<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>待审核组合答卷列表</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<style>
		.page-box {
			margin: 20px 0 0 !important;
		}
	</style>
	<script type="text/javascript">
		$(function(){
			//禁用分页回车键
			$("#toPage").keydown(function(e){
				if(e.keyCode==13) {
					return false;
				}
			}); 
		});
	</script>
</head>
<body>
<div class="content">
	<c:if test="${param.home ne 1}"><div class="content-title">待审核组合答卷列表</div></c:if>
  	<div class="table-box">
   		<form action="list" method="post">
		    <c:if test="${page.totalCount == 0}">
    			<div class="empty-info">暂时没有审核数据</div>
			</c:if>
			<c:if test="${page.totalCount > 0}">
		   		<table class="table-content">
		   			<thead class="table-title">
						<tr>
							<th width="15%">答卷编号</th>
							<th width="30%">问卷名称</th>
							<th width="15%">发放日期</th>
							<th>会员名称/作答日期</th>
							<th width="15%">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${page.result}" var="oasr">
							<tr>
								<td>${oasr.serialNumber}</td>
								<td><c:out value="${oasr.ocqt.combQustName}" escapeXml="true"/></td>
								<td><fmt:formatDate value="${oasr.ocam.publisherTime}" type="both" dateStyle="default" timeStyle="default"/></td>
								<td>${oasr.member.memname}/<fmt:formatDate value="${oasr.ocam.answerTime}" type="both" dateStyle="default" timeStyle="default"/></td>
								<td id="table_content_title_td">
									<a href="toAudit?serialNumber=${oasr.serialNumber}&combAnsId=${oasr.reportNo}">审核</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="page-box">
					<jsp:include  page="/public/pageFoot.jsp"/>
				</div>
			</c:if>
		</form>
	</div>
</div> 
</body>
</html>