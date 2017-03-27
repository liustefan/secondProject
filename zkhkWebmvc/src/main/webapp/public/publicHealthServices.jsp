<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>健康管理左侧iframe模块</title>

    <link rel="stylesheet" type="text/css" href="<%=path %>/css/general.css">
    <link rel="stylesheet" type="text/css" href="<%=path %>/public/css/left.css">
    
	<script src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script src="<%=path %>/public/js/left.js"></script>
	<script>
		$(function(){
			$("#mode").addClass("margin-91");
			$("#mode dl").show();    //如果元素为隐藏,则将它显现
			$("#mode .dd_span").html("v");
		});
	</script>
</head>
<body class="over-hidden">
	<div id="left">
		<dl class="menu-list" id="dl">
			<dd class="seat" id="mode">
				<p class="nav-parent">模板管理<span class="dd_span">></span></p>
				<dl class="nav-child">
					<c:if test="${userInfo.roleid==2 || userInfo.roleid==3 || userInfo.roleid==4 || userInfo.roleid==7 }">
					<a href="../health/listHealth" target="showRight"><dd class="h_nav_over">健教库管理</dd></a>
					</c:if>
					<a href="../health/templet/list" target="showRight"><dd>管理方案模板</dd></a>
				</dl>
			</dd>
			<c:if test="${userInfo.roleid==2 || userInfo.roleid==3 || userInfo.roleid==4 || userInfo.roleid==7 }">
				<dd class="seat1">
					<p class="nav-parent">管理方案<span class="dd_span">></span></p>
					<dl class="nav-child">
						<a href="../health/managescheme/listPerson" target="showRight"><dd>个人管理方案</dd></a>
						<a href="../health/managescheme/listGroup" target="showRight"><dd>群体管理方案</dd></a>
					</dl>
				</dd>
				
				<a href="../health/manageschemeTask/list" target="showRight"><dd>健康管理任务<span class="dd_span">></span></dd></a>
				
				<dd id="pubServices">
					<p class="nav-parent">公卫服务<span class="dd_span">></span></p>
					<dl class="nav-child">
						<a href="../inspect/physical/list" target="showRight"><dd>健康体检</dd></a>
						<a href="../inspect/hypertension/plist" target="showRight"><dd>高血压随访</dd></a>
						<a href="../inspect/diabetes/plist" target="showRight"><dd>Ⅱ型糖尿病随访</dd></a>
					</dl>
				</dd>
				
				<a href="<%=path %>/transferTreatment/getTransferTreatRecord" target="showRight"><dd>转诊记录<span class="dd_span">></span></dd></a>
			</c:if>
		</dl> 
	</div>
</body>
</html>