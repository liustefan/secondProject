<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
    <title>载入单份问卷</title>
   	<link rel="stylesheet" href="<%=path %>/css/general.css">
	
	<script src="<%=path %>/js/jquery-1.9.1.min.js"></script>
</head>
<body>
	<div class="content">
		<form id="" name="" action="chooseQust">
			<input type="hidden" name="ansMode" value="${ansMode}">
			<div class="search-box-wrapper">
				<ul class="search-wrapper clearfix">
					<li>
						<label>问卷名称：</label>
						<input name="qustName" value="${qustName}">
					</li>
					<li>
						<button type="button" onclick="search(1)" class="btn-inquiry ico-search">查询</button>
					</li>
				</ul>
	 		</div>
			<div class="table-box">
			<c:if test="${page.totalCount == 0}">
				<div class="empty-info  border-1-solid align-center"> 
					<span class="empty-info">目前还没有相关问卷信息</span>
				</div>
			</c:if>
			<c:if test="${page.totalCount > 0}">
	   			<table class="table-content">
	   		    	<thead class="table-title">
	   		    		<tr>
	   		    			<th>问卷名称</th>
	   		    			<th>评测方式</th>
	   		    			<th>版本号</th>
	   		    			<th>操作</th>
	   		    		</tr>
	   		    	</thead>
	   		    	<tbody>
	   		    		<c:forEach items="${page.result}" var="omfq" varStatus="status">
				    		<tr>
				    			<td class="th_td_name" width="35%" ><c:out value="${omfq.qustname}" escapeXml="true"/></td>
				    			<td class="th_td_title" width="25%" >${omfq.ansMode==1?'自评':'测评'}</td>
				    			<td class="th_td_title" width="25%" >${omfq.qustVer}</td>
				    			<td class="th_td_title" width="25%" ><a href="javascript:void(0);parent.addQustCallback(${omfq.qustid}, '<c:out value='${omfq.qustname}' escapeXml='true'/>', ${omfq.ansMode})">选择</a></td>
				    		</tr>
			    		</c:forEach>
	   		    	</tbody>
   		    	</table>
   		    	</c:if>
	    	</div>
	    	<div class="page-box">
				<jsp:include page="/public/pageFoot.jsp"/>
			</div>
		</form>
	</div>
</body>
</html>
