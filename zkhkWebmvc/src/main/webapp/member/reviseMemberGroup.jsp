<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@page import="java.net.URLDecoder"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>修改会员分组</title>
<link rel="stylesheet" href="<%=path %>/css/general.css"/>
<link rel="stylesheet" href="<%=path %>/plugins/zTree_v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
<link rel="stylesheet" href="<%=path %>/css/tree.css"/>

<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
<script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.excheck-3.5.js"></script>
<script type="text/javascript" src="<%=path %>/js/tree.js"></script>
<script type="text/javascript" src="<%=path %>/js/reviseMemberGroup.js"></script>

<style type="text/css">
body {
	max-height: 600px;
	max-width: 600px;
}
.edit-box {
	padding: 15px 0 0 5px;;
}
#treeDemo {
	height: 210px;
}
.content-ends {
	margin-top: 15px;
}
.tree-wrapper{
	background: #fff;
}
</style>
</head>
<body>
	<% String name = URLDecoder.decode(request.getParameter("name"), "UTF-8"); %>
	<input type="hidden" id="memberid" value="${param.memberid }">
	<input type="hidden" id="name" value="<%=name %>">
	<input type="hidden" id="memberGroupId" value="${param.memGrpid}"/>
	<input type="hidden" id="batchTag" value="${param.batch }"/>
    <div class="edit-box">
        <p class="title">您将要修改 <span><%=name %></span> 的分组类别</p>
		<div class="tree-wrapper clearfix">
			<ul id="treeDemo" class="ztree"></ul>
		</div>
		<div class="page-box align-center">
			<button type="button"  onclick="updateMember();" class="btn-inquiry">保存</button>
			<button type="button" onclick="closeWd();" class="btn-cancel">取消</button>
		</div>
	</div>
</body>
</html>