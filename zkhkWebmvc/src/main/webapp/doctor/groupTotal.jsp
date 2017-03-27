<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>医生分组管理</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/plugins/zTree_v3/css/zTreeStyle/zTreeStyle.css">
	<link rel="stylesheet" href="<%=path %>/css/tree.css">
	<link rel="stylesheet" href="<%=path %>/css/odgplist.css">
    
	<script type="text/javascript" src="<%=path %>/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.core-3.5.min.js"></script>
	<script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.exhide-3.5.js"></script>
	<script type="text/javascript" src="<%=path %>/js/tree.js"></script>
	<script type="text/javascript" src="<%=path %>/js/odgpList.js"></script>

	<script>
		//左侧的树节点位置固定 右侧数据超出出现滚动条
		function setHeight() {
			$("#height").height($(window).height());
			$("#dataTable").height($(window).height()-55);
		    $(".tree-wrapper").height($("#height").height()-104);
		}
		$(function(){
		    setInterval(setHeight, 200);
		});
	</script>
</head>
<body style="overflow: hidden;">
<div class="content">
	<div class="content-title">
		医生分组管理
	</div>
	<input type="hidden" value="${pId}" name="pId"/>
	<div id="height" class="createGroup-left">
		<div style="width:100%; height:10px;"></div>
		<div class="left-title">
			<input type="text" id="key" class="input-search" >
			<i class="icon-search" onclick="searchNode();"></i>
		</div>
		<div class="tree-wrapper">
			<ul id="treeDemo" class="ztree"></ul>
		</div>
	</div>
	<iframe id="dataTable" name="dataTable" scrolling="yes" src="<%=path %>/docGrp/listDoctorGrp?pId=${pId}" onLoad="reinitIframe();"></iframe>
</div>
</body>
</html>