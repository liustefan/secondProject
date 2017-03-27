<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en" ng-app="createManageMode">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>编辑管理方案模板</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.validate.min.js"></script>
    <script type="text/javascript" src="<%=path %>/js/kindeditor/kindeditor.js"></script>
    <script type="text/javascript" src="<%=path %>/js/kindeditor/lang/zh_CN.js"></script>
   	<script type="text/javascript" src="<%=path %>/js/angular.min.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<style type="text/css">
		.content {
			min-width: 1000px;
		}
		
		.detail-box {
			margin: 20px 0;
		    padding-left: 18px;
		    border: 1px solid #ccc;
		    font-size: 14px;
		    line-height: 28px;
		    background-color: #eff1f0;
		}
		
		.mg-right {
			margin-right: 50px;
		}
		
		.tab {
			text-align: center;
			margin-top: 10px;
			position: relative;
		}
		
		.tab>ul {
			width: 445px;
			margin: 0 auto;
			list-style: none;
			height: 35px;
			position: relative;
			top: 0;
			left: 0;
			background-color: #fff;
		}
		
		.tab>ul>li {
			width: 225px;
			height: 35px;
			line-height: 35px;
			position: absolute;
		}
		
		.tab>ul>li {
			cursor: pointer;
			color: #5F5F5F;
		}
		
		.tab>ul>li.active {
			cursor: default;
			color: #fff;
		}
		
		.tab>ul>li.tab1 {
			left: 0;
			background-image: url("<%=path %>/img/tab-first-bg_.png");
		}
		
		.tab>ul>li.tab1.active {
			background-image: url("<%=path %>/img/tab-first-bg.png");
		}
		
		.tab>ul>li.tab2 {
			left: 220px;
			background-image: url("<%=path %>/img/tab-last-bg_.png");
		}
		
		.tab>ul>li.tab2.active {
			background-image: url("<%=path %>/img/tab-last-bg.png");
		}
		
		.main-content {
			margin-top: 10px;
			border: 1px solid #98cc6b;
			padding: 15px; 
			font-size: 14px;
		}
		
		.table-normal td {
			padding: 6px 5px; 
		}
		
		.table-normal tr td:first-of-type {
			text-align: right;
		}
		
		.fix-place {
			position: absolute;
			top: 0;
			right: 10px;
		}
		
		.content-head {
			height: 40px;
			line-height: 40px;
		}
		
		.text-top {
    		vertical-align: text-top;
		}
		
		.width-lg {
			width: 550px;
		}
		
		.width-disease {
			width: 350px;
		}
		
		.width-number {
			width: 45px;
			padding: 2px;
		}
		
		.width-price {
			width: 105px;
		}
		
		.margin-left {
			margin-left: 20px;
		}
		
		.ke-container {
			width: 793px !important;
		}
		
		.ke-edit {
			height: 200px !important;
		}
		
		.position-r {
			position: relative;
			display: inline-block;
		}
		
		.member-search {
		    position: absolute;
		    right: 5px;
		    top: 2px;
		    width: 20px;
		    height: 20px;
		    display: inline-block;
		    background: url(<%=path %>/img/u125.png) no-repeat center;
		    cursor: pointer;
		}
		
		.hidden {
			width: 0;
			padding: 0 !important;
			margin: 0 !important;
			border: 0;
		}
		
		body .skin1 .layui-layer-btn1 {
		    height: 28px;
		    margin: 0 5px;
		    padding: 0 15px;
		    font: normal 14px "Microsoft YaHei",Arial,"宋体",Helvetica,Verdana,Sans-serif;
		    color: #000;
		    display: inline-block;
		    line-height: 28px;
		    text-decoration: none;
		    border: 1px solid #6AD279;
		    border-radius: 3px;
		    -moz-border-radius: 3px;
		    -webkit-border-radius: 3px;
		    background-color: #DAF6D7 !important;
		    cursor: pointer;
		    outline: none;
		}
		
		body .skin1 .layui-layer-btn1:hover {
		    color: #fff !important;
		    font-weight: bold;
		    background-color: #64C25A !important;
		}
		
		body .skin1 .layui-layer-btn0 {
		    border: 1px solid #A9A9A9;
		    background-color: #F1F1F1 !important;
		}
		
		body .skin1 .layui-layer-btn0:hover {
		    color: #000 !important;
		    font-weight: normal !important;
		    background-color: #F1F1F1 !important;
		}
		
		label.error {
			display: inline !important;
		}
	</style>
	<script>
		var vForm;
		var vForm3;
		var tasks = ${tasks}; 
		var executeWay = ${executeWay}, planTimeType = ${planTimeType}, taskType = ${taskType};
		function getScope(){
			return angular.element(document.querySelector('[ng-controller=ManageModeCtrl]')).scope();
		}
		function callback(status, id, fileName, filePath){
			$("#save").prop('disabled',false);
			if(status){
				angular.element("input[name='MSTempletID']").val(id);
	        	if(fileName && filePath){
	        		angular.element("#attachment").html(fileName);		
	        		angular.element("#attachment").attr("onclick","_showTopAttach('"+filePath+"','"+fileName+"')");
	        		
	        		//angular.element("#attachment").attr("href", filePath+"&alias="+fileName);
	        		angular.element('input[name="file"]').val('');
	        	}
	        	var scope = getScope();
	        	if(scope.active.willNext){
	        		scope.active = {activeTab: 2, willNext: false};
	        	}else{
	        		alert("保存成功");
	        	}
	        	scope.event.checkHasAttached();
	        	scope.$apply(scope.active);
			}else{
				alert("当前资料保存失败，请稍后重试！");
			}
		}
		function addQustCallback(qustId, qustName, ansMode){
			var scope = getScope();
			scope.event.addTaskRef({id: qustId, name: qustName, ansMode: ansMode});
			scope.$apply();
			layer.closeAll();
		}
		function setHed(id, title){
			var scope = getScope();
			scope.event.addTaskRef({id: id, name: title});
			scope.$apply();
			layer.closeAll();
		}
		function fileChange($this){
			var suffix = {'xls': true, 'xlsx': true,'xlt': true, 'doc': true, 'docx': true, 'txt': true, 'jpg': true, 'pdf': true};
			var flag = suffix[($this.value.substring($this.value.lastIndexOf('.') + 1)).toLowerCase()];
			if(!flag){
				alert("参考附件格式不正确，请重新选择！");
				$("input[type='file']").val('');
			}
		}
		KindEditor.ready(function(K) {
	        window.editor = K.create('textarea[name="content"]',{
	        	/* pasteType : 1, */ 
	        	afterCreate : function(){
	                 this.sync();
	             },
	             afterChange: function(){ //编辑器内容发生变化后，将编辑器的内容设置到原来的textarea控件里
	                 this.sync();
	                 $('.word_count1').html(this.count()); //字数统计包含HTML代码
	                 //$('.word_count2').html(this.count('text'));  //字数统计包含纯文本、IMG、EMBED，不包含换行符，IMG和EMBED算一个文字
	                 //////////
	                 //限制字数
	                 var limitNum = 20000;  //设定限制字数
	                 var pattern = '还可以输入' + limitNum + '字符'; 
	                 $('.word_surplus').html(pattern); //输入显示
	                 if(this.count() > limitNum) {
	                  pattern = ('字数超过限制，请适当删除部分内容');
	                  $('.word_surplus').html(pattern);
	                  $('.word_surplus').addClass('red');
	                  } else {
	                  //计算剩余字数
	                  var result = limitNum - this.count(); 
	                  pattern = '还可以输入' +  result + '字符'; 
	                  $('.word_surplus').html(pattern); //输入显示
	                  $('.word_surplus').removeClass('red');
	                  }
	             },
	             afterBlur : function(){ //编辑器聚焦后，将编辑器的内容设置到原来的textarea控件里
	                 this.sync();
	             }
	        });
	    });
	

		var app = angular.module('createManageMode', [], function($httpProvider){
		});
		
		app.controller('ManageModeCtrl', function ($scope, $http) {
			$scope.active = {activeTab: 1,  willNext: false};
			$scope.dict = {};
			$scope.task = {};
		  	$scope.event = {
		  			init: function(){
		  				if(tasks)
							$scope.task = {list: tasks, add: {mSTempletID: angular.element("input[name='MSTempletID']").val()}};
		  				if(executeWay)$scope.dict.execWay = executeWay;
		  				if(planTimeType)$scope.dict.planTimeType = planTimeType;
		  				if(taskType)$scope.dict.taskType = taskType;
		  				this.checkHasAttached();
					},
					checkHasAttached: function(){
						if(angular.element("#attachment").html().length > 0)
		  					$scope.hasAttached = true;
					},
					// 切换Tab 然后保存数据
		  			changeTab: function(id, task, view){
		  				 if(id < $scope.active.activeTab) { // 上一步 不需要验证和保存
							  $scope.active.activeTab = id;
						  }else if(id > $scope.active.activeTab) { // 下一步 需要验证和保存
							  if(view == 'true'){
								  $scope.active.activeTab = id;
							  }else {
								  if(id === 2){
									  this.save(id);
								  	  $scope.active.willNext = true;
								  }else{
									  if(task){
										  $scope.task.original = task;
										  if($scope.task.add == undefined)
												$scope.task.add = {};
										  angular.copy(task, $scope.task.add);
									  }else{
										  $scope.task.original = {};
										  this.initAddTask();
									  }
									  $scope.active.activeTab = id;
								  }
							  }
						  }
		  			},
					save: function(next){
						if(next === 2){//点击下一步：保存基本资料成功之后进入下一步
							this.checkTitleUnique(function(){
								if(vForm.form()){
									$('form')[0].submit();
								}
							});
						}else{
							if($scope.active.activeTab === 1){//保存基本资料
								this.checkTitleUnique(function(){
									if(vForm.form()){
										$('form')[0].submit();
									}
								});
							}else{//保存单条任务
								if(vForm3.form()){
									$("#save").prop('disabled',true);
									if($scope.task.add.taskRef == null)
										delete $scope.task.add.taskRef;
									this.callRemote("saveTask", $scope.task.add, function(reponse){
										$("#save").prop('disabled',false);
										if(reponse.status){
											if(!$scope.task.add.mSTTaskID){//新增任务操作，需追加一条
												reponse.data.mSTTaskID = reponse.data.msttaskID;
												delete reponse.data.msttaskID;
												$scope.task.list.push(reponse.data);
											}else{
												angular.copy($scope.task.add, $scope.task.original);
											}
											$scope.active.activeTab = 2;
										}else{
											alert("当前资料保存失败，请稍后重试！");
										}
									});
								}
							}
						}
					},
					initAddTask: function(){
						$scope.task.add = {mSTempletID: angular.element("input[name='MSTempletID']").val(), taskType : 1, planTimeType : 1, execWay : 3};
					},
					callRemote: function(url, data, callback){
						$scope.onOff = false;
			            transFn = function(data) {
			                return $.param(data);
			            },
			            postCfg = {
			                headers: { 'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
			                transformRequest: transFn
			            };
			            $http.post(url, data, postCfg).success(function(reponse){
			            	if(typeof(reponse)==='object'){
			            		callback(reponse);
		                	}else{
		                	   parent.layer.alert("登录信息过期，请重新登录", {shade: 0,skin : 'skin1',end: function(index){
			                		   parent.layer.close(index);
			                		   window.top.location.href="..";
		                		   }}, function(index) {
			                		   parent.layer.close(index);
			                		   window.top.location.href="..";
		                	   });
		                	}
			            }).error(function(){
			            	alert("当前资料保存失败，请稍后重试！");
			            	$("#save").prop('disabled',false);
			            });
					},
					toEditTask: function(task){
						this.changeTab(3, task);
					},
					deleteAttached: function(){
						this.callRemote("deleteAttached", {id: angular.element("input[name='MSTempletID']").val()}, function(reponse){
							if(reponse.data){
								$scope.hasAttached = false;
								angular.element("#attachment").html("");
							}else{
								alert("删除失败！");
							}
						});
					},
				    deleteTask: function(id, index){
				    	this.callRemote("deleteTask", {id: id}, function(reponse){
				    		if(reponse.data){
				    			$scope.task.list.splice(index, 1)
							}else{
								alert("删除失败！");
							}
				    	});
				    },
				    checkTitleUnique: function(callback){
				    	this.callRemote("selectIsExist", {id: angular.element("input[name='MSTempletID']").val(), schemeTitle: angular.element('input[name="schemeTitle"]').val()}, function(reponse){
				    		if(reponse.status){
				    			if(reponse.content){
				    				layer.confirm("当前输入的模板名称与现有"+reponse.content+"模板中名称重复，请确认是否增加？", {
										skin : 'skin1',
								   	    shade: 0,
								   	 	btn: ['确定','取消']
									}, function(){
										layer.closeAll();
										callback();
									}, function(){
										$("input[name='schemeTitle']").val('');
										layer.closeAll();
									});
				    			}
							}else{
								callback();
							}
				    	});
				    },
				    checkTitleUnique2: function(){
				    	if($("input[name='schemeTitle']").val() != ''){
				    		this.callRemote("selectIsExist", {id: angular.element("input[name='MSTempletID']").val(), schemeTitle: angular.element('input[name="schemeTitle"]').val()}, function(reponse){
					    		if(reponse.status){
					    			if(reponse.content){
					    				layer.confirm("当前输入的模板名称与现有"+reponse.content+"模板中名称重复，请确认是否增加？", {
											skin : 'skin1',
									   	    shade: 0,
									   	 	btn: ['确定','取消']
										}, function(){
											layer.closeAll();
										}, function(){
											$("input[name='schemeTitle']").val('');
											layer.closeAll();
										});
					    			}
								}
					    	});
				    	}
				    },
				    cancleEditTask: function(){
						$("#planTimeValue-error").html('');
				    	$("#summary-error").html('');
				    	$("#healthMode-error").html('');
				    	$("#qustName-error").html('');
				    	$scope.active.activeTab = 2;
				    },
				    chooseQuestion: function(execWay){
				    	if(execWay){
				    		layer.closeAll();
							layer.open({
						   	    type: 2,
						   		skin : 'skin1',
						   	    title: '选择问卷',
						   	    shadeClose: false,
						   	    shade: 0,
						   	    area: ['700px', '450px'],
						   	 	content: '../../question/singleQuestion/chooseQust?ansMode='+(execWay == 3 ? 1 : ''), //iframe的url
						   	}); 
				    	}else{
				    		alert("请先选择执行方式！");
				    	}
				    },
				    addTaskRef: function(taskRef){
				    	$scope.task.add.taskRefID = taskRef.id;
				    	$scope.task.add.taskRef = taskRef;
				    	$scope.task.add.summary = taskRef.name;
				    }
		  	};
			$scope.$watch('task.add.execWay', function(newValue, oldValue) {
				if(oldValue != undefined && newValue == 3 && $scope.task.add.taskRef && $scope.task.add.taskRef.ansMode == 2){
					$scope.task.add.taskRefID = null;
			    	$scope.task.add.taskRef = {};
				}
			}, true);
			$scope.$watch('task.add.taskType', function(newValue, oldValue) {
				if(oldValue != undefined && newValue != oldValue){
					$scope.task.add.taskRefID = null;
			    	$scope.task.add.taskRef = {};
				}
			}, true);
		  	$scope.event.init();
		});
		
		app.filter('getName', function () {
		    return function(task, type, dict) {
		        if(type === 1){
		        	return dict.taskType[task.taskType-1].name;
		        }else if(type === 2){
		        	if(task.taskType == 7)
		        		return null;
		        	return dict.execWay[task.execWay-1].name;
		        }else{
		        	if(task.planTimeValue === 0 || task.planTimeValue == '0')
		        		return '当天';
		        	return task.planTimeValue+dict.planTimeType[task.planTimeType-1].name+'后';
		        }
		    };
		});
		
		var index = layer.getFrameIndex(window.name); //获取窗口索引
		
		function openHealthMode(){
			layer.closeAll();
			layer.open({
		   	    type: 2,
		   		skin : 'skin1',
		   	    title: '选择健教模板',
		   	    shadeClose: false,
		   	    shade: 0,
		   	    area: ['890px', '520px'],
		   	  content: '../managescheme/chooseHealthTemp', //iframe的url

		   	}); 
		}
		
		function chooseDisease(stadu){
			if(stadu != 'true'){
				layer.closeAll();
				layer.open({
			   	    type: 2,
			   		skin : 'skin1',
			   	    title: '选择疾病分类',
			   	    shadeClose: false,
			   	    shade: 0,
			   	    area: ['420px', '450px'],
			   	 	content: '<%=path%>/health/templet/chooseDisease.jsp', //iframe的url
			   	});
			}
		}
		
		function chooseDiseaseInfo(obj){
			$("input[name='diseaseClassify']").val(obj.diseaseName);
			$("input[name='MSDiseaseIDs']").val(obj.diseaseId);
		}
		
	 	function changeStadu(){
	 		if($("select[name='isCharge'] option:selected").val() == 0){
				$("#price").hide();
				$("input[name='price']").attr('prop', true);
				$("input[name='price']").val('');
				$("#price-error").html('');
			}else if($("select[name='isCharge'] option:selected").val() == 1){
				$("input[name='price']").attr('prop', false);
				$("#price").show();
			}
	 	}
	 	
	 	$(function(){
	 		$("#price").hide();
			if($("select[name='isCharge'] option:selected").val() == 0){
				$("#price").hide();
			}else if($("select[name='isCharge'] option:selected").val() == 1){
				$("#price").show();
			}
			
			jQuery.validator.addMethod("numberPrice", function(value, element) {
				return this.optional(element) || /^(?:[1-9]\d{0,7}|0)(?:\.\d{1,2})?$/.test(value);
				}, "请输入整数最多8位，小数最多2位的值!");
			
			jQuery.validator.addMethod("srvLimit", function(value, element) {
				return this.optional(element) || /^(?:[1-9]\d{0,1}|0)?$/.test(value);
				}, "请输入0-99的整数!");
			
			jQuery.validator.addMethod("planTimeValue", function(value, element) {
				return this.optional(element) || /^(?:[1-9]\d{0,2}|0)?$/.test(value);
				}, "请输入0-999的整数!");
			
			jQuery.validator.addMethod("isBlank", function(value, element) {
				return $.trim(value) != ''
				}, "必填!");
			
			// form_1表单验证
			vForm = $("#form_1").validate({
				rules : {
					'schemeTitle' : {
						isBlank: true
					},
					'srvLimitValue' : {
						srvLimit: true
					},
					'benchmarkTime' : {
						isBlank: true,
					},
					'price' : {
						numberPrice: true,
						isBlank: true,
					}
				},
				messages : {
					'schemeTitle' : {
						isBlank : "必填!",
					},
					'srvLimitValue' : {
						srvLimit: "请输入0-99的整数!",
					},
					'benchmarkTime' : {
						isBlank : "必填!",
					},
					'price' : {
						numberPrice : "请输入整数最多8位，小数最多2位的值!",
						isBlank : "必填!",
					}
				}
			});
			
			// form_3表单验证
			vForm3 = $("#form_3").validate({
				rules : {
					'planTimeValue' : {
						planTimeValue: true,
						isBlank: true
					},
					'taskType' : {
						isBlank: true,
					},
					'execWay' : {
						isBlank: true,
					},
					'summary' : {
						isBlank: true,
					},
					'healthMode' : {
						isBlank: true,
					},
					'qustName' : {
						isBlank: true,
					}
				},
				messages : {
					'planTimeValue' : {
						planTimeValue: "请输入0-999的整数!",
						isBlank: "必填!"
					},
					'taskType' : {
						isBlank: "必填!",
					},
					'execWay' : {
						isBlank: "必填!",
					},
					'summary' : {
						isBlank: "必填!",
					},
					'healthMode' : {
						isBlank: "必填!",
					},
					'qustName' : {
						isBlank: "必填!",
					}
				}
			});
	 	})
	 	
	 	$(function(){
			if('${param.view}' == 'true'){
				$("#form_1 input, #form_1 select, #form_1 textarea").prop("disabled",true);
			}
		})
		
		
	 function _showTopAttach(url,alias){  
	 		window.open(url+"&alias="+encodeURI(alias) , "_blank"); 
           }  
	 	
	</script>
</head>
<body ng-controller="ManageModeCtrl">
	<div class="content">
		<div class="content-title">管理方案模板 --- <c:if test="${empty pojo.MSTempletID}">新增</c:if><c:if test="${not empty pojo.MSTempletID and !param.view}">修改</c:if><c:if test="${not empty pojo.MSTempletID and param.view}">查看</c:if></div>
		<div class="tab">
			<ul>
				<li class="tab1" ng-class="{true: 'active'}[active.activeTab == 1]" data-page="tab1-page" ng-click="event.changeTab(1)">1 方案基本资料</li>
				<li class="tab2" ng-class="{true: 'active'}[active.activeTab == 2]" data-page="tab2-page" ng-click="event.changeTab(2, null, '${not empty pojo.MSTempletID and param.view}')">2 方案执行任务</li>
				<li class="tab2 active" ng-show="active.activeTab == 3">2 方案执行任务</li>
			</ul>
		</div>
		<div class="main-content">
			<!-- tab1-page -->
			<div id="tab1-page" ng-show="active.activeTab == 1">
				<form id="form_1" name="form_1" action="save" novalidate ng-disabled="operate=='view'" target="upload" method="post" enctype="multipart/form-data">
					<input type="hidden" name="MSTempletID" value="${pojo.MSTempletID}">
					<table border="0" cellspacing="0" class="table-normal table-fixed">
			    		<tbody>
				    		<tr>
				    			<td colspan="1"><span class="red">*</span>方案标题：</td>
				    			<td colspan="6">
				    				<input type="text" class="width-lg" name="schemeTitle" value="${pojo.schemeTitle}" maxlength="20" <c:if test="${pojo.templetStatus eq 2}">readonly="readonly"</c:if> ng-blur="event.checkTitleUnique2()">
			    				</td>
				    		</tr>
				    		<tr>
				    			<td colspan="1">适用疾病分类：</td>
				    			<td colspan="6">
					    			<div class="position-r">
					    				<input type="hidden" name="MSDiseaseIDs" value='<c:forEach items="${pojo.diseases}" var="ds" varStatus="vs">${ds.MSDiseaseID}<c:if test="${fn:length(pojo.diseases) > vs.index+1}">,</c:if></c:forEach>'>
						                <input type="text" class="width-disease" readonly name="diseaseClassify" value='<c:forEach items="${pojo.diseases}" var="ds">${ds.diseaseName}；</c:forEach>'>
						                <i class="member-search" onclick="chooseDisease('${param.view}');"></i>
				                 	</div>
			                 	</td>
				    		</tr>
				    		<tr>
				    			<td colspan="1" class="text-top" >总体管理目标：</td>
				    			<td colspan="6"><textarea rows="9" cols="110" name="manageGoal" maxlength="500">${pojo.manageGoal}</textarea></td>
				    		</tr>
				    		<tr>
				    			<td colspan="1">服务期限：</td>
				    			<td colspan="6">
				    				<input type="text" class="width-number" name="srvLimitValue" value="${pojo.srvLimitValue}" maxlength="2">
				    				<select name="srvLimitType">
				    					<option value="1" <c:if test="${pojo.srvLimitType eq 1}">selected="selected"</c:if>>天</option>
				    					<option value="2" <c:if test="${pojo.srvLimitType eq 2}">selected="selected"</c:if>>周</option>
				    					<option value="3" <c:if test="${pojo.srvLimitType eq 3}">selected="selected"</c:if>>月</option>
				    					<option value="4" <c:if test="${pojo.srvLimitType eq 4}">selected="selected"</c:if>>年</option>
				    				</select>
				    				<label id="srvLimitValue-error" class="error" for="srvLimitValue"></label>
			    					<span class="red margin-left">*</span>基准时间：
			    					<select name="benchmarkTime">
				    					<option value="1" <c:if test="${pojo.benchmarkTime eq 1}">selected="selected"</c:if>>方案触发时间</option>
				    				</select>
			    					<span class="margin-left">是否收费：</span>
			    					<select name="isCharge" onchange="changeStadu()">
				    					<option value="0" <c:if test="${pojo.isCharge eq 0}">selected="selected"</c:if>>免费</option>
				    					<option value="1" <c:if test="${pojo.isCharge eq 1}">selected="selected"</c:if>>收费</option>
				    				</select>
				    				<span id="price">
				    					<span class="margin-left"><span class="red">*</span>价格：</span>
					    				<input type="text" class="width-price" name="price" value="${pojo.price}">
					    				<span>元</span>
					    				<label id="price-error" class="error" for="price"></label>
				    				</span>
			    				</td>
				    		</tr>
				    		<tr>
				    			<td colspan="1" class="text-top">参考附件：</td>
				    			<td colspan="6">
				    				<input type="file" name="file" onchange="fileChange(this)">
				    				<br>
				    				
				    			  <a href="javascript:void(0);" onclick="_showTopAttach('${pojo.filePath}','${pojo.fileName}')" 
				    				  id="attachment" >${pojo.fileName} 
				    				 </a>
				    				<c:if test="${!param.view and not empty pojo.filePath}">
				    					<img alt="删除" src="<%=path %>/img/u478.png" title="删除" ng-click="event.deleteAttached()" ng-show="hasAttached" style="cursor: pointer;">
			    					</c:if>
				    				<%-- <c:if test="${param.view}">
				    					<img alt="删除" src="<%=path %>/img/u478.png" title="删除" ng-show="hasAttached" style="cursor: default;">
			    					</c:if> --%>
								</td>
				    		</tr>
				    		<tr>
				    			<td colspan="1" class="text-top">方案介绍：</td>
				    			<td colspan="6"><textarea rows="9" cols="110" name="introduction" maxlength="500">${pojo.introduction}</textarea></td>
				    		</tr>
			    		</tbody>
		    		</table>
				</form>
				<iframe name="upload" style="display:none"></iframe>
			</div>
			
			<div id="tab2-page" ng-cloak ng-show="active.activeTab == 2">
				<form id="form2" name="form_2" action="" novalidate>
					<div class="clearfix content-head">
						<label>任务基准时间：</label><span>方案触发时间</span>
						<c:if test="${!param.view}">
							<button type="button" class="fr btn-inquiry ico-add" ng-click="event.changeTab(3)">新增</button>
						</c:if>
					</div>
					<div class="table-box">
			   			<table class="table-content">
			   		    	<thead class="table-title">
			   		    		<tr>
			   		    			<th width="10%">任务类型</th>
			   		    			<th width="10%">执行方式</th>
			   		    			<th width="10%">计划执行时间</th>
			   		    			<th width="55%">任务概述</th>
			   		    			<c:if test="${!param.view}">
			   		    				<th>操作</th>
		   		    				</c:if>
			   		    		</tr>
			   		    	</thead>
			   		    	<tbody>
			   		    		<tr ng-repeat="task in task.list">
			   		    			<td>{{task | getName:1:dict}}</td>
			   		    			<td>{{task | getName:2:dict}}</td>
			   		    			<td>{{task | getName:3:dict}}</td>
			   		    			<td>{{task.summary}}</td>
			   		    			<c:if test="${!param.view}">
				   		    			<td>
				   		    				<a href="javascript:void(0);" ng-click="event.toEditTask(task)">修改</a>
				   		    				<a href="javascript:void(0);" class="mar-left" ng-click="event.deleteTask(task.mSTTaskID, $index)" >删除</a>
				   		    			</td>
			   		    			</c:if>
			   		    		</tr>
			   		    	</tbody>
		   		    	</table>
	   		    	</div>
				</form>
			</div>
			<div id="tab3-page" ng-show="active.activeTab == 3">
				<div class="content-title">
					<span ng-hide="task.add.mSTTaskID">新增</span><span ng-show="task.add.mSTTaskID">修改</span>任务
				</div>
				<form name="form_3" id="form_3" novalidate>
					<table border="0" cellspacing="0" class="table-normal table-fixed">
			    		<tbody>
				    		<tr>
				    			<td colspan="1"><span class="red">*</span>任务计划时间：</td>
				    			<td colspan="6">
				    				方案触发时间后
				    				<input type="text" class="width-number" name="planTimeValue" ng-model="task.add.planTimeValue" maxlength="3">
				    				<select name="planTimeType" ng-model="task.add.planTimeType" ng-options="d.code as d.name for d in dict.planTimeType">
				    				</select>
				    				<label id="planTimeValue-error" class="error" for="planTimeValue" style="display: inline-block;"></label>
			    					<span class="red margin-left">*</span>任务类型：
			    					<select name="taskType" ng-disabled="task.add.mSTTaskID && ${!param.view}" ng-model="task.add.taskType" ng-options="d.code as d.name for d in dict.taskType">
					              	</select>
			    					<labe1 ng-hide="task.add.taskType == 7"><span class="red margin-left">*</span>执行方式：
			    					<select name="execWay" ng-model="task.add.execWay" ng-options="d.code as d.name for d in dict.execWay">
				                    </select>
				                    </labe1>
			    				</td>
				    		</tr>
				    		<tr ng-show="task.add.taskType == 1">
				    			<td colspan="1" class="text-top"><span class="red">*</span><span ng-show="task.add.taskType == 1">请选择健教：</span></td>
				    			<td colspan="6">
				    				<a href="javascript:void(0);" onclick="openHealthMode()">选择：</a>
				    				<input type="text" class="hidden" name="healthMode" value="{{task.add.taskRef.name}}">
				    				<span><a href="../checkHealth?id={{task.add.taskRef.id}}&view=true&close=true" target="_blank">{{task.add.taskRef.name}}<span ng-hide="task.add.taskRef.name">{{task.original.taskRef.name}}</span></a></span>
				    				<label ng-hide="task.add.taskRef.name" id="healthMode-error" class="error" for="healthMode"></label>
			    				</td>
				    		</tr>
				    		<tr ng-show="task.add.taskType == 4">
				    			<td colspan="1" class="text-top"><span class="red">*</span>请选择问卷：</td>
				    			<td colspan="6">
				    				<a href="javascript:void(0);" ng-click="event.chooseQuestion(task.add.execWay)">选择：</a>
				    				<input type="text" class="hidden" name="qustName" value="{{task.add.taskRef.name}}">
				    				<span><a href="../../question/questionInfo?qustId={{task.add.taskRef.id}}" target="_blank">{{task.add.taskRef.name}}<span ng-hide="task.add.taskRef.name">{{task.original.taskRef.name}}</span></a></span>
				    				<label ng-hide="task.add.taskRef.name" id="qustName-error" class="error" for="qustName"></label>
			    				</td>
				    		</tr>
				    		<tr>
				    			<td colspan="1" class="text-top"><span class="red">*</span>任务概述：</td>
				    			<td colspan="6">
				    				<textarea rows="8" cols="110" class="text-top" name="summary" ng-model="task.add.summary" maxlength="100" ></textarea>
				    				<p style="color: #a1a1a1;">消息类的任务概述内容会推送给会员</p>
				    				<label id="summary-error" class="error" for="summary" style="display: inline;"></label>
			    				</td>
				    		</tr>
<!-- 				    		<tr ng-show="task.add.taskType == 1"> -->
<!-- 			                    <td colspan="1" class="text-top">详情内容：</td> -->
<!-- 			                    <td colspan="6"> -->
<!-- 			                        <div class="new-temp-content"> -->
<!-- 		                             	<textarea name="content" ng-model="task.add.content"></textarea> -->
<!-- 		                             	<p> -->
<!-- 		                             		您当前输入了 <span class="word_count1">0</span> 个字符。<br> -->
<!-- 									   		<span class="word_surplus"></span>  -->
<!-- 									 	</p> -->
<!-- 			                        </div> -->
<!-- 			                    </td> -->
<!-- 			                </tr> -->
			                <tr ng-show="task.add.taskType == 2 || task.add.taskType == 3">
				    			<td colspan="1" class="text-top">任务说明：</td>
				    			<td colspan="6">
				    				<textarea rows="8" cols="110" ng-model="task.add.content"></textarea>
			    				</td>
				    		</tr>
			    		</tbody>
		    		</table>
				</form>
			</div>
		</div>
		<c:if test="${!param.view}">
			<div class="page-box" ng-class="{true: 'align-center'}[active.activeTab == 3]">
				<input type="button" ng-hide="active.activeTab == 2" class="btn-inquiry" id="save" ng-click="event.save()" value="保存"/>
				<input type="button" ng-hide="active.activeTab == 3" class="btn-cancel" ng-class="{true: 'fr'}[active.activeTab == 2]" value="返回" onclick="window.location.href='list'"/>
				<input type="button" ng-show="active.activeTab == 3" class="btn-cancel" value="取消" ng-click="event.cancleEditTask()"/>
				<input type="button" ng-show="active.activeTab == 2" class="btn-inquiry fl" value="上一步" ng-click="event.changeTab(active.activeTab - 1)"/>
				<input type="button" ng-show="active.activeTab == 1" class="btn-inquiry fr" value="下一步" ng-click="event.changeTab(active.activeTab + 1)"/>
			</div>
		</c:if>
		<c:if test="${not empty pojo.MSTempletID and param.view}">
			<div class="page-box align-center">
				<input type="button" ng-hide="active.activeTab == 3" class="btn-cancel" value="返回" onclick="window.location.href='list'"/>
			</div>
		</c:if>
	</div>
</body>
</html>