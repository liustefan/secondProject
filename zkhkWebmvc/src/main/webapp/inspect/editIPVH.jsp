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
<title>编辑非免疫规划预防接种史</title>

<link rel="stylesheet" href="<%=path %>/css/general.css">
<link rel="stylesheet" href="<%=path %>/js/jquery-ui/themes/overcast/jquery-ui.min.css">
<link rel="stylesheet" href="<%=path %>/plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="<%=path %>/css/leadInformation.css">

<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/jquery-ui/jquery-ui.js"></script>
<script type="text/javascript" src="<%=path %>/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/editIPVH.js"></script>
<script type="text/javascript" src="<%=path %>/js/dataPacker.js"></script>
</head>
<body>
	<div class="layer-box">
		<form id="form-vaccine" action="">
			<input type="hidden" name="logID">
			<input type="hidden" name="index">
			<div class="input-block">
				<p>
					<span class="content-left">疫苗名称：</span>
					<input maxlength="50"  type="text" class="" name="vaccineName">
					<i class="red">*</i>
				</p>
			</div>
			<div class="input-block">
				<p>
					<span class="content-left">接种日期：</span>
					<input class="info-date date-width1" id="startDate" type="text" name="vaccineDate" readonly="readonly">
				</p>
			</div>
			<div class="input-block">
				<p>
					<span class="content-left">接种机构：</span>
					<input maxlength="35" type="text" class="" name="vaccineOrganization">
				</p> 
			</div>
			<div class="btn-box align-center">
				<input type="button" id="vaccineDetail" class="btn-inquiry mg-lf-50" value="确定">
				<input type="button" class="btn-cancel mg-lf-50" onclick="parent.layer.closeAll('iframe');" value="取消">
			</div>
		</form>
	</div>
</body>
</html>
