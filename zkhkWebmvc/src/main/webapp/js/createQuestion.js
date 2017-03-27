/*
 * 创建问卷
 */
var app = angular.module('createQuestionnaire', ['ngDialog', 'ngAnimate'], function($httpProvider){

});

//  只显示题号大于本题的题目 并且不显示已经选择过的题目
app.filter('myfilter1', function () {
    return function (arr, id, existList, index) {
       return arr.filter(function(item) {
    	   // 问题编号 大于 本题  && (没有被选中过 || 题目编号等于现在选中的)
           if(item.problemid > id && (existList.indexOf(item.problemid) < 0 || item.problemid == index)) {
               return true;
           }
       });

        
    };
});

//只显示未选择过的答案 
app.filter('myfilter2', function () {
    return function (arr, existList, index) {
       return arr.filter(function(item) {
    	   var result = true;
    	   
    	   for(var e in existList) {
    		   if(existList[e].answerId == item.ansid && index !== item.ansid ) {
    			   result = false;
    		   }
    	   }
    	  
    	   return result;
       });        
    };
});

app.controller('QuestionListCtrl', function ($scope,$timeout, $http, $filter, ngDialog) {
		  $scope.AtoZ = ['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'];
		  $scope.activeTab = 1;
		  $scope.operate = operate;
		  $scope.ooptList = [];
		  $scope.changeLogic = false;
		  $scope.firstValid = false;
		  $scope.useRanges = [{code: 1, name: "全局"},{code: 2, name: "组织内共享"}];
		  $scope.changedOrg = false;
		  $scope.required = {org: true};
		  $scope.ansMode_disabled;
		  // 切换Tab 然后保存数据
		  $scope.changeTab = function(id, btnClick) {
			  if($scope.operate !='create' || btnClick) {
				  if(id < 1) {
					  id = 1;
				  }else if(id > 4) {
					  id = 4;
				  }
				  
				  if(id < $scope.activeTab) { // 上一步 不需要验证和保存
					  $scope.activeTab = id;
				  }else if(id > $scope.activeTab &&  $scope.operate != 'view') { // 下一步 需要验证和保存
					  $scope.firstValid = true;
					  $scope.event.saveOrUpdateOmfq(id);
				  }else{
					  $scope.activeTab = id;
				  }
				  
//				  if($scope.activeTab+1 === id && btnClick)
//					  $scope.event.saveOrUpdateOmfq(true);
//				  else
//					  $scope.activeTab = id;
			  }
		  }
		  
		  
		  $scope.Question = {
					init: function() {
						this.getData();
						this.view.render();
						if(this.model.questionnaire.useRange == 1)
							$scope.event.querySingleOopt({id: 0, name: ''});
						else
							$scope.event.querySingleOopt({id: this.model.questionnaire.orgId, name: this.model.questionnaire.orgName});
						
					},
					getData: function(data) {
						if(data){
							$scope.chkArr = [[],[],[]];
							OMFQ = data;
						}
						if(OMFQ){
//							$scope.operate='edit';
							this.model.questionnaire = angular.copy(OMFQ);// obj.slice(0);
							if(OMFQ && OMFQ.mfq1s){
								angular.forEach(OMFQ.mfq1s, function(v){
									$scope.chkArr[0].push({problemid: v.problemid, checked: false});
						        	$scope.chkArr[1].push({problemid: v.problemid, checked: false});
						        	$scope.chkArr[2].push({problemid: v.problemid, checked: false});
						        });
								if(OMFQ.mfq2 && OMFQ.mfq2.countmethod){//mfq2
									angular.forEach(OMFQ.mfq2.problemIds, function(v){//已选题
										if($scope.chkArr[OMFQ.mfq2.countmethod-1].length > 0 && $scope.chkArr[OMFQ.mfq2.countmethod-1][v-1])
											$scope.chkArr[OMFQ.mfq2.countmethod-1][v-1].checked=true;
									});
									
									if(OMFQ.mfq2.problemIds && OMFQ.mfq2.problemIds.length === OMFQ.mfq1s.length )//全选
										$scope.chkAll[OMFQ.mfq2.countmethod-1] = true;
								}
							}
							
						}
					},
					addQuestion: function() {
						this.model.addQuestion(1);
					},
					getQuestionList: function() {
						return this.model.questionnaire.mfq1s;
					},
					removeQuestion: function(index) {
						this.model.removeQuestion(index);
					},
					changeType: function(index) {
						this.model.changeType(index);
					},
					addAnswer: function(index) {
						this.model.addAnswer(this.model.questionnaire.mfq1s[index].mfq11s ,1);
					},
					removeAnswer: function(pindex) {
						this.model.removeAnswer(this.model.questionnaire.mfq1s[pindex].mfq11s);
					},
					upQuestion: function(index) {
						if(index == 0) {
				            return;
				        }
						//  修改问题编号
						this.model.questionnaire.mfq1s[index].problemid-=1; // 当前题号 
						this.model.questionnaire.mfq1s[index-1].problemid+=1;	
						//  切换两个问题的位置
						this.model.swapItems(this.model.questionnaire.mfq1s, index, index - 1);
						
						//  清除逻辑问题等于当前题目的逻辑问题
						this.model.checkLogic(this.model.questionnaire.mfq1s[index])
						this.model.checkLogic(this.model.questionnaire.mfq1s[index - 1])
						//  刷新数据
						$timeout(function() {
							$scope.Question.model.questionnaire.mfq1s = angular.copy($scope.Question.model.questionnaire.mfq1s);
						},1000); 						
					},
					downQuestion: function(index) {
						if(index == this.model.questionnaire.mfq1s.length -1) {
							return;
						}
						//  修改问题编号
						this.model.questionnaire.mfq1s[index].problemid +=1;
						this.model.questionnaire.mfq1s[index+1].problemid-=1;
						//  切换两个问题的位置 
						this.model.swapItems(this.model.questionnaire.mfq1s, index, index + 1);
						//  清除逻辑问题等于当前题目的逻辑问题
						this.model.checkLogic(this.model.questionnaire.mfq1s[index]);
						this.model.checkLogic(this.model.questionnaire.mfq1s[index + 1]);
						//  刷新数据
						$timeout(function() {
							$scope.Question.model.questionnaire.mfq1s = angular.copy($scope.Question.model.questionnaire.mfq1s);
						},1000);
						
					},
					isShow: function(type, index) {
						this.view.isShow(type, index);
					},
					removeResult: function(index) {
						this.model.removeResult(index);
					},
					addResult: function() {
						this.model.addResult();
					},
					openLogic: function(question) {
						this.view.openLogic(question);
					},
					addLogic: function(logicses, problemId) {
						this.model.addLogic(logicses, problemId);
					},
					removeLogic: function(logicses,index) {
						this.model.removeLogic(logicses,index);
					},
					addLogicQuestion: function(mfq1s) {
						this.model.addLogicQuestion(mfq1s);
					},
					removeLogicQuestion: function(mfq1s, index) {
						this.model.removeLogicQuestion(mfq1s, index);
					},
					isUnique: function(content) {
						this.model.isUnique(content);
					},
					changeMaxScore: function(list, index) {
						this.model.changeMaxScore(list, index);
					}
				};
		  $scope.event = {
				  saveOrUpdateOmfq : function(next, qustTag){
					  $scope.firstValid = true;
					  var isOk = false;
					  
					  if($scope.activeTab === 1) {
						  if(!$scope.event.isDoctor() && $scope.Question.model.questionnaire.useRange == 2 && !$scope.Question.model.questionnaire.orgName)
							  return;
						  isOk = $scope.form_1.$valid;
					  }else if($scope.activeTab === 2) {
						  if(!$scope.Question.model.questionnaire.mfq1s || $scope.Question.model.questionnaire.mfq1s.length < 1) {
							  alert("请添加问题");
							  return;
						  }
						  isOk = $scope.form_2.$valid;
					  }else if($scope.activeTab === 3) {
						  isOk = true;
					  }else if($scope.activeTab === 4) {
						  var list = $scope.Question.model.questionnaire.mfq2 && $scope.Question.model.questionnaire.mfq2.problemIds;
						  
//						  console.info(list);
						  if(!list || list.length <= 0) {
							  alert("请选择总分计算方法的问题");
							  return;
						  }
						  if($scope.Question.model.questionnaire.mfq21s && $scope.Question.model.questionnaire.mfq21s.length <=0) {
							  alert("请添加选择判定条件与结论内容");
							  return;
						  }
						  // 检查答卷结果判定条件与结论内容 的分值区间
						  var checkResult = false;
						  $($scope.Question.model.questionnaire.mfq21s).each(function(i, e) {
							  if($scope.Question.model.questionnaire.mfq21s[i-1]) {
								  if(e.minScore > e.maxScore || e.minScore <= $scope.Question.model.questionnaire.mfq21s[i-1].maxScore) {
									  checkResult = true
									  return false;
								  }  
							  }
						  });
						  if(checkResult) {
							  alert("请填写正确的分值区间.");
							  return;
						  };
						  isOk = $scope.form_4.$valid;
					  }

					  if((next ==1 || next ==3 || next ==4) && (!$scope.Question.model.questionnaire.mfq1s || $scope.Question.model.questionnaire.mfq1s.length < 1)) {
						  alert("请先设置问卷内容")
						  $scope.activeTab = 2;
						  return;
					  }
					 
					  if(isOk){
						  if(qustTag == 'T' || $scope.changeLogic || ($scope["form_"+$scope.activeTab] && $scope["form_"+$scope.activeTab].$dirty) || $scope.changedOrg){
							  if(qustTag == 'T'){
								  $scope.Question.model.questionnaire.qustTag=qustTag;
							  }
							  $http.post('save', angular.copy($scope.Question.model.questionnaire)).success( function(response) {
									  //  如果用户已经在其他地方登陆 则提示用户
									  if(typeof response == "string") {
										  document.write(response);
										  return;
									  }
									  if(response.status){
										  delete response.data.valid;
										  $scope.Question.getData(response.data);
//										  $scope.Question.model.questionnaire.qustid = response.data.qustid
										  if(next)
											  $scope.activeTab = next;
										  else
											  window.location.href="list";
									  }
									  else {
										  alert(response.content)
									  }
					              }).error(function(){
					            	  alert("请求异常！");
					            	  window.location.href="list";
					              });
						  }else{
							  if(next)
								  $scope.activeTab = next;
							  else
								  window.location.href="list";
						  }
					  }
				  },
				  chkAll: function(checked, index){
					  angular.forEach($scope.chkArr[index], function(value, key){
						  value.checked = checked;
					  });
				  },
				  changeMethod: function(newMethod){
					  $scope.line = newMethod;
					  //  将选项清空
					  for(var i = 0; i < $scope.chkArr[1].length; i++){
						  $scope.chkArr[0][i].checked = false;
						  $scope.chkArr[1][i].checked = false;
						  $scope.chkArr[2][i].checked = false;
					  }
					  $scope.chkAll = [false, false, false];
					  // 默认全选
					  $scope.chkAll[newMethod-1] = true;
					  $scope.event.chkAll(true, newMethod-1)
				  },
				  isDoctor: function(){
					  return $("input[name='orgName']").length === 0;
				  },
				  querySingleOopt: function(treeNode){
					  if($scope.Question.model.questionnaire.orgId != treeNode.id){
						  $scope.changedOrg = true
						  angular.extend($scope.Question.model.questionnaire, {orgId: treeNode.id, orgName: treeNode.name, qustname:''});
					  }
					  // 获取问卷类别数据
					  $http.get('../queryOption?funId=3&useRange=' + $scope.Question.model.questionnaire.useRange + (treeNode.id != undefined ? "&orgId=" + treeNode.id : "")).success( function(response) {
						  $scope.ooptList = angular.copy(response.data);
			          });
				  }
		  };
		  $scope.Question.model = {
				    questionnaire: {ansMode:1,mfq1s:[],mfq2:{countmethod:1},mfq21s:[],qustTag: 'D', 
				    	useRange: 2,
				    	qustNameType: $scope.event.isDoctor() ? '自定义名称' : '固定名称'},
					addQuestion: function(type) {
						var obj = {proDesc: '', ansType: type, problemid: $scope.Question.model.questionnaire.mfq1s.length+1, mfq11s: [], logicses: []};
						
						if(type == 1) {
							this.addAnswer(obj.mfq11s, 2);
						}else {
							this.addAnswer(obj.mfq11s, 3);
						}
						this.questionnaire.mfq1s.push(obj);
					},
					removeQuestion: function(index) {
						this.questionnaire.mfq1s.splice(index, 1);
						// 重置problemid
						$(this.questionnaire.mfq1s).each(function(i, e) {
							e.problemid = i + 1;
						});
					},
					addAnswer: function(mfq11s, count) {
						var length = mfq11s.length;
						for(var i = 1; i<= count; i++) {
							mfq11s.push({description: '', score: 0, ansid: length+i, mark: $scope.AtoZ[length+i-1]});
						}
					},
					removeAnswer: function(mfq11s) {
						mfq11s.pop();
						// 重置problemid
						$(mfq11s).each(function(i, e) {
							e.ansid = i + 1;
						});
					},
					changeType: function(index) {	// 切换题型时 控制答案的最先数量
						var count = this.questionnaire.mfq1s[index].mfq11s.length,
							type = this.questionnaire.mfq1s[index].ansType;
						
						if(type == 1 && count < 2) {
							this.addAnswer(this.questionnaire.mfq1s[index].mfq11s, 2 - count);
						}else if(type == 2 && count < 3){
							this.addAnswer(this.questionnaire.mfq1s[index].mfq11s, 3 - count);
						}
					},
					swapItems: function(arr, index1, index2) {
						arr[index1] = arr.splice(index2, 1, arr[index1])[0];
//						return angular.copy(arr);
					},
					checkLogic: function(question) {
						for(var i in question.logicses) {
							for(var j in question.logicses[i].problemIds) {
								if(question.logicses[i].problemIds[j] == question.problemid) {
									question.logicses[i].problemIds.splice(j, 1);
								}
							}
							if(question.logicses[i].problemIds.length == 0) {
								question.logicses.splice(i, 1);
							}
						}
					},
					removeResult: function(index) {
//						console.log(index);
						this.questionnaire.mfq21s.splice(index, 1);
					},
					addResult: function() {
						var mscore = 0;
						var length = this.questionnaire.mfq21s.length; 
						var lastMaxScore = length && this.questionnaire.mfq21s[length-1].maxScore;
						
						if(length > 0 && lastMaxScore) {
							var count = lastMaxScore.toString().split(".")[1]?lastMaxScore.toString().split(".")[1].length: 0;
							
							if(count == 0) {
								mscore = lastMaxScore +1;
							}else if(count == 1) {
								mscore = (lastMaxScore * 10 +1) /10;
							}else if(count == 2) {
								mscore = (lastMaxScore * 100 + 1) /100;
							}
						}
						this.questionnaire.mfq21s.push({minScore: mscore, maxScore: mscore + 1, conclusion: '', convid: this.questionnaire.mfq21s.length+1});
					},
					addLogic: function(logicses, problemId) {
						logicses.push({answerId: null, problemId: problemId, problemIds: [null] });
					},
					removeLogic: function(logicses,index) {
						logicses.splice(index, 1);
					},
					addLogicQuestion: function(mfq1s) {
						mfq1s.push(null);
					},
					removeLogicQuestion: function(mfq1s, index) {
						mfq1s.splice(index, 1);
					},
					updateLogic: function(arr){
						for(var i = 0; i< arr.length; i++) {
							if(arr[i].answerId == null) {
								alert("请选择选项列表项");
								return false;
							}
							for(var j =0; j< arr[i].problemIds.length; j++) {
								if(arr[i].problemIds[j] == null) {
									alert("请选择题目列表项");
									return false;
								}
							}
						}
						return true;
						
					},
					isUnique: function(content) {
						$(this.questionnaire.mfq1s).each(function(i, e) {
							if(e.proDesc == content) {
								return true;
							}
						});
					},
					changeMaxScore: function(list, index) {
						var length = list.length;
						if(index == length -1 || !list[index].maxScore) {
							return;
						}
						var count = list[index].maxScore.toString().split(".")[1]?list[index].maxScore.toString().split(".")[1].length: 0;
						var mscore = 0;
						
						if(count == 0) {
							mscore = list[index].maxScore +1;
						}else if(count == 1) {
							mscore = (list[index].maxScore * 10 +1) /10;
						}else if(count == 2) {
							mscore = (list[index].maxScore * 100 + 1) /100;
						}
						list[index+1].minScore = mscore;
						
					}
				};

		  $scope.Question.view = {
					render: function() {
						
					},
					renderQuestion: function(q) {

					},
					isShow: function(type, index) {
//						console.log((type == 1 && index > 1), (type == 2 && index > 2))
						if(type == 1 && index > 1){
							return true;
						}
						else if(type == 2 && index > 2) {
							return true;
						}
						else {
							return false;
						}
					},
					addQuestion: function() {
						$scope.type = 1;//默认单选
						ngDialog.open({ template: 'templateAddQuestion',//模式对话框id
				  	           scope:$scope, //将scope传给模板,以便显示信息
				  	           
				  	       });
					},
					openLogic: function(question) {
						//console.log(question);
						if(question.logicses.length == 0) {
							question.logicses.push({answerId:null, problemId: question.problemid, problemIds: [null]})
						}
						$scope.question = question;
						ngDialog.open({ template: 'templateSetLogic',//模式对话框id
				  	           scope:$scope, //将scope传给模板,以便显示信息
				  	           overlay: true,
				  	           closeByEscape: false,
				  	           closeByDocument : false
				  	       });
					}

				};
		  $scope.chkAll = [false, false, false];
		  $scope.chkArr = [[],[],[]];
	      $scope.$watch('Question.model.questionnaire.mfq1s', function(nv, ov, scope){	    	  
	        if(nv == ov){
			   return;
		    }
	        $scope.chkArr = [[],[],[]];
	        
	        angular.forEach(nv, function(v, index){
	        		// 控制问题内容不能重复
	       		var temp = 0;
		        	angular.forEach(nv, function(v2) {
		        		if(v2.problemid != v.problemid && v2.proDesc == v.proDesc) {
		        			temp++;
		        		}
		        	});
		        	
		        	if(temp > 0) {
		        		$scope.form_2["namesForm_"+index] && $scope.form_2["namesForm_"+index]["input_question"].$setValidity('myunique',false);
		        	}else {
		        		$scope.form_2["namesForm_"+index] && $scope.form_2["namesForm_"+index]["input_question"].$setValidity('myunique',true);
		        	}
		        	
		        	$scope.chkArr[0].push({problemid: v.problemid, checked :true});
		        	$scope.chkArr[1].push({problemid: v.problemid, checked :false});
		        	$scope.chkArr[2].push({problemid: v.problemid, checked :false});
	        });
	        $scope.changeLogic = true;
	      }, true);
	      $scope.line = $scope.Question.model.questionnaire.mfq2.countmethod;
	      $scope.$watch('chkArr', function(nv, ov){
	    	  if(nv == ov && nv.length > 0){
				   return;
			  }
	    	  if(!$scope.Question.model.questionnaire.mfq2)
	    		  $scope.Question.model.questionnaire.mfq2 = {countmethod: 1};
	    	  $scope.Question.model.questionnaire.mfq2.problemIds = [];
	    	  nv = nv[$scope.line-1];
				  angular.forEach($filter('filter')(nv, {checked: true}), function(v) {
				    			$scope.Question.model.questionnaire.mfq2.problemIds.push(v.problemid);
				  });
			  $scope.chkAll[$scope.line-1] = $scope.Question.model.questionnaire.mfq2.problemIds.length == $scope.chkArr[$scope.line-1].length;
	      }, true);
	      $scope.$watch("Question.model.questionnaire.qustname", function(nv, ov){
	    	  $scope.ansMode_disabled = false;
	    	  if($scope.Question.model.questionnaire.qustNameType == '固定名称'){
	    		  var ansMode = $("option[value='" + nv + "']").attr('ansmode');
	    		  if(ansMode && ansMode > 0){
	    			  $scope.Question.model.questionnaire.ansMode = ansMode;
	    			  $scope.ansMode_disabled = true;
	    		  }
	    	  }
	      });
	      $scope.$watch("Question.model.questionnaire.useRange", function(nv, ov){
	    	  $scope.ooptList = [];
	    	  if(nv == "2"){
	    		  $scope.required.org = true;
	    	  }else if(nv == "1"){
	    		  $scope.event.querySingleOopt({id: 0, name: ''});
	    		  $scope.Question.model.questionnaire.orgName = null;
	    		  $scope.Question.model.questionnaire.orgId = null;
	    	  }
	      });
		  $scope.Question.init();
}).filter("index", [
                    function() {
                        return function(array) {
                          return (array || []).map(function(item, index) {
                            item.order = index;
                            return item;
                          });
                        };
                      }
                    ]);



// 互换题目位置的动画
app.animation('.my-crazy-animation', function() {
	  return {
	    move: function(element, done) {
	    	var height1 = element[0].offsetHeight;
	    	var height2 = element[0].nextElementSibling.offsetHeight;
	    	
	    	element.css({
	        position: "relative",
	        top: height1 + 20,
	      })
	      .animate({
	        top: 0,
	        }, 1000);
	    	
	      $(element[0].nextElementSibling).css({
	        position: "relative",
	        top: -height2 - 20,
	      })
	      .animate({
	        top: 0,
	        }, 1000, done);
	    }
	  };
	});

app.directive('ensureUnique', ['$http', function($http) {
	  return {
	    require: 'ngModel',
	    link: function(scope, ele, attrs, c) {
	      scope.$watch(attrs.ngModel, function(n) {
	    	c.$setValidity('unique', true);
	    	if (!n || scope.operate !='create') return;
	    	
	    	transFn = function(data) {
                return $.param(data);
            },
            postCfg = {
                headers: { 'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
                transformRequest: transFn
            };
            $http.post("checkNameUnique", {
	        	   name: attrs.ensureUnique,
 	        	   orgId: getScope().Question.model.questionnaire.orgId ? getScope().Question.model.questionnaire.orgId : 0
 	        	   }, postCfg).success(function(msg, status, headers, cfg) {
 	        		   if(msg.content)
 	        			   alert(msg.content);
 		 	           c.$setValidity('unique', msg.data);
 		 	        }).error(function(msg, status, headers, cfg) {
 		 	           c.$setValidity('unique', false);
 		 	        });
	      });
	    }
	  }
	}
]);

app.directive('myunique',function(){
  return {
      restrict:"A",
      require:"ngModel",
      link:function(scope,ele,attrs,ngModelController){
          ngModelController.$parsers.push(function(viewValue){        	  
//        	  	var result = false;
//          	
//          	$(scope.Question.model.questionnaire.mfq1s).each(function(i, question) {
//				if(question.proDesc == viewValue) {
//					result = true;
//				}
//			});
//          	ngModelController.$setValidity('myunique',!result);
             return viewValue;
          });
      }
  }
});

app.directive('nochar',function(){
	  return {
	      restrict:"A",
	      require:"ngModel",
	      link:function(scope,ele,attrs,ngModelController){
	          ngModelController.$parsers.push(function(viewValue){
	          	
	        	  var pattern = new RegExp("[\t]")
	        	  var rs = "";
	        	  for (var i = 0; i < viewValue.length; i++) { 
	        		  rs = rs+viewValue.substr(i, 1).replace(pattern, ' '); 
	        		  } 
//	        	  console.log(rs);
	             return rs;
	          });
	      }
	  }
	});

function querySingleOopt(treeNode){
	getScope().event.querySingleOopt(treeNode);
}
function getScope(){
	return angular.element(document.querySelector('[ng-controller=QuestionListCtrl]')).scope();
}