<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<style type="text/css">
		.content {
			margin-top: 8px;
			height: 238px;
			overflow: auto;
		}
		
		.layer-box ul {
			padding: 0 10px;
			width: 348px;
			margin: 0 auto;
		}
		
		.layer-box li {
			display: inline-block;
			margin: 5px;
			padding: 0 8px;
			width: 85px;
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
			margin: 15px 0 15px 25px;
			font-size: 16px;
		}
		
		/*li 原先的背景色*/ 
		.li-bg {
			background-color: #fff;
		}
		
		/*li 要切换的背景色*/ 
		.bg-click { 
			background: #99ccff;
		} 
		
		.bg-gray {
			background: #ebebe4;
			cursor: not-allowed !important;
		}
	</style>
	<script type="text/javascript">
		var LabelIds = new Array();
		var LabelNames = new Array();
		$(document).ready(function(){
			$(".bg-click").each(function(){
				LabelIds.push($(this).val());
				LabelNames.push($(this).html());
			});
		});
		
		$(function(){
			if('query' != $("#flag").val()) {
				$("li[value='1'], li[value='2']").addClass('bg-gray');
			}
			
			$('.layer-box li').click(function(e){
				var clickId = $("#"+$(e.target).attr("id")).val();
				if('query' != $("#flag").val()) {
					$("li[value='1'], li[value='2']").addClass('bg-gray');
					if(clickId == 1 || clickId == 2) {
						return;
					}
				}
				
				if($(e.target).hasClass('li-bg')){
					$(e.target).addClass('bg-click').removeClass('li-bg');
					LabelIds.push($("#"+$(e.target).attr("id")).val());
					LabelNames.push($("#"+$(e.target).attr("id")).html());
				}else if($(e.target).hasClass('bg-click')){
					$(e.target).removeClass('bg-click').addClass('li-bg');
					var idLabel = $("#"+$(e.target).attr("id")).val();
					var valueLabel = $("#"+$(e.target).attr("id")).html();
					//以id为基准
					for(var j=0;j<LabelIds.length;j++){
						if(LabelIds[j] == idLabel){
							LabelIds.splice(j,1);
							LabelNames.splice(j,1);
						}
					}
					/* //以值为基准
					for(var j=0;j<LabelNames.length;j++){
						if(LabelNames[j] == valueLabel && LabelIds[j] == idLabel){
							LabelIds.splice(j,1);
							LabelNames.splice(j,1);
						}
					} */
				}
			});
			
			$("#selectlabel").click(function(){
				if($(".layer-box li.bg-click").length > 10){
					layer.msg('最多选择10个会员标签!', {icon: 7});
				}else {
					parent.setLabelName(LabelIds,LabelNames);
					parent.layer.closeAll();
				}
			});
			
			$("#clearLabel").click(function(){
				parent.layer.closeAll();
			});
		});
	</script>
</head>
<body>
	<div class="layer-box content">
	<input type="hidden" value="${flag}" id="flag">
		<div>
			<p>系统标签</p>
			<ul>
				<c:forEach items="${items }" var="item" varStatus="status">
					<c:if test="${item.userange eq 1 or item.userange eq 2}">
						<li class="<c:if test='${item.checked }'>bg-click</c:if><c:if test='${not item.checked }'>li-bg</c:if>" id="sys_${status.index}" title="${item.itemname }" value="${item.litemid}">${item.itemname }</li>
					</c:if>
				</c:forEach>
			</ul>
		</div>
		<div>
			<p>自定义标签</p>
			<ul>
				<c:forEach items="${items }" var="item" varStatus="status">
					<c:if test="${item.userange eq 3}">
						<li class="<c:if test='${item.checked }'>bg-click</c:if><c:if test='${not item.checked }'>li-bg</c:if>" id="def_${status.index}" title="${item.itemname }" value="${item.litemid}">${item.itemname }</li>
					</c:if>
				</c:forEach>
			</ul>
		</div>
	</div>
	<div class="page-box align-center">
        <button type="button" class="btn-inquiry" id="selectlabel">确定</button>
        <button type="button" class="btn-cancel" id="clearLabel">取消</button>
	</div>
</body>
</html>
