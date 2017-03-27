<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en" ng-app="createManageMode">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>编辑个人管理方案</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/js/jquery-ui/themes/overcast/jquery-ui.min.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.validate.min.js"></script>
    <script type="text/javascript" src="<%=path %>/js/kindeditor/kindeditor.js"></script>
    <script type="text/javascript" src="<%=path %>/js/kindeditor/lang/zh_CN.js"></script>
   	<script type="text/javascript" src="<%=path %>/js/angular.min.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-ui/jquery-ui.js"></script>
	<script type="text/javascript" src="<%=path %>/js/dataPacker.js"></script>
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
			margin-right: 30px;
		}
		
		.tab {
			text-align: center;
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
			top: 3px;
			right: 10px;
			outline: none;
		}
		
		.content-head {
			height: 40px;
			line-height: 40px;
		}
		
		.text-top {
    		vertical-align: text-top;
		}
		
		.width-print {
			width: 550px;
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
		
		.layer-box {
			margin: 35px 25px 35px 25px;
			font-size: 16px;
		}
		
	    .width-fl {
	    	width: 85%;
	    }
	    
	    .width-fr {
	    	text-align: center;
		    width: 15%;
		    line-height: 56px;
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
		var tab = '${tab}';
		var executeWay = ${executeWay}, planTimeType = ${planTimeType}, taskType = ${taskType};
		function getScope(){
			return angular.element(document.querySelector('[ng-controller=ManageModeCtrl]')).scope();
		}
		function callback(status, mId, eId, fileName, filePath, tasks){
			$("#save").prop('disabled',false);
			if(status){
// 				$("#chooseMode").hide();
				angular.element("input[name='designDetail.fileName']").val("");
				angular.element("input[name='designDetail.filePath']").val("");
				angular.element("input[name='MSDesignID']").val(mId);
				angular.element("input[name='exec.MSExecID']").val(eId);
	        	if(fileName && filePath){
	        		angular.element("#attachment").html(fileName);	
	        		angular.element("#attachment").attr("onclick","_showTopAttach('"+filePath+"','"+fileName+"')");
	        		 
	        		angular.element('input[name="designDetail.file"]').val('');
	        	}
	        	var scope = getScope();
	        	if(scope.active.willNext){
	        		scope.active = {activeTab: 2, willNext: false};
	        	}else{
	        		alert("保存成功");
	        	}
	        	if(tasks)
	        		scope.task.list = tasks;
// 	        	else
// 	        		scope.task.list = [];
	        	scope.event.checkHasAttached();
	        	scope.$apply(scope.active);
			}else{
				alert("当前资料保存失败，请稍后重试！");
			}
		}
		function fileChange($this){
			var suffix = {'xls': true, 'xlsx': true,'xlt': true, 'doc': true, 'docx': true, 'txt': true, 'jpg': true, 'pdf': true};
			var flag = suffix[($this.value.substring($this.value.lastIndexOf('.') + 1)).toLowerCase()];
			if(!flag){
				alert("参考附件格式不正确，请重新选择！");
				$("input[type='file']").val('');
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
		
		app.controller('ManageModeCtrl', function ($scope, $http, $filter) {
			$scope.active = {activeTab: '${not empty pojo.MSDesignID and !param.view}' == 'true' && ${pojo.massStatus ne 1} ? 2 : 1,  willNext: '${not empty pojo.MSDesignID and !param.view}' == 'true' && ${pojo.massStatus ne 1} ? true : false};
			$scope.dict = {};
			$scope.task = {};
		  	$scope.event = {
		  			init: function(){
		  				if(tab)
		  					$scope.active.activeTab = tab;
		  				if(tasks){
		  					for(var i = 0 ; i < tasks.length; i ++){
		  						tasks[i].execTask.planTime = $filter("date")(tasks[i].execTask.planTime, "yyyy-MM-dd")
		  					}
		  					$scope.task = {list: tasks};
		  				}
		  				if(executeWay)$scope.dict.execWay = executeWay;
		  				if(planTimeType)$scope.dict.planTimeType = planTimeType;
		  				if(taskType)$scope.dict.taskType = taskType;
		  				this.checkHasAttached();
					},
					checkHasAttached: function(){
						if(angular.element("#attachment").html().length > 0)
		  					$scope.hasAttached = true;
						else
							$scope.hasAttached = false;
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
								  }else{
									  if(task){
										  $scope.task.add = task;
									  }else {
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
// 							this.checkTitleUnique(function(){
								if(vForm.form()){
									$scope.active.willNext = true;
									this.checkMemberHasMs(function(){
										$('form')[0].submit();
									});
								}
// 							});
						}else{
							if($scope.active.activeTab === 1){//保存基本资料
// 								this.checkTitleUnique(function(){
									if(vForm.form()){
										this.checkMemberHasMs(function(){
											$('form')[0].submit();
										});
									}
// 								});
							}else{//保存单条任务
								if(vForm3.form()){
									this.savePersonTask();
								}
							}
						}
					},
					checkMemberHasMs: function(callback){
						if(this.getMSDesignID()){
							callback();
						}else{
							this.callRemote("checkMemberHasMs", {memberId: angular.element("input[name='memberId']").val()}, function(reponse){
								if(reponse.status){
									callback();
								}else{
									alert(reponse.content);
								}
							});
						}
					},
					savePersonTask: function(){
						$("#save").prop('disabled',true);
						var $this = this;
						this.callRemote("savePersonTask", $scope.task.add, function(reponse){
							$("#save").prop('disabled',false);
							if(reponse.status){
								if(reponse.type &&　reponse.type == "warn"){
									if(confirm(reponse.content)){
										$scope.task.add.checkDis = false;
										$this.savePersonTask();
									}
								}else{
									if(!$scope.task.add.mSTTaskID){//新增任务操作，需追加一条
										reponse.data.mSDTaskID = reponse.data.msdtaskID;
										delete reponse.data.msttaskID;
										if($scope.task.list == undefined)
											$scope.task.list = [];
										reponse.data.execTask.planTime = $filter("date")(reponse.data.execTask.planTime, "yyyy-MM-dd")
										$scope.task.list.push(reponse.data);
									}
									$scope.active.activeTab = 2;
								}
							}else{
								alert(reponse.content);
							}
						});
					},
					initAddTask: function(){
						$scope.task.add = {MSDesignID: this.getMSDesignID(), 
								MSExecID: angular.element("input[name='exec.MSExecID']").val(), 
								memberId: angular.element("input[name='memberId']").val(), 
								taskType : 1, planTimeType : 1, execWay : 3};
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
						$scope.task.original = task;
						if($scope.task.add == undefined)
							$scope.task.add = {};
					  	angular.copy(task, $scope.task.add);
						layer.closeAll();
						layer.open({
					   	    type: 1,
					   		skin : 'skin1',
					   	    title: '修改计划时间',
					   	    shadeClose: false,
					   	    shade: 0,
					   	    area: ['400px', '200px'],
					   	 	content: $("#editPlanTime"), //iframe的url
					   	}); 
					},
					deleteAttached: function(){
						if(this.getMSDesignID()){
							this.callRemote("deleteAttached", {id: this.getMSDesignID()}, function(reponse){
								if(reponse.data){
									$scope.hasAttached = false;
									angular.element("#attachment").html("");
								}else{
									alert("删除失败！");
								}
							});
						}else{
							$scope.hasAttached = false;
							angular.element("#attachment").html("");
							angular.element("input[name='designDetail.fileName']").val("");
							angular.element("input[name='designDetail.filePath']").val("");
						}
					},
					getMSDesignID: function(){
						return angular.element("input[name='MSDesignID']").val();
					},
				    deleteTask: function(id, index){
				    	this.callRemote("deleteTask", {id: id, type: 1}, function(reponse){
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
				    cancleEditTask: function(){
						$("#planTimeValue-error").html('');
						$("#planTimeValue2-error").html('');
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
				    },
				    saveEditPlanTime: function(){
				    	if(!$scope.task.add.execTask.planTime){
				    		var reg = /^(0|[1-9]\d*)$/;
				    		if(!reg.test($("#sure_time").val()) || $("#sure_time").val() > 999){
					    		layer.msg('请输入0-999之间的整数!', {icon: 7});
					    		return;
					    	}
				    	}
				    	
				    	var data = {MSDTaskID: $scope.task.add.mSDTaskID, type: 1};
				    	if($scope.task.add.execTask){
// 				    		data.planTime = $scope.task.add.execTask.planTime;
							data.planTime = $('input[ng-model="task.add.execTask.planTime"]').val();
				    	}else{
				    		data.planTimeValue = $scope.task.add.planTimeValue;
				    		data.planTimeType = $scope.task.add.planTimeType;
				    	}
				    	this.callRemote("saveEditPlanTime", data, function(reponse){
				    		if(reponse.status){
				    			alert("修改计划时间成功！");
				    			angular.copy($scope.task.add, $scope.task.original);
				    			layer.closeAll();
							}else{
								alert("修改计划时间失败！");
							}
				    	});
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
		
		app.directive('wdatePicker',function(){
	        return{
	            restrict:"A",
	            link:function(scope,element,attr){
	                element.bind('click',function(){
	                    window.WdatePicker({
	                        onpicked: function(){element.change()},
	                        oncleared:function(){element.change()}
	                    })
	                });
	            }
	        }
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
		        	if($("#action").val() == 'edit' && task.execTask){
			        	return task.execTask.planTime;
		        	}else{
		        		if(task.planTimeValue === 0 || task.planTimeValue == '0')
			        		return '当天';
		        		return task.planTimeValue+dict.planTimeType[task.planTimeType-1].name+'后';
		        	}
		        }
		    };
		});
		app.filter('getExecStatusName', function () {
		    return function(status) {
		    	if(status)
		        	return status == 1 ? "待执行" : status == 2 ? "已执行" : "已终止";
		    	else
		    		return "待执行";
		    };
		});
		
		var index = layer.getFrameIndex(window.name); //获取窗口索引
		
		function openMagModo(){
			layer.closeAll();
			layer.open({
		   	    type: 2,
		   		skin : 'skin1',
		   	    title: '选择方案模板',
		   	    shadeClose: false,
		   	    shade: 0,
		   	    area: ['940px', '550px'],
		   	    content: 'chooseTemplet', //iframe的url
		   	}); 
		}
		
		function chooseDoc(stadu){
			if(stadu == 'true'){
				layer.closeAll();
				layer.open({
			   	    type: 2,
			   		skin : 'skin1',
			   	    title: '选择医生',
			   	    shadeClose: false,
			   	    shade: 0,
			   	    area: ['610px', '400px'],
			   	    content: 'doctors?memberId='+$(":hidden[name='memberId']").val(), //iframe的url
			   	});			
			}
		}
		
		function setExeDoc(docId, docName){
			angular.element("#execDrID").val(docId);
			angular.element("#execDrName").val(docName);
			layer.closeAll();
		}
		
		function openHealthMode(){
			layer.closeAll();
			layer.open({
		   	    type: 2,
		   		skin : 'skin1',
		   	    title: '选择健教模板',
		   	    shadeClose: false,
		   	    shade: 0,
		   	    area: ['880px', '500px'],
		   	  content: 'chooseHealthTemp', //iframe的url

		   	}); 
		}
		
		function setTemplet(MSTempletID){
			$.ajax({
				   type: "GET",
				   url: '../templet/selectById?id='+MSTempletID,
				   asyn: false,
				   success: function(response){
					   var filePath ="";
					   var fileName = "";
					   for(var k in response.data){
						   $("[tName='"+k+"']").val(response.data[k]);
						  // if(k == 'filePath')
							//   $("#attachment").attr("href", response.data[k]);
						    
						   if(k == 'filePath'){
							   filePath = response.data[k];
						   }
							  
						   if(k == 'fileName'){
							   fileName = response.data[k];
							    $("#attachment").html(response.data[k]);
							   
						   } 
							   
					   }
					   angular.element("#attachment").attr("onclick","_showTopAttach('"+filePath+"','"+fileName+"')");
			        	
					   $("input[name='referenceId']").val(response.data.mstempletID);
					   changeStadu();
					   $("input[name='tasks']").val(JSON.stringify(response.data.tasks));
					   var scope = getScope();
					   scope.event.checkHasAttached()
					   scope.$apply();
				   }
				});
			layer.closeAll();
		}
		
	 	function changeStadu(){
	 		if($("select[name='designDetail.isCharge'] option:selected").val() == 0){
				$("#price").hide();
				$("input[name='designDetail.price']").attr('prop', true);
				$("input[name='designDetail.price']").val('');
				$(".price-error").html('');
			}else if($("select[name='designDetail.isCharge'] option:selected").val() == 1){
				$("input[name='designDetail.price']").attr('prop', false);
				$("#price").show();
			}
	 	}
	 	$(function(){
	 		$("#price").hide();
			if($("select[name='designDetail.isCharge'] option:selected").val() == 0){
				$("#price").hide();
			}else if($("select[name='designDetail.isCharge'] option:selected").val() == 1){
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
					'designDetail.srvLimitValue' : {
						srvLimit: true
					},
					'designDetail.benchmarkTime' : {
						isBlank: true,
					},
					'designDetail.price' : {
						numberPrice: true,
						isBlank: true,
					},
					'execDrName' : {
						isBlank: true,
					}
				},
				messages : {
					'schemeTitle' : {
						isBlank : "必填!",
					},
					'designDetail.srvLimitValue' : {
						srvLimit: "请输入0-99的整数!",
					},
					'designDetail.benchmarkTime' : {
						isBlank : "必填!",
					},
					'designDetail.price' : {
						numberPrice : "请输入整数最多8位，小数最多2位的值!",
						isBlank : "必填!",
					},
					'execDrName' : {
						isBlank : "必填!",
					}
				}
			});
			
			// form_3表单验证
			vForm3 = $("#form_3").validate({
				rules : {
					'planTimeValue' : {
						planTimeValue: true,
						isBlank: true,
					},
					'planTimeValue2' : {
						isBlank: true,
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
						isBlank: "必填!",
					},
					'planTimeValue2' : {
						isBlank: "必填!",
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
			if(${not empty pojo.MSDesignID and !param.view} && ${pojo.massStatus ne 1}){
				$("#form_1 input, #form_1 select, #form_1 textarea").prop("disabled",true);
			}else if(${not empty pojo.MSDesignID and param.view}){
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
		<div class="content-title">个人管理方案 --- <c:if test="${empty pojo.MSDesignID}">新增</c:if><c:if test="${not empty pojo.MSDesignID and !param.view}">修改</c:if><c:if test="${not empty pojo.MSDesignID and param.view}">查看</c:if></div>
		<div class="detail-box clearfix">
			<div class="fl width-fl">
				<input type="hidden" name="memberId" value="${member.memberid}">
				<p>姓名：<span class="mg-right">${member.memname}</span>性别：<span class="mg-right">${member.gender eq 1 ? '男' : member.gender eq 2 ? '女' : '未知'}</span>年龄：<span class="mg-right">${age}</span>手机号码：<span class="mg-right">${member.tel}</span>身份证号码：<span class="mg-right">${member.idcard}</span>状态：<span class="mg-right">${member.status eq 'T' ? '正常' : '冻结'}</span></p>
				<p>会员疾病史：<span class="mg-right">
					<c:forEach items="${diseases}" var="disease">
						${disease.diseasename}；
					</c:forEach>
				</span>会员标签：<span>
					<c:forEach items="${labels}" var="label">
						${label.itemname};
					</c:forEach>
				</span></p>
			</div>
			<div class="fr width-fr">
				<button type="button" class="btn-inquiry" onclick="window.open('<%=path %>/member/${member.memberid }/memberPage', '_blank')">查看会员信息</button>
			</div>
		</div>
		<div class="tab" style="position: relative;">
			<ul>
				<li class="tab1" ng-class="{true: 'active'}[active.activeTab == 1]" data-page="tab1-page" ng-click="event.changeTab(1)">1 方案基本资料</li>
				<li class="tab2" ng-class="{true: 'active'}[active.activeTab == 2]" data-page="tab2-page" ng-click="event.changeTab(2, null, '${not empty pojo.MSDesignID}')">2 方案执行任务</li>
				<li class="tab2 active" ng-show="active.activeTab == 3">2 方案执行任务</li>
			</ul>
			<c:if test="${empty pojo.MSDesignID}">
				<button ng-show="active.activeTab == 1" type="button" id="chooseMode" class="btn-normal fix-place" onclick="openMagModo()">选择方案模板</button>
			</c:if>
		</div>
		<div class="main-content">
			<!-- tab1-page -->
			<div id="tab1-page" ng-show="active.activeTab == 1">
				<form id="form_1" name="form_1" action="save" novalidate ng-disabled="operate=='view'" target="upload" method="post" enctype="multipart/form-data">	
					<input type="hidden" id="action" value="${empty pojo.MSDesignID ? 'add' : 'edit'}">
					<input type="hidden" name="MSDesignID" value="${pojo.MSDesignID}">
					<input type="hidden" name="schemeType" value="1">
					<input type="hidden" name="exec.MSExecID" value="${pojo.exec.MSExecID}">
					<input type="hidden" name="exec.memberID" value="${pojo.exec.memberID == null ? member.memberid : pojo.exec.memberID}">
					<input type="hidden" name="referenceId">
					<input type="hidden" id="massStatus" value="${pojo.massStatus}">
					<table border="0" cellspacing="0" class="table-normal table-fixed">
			    		<tbody>
				    		<tr>
				    			<td colspan="1"><span class="red">*</span>方案标题：</td>
				    			<td colspan="6">
				    				<input type="text" class="width-print" name="schemeTitle" tName="schemeTitle" value="${pojo.schemeTitle}" maxlength="20">
			    				</td>
				    		</tr>
				    		<tr>
				    			<td colspan="1" class="text-top" >总体管理目标：</td>
				    			<td colspan="6"><textarea rows="9" cols="110" name="designDetail.manageGoal" tName="manageGoal" maxlength="500">${pojo.designDetail.manageGoal}</textarea></td>
				    		</tr>
				    		<tr>
				    			<td colspan="1" class="text-top">服务期限：</td>
				    			<td colspan="6">
				    				<input type="text" class="width-number" name="designDetail.srvLimitValue" tName="srvLimitValue" value="${pojo.designDetail.srvLimitValue}" maxlength="2">
				    				<select name="designDetail.srvLimitType" tName="srvLimitType">
				    					<option value="1" <c:if test="${pojo.designDetail.srvLimitType eq 1}">selected="selected"</c:if>>天</option>
				    					<option value="2" <c:if test="${pojo.designDetail.srvLimitType eq 2}">selected="selected"</c:if>>周</option>
				    					<option value="3" <c:if test="${pojo.designDetail.srvLimitType eq 3}">selected="selected"</c:if>>月</option>
				    					<option value="4" <c:if test="${pojo.designDetail.srvLimitType eq 4}">selected="selected"</c:if>>年</option>
				    				</select>
				    				<label id="designDetail.srvLimitValue-error" class="error" for="designDetail.srvLimitValue"></label>
			    					<span class="red margin-left">*</span>基准时间：
			    					<select name="designDetail.benchmarkTime" tName="benchmarkTime">
				    					<option value="1" <c:if test="${pojo.designDetail.benchmarkTime eq 1}">selected="selected"</c:if>>方案触发时间</option>
				    				</select>
			    					<span class="margin-left">是否收费：</span>
			    					<select name="designDetail.isCharge" onchange="changeStadu()" tName="isCharge">
				    					<option value="0" <c:if test="${pojo.designDetail.isCharge eq 0}">selected="selected"</c:if>>免费</option>
				    					<option value="1" <c:if test="${pojo.designDetail.isCharge eq 1}">selected="selected"</c:if>>收费</option>
				    				</select>
				    				<span id="price">
				    					<span class="margin-left"><span class="red">*</span>价格：</span>
					    				<input type="text" class="width-price" name="designDetail.price" value="${pojo.designDetail.price}" tName="price">
					    				<span>元</span>
					    				<label id="designDetail.price-error" class="error price-error" for="designDetail.price"></label>
				    				</span>
			    				</td>
				    		</tr>
				    		<tr>
				    			<td colspan="1" class="text-top">参考附件：</td>
				    			<td colspan="6">
				    				<input type="hidden" name="designDetail.fileName" tName="fileName">
				    				<input type="hidden" name="designDetail.filePath" tName="filePath">
				    				<input type="file" name="designDetail.file" onchange="fileChange(this)">
				    				<br>
				    				 	 <a href="javascript:void(0);" onclick="_showTopAttach('${pojo.designDetail.filePath}','${pojo.designDetail.fileName}')" 
				    				  id="attachment" >${pojo.designDetail.fileName}</a>
				    				
				    				<c:if test="${!param.view and pojo.massStatus eq 1}">
				    					<img alt="删除" src="<%=path %>/img/u478.png" title="删除" ng-click="event.deleteAttached()" ng-show="hasAttached" style="cursor: pointer;">
				    				</c:if>
				    				<%-- <c:if test="${param.view or pojo.massStatus ne 1}">
					    				<img alt="删除" src="<%=path %>/img/u478.png" title="删除" ng-show="hasAttached" style="cursor: default;">
				    				</c:if> --%>
								</td>
				    		</tr>
				    		<tr>
				    			<td colspan="1" class="text-top">方案介绍：</td>
				    			<td colspan="6"><textarea rows="9" cols="110" name="designDetail.introduction" tName="introduction" maxlength="500">${pojo.designDetail.introduction}</textarea></td>
				    		</tr>
				    		<tr>
				    			<td colspan="1"><span class="red">*</span>执行医生：</td>
				    			<td colspan="6">
				    				<div class="position-r">
				    					<input type="hidden" id="execDrID" name="execDrID" value="${pojo.execDrID}">
						                <input type="text" readonly id="execDrName" name="execDrName" value="${pojo.execDrName}">
						                <i class="member-search2" onclick="chooseDoc('${!param.view and pojo.massStatus eq 1}');"></i>
				                 	</div>
				                 	<label id="execDrName-error" class="error" for="execDrName"></label>
				    			</td>
				    		</tr>
			    		</tbody>
		    		</table>
		    		<input type="hidden" name="tasks">
				</form>
				<iframe name="upload" style="display:none"></iframe>
			</div>
			
			<div id="tab2-page" ng-cloak ng-show="active.activeTab == 2">
				<form id="form2" name="form_2" action="" novalidate>
					<div class="clearfix content-head">
						<c:if test="${empty pojo.MSDesignID}">
						<label>任务基准时间：</label><span>方案触发时间</span>
						</c:if>
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
		   		    				<th width="5%">状态</th>
			   		    			<c:if test="${!param.view}">
			   		    				<th>操作</th>
		   		    				</c:if>
			   		    		</tr>
			   		    	</thead>
			   		    	<tbody>
			   		    		<tr ng-repeat="task in task.list | orderBy:'execTask.planTime'">
			   		    			<td>{{task | getName:1:dict}}</td>
			   		    			<td>{{task | getName:2:dict}}</td>
			   		    			<td>{{task | getName:3:dict}}</td>
			   		    			<td ng-show="task.execTask.execStatus == 2"><a href="../manageschemeTask/detail?id={{task.execTask.mSETaskID}}&source=../managescheme/toEditPerson?id=${pojo.MSDesignID}&view=true&tab=2">{{task.summary}}<a></td>
			   		    			<td ng-show="task.execTask.execStatus != 2">{{task.summary}}</td>
			   		    			<td>{{task.execTask.execStatus | getExecStatusName}}</td>
			   		    			<c:if test="${!param.view}">
				   		    			<td ng-show="task.execTask.execStatus == 2 || task.execTask.execStatus == 3">
				   		    				<span>修改</span>
				   		    				<span class="mar-left">删除</span>
				   		    			</td>
				   		    			<td ng-show="task.execTask == null || task.execTask.execStatus == 1">
				   		    				<a href="javascript:void(0);" ng-click="event.toEditTask(task)">修改</a>
				   		    				<a href="javascript:void(0);" class="mar-left" ng-click="event.deleteTask(task.mSDTaskID, $index)" >删除</a>
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
				    				<c:if test="${empty pojo.MSDesignID}">
					    				方案触发时间后
					    				<input type="text" class="width-number" name="planTimeValue" ng-model="task.add.planTimeValue" maxlength="3">
					    				<select name="planTimeType" ng-model="task.add.planTimeType" ng-options="d.code as d.name for d in dict.planTimeType">
					    				</select>
					    				<label id="planTimeValue-error" class="error" for="planTimeValue" style="display: inline-block;"></label>
				                    </c:if>
				    				<c:if test="${not empty pojo.MSDesignID}">
				    					<input class="info-date" name="planTimeValue2" id="planTime3" type="text" ng-model="task.add.planTime" value='' readonly />
				    					<label id="planTimeValue2-error" class="error" for="planTimeValue2" style="display: inline-block;"></label>
				    				</c:if>
				    					<span class="red margin-left">*</span>任务类型：
				    					<select name="taskType" ng-model="task.add.taskType" ng-options="d.code as d.name for d in dict.taskType">
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
				    				<span><a href="../checkHealth?id={{task.add.taskRef.id}}&view=true&close=true" target="_blank" onclick="">{{task.add.taskRef.name}}<span ng-hide="task.add.taskRef.name">{{task.original.taskRef.name}}</span></a></span>
				    				<label ng-hide="task.add.taskRef.name" id="healthMode-error" class="error" for="healthMode"></label>
			    				</td>
				    		</tr>
				    		<tr ng-show="task.add.taskType == 4">
				    			<td colspan="1" class="text-top"><span class="red">*</span>请选择问卷：</td>
				    			<td colspan="6">
				    				<a href="javascript:void(0);" ng-click="event.chooseQuestion(task.add.execWay)">选择：</a>
				    				<input type="text" class="hidden" name="qustName" value="{{task.add.taskRef.name}}">
				    				<span><a href="../../question/questionInfo?qustId={{task.add.taskRef.id}}" target="_blank" onclick="">{{task.add.taskRef.name}}<span ng-hide="task.add.taskRef.name">{{task.original.taskRef.name}}</span></a></span>
				    				<label ng-hide="task.add.taskRef.name" id="qustName-error" class="error" for="qustName"></label>
			    				</td>
				    		</tr>
				    		<tr>
				    			<td colspan="1" class="text-top"><span class="red">*</span>任务概述：</td>
				    			<td colspan="6">
				    				<textarea rows="8" cols="110" class="text-top" name="summary" ng-model="task.add.summary" maxlength="100" ></textarea>
				    				<p style="color: #a1a1a1;">消息类的任务概述内容会推送给会员</p>
				    				<label id="summary-error" class="error" for="summary" style="display: inline-block;"></label>
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
		<c:if test="${empty pojo.MSDesignID or pojo.massStatus eq 1}">
			<div class="page-box" ng-class="{true: 'align-center'}[active.activeTab == 3]">
				<input type="button" ng-hide="active.activeTab == 2" class="btn-inquiry" id="save" ng-click="event.save()" value="保存"/>
				<input type="button" ng-hide="active.activeTab == 3" class="btn-cancel" ng-class="{true: 'fr'}[active.activeTab == 2]" value="返回" onclick="window.location.href='${empty param.source ? 'listPerson' : param.source}'"/>
				<input type="button" ng-show="active.activeTab == 3" class="btn-cancel" value="取消" ng-click="event.cancleEditTask()"/>
				<input type="button" ng-show="active.activeTab == 2" class="btn-inquiry fl" value="上一步" ng-click="event.changeTab(active.activeTab - 1)"/>
				<input type="button" ng-show="active.activeTab == 1" class="btn-inquiry fr" value="下一步" ng-click="event.changeTab(active.activeTab + 1)"/>
			</div>
		</c:if>
		<c:if test="${not empty pojo.MSDesignID and pojo.massStatus ne 1}">
			<div class="page-box align-center">
				<input type="button" ng-hide="active.activeTab == 2 || active.activeTab == 1" class="btn-inquiry" id="save" ng-click="event.save()" value="保存"/>
				<input type="button" ng-show="active.activeTab == 3" class="btn-cancel" value="取消" ng-click="event.cancleEditTask()"/>
				<input type="button" ng-hide="active.activeTab == 3" class="btn-cancel" value="返回" onclick="window.location.href='${empty param.source ? 'listPerson' : param.source}'"/>
			</div>
		</c:if>
	</div>
	<div id="editPlanTime" style="display: none;">
	<form action="" method="post">
		<div class="layer-box" ng-show="task.add.execTask && ${not empty pojo.MSDesignID}">
			<span>请重新选择任务计划执行时间：</span>
			<input class="info-date" id="planTime" type="text" ng-model="task.add.execTask.planTime" value="" readonly />
		</div>
		<div class="layer-box" ng-show="${empty pojo.MSDesignID}">
			<span class="red">*</span>任务计划时间： 方案触发时间后 <input type="text" id="sure_time" class="width-number" name="planTimeValue" ng-model="task.add.planTimeValue">
			<select name="planTimeType" ng-model="task.add.planTimeType" ng-options="d.code as d.name for d in dict.planTimeType">
			</select>
		</div>
		<div class="page-box align-center">
			<input type="button" class="btn-inquiry" value="保存" ng-click="event.saveEditPlanTime()">
			<input type="button" class="btn-cancel" onclick="layer.closeAll();" value="取消">
		</div>
	</form>
</div>
</body>
</html>