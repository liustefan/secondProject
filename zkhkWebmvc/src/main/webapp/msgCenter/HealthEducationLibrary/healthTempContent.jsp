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
	<title>查看健教</title>
	<link rel="shortcut icon" type="image/x-icon" href="<%=path %>/<%=getServletContext().getAttribute("img") %>/title_ico.ico" />
	<link rel="stylesheet" href="<%=path %>/css/general.css">

	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="<%=path %>/js/jquery.validate.min.js"></script>
    <script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<style>
		.main-box {
	    	background: #f2f1f1;
		}
		
		.main-box ul li {
			padding: 15px 8px 15px 30px;
		}
	    
	    .task-title {
	    	height: 30px;
	    	line-height: 30px;
	    	padding-left: 8px;
	    	font-size: 14px;
	    }
	</style>
</head>
<body>
<div class="content">
	<div class="content-title">查看健教</div>
    <form action="<%=path %>/health/checkHealth" method="POST" id="pojo">
		<div class="main-box">
			<div class="task-title">健教内容详情</div>
			<ul class="clearfix">
			<c:if test="${pojo.sourceway!=3}">
				<li>
					${pojo.content}
				</li>
			</c:if>
			
			<c:if test="${pojo.sourceway==3}">
				<li>
					<a href="${pojo.content}">${pojo.content}</a>
				</li>
			</c:if>
			</ul>
		</div>
		<div class="page-box align-center">
	         <button type="button" class="btn-cancel" onclick="window.close();">关闭</button>
        </div>
	</form>
</div>
</body>
</html>