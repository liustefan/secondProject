<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>选择医生</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">

	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<style>
		.content {
			margin-top: 1%;
		}
	</style>
	<script type="text/javascript">
	$(document).ready(function(){
		if($("#doctorNums").val() == '' || $("#doctorNums").val() == 0) {
			parent.$("#outDrID").val('');
			parent.$("#outDrName").val("无");
		}
	});
	</script>
</head>
<body>
<div class="content">
<input type="hidden" value="${page.totalCount }" id="doctorNums"/>
    <form action="<%=path %>/member/memberDoctors" method="POST" id="">
    <input type="hidden" name="memberId" value="${memberId }"/>
		<div class="table-box">
			<table class="table-content">
				<thead class="table-title">
					<tr>
						<th>姓名</th>
						<th>性别</th>
						<th>手机号</th>
						<th>选择</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${page.result}" var="item">
				 <tr>
					<td>${item.docname}</td>
					<td>
					<c:if test="${item.gender eq 'M'}">男</c:if>
					<c:if test="${item.gender eq 'F'}">女</c:if>
					</td>
					<td>${item.tel}</td>
					<td><a href="javascript: void(0);" onclick="javascript:parent.setConfirmDoc(${item.docid}, '${item.docname}')">选择</a></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="page-box">
			<jsp:include page="/public/pageFoot.jsp"></jsp:include>
		</div>
	</form>
</div>
</body>
</html>
