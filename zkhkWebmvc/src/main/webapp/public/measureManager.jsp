<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    <title>测量管理左侧iframe模块</title>
    <link rel="stylesheet" href="<%=path %>/css/general.css">
    <link rel="stylesheet" href="<%=path %>/public/css/left.css">

    <script src="<%=path %>/js/jquery-1.9.1.min.js"></script>
    <script src="<%=path %>/public/js/left.js"></script>
</head>
<body class="over-hidden">
	<div id="left">
	    <dl class="menu-list" id="dl">
	        <!-- 测量管理  -->
	        <a href="../bloodPressure/queryBloodPressure?wheAbnTag=1&docid=${userInfo.id}" target="showRight"><dd class="h_nav_over">血压<span class="dd_span">></span></dd></a>
			<a href="../bloodSugar/queryBloodSugar?&wheAbnTag=1&docid=${user_id }" target="showRight"><dd>血糖<span class="dd_span">></span></dd></a>
			<a href="../electrocardioPulse/queryElectrocardioPulse?wheAbnTag=1&docid=${user_id }" target="showRight"><dd>三合一心血管<span class="dd_span">></span></dd></a>
			<a href="../electrocardio/queryElectrocardio?wheAbnTag=1&docid=${user_id }" target="showRight"><dd>动态心电<span class="dd_span">></span></dd></a>
	    </dl>
	</div>
</body>
</html>