<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>血糖测量报告</title>
	<link rel="shortcut icon" href="<%=path %>/<%=getServletContext().getAttribute("img") %>/title_ico.ico" type="image/x-icon" />
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/css/vip.css">
	<script type="text/javascript">
		var memberid = "${omem.memberid}";
		// 全局变量 用于singleObsrRep.js
		var basePath = '<%=basePath%>';
		var obsrsJson= ${obsrsJson};
	</script>
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/highcharts.js"></script>
	<script type="text/javascript" src="<%=path %>/js/exporting.js"></script>
	<script type="text/javascript" src="<%=path %>/js/highcharts-more.js"></script>
	<script type="text/javascript" src="<%=path %>/js/xuetangRep.js"></script>
	<script type="text/javascript" src="<%=path %>/js/kindeditor/kindeditor.js"></script>
	<script type="text/javascript" src="<%=path %>/js/kindeditor/lang/zh_CN.js"></script>
	<%-- <script type="text/javascript" src="<%=path %>/js/popupPage1.js"></script> --%>
	
	<script type="text/javascript">
		var userInfo_orgId =${empty userInfo.dept_id}?0:${userInfo.dept_id}+0;
		KindEditor.ready(function(K) {		
			window.editor = K.create('#myAdvice', {
				height : '300px',
				width : '100%',
				orgid: userInfo_orgId
			});
			
		});
		
		//post提交数据方法
		function post(url, params) {
		    var temp = document.createElement("form");
		    temp.action = url;
		    temp.method = "post";
		    temp.style.display = "none";
		    for (var x in params) {
		        var opt = document.createElement("input");
		        opt.name = x;
		        opt.value = params[x];
		        temp.appendChild(opt);
		    }
		    document.body.appendChild(temp);
		    temp.submit();
		    return temp;
		}
		
		function exportXTPreview(){
			post("../bloodSugar/getReportXTPreview",{obsrsJson:JSON.stringify(${obsrsJson}),memberid:${omem.memberid},generTime:$("#generTime").val()});
		}
	</script>
	<style type="text/css">
		#myAdvice {
		  margin: 0;
		  padding: 0;
		  border: 1px solid #ccc;
		  width: 90%;
		  resize: none;
		  font-family: "Microsoft YaHei";
		  color: #333;
		 }
	   
	   .reason-box { 
			background: #faefc6;
			padding: 15px;
	   }
	   
	   .reason-box textarea {
			min-height: 40px;
			border: 1px solid #ddd;
			resize: none;
			width: 80%;
	   }
	   
	   .reason-box span { 
			display: block; 
			margin-bottom: 5px;
	   }
	   
	  .btn-blue {
			font-family: "Microsoft YaHei";
			font-size: 14px; 
			margin-top: 10px;
			font-weight: bold; 
			padding: 3px 10px;
			background: #f60;
			border-radius: 3px;
			background-image: -moz-linear-gradient(center top, rgba(255, 102, 0, 0.8) , rgba(253, 113, 28, 0.8)) repeat scroll 0 0 rgba(255, 102, 0, 0.8);
			background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, rgba(255, 102, 0, 0.8)), color-stop(1, rgba(253, 113, 28, 0.8)));
			color: #fff;
			cursor: pointer;
			outline: none; 
			margin-bottom: 10px;
	  }
	  
	  .pieTitle {
			text-align: center;
			font-weight: bold;
			font-size: 16px;
			font-family: Microsoft YaHei;
	  }
	</style>
</head>
<body>
<div class="content">
	<h4 class="title-report">${omem.memname }血糖测量报告</h4>
		<table class="table-border">
			<tr>
				<td>姓名：${omem.memname }</td>
				<td>性别：${omem.gender=='1'?'男': omem.gender=='2'?'女':'未知'}</td>
				<td>年龄：${age }</td>
				
				<td>身高：${omem.physical.height }</td>
				<td>体重：${omem.physical.weight }</td>
				<td>报告编号：</td>
			</tr>
			<tr>
				<td>测量时间段：</td>
				<td><fm:formatDate value="${startMeasTime }" pattern="yyyy-MM-dd"/>至<fm:formatDate value="${endMeasTime }" pattern="yyyy-MM-dd"/></td>
				<td>历时天数：${lastDay }</td>
				<td>数据记录天数：${recordDay }</td>
				<td>报告产生时间：<fm:formatDate value="${generTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<input id="generTime" type="hidden" value="<fm:formatDate value='${generTime }' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<td>报告审核时间：</td>
			</tr>
		</table>
		<br/>
		<div id="chart">
			<div id="part1">
				<div id="chart1"></div>
				<div id="chart2" style="height:335px;"></div>
				<div id="chart5" style="height:410px;"></div>
			</div>
			<div id="part2">
				<div id="chart3"></div>
				<div id="chart4">
					<p class="pieTitle">血糖饼图</p>
					<div id="chart4_1" style="height:150px;"></div>
					<div id="chart4_2" style="height:150px;"></div>
					<div id="chart4_3" style="height:150px;"></div>
					<div id="chart4_4" style="height:150px;"></div>
					<div id="chart4_5" style="height:150px;"></div>
					<div id="chart4_6" style="height:150px;"></div>
					<div id="chart4_7" style="height:150px;"></div>
					<div id="chart4_8" style="height:150px;"></div>
					<div id="chart4_9" style="height:150px;"></div>
				</div>
			</div>
		</div>
		<br/>
		<table class="table-border">
			<tr><td>测量时间</td><td>测量方式</td><td>时间类型</td><td>血糖值</td><td>操作</td></tr>
			<c:forEach var="item" items="${obsrs}" varStatus="st">
				<tr>
					<td><fm:formatDate value="${item.testtime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" dateStyle="long"/></td>
					<td>${item.devicecode }</td>
					<td>${item.periodName }</td>
					<td>${item.bsvalue}</td>
					<td>
						<a href="${pageContext.request.contextPath}/bloodSugar/showSingleBloodSugar?memberId=${item.memberid}&eventId=${item.eventid}" target="_blank">查看</a>
					</td>
				</tr>
			</c:forEach> 
		</table>
		<br/>
		<a href="javascript:exportXTPreview();" target="_blank"><input type="button" class="btn-normal" value="导出测量报告"/></a>
</div>
</body>
</html>