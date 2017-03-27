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
	<title>选择管理方案模板</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/js/jquery-ui/themes/overcast/jquery-ui.min.css">
	<link rel="stylesheet" href="<%=path %>/plugins/font-awesome/css/font-awesome.min.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-ui/jquery-ui.js"></script>
	<script type="text/javascript" src="<%=path %>/js/dataPacker.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<style type="text/css">
		.layer-box {
			margin: 30px 20px;
		}
		
		.layer-box input[type="text"] {
			width: 350px;
		}
	</style>
	<script type="text/javascript">
		var index = layer.getFrameIndex(window.name); //获取窗口索引
	
		function setDiseaseInfo(obj){
			$("input[name='MSDiseaseName']").val(obj.diseaseName);
			$("input[name='MSDiseaseIDs']").val(obj.diseaseId);
		}
		
		function chooseDisease(){
			var layerLeft;
			var layerTop;
			var titleObj = $("input[name='MSDiseaseName']");
			var titleOffset = $("input[name='MSDiseaseName']").offset();
			layerLeft = titleOffset.left + "px";
			layerTop = titleOffset.top + titleObj.outerHeight() + "px";
			
			layer.closeAll();
			layer.open({
		   	    type: 2,
		   		skin : 'skin1',
		   	    title: '选择疾病分类',
		   	    shadeClose: false,
		   	    shade: 0,
		   	 	offset: [layerTop, layerLeft],
		   	    area: ['300px', '400px'],
		   	 	content: '<%=path%>/health/templet/diseaseClassify.jsp', //iframe的url
		   	}); 
		}
	</script>
</head>
<body>
<div class="content">
    <form action="chooseTemplet" method="GET" id="">
		<div class="search-box-wrapper">
			<ul class="search-wrapper">
				<li>
					<label>模板标题：</label>
	                <input type="text" name="schemeTitle" value="${pojo.schemeTitle}" maxlength="20">
				</li>
				<li>
					<label>疾病分类：</label>
					<div class="position-r">
    					<input type="hidden" name="MSDiseaseIDs" value="${pojo.MSDiseaseIDs}">
		                <input type="text" name="MSDiseaseName" readonly value="${pojo.MSDiseaseName}">
		                <i class="member-search" onclick="chooseDisease();"></i>
                 	</div>
				</li>
				<li>
					<label>更新日期：</label> 
					<input class="info-date" id="startDate" type="text" name="updateTimeS" required="required" value='<fmt:formatDate value='${pojo.updateTimeS}' pattern="yyyy-MM-dd"/>' readonly="readonly" /> 
					<span class="mar-left">至</span> 
					<input class="info-date" id="endDate" type="text" name="updateTimeE" required="required" value='<fmt:formatDate value='${pojo.updateTimeE}' pattern="yyyy-MM-dd"/>' readonly="readonly" />
				</li>
				<li>
					<button type="button" class="btn-inquiry ico-search" onclick="search(1)">查询</button>
				</li>
			</ul>
		</div>
		<div class="table-box">
			<c:if test="${page.totalCount == 0}">
		  			<div class="empty-info border-1-solid">目前还没有方案模板信息</div>
	  		</c:if>
			<c:if test="${page.totalCount > 0}">
			<table class="table-content">
				<thead class="table-title">
					<tr>
						<th>模板标题</th>
						<th>适用疾病分类</th>
						<th>使用范围</th>
						<th>被使用次数</th>
						<th>更新人</th>
						<th>更新日期</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${page.result}" var="item">
					<tr>
						<td><c:out value="${item.schemeTitle}" escapeXml="true"/></td>
						<td>
						<c:forEach items="${item.diseases}" var="ds" varStatus="vs">
							${ds.diseaseName}<c:if test="${fn:length(item.diseases) > vs.index+1}">、</c:if>
						</c:forEach>
						</td>
						<td>${item.useRangeName}</td>
						<td>${item.usedNumber}</td>
						<td>${item.updateName}</td>
						<td><fmt:formatDate value='${item.updateTime}' pattern="yyyy-MM-dd"/></td>
						<td>
							<a href="javascript:parent.setTemplet(${item.MSTempletID})">选择</a>
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
</body>
</html>
