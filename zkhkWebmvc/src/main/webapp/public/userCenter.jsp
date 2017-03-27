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
   	<meta charset="utf-8">
   	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>用户管理左侧iframe模块</title>
    <link rel="stylesheet" href="<%=path %>/css/general.css">
    <link rel="stylesheet" href="<%=path %>/public/css/left.css">

    <script src="<%=path %>/js/jquery-1.9.1.min.js"></script>
    <script src="<%=path %>/public/js/left.js"></script>
</head>

<body class="over-hidden">
	<div id="left">
		<dl class="menu-list" id="dl">
			<!-- 金钥匙账户 -->
			<c:if test='${userInfo.roleid == 5 }'>			
				<a href="<%=path %>/doctor/listSysAdmin" target="showRight"><dd id="dd_top_2" class="h_nav_over">系统管理员列表<span class="dd_span">></span></dd></a>
			</c:if>
			
			<!-- 系统管理员账户 -->
			<c:if test="${userInfo.roleid == 6 }">
			<a href="<%=path %>/doctor/listCommonAdmin" target="showRight"><dd id="dd_top_2" class="h_nav_over">管理员列表<span class="dd_span">></span></dd></a>			
				<a href="<%=path %>/doctor/listGoldKey" target="showRight"><dd>重置金钥匙账户密码<span class="dd_span">></span></dd></a>
			</c:if>
			
			<!-- 管理员账户 -->
			<c:if test='${userInfo.roleid == 1 }'>
				<a href="<%= path %>/doctor/listDoctor?orgId=${userInfo.dept_id}" target="showRight"><dd class="h_nav_over">医生管理<span class="dd_span">></span></dd></a>
				<a href="<%= path %>/docGrp/groupTotal" target ="showRight"><dd>医生分组管理<span class="dd_span">></span></dd></a>
				<a href="<%= path %>/memberGrp/groupTotal" target ="showRight"><dd>会员分组管理<span class="dd_span">></span></dd></a>
				<a href="<%= path %>/question/option/list" target="showRight"><dd>问卷类别配置<span class="dd_span">></span></dd></a>
			</c:if>
			
			<!-- 一般账户 -->
			<c:if test="${userInfo.roleid != 1 && userInfo.roleid != 6 && userInfo.roleid != 5}">
				<a href="../doctor/doctorAction!showUpdateInfoByIdUI?docid=${userInfo.id }" target="showRight"><dd class="h_nav_over">更新个人资料<span class="dd_span">></span></dd></a>
				<a href="${pageContext.request.contextPath }/doctor/docUpdatePassword.jsp" target="showRight"><dd>修改登录密码<span class="dd_span">></span></dd></a>
			</c:if>
	   </dl>
	</div>
</body>
</html>