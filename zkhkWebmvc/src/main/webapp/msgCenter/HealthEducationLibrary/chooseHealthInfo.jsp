<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>选择健康资讯</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">

	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
</head>
<body>
<div class="content">
    <form action="<%=path %>/health/chooseHealthInfo" method="POST" id="pojo">
		<div class="search-box-wrapper">
			<ul class="search-wrapper">
				<li>
					<label>标签：</label>
					<select name="hnlabelid">
	                <option value="">请选择</option>
	                <c:forEach items="${lableList}" var="lable">
	                <c:choose>
	                 <c:when test="${healthnewsLable.hnlabelid eq lable.hnlabelid }">
	                 <option value="${lable.hnlabelid}" selected="selected">${lable.content}</option>
	                 </c:when>
	                 <c:otherwise>
	                 <option value="${lable.hnlabelid}">${lable.content}</option>
	                 </c:otherwise>
	                 </c:choose>
	                </c:forEach> 
	                </select>
				</li>
				<li>
					<label>标题：</label>
	                <input type="text" name="title" value="${pojo.title}">
				</li>
				<li>
					<button type="button" class="btn-inquiry ico-search" onclick="search(1)">查询</button>
				</li>
			</ul>
		</div>
		<div class="table-box">
			<table class="table-content">
			<c:if test="${page.totalCount == 0}">
		  			<div class="empty-info border-1-solid">目前还没有健康资讯信息</div>
	  		</c:if>
			<c:if test="${page.totalCount > 0}">
				<thead class="table-title">
					<tr>
						<th width="40%">标题</th>
						<th width="40%">标签</th>
						<th width="20%">操作</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${page.result}" var="healthInfo">
					<tr>
						<td>${healthInfo.title}</td>
						<td>
						<c:forEach items="${healthInfo.healthnewsLables}" var="healthnewsLable">
									${healthnewsLable.content}&nbsp;
						</c:forEach>
						</td>
						<td>
						<a href="javascript: void(0);" onclick="parent.setHed(${healthInfo.hninfoid})">选择</a>
						</td>
					</tr>
				</c:forEach>
				</tbody>
				</c:if>
			</table>
		</div>
		<div class="page-box">
			<jsp:include page="/public/pageFoot.jsp"></jsp:include>
		</div>
	</form>
</div>
</body>
</html>
