<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>编辑标签分类</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<style>
		.content-box {
			padding: 35px 10px 0 10px;
		}
		
		.content-box label {
			width: 120px;
			font-size: 14px;
			text-align: right;
		}
		
		.content-slice {
			margin-bottom: 25px;
		}
		
		.text-top {
	        vertical-align: text-top;
	    } 
	    
	    .mar-label {
	    	margin-left: 125px;
	    	padding-top: 3px;
	    }
	</style>
</head>
<body>
	<form class="" id="" method="post" action="">
		<div class="content-box">
			<div class="content-table">
				<div class="content-slice">
					<label><span class="red">*</span>标签分类名称：</label>
					<input type="text" name="" maxlength="10">
					<span class="red">必填</span>
				</div>
				<div class="content-slice">
					<label>描述：</label>
					<textarea class="text-top" name="" cols="40" rows="6" maxlength="100"></textarea>
					<p class="red mar-label">不允许添加特殊字符</p>
				</div>
			</div>
		</div>
		<div class="page-box align-center">
			<button type="button" id="" class="btn-inquiry">保存</button>
			<button type="button" id="" class="btn-cancel">取消</button>
		</div>
	</form>
</body>
</html>
