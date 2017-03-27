<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE HTML>
<html>
<head>
   	<title>会员转移页面</title>
   	<meta charset="utf-8">
   	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/css/comm.css">
	<link rel="stylesheet" href="<%=path %>/js/jquery-ui/themes/overcast/jquery-ui.min.css">
	<link rel="stylesheet" href="<%=path %>/plugins/font-awesome/css/font-awesome.min.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-ui/jquery-ui.js"></script>
	<script type="text/javascript" src="<%=path %>/js/dataPacker.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script type="text/javascript">
		function deleteRecord(msg) {
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
					alert(data.content);
	 		     	if(data.status) {
	 		     		window.location.reload();
	 		     	}
				}
				});
			});
		}
		
		function dispose(){
			layer.closeAll();
			layer.open({
		   	    type: 2,
		   		skin : 'skin1',
		   	    title: '提示信息',
		   	    shadeClose: false,
		   	    shade: 0,
		   	    area: ['650px', '350px'],
		   	    content: 'chooseResult.html', //iframe的url
		   	}); 
		}
	</script>
</head>
  
<body>
  <div class="content">
	  <div class="content-title">会员转移</div>
	  <nav>
	  	<ul class="clearfix">
	  		<c:choose>
	  			<c:when test="">
	  				<li class="active">转入申请</li>
					<li><a href="">转出处理</a></li>
  				</c:when>
  				<c:otherwise>
					<li><a href="">转入申请</a></li>
  					<li class="active">转出处理</li>
  				</c:otherwise>
  			</c:choose>
	  	</ul>
	  </nav>
	  <form action="" id="">
		  <div class="search-box-wrapper">
				<ul class="search-wrapper clearfix">
					<li>
						<label>会员姓名:</label>
		                <input class="info-name" type="text" name="member.memname" value="${pojo.member.memname}">
					</li>
					<li>
						<label>手机号码:</label>
		                <input class="info-tel" type="text" name="member.tel" value="${pojo.member.tel}">	
					</li>
					<li>
						<label>身份证号码:</label>
		                <input class="info-idCard" type="text" name="member.idcard" value="${pojo.member.idcard}">
					</li>
					<li>
						<label>申请日期:</label>
	                    <input class="info-date" id="startDate" type="text" name="startVisitDate" value="<fmt:formatDate value="${pojo.startVisitDate}" pattern="yyyy-MM-dd"/>" readonly="readonly"/>
	                    <span style="padding-left: 8px;">至</span>
	                    <input class="info-date" id="endDate" type="text" name="endVisitDate" value="<fmt:formatDate value="${pojo.endVisitDate}" pattern="yyyy-MM-dd"/>" readonly="readonly"/>
					</li>
					<li>
						<label>状态:</label>
						<select class="info-result free-width" name="visitClass" onchange="search()">
	               			<option value="0">全部</option>
	               			<option value="1">待确认</option>
	               			<option value="2">已同意</option>
	               			<option value="3">已拒绝</option>
	               		</select>
					</li>
					<li>
						<button type="button" onclick="" id="" class="btn-inquiry ico-search">查询</button>	
						<c:if test="">
  							<button type="button" onclick="" class="btn-inquiry ico-add">新增</button>
						</c:if>
					</li>
				</ul>
		 </div>

	      <div class="table-box"> 
		  		<c:if test="${page.totalCount == 0}">
		  			<div class="empty-info border-1-solid">目前还没有会员转移信息</div>
		  		</c:if>
				<c:if test="${page.totalCount > 0}">
			   		<table class="table-content">
			   		    <thead class="table-title">
			    		<tr>
				    		<th width="6%">会员姓名</th>
				    		<th width="8%">手机号码</th>
			    			<th width="20%">转出组织</th>
				    			<th width="20%">转入组织</th>
				    			<th width="6%">申请医生</th>
				    		<th width="8%">申请时间</th>
			    			<th width="6%">确认医生</th>
				    		<th width="8%">确认时间</th>
				    		<th width="20%">拒绝原因</th>
				    		<th width="6%">状态</th>
				    		<th>操作</th>
			    		</tr>
			    		</thead>
			    		<tbody>
			    			<tr>
					    		<td></td>
					    		<td></td>
					    		<td></td>
					    		<td></td>
					    		<td></td>
					    		<td></td>
					    		<td></td>
					    		<td></td>
					    		<td></td>
					    		<td></td>
					    		<td>
					    			<a href="javascript: void(0);" onclick="">确认</a>
									<a href="javascript: void(0);" class="mar-left" onclick="delete('您确定要删除当前记录吗？')">删除</a>
									<a href="javascript: void(0);" onclick="dispose()">处理</a>
					    		</td>
				    		</tr>
			    		</tbody>
			    	</table>
	    		</c:if>
	    		<div class="page-box">
					<jsp:include page="/public/pageFoot.jsp"/>
				</div>
	      </div>
		</form>
	</div>
</body>
</html>
