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
	<title>个人管理方案</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/js/jquery-ui/themes/overcast/jquery-ui.min.css">
	<link rel="stylesheet" href="<%=path %>/plugins/font-awesome/css/font-awesome.min.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-ui/jquery-ui.js"></script>
	<script type="text/javascript" src="<%=path %>/js/dataPacker.js"></script>
	<script type="text/javascript" src="<%=path %>/js/wordCount.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
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
		var index = layer.getFrameIndex(window.name); //获取窗口索引
		
		function chooseMember() {
			layer.closeAll();
			layer.open({
		   	    type: 2,
		   		skin : 'skin1',
		   	    title: '选择会员',
		   	    shadeClose: false,
		   	    shade: 0,
		   	    area: ['900px', '485px'],
		   	    content: 'listMember', //iframe的url
		   	}); 
		}
		
		function chooseMemberCallback(memberId){
			layer.closeAll();
			window.location.href = "toEditPerson?memberId="+memberId;
		}
		
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
	</script>
</head>
<body>
<div class="content">
	<div class="content-title">个人管理方案</div>
    <form action="listPerson" method="POST" id="">
		<div class="search-box-wrapper">
			<ul class="search-wrapper">
				<li>
					<label>会员姓名：</label>
					<input type="text" name="memName" value="${pojo.memName}" maxlength="20">
				</li>
				<li>
					<label>手机号码：</label>
					<input type="text" name="tel" value="${pojo.tel}" maxlength="11">
				</li>
				<li>
					<label>状态：</label>
	               	<select name="execStatus">
			            <option value="">全部</option>
			          	<option value="1" <c:if test="${pojo.execStatus eq 1}">selected="selected"</c:if>>制定中</option>
			          	<option value="2" <c:if test="${pojo.execStatus eq 2}">selected="selected"</c:if>>执行中</option>
			          	<option value="3" <c:if test="${pojo.execStatus eq 3}">selected="selected"</c:if>>无任务</option>
			          	<option value="4" <c:if test="${pojo.execStatus eq 4}">selected="selected"</c:if>>已终止</option>
		        	</select>
				</li>
				<li>
					<label>管理方案：</label>
					<input type="text" name="design.schemeTitle" value="${pojo.design.schemeTitle}" maxlength="20">
				</li>
				<li>
					<label>创建日期：</label> 
					<input class="info-date" id="startDate" type="text" name="createTimeS" required="required" value='<fmt:formatDate value='${pojo.createTimeS}' pattern="yyyy-MM-dd"/>' readonly /> 
					<span class="mar-left">至</span> 
					<input class="info-date" id="endDate" type="text" name="createTimeE" required="required" value='<fmt:formatDate value='${pojo.createTimeE}' pattern="yyyy-MM-dd"/>' readonly />
				</li>
				<li>
					<button type="button" class="btn-inquiry ico-search" onclick="search(1)">查询</button>
					<button type="button" class="btn-inquiry" onclick="chooseMember()">制定个人管理方案</button>
				</li>
			</ul>
		</div>
		<div class="table-box">
			<c:if test="${page.totalCount == 0}">
		  			<div class="empty-info border-1-solid">目前暂无数据</div>
	  		</c:if>
	  		<c:if test="${page.totalCount > 0}">
			<table class="table-content">
				<thead class="table-title">
					<tr>
						<th width="10%">会员姓名</th>
						<th width="8%">性别</th>
						<th width="10%">手机号码</th>
						<th>会员标签</th>
						<th width="15%">管理方案</th>
						<th width="10%">状态</th>
						<th width="10%">创建日期</th>
						<th width="10%">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${page.result}" var="item">
					<tr>
						<td>${item.memName}</td>
						<td>${item.gender eq 1 ? '男' : item.gender eq 2 ? '女' : '未知'}</td>
						<td>${item.tel}</td>
						<td>${item.memberLabelsStr}</td>
						<td><a href="toEditPerson?id=${item.MSDesignID}&view=true"><c:out value="${item.design.schemeTitle}" escapeXml="true"/><a></td>
						<td>${item.execStatusName}</td>
						<td><fmt:formatDate value='${item.createTime}' pattern="yyyy-MM-dd"/></td>
						<td>
							<c:choose>
								<c:when test="${item.execStatus eq 4}">
									<span>修改</span>
									<span class="mar-left">终止</span>
								</c:when>
								<c:otherwise>
									<a href="toEditPerson?id=${item.MSDesignID}">修改</a>
									<a href="javascript: void(0);" class="mar-left" onclick="endMode(${item.MSDesignID});">终止</a>
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
		<input type="hidden" name="schemeType" value="1">
		<div class="layer-box wordCount" id="wordCount">
			<span>终止原因：</span>
			<textarea rows="3" cols="45" class="text-top" name="massOffReason" maxlength="50"></textarea>
			<span class="fix-position wordwrap"><span class="word red">50</span>/50字</span>
		</div>
		<div class="page-box align-center">
			<input type="submit" class="btn-inquiry" value="保存">
			<input type="button" class="btn-cancel" onclick="layer.closeAll()" value="取消">
		</div>
	</form>
</div>
</body>
</html>
