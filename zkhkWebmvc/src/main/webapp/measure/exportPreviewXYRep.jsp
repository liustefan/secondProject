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
	<title>血压测量报告导出预览</title>
	<link rel="shortcut icon" href="<%=path %>/<%=getServletContext().getAttribute("img") %>/title_ico.ico" type="image/x-icon" />
	<link rel="stylesheet" href="<%=path %>/css/reset.css">
	<link rel="stylesheet" href="<%=path %>/css/member.css">
	<script type="text/javascript" src="<%=path %>/js/jquery-1.7.2.js"></script>
	<script type="text/javascript" src="<%=path %>/js/highcharts.js"></script>
	<script type="text/javascript" src="<%=path %>/js/exporting.js"></script>
	<script type="text/javascript" src="<%=path %>/js/highcharts-more.js"></script>
	<script type="text/javascript" src="<%=path %>/js/exportPreviewXYRep.js"></script>
	<script>
		//医生签名没有图片的时候，加载一个默认图片（此处加载的为1*1px透明图）
		function nofind(){
		var img=event.srcElement;
		img.src="${pageContext.request.contextPath }/img/namedefault.png";
		img.onerror=null; //控制onerror事件只触发一次 
		}
	
		var osbpsJson= ${osbpsJson};
		var memberid = ${omem.memberid}
		var xy_chart1_Obj, xy_chart2_0_Obj, xy_chart2_1_Obj, xy_chart2_2_Obj, xy_chart2_3_Obj, xy_chart2_4_Obj, xy_chart3_Obj, xy_chart4_Obj;
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
		<div class="header">
			<h1 class="paper-title">${omem.memname}的血压测量报告</h1>
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
			<div class="print-box">
				<label for="xy_tab1"><input id="xy_tab1" name="charts" value="xy_tab1" type="checkbox" checked="checked"/>打印</label>
			</div>
			<table class="table-border">
				<tr>
					<th colspan="2"></th>
					<th>平均值（参考范围）</th>
					<th>最大值（发生时刻）</th>
					<th>最小值（发生时刻）</th>
				</tr>
				<tr>
					<td rowspan="4" width="10%">24小时</td>
					<td width="16%">收缩压mmHg</td>
					<td>
						<c:choose>
							<c:when test="${data1[0]==0}"> -
							</c:when>
							<c:otherwise> ${data1[0]}
           					</c:otherwise>
						</c:choose> (90-140)
					</td>
					<td>
						<c:choose>
							<c:when test="${data1[4]==0}"> -
            				</c:when>
							<c:otherwise> ${data1[4]}
            				</c:otherwise>
						</c:choose> 
						<c:if test="${dates[0] != null && dates[0]!='' }">
							(${dates[0] })
						</c:if>
					</td>
					<td>
						<c:choose>
							<c:when test="${data1[8]==0}"> -
           					</c:when>
							<c:otherwise> ${data1[8]}
            				</c:otherwise>
						</c:choose> 
						<c:if test="${dates[3] != null && dates[3]!='' }">
							(${dates[3] })
						</c:if>
					</td>
				</tr>
				<tr>
					<td>舒张压mmHg</td>
					<td>
						<c:choose>
							<c:when test="${data1[1]==0}"> -
            				</c:when>
							<c:otherwise> ${data1[1]}
            				</c:otherwise>
						</c:choose> (60-90)
					</td>
					<td>
						<c:choose>
							<c:when test="${data1[5]==0}"> -
            				</c:when>
							<c:otherwise> ${data1[5]}
            				</c:otherwise>
						</c:choose> 
						<c:if test="${dates[1] != null && dates[1]!='' }">
							(${dates[1] })
						</c:if>
					</td>
					<td>
						<c:choose>
							<c:when test="${data1[9]==0}"> -
            				</c:when>
							<c:otherwise> ${data1[9]}
            				</c:otherwise>
						</c:choose> 
						<c:if test="${dates[4] != null && dates[4]!='' }">
							(${dates[4] })
						</c:if>
					</td>
				</tr>
				<tr>
					<td>平均压mmHg</td>
					<td>
						<c:choose>
							<c:when test="${data1[2]==0}"> -
            				</c:when>
							<c:otherwise> ${data1[2]}
            				</c:otherwise>
						</c:choose>
					</td>
					<td>
						<c:choose>
							<c:when test="${data1[6]==0}"> -
            				</c:when>
							<c:otherwise> ${data1[6]}
            				</c:otherwise>
						</c:choose>
					</td>
					<td>
						<c:choose>
							<c:when test="${data1[10]==0}"> -
            				</c:when>
							<c:otherwise> ${data1[10]}
            				</c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr>
					<td>脉搏次/分</td>
					<td>
						<c:choose>
							<c:when test="${data1[3]==0}"> -
            				</c:when>
							<c:otherwise> ${data1[3]}
            				</c:otherwise>
						</c:choose>(60-100)
					</td>
					<td>
						<c:choose>
							<c:when test="${data1[7]==0}"> -
            				</c:when>
							<c:otherwise> ${data1[7]}
            				</c:otherwise>
						</c:choose>
						<c:if test="${dates[2] != null && dates[2]!='' }">
							(${dates[2] })
						</c:if>
					</td>
					<td>
						<c:choose>
							<c:when test="${data1[11]==0}"> -
            				</c:when>
							<c:otherwise> ${data1[11]}
            				</c:otherwise>
						</c:choose>
						<c:if test="${dates[5] != null && dates[5]!='' }">
							(${ dates[5]})</c:if>
					</td>
				</tr>
				<tr>
					<td rowspan="4">白天（08:00~22:00）</td>
					<td>收缩压mmHg</td>
					<td>
						<c:choose>
							<c:when test="${data2[0]==0}"> -
            				</c:when>
							<c:otherwise> ${data2[0]}
            				</c:otherwise>
						</c:choose> (90-140)
					</td>
					<td>
						<c:choose>
							<c:when test="${data2[4]==0}"> -
            				</c:when>
							<c:otherwise> ${data2[4]}
           					</c:otherwise>
						</c:choose>
						<c:if test="${dates2[0] != null && dates2[0]!=''}">
							(${dates2[0]})
						</c:if>
					</td>
					<td>
						<c:choose>
							<c:when test="${data2[8]==0}"> -
           					</c:when>
							<c:otherwise> ${data2[8]}
            				</c:otherwise>
						</c:choose>
						<c:if test="${dates2[3] != null && dates2[3]!='' }">
							(${dates2[3] })
						</c:if>
					</td>
				</tr>
				<tr>
					<td>舒张压mmHg</td>
					<td>
						<c:choose>
							<c:when test="${data2[1]==0}"> -
            				</c:when>
							<c:otherwise> ${data2[1]}
            				</c:otherwise>
						</c:choose>(60-90)</td>
					<td>
						<c:choose>
							<c:when test="${data2[5]==0}"> -
            				</c:when>
							<c:otherwise> ${data2[5]}
            				</c:otherwise>
						</c:choose>
						<c:if test="${dates2[1] != null && dates2[1]!='' }">
							(${dates2[1]})
						</c:if>
					</td>
					<td>
						<c:choose>
							<c:when test="${data2[9]==0}"> -
            				</c:when>
							<c:otherwise> ${data2[9]}
            				</c:otherwise>
						</c:choose>
						<c:if test="${dates2[4] != null && dates2[4]!=''}">
							(${ dates2[4]})
						</c:if>
					</td>
				</tr>
				<tr>
					<td>平均压mmHg</td>
					<td>
						<c:choose>
							<c:when test="${data2[2]==0}"> -
            				</c:when>
							<c:otherwise> ${data2[2]}
            				</c:otherwise>
						</c:choose>
					</td>
					<td>
						<c:choose>
							<c:when test="${data2[6]==0}"> -
            				</c:when>
							<c:otherwise> ${data2[6]}
           					</c:otherwise>
						</c:choose>
					</td>
					<td>
						<c:choose>
							<c:when test="${data2[10]==0}"> -
            				</c:when>
							<c:otherwise> ${data2[10]}
            				</c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr>
					<td>脉搏次/分</td>
					<td>
						<c:choose>
							<c:when test="${data2[3]==0}"> -
            				</c:when>
							<c:otherwise> ${data2[3]}
            				</c:otherwise>
						</c:choose>(60-100)</td>
					<td>
						<c:choose>
							<c:when test="${data2[7]==0}"> -
            				</c:when>
							<c:otherwise> ${data2[7]}
            				</c:otherwise>
						</c:choose>
						<c:if test="${dates2[2] != null && dates2[2]!=''}">
							(${ dates2[2]})
						</c:if>
					</td>
					<td>
						<c:choose>
							<c:when test="${data2[11]==0}"> -
            				</c:when>
							<c:otherwise> ${data2[11]}
            				</c:otherwise>
						</c:choose>
						<c:if test="${dates2[5] != null && dates2[5]!='' }">
							(${dates2[5] })
						</c:if>
					</td>
				</tr>
				<tr>
					<td rowspan="4">夜间(22:00~08:00)</td>
					<td>收缩压mmHg</td>
					<td>
						<c:choose>
							<c:when test="${data3[0]==0}">-
            				</c:when>
							<c:otherwise>  ${data3[0]}
            				</c:otherwise>
						</c:choose> (90-140)</td>
					<td>
						<c:choose>
							<c:when test="${data3[4]==0}">-
            				</c:when>
							<c:otherwise> ${data3[4]}
            				</c:otherwise>
						</c:choose>
						<c:if test="${dates3[0] != null && dates3[0]!='' }">
							(${dates3[0] })
						</c:if>
					</td>
					<td>
						<c:choose>
							<c:when test="${data3[8]==0||data3[8]==1000}"> -
            				</c:when>
							<c:otherwise> ${data3[8]}
            				</c:otherwise>
						</c:choose>
						<c:if test="${dates3[3] != null && dates3[3]!='' }">
							(${dates3[3] })
						</c:if>
					</td>
				</tr>
				<tr>
					<td>舒张压mmHg</td>
					<td>
						<c:choose>
							<c:when test="${data3[1]==0}">-
            				</c:when>
							<c:otherwise> ${data3[1]}
            				</c:otherwise>
						</c:choose>(60-90)
					</td>
					<td>
						<c:choose>
							<c:when test="${data3[5]==0}">-
            				</c:when>
							<c:otherwise> ${data3[5]}
            				</c:otherwise>
						</c:choose>
						<c:if test="${dates3[1] != null && dates3[1]!=''}">
							(${dates3[1]})
						</c:if>
					</td>
					<td>
						<c:choose>
							<c:when test="${data3[9]==0||data3[9]==1000}">-
            				</c:when>
							<c:otherwise> ${data3[9]}
            				</c:otherwise>
						</c:choose> 
						<c:if test="${dates3[4] != null && dates3[4]!=''}">
							(${dates3[4]})
						</c:if>
					</td>
				</tr>
				<tr>
					<td>平均压mmHg</td>
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
					<td>脉搏次/分</td>
					<td>
						<c:choose>
							<c:when test="${data3[3]==0}">-
            				</c:when>
							<c:otherwise>${data3[3]}
            				</c:otherwise>
						</c:choose> (60-100)
					</td>
					<td>
						<c:choose>
							<c:when test="${data3[7]==0}">-
            				</c:when>
							<c:otherwise>${data3[7]}
            				</c:otherwise>
						</c:choose> 
						<c:if test="${dates3[2] != null && dates3[2]!=''}">
							(${dates3[2] })
						</c:if>
					</td>
					<td>
						<c:choose>
							<c:when test="${data3[11]==0||data3[11]==1000}">-
            				</c:when>
							<c:otherwise>${data3[11]}
            				</c:otherwise>
						</c:choose> 
						<c:if test="${ dates3[5] != null && dates3[5]!=''}">
							(${dates3[5]})
						</c:if>
					</td>
				</tr>
			</table>
			<div class="pie">
				<label class="f-right" for="xy_chart2_cb"><input id="xy_chart2_cb" name="charts" value="xy_chart2" type="checkbox" checked="checked"/>打印</label>
				<div id="xy_chart2_0" style="width: 500px; height: 400px"></div>
				<div id="xy_chart2_1" style="width: 250px; height: 200px"></div>
				<div id="xy_chart2_2" style="width: 250px; height: 200px"></div>
				<div id="xy_chart2_3" style="width: 250px; height: 200px"></div>
				<div id="xy_chart2_4" style="width: 250px; height: 200px"></div>
			</div>
			<div class="box1">
				<label class="f-right" for="xy_chart3_cb"><input id="xy_chart3_cb" name="charts" value="xy_chart3" type="checkbox" checked="checked"/>打印</label>
				<div id="xy_chart3" style="width: 500px;"></div>
				<label class="f-right" for="xy_chart4_cb"><input id="xy_chart4_cb" name="charts" value="xy_chart4" type="checkbox" checked="checked"/>打印</label>
				<div id="xy_chart4" style="width: 500px;"></div>
			</div>
			<label class="f-right"><input id="xy_chart1_0_cb" name="charts" value="xy_chart1_0" type="checkbox" checked="checked"/>打印</label>
			<div id="xy_chart1_0" style="min-width: 600px; "></div>
			
			<label class="f-right" ><input id="xy_chart1_1_cb" name="charts" value="xy_chart1_1" type="checkbox" checked="checked"/>打印</label>
			<div id="xy_chart1_1" style="min-width: 600px; "></div>
			<label class="f-right" ><input id="xy_chart1_2_cb" name="charts" value="xy_chart1_2" type="checkbox" checked="checked"/>打印</label>
			<div id="xy_chart1_2" style="min-width: 600px; "></div>
			 
			<label class="f-right" ><input id="xy_chart1_3_cb" name="charts" value="xy_chart1_3" type="checkbox" checked="checked"/>打印</label>
			<div id="xy_chart1_3" style="min-width: 600px; "></div>
			 
			<table class="table-normal">
				<tr>
					<th>测量时间</th>
					<th>测量点</th>
					<th>血压(mmhg)</th>
					<th>平均压</th>
					<th>脉压差</th>
					<th>双乘积指数</th>
					<th>脉率(bpm)</th>
				</tr>
				<c:forEach items="${osbps}" var="osbp">
					<tr>
					<td><fm:formatDate value="${osbp.testtime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" dateStyle="long"/></td>
					<td><c:if test="${osbp.timeperiod==0}">其它</c:if> 
						 <c:if test="${osbp.timeperiod==1}">起床后2小时</c:if> 
						<c:if test="${osbp.timeperiod != 1 && osbp.timeperiod != 0}">睡觉前</c:if></td>
						<td>${osbp.sbp }/${osbp.dbp }</td>
					<td><fm:formatNumber type="number" value="${(osbp.sbp + 2 * osbp.dbp) / 3 - 0.5}" maxFractionDigits="0"/></td>
					<td>${osbp.sbp - osbp.dbp}</td>
					<td>${osbp.sbp * osbp.pulserate}</td>
					<td>${osbp.pulserate}</td>
				</tr>
				</c:forEach>
			</table>
			<div class="clear-fix m-10">
				<div class="fl w49">
					<label for="xy_tab2"><input id="xt_tab2" name="charts" value="xy_tab2" type="checkbox" checked="checked"/>打印</label>
				</div>
				<div>数据记录天数：</div>
			</div>
		</div>
		<div class="footer-box">
			<p>*声明：本报告仅供临床医师参考，不做临床诊断证明*</p>
			<div class="doc-sign">
				审核医生：	&nbsp;&nbsp;&nbsp;&nbsp;
 			</div>
		</div>
	</div>
	<div class="btns">
		<input type="button" value="导出" class="btn-normal" onclick="exportWord();">
		<input type="button" class="btn-normal" value="取消" onclick="javascript: window.close();">
	</div>
</body>
</html>
