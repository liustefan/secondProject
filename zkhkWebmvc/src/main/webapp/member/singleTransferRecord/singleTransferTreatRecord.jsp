<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>转诊记录(单一会员)</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/js/jquery-ui/themes/overcast/jquery-ui.min.css">
	<link rel="stylesheet" href="<%=path %>/plugins/font-awesome/css/font-awesome.min.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-ui/jquery-ui.js"></script>
	<script type="text/javascript" src="<%=path %>/js/dataPacker.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script type="text/javascript">
		function del(url, memName){
			layer.confirm('删除后将不能恢复，您确定要删除会员'+memName+'的转诊信息吗？', {
				title : '提示信息',
				skin : 'skin1',
				shade : 0,
				btn : [ '确定', '取消' ]
			}, function(index) {
				$.ajax({
					url: url,
				    type: "POST",
					success: function(data) {
								alert(data.content);
				 		     	if(data.status) {
				 		     		location.href=window.location.href;
				 		     	}
							}
				});
				layer.closeAll();
			});
		}
		
	</script>
</head>

<body>
<div class="content">
	<div class="content-title">
   		转诊记录
	</div>
    <form action="<%=path %>/singleTransferTreatment/getTransferTreatRecord" method="POST" id="pojo">
    <input type="hidden" name="memberid" value="${pojo.memberid}">
		<div class="search-box-wrapper">
			<ul class="search-wrapper">
				<li>
					<label>状态：</label>
	                <select name="treatstatus">
						<option value="">全部</option>
						<c:choose>
							<c:when test="${pojo.treatstatus eq '1'}">
								<option value="1" selected>转诊申请</option>
							</c:when>
							<c:otherwise>
								<option value="1">转诊申请</option>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${pojo.treatstatus eq '2'}">
								<option value="2" selected>取消转诊</option>
							</c:when>
							<c:otherwise>
								<option value="2">取消转诊</option>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${pojo.treatstatus eq '3'}">
								<option value="3" selected>已转诊</option>
							</c:when>
							<c:otherwise>
								<option value="3">已转诊</option>
							</c:otherwise>
						</c:choose>
					</select>
				</li>
				<li>
					<label>更新日期：</label> 
					<input class="info-date" id="startDate" type="text" name="startUpdatetime"  value='<fm:formatDate value="${pojo.startUpdatetime }" pattern="yyyy-MM-dd"/>' readonly="readonly" /> 
					<span class="mar-left">至</span> 
					<input class="info-date" id="endDate" type="text" name="endUpdatetime" value='<fm:formatDate value="${pojo.endUpdatetime}" pattern="yyyy-MM-dd"/>' readonly="readonly" />
				</li>
				<li>
					<button type="submit" id="query" class="btn-inquiry ico-search">查询</button>
					<c:choose>
						<c:when test="${isMy || empty pojo.memberid}">
							<button type="button" class="btn-inquiry ico-add" onclick="window.location.href='editTransferTreat?memberid=${pojo.memberid}'">新增</button>
						</c:when>
						<c:otherwise>
							<button type="button" class="btn-cancel">新增</button>
						</c:otherwise>
					</c:choose>
				</li>
			</ul>
		</div>
		<div class="table-box">
		<c:if test="${page.totalCount == 0}">
				<div class="empty-info border-1-solid">目前没有转诊信息</div>
			</c:if>
			<c:if test="${page.totalCount > 0}">
			<table class="table-content">
				<thead class="table-title">
					<tr>
						<th width="15%">转诊机构和科室</th>
						<th>转诊原因</th>
						<th width="15%">转诊结果</th>
						<th width="8%">状态</th>
						<th width="10%">创建人</th>
						<th width="10%">更新人</th>
						<th width="10%">更新日期</th>
						<th width="8%">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${page.result}" varStatus="statu" var="item">
						<tr>
							<td>${item.organddept }</td>
							<td>${item.reason }</td>
							<td>${item.result }</td>
							
							<c:if test="${item.treatstatus==1}"><td>转诊申请</td></c:if>
							<c:if test="${item.treatstatus==2}"><td>取消转诊</td></c:if>
							<c:if test="${item.treatstatus==3}"><td>已转诊</td></c:if>
							
							<td>${item.createDrName}</td>
							<td>${item.updateDrName}</td>
							<td><fm:formatDate value="${item.updatetime}" pattern="yyyy-MM-dd"/></td>
							<td>
							<c:choose>
								<c:when test="${isMy || empty pojo.memberid}">
								<a href="<%=path %>/singleTransferTreatment/editTransferTreat?id=${item.ttreatmentid}" target="showRight">修改</a>
								</c:when>
							<c:otherwise>
								<span>修改</span>
							</c:otherwise>
							</c:choose>
							
							<c:choose>
								<c:when test="${isMy || empty pojo.memberid}">
								<a onclick="del('<%=path %>/singleTransferTreatment/${item.ttreatmentid}/deleteTransferTreat','${item.member.memname}');" href="javascript:void(0);" class="mar-left">删除</a>
								</c:when>
							<c:otherwise>
								<span class="mar-left">删除</span>
							</c:otherwise>
							</c:choose>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			</c:if>
		</div>
		<div class="page-box">
			<jsp:include page="/public/pageFoot.jsp"></jsp:include>
		</div>
	</form>
</div>
</body>
</html>