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
	<title>会员标签管理</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">

	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script type="text/javascript">
		var index = layer.getFrameIndex(window.name); //获取窗口索引
		
		function changeStatus1() {
	    	layer.closeAll();
		    layer.confirm("您确认要启用当前标签吗？",{
		        skin : 'skin1',
		        shade: 0,
		        btn: ['确定','取消'] //按钮
		    }, function(index){
		    	
		    });
		}
	    
	    function changeStatus2() {
	    	layer.closeAll();
		    layer.confirm("您确认要禁用当前标签吗？",{
		        skin : 'skin1',
		        shade: 0,
		        btn: ['确定','取消'] //按钮
		    }, function(index){
		    	
		    });
		}
	</script>
</head>
<body>
<div class="content">
	<div class="content-title">
   		会员标签管理
	</div>
    <form action="" method="POST" id="">
		<div class="search-box-wrapper">
			<ul class="search-wrapper">
				<li>
					<label>标签分类：</label>
	                <select name="">
						<option value="0">请选择</option>
						<option value="1">会员来源</option>
						<option value="2">注册方式</option>
					</select>
				</li>
				<li>
					<label>标签内容：</label>
	                <input type="text" name="" value="">
				</li>
				<li>
					<label>使用范围：</label>
	                <select name="">
						<option value="0">全部</option>
						<option value="1">全局</option>
						<option value="2">组织内</option>
						<option value="3">私人</option>
					</select>
				</li>
				<li>
					<label>状态：</label>
	                <select name="">
						<option value="0">启用</option>
						<option value="1">禁用</option>
					</select>
				</li>
				<li>
					<button type="button" class="btn-inquiry ico-search" onclick="">查询</button>
					<button type="button" class="btn-inquiry ico-add" onclick="window.location.href='editLabel.html'">新增</button>
				</li>
			</ul>
		</div>
		<div class="table-box">
			<table class="table-content">
				<thead class="table-title">
					<tr>
						<th>标签分类</th>
						<th>标签内容</th>
						<th>备注</th>
						<th>使用范围</th>
						<th>更新人</th>
						<th>所属组织</th>
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
						<td></td>
						<td></td>
						<td>
							<a href="javascript:void(0);" onclick="">修改</a>
							<c:if test="">
	                        	<a href="javascript:void(0);" id="" class="mar-left" onclick='changeStatus1()'>启用</a>
	                        </c:if>
                         	<c:if test="">
	                        	<a href="javascript:void(0);" id="" class="mar-left" onclick='changeStatus2()'>禁用</a>
	                        </c:if>
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
