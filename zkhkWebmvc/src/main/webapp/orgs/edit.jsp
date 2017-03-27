<%@ page contentType="text/html; charset=utf-8" language="java" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>编辑组织机构</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/css/addOrg.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script>
		$(function() {
			jQuery.validator.addMethod("string", function(value, element) {
				return this.optional(element) || !(/\<|\>|\'|\"|\\/g.test(value));
				}, "不允许包含特殊字符!");
			
			jQuery.validator.addMethod("isBlank", function(value, element) {
				return $.trim(value) != '';
				}, "必填!");
			
			var index = parent.layer.getFrameIndex(window.name);
	
			var validate = $("#form1").validate({
				rules : {
					'orgName' : {
						required : true,
						isBlank: true,
						remote: {
						    url: "<%=path %>/org/checkNameExists",  //后台处理程序
						    type: "post",               //数据发送方式
						    dataType: "json",           //接受数据格式   
						    data: {                     //要传递的数据
						    	'superior': function(){
						    		return $("input[name='superior']").val().trim();
						    	},
						    	'orgId': function() {
						            return $("input[name='orgId']").val().trim();
						        },
						        'orgName': function(){
						        	return $("input[name='orgName']").val().trim();
						        }
						    }
						},
						string: true
					},
					'orgCode' : {
						required : true,
						isBlank: true,
						remote: {
						    url: "<%=path %>/org/checkCodeExists",   //后台处理程序
						    type: "post",               //数据发送方式
						    dataType: "json",           //接受数据格式   
						    data: {                     //要传递的数据
						    	'orgId': function() {
						            return $("input[name='orgId']").val().trim();
						        },
						        'orgCode': function(){
						        	return $("input[name='orgCode']").val().trim();
						        }
						    }
						},
						string: true
					},
					'isExternalService' : {
						required : true
					},
					'order' : {
						required : true,
						digits:true,
						maxlength: 9
					}
				},
				messages : {
					'orgName' : {
						required: "必填",
						remote: "同级组织名称已存在"
					},
					'orgCode' : {
						required : "必填",
						remote: "组织编号已存在"
					},
					'isExternalService' : {
						required : "必选",
					},
					'order' : {
						required : "必填",
						digits: "请输入正整数",
						maxlength: "请输入9位以下正整数"
					}
				}
			});
	
			$("#save").on('click', function() {
				$("#save").attr("disabled", true);
				if (validate.form()) {
					$.ajax({
						type : "POST",
						url : "<%=path %>/org/add",
						data : $("#form1").serialize(),
						success : function(msg) {
							layer.msg(msg.content,{icon:1,time:1000},function(){
								if (msg.status) {
								parent.parent.reload($("input[name='superior']").val());
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
		<input type="hidden" name="orgId" value="${org.orgId}">
		<input type="hidden" name="superior" value="${parent.orgId}"> 
		<input type="hidden" name="otype" value="${org.otype}">
		<input type="hidden" name="path" value="${org.path }"/>
		<div class="content-box">
			<div class="content-table">
				<div class="content-slice" style="margin-bottom: 2px;">
					<label>上级组织：</label><span class="mar-5">${parent.orgName}</span>
				</div>
				<div class="content-slice">
					<label><span class="red">*</span>组织名称：</label> 
					<input type="text" name="orgName" required maxlength="20" value="${org.orgName }">
				</div>
				<div class="content-slice">
					<label><span class="red">*</span>组织编号：</label> 
					<input type="text" name="orgCode" required maxlength="20" value="${org.orgCode }">
				</div>
				<div class="content-slice">
					<label><span class="red">*</span>是否对外服务机构：</label> 
					<label class="radio-inlines fixed-width">
						<input type="radio" name="isExternalService" value="Y" <c:if test="${org.isExternalService=='Y'}">checked="checked"</c:if>><span>是</span>
					</label>
					<label class="radio-inlines fixed-width">
						<input type="radio" name="isExternalService" value="N" <c:if test="${org.isExternalService=='N'}">checked="checked"</c:if>><span>否</span>
					</label>
					<label id="isExternalService-error" class="error" for="isExternalService"></label>
				</div>
				<div class="content-slice">
					<label><span class="red">*</span>排序号：</label>
					<input type="text" name="order" class="" required maxlength="20" value="${detaultOrder}${org.order}">
				</div>
			</div>
		</div>
		<div class="mar-20 align-center">
			<button type="button" id="save" class="btn-inquiry">保存</button>
			<button type="button" id="return" class="btn-cancel">取消</button>
		</div>
	</form>
</body>
</html>