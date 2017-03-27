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
   	<meta charset="utf-8">
   	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>心电单次测量结果</title>
   	<link rel="shortcut icon" type="image/x-icon" href="<%=path %>/<%=getServletContext().getAttribute("img") %>/title_ico.ico" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/comm.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/reset.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/celiangsing.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/layer/layer/skin/layer.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/plugins/font-awesome/css/font-awesome.min.css">

	<script type="text/javascript" src="<%=path %>/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer/layer.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/showInfo.js"></script>
	<script type="text/javascript" src="<%=path %>/js/highstock.js"></script>
	<script type="text/javascript" src="<%=path %>/js/exporting.js"></script>
	<script type="text/javascript" src="<%=path %>/js/data.js"></script>
	<script type="text/javascript" src="<%=path %>/plugins/My97DatePicker/WdatePicker.js"></script>
	<style type="text/css">
		html {
			font-size: 100%;
			/* height: 100%; */
			margin-bottom: 1px;
			/* Always show a scrollbar to avoid jumping when the scrollbar appears  */
		}
		
		body {
			font-family: "Microsoft YaHei", Arial, Helvetica, sans-serif;
			color: #555;
			font-size: 12px;
		}
		
		.clear {
			clear: both;
		}
		
		.page {
			width: auto;
			height: auto;
		}
		
		a {
			text-decoration: none;
			outline: none;
		}
		
		.pagemove {
			margin-top: 30px;
			margin-bottom: 30px;
		}
		
		.pagemove img {
			padding-left: 30px;
		}
		
		.xdinfo {
			
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
		
		.content-box-header {
			background: #e5e5e5 url('../img/bg-content-box.gif') top left repeat-x;
			margin-top: 1px;
			height: 40px;
			line-height: 40px;
			cursor: pointer;
		}
		
		.content-box-header h3 {
			margin: 0;
			text-indent: 1em;
			float: left;
			font-size: 14px;
			font-weight: bold;
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
			border: 1px solid #ccc;
			border-bottom: 0;
			margin: 0;
		}
		
		.content-box-content {
			padding: 20px 10px;
			font-size: 13px;
			border-top: 1px solid #ccc;
		}
		
		.content-box-header img {
			float: right;
			width: 14px;
			height: 14px;
			padding-top: 14px;
			padding-right: 20px;
			cursor: pointer;
		}
		/************ Table ************/
		table {
			border-collapse: collapse;
			border-spacing: 0;
		}
		
		.table-heavy {
			border: 1px solid #ddd;
			width: 100%;
			border-collapse: collapse;
			text-align: center;
			font-size: 14px;
		}
		
		.table-heavy  thead th {
			font-weight: bold;
			font-size: 14px;
			border-bottom: 1px solid #ddd;
		}
		
		.table-heavy  tr td {
			border-bottom: 1px solid #ddd;
			font-size: 13px;
		}
		
		.table-heavy tbody tr {
			background: #fff;
		}
		
		.table-heavy tbody tr.alt-row {
			background: #f3f3f3;
		}
		
		.table-heavy  td, .table-heavy  th {
			padding: 10px;
			line-height: 1.3em;
		}
		
		.table-heavy  tfoot td .bulk-actions {
			padding: 15px 0 5px 0;
		}
		
		.table-heavy  tfoot td .bulk-actions select {
			padding: 4px;
			border: 1px solid #ccc;
		}
		/************ ECG style ************/
		.chart {
			height: 400px;
			width: 100%;
			max-width: 980px;
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
		    box-sizing: border-box;
		    -webkit-box-sizing: border-box;
		    -moz-box-sizing: border-box;
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
		
		.btnlist li .btn-normal9 {
			background-image: none;
			background-color: #DDDDDD;
			color: #333333;
		    padding: 5px 10px;
		    border-radius: 3px;
		    cursor: pointer;
		    font-family: "Microsoft YaHei", "SimSun";
		    font-size: 12px;
		    display: inline-block;
		    font-family: "Microsoft YaHei";
		    border: 1px solid #ccc;
		}
		
		#loadImg {
			text-align: center;
			position: relative;
			top: 200px;
			z-index: 9999;
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
		
		.btn-normal {
			padding: 5px 10px;
			border: 0;
			border-radius: 3px;
			color: #FFF;
			cursor: pointer;
			font-family: "Microsoft YaHei", "SimSun";
			font-size: 12px;
			display: inline-block;
			font-family: "Microsoft YaHei";
			background-image: -moz-linear-gradient(center top, rgba(072, 214, 096, 0.8),
				rgba(097, 185, 095, 0.8)) repeat scroll 0 0 rgba(072, 214, 096, 0.8);
			background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, rgba(072,
				214, 096, 0.8)), color-stop(1, rgba(097, 185, 095, 0.8)));
			filter: progid:DXImageTransform.Microsoft.Gradient(GradientType=0,
				StartColorStr='#48d660', EndColorStr='#61b95f');
		}
		
		.btn-Normal1 {
			padding: 5px 10px;
			border: 0;
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
			border: 1px solid #ddd;
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
		
		.width-initial {
			width: initial !important;
		}
		
		.inquiry {
			line-height: normal !important;
		}
		
		.mr-8 {
			display: inline-block;
			margin: 0 8px;
			color: #fff;
		}
		
		.btn-normal6 {
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
		
		.btn-normal6:hover {
			color: #fff;
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
		
		
		/****
		加载异常图片 
		showExtImgXdt
		****/
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
			load_xdt(1);		
			load_ssxlt('1');
		}
		
		var xdt_num = 0;
		var totalPage = -1;
		function load_xdt(type){
			var showTimeLength = $("#showTimeLength").val();
			var initTotalPage = "${totalPage}";
			if(totalPage == -1){
				 totalPage = initTotalPage;
			 }
			 $("#totalPage").html(totalPage);
			 var startTime = $("#startTime").val();
			 var endTime = $("#endTime").val();
			 
			 if(totalPage == 0){
				 $('#xdtindex').html(0);
				 setChart("ecgChart", {});
				 return;
			 }
			
			 if(type == "1"){
				xdt_num++;
				if(xdt_num <= totalPage){
					var url="../electrocardio/getElectrocardioChartData";
					$.ajax({
						 url:url,
						 data:{
							 showTimeLength : showTimeLength,
							 startTime: startTime,
							 endTime: endTime,
							 memberId: "${omem.memberid}",
							 eventId: "${oecg.eventid}",
							 pageNo: "${pageNo}",
							 page: xdt_num 
							},
						type:"POST",
						dataType:"text",
						success:function(data){
							var dt=JSON.parse(data);
							setChart("ecgChart", dt);	
				 			
				 			$('#xdtindex').html('');
				 			$('#xdtindex').html((xdt_num));
				 			$('#jumpPage').val(xdt_num);
						}
					 });
				}else{
					alert("没有下一页");
					xdt_num--;
				}
			 }else if(type == "2"){
				 xdt_num--;
				if(xdt_num>0 && xdt_num <= totalPage){
					var url="../electrocardio/getElectrocardioChartData";
					$.ajax({
						 url:url,
						 data:{
							 showTimeLength : showTimeLength,
							 startTime: startTime,
							 endTime: endTime,
							 memberId: "${omem.memberid}",
							 eventId: "${oecg.eventid}",
							 pageNo: "${pageNo}",
							 page: xdt_num 
							},
						type:"POST",
						dataType:"text",
						success:function(data){
							var dt=JSON.parse(data);
				 			setChart("ecgChart", dt);	
				 			
				 			$('#xdtindex').html('');
				 			$('#xdtindex').html((xdt_num));
				 			$('#jumpPage').val(xdt_num);
						}
					 });
				}else{
					alert("没有上一页");
					xdt_num++;
				}
			 }else if(type == "3"){
				 xdt_num = parseInt($("#jumpPage").val());
					
					if(xdt_num>0 && xdt_num <= totalPage){
						var url="../electrocardio/getElectrocardioChartData";
						
						$.ajax({
							 url:url,
							 data:{
								 showTimeLength : showTimeLength,
								 startTime: startTime,
								 endTime: endTime,
								 memberId: "${omem.memberid}",
								 eventId: "${oecg.eventid}",
								 pageNo: "${pageNo}",
								 page: xdt_num 
								},
							type:"POST",
							async:false,
							dataType:"text",
							success:function(data){
								var dt=JSON.parse(data);
					 			setChart("ecgChart", dt);
					 			
					 			//设置加载心电图时长时，总页数也相应改变，获取最新总页数
					 			totalPage = dt.totalPage;
					 			$("#totalPage").html(totalPage);
					 			
								$('#xdtindex').html('');
			 					$('#xdtindex').html((xdt_num));
							}
						 });
					}else{
						if(isNaN(xdt_num)){
							alert("输入格式不符");
						}else{
							if(xdt_num < 1){
								xdt_num = $("#xdtindex").html();
								alert("已超出最小值");
								$("#jumpPage").val(xdt_num);
							}else if(xdt_num > totalPage){
								xdt_num = $("#xdtindex").html();
								alert("已超出最大值");
								$("#jumpPage").val(xdt_num);
							}
						}
					}
			 }else{
				 var url="../electrocardio/getElectrocardioChartData";
					
					$.ajax({
						 url:url,
						 data:{
							 showTimeLength : showTimeLength,
							 startTime: startTime,
							 endTime: endTime,
							 memberId: "${omem.memberid}",
							 eventId: "${oecg.eventid}",
							 pageNo: "${pageNo}",
							 page: xdt_num  
							},
						type:"POST",
						async:false,
						dataType:"text",
						success:function(data){
							var dt=JSON.parse(data);
				 			setChart("ecgChart", dt);
				 			
				 			//设置加载心电图时长时，总页数也相应改变，获取最新总页数
				 			totalPage = dt.totalPage;
				 			$("#totalPage").html(totalPage);
				 			xdt_num = 1;
				 			$("#jumpPage").val(1);
							$('#xdtindex').html('');
							$('#xdtindex').html((xdt_num));
						}
					 });
			 }
		}
			
			
		function setTimeLength(){
			var maxTimeLength = Math.ceil($("#timeLength").val()/60);
			var showTimeLength = $("#showTimeLength").val();
			var reg = new RegExp(/^[1-9]\d*$/);
			
			if(reg.test(showTimeLength)){
				if(showTimeLength <= maxTimeLength){
					if(showTimeLength > 120){
						alert("时间设置过大");
					}else{
						$("#jumpPage").val(1);
						load_xdt('3');
					}
				}else{
					alert("时间设置已超过最大值");
				};
			}else{
				alert("输入格式不符");
			}
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
					var url="../electrocardio/getInstanceHeartRateChartData";
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
					var url="../electrocardio/getInstanceHeartRateChartData";
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
	</script>
</head>
<body>
	<div>
		<input id="pagenow" type="hidden" value="${pageNo}" />
		<input id="memberid" type="hidden" value="${omem.memberid}" />
		<input id="eventid" type="hidden" value="${oecg.eventid}" />
		<input id="ecgType" type="hidden" value="miecg" />
		<input id="measTime" type="hidden" value="<fmt:formatDate value='${oecg.meastime}' pattern='yyyy-MM-dd HH:mm:ss' />"/>
		<input id="timeLength" type="hidden" value="${oecg.timelength}"/>
		<input id="endTimeStr" type="hidden" value="${endTimeStr}"/>
		<c:if test="${empty oecg}"><div class="empty-info">目前还没有心电测量数据</div></c:if >
		<c:if test="${not empty oecg}">
			
			<c:if test="${view ne 1 }">
			<div class="page" style="padding: 10px 0;">
				<c:if test="${pageNo > 0}">
					<a class="btn-normal6" href="../electrocardio/showSingleElectrocardio?pageNo=${pageNo-1 }&memberId=${omem.memberid }&flag=${flag}">上一次</a>&nbsp;&nbsp;
				</c:if>
				<c:if test="${pageNo+1 < total}">
					<a class="btn-normal6" href="../electrocardio/showSingleElectrocardio?pageNo=${pageNo+1 }&memberId=${omem.memberid }&flag=${flag}">下一次</a>
				</c:if>
				<a class="btn-normal6" href="../electrocardio/showSingleElectrocardio?pageNo=${total-1 }&memberId=${omem.memberid }&flag=${flag}">最&nbsp;&nbsp;&nbsp;&nbsp;后</a>
			</div>
			</c:if>
			<!-- 测量信息 -->
			<div class="content-box">
				<div class="content-box-header clear-fix">
					<img src="<%=basePath%>img/minus.png" />
					<h3>测量信息</h3>
				</div>
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
					</div>
					<br />
					<div class="tab-content default-tab">
						<h4>心电</h4>
						<table class="table-light">
							<tr>
								<td width="15%" align="right">总心搏数：</td>
								<td width="30%" align="left">${oecg.heartnum }个</td>
								<td width="15%" align="right">平均心率：</td>
								<td align="left">${oecg.averageheart }bpm</td>
							</tr>
							<tr>
								<td width="15%" align="right">最大心率：</td>
								<td width="30%" align="left">${oecg.fastestbeat}bpm</td>
								<td width="15%" align="right">最大心率发生时间：</td>
								<td align="left"><fmt:formatDate value="${hfd}"
										pattern="yyyy-MM-dd HH:mm:ss" /></td>
							</tr>
							<tr>
								<td width="15%" align="right">最小心率：</td>
								<td width="30%" align="left">${oecg.slowestbeat}bpm</td>
								<td width="15%" align="right">最小心率发生时间：</td>
								<td align="left"><fmt:formatDate value="${hsd}"
										pattern="yyyy-MM-dd HH:mm:ss" /></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<!-- 心电图 -->
			<div class="content-box">
				<div class="content-box-header clear-fix">
					<img src="<%=basePath%>img/open.png" />
					<h3>心电图</h3>
				</div>
				<!-- End .content-box-header -->
				<div id ="ecgbox" class="content-box-content hidden">
					<div id="xdt" class="tab-content default-tab">
						<div class="chart-container">
							<div class="btnbox">
								<ul class="btnlist">
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
									<!-- <li><a href="javascript: void(0)" class="btn-normal" id ="btn_zoomIn" ><i class="fa fa-search"></i>放大</a></li>
										<li><a href="javascript: void(0)" class="btn-normal" id ="btn_zoomOut" ><i class="fa fa-search"></i>缩小</a></li>
										<li><a href="javascript: void(0)" class="btn-normal" id ="btn_zoomReset" ><i class="fa fa-arrows-alt"></i>复位</a></li> -->
									<li class="fr">
										<input id="startTime" class="Wdate" type="text" onfocus="WdatePicker({startDate:'<fmt:formatDate value='${oecg.meastime}' pattern='yyyy-MM-dd HH:mm:ss' />',dateFmt:'yyyy-MM-dd HH:mm:ss',
										minDate:'<fmt:formatDate value='${oecg.meastime}' pattern='yyyy-MM-dd HH:mm:ss' />',maxDate:'#F{$dp.$D(\'endTime\')||\'${endTimeStr}\'}'})" readonly="readonly"/>
										
										<span class="mr-8">至</span>
										<input id="endTime" class="Wdate" type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'startTime\')||\'<fmt:formatDate value='${oecg.meastime}' pattern='yyyy-MM-dd HH:mm:ss' />\'}',maxDate:'${endTimeStr}'})" readonly="readonly" />
										<input type="button" class="btn-normal9 inquiry" value="查询" onclick="load_xdt('4')"/>
									</li>
								</ul>
							</div>
							<input type="hidden" id="isMove" value="true">
							<ul>
								<li id="loadImg">
									<img alt="正在加载心电图" src="<%=basePath%>img/load1.gif" />数据加载中 请耐心等待
								</li>
							</ul>
							<div id="ecgChart" class="chart"></div>
	
							<table class="floorBox">
								<tr>
									<td colspan="3" style="padding: 10px 0;"><span>
											说明：Shift键 + 鼠标左键按下可以拖动，双击全屏显示</span>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<a href="javascript:load_xdt('2');" id="pre" class="page-btn width-initial" style="width: 46px;">上一页</a>当前第<span id="xdtindex"></span>页<a href="javascript:load_xdt('1');" id="nex" class="page-btn width-initial" style="width: 46px;">下一页</a>
									<span class="page-total">共<span id="totalPage"></span>页</span>&nbsp;&nbsp;跳转到：<input id="jumpPage" type="number" class="page-go"/><a href="javascript:load_xdt('3');" class="page-btn" id="toPage-btn">Go</a>&nbsp;&nbsp;设置每页显示时长<input id="showTimeLength" class="page-go" style="width: 42px;" onchange="setTimeLength();" type="number" value="60"/>min
									</td>
								</tr>
								<tr>
									<td>操作记录：</td>
									<td><textarea name="operateList" readonly="readonly"  id="operateList" cols="80" style="width:100%;"
											rows="6"></textarea></td>
									<td><input type="button" class="btn1" id="btn_rese"
										value="还原到最初"> <br /> <input type="button"
										id="btn_reanalyse" class="btn1" value="重新分析"></td>
								</tr>
							</table>
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
									<th>异常比例</th>
									<th>结果</th>
									<th>异常详情</th>
								</tr>
							</thead>
							<tbody id="tbody">
								<c:forEach var="ecgExc" items="${oecgExcs}">
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
												<td>${ecgExc.expRate}%</td>
												<td>+</td>
												<td><a href="javascript:showExtImgXdt('${ecgExc.expCname}',${ecgExc.objectIds},${ecgExc.extimes},${ecgExc.extMss});" >异常详情</a></td>
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
			<div class="content-box column_left11 column_left1_j" style="margin-bottom: 0;">
				<div class="content-box-header clear-fix">
					<img src="<%=basePath%>img/open.png" />
					<h3>瞬时心率图</h3>
				</div>
				<!-- End .content-box-header -->
				<div class="content-box-content hidden">
					<div id="ssxlt" class="tab-content default-tab">
						<ul>
						<li id="instantChart" class="load_ssxlt" style="list-style: none;"></li>
						<c:if test="${not empty hrecgPage}">
							<li style="padding-top: 50px;">当前第<span id="ssxltindex"></span>张/共${hrecgPage}张&nbsp;&nbsp;&nbsp; 
							<a href="javascript:load_ssxlt('2');" class="btn-normal">上一张</a> 
							<a href="javascript:load_ssxlt('1');" class="btn-normal">下一张</a>
							</li>
						</c:if>
						</ul>
					</div>
				</div>
			</div>
			<!-- 瞬时心率图 end-->
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
