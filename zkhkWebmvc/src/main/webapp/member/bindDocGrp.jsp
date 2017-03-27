<%@ page import="java.net.URLDecoder"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String groupPath = URLDecoder.decode(request.getParameter("pathName"), "UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>绑定医生分组</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/plugins/zTree_v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<link rel="stylesheet" href="<%=path %>/css/tree.css">
	<link rel="stylesheet" href="<%=path %>/css/bindingGroup.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.core-3.5.min.js"></script>
	<script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.excheck-3.5.js"></script>
	<script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.exhide-3.5.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script type="text/javascript" src="<%=path %>/js/tree.js"></script>
	<script type="text/javascript" src="<%=path %>/js/bindingGroup.js"></script>
</head>
<body>
<div class="content">
	<div class="content-title">会员分组管理 --- 绑定医生分组</div>
	<input type="hidden" value="${param.memGrpId}" name="memGrpId">
	<div class="page-box">
		<span>会员分组名称><%=groupPath %></span>
	</div>
	<div class="content-group">
		<span>选择医生分组</span>
		<div class="left-title">
			<input type="text" id="key" class="input-search" >
			<i class="icon-search" onclick="searchNode();"></i>	
		</div>
		<div class="tree-wrapper edit">
			<ul id="treeDemo" class="ztree"></ul>
		</div>
	</div>
	<div class="page-box align-center">
		<button type="button" onclick="saveGroup();" class="btn-normal">确定</button>
		<button type="button" onclick="goback();" class="btn-cancel">返回</button>
	</div>
</div> 
</body>
</html>