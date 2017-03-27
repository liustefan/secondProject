<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>单份答卷答案列表</title>
	<link rel="stylesheet" href="<%=path %>/css/questionnaire.css">
	<link rel="stylesheet" href="<%=path %>/css/questionList.css">
	<link rel="stylesheet" href="<%=path %>/css/vip.css">
	<link rel="stylesheet" href="<%=path %>/js/kindeditor/themes/default/default.css">
	<link rel="stylesheet" href="<%=path %>/css/reset.css">
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/kindeditor/kindeditor-min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/popupPage1.js"></script>
	<script type="text/javascript" src="<%=path %>/js/kindeditor/lang/zh_CN.js"></script>
	
	<style type="text/css">
	.answer-show {
		width: 100%;
		overflow: hidden;
		margin: 0 auto;
		font-family: "Microsoft YaHei";
		font-size: 13px;
		color: #333;
	}
	
	.answer-show .empty-info {
		font-size: 14px;
		padding: 10px 0;
		color: #999;
	}
	
	.answer-box {
		background: #F6F6F6;
		border: 1px solid #ddd;
		padding: 20px;
	}
	
	.answer-box ol {
		margin-left: 15%;
	}
	
	.ques-explain {
		margin-left: 8%;
	}
	
	.anwer-conclusion {
		padding: 1em 2em; 
		background: #fcf8e3;
	}
	
	.anwer-conclusion li {
		font-size: 15px;
	}
	
	.reslut {
		margin-left: 2em;
	}
	
	.anwer-list li {
		padding-top: 8px; 
		font-size: 13px; 
		text-indent: 2em;
	}
	
	.anwer-result-title {
		margin-top: 10px;
		padding: 5px 0px;
		font-weight: bold;
	}
	
	.caption-title {
		border-top-left-radius: 3px;
		border-top-right-radius: 3px;
		background: #bcdee0;
		height: 35px;
		text-align: left;
		font-weight: bold;
		color: #333;
		font-size: 14px;
		line-height: 35px;
		text-indent: 1em;
	}
	
	.result-list-box {
		width: 100%;
		margin: 0 auto;
		margin-top: 20px;
	}
	
	.result-list {
		padding: 15px;
		font-size: 13px;
		border: 1px solid #ddd;
	}
	
	.result-list ol li {
		font-size: 14px;
		color: #333;
		margin: 7px 0;
	}
	
	.result-list ol li img {
		max-width: 64px;
		max-height: 64px;
		border: none;
		outline: none;
		vertical-align: middle;
	}
	
	.sz-answer-box {
		border: 1px solid #ddd;
		background: #f6f6f6;
	}
	
	.sz-answer-box ol {}
	
	.checked {
		background-color: #666666;
		color: #fff;
	}
	</style>
	
	<script type="text/javascript">
		var memberid = "${oasr.memberid}";
		var reportNo = "${oasr.reportNo}";
		var basePath = "<%=basePath%>";
	// 	var userInfo_orgId = ${empty userInfo.dept_id} ? 0 : ${userInfo.dept_id}+0;
		KindEditor.ready(function(K) {
			
			window.editor = K.create('#myAdvice', {
				height : '300px',
				width : '100%'
	// 			orgid: userInfo_orgId
			});
			
		});
	$(function() {
		$(".btn-blue").click(function(){
		$(".reason-box").toggle();
		});
	});
	
	function checkAudit(){
		if($('textarea[name="diagnosis"]').val().length ==0){
			alert('诊断内容不能为空');
			return false;
		}
		if($('textarea[name="diagnosis"]').val().length>100){
			alert('诊断内容长度不能大于100');
			return false;
		}
		$('#myAdvice').val(editor.html());
		if(editor.count('text') == 0){
			alert('审核意见不能为空');
			return false;
		}
		if(editor.count('text') > 1000){
			alert('审核内容不能够超过1000字符!');
			return false;
		}
		return true;
	}
	//医生签名没有图片的时候，加载一个默认图片（此处加载的为1*1px透明图）
	function nofind(){
	var img=event.srcElement;
	img.src="<%=path%>/img/namedefault.png";
	img.onerror=null; //控制onerror事件只触发一次 
	}
	</script>
</head>
<body>
<div class="content">
<div class="content-title">待审核单份答卷列表 --- 审核</div>
<form action="audit" onsubmit="return checkAudit();" method="post">
	<input type="hidden" id="serialNumber" name="serialNumber" value="${serialNumber}" /> <!-- 进度流水号 -->
	<input type="hidden" name="ansNumber" value="${pojo.ansNumber}" />
	<input type="hidden" name="memberId" value="${pojo.member.memberid}" />
	<input type="hidden" name="content" value="${pojo.omfq.qustname}" />
	<input type="hidden" name="type" value="${pojo.omfq.ansMode}" />
    <div class="answer-show">
	        <div class="answer-box">
				<h3 class="question-name">${pojo.omfq.qustname}</h3>
				<div class="ques-user-info">
					   <span><b>姓名：</b>${pojo.member.memname}</span>
					   <span><b>性别：</b>${pojo.member.gender eq 1 ? '男' : pojo.member.gender eq 2 ? '女' : '未知'}</span>
					   <span><b>年龄：</b>${pojo.memberAge}</span>
					   <span><b>答卷ID：</b>${pojo.ansNumber}</span>
					   <span></span>
					   <span><b>答卷时间：</b><fmt:formatDate value="${pojo.answerTime}" type="both" dateStyle="default" timeStyle="default"/></span>
				</div>
				<ol>
					<c:forEach items="${pojo.omfq.mfq1s}" var="mfq1" varStatus="status">
							<c:if test="${not empty mfq1.uai21s}">
							<li class="question-title">
								${status.index+1}、<c:out value="${mfq1.proDesc}" escapeXml="true"/>【
								<c:if test="${mfq1.ansType eq 1}">单选</c:if>
								<c:if test="${mfq1.ansType eq 2}">多选</c:if>
								】
							</li> <!-- 题目内容 -->
							<ul class="anwer-list">
								<li>
									<c:forEach items="${mfq1.mfq11s}" var="mfq11">
										<span 
										<c:forEach items="${mfq1.uai21s}" var="uai21">
											<c:if test="${uai21.ansid eq mfq11.ansid}">class="checked"</c:if>
										</c:forEach>
										>${mfq11.mark}、<c:out value="${mfq11.description}" escapeXml="true"/>&nbsp;</span>
									</c:forEach>
								</li>
								<li>
									<c:forEach items="${mfq1.uai21s}" var="uai21">
										<span>&nbsp;&nbsp;选择&nbsp;
										<c:forEach items="${mfq1.mfq11s}" var="mfq11">
											<c:if test="${uai21.ansid eq mfq11.ansid}">${mfq11.mark}</c:if>
										</c:forEach>
										&nbsp;(得 ${uai21.score}分)</span>
									</c:forEach>
								</li>
							</ul>
							</c:if>
					</c:forEach>
				</ol>
				<div class="ques-explain">
				    <h2>说明：</h2>
				    <c:forEach items="${pojo.omfq.mfq21s}" var="mfq21">
						<p>得分${mfq21.minScore}~${mfq21.maxScore}分，${mfq21.conclusion}</p>
					</c:forEach>
				</div>
			</div>
			<div class="anwer-conclusion">
				<ol>
				    <li><b>答卷总得分：</b> ${pojo.uai4.score}分</li>
					<li class="reslut"><b>结论：</b>${pojo.uai4.conclusion}</li>
				</ol>
			</div>
			<div class="result-list-box">
				<div class="caption-title">诊断</div>
				<div class="result-list">
					<ol>
						<li>
						   <textarea class="w100-txtarea" name="diagnosis" placeholder="单击此处填写诊断意见...">${audit.diagnosis}</textarea>
						</li>
					</ol>
				</div>
		    </div>
			<div class="result-list-box">
			    <div class="caption-title clear-fix">
			         <span class="fl">审核意见</span>
			         <div class="fr">
			              <input type="button" value="载入审核意见模板" id="loadTemplate" class="btn-normal" onclick="popup(${userInfo.dept_id},2);"/>&nbsp;&nbsp;
			         </div>
			    </div>
				<div style="border:1px solid #ddd; padding:15px;">
					 <textarea name="auditDesc" cols="30" readonly="readonly" id="myAdvice" rows="8" class="w100-txtarea" placeholder="审核意见..."></textarea>
			       <br/>
			       <input name="submit" type="submit" value="提交审核" class="btn-normal" style="margin:10px 0;"/>
				</div>	
			</div>
 	</div>
</form>
</div>
</body>
</html>