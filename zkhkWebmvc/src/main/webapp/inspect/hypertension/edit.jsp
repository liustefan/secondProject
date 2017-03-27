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
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=9">
<title>添加高血压随访</title>

<link rel="stylesheet" href="<%=path %>/css/general.css">
<link rel="stylesheet" href="<%=path %>/css/editFllow.css">
<link rel="stylesheet" href="<%=path %>/js/jquery-ui/themes/overcast/jquery-ui.min.css">
<link rel="stylesheet" href="<%=path %>/plugins/font-awesome/css/font-awesome.min.css">

<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/jquery-ui/jquery-ui.js"></script>
<script type="text/javascript" src="<%=path %>/js/jquery.validate.min.js"></script> 
<script type="text/javascript" src="<%=path %>/js/jquery.validate.messages_cn.js"></script>
<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
<script type="text/javascript" src="<%=path %>/js/dataPacker.js"></script>
<script type="text/javascript" src="<%=path %>/js/healthServicesComm.js"></script>
<script type="text/javascript" src="<%=path %>/js/followUpCommon.js"></script>
<script type="text/javascript">
function setBaseInfo(obj){
	$("input[name='unique_ID']").val(obj.uniqueId);
	$("input[name='name']").val(obj.memName);
	$("input[name='memberID']").val(obj.memberId);
	setOtherInfo(obj.memberId, 'h');
}
function setDocBaseInfo(obj){
	$("input[name='visitDrName']").val(obj.docName);
}
//数值大小验证
	function numberRange(id, minN, maxN){
        var val = $("#" +  id ).val();
        var numberVal = parseInt(val);
        var reg = /^(0|[1-9]\d*)$/;
        if($("#"+id).val() != ''){
        	if(!reg.test($("#"+id).val())) {
        		$("#" + id).focus();
            	return;
            }else if(numberVal<=maxN && numberVal>=minN) {
            	return;
            }else {
        		$("#" + id).focus();
            	return;
            }
        }   
    }
    
	//decimal(5,2)form表单提交验证
	function VDblur4(id1, msg, id2, touch) {
		reg=/^(?:[1-9]\d{0,2}|0)(?:\.\d{1,2})?$/;
           if(reg.test($("#"+id2).val()) || $("#" + id2).val() == ""){
           		$("#" + id1).html("");
           }else {
               $("#" + id1).html(msg);
               if(touch){
	               layer.alert("请填写正确的信息", {shade: 0,skin : 'skin1'}, function(index) { 
					   layer.close(index);
               		   $("#" + id2).focus();
               		   if(id2 == 'bmi'){
               			   $("#height").focus();
               		   }
				       $("#btn_save").removeAttr("disabled");
				   });
               }
           } 
	}

	//decimal(5,1)form表单提交验证
	function VDblur(id1, msg, id2, touch) {
		reg=/^(?:[1-9]\d{0,3}|0)(?:\.\d{1})?$/;
           if(reg.test($("#"+id2).val()) || $("#" + id2).val() == ""){
           		$("#" + id1).html("");
           }else {
               $("#" + id1).html(msg);
               if(touch){
	               layer.alert("请填写正确的信息", {shade: 0,skin : 'skin1'}, function(index) { 
					   layer.close(index);
               		   $("#" + id2).focus();
				       $("#btn_save").removeAttr("disabled");
				   });
               }
           } 
	}
	
	//decimal(3,1)form表单提交验证
	function VDblur3(id1, msg, id2, touch) {
		reg=/^(?:[1-9]\d{0,1}|0)(?:\.\d{1})?$/;
           if(reg.test($("#"+id2).val()) || $("#" + id2).val() == ""){
           		$("#" + id1).html("");
           }else {
               $("#" + id1).html(msg);
               if(touch){
	               layer.alert("请填写正确的信息", {shade: 0,skin : 'skin1'}, function(index) { 
					   layer.close(index);
               		   $("#" + id2).focus();
				       $("#save").removeAttr("disabled");
				   });
               }
           } 
	}
	
	//decimal(2,1)form表单提交验证
	function VDblur6(id1, msg, id2, touch) {
		reg=/^(?:[1-9]\d{0,0}|0)(?:\.\d{1})?$/;
           if(reg.test($("#"+id2).val()) || $("#" + id2).val() == ""){
           		$("#" + id1).html("");
           }else {
               $("#" + id1).html(msg);
               if(touch){
	               layer.alert("请填写正确的信息", {shade: 0,skin : 'skin1'}, function(index) { 
					   layer.close(index);
               		   $("#" + id2).focus();
				       $("#save").removeAttr("disabled");
				   });
               }
           } 
	}
	
	//decimal(5,2)onblur光标验证
	function VDblur4_(id1, msg, id2, touch) {
		reg=/^(?:[1-9]\d{0,2}|0)(?:\.\d{1,2})?$/;
           if(reg.test($("#"+id2).val()) || $("#" + id2).val() == ""){
           		$("#" + id1).html("");
           }else {
               $("#" + id1).html(msg);
               if(touch){
               		   $("#" + id2).focus();
				       $("#save").removeAttr("disabled");
               }
           } 
	}
	
	//decimal(5,1)onblur光标验证
	function VDblur_(id1, msg, id2, touch) {
		reg=/^(?:[1-9]\d{0,3}|0)(?:\.\d{1})?$/;
        if(reg.test($("#"+id2).val()) || $("#" + id2).val() == ""){
   			$("#" + id1).html("");
        }else {
            $("#" + id1).html(msg);
            if(touch){
       		   	$("#" + id2).focus();
       			$("#btn_save").removeAttr("disabled");
   			};
		}
   	} 
	
	//decimal(3,1)onblur光标验证
	function VDblur3_(id1, msg, id2, touch) {
		reg=/^(?:[1-9]\d{0,1}|0)(?:\.\d{1})?$/;
           if(reg.test($("#"+id2).val()) || $("#" + id2).val() == ""){
           		$("#" + id1).html("");
           }else {
               $("#" + id1).html(msg);
               if(touch){
               		   $("#" + id2).focus();
				       $("#save").removeAttr("disabled");
               }
           } 
	}
	
	//decimal(2,1)onblur光标验证
	function VDblur6_(id1, msg, id2, touch) {
		reg=/^(?:[1-9]\d{0,0}|0)(?:\.\d{1})?$/;
           if(reg.test($("#"+id2).val()) || $("#" + id2).val() == ""){
           		$("#" + id1).html("");
           }else {
               $("#" + id1).html(msg);
               if(touch){
               		   $("#" + id2).focus();
				       $("#save").removeAttr("disabled");
               }
           } 
	}
	
	function VDblurF(id, msg){
		if($("#" + id ).html() == msg){
			$("#btn_save").removeAttr("disabled");
		    return;
		}
	}
// 页面初始化
function init() {
	// 症状 无 其他禁用
	if($("#symptomWrap label:first-child input[type='checkbox']").attr("checked")){
		$("#symptomWrap label:first-child").siblings('label').find('input').attr("disabled", true);
		$("#rest").attr("disabled",true);
	}
	
	if(!$("#symptomWrap label").last().find("input").is(':checked')){
		$("#rest").attr("disabled", true);
	}else {
		$("#rest").removeAttr("disabled");
	} 
	
	if($("#reaction label").first().find("input").is(':checked')){
		$("#reaction-input").attr("disabled", true);
	}else if($("#reaction label").last().find("input").is(':checked')){
		$("#reaction-input").removeAttr("disabled");
	}else {
		$("#reaction-input").attr("disabled", true);
	} 
// 	setValues($("input[name='memberID']").val(), "followUp1");
}
$(function() {
	init();
	setBaseInfo({memberId: '${pojo.member.memberid}', memName: '${pojo.member.memname}', uniqueId: '${pojo.unique_ID}'});
	//表单验证
	$("#forms").validate();
	
	$("#symptomWrap label").last().find("input").click(function() {
		if($(this).is(':checked')) {
			$("#rest").removeAttr("disabled");
		}else {
			$("#rest").val("");
			$("#rest").attr("disabled", true);
		}
	});
	
	$('input[name="phHypertensiondetail.drugAdverseReaction"]').click(function() {
		if($(this).val() == 1) {
			$("#reaction-input").val("");
			$("#reaction-input").attr("disabled", true);
		}else if ($(this).val() == 2){
			$("#reaction-input").removeAttr("disabled");
		}else {
			$("#reaction-input").attr("disabled", true);
		}
	});
	
	$("#classify input[name='visitClass']").click(function(){
		$("#followDate").removeAttr("disabled");
	});
	// 症状 无 其他禁用
	$("#symptomWrap input[name='phHypertensiondetail.symptom']").click(function() {
		var value = $(this).val(),
			state = $(this).prop("checked");
		
		if(value == '1') {
			if(state) {
				$(this).parent().siblings('label').find('input').attr("checked", false);
				$(this).parent().siblings('label').find('input').attr("disabled", true);
				$("#rest").val("");
				$("#rest").attr("disabled",true);
			}else {
				$(this).parent().siblings('label').find('input').removeAttr("disabled");
				if(!$("#symptomWrap label").last().find("input").is(':checked')){
					$("#rest").attr("disabled", true);
				}else {
					$("#rest").removeAttr("disabled");
				} 
			}
		}
		
	});
	
	// 初始体质指数
	calcBMI('phHypertensiondetail.height','phHypertensiondetail.weight', 'phHypertensiondetail.bmi','bmiDes', 'BMI-error');

	function success(index,operate,memid){
		if(operate == 'new' || operate == 'do'){
  	 	 	window.location="publicHealthAction!noFollowUpList?type=followUp1&flag=F&omem_flag=Y";
   	    }else if(operate == 'edit'){
  	 	 	window.location="publicHealthAction!followUpList?type=followUp1&flag=T&omem_flag=Y";
        }else if(operate == 'singlenew' || operate == 'singledo'){
  		 	window.location="publicHealthAction!memberNoFollowList?type=followUp1&member.memberid="+memid+"&flag=F&omem_flag=Y";
        }else{
  	 	 	window.location="publicHealthAction!memberFollowList?type=followUp1&member.memberid="+memid+"&flag=T&omem_flag=Y";
        }
	}
	$("#btn_save").click(function(){
		var $form = $('#forms');
		if(!$form.valid()) {
					layer.alert("请填写正确的信息", {shade: 0,skin : 'skin1'}, function(index) { 
	 					layer.close(index);
	 					numberRange("sportDuration", -32768, 32767);
						/* numberRange("dailyDrinkNext", -32768, 32767);
	 					numberRange("dailyDrink", -32768, 32767); */
	 					VDblur3_('dailyDrinkNext-error', '请输入一个介于 0 和 100之间且最多一位小数的值', 'dailyDrinkNext', 'be');
	 					VDblur3_('dailyDrink-error', '请输入一个介于 0 和 100之间且最多一位小数的值', 'dailyDrink', 'be');
	 					numberRange("dailySmokingNext", -32768, 32767);
	 					numberRange("dailySmoking", -32768, 32767);
	 					numberRange("heartRate", -32768, 32767);
	 					VDblur4_('BMI-error', '请输入有效的身高体重', 'bmi', 'be');
	 					VDblur_('weight-error', '请输入一个介于 0 和 10000 之间且最多一位小数的值', 'weight', 'be');
	 					VDblur_('height-error', '请输入一个介于 0 和 10000 之间且最多一位小数的值', 'height', 'be');
	 					numberRange("diastolic", -32768, 32767);
	 					numberRange("systolic", -32768, 32767);
	 					
	 					if($("#memeberName").val() == "" || $('input[name="phHypertensiondetail.visitWay"]:checked').length == 0 ){
	 						$("#memeberName").focus();
	 					}
	 					
					});
					$("#btn_save").removeAttr("disabled");
					return;
				}
		
				$(this).attr("disabled","disabled");
				
				VDblur('height-error', '请输入一个介于 0 和 10000 之间且最多一位小数的值', 'height', 'be');
				if($("#height-error").html() == '请输入一个介于 0 和 10000 之间且最多一位小数的值'){
					$("#btn_save").removeAttr("disabled");
				    return;
				}
				
				VDblur('weight-error', '请输入一个介于 0 和 10000 之间且最多一位小数的值', 'weight', 'be');
				if($("#weight-error").html() == '请输入一个介于 0 和 10000 之间且最多一位小数的值'){
					$("#btn_save").removeAttr("disabled");
				    return;
				}
				
				VDblur4('BMI-error', '请输入有效的身高体重', 'bmi', 'be');
				if($("#BMI-error").html() == '请输入有效的身高体重'){
					$("#weight").val("");
					$("#height").val("");
					$("#btn_save").removeAttr("disabled");
				    return;
				}
				
				VDblur3('dailyDrink-error', '请输入一个介于 0 和 100 之间且最多一位小数的值', 'dailyDrink', 'be');
				if($("#dailyDrink-error").html() == '请输入一个介于 0 和 100 之间且最多一位小数的值'){
					$("#btn_save").removeAttr("disabled");
				    return;
				}
				
				VDblur3('dailyDrinkNext-error', '请输入一个介于 0 和 100 之间且最多一位小数的值', 'dailyDrinkNext', 'be');
				if($("#dailyDrinkNext-error").html() == '请输入一个介于 0 和 100之间且最多一位小数的值'){
					$("#btn_save").removeAttr("disabled");
				    return;
				}
				
				$form.submit();
     });
})
</script>
</head>
<body>
	<div class="content">
		<div class="content-title">
			<c:choose><c:when test="${empty pojo.hypertensionID}">新增</c:when><c:when test="${pojo.pending}">进行</c:when><c:otherwise>修改</c:otherwise></c:choose>高血压随访
		</div>
		
		<div>
			<form id="forms" action="save" method="post">
			<input type="hidden" name="pending" value="${pojo.pending}">
			<input type="hidden" name="hypertensionID" value="${pojo.hypertensionID}"/>
			<input type="hidden" name="RefDataPK" value="${pojo.refDataPK}"/>
			<input type="hidden" name="IDCard" value="${pojo.IDCard}"/>
			<input type="hidden" name="phHypertensiondetail.hypertensionID" value="${pojo.phHypertensiondetail.hypertensionID}"/>
			<input type="hidden" name="singleMembers" value="${param.singleMembers}">
			<table  class="form-table">
				<th>
					<ul class="detail">
						<li class="detail-list">
							健康档案编号：
							<input type="text" id="unique_ID" name="unique_ID" value="${pojo.unique_ID}" readonly>
						</li>
						<li class="detail-list">
							姓名： 
							<input maxlength="10" type="text" id="memeberName" name="name" value="${pojo.member.memname }" readonly required>
							<input type="hidden" id="memberId" name="memberID" value="${pojo.member.memberid}">
							<c:if test="${empty pojo.member.memberid}">
								<button type="button" class="button" onclick="openPage('选择会员','members')">...</button>
							</c:if>
							<label class="error" for="memeberName">*</label>
						</li>
					</ul>
				</th>
			</table>
			<table border="1" cellspacing="0" class="table-normal">
				<tbody>
					<tr>
						<th class="align-right">随访日期</th>
						<td colspan="8">
							<input id="visitDate" type="text" name="visitDate" class="follow-date" value="<fmt:formatDate value='${pojo.visitDate}' pattern='yyyy-MM-dd'/>" readonly >
						</td>
					</tr>
					<tr>
						<th class="align-right">随访方式</th>
						<td colspan="8">
							<c:forEach items="${pojo.dicts.get('高血压随访/随访方式')}" var="dict" varStatus="var">
	                			<input name="phHypertensiondetail.visitWay" type="radio" class="input-center" value="${dict.DItemID}" 
	                				<c:if test="${dict.DItemID eq pojo.phHypertensiondetail.visitWay}">checked="checked"</c:if>
	                			required/><span class="span-center">${dict.DItemName}</span>
                			</c:forEach> 
                			<span class="red">*</span>
						</td>
					</tr>
					<tr>
						<th class="align-right">症状</th>
						<td colspan="8" id="symptomWrap">
							<c:forEach items="${pojo.dicts.get('高血压随访/症状')}" var="dict" varStatus="var">
                				<label><input name="phHypertensiondetail.symptom" type="checkbox" class="input-center" value="${dict.DItemID}" 
                				<c:forEach items="${pojo.phHypertensiondetail.symptoms}" var="s">
                					<c:if test="${dict.DItemID eq s}">checked="checked"</c:if>
                				</c:forEach>
                				/><span class="span-center" >${dict.DItemName}</span>
                				</label>
                			</c:forEach>
                			<input maxlength="100" id="rest" type="text"  name="phHypertensiondetail.symptom_Desc" value="${pojo.phHypertensiondetail.symptom_Desc}" >
						</td>
					</tr>
					<tr>
						<th class="align-right" rowspan="3">体征</th>
						<td colspan="8">
							血压：<input type="text" id="systolic"  name="phHypertensiondetail.systolic" class="input-margin" value="${pojo.phHypertensiondetail.systolic }" range="[-32768,32767]" 	digits="true" >/
								<input type="text" id="diastolic" name="phHypertensiondetail.diastolic" class="input-margin" value="${pojo.phHypertensiondetail.diastolic }" range="[-32768,32767]" 	digits="true" >mmHg
						</td>
					</tr>
					<tr>
						<td colspan="8">
							<span class="span-margin">身高：<input maxlength="6" type="text" id="height" name="phHypertensiondetail.height" class="input-margin" value="${pojo.phHypertensiondetail.height}" onchange="calcBMI('phHypertensiondetail.height','phHypertensiondetail.weight', 'phHypertensiondetail.BMI','bmiDes', 'BMI-error');"  onblur="VDblur('height-error', '请输入一个介于 0 和 10000 之间且最多一位小数的值', 'height')">cm</span><span id="height-error" class="red"></span>
							<span class="span-margin">体重：<input maxlength="6" type="text" id="weight"  name="phHypertensiondetail.weight" class="input-margin" value="${pojo.phHypertensiondetail.weight}" onchange="calcBMI('phHypertensiondetail.height','phHypertensiondetail.weight', 'phHypertensiondetail.BMI' ,'bmiDes', 'BMI-error');" onblur="VDblur('weight-error', '请输入一个介于 0 和 10000 之间且最多一位小数的值', 'weight')">Kg</span><span id="weight-error" class="red"></span>
							<span class="span-margin">体质指数：<input type="number" id="bmi"  name="phHypertensiondetail.BMI" class="input-margin" value="${pojo.phHypertensiondetail.BMI }" readonly></span>
							<span id="toggle">(<span id="bmiDes" style="color: red;"></span>)</span><span id="BMI-error" class="red"></span>
						</td>
					</tr>
					<tr>
						<td colspan="8">
							<span class="span-margin">心率：<input type="text"  id="heartRate" name="phHypertensiondetail.heartRate" class="input-margin" value="${pojo.phHypertensiondetail.heartRate }" range="[-32768,32767]" 	digits="true" >次/分钟</span>
							<span class="span-margin">其他：<input maxlength="50" type="text" name="phHypertensiondetail.otherSign"  class="input-margin" value="${pojo.phHypertensiondetail.otherSign }"></span>
						</td>
					</tr>
					<tr>
						<th class="align-right" rowspan="3">生活方式指导</th>
						<td colspan="8">
							<span class="span-margin">日吸烟量：<input type="text"  id="dailySmoking" name="phHypertensiondetail.dailySmoking" class="input-margin" value="${pojo.phHypertensiondetail.dailySmoking }" range="[-32768,32767]" 	digits="true" >支/天</span>
							<span class="span-margin">目标日吸烟量：<input type="text"  id="dailySmokingNext" name="phHypertensiondetail.dailySmoking_Next" class="input-margin" value="${pojo.phHypertensiondetail.dailySmoking_Next }" range="[-32768,32767]" 	digits="true" >支/天</span>
							<span class="span-margin">日饮酒量：<input type="text" maxlength="4" id="dailyDrink" name="phHypertensiondetail.dailyDrink" class="input-margin" value="${pojo.phHypertensiondetail.dailyDrink }" onblur="VDblur3('dailyDrink-error', '请输入一个介于 0 和 100之间且最多一位小数的值', 'dailyDrink')">两/天</span><span id="dailyDrink-error" class="red"></span>
							<span class="span-margin">目标日饮酒量：<input type="text" maxlength="4" id="dailyDrinkNext" name="phHypertensiondetail.dailyDrink_Next" class="input-margin" value="${pojo.phHypertensiondetail.dailyDrink_Next }" onblur="VDblur3('dailyDrinkNext-error', '请输入一个介于 0 和 100之间且最多一位小数的值', 'dailyDrinkNext')">两/天</span><span id="dailyDrinkNext-error" class="red"></span>
					</tr>
					<tr>
						<td colspan="8">
							<span class="span-margin">运动：<input type="text"  id="sportFrequency" name="phHypertensiondetail.sportFrequency" class="input-margin" value="${pojo.phHypertensiondetail.sportFrequency }" maxlength="10">次/周</span>
							<span class="span-margin">每次运动：<input type="text"  id="sportDuration" name="phHypertensiondetail.sportDuration" class="input-margin" value="${pojo.phHypertensiondetail.sportDuration }" range="[-32768,32767]" 	digits="true" >分钟</span>
						</td>
					</tr>
					<tr>
						<td colspan="8">
							<span class="span-center" >心理调整：</span> 
							<c:forEach items="${pojo.dicts.get('高血压随访_生活方式指导/心理调整')}" var="dict" varStatus="var">
	                			<input name="phHypertensiondetail.psychologicalRecovery" type="radio" class="input-center" value="${dict.DItemID}" 
	                				<c:if test="${dict.DItemID eq pojo.phHypertensiondetail.psychologicalRecovery}">checked="checked"</c:if>
	                			/><span class="span-center">${dict.DItemName}</span>
                			</c:forEach> 
							
							<span class="span-center" >遵医行为：</span> 
							<c:forEach items="${pojo.dicts.get('高血压随访_生活方式指导/遵医行为')}" var="dict" varStatus="var">
	                			<input name="phHypertensiondetail.complianceBehavior" type="radio" class="input-center" value="${dict.DItemID}" 
	                				<c:if test="${dict.DItemID eq pojo.phHypertensiondetail.complianceBehavior}">checked="checked"</c:if>
	                			/><span class="span-center">${dict.DItemName}</span>
                			</c:forEach> 
							
							<span class="span-center" >涉盐情况：</span> 
							<c:forEach items="${pojo.dicts.get('高血压随访/摄盐情况(咸淡)')}" var="dict" varStatus="var">
	                			<input name="phHypertensiondetail.intakeSalt" type="radio" class="input-center" value="${dict.DItemID}" 
	                				<c:if test="${dict.DItemID eq pojo.phHypertensiondetail.intakeSalt}">checked="checked"</c:if>
	                			/><span class="span-center">${dict.DItemName}</span>
                			</c:forEach> 
						</td>
					</tr>
					<tr>
						<th class="align-right">辅助检查</th>
						<td colspan="8">
							<input maxlength="50" type="text" class="inspect" name="phHypertensiondetail.checkResult" value="${pojo.phHypertensiondetail.checkResult}">
						</td>
					</tr>
					<tr>
						<th class="align-right">服药依从性</th>
						<td colspan="8">
							<c:forEach items="${pojo.dicts.get('高血压随访/服药依从性')}" var="dict" varStatus="var">
	                			<input name="phHypertensiondetail.drugCompliance" type="radio" class="input-center" value="${dict.DItemID}" 
	                				<c:if test="${dict.DItemID eq pojo.phHypertensiondetail.drugCompliance}">checked="checked"</c:if>
	                			/><span class="span-center">${dict.DItemName}</span>
                			</c:forEach> 
						</td>
					</tr>
					<tr>
						<th class="align-right">服药不良反应</th>
						<td colspan="8" id="reaction">
							<c:forEach items="${pojo.dicts.get('高血压随访/药物不良反应')}" var="dict" varStatus="var">
	                			<label><input name="phHypertensiondetail.drugAdverseReaction" type="radio" class="input-center" value="${dict.DItemID}" 
	                				<c:if test="${dict.DItemID eq pojo.phHypertensiondetail.drugAdverseReaction}">checked="checked"</c:if>
	                			/><span class="span-center">${dict.DItemName}</span>
	                			</label>
                			</c:forEach> 
                			<input type="text" id="reaction-input" maxlength="50" name="phHypertensiondetail.drugAdverseReaction_Desc" value="${pojo.phHypertensiondetail.drugAdverseReaction_Desc}">
						</td>
					</tr>
					<tr>
						<th class="align-right">此次随访分类</th>
						<td colspan="8" id="classify">
							<c:choose>
								<c:when test="${param.operate == 'edit' or param.operate == 'singleedit'}">
									<c:forEach items="${pojo.dicts.get('高血压随访/此次随访分类')}" var="dict" varStatus="var">
		                			<input type="radio" class="input-center" value="${dict.DItemID}" 
		                				<c:if test="${dict.DItemID eq pojo.visitClass}">checked="checked"</c:if>
		                			disabled/><span class="span-center">${dict.DItemName}</span>
	                			</c:forEach> 
	                			<input name="visitClass" type="hidden" value="${pojo.visitClass}" />
								</c:when>
								<c:otherwise>
									<c:forEach items="${pojo.dicts.get('高血压随访/此次随访分类')}" var="dict" varStatus="var">
		                			<input name="visitClass" type="radio" class="input-center" value="${dict.DItemID}" 
		                				<c:if test="${dict.DItemID eq pojo.visitClass}">checked="checked"</c:if>
		                			/><span class="span-center">${dict.DItemName}</span>
	                			</c:forEach> 
								</c:otherwise>
							</c:choose>
					</tr>
					<tr>
						<th class="align-right">用药情况(医嘱)</th>
						<td class="none-border">
							<div class="button-box">
                				<li><input type="button" value="新增" onclick="openPage('新增用药', 'editMedicinal',null,'hypertension')"></li>
	                			<li><input type="button" value="修改" onclick="editMedicinal('hypertension')"></li>
	                			<li><input type="button" value="删除" onclick="removeTr('Medicinal','您确定要删除用药信息吗？');"></li>
							</div>
						</td>
						<td class="full">
							<table id="Medicinal" border="0" cellspacing="0"  class="table-normal small-table">
								<thead>
									<th>选择</th>
									<th>药物名称</th>
									<th>用法</th>
									<th>用量</th>
									<th>单位</th>
									<th>频度</th>
									<th>备注</th>
								</thead>
								<tbody id="medicine_data">
								<c:forEach items="${pojo.phHypertensiondetailmedicines}" var="medic" varStatus="status">
                				<tr id="Medicinal-cb-${status.index }">
                					<td><input type="checkbox"  value="${status.index }" ><input type="hidden" name="phHypertensiondetailmedicines[${status.index }].logID" value="${medic.logID}"/></td>
                					<td><input type="hidden" name="phHypertensiondetailmedicines[${status.index }].drugName" value="${medic.drugName }"><span>${medic.drugName }</span></td>
                					<td><input type="hidden" name="phHypertensiondetailmedicines[${status.index }].drugUsage" value="${medic.drugUsage }"><span>${medic.drugUsage }</span></td>
                					<td><input type="hidden" name="phHypertensiondetailmedicines[${status.index }].drugDosage" value="${medic.drugDosage }"><span>${medic.drugDosage }</span></td>
                					<td><input type="hidden" name="phHypertensiondetailmedicines[${status.index }].drugUnit" value="${medic.drugUnit }"><span>${medic.drugUnit }</span></td>
                					<td><input type="hidden" name="phHypertensiondetailmedicines[${status.index }].drugFreq" value="${medic.drugFreq }"><span>${medic.drugFreq }</span></td>
                					<td><input type="hidden" name="phHypertensiondetailmedicines[${status.index }].remarks" value="${medic.remarks }"><span>${medic.remarks }</span></td>
                				</tr>
                				</c:forEach>
								</tbody>
							</table>
						</td>
					</tr>
					<tr>
						<th class="align-right">转诊</th>
						<td colspan="8">
							<span class="span-margin fl span-width">原因：<input maxlength="50" type="text" name="phHypertensiondetail.transferReason" class="input-margin reason" value="${pojo.phHypertensiondetail.transferReason }"></span>
							<span class="span-align fr ">机构及科室：<input maxlength="25" type="text" name="phHypertensiondetail.transferOrgAndDept" class="input-margin" value="${pojo.phHypertensiondetail.transferOrgAndDept }"></span>
						</td>
					</tr>
					<tr>
						<th class="align-right">随访医生</th>
						<td colspan="8">
							<span class="span-margin fl"><input maxlength="10" type="text" id="drName" name="visitDrName" class="span-margin" value="${pojo.visitDrName }" ><input type="hidden" id="drId" readonly><button type="button" class="button" onclick="openPage('选择医生','iDoctors')">...</button></span>
							<span class="span-margin fr">下次随访日期：
								<c:choose>
									<c:when test="${pojo.pending}">
										<input class="input-margin follow-date" id="followDate" name="phHypertensiondetail.visitDate_Next"  value="<fmt:formatDate value='${pojo.phHypertensiondetail.visitDate_Next}' pattern='yyyy-MM-dd'/>" readonly ${empty pojo.visitClass or pojo.visitClass eq "" ? "disabled":""}>
									</c:when>
									<c:otherwise>
										<input name="phHypertensiondetail.visitDate_Next" value="<fmt:formatDate value='${pojo.phHypertensiondetail.visitDate_Next}' pattern='yyyy-MM-dd'/>" readonly/>
									</c:otherwise>
								</c:choose>
							</span>
						</td>
					</tr>
				</tbody>
			</table>
			</form>
		</div>
		<div class="btn-center">
			<input id="btn_save" type="button" class="btn-inquiry" value="保存">
			<input type="button" class="btn-cancel" onclick='cancelMsg("${empty pojo.hypertensionID ? "放弃新增高血压随访？":"放弃修改高血压随访？"}")'; value="取消">
		</div>
	</div>
</body>
</html>
