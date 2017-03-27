<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>单项测量审核模板</title>
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/general.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
		$(function(){
			  $("#add_model").click(function(){
				window.location = "${pageContext.request.contextPath}/template/toAddSingleTemplatePage?funId=1";
	          }); 
		});
	
		function validateDel(id){
			var url = "../template/validateDeleteTemplate";
			$.post(	
				url, {
				tempCode : id,
				type:'1'
				},
				function(data){
					if(data != "OK"){
						alert("该单项模板已关联汇总模板，无法删除！");
					}else{
						if(confirm('确认删除吗？')){
							window.location.href="../template/deleteTemplate?tempCode="+id+"&type=1";
						}
					}
				});
		}
	</script>
</head>
<body>
<div class="content">
	<div class="content-title">
		单项测量审核模板
	</div>
	<c:if test="${page.totalCount == 0 }">
		<div class="empty-info">暂无单项测量审核模板</div>
	</c:if>
	<c:if test="${page.totalCount != 0 }">
		<div class="table-box">
			 <table class="table-content">
				 <thead class="table-title">
					<tr>
						<th>模板名称</th>
						<th>测量类型</th>
						<th>最少记录天数</th>
						<th>是否审核</th>
						<th>操作</th>
					</tr>
			    </thead>
			    <tbody>
			    <c:forEach var="item" items="${templatelist}" varStatus="status">
					<tr>
					   <td>${item.tempName}</td>
					   <td>${item.optName}</td>
		               <td>${item.minDisDay}</td>
		               <td>${item.chTag=='Y'?'是':'否' }</td>
		               <td class="table_content_title_td"><a href="../template/toEditSingleTemplate?tempCode=${item.tempCode }">修改</a>&nbsp;
		               <a class="mar-left" href="javascript:validateDel(${item.tempCode});">删除</a></td>
		             </tr>
		         </c:forEach>  
	           </tbody> 
			</table>
			<div class="page-box align-center">
	        	<button type="button" id="add_model" class="btn-inquiry">添加</button>
			</div>	
		</div>
	</c:if>
</div>
</body>
</html>