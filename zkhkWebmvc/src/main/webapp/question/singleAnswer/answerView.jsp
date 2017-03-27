<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>查看单份答卷</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/css/vip.css">
	<link rel="stylesheet" href="<%=path %>/css/questionList.css">
	<link rel="stylesheet" href="<%=path %>/js/showloading/showLoading.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.PrintArea.js"></script>
	<script type="text/javascript" src="<%=path %>/js/showloading/jquery.showLoading.min.js"></script>
	
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
	$(function() {
		$('#print').click(function(){
			window.location.href = "queryPrintQuestionInfoByIds?ansNumbers=${param.ansNumber}";
		});
	});
	
	//医生签名没有图片的时候，加载一个默认图片（此处加载的为1*1px透明图）
	function nofind(){
	var img=event.srcElement;
	img.src="<%=basePath%>/img/namedefault.png";
	img.onerror=null; //控制onerror事件只触发一次 
	}
	</script>
</head>
<body>
<div class="content">
	<c:choose>
   		<c:when test="${not empty param.title}">
   			<div class="content-title">${param.title}任务---查看</div>查看问卷
   		</c:when>
   		<c:otherwise>
   			<div class="content-title">单份答卷列表 --- 查看</div>
   		</c:otherwise>
   	</c:choose>
	<form action="audit" method="post">
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
				<ol class="">
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
							<c:if test="${empty mfq1.uai21s}">
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
			<c:if test="${not empty pojo.uai3}">
				<div class="result-list-box">
					<div class="caption-title">诊断</div>
					<div class="result-list">
								${pojo.uai3.diagnosis}<br/>
					</div>
		        </div> 
	        </c:if>
			<c:if test="${not empty pojo.uai3}">
			<div class="result-list-box">
				<div class="caption-title">审核结果列表</div>
				<div class="result-list">
					<ol>
						<li class="audit-box">
						<div class="audit-content">${pojo.uai3.auditDesc}</div>
						<div class="audit-foot clearfix">
							<div class="fl">审核级别: ${pojo.uai3.auditLevel}</div>
							<div class="fl">审核时间：<fmt:formatDate value="${pojo.uai3.auditTime}" type="both" dateStyle="default" timeStyle="default"/></div>
							<div class="fr doc-sign">审核医生：${pojo.uai3.doctor.docname}
								&nbsp;&nbsp;&nbsp;&nbsp;
						  		<img src="<%=path %>/image/getImage?uniqueId=${pojo.uai3.doctor.signaddress}" onerror="nofind();"/>
							</div>
						</div>
						</li>
					</ol>
				</div>
	      	</div> 
			</c:if>
			<br/>
			<c:if test="${pojo.qustTag eq 'C'}">
				<input type="button" value="打印答卷" id="print" class="btn-normal"/>
			</c:if>
			<input type="button" class="btn-normal" value="返回" onclick="history.go(-1)"/>
		</div>
	</form>
	<iframe class="printIframe" style="display: none;"></iframe>
</div>
</body>
</html>