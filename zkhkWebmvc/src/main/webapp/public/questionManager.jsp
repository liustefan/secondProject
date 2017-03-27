<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
   	<meta charset="utf-8">
   	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>问卷管理左侧iframe模块</title>

    <link rel="stylesheet" href="<%=path %>/css/general.css">
    <link rel="stylesheet" href="<%=path %>/public/css/left.css">

    <script src="<%=path %>/js/jquery-1.9.1.min.js"></script>
    <script src="<%=path %>/public/js/left.js"></script>
    <script>
	    $(function(){
			$("#question").addClass("margin-46");
			$("#question dl").show();    //如果元素为隐藏,则将它显现
			$("#question .dd_span").html("v");
		});
    </script>
</head>
<body class="over-hidden">
	<div id="left">
		<dl class="menu-list" id="dl">
			<c:if test='${userInfo.roleid eq "6"}'>
				<dd id="question">
					<p class="nav-parent">问卷管理<span class="dd_span">></span></p>
					<dl class="nav-child">
						<a href="../question/singleQuestion/list" target="showRight"><dd class="h_nav_over">单份问卷列表</dd></a>
					</dl>
				</dd>
				<a href="../health/templet/list" target="showRight"><dd>管理方案模板<span class="dd_span">></span></dd></a>
			</c:if>
		
			<c:if test='${userInfo.roleid ne "6"}'>
				<a href="../question/singleQuestion/list" target="showRight"><dd class="h_nav_over">单份问卷列表<span class="dd_span">></span></dd></a>
				
				<a href="../question/singleAnswer/list" target="showRight"><dd>单份答卷列表<span class="dd_span">></span></dd></a>
				
				<a href="../question/comQuestion/list" target="showRight"><dd>组合问卷列表<span class="dd_span">></span></dd></a>
				
				<a href="../question/comAnswer/list" target="showRight"><dd>组合答卷列表<span class="dd_span">></span></dd></a>
				
				<a href="../question/singleAudit/list" target="showRight"><dd>待审核单份答卷列表<span class="dd_span">></span></dd></a>
				
				<a href="../question/comAudit/list" target="showRight"><dd>待审核组合答卷列表<span class="dd_span">></span></dd></a>
			</c:if>
		</dl>
	</div>
</body>
</html>