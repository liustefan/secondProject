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
    <base href="<%=basePath%>">
    <title>重置金钥匙账户密码</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>

	<script type="text/javascript">
		  $(function(){
			  $(".resetPwd").click(function(){
				  var $this = this;
				  if(!$this.disabled&&confirm('确认重置密码？')){
					  $this.disabled=true;
					  $.ajax({
						   type: "GET",
						   url: $this.getAttribute("data-href"),
						   success: function(msg){
							 alert(msg.content);
							 $this.disabled = false;
						   }
						});
				  }
			  });
		  });
	</script>
</head>
<body>
<div class="content">
	<c:choose>
		<c:when test="${msg != null && msg != '' }">
			<font color="red"><b>${msg }</b></font>
		</c:when>
		<c:otherwise>
		<div class="content-title">重置金钥匙账户密码</div>
		<div class="fr">
			<a class="btn-normal resetPwd" data-href="<%=path %>/doctor/reset?docid=${doctor.docid }&roleid=${doctor.roleid }">重置密码</a>
		</div>
		</c:otherwise>
	</c:choose>
</div>  
</body>
</html>
