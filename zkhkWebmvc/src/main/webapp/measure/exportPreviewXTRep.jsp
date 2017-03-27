<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>血糖测量报告导出预览</title>
	<link rel="shortcut icon" href="<%=path %>/<%=getServletContext().getAttribute("img") %>/title_ico.ico" type="image/x-icon" />
	<link rel="stylesheet" href="<%=path %>/css/reset.css">
	<link rel="stylesheet" href="<%=path %>/css/member.css">
	<script type="text/javascript" src="<%=path %>/js/jquery-1.7.2.js"></script>
	<script type="text/javascript" src="<%=path %>/js/highcharts.js"></script>
	<script type="text/javascript" src="<%=path %>/js/exporting.js"></script>
	<script type="text/javascript" src="<%=path %>/js/highcharts-more.js"></script>
	<script type="text/javascript" src="<%=path %>/js/exportPreviewXTRep.js"></script>
	<script>
		//医生签名没有图片的时候，加载一个默认图片（此处加载的为1*1px透明图）
		function nofind(){
		var img=event.srcElement;
		img.src="${pageContext.request.contextPath }/img/namedefault.png";
		img.onerror=null; //控制onerror事件只触发一次 
		}
		var memberid = '${omem.memberid}';
		var obsrsJson = ${obsrsJson};
		var xt_chart1_Obj, xt_chart2_Obj, xt_chart3_Obj, xt_chart4_Obj, xt_chart5_List = [];
	</script>
	<style type="text/css">
		body {
			font-size: 14px;
		}
		
		.main {
			/*width: 1024px;*/
			margin: 0 auto;
			text-align: center;
			border: 1px solid;
		}
		
		.pie {
			width: 500px;
			height: 800px;
			float: left;
		}
		
		.pie div {
			float: left;
		}
		
		.box1 {
			width: 500px;
			float: left;
		}
		
		.title {
			text-align: center;
		}
		
		.table {
			width: 100%;
			padding: 15px 50px;
		}
		
		.table td {
		text-indent: 1em;
		}
		
		.resultContent {
			padding: 5px 10px;
		}
		
		.clear {
			clear: both;
		}
		
		.btns {
			position: fixed;
			bottom: 10px;
			right: 50px;
		}
		
		.table-normal tr td {
			font-size: 14px;
		}
		
		.f-left {
			float: left;
		}
		
		.f-right {
			float: right;
		}
		
		.doctorName {
		    max-width: 64px;
		    max-height: 64px;
		    border: none;
		    outline: none;
		}
		
		#xt_tab1 {
			overflow: hidden;
		}
		
		.pieTitle {
		  	text-align: center;
		    font-weight: bold;
		    font-size: 16px;
		    font-family: Microsoft YaHei;
	  	}
	</style>
</head>

<body style="width: 1024px; margin: 0 auto;" onload="getJson();">
	<div class="report-wrap">
		<%-- <h1 class="paper-title">${omem.memname}的测量报告</h1>
		<div class="user-info">
			<table class="table">
				<tr>
					<td>姓名：${omem.memname}</td>
					<td>性别：${omem.gender=='1'?'男': omem.gender=='2'?'女':'未知'}</td>
					<td>年龄：${age}</td>
					<td>联系电话： ${omem.tel}</td>
				</tr>
				<tr>
					<td>身高： <c:if test="${not empty omem.physical.height}">${omem.physical.height}cm</c:if></td>
					<td>体重：<c:if test="${not empty omem.physical.weight}">${omem.physical.weight}Kg</c:if></td>
					<td>地址：${omem.address}</td>
					<td></td>
				</tr>
				<tr>
					<td colspan="2">
					疾病情况：
					</td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>汇总分析</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td colspan="4">
						<div class="resultContent">
						</div>
					</td>
				</tr>
			</table>
		</div> --%>
	<div class="report-wrap">
		<div class="header">
				<h1 class="paper-title">${omem.memname}的血糖测量报告</h1>
				<div class="user-info">
					<span>姓名：<i>${omem.memname}</i></span> 
					<span>ID：<i></i></span> 
					<span>性别：<i>${omem.gender=='1'?'男': omem.gender=='2'?'女':'未知'}</i></span> 
					<span>年龄：${age }</span> 
					<span>身高：<i><c:if test="${not empty omem.physical.height}">${omem.physical.height}cm</c:if></i></span> 
					<span>体重：<i><c:if test="${not empty omem.physical.weight}">${omem.physical.weight}Kg</c:if></i></span> 
					<span>报告编号：<i></i></span>
				</div>
			</div>
		<div class="report-content">
			<div class="celiang-summary">
				<span>测量时间：<fm:formatDate value="${startMeasTime }" pattern="yyyy-MM-dd"/>至<fm:formatDate value="${endMeasTime }" pattern="yyyy-MM-dd"/>
				</span> 
				<span>历时天数：${lastDay }天</span>
				<span>数据记录天数：${recordDay }</span> 
				<span>报告产生时间：<fm:formatDate value="${generTime }" pattern="yyyy-MM-dd HH:mm:ss"/></span> 
				<input id="generTime" type="hidden" value="<fm:formatDate value='${generTime }' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<span>报告审核时间：</span>
			</div>
			<label class="f-right" for="xt_tab1_cb"><input id="xt_tab1_cb" name="charts" value="xt_tab1" type="checkbox" checked="checked"/>打印</label>
			<div class="xuetang-box clear-fix" id="xt_tab1">
				<table class="fl">
					<tr>
						<td colspan="4"><h2>最大血糖值</h2></td>
					</tr>
					<tr>
						<th>项目</th>
						<th>测量时间</th>
						<th>血糖值(mmol/L)</th>
						<th>正常值范围(mmol/L)</th>
					</tr>
					<c:forEach items="${maxData}" var="item">
						<tr>
							<td>${ item.timeperiod}</td>
							<td><fm:formatDate value="${item.testtime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" dateStyle="long"/></td>
							<td>${item.bsvalue}</td>
							<td>${item.nv.min}~${item.nv.max}</td>
						</tr>
					</c:forEach>
					${maxObsr }
				</table>
				<table class="fr">
					<tr>
						<td colspan="4"><h2>最小血糖值</h2></td>
					</tr>
					<tr>
						<th>项目</th>
						<th>测量时间</th>
						<th>血糖值(mmol/L)</th>
						<th>正常值范围(mmol/L)</th>
					</tr>
					<c:forEach items="${minData}" var="item">
						<tr>
							<td>${item.timeperiod }</td>
							<td><fm:formatDate value="${item.testtime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" dateStyle="long"/></td>
							<td>${item.bsvalue}</td>
							<td>${item.nv.min}~${item.nv.max}</td>
						</tr>
					</c:forEach>
					${minObsr }
				</table>
			</div>
			<div class="hr-line"></div>
			<div class="xuetang-box clear-fix">
				<table class="fl">
					<tr>
						<td colspan="4"><h2>血糖平均值</h2></td>
					</tr>
					<tr>
						<th>项目</th>
						<th>血糖值(mmol/L)</th>
						<th>正常值范围(mmol/L)</th>
					</tr>
					<c:forEach items="${avgData}" var="item">
						<tr>
							<td>${item.timeperiod }</td>
							<td>${item.bsvalue}</td>
							<td>${item.nv.min}~${item.nv.max}</td>
						</tr>
					</c:forEach>
					<tr style="border-top: 1px #ccc solid;">
						<td>血糖平均值</td>
						<td>${avgObsr }</td>
						<td></td>
					</tr>
				</table>
				<table class="fr">
					<tr>
						<td colspan="4"><h2>血糖异常统计</h2></td>
					</tr>
					<tr>
						<th width="15%">项目</th>
						<th>血糖过低次数</th>
						<th>血糖过高次数</th>
						<th>过低比率</th>
						<th>过高比率</th>
					</tr>
					<c:forEach items="${exData}" var="item">
						<tr>
							<td>${item.timePeriodName }</td>
							<td>${item.tooLowTimes}</td>
							<td>${item.tooHighTimes}</td>
							<td>${item.tooLowRate}%</td>
							<td>${item.tooHighRate}%</td>
						</tr>
					</c:forEach>
					${exObsr}
				</table>
			</div>
			<label class="f-right" for="xt_chart1_cb"><input id="xt_chart1_cb" name="charts" value="xt_chart1" type="checkbox" checked="checked"/>打印</label>
			<div id="xt_chart1" class="clear" style="width: 1000px; height: 400px"></div>
			<div  class="f-left">
				<label class="f-right" for="xt_chart2_cb"><input id="xt_chart2_cb" name="charts" value="xt_chart2" type="checkbox" checked="checked"/>打印</label>
				<div id="xt_chart2" style="width: 500px; height: 400px"></div>
			</div>
			<div class="f-left">
				<label class="f-right" for="xt_chart3_cb"><input id="xt_chart3_cb" name="charts" value="xt_chart3" type="checkbox" checked="checked"/>打印</label>
				<div id="xt_chart3" style="width: 500px;"></div>
			</div>
			<div class="f-left">
				<label class="f-right" for="xt_chart4_cb"><input id="xt_chart4_cb" name="charts" value="xt_chart4" type="checkbox" checked="checked"/>打印</label>
				<div id="xt_chart4"  style="width: 500px"></div>
			</div>
			<div class="GLUPies f-left" style="width: 500px">
				<div style="overflow: hidden;"><label class="f-right" for="xt_chart5_cb"><input id="xt_chart5_cb" name="charts" value="xt_chart5" type="checkbox" checked="checked"/>打印</label></div>
				<p class="pieTitle">血糖饼图</p>
				<div id="xt_chart5_0" class="f-left"  style="width: 250px; height: 150px"></div>
				<div id="xt_chart5_1" class="f-left"  style="width: 250px; height: 150px"></div>
				<div id="xt_chart5_2" class="f-left"  style="width: 250px; height: 150px"></div>
				<div id="xt_chart5_3" class="f-left"  style="width: 250px; height: 150px"></div>	
				<div id="xt_chart5_4" class="f-left"  style="width: 250px; height: 150px"></div>
				<div id="xt_chart5_5" class="f-left"  style="width: 250px; height: 150px"></div>
				<div id="xt_chart5_6" class="f-left"  style="width: 250px; height: 150px"></div>
				<div id="xt_chart5_7" class="f-left"  style="width: 250px; height: 150px"></div>
				<div id="xt_chart5_8" class="f-left"  style="width: 250px; height: 150px"></div>
			</div>
			<table class="table-normal">
				<tr>
					<th>测量时间</th>
					<th>测量点</th>
					<th>血糖值(mmhg)</th>
				</tr>
				<c:forEach items="${obsrs}" var="obsr">
					<tr>
						<td><fm:formatDate value="${obsr.testtime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" dateStyle="long"/></td>
						<td>${obsr.timeperiod}</td>
						<td>${obsr.bsvalue}</td>
					</tr>
				</c:forEach>
			</table>
			<div class="m-10 clear-fix">
				<div class="fl w49">
					<label for="xt_tab2_cb"><input id="xt_tab2_cb" name="charts" value="xt_tab2" type="checkbox" checked="checked"/>打印</label>
				</div>
				<div>数据记录天数：</div>
			</div>
		</div>
		<div class="footer-box">
			<p>*声明：本报告仅供临床医师参考，不做临床诊断证明*</p>
			<div class="doc-sign">
				审核医生：  	&nbsp;&nbsp;&nbsp;&nbsp;
 					 </div>
			<div class="print-page"></div>
		</div>
	</div>
	</div>
	<div class="btns">
		<input type="button" value="导出" class="btn-normal" onclick="exportWord();">
		<input type="button" class="btn-normal" value="取消" onclick="javascript: window.close();">
	</div>
</body>
</html>
