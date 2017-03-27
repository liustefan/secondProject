<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE HTML>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>查看医生分组数据展示</title>
    <link rel="stylesheet" href="<%=path %>/css/general.css">
    
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script type="text/javascript" src="<%=path %>/js/odgpTable.js"></script>
</head>
<body>
<form action="<%=path %>/docGrp/listDoctorGrp" class="searchForm" method="POST">
	<div class="content">
		<div class="search-box-wrapper clearfix">
			<input type="hidden" name="pId" value="${parent.odgpid}"/>
			<ul class="search-wrapper clearfix">
				<li>
					<label>分组名称：</label>
					<input type="text" class="input-sm" name="odgpname" value="${odgpname}">
					<i class="icon icon-group-search "></i>	
				</li>
				<li>
					<button id="add-doctor" type="button" class="btn-inquiry">新增</button>
				</li>
			</ul>
			<input type="hidden" name="odgpname" value="${parent.odgpname}"/>
			<input type="hidden" name="endblocktag" value="${parent.endblocktag}"/>
		</div>
	    <div class="table-box">
			<table class="table-content">
				<thead class="table-title">
					<tr>
						<th width="18%">分组名称</th>
						<th width="30%">分组说明</th>
						<th width="9%">排序号</th>
						<th width="9%">是否为终结点</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${page.result}" var="pojo">
					<tr>
						<td>${pojo.odgpname}</td>
						<td><c:out value="${pojo.remark}" escapeXml="true"/></td>
						<td>${pojo.order}</td>
						<td>${pojo.endblocktag?'是':'否'}</td>
						<td>
							<a href="javascript: void(0);" onclick="updateDoctorGroup(${pojo.odgpid});" >修改</a>
							<c:if test="${pojo.endblocktag}">
							<a href="javascript: void(0);" onclick="javascript:parent.goPage('<%=path%>/docGrp/listDocByGrp?groupId=${pojo.odgpid}');">查看所属医生</a>
							<a href="javascript: void(0);" onclick="setExamine(${pojo.odgpid});" >设置审核权限</a>
							</c:if>
							<c:if test="${!pojo.endblocktag}">
							<span>查看所属医生</span>
							<span>设置审核权限</span>
							</c:if>
							<a href="javascript: void(0);" onclick="removeRecord(${pojo.odgpid}, this);" odgpName="<c:out value="${pojo.odgpname}" escapeXml="true"/>" >删除</a>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			<div class="page-box">
				<jsp:include page="/public/pageFoot.jsp?tmp=<%=Math.random() %>"></jsp:include>
			</div>
    	</div>
	</div>
</form>
</body>
</html>