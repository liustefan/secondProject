<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>会员标签分类管理</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">

	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script type="text/javascript">
		var index = layer.getFrameIndex(window.name); //获取窗口索引
		
		function editClassify(title,id) {
			layer.closeAll();
			layer.open({
		   	    type: 2,
		   		skin : 'skin1',
		   	    title: title,
		   	    shadeClose: false,
		   	    shade: 0,
		   	    area: ['500px', '350px'],
		   	    content: 'editLabelClass?id=' + id, //iframe的url
		   	 	success: function(msg) {
		   	    	if(msg.status) {
						window.location.href ="window.location.href" ;
					}
		   	    }
		   	}); 
		};
		
		function addLabelClass(title) {
			layer.closeAll();
			layer.open({
		   	    type: 2,
		   		skin : 'skin1',
		   	    title: title,
		   	    shadeClose: false,
		   	    shade: 0,
		   	    area: ['500px', '350px'],
		   	    content: 'editLabelClass', //iframe的url
		   	    success: function(msg) {
		   	    	if(msg.status) {
						window.location.href ="window.location.href" ;
					}
		   	    }
		   	}); 
			layer.close(index);
		};
		
		function deleteClassify(url,name,status){
			var msg = '您确定要删除'+name+'标签分类吗？'
			if(status==1){
				msg = ''+name+'为系统标签不可删除！'
			}
			layer.closeAll();
			layer.confirm( msg, {
				title : '提示信息',
				skin : 'skin1',
				shade : 0,
				btn : [ '确定', '取消' ]
			}, function(index) {
				$.ajax({
					url: url,
				   type: "POST",
				success: function(data) {
						if(data.status) {
							layer.alert(data.content, {icon: 1, shade : 0}, function(){
								location.href="../labelClass/deleteLabelClass?id=${label.lclassid}";
					     		window.location.reload();
							})
				     	}else {
							layer.msg(data.content, {time: 2000, icon:0});
				     	}
				}
				});
			});
		}
	</script>
</head>
<body>
<div class="content">
	<div class="content-title">
   		会员标签分类管理
	</div>
    <form action="<%= path%>/labelClass/listLabelClass" method="POST" id="pojo">
		<div class="search-box-wrapper">
			<ul class="search-wrapper">
				<li>
					<label>标签分类：</label>
	                <input type="text" maxlength="10" name="classname" value="${pojo.classname}">
				</li>
				<li>
					<button type="button" class="btn-inquiry ico-search" onclick="search(1)">查询</button>
					<button type="button" class="btn-inquiry ico-add" onclick='addLabelClass("新增标签分类")'>新增</button>
				</li>
			</ul>
		</div>
		<div class="table-box">
			<c:if test="${page.totalCount == 0}">
		  			<div class="empty-info border-1-solid">目前无标签分类信息</div>
	  		</c:if>
			<c:if test="${page.totalCount > 0}">
			<table class="table-content">
				<thead class="table-title">
					<tr>
						<th width="20%">标签分类</th>
						<th>备注</th>
						<th width="20%">更新人</th>
						<th width="20%">更新日期</th>
						<th width="10%">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${page.result}" var="labelClass">
						<tr>
							<td>${labelClass.classname}</td>
							<td>${labelClass.description}</td>
							<td>${labelClass.docname}</td>
							<td><fmt:formatDate value="${labelClass.updatetime}" pattern="yyyy-MM-dd"/></td>
							<td>
							  <c:if test="${labelClass.issystem==0}">
								<a href="javascript: void(0);" onclick='editClassify("修改标签分类",${labelClass.lclassid})'>修改</a>
							  </c:if>
							  <c:if test="${labelClass.issystem==1}">
								<span>修改</span>
							  </c:if>
							  <c:if test="${labelClass.issystem==0}">
								<a href="javascript: void(0);" class="mar-left" onclick="deleteClassify('<%=path %>/labelClass/deleteLabelClass?id=${labelClass.lclassid}','${labelClass.classname}','${label.issystem}');">删除</a> 
							  </c:if>
							  <c:if test="${labelClass.issystem==1}">
								<span class="mar-left">删除</span>
							  </c:if>
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
