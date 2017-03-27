<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>组合答卷</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/css/questionnaire.css">	
	<link rel="stylesheet" href="<%=path %>/js/showloading/showLoading.css">
	<link rel="stylesheet" href="<%=path %>/js/skins/blue.css">
		
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.PrintArea.js"></script>
	<script type="text/javascript" src="<%=path %>/js/showloading/jquery.showLoading.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.artDialog.js"></script>

	<style type="text/css">
	.btn-green2 {
		width: 100px; 
		height: 30px; 
		line-height: 28px; 
		color: #333333;
	}
	
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
		border:1px solid #ddd;
		background:	#f6f6f6;
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
		if($(".toAnswer").length == 0){
			$("#submit").removeAttr("disabled").removeClass("btn-green2").addClass("btn-green");
		}
		$("#submit").click(function(){
			$.ajax({
				url:'../answer/answer!submitOcam',
				data:{'ocam.combAnsid':'${ocam.combAnsid}'},
				success:function(message){
					alert(message.content);
					if(message.status)
						window.location.href="../answer/ouai!listGroup";
				}
			});
		});
	  	$('.printBtn').click(function(){
		    var data;
		  	if(this.getAttribute("data")){
		  		data = "ansNumbers="+this.getAttribute("data");
		  	}else{
		  		var checkedRows = $("input[name='ansNumbers']:checked");
				data = $.param(checkedRows);
				if(!data){
					alert("请选择答卷");
					return;
				}
		  	}
		  	window.location.href="../answer/answer!queryPrintOuaiInfoByAnsIds?"+data;
	  	});
	  	$(".back").click(function(){
	  		window.location.href="../answer/ouai!listGroup";
	  	});
	});
	</script>
</head>
<body>
<div class="content clearfix">
	<div class="content-title">
		组合答卷列表 --- <c:if test="${pojo.combTag == 0}">作答</c:if><c:if test="${pojo.combTag != 0}">查看</c:if>
	</div>
	<div class="table-box">
		<table class="table-content">
		    <thead class="table-title">
    		<tr>
    		    <th width="10%">答卷编号</th>
				<th width="10%">答卷名称</th>
				<th width="10%">状态</th>
				<th width="10%">操作</th>
			</tr>
			</thead>
			<tbody>
			<c:if test="${fn:length(pojo.cam1s) == 0}">
				<tr>
					<td colspan="6">
						<div class="empty-info">没有满足条件的单份答卷</div>
					</td>
				</tr>
			</c:if>
			<c:if test="${fn:length(pojo.cam1s) > 0}">
				<c:forEach items="${pojo.cam1s}" var="cam1">
					<tr>
					    <td>${cam1.ouai.ansNumber}</td>
						<td><c:out value="${cam1.ouai.omfq.qustname}" escapeXml="true"/></td>
						<td id="table_content_title_td">
							<c:choose>
								<c:when test='${cam1.ouai.qustTag == "T"}'>已作答</c:when>
								<c:when test='${cam1.ouai.qustTag == "C"}'>已审核</c:when>
								<c:when test='${cam1.ouai.qustTag == "B"}'>作答中</c:when>
								<c:otherwise>
									未作答
								</c:otherwise>
							</c:choose>
						</td>
						<td>
							<c:choose>
								<c:when test='${cam1.ouai.qustTag == "T" || cam1.ouai.qustTag == "C"}'>
									<a class="toView" href="../singleAnswer/answerView?ansNumber=${cam1.ouai.ansNumber}&combAnsId=${pojo.combAnsid}">
										查看
									</a>
								</c:when>
								<c:when test='${cam1.ouai.qustTag == "B"}'>
									<a class="toAnswer" href="../singleAnswer/answerInfo?ansNumber=${cam1.ouai.ansNumber}&combAnsId=${pojo.combAnsid}">
										继续作答
									</a>
								</c:when>
								<c:otherwise>
									<a class="toAnswer" href="../singleAnswer/answerInfo?ansNumber=${cam1.ouai.ansNumber}&combAnsId=${pojo.combAnsid}">
										作答
									</a>
								</c:otherwise>
							</c:choose>
	    				</td>
					</tr>
				</c:forEach>
			</c:if>
			</tbody>
		</table>
	 </div>
	 <c:if test="${not empty pojo.cam2}">
	 	<div class="result-list-box">
			<div class="caption-title">诊断</div>
			<div class="result-list">
					${pojo.cam2.diagnosis}<br/>
			</div>
        </div>
		<div class="result-list-box">
			<div class="caption-title">审核结果</div>
			<div class="result-list">
				<ol>
					<li class="audit-box" style="padding-bottom: 5px;">
						<div class="audit-content">审核医生：${pojo.cam2.doctor.docname}</div>
						<div class="audit-content">审核级别：${pojo.cam2.auditLevel}</div>
						<div class="audit-content">审核内容：${pojo.cam2.auditDesc}</div>
						<div class="audit-content">审核时间：<fmt:formatDate value="${pojo.cam2.auditTime}" type="both" dateStyle="default" timeStyle="default"/></div>
					</li>
				</ol>
			</div>
       </div><br/>
       <div class="fr">审核医生：
	       	<img width="50" src="<%=path %>/image/getImage?uniqueId=${pojo.cam2.doctor.signaddress}"/>
       </div>
     </c:if>
	<div class="page-box">
		<input type="button" class="btn-inquiry" value="返回" onclick="history.go(-1)"/>
	</div>
</div>
<iframe class="printIframe" style="display: none;"></iframe>
</body>
</html>
