<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>疾病分类</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/plugins/zTree_v3/css/zTreeStyle/zTreeStyle.css">
	<link rel="stylesheet" href="<%=path %>/css/tree.css">
	<link rel="stylesheet" href="<%=path %>/css/odgplist.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.core-3.5.min.js"></script>
	<script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.exhide-3.5.js"></script>
	<script type="text/javascript" src="<%=path %>/js/tree.js"></script>
	<script type="text/javascript" src="<%=path %>/js/orgsList.js"></script>

	<script>
		//左侧的树节点位置固定 右侧数据超出出现滚动条
		function setHeight() {
			$("#height").height($(window).height());
			$("#dataTable").height($(window).height());
		    $(".tree-wrapper").height($("#height").height()-45);
		}
		$(function(){
		     setInterval(setHeight, 200);
		});
	</script>
</head>
<body>
<div class="clearfix">
	<input type="hidden" id="id" value="${id}">
	<div class="content-title">疾病分类管理</div>
	<div id="height" class="createGroup-left">
		<div style="width:100%; height:10px;"></div>
		<div class="left-title">
			<input type="text" id="key" class="input-search">
			<i class="icon-search" onclick="searchNode();"></i>
		</div>
		<div class="tree-wrapper">
			<ul id="treeDemo" class="ztree"></ul>
		</div>
	</div>
	
	<iframe id="dataTable" name="dataTable" scrolling="yes" src="" onLoad="reinitIframe();"></iframe>
</div>
</body>
</html>