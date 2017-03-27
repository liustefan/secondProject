<%@ page contentType="text/html; charset=utf-8" language="java" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>发布</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/js/jquery-ui/themes/overcast/jquery-ui.min.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-ui/jquery-ui.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script type="text/javascript" src="<%=path %>/js/dataPacker.js"></script>
	<script type="text/javascript" src="<%=path %>/js/msgCenter.js"></script>
	<style type="text/css">
		html {
			height: 100%;
		}
		
		.mar-top {
			margin-top: 60px;
		} 
		
		.mar-btn {
			margin-top: 45px;
		}
		
		#ui-datepicker-div {
			position: absolute;
			left: 58px !important;
			top: 0 !important;
		}
	</style>
	<script type="text/javascript">
		$(function(){
			var $form = $('#forms');
			var index = layer.getFrameIndex(window.name); //获取窗口索引
		    $('#publish').click(function() {
		    	if($('input[name="releasetime"]').val() == ''){
		    		$('input[name="releasetime"]').focus();
		            $("#error-title").html("请选择时间！").css("color","red");
		            return false;
		        }else {
		        	$("#error-title").html("");
		        }
		    	$.ajax({
					type : "POST",
					url : "savePublish",
					data : $("#forms").serialize(),
					dataType:"json",
					success : function(data) {
						alert(data.content);
		  		     	if(data.status) {
		  		     		layer.closeAll();
		  		     		parent.window.location.href = "../msgCenter/listNewsInfo";
	    		     	}
					}
		    	});
			});
		})
	</script>
</head>
<body>
	<form id="forms" method="post">
    <input type="hidden" name="hninfoid" value="${pojo.hninfoid}"/>
	<div class="search-wrapper align-center mar-top">
		生效日期： <input id="availDate" class="info-date" style="width: 130px" type="text" 
		 name="takeeffecttime" value="<fmt:formatDate value="${pojo.takeeffecttime}" pattern="yyyy-MM-dd"/>" readonly />
	 <div id="error-title" style="height: 20px; line-height: 20px;"></div>
	</div>

	<div class="align-center mar-btn">
		<button type="button" class="btn-inquiry" id="publish">发布</button>
	    <button type="button" class="btn-cancel" onclick="parent.layer.closeAll('iframe');">取消</button>
	</div>
	</form>
</body>
</html>