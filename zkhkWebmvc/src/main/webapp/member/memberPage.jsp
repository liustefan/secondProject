<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>单一会员${requestScope.omem.memname }的详细资料</title>
	<link rel="shortcut icon" type="image/x-icon" href="<%=path %>/<%=getServletContext().getAttribute("img") %>/title_ico.ico" />
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/plugins/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="<%=path %>/css/singleMember.css">
	<link rel="stylesheet" href="<%=path %>/css/sidebar-menu.css">
	
	<script src="<%=path %>/js/jquery-1.9.1.min.js"></script>
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
		
/* 		function checkNav(obj) {
			$("li a.nav").each(function(){ 
				$(this).removeClass("current");
			});
			$(obj).addClass("current");
		}
		
		$(document).ready(function(){
			$("li a.nav").click(function(e){
				checkNav(this);
			});
		}); */  

		function setheight() {
			//取到窗口的高度   
			var winH = $('#left').height();
			var winW1=  $('#right').width();
			var winH1=$(window).height();
			var winW = $(window).width(); 
			var tempH = winH1-118;
			$('#mainFrame').css({
				'height':tempH
				});
			if(winH < tempH){
				$('#left').css({
					'height':tempH
				});
			}
		};
		
		$(function(){
			var obj,
				page = "${param.page}";
			
			setheight();
			$(window).resize(setheight);
			
			if(page !=="") {
				switch(page) {
					case "checkUp":
						obj = $("#checkUp");
						break;
					case "followUp1":
						obj = $("#followUp1");
						break;
					case "followUp2":
						obj = $("#followUp2");
						break;
					/* case "followUp3":
						obj = $("#followUp3");
						break;
					case "followUp4":
						obj = $("#followUp4");
						break;
					case "followUp5":
						obj = $("#followUp5");
						break; */
				}
				$(obj).trigger("click");
				$(obj).parent().parent().parent().addClass('active');
				$(obj).parent().parent().prev().addClass('border-bottom1');
				$(obj).parent().parent().slideDown();
				$("#mainFrame").attr("src",$(obj).attr("href"));
			}
		});
	</script>
</head>
<body>
<div class="w1280">
    <div class="single_report_head">
        <div class="person-info clearfix">
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
                  <p>性别：
                  	<c:if test="${omem.gender eq 1}">男</c:if>
					<c:if test="${omem.gender eq 2}">女</c:if>
					<c:if test="${omem.gender eq 3}">未知</c:if>
                   	<%-- ${omem.gender=='M'?'男':'女'} --%>
                  </p>
                  <p>年龄：${age}</p>
             </div>
        </div>
		<h3>单一会员详细资料</h3>
    </div>
	<div class="main clearfix">
		<div id="left">
		 	<ul class="sidebar-menu">
				<li class="changge-bgcolor"><a href="<%=path %>/member/detail/${omem.memberid }?flag=6" id="memberInfo" target="showRight">基本信息与健康档案</a></li>
				<li class="treeview">
					<a href="javascript: void(0);">
					  <span>测量管理</span>
					  <i class="fa fa-angle-right pull-right"></i>
					</a>
					<%-- <a href="<%=path %>/mem/SingleMemMgrAction!toMemMeasurePage?memberid=${memberid}" target="showRight">测量管理</a> --%>
				   	<ul class="treeview-menu" style="display: none;">
				       <li><a class="nav" href="<%=path %>/bloodPressure/showAllBloodPress?memberId=${omem.memberid }&flag=1" target="showRight">血压测量</a></li>
				       <li><a class="nav" href="<%=path %>/bloodSugar/showAllBloodSugar?memberId=${omem.memberid }&flag=1" target="showRight">血糖测量</a></li>
				       <li><a class="nav" href="<%=path %>/measure/sanHeYi.jsp?memberId=${omem.memberid }&flag=1&tab=all" target="showRight">三合一测量</a></li>
				       <li><a class="nav" href="<%=path %>/measure/xinDian.jsp?memberId=${omem.memberid }&flag=1&tab=all" target="showRight">动态心电测量</a></li>
				       <c:if test="${requestScope.flags eq 'my' }">
				       		<li><a class="nav" href="<%=path %>/uploadMeasData/showUploadMeasPage?memberId=${omem.memberid }" target="showRight">上传测量数据</a></li>
				   	   </c:if>
				   </ul>
				</li>
				<%-- <li><a class="nav"  href="<%=path %>/summaryReport/toMemSumReportPage?memberid=${omem.memberid}" target="showRight">测量报告管理</a></li> --%>
				<li><a class="nav"  href="<%=path %>/question/singleAnswer/list?memberid=${omem.memberid}" target="showRight">答卷管理</a></li>
				
				<!-- 某会员和该登陆医生有分组关联关系，则显示该菜单，否则不显示 -->
				<%-- <c:if test="${requestScope.flags eq 'my' }">
					<li><a class="nav"  href="<%=path %>/package/getMemberPackageList?memberid=${omem.memberid}" target="showRight">订购套餐管理</a></li>
				</c:if> --%>
				
				<li><a class="nav"  href="<%=path %>/measureRecord/toMeasStatisPage?memberId=${omem.memberid}" target="showRight">远程测量统计与分析</a></li>
				<%-- <li><a class="nav" href="<%=path %>/statistic/toRepStatistcPage?memberid=${omem.memberid}" target="showRight">报告统计与分析</a></li> --%>
				
				<li class="treeview">
					<a href="javascript: void(0);">
					  <span>健康管理</span>
					  <i class="fa fa-angle-right pull-right"></i>
					</a>
					<ul class="treeview-menu" style="display: none;">
						<li><a class="nav" id="checkUp" href="<%=path %>/inspect/physical/list?memberID=${omem.memberid}&name=<c:out value="${omem.memname}" escapeXml='true'/>&unique_ID=${omem.uniqueId}" target="showRight">健康体检</a></li>
						<li><a class="nav" id="followUp1" href="<%=path %>/inspect/hypertension/plist?memberID=${omem.memberid}&name=<c:out value="${omem.memname}" escapeXml='true'/>&unique_ID=${omem.uniqueId}" target="showRight">高血压随访</a></li>
						<li><a class="nav" id="followUp2" href="<%=path %>/inspect/diabetes/plist?memberID=${omem.memberid}&name=<c:out value="${omem.memname}" escapeXml='true'/>&unique_ID=${omem.uniqueId}" target="showRight">Ⅱ型糖尿病随访</a></li>
						<li><a class="nav" id="followUp4" href="<%=path %>/health/managescheme/singleList?memberID=${omem.memberid}" target="showRight">管理方案</a></li>
						<li><a class="nav" id="followUp3" href="<%=path %>/health/manageschemeTask/singleList?memberId=${omem.memberid}" target="showRight">健康管理任务</a></li>
						<li><a class="nav" id="followUp5" href="<%=path %>/singleTransferTreatment/getTransferTreatRecord?memberid=${omem.memberid}&memname=<c:out value="${omem.memname}" escapeXml='true'/>" target="showRight">转诊记录</a></li>
					</ul>
				</li>
		 	</ul>
		</div>
		<div id="right">
			 <iframe id="mainFrame" src="<%=path %>/member/detail/${omem.memberid }?flag=6" width="100%" frameborder="0" name="showRight" ></iframe>
		</div>
	</div>
</div>

<script src="<%=path %>/js/sidebar-menu.js"></script>
<script>
$.sidebarMenu($('.sidebar-menu'))
</script>
</body>
</html>