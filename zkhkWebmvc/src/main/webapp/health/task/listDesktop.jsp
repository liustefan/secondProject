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
	<title>健康管理任务列表(我的桌面)</title>
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
			width: 402px\0;
		}
		
		.page-box {
			margin: 0 !important;
			padding-top: 15px;
			padding-bottom: 15px\0;
		}
	</style>
	<script type="text/javascript">
		var index = layer.getFrameIndex(window.name); //获取窗口索引
		
		function openMemTag() {
			var layerLeft1;
			var layerTop1;
			var diseaseObj1 = $("input[name='memberLabelNames']");
			var diseaseOffset1 = $("input[name='memberLabelNames']").offset();
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
		   	    area: ['425px', '350px'],
		   	 	content: '<%=path %>/label/listLabelItemsByDoc?flag=query&labelIds='+ $('input[name="memberLabelIds"]').val(),
		   	}); 
		}
		
		function setLabelName(labelId, labelName) {
			$("input[name='memberLabelNames']").val(labelName);
			$("input[name='memberLabelIds']").val(labelId);
		}
		
		function editTime(id, planTime){
			$("#MSETaskID").val(id);
			$("#planTime").val(planTime);
			layer.closeAll();
			layer.open({
		   	    type: 1,
		   		skin : 'skin1',
		   	    title: '延迟执行',
		   	    shadeClose: false,
		   	    shade: 0,
		   	    area: ['380px', '200px'],
		   	 	content: $("#editPlanTime"), //iframe的url
		   	}); 
		}
		function toExecTask(MSETaskID, memberId, taskType){
			var src = 'toExec?id='+MSETaskID+'&memberId='+memberId+'&source=listDesktop';
			if(taskType == 5 || taskType == 6){
				$.ajax({
					   type: "GET",
					   url: "hasDiseasesHistory",
					   data: {type: taskType == 5 ? 1 : 2, memberId: memberId},
					   async: false,
					   success: function(msg){
					     if(msg.data){
					    	 window.location.href=src;
					     }else{
					    	 alert("当前会员没有"+(taskType == 5 ? '高血压' : '糖尿病')+"疾病,不可执行执行"+(taskType == 5 ? '高血压' : '糖尿病')+"随访(公卫)任务！");
					     }
					   }
					});
			}else{
				window.location.href=src;
			}
			
		}
	</script>
</head>
<body>
<div class="content" style="min-height: 500px;">
    <form action="listDesktop" method="POST" id="">
		<div class="search-box-wrapper">
			<ul class="search-wrapper">
				<li>
					<label>会员姓名：</label>
	                <input type="text" name="memName" value="${pojo.memName}" maxlength="20">
				</li>
				<li>
					<label>手机号码：</label>
	                <input type="text" name="tel" value="${pojo.tel}" maxlength="11">
				</li>
				<li>
					<label>管理方案：</label>
	                <div class="position-r">
		                <input type="text" name="design.schemeTitle" value="${pojo.design.schemeTitle}" maxlength="20">
                 	</div>
				</li>
				<li>
					<label>计划执行时间：</label> 
					<input class="info-date" id="firstTime" type="text" name="planTimeS" required="required" value='<fmt:formatDate value='${pojo.planTimeS}' pattern="yyyy-MM-dd"/>' readonly="readonly" /> 
					<span class="mar-left">至</span> 
					<input class="info-date" id="lastTime" type="text" name="planTimeE" required="required" value='<fmt:formatDate value='${pojo.planTimeE}' pattern="yyyy-MM-dd"/>' readonly="readonly" />
				</li>
				<li>
					<label>会员标签：</label>
	                <div class="position-r">
	                	<input type="hidden" name="memberLabelIds" value="${pojo.memberLabelIds}">
		                <input class="member-label" type="text" readonly name="memberLabelNames" value="${pojo.memberLabelNames}">
		                <i class="member-search" onclick="openMemTag();"></i>
                 	</div>
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
						<th>会员姓名</th>
						<th>性别</th>
						<th>手机号码</th>
						<th>管理方案</th>
						<th>任务类别</th>
						<th>任务执行方式</th>
						<th>计划执行时间</th>
<!-- 						<th>实际执行时间</th> -->
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${page.result}" var="item">
					<tr>
						<td>${item.memName}</td>
						<td>${item.gender eq 1 ? '男' : item.gender eq 2 ? '女' : '未知'}</td>
						<td>${item.tel}</td>
						<td><a href="../managescheme/${item.design.schemeType eq 1 ? 'toEditPerson' : 'toEditGroup'}?id=${item.design.MSDesignID}&view=true&source=../manageschemeTask/listDesktop"><c:out value="${item.design.schemeTitle}" escapeXml="true"/><a></td>
						<td>${item.designTask.taskTypeName}</td>
						<td>${item.designTask.execWayName}</td>
						<td><fmt:formatDate value='${item.planTime}' pattern="yyyy-MM-dd"/></td>
<%-- 						<td><fmt:formatDate value='${item.execTime}' pattern="yyyy-MM-dd"/></td> --%>
						<td>
							<a href="javascript:toExecTask(${item.MSETaskID},${item.memberId},${item.designTask.taskType});">执行任务</a>
							<a class="mar-left" href="javascript: void(0);" onclick="editTime(${item.MSETaskID}, '<fmt:formatDate value='${item.planTime}' pattern="yyyy-MM-dd"/>');">延迟执行</a>
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
		<input type="hidden" name="source" value="listDesktop">
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
