<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>组合答卷打印预览</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/css/vip.css">
	<link rel="stylesheet" href="<%=path %>/css/questionList.css">
	
	<script src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	
	<style type="text/css">
	body {
		font-size: 14px;
	}
	
	.answer-show {
		font-family: "Microsoft YaHei";
		font-size: 14px;
		color: #333;
		padding: 20px;
	}
	
	.answer-show .empty-info {
		font-size: 14px;
		padding: 10px 0;
		color: #999;
	}
	
	.answer-box {
		background: #f6ff6;
		border: 1px solid #ddd;
		padding: 20px;
	}
	
	.answer-box ol {
		width: 80%;
		margin: 0 auto;
	}
	
	.anwer-conclusion {
		padding: 15px 0; 
		font-size: 1.2em;
	}
	
	.anwer-conclusion li {
		font-size: 14px;
	}
	
	.anwer-list li {
		padding: 5px 0px; 
		font-size: 12px; 
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
	
	.ques-user-info span {
		display: inline-block;
		font-size: 14px;
		width: 30%;
	}
	
	.checked {
		background-color: #666666;
		color: #fff;
	}
	</style>

	<script type="text/javascript">
		$(function(){
			$('#print').click(function(){
				window.location.href="downWord?1=1<c:forEach items='${combAnsIds}' var='combAnsId'>&combAnsIds=${combAnsId}</c:forEach>";
			});
		});
	</script>
</head>
<body>
<div class="content">
<div class="content-title">组合答卷列表 --- 打印</div>
<div class="question-list-wrapper">
	<c:if test="${fn:length(baseCInfos)==0}">
		<div class="question-list-box">
			<p class="red">数据不全,无法打印</p>
		</div>
	</c:if>
	<c:forEach items="${baseCInfos}" var="baseCInfo">
	<div class="question-list-box clearfix">
		<c:forEach items="${baseCInfo.ouais}" var="baseInfo">
			<div class="mg-left-5">
				<h1 style="font-size:1.5em;font-weight: bold;">医院名称：${userInfo.orgName}</h1>
                <h2 class="ques-name">${baseInfo.omfq.qustname}</h2>
				<div class="ques-user-info">
					   <span><b>姓名：</b>${baseInfo.member.memname}</span>
					   <span><b>性别：</b>${baseInfo.member.gender=='1'?'男':baseInfo.member.gender=='2'?'女':'未知'}</span>
					   <span><b>年龄：</b>${baseInfo.memberAge}</span>
					   <span><b>答卷ID：</b>${baseInfo.ansNumber}</span>
					   <span></span>
					   <span><b>答卷时间：</b><fmt:formatDate value="${baseInfo.answerTime}" type="both" dateStyle="default" timeStyle="default"/></span>
				</div>
				  <ol class="">
					<c:forEach items="${baseInfo.omfq.mfq1s}" var="mfq1" varStatus="status">
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
			    <div class="anwer-conclusion">
					<ol>
					     <li><b>结果得分：</b> ${baseInfo.uai4.score}分</li>
					</ol>
				</div>
			 	<div class="ques-explain">
				    <h2>问卷分析：</h2>
				    <c:forEach items="${baseInfo.omfq.mfq21s}" var="mfq21">
						 <p>得分${mfq21.minScore}~${mfq21.maxScore}分，${mfq21.conclusion}</p>
					</c:forEach>
				</div>
				<br/>
			</div>
		</c:forEach>
		<h1 style="font-size:24px;">医院名称：${userInfo.orgName}</h1>
		<h2 class="ques-name">${baseCInfo.combQustName}</h2>
		<div class="ques-user-info">
			   <span><b>答卷人：</b>${baseCInfo.member.memname}</span><span></span>
			   <span><b>答卷时间：</b><fmt:formatDate value="${baseCInfo.answerTime}" type="both" dateStyle="default" timeStyle="default"/></span>
		</div>
		<div class="result-list-box">
			<div class="caption-title">诊断</div>
			<div class="result-list">
					${baseCInfo.cam2.diagnosis}<br/>
			</div>
        </div>
		<div class="result-list-box">
			<div class="caption-title">审核结果</div>
			<div class="result-list">
				<ol>
					<li class="audit-box" style="padding-bottom: 5px;">
						<div class="audit-content">审核医生：${baseCInfo.cam2.doctor.docname}</div>
						<div class="audit-content">审核级别: ${baseCInfo.cam2.auditLevel}</div>
						<div class="audit-content">审核内容：${baseCInfo.cam2.auditDesc}</div>
						<div class="audit-content">审核时间: <fmt:formatDate value="${baseCInfo.cam2.auditTime}" type="both" dateStyle="default" timeStyle="default"/></div>
					</li>
				</ol>
			</div>
       </div><br/>
       <div class="fr">审核医生：
	       	<img width="50" src="<%=path %>/image/getImage?uniqueId=${baseCInfo.cam2.doctor.signaddress}"/>
       </div>
     </div>
	</c:forEach>
	<div class="page-box">
		<c:if test="${fn:length(baseCInfos)>0}">
			<input type="button" class="btn-normal" id="print" value="打印"/>
		</c:if>
		<input type="button" class="btn-normal" value="取消" onclick="history.go(-1)"/>
	</div>
</div>
</div>
</body>
</html>