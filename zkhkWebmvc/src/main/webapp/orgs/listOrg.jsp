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
}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>查看组织架构数据展示</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">

	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/orgsTable.js"></script>
</head>
<body>
<input type="hidden" id="level" value="${param.level }">
<input type="hidden" id="pId" value="${param.orgId }">
<input type="hidden" id="endTag" value="${parent.isExternalService}">
<input type="hidden" id="pName" value="<%=pName %>">
<div class="content">
	<form id="form1" action="<%=path %>/org/listOrg" method="post">
		<div class="search-box-wrapper">
			<ul class="search-wrapper clearfix">
				<li>
					<label>组织名称：</label>
					<input id="org_id" name="orgId" type="hidden" value="${parent.orgId}" />
					<input name="orgName" type="text" value="${orgName }" class="input-sm" />
					<i class="icon icon-group-search" onclick="submitForm();"></i>
				</li>
				<li>
					<button id="add-group" type="button" class="btn-inquiry">新增</button>
				</li>
			</ul>
		</div>
		<div class="table-box">
			<table class="table-content" id="datalist">
				<thead class="table-title">
					<tr>
						<th>组织编码</th>
						<th>组织名称</th>
						<th>是否对外服务机构</th>
						<th>排序号</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${page.result}" var="orgs">
						<tr>
							<td>${orgs.orgCode}</td>
							<td>${orgs.orgName}</td>
							<td>${orgs.isExternalService eq "Y"?'是':'否'}</td>
							<td>${orgs.order}</td>
							<td class="table-control-wrapper">
								<a onclick="updateOrgById('${orgs.orgId }')" href="javascript:void(0)" >修改</a>
								<a class="mar-left" onclick="delOrgById('${orgs.orgId }', '${orgs.orgName}')" href="javascript:void(0)" >删除</a>
								<c:if test="${orgs.isExternalService eq 'Y'}">
								<a class="mar-left" onclick="configOrgById('${orgs.orgId }')" href="javascript:void(0)" >配置</a>
								</c:if>
								<c:if test="${orgs.isExternalService eq 'N'}">
							    <span class="mar-left">配置</span>
								</c:if>
								<a class="mar-left" onclick="parent.openSMS('${orgs.orgId}','${orgs.orgName}')" href="javascript:void(0)">短信配置</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="page-box">
				<jsp:include page="/public/pageFoot.jsp"></jsp:include>
		  	</div>
    	</div>
	</form>
</div>
</body>
</html>