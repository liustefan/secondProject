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
	<title>选择单项模板</title>
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/general.css">
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
		$(function(){
			 var url = window.location.href;
	         var id = url.substring(url.indexOf( "?") + 4, url.length);
	         var sumRepTempCode = ${sumRepTempCode};
			$("#add").click(function(){
			    var ids =[];
				$("input[name='tempCode']:checked").each(function(){
					ids.push($(this).val());
				});
				if (ids.length == 0) {
					alert("请选择你要添加的单项模板!");
	             return ;
	       	     }
	            var values=ids.toString();
	            window.location= "${pageContext.request.contextPath}/template/addSingelToSumTemplate?sumRepTempCode="+sumRepTempCode+"&tempCodes="+values;
	          }); 
	          
	          $("#return").click(function(){
				   
					window.history.go(-1);
	          }); 
			  
	          }); 
	</script>
</head>
<body>
<div class="content">
<div class="table-box">
	<table class="table-content">
		<thead class="table-title">
		<tr>
			<th>选择</th>
			<th>单项模板代码</th>
			<th>模板名称</th>
			<th>功能选项</th>
<%--			<th>最小记录数</th>--%>
			<th>最少记录天数</th>
<%--			<th>最大间隔天数</th>--%>
			<th>是否审核</th>
			<th>有效标记</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${SingleTemplateList}" varStatus="status">
			<tr style="height: 30px">
			   <td><input name="tempCode" type="checkbox" value="${item.tempCode }"></td>
			   <td>${item.tempCode }</td>
			   <td>${item.tempName }</td>
               <td>
             		<c:if test="${item.optId==1 }">血压</c:if>
			   		<c:if test="${item.optId==2 }">血糖</c:if>
			   		<c:if test="${item.optId==3 }">三合一</c:if>
			   		<c:if test="${item.optId==4 }">动态心电</c:if>
               </td>
               <td>${item.minDisDay }</td>
               <td>${item.chTag=='Y'?'是':'否' }</td>
               <td>${item.valiTag=='T'?'有效':'无效' }</td>
             </tr>
           </c:forEach> 
           </tbody>
	</table>
	<div class="page-box align-center">
	    <button type="button" id="add" title='添加到汇总模板' class="btn-normal">添加</button>
	    <button type="button" id="return" class="btn-normal mar-left">返回</button>
	</div>
</div>
</div>
</body>
</html>