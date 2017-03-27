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
	<title>选择确认结果</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">

	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script type="text/javascript" src="<%=path %>/js/placeholder.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#confirm_radio").click(function(){
				$("#refuse_reason").hide();
			});
			$("#refuse_radio").click(function(){
				$("#refuse_reason").show();
			});
		});
	</script>
	<style>
	 .confirm-result {
	 	font-size: 14px;
	 	width: 500px;
	 }
	 
	 .confirm-result li {
	 	margin: 20px 0 20px 15px;
	 }
	 
	 .btn-box {
	 	margin-left: 12px;
	 }
	 
	 .pd-40 {
	 	padding: 10px 40px;
	 }
	</style>
	<script type="text/javascript">
	function submitForm() {
		$.ajax({
            cache: true,
            type: "POST",
            url: $("#confirmForm").attr("action"),
            data:$('#confirmForm').serialize(),// 你的formid
            dataType: 'json',
            async: false,
            error: function(request) {
                alert("Connection error");
            },
            success: function(data) {
                if(data.status) {
                	parent.location.href="<%=path %>/member/momvementsList?flag=outer&status=1";
                } else {
                	alert(data.content);
                }
            }
        });
	}
	</script>
</head>
<body>
<div class="clearfix">
    <form action="<%=path %>/member/confirm" method="POST" id="confirmForm">
    <input type="hidden" name="MMovementID" value="${movement.MMovementID}"/>
    	<div class="clearfix pd-40">
    		<div class="fl">
	    		<img src="<%=path %>/img/u179.png" style="width: 60px; height: 60px; margin-top: 20px;">
	    	</div>
			<div class="fl confirm-result">
				<ul>
					<li>
						您是否同意将会员<span>${movement.member.memname }</span>转出到组织：<span>${movement.inOrgName }</span>：
					</li>
					<li>
		                <label class="radio-inlines">
							  <input id="confirm_radio" type="radio" name="moveStatus" value="2">同意
						</label>
						<label class="radio-inlines">
							  <input id="refuse_radio" type="radio" name="moveStatus" value="3">拒绝
						</label>
					</li>
					<li style="height: 100px;">
						<div id="refuse_reason" style="display: none;">
							<textarea class="" rows="4" cols="65" maxlength="100" name="refuseReason" placeholder="请输入拒绝原因!"></textarea>
						</div>
					</li>
				</ul>
				<div class="btn-box">
					<button type="button" onclick="submitForm()" class="btn-inquiry">保存</button>
					<button type="button" class="btn-cancel" onclick="parent.layer.closeAll();">取消</button>
				</div>
			</div>
    	</div>
	</form>
</div>
</body>
</html>
