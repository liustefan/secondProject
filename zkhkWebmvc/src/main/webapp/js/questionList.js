var app = angular.module('questionList', [], function($httpProvider){
});

app.controller('questionCtrl', function ($scope, $http, $filter) {
	$scope.checkAnswer= function(answer, question) {
			//  将作答过的问题添加到列表
			//addAnswerQuestion(question);
			//  将所关联的问题隐藏
			if(question.ansType == 1) {	// 单选题
				// 显示其他答案所关联的问题
				angular.forEach(question.logicses, function(logic){
					
					if(logic.answerId !== answer.ansid){
						angular.forEach(logic.problemIds, function(pId){
							// 显示所有答案所关联的问题  排除其他问题干扰
							if(isSetted(pId) === 0) {
								setQuestionStatus($scope.questionnaire.mfq1s[pId-1], true);	
							}
						});
					}
				});
				$(question.logicses).each(function(i, logic) {
					if(logic.answerId === answer.ansid){
						angular.forEach(logic.problemIds, function(pId){
							// 隐藏当前答案所关联的问题
							if(isSetted(pId) <= 1) {
								setQuestionStatus($scope.questionnaire.mfq1s[pId-1], false);	
							}
						});
					}
				});
			}else {		// 多选题
				$(question.logicses).each(function(i, logic) {
					if(logic.answerId === answer.ansid){
						angular.forEach(logic.problemIds, function(pId){
							if(isSetted(pId) <= 1) {
								setQuestionStatus($scope.questionnaire.mfq1s[pId-1], !question.useranswer[answer.ansid-1]);
							}
						});
					}
				});
			}
			
	}
	$scope.event = {
			setOmfq:  function(omfq){
				// 设置问题的答案
				angular.forEach(uai21, function(u, index){
					if(omfq.mfq1s[u.problemid-1].ansType == 2){	// 多选
						if(!omfq.mfq1s[u.problemid-1].useranswer)
							omfq.mfq1s[u.problemid-1].useranswer = {};
						omfq.mfq1s[u.problemid-1].useranswer[u.ansid-1] = true;
					}else{	// 单选
						omfq.mfq1s[u.problemid-1].useranswer = u.ansid;
					}
				});
				$scope.questionnaire = omfq;
				//  设置问题是否显示
				angular.forEach($scope.questionnaire.mfq1s, function(obj, index) {
					if(isSetted(obj.problemid) > 0) {
						$scope.questionnaire.mfq1s[index].isShow = false;
					}
				});
			},
			submit: function(tag){
				 var json = this.constructData(tag);
				 if(json){
					 $http.post(href,{
						 qustid: $scope.questionnaire.qustid,
						 ansNumber: ansNumber, 
						 qustTag: tag,
						 uai21s: json,
						 combQustId: combQustId
						 }).success( function(response) {
						  if(response.status){
							  alert("保存成功！");
							  window.location.href = response.content + (combQustId ? '&' : '?') + 'memberid=' + memberId;
						  }else{
							  alert("保存失败！");
						  }
			         });
				 }
			},
			constructData: function(tag){//构造数据
				var uai21 = [], questionCount = 0, hasAnswerQuestion = 0;
				
				angular.forEach($scope.questionnaire.mfq1s, function(q, index){
					if(q.isShow !== false) {
						questionCount ++;
					}
					if(q.useranswer){
						if(angular.isObject(q.useranswer)){
							//  记录此多选题是否已经作答 
							var hasAnswer = false;
							
							angular.forEach(q.useranswer, function(u, i){
								if(u){
									hasAnswer = true
									uai21.push({ansNumber:ansNumber,problemid:q.problemid,ansid:parseInt(i)+1,score:q.mfq11s[parseInt(i)].score});
								}
							});
							if(hasAnswer) {
								hasAnswerQuestion ++;
							}
						}else{
							hasAnswerQuestion ++;
							uai21.push({ansNumber:ansNumber,problemid:q.problemid,ansid:q.useranswer,score:q.mfq11s[q.useranswer-1].score});
						}
					}
				});
				// 判断用户是否有作答
				if(uai21.length === 0){
					 if(tag == 'T')
						 alert("请作答！");
					 else
						 alert("无作答记录，无需暂存！");
					 return;
				}
				
				// 判断用户是否做答完全
//				console.log(hasAnswerQuestion, questionCount);
				if(hasAnswerQuestion !== questionCount && tag == 'T')  {
					 alert("请答完全部题目再提交！");
					 return;
				}
				return uai21;
//				return JSON.stringify(uai21);
			}
	};
	
	$scope.event.setOmfq(omfq);
	
	// 判断问题是否已经被控制
	function isSetted(qid) {
		var count = 0;
		//循环所有问题
		$($scope.questionnaire.mfq1s).each(function(i, q) {
			// 循环所有问题逻辑
			angular.forEach(q.logicses, function(logic){ 
				// 如果问题有作答过 单选题 或者 多选题
				if(q.mfq11s[logic.answerId-1].ansid == q.useranswer || (angular.isObject(q.useranswer) && q.useranswer[logic.answerId-1])){
					// 循环这个问题的逻辑 看是否关联到 qid 
					angular.forEach(logic.problemIds, function(pId){
						if(pId === qid)
							count++;
					});
					
				}
			});
			
		});
		return count;
	}
	
	// 设置问题 及其所关联的问题 的显示和隐藏
	function setQuestionStatus(question, action) {
//		console.log(question, action);
		//	判断此问题是否已经被其他答案所关联
		if(question) {
			$(question.mfq11s).each(function(i, answer) {
				// 如果问题的选项有被修改 并且关联了其他问题
				if(answer.ansid == question.useranswer) {
					//	先将问题的勾选清除 然后将选项关联的其他问题显示
					if(!action) {
						question.useranswer = null;
					}
					
					$(question.logicses).each(function(i, logic) {
						if(logic.answerId === answer.ansid){
							angular.forEach(logic.problemIds, function(pId){
								setQuestionStatus($scope.questionnaire.mfq1s[pId-1], !action);
							});
						}
					});
				}
				
			});
		
			question.isShow = action;
		}
	}
	
});