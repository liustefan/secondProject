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
	<title>编辑标题</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script type="text/javascript" src="<%=path %>/js/kindeditor/kindeditor.js"></script>
	<script type="text/javascript" src="<%=path %>/js/kindeditor/lang/zh_CN.js"></script>	
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
	</style>
	<script type="text/javascript">
		var index = parent.layer.getFrameIndex(window.name); //获取窗口索引 
		$(function(){
			var $form = $('#forms'); 
			$('#save').click(function() {
				$("#save").attr("disabled", true);
				if($('input[name="content"]').val() == ''){
		    		$('input[name="content"]').focus();
		            $("#content").html("请输入标签！").css("color","red");
		            $("#save").attr("disabled", false);
		            return;
		        }
				
				$.ajax({
					type : "POST",
					url : "saveLable",
					data : $("#forms").serialize(),
					success : function(msg,index) {
						layer.msg(msg.content,{icon: 1,time: 1000},function(){
							if (msg.status) {
								parent.window.location.href = "../msgCenter/listTitleTag";
							}else{
								$("#save").attr("disabled", false);
							}	
						});
					}
				});
			});
		});
	</script>
</head>
<body>
	<form id="forms" method="post">
		<input type="hidden" name="hnlabelid" value="${pojo.hnlabelid}"/>
		<div class="search-wrapper align-center mar-top">
			标签内容：<input type="text" name="content" value="${pojo.content}" maxlength="6" />
		</div>
		<div id="content" style=" height: 20px; line-height: 20px; margin-left: 118px;"></div>
		<div class="align-center mar-btn">
			 <input type="button" class="btn-inquiry" id="save" value="保存">
	         <input type="button" class="btn-cancel" onclick='parent.layer.close(index);' value="取消">
	    </div>
	</form>
</body>
</html>