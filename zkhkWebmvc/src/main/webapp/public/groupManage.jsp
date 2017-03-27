<%@ page language="java" import="java.util.*,javax.servlet.http.*" pageEncoding="UTF-8"%>  
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
   	<meta charset="utf-8">
   	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>系统管理左侧iframe模块</title>

    <link rel="stylesheet" href="<%=path %>/css/general.css">
    <link rel="stylesheet" href="<%=path %>/public/css/left.css">

    <script src="<%=path %>/js/jquery-1.9.1.min.js"></script>
    <script src="<%=path %>/public/js/left.js"></script>
</head>
<body class="over-hidden">
	<div id="left">
		<dl class="menu-list" id="dl">
			 <c:choose>
				<%-- 系统管理员账户 --%>
				<c:when test='${userInfo.roleid == "6"}'>
				<a href="<%= path %>/ofun/getOfunList" target ="showRight"><dd class="h_nav_over">医生分组功能定义<span class="dd_span"></span></dd></a>
				<%-- <dd><a href="<%= path %>/group/ofun.jsp" target="showRight">添加功能</a><span class="dd_span">></span></dd> --%>
				<a href="<%= path %>/org/orgPage" target ="showRight"><dd>组织机构配置<span class="dd_span"></span></dd></a>
				<%-- <dd><a href="<%= path %>/group/orgs!saveView" target="showRight">添加组织架构</a><span class="dd_span">></span></dd> --%>
				<a href="<%= path %>/sms/getSmsRecord" target ="showRight"><dd>短信发送记录<span class="dd_span"></span></dd></a>
				<a href="<%= path %>/health/illType" target ="showRight"><dd>疾病分类管理<span class="dd_span"></span></dd></a>
				<a href="<%= path %>/labelClass/listLabelClass" target ="showRight"><dd>会员标签分类管理<span class="dd_span"></span></dd></a>
				<a href="<%=path %>/label/listLabel" target ="showRight"><dd>会员标签管理<span class="dd_span"></span></dd></a>
				</c:when>
				<%-- 管理员账户 --%>
				<c:when test='${userInfo.roleid == "1"}'>
			<%-- 	<a href="<%= path %>/doctor/doctorAction!showCreateManagerUI?logRole=${sessionScope.logRole}&amp;docid=${sessionScope.userInfo.docid }" target="showRight"><dd class="h_nav_over">创建医生<span class="dd_span">></span></dd></a>
				<a href="<%= path %>/group/odgp!showAllLowerStr" target ="showRight"><dd>创建医生分组<span class="dd_span">></span></dd></a>
				<a href="<%= path %>/doctor/doctorManager1!showAllDoctors?orgId=${sessionScope.org_id}" target="showRight"><dd>修改医生分组<span class="dd_span">></span></dd></a>
				 --%>
				<a href="<%= path %>/group/oopt!saveView" target="showRight" ><dd class="h_nav_over">添加选项<span class="dd_span">></span></dd></a>
				<a href="<%= path %>/group/oopt!getDocOopt" target="showRight"><dd>选项列表<span class="dd_span">></span></dd></a>
				<%-- <dd><a href="<%= path %>/group/odgp!saveView" target="showRight">添加医生分组</a><span class="dd_span">></span></dd> --%>
				<%-- <dd><a href="<%= path %>/group/omgs!saveView" target="showRight">添加会员分组</a><span class="dd_span">></span></dd> --%>
				</c:when>
				<c:when test='${userInfo.roleid != "1"}'>
					<a href="<%= path %>/group/omgs!showAllLowerStr" target ="showRight"><dd>创建会员分组<span class="dd_span">></span></dd></a> 
					<a href="<%= path %>/group/omgs!groupMember" target="showRight"><dd class="h_nav_over">查看会员分组<span class="dd_span">></span></dd></a>
					<a href="<%= path %>/mem/MemberAction_memberRelationship" target="showRight"><dd>会员与会员分组关系维护<span class="dd_span">></span></dd></a>
					<a href="<%= path %>/group/odgp!groupDoctor" target="showRight"><dd>医生分组列表<span class="dd_span">></span></dd></a>
					<%-- <a href="<%= path %>/group/odgp!groupDoctor" target="showRight"><dd>查看医生分组明细<span class="dd_span">></span></dd></a> --%>				
					<a href="<%= basePath %>dpkgs/dpkg!viewMemPacket" target="showRight"><dd>修改医生会员分组对照<span class="dd_span">></span></dd></a>
					<a href="<%= path %>/group/odmt.action" target="showRight"><dd>查看医生会员分组对照明细<span class="dd_span">></span></dd></a>				
				</c:when>
			</c:choose>
		</dl>
	</div>
</body>
</html>
