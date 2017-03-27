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
	<title>群体管理方案</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/js/jquery-ui/themes/overcast/jquery-ui.min.css">
	<link rel="stylesheet" href="<%=path %>/plugins/font-awesome/css/font-awesome.min.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-ui/jquery-ui.js"></script>
	<script type="text/javascript" src="<%=path %>/js/dataPacker.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script type="text/javascript" src="<%=path %>/js/wordCount.js"></script>
	<style type="text/css">
		.layer-box {
			margin: 20px;
			font-size: 16px;
			position: relative;
		}
		
		.text-top {
	        vertical-align: text-top;
	    }
	    
	    .fix-position {
	    	position: absolute;
	    	right: 10px;
	    	bottom: 10px;
	    }
	</style>
	<script type="text/javascript">
	function endMode(id){
		layer.closeAll();
		$("#endMode_box").find("input[name='id']").val(id);
		layer.open({
	   	    type: 1,
	   		skin : 'skin1',
	   	    title: '终止方案',
	   	    shadeClose: false,
	   	    shade: 0,
	   	    area: ['465px', '200px'],
	   	 	content: $("#endMode_box"), //iframe的url
	   	}); 
	}
	function del(id) {
		layer.confirm("确定要删除？", {
			  skin : 'skin1',
			  shade: 0,
		      btn: ['确认','取消'] //按钮
		  }, function(i){
			  $.ajax({
				   type: "get",
				   url:  "delete",
				   data: {id: id},
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
	<div class="content-title">群体管理方案</div>
    <form action="listGroup" method="POST" id="">
		<div class="search-box-wrapper">
			<ul class="search-wrapper">
				<li>
					<label>管理方案：</label>
					<input type="text" name="schemeTitle" value="${pojo.schemeTitle }" maxlength="20">
				</li>
				<li>
					<label>方案状态：</label>
	               	<select name="massStatus">
          	          <option value="">请选择</option>
			          <option value="1" <c:if test="${pojo.massStatus eq 1}">selected="selected"</c:if>>制定中</option>
			          <option value="2" <c:if test="${pojo.massStatus eq 2}">selected="selected"</c:if>>已生效</option>
			          <option value="3" <c:if test="${pojo.massStatus eq 3}">selected="selected"</c:if>>已终止</option>
		        	</select>
				</li>
				<li>
					<label>创建日期：</label> 
					<input class="info-date" id="startDate" type="text" name="createTimeS" required="required" value='<fmt:formatDate value='${pojo.createTimeS}' pattern="yyyy-MM-dd"/>' readonly /> 
					<span class="mar-left">至</span> 
					<input class="info-date" id="endDate" type="text" name="createTimeE" required="required" value='<fmt:formatDate value='${pojo.createTimeE}' pattern="yyyy-MM-dd"/>' readonly />
				</li>
				<li>
					<label>任务生成状态：</label>
	               	<select name="massEffectProcess">
			          	<option value="">请选择</option>
			            <option value="1" <c:if test="${pojo.massEffectProcess eq 1}">selected="selected"</c:if>>未触发</option>
				        <option value="2" <c:if test="${pojo.massEffectProcess eq 2}">selected="selected"</c:if>>生成中</option>
				        <option value="3" <c:if test="${pojo.massEffectProcess eq 3}">selected="selected"</c:if>>已生成</option>
				        <option value="4" <c:if test="${pojo.massEffectProcess eq 4}">selected="selected"</c:if>>生成失败</option>
		        	</select>
				</li>
				<li>
					<button type="button" class="btn-inquiry ico-search" onclick="search(1)">查询</button>
					<button type="button" class="btn-inquiry" onclick="window.location.href='toEditGroup'">制定群体管理方案</button>
				</li>
			</ul>
		</div>
		<div class="table-box">
			<c:if test="${page.totalCount == 0}">
		  			<div class="empty-info border-1-solid">目前还没有群体管理方案信息</div>
	  		</c:if>
	  		<c:if test="${page.totalCount > 0}">
			<table class="table-content">
				<thead class="table-title">
					<tr>
						<th>管理方案</th>
						<th>创建日期</th>
						<th>生效日期</th>
						<th>方案状态</th>
						<th>任务生成状态</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${page.result}" var="item">
					<tr>
						<td><a href="toEditGroup?id=${item.MSDesignID}&view=true"><c:out value="${item.schemeTitle }" escapeXml="true"/></a></td>
						<td><fmt:formatDate value='${item.createTime }' pattern="yyyy-MM-dd"/></td>
						<td><fmt:formatDate value='${item.massEffectTime }' pattern="yyyy-MM-dd"/></td>
						<td>${item.massStatusName }</td>
						<td>${item.massEffectProcessName }</td>
						<td>
							<c:choose>
								<c:when test="${item.massStatus eq 3}">
									<span>终止</span>
									<span class="mar-left">修改</span>
									<span class="mar-left">删除</span>
								</c:when>
								<c:otherwise>
								<c:if test="${item.massStatus eq 1}">
									<span>终止</span>
								</c:if>
								<c:if test="${item.massEffectProcess eq 2}">
									<span>终止</span>
									<span class="mar-left">修改</span>
									<span class="mar-left">删除</span>
								</c:if>
								<c:if test="${item.massEffectProcess ne 2}">
									<c:if test="${item.massStatus ne 1}">
										<a href="javascript: void(0);" onclick="endMode(${item.MSDesignID});">终止</a>
									</c:if>
									<a href="toEditGroup?id=${item.MSDesignID}" class="mar-left">修改</a>
									<c:if test="${item.massStatus eq 1}">
									<a href="javascript: void(0);" class="mar-left" onclick="del(${item.MSDesignID})">删除</a>
									</c:if>
									<c:if test="${item.massStatus ne 1}">
										<span class="mar-left">删除</span>
									</c:if>
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
<div id="endMode_box" style="display: none;">
	<form action="terminatedManagescheme" method="post">
		<input type="hidden" name="id">
		<input type="hidden" name="schemeType" value="2">
		<div class="layer-box wordCount" id="wordCount">
			<span>终止原因：</span>
			<textarea rows="3" cols="45" class="text-top" name="massOffReason" maxlength="50"></textarea>
			<span class="fix-position wordwrap"><span class="word red">50</span>/50字</span>
		</div>
		<div class="page-box align-center">
			<input type="submit" class="btn-inquiry" value="保存">
			<input type="button" class="btn-cancel" onclick="layer.closeAll();" value="取消">
		</div>
	</form>
</div>
</body>
</html>
