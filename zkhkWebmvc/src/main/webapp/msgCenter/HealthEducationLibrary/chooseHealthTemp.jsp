<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>选择健教模板</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">

	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<style>
		.content {
			margin-top: 8px;
		}
		
		.width-normal {
			width: 150px;
		}
		
		.width-lg {
			width: 250px;
		}
		
		.position-r {
			position: relative;
			display: inline-block;
		}
	</style>
	<script type="text/javascript">
	var index = layer.getFrameIndex(window.name); //获取窗口索引
	
	function setDiseaseInfo(obj){
		$("input[name='MSDiseaseName']").val(obj.diseaseName);
		$("input[name='MSDiseaseIDs']").val(obj.diseaseId);
	}
		//选择疾病分类
		function chooseDisease(){
			var layerLeft1;
			var layerTop1;
			var diseaseObj1 = $("input[name='MSDiseaseName']");
			var diseaseOffset1 = $("input[name='MSDiseaseName']").offset();
			layerLeft1 = diseaseOffset1.left + "px";
			layerTop1 = diseaseOffset1.top + diseaseObj1.outerHeight() + "px";

		layer.closeAll();
		layer.open({
	   	    type: 2,
	   		skin : 'skin1',
	   	    title: '选择疾病分类',
	   	    shadeClose: false,
	   	    shade: 0,
	   	 	offset: [layerTop1, layerLeft1],
	   	    area: ['300px', '400px'],
	   	 	content: '<%=path%>/health/templet/diseaseClassify.jsp', //iframe的url
	   	}); 
	}
	</script>
</head>
<body>
<div class="content">
     <form action="<%=path %>/health/chooseHealthTemp" method="POST" id="pojo">
		<div class="search-box-wrapper">
			<ul class="search-wrapper">
				<li>
					<label>健教类型：</label>
					<select name="heducationtype">
			          	<option value="">全部</option>
			          	<option value="1"  <c:if test="${pojo.heducationtype eq '1'}">selected="selected"</c:if>>饮食指导</option>
			          	<option value="2"  <c:if test="${pojo.heducationtype eq '2'}">selected="selected"</c:if>>运动指导</option>
			          	<option value="3"  <c:if test="${pojo.heducationtype eq '3'}">selected="selected"</c:if>>心理指导</option>
			          	<option value="4"  <c:if test="${pojo.heducationtype eq '4'}">selected="selected"</c:if>>中医指导</option>
			          	<option value="5"  <c:if test="${pojo.heducationtype eq '5'}">selected="selected"</c:if>>生活方式指导</option>
			          	<option value="6"  <c:if test="${pojo.heducationtype eq '6'}">selected="selected"</c:if>>用药指导</option>
		        	</select>
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
					<label>标题：</label>
	                <input type="text" class="width-lg" name="title" value="${pojo.title}">
				</li>
				<li>
					<button type="button" class="btn-inquiry ico-search" onclick="search(1)">查询</button>
				</li>
			</ul>
		</div>
		<div class="table-box">
		<c:if test="${page.totalCount == 0}">
		  			<div class="empty-info border-1-solid">目前还没有健教信息</div>
	  		</c:if>
			<c:if test="${page.totalCount > 0}">
			<table class="table-content">
				<thead class="table-title">
					<tr>
						<th width="20%">健教类型</th>
						<th width="20%">标题</th>
						<th>适用疾病分类</th>
						<th width="10%">操作</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${page.result}" var="health">
					<tr>
					 	<c:if test="${health.heducationtype==1}"><td>饮食指导</td></c:if>
					 	<c:if test="${health.heducationtype==2}"><td>运动指导</td></c:if>
					 	<c:if test="${health.heducationtype==3}"><td>心里指导</td></c:if>
					 	<c:if test="${health.heducationtype==4}"><td>中医指导</td></c:if>
					 	<c:if test="${health.heducationtype==5}"><td>生活方式指导</td></c:if>
					 	<c:if test="${health.heducationtype==6}"><td>用药指导</td></c:if>
						<td>${health.title}</td>
						<td>
							<c:forEach items="${health.diseases}" var="ds" varStatus="vs">
										${ds.diseaseName}<c:if test="${fn:length(health.diseases) > vs.index+1}">、</c:if>
							</c:forEach>
						</td>
						<td>
							<a href="javascript: void(0);" onclick="parent.setHed('<c:out value='${health.content}' escapeXml='true'/>', ${health.heducationid}, '<c:out value='${health.title}' escapeXml='true'/>')">选择</a>
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