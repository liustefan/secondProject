<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
    <title>血压单次测量结果</title>
	<link rel="shortcut icon" href="<%=path %>/<%=getServletContext().getAttribute("img") %>/title_ico.ico" type="image/x-icon" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/general.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/celiangsing.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/xueya.css">
	
	<script src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script src="<%=path %>/js/highcharts.js"></script>
	<script src="<%=path %>/js/exporting.js"></script>
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
		$(function(){
			var sbp = $("#mySpan").val();
			var dbp = $("#myDbp").val();
			if((sbp >= 140 && sbp < 150) && (dbp >= 60 && dbp < 90)) {
				//  单纯收缩期高血压
				$("#xueya").css("margin-top", "160px");
			}else if( (sbp >= 140 && sbp < 160) || (dbp >= 90 && dbp < 100)) {
				// 轻度高血压
				$("#xueya").css("margin-top", "130px");
			}else if((sbp >= 160 && sbp < 180) || (dbp >= 100 && dbp < 110)) {
				// 中度高血压
				$("#xueya").css("margin-top", "90px");
			}else if(sbp >= 180 || dbp >= 110) {
				// 高度高血压
				$("#xueya").css("margin-top", "50px");
			}else if(sbp < 90 || dbp < 60) {
				// 低血压
				$("#xueya").css("margin-top", "300px");
			}else if((sbp >= 90 && sbp <= 130) && (dbp >= 60 && dbp <= 85)) {
				// 正常
				$("#xueya").css("margin-top", "250px");
			}else if(((sbp > 130 && sbp < 140) && (dbp >= 60 && dbp < 90)) || ((sbp >= 90 && sbp <= 130) && (dbp > 85 && dbp < 90))) {
				// 正常偏高
				$("#xueya").css("margin-top", "200px");
			}
		});
	</script>
</head>
<body <c:if test="${flag ne 1 }">style="background:#f3f3f3;"</c:if>>
<div <c:if test="${flag eq 1 }">class="content" style="background:#fff;"</c:if><c:if test="${flag ne 1 }">id="w1280"</c:if>>
     <c:if test="${flag ne 1 }">
 		<div class="single_report_head">
            <div class="person-info">
                 <div class="fl person-img">
                  	<c:if test="${not empty omem.headaddress}">
					    <img src="<%=path %>/image/getImage?uniqueId=${omem.headaddress}" style="width: 64px; height: 64px;">
					</c:if>
					<c:if test="${empty omem.headaddress}">
					    <img src="<%=path %>/img/mem_img.png" style="width: 64px; height: 64px;">
					</c:if>
                 </div>
                 <div class="fr">
                 	<p>姓名：${omem.memname }</p>
                    <p>性别：${omem.gender eq '1'?'男': omem.gender eq '2'?'女': '未知'}</p>
                    <p>年龄：${age}</p>
                 </div>
            </div>
  			<h3>血压测量结果</h3>
    	</div>
    </c:if>
    <c:if test="${flag eq 1 }">
    	<div class="content-title">血压测量</div>
    </c:if>
    <div>
		<ul class="footer_content_ul clearfix">
			<li><a href="../bloodPressure/showSingleBloodPress?memberId=${omem.memberid}&eventId=${osbp.eventid}&flag=${flag}" class="current">单次测量结果</a></li>
			<li><a href="../bloodPressure/showAllBloodPress?memberId=${omem.memberid}&eventId=${osbp.eventid}&flag=${flag}">所有测量数据</a></li>
	    </ul>	
    </div>
    <c:if test="${empty osbp.testtime}">
 		<div class="empty-info">
 			目前还没有血压测量数据
 			<c:if test="${startTime != null || endTime != null}">
 				<a class="btn-normal" href="javascript:history.go(-1)">返回</a>
 			</c:if>
 		</div>
  	</c:if>
  	<c:if test="${not empty osbp.testtime}">
		<div class="page-box">  
			<div class="fr">
				<c:if test="${pageNo > 0 }">
					<a class="btn-normal2" href="../bloodPressure/showSingleBloodPress?pageNo=${pageNo-1 }&memberId=${omem.memberid}&flag=${flag}">上一次</a>
		  		</c:if>
		      	<c:if test="${pageNo+1 < total }">
					<a class="btn-normal2" href="../bloodPressure/showSingleBloodPress?pageNo=${pageNo+1 }&memberId=${omem.memberid}&flag=${flag}">下一次</a>
			  	</c:if>
		        <a class="btn-normal2" href="../bloodPressure/showSingleBloodPress?pageNo=${total-1 }&memberId=${omem.memberid}&flag=${flag}">最后</a>
			</div>
		</div>
		<hr/>
		<table class="footer_content1_table">
			<tr>
				<td>概述</td>
				<td>
					<table class="single-table">
						<tr>
							<td>测量时间：</td>
							<td><fmt:formatDate value="${osbp.testtime}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
						</tr>
						<tr>
							<td>
								总评：
							</td>
						</tr>
						<tr>
							<td colspan="2">您本次测量数据</td>
						</tr>
						<tr>
							<td>收缩压（高压）：</td>
							<td><input type="text" value="${osbp.sbp }" id="mySpan" readonly style="width:30px;"/>参考值：90-140mmHg</td>
						</tr>
						<tr>
							<td>舒张压（低压）：</td>
							<td><input type="text" value="${osbp.dbp }" id="myDbp" readonly style="width:30px;"/>参考值：60-90mmHg</td>
						</tr>
						<tr>
							<td>脉率：</td>
							<td>${osbp.pulserate }<span style="display: inline-block; width: 20px;"></span>参考值：55-100bpm</td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td colspan="2">
							平均压：<fmt:formatNumber type="number" value="${(osbp.sbp + 2 * osbp.dbp)/3 - 0.5}" maxFractionDigits="0"/>&nbsp;&nbsp;&nbsp;
							脉压差：${osbp.sbp - osbp.dbp}&nbsp;&nbsp;&nbsp;
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<div style="width:100%; margin-top:20px;">
			<div class="o" id="xueya">
				<img src="${pageContext.request.contextPath }/img/cursor.png" id="cursor">
			</div> 
			<div class="clear-flow q">
				<div class="v">
					<div class="v6">180</div>
					<div class="v5">160</div>
					<div class="v4">150</div>
					<div class="v3">140</div>
					<div class="v2">130</div>
					<div class="v1">90</div>
				</div>
				<div class="n">
					<div class="n1"><b>低血压</b></div>
					<div class="n2"><b>正常</b></div>
					<div class="n3"><b>正常高值</b></div>
					<div class="n4"><b>单纯收缩期高血压</b></div>
					<div class="n5"><b>轻度高血压</b></div>
					<div class="n6"><b>中度高血压</b></div>
					<div class="n7"><b>重度高血压</b></div>
					<div class="n8"><b>收缩压&nbsp;&nbsp;mmHg</b></div>
				</div>
				<div class="wz">舒张压<br/>mmHg</div>
				<div class="w clear">
					<div class="w1">60</div>
					<div class="w2">85</div>
					<div class="w3">90</div>
					<div class="w4">100</div>
					<div class="w5">110</div>
				</div>
			</div>
		</div>
	</c:if>
</div>
</body>
</html>
