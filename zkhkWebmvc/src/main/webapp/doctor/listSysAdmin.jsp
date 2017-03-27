<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<title>系统管理员列表</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
    <script type="text/javascript" src="<%=path %>/js/showAllDoctors.js"></script>
    <script type="text/javascript" src="<%=path %>/js/listSysAdmin.js"></script>
</head>
<body>
	<div class="content">
		<div class="content-title">系统管理员列表</div>
		<div class="fr" style="margin-bottom: 8px;">
			<input type="button" onclick="add()" class="btn-inquiry" value="添加" />
		</div>
		<div class="table-box">
			<table class="table-content" id="table_new_1">
				<thead class="table-title">
					<tr>
				   		<th width="15%">账号</th>
				   		<th width="15%">姓名</th>
				   		<th width="15%">手机号</th>
				   		<th>Email地址</th>
				   		<th width="20%">操作</th>
				   		<th width="15%">重置密码</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
				   		<c:when test="${page.totalCount gt 0 }">
						   	<c:forEach items="${page.result }" var="doc1">
					   			<tr align="center">
					   				<td>${doc1.doctorAccount.docacc }</td>
					   				<td>${doc1.docname }</td>
					   				<td>${doc1.tel }</td>
					   				<td>${doc1.email }</td>
					   				<td>
					   					<c:choose>
					   						<c:when test="${doc1.tag eq 'T' }"><a onclick="return confirm('确认禁用？');" href="<%=path%>/doctor/disabled?docid=${doc1.docid }&tag=F">禁用</a></c:when>
					   						<c:otherwise><a onclick="return confirm('确认启用？');" href="<%=path%>/doctor/disabled?docid=${doc1.docid }&tag=T">启用</a></c:otherwise>
					   					</c:choose>
					   					<a href="javascript: void(0);" onclick="removeRecord('<%=path%>/doctor/delete?docid=${doc1.docid }&roleid=${doc1.roleid }');" ><span class="mar-left">删除</span></a>	
					   				</td>
					   				<td>
					   					<a data-href="<%=path%>/doctor/reset?docid=${doc1.docid }&roleid=${doc1.roleid }" class="resetPwd"><span class="cursor-p">重置密码</span></a>
				   					</td>
				  				</tr>
						    </c:forEach>
				   		</c:when>
					   	<c:otherwise>
					   		<tr>
					   			<td colspan="6">
					   				<div class="empty-info">目前还没有用户信息</div>
				   				</td>
					   		</tr>
					   	</c:otherwise>
			   		</c:choose>
				</tbody>
	  		</table>
 		</div>
		<form action="<%=path %>/doctor/listSysAdmin" method="post" id="sysAdminForm">
			<div class="page-box">
				<jsp:include  page="/public/pageFoot.jsp"/>
	  		</div>
		</form>
	</div>
</body>
</html>