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
	<title>三合一测量报告</title>
	<script type="text/javascript">
		// 全局变量 用于singleOecgRep.js
		var basePath = "<%=basePath%>";
	</script>
	<link rel="shortcut icon" href="<%=path %>/<%=getServletContext().getAttribute("img") %>/title_ico.ico" type="image/x-icon" />
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/css/vip.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/highcharts.js"></script>
	<script type="text/javascript" src="<%=path %>/js/sanheYiRep.js"></script>
	<script type="text/javascript" src="<%=path %>/js/kindeditor/kindeditor.js"></script>
	<script type="text/javascript" src="<%=path %>/js/kindeditor/lang/zh_CN.js"></script>
	<%-- <script type="text/javascript" src="<%=path %>/js/popupPage1.js"></script> --%>
	<script type="text/javascript">
		var memberid = '${omem.memberid}';
		var oecgsJson = ${oecgsJson};
		var oppgsJson = ${oppgsJson};
		
		var userInfo_orgId = ${empty userInfo.dept_id}?0:${userInfo.dept_id}+0;
		KindEditor.ready(function(K) {		
			window.editor = K.create('#myAdvice', {
				height : '300px',
				width : '100%',
				orgid: userInfo_orgId
			});
			
		});
		
		function scanShyDetail(memName,memberId,gender,birthDate,headAddress,eventId){
			var d = new Date(birthDate);
			var date = d.getFullYear()+"-"+(d.getMonth()+1)+"-"+d.getDate();
			var url = "../measure/showMeasSanheyi.jsp?memName="+encodeURI(encodeURI(memName))+"&memberId="+memberId+"&gender="+gender+"&birthDate="+date
						+"&headAddress="+headAddress+"&eventId="+eventId+"&tab=single";
			window.open(url);
		}
		
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
		
		function exportSHYPreview(){
			post("../electrocardioPulse/getReportSHYPreview",{oecgsJson:JSON.stringify(${oecgsJson}),oppgsJson:JSON.stringify(${oppgsJson}),memberid:${omem.memberid},generTime:$("#generTime").val()});
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
			background:#faefc6;
			padding:15px;
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
	</style>
</head>
<body>
<div class="content">
	<h4 class="title-report">${omem.memname }三合一测量报告</h4>
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
	<br />
	<div id="chart">
		<div id="part1">
				<div id="chart1" style="height:400px;"></div>
				<div id="chart2" style="height:400px;margin-top:10px;"></div>
		</div>
		<div id="part2">
			<div id="chart3" style="height:400px;"></div>
			<div id="chart4" style="height:400px;margin-top:10px;"></div>
		</div>
	</div>
	<br/>
	<table class="table-border align-center">
	<tr>
		<td width="15%">测量时间</td>
		<td width="15%">平均心率</td>
		<td>分析结果</td>
		<td width="8%">操作</td>
	</tr>
	<c:forEach var="item" items="${oecgs}" varStatus="status">
	<tr>
		<td><fm:formatDate value="${item.meastime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" dateStyle="long"/></td>
		<td align="center">${item.averageheart}</td>
		
		<c:if test="${fn:length(item.ecg2s) == 0 && fn:length(item.oppg.extName) == 0}">
			<td>无异常</td>
		</c:if>
		<c:if test="${fn:length(item.ecg2s) != 0 || fn:length(item.oppg.extName) != 0}">
		<td style="color:red;">
			<c:if test="${fn:length(item.ecg2s) !=0 }">
				心电异常(${fn:length(item.ecg2s)}):&nbsp;&nbsp;
				<c:forEach var="ecg2" items="${item.ecg2s}" varStatus="st">
					<c:if test="${st.last}">${ecg2.abnCname}。</c:if>
					<c:if test="${!st.last}">${ecg2.abnCname}</c:if>
				</c:forEach> 
		    </c:if>
			<c:if test="${fn:length(item.oppg.extName) != 0}">
				脉搏异常(${fn:length(item.oppg.extName)}):&nbsp;&nbsp;
				<c:forEach var="extName" items="${item.oppg.extName}" varStatus="st">
					<c:if test="${st.last}">${extName}。</c:if>
					<c:if test="${!st.last}">${extName}</c:if>
				</c:forEach> 
			</c:if>
		</td>
		</c:if>
		<td>
			<a href="" onclick="scanShyDetail('${omem.memname}','${item.memberid }','${omem.gender }','${omem.birthdate }','${omem.headaddress}','${item.eventid}');">查看</a>
		</td>
	</tr>
	</c:forEach> 
	</table>
	<br>
	<br/>
	<a href="javascript:exportSHYPreview();" target="_blank"><input type="button" class="btn-normal" value="导出测量报告"/></a>
</div>
</body>
</html>