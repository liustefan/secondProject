<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE HTML>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>报告统计与分析</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	
	<script src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script src="<%=path %>/js/calendar.js"></script>
</head>
<body>
<div class="content">
	<div class="content-title">
		报告统计与分析
	</div>
	<div class="table-box">
		<table class="table-content">
			<thead class="table-title">
				<tr>
					<th>时间</th>
					<th>血压</th>
					<th>血糖</th>
					<th>三合一</th>
					<th>动态心电</th>
					<th>答卷</th>
					<th>备注</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${strs[0] }</td>
					<td>${reps[0] }</td>
					<td>${reps[4] }</td>
					<td>${reps[8] }</td>
					<td>${reps[12] }</td>
					<td>${reps[16] }</td>
					<td></td>
				</tr>
				<tr>
					<td>${strs[1]  }</td>
					<td>${reps[1] }</td>
					<td>${reps[5] }</td>
					<td>${reps[9] }</td>
					<td>${reps[13] }</td>
					<td>${reps[17] }</td>
					<td></td>
				</tr>
				<tr>
					<td>${strs[2]  }</td>
					<td>${reps[2] }</td>
					<td>${reps[6] }</td>
					<td>${reps[10] }</td>
					<td>${reps[14] }</td>
					<td>${reps[18] }</td>
					<td></td>
				</tr>
				<tr>
					<td>总数</td>
					<td>${reps[3] }</td>
					<td>${reps[7] }</td>
					<td>${reps[11] }</td>
					<td>${reps[15] }</td>
					<td>${reps[19] }</td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
</body>
</html>