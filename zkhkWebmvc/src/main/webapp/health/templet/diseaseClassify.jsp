<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML>
<html>
<head>
	<meta charset="utf-8">
	<title>选择疾病分类</title>
	<link rel="stylesheet" href="../../css/general.css"/>
	<link rel="stylesheet" href="../../plugins/zTree_v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<link rel="stylesheet" href="../../css/tree.css"/>

	<script type="text/javascript" src="../../js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="../../layer/layer-v2.0/layer.js"></script>
	<script type="text/javascript" src="../../plugins/zTree_v3/js/jquery.ztree.core-3.5.min.js"></script>
	<script type="text/javascript" src="../../plugins/zTree_v3/js/jquery.ztree.excheck-3.5.js"></script>
	<script type="text/javascript" src="../../plugins/zTree_v3/js/jquery.ztree.exhide-3.5.js"></script>
	<script type="text/javascript" src="../../js/diseaseClassify.js"></script>

	<style type="text/css">
		.input-search {
			height: 20px;
			width: 260px;
			margin: 15px 16px 5px 16px;
		}
		
		.member-search {
			right: 20px;
    		top: 19px;
		}
		
		.tree-content {
			margin: 0 16px;
			height: 245px;
			overflow: auto;
		}
		
		#treeDemo_1 {
		    padding-top: 0;
		}
	</style>
	<script type="text/javascript">
		function chooseDisease() {
			parent.setDiseaseInfo({
				diseaseName: $("#checked_name").val(),
				diseaseId: $("#checked_ID").val()
			});
    		parent.layer.close(index);
		}
	</script>
</head>
<body>
    <div class="tree-box">
    	<input type="hidden" id="checked_ID">
    	<input type="hidden" id="checked_name">
    	<div class="position-r">
			<input type="text" id="key" class="input-search" >
			<i class="member-search" onclick="searchDisease();"></i>
		</div>
		<div class="tree-content">
			<ul id="treeDemo" class="ztree"></ul>
		</div>
		<div class="page-box align-center">
			<button type="button" class="btn-inquiry" onclick="chooseDisease()">保存</button>
			<button type="button" class="btn-cancel" onclick="parent.layer.close(index)">取消</button>
		</div>
	</div>
</body>
</html>