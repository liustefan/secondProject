<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %> 
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>医生管理</title>
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/general.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/showAllDoctors.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script type="text/javascript" src="<%=path %>/js/showAllDoctors.js"></script>
	<script type="text/javascript" src="<%=path %>/js/placeholder.js"></script>
</head>
<body>
	<form action="<%=path %>/doctor/listDoctor" method="post" id="doctorForm">
		<div class="content">
			<div class="content-title">医生管理</div>
			<div class="search-box-wrapper clearfix">
				<ul class="search-wrapper clearfix">
					<li>
						<input type="text" name="criteria" id="find" value="${criteria}" placeholder="模糊匹配姓名、手机号、微信号、邮箱、证件号码" />
						<button type="button" id="select1" onclick="search(1);">
							<img src="<%=path %>/img/sousuo.png" />
						</button>
					</li>
					<li>
						<button class="btn-inquiry" type="button" onclick="javascript:location.href='<%=path%>/doctor/edit/0'">新增</button>
					</li>
				</ul>
			</div>
			<div class="table-box">
				<table class="table-content">
					<thead class="table-title">
						<tr>
							<th width="10%">姓名</th>
							<th width="10%">账号</th>
							<th width="5%">性别</th>
							<th width="10%">手机号</th>
							<th width="10%">证件号码</th>
							<th width="15%">家庭地址</th>
							<th width="15%">工作单位</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
					<c:choose>
					<c:when test="${page.totalCount eq 0}">
					      <tr><td colspan="8" class="empty-info">目前还没有用户信息</td></tr>
					</c:when>
					<c:otherwise>
					<c:forEach items="${page.result }" var="odoc">
						<tr align="center">
							<td><a href="<%=path %>/doctor/detail/${odoc.docid}?orgId=${odoc.orgid}"> 
							   ${odoc.docname} </a></td>
							<td>${odoc.doctorAccount.docacc }</td>
							<c:choose>
							<c:when test="${odoc.gender eq 'M' }"><td>男</td></c:when>
							<c:otherwise><td>女</td></c:otherwise>
							</c:choose>
							<td>${odoc.tel }</td>
							<td>${odoc.certinum }</td>
							<td>${odoc.homeaddress }</td>
							<td>${odoc.workaddress }</td>
							<td id="table_content_title_td">
								<a href="javascript: void(0);" onclick="addDoctorGroup(${odoc.docid }, ${odoc.orgid });">加入医生分组</a>
								<a href="<%=path%>/doctor/edit/${odoc.docid }">修改</a>
								<a href="javascript: void(0);" onclick="resertPwd('<%=path%>/doctor/reset?docid=${odoc.docid }&orgid=${odoc.orgid}&roleid=${odoc.roleid }');">重置密码</a>
								<a href="javascript: void(0);" onclick="removeRecord('<%=path%>/doctor/delete?docid=${odoc.docid }&orgid=${odoc.orgid}&roleid=${odoc.roleid }');" >删除</a>				
							</td>
						</tr>
					</c:forEach>
					</c:otherwise>
					</c:choose>
					</tbody>
				</table>
				<div class="page-box">
					<jsp:include page="/public/pageFoot.jsp"></jsp:include>
				</div>
			</div>
		</div>
	</form>
</body>
</html>