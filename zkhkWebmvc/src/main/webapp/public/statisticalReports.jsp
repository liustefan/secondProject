<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
   	<meta charset="utf-8">
   	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>统计报表左侧iframe模块</title>
    <link rel="stylesheet" href="<%=path %>/css/general.css">
    <link rel="stylesheet" href="<%=path %>/public/css/left.css">

    <script src="<%=path %>/js/jquery.min.js"></script>
    <script src="<%=path %>/public/js/left.js"></script>
</head>

<body class="over-hidden">
	 <div id="left">
		<dl class="menu-list" id="dl">
			<a href="../statistic/exProcSelectMeasurementStatics" target="showRight">
				<dd class="h_nav_over">
					测量状况统计 <span class="dd_span">></span>
				</dd>
			</a>
			<c:if test='${userInfo.roleid == "5" || userInfo.roleid == "6" || userInfo.roleid == "1"}'>  
			<a href="../statistic/populationReport.jsp" target="showRight">
				<dd>
					人口基本状况 <span class="dd_span">></span>
				</dd>
			</a>
			<a href="../statistic/elderlyHealthManagement.jsp" target="showRight">
				<dd>
					老年人接受健康管理状况 <span class="dd_span">></span>
				</dd>
			</a>
			<a href="../statistic/checkUpReport.jsp" target="showRight">
				<dd>
					老年人年度体检状况 <span class="dd_span">></span>
				</dd>
			</a>
			<a href="../statistic/hypertensionFollowUpReport.jsp" target="showRight">
				<dd>
					高血压随访 <span class="dd_span">></span>
				</dd>
			</a>
			<a href="../statistic/glycuresisFollowUpReport.jsp" target="showRight">
				<dd>
					糖尿病随访 <span class="dd_span">></span>
				</dd>
			</a>
			</c:if> 
		</dl>
	</div>
</body>
</html>