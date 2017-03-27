<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>查看已执行任务</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">

	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<style>
		.info-date {
		    width: 90px;
		    background: url("<%=path %>/img/u17.png") no-repeat scroll right center white;
		    background-size: 15px 15px;
		    padding-top: 3px;
		    padding-bottom: 3px;
		    background-origin: content-box;
		    border: 1px solid #a9a9a9;
		}
		
		.detail-box {
			margin: 20px 0;
		    padding: 15px;
		    border: 1px solid #ccc;
		    font-size: 14px;
		    line-height: 28px;
		    background-color: #eff1f0;
		}
		
		.main-box {
			border: 1px solid #98cc6b;
		}
		
		.main-box ul li {
			margin: 15px 8px;
		}
		
		.fix-label {
			text-align: right;
			font-size: 14px;
			width: 120px;
			margin-right: 10px;
			font-weight: bold;
		}
		
		.mg-right {
			margin-right: 50px;
		}
		
		.mg-right1 {
			margin-right: 2%;
		}
		
		.text-top {
	        vertical-align: text-top;
	    }
	    
	    .task-title {
	    	height: 30px;
	    	line-height: 30px;
	    	color: #007735;
	    	background: #f2f1f1;
	    	font-weight: bold;
	    	padding-left: 8px;
	    	font-size: 14px;
	    }
	    
	    .div-block {
	    	display: inline-block;
	    }
	    
	    .blue {
	    	color: #0000ff;
	    }
	    
	    .Wdate {
	    	width: 140px;
	    }
	    
	    .width-fl {
	    	width: 85%;
	    }
	    
	    .width-fr {
	    	text-align: center;
		    width: 15%;
		    line-height: 56px;
	    }
	    
	    .width-label {
	    	width: 120px;
	    	text-align: left;
	    }
	</style>
</head>
<body>
<div class="content">
	<div class="content-title">
		${pojo.execStatus eq 1 ? '待执行' : pojo.execStatus eq 2 ? '已执行' : '已终止'}任务--- 查看
	</div>
    <form action="" method="POST" id="">
		<div class="main-box">
			<div class="task-title">查看${pojo.execStatus eq 1 ? '待执行' : pojo.execStatus eq 2 ? '已执行' : '已终止'}任务</div>
				<ul class="clearfix">
					<li>
						<label class="fix-label">计划执行时间：</label>
		                <label class="width-label"><fmt:formatDate value='${pojo.planTime}' pattern="yyyy-MM-dd"/></label>
		                <label class="fix-label">实际执行时间：</label>
		                <span><fmt:formatDate value='${pojo.execTime}' pattern="yyyy-MM-dd HH:mm:ss"/></span>
					</li>
					<li>
						<label class="fix-label">执行医生：</label>
		                <label class="width-label">${pojo.design.execDrName}</label>
		                <c:if test="${pojo.designTask.taskType ne 7}">
		                <label class="fix-label">执行方式：</label>
		                <span>${pojo.designTask.execWayName}</span>
		                </c:if>
					</li>
					<li>
						<label class="fix-label">任务类型：</label>
		                <span>${pojo.designTask.taskTypeName}</span>
					</li>
					<li>
						<label class="fix-label">任务概述：</label>
		                <span>${pojo.designTask.summary}</span>
					</li>
					<c:choose>
					<c:when test="${pojo.designTask.taskType eq 1}">
						<li>
							<label class="fix-label">详情内容：</label>
			                <span><a href="getHealthEducationDetail?id=${pojo.designTask.taskRefID}">点击查看</a></span>
						</li>
						<c:if test="${pojo.designTask.execWay ne 3}">
							<li>
								<label class="fix-label">任务执行结果：</label>
				                <span>${pojo.execResult}</span>
							</li>
						</c:if>
					</c:when>
					<c:when test="${pojo.designTask.taskType eq 2 || pojo.designTask.taskType eq 3}">
						<li>
							<label class="fix-label">任务说明：</label>
			                <span>${pojo.designTask.content}</span>
						</li>
						<c:if test="${pojo.designTask.execWay ne 3}">
						<li>
							<label class="fix-label">任务执行结果：</label>
			                <span>${pojo.execResult}</span>
						</li>
						</c:if>
					</c:when>
					<c:when test="${pojo.designTask.taskType eq 4}">
						<li>
							<label class="fix-label">执行问卷：</label>
							<c:choose>
								<c:when test="${pojo.ref.done}">
									<span>${pojo.designTask.taskRef.name}(已填写)<button type="button" class="btn-cancel" onclick="window.location.href='answerView?MSETaskID=${pojo.MSETaskID}&qustId=${pojo.designTask.taskRef.id}&memberId=${pojo.exec.memberID}&title=${pojo.execStatus eq 1 ? '待执行' : pojo.execStatus eq 2 ? '已执行' : '已终止'}'">查看</button></span>
								</c:when>
								<c:otherwise>
									<span>${pojo.designTask.taskRef.name}(未填写)<button type="button" class="btn-cancel" onclick="window.location.href='answerView?MSETaskID=${pojo.MSETaskID}&qustId=${pojo.designTask.taskRef.id}&memberId=${pojo.exec.memberID}&title=${pojo.execStatus eq 1 ? '待执行' : pojo.execStatus eq 2 ? '已执行' : '已终止'}'">查看</button></span>
								</c:otherwise>
							</c:choose>
						</li>
						<c:if test="${pojo.designTask.execWay ne 3}">
						<li>
							<label class="fix-label">任务执行结果：</label>
			                <span>${pojo.execResult}</span>
						</li>
						</c:if>
					</c:when>
					<c:when test="${pojo.designTask.taskType eq 5}">
						<c:if test="${pojo.designTask.execWay ne 3}">
						 	<li>
								<label class="fix-label">高血压随访结果：</label>
								<span>高血压随访表(已填写)<button type="button" class="btn-cancel" onclick="window.location.href='hypertensionView?MSETaskID=${pojo.MSETaskID}&title=${pojo.execStatus eq 1 ? '待执行' : pojo.execStatus eq 2 ? '已执行' : '已终止'}'">查看</button></span>
							</li>
							<li>
								<label class="fix-label">任务执行结果：</label>
				                <span>${pojo.execResult}</span>
							</li>
						</c:if>
					</c:when>
					<c:when test="${pojo.designTask.taskType eq 6}">
						<c:if test="${pojo.designTask.execWay ne 3}">
							<li>
								<label class="fix-label">糖尿病随访结果：</label>
								<span>糖尿病随访表(已填写)<button type="button" class="btn-cancel" onclick="window.location.href='diabetesView?MSETaskID=${pojo.MSETaskID}&title=${pojo.execStatus eq 1 ? '待执行' : pojo.execStatus eq 2 ? '已执行' : '已终止'}'">查看</button></span>
							</li>
							<li>
								<label class="fix-label">任务执行结果：</label>
				                <span>${pojo.execResult}</span>
							</li>
						</c:if>
					</c:when>
					<c:otherwise>
						<li>
							<label class="fix-label">总体管理目标：</label>
			                <span>${pojo.designDetail.manageGoal}</span>
						</li>
						<li>
							<label class="fix-label">总结：</label>
			                <span>${pojo.execResult}</span>
						</li>
						<li>
							<label class="fix-label">结论：</label>
			                <span>${pojo.conclusionTypeName}</span>
						</li>
					</c:otherwise>
				</c:choose>
			</ul>
        </div> 
        <div class="page-box align-center">
			 <button type="button" class="btn-cancel" onclick="history.go(-1);">返回</button>
		</div>
	</form>
</div>
</body>
</html>