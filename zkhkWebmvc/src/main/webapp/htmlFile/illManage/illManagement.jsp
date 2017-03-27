<%@ page import="java.net.URLDecoder"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String name = request.getParameter("pName");
String pName =(String)request.getAttribute("pName");
if(name != null){
	pName = URLDecoder.decode(name, "UTF-8");
}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>疾病分类管理</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">

	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/orgsTable.js"></script>
</head>
<body>
<div class="content">
	<form id="" action="" method="post">
		<div class="search-box-wrapper">
			<ul class="search-wrapper clearfix">
				<li>
					<label>选中上级疾病节点：</label>
					<span>全部</span>
				</li>
				<li>
					<button id="add-group" type="button" class="btn-inquiry ico-add">新增</button>
				</li>
			</ul>
		</div>
		<div class="table-box">
			<table class="table-content">
				<thead class="table-title">
					<tr>
						<th>疾病分类名称</th>
						<th>描述</th>
						<th>排序号</th>
						<th>更新人</th>
						<th>更新日期</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td>
							<a href="javascript:void(0)" onclick="">修改</a>
							<a href="javascript:void(0)" class="mar-left" onclick="">删除</a>
						</td>
					</tr>
				</tbody>
			</table>
			<div class="page-box">
				<jsp:include page="/public/pageFoot.jsp"></jsp:include>
		  	</div>
    	</div>
	</form>
</div>
</body>
</html>