<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE HTML>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>新增/修改会员分组</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css"/>

	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script type="text/javascript" src="<%=path %>/js/memberGroup.js"></script>
	<style>
		.content-slice {
			margin: 25px 0;
		}
		.content-slice>label:first-child {
			font-size: 14px;
			height: 20px;
			line-height: 20px;
			width: 130px;
			text-align: right;
		}
		.v-top {
			vertical-align: top;
		}
	</style>
</head>
<body>
<form class="cmxform" id="form3" method="post" action="">
	<input type="hidden" name="memgrpid" value="${pojo.memgrpid}"/>
	<input type="hidden" name="famemid" value="${parent.memgrpid}"/>
	<input type="hidden" name="path" value="${pojo.path}"/>
	<div class="content">
		<div class="content-main">
			<div class="content-slice">
				<label>所属组织：</label>
				<span>${userInfo.orgName}</span>
				<input type="hidden" name="orgid" value="${pojo.orgid }"/>
			</div>
			<div class="content-slice">
				<label>上级分组：</label>
				<span>${parent.memgrpname}</span>
			</div>
			<div class="content-slice">
				<label><span class="red">*</span>分组名称：</label>
				<input type="text" class="" name="memgrpname" value="${pojo.memgrpname}">
			</div>
			<div class="content-slice">
				<label><span class="red">*</span>排序号：</label>
				<input type="text" class="margin-lt" name="order" value="${detaultOrder}${pojo.order}">
			</div>
			<div class="content-slice">
				<label class="v-top">分组说明：</label>
				<textarea name="memgrpdesc" rows="4" cols="35">${pojo.memgrpdesc}</textarea>
				<div style="padding-left: 130px; height: 20px;"><label for="memgrpdesc" class="error"></label></div>
			</div>
		</div>
		<div class="page-box align-center">
			<button type="button" id="btnSubmit" class="btn-inquiry">保存</button>
			<button type="button" onclick="closeWd();" class="btn-cancel">取消</button>
		</div>
	</div>
</form>
</body>
</html>