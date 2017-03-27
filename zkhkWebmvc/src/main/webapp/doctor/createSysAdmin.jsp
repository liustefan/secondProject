<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>创建系统管理员</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/css/common.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/common.js"></script>
</head>
<body>
<div class="content">
	<div class="content-title">
		系统管理员列表 --- 添加
	</div>
	<div class="table-box">
		<table id="table_new">
			<tr class="table_right">
				<td></td>
				<td class="table_left"><label id="label_prompt"></label></td>
			</tr>
			<c:forEach items="${error }" var="item">
			${item }
			</c:forEach>
			<form action="<%=path %>/doctor/createSysAdmin" method="post" id="form1">
				<tr>
					<td class="table_right">姓名：</td>
					<td class="table_left">
					    <input type="text" name="docname" value="${doctor.docname }" title="账号" id="name">
					    <span class="red">*</span>
					</td>
				</tr>
				<tr>
					<td class="table_right">邮箱地址：</td>
					<td class="table_left">
					    <input type="text" name="email" value="${doctor.email }" title="Email" onBlur="isEmail(this);" id="email">
					    <span class="red">*</span>
					</td>
				</tr>
				<tr>
					<td class="table_right">手机号码：</td>
					<td class="table_left">
					    <input type="text" name="tel" value="${doctor.tel }" title="手机号码" onchange="if(isNaN(this.value)){alert('请填写数字');this.value='';}" onBlur="isPhone(this);" id="phone">
						<span class="red">*</span>
					</td>
				</tr>
				<tr>
					<td></td>
					<td align="left">
					   <input type="button" value="确定" class="btn-inquiry" id="addSubmint" onclick="submitFm();"> 
					   <input type="reset" value="重置" class="btn-cancel">
					</td>
				</tr>
			</form>
			<tr>
				<td></td>
				<td></td>
			</tr>
		</table>
	</div>
</div>
</body>
<script type="text/javascript">
	function submitFm() {
		if (isEmail($("#email")) && isPhone($("#phone"))) {
			$("#addSubmint").prop("disabled", true);
			$.ajax({
				url:$("#form1").attr("action"),
				data:$("#form1").serialize(),
				dataType:"json",
				type:"POST",
				success:function(data) {
					alert(data.content);
		  		     	if(data.status) {
		  		     			window.location.href = "<%=path %>/doctor/listSysAdmin";
		    		     	}else{
		    		     		$("#addSubmint").prop("disabled", false);
		    		     	}
						}
					});
		};
	}
</script>
</html>
