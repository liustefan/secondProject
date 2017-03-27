<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
    <title>血糖单次测量结果</title>
   	<meta charset="utf-8">
   	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/reset.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/celiangsing.css">
	<link rel="shortcut icon" href="<%=path %>/<%=getServletContext().getAttribute("img") %>/title_ico.ico" type="image/x-icon" />
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.7.2.min.js"></script>
 	<script type="text/javascript" src="<%=path %>/layer/layer/layer.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/highcharts.js"></script>
	<script type="text/javascript" src="<%=path %>/js/exporting.js"></script>
	<style type="text/css">
		#flag{
			z-index: 1;
			float: left;
			margin-left: -200px;
			margin-top: 100px;
		}
		
		#myXueTang{
			float: left;
		}
		
		.btn-normal2 {
		    height: 30px;
		    padding: 0 15px;
		    margin: 0 5px;
		    font: normal 14px "Microsoft YaHei",Arial,"宋体",Helvetica,Verdana,Sans-serif;
		    color: #FFF !important;
		    line-height: 30px;
		    display: inline-block;
		    border: 0;
		    border-radius: 3px;
		    -moz-border-radius: 3px;    /* Gecko browsers */
		    -webkit-border-radius: 3px; /* Webkit browsers */
		    cursor: pointer;
		    background: #75D07D;
		    background: -moz-linear-gradient(top, #48d660 0%, #61b95f 100%);
		    background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#48d660), color-stop(100%,#61b95f));
		    background: -webkit-linear-gradient(top, #48d660 0%,#61b95f 100%);
		    background: -o-linear-gradient(top, #48d660 0%,#61b95f 100%);
		    background: -ms-linear-gradient(top, #48d660 0%,#61b95f 100%);
		    background: linear-gradient(to bottom, #48d660 0%,#61b95f 100%);
		    filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#48d660', endColorstr='#61b95f',GradientType=0 );
		}
		
		.btn-normal2:hover {
			color: #fff;
		}
	</style>	
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
			$("#info").click(function(){
				layer.tips('①空腹<br/>正常值：3.9~6.1<br/>糖尿病：轻度糖尿病：7.0~8.4mmol/L，中度糖尿病：8.1~11.1mmol/L，重度糖尿病：≥11.1mmol/L<br/>'+
						'②餐后1小时<br/>正常值：6.7~9.4mmol/L<br/>糖尿病：≥11.1mmol/L<br/>'+
						'③餐后2小时<br/>正常值：≤7.8mmol/L<br/>糖尿病：≥11.1mmol/L<br/>糖耐量受损：7.8~11.1mmol/L<br/>空腹血糖受损： ＜7.8mmol/L<br/>'+
						'④餐后3小时<br/>血糖恢复正常，各次尿糖均为阴性', this, {
				    style: ['background-color:#78BA32; color:#fff', '#78BA32'],
				    maxWidth:380,
				    time: 10,
				    closeBtn:[0, true]
				});
			});
		});
	</script>	
</head>
<body <c:if test="${flag ne 1 }">style="background:#f3f3f3;"</c:if>>
	<div <c:if test="${flag eq 1 }">class="content" style="background:#fff;"</c:if><c:if test="${flag ne 1 }">id="w1280"</c:if>>
      	<c:if test="${flag ne 1 }">
	  		<div class="single_report_head">
	            <div class="person-info clear-fix">
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
	  	      	<h3>血糖测量结果</h3>
		    </div>
	    </c:if>
	    <c:if test="${flag eq 1 }">
	    	<div class="content-title">血糖测量</div>
	    </c:if>
	    <div>
		<ul class="footer_content_ul clearfix">
			<li><a href="../bloodSugar/showSingleBloodSugar?memberId=${omem.memberid}&eventId=${obsr.eventid}&flag=${flag}" class="current">单次测量结果</a></li>
			<li><a href="../bloodSugar/showAllBloodSugar?memberId=${omem.memberid}&eventId=${obsr.eventid}&flag=${flag}" ">所有测量数据</a></li>
        </ul>
        </div>
        <c:if test="${empty obsr.testtime}">
	 		<div class="empty-info">
	 			目前还没有血糖测量数据
	 			<c:if test="${startTime != null || endTime != null}">
	 				<a class="btn-normal" href="javascript:history.go(-1)">返回</a>
	 			</c:if>
	 		</div>
	  	</c:if>
	  	<c:if test="${not empty obsr.testtime}">
	  		<div class="page" style="padding:10px 0;"> 
				<c:if test="${pageNo > 0 }">
					<a class="btn-normal2" href="../bloodSugar/showSingleBloodSugar?pageNo=${pageNo-1 }&memberId=${omem.memberid}&flag=${flag}">上一次</a>&nbsp;&nbsp;
				</c:if>
				<c:if test="${pageNo+1 < total }">
					<a class="btn-normal2" href="../bloodSugar/showSingleBloodSugar?pageNo=${pageNo+1 }&memberId=${omem.memberid}&flag=${flag}">下一次</a>
				</c:if>
				<a class="btn-normal2" href="../bloodSugar/showSingleBloodSugar?pageNo=${total-1 }&memberId=${omem.memberid}&flag=${flag}">最&nbsp;&nbsp;&nbsp;&nbsp;后</a>
			</div>
			<hr/>
			<table class="footer_content1_table" style="text-align: left;">
				<tr>
					<th style="font-size:14px;padding:10px 0;" align="left">&nbsp;&nbsp;概述</th>
				</tr>
				<tr>
					<td>
						<table>
							<tr>
								<td>&nbsp;&nbsp;测量时间：</td>
								<td><fmt:formatDate value="${obsr.testtime}" pattern="yyyy-MM-dd HH:mm:ss"/> （
									<c:if test="${obsr.timeperiod == '0'}">其它时间</c:if>
									<c:if test="${obsr.timeperiod == '1'}">早餐前</c:if>
									<c:if test="${obsr.timeperiod == '2'}">早餐后2小时</c:if>	
									<c:if test="${obsr.timeperiod == '3'}">午餐前</c:if>	
									<c:if test="${obsr.timeperiod == '4'}">午餐后2小时</c:if>	
									<c:if test="${obsr.timeperiod == '5'}">晚餐前</c:if>	
									<c:if test="${obsr.timeperiod == '6'}">晚餐后2小时</c:if>	
									<c:if test="${obsr.timeperiod == '7'}">睡前</c:if>	
									<c:if test="${obsr.timeperiod == '8'}">夜间</c:if>				
									）
								</td>
							</tr>
							<tr>
								<td colspan="2">&nbsp;&nbsp;总评：</td>
							</tr>
							<tr>
								<td colspan="2">&nbsp;&nbsp;本次测量结果：${obsr.bsvalue }&nbsp;&nbsp;&nbsp;<a href="javascript:;" id="info">参考值</a></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<table class="footer_content1_table">
				<tr align="center"><th colspan="5" style="font-size:14px;">血糖值对照表</th></tr>
				<tr>
					<td>
						<table class="table-normal">
							<tr align="center">
								<th>诊断</th>
								<th>血糖类型</th>
								<th>静脉血浆(mmol/L)</th>
								<th>静脉全血(mmol/L)</th>
								<th>毛细血管全血(mmol/L)</th>
							</tr>
							<tr align="center">
								<td rowspan="2">糖尿病(DM)</td>
								<td>空腹</td>
								<td>≥7.0</td>
								<td>≥6.1</td>
								<td>≥6.1</td>
							</tr>
							<tr align="center">
								<td>餐后2小时</td>
								<td>≥11.1</td>
								<td>≥10.0</td>
								<td>≥11.1</td>
							</tr>
							<tr align="center">
								<td rowspan="2">糖耐量(IGT)受损</td>
								<td>空腹</td>
								<td>＜7.0</td>
								<td>＜6.1</td>
								<td>＜6.1</td>
							</tr>
							<tr align="center">
								<td>餐后2小时</td>
								<td>7.8~11.0</td>
								<td>6.7~9.9</td>
								<td>7.8~11.0</td>
							</tr>
							<tr align="center">
								<td rowspan="2">空腹血糖(IFG)受损</td>
								<td>空腹</td>
								<td>6.1~6.9</td>
								<td>5.6~6.0</td>
								<td>5.6~6.0</td>
							</tr>
							<tr align="center">
								<td>餐后2小时</td>
								<td>＜7.8</td>
								<td>＜6.7</td>
								<td>＜7.8</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<br/>
		</c:if>
	</div>
</body>
</html>
