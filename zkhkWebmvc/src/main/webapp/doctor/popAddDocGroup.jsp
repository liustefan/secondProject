<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
    <title>加入医生分组</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/plugins/zTree_v3/css/zTreeStyle/zTreeStyle.css">
	<link rel="stylesheet" href="<%=path %>/css/tree.css">
	<link rel="stylesheet" href="<%=path %>/css/popAddDocGroup.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.core-3.5.min.js"></script>
	<script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.excheck-3.5.js"></script>
	<script type="text/javascript" src="<%=path %>/js/tree.js"></script>
	<script type="text/javascript" src="<%=path %>/js/popAddDocGroup.js"></script>
</head>
<body>
  	<input type="hidden" id="docid" value="${param.docid}">
  	<input type="hidden" id="orgId" value="${param.orgid }"/>
    <div>
		<div class="clearfix tree-box">
			<ul id="treeDemo" class="ztree" style="margin-top:0; width:160px;"></ul>
		</div>
		<div class="clearfix mg-10">
			<span class="pull-left">已选医生分组<i>(<span id="info_checked">0</span>/<span id="info_total">0</span>)</i></span>
			<a href="javascript: void(0);" type="button" class="pull-right" onclick="removeAllGroup();">清空</a>
		</div>
		<ul id="selectedList" class="clearfix"></ul>
		<div class="page-box align-center">
			<button id="btn-ok" type="button"  class="btn-inquiry">确定</button>
			<button id="btn-cancel" type="button" class="btn-cancel">取消</button>
		</div>
    </div>
</body>
</html>
