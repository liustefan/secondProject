<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>会员所有套餐列表</title>
    <link rel="stylesheet" type="text/css" href="<%=path %>/css/general.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/vip.css">
    <script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>

	<script type="text/javascript">
		$(function(){
			var status = '${member.status}';
			if(status == 'F'){
				//会员状态为冻结时，修改、删除、查看、新增功能不可用
				$("a").attr("onclick","return false");
			}else{
				$("#add").click(function(){
	         		var id ="${memberPackag.memberid}";
					window.location = "${pageContext.request.contextPath}/package/toAddMemberPackagePage?memberid="+id;
	          }); 
			}
		});
	</script>
</head>
<body>
<div class="content">
	<div class="content-title">
		会员所有套餐列表
	</div> 
	<div class="table-box">
		<table class="table-content">
			<thead class="table-title">
				<tr>
					<th>会员代码</th>
					<th>套餐名称</th>
					<th>创建时间</th>
					<th>创建人姓名</th>
					<th>标记</th>
					<th>套餐明细</th>
					<th>修改</th>
					<th>删除</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${memPackageList}" varStatus="status">
					<tr>
					   <td>${item.memberid }</td>
		               <td>${item.packag.packageName }</td>
		               <td>
		               	 <fm:formatDate value="${item.createTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" dateStyle="long"/>
		               </td>
		               <td>${item.createName }</td>
		               <td>${item.tag =='T'?'有效':'无效' }</td>
					   <td id="table_content_title_td">
					   		<a href="${pageContext.request.contextPath}/package/getMemberPackageDetail?memberid=${item.memberid }&lineNum=${item.lineNum }&packageCode=${item.packageCode }">查看明细</a>
					   </td>
		               <td id="table_content_title_td">
		               		<a href="${pageContext.request.contextPath}/package/toEidtMemberPackagePage?memberid=${item.memberid }&lineNum=${item.lineNum }">修改</a>
		               </td>
		               <td id="table_content_title_td">
		               		<a onclick="return confirm('确认删除吗？');" href="${pageContext.request.contextPath}/package/deleteMemberPackage?memberid=${item.memberid }&lineNum=${item.lineNum }">删除</a>
		               	</td>
		             </tr>
	           	 </c:forEach>
			</tbody>
		</table>
		<div class="page-box align-center">
			<button type="button" id="add" class="btn-inquiry">添加</button>
		</div>
	</div>
</div>
</body>
</html>