<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>审核意见模板</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/js/skins/blue.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.artDialog.js"></script>
</head>
<body>
<div class="content">
	<div class="content-title clearfix">
		审核意见模板
	</div>
	<div class="clearfix" style="margin-bottom: 8px;"><button type="button" class="btn-inquiry fr" onclick="window.location.href='<%=path %>/template/toAddTemplatePage' ">新增模板</button></div>
	<c:if test="${page.totalCount == 0 }">
		<div class="empty-info border-1-solid">暂无审核意见模板</div>
	</c:if>
	<c:if test="${page.totalCount != 0 }">
		<div class="table-box">
			 <table class="table-content">
			    <thead class="table-title">
					<tr>
						<th width="5%">序号</th>
						<th width="30%">模板名称</th>
						<th width="20%">模板类型</th>
						<th width="20%">创建时间</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${page.result}" varStatus="status">
						<tr>
						   <td>${(page.pageSize)*(page.pageNo)-((page.pageSize))+(status.index+1) }</td>
						   <td>${item.name }</td>
						   <td>
						   <c:if test="${ item.type==1}">
						  		 报告审核意见
						   </c:if>
						  <c:if test="${ item.type!=1}">
						  		答卷审核意见
						   </c:if>
						   </td>
						   <td>${item.createTime }</td>
						   <td>
						      <a href="<%=request.getContextPath() %>/template/getOpinionTemplate?id=${item.id}">查看</a>&nbsp;
						      <a href="<%=request.getContextPath() %>/template/toEditOpinionTemplatePage?id=${item.id}">修改</a>&nbsp;
						      <a onclick="return confirm('是否删除？');"  href="<%=request.getContextPath() %>/template/deleteOpinionTemplate?id=${item.id}">删除</a>
						   </td>
						</tr>
					</c:forEach>  
				</tbody>
			</table>
			<div class="page-box">
				<jsp:include  page="/public/pageFoot.jsp"/>
			</div>
		</div>
	 </c:if>
</div>
</body>
</html>