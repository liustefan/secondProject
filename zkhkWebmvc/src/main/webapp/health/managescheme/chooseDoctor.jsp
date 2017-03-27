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
	<title>选择医生</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
</head>
<body>
<div class="content">
	<form id="form1" action="doctors">
	<input type="hidden" name="memberId" value="${memberId}"/>
		<div class="table-box">
			<table class="table-content">
				<thead class="table-title">
					<tr>
						<th width="5%">姓名</th>
						<th width="9%">性别</th>
						<th width="9%">手机号</th>
						<th width="9%">选择</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${page.result}" var="item">
						<tr>
							<td>${item.docname}</td>
							<td>${item.gender == 'M' ? '男' : '女'}</td>
							<td>${item.tel}</td>
							<td><a href="javascript:parent.setExeDoc(${item.docid}, '${item.docname}')">选择</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="page-box">
				<jsp:include page="/public/pageFoot.jsp"/>
			</div>
		</div>
	</form>
</div>
</body>
</html>
