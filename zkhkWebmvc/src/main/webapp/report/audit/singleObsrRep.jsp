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
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/css/vip.css">
	<script type="text/javascript">
		var memberid = "${omrr.memberid}";
		var reportNo = "${omrr.ID}";
		// 全局变量 用于singleObsrRep.js
		var basePath = '<%=basePath%>';
	</script>
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/highcharts.js"></script>
	<script type="text/javascript" src="<%=path %>/js/exporting.js"></script>
	<script type="text/javascript" src="<%=path %>/js/highcharts-more.js"></script>
	<script type="text/javascript" src="<%=path %>/js/singleObsrRep.js"></script>
	<script type="text/javascript" src="<%=path %>/js/kindeditor/kindeditor.js"></script>
	<script type="text/javascript" src="<%=path %>/js/kindeditor/lang/zh_CN.js"></script>
	<script type="text/javascript" src="<%=path %>/js/popupPage1.js"></script>
	
	<script type="text/javascript">
		var userInfo_orgId =${empty userInfo.dept_id}?0:${userInfo.dept_id}+0;
		KindEditor.ready(function(K) {		
			window.editor = K.create('#myAdvice', {
				height : '300px',
				width : '100%',
				orgid: userInfo_orgId
			});
			
		});
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
	<h4 class="title-report">${omem.memname }${oasr.templateName }</h4>
	<form action="<%=basePath%>/singleReport/saveSingleAuditContent" method="post" onsubmit="javascript: editor.sync();return checkAudit();" enctype="application/x-www-form-urlencoded">
     	<input type="hidden" name="auditLevel" value="${oasr.auditLevel }"/>
     	<input type="hidden" id="serialNumber" name="serialNumber" value="${oasr.serialNumber }"/>
     	<input type="hidden" name="docGrpCode" value="${oasr.docGrpCode }"/>
     	<input type="hidden" name="docid" value="${oasr.docid }"/>
     	<input type="hidden" name="reportNo" value="${oasr.reportNo }"/>
     	<input type="hidden" id="optId" name="optId" value="${oasr.optId }"/>
     	<input type="hidden" name="optName" value="${oasr.optName }"/>
     	<input type="hidden" name="submitOther" value="${oasr.submitOther }"/>
     	<input type="hidden" name="memberid" value="${oasr.memberid}"/>
   		<input type="hidden" name="measTime" value="${oasr.measTime }"/>
     	<input type="hidden" name="measTermTime" value="${oasr.measTermTime }"/>
     	<input type="hidden" name="measNum" value="${oasr.measNum }"/>
     	<input type="hidden" name="tempCode" value="${oasr.tempCode }"/>
     	<input type="hidden" name="grenerTime" value="${oasr.grenerTime }"/>
		<table class="table-border">
			<tr>
				<td>姓名：${omem.memname }</td>
				<td>性别：${omem.gender=='F'?'女':'男'}</td>
				<td>年龄：${age }</td>
				
				<td>身高：${omem.physical.height }</td>
				<td>体重：${omem.physical.weight }</td>
				<td>报告编号：${omrr.ID }</td>
			</tr>
			<tr>
				<td>测量时间段：</td>
				<td><fm:formatDate value="${omrr.measTime }" type="date" dateStyle="default"/>至<fm:formatDate value="${omrr.measTermTime }" type="date" dateStyle="default"/></td>
				<td>历时天数：${lastDay }</td>
				<td>数据记录天数：${omrr.measNum }</td>
				<td>报告产生时间：<fm:formatDate value="${omrr.grenerTime }" type="date" dateStyle="default"/></td>
				<td>报告审核时间：<fm:formatDate value="${oasr.auditDatetime }" type="date" dateStyle="default"/></td>
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
			<c:forEach var="item" items="${omrr.obsrs}" varStatus="st">
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
	    <div class="result-list-box">
	    <div class="caption-title">同组医生建议</div>
   			<div class="result-list">		
			 	<c:if test="${fn:length(mrrCommons) != 0}">
					<c:set  value="0" var="next"></c:set>	
					<c:forEach var="item" items="${mrrCommons}" varStatus="st">
					<li>
						<div>
							审核医生：${item.doctorName}
							&nbsp;&nbsp;&nbsp;&nbsp;
					  		<img alt="签名" src="${pageContext.request.contextPath }/image/getImage?uniqueId=${item.signaddress}"/>
						</div>
						<div>审核级别： 
							<c:choose>
									<c:when test="${item.auditMode==2}">
										<c:set var="next" value="${item.auditMode}" />
									</c:when>
									<c:when test="${item.auditMode==3 || next == 2}">
										[审核]<c:set var="next" value="0" />
									</c:when>
									<c:otherwise>
										${item.auditLevel }
									</c:otherwise>
								</c:choose>
							
						</div>
					    <div>审核内容：${item.auditDesc }</div>
					    <div>审核时间：<fm:formatDate value="${item.auditTime}" type="date" pattern="yyy-MM-dd HH:mm:ss" dateStyle="long"/></div>
					    <br/>
					</li>
					</c:forEach> 
					<br><br>
				</c:if>
				<c:if test="${fn:length(mrrCommons) == 0}">
					<span style="color:#999;">还没有医生建议</span><br><br>
				</c:if>
			</div>
			</div>
			<div class="result-list-box">
			    <div class="caption-title">其他组医生建议</div>
				<div class="result-list">
			 		<c:if test="${fn:length(smr1Others) != 0}">
					 <c:forEach var="item" items="${mrrOthers}" varStatus="st">
						  ${item.docGrpName}:${item.doctorName }
						  &nbsp;&nbsp;&nbsp;&nbsp;
						  <img src="<s:property value="(new com.hkbithealth.action.DoctorAction()).getDocSignAddr(docid)"/>"/>
						  <br/>
						  时间 ：<fm:formatDate value="${item.auditTime }" type="date" dateStyle="default"/><br/>
						 ${item.auditDesc };<br>
					  </c:forEach>  
					  <br>
					 </c:if>
					 <c:if test="${fn:length(smr1Others) == 0}">
					 	<span style="color:#999;">目前还没有其它组建议</span><br>
					 </c:if>
				</div>
		 	</div>
			<c:if test='${ oasr.serialNumber!=null && isAudit != "N"}'>
			 	<div class="result-list-box">
				     <div class="caption-title">我的意见建议: <input type="button" value="载入审核意见模板" class="btn-normal float" onclick="popup(userInfo_orgId,1);"></div>
				     <div class="result-list">
				     	<textarea id="myAdvice" name="myAdvice" cols="40" rows="5">
					     	<c:if test="${fn:length(mrrCommons) != 0 }">
					     		${mrrCommons[fn:length(mrrCommons)-1].auditDesc}
					     	</c:if>
				     	</textarea>	
				        <br>
				      </div>
			     </div>
			</c:if>
		<br/>
	  	<a style="color:#f00;text-decoration:none;" href="${pageContext.request.contextPath}/member/detail/${omem.memberid}?resource=report" target="_blank">快速查看会员健康档案>></a><br>
	  	<c:if test='${ oasr.serialNumber!=null && isAudit != "N" }'>
			<c:if test="${oasr.auditLevel>1 }">
			<button type="button" id="btn" class="btn-blue">退审</button><br/>
			</c:if>
			&nbsp;<button type="button" class="btn-normal">提交</button>
	  	</c:if>
	  	<div class="page-box">
	 		<button type="button" id="return" class="btn-normal">返回</button>
	 	</div>
	</form>
</div>
</body>
</html>