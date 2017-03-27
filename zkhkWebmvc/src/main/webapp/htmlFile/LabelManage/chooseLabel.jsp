<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>选择会员标签</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">

	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<style type="text/css">
		.content {
			margin-top: 8px;
		}
		
		.layer-box li {
			display: inline-block;
			margin-right: 20px;
			padding: 0 8px;
			width: 80px;
			height: 28px;
			text-align: center;
			line-height: 28px;
			border: 1px solid #797979;
		    cursor: pointer;
		    overflow: hidden;
		    text-overflow: ellipsis;
		    white-space: nowrap;
		}
		
		.layer-box p {
			margin: 15px 0;
		}
		
		/*li 原先的背景色*/ 
		.li-bg {
			background-color: #fff;
		}
		
		/*li 要切换的背景色*/ 
		.bg-click { 
			background: #99ccff;
		} 
	</style>
	<script type="text/javascript">
		$(function(){
			var checkId = new Array();
			$('.layer-box li').click(function(e){
				if($(e.target).hasClass('li-bg')){
					$(e.target).addClass('bg-click').removeClass('li-bg');
					checkId.push($(e.target).attr("id"));
				}else{
					$(e.target).removeClass('bg-click').addClass('li-bg');
					checkId.pop($(e.target).attr("id"));
				}
			})
		});
	</script>
</head>
<body>
	<div class="layer-box content">
		<div>
			<p>系统标签</p>
			<ul>
				<li class="li-bg" id="gxy" title="高血压高血压高血压">高血压高血压高血压</li>
				<li class="li-bg" id="tnb">糖尿病</li>
				<li class="li-bg" id="xxg">心血管</li>
			</ul>
		</div>
		<div>
			<p>自定义标签</p>
			<ul>
				<li class="li-bg" id="gxy1">高血压1</li>
				<li class="li-bg" id="tnb1">糖尿病1</li>
				<li class="li-bg" id="xxg1">心血管1</li>
			</ul>
		</div>
		<div class="page-box align-center">
	        <button type="button" class="btn-inquiry" onclick="">确定</button>
	        <button type="button" class="btn-cancel" onclick="">取消</button>
        </div>
	</div>
</body>
</html>
