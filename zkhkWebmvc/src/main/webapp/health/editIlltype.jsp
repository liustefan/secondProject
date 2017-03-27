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
	<title>编辑疾病分类</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<style>
		.content-box {
			padding: 25px 10px 10px 10px;
		}
		
		.content-box label:first-of-type {
			width: 150px;
			font-size: 14px;
			text-align: right;
		}
		
		.content-slice {
			margin-bottom: 15px;
		}
		
		.text-top {
	        vertical-align: text-top;
	    } 
	    
	    .mar-5 {
	    	margin-left: 5px;
	    }
	    
	    .width-input {
	    	width: 150px;
	    	margin-right: 5px;
	    }
	    
	    .width-number {
	    	width: 150px;
	    	padding: 2px;
	    }
	</style>
	<script type="text/javascript">
	$(function() {
		jQuery.validator.addMethod("isBlank", function(value, element) {
			return $.trim(value) != '';
			}, "必填!");
		var index = parent.layer.getFrameIndex(window.name);
		var validate = $("#form1").validate({
			rules : {
				'diseasename' : {
					isBlank: true,
					remote: {
					    url: "<%=path %>/health/checkNameExists",  //后台处理程序
					    type: "post",               //数据发送方式
					    dataType: "json",           //接受数据格式   
					    data: {                     //要传递的数据
					    	'parentid': function(){
					    		return $("input[name='parentid']").val().trim();
					    	},
					    	'msdiseaseid': function() {
					            return $("input[name='msdiseaseid']").val().trim();
					        },
					        'diseasename': function(){
					        	return $("input[name='diseasename']").val().trim();
					        }
					    }
					}
				},
				'sortno' : {
					isBlank : true,
					number : true,
					digits : true
				}
			},
			messages : {
				'diseasename' : {
					isBlank: "必填!",
					remote: "疾病分类已存在!"
				},
				'sortno' : {
					isBlank : "必填!",
					number : "请输入合法的数字!",
					digits : "请输入非负整数!"
				}
			}
		});

		$("#save").on('click', function() {
			$("#save").attr("disabled", true);
			if (validate.form()) {
				$.ajax({
					type : "POST",
					url : "<%=path %>/health/add",
					data : $("#form1").serialize(),
					success : function(msg) {
						layer.msg(msg.content,{icon:1,time:1000},function(){
							if (msg.status) {
							parent.parent.reload($("input[name='parentid']").val());
							}else{
								$("#save").attr("disabled", false);
							}
						});
					}
				});
			}else{
				$("#save").attr("disabled", false);
			};
		});
		
		$("#return").on('click', function() {
			parent.layer.close(index);
		});
	});
	</script>
</head>
<body>
	<form class="cmxform" id="form1" method="post" action="">
		<input type="hidden" name="msdiseaseid" value="${pojo.msdiseaseid}">
		<input type="hidden" name="parentid" value="${parent.msdiseaseid}"> 
		<input type="hidden" name="path" value="${pojo.path}"/>
		<div class="content-box">
			<div class="content-slice">
				<label>上级分类名称：</label>
				<span class="mar-5">${parent.diseasename}</span>
			</div>
			<div class="content-slice">
				<label><span class="red">*</span>疾病分类名称：</label> 
				<input class="width-input" type="text" name="diseasename" value="${pojo.diseasename}" maxlength="10" onKeypress="javascript:if(event.keyCode == 32)event.returnValue = false;">
			</div>
			<div class="content-slice">
				<label><span class="red">*</span>排序号：</label> 
				<input class="width-input" type="text" name="sortno" value="${MaxParentId}${pojo.sortno}">
			</div>
			<div class="content-slice">
				<label>描述：</label>
				<textarea class="text-top" rows="6" cols="40" maxlength="100" name="description">${pojo.description}</textarea>
			</div>
		</div>
		<div class="page-box align-center">
			<button type="button" id="save" class="btn-inquiry">保存</button>
			<button type="button" id="return" class="btn-cancel">取消</button>
		</div>
	</form>
</body>
</html>