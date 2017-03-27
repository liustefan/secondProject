<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<title>远程测量统计与分析</title>
    <link rel="stylesheet" type="text/css" href="<%=path %>/css/general.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/audit.css">
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/calendar.js"></script>

	<script type="text/javascript">
		$(function(){
			
			});
	</script>
</head>
<body>
<div class="content">
	<div class="content-title">
		远程测量统计与分析
	</div>
	<div id="footer_content">
		<div id="footer_table">
			<table border="0" cellspacing="0" id="tabel_content">
				<thead>
					<tr id="table_content_title">
						<th rowspan="2">时间</th>
						<th colspan="2">血压</th>
						<th colspan="2">血糖</th>
						<th colspan="2">三合一</th>
						<th colspan="2">动态心电</th>
						<th rowspan="2">备注</th>
					</tr>
					<tr id="table_content_title1">
						<th>测量数量</th>
						<th>异常数量</th>
						<th>测量数量</th>
						<th>异常数量</th>
						<th>测量数量</th>
						<th>异常数量</th>
						<th>测量数量</th>
						<th>异常数量</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${strs[0] }</td>
						<td>${reps[0] }</td><td>${reps[4] }</td><td>${reps[8] }</td><td>${reps[12] }</td>
						<td>${reps[16] }</td><td>${reps[20] }</td><td>${reps[24] }</td><td>${reps[28] }</td>
						<td></td>
					</tr>
					<tr>
						<td>${strs[1] }</td>
						<td>${reps[1] }</td><td>${reps[5] }</td><td>${reps[9] }</td><td>${reps[13] }</td>
						<td>${reps[17] }</td><td>${reps[21] }</td><td>${reps[25] }</td><td>${reps[29] }</td>
						<td></td>
					</tr>
					<tr>
						<td>${strs[2] }</td>
						<td>${reps[2] }</td><td>${reps[6] }</td><td>${reps[10] }</td><td>${reps[14] }</td>
						<td>${reps[18] }</td><td>${reps[22] }</td><td>${reps[26] }</td><td>${reps[30] }</td>
						<td></td>
					</tr>
					<tr>
						<td>总数</td>
						<td>${reps[3] }</td><td>${reps[7] }</td><td>${reps[11] }</td><td>${reps[15] }</td>
						<td>${reps[19] }</td><td>${reps[23] }</td><td>${reps[27] }</td><td>${reps[31] }</td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>