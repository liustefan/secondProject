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
	<title>健教库</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-ui/jquery-ui.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script type="text/javascript" src="<%=path %>/js/dataPacker.js"></script>
	<script type="text/javascript" src="<%=path %>/js/health/healthEducation.js"></script>
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
	<div class="content-title">
   		健教库管理
	</div>
    <form action="<%=path %>/health/listHealth" method="POST" id="pojo">
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
					<input type="text" name="title" value="${pojo.title}" maxlength="50">
				</li>
				<li>
					<label>使用范围：</label>
	                <select name="userange">
	                	<option value="0">全部</option>
						<option value="1" <c:if test="${pojo.userange eq '1'}">selected="selected"</c:if>>全局</option>
						<option value="2" <c:if test="${pojo.userange eq '2'}">selected="selected"</c:if>>组织内</option>
						<option value="3" <c:if test="${pojo.userange eq '3'}">selected="selected"</c:if>>私人</option>
					</select>
				</li>
				<li>
					<label>来源：</label>
	                <select name="sourceway">
						<option value="">全部</option>
						<option value="1" <c:if test="${pojo.sourceway eq '1'}">selected="selected"</c:if>>自定义</option>
						<option value="2" <c:if test="${pojo.sourceway eq '2'}">selected="selected"</c:if>>健康资讯</option>
						<option value="3" <c:if test="${pojo.sourceway eq '3'}">selected="selected"</c:if>>复制网址</option>
					</select>
				</li>
				<li>
				    <button type="button" class="btn-inquiry ico-search" onclick="search(1)">查询</button>
					<button type="button" class="btn-inquiry ico-add" onclick="window.location.href='editHealth'">新增</button>
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
							<th>健教类型</th>
							<th>标题</th>
							<th>适用疾病分类</th>
							<th>来源</th>
							<th>使用范围</th>
							<th>更新人</th>
							<th>更新日期</th>
							<th>操作</th>
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
								<td><a href="<%=path %>/health/editHealth?id=${health.heducationid }&view=true"><c:out value="${health.title}" escapeXml="true"/></a></td>
								<td>
									<c:forEach items="${health.diseases}" var="ds" varStatus="vs">
										${ds.diseaseName}<c:if test="${fn:length(health.diseases) > vs.index+1}">、</c:if>
									</c:forEach>
								</td>
								<c:if test="${health.sourceway==1}"><td>自定义</td></c:if>
								<c:if test="${health.sourceway==2}"><td>健康资讯</td></c:if>
								<c:if test="${health.sourceway==3}"><td>复制网址</td></c:if>
								
								<c:if test="${health.userange==1}"><td>全局</td></c:if>
								<c:if test="${health.userange==2}"><td>组织内</td></c:if>
								<c:if test="${health.userange==3}"><td>私人</td></c:if>
								<td>${health.docname}</td>
								<td><fmt:formatDate value="${health.updatetime}" pattern="yyyy-MM-dd"/></td>
								<td>
								<c:if test="${health.createid eq userInfo.id}">
									<a href="editHealth?id=${health.heducationid }">修改</a>
									<a href="javascript: void(0);" class="mar-left" onclick="deleteHealthdele('<%=path %>/health/deleteHealth?id=${health.heducationid}');">删除</a>
								</c:if>
								<c:if test="${health.createid ne userInfo.id}">
									<span>修改</span>
									<span class="mar-left">删除</span>
								</c:if>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
			<div class="page-box">
				<jsp:include page="/public/pageFoot.jsp"></jsp:include>
			</div>
		</div>
	</form>
</div>
</body>
</html>
								