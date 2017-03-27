<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
	<title>会员套餐列表</title>
    <link rel="stylesheet" type="text/css" href="<%=path %>/css/general.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/vip.css">
    <script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
		$(function(){
			 $("#return").click(function(){
					window.history.go(-1);
	          }); 
			  
			});
	</script>
</head>
<body>
<div class="content">
	<div class="page-box">
		<button type="button" id="return" class="btn-cancel" style="margin-left: 0;">返回</button>
	</div>
	<div class="table-box">
		<table class="table-content">
			<thead class="table-title">
				<tr>
					<th>汇总模板</th>
					<th>次数</th>
					<th>已提交次数</th>
					<th>开始日期</th>
					<th>结束日期</th>
					<th>计算类型</th>
					<th>标记</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${detailList}" varStatus="deatilStatus">
				<tr>
				   <td>${item.sumRepTempName}</td>
				   <td>${item.numTimes}</td>
	               <td>${item.submitNum}</td>
	               <td><fm:formatDate pattern="yyyy-MM-dd" value="${item.beginDate}" /></td>
	               <td><fm:formatDate pattern="yyyy-MM-dd" value="${item.endDate}" /></td>
	               <td>${item.calcType=='T'?'计时套餐':'计次套餐'}</td>
	               <td>${item.tag =='T'?'有效':'无效' }</td>
	             </tr>
				</c:forEach> 
			</tbody>
		</table>
	</div>
</div>
</body>
</html>