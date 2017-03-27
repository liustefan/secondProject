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
	<title>血压测量报告</title>
	<link rel="shortcut icon" href="<%=path %>/<%=getServletContext().getAttribute("img") %>/title_ico.ico" type="image/x-icon" />
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/css/vip.css">
	<script>
		var memberid = "${omem.memberid}";
		// 全局变量 用于singleOsbpRep.js
		var basePath = '<%=basePath%>';
		var osbpsJson= ${osbpsJson};
	</script>
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer/layer.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/highcharts.js"></script>
	<script type="text/javascript" src="<%=path %>/js/exporting.js"></script>
	<script type="text/javascript" src="<%=path %>/js/xueyaRep.js"></script>
	<script type="text/javascript" src="<%=path %>/js/kindeditor/kindeditor.js"></script>
	<script type="text/javascript" src="<%=path %>/js/kindeditor/lang/zh_CN.js"></script>
	<%-- <script type="text/javascript" src="<%=path %>/js/popupPage1.js"></script> --%>
	<script type="text/javascript">
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
		
		function exportXYPreview(){
			post("../bloodPressure/getReportPreview",{osbpsJson:JSON.stringify(${osbpsJson}),memberid:${omem.memberid},generTime:$("#generTime").val()});
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
			display:block; 
			margin-bottom:5px;
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
	<div id="container">
		<h4 class="title-report">${omem.memname }血压测量报告</h4>
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
				<div id="chart1" style="height:400px;"></div>
				<div id="chart2" style="height:400px; margin-top:10px;">
					<div id="chart2_1" style="height:200px;"></div>
					<div id="chart2_2" style="height:200px;"></div>
					<div id="chart2_3" style="height:200px;"></div>
					<div id="chart2_4" style="height:200px;"></div>
				</div>
			</div>
			<div id="part2">
				<div id="chart3" style="height:400px;"></div>
				<div id="chart4" style="height:400px;margin-top:10px;"></div>
			</div>
		</div>
		<br/>
		<table class="table-border">
			<tr>
				<td colspan="2"></td>
				<td>平均值(参考范围)</td>
				<td>最大值(发生时刻)</td>
				<td>最小值(发生时刻)</td>
			</tr>
			<tr>
				<td rowspan="4">24小时</td>
				<td>收缩压</td>
				<td>
				<c:choose>
	            <c:when test="${data1[0]==0}"> -
	            </c:when>
	              <c:otherwise> ${data1[0]}
	            </c:otherwise>
	           </c:choose>
	           (90-140)</td>
				<td>	
				<c:choose>
	            <c:when test="${data1[4]==0}"> -
	            </c:when>
	              <c:otherwise> ${data1[4]}
	            </c:otherwise>
	           </c:choose>
				<c:if test='${dates[0] != null && dates[0] != ""}'>(${dates[0]})</c:if></td>
				<td>
				<c:choose>
	            <c:when test="${data1[8]==0 ||data1[8]==1000}"> -
	            </c:when>
	              <c:otherwise> ${data1[8]}
	            </c:otherwise>
	           </c:choose>
				<c:if test='${dates[3] != null && dates[3] != ""}'>(${dates[3]})</c:if></td>
			</tr>
			<tr>
				<td>舒张压</td>
				<td><c:choose>
	            <c:when test="${data1[1]==0}"> -
	            </c:when>
	              <c:otherwise> ${data1[1]}
	            </c:otherwise>
	           </c:choose>
	           (60-90)</td>
				<td><c:choose>
	            <c:when test="${data1[5]==0}"> -
	            </c:when>
	              <c:otherwise> ${data1[5]}
	            </c:otherwise>
	           </c:choose>
	         <c:if test='${dates[1] != null && dates[1] != ""}'>(${dates[1]})</c:if></td>
				<td><c:choose>
	            <c:when test="${data1[9]==0 ||data1[9]==1000}"> -
	            </c:when>
	              <c:otherwise> ${data1[9]}
	            </c:otherwise>
	           </c:choose>
	           <c:if test='${dates[4] != null && dates[4] != ""}'>(${dates[4]})</c:if></td>
			</tr>
			<tr>
				<td>平均压</td>
				<td><c:choose>
	            <c:when test="${data1[2]==0}"> -
	            </c:when>
	              <c:otherwise> ${data1[2]}
	            </c:otherwise>
	           </c:choose></td>
				<td><c:choose>
	            <c:when test="${data1[6]==0}"> -
	            </c:when>
	              <c:otherwise> ${data1[6]}
	            </c:otherwise>
	           </c:choose></td>
				<td><c:choose>
	            <c:when test="${data1[10]==0 ||data1[10]==1000}"> -
	            </c:when>
	              <c:otherwise> ${data1[10]}
	            </c:otherwise>
	           </c:choose></td>
			</tr>
			<tr>
				<td>脉搏</td>
				<td><c:choose>
	            <c:when test="${data1[3]==0}"> -
	            </c:when>
	              <c:otherwise> ${data1[3]}
	            </c:otherwise>
	           </c:choose>(60-100)</td>
				<td><c:choose>
	            <c:when test="${data1[7]==0}"> -
	            </c:when>
	              <c:otherwise> ${data1[7]}
	            </c:otherwise>
	           </c:choose><c:if test='${dates[2] != null && dates[2] != ""}'>(${dates[2]})</c:if></td>
				<td><c:choose>
	            <c:when test="${data1[11]==0 ||data1[11]==1000}"> -
	            </c:when>
	              <c:otherwise> ${data1[11]}
	            </c:otherwise>
	           </c:choose><c:if test='${dates[5] != null && dates[5] != ""}'>(${dates[5]})</c:if></td>
			</tr>
			<tr>
				<td rowspan="4">白天</td>
				<td>收缩压</td>
				<td>
				<c:choose>
	            <c:when test="${data2[0]==0}"> -
	            </c:when>
	              <c:otherwise> ${data2[0]}
	            </c:otherwise>
	           </c:choose>
	           (90-140)</td>
				<td><c:choose>
	            <c:when test="${data2[4]==0}"> -
	            </c:when>
	              <c:otherwise> ${data2[4]}
	            </c:otherwise>
	           </c:choose> <c:if test='${dates2[0] != null && dates2[0] != ""}'>(${dates2[0]})</c:if></td>
				<td><c:choose>
	            <c:when test="${data2[8]==0 ||data2[8]==1000}"> -
	            </c:when>
	              <c:otherwise> ${data2[8]}
	            </c:otherwise>
	           </c:choose><c:if test='${dates2[3] != null && dates2[3] != ""}'>(${dates2[3]})</c:if></td>
			</tr>
			<tr>
				<td>舒张压</td>
				<td><c:choose>
	            <c:when test="${data2[1]==0}"> -
	            </c:when>
	              <c:otherwise> ${data2[1]}
	            </c:otherwise>
	           </c:choose>(60-90)</td>
				<td><c:choose>
	            <c:when test="${data2[5]==0}"> -
	            </c:when>
	              <c:otherwise> ${data2[5]}
	            </c:otherwise>
	           </c:choose><c:if test='${dates2[1] != null && dates2[1] != ""}'>(${dates2[1]})</c:if></td>
				<td><c:choose>
	            <c:when test="${data2[9]==0 ||data2[9]==1000}"> -
	            </c:when>
	              <c:otherwise> ${data2[9]}
	            </c:otherwise>
	           </c:choose><c:if test='${dates2[4] != null && dates2[4] != ""}'>(${dates2[4]})</c:if></td>
			</tr>
			<tr>
				<td>平均压</td>
				<td><c:choose>
	            <c:when test="${data2[2]==0}"> -
	            </c:when>
	              <c:otherwise> ${data2[2]}
	            </c:otherwise>
	           </c:choose></td>
				<td><c:choose>
	            <c:when test="${data2[6]==0}"> -
	            </c:when>
	              <c:otherwise> ${data2[6]}
	            </c:otherwise>
	           </c:choose></td>
				<td><c:choose>
	            <c:when test="${data2[10]==0 ||data2[10]==1000}"> -
	            </c:when>
	              <c:otherwise> ${data2[10]}
	            </c:otherwise>
	           </c:choose></td>
			</tr>
			<tr>
				<td>脉搏</td>
				<td><c:choose>
	            <c:when test="${data2[3]==0}"> -
	            </c:when>
	              <c:otherwise> ${data2[3]}
	            </c:otherwise>
	           </c:choose>(60-100)</td>
				<td><c:choose>
	            <c:when test="${data2[7]==0}"> -
	            </c:when>
	              <c:otherwise> ${data2[7]}
	            </c:otherwise>
	           </c:choose><c:if test='${dates2[2] != null && dates2[2] != ""}'>(${dates2[2]})</c:if></td>
				<td><c:choose>
	            <c:when test="${data2[11]==0 ||data2[11]==1000}"> -
	            </c:when>
	              <c:otherwise> ${data2[11]}
	            </c:otherwise>
	           </c:choose><c:if test='${dates2[5] != null && dates2[5] != ""}'>(${dates2[5]})</c:if></td>
			</tr>
			<tr>
				<td rowspan="4">夜间</td>
				<td>收缩压</td>
				<td>
				<c:choose>
	            <c:when test="${data3[0]==0}">-
	            </c:when>
	              <c:otherwise>  ${data3[0]}
	            </c:otherwise>
	            </c:choose>
	            (90-140)
	           </td>
				<td>		
				<c:choose>
	            <c:when test="${data3[4]==0}">-
	            </c:when>
	             <c:otherwise> ${data3[4]}
	            </c:otherwise>
	            </c:choose>
	            <c:if test='${dates3[0] != null && dates3[0] != ""}'>(${dates3[0]})</c:if></td>
				<td>	<c:choose>
	            <c:when test="${data3[8]==0||data3[8]==1000}"> -
	            </c:when>
	             <c:otherwise> ${data3[8]}
	            </c:otherwise>
	            </c:choose><c:if test='${dates3[3] != null && dates3[3] != ""}'>(${dates3[3]})</c:if></td>
			</tr>
			<tr>
				<td>舒张压</td>
				<td>	<c:choose>
	            <c:when test="${data3[1]==0}">-
	            </c:when>
	             <c:otherwise> ${data3[1]}
	            </c:otherwise>
	            </c:choose>(60-90)</td>
				<td>
				<c:choose>
	            <c:when test="${data3[5]==0}">-
	            </c:when>
	             <c:otherwise> ${data3[5]}
	            </c:otherwise>
	            </c:choose>
	            <c:if test='${dates3[1] != null && dates3[1] != ""}'>(${dates3[1]})</c:if></td>
				<td>	
				<c:choose>
	            <c:when test="${data3[9]==0||data3[9]==1000}">-
	            </c:when>
	             <c:otherwise> ${data3[9]}
	            </c:otherwise>
	            </c:choose>
	            <c:if test='${dates3[4] != null && dates3[4] != ""}'>(${dates3[4]})</c:if></td>
			</tr>
			<tr>
				<td>平均压</td>
				<td>
				<c:choose>
	            <c:when test="${data3[2]==0}">-
	            </c:when>
	             <c:otherwise>${data3[2]}
	            </c:otherwise>
	            </c:choose>
	            </td>
				<td>	
				<c:choose>
	            <c:when test="${data3[6]==0}">-
	            </c:when>
	             <c:otherwise>${data3[6]}
	            </c:otherwise>
	            </c:choose>
	         	</td>
				<td>
				<c:choose>
	            <c:when test="${data3[10]==0||data3[10]==1000}">-
	            </c:when>
	             <c:otherwise>${data3[10]}
	            </c:otherwise>
	            </c:choose>
	      		</td>
			</tr>
			<tr>
				<td>脉搏</td>
				<td><c:choose>
	            <c:when test="${data3[3]==0}">-
	            </c:when>
	             <c:otherwise>${data3[3]}
	            </c:otherwise>
	            </c:choose>
	            (60-100)</td>
				<td>
				<c:choose>
	            <c:when test="${data3[7]==0}">-
	            </c:when>
	             <c:otherwise>${data3[7]}
	            </c:otherwise>
	            </c:choose>
	            <c:if test='${dates3[2] != null && dates3[2] != ""}'>(${dates3[2]})</c:if></td>
				<td><c:choose>
	            <c:when test="${data3[11]==0||data3[11]==1000}">-
	            </c:when>
	             <c:otherwise>${data3[11]}
	            </c:otherwise>
	            </c:choose>
	            <c:if test='${dates3[5] != null && dates3[5] != ""}'>(${dates3[5]})</c:if></td>
			</tr>
		</table>
		<div id="chart5" style="height:350px;"></div>
		<div id="chart6" style="height:350px;"></div>
		<div id="chart7" style="height:350px;"></div>
		<div id="mypulse" style="min-width:700px; height:400px;"></div>
		<br/>
		<table class="table-border">
			 	<tr>
				 	<td>测量时间</td>
				 	<td>测量方式</td>
				 	<td>时间类型</td>
				 	<td>血压</td>
				 	<td>平均压</td>
				 	<td>脉压差</td>
				 	<!-- <td>双乘积指数</td> -->
				 	<td>脉搏率</td>
				 	<td>操作</td>
			 	</tr>
			 	<c:forEach var="item" items="${osbps}" varStatus="st">
			 		<tr>
				 		<td><fm:formatDate value="${item.testtime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" dateStyle="long"/></td>
				 		<td>${item.devicecode}</td>
				 		<td>		
	 						<c:choose>
								<c:when test="${item.timeperiod == 0}">
									其他
								</c:when>
								<c:when test="${item.timeperiod == 1}">
									起床后2小时
								</c:when>
								<c:otherwise>
									睡觉前
								</c:otherwise>
							</c:choose>
				 		</td><td>${item.sbp }/${item.dbp }</td>
				 		<td>
				 			<!-- 由于<fm：formatNumber本身有bug，导致如94.5、104.5等数字 四舍五入去掉小数位，得到的却是94、104这些数字，故做如下处理-->
				 			<c:if test="${(item.sbp + 2 * item.dbp) % 3 == 0}">
				 				<fm:formatNumber type="number" value="${(item.sbp + 2 * item.dbp) / 3}" maxFractionDigits="0"/>
				 			</c:if>
				 			<c:if test="${(item.sbp + 2 * item.dbp) % 3 != 0}">
				 				<fm:formatNumber type="number" value="${(item.sbp + 2 * item.dbp) / 3 - 0.5}" maxFractionDigits="0"/>
				 			</c:if>
				 		</td>
				 		<td>${item.sbp - item.dbp}</td>
						<%-- <td>${item.sbp * item.pulserate}</td> --%>
				 		<td>${item.pulserate}</td>
				 		<td>
				 			<a href="${pageContext.request.contextPath}/bloodPressure/showSingleBloodPress?memberId=${item.memberid}&eventId=${item.eventid}" target="_blank">查看</a>
				 		</td>
			 		</tr>
			 	</c:forEach> 
			 </table>
		  <br/>
	</div>
	<a href="javascript:exportXYPreview();" target="_blank"><input type="button" class="btn-normal" value="导出测量报告"/></a>
</div>
</body>
</html>