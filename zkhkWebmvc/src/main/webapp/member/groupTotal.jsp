<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" %>
<%
String path = request.getContextPath();
%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>会员分组管理</title>

<link rel="stylesheet" href="<%=path %>/css/reset.css">
<link rel="stylesheet" type="text/css" href="<%=path %>/css/member.css">
<link rel="stylesheet" href="<%=path %>/plugins/zTree_v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
<link rel="stylesheet" href="<%=path %>/css/comm.css"/>

<link rel="stylesheet" href="<%=path %>/css/tree.css"/>
<link rel="stylesheet" href="<%=path %>/css/odgplist.css"/>
<link rel="stylesheet" href="<%=path %>/css/groupMemberList.css"/>
<link rel="stylesheet" href="<%=path %>/css/general.css">

<script type="text/javascript" src="<%=path %>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.excheck-3.5.js"></script>
<script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.exhide-3.5.js"></script>
<script type="text/javascript" src="<%=path %>/js/tree.js"></script>
<script type="text/javascript" src="<%=path %>/js/groupMemberList.js"></script>

<script>
	//左侧的树节点位置固定 右侧数据超出出现滚动条
	function setHeight() {
		$("#height").height($(window).height());
		$("#dataTable").height($(window).height()-58);
	    $(".tree-wrapper").height($("#height").height()-110);
	}
	$(function(){
	    setInterval(setHeight, 200);
	});
</script>
</head>
<body style="overflow: hidden;">
<div class="content">
	<div class="content-title">
		会员分组管理
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
	<iframe id="dataTable" name="dataTable" scrolling="yes" src="<%=path %>/memberGrp/listMemberGroup?pId=${pId}" onLoad="reinitIframe();"></iframe>
</div>
</body>
</html>
