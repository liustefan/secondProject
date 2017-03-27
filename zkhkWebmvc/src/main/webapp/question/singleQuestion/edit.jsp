<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%>

<!DOCTYPE html>
<html ng-app="createQuestionnaire" ng-controller="QuestionListCtrl">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title><c:if test="${empty pojo.qustid}">创建</c:if><c:if test="${not empty pojo.qustid}"><c:if test="${not empty view}">查看</c:if><c:if test="${empty view}">修改</c:if></c:if>问卷</title>

	<link rel="stylesheet" href="<%=path %>/js/ngDialog/css/ngDialog.css">
	<link rel="stylesheet" href="<%=path %>/js/ngDialog/css/ngDialog-theme-default.min.css">
	<link rel="stylesheet" href="<%=path %>/js/ngDialog/css/ngDialog-theme-plain.min.css">
	<link rel="stylesheet" href="<%=path %>/css/question.css">
	<link rel="stylesheet" href="<%=path %>/css/questionnaire.css">
	<link rel="stylesheet" href="<%=path %>/css/tab.css">
	<link rel="stylesheet" href="<%=path %>/plugins/zTree_v3/css/zTreeStyle/zTreeStyle.css">
	<link rel="stylesheet" href="<%=path %>/css/tree.css">

	<script type="text/javascript" src="<%=path %>/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.form.js"></script>
	
	<script type="text/javascript" src="<%=path %>/js/angular.js"></script>
	<script type="text/javascript" src="<%=path %>/js/angular-animate.js"></script>
	<script type="text/javascript" src="<%=path %>/js/ngDialog/js/ngDialog.js"></script>
	<script type="text/javascript" src="<%=path %>/js/createQuestion.js"></script>
	
	<script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.core-3.5.min.js"></script>
	<script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.excheck-3.5.js"></script>
	<script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.exhide-3.5.js"></script>
	<script type="text/javascript" src="<%=path %>/js/tree.js"></script>
	
	<style type="text/css">
	/* html {
	overflow:hidden;
	} */
	
	input.error {
	  border: 1px dotted red;
	}
	
	form label.error, label.error {
	  color: red;
	  margin-left: 10px;
	}
	
	.error {
		color: red;
	}
	
	.pop-ztree {
		width: 290px;
	}
	
	/* 淡绿色按钮样式 */
	.btn-inquiry {
		margin: 0 5px;
		padding: 0 15px;
		height: 30px;
		border: 1px solid #6AD279;
		border-radius: 3px;
		background-color: #DAF6D7;
		cursor: pointer;
		font-family:"Microsoft YaHei", "SimSun";
		font-weight: normal;
		text-decoration: none;
		color: black;
		outline: none;
	}
	
	body .btn-inquiry:hover {
		background-color: #64C25A;
	}
	
	/* 鼠标移入按钮字体加粗、颜色变成白色 */
	.font-change:hover { 
		color: #fff;
		font-weight: bold;
	}
	
	.btn-box {
		height: initial !important;
	   	line-height: initial !important;
	}
	
	.btn-step {
		background-color: #64C25A;
		color: #fff;
		font-weight: bold;
		margin: 0 5px;
		padding: 0 15px;
		height: 30px;
		border: 1px solid #6AD279;
		border-radius: 3px;
		cursor: pointer;
		font-family: "Microsoft YaHei", "SimSun";
		text-decoration: none;
		outline: none;
	}
	
	.page-title {
		height: 30px;
		line-height: 30px;
		overflow: auto;
	}
	
	.answer-list {
		margin-left: 55px;
	}
	
	.no-border {
		border: none;
	}
	
	.w282 {
		width: 282px\9 !important;
	}
	
	.page-box {
	    height: 30px;
	    width: 100%;
	    line-height: 30px;
	    margin: 10px 0;
	}
	
	input.form-control {
		width: 282px;
	}
	
	.org-search {
	    position: absolute;
	    right: 3px;
	    top: 1px;
	    width: 20px;
	    height: 20px;
		display: inline-block;
	    background: url(../../img/u125.png) no-repeat center;
	}
	
	.position-r {
		position: relative;
		display: inline-block;
	}
	</style>
	<script type="text/javascript">
		var operate = 'create';
		var OMFQ;
		<c:if test="${not empty pojo.qustid}">
			<c:if test="${!view}">operate='edit';</c:if>
			<c:if test="${view}">operate='view';</c:if>
			OMFQ = ${json};
		</c:if>
		$(function(){
			if($.browser.version=='9.0'){
				$("#orgName-input input[type='text']").addClass("w282");
				$("#qustNameType-input").addClass("w282");
			}
			
			if(operate=='view'){
				$("form").find("*").attr("disabled", true);
				$("form").find("input[type='button']").hide();
			}
			var setting = {
					check: {
						enable: true,
						chkStyle: "radio",
						radioType: "all"
					},
					data : {
						simpleData : {
							enable : true
						}
					},
					view : {
						dblClickExpand: false,
						selectedMulti: false,
						showIcon: false
					},
					callback : {
						onCheck : function(e, treeId, treeNode){
	// 						$("#orgId").val(treeNode.id);
	// 						$("#orgs").val(treeNode.name);
							querySingleOopt(treeNode);
						},
						beforeClick: checkedBox,
						onExpand: zTreeOnExpand
					}
				};
			$.ajax({
				type : "GET",
				url : '../../org/listAllOrg?pId=0',
				async: false,
				success : function(rsp) {
					var obj = rsp;
					$(obj).each(function(i, e) {
						e.nocheck=e.endTag==='Y'?false:true;
					});
					$.fn.zTree.init($("#treeDemo"), setting, obj);
				}
			});
			$("#orgs_search").click(function(){
				var cityObj = $("#orgs");
				var cityOffset = $("#orgs").offset();
				
				$("#menuContent").css({
					left : cityOffset.left + "px",
					top : cityOffset.top + cityObj.outerHeight() + "px"
				}).slideDown("fast");
	
				$("body").bind("mousedown", function(event){
					if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(
							event.target).parents("#menuContent").length > 0)) {
						$("#menuContent").fadeOut("fast");
						$("body").unbind("mousedown", function(event){
							if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(
									event.target).parents("#menuContent").length > 0)) {
								hideMenu();
							}
						});
					}
				});
			});
		});
	</script>
</head>
<body>
<div class="content">
	<!-- 头部标题 -->
	<div class="content-title">
		单份问卷列表 --- <c:if test="${empty pojo.qustid}">创建问卷</c:if><c:if test="${not empty pojo.qustid}"><c:if test="${not empty view}">查看</c:if><c:if test="${empty view}">修改</c:if></c:if>
	</div>
	<!--end: 头部标题 -->

	<!-- tab导航 -->
	<div class="tab">
		<ul>
			<li class="tab1" ng-class="{true: 'active'}[activeTab == 1]" data-page="tab1-page" ng-click="changeTab(1)">1 设置基本数据</li>
			<li class="tab2" ng-class="{true: 'active'}[activeTab == 2]" data-page="tab2-page" ng-click="changeTab(2)">2 设置问卷内容</li>
			<li class="tab3" ng-class="{true: 'active'}[activeTab == 3]" data-page="tab3-page" ng-click="changeTab(3)">3 设置答题逻辑</li>
			<li class="tab4" ng-class="{true: 'active'}[activeTab == 4]" data-page="tab4-page" ng-click="changeTab(4)">4 计分、判断与结论</li>
		</ul>
	</div>
	<!--end: tab导航 -->
	<!-- tab内容区域 -->
	<div class="tab-content">
		<!-- tab1-page -->
		<div id="tab1-page" ng-show="activeTab == 1" class="tab-page">
		<form name="form_1" novalidate  ng-disabled="operate=='view'">
			<input type="hidden" ng-model="Question.model.questionnaire.qustid"/>
			<div class="page-title">
			</div>
			<div class="page-wrapper">
				<%-- 管理员 --%>
				<c:if test="${userInfo.roleid == 6}">
				<%-- 选择组织 start --%>
				<div id="menuContent" class="menuContent" style="display:none; position: absolute;background-color: #fff; z-index: 1; border:1px solid #ccc; border-top: 0;">
					<ul id="treeDemo" class="pop-ztree ztree" style="padding: 4px;"></ul>
				</div>
				<%-- 选择组织 end --%>
				<div class="row">
					<span class="form-label">应用范围：</span>
					<select class="form-control" name="useRange" ng-model="Question.model.questionnaire.useRange" ng-disabled="operate !='create'" ng-options="ur.code as ur.name for ur in useRanges" >
					</select>
				</div>
				<div id="orgName-input" class="row" ng-show="Question.model.questionnaire.useRange=='2'">
					<span class="form-label">组织名称：</span>
					<input type="hidden" ng-model="Question.model.questionnaire.orgId" readonly="readonly" />
					<div class="position-r">
						<input class="form-control" id="orgs" type="text" name="orgName" ng-model="Question.model.questionnaire.orgName" ng-disabled="operate !='create'" readonly="readonly" />
						<i class="org-search" id="orgs_search"></i>
					</div>
					<span ng-show="firstValid">
						<span ng-cloak class="error" ng-show="required.org && !Question.model.questionnaire.orgId">必填</span>
					</span>
				</div>
				</c:if>
				<div class="row">
					<label>
						<span class="form-label">问卷类别：</span>
						<select class="form-control" name="optId" ng-model="Question.model.questionnaire.optId" ng-options="oopt.optId as oopt.optName for oopt in ooptList" required>
						</select>
						<span ng-show="firstValid">
							<span ng-cloak class="error" ng-show="form_1.optId.$error.required">必填</span>
						</span>
					</label>
				</div>
				<div class="row">
					<span class="form-label">问卷名称：</span>
					<select class="form-control" ng-model="Question.model.questionnaire.qustNameType" ng-disabled="operate !='create'" ng-show="!event.isDoctor()">
			          	<option value="固定名称">固定名称</option>
			          	<option value="自定义名称">自定义名称</option>
			        </select>
			        <select class="form-control" ng-model="Question.model.questionnaire.qustname" ng-disabled="operate !='create'" ng-show="!event.isDoctor() && Question.model.questionnaire.qustNameType == '固定名称'" ensure-unique="{{Question.model.questionnaire.qustname}}"  ng-readonly="operate !='create'" nochar>
	                	<c:forEach items="${fixedNames}" var="fn">
	                		<option value="${fn.key}" ansMode="${fn.value}">${fn.key}</option>
	                	</c:forEach>
	              	</select>
					<input id="qustNameType-input" type="text" ng-show="Question.model.questionnaire.qustNameType == '自定义名称'" class="form-control" name="qustname" required ng-model="Question.model.questionnaire.qustname" ensure-unique="{{Question.model.questionnaire.qustname}}"  ng-disabled="operate !='create'" nochar />
					<span ng-cloak class="error"  ng-show="form_1.qustname.$error.required && firstValid">必填</span>
					<span ng-cloak class="error" ng-show="form_1.qustname.$error.unique">名称已存在</span>
				</div>
				<div class="row">
					<label><span class="form-label">评测方式：</span></label>
					<label class="radio-inlines form-control-radio"><input id="mr-top0" class="no-border" type="radio" ng-disabled="ansMode_disabled" ng-model="Question.model.questionnaire.ansMode" value="1"><span>自评</span></label>
					<label class="radio-inlines form-control-radio"><input id="mr-top0" class="no-border" type="radio" ng-disabled="ansMode_disabled" ng-model="Question.model.questionnaire.ansMode" value="2"><span>测评</span></label>
				</div>
				<div class="row">
					<label>
						<span class="form-label">问卷说明：</span>
						<textarea name="desription" id="Questionnaireexplain" ng-model="Question.model.questionnaire.desription" ng-maxlength=100 cols="70" rows="10" nochar></textarea>
						<span ng-cloak class="error" ng-show="form_1.desription.$error.maxlength">长度不能大于100</span>
					</label>
				</div>
			</div>
		</form>
		</div>
		<!--end: tab1-page -->

		<!-- tab2-page -->
		<div id="tab2-page" ng-cloak ng-show="activeTab == 2" class="tab-page">
		<form id="form2" name="form_2" action="" novalidate>
			<div class="page-title">
				<label>问卷名称：{{Question.model.questionnaire.qustname}}</label>
				<input type="button" class="btn btn-add-question f-right" value="新增问题" ng-click="Question.addQuestion();">
			</div>
			<div class="page-wrapper">
			   <!-- question box-->
				<div  class="row clearfix question-box" ng-repeat="mfq1 in Question.model.questionnaire.mfq1s" >
				<ng-form name ="namesForm_{{$index}}">
					<div class="question-left">
						<div class="question-number">
							<span>题号：<span> {{$index + 1}} </span></span>
						</div>
						<div class="question-body">
							<label>
							<span class="form-label" >问题：</span>
							<input type="text" class="form-control-question" ng-model="mfq1.proDesc"  name="input_question"  myunique nochar required>
							<span class="error" ng-show="namesForm_{{$index}}.input_question.$error.required">*必填</span>
							<span class="error" ng-show="!namesForm_{{$index}}.input_question.$error.required && namesForm_{{$index}}.input_question.$error.myunique">问题已存在</span>
							</label>
							<p>
								<span class="form-label">题型：</span>
								<label class="radio-inlines form-control-radio">
									<input class="answer-radio" value="1" ng-model="mfq1.ansType" type="radio" ng-change="Question.changeType($index)">
									<span>单选</span>
								</label>
								<label class="radio-inlines form-control-radio">
									<input class="answer-radio" value="2" ng-model="mfq1.ansType" type="radio" ng-change="Question.changeType($index)">
									<span>多选</span>
								</label>
							</p>
							<div class="answer-list">
								 <ol type="A">  
									<li ng-repeat="mfq11s in mfq1.mfq11s">
										<input type="radio" ng-show="mfq1.ansType == 1"  class="question-check-box" disabled>
										<input type="checkbox" ng-show="mfq1.ansType == 2" class="question-check-box" disabled >
										<input type="text" class="txt-question" ng-model="mfq11s.description" name="input_{{$parent.$index}}_description_{{$index}}" required nochar>
										<span class="error" ng-show="namesForm_{{$parent.$index}}.input_{{$parent.$index}}_description_{{$index}}.$error.required">*必填</span>
										<label>
											<span class="form-label-sm-1">分值</span>
											<input type="number" class="txt-score" ng-model="mfq11s.score" min='0' max = '100' name="input_{{$parent.$index}}_score_{{$index}}" ng-pattern="/^(0|[1-9][0-9]?|100)$/" required>
											<span class="error" ng-show="namesForm_{{$parent.$index}}.input_{{$parent.$index}}_score_{{$index}}.$invalid">分值在 0 ~ 100</span>
										</label>
										<input type="button" class="btn btn-delete-answer" ng-show="(mfq1.ansType == 1 && $index >1 && $index == mfq1.mfq11s.length -1) || (mfq1.ansType== 2 && $index >2 && $index == mfq1.mfq11s.length -1)" value="删除选项"  ng-click="Question.removeAnswer($parent.$index);">
									</li> 									
									<input type="button" class="btn btn-add-answer" value="新增选项"  ng-click="Question.addAnswer($index)" />
								</ol>
							</div>
						</div>
					</div>
					<div class="question-right">
						<input type="button" class="btn btn-delete-question" value="删除问题" ng-click="Question.removeQuestion($index)">
					</div>
					</ng-form>
				</div>
				<!--end: question box-->
			</div>
		</form>
		</div>
		<!--end: tab2-page -->

		<!-- tab3-page -->
		<div id="tab3-page" ng-cloak ng-show="activeTab == 3" class="tab-page">
		<form id="form3" action="" >
			<div class="page-title">
				<label>问卷名称：{{Question.model.questionnaire.qustname}}</label>
			</div>
			<div class="page-wrapper">
				<div id="" class="row clearfix question-box my-crazy-animation" ng-repeat="mfq1 in Question.model.questionnaire.mfq1s">
					<div class="question-left">
						<div class="question-number">
							<span>题号：<span> {{$index + 1}} </span></span>
						</div>
						<div class="question-body">
							<span class="form-label" >问题：</span><label>{{mfq1.proDesc}}</label>
							<p>
								<span class="form-label">题型：</span>
								<label class="radio-inlines form-control-radio">
									<input class="answer-radio" value="1" type="radio" ng-model="mfq1.ansType" disabled>
									<span>单选</span>
								</label>
								<label class="radio-inlines form-control-radio">
									<input class="answer-radio" value="2"  type="radio" ng-model="mfq1.ansType" disabled>
									<span>多选</span>
								</label>
							</p>
							<div class="answer-list">
								 <ol type="A">  
									<li ng-repeat="mfq11s in mfq1.mfq11s">
										<input type="radio" ng-show="mfq1.ansType == 1"  class="question-check-box" disabled>
										<input type="checkbox" ng-show="mfq1.ansType == 2" class="question-check-box" disabled >
										<span class="txt-question">{{mfq11s.description}}</span>
										<label>
											<span class="form-label-sm-1">分值</span>
											<span class="txt-score">{{mfq11s.score || 0}}</span>
										</label>
									</li>
								</ol>
							</div>
						</div>
					</div>
					<div class="question-right">
						<input type="button" class="btn btn-setting" ng-disabled="$index == Question.model.questionnaire.mfq1s.length -1" value="逻辑设置" ng-click="Question.openLogic(mfq1);">
						<input type="button" class="btn btn-up" value="" ng-click="Question.upQuestion($index)">
						<input type="button" class="btn btn-down" value="" ng-click="Question.downQuestion($index)">
					</div>
				</div>
			</div>
		</form>
		</div>
		<!--end: tab3-page -->

		<!-- tab4-page -->
		<div id="tab4-page" ng-cloak ng-show="activeTab == 4" class="tab-page">
		<form id="form4"  name="form_4" action="post" novalidate>
			<div class="page-title">
				<label>问卷名称：{{Question.model.questionnaire.qustname}}</label>
			</div>
			<div class="page-wrapper">
				<!-- top-wrapper -->
				<div id="function-sum" class="top-wrapper">
					<p class="page-title">总分计算方法<span class="error" ng-show="form_4.countmethod.$error.required">(*必填)</span></p>
					<div id="f1" class="row mg-left">
						<label class="radio-inlines form-control-radio left-wrapper" style="width:10% !important;"><input type="radio" ng-model="Question.model.questionnaire.mfq2.countmethod" data-pid="f1" value=1 name="countmethod" ng-change="event.changeMethod(1)" required><span>选择某些问题求和</span></label>
						<div class="right-wrapper">
							<label class="checkbox-inlines form-control-checkbox">
								<input type="checkbox" class="ck-all" data-pid="f1" ng-disabled="Question.model.questionnaire.mfq2.countmethod != 1" ng-model="chkAll[0]" ng-click="event.chkAll(chkAll[0], 0)">
								<span>全选</span>
							</label>
							<label class="checkbox-inlines form-control-checkbox" ng-repeat="chk in chkArr[0]">
								<input type="checkbox" ng-disabled="Question.model.questionnaire.mfq2.countmethod != 1" ng-model="chk.checked">
								<span>问题 {{$index + 1}}</span>
							</label>
						</div>
					</div>
					<div id="f2" class="row mg-left clearfix hide">
						<label class="radio-inlines form-control-radio left-wrapper"><input type="radio" ng-model="Question.model.questionnaire.mfq2.countmethod" data-pid="f2" value=2  name="countmethod" ng-change="event.changeMethod(2)" required><span>选择某些问题求平均</span></label>
						<div class="right-wrapper">
							<label class="form-control-checkbox"><input type="checkbox" class="ck-all" data-pid="f2" ng-disabled="Question.model.questionnaire.mfq2.countmethod != 2" ng-model="chkAll[1]" ng-click="event.chkAll(chkAll[1], 1)">全选</label>
							<label class="form-control-checkbox" ng-repeat="chk in chkArr[1]">
								<input type="checkbox" ng-disabled="Question.model.questionnaire.mfq2.countmethod != 2" ng-model="chk.checked">
								问题 {{$index + 1}}
							</label>
						</div>
					</div>
					<div id="f3" class="row mg-left clearfix hide">
						<label class="radio-inlines form-control-radio left-wrapper"><input type="radio" ng-model="Question.model.questionnaire.mfq2.countmethod" data-pid="f3" value=3 name="countmethod" ng-change="event.changeMethod(3)" required><span>选择某些问题取最大值</span></label>
						<div class="right-wrapper">
							<label class="form-control-checkbox"><input type="checkbox" class="ck-all" data-pid="f3" ng-disabled="Question.model.questionnaire.mfq2.countmethod != 3" ng-model="chkAll[2]" ng-click="event.chkAll(chkAll[2], 2)">全选</label>
							<label class="form-control-checkbox" ng-repeat="chk in chkArr[2]">
								<input type="checkbox" ng-disabled="Question.model.questionnaire.mfq2.countmethod != 3" ng-model="chk.checked">
								问题 {{$index + 1}}
							</label>
						</div>
					</div>
					<hr/>
				</div>
				<!--end: top-wrapper -->
				
				<!-- result-wrapper -->
				<div class="result-wrapper">
					<p class="page-title">答卷结果判定条件与结论内容</p>
					<div class="row">
						<table id="tb-result">
							<thead>
								<tr>
									<th>判定条件</th>
									<th>结论内容</th>
								</tr>
							</thead>
							<tbody>
								<tr ng-repeat="mfq21 in Question.model.questionnaire.mfq21s">
									<td>
										<input type="number" class="txt-score" ng-if="$index != 0"  ng-model="mfq21.minScore" min="0" max="100" step="" data-index={{$index}} ng-pattern="/^(?:0|[1-9][0-9]?|100)$/" checkresult name="score1_{{$index}}" required/>
										<span class="txt-score" ng-model="mfq21.minScore" ng-show ="$index == 0">{{mfq21.minScore}}</span>
										<span class="error" ng-show="form_4.score1_{{$index}}.$invalid">*分值在 0 ~ 100*</span>
										 分  —— 
										 <input type="number" class="txt-score" ng-show="$index != Question.model.questionnaire.mfq2s.length - 1"  ng-model="mfq21.maxScore" min="0" max="100" ng-pattern="/^(?:0|[1-9][0-9]?|100)$/" name="score2_{{$index}}" required ng-change="Question.changeMaxScore(Question.model.questionnaire.mfq21s,$index);"/>
										 <span class="txt-score" ng-show ="$index == Question.model.questionnaire.mfq2s.length - 1">{{mfq21.maxScore}}</span>
										 <span class="error" ng-show="form_4.score2_{{$index}}.$invalid">*分值在 0 ~ 100*</span>
										  分:
										 
									</td>
									<td>
										<input type="text" class="txt-result-content" ng-model="mfq21.conclusion" name="conclusion_{{$index}}" required nochar/><span class="error" ng-show="form_4.conclusion_{{$index}}.$error.required">*必填</span>
									</td>
									<td>
										<input type="button" class="btn btn-delete-result" ng-show="$index == Question.model.questionnaire.mfq21s.length - 1" value="删除" ng-click="Question.removeResult($index)">
									</td>
								</tr>
							</tbody>
						</table>
						<input type="button" class="btn btn-add-result" value="新增"   ng-click="Question.addResult();">
					</div>
				</div>
				<!--end: result-wrapper -->
			</div>
		</form>
		</div>
		<!--end: tab4-page -->
	</div>
	<!--end: tab内容区域 -->
	<c:if test="${!view}">
	<div class="page-box">
		<input type="button" class="btn-inquiry font-change" id="save" ng-click="event.saveOrUpdateOmfq()" value="保存"/>
		<input type="button" class="btn-inquiry font-change" value="取消" onclick="history.go(-1)"/>
		<input type="button" ng-show="activeTab == 4 && Question.model.questionnaire.qustTag == 'D'" class="btn-inquiry font-change" value="发布" ng-click="event.saveOrUpdateOmfq(false, 'T')"/>
		<div class="f-right">
			<input type="button" ng-hide="activeTab == 1" class="btn-step" value="上一步" ng-click="changeTab(activeTab - 1, true)"/>
			<input type="button" ng-hide="activeTab == 4" class="btn-step" value="下一步" ng-click="changeTab(activeTab + 1, true)"/>
		</div>
	</div>
	</c:if>
</div>

	<!-- 模板内容 -->
	<script type="text/ng-template" id="templateAddQuestion">
	<h3 class="pop-title">新增问题</h3>
	<div class="popup1">
 		<span class="form-label">题型：</span>
 		<label class="form-control-radio">
   		<input class="answer-radio" value="1" ng-model="type" type="radio" name="question-type"/>单选
 		</label>
 		<label class="form-control-radio">
   		<input class="answer-radio" value="2" ng-model="type" type="radio" name="question-type"/>多选
 		</label>
		<div class="btn-list">
			<button type="button" class="btn btn-green" ng-click="Question.model.addQuestion(type);closeThisDialog();" autofocus="autofocus">确定</button>
			<button type="button" class="btn btn-cancel" ng-click="closeThisDialog()">取消</button>
		</div>
	</div>
	</script>
	
	<script type="text/ng-template" id="templateSetLogic">
    <h3 class="pop-title">逻辑设置</h3>
    <div class="logic-set">
        <div class="logic" ng-repeat="logic in question.logicses">
            <label class="form-label">若选择选项</label>
            <select ng-init class="form-control-select" ng-model="logic.answerId"  ng-options="answer.ansid as AtoZ[answer.ansid-1] for answer in question.mfq11s | myfilter2: question.logicses :logic.answerId">
            	<option value="">--请选择--</option>
			</select>
            <label class="form-label">则不作答</label>
			
            <ul class="logic-question-wrapper">
                <li ng-repeat="logicQuestion in logic.problemIds track by $index">
					
                    <select class="form-control-select" ng-model="logic.problemIds[$index]"  ng-options="q.problemid as '第' + (q.problemid) + '题' for q in Question.model.questionnaire.mfq1s   | myfilter1:question.problemid:logic.problemIds:logicQuestion ">
						<option value="">--请选择--</option>
                    </select>
                    <input type="button" class="btn btn-add-logic-question" value=" " ng-show="$index == logic.problemIds.length-1  && ($index < Question.model.questionnaire.mfq1s.length -1-question.problemid)" ng-click="Question.addLogicQuestion(logic.problemIds);">
                    <input type="button" class="btn btn-delete-logic-question" value=" " ng-show="$index == logic.problemIds.length-1 && $index != 0" ng-click="Question.removeLogicQuestion(logic.problemIds, $index);">
                </li>
            </ul>
			
            <div>
                <input type="button" class="btn btn-add-logic" value=" " ng-hide="$index != question.logicses.length -1 || $index >=question.mfq11s.length -1" ng-click="Question.addLogic(question.logicses, question.problemid);">
                <input type="button" class="btn btn-delete1" value=" " ng-hide="$index != question.logicses.length -1 " ng-click="Question.removeLogic(question.logicses, $index);">
            </div>
        </div>
        <input type="button" class="btn btn-add-logic" value=" " ng-show="question.logicses.length == 0" ng-click="Question.addLogic(question.logicses, question.problemid);">
        <div class="btn-list">
            <button type="button" class="btn btn-green" ng-click="Question.model.updateLogic(question.logicses) && closeThisDialog();">确定</button>
            <button type="button" class="btn btn-cancel" ng-click="closeThisDialog()">取消</button>
        </div>
    </div>
	</script>
</body>
</html>