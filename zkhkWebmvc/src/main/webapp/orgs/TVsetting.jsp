<%@ page contentType="text/html; charset=utf-8" language="java" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>修改组织机构配置(TV)</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/css/addConfig.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.validate.messages_cn.js"></script>	
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script>
		function checkInt(id, id2){
			reg=/^\+?[1-9][0-9]*$/;
			if(reg.test($("#"+id).val())|| $("#" + id).val() == ""){
				$("#"+id2).html("");
				return true;
			}else {
				$("#"+id2).html("请输入正整数");
				$("#save").removeAttr("disabled");
				return false;
			}
		}
		
		function checkInt2(id, id2){
			reg=/^\d+$/;
			if(reg.test($("#"+id).val())|| $("#" + id).val() == ""){
				$("#"+id2).html("");
				return true;
			}else {
				$("#"+id2).html("请输入非负整数");
				$("#save").removeAttr("disabled");
				return false;
			}
		}
		
		$(function() {
			var idcardChecked = false;
			var telChecked = false;
			var memNameChecked = false;
			$("#member-required input[type='checkbox']:checked").each(function(){
				var val = this.value;
				if(8 == val) { //身份证选择
					idcardChecked = true;
				}
				if(1 == val) {
					memNameChecked = true;
				}
				if(16 == val) {
					telChecked = true;
				}
			});
			
			$("#member-required input[type='checkbox']").click(function(){
				var val = this.value;
				if(8 == val) { //身份证选择
					idcardChecked = this.checked;
				}
				if(1 == val) {
					memNameChecked = this.checked;
				}
				if(16 == val) {
					telChecked = this.checked;
				}
			});
			
			$("#form1").validate();
			$("#save").on('click', function() {
				$("#save").attr("disabled", true);
				if($("#tip").html() == "请在会员类型管理模块进行添加"){
					alert("请在会员类型管理模块进行添加");
					$("#tip").css("color","red");
					$("#save").removeAttr("disabled");
					return;
				}
	
				if($("#member-required input[type='checkbox']:checked").length == 0){
					alert("请选择会员信息必填配置");
					$("#save").removeAttr("disabled");
					return;
				}
				
				if(!idcardChecked) {
					if(!telChecked) {
						alert("身份证和手机号必须勾选之一");
						$("#save").removeAttr("disabled");
						return;
					}
					if(!memNameChecked) {
						alert("手机号和姓名必须同时勾选");
						$("#save").removeAttr("disabled");
						return;
					}
				}
				
				if(!checkInt('experience-input','checked-false')){
					return;
				}
				
				if(!checkInt2('experienceNum-input','checked-err')){
					return;
				}
				
				/* if($('input[name="orgsConfig.experienceDay"]').val() && $('input[name="orgsConfig.experienceDay"]').val()==0){
					alert("会员体验时长不能为0");
					$("#save").removeAttr("disabled");
					return;
				} */
				var r = $('#form1').valid();
				if(!r) {
					alert("请填写正确的信息");
					$("#save").removeAttr("disabled");
					return;
				}
				$.ajax({
					type : "POST",
					url : "<%=path %>/org/config",
					data : $("#form1").serialize(),
					success : function(msg) {
						layer.msg(msg.content,{icon:1,time:1000},function(){
							if (msg.status) {
							parent.parent.reload($("input[name='org.superior']").val());
							}else{
								$("#save").attr("disabled", false);
							}
						});
					}
				});
			});
			
			var index = parent.layer.getFrameIndex(window.name);
	
			$("#return").on('click', function() {
				parent.layer.close(index);
				parent.location.reload();
			});
			
			function checkIsDisplayCard($this){
// 				if($('input[name="isDisplayCard"]:checked').val()==0){
// 					$("#experienceNum").hide();
// 				}else{
					$("#experienceNum").show();
// 				}
			}
			checkIsDisplayCard();
			$("input[name='isDisplayCard1']").click(function(){
				checkIsDisplayCard();
			});
		});
	</script>
</head>
<body>
	<form class="cmxform" id="form1" method="post" action="">
		<input type="hidden" name="orgID" value="${org.orgId}">
		<input type="hidden" name="org.superior" value="${param.pId}${org.superior}"> 
		<input type="hidden" name="logID" value="${org.orgConfig.logID }"/>
		<input type="hidden" name="createDrID" value="${org.orgConfig.createDrID }"/>
		<input type="hidden" name="createTime" value="<fm:formatDate value="${org.orgConfig.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/>"/>
		<div class="content-box">
			<div class="content-main">
				<div class="content-slice">
					<label>上级组织：</label><span>${org.parentOrg.orgName}</span>
				</div>
				<div class="content-slice">
					<label>组织名称：</label><span>${org.orgName }</span>
				</div>
				<div class="content-slice">
					<label>组织编号：</label><span>${org.orgCode}</span>
				</div>
				<div class="content-slice clearfix">
					<div class="fl"><label>会员信息<br>必填配置(<font color="red">*</font>)：</label></div>
					<div class="fl fix-width">
						<ul class="right clearfix" id="member-required">
							 <c:forEach items="${memMustItemSettins }" var="setting">
								       <li>
										<input name="memMustSetItemStr" type="checkbox" value="${setting.num }" id="checkboxId_${setting.num}"  
 										<c:choose>
											<c:when test="${not empty org.orgConfig.memMustSetItemArr}">
											    <c:forEach items="${org.orgConfig.memMustSetItemArr }" var="memMustSetItem"> 
						 							<c:if test="${memMustSetItem eq setting.num or setting.num eq 8}">checked="checked"</c:if> 
						 							<c:if test="${setting.num eq 8}"> disabled </c:if>
						 						</c:forEach> 
											</c:when>
											<c:otherwise>
											<c:if test="${setting.num eq 8}">checked="checked" disabled </c:if> 
											</c:otherwise>
										</c:choose> />${setting.text }
								    </li>
							 </c:forEach>
							 <input name="memMustSetItemStr" value="8" type="hidden"/>
						</ul>
					</div>
				</div>
				<div class="content-slice clearfix">
					<div class="fl"><label>注册会员<br>默认类型(<font color="red">*</font>)：</label></div>
					<div class="fl fix-width" id="member-type">
						<c:choose>
							<c:when test="${not empty typeList}">
								<c:forEach items="${typeList}" var="omes" varStatus="var">
	               					<div class="fl padding-r">
	               					    <input name="memId" type="radio" class="align-radiu" value="${omes.memid}" 
	               					      <c:if test="${org.orgConfig.memId eq omes.memid || var.index == 0}">checked="checked"</c:if> />
	               					    <span class="span-center">${omes.memname}</span>
	               					</div>
	                			</c:forEach> 
							</c:when>
							<c:otherwise>
								<span id="tip">请在会员类型管理模块进行添加</span>
							</c:otherwise>
						</c:choose>
                	</div>
				</div>
				<div class="content-slice clearfix" id="experienceDay">
					<div class="fl"><label>会员默认类型<br>体验时长：</label></div>
					<div class="fl padding-t">
						<input id="experience-input" type="text" name="experienceDay" value="${org.orgConfig.experienceDay}" maxlength="5" onblur="checkInt('experience-input','checked-false')" />天
						<!-- <label id="orgsConfig.experienceDay-error" class="error" for="orgsConfig.experienceDay"></label> -->
						<span class="change-color" id="checked-false"></span>
					</div>
				</div>
				<div class="content-slice clearfix">
					<div class="clearfix">
						<div class="fl"><label>是否显示智能<br>卡号：</label></div>
						<div class="fl" id="member-type">
	       					<div class="fl">
	       					    <input type="hidden" name="isDisplayCard" value="1"/>
		       					<label class="radio-inlines fixed-width">
		       						<input type="radio" name="isDisplayCard1" value="1" checked="checked" disabled><span>是</span>
								</label> 
								<label class="radio-inlines fixed-width">
		       						<input type="radio" name="isDisplayCard1" value="0" disabled><span>否</span>
								</label>
	                		</div>
						</div>
					</div>
				</div>
				<div class="content-slice clearfix" id="experienceNum">
					<div class="fl"><label>家庭会员默认<br>类型数量：</label></div>
					<div class="fl padding-t">
						<input id="experienceNum-input" type="text" name="experienceNum" value="${org.orgConfig.experienceNum}" maxlength="3" onblur="checkInt2('experienceNum-input','checked-err')" />个
						<!-- <label id="orgsConfig.experienceNum-error" class="error" for="orgsConfig.experienceNum"></label> -->
						<span class="change-color" id="checked-err"></span>
					</div>
				</div>
				<div class="content-slice clearfix">
					<input type="checkbox" class="input-checkbox" name="sharedParentNode" value="1" <c:if test="${org.orgConfig.sharedParentNode eq 1}">checked</c:if>>与上级节点为同一机构(与上级组织节点共享会员标签、健教、管理方案模板、问卷)
				</div>
				<div class="mar-20 align-center">
					<button type="button" id="save" class="btn-inquiry">保存</button></span> 
					<button type="button" id="return" class="btn-cancel">取消</button></span>
				</div>
			</div>
		</div>
	</form>
</body>
</html>