<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>帮助</title>
   	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<script src="<%=path %>/js/jquery-1.9.1.min.js"></script>
</head>

<body>
	 <div class="content">
		<div class="content-title">帮助</div>
		<div class="table-box">
			<table class="table-content">
				<thead class="table-title">
					<tr>
						<th>名称</th>
						<th>简介</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>动态心电上传工具</td>
						<td>用于动态心电采集器下发给会员及将会员测量数据上传到web平台</td>
						<td id="table_content_title_td"><a href="http://192.168.10.27:8082/upgrade/download?version=V1.0.0&code=45555">下载</a></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>