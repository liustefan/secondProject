<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>选择健康资讯</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">

	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
</head>
<body>
<div class="content">
    <form action="" method="POST" id="">
		<div class="search-box-wrapper">
			<ul class="search-wrapper">
				<li>
					<label>标签：</label>
					<select name="">
						<option value="0">全部</option>
						<option value="1">健康饮食</option>
						<option value="2">健康科普</option>
					</select>
				</li>
				<li>
					<label>标题：</label>
	                <input type="text">
				</li>
				<li>
					<button type="button" class="btn-inquiry ico-search" onclick="">查询</button>
				</li>
			</ul>
		</div>
		<div class="table-box">
			<table class="table-content">
				<thead class="table-title">
					<tr>
						<th width="40%">标题</th>
						<th width="40%">标签</th>
						<th width="20%">操作</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td></td>
						<td></td>
						<td>
							<a href="javascript: void(0);" onclick="">选择</a>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="page-box">
			<jsp:include page="/public/pageFoot.jsp"></jsp:include>
		</div>
	</form>
</div>
</body>
</html>
