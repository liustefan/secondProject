<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html ng-app="questionList">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>问题列表</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/css/questionList.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/angular.js"></script>
	<script type="text/javascript" src="<%=path %>/js/questionList.js"></script>
	<script type="text/javascript">
		var omfq = ${omfq};
		var ansNumber = '${ansNumber}';
		var combQustId = '${combAnsId}';
		var uai21 = ${uai21};
		var href = "${empty combAnsId ? 'answer' : '../comAnswer/answer'}";
		var memberId = '${param.memberId}';
	</script>
</head>
<body ng-controller="questionCtrl">
<div class="content">
	<div class="content-title">单份答卷列表 --- 作答</div>
	<form action="answer!answer" class="question-list-wrapper" method="post">
		<div class="question-list-box" >
			<h3 class="question-name">{{questionnaire.qustname}}</h3>
			<div id="q_{{$index}}" class="question-warpper" ng-class="{false: 'inactive'}[question.isShow]" ng-repeat="question in questionnaire.mfq1s">
				<p class="question-body">{{$index+1}}. {{question.proDesc}} {{question.ansType == '1'?'[单选]':'[多选]'}}</p>
				<ul class="answer-box clearfix">
					<li ng-if="question.ansType == '1'" ng-repeat="answer in question.mfq11s">
						<label>
							<input type="radio" class="input-center" value={{$index+1}} ng-disabled="question.isShow != undefined && !question.isShow" ng-model="question.useranswer" ng-click="checkAnswer(answer, question)">
							<span class="span-center">{{answer.mark}}. {{answer.description}}</span>
						</label>
					</li>
					<li ng-if="question.ansType == '2'" ng-repeat="answer in question.mfq11s">
						<label>
							<input type="checkbox" class="input-center" value={{$index+1}} ng-disabled="question.isShow != undefined && !question.isShow" ng-model="question.useranswer[$index]" ng-click="checkAnswer(answer, question)">
							<span class="span-center">{{answer.mark}}. {{answer.description}}</span>
						</label>
					</li>
				</ul>
			</div>
		</div>
		<div class="page-box">
			<input type="button" class="btn-inquiry" id="save" ng-click="event.submit('B')" value="暂存">
			<input type="button" class="btn-inquiry" id="save" ng-click="event.submit('T')" value="提交">
			<input type="button" class="btn-inquiry" value="取消" onclick="history.go(-1)">
		</div>
	</form>
</div>
</body>
</html>