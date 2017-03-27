<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    <title>人口基本状况</title>
    <link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/plugins/zTree_v3/css/zTreeStyle/zTreeStyle.css">
	<link rel="stylesheet" href="<%=path %>/plugins/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="<%=path %>/css/tree.css">
	<link rel="stylesheet" href="<%=path %>/css/reset.css">
    <link rel="stylesheet" href="<%=path %>/css/populationReport.css">
    
    <script src="<%=path %>/js/jquery-1.9.1.min.js"></script>
    <script src="<%=path %>/js/highcharts.js"></script>
    <script src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.core-3.5.min.js"></script>
	<script src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.exhide-3.5.js"></script>
    <script src="<%=path %>/js/tree.js"></script>
    <script src="<%=path %>/js/drawStatisticalReports.js"></script>
</head>

<body>
<div class="content">
	<div class="loadBox">
		<div class="loading"></div>
		数据加载中。。。
	</div>
	<div class="content-title">人口基本状况</div>
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
				<button type="submit" class="btn-inquiry ico-search" onclick="search();">查询</button>
			</li>
		</ul>
	</div>				
    <div class="table-box" id="datalist">
	    <table class="table-content">
	    	<thead class="table-title">
		        <tr>
		            <th>地区</th>
		            <th>人口总数</th>
		            <th>65以上老人</th>
		            <th>高血压人数</th>
		            <th>糖尿病人数</th>
		        </tr>
	        </thead>
	        <tbody>
	        </tbody>
	    </table>
    </div>
    <%--数据图表--%>
    <div class="info-charts">
        <!-- 各地区人口基本资料表 -->
        <div id="chart-population" style="min-width: 700px; margin: 15px auto;"></div>
        <!-- 各地区需随访人群资料 -->
        <div id="chart-followUp" style="min-width: 700px; margin: 15px auto;"></div>
        <!-- <div id="barBox"></div> -->
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
	        	