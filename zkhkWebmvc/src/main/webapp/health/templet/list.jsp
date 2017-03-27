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
	<title>管理方案模板</title>
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
		
		function saveTitle(){
			if($("input[name='newSchemeTitle']").val().length > 20){
				alert('方案标题字数超过限制,请重新输入!');
				$("input[name='newSchemeTitle']").focus();
				return;
			}
			$("#form_title").submit();
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
		function copy(id, title){
			layer.closeAll();
			$("#referenceId").val(id);
			$("#newSchemeTitle").val(title+"_副本");
			layer.open({
		   	    type: 1,
		   		skin : 'skin1',
		   	    title: '方案模板拷贝',
		   	    shadeClose: false,
		   	    shade: 0.3,
		   	    area: ['438px', '200px'],
		   	 	content: $("#templetTitle"), //iframe的url
		   	}); 
		}
		function del(id,title) {
			layer.confirm('您确定要删除'+title+'吗？', {
				  skin : 'skin1',
				  shade: 0,
			      btn: ['确认','取消'] //按钮
			  }, function(i){
				  $.ajax({
					   type: "get",
					   url:  "delete",
					   data: {ids: id},
					   success: function(msg){
						   layer.alert(msg.content, {skin: 'skin1', shade: 0, end: function(index){
						    	 if(msg.data)
						    		 window.location.reload();
						     }}, function() {
						    	 if(msg.data)
						    		 window.location.reload();
						     });
					   }
					})
					layer.close(i);
			  }, function(){
			      
			  });
		}
		function updateStatus(id, status, title) {
			layer.confirm("您确定要"+(status == 2 ? '生效' : '作废')+title+"吗？", {
				  skin : 'skin1',
				  shade: 0,
			      btn: ['确认','取消'] //按钮
			  }, function(i){
				  $.ajax({
					   type: "get",
					   url:  "updateStatus",
					   data: {id: id, newStatus: status},
					   success: function(msg){
						   layer.alert(msg.content, {skin: 'skin1', shade: 0, end: function(index){
						    	 if(msg.data)
						    		 window.location.reload();
						     }}, function() {
						    	 if(msg.data)
						    		 window.location.reload();
						     });
					   }
					})
					layer.close(i);
			  }, function(){
			      
			  });
		}
	</script>
</head>
<body>
<div class="content">
	<div class="content-title">
   		管理方案模板
	</div>
    <form action="list" method="GET" id="">
		<div class="search-box-wrapper">
			<ul class="search-wrapper">
				<li>
					<label>方案标题：</label>
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
					<label>使用范围：</label>
	                <select name="useRange">
						<option value="0">全部</option>
						<option value="1" <c:if test="${pojo.useRange eq 1}">selected="selected"</c:if>>全局</option>
						<option value="2" <c:if test="${pojo.useRange eq 2}">selected="selected"</c:if>>组织内</option>
						<option value="3" <c:if test="${pojo.useRange eq 3}">selected="selected"</c:if>>私人</option>
					</select>
				</li>
				<li>
					<label>状态：</label>
	                <select name="templetStatus">
						<option value="">全部</option>
						<option value="1" <c:if test="${pojo.templetStatus eq 1}">selected="selected"</c:if>>新增</option>
						<option value="2" <c:if test="${pojo.templetStatus eq 2}">selected="selected"</c:if>>已生效</option>
						<option value="3" <c:if test="${pojo.templetStatus eq 3}">selected="selected"</c:if>>已作废</option>
					</select>
				</li>
				<li>
					<button type="button" class="btn-inquiry ico-search" onclick="search(1)">查询</button>
					<button type="button" class="btn-inquiry ico-add" onclick="window.location.href='toEdit'">新增</button>
				</li>
			</ul>
		</div>
		<div class="table-box">
			<c:if test="${page.totalCount == 0}">
		  			<div class="empty-info border-1-solid">目前还没有管理方案模板信息</div>
	  		</c:if>
			<c:if test="${page.totalCount > 0}">
			<table class="table-content">
				<thead class="table-title">
					<tr>
						<th>方案标题</th>
						<th width="15%">适用疾病分类</th>
						<th width="10%">使用范围</th>
						<th width="10%">更新人</th>
						<th width="10%">更新日期</th>
						<th width="10%">被使用次数</th>
						<th width="8%">状态</th>
						<th width="15%">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${page.result}" var="item">
					<tr>
						<td><a href="toEdit?id=${item.MSTempletID}&view=true"><c:out value="${item.schemeTitle}" escapeXml="true"/></a></td>
						<td>
						<c:forEach items="${item.diseases}" var="ds" varStatus="vs">
							${ds.diseaseName}<c:if test="${fn:length(item.diseases) > vs.index+1}">、</c:if>
						</c:forEach>
						</td>
						<td>${item.useRangeName}</td>
						<td>${item.updateName}</td>
						<td><fmt:formatDate value='${item.updateTime}' pattern="yyyy-MM-dd"/></td>
						<td>${item.usedNumber}</td>
						<td>${item.templetStatusName}</td>
						<td>
							<a href="javascript: void(0);" onclick="copy(${item.MSTempletID}, '<c:out value="${item.schemeTitle}" escapeXml="true"/>')">拷贝</a>
							<c:choose>
								<c:when test="${userInfo.roleid eq 6 or (userInfo.roleid eq 1 and userInfo.dept_id eq item.orgID) or userInfo.id eq item.createID}">
									<c:if test="${item.templetStatus ne 3}">
									<a href="toEdit?id=${item.MSTempletID}" class="mar-left">修改</a>
									</c:if>
									<c:if test="${item.templetStatus eq 3}">
									<span class="mar-left">修改</span>
									</c:if>
									<c:if test="${item.templetStatus ne 2}">
									<a href="javascript: void(0);" class="mar-left" onclick="del('${item.MSTempletID}','${item.schemeTitle}')">删除</a>
									</c:if>
									<c:if test="${item.templetStatus eq 2}">
									<span class="mar-left">删除</span>
									</c:if>
									<c:if test="${item.templetStatus eq 1}">
									<a href="javascript: void(0);" class="mar-left" onclick="updateStatus('${item.MSTempletID}', '2', '${item.schemeTitle}')">生效</a>
									</c:if>
									<c:if test="${item.templetStatus eq 2}">
									<a href="javascript: void(0);" class="mar-left" onclick="updateStatus('${item.MSTempletID}', '3', '${item.schemeTitle}')">作废</a>
									</c:if>
									<c:if test="${item.templetStatus eq 3}">
									<span class="mar-left">作废</span>
									</c:if>	
								</c:when>
								<c:otherwise>
									<span class="mar-left">修改</span>
									<span class="mar-left">删除</span>
									<c:if test="${item.templetStatus eq 1}">
										<span class="mar-left">生效</span>
									</c:if>
									<c:if test="${item.templetStatus eq 2 || item.templetStatus eq 3}">
										<span class="mar-left">作废</span>
									</c:if>
								</c:otherwise>
							</c:choose>
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
<div id="templetTitle" style="display: none;">
	<form action="copyToEdit" method="post" id="form_title">
		<input type="hidden" name="referenceId" id="referenceId">
		<div class="layer-box">
			<span>标题：</span>
			<input type="text" name="newSchemeTitle" id="newSchemeTitle">
		</div>
		<div class="page-box align-center">
			<input type="button" class="btn-inquiry" value="保存" onclick="saveTitle();">
			<input type="button" class="btn-cancel" onclick="layer.closeAll();" value="取消">
		</div>
	</form>
</div>
</body>
</html>
