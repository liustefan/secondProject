<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
	<title>三合一单次测量结果</title>
   	<meta charset="utf-8">
   	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/comm.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/reset.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/celiangsing.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/layer/layer/skin/layer.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/plugins/font-awesome/css/font-awesome.min.css">
	<link rel="shortcut icon" type="image/x-icon" href="<%=path %>/<%=getServletContext().getAttribute("img") %>/title_ico.ico"/>
	
	<script src="<%=path %>/js/jquery-1.7.2.js"></script>
	<script src="<%=path %>/js/highstock.js"></script>
	<script src="<%=path %>/js/exporting.js"></script>
	<script src="<%=path %>/layer/layer/layer.min.js"></script>
	<script src="<%=path %>/js/tab.js"></script>
	<script src="<%=path %>/js/data.js"></script>
	<style type="text/css">
		.btn-normal5 {
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
		
		.btn-normal5:hover {
			color: #fff;
		}
		
		.pagemove {
			margin-top: 20px;
			margin-bottom: 20px;
		}
		
		.pagemove img {
			padding-left: 30px;
		}
		
		.go-back {
			color: #f00;
			font-size: 14px;
			text-decoration: underline;
			font-family: "Microsoft YaHei";
			margin-top: 5px;
		}
		/*************** Content Box ***************/
		.content-box {
			border: 1px solid #ccc;
			margin: 0 0 20px 0;
			background: #fff;
		}
		
		ul.content-box-tabs {
			float: right;
			padding: 12px 15px 0 0 !important;
			margin: 0 !important;
		}
		
		ul.content-box-tabs li {
			float: left;
			margin: 0;
			padding: 0 !important;
			background-image: none !important;
		}
		
		ul.content-box-tabs li a {
			color: #333;
			padding: 8px 10px;
			display: block;
			margin: 1px;
			border-bottom: 0;
		}
		
		ul.content-box-tabs li a:hover {
			color: #57a000;
		}
		
		ul.content-box-tabs li a.current {
			background: #fff;
			border-bottom: 0;
			margin: 0;
		}
		
		.content-box-content {
			padding:15px;
			font-size: 13px;
		}
		
		.content-box-header {
			background: #e5e5e5 url('../img/bg-content-box.gif') top left repeat-x;
			margin-top: 1px;
			height: 40px;
			line-height: 40px;
			cursor: pointer;
		}
		
		.content-box-header img {
			float: right;
			width: 14px;
			height: 14px;
			padding-top: 14px;
			padding-right: 20px;
			cursor: pointer;
		}
		
		.content-box-header h3 {
			text-indent: 1em;
			font-size: 14px;
			font-weight:bold;
		}
		/************ ECG style ************/
		.chart {
			height: 400px;
			width: 100%;
			max-width: 980px;
			position:relative;
		
		}
		
		.modal {
			position: fixed;
			width: 100%;
			height: 100%;
			padding-top: 30px;
			top: 0;
			left: 0;
			background: rgba(0, 0, 0, 0.7);
			z-index: 999999;
		}
		
		.modal .chart {
			height: 60%;
			width: 90%!important;
			margin: 0 auto;
			max-width: none !important;
		}
		
		.floorBox {
			width: 100%;
		}
		
		.modal .floorBox {
			width: 90%;
			margin: 0 auto;
			height: 100px;
			color: #fff;
		}
		
		#operateList {
			resize: none;
			padding: 15px;
			font-size: 18px;
			width: 100%;
			outline:none;
		    box-sizing:border-box;
		    -webkit-box-sizing:border-box;
		    -moz-box-sizing:border-box;
		}
		
		.btn1 {
			width: 100px;
			height: 25px;
			margin: 10px 3px;
		}
		
		.btnbox {
			/* width: 91%; */
			height: 45px;
			background: #333333;
		}
		
		.modal .btnbox {
			background: none;
			text-align: center;
		}
		
		.modal .btnlist {
			  padding-left: 5%;
		}
		
		.btnlist li .fa {
			margin-right: 5px;
		}
		
		.btnlist li {
			float: left;
			height: 25px;
			margin: 10px 3px;
		}
		
		.btnlist li .btn-Normal1 {
			background-image: none;
			background-color: #DDDDDD;
			color: #333333;
		}
		/******************其他*********************/
		p {
			word-wrap: break-word;
			word-break: normal;
		}
		
		.jiange1 {
			padding-left: 15px;
		}
		
		.jiange2 {
			padding-left: 150px;
		}
		
		.show {
			display: block;
		}
		
		.hidden {
			display: none;
		}
		
		.xdclclas {
			width: 950px;
			padding: 15px;
			border: 1px solid #ccc;
			background-color: #eee;
		}
		
		.btn-Normal1 {
			padding: 5px 10px;
			border: 0px;
			border-radius: 3px;
			color: #FFF;
			cursor: pointer;
			font-family: "Microsoft YaHei", "SimSun";
			font-size: 12px;
			display: inline-block;
			font-family: "Microsoft YaHei";
		}
		
		.clear-fix:after {
			content: ".";
			display: block;
			height: 0;
			font-size: 0;
			clear: both;
			visibility: hidden;
		}
		
		.clear-fix { +
			height: 1%;
		}
		
		table.table-light {
			border: none;
			width: 96%;
			margin: 10px 0;
		}
		
		table.table-light tr td {
			padding: 5px;
			font-size: 12px;
			border: 1px #ddd solid;
			color: #333;
		}
		
		.tab-content img {
			max-width: 100%;
		}
		
		.ecgInfo {
		width: 500px;
		border: 1px solid;
		}
		
		.ecgInfo tr th {
		height: 30px;
		border: 1px solid;
		}
		
		
		.ecgInfo tr td {
		text-align: center;
		height: 30px;
		border: 1px solid;
		}
		
		.btn-export {
			position: relative;
		    right: 5px;
		    top: 5px;
		    margin-left: 15px;
		    padding: 5px 10px !important;
		}
		
		.btn-export a {
			font-size: 16px;
			padding: 0 15px;
			color: #fff !important;
		}
		
		.btn-export:hover {
			color: #fff;
			background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#01bd56), to(#009241));
			filter: progid:DXImageTransform.Microsoft.Gradient(GradientType=0,
				StartColorStr='#48d660', EndColorStr='#61b95f');
		}
		
		.btnNormal {
		    height: 30px;
		    padding: 0 15px;
		    margin: 0 5px;
		    font: normal 14px "Microsoft YaHei",Arial,"宋体",Helvetica,Verdana,Sans-serif;
		    color: #FFF;
		    line-height: normal;
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
		
		.page-box {
		    height: 30px;
		    width: 100%;
		    line-height: 30px;
		    margin: 10px 0;
		}
		
		.align-center {
		    text-align: center;
		}
	</style>
	<script>
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
		
		var baseUrl = '<%=basePath%>';
		var layerIndex;
		$(function(){
			load();
			$('.content-box-header').click(function(){
				var obj = $(this).parent().find('.content-box-content');
				if(obj.is('.show')){
					obj.removeClass('show');
					obj.addClass('hidden');
					$(this).find('img').attr('src',baseUrl+"img/open.png");
				}else{
					obj.removeClass('hidden');
					obj.addClass('show');
					$(this).find('img').attr('src',baseUrl+"img/minus.png");
					
				}
			});
		});
		
		function showExtImgXdt(ecgname, objectIds, extimes, extMillis){
			extxdt_num = 0;
			changeImgToLoad('loadextimg');	
		
			layer.close(layerIndex)
			layerIndex = $.layer({
		         type: 1,
		         title: '【'+ecgname+'】异常详情',
		         area: ['500px', 'auto'],
		         border: [3, 0.3, '#000'], //去掉默认边框
		         shade: [0], //去掉遮罩
		         closeBtn: [0, true], //去掉默认关闭按钮
		         shift: 'left', //从左动画弹出
		         page:{
		             html: '<div style="height: 200px; width: 500px; margin-top: 8px;overflow-y:scroll; border:1px solid;" >' +
		             '    <table id="tabl" class ="ecgInfo" style="width: 480px;">' +
		             '        <tr><th>序号</th><th>异常时间</th><th> </th></tr>' +
		             '    </table>' +
		             '</div>' 
		         }
		});	 
		
			appendBox(objectIds, extimes, extMillis,ecgname);
		}
		
		function changeImgToLoad(name){		
			$('.'+name).html('');
			$('.'+name).html('<img alt="正在图片" src="'+baseUrl+'img/load1.gif" style="vertical-align:middle;">正在加载图片,请稍等...</img>');			
		}
		
		//加载心电、脉搏、瞬时心率、瞬时脉率图片
		function load(){
			load_xdt();		
			load_mb('1');
			load_ssxlt('1');
			load_ssmlt('1');
			
		}
		
		function load_xdt(){
			var url="../electrocardioPulse/getElectrocardioPulseChartData";
				 $.post(url,
					{
					 memberId : "${omem.memberid}",
					 eventId : "${oecg.eventid}",
					 pageNo: "${pageNo}"
					},
			function(data){
				if(data != "" && data != null){
					var dt=JSON.parse(data);
					
		 			setChart("ecgChart", dt);
				}
				}
			); 
		}
		
		var page_ssxl = 0;
		function load_ssxlt(type){
			var hrecgPage = "${hrecgPage}";
			if(hrecgPage == 0 || hrecgPage == "" || hrecgPage == null || hrecgPage == undefined){
				return;
			}
			
			 if(type == "1"){
				 page_ssxl++; 
				 if(page_ssxl <= hrecgPage){
					var url="../electrocardioPulse/getInstanceHeartRateChartData";
						$.post(url,
							{page : page_ssxl,
							 memberId : "${omem.memberid}",
							 eventId : "${oecg.eventid}",
							 pageNo: "${pageNo}"
							},
					function(data){
						var dt=JSON.parse(data);
			 			setChart("instantChart", dt);
			 			$('#ssxltindex').html('');
			 			$('#ssxltindex').html((page_ssxl));		
						}
					); 
				}else{
					alert("没有下一张");
					page_ssxl--;
				} 
			}else{
				page_ssxl--;
				if(page_ssxl>0 && page_ssxl <= hrecgPage){
					var url="../electrocardioPulse/getInstanceHeartRateChartData";
					 $.post(url,
						{page : page_ssxl,
						memberId : "${omem.memberid}",
						eventId : "${oecg.eventid}",
						pageNo: "${pageNo}"
						},
						function(data){
							var dt=JSON.parse(data);
		 					setChart("instantChart", dt);
		 					$('#ssxltindex').html('');
		 					$('#ssxltindex').html((page_ssxl));	
						}
					); 
				}else{
					alert("没有上一张");
					page_ssxl++;
				}  
			}  
		}
		
		
		var page_mb = 0;
		function load_mb(type){
			var total_mb = "${ppgPage}";
			if(total_mb == 0 || total_mb == "" || total_mb == null || total_mb == undefined){
				return;
			}
			 if(type == "1"){
				 page_mb++; 
					 if(page_mb <= total_mb){
						var url="../electrocardioPulse/getPulseChartData";
							$.post(url,
								{page : page_mb,
								 memberId : "${omem.memberid}",
								 eventId : "${oppg.eventid}",
								 pageNo: "${pageNo}"
								},
						function(data){
							if(data != null && data != ""){
								var dt=JSON.parse(data);
					 			setChart("sphygmusChart", dt);
					 			$('#mbindex').html('');
					 			$('#mbindex').html((page_mb));	
							}
						}
						); 
					}else{
						alert("没有下一张");
						page_mb--;
					} 
				}else{
					page_mb--;
					if(page_mb>0 && page_mb <= total_mb){
						var url="../electrocardioPulse/getPulseChartData";
						 $.post(url,
							{page : page_mb,
							 memberId : "${omem.memberid}",
							 eventId : "${oppg.eventid}",
							 pageNo: "${pageNo}"
							},
							function(data){
								var dt=JSON.parse(data);
			 					setChart("sphygmusChart", dt);
			 					$('#mbindex').html('');
			 					$('#mbindex').html((page_mb));	
								}
						); 
					}else{
						alert("没有上一张");
						page_mb++;
					}  
				}  
			}
		
		var page_ssmlt = 0;
		function load_ssmlt(type){
			var total_ssmlt = "${hrppgPage}";
			if(total_ssmlt == 0 || total_ssmlt == "" || total_ssmlt == null || total_ssmlt == undefined){
				return;
			}
			 if(type == "1"){
				 page_ssmlt++; 
					 if(page_ssmlt <= total_ssmlt){
						var url="../electrocardioPulse/getInstancePulseRateChartData";
							$.post(url,
								{page : page_ssmlt,
								 memberId : "${omem.memberid}",
								 eventId : "${oppg.eventid}",
								 pageNo: "${pageNo}"
								},
						function(data){
							if(data != null && data != ""){
								var dt=JSON.parse(data);
					 			setChart("instantSphygmusChart", dt);
					 			$('#ssmltindex').html('');
					 			$('#ssmltindex').html((page_ssmlt));	
							}
						}
						); 
					}else{
						alert("没有下一张");
						page_ssmlt--;
					} 
				}else{
					page_ssmlt--;
					if(page_ssmlt>0 && page_ssmlt <= total_ssmlt){
						var url="../electrocardioPulse/getInstancePulseRateChartData";
						 $.post(url,
							{page : page_ssmlt,
							 memberId : "${omem.memberid}",
							 eventId : "${oppg.eventid}",
							 pageNo: "${pageNo}"
							},
							function(data){
								var dt=JSON.parse(data);
			 					setChart("instantSphygmusChart", dt);
			 					$('#ssmltindex').html('');
			 					$('#ssmltindex').html((page_ssmlt));	
								}
						); 
					}else{
						alert("没有上一张");
						page_ssmlt++;
					}  
				}  
		}
		
		function reportinfo(content){
			if($('#excinfo').text() == ""){
				$("#noexcinfo").text("");
				$('#excinfo').text(content);
			}else{
				$('#excinfo').text($('#excinfo').text()+","+content);
			}
		}
		
		function previewReport(eventId, memberId, pageNo){
			//标识心电图复选框是否选中
			var flag = false;
			if($("#checkId").is(':checked')){
				flag = true;
			}
			window.open("../electrocardioPulse/previewElectrocardioPulseReport?eventId="+eventId+"&memberId="+memberId+"&pageNo="+pageNo+"&flag="+flag);
		}
	
	</script>
</head>
<body>
	<div>
		<input id="pagenow" type="hidden" value="${pageNo}" /> 
		<input id="memberid" type="hidden" value="${omem.memberid}" />
		<input id="eventid" type="hidden" value="${oecg.eventid }" />
		<input id="ecgType" type="hidden" value="ecg" />
		<c:if test="${empty oecg}"><div class="empty-info">目前还没有三合一测量数据</div></c:if>
		<c:if test="${not empty oecg}">
			
			<div class="border-1px">
			<c:if test="${view ne 1 }">
				<div class="page" style="padding: 10px 0;overflow:hidden;position: relative;">
					<c:if test="${pageNo > 0 }">
						<a class="btn-normal5" href="../electrocardioPulse/showSingleElectroPulse?pageNo=${pageNo-1 }&memberId=${omem.memberid }&flag=${flag}">上一条</a>&nbsp;&nbsp;
					</c:if>
					<c:if test="${pageNo+1 < total}">
						<a class="btn-normal5" href="../electrocardioPulse/showSingleElectroPulse?pageNo=${pageNo+1 }&memberId=${omem.memberid }&flag=${flag}">下一条</a>
					</c:if>
					<a class="btn-normal5" href="../electrocardioPulse/showSingleElectroPulse?pageNo=${total-1 }&memberId=${omem.memberid }&flag=${flag}">最后</a>&nbsp;&nbsp;
					<a class="btn-normal5" onclick="previewReport('${oecg.eventid}','${omem.memberid}','${pageNo}');">导出测量报告</a>
				</div>
				</c:if>
				<div class="framewin clear-fix">
					<div class="xdinfo">
						<!-- 测量信息 -->
						<div class="content-box">
							<div class="content-box-header clear-fix">
								<img src="<%=basePath%>img/minus.png" />
								<h3>测量信息</h3>
							</div>
							<!-- End .content-box-header -->
							<div class="content-box-content show">
								<div class="tab-content default-tab">
									<h4>会员信息</h4>
									<table class="table-light">
										<tr>
											<td width="15%" align="right">会员名称：</td>
											<td width="30%" align="left">${omem.memname}</td>
											<td width="15%" align="right">会员电话：</td>
											<td align="left">${omem.tel }</td>
										</tr>
									</table>
								</div>
								<br />
								<div class="tab-content default-tab">
									<h4>概述</h4>
									<ul>
									<li>
										<table class="table-light">
											<tr>
												<td width="15%" align="right">测量时间：</td>
												<td width="30%" align="left"><fmt:formatDate
														value="${oecg.meastime}"
														pattern="yyyy-MM-dd HH:mm:ss" /></td>
												<td width="15%" align="right">测量时长：</td>
												<td align="left">${timeLength }</td>
											</tr>
										</table>
										<p>
											您本次测量结果：
											<font color="red">
												<span id="noexcinfo">本次测量未发现异常</span>
												<span id="excinfo"></span>
											</font>
											<script>
												if('${oecgExcStr}' != ""){
													reportinfo('${oecgExcStr}');
												}
											</script>
										</p>
									</li>
									</ul>
								</div>
								<br />
								<div class="tab-content default-tab">
									<h4>心电</h4>
									<table class="table-light">
										<tr>
											<td width="15%" align="right">总心搏数：</td>
											<td width="30%">${oecg.heartnum }个</td>
											<td width="10%" align="right">平均心率：</td>
											<td>${oecg.averageheart }bpm</td>
										</tr>
										<tr>
											<td width="15%" align="right">最大心率：</td>
											<td width="30%">${oecg.fastestbeat}bpm</td>
											<td width="10%" align="right">最大心率发生时间：</td>
											<td><fmt:formatDate	value="${hfd}"
														pattern="HH:mm:ss" /></td>
										</tr>
										<tr>
											<td width="15%" align="right">最小心率：</td>
											<td width="30%">${oecg.slowestbeat}bpm</td>
											<td width="15%" align="right">最小心率发生时间：</td>
											<td><fmt:formatDate	value="${hsd}"
													pattern="HH:mm:ss" /></td>
										</tr>
									</table>
								</div>
								<br />
								<div class="tab-content default-tab">
									<h4>脉搏</h4>
									<table class="table-light">
										<tr>
											<td width="15%" align="right">总脉搏数：</td>
											<td width="30%">${pulseTotal }个</td>
											<td width="10%" align="right">平均脉率：</td>
											<td>${oppg.pulserate }bpm</td>
										</tr>
										<tr>
											<td width="15%" align="right">最大脉率：</td>
											<td width="30%">${oppg.quickpulse}bpm</td>
											<td width="10%" align="right">最大脉率发生时间：</td>
											<td><fmt:formatDate	value="${pfd}"
													pattern="HH:mm:ss" /></td>
										</tr>
										<tr>
											<td width="15%" align="right">最小脉率：</td>
											<td width="30%">${oppg.slowpulse}bpm</td>
											<td width="15%" align="right">最小脉率发生时间：</td>
											<td><fmt:formatDate	value="${psd}"
													pattern="HH:mm:ss" /></td>
										</tr>
									</table>
								</div>
							</div>
						</div>
					</div>
					<!-- end -->
					<!-- 心电图 -->
					<div class="content-box">
						<div class="content-box-header clear-fix">
							<img src="<%=basePath%>img/open.png" />
							<h3>心电图</h3>
						</div>
						<!-- End .content-box-header -->
						<div id="ecgbox" class="content-box-content hidden">
							<div class="tab-content default-tab">
								<div class="chart-container">
									<div class="btnbox">
										<ul class="btnlist" style="overflow: hidden;">
											<li><a href="javascript: void(0)" class="btn-Normal1"
												id="btn_move"><i class="fa fa-times"></i>拖动</a></li>
											<!-- <li><a href="javascript: void(0)" class="btn-normal" id ="btn_full" ><i class="fa fa-arrows"></i>全屏</a></li> -->
											<li><a href="javascript: void(0)" class="btn-Normal1"
												id="btn_select"><i class="fa fa-hand-o-up"></i>选择</a></li>
											<li><a href="javascript: void(0)" class="btn-Normal1"
												id="btn_addExc"><i class="fa fa-plus"></i>添加异常</a></li>
											<li><a href="javascript: void(0)" class="btn-Normal1"
												id="btn_delExc"><i class="fa fa-minus"></i>删除异常</a></li>
											<li><a href="javascript: void(0)" class="btn-Normal1"
												id="btn_delECG"><i class="fa fa-remove"></i>删除心电图</a></li>
											<li><a href="javascript: void(0)" class="btn-Normal1"
												id="btn_undo"><i class="fa fa-reply"></i>撤销</a></li>
											<li><a href="javascript: void(0)" class="btn-Normal1"
												id="btn_back"><i class="fa fa-share"></i>还原</a></li>
											<li style="padding: 0 5px; color:#FFF; float: right; line-height:25px;">
												<input id="checkId" type="checkbox" style="vertical-align: middle;" />
												<span>作为正常心电图加入到报告中</span>
											</li>
										</ul>
									</div>
									<input type="hidden" id="isMove" value="true">
							        <div id="ecgChart" class="chart"></div>
									<table class="floorBox">
										<tr>
											<td colspan="3" style="padding: 10px 0;"><span>
													说明：Shift键 + 鼠标左键按下可以拖动，双击全屏显示</span></td>
										</tr>
										<tr>
											<td>操作记录：</td>
											<td><textarea name="operateList"  readonly="readonly" id="operateList"
													cols="80" rows="6"></textarea></td>
											<td><input type="button" class="btn1" id="btn_rese"
												value="还原到最初"> <br /> <input type="button"
												id="btn_reanalyse" class="btn1" value="重新分析"></td>
										</tr>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- 心电图 end-->
				<!-- 心电测量指标 -->
				<div class="content-box ">
					<div class="content-box-header clear-fix">
						<img src="<%=basePath%>img/open.png" />
						<h3>心电测量指标</h3>
					</div>
					<!-- End .content-box-header -->
					<div class="content-box-content hidden">
						<div class="tab-content default-tab ">
							<table class="main-content table-heavy">
								<thead>
									<tr>
										<th>测量项</th>
										<th>异常次数</th>
										<th>异常比率</th>
										<th>结果</th>
										<th>异常详情</th>
									</tr>
								</thead>
								<tbody id="tbody">
									<c:forEach items="${oecgExcs}" var="ecgExc">
										<tr>
											<td>${ecgExc.expCname}</td>
											<td>${ecgExc.expNum}</td>
											<c:choose> 
												<c:when test="${ecgExc.expNum == 0}">
													<td>0</td>
													<td></td>
													<td></td>
												</c:when>
												<c:otherwise>
													<td>${ecgExc.expRate }%</td>
													<td><img src="<%=basePath%>img/icon_add_16.png"></td>
													<td><a href="javascript:showExtImgXdt('${ecgExc.expCname}',${ecgExc.objectIds},${ecgExc.extimes},${ecgExc.extMss});">异常详情</a></td>
												</c:otherwise>
											</c:choose>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<!-- 心电测量指标 end-->
				<!-- 瞬时心率图 -->
				<div class="content-box column_left11 column_left1_j">
					<div class="content-box-header clear-fix">
						<img src="<%=basePath%>img/open.png" />
						<h3>瞬时心率图</h3>
					</div>
					<!-- End .content-box-header -->
					<div class="content-box-content hidden" style="padding:15px 0;">
						<div id="ssxlt" class="tab-content default-tab">
							<ul>
							<li id="instantChart" class="load_ssxlt" style="list-style: none"></li>
							<c:if test="${not empty hrecgPage}">
								<li style="padding:0px 15px;">当前第<span id="ssxltindex"></span>张/共${hrecgPage}张&nbsp;&nbsp;&nbsp; <a
									href="javascript:load_ssxlt('2');" class="btn-normal">上一张</a> <a
									href="javascript:load_ssxlt('1');" class="btn-normal">下一张</a>
								</li>
							</c:if>
							</ul>
						</div>
					</div>
				</div>
				<!-- 瞬时心率图 end-->
				<!-- 心功能参数 -->
				<div class="content-box column_left11">
					<div class="content-box-header clear-fix">
						<img src="<%=basePath%>img/open.png" />
						<h3>心功能参数</h3>
					</div>
					<!-- End .content-box-header -->
					<div class="content-box-content hidden">
						<div class="tab-content default-tab">
							<table class="main-content table-heavy">
								<thead>
									<tr>
										<th width="33%">测量项</th>
										<th width="33%">测量结果</th>
										<th width="33%">参考范围</th>
									</tr>
								</thead>

								<tbody>
									<tr>
										<td>平均脉率 PR</td>
										<td>${oppg.pulserate}<c:if
												test="${oppg.pulserate<55}">
												<img alt="" src="<%=basePath%>img/down.png">
												<script>
													var statusTag = "${oppg.statustag}";
													if(statusTag == 2){
														reportinfo('平均脉率PR(偏低)');
													}
												</script>
											</c:if> <c:if test="${oppg.pulserate>100}">
												<img alt="" src="<%=basePath%>img/up.png">
												<script>
													var statusTag = "${oppg.statustag}";
													if(statusTag == 2){
														reportinfo('平均脉率PR(偏高)');
													}
												</script>
											</c:if>
										</td>
										<td>55-100次/分</td>
									</tr>
									<tr>
										<td>平均每分射血量 co</td>
										<td>${oppg.co}<c:if
												test="${oppg.co<3}">
												<img alt="" src="<%=basePath%>img/down.png">
												<script>
													var statusTag = "${oppg.statustag}";
													if(statusTag == 2){
														reportinfo('平均每分射血量co(偏低)');
													}
												</script>
											</c:if> <c:if test="${oppg.co>7.5}">
												<img alt="" src="<%=basePath%>img/up.png">
												<script>
													var statusTag = "${oppg.statustag}";
													if(statusTag == 2){
														reportinfo('平均每分射血量co(偏高)');
													}
												</script>
											</c:if>
										</td>
										<td>3-7.5L/min</td>
									</tr>
									<tr>
										<td>心脏每搏射血量 SV</td>
										<td>${oppg.sv}<c:if
												test="${oppg.sv<55}">
												<img alt="" src="<%=basePath%>img/down.png">
												<script>
													var statusTag = "${oppg.statustag}";
													if(statusTag == 2){
														reportinfo('心脏每搏射血量SV(偏低)');
													}
												</script>
											</c:if> <c:if test="${oppg.sv>105}">
												<img alt="" src="<%=basePath%>img/up.png">
												<script>
													var statusTag = "${oppg.statustag}";
													if(statusTag == 2){
														reportinfo('心脏每搏射血量SV(偏高)');
													}
												</script>
											</c:if>
										</td>
										<td>55-105ml/搏</td>
									</tr>
									<tr>
										<td>血氧饱和度SO</td>
										<td>${oppg.spo}<c:if
												test="${oppg.spo<95}">
												<img alt="" src="<%=basePath%>img/down.png">
												<script>
													var statusTag = "${oppg.statustag}";
													if(statusTag == 2){
														reportinfo('血氧饱和度SO(偏低)');
													}
												</script>
											</c:if> <c:if test="${oppg.spo>100}">
												<img alt="" src="<%=basePath%>img/up.png">
												<script>
													var statusTag = "${oppg.statustag}";
													if(statusTag == 2){
														reportinfo('血氧饱和度SO(偏高)');
													}
												</script>
											</c:if>
										</td>
										<td>95%-100%</td>
									</tr>
									<tr>
										<td>心指数 CI</td>
										<td>${oppg.ci}<c:if
												test="${oppg.ci<2.3}">
												<img alt="" src="<%=basePath%>img/down.png">
												<script>
													var statusTag = "${oppg.statustag}";
													if(statusTag == 2){
														reportinfo('心指数CI(偏低)');
													}
												</script>
											</c:if> <c:if test="${oppg.ci>100}">
												<img alt="" src="<%=basePath%>img/up.png">
												<script>
													var statusTag = "${oppg.statustag}";
													if(statusTag == 2){
														reportinfo('心指数CI(偏高)');
													}
												</script>
											</c:if>
										</td>
										<td>2.3-100</td>
									</tr>
									<tr>
										<td>心搏指数SPI</td>
										<td>${oppg.spi}<c:if
												test="${oppg.spi<33}">
												<img alt="" src="<%=basePath%>img/down.png">
												<script>
													var statusTag = "${oppg.statustag}";
													if(statusTag == 2){
														reportinfo('心搏指数SPI(偏低)');
													}
												</script>
											</c:if> <c:if test="${oppg.spi>200}">
												<img alt="" src="<%=basePath%>img/down.png">
												<script>
													var statusTag = "${oppg.statustag}";
													if(statusTag == 2){
														reportinfo('心搏指数SPI(偏高)');
													}
												</script>
											</c:if>
										</td>
										<td>33-200</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<!-- 心功能参数 end-->
				<!-- 血管外围-->
				<div class="content-box column_left11 column_left1_j">
					<div class="content-box-header clear-fix">
						<img src="<%=basePath%>img/open.png" />
						<h3>外周血管参数</h3>
					</div>
					<!-- End .content-box-header -->
					<div class="content-box-content hidden">
						<div class="tab-content default-tab">
							<table class="main-content table-heavy">
								<thead>
									<tr>
										<th width="33%">测量项</th>
										<th width="33%">测量结果</th>
										<th width="33%">参考范围</th>
									</tr>
								</thead>

								<tbody>
									<tr>
										<td>波形特征量 K</td>
										<td>${oppg.k}<c:if
												test="${oppg.k<0.29}">
												<img alt="" src="<%=basePath%>img/down.png">
												<script>
													var statusTag = "${oppg.statustag}";
													if(statusTag == 2){
														reportinfo('波形特征量K(偏低)');
													}
												</script>
											</c:if> <c:if test="${oppg.k>0.46}">
												<img alt="" src="<%=basePath%>img/up.png">
												<script>
													var statusTag = "${oppg.statustag}";
													if(statusTag == 2){
														reportinfo('波形特征量K(偏高)');
													}
												</script>
											</c:if>
										</td>
										<td>0.29-0.46</td>
									</tr>
									<tr>
										<td>血液黏度</td>
										<td>${oppg.v}<c:if
												test="${oppg.v<3}">
												<img alt="" src="<%=basePath%>img/down.png">
												<script>
													var statusTag = "${oppg.statustag}";
													if(statusTag == 2){
														reportinfo('血液黏度(偏低)');
													}
												</script>
											</c:if> <c:if test="${oppg.v>5.04}">
												<img alt="" src="<%=basePath%>img/up.png">
												<script>
													var statusTag = "${oppg.statustag}";
													if(statusTag == 2){
														reportinfo('血液黏度(偏高)');
													}
												</script>
											</c:if>
										</td>
										<td>3-5.04cp</td>
									</tr>
									<tr>
										<td>外周阻力 TPR</td>
										<td>${oppg.tpr}<c:if
												test="${oppg.tpr<750}">
												<img alt="" src="<%=basePath%>img/down.png">
												<script>
													var statusTag = "${oppg.statustag}";
													if(statusTag == 2){
														reportinfo('外周阻力TPR(偏低)');
													}
												</script>
											</c:if> <c:if test="${oppg.tpr>1450}">
												<img alt="" src="<%=basePath%>img/up.png">
												<script>
													var statusTag = "${oppg.statustag}";
													if(statusTag == 2){
														reportinfo('外周阻力TPR(偏高)');
													}
												</script>
											</c:if>
										</td>
										<td>750-1450dy*S*cm</td>
									</tr>
									<tr>
										<td>血管顺应度 AC</td>
										<td>${oppg.ac}<c:if
												test="${oppg.ac<1.2}">
												<img alt="" src="<%=basePath%>img/down.png">
												<script>
													var statusTag = "${oppg.statustag}";
													if(statusTag == 2){
														reportinfo('血管顺应度AC(偏低)');
													}
												</script>
											</c:if> <c:if test="${oppg.ac>3}">
												<img alt="" src="<%=basePath%>img/up.png">
												<script>
													var statusTag = "${oppg.statustag}";
													if(statusTag == 2){
														reportinfo('血管顺应度AC(偏高)')
													}
												</script>
											</c:if>
										</td>
										<td>1.2-3dy.s.c</td>
									</tr>
									<tr>
										<td>平均动脉压</td>
										<td>${oppg.pm}<c:if
												test="${oppg.pm<70}">
												<img alt="" src="<%=basePath%>img/down.png">
												<script>
													var statusTag = "${oppg.statustag}";
													if(statusTag == 2){
														reportinfo('平均动脉压(偏低)');
													}
												</script>
											</c:if> <c:if test="${oppg.pm>105}">
												<img alt="" src="<%=basePath%>img/up.png">
												<script>
													var statusTag = "${oppg.statustag}";
													if(statusTag == 2){
														reportinfo('平均动脉压(偏高)');
													}
												</script>
											</c:if>
										</td>
										<td>70-105 mmHg</td>
									</tr>
									<tr>
										<td>血管硬化指数</td>
										<td>${oppg.si}<c:if
												test="${oppg.si<0}">
												<img alt="" src="<%=basePath%>img/down.png">
												<script>
													var statusTag = "${oppg.statustag}";
													if(statusTag == 2){
														reportinfo('血管硬化指数(偏低)');
													}
												</script>
											</c:if> <c:if test="${oppg.si>8}">
												<img alt="" src="<%=basePath%>img/up.png">
												<script>
													var statusTag = "${oppg.statustag}";
													if(statusTag == 2){
														reportinfo('血管硬化指数(偏高)');
													}
												</script>
											</c:if>
										</td>
										<td>0-8</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<!-- 血管外围参数 end-->
				<!-- 脉搏波图-->
				<div class="content-box column_left11">
					<div class="content-box-header clear-fix">
						<img src="<%=basePath%>img/open.png" />
						<h3>脉搏波图</h3>
					</div>
					<div class="clear"></div>
					<!-- End .content-box-header -->
					<div class="content-box-content hidden" style="height: 450px;padding:15px 0px;">
						<div id="mbbt" class="tab-content default-tab ">
							<ul>
								<li id="sphygmusChart" class="load_mbbt" style="list-style: none;"></li>
								<c:if test="${not empty ppgPage }">
									<li style="padding:0px 15px;">当前第<span id="mbindex"></span>张/共${ppgPage }
										张&nbsp;&nbsp;&nbsp; <a
									href="javascript:load_mb('2');" class="btn-normal">上一张</a>&nbsp;&nbsp;
									<a href="javascript:load_mb('1');" class="btn-normal">下一张</a>
									</li>
								</c:if>
							</ul>
						</div>
					</div>
				</div>
				<!-- 脉搏波图 end-->
				<!-- 瞬时脉率图 -->
				<div class="content-box column_left11 column_left1_j">
					<div class="content-box-header clear-fix">
						<img src="<%=basePath%>img/open.png" />
						<h3>瞬时脉率图</h3>
					</div>
					<!-- End .content-box-header -->
					<div class="content-box-content hidden" style="padding:15px 0;">
						<div id="ssmlt" class="tab-content default-tab">
							<ul>
							<li id="instantSphygmusChart" class="load_ssmlt" style="list-style: none;"></li>
							<c:if test="${not empty hrppgPage}">
								<li style="padding:0px 15px;">当前第<span id="ssmltindex"></span>张/共${hrppgPage }
								 	 张&nbsp;&nbsp;&nbsp; 
									<a href="javascript:load_ssmlt('2');" class="btn-normal">上一张</a>&nbsp;&nbsp;
									<a href="javascript:load_ssmlt('1');" class="btn-normal">下一张</a>
								</li> 
							</c:if>
							</ul>
						</div>
					</div>
				</div>
				<!-- 瞬时心率图 end-->
			</div>
			<c:if test="${view eq 1 }">
			<div class="page-box align-center">
				<button type="button" class="btnNormal" onclick="history.go(-1);">返回</button>
			</div>
			</c:if>
		</c:if>
	</div>
</body>
<script type="text/javascript" src="<%=path %>/js/elvin-plus.js"></script>
</html>
