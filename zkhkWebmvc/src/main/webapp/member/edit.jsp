<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<% String path = request.getContextPath();%>
<!DOCTYPE html>
<html ng-app="app">
<head>
 	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>
	<c:choose>
	<c:when test="${empty omem.memberid }">
	                              我的会员 --- 新增
	</c:when>
	<c:otherwise>
		<c:if test="${!isEdit}">
				我的会员 --- 查看
		</c:if>
		<c:if test="${isEdit}">
				我的会员 --- 修改
		</c:if>
	</c:otherwise>
	</c:choose>
	</title>
	<link rel="shortcut icon" type="image/x-icon" href="<%=path %>/<%=getServletContext().getAttribute("img") %>/title_ico.ico" />
    <link rel="stylesheet" href="<%=path %>/plugins/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=path %>/js/jquery-ui/themes/overcast/jquery-ui.min.css">
	<link rel="stylesheet" href="<%=path %>/plugins/zTree_v3/css/zTreeStyle/zTreeStyle.css">
	<link rel="stylesheet" href="<%=path %>/css/tree.css"/>
	<link rel="stylesheet" href="<%=path %>/css/general.css"/>
	<link rel="stylesheet" href="<%=path %>/css/memberInfo.css"/>
	
    <script src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script src="<%=path %>/js/jquery-ui/jquery-ui.js"></script>
    <script src="<%=path %>/plugins/bootstrap/js/bootstrap.min.js"></script>
	<script src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.core-3.5.min.js"></script>
	<script src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.excheck-3.5.js"></script>
	<script src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script src="<%=path %>/js/previewIMG.js"></script>
	<script src="<%=path %>/js/angular.js"></script>
	<script src="<%=path %>/js/validate.js"></script>
	<script src="<%=path %>/js/tree.js"></script>
	<script src="<%=path %>/js/packageDate.js"></script>
	<script src="<%=path %>/js/placeholder.js"></script>
	<script src="<%=path %>/js/memberInfo.js"></script>
	<script src="<%=path %>/js/simpleName.js"></script>
	<script src="<%=path %>/js/placeholder.js"></script>
	<script type="text/javascript">
		//decimal(5,2)onblur光标验证
		function VDblur4_(id1, msg, name) {
			var reg=/^(?:[1-9]\d{0,2}|0)(?:\.\d{1,2})?$/;
			var result = Number($('input[name="'+name+'"]').val());
	        if(reg.test(result) || result == ""){
	        		$("#" + id1).html("");
	        }else {
	            $("#" + id1).html(msg);
	        } 
		}
		
		function checkName(obj) {
			//var pattern = /[`~!@#$%^&*()_+<>?:"{},.\/;'[\]]/im;
			//只能输入中英文和”.”,不可输入其它字符;
			var pattern = /^[a-zA-Z.\u4e00-\u9fa5]+$/;
			var value = $(obj).val();
			if (!pattern.test(value)) {	
				if($(obj).val() != ''){
					$(obj).next().text('输入中英文和"."');
					if($(obj).next().is(":hidden")){
						$("#stadu_name").text('输入中英文和"."');
					}
				}
			}else{
				if(getRequired().memname){
					$(obj).next().text('*');
				}else{
					$(obj).next().text('');
				}
				$("#stadu_name").text('');
			}
		}
	
		var memberId = '${omem.memberid}';
		var baseUrl = '${pageContext.request.contextPath}';
		var contacts = [],cardNos=[],familyMembers=[];
		<c:if test="${not empty contacts}">contacts = ${contacts};</c:if>
		<c:if test="${not empty cardNos}">cardNos = ${cardNos};</c:if>
		<c:if test="${not empty familyMembers}">familyMembers = ${familyMembers};</c:if>
		
		var orgsConfig = ${orgsConfig};
		var roles = ${roles};
		var isEdit = ${isEdit};
		
		function allergicHisNameShow () {
			if($("#allergicHisY").is(":checked")){
				$("#allergicHisName").val('');
				$("#allergicHisName").show();
			}
			
			if($("#allergicHisN").is(":checked")){
				$("#allergicHisName").val('');
				$("#allergicHisName").hide();
			}
		}
		  
		function digits(id1, id2){
			var reg = /^(0|[1-9]\d*)$/;
			var value = $("#" + id1).val();
			if (!reg.test(value) && value != ''){
				$("#" + id2).html("请输入整数！");
			}else {
				$("#" + id2).html("");
			}
		}
		
		function digits2(name, id2){
			var reg = /^(0|[1-9]\d*)$/;
			var value = $('input[name="'+name+'"]').val();
			if (!reg.test(value) && value != ''){
				$("#" + id2).html("请输入整数！");
			}else {
				$("#" + id2).html("");
			}
		}
		
		$(function(){
			//ie readonly无光标
			$('.readonly-width input').attr("unselectable","on").css("border","1px solid #a9a9a9");
			
			var illList = $(".family-ill").length;
			for(var i = illList-1; i >= 0; i--){
				if($('.family-ill input[type="checkbox"][value="10"]:eq('+ i +')').is(":checked")){
					$('input[type="text"]', $('.family-ill input[type="checkbox"][value="10"]:eq('+ i +')').parents('td')[0]).attr('readOnly', false);
				} else {
					$('input[type="text"]', $('.family-ill input[type="checkbox"][value="10"]:eq('+ i +')').parents('td')[0]).attr('readOnly', true).val("");
				}
			}
			if($("#allergicHisY").is(":checked") == false){
				$("#allergicHisName").hide();
			}
			if($("#allergicHisY").is(":checked") == true){
				$("#allergicHisName").show();
			}
			
			$(".family-ill input[type='checkbox'][value='10']").click(function(){
				var $this = this;
				if($(this).is(':checked')){
					$('input[type="text"]', $(this).parents('td')[0]).attr('readOnly', false);
				}else {
					$('input[type="text"]', $(this).parents('td')[0]).attr('readOnly', true).val("");
				}
			}) 
		})
		
		function openMemTag(stadu) {
			if(!stadu){
				layer.closeAll();
				layer.open({
			   	    type: 2,
			   		skin : 'skin1',
			   	    title: '会员标签',
			   	    shadeClose: false,
			   	    shade: 0,
			   	    area: ['418px', '350px'],
			   	    content: '<%=path %>/label/listLabelItemsByDoc?labelIds=' + $("#labelItemIds").val()
			   	});
			}
		}
		
		function setLabelName(labelId, labelName) {
			$("#labelItemNames").val(labelName);
			$("#labelItemIds").val(labelId);
		}
	</script>
</head>

<body ng-controller="ctrl">
<div class="content">
	<div class="content-title">
		<c:if test="${flag eq '6' }">
			<c:choose>
			    <c:when test="${empty omem.memberid}">
					基本信息与健康档案 --- 新增
				</c:when>
				<c:otherwise>
				    <c:if test="${!isEdit}">
						基本信息与健康档案 --- 查看
					</c:if>
					<c:if test="${isEdit}">
						基本信息与健康档案 --- 修改
					</c:if>
				</c:otherwise>
			</c:choose>
			<c:if test="${not empty msg }">
				 	<b><font color="red">${msg }</font></b>
			</c:if>
		</c:if>
		<c:if test="${flag ne '6' }">
			<c:choose>
			    <c:when test="${empty omem.memberid}">
					我的会员 --- 新增
				</c:when>
				<c:otherwise>
				    <c:if test="${!isEdit}">
						我的会员 --- 查看
					</c:if>
					<c:if test="${isEdit}">
						我的会员 --- 修改
					</c:if>
				</c:otherwise>
			</c:choose>
			<c:if test="${not empty msg }">
				 	<b><font color="red">${msg }</font></b>
			</c:if>
		</c:if>
	</div>
	<div>
		<!-- Nav tabs -->
		<ul class="nav nav-tabs" role="tablist" id="tab-ul">
		  	<li role="presentation" class="active"><a href="#main-message" aria-controls="main-message" role="tab" data-toggle="tab">会员基本信息</a></li>
		  	<li role="presentation"><a href="#other-message" id="other-information" aria-controls="other-message" role="tab" data-toggle="tab">会员其他信息</a></li>
		 	<li role="presentation"><a href="#phE-message" aria-controls="phE-message" role="tab" data-toggle="tab">健康档案信息</a></li>
		</ul>
		<form name="myForm" action="${pageContext.request.contextPath}/member/add" onsubmit="return check()" enctype="multipart/form-data" method="post">
		<input id="flag" name="flag" type="hidden" value="${flag}"/>
		<input name="memberid" value="${omem.memberid}" type="hidden"/>
		<input name="orgid" value="${omem.orgid}" type="hidden"/>
		<input name="memberGUID" value="${omem.memberGUID}" type="hidden"/>
		<input name="uniqueId" value="${omem.uniqueId}" type="hidden"/>
		<input name="source" value="${omem.source}" type="hidden"/>
		<input name="verifyType" value="${omem.verifyType}" type="hidden"/>
		<input name="isInfoPerfect" value="${omem.isInfoPerfect}" type="hidden"/>
		<!-- Tab panes -->
		<div class="tab-content">
		    <!-- 以下是会员基本信息  -->
  			<div role="tabpanel" class="tab-pane active" id="main-message">
		  			<table class="table table-bordered table-fixed">
						<tbody>
							<tr>
								<th colspan="12">基本信息</th>
							</tr>
							<tr>
								<td colspan="2">姓名：</td>
								<td colspan="3">
								   <c:if test="${omem.isInfoPerfect eq 0}">
								   <input class="require" id="memname" name="memname" onchange="checkName(this)" onblur="query()" type="text" maxlength='20' value="${omem.memname }" placeholder="请输入正确姓名!">
								  </c:if>
								  <c:if test="${omem.isInfoPerfect eq 1}">
								   <input class="require" id="memname" name="memname" readonly="readonly" onchange="checkName(this)" onblur="query()" type="text" maxlength='20' value="${omem.memname }">
								  </c:if>
								<span style="color:red" ng-show="required.memname">*</span>
								<span style="color:red" id="stadu_name"></span>
								</td>
								<td colspan="2">姓名简码：</td>
								<td colspan="3">
									<input type="text" id="simple_name" name="memNameCode" value="${omem.memNameCode }" onblur="CheckChinese(this.value)" readonly="readonly">
									<span style="color:red" ng-show="required.memname">*</span>
								</td>
								<td colspan="2" rowspan="9">
						           <div class="img-box">
							             <div id="preview" class="preview ">
										    <c:if test="${empty omem.headaddress}">
										    	<img id="imghead" class="imghead center-block" width="130" height="130" border=0 src='<%=path %>/img/memberImg.png' />
										    </c:if>
										    <c:if test="${not empty omem.headaddress}">
										   	    <img id="imghead" class="imghead center-block" width="130" height="130" border=0 src='<%=path %>/image/getImage?uniqueId=${omem.headaddress}' />
										    </c:if>
					 					 </div>
					 					 <p id="editImg" class="text-center"><label class="cursor" for="fieldName">修改头像</label></p>
						                 <input type="file" style="display: none;" name="fieldName" id="fieldName" class="fieldName" onchange="fileChange(this);" accept="image/*"/><span></span>
						                 <c:if test="${isEdit }">
						                 <p style="padding-left: 18px;color: red;">推荐120*120px，小于200KB，文件格式 jpg、bmp、png</p>
						                 </c:if>
						                 <input type="hidden" name="headaddress" value="${omem.headaddress}"/>
						             </div>
								</td>
							</tr>
							<tr>
								<td colspan="2">会员类型名称：</td>
								<td colspan="3">
									<select class="select-normal mr-5" name="memid" id="memId">
									<c:forEach items="${typeList}" var="omes" varStatus="">
										<option value="${omes.memid}" <c:if test="${omes.memid eq omem.memid}">selected="selected"</c:if>>${omes.memname}</option>
									</c:forEach>
									</select>
									<span style="color:red">*</span>
									<input name="omesMemName" type="hidden" value="${omem.memberType.memname }">
								</td>
								<td colspan="2">身份证号：</td>
								<td colspan="3">
								<c:choose>
								<c:when test="${empty omem.memberid}">
									<input id="idCard" onchange="isIDCard(this)" name="idcard" type="text" value="${omem.idcard }" class="vp" maxlength='18' /><span></span> 
								</c:when>
								<c:otherwise>
								 <c:if test="${omem.isInfoPerfect eq 0}">
								 <input id="idCard" onchange="isIDCard(this)" name="idcard" type="text" value="${omem.idcard }" class="vp" maxlength='18' /><span></span>
								 </c:if>
								  <c:if test="${omem.isInfoPerfect eq 1}">
								  <input id="idCard" onchange="isIDCard(this)" name="idcard" type="text" value="${omem.idcard }" class="vp" maxlength='18' readonly="readonly" /><span></span>
								  </c:if>
<%-- 									<c:if test="${omem.idcard != null && omem.idcard !='' }"> </c:if> --%>
<%-- 									<c:if test="${omem.idcard == null || omem.idcard =='' }"> </c:if> --%>
								</c:otherwise>
								</c:choose>
								<span style="color:red"></span>
								<span style="color:red" ng-show="required.idcard">*</span>
								</td>
							</tr>
							<tr>
								<td colspan="2">性别：</td>
								<td colspan="3">
									<label class="radio-inline check-gender">
									  <input type="radio" name="sexual" value="1" <c:if test="${ omem.gender eq '1'}">checked</c:if>/>男
									</label>
									<label class="radio-inline check-gender">
									  <input type="radio" name="sexual" value="2" <c:if test="${ omem.gender eq '2'}">checked</c:if>/>女
									</label>
									<label class="radio-inline mr-align check-gender">
									  <input type="radio" name="sexual" value="3" <c:if test="${ omem.gender ne '1' and omem.gender ne '2'}">checked</c:if>/>未知
									</label><span style="color:red;" ng-show="required.gender">*</span>
									<input type="hidden" name="gender" value="${ omem.gender}" />
								</td>
								<td colspan="2">出生日期：</td>
								<td colspan="3" class="date-read">
									<c:if test="${omem.idcard != null && omem.idcard !='' }"><input class="info-date" name="birthDate" type="text" readonly></c:if>
									<c:if test="${omem.idcard == null || omem.idcard =='' }"><input class="info-date" name="birthDate" type="text" onchange="checkDate(this)" id="birthDate"  value='<fmt:formatDate value="${omem.birthdate }" pattern="yyyy-MM-dd"/>'></c:if>
									<span style="color:red"></span>
									<span style="color:red" ng-show="required.birthDate">*</span>
									<input type="hidden" name="birthdate" value="<fmt:formatDate value="${omem.birthdate }" pattern="yyyy-MM-dd"/>" />
								</td>
							</tr>
							<tr>
								<td colspan="2">手机号：</td>
								<td colspan="3">
									<c:if test="${omem.verifyType eq 1 }"><input name="tel" type="text" value="${omem.tel }" maxlength='11' onchange="if(isNaN(this.value)){alert('手机号格式输入错误,请重新输入');this.value='';}" onblur="isPhone(this)" readonly="readonly"/></c:if>
									<c:if test="${omem.verifyType eq 0}"><input name="tel" type="text" value="${omem.tel }" maxlength='11' onchange="if(isNaN(this.value)){alert('手机号格式输入错误,请重新输入');this.value='';}" onblur="isPhone(this)"/></c:if>
									<span style="color:red"></span>
									<span style="color:red" ng-show="required.tel">*</span>
									<span></span>
								</td>
								<td colspan="2">籍贯：</td>
								<td colspan="3">
									<input name="nativeaddr" type="text" maxlength="20" value="${omem.nativeaddr }">
								</td>
							</tr>
							<tr>
								<td colspan="2">邮箱：</td>
								<td colspan="3">
									<input name="email" type="text" maxlength="30" value="${omem.email }" onchange="isEmail(this)"/>
									<span></span>
								</td>
								<td colspan="2">婚姻状况：</td>
								<td colspan="3">
                                    <select class="select-normal" name="marrystatus">
									  <c:forEach items="${marryStatus }" var="item">
										 <option value="${item.val}" <c:if test="${item.val eq omem.marrystatus }"> selected </c:if> >${item.descr }</option>
									  </c:forEach>
					                </select>									
								</td>
							</tr>
							<tr>
								<td colspan="2">教育状况：</td>
								<td colspan="3">
									<select class="select-normal" name="educationstatus">
										<c:forEach items="${educationStatus }" var="item">
										    <option value="${item.value }" <c:if test="${item.value eq omem.educationstatus }"> selected </c:if>>${item.descr }</option>
										</c:forEach>
					            	</select>
								</td>
								<td colspan="2">职业：</td>
								<td colspan="3">
									<select name="occupation" class="occupation">
					                   <c:forEach items="${accupations }" var="item">
					                      <option value="${item.value }" <c:if test="${item.value eq omem.occupation }"> selected </c:if>>${item.desc }</option>
					                   </c:forEach>
					                </select>
								</td>
							</tr>
							<tr>
								<td colspan="2">地址：</td>
								<td colspan="3">
									<input class="address" onblur="Required(this)" name="address"  type="text" maxlength="200" onchange="if(!isNaN(this.value)){alert('不能只输入数字');this.value='';}" value="${omem.address }"/>
								</td>
								<td colspan="2">建档医生：</td>
								<td colspan="3">
									<input name="docname" type="text" maxlength='20' value="${omem.docname}" readonly="readonly">
									<input name="docid" type="hidden" value="${omem.docid }" />
								</td>
							</tr>
							<tr>
								<td colspan="2">会员状态：</td>
								<td colspan="3">
									<select name="status" id="useTag" class="select-normal">
								    <option value="T" <c:if test="${ omem.status ne 'F'}">selected</c:if>>正常</option>
								    <option value="F" <c:if test="${ omem.status eq 'F'}">selected</c:if>>冻结</option>
								    </select>
								    <img class="status" id="statusImg" src="${pageContext.request.contextPath}/img/${omem.status=='F'?'frozen.png':'normal.png'}" alt="状态">
								</td>
								<td colspan="2">注册日期：
								<td colspan="3"><input type="text" readonly value="<fmt:formatDate value='${omem.createtime}' pattern='yyyy-MM-dd'/>"/>
								<input type="hidden" value="<fmt:formatDate value='${omem.createtime}' pattern='yyyy-MM-dd HH:mm:ss'/>" name="createtime"/>
								</td>
							</tr>
							<tr>
								<td colspan="2">会员标签：</td>
								<td colspan="8">
									<div class="position-r" style="width: 100%;">
									    <input type="hidden" value="${omem.labelItemIds }" name="labelItemIds" id="labelItemIds">
										<input class="" style="width: 100%;" type="text" value="${omem.labelItemNames}" readonly id="labelItemNames">
										<i class="member-search2" onclick="openMemTag(${!isEdit});"></i>
									</div>
								</td>
							</tr>
							<tr>
								<th colspan="12">会员分组(<span class="red">*</span>)<input type="text" id="position"></th>
							</tr>
							<c:if test="${!isEdit }">
							<c:forEach items="${groupNames}" var="item" varStatus="stu">
							<tr id="group-list">
								<td class="v">分组${stu.index+1}</td>
								<td class="u group-name" colspan="11">
									${item }
								</td>
							</tr>
							</c:forEach>
							</c:if>
							<c:if test="${isEdit}">
							<tr>
								<td colspan="12">
									<input name="memGrpid" type="hidden" id="memberGroupId" value="${memGrpid}" />
					                <ul id="treeDemo" class="ztree"></ul>
						            <input name="memGrpNames" type="hidden" id="memberGroupName" />
								</td>
							</tr>
							</c:if>
							<tr>
								<th colspan="12">可用账号</th>
							</tr>
							<c:forEach items="${omem.accountList}" step="2" varStatus="v">
							<tr>
								
								<td colspan="2">账号${v.index+1}</td>
								<td colspan="${empty omem.accountList[v.index+1] ? 10 : 4}">${omem.accountList[v.index].account}(${omem.accountList[v.index].accounttypeName})</td>
								<c:if test="${not empty omem.accountList[v.index+1]}">
									<td colspan="2">账号${v.index+2}</td>
									<td colspan="4">${omem.accountList[v.index+1].account}(${omem.accountList[v.index+1].accounttypeName})</td>
								</c:if>
							</tr>
							</c:forEach>
						</tbody>
					</table>
	 	 	</div>
	 	 	<!-- 以下是会员其他信息  -->
	 	 	<div role="tabpanel" class="tab-pane" id="other-message">
			  		<table class="table table-bordered table-fixed">
						<tr>
							<th colspan="12">紧急联系人</th>
						</tr>
						<tbody ng-repeat="contact in contacts">
							<tr>
								<td colspan="12" class="text-center"><b>紧急联系人{{digit[$index] ? digit[$index] : $index+1}}</b></td>
							</tr>
							<tr>
								<td colspan="1">联系人姓名：</td>
								<td colspan="2" class="name">
									<input name='linkmanList[{{$index}}].contactname' type="text" maxlength='20' ng-model="contact.contactname">
								</td>
								<td colspan="2">联系人手机号：</td>
								<td colspan="2">
									<input name='linkmanList[{{$index}}].contactmobphone' type="text" ng-model="contact.contactmobphone" onchange="if(isNaN(this.value)){alert('手机号格式输入错误,请重新输入');this.value='';}" onblur="isPhone(this)" maxlength='11'>
									<span class="valid"></span>
								</td>
								<td colspan="1">关系：</td>
								<td colspan="2">
									<input name='linkmanList[{{$index}}].relation' maxlength='20' type="text" ng-model="contact.relation">
								</td>
								<td colspan="2" class="text-center">
									<c:if test="${isEdit }">
										<button type="button" class="btn-normal btnshow" ng-click="event.removeContact($index)">移除紧急联系人</button>
									</c:if>
									<button type="button" class="btn-normal btnhide" style="display:none;">移除紧急联系人</button>
								</td>
							</tr>
						</tbody>
						<tr id="addbutton">
							<td colspan="10" class="border-right"></td>
							<td colspan="2"  class="text-center border-left">
								<c:if test="${isEdit }">
									<button type="button" class="btn-normal btnshow" ng-click="event.addContact()">添加紧急联系人</button>
								</c:if>
								<button type="button" class="btn-normal btnhide" style="display:none;">添加紧急联系人</button>
							</td>
						</tr>
						
						<tr ng-show="orgsConfig.isDisplayCard==1">
							<th colspan="12">智能卡号</th>
						</tr>
						<tr ng-repeat="c in cardNos" ng-show="orgsConfig.isDisplayCard">
							<td colspan="2">智能卡号{{digit[$index] ? digit[$index] : $index+1}}：</td>
							<td colspan="8">
								<input name='omemCardNos[{{$index}}].logID' ng-show="false" index="{{$index}}" ng-model="c.logID" >
								<input name='omemCardNos[{{$index}}].cardNo' type="text" maxlength='18' index="{{$index}}" ng-model="c.cardNo" ng-readonly="c.readonly" card-verify ng-blur="event.cardValid(myForm.$invalid)" style="width: 350px;"><span style="color:red">*</span>
								<span class="error" ng-show="activate">{{c.error}}</span>
							</td>
							<td colspan="2" class="text-center">
							<c:if test="${isEdit }">
								<button type="button" class="btn-normal btnshow" ng-click="event.removeCardNo($index)">移除智能卡号</button>
							</c:if>
								<button type="button" class="btn-normal btnhide" style="display:none;">移除智能卡号</button>
							</td>
						</tr>
						<tr ng-show="orgsConfig.isDisplayCard==1" id="intelligence-number">
							<td colspan="10" class="border-right"></td>
							<td colspan="2" class="border-left text-center">
								<c:if test="${isEdit }">
									<button type="button" class="btn-normal btnshow" ng-click="event.addCardNo(myForm.$invalid)">添加智能卡号</button>
								</c:if>
								<button type="button" class="btn-normal btnhide" style="display:none;">添加智能卡号</button>
							</td>
						</tr>
						<tr>
							<th colspan="12">家庭成员</th>
						</tr>
						<tbody ng-repeat="fm in familyMembers">
						<tr>
							<td colspan="12" class="text-center"><b>家庭成员{{digit[$index] ? digit[$index] : $index+1}}</b></td>
						</tr>
						<tr>
							<td colspan="1">成员关系：</td>
							<td colspan="2">
								<input ng-show="false" name="omemFamilyCards[{{$index}}].logID" value="{{fm.logID}}" ng-model="fm.logID">
								<input type="hidden" name="omemFamilyCards[{{$index}}].familyMemberid" value="{{fm.familyMemberid}}">
								<input type="hidden" name="omemFamilyCards[{{$index}}].familyMember.birthdate" value="{{fm.familyMember.birthdate}}">
								<input type="hidden" name="omemFamilyCards[{{$index}}].familyMember.gender" value="{{fm.familyMember.gender}}">
								<input type="hidden" name="omemFamilyCards[{{$index}}].role" value="{{fm.role}}">
								<input type="hidden" name="omemFamilyCards[{{$index}}].roleName" value="{{fm.roleName}}">
								<input type="hidden" name="omemFamilyCards[{{$index}}].familyMember.memid" value="{{fm.familyMember.memid}}">
<!-- 									{{roles[fm.role].relation}} -->
									{{fm.roleName}}
							</td>
							<td colspan="1">姓名：</td>
							<td colspan="2">
								{{fm.familyMember.memname}}
								<input type="hidden" name="omemFamilyCards[{{$index}}].familyMember.memname" value="{{fm.familyMember.memname}}" ng-model="fm.name">
							</td>
							<td colspan="2">手机号：</td>
							<td colspan="2">
								{{fm.familyMember.tel}}
								<input type="hidden" name="omemFamilyCards[{{$index}}].familyMember.tel" value="{{fm.familyMember.tel}}" ng-model="fm.phone">
							</td>
							
							<td colspan="2" rowspan="2" class="text-center">
							<c:if test="${isEdit }">
								<button type="button" class="btn-normal btnshow" ng-click="event.removeFamilyMember($index)">移除家庭成员</button>
								<button type="button" class="btn-normal btnhide" style="display:none;">移除家庭成员</button>
							</c:if>
							</td>
						</tr>
						<tr>
							<td colspan="1">身份证号：</td>
							<td colspan="2">
								{{fm.familyMember.idcard}}<input type="hidden" name="omemFamilyCards[{{$index}}].familyMember.idcard" value="{{fm.familyMember.idcard}}" ng-model="fm.idCard">
							</td>
							<td colspan="1">会员类型：</td>
							<td colspan="2">{{fm.familyMember.memberType.memname}}</td>
							<td colspan="2" ng-show="orgsConfig.isDisplayCard">关联的智能卡号:</td>
							<td colspan="2" ng-show="orgsConfig.isDisplayCard">
								<input type="hidden" name="omemFamilyCards[{{$index}}].cardNosStr" value="{{fm.cardNosStr}}" size="100%">
								{{fm.cardNosStr}}
							</td>
							<td colspan="4" ng-show="!orgsConfig.isDisplayCard"></td>
						</tr>
						</tbody>
						<tr>
							<td colspan="10" class="border-right"></td>
							<td colspan="2" class="text-center border-left">
							<c:if test="${isEdit }">
								<button type="button" class="btn-normal btnshow" onclick="openAddFamily()">添加家庭成员</button>
								<button type="button" class="btn-normal btnhide" style="display:none;">添加家庭成员</button>
							</c:if>
							</td>
						</tr>
					</table>
	  		</div> 
	  		<!-- 以下是健康档案信息  -->
	 	 	<div role="tabpanel" class="tab-pane" id="phE-message">
		  			<table class="table table-bordered table-fixed">
						<tbody>
							<tr>
								<th colspan="12">档案信息</th>
							</tr>
							<tr class="readonly-width">
								<td colspan="2">民族：</td>
								<td colspan="4">
									<input type="text" value="${omem.relation.nation}" readonly/>
								</td>
								<td colspan="2">行政区域：</td>
								<td colspan="4">
									<input type="text" value="${omem.relation.neighborhoodCommittee}" readonly/>
								</td>
							</tr>
							<tr class="readonly-width">
								<td colspan="2">居住状况：</td>
								<td colspan="4">
									<input type="text" 
									<c:if test="${omem.relation.liveStatus eq 1}">本地户籍常住</c:if>
									<c:if test="${omem.relation.liveStatus eq 2}">本地户籍不常住</c:if>
									<c:if test="${omem.relation.liveStatus eq 3}">外地户籍常住</c:if>
									<c:if test="${omem.relation.liveStatus eq 4}">不详</c:if> readonly/>
								</td>
								<td colspan="2">与户主关系：</td>
								<td colspan="4">
									<input type="text" <c:if test="${omem.relation.relation eq 1 }">户主</c:if>
									<c:if test="${omem.relation.relation eq 2 }">配偶</c:if>
									<c:if test="${omem.relation.relation eq 3 }">子女</c:if>
									<c:if test="${omem.relation.relation eq 4 }">(外)孙子女</c:if>
									<c:if test="${omem.relation.relation eq 5 }">父母</c:if>
									<c:if test="${omem.relation.relation eq 6 }">(外)祖父母</c:if>
									<c:if test="${omem.relation.relation eq 7 }">兄弟姐妹</c:if>
									<c:if test="${omem.relation.relation eq 8 }">儿媳</c:if>
									<c:if test="${omem.relation.relation eq 9 }">女婿</c:if>
									<c:if test="${omem.relation.relation eq 10}">孙子女</c:if>
									<c:if test="${omem.relation.relation eq 11 }">侄子女</c:if>
									<c:if test="${omem.relation.relation eq 12 }">曾孙子女</c:if>
									<c:if test="${omem.relation.relation eq 13 }">祖父母</c:if>
									<c:if test="${omem.relation.relation eq 99 }">其他</c:if> readonly/>
								</td>
							</tr>
							<tr class="readonly-width">
								<td colspan="2">医疗费用支付方式：</td>
								<td colspan="4">
									<input type="text" <c:if test="${omem.relation.payType eq 1 }">全自费</c:if>
									<c:if test="${omem.relation.payType eq 2 }">全公费</c:if>
									<c:if test="${omem.relation.payType eq 3 }">城镇职工基本医疗保险</c:if>
									<c:if test="${omem.relation.payType eq 4 }">城镇居民基本医疗保险</c:if>
									<c:if test="${omem.relation.payType eq 5 }">新型农村合作医疗</c:if>
									<c:if test="${omem.relation.payType eq 6 }">社会医疗保险</c:if>
									<c:if test="${omem.relation.payType eq 7 }">商业医疗保险</c:if>
									<c:if test="${omem.relation.payType eq 8 }">贫困救助</c:if>
									<c:if test="${omem.relation.payType eq 99 }">其他</c:if> readonly/>
								</td>
								<td colspan="2">医疗保险号：</td>
								<td colspan="4">
									<input type="text"  value="${omem.relation.medicalAccount}" readonly/>
								</td>
							</tr>
							<tr class="readonly-width">
								<td colspan="2">其他医疗费用支付方式：</td>
								<td colspan="4">
									<input type="text" <c:if test="${omem.relation.payType eq 99 }">${omem.relation.otherPay}</c:if> readonly/>
								</td>
								<td colspan="2">新农合号：</td>
								<td colspan="4">
									<input type="text" value="${omem.relation.agroAccount}" readonly/>
								</td>
							</tr>
							<tr class="readonly-width">
								<td colspan="2">怀孕情况：</td>
								<td colspan="4">
									<input type="text" <c:if test="${omem.relation.fetationStatus eq 0 }">未孕</c:if>
									<c:if test="${omem.relation.fetationStatus eq 1 }">已孕未生产</c:if>
									<c:if test="${omem.relation.fetationStatus eq 2 }">已生产(随访期内)</c:if>
									<c:if test="${omem.relation.fetationStatus eq 3 }">已生产(随访期外)</c:if> readonly/>
								</td>
								<td colspan="2">档案状况：</td>
								<td colspan="4">
									<input type="text" 
									<c:if test="${omem.relation.fileStatus eq 1}">活动</c:if>
									<c:if test="${omem.relation.fileStatus eq 2}">非活动</c:if> readonly/>
								</td>
							</tr>
							<tr class="readonly-width">
								<td colspan="2">档案类别：</td>
								<td colspan="4">
									<input type="text" 
									<c:if test="${omem.relation.fileType eq 1}">城镇</c:if>
									<c:if test="${omem.relation.fileType eq 2}">农村</c:if>readonly/>
								</td>
								<td colspan="2">档案非活动状态原因：</td>
								<td colspan="4">
									<input type="text" <c:if test="${omem.relation.fileStatusDesc eq 1 }">死亡</c:if>
									<c:if test="${omem.relation.fileStatusDesc eq 2 }">失踪</c:if>
									<c:if test="${omem.relation.fileStatusDesc eq 3 }">迁出</c:if>
									<c:if test="${omem.relation.fileStatusDesc eq 4 }">其他</c:if>
									<c:if test="${omem.relation.fileStatusDesc eq 5 }">长期外出</c:if>readonly/>
								</td>
							</tr>
							<tr class="readonly-width">
								<td colspan="2">家庭档案编号：</td>
								<td colspan="4">
									<input type="text" value="${omem.relation.familyCode}" readonly/>
								</td>
								<td colspan="2">会员活力指数：</td>
								<td colspan="4">
									<input type="text" <c:if test="${omem.vitalIndex.vigorindex != 0 }"> ${omem.vitalIndex.vigorindex }</c:if> readonly/>%
								</td>
							</tr>
							<%-- <tr>
								<th colspan="12">会员疾病史</th>
							</tr>
							<tr>
								<td colspan='12'>
									<c:forEach var="dict" items="${dict}">
										<label class="checkbox-inline">
											<input type="checkbox" value="${dict.disease_id}" onclick="onChecked(this)" />${dict.disease_name}&nbsp;&nbsp;&nbsp;&nbsp;
											<input type="hidden" value="${dict.disease_name}" />
										</label>
									</c:forEach>
								</td>
							</tr> --%>
							<tr>
								<th colspan="12"><b>会员疾病史</b></th>
							</tr>
							<tr>
								<td colspan='12'>
								<input type="hidden" value="${ hypertensionFollowUp}" id="hyp_is_abled"/>
								<input type="hidden" value="${ diabetesFollowUp}" id="dia_is_abled"/>
									<c:forEach var="dict" items="${diseases}">
										<label class="checkbox-inline">
											<input id="dict_${dict.disease_id}" type="checkbox" value="${dict.disease_id}" onclick="onChecked(this)" />${dict.disease_name}&nbsp;&nbsp;
											<input id="hidDict_${dict.disease_id}" type="hidden" value="${dict.disease_name}" />
										</label>
									</c:forEach>
								</td>
							</tr>
							
							<c:forEach items="${omem.diseasesHistoryList }" var="item" varStatus="statu">
							    <c:if test="${item.diseaseid != null }">
									<tr id="disease_${item.diseaseid}">
										<td colspan="2">疾病名称：</td>
										<td colspan="4">
											<input id="showDisName_${item.diseaseid}" type="text" class="vp" value="${item.diseasename }" disabled="disabled" maxlength='20'/>
											<input id="hidDisId_${item.diseaseid}" type="hidden" class="vp" name="diseasesHistoryList[${item.diseaseid}].diseaseid" value="${item.diseaseid}"/>
											<input id="hidDisName_${item.diseaseid}" type="hidden" class="vp" name="diseasesHistoryList[${item.diseaseid}].diseasename" value="${item.diseasename }"/>
										</td>
										<td colspan="2">确诊时间：</td>
										<td colspan="4">
											<input type="text" class="diagTime" name="diseasesHistoryList[${item.diseaseid}].diagtime"  value='<fmt:formatDate value="${item.diagtime }" pattern="yyyy-MM-dd"/>' />
											<input id="diag_${item.diseaseid}" type="hidden" value="${item.diagtime }" />
										</td>
									</tr>
								</c:if>
							</c:forEach>
							
							<tr>
								<th colspan="12">会员家族病史</th>
							</tr>
							<input type="hidden" name="fmlHistories" id="fmlHistories"/>
							<c:forEach items="${relationList }" var="rel">
								 <tr>
									<td colspan="12" class="text-center">
										<b>${rel.relation}</b>
									</td>
								 </tr>
								 <tr>
								 <td colspan="12" class="family-ill">
									 <c:forEach var="dict" items="${diseases}">
										 <label class="checkbox-inline" title="familyHistory">
										      <input id="${rel.code}_${dict.disease_id}" type="checkbox" value="${dict.disease_id}" 
										     <c:forEach items="${omem.familyHistoryList}" var="mem4">
										           <c:if test="${rel.code eq  mem4.relation and mem4.diseaseID eq dict.disease_id}">checked</c:if>
											 </c:forEach> /> ${dict.disease_name}&nbsp;&nbsp;
										</label>	 
										      <c:if test="${dict.disease_id eq 10 }">
											      <input class="other-ill" type="text" maxlength='50' id="other_${rel.code}_${dict.disease_id}" 
												      <c:forEach items="${omem.familyHistoryList}" var="mem4">
												           <c:if test="${rel.code eq  mem4.relation and mem4.diseaseID eq dict.disease_id}"> value="${mem4.diseaseName}" </c:if>
													 </c:forEach> 
												  placeholder="请输入其他疾病名称" />
										      </c:if>
									 </c:forEach>
								 </td>
								 </tr>
							</c:forEach>
							
							<tr>
								<th colspan="12">体格检测与生活习惯</th>
							</tr>
							<tr>
								<td colspan="2">血型：</td>
								<td colspan="4">
									<label class="radio-inline">
									  <input type="radio" name="physical.bloodtype" value="A" <c:if test="${omem.physical.bloodtype eq 'A'}">checked</c:if>/>A型
									</label>
									<label class="radio-inline">
									  <input type="radio" name="physical.bloodtype" value="B" <c:if test="${omem.physical.bloodtype eq 'B'}">checked</c:if>/>B型
									</label>
									<label class="radio-inline">
									  <input type="radio" name="physical.bloodtype" value="O" <c:if test="${omem.physical.bloodtype eq 'O'}">checked</c:if>/>O型
									</label>
									<label class="radio-inline">
									  <input type="radio" name="physical.bloodtype" value="AB" <c:if test="${omem.physical.bloodtype eq 'AB'}">checked</c:if>/>AB型
									</label>
									<label class="radio-inline">
									  <input type="radio" name="physical.bloodtype" value="" <c:if test="${omem.physical.bloodtype ne 'A' && omem.physical.bloodtype ne 'B' && omem.physical.bloodtype ne 'O' && omem.physical.bloodtype ne 'AB'}">checked</c:if>/>不详
									</label>
								</td>
								<td colspan="2">过敏史：</td>
								<td colspan="4">
										<label class="radio-inline h27">
											  <input id="allergicHisN" type="radio" value="N" name="physical.allergichis" onclick="allergicHisNameShow()" <c:if test="${empty omem.physical.allergichis or omem.physical.allergichis eq 'N'}">checked</c:if>/>无
										</label>
										<label class="radio-inline h27">
											  <input id="allergicHisY" type="radio" value="Y" name="physical.allergichis" onclick="allergicHisNameShow()" <c:if test="${omem.physical.allergichis eq 'Y'}">checked</c:if>/>有
										</label>
										<input id="allergicHisName" name="physical.allergichisname" type="text" maxlength="100" value="${omem.physical.allergichisname }"/>
								</td>
							</tr>
							<tr>
								<td colspan="2">身高：</td>
								<td colspan="4">
									<input name="physical.height" id="mem2.height" type="text" value="${omem.physical.height eq 0 ? '' : omem.physical.height}" maxlength='3' onblur="digits2('physical.height','height_err')" onchange="if(isNaN(this.value)){alert('只能输入数字');this.value='';}">cm
									<span id="height_err" class="red"></span>
								</td>
								<td colspan="2">体重：</td>
								<td colspan="4">
									<input name="physical.weight" id="mem2.weight" type="text" value="${omem.physical.weight eq 0 ? '' : omem.physical.weight}" maxlength='6' onblur="VDblur4_('weight_err', '请输入三位整数且最多两位小数的值', 'physical.weight')" onchange="if(isNaN(this.value)){alert('只能输入数字');this.value='';}">KG
									<span id="weight_err" class="red"></span>
								</td>
							</tr>
							<tr>
								<td colspan="2">腰围：</td>
								<td colspan="4">
								<input name="physical.waist" id="waist" type="text" value="${omem.physical.waist eq 0 ? '' : omem.physical.waist}" maxlength='5' onblur="digits('waist','waist_err')" onchange="if(isNaN(this.value)){alert('只能输入数字');this.value='';}">cm
						   		<span id="waist_err" class="red"></span>
								</td>
								<td colspan="2">臀围：</td>
								<td colspan="4">
									<input name="physical.hip" id="hip" type="text" value="${omem.physical.hip eq 0 ? '' : omem.physical.hip}" maxlength='5' onblur="digits('hip','hip_err')" onchange="if(isNaN(this.value)){alert('只能输入数字');this.value='';}">cm
								    <span id="hip_err" class="red"></span>
								</td>
							</tr>
							<tr>
								<td colspan="2">收缩压：</td>
								<td colspan="4">
									<input name="physical.bloodh" type="text" value="${omem.physical.bloodh eq 0 ? '' : omem.physical.bloodh}" maxlength='3' onchange="if(isNaN(this.value)){alert('只能输入数字');this.value='';}">mmHg
						    		<span></span>
						    		</td>
								<td colspan="2">舒张压：</td>
								<td colspan="4">
								<input name="physical.bloodl" type="text" value="${omem.physical.bloodl eq 0 ? '' : omem.physical.bloodl}" maxlength='3' onchange="if(isNaN(this.value)){alert('只能输入数字');this.value='';}">mmHg
							    <span></span>
								</td>
							</tr>
							<tr>
								<td colspan="2">心率：</td>
								<td colspan="4">
									<input id="heartrate" name="physical.heartrate" type="text" value="${omem.physical.heartrate eq 0 ? '' : omem.physical.heartrate}" maxlength='3' onblur="digits('heartrate','heartrate_err')" onchange="if(isNaN(this.value)){alert('只能输入数字');this.value='';}">次/分<span class="red" id="heartrate_err"></span>
									<span></span>
								</td>
								<td colspan="2">脉搏：</td>
								<td colspan="4">
									<input id="pulse" name="physical.pulse" type="text" value="${omem.physical.pulse eq 0 ? '' : omem.physical.pulse}" maxlength='3' onblur="digits('pulse','pulse_err')" onchange="if(isNaN(this.value)){alert('只能输入数字');this.value='';}">次/分<span class="red" id="pulse_err"></span>
									<span></span>
								</td>
							</tr>
							<tr>
								<td colspan="2">空腹血糖：</td>
								<td colspan="4">
									<input id="fastingGlucose" name="physical.fastingglucose" type="text" value="<fmt:formatNumber pattern='#0.00' value='${omem.physical.fastingglucose eq 0 ? \'\' : omem.physical.fastingglucose}'/>" maxlength='5' onchange="physiqueData('FG-error', '请输入[0.00,50.00]之间的数值', 'fastingGlucose')">mmol/L<span class="red" id="FG-error"></span>
								</td>
								<td colspan="2">总胆固醇：</td>
								<td colspan="4">
									<input id="totalCholesterol" name="physical.totalcholesterol" type="text" value="<fmt:formatNumber pattern='#0.00' value='${omem.physical.totalcholesterol eq 0 ? \'\' : omem.physical.totalcholesterol}'/>" maxlength='5' onchange="physiqueData('TC-error', '请输入[0.00,50.00]之间的数值', 'totalCholesterol')">mmol/L<span class="red" id="TC-error"></span>
								</td>
							</tr>
							<tr>
								<td colspan="2">甘油三酯：</td>
								<td colspan="4">
									<input id="triglyceride" name="physical.triglyceride" type="text" value="<fmt:formatNumber pattern='#0.00' value='${omem.physical.triglyceride eq 0 ? \'\' : omem.physical.triglyceride}'/>" maxlength='5' onchange="physiqueData('triglyceride-error', '请输入[0.00,50.00]之间的数值', 'triglyceride')">mmol/L<span class="red" id="triglyceride-error"></span>
									<span></span>
								</td>
								<td colspan="2">高密度脂蛋白：</td>
								<td colspan="4">
									<input id="densityLipop" name="physical.densitylipop" type="text" value="<fmt:formatNumber pattern='#0.00' value='${omem.physical.densitylipop eq 0 ? \'\' : omem.physical.densitylipop}'/>" maxlength='5' onchange="physiqueData('DL-error', '请输入[0.00,50.00]之间的数值', 'densityLipop')">mmol/L<span class="red" id="DL-error"></span>
								</td>
							</tr>
							<tr>
								<td colspan="2">低密度脂蛋白：</td>
								<td colspan="4">
									<input id="ldlip" name="physical.ldlip" type="text" value="<fmt:formatNumber pattern='#0.00' value='${omem.physical.ldlip eq 0 ? \'\' : omem.physical.ldlip}'/>" maxlength='5' onchange="physiqueData('ldlip-error', '请输入[0.00,50.00]之间的数值', 'ldlip')">mmol/L<span class="red" id="ldlip-error"></span>
								</td>
								<td colspan="2">尿酸：</td>
								<td colspan="4">
									<input id="uricAcid-input" name="physical.uricacid" type="text" value="${omem.physical.uricacid eq 0 ? '' : omem.physical.uricacid}" onchange="if(isNaN(this.value)){alert('只能输入数字');this.value='';}" maxlength='3' onblur="digits('uricAcid-input','checked-false');">umol/L
									<span class="red" id="checked-false"></span>
								</td>
						</tr>
						<tr>
							<td colspan="12" align="center" style=font-weight:bold>生活习惯</td>
						</tr>
							<tr>
								<td colspan="2">是否抽烟：</td>
								<td colspan="4">
									<input type="checkbox" name="habit.smoking" value="Y" <c:if test="${ omem.habit.smoking eq 'Y'}">checked</c:if> />
								</td>
								<td colspan="2">是否喝酒：</td>
								<td colspan="4">
									<input type="checkbox" name="habit.dodrink" value="Y" <c:if test="${ omem.habit.dodrink eq 'Y'}">checked</c:if> />
								</td>
							</tr>
							<tr>
								<td colspan="2">不喜欢的食物：</td>
								<td colspan="4">
									<input type="text" name="habit.dontfood" maxlength='20' value="${omem.habit.dontfood }" />
								</td>
								<td colspan="2">主食：</td>
								<td colspan="4">
									<label class="radio-inline">
										<input name="habit.staplefood" type="radio" value="粥" class="input_radio" <c:if test="${ omem.habit.staplefood eq '粥'}">checked</c:if> />粥
									</label>
									<label class="radio-inline">
										<input name="habit.staplefood" type="radio" value="米" class="input_radio" <c:if test="${ omem.habit.staplefood eq '米'}">checked</c:if> />米
									</label>
									<label class="radio-inline">
										<input name="habit.staplefood" type="radio" value="面" class="input_radio" <c:if test="${ omem.habit.staplefood eq '面'}">checked</c:if> />面
									</label>
								</td>
							</tr>
							<tr>
								<td colspan="2">睡眠状况：</td>
								<td colspan="4">
									<label class="radio-inline">
										<input name="habit.sleepcond" type="radio" value="Y" class="input_radio" <c:if test="${ omem.habit.sleepcond eq 'Y'}">checked</c:if> />好
									</label>
									<label class="radio-inline">
										<input name="habit.sleepcond" type="radio" value="N" class="input_radio" <c:if test="${ omem.habit.sleepcond eq 'N'}">checked</c:if> />差
									</label>
								</td>
								<td colspan="2">喜欢的运动：</td>
								<td colspan="4">
									<input type="text" name="habit.likesports" value="${omem.habit.likesports }" maxlength='20'/>
								</td>
							</tr>
							<tr>
								<td colspan="2">运动时长：</td>
								<td colspan="4">
									<input type="text" name="habit.movelong " value="${omem.habit.movelong }"  maxlength='3' onchange="if(isNaN(this.value)){alert('只能输入数字');this.value='';}"/>小时
								</td>
								<td colspan="2">时间段：</td>
								<td colspan="4">
								    <select name="habit.timeseg" class="height-normal">
								      <c:forEach items="${segments }" var="item">
								      <option value="${item.value }" <c:if test="${item.value eq omem.habit.timeseg }">selected</c:if>>${item.segValue }</option>
								      </c:forEach>
								    </select>
								</td>
							</tr>
							<tr>
								<td colspan="2">每周几次：</td>
								<td colspan="4">
									<input type="text" id="weekly" name="habit.weeknumtimes" value="${omem.habit.weeknumtimes eq 0 ? '' : omem.habit.weeknumtimes}" maxlength='4' onblur="digits('weekly','weekly_err')" onchange="if(isNaN(this.value)){alert('只能输入数字');this.value='';}"/>次<span class="red" id="weekly_err"></span>
								</td>
								<td colspan="2"></td>
								<td colspan="4"></td>
							</tr>
						</tbody>
					</table>
		  	</div>
		  	<c:choose>
		  	<c:when test="${resource eq 'report' }">
			  	<div class="text-center margin-10">
			  		<input type="button" onclick="javascript:window.close();" class="btn-cancel mg-lf-50" value="关闭"/>
			  	</div>
		  	</c:when>
		  	<c:otherwise>
		  	<c:if test="${empty omem.memberid || isMy}">
			  	<div class="text-center margin-10">
			  		<c:if test="${isEdit}">
						<input type="button" ng-click="event.submit(myForm.$invalid)" value="保存" id="content_sub" class="btn-inquiry mg-lf-50"/>
						<c:if test="${flag ne '6' }">
						   <input type="button" onclick="isReturn('<%=path %>/member/memberList?flag=${flag }')" class="btn-cancel mg-lf-50" value="返回" />
						</c:if>
					</c:if>
					<c:if test="${!isEdit}">
						<input type="button" onclick="window.location.href='<%=path %>/member/edit/${omem.memberid }?flag=${flag}'" value="修改" id="content_sub" class="btn-inquiry mg-lf-50 ico-edit"/>
					</c:if>
				</div>
			</c:if>
		  	</c:otherwise>
		  	</c:choose>
		</div>
		</form>
		<input id="memGrpid" type="hidden" value="${memGrpid}" />
	</div>
</div>
</body>
</html>