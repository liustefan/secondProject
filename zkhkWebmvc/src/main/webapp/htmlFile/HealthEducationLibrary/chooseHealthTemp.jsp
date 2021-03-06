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
	<title>选择健教模板</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">

	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<style>
		.content {
			margin-top: 8px;
		}
		
		.width-normal {
			width: 150px;
		}
		
		.width-lg {
			width: 250px;
		}
		
		.position-r {
			position: relative;
			display: inline-block;
		}
		
		.member-search {
		    position: absolute;
		    right: 5px;
		    top: 5px;
		    width: 20px;
		    height: 20px;
		    display: inline-block;
		    background: url(../../img/u125.png) no-repeat center;
		    cursor: pointer;
		}
	</style>
	<script type="text/javascript">
		var index = layer.getFrameIndex(window.name); //获取窗口索引
	
		function chooseDisease(title){
			layer.closeAll();
			layer.open({
		   	    type: 2,
		   		skin : 'skin1',
		   	    title: title,
		   	    shadeClose: false,
		   	    shade: 0,
		   	    area: ['300px', '400px'],
		   	    content: '', //iframe的url
		   	}); 
		}
	</script>
</head>
<body>
<div class="content">
    <form action="" method="POST" id="">
		<div class="search-box-wrapper">
			<ul class="search-wrapper">
				<li>
					<label>健教类型：</label>
					<select name="">
						<option value="0">全部</option>
						<option value="1">饮食指导</option>
						<option value="2">运动指导</option>
						<option value="3">心理指导</option>
						<option value="4">中医指导</option>
						<option value="5">生活方式指导</option>
						<option value="6">用药指导</option>
					</select>
				</li>
				<li>
					<label>疾病分类：</label>
					<div class="position-r">
		                <input type="text" class="width-normal" readonly>
		                <i class="member-search" onclick="chooseDisease('选择疾病分类');"></i>
                 	</div>
				</li>
				<li>
					<label>标题：</label>
	                <input type="text" class="width-lg" >
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
						<th>健教类型</th>
						<th>标题</th>
						<th>适用疾病分类</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td></td>
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
