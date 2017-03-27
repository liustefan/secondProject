<%@ page contentType="text/html; charset=utf-8" language="java" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE HTML>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>设置审核权限</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/reviseAuthority.js"></script>
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
		.margin-small {
			width: 150PX;
		}
	</style>
</head>
<body>
<input type="hidden" id="funId" value="${pojo.funid}"/>
<input type="hidden" id="optId" value="${pojo.optid}"/>
<form class="cmxform" id="form-examine" method="post" action="">
	<input type="hidden" name="odgpid" value="${pojo.odgpid}"/>
	<div class="content">
		<div class="content-main">
			<div class="content-slice">
				<label><span class="red">*</span>功能代码：</label>
                <select class="margin-small" name="funid" value="{}" id="sFun">
                    <option value="">请选择</option>
                    <option value="1">单项测量</option>
                    <option value="2">汇总测量</option>
                </select>
			</div>
			<div class="content-slice">
				<label><span class="red">*</span>选项代码：</label>
                <select class="margin-small" name="optid" id="sOpt">
                    <option value="">请选择</option>
                </select>
			</div>
			<div class="content-slice">
				<label>审核级数：</label>
				<span class="chLevel" id="chLevel">${pojo.chlevel}</span>
				<input type="hidden" id="chLevelHidden" name="chlevel" class="chLevelHidden" value="${pojo.chlevel}">
			</div>
		</div>
		<div class="page-box align-center">
			<button type="button" id="submit" class="btn-inquiry">确认</button></span>
			<button type="button" id="btnReset" class="btn-cancel">清空</button></span>
		</div>
	</div>
</form>
</body>
</html>