<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>模板/报告管理左侧iframe模块</title>
	
    <link rel="stylesheet" type="text/css" href="<%=path %>/css/general.css">
    <link rel="stylesheet" type="text/css" href="<%=path %>/public/css/left.css">
    
	<script src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script src="<%=path %>/public/js/left.js"></script>
</head>

<body class="over-hidden">
	<div id="left">		
		<dl class="menu-list" id="dl">
			<c:if test="${userInfo.roleid == 1 }">
				<!-- <a href="../template/getSingleTemplateList" target="showRight"><dd class="h_nav_over">单项测量审核模板<span class="dd_span">></span></dd></a>
				<a href="../template/getSumTemplateList" target="showRight"><dd>汇总测量审核模板<span class="dd_span">></span></dd></a> -->
				<a href="../template/toOpintionTemplatPage?type=1" target="showRight"><dd class="h_nav_over">审核意见模板<span class="dd_span">></span></dd></a>
				<a href="../health/templet/list" target="showRight"><dd>管理方案模板<span class="dd_span">></span></dd></a>
			</c:if>
			<c:if test="${userInfo.roleid != 1 }">
				<a href="../singleReport/showSingAduitList" target="showRight"><dd class="h_nav_over">单项测量待审<span class="dd_span">></span></dd></a>
				<a href="../summaryReport/showSumAduitList" target="showRight"><dd>汇总测量待审<span class="dd_span">></span></dd></a>
				<a href="../singleReport/showSingleReportList" target="showRight"><dd>测量数据已审<span class="dd_span">></span></dd></a>
			</c:if>
		</dl>
	</div>
</body>
</html>