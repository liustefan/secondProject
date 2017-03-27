<%@ page contentType="text/html; charset=utf-8" language="java" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>编辑标签分类</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>	
	<style>
		.content-box {
			padding: 35px 10px 0 10px;
		}
		
		.content-box label:first-of-type {
			width: 120px;
			font-size: 14px;
			text-align: right;
		}
		
		.content-slice {
			margin-bottom: 25px;
		}
		
		.text-top {
	        vertical-align: text-top;
	    } 
	    
	    .mar-label {
	    	margin-left: 125px;
	    	padding-top: 3px;
	    }
	</style>
	<script type="text/javascript">
		var index = parent.layer.getFrameIndex(window.name); //获取窗口索引 
		
		$(function() {
			jQuery.validator.addMethod("isBlank", function(value, element) {
				return $.trim(value) != '';
				}, "必填!");
			var index = parent.layer.getFrameIndex(window.name);
			var validate = $("#form1").validate({
				rules : {
					'classname' : {
						isBlank: true,
						remote: {
						    url: "<%=path %>/labelClass/checkNameExists",  //后台处理程序
						    type: "post",               //数据发送方式
						    dataType: "json",           //接受数据格式   
						    data: {                     //要传递的数据
						    	'lclassid': function() {
						            return $("input[name='lclassid']").val().trim();
						        },
						        'classname': function(){
						        	return $("input[name='classname']").val().trim();
						        }
						    }
						}
					},
				},
				messages : {
					'classname' : {
						isBlank: "必填!",
						remote: "此标签分类已存在！"
					},
				}
			});

			$(function(){
				var $form = $('#form1'); 
				$('#save').click(function() {
					if(validate.form()){
						$("#save").attr("disabled", true);
						$.ajax({
							type : "POST",
							url : "saveLabelClass",
							data : $("#form1").serialize(),
							success : function(msg,index) {
								layer.msg(msg.content,{icon: 1,time: 1000},function(){
									if (msg.status) {
										parent.window.location.href = "../labelClass/listLabelClass";
									}else{
										$("#save").attr("disabled", false);
									}	
								});
							}
						});
					}
				});
			});
		});
	</script>
</head>
<body>
	<form id="form1" method="post" action="saveLabelClass">
	<input type="hidden" name="lclassid" value="${pojo.lclassid}"/>
		<div class="content-box">
			<div class="content-table">
				<div class="content-slice">
					<label><span class="red">*</span>标签分类名称：</label>
					<input type="text" name="classname" maxlength="10" value="${pojo.classname}" onKeypress="javascript:if(event.keyCode == 32)event.returnValue = false;">
					<span class="red" id="tag_error"></span>
				</div>
				<div class="content-slice">
					<label>描述：</label>
					<textarea class="text-top" name="description" cols="40" rows="6" maxlength="50">${pojo.description}</textarea>
				</div>
			</div>
		</div>
		<div class="page-box align-center">
			<input type="button" class="btn-inquiry" id="save" value="保存">
	        <input type="button" class="btn-cancel" id="return" onclick='parent.layer.close(index);' value="取消">
		</div>
	</form>
</body>
</html>
