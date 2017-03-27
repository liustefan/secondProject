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
<title>编辑住院史</title>

<link rel="stylesheet" href="<%=path %>/css/general.css">
<link rel="stylesheet" href="<%=path %>/js/jquery-ui/themes/overcast/jquery-ui.min.css">
<link rel="stylesheet" href="<%=path %>/plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="<%=path %>/css/leadInformation.css">

<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/jquery-ui/jquery-ui.js"></script>
<script type="text/javascript" src="<%=path %>/js/dataPacker.js"></script>
<script type="text/javascript" src="<%=path %>/js/editHOIV.js"></script>
</head>

<body>
	<div class="layer-box">
		<form id="form-hospitalization" action="">
			<input type="hidden" name="logID">
			<input type="hidden" name="index">
			<div class="input-block">
				<p>
					<span class="content-left">入院日期：</span>
					<input class="info-date date-width1" id="startDate" type="text" name="admissionDate" readonly="readonly">
					<span class="red">*</span>
				</p>
			</div>
			<div class="input-block">
				<p>
					<span class="content-left">出院日期：</span>
					<input class="info-date date-width1" id="endDate" type="text" name="dischargeDate" readonly="readonly">
				</p>
			</div>
			<div class="input-block">
				<p>
					<span class="content-left">医疗机构名称：</span>
					<input maxlength="35" type="text" class="info-organization" name="organization">
				</p>
			</div>
			<div class="input-block">
				<p>
					<span class="content-left">病案号：</span>
					<input maxlength="10" type="text" class="info-number" name="fileNumber">
				</p>
			</div>
			<div class="textarea-block">
				<p>
					<span class="content-left">住院原因：</span>
					<textarea  maxlength="50" class="size" name="reason"></textarea>
				</p> 
			</div>
			<div class="btn-box align-center">
				<input type="button" id="hospitalization" class="btn-inquiry mg-lf-50" value="确定">
				<input type="button" class="btn-cancel mg-lf-50" onclick="parent.layer.closeAll('iframe');" value="取消">
			</div>
		</form>
	</div>
</body>
</html>
