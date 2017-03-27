<%@	page import="java.net.URLDecoder"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE HTML>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>查看有分组管理数据展示</title>
    <link rel="stylesheet" href="<%=path %>/css/general.css"/>

	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/omgsTable.js"></script>
</head>
<body>
<form class="searchForm" action="<%=path %>/memberGrp/listMemberGroup" method="post">
	<div class="content">
		<div class="search-box-wrapper clearfix">
			<ul class="search-wrapper clearfix">
				<input type="hidden" name="pId" value="${group.memgrpid}"/>
				<li>
					<label>分组名称：</label>
					<input name="memGrpName" type="text" value="${memGrpName}" class="input-sm" />
					<i class="icon icon-group-search"></i>
				</li>
				<li>
					<button id="add-group" type="button" class="btn-inquiry">新增</button>
				</li>
			</ul>
			<input type="hidden" name="memGrpPName" value="${group.memgrpname}"/>
		</div>
	    <div class="table-box">
			<table class="table-content">
				<thead class="table-title">
					<tr>
						<th width="20%">分组名称</th>
						<th width="35%">分组说明</th>
						<th width="8%">排序号</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${page.result}" var="pojo">
						<tr>
							<td>${pojo.memgrpname}</td>
							<td><c:out value="${pojo.memgrpdesc}" escapeXml="true"/></td>
							<td>${pojo.order}</td>
							<td class="table-control-wrapper">
								<a href="javascript:void(0)" onclick="updateMemberGroup(${pojo.memgrpid})">修改</a>
								<a href="javascript:void(0)" onclick="javascript:parent.goPage('<%=path%>/member/bindDocGrp.jsp', ${pojo.memgrpid});">绑定医生分组</a>
								<a href="javascript:void(0)" onclick="removeRecord(${pojo.memgrpid}, this)" memGrpName="<c:out value="${pojo.memgrpname}" escapeXml="true"/>">删除</a>
							</td>
						</tr>
					</c:forEach>
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