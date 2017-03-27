<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.bithealth.sdk.common.utils.TimeUtil"%>
<%
String path = request.getContextPath();
pageContext.setAttribute("currentYear", TimeUtil.year());
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
    <title>高血压随访</title>
    <link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/js/jquery-ui/themes/overcast/jquery-ui.min.css">
	<link rel="stylesheet" href="<%=path %>/plugins/zTree_v3/css/zTreeStyle/zTreeStyle.css">
	<link rel="stylesheet" href="<%=path %>/plugins/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="<%=path %>/css/tree.css">
    <link rel="stylesheet" href="<%=path %>/css/populationReport.css">
    
    <script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="<%=path %>/js/highcharts.js"></script>
    <script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.core-3.5.min.js"></script>
	<script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.exhide-3.5.js"></script>
    <script type="text/javascript" src="<%=path %>/js/tree.js"></script>
    <script type="text/javascript" src="<%=path %>/js/hypertensionFollowUpReport.js"></script>
</head>

<body onload="addYear()">
<div class="content">
	<!-- 隐藏域 服务器时间 -->
	<input type="hidden" value="${currentYear}" id="currentYear">
	<div class="loadBox">
		<div class="loading"></div>
		数据加载中。。。
	</div>
	<div class="content-title">高血压随访</div>
    <div class="search-box-wrapper">
		<ul class="search-wrapper clearfix">
			<li>
				<label>组织名称：</label>
				<span <c:if test="${userInfo.roleid == 6}">onclick="showGroupList();"</c:if><c:if test="${userInfo.roleid != 6}">class="disable-change"</c:if>>
	        	<c:if test="${org.orgId!=null}">
	        	<input class="info" type="hidden" name="orgId" id="memberGroupId"  value="${org.orgId}"/>
	        	<input type="text" name="name" class="input-height margin-lf" id="memberGroupName" value="${org.orgName}" readonly="readonly">
	        	<i class="org-search"></i>
	        	</c:if>
	        	
	        	<c:if test="${org.orgId==null}">
	        	<input class="info" type="hidden" name="orgId" id="memberGroupId"  value="${userInfo.dept_id }"/>
	        	<input type="text" name="name" class="input-height margin-lf" id="memberGroupName" value="${userInfo.orgName}" readonly="readonly">
	        	<i class="org-search"></i>
	        	</c:if>
        		
        		</span>
			</li>
			<li>
				<label>随访年度: </label>
		        <select id="infoYear">
		        </select>
			</li>
			<li>
				<button type="submit" class="btn-inquiry ico-search" onclick="search();">查询</button>
			</li>
		</ul>
	</div>
    <div class="table-box" id="datalist">
	    <table class="table-content">
	    	<thead class="table-title">
		        <tr>
		        <th>地区</th>
	            <th>高血压总人数</th>
	            <th>年内累计管理</th>
	            <th>规范管理</th>
	            <th>年内新发现</th>
	            <th>最近随访血压达标</th>
		        </tr>
	        </thead>
	        <tbody>
	        </tbody>
	    </table>
    </div>
    <div class="info-charts">
        <!-- 高血压随访状况表 -->
        <div id="chart-hypertension1" style="min-width:700px; margin: 15px auto; "></div>
        <!-- 各地区高血压随访状况横向对比表 -->
        <div id="chart-hypertension2" style="min-width:700px; margin: 15px auto;"></div>
    </div>
    <%--组织名称分组--%>
    <div id="menuContent" class="menuContent">
		<div class="menu-title">选择组织名称</div>
		<div class="left-title">
			<input type="text" id="key" class="input-search" >
			<i class="icon-search" onclick="searchNode();"></i>
		</div>
		<ul id="treeDemo" class="pop-ztree ztree"></ul>
		<div class="menu-footer">
			<button type="button" class="btn-inquiry" onclick="javascript: $('#menuContent').hide();">确定</button>
			<button type="button" class="btn-cancel" onclick="cancelSeclectGroup();">取消</button>
		</div>
	</div>
</div>  
</body>
</html>
