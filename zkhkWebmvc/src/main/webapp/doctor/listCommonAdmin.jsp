<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
    <title>管理员列表</title>
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/general.css">
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
    <script type="text/javascript" src="<%=path %>/js/showAllDoctors.js"></script>
 </head>
 <body>
 <div class="content">
 	<div class="content-title">管理员列表</div>
 	<div class="clearfix" style="padding-bottom: 8px;">
		<input type="button" onclick="window.location='<%=path %>/doctor/edit/0'" class="btn-normal fr" value="创建管理员" />
 	</div>
    <c:if test="${page.totalCount eq 0}">
		<div class="empty-info border-1-solid">目前还没有用户信息</div>
	</c:if>
	<c:if test="${page.totalCount gt 0}">
		<div class="table-box">
			<table class="table-content">
			    <thead class="table-title">
	                <tr>
			    		<th width="15%">ID</th>
			    		<th width="15%">登录账号</th>
			    		<th width="15%">姓名</th>
			    		<th width="40%">归属医院</th>
			    		<th width="15%">操作</th>
		    		</tr>
		    	</thead>
		    	<tbody>
		    	    <c:forEach items="${page.result }" var="odoc">
				    	<tr align="center">
		    				<td>${odoc.docid }</td>
		    				<td>${odoc.doctorAccount.docacc }</td>
		    				<td>${odoc.docname }</td>
		    				<td>${odoc.orgName}</td>
		    				<td>
		    					<a href="javascript: void(0);" onclick="resertPwd('<%=path%>/doctor/reset?docid=${odoc.docid }&orgid=${odoc.orgid}&roleid=${odoc.roleid }');"><span>重置密码</span></a>
		    					<a href="<%=path%>/doctor/viewDoctorDetail?docid=${odoc.docid }" >
		    						<span>查看</span>
		    					</a>
		    					<a href="<%=path %>/doctor/edit/${odoc.docid }"><span>修改</span></a>
								<a href="javascript: void(0);" onclick="removeRecord('<%=path%>/doctor/delete?docid=${odoc.docid }&orgid=${odoc.orgid}&roleid=${odoc.roleid }');" ><span>删除</span></a>				
		    				</td>
		   				</tr>
			    	</c:forEach>
			    </tbody>
	   		</table>
		    <div class="page-box">
				<form action="<%=path %>/doctor/listCommonAdmin" method="post" id="comAdminForm">
					<jsp:include page="/public/pageFoot.jsp"></jsp:include>
		        </form>
		     </div>
	     </div>
	</c:if>
</div>
</body>
</html>