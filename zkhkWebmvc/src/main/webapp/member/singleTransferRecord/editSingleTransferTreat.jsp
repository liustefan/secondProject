<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>修改转诊</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/plugins/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="<%=path %>/js/jquery-ui/themes/overcast/jquery-ui.min.css">

	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-ui/jquery-ui.js"></script>
	<script type="text/javascript" src="<%=path %>/js/dataPacker.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.validate.min.js"></script>
	<script type="text/javascript">
		function vilidState(){
			if($.trim($("#status option:selected").val())==''){
				$("#error-status").html("请选择!");
				return false;
			}else{
				$("#error-status").html("");
				return true;
			}
		}
		
		$(function(){
			jQuery.validator.addMethod("isBlank", function(value, element) {
				return $.trim(value) != ''
				}, "必填!");
			
			// 表单验证
			var vForm = $("#myForm").validate({
				rules : {
					'organddept' : {
						isBlank: true,
					},
					'reason' : {
						isBlank: true,
					}
				},
				messages : {
					'organddept' : {
						isBlank : "必填!",
					},
					'reason' : {
						isBlank : "必填!",
					}
				}
			});
			
			var $form = $('#myForm'); 
			$('#save').click(function() {
				vForm.form();
				vilidState();
				if(vForm.form() && vilidState()){
					$("#save").attr("disabled", true);
					$.ajax({
						type : "POST",
						url : "saveTransferTreat",
						data : $("#myForm").serialize(),
						success : function(msg,index) {
							alert(msg.content);
							if (msg.status) {
								window.location.href = "<%=path %>/singleTransferTreatment/getTransferTreatRecord?memberid=${pojo.memberid}";
							}else{
								$("#save").attr("disabled", false);
							}	
						}
					});
				}
			});
		});
	</script>
	<style>
		.detail-box {
			margin: 20px 0;
		    padding-left: 8px;
		    border: 1px solid #ccc;
		    font-size: 14px;
		    line-height: 28px;
		    background-color: #eff1f0;
		}
		
		.mg-right {
			margin-right: 50px;
		}
		
		.main-box ul li {
			margin: 20px 8px;
		}
		
		.fix-label {
			text-align: right;
			font-size: 14px;
			width: 15%;
			margin-right: 10px;
		}
		
		.text-top {
	        vertical-align: text-top;
	    }
	    
	    .mg-lt15 {
	    	margin: 15px 0 15px 15%;
	    }
	</style>
</head>
<body>
<div class="content">
	<c:if test="${pojo.ttreatmentid!=null}">
	<div class="content-title">
   		转诊记录 --- 修改
	</div>
	</c:if>
	<c:if test="${pojo.ttreatmentid==null}">
	<div class="content-title">
   		转诊记录 --- 新增
	</div>
	</c:if>
    <form action="saveTransferTreat" method="POST" id="myForm">
    <input type="hidden" name="memberid" value="${pojo.memberid}">
    <input type="hidden" name="ttreatmentid" value="${pojo.ttreatmentid}"/>
		<div class="main-box">
			<ul>
				<li>
				 <c:if test="${pojo.createid == userInfo.id }">
					<label class="fix-label"><span class="red">*</span>转诊机构和科室：</label>
	                <input type="text" name="organddept" maxlength="50" value="${pojo.organddept }">
	             </c:if>
	             <c:if test="${pojo.createid != userInfo.id }">
					<label class="fix-label"><span class="red">*</span>转诊机构和科室：</label>
	                <input type="text" name="organddept" maxlength="50" value="${pojo.organddept }" readOnly="true">
	             </c:if>
				</li>
				<li>
					<c:if test="${pojo.createid == userInfo.id }">
					<label class="fix-label"><span class="red">*</span>转诊原因：</label>
	                <textarea name="reason" cols="50" rows="4" maxlength="100" class="text-top">${pojo.reason }</textarea>
					</c:if>
					
					<c:if test="${pojo.createid != userInfo.id }">
					<label class="fix-label"><span class="red">*</span>转诊原因：</label>
	                <textarea name="reason" cols="50" rows="4" maxlength="100" class="text-top" readOnly="true">${pojo.reason }</textarea>
					</c:if>
				</li>
				<li>
					<label class="fix-label">转诊结果：</label>
	                <textarea name="result" cols="50" rows="4" maxlength="100" class="text-top">${pojo.result }</textarea>
				</li>
				<li>
					<label class="fix-label">转诊时间：</label> 
					<input class="info-date" id="startDate" type="text" name="treattime" value='<fm:formatDate value="${pojo.treattime }" pattern="yyyy-MM-dd"/>' readonly />
				</li>
				<li>
					<label class="fix-label"><span class="red">*</span>状态：</label>
	                <select id="status" name="treatstatus" onchange="vilidState();">
						<option value="">请选择</option>
						<c:choose>
							<c:when test="${pojo.treatstatus eq '1'}">
								<option value="1" selected>转诊申请</option>
							</c:when>
							<c:otherwise>
								<option value="1">转诊申请</option>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${pojo.treatstatus eq '2'}">
								<option value="2" selected>取消转诊</option>
							</c:when>
							<c:otherwise>
								<option value="2">取消转诊</option>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${pojo.treatstatus eq '3'}">
								<option value="3" selected>已转诊</option>
							</c:when>
							<c:otherwise>
								<option value="3">已转诊</option>
							</c:otherwise>
						</c:choose>
					</select>
					<span id="error-status" class="red"></span>
				</li>
				<li>
					<label class="fix-label">创建人：</label>
	                <span>${pojo.createDrName}</span>
				</li>
				<li>
					<label class="fix-label">更新人：</label>
	                <span>${pojo.updateDrName}</span>
	                <c:if test="${pojo.ttreatmentid==null}">
	                <span>${userInfo.realName}</span>
	                </c:if>
				</li>
			</ul>
		</div>
		<div class="mg-lt15">
			<input type="button" class="btn-inquiry" id="save" value="保存"/>
	        <input type="button" class="btn-cancel" onclick='history.go(-1);' value="返回"/>
        </div>
	</form>
</div>
</body>
</html>