<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>功能列表</title>
	
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/css/systemManagement.css">

	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
	function update(a) {
		alert(a.action);
		alert($(a).attr('action'));
		$.post($(this).attr('action'), $(this).serialize(), function(data) {
			if (data.success)
				location.reload(true);
			else
				alert('修改失败');
		});
		
		return false;
	}
	</script>
</head>
<body>
<div class="content">
	<div class="content-title">
		医生分组功能定义
	</div>
	<div class="table-box">
		<table class="table-content">
			<thead class="table-title">
				<tr>
					<th>功能代码</th>
					<th>功能名称</th>
					<th>功能说明</th>
					<!-- <th>操作</th> -->
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${ofunlist}" varStatus="status">
					<tr>
						<td>${item.funId }</td>
						<td>${item.funName }</td>
						<td>${item.funDes }</td>
					</tr>
				</c:forEach> 
			</tbody>
		</table>
	</div>
	<p class="tips">说明：“医生分组功能”将在创建医生分组时使用，为每个医生分组指定一个“分组功能”表明该分组中医生需要执行的功能，比如为医生分组“血压审核医生组”指定功能为“单项审核”，则表示“血压审核医生组”中的医生需要处理“单项审核”的工作。</p>
</div>
</body>
</html>