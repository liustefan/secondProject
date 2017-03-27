<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>服务套餐</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<script src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	
	<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<script type="text/javascript">
		$(function(){
		  	$("#btnadd").click(function(){
				window.location = "${pageContext.request.contextPath}/package/toPackageEditPage";
		    }); 
		  	(function(){
		  		if("${msg}")alert("${msg}");
		  	})();
		});
	</script>
</head>
<body>
<div class="content">
    <c:if test="${fn:length(packagList) == 0}">
	    <div class="empty-info">还没有服务套餐</div>
	    <div class="align-center">
	        <button type="button" id="btnadd" class="btn-inquiry">添加</button>
	    </div>
    </c:if>
	
	<c:if test="${fn:length(packagList) != 0}">
		<div class="content-title">
			服务套餐列表
		</div>
		<div class="table-box">
			<table class="table-content">
				<thead class="table-title">
					<tr>
						<th>套餐代码</th>
						<th>套餐名称</th>
						<th>套餐描述</th>
						<th>价格</th>
						<th>套餐级别</th>
						<th>创建时间</th>
						<th>创建人姓名</th>
						<th>使用标记</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${packagList}" varStatus="status">
						<tr>
						   <td>${item.packageCode}</td>
			               <td>${item.packageName}</td>
			               <td>${item.packageDesc}</td>
			               <td>${item.price}</td>
			               <td>${item.packageLevel}</td>
			               <td>
			               <fm:formatDate value="${item.createTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" dateStyle="long"/>
			         		</td>
			               <td>${item.createName}</td>
			               <td>${item.useTag =='T'?'有效':'无效' }</td>
			               <td>
			               		<a href="../package/toPackageEditPage?packageCode=${item.packageCode }">修改</a>&nbsp;&nbsp;
			               		<a onclick="return confirm('确认删除吗？');" href="../package/deletePackage?packageCode=${item.packageCode }">删除</a>
			               </td>
			             </tr>
			        </c:forEach>  
				</tbody>
			 </table>
		</div>
	 	<div class="align-center page-box">
        	<button type="button" id="btnadd" class="btn-inquiry">添加</button>
   		</div>
	</c:if>
</div>
</body>
</html>