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
	<title>健康管理任务列表(单一会员)</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/js/jquery-ui/themes/overcast/jquery-ui.min.css">
	<link rel="stylesheet" href="<%=path %>/plugins/font-awesome/css/font-awesome.min.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-ui/jquery-ui.js"></script>
	<script type="text/javascript" src="<%=path %>/js/dataPacker.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
		<style type="text/css">
		.layer-box {
			margin: 35px 25px 35px 25px;
			font-size: 16px;
		}
		
		.member-label {
			width: 444px;
		}
	</style>
	<script type="text/javascript">
		var index = layer.getFrameIndex(window.name); //获取窗口索引
	
		function chooseProgramme(title){
			layer.closeAll();
			layer.open({
		   	    type: 2,
		   		skin : 'skin1',
		   	    title: title,
		   	    shadeClose: false,
		   	    shade: 0,
		   	    area: ['650px', '350px'],
		   	    content: '', //iframe的url
		   	}); 
		}
		
		function openMemTag() {
			var layerLeft1;
			var layerTop1;
			var diseaseObj1 = $("input[name='memberLabelName']");
			var diseaseOffset1 = $("input[name='memberLabelName']").offset();
			layerLeft1 = diseaseOffset1.left + "px";
			layerTop1 = diseaseOffset1.top + diseaseObj1.outerHeight() + "px";
			
			layer.closeAll();
			layer.open({
		   	    type: 2,
		   		skin : 'skin1',
		   	    title: '会员标签',
		   	    shadeClose: false,
		   	    shade: 0,
		   	 	offset: [layerTop1, layerLeft1],
		   	    area: ['400px', '350px'],
		   	    content: 'chooseLabel.html', //iframe的url
		   	}); 
		}
		function editTime(id, planTime){
			$("#MSETaskID").val(id);
			$("#planTime").val(planTime);
			layer.closeAll();
			layer.open({
		   	    type: 1,
		   		skin : 'skin1',
		   	    title: '修改计划时间',
		   	    shadeClose: false,
		   	    shade: 0,
		   	    area: ['390px', '200px'],
		   	 	content: $("#editPlanTime"), //iframe的url
		   	}); 
		}
	</script>
</head>
<body>
<div class="content">
	<div class="content-title">
   		健康管理任务
	</div>
    <form action="singleList" method="POST" id="">
    	<input type="hidden" name="memberId" value="${pojo.memberId}">
		<div class="search-box-wrapper">
			<ul class="search-wrapper">
				<li>
					<label>管理方案：</label>
	                <div class="position-r">
		                <input type="text" name="design.schemeTitle" value="${pojo.design.schemeTitle}">
                 	</div>
				</li>
				<li>
					<label>计划执行时间：</label> 
					<input class="info-date" id="firstTime" type="text" name="planTimeS" value='<fmt:formatDate value='${pojo.planTimeS}' pattern="yyyy-MM-dd"/>' readonly /> 
					<span class="mar-left">至</span> 
					<input class="info-date" id="lastTime" type="text" name="planTimeE" value='<fmt:formatDate value='${pojo.planTimeE}' pattern="yyyy-MM-dd"/>' readonly />
				</li>
				<li>
					<label>状态：</label>
	                <select name="execStatus">
					  <option value="1" <c:if test="${pojo.execStatus eq 1}">selected="selected"</c:if>>待执行</option>
			          <option value="2" <c:if test="${pojo.execStatus eq 2}">selected="selected"</c:if>>已执行</option>
			          <option value="3" <c:if test="${pojo.execStatus eq 3}">selected="selected"</c:if>>已终止</option>
					</select>
				</li>
				<li>
					<button type="button" class="btn-inquiry ico-search" onclick="search(1)">查询</button>
				</li>
			</ul>
		</div>
		<div class="table-box">
			<c:if test="${page.totalCount == 0}">
		  		<div class="empty-info border-1-solid">目前暂无数据</div>
	  		</c:if>
	  		<c:if test="${page.totalCount > 0}">
			<table class="table-content">
				<thead class="table-title">
					<tr>
						<th>管理方案</th>
						<th>任务类别</th>
						<th>任务执行方式</th>
						<th>计划执行时间</th>
						<th>实际执行时间</th>
						<th>状态</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${page.result}" var="item">
					<tr>
						<td><a href="../managescheme/${item.design.schemeType eq 1 ? 'toEditPerson' : 'toEditGroup'}?id=${item.design.MSDesignID}&view=true&source=../manageschemeTask/singleList?memberId=${pojo.memberId}"><c:out value="${item.design.schemeTitle}" escapeXml="true"/><a></td>
						<td>${item.designTask.taskTypeName}</td>
						<td>${item.designTask.execWayName}</td>
						<td><fmt:formatDate value='${item.planTime}' pattern="yyyy-MM-dd"/></td>
						<td><fmt:formatDate value='${item.execTime}' pattern="yyyy-MM-dd HH:mm:ss"/></td>
						<td>${item.execStatusName}</td>
						<td>
							<a href="detail?id=${item.MSETaskID}&source=singleList?memberId=${item.memberId}" onclick="">查看</a>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			</c:if>
		</div>
		<div class="page-box">
			<jsp:include page="/public/pageFoot.jsp"></jsp:include>
		</div>
	</form>
</div>
<div id="editPlanTime" style="display: none;">
	<form action="saveEditPlanTime" method="post">
		<input type="hidden" id="MSETaskID" name="MSETaskID">
		<input type="hidden" name="source" value="list">
		<div class="layer-box">
			<span>请重新选择任务计划执行时间：</span>
			<input class="info-date" id="planTime" name="planTime" readonly>
		</div>
		<div class="page-box align-center">
			<input type="submit" class="btn-inquiry" value="保存">
			<input type="button" class="btn-cancel" onclick="layer.closeAll();" value="取消">
		</div>
	</form>
</div>
</body>
</html>
