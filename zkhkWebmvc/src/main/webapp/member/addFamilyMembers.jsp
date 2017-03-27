<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en" ng-app="app">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>添加家庭成员</title>
	<link rel="stylesheet" href="<%=path %>/plugins/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=path %>/js/jquery-ui/themes/overcast/jquery-ui.min.css">
	<link rel="stylesheet" href="<%=path %>/css/general.css" />
	<link rel="stylesheet" href="<%=path %>/css/addFamilyMembers.css" />
	
	<script src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script src="<%=path %>/js/angular.js"></script>
	<script src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script src="<%=path %>/js/member/addFamilyMembers.js"></script>
	<script src="<%=path %>/js/jquery-ui/jquery-ui.js"></script>
	<script src="<%=path %>/js/placeholder.js"></script>
	<style type="text/css">
		.otherDes {
		    width: 138px !important;
		    position: absolute;
		    left: 2px;
		    top: 2px;
		    z-index: 99;
		    border: 2px solid #FFF;
		    display: none;
		    outline: none;
		}
		
		 .text-top {
	        vertical-align: text-top;
	    }
	    
	    .error-div {
	    	height: 22px; 
	    	line-height: 22px;
	    	margin-bottom: 1px;
	    }
	</style>
	<script type="text/javascript">
		var baseUrl = '<%=path %>';
		function selected(name, txt){
			var obj = $("select[name ='"+name+"'] option:checked");
			
			if(obj.val() == 'number:7'){
				$("#" + txt).show();
				$("#" + txt).focus();
			} else {
				$("#" + txt).hide();
			}
		}
	</script>
</head>
<body ng-controller="ctrl">
	<div class="mainContent">
		<ng-form name="myForm">
		<table>
			<tr>
				<td width="23%" class="text-top">成员关系：</td>
				<td style="position: relative">
					<select class="select-width" ng-model="member.role" name="role" ng-options="role.role as role.relation for role in roles" onchange="selected('role', 'txt1')">
					</select><span class="red">*</span>
					<input maxlength="10" type="text" id="txt1" ng-model="member.roleName" name="roleName" placeholder="其他" class="otherDes" />
					<div class="error-div"><span class="red" ng-show="myForm.role.$dirty || member.msg.active">{{member.msg.role}}</span></div>
				</td>
			</tr>
			<tr>
				<td class="text-top">姓名：</td>
				<td>
					<input type="text" ng-model="member.name" name="name" maxlength="20" ng-disabled="member.status==2"><span class="red" ng-show="required.memname">*</span>
					<button type="button" class="btn-inquiry" onclick="parent.openPage('选择会员','member')">选择</button>
					<div class="error-div"><span class="red" ng-show="myForm.name.$dirty || member.msg.active">{{member.msg.name}}</span></div>
				</td>
			</tr>
			<tr>
				<td class="text-top">身份证号：</td>
				<td>
					<input type="text" ng-model="member.idCard" name="idCard" maxlength="18" ng-blur="event.getOmemInfo()" ng-disabled="member.status==2" onkeyup="this.value = this.value.toUpperCase();"><span class="red" ng-show="required.idcard">*</span>
					<div class="error-div"><span class="red" ng-show="myForm.idCard.$dirty || member.msg.active">{{member.msg.idCard}}</span></div>
				</td>
			</tr>
			
			<tr>
				<td class="text-top">手机号：</td>
				<td>
					<input type="text" ng-model="member.phone" name="phone" maxlength="11" ng-disabled="member.status==2"><span class="red" ng-show="required.tel">*</span>
					<div class="error-div"><span class="red" ng-show="myForm.phone.$dirty || member.msg.active">{{member.msg.phone}}</span></div>
				</td>
			</tr>
			<tr>
				<td class="text-top">性别：</td>
				<td class="disabled">
					<label for="gender_1" class="radio-inline"><input type="radio" name="sexMember" ng-model="member.gender" value="1" id="gender_1" ng-disabled="member.status!=0">男</label>
					<label for="gender_2" class="radio-inline"><input type="radio" name="sexMember" ng-model="member.gender" value="2" id="gender_2" ng-disabled="member.status!=0">女</label>
					<label for="gender_3" class="radio-inline"><input type="radio" name="sexMember" ng-model="member.gender" value="3" id="gender_3" ng-disabled="member.status!=0">未知</label>
					<span style="color: red; display: inline-block; position: relative; top: 4px; left: 13px;" ng-show="required.gender">*</span>
					<div class="error-div"><span class="red">{{member.msg.gender}}</span></div>
				</td>
			</tr>
			<tr>
				<td class="text-top">出生日期：</td>
				<td>
					<input type="data" ng-model="member.birthDate" ng-disabled="member.status!=0" datepicker id="birthDate"><span class="red" ng-show="required.birthDate">*</span>
					<div class="error-div"><span class="red">{{member.msg.birthDate}}</span></div>
				</td>
			</tr>
			<tr>
				<td class="text-top">会员类型：</td>
				<td>
					<div ng-show="member.status==2" style="display: inline-block;">{{member.memTypeName}}</div>
					<select class="select-width2" ng-model="member.memId" name="memId" ng-options="memType.value as memType.name for memType in memTypes" ng-show="member.status!=2">
					</select><span class="red">*</span>
					<div class="error-div"><span class="red">{{member.msg.memId}}</span></div>
				</td>
			</tr>
			<tr ng-show="orgsConfig.isDisplayCard">
				<td class="text-top">关联智能卡号：<span style="color: red; display: inline-block;">*</span></td>
				<td>
					<div ng-repeat="c in member.cardNos" class="fix-width checkbox">
						<label ng-show="c.cardNo.length > 0" for="cardNo_{{$index}}"><input type="checkbox" ng-model="c.checked" name="cardNos" id="cardNo_{{$index}}" ng-show="c.cardNo.length > 0">{{c.cardNo}}</label>
					</div>
					<div class="error-div"><span class="red" ng-show="myForm.cardNos.$dirty || member.msg.active">{{member.msg.cardNos}}</span></div>
				</td>
			</tr>
		</table>
		<ng-form>
	</div>
	<div class="text-center">
		<input type="button" class="mg-lf-50" ng-class="onOff ? 'btn-inquiry': 'btn-cancel'" ng-click="event.confirm()" ng-disabled="!onOff" value="确定">
		<input type="button" class="btn-cancel mg-lf-50" ng-click="event.closeLayer()" value="取消">
	</div>
</body>

</html>