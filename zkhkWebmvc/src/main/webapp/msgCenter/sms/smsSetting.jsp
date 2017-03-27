<%@ page contentType="text/html; charset=utf-8" language="java" import="java.util.*" pageEncoding="UTF-8" %>
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
	<title>短信参数设置</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="<%=path %>/plugins/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<style>
		.main-box ul li {
			margin: 25px 8px;
		}
		
		.fix-label {
			text-align: right;
			font-size: 14px;
			width: 15%;
		}
		
		.Wdate {
			width: 75px;
		}
		
		input[type="text"],
		input[type="password"] {
			width: 181px;
		}
		
		.btn-left {
			margin: 15px 0 15px 15.5%;
		}
		
		input[type="text"] {
			margin-right: 10px;
		}
	</style>
	<script type="text/javascript">
		var index = layer.getFrameIndex(window.name); //获取窗口索引
	
		function vilidSendDate() {
			if($('input[name="sendStartTimeStr"]').val() == '' && $('input[name="sendEndTimeStr"]').val() != ''){
				$("#numberRange").html("请输入发送短信的开始时间!");
				return false;
			}else if($('input[name="sendEndTimeStr"]').val() == '' && $('input[name="sendStartTimeStr"]').val() != ''){
				$("#numberRange").html("请输入发送短信的结束时间!");
				return false;
			}else if($('input[name="sendEndTimeStr"]').val() == '' && $('input[name="sendStartTimeStr"]').val() == ''){
				$("#numberRange").html("请输入发送短信的时间!");
				return false;
			}else {
				$("#numberRange").html("");
				return true;
			}
		}
		
		function resetSMS(){
			layer.closeAll();
			layer.confirm( '重置后，该组织短信配置将会恢复成默认配置', {
				title : '提示信息',
				skin : 'skin1',
				shadeClose: false,
		   	    shade: 0,
				btn : [ '确定', '取消' ]
			}, function(index) {
				//alert($("#SCfgID").val());
				$("#hidden_form").attr("action", "<%=path %>/sms/deleteSmsConfig");
				$("#hidden_form").submit();
			});
			layer.close(index);
		}
	
		$(function(){
			jQuery.validator.addMethod("string", function(value, element) {
				return this.optional(element) || !(/\<|\>|\'|\"|\\/g.test(value));
				}, "不允许包含特殊字符!");
			
			jQuery.validator.addMethod("isBlank", function(value, element) {
				return $.trim(value) != ''
				}, "必填!");
			
			// 表单验证
			var vForm = $("#form_SMS").validate({
				rules : {
					'account' : {
						isBlank: true,
					},
					'passwd' : {
						isBlank: true,
					},
					'signature' : {
						isBlank: true,
					},
					'totalSendLimit' : {
						digits: true,
					},
					'dailyMaxSend' : {
						digits: true,
					},
					'memberDailyMaxRecv' : {
						digits: true,
						max: 99
					},
					'memberDailyMaxRepl' : {
						digits: true,
						max: 9
					},
					'captchaTempletNo' : {
						isBlank: true,
					},
					'testSMSTempletNo' : {
						isBlank: true,
					}
				},
				messages : {
					'account' : {
						isBlank : "必填",
					},
					'passwd' : {
						isBlank : "必填",
					},
					'signature' : {
						isBlank : "必填",
					},
					'totalSendLimit' : {
						digits : "请输入整数!",
					},
					'dailyMaxSend' : {
						digits : "请输入整数!",
					},
					'memberDailyMaxRecv' : {
						digits : "请输入整数!",
						max: "输入值不能大于 99!",
					},
					'memberDailyMaxRepl' : {
						digits : "请输入整数!",
						max: "输入值不能大于 9!",
					},
					'captchaTempletNo' : {
						isBlank : "必填",
					},
					'testSMSTempletNo' : {
						isBlank : "必填",
					}
				}
			});
			
			$("#sava_SMS").on("click", function() {
				if(parseInt($("input[name='totalSendLimit']").val()) < parseInt($("input[name='dailyMaxSend']").val())){
					alert("每日最大发送条数不得大于总条数!");
					$('input[name="dailyMaxSend"]').focus();
					return;	
				}
				vForm.form();
				vilidSendDate();
				if(vForm.form() && vilidSendDate()){
					$('#form_SMS').submit();
				}
			});
		});
		
		function returnBack() {
			$("#hidden_form").attr("action", "<%=path %>/org/orgPage");
			$("#hidden_form").submit();
		}
	</script>
</head>
<body>
<div class="content">
	<div class="content-title">
   		组织机构配置 --- 短信配置
	</div>
	<form action=""  method="POST" id="hidden_form" novalidate >
		<input name="orgName" type="hidden" value="${orgName}">
		<input name="serverID" type="hidden" value="${smsConfig.serverID}">
		<input type="hidden" id="SCfgID" name="SCfgID" value="${smsConfig.SCfgID}">
		<input name="orgID" type="hidden" value="${smsConfig.orgID}">
	</form>
    <form action="<%=path %>/sms/saveSmsConfig"  method="POST" id="form_SMS" novalidate >
		<div class="main-box">
		<input type="hidden" id="SCfgID" name="SCfgID" value="${smsConfig.SCfgID}">
			<ul>
				<li>
					<label class="fix-label">组织名称：</label><input name="serverID" type="hidden" value="${smsConfig.serverID}">
	                <span>${orgName}</span><input name="orgID" type="hidden" value="${smsConfig.orgID}">
				</li>
				<li>
					<label class="fix-label"><span class="red">*</span>短信账号：</label>
	                <input type="text" name="account" value="${smsConfig.account}" maxlength="20">
	                <span class="red"></span>
				</li>
				<li>
					<label class="fix-label"><span class="red">*</span>密码：</label>
	                <input type="password" name="passwd" value="${smsConfig.passwd}" maxlength="50">
				</li>
				<li>
					<label class="fix-label"><span class="red">*</span>签名：</label>
	                <input type="text" name="signature" value="${smsConfig.signature}" maxlength="20">
				</li>
				<li>
					<label class="fix-label">短信总条数：</label>
	                <input type="text" name="totalSendLimit" value="${smsConfig.totalSendLimit}">
				</li>
				<li>
					<label class="fix-label">每日最大发送：</label>
	                <input type="text" name="dailyMaxSend" value="${smsConfig.dailyMaxSend}">
	                <span class="mar-right">条</span>
	                <label id="dailyMaxSend-error" class="error" for="dailyMaxSend"></label>
				</li>
				<li>
					<label class="fix-label">会员每日可接收：</label>
	                <input type="text" name="memberDailyMaxRecv" value="${smsConfig.memberDailyMaxRecv}">
	                <span class="mar-right">条</span>
	                <label id="memberDailyMaxRecv-error" class="error" for="memberDailyMaxRecv"></label>
				</li>
				<li>
					<label class="fix-label">每日允许重复内容：</label>
	                <input type="text" name="memberDailyMaxRepl" value="${smsConfig.memberDailyMaxRepl}">
	                <span class="mar-right">次</span>
	                <label id="memberDailyMaxRepl-error" class="error" for="memberDailyMaxRepl"></label>
				</li>
				<li>
					<label class="fix-label"><span class="red">*</span>短信发送时间范围：</label>
					<input class="Wdate" id="first_date" name="sendStartTimeStr" onclick="WdatePicker({dateFmt:'HH:mm:ss', maxDate:'#F{$dp.$D(\'last_date\')}'})" value='<c:if test="${empty smsConfig.sendStartTime}">08:00:00</c:if><fmt:formatDate value="${smsConfig.sendStartTime}" pattern="HH:mm:ss"/>' readonly > 
					<span class="mar-left">至</span> 
					<input class="Wdate mar-left mar-right" id="last_date" name="sendEndTimeStr" onclick="WdatePicker({dateFmt:'HH:mm:ss', minDate:'#F{$dp.$D(\'first_date\')}'})" value='<c:if test="${empty smsConfig.sendEndTime}">20:00:00</c:if><fmt:formatDate value="${smsConfig.sendEndTime}" pattern="HH:mm:ss"/>' readonly >
					<span id="numberRange" class="red"></span>
				</li>
				<li>
					<label class="fix-label"><span class="red">*</span>验证码模板编号：</label>
	                <input type="text" name="captchaTempletNo" value="${smsConfig.captchaTempletNo}" maxlength="20">
				</li>
				<li>
					<label class="fix-label">邀请短信模板编号：</label>
	                <input type="text" name="inviteSMSTempletNo" value="${smsConfig.inviteSMSTempletNo}">
				</li>
				<li>
					<label class="fix-label"><span class="red">*</span>测试短信模板编号：</label>
	                <input type="text" name="testSMSTempletNo" value="${smsConfig.testSMSTempletNo}">
				</li>
			</ul>
			<input type="hidden" name="createID" value="${smsConfig.createID}">
			<input type="hidden" name="createTime" value="${smsConfig.createTime}">
		</div>
		<div class="btn-left">
	        <button type="button" id="sava_SMS" class="btn-inquiry">保存</button>
	        <button type="button" id="reset_SMS" class="btn-inquiry" onclick="resetSMS();">重置配置</button>
	        <button type="button" class="btn-cancel" onclick="returnBack();">返回</button>
        </div>
	</form>
</div>
</body>
</html>
