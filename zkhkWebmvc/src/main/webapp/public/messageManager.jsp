<%@ page contentType="text/html; charset=utf-8" language="java" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>消息管理左侧iframe模块</title>

    <link rel="stylesheet" type="text/css" href="<%=path %>/css/general.css">
    <link rel="stylesheet" type="text/css" href="<%=path %>/public/css/left.css">
    
	<script src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script src="<%=path %>/public/js/left.js"></script>
	<script>
		$(function(){
			$("#listTag").addClass("margin-91");
			$("#listTag dl").show();    //如果元素为隐藏,则将它显现
			$("#listTag .dd_span").html("v");
		});
	</script>
</head>
<body class="over-hidden">
	<div id="left">
		<dl class="menu-list" id="dl">
			<c:if test="${userInfo.roleid ==7}">
				<dd class="seat" id="listTag">
					<p class="nav-parent">健康资讯<span class="dd_span">></span></p>
					<dl class="nav-child">
						<a href="../msgCenter/listTitleTag" target="showRight"><dd class="h_nav_over">标签管理</dd></a>
						<a href="../msgCenter/listNewsInfo" target="showRight"><dd>健康资讯</dd></a>
					</dl>
				</dd>
				<a href="../msgCenter/listAdvert" target="showRight"><dd>广告<span class="dd_span">></span></dd></a>
				<dd class="seat1" id="listTag1">
					<p class="nav-parent">互动交流<span class="dd_span">></span></p>
					<dl class="nav-child">
						<a href="../message/memberList" target="showRight"><dd>温馨提示</dd></a>
						<a href="../communicate/listCommunicate" target="showRight"><dd>医患沟通</dd></a>
					</dl>
				</dd>
			</c:if>
			<c:if test="${userInfo.roleid != 7 && userInfo.roleid != 6 && userInfo.roleid != 5}" >
				<a href="../communicate/listCommunicate" target="showRight"><dd class="h_nav_over">医患沟通<span class="dd_span">></span></dd></a>
			</c:if>
		</dl> 
	</div>
</body>
</html>