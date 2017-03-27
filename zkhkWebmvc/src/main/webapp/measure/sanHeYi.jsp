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
    <title>三合一测量页面</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
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
		var tab_judge = '${param.tab}';
		
 		$(function(){
			$("#single").click(function(){
				if($("#innerIframe1").attr('src') == ''){
					$("#innerIframe1").attr('src','<%=path %>/electrocardioPulse/showSingleElectroPulse?memberId=${param.memberId }&eventId=${param.eventId}&flag=${param.flag}')
				}
			})
		});
 		
		//tab功能切换
		$(document).ready(function(){ 
			jQuery.jqtab = function(tabtit,tab_conbox,shijian) {
				// 隐藏所有section
				$(tab_conbox).find(".tab-conbox-item").hide();
				
				if(tab_judge == 'all'){
					// 选中第一个nav 
					$(tabtit).find("li:last").addClass("thistab").show(); 
					// 显示第一个nav对应的内容 
					$(tab_conbox).find(".tab-conbox-item:last").show();
				}else if(tab_judge == 'single'){
					// 选中第一个nav 
					$(tabtit).find("li:first").addClass("thistab").show(); 
					// 显示第一个nav对应的内容 
					$(tab_conbox).find(".tab-conbox-item:first").show();
					$("#innerIframe1").attr('src','<%=path %>/electrocardioPulse/showSingleElectroPulse?memberId=${param.memberId }&eventId=${param.eventId}&flag=${param.flag}')
				}
				
				// 给所有nav项 添加点击事件
				$(tabtit).find("li").bind(shijian,function(){
					$(this).addClass("thistab").siblings("li").removeClass("thistab"); 
					var activeindex = $(tabtit).find("li").index(this);
					$(tab_conbox).children().eq(activeindex).show().siblings().hide();
					return false;
					});
			};
			/*调用方法如下*/
			$.jqtab("#tab_title","#tab_conbox","click");
		})
		
		function setheight() {
			//取到窗口的高度   
			var winH1=$(window).height();
			var tempH = winH1-64;
			
			if(tab_judge == 'all'){
				$('#innerIframe1').css({
					'height':tempH-45
				});
				$('#innerIframe2').css({
					'height':tempH-45
				});
			}else if(tab_judge == 'single'){
				$('#innerIframe1').css({
					'height':tempH-80
				});
				
				$('#innerIframe2').css({
					'height':tempH-80
				});
			}
		};
		
		$(function(){
			setheight();
			$(window).resize(setheight);
		});
	</script>
	<style type="text/css">
		.footer_content_ul {
			width: 100%;
			height: 40px;
			background: #f0f0f0;
			background: -moz-linear-gradient(top, #f0f0f0 0%, #dadbdb 100%);
			background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#f0f0f0), color-stop(100%,#dadbdb));
			background: -webkit-linear-gradient(top, #f0f0f0 0%,#dadbdb 100%);
			background: -o-linear-gradient(top, #f0f0f0 0%,#dadbdb 100%);
			background: -ms-linear-gradient(top, #f0f0f0 0%,#dadbdb 100%);
			background: linear-gradient(to bottom, #f0f0f0 0%,#dadbdb 100%);
			filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#f0f0f0', endColorstr='#dadbdb',GradientType=0 );
		}
				
		.footer_content_ul li {
			float: left;
			width: 200px;
			list-style: none;
			height: 38px;
			text-align: center;
			font-size: 13px;
			line-height: 38px;
			border: 1px solid #f0f0f0;
		    cursor: pointer;
		}
		
		.footer_content_ul li:hover {
			color: #fff;
			border: 1px solid #008a3e;
			background: #01bd56;
			background: -moz-linear-gradient(top, #01bd56 0%, #009241 100%);
			background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#01bd56), color-stop(100%,#009241));
			background: -webkit-linear-gradient(top, #01bd56 0%,#009241 100%);
			background: -o-linear-gradient(top, #01bd56 0%,#009241 100%);
			background: -ms-linear-gradient(top, #01bd56 0%,#009241 100%);
			background: linear-gradient(to bottom, #01bd56 0%,#009241 100%);
			filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#01bd56', endColorstr='#009241',GradientType=0 );
		}
		
		#tab_title li.thistab {
			color: #fff;
			border: 1px solid #008a3e;
			background: #01bd56;
			background: -moz-linear-gradient(top, #01bd56 0%, #009241 100%);
			background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#01bd56), color-stop(100%,#009241));
			background: -webkit-linear-gradient(top, #01bd56 0%,#009241 100%);
			background: -o-linear-gradient(top, #01bd56 0%,#009241 100%);
			background: -ms-linear-gradient(top, #01bd56 0%,#009241 100%);
			background: linear-gradient(to bottom, #01bd56 0%,#009241 100%);
			filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#01bd56', endColorstr='#009241',GradientType=0 );
		}
		
		.tab-conbox-item iframe {
			border: none;
		}
		
		.content-box {
			padding: 0 20px !important;
		}
	</style>
</head>
<body>
<div <c:if test="${empty param.eventId}">class="content"</c:if>>
	<c:if test="${empty param.eventId}">
		<div class="content-title">三合一测量</div>
	</c:if>
	<nav>
		<ul id="tab_title" class="footer_content_ul">
		  <li id="single">单次测量结果</li>
		  <li id="all">所有测量结果</li>
		</ul>
	</nav>
	<div class="tab-content">
		<div id="tab_conbox" class="clearfix">
			<section class="tab-conbox-item">
				<iframe id="innerIframe1" name="innerIframe1" width="100%" height="" src=""></iframe>
			</section>
			<section class="tab-conbox-item">
				<iframe id="innerIframe2" name="innerIframe2" width="100%" height="" src="<%=path %>/electrocardioPulse/showAllElectrocardioPulse?memberId=${param.memberId }&flag=1"></iframe>
			</section>
		</div>
	</div>    
</div>
</body>
</html>
 