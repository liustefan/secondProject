<%@ page import="java.net.URLDecoder"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String name = request.getParameter("pName");
String pName =(String)request.getAttribute("pName");
if(name != null){
	pName = URLDecoder.decode(name, "UTF-8");
}else {
	pName = "全部";
}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>疾病分类管理</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">

	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/disease.js"></script>
</head>
<body>
<input type="hidden" id="level" value="${param.level }">
<input type="hidden" id="pId" value="${param.msdiseaseid}">
<input type="hidden" id="pName" value="<%=pName %>">
<input type="hidden" id="msdiseaseid" name="msdiseaseid" value="${parent.msdiseaseid}" />
<div class="content" style="margin-top: 0;">
	<form id="form1" action="<%=path %>/health/illManagement" method="post">
		<div class="search-box-wrapper">
			<ul class="search-wrapper clearfix">
				<li>
					<label>上级疾病节点：</label>
					<span><%=pName %></span>
					<input id="msdiseaseid" name="msdiseaseid" type="hidden" value="${parent.msdiseaseid}" />
				</li>
				<li>
					<button id="add-group" type="button" class="btn-inquiry">新增</button>
				</li>
			</ul>
		</div>
		<div class="table-box">
		<c:if test="${page.totalCount == 0}">
		  			<div class="empty-info border-1-solid">目前无疾病分类信息</div>
	  		</c:if>
			<c:if test="${page.totalCount > 0}">
			<table class="table-content">
				<thead class="table-title">
					<tr>
						<th width="20%">疾病分类名称</th>
						<th>描述</th>
						<th width="10%">排序号</th>
						<th width="15%">更新人</th>
						<th width="15%">更新日期</th>
						<th width="10%">操作</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${page.result}" var="dis">
					<tr>
						<td>${dis.diseasename}</td>
						<td>${dis.description}</td>
						<td>${dis.sortno}</td>
						<td>${dis.docname}</td>
						<td><fmt:formatDate value="${dis.updatetime}" pattern="yyyy-MM-dd"/></td>
						<td>
							<a href="javascript:void(0)" onclick="updateDisById('${dis.msdiseaseid }')">修改</a>
							<a href="javascript:void(0)" class="mar-left" onclick="delDisById('${dis.msdiseaseid }', '${dis.diseasename}')">删除</a>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			</c:if>
			<div class="page-box">
				<jsp:include page="/public/pageFoot.jsp"></jsp:include>
		  	</div>
    	</div>
	</form>
</div>
</body>
</html>