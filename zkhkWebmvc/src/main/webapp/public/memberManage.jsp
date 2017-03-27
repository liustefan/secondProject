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
    <title>会员管理左侧iframe模块</title>
    <link rel="stylesheet" href="<%=path %>/css/general.css">
    <link rel="stylesheet" href="<%=path %>/public/css/left.css">

    <script src="<%=path %>/js/jquery-1.9.1.min.js"></script>
    <script src="<%=path %>/public/js/left.js"></script>
</head>
<body class="over-hidden">
<div id="left">
    <dl class="menu-list" id="dl">
        <c:if test='${userInfo.roleid != "1"}'>
		    <a href="<%=path %>/member/memberList?flag=my" target="showRight"><dd class="h_nav_over">我的会员<span class="dd_span">></span></dd></a>
			<a href="<%=path %>/member/memberList?flag=other" target="showRight"><dd>其他会员<span class="dd_span">></span></dd></a>
			<a href="<%=path %>/member/memberList" target="showRight"><dd id="allMember">所有会员<span class="dd_span">></span></dd></a>
			<a href="<%=path %>/member/momvementsList?flag=inner" target="showRight"><dd id="allMember">会员转移<span class="dd_span">></span></dd></a>
			<%--   新增异步注册时查看菜单 --%>
			<a href="<%=path %>/data/registList" target="showRight"><dd id="allMember">导入失败会员<span class="dd_span">></span></dd></a>
			<a href="<%=path %>/label/listLabel" target="showRight"><dd>会员标签管理<span class="dd_span">></span></dd></a>
		</c:if>
		<c:if test='${userInfo.roleid == "1"}'>
			<a href="<%=path %>/memberType/listMemberType" target="showRight"><dd class="h_nav_over">会员类型管理<span class="dd_span">></span></dd></a>
			<!-- <a href="../package/getPackageList" target="showRight"><dd>服务套餐管理<span class="dd_span">></span></dd></a> -->
			<a href="<%=path %>/label/listLabel" target="showRight"><dd>会员标签管理<span class="dd_span">></span></dd></a>
		</c:if>
    </dl>
</div>
</body>
</html>