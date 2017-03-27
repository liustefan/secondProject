<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>三合一导出预览</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="shortcut icon" type="image/x-icon" href="<%=basePath%>/<%=getServletContext().getAttribute("img") %>/title_ico.ico" />
<link rel="stylesheet" type="text/css" href="../css/exportSanHeYiPreview.css" />

<script type="text/javascript" src="<%=basePath%>js/jquery-1.7.2.js" ></script>
<script type="text/javascript" src="<%=basePath%>js/highstock.js"></script>
<script type="text/javascript" src="<%=basePath%>js/exporting.js"></script>
<script type="text/javascript" src="<%=basePath%>js/exportSanHeYiPreview.js"></script>
<script type="text/javascript" src="<%=basePath%>js/data.js"></script>
<script type="text/javascript">
function toLoginPage(){
	window.location.href = '<%=basePath%>'
}
function getRoot(){
	return '<%=basePath%>';
}

var EventUtil = {
    addHandler: function(element, type, handler) {
        if (element.addEventListener) {
            element.addEventListener(type, handler, false);
        } else if (element.attachEvent) {
            element.attachEvent("on" + type, handler);
        } else {
            element["on" + type] = handler;
        }
    }
};
EventUtil.addHandler(window, "offline", function() {
    window.location.href='<%= path + "/error.jsp"%>';
});

var docentry = "${oecg.docentry}";
var shy_exc_List=[];
$(function(){
	var j,k, list=[];
	$.post("../electrocardioPulse/getPreviewExcElectrocardioStatisData",
			{
			docentry : docentry
			},
			function(data){
				var json = JSON.parse(data);
				for(j=0; j<json.length;j++) {
					for(k =0; k<json[j]["objectIds"].length;k++) {
						list.push({expCname: json[j].expCname, extMss: json[j].extMss[k], extimes: json[j].extimes[k].replace(/'/g,""), objectIds: json[j].objectIds[k].replace(/'/g,"")  })
					}
				}
				$(list).each(function(i, e) {
					var dome = $("#ExcChartBoxs");			
					dome.append('<label class="fr" for="shy_exc_' + i + '_cb"> <input id="shy_exc_' + i + '_cb" name="charts" value="shy_exc" cindex= ' + i+'  type="checkbox" checked="checked" />打印</label>');
					dome.append('<div id="shy_exc_' + i + '" ></div>');
					getExcData(docentry, e, 0, 'shy_exc_' , i);
				});
			}
			);
	
	
	var flag = "${flag}";
	if(flag == 'true'){
		$("<h3>正常心电图</h3>").insertBefore("#ecgChart");
	    var url="../electrocardioPulse/getElectrocardioPulseChartData";
		 $.post(url,
			{
			 memberId : "${omem.memberid}",
			 eventId : "${oecg.eventid}" 
			},
			function(data){
				var dt=JSON.parse(data);
				setChart("ecgChart", dt);
			}
	); 
	}
});
</script>
</head>
<body>
	<div class="main">
		<h2>
			医院名称: <i class="hospitalName">${org}</i>
		</h2>
		<h1 class="title">三合一测量结果</h1>
		<c:if test="${privilege}">
			<table class="user_info">
			<tr>
				<td><strong>姓名:</strong><span>${omem.memname}</span></td>
				<td><strong>性别:</strong>${omem.gender=='1'?'男':omem.gender=='2'?'女':'未知'}</td>
			</tr>
			<tr>
				<td><strong>测量时间:</strong><fmt:formatDate
						value="${oecg.meastime}"
						pattern="yyyy-MM-dd HH:mm:ss" />
				</td>
				<td><strong>年龄:</strong>${age}</td>
			</tr>
		</table>
		<!-- 心电测量指标 -->
		<table class="table-heavy">
			<thead>
				<tr>
					<th width="33%">心电测量指标</th>
					<th width="33%">异常次数</th>
					<th width="33%">异常比率</th>
				</tr>
			</thead>
			<tbody id="tbody">
				<c:forEach var="oecgExc" items="${oecgExcs}">
					<tr>
						<td>${oecgExc.expCname}</td>
						<td>${oecgExc.expNum}</td>
						<td>${oecgExc.expRate }%</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<!-- 心功能参数 -->
		<table class="table-heavy">
			<thead>
				<tr>
					<th width="33%">心功能参数</th>
					<th width="33%">测量结果</th>
					<th width="33%">参考范围</th>
				</tr>
			</thead>

			<tbody>
				<tr>
					<td>平均脉率 PR</td>
					<td>${oppg.pulserate}</td>
					<td>55-100次/分</td>
				</tr>
				<tr>
					<td>平均每分射血量 co</td>
					<td>${oppg.co}</td>
					<td>3-7.5L/min</td>
				</tr>
				<tr>
					<td>心脏每搏射血量 SV</td>
					<td>${oppg.sv}</td>
					<td>55-105ml/搏</td>
				</tr>
				<tr>
					<td>血氧饱和度SO</td>
					<td>${oppg.spo}</td>
					<td>95%-100%</td>
				</tr>
				<tr>
					<td>心指数 CI</td>
					<td>${oppg.ci}</td>
					<td>2.3-100</td>
				</tr>
				<tr>
					<td>心搏指数SPI</td>
					<td>${oppg.spi}</td>
					<td>33-200</td>
				</tr>
			</tbody>
		</table>
		<!-- 血管外围参数 -->
		<table class="table-heavy">
			<thead>
				<tr>
					<th width="33%">外周血管参数</th>
					<th width="33%">测量结果</th>
					<th width="33%">参考范围</th>
				</tr>
			</thead>

			<tbody>
				<tr>
					<td>波形特征量 K</td>
					<td>${oppg.k}</td>
					<td>0.29-0.46</td>
				</tr>
				<tr>
					<td>血液黏度</td>
					<td>${oppg.v}</td>
					<td>3-5.04cp</td>
				</tr>
				<tr>
					<td>外周阻力 TPR</td>
					<td>${oppg.tpr}</td>
					<td>750-1450dy*S*cm</td>
				</tr>
				<tr>
					<td>血管顺应度 AC</td>
					<td>${oppg.ac}</td>
					<td>1.2-3dy.s.c</td>
				</tr>
				<tr>
					<td>平均动脉压</td>
					<td>${oppg.pm}</td>
					<td>70-105 mmHg</td>
				</tr>
				<tr>
					<td>血管硬化指数</td>
					<td>${oppg.si}</td>
					<td>0-8</td>
				</tr>
			</tbody>
		</table>

		<div id="ExcChartBoxs"></div>
		<input type="hidden" id="isMove" value="true">
		<div id="ecgChart"></div>
		
		<div style="overflow: hidden;width: 100%;">
			<h3>医生意见</h3>
			<textarea name="myAdvice" cols="40" rows="7" id="myAdvice" readonly="readonly"></textarea>
			<p class="fr">
				<span class="doctorName">医生签名</span>
			</p>
		</div>
		<div class="btns">
			<input type="button" value="导出" class="btn-normal"
				onclick="exportWord(${omem.memberid},${oecg.eventid});">
			<!-- <input type="button" class="btn-normal" value="取消" onclick="javascript: window.close();"> -->
		</div>
		</c:if>
		<c:if test="${!privilege}">
			无权限的操作
		</c:if>
		</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/elvin-plus.js"></script>
</html>