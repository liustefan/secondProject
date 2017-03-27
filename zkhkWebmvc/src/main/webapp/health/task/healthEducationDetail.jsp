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
	<title>健教内容详情</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">

	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<style>
		.main-box {
			border: 1px solid #98cc6b;
		}
		
		.main-box ul li {
			padding: 15px 8px 15px 30px;
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
	</style>
</head>
<body>
<div class="content">
	<div class="content-title">健康管理任务</div>
    <form action="" method="POST" id="">
		<div class="main-box">
			<div class="task-title">
				<c:if test="${pojo.sourceway eq 3}">来源网址</c:if>
				<c:if test="${pojo.sourceway ne 3}">健教内容详情</c:if>
			</div>
			<ul class="clearfix">
				<li>
					<c:choose>
						<c:when test="${pojo.sourceway eq 3}">
							<a target="_target" href="${pojo.content}">${pojo.content}</a>
						</c:when>
						<c:otherwise>
							${pojo.content}
						</c:otherwise>
					</c:choose>
				</li>
			</ul>
		</div>
		<div class="page-box align-center">
	        <button type="button" class="btn-cancel" onclick="history.go(-1);">返回</button>
        </div>
	</form>
</div>
</body>
</html>