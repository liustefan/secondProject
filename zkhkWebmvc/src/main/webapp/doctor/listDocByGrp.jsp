<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" %>
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
	<title>查看医生分组所属医生</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">

	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script type="text/javascript">
		function removeRecord(doctorId, odgpId) {
			layer.confirm('确定要删除吗？', {
				title : '提示信息',
				skin: 'skin1',
				shade : 0,
				btn : [ '确定', '取消' ]
			}, function(index) {
				$.ajax({
					type : "POST",
					url : "<%=path %>/docGrp/removeDoctor",
					data : {docid: doctorId, odgpid: odgpId},
					success : function(msg) {
						if (msg.status) {
							layer.msg(msg.content, {icon: 1,time: 1000,offset: "100px"},function(){
							layer.close(index);
							location.reload();
							})
						};
					}
				});
				
			});
		}
	</script>
</head>
<body>
<div class="content">
	<div class="content-title">医生分组管理 --- 查看所属医生</div>
	<div class="page-box">
		<span>
			<c:if test="${parentList.size() gt 0 }">
				<c:forEach items="${parentList }" var="item">
				${item.odgpname }>
				</c:forEach>
			</c:if>
			${group.odgpname}
			<c:if test="${group.chlevel != null}">(${group.chlevel}级审核)</c:if>
		</span>
	 	<button class="btn-normal fr" type="button" onclick="javascript: history.go(-1);">返回</button>
 	</div>
	<div class="table-box">
		<table class="table-content">
			<thead class="table-title">
				<tr>
					<th>医生ID</th>
					<th>审核级别</th>
					<th>医生姓名</th>
					<th>所属医院</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${page.result}" var="pojo">
					<tr>
						<td>${pojo.docid}</td>
						<td>${pojo.auditlevel}</td>
						<td>${pojo.doctor.docname}</td>
						<td>${pojo.doctor.orgName}</td>
						<td><a href="javascript: void(0);" onclick="removeRecord(${pojo.docid}, ${pojo.odgpid});">删除</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="page-box">
		<form action="<%=path%>/docGrp/listDocByGrp" method="POST">
			<input type="hidden" name="groupId" value="${group.odgpid}">
			<jsp:include page="/public/pageFoot.jsp"></jsp:include>
		</form>
	</div>
</div>
</body>
</html>