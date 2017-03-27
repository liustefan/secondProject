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
	<title>选择会员</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">

	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<style type="text/css">
		.content {
			margin-top: 8px;
		}
	</style>
	<script type="text/javascript">
		var index = layer.getFrameIndex(window.name); //获取窗口索引
	
		function deleteGroupMember(id){
			layer.confirm('您确定要移除当前会员吗？', {
				title : '提示信息',
				skin : 'skin1',
				shade : 0,
				btn : [ '确定', '取消' ]
			}, function(){
				$.ajax({
			   		type: "GET",
				   	url: 'deleteGroupMember?id='+id,
				   	asyn: false,
				   	success: function(response){
					  	if(response.status){
					  		layer.msg("移除成功！",{icon: 1,time: 1000},function(index) {
							  	location.reload();
							});
					  	}else{
						  	alert(response.content);
					  	}
				   	}
				});
			});
		}
	</script>
</head>
<body>
<div class="content">
	<form action="listGroup_members?MSDesignID=${pojo.MSDesignID}&massStatus=${param.massStatus}&massEffectProcess=${param.massEffectProcess}&view=${param.view}" method="POST" id="">
		<div class="search-box-wrapper">
			<ul class="search-wrapper">
				<li>
					<label>会员姓名：</label>
					<input type="text" name="memName" value="${pojo.memName}">
				</li>
				<li>
					<label>手机号码：</label>
					<input type="text" name="tel" value="${pojo.tel}">
				</li>
				<c:if test="${param.massStatus ne 1}">
				<li>
					<label>状态：</label>
					<select name="MEPersonProcess">
		                <option value="">全部</option>
		                <option value="1" <c:if test="${pojo.MEPersonProcess eq 1}">selected="selected"</c:if>>未触发</option>
		                <option value="2" <c:if test="${pojo.MEPersonProcess eq 2}">selected="selected"</c:if>>生成中</option>
		                <option value="3" <c:if test="${pojo.MEPersonProcess eq 3}">selected="selected"</c:if>>已生成</option>
		            </select>
				</li>
				</c:if>
				<li>
					<button type="button" class="btn-inquiry ico-search" onclick="search(1)">查询</button>
					<c:if test="${!param.view}">
						<c:if test="${param.massEffectProcess eq 2}">
							<button type="button" class="btn-cancel">新增</button>
						</c:if>
						<c:if test="${param.massEffectProcess ne 2}">
							<button type="button" class="btn-inquiry ico-add"  onclick="parent.chooseMember(${pojo.MSDesignID})">新增</button>
						</c:if>
					</c:if>
				</li>
			</ul>
		</div>
		<div class="table-box">
			<table class="table-content">
				<thead class="table-title">
					<tr>
						<th>会员姓名</th>
						<th>性别</th>
						<th>手机号码</th>
						<th>触发时间</th>
						<th>状态</th>
						<c:if test="${!param.view}">
						<th>操作</th>
						</c:if>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${page.result}" var="item">
					<tr>
						<td>${item.memName}</td>
						<td>${item.gender eq 1 ? '男' : item.gender eq 2 ? '女' : '未知'}</td>
						<td>${item.tel}</td>
						<td><fmt:formatDate value='${item.MEPTriggerTime}' pattern="yyyy/MM/dd HH:mm:ss"/></td>
						<td>${item.MEPersonProcessName}</td>
						<c:if test="${!param.view}">
						<td>
							<c:choose>
								<c:when test="${param.massEffectProcess eq 2 || (item.MEPersonProcess ne 1 && item.MEPersonProcess ne 4)}">
									<span>移除</span>
								</c:when>
								<c:otherwise>
									<a href="javascript: void(0);" onclick="deleteGroupMember(${item.MSExecID})">移除</a>
								</c:otherwise>
							</c:choose>
						</td>
						</c:if>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="page-box">
			<jsp:include page="/public/pageFoot.jsp"></jsp:include>
		</div>
	</form>
</div>
</body>
</html>
