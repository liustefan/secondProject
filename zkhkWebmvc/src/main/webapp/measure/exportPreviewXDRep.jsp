<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<title>动态心电测量报告导出预览</title>
	<link rel="shortcut icon" href="<%=path %>/<%=getServletContext().getAttribute("img") %>/title_ico.ico" type="image/x-icon" />
	<link rel="stylesheet" href="<%=path %>/css/reset.css">
	<link rel="stylesheet" href="<%=path %>/css/member.css">
	<script type="text/javascript" src="<%=path %>/js/jquery-1.7.2.js"></script>
	<script type="text/javascript" src="<%=path %>/js/highcharts.js"></script>
	<script type="text/javascript" src="<%=path %>/js/exporting.js"></script>
	<script type="text/javascript" src="<%=path %>/js/highcharts-more.js"></script>
	<script type="text/javascript" src="<%=path %>/js/exportPreviewXDRep.js"></script>
	<script>
	//医生签名没有图片的时候，加载一个默认图片（此处加载的为1*1px透明图）
	function nofind(){
	var img=event.srcElement;
	img.src="${pageContext.request.contextPath }/img/namedefault.png";
	img.onerror=null; //控制onerror事件只触发一次 
	}

	var memberid = '${omem.memberid}';
	var oecgsJson = ${oecgsJson};
	
	var xd_chart1_Obj,xd_chart2_Obj,xd_chart3_List = [];
	
	
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
	
	function exportWordMethod(){
		post("../electrocardio/exportReportWord",{oecgsJson:JSON.stringify(${oecgsJson}),memberId:${omem.memberid},generTime:$("#generTime").val()});
	}
	
	$(function(){
		var ecg12s_4 = <%=request.getAttribute("ecg12s_4")%>;
		var json_4 = formatData(ecg12s_4);
		$(json_4).each(function(i, e) {
			var dome = $("#xd_chart3_box");		
			dome.append('<div class="imgholder m-10" style="overflow:hidden;">');
			dome.append('<label class="fr" for="xd_chart3_' + i + '_cb"> <input id="xd_chart3_' + i + '_cb" name="charts" value="xd_chart3" cindex= ' + i+' type="checkbox" checked="checked" />打印</label>');
			dome.append('<div id="xd_chart3_' + i + '" style="height: 300px;"></div></div>');
			
			getExcData1(e, 0, 'xd_chart3_', i);
		});
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
<body style="width: 1024px; margin: 0 auto;" onload="getJson();">
	<div class="report-wrap">
		<%-- <h1 class="paper-title">${omem.memname}测量报告</h1>
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
				<h1 class="paper-title">${omem.memname}的动态心电测量报告</h1>
					<div class="user-info">
						<span>姓名：<i>${omem.memname}</i></span> 
						<span>ID：<i></i></span> 
						<span>性别：<i>${omem.gender=='1'?'男': omem.gender=='2'?'女':'未知'}</i></span> 
						<span>年龄：<i>${age}</i></span> 
						<span>身高：<i><c:if test="${not empty omem.physical.height}">${omem.physical.height}cm</c:if></i></span> 
						<span>体重：<i><c:if test="${not empty omem.physical.weight}">${omem.physical.weight}Kg</c:if></i></span> 
						<span>报告编号：<i></i></span>
					</div>
			</div>
			<div class="report-content">
				<div class="celiang-summary">
						<span>测量时间：
							<fm:formatDate value="${startMeasTime }" pattern="yyyy-MM-dd"/>至<fm:formatDate value="${endMeasTime }" pattern="yyyy-MM-dd"/>
						</span> 
						<span>历时天数：${lastDay }天</span>
						<span>数据记录天数：${recordDay }</span>
						<span>报告产生时间：<fm:formatDate value="${generTime }" pattern="yyyy-MM-dd HH:mm:ss"/></span> 
						<input id="generTime" type="hidden" value="<fm:formatDate value='${generTime }' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
						<span>报告审核时间：</span>
					</div>
				<div class="clear-fix">
					<div class="fl w49">
						<div class="imgholder">
							<label class="fr" for="xd_chart1_cb"> <input id="xd_chart1_cb" name="charts" value="xd_chart1" type="checkbox" checked="checked" />打印</label>
							<div id="xd_chart1" style="width: 500px; height: 400px;"></div>
						</div>
					</div>
					<div class="fr w49">
						<div class="imgholder">
							<label class="fr" for="xd_chart2_cb"> <input id="xd_chart2_cb" name="charts" value="xd_chart2"  type="checkbox" checked="checked" />打印</label>
							<div id="xd_chart2" style="width: 500px; height: 400px;"></div>
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
							<h2>动态心电测量记录：${oecgs.size() }</h2>
						</div>
						<label class="fr" for="xd_tab2_cb"> <input id="xd_tab2_cb" name ="charts" value="xd_tab2" type="checkbox" checked="checked" />打印</label>
					</div>
					<table class="table-normal" id="xd_tab2">
						<tr>
							<th width="30%">测量时间</th>
							<th width="30%">平均心率(bpm)</th>
							<th>异常情况</th>
						</tr>
						<c:forEach items="${oecgs}" var="oecg">
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
