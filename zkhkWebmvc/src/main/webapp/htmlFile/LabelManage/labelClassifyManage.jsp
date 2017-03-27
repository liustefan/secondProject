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
	<title>会员标签分类管理</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">

	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script type="text/javascript">
		var index = layer.getFrameIndex(window.name); //获取窗口索引
		
		function addClassify(title) {
			layer.closeAll();
			layer.open({
		   	    type: 2,
		   		skin : 'skin1',
		   	    title: title,
		   	    shadeClose: false,
		   	    shade: 0,
		   	    area: ['500px', '350px'],
		   	    content: 'editlabelClassify.html', //iframe的url
		   	}); 
		};
		
		function deleteClassify(msg, status) {
			if(status){
				layer.closeAll();
				layer.confirm( '此标签分类下有会员标签，不可删除！', {
					title : '提示信息',
					skin : 'skin1',
					shade : 0,
					btn : [ '确定' ]
				})
			}else {
				layer.closeAll();
				layer.confirm( msg, {
					title : '提示信息',
					skin : 'skin1',
					shade : 0,
					btn : [ '确定', '取消' ]
				}, function(index) {
					$.ajax({
						url: url,
					   type: "POST",
					success: function(data) {
						alert(data.content);
		 		     	if(data.status) {
		 		     		window.location.reload();
		 		     	}
					}
					});
				});
			}
		}
	</script>
</head>
<body>
<div class="content">
	<div class="content-title">
   		会员标签分类管理
	</div>
    <form action="" method="POST" id="">
		<div class="search-box-wrapper">
			<ul class="search-wrapper">
				<li>
					<label>标签分类：</label>
	                <input type="text" maxlength="10">
				</li>
				<li>
					<button type="button" class="btn-inquiry ico-search" onclick="">查询</button>
					<button type="button" class="btn-inquiry ico-add" onclick='addClassify("新增标签分类")'>新增</button>
				</li>
			</ul>
		</div>
		<div class="table-box">
			<table class="table-content">
				<thead class="table-title">
					<tr>
						<th>标签分类</th>
						<th>备注</th>
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
						<td>
							<a href="javascript: void(0);" onclick='addClassify("修改标签分类")'>修改</a>
							<a href="javascript: void(0);" class="mar-left" onclick="deleteClassify('您确认要删除标签分类名称标签分类吗？','be')">删除</a>
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
