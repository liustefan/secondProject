<%@page import="com.bithealth.sdk.common.utils.TimeUtil"%>
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
	<title>选择会员</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/js/jquery-ui/themes/overcast/jquery-ui.min.css">
	<link rel="stylesheet" href="<%=path %>/css/selectMember.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-ui/jquery-ui.js"></script>
	<script type="text/javascript" src="<%=path %>/js/dataPacker.js"></script>
	<script type="text/javascript" src="<%=path %>/js/chooseMember.js"></script>
</head>
<body>
	<form id="form1" action="members" method="post">
		<div class="search-wrapper clearfix">
			<div class="fl">
				<p>
					<label>
						<span>会员姓名：</span>
						<input type="text" class="info-tel" name="memName" value="${pojo.memName}">
					</label>
					<label>
						<span>身份证号：</span>
						<input type="text" class="info-idCard" name="idcard" value="${pojo.idcard}">
					</label>
				</p>
				<p>
					<label>
						<span>手机号码：</span>
						<input type="text" class="info-tel" name="tel" value="${pojo.tel}">
					</label>
					<label>
						<span>注册日期：</span>
						<input class="info-date" id="startDate" type="text" name="creTimeStart" value="${pojo.creTimeStart}"
							readonly="readonly">
					</label>
					<label class="mg-0">
						<span class="mr-span">至</span>
						<input class="info-date" id="endDate" type="text" name="creTimeEnd" value="${pojo.creTimeEnd}" readonly="readonly">
					</label> 
				</p>
			</div>
			<div class="btn-center">
				<button type="button" onclick="search(1)" class="btn-inquiry ico-search">查询</button>
			</div>
		</div>
		<div>
			<table class="table-content">
				<thead class="table-title">
					<tr>
						<th width="5%">选择</th>
						<th width="5%">姓名</th>
						<th width="9%">手机号码</th>
						<th width="9%">身份证号</th>
						<th width="8%">注册日期</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${page.result}" var="item">
						<tr>
							<td><input type="radio" name="doctor" data-memname ="<c:out value="${item.memName}" escapeXml='true'/>" data-unique ="${item.uniqueId}" data-gender="${item.gender}" data-birthday="${item.birthDay}"  value="${item.memberId}"></td>
							<td>${item.memName}</td>
							<td>${item.tel}</td>
							<td>${item.idcard}</td>
							<td><fmt:formatDate value='${item.createTime}' pattern="yyyy-MM-dd"/></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="page-box">
				<jsp:include  page="/public/pageFoot.jsp"/>
			</div>
		</div>
		<div class="page-box align-center">
			<input type="button" class="btn-inquiry" onclick="choose();" value="确定">
			<input type="button" class="btn-cancel" onclick="parent.layer.close(index);" value="取消">
		</div>
	</form>
</body>
</html>