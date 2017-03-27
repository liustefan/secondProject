<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt"%>
 <%
String path = request.getContextPath();
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9">
<title>会员类型管理</title>

<link rel="stylesheet" type="text/css" href="<%=path %>/css/general.css">
<script src="<%=path %>/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		  $("#btnadd").click(function(){
			window.location = "<%=path %>/memberType/edit/0";
          }); 
	});
	
	function deleteType(memId){
		if (!confirm('确认删除吗？')){
			return;
		}
		
	$.ajax({
             type: "POST",
             url: "<%=path %>/memberType/delete/" + memId,
             dataType: "json",
             cache:false,
             success: function(data){
            	 alert(data.content);
            	 if(data.status) {
              		window.location = "<%=path %>/memberType/listMemberType";
            	 }
              }
         });
		
	}
</script>
<style>
#tabel_content { margin-bottom: 20px;}
#tabel_content tr:nth-child(odd) input{background:none;border:none;font-family:微软雅黑;text-align:center;}
#tabel_content tr:nth-child(even) input{background:none;border:none;font-family:微软雅黑;text-align:center;}
</style>
</head>

<body>
 <div class="content">
	<div class="content-title">会员类型管理</div>
	<div class="table-box">
		<table class="table-content" id="tabel_content">
			<thead class="table-title">
				<tr>
					<th>会员类型名称</th>
					<th>会员类型描述</th>
					<th>标志</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
			    <c:forEach items="${typeList }" var="item">
			       <tr>
					   <td><%-- <s:property value="memName"/> --%>
					   <input type='text' title='${item.memname}' value='${fn:substring(item.memname,0,10) }' readonly/>
					   </td>
		               <td>
		               	<input type='text' title='${item.memdesc}' value='${fn:substring(item.memdesc,0,10) }' readonly/>
		               </td>
		               <td>${item.tag eq 'T' ? '有效' : '无效' }</td>
		               <td id="table_content_title_td"><a href="<%=path %>/memberType/edit/${item.memid }">修改</a>&nbsp;&nbsp;<a onclick="deleteType(${item.memid })" href="#">删除</a></td>
		             </tr>
			    </c:forEach>
			</tbody>
		</table>
	</div>
	<div class="align-center"><button type="button" id="btnadd" class="btn-inquiry">添加</button></div>
</div>
</body>
</html>