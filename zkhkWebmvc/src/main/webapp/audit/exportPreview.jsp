<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>	
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>导出预览</title>
	<link rel="shortcut icon" href="<%=path %>/<%=getServletContext().getAttribute("img") %>/title_ico.ico" type="image/x-icon" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/member.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/highcharts.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/exporting.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/highcharts-more.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/exportPreviewChart.js"></script>
	<script>
		//医生签名没有图片的时候，加载一个默认图片（此处加载的为1*1px透明图）
		function nofind(){
		var img=event.srcElement;
		img.src="${pageContext.request.contextPath }/img/namedefault.png";
		img.onerror=null; //控制onerror事件只触发一次 
		}
		var docentry_3 = '<%=request.getAttribute("docentry_3")%>';
		var docentry_4 = '<%=request.getAttribute("docentry_4")%>';
		var optId_1 = '<%=request.getAttribute("optId_1")%>';
		var optId_2 = '<%=request.getAttribute("optId_2")%>';
		var optId_3 = '<%=request.getAttribute("optId_3")%>';
		var optId_4 = '<%=request.getAttribute("optId_4")%>';
		var id_1 = '<%=request.getAttribute("id_1")%>';
		var id_2 = '<%=request.getAttribute("id_2")%>';
		var id_3 = '<%=request.getAttribute("id_3")%>';
		var id_4 = '<%=request.getAttribute("id_4")%>';
		var memberid = '<%=request.getAttribute("memberid")%>';
		
		var xy_chart1_Obj, xy_chart2_0_Obj, xy_chart2_1_Obj, xy_chart2_2_Obj, xy_chart2_3_Obj, xy_chart2_4_Obj, xy_chart3_Obj, xy_chart4_Obj,
	    xt_chart1_Obj, xt_chart2_Obj, xt_chart3_Obj, xt_chart4_Obj, xt_chart5_List = [],
	    shy_chart1_Obj, shy_chart2_Obj, shy_chart4_Obj, shy_chart5_Obj,shy_chart6_List = [],shy_chart3_List = [],
	    xd_chart1_Obj,xd_chart2_Obj,xd_chart3_List = [];
		
		var flag_1 = false;
		var flag_2 = false;
		var flag_3 = false;
		var flag_4 = false;
		/* console.log(optId_1,optId_2,optId_3,optId_4); */
		if(optId_1 == 1){
			flag_1 = true;
		}
		
		if(optId_2 == 2){
			flag_2 = true;
		}
		
		if(optId_3 == 3){
			flag_3 = true;
		}
		
		if(optId_4 == 4){
			flag_4 = true;
		}
		
		/* function getExcData(docentry, excObj, page,id, i ) {
			 $.post("../summaryReport/getPreviewAbecgData",
				{docentry : docentry,
				 objectId : excObj.objectId[page],
				 measTime : excObj.extMilli[page],
				},
				function(data){
					var obj = JSON.parse(data);
					//console.log(obj);
					if(!obj.data || obj.data.length <= 0) {
						return;
					}
					var svg = createABEcg(id,i, excObj, page, obj,docentry);
					if(id == "shy_chart3_") {
						shy_chart3_List[i] = svg;
					}else {
						xd_chart3_List[i] = svg;
					}
			}); 
		} */
		
	 	function getExcData1(excObj, page,id, i ) {
			console.log(excObj);
			var temp = excObj.data[page];
			
			 $.post("../summaryReport/getPreviewAbecgData",
				{docentry : temp.docentry,
				 objectId : temp.objectIds,
				 measTime : temp.extMss,
				},
				function(data){
					if(data != "null" && data != ""){
						var obj = JSON.parse(data);
						if(!obj.data || obj.data.length <= 0) {
							return;
						}
						var svg = createABEcg(id,i, excObj, page, obj);
						if(id == "shy_chart3_") {
							shy_chart3_List[i] = svg;
						}else {
							xd_chart3_List[i] = svg;
						}
				}
			}); 
		} 
		
		function formatData(obj) {
			var result, arr = [] ;
			for(var i in obj) {
				result = {type: '', data: []};
				result.type = i; // 异常名称
				for(var j in obj[i]) {
					result.celxName = obj[i][j].expName; // 异常缩写
					for(var k = 0; k< obj[i][j].objectIds.length; k++) {
						result.data.push({
							docentry: obj[i][j].docentry,
							extMss: obj[i][j].extMss[k],
							extimes: obj[i][j].extimes[k],
							objectIds: obj[i][j].objectIds[k]
						});
					}
				}
				arr.push(result);
			}
			return arr;
			
		}
	$(function(){
		//三合一 
		if(flag_3) {
			var ecg12s_3 = <%=request.getAttribute("ecg12s_3")%>; 
			var json_3 = formatData(ecg12s_3);
			$(json_3).each(function(i, e) {
				var dome = $("#shy_chart3_box");			
				dome.append('<div class="imgholder m-10" style="overflow:hidden;">');
				dome.append('<label class="fr" for="shy_chart3_' + i + '_cb"> <input id="shy_chart3_' + i + '_cb" name="charts" value="shy_chart3" cindex= ' + i+'  type="checkbox" checked="checked" />打印</label>');
				dome.append('<div id="shy_chart3_' + i + '" style="height: 300px;"></div></div>');
				
				getExcData1(e, 0, 'shy_chart3_' , i);
			});
		}
		//动态心电
		if(flag_4) {
			var ecg12s_4 = <%=request.getAttribute("ecg12s_4")%>;
			var json_4 = formatData(ecg12s_4);
			$(json_4).each(function(i, e) {
				var dome = $("#xd_chart3_box");		
				dome.append('<div class="imgholder m-10" style="overflow:hidden;">');
				dome.append('<label class="fr" for="xd_chart3_' + i + '_cb"> <input id="xd_chart3_' + i + '_cb" name="charts" value="xd_chart3" cindex= ' + i+' type="checkbox" checked="checked" />打印</label>');
				dome.append('<div id="xd_chart3_' + i + '" style="height: 300px;"></div></div>');
				
				getExcData1(e, 0, 'xd_chart3_', i);
			});
		}
		});
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

<body style="width: 1024px; margin: 0 auto;" onload="getJson(flag_1,flag_2,flag_3,flag_4);">
	<div class="report-wrap">
		<h1 class="paper-title">${reportSumName}</h1>
		<div class="user-info">
			<table class="table">
				<tr>
					<td>姓名：${omem.memname}</td>
					<td>性别：${omem.gender}</td>
					<td>年龄：${age}</td>
					<%-- <td>籍贯：${omem.nativeAddr}</td> --%>
					<td>联系电话： ${omem.tel}</td>
				</tr>
				<tr>
					<%-- <td>身份证号：${omem.idCard}</td> --%>
					<td>身高： ${omem.physical.height}cm</td>
					<td>体重：${omem.physical.weight}kg</td>
					<td>地址：${omem.address}</td>
					<td></td>
				</tr>
				<tr>
					<td colspan="2">
					疾病情况：
 					<%-- <c:forEach items="${ omem.mem3s}" >
						${diseaseName }&nbsp;&nbsp;&nbsp;
					</c:forEach>  --%>
					</td>
					<td></td>
					<td></td>
				</tr>
				<!-- <tr>
					<td colspan="4">用药情况：未知</td>
				</tr> -->
				<tr>
					<td>汇总分析</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td colspan="4">
						<div class="resultContent">
							<c:forEach items="${osmr.singleReportList }" var="singleReport" >
								<c:forEach items="${singleReport.auditList }" varStatus="st">
									<c:if test="${st.first}"><p>${auditDesc }</p></c:if>
								</c:forEach>
							</c:forEach>
						</div>
					</td>
				</tr>
			</table>
		</div>
		<c:if test="${omrr_1.optId == 1 }">
		<div class="header">
			<h1 class="paper-title">${omem.memname}${subTempName_1}</h1>
			<div class="user-info">
				<span>姓名：<i>${omem.memname}</i></span> 
				<span>ID：<i></i></span> 
				<span>性别：<i>${omem.gender}</i></span>
				<span>年龄：</span> 
				<span>身高：<i>${omem.physical.height}cm</i></span> 
				<span>体重：<i>${omem.physical.weight}Kg</i></span> 
				<span>报告编号：<i>${omrr_1.reportCode}</i></span>
			</div>
		</div>
		<div class="report-content">
			<div class="celiang-summary">
				<span>测量时间：<fm:formatDate value="${omrr_1.measTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" dateStyle="long"/>
					至 <fm:formatDate value="${omrr_1.measTermTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" dateStyle="long"/>
				</span> 
				<span>历时天数：${lastDay}天</span>
				<span>数据记录天数：${omrr_1.measNum}</span> 
				<%-- <span>用药情况：未知</span> --%>
				<span>报告产生时间：<fm:formatDate value="${omrr_1.grenerTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" dateStyle="long"/></span> 
				<span>报告审核时间：<fm:formatDate value="${oasr.auditDatetime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" dateStyle="long"/></span>
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
				<div>数据记录天数：${osbpsCount}</div>
			</div>
		</div>
		<div class="footer-box">
			<p>*声明：本报告仅供临床医师参考，不做临床诊断证明*</p>
			<div class="doc-sign">
				审核医生：${doctor.docname }
					  	&nbsp;&nbsp;&nbsp;&nbsp;
 					  	<img class="doctorName"  src="${pageContext.request.contextPath }/image/getImage?uniqueId=${doctor.signaddress}"/>
 			</div>
			<div class="print-page">${osbpCount}/${total}</div>
		</div>
	
	</c:if>
	
	<c:if test="${omrr_2.optId == 2 }">
	<div class="report-wrap">
		<div class="header">
				<h1 class="paper-title">${omem.memname}${subTempName_2}</h1>
				<div class="user-info">
					<span>姓名：<i>${omem.memname}</i></span> 
					<span>ID：<i></i></span> 
					<span>性别：<i>${omem.gender}</i></span> 
					<span>年龄：</span> 
					<span>身高：<i>${omem.physical.height}cm</i></span> 
					<span>体重：<i>${omem.physical.weight}Kg</i></span> 
					<span>报告编号：<i>${omrr_2.reportCode}</i></span>
				</div>
			</div>
		<div class="report-content">
			<div class="celiang-summary">
				<span>测量时间：<fm:formatDate value="${omrr_2.measTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" dateStyle="long"/>
					至 <fm:formatDate value="${omrr_2.measTermTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" dateStyle="long"/>
				</span> 
				<span>历时天数：${lastDay}天</span>
				<span>数据记录天数：${omrr_2.measNum}</span> 
				<span>报告产生时间：<fm:formatDate value="${omrr_2.grenerTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" dateStyle="long"/></span> 
				<span>报告审核时间：<fm:formatDate value="${oasr.auditDatetime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" dateStyle="long"/></span>
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
				<c:forEach items="${omrr_2.obsrs}" var="obsr">
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
				<div>数据记录天数：${osbrsCount}</div>
			</div>
		</div>
		<div class="footer-box">
			<p>*声明：本报告仅供临床医师参考，不做临床诊断证明*</p>
			<div class="doc-sign">
				审核医生：${doctor.docname }
					  	&nbsp;&nbsp;&nbsp;&nbsp;
 					  	<img class="doctorName"  src="${pageContext.request.contextPath }/image/getImage?uniqueId=${doctor.signaddress}" onerror="nofind();" alt="医生签名"/>
 					 </div>
			<div class="print-page">${obsrCount}/${total}</div>
		</div>
	</div>
	</c:if>
	
	<c:if test="${omrr_3.optId == 3 }">
	<div class="report-wrap">
		<div class="header">
			<h1 class="paper-title">${omem.memname}${subTempName_3}</h1>
				<div class="user-info">
					<span>姓名：<i>${omem.memname}</i></span> 
					<span>ID：<i></i></span> 
					<span>性别：<i>${omem.gender}</i></span> 
					<span>年龄：<i>${age }</i></span> 
					<span>身高：<i>${omem.physical.height}cm</i></span> 
					<span>体重：<i>${omem.physical.weight}Kg</i></span> 
					<span>报告编号：<i>${omrr_3.ID}</i></span>
				</div>
		</div>
		<div class="report-content">
			<div class="celiang-summary">
				<span>测量时间：<fm:formatDate value="${omrr_3.measTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" dateStyle="long"/>
					至 <fm:formatDate value="${omrr_3.measTermTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" dateStyle="long"/>
				</span> 
				<span>历时天数：${lastDay}天</span>
				<span>数据记录天数：${omrr_3.measNum}</span> 
				<%-- <span>用药情况：未知</span> --%>
				<span>报告产生时间：<fm:formatDate value="${omrr_3.grenerTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" dateStyle="long"/></span> 
				<span>报告审核时间：<fm:formatDate value="${oasr.auditDatetime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" dateStyle="long"/></span>
			</div>
				<div class="clear-fix">
				<div class="fl w49">
					<div class="imgholder">
						<label class="f-right" for="shy_chart1_cb"><input id="shy_chart1_cb" name="charts" value="shy_chart1" type="checkbox" checked="checked"/>打印</label>
						<div id="shy_chart1" style="width: 500px; height: 400px;"></div>
					</div>
				</div>
				<div class="fr w49">
					<div class="imgholder">
						<label class="f-right" for="shy_chart2_cb"><input id="shy_chart2_cb" name="charts" value="shy_chart2" type="checkbox" checked="checked"/>打印</label>
						<div id="shy_chart2" style="width: 500px; height: 400px;"></div>
					</div>
				</div>
			</div>
			<div class="xindian-wrap" id="shy_chart3_box">
				<h2>【异常心电图】</h2>
			</div>
			<div class="xindian-wrap">
				<div class="xindian-wrap clear-fix">
					<div class="fl">
						<h2>异常心电一览表</h2>
					</div>
					<div class="fr">
						<label class="fr" for="shy_tab1_cb"> <input id="shy_tab1_cb" name="charts"  value="shy_tab1" type="checkbox" checked="checked" />打印</label>
					</div>
				</div>
				<table class="table-border" id="shy_tab1">
					<tr>
						<th width="15%">日期</th>
						<th width="15%">时间区间</th>
						<th width="45%">异常项</th>
						<th>次数</th>
					</tr>
					<c:forEach items="${ecg12s_tab3 }" var="ecg12s">
						<tr>
						<td><fm:formatDate value="${ecg12s.timePoint1}" type="date" pattern="yyyy-MM-dd" dateStyle="long"/></td>
						<td><fm:formatDate value="${ecg12s.timePoint1}" type="date" pattern="HH:mm" dateStyle="long"/>-<fm:formatDate value="${ecg12s.timePoint2}" type="date" pattern="HH:mm" dateStyle="long"/></td>
						<td>${ecg12s.expCname}</td>
						<td>${ecg12s.extMss.size()}</td>
						</tr>
					</c:forEach>
				</table>
				<div class="xindian-wrap">
					<h2>脉搏数据分析</h2>
					<div class="clear-fix">
						<div class="fl w49">
							<label class="fr" for="shy_chart4_cb"> <input id="shy_chart4_cb" name="charts"  value="shy_chart4" type="checkbox" checked="checked" />打印</label>
							<div class="imgholder">
								<div id=shy_chart4 style="width: 500px; height: 400px;"></div>
							</div>
						</div>
						<div class="fr w49">
							<label class="fr" for="shy_chart5_cb"> <input id="shy_chart5_cb"  value="shy_chart5" name="charts" type="checkbox" checked="checked" />打印</label>
							<div class="imgholder">
								<div id="shy_chart5" style="width: 500px; height: 400px;"></div>
							</div>
						</div>
					</div>
				</div>
				<div class="xindian-wrap" id="shy_chart6_box">
				</div>
				<div class="xindian-wrap">
					<div class="clear-fix">
						<h2 class="fl">异常脉搏指标一览表</h2>
						<label class="fr" for="shy_tab2_cb"> <input id="shy_tab2_cb" name="charts" value="shy_tab2" type="checkbox" checked="checked" />打印</label>
					</div>
					<table class="table-border" id="shy_tab2">
						<tr>
							<th width="15%">日期</th>
							<th width="15%">时间</th>
							<th width="25%">异常项</th>
							<th width="20%">测量值</th>
							<th>结果</th>
						</tr>
						<c:forEach items="${omrr_3.oppgs}" var="oppg">
							<c:forEach items="${ oppg.excOppgs}" var="item">
									<tr>
										<td><fm:formatDate value="${oppg.measuretime}" type="date" pattern="MM月dd日" dateStyle="long"/></td>
										<td><fm:formatDate value="${oppg.measuretime}" type="date" pattern="HH:mm" dateStyle="long"/></td>
										<td>${item.name}</td>
										<td>${item.value}</td>
										<td>${item.result}</td>
									</tr>

								
							</c:forEach>
						</c:forEach>
					</table>
				</div>
				<div class="xindian-wrap clear-fix">
					<div class="fl w49">
						<h2>三合一测量记录：${omrr_3.oppgs.size()}</h2>
					</div>
					<label class="fr" for="shy_tab3_cb"> <input id="shy_tab3_cb" name="charts" value="shy_tab3" type="checkbox" checked="checked" />打印</label>
				</div>
				<table class="table-normal" id="shy_tab3">
					<tr>
						<th width="15%">测量时间</th>
						<th width="30%">平均心率(bpm)</th>
						<th width="30%">平均脉搏(bpm)</th>
						<th>血氧饱和度</th>
					</tr>
					<c:forEach items="${omrr_3.oppgs }" var="oppg" varStatus="status">
						<tr>
							<td><fm:formatDate value="${oppg.measuretime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" dateStyle="long"/></td>
							<td>${oppg.oecg.averageheart}</td>
							<td>${oppg.pulserate}</td>
							<td>${oppg.spo}</td>
						</tr>
					</c:forEach>
				</table>
			</div>

		</div>
		<div class="footer-box">
			<p>*声明：本报告仅供临床医师参考，不做临床诊断证明*</p>
			<div class="doc-sign">
				审核医生：${doctor.docname }
					  	&nbsp;&nbsp;&nbsp;&nbsp;
 					  	<img class="doctorName"  src="${pageContext.request.contextPath }/image/getImage?uniqueId=${doctor.signaddress}" onerror="nofind();" alt="医生签名"/>
			</div>
			<div class="print-page">${oecg3Count}/${total}</div>
		</div>
	</div>
	</c:if>
	
	<c:if test="${omrr_4.optId == 4 }"> 
	<div class="report-wrap">
		<div class="header">
			<h1 class="paper-title">${omem.memname}${subTempName_4}</h1>
				<div class="user-info">
					<span>姓名：<i>${omem.memname}</i></span> 
					<span>ID：<i></i></span> 
					<span>性别：<i>${omem.gender}</i></span> 
					<span>年龄：<i>${age}</i></span> 
					<span>身高：<i>${omem.physical.height}cm</i></span> 
					<span>体重：<i>${omem.physical.weight}Kg</i></span> 
					<span>报告编号：<i>${omrr_4.ID}</i></span>
				</div>
		</div>
		<div class="report-content">
			<div class="celiang-summary">
					<span>测量时间：<fm:formatDate value="${omrr_4.measTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" dateStyle="long"/>
						至 <fm:formatDate value="${omrr_4.measTermTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" dateStyle="long"/>
					</span> 
					<span>历时天数：${lastDay}天</span>
					<span>数据记录天数：${omrr_4.measNum}</span>
					<%-- <span>用药情况：未知</span>  --%>
					<span>报告产生时间：<fm:formatDate value="${omrr_4.grenerTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" dateStyle="long"/></span> 
					<span>报告审核时间：<fm:formatDate value="${oasr.auditDatetime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" dateStyle="long"/></span>
				</div>
			<div class="clear-fix">
				<div class="fl w49">
					<div class="imgholder">
						<label class="fr" for=""xd_chart1_cb""> <input id="xd_chart1_cb" name="charts" value="xd_chart1" type="checkbox" checked="checked" />打印</label>
						<div id="xd_chart1" memberid="${omrr_4.memberid}" reportNo="${omrr_4.ID}" style="width: 500px; height: 400px;"></div>
					</div>
				</div>
				<div class="fr w49">
					<div class="imgholder">
						<label class="fr" for="xd_chart2_cb"> <input id="xd_chart2_cb" name="charts" value="xd_chart2"  type="checkbox" checked="checked" />打印</label>
						<div id="xd_chart2" memberid="${omrr_4.memberid}" reportNo="${omrr_4.ID}" style="width: 500px; height: 400px;"></div>
					</div>
				</div>
			</div>
			<div class="xindian-wrap" id="xd_chart3_box">
				<h2>【异常心电图】</h2>
			</div>
			<div class="xindian-wrap">
				<div class="xindian-wrap clear-fix">
					<div class="fl">
						<h2>Mini异常心电一览表</h2>
					</div>
					<label class="fr" for="xd_tab1_cb"> <input id="xd_tab1_cb" value="xd_tab1" name="charts" type="checkbox" checked="checked" />打印</label>
				</div>
				<table class="table-border" id="xd_tab1">
					<tr>
						<th width="15%">日期</th>
						<th width="15%">时间区间</th>
						<th width="45%">异常项</th>
						<th>次数</th>
					</tr>
					<c:forEach items="${ecg12s_tab4 }" var="ecg12s">
						<tr>
						<td><fm:formatDate value="${ecg12s.timePoint1}" type="date" pattern="yyyy-MM-dd" dateStyle="long"/></td>
						<td><fm:formatDate value="${ecg12s.timePoint1}" type="date" pattern="HH:mm" dateStyle="long"/>-<fm:formatDate value="${ecg12s.timePoint2}" type="date" pattern="HH:mm" dateStyle="long"/></td>
						<td>${ecg12s.expCname}</td>
						<td>${ecg12s.extMss.size()}</td>
						</tr>
					</c:forEach>
				</table>
				<div class="xindian-wrap clear-fix">
					<div class="fl w49">
						<h2>动态心电测量记录：${omrr_4.oecgs.size() }</h2>
					</div>
					<label class="fr" for="xd_tab2_cb"> <input id="xd_tab2_cb" name ="charts" value="xd_tab2" type="checkbox" checked="checked" />打印</label>
				</div>
				<table class="table-normal" id="xd_tab2">
					<tr>
						<th width="30%">测量时间</th>
						<th width="30%">平均心率(bpm)</th>
						<th>异常情况</th>
					</tr>
					<c:forEach items="${omrr_4.oecgs}" var="oecg">
						<tr>
							<td><fm:formatDate value="${oecg.meastime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" dateStyle="long"/></td>
							<td>${oecg.averageheart }</td>
							<c:if test="${oecg.ecg2s.size()==0}">
								<td>无异常</td>
							</c:if>
							<c:if test="${oecg.ecg2s.size()!=0}">
								<td style="color:red;">
								异常(${oecg.ecg2s.size() }):&nbsp;&nbsp;
								<c:forEach items="${oecg.ecg2s }" var="ecg2" varStatus="st" >
									<c:if test="${st.last }">${ecg2.abnCname }。</c:if>
									<c:if test="${!st.last }">${ecg2.abnCname }，</c:if>
								</c:forEach>
								</td>
							</c:if>	
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<div class="footer-box">
			<p>*声明：本报告仅供临床医师参考，不做临床诊断证明*</p>
			<div class="doc-sign">
				审核医生：${doctor.docname }
					  	&nbsp;&nbsp;&nbsp;&nbsp;
 					  	<img class="doctorName"  src="${pageContext.request.contextPath }/image/getImage?uniqueId=${doctor.signaddress}" onerror="nofind();" alt="医生签名"/>
 			</div>
			<div class="print-page">${oecg4Count}/${total}</div>
		</div>
	</div>
	</c:if>
	</div>
	<div class="btns">
		<input type="button" value="导出" class="btn-normal" onclick="exportWord(${oasr.reportNo},${oasr.auditLevel},'${doctor.signaddress}');">
		<input type="button" class="btn-normal" value="取消" onclick="javascript: window.close();">
	</div>
</body>
</html>
