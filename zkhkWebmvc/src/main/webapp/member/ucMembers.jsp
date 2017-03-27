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
	<title>选择会员(会员转移)</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">

	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/ucMembers.js"></script>
	<style type="text/css">
		.content {
			margin-top: 1%;
		}
		
		.normal-width {
			width: 100px;
		}
		
		.lg-width {
			width: 145px;
		}
	</style>
</head>
<body>
<div class="content">
    <form action="<%=path %>/member/ucMembers" method="POST" id="formId">
		<div class="search-box-wrapper">
			<ul class="search-wrapper">
				<li>
					<label>会员姓名：</label>
	                <input type="text" class="normal-width" name="memname" value="${omem.memname }">
				</li>
				<li>
					<label>手机号码：</label>
	                <input type="text" class="normal-width" name="tel" value="${omem.tel }" maxlength='11' onchange="isPhone(this);">
				</li>
				<li>
					<label>身份证号：</label>
	                <input type="text" class="lg-width" id="idCard" name="idcard" value="${omem.idcard }" maxlength='18' onchange="isIDCard(this);">
				</li>
				<li>
					<button type="button" class="btn-inquiry ico-search" onclick="javascript:$('form')[0].submit();">查询</button>
				</li>
			</ul>
		</div>
		<div class="table-box">
			<table class="table-content">
				<thead class="table-title">
					<tr>
						<th>会员姓名</th>
						<th>性别</th>
						<th>手机号码</th>
						<th>身份证号</th>
						<th>运行环境</th>
						<th>选择</th>
					</tr>
				</thead>
				<tbody>
				<c:if test="${not empty msg}">
				<tr><td colspan="6">${msg }</td></tr>
				</c:if>
				<c:if test="${empty msg}">
				<c:forEach items="${memberList }" var="mem">
				<tr>
					<td>${mem.memberName }</td>
					<td>${mem.gender }</td>
					<td>${mem.tel }</td>
					<td>${mem.idcard }</td>
					<td>${mem.serverName }</td>
					<td><a href="javascript: void(0);" onclick='javascript:parent.setMemberInfo(${mem})'>选择</a></td>
				</tr>
				</c:forEach>
				</c:if>
				</tbody>
			</table>
		</div>
	</form>
</div>
</body>
</html>
