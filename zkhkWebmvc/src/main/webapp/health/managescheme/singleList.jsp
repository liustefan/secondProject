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
	<title>单一会员管理方案</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/js/jquery-ui/themes/overcast/jquery-ui.min.css">
	<link rel="stylesheet" href="<%=path %>/plugins/font-awesome/css/font-awesome.min.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-ui/jquery-ui.js"></script>
	<script type="text/javascript" src="<%=path %>/js/dataPacker.js"></script>
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
		
		function endMode(id, MSExecID, schemeType){
			layer.closeAll();
			$("#endMode_box").find("input[name='id']").val(id);
			$("#endMode_box").find("input[name='MSExecID']").val(MSExecID);
			$("#endMode_box").find("input[name='schemeType']").val(schemeType);
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
	<div class="content-title">管理方案</div>
    <form action="singleList" method="POST" id="">
    	<input type="hidden" name="memberID" value="${pojo.memberID}">
		<div class="search-box-wrapper">
			<ul class="search-wrapper">
				<li>
					<label>管理方案：</label>
					<input type="text" name="design.schemeTitle" value="${pojo.design.schemeTitle}">
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
					<button type="button" class="btn-inquiry ico-search" onclick="search(1)">查询</button>
					<c:choose>
						<c:when test="${isMy and empty hasMs and member.status eq 'T'}">
							<button type="button" class="btn-inquiry" onclick="window.location.href='toEditPerson?memberId=${pojo.memberID}&source=singleList?memberID=${pojo.memberID}'">制定个人管理方案</button>
						</c:when>
						<c:otherwise>
							<button type="button" class="btn-cancel">制定个人管理方案</button>
						</c:otherwise>
					</c:choose>
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
						<th width="12%">类别</th>
						<th width="18%">管理方案</th>
						<th width="10%">状态</th>
						<th width="10%">更新人</th>
						<th width="12%">创建日期</th>
						<th width="10%">终止人</th>
						<th>终止原因</th>
						<th width="10%">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${page.result}" var="item">
					<tr>
						<td>${item.design.schemeTypeName}</td>
						<td><a href="${item.design.schemeType eq 1 ? 'toEditPerson' : 'toEditGroup'}?id=${item.design.MSDesignID}&view=true&source=singleList?memberID=${pojo.memberID}"><c:out value="${item.design.schemeTitle}" escapeXml="true"/><a></td>
						<td>${item.execStatusName}</td>
						<td>${item.updateID ne 0 ? empty item.updateName ? item.createName : item.updateName : '系统'}</td>
						<td><fmt:formatDate value='${item.createTime}' pattern="yyyy-MM-dd"/></td>
						<c:if test="${item.execStatus eq 4}">
							<td>${item.updateID ne 0 ? item.updateName : '系统'}</td>
							<td>${item.execOffReason}</td>
						</c:if>
						<c:if test="${item.execStatus ne 4}">
						<td></td><td></td>
						</c:if>
						<td>
							<c:choose>
								<c:when test="${!isMy || item.execStatus eq 4 || userInfo.id ne item.createID}">
									<span>修改</span>
									<span class="mar-left">终止</span>
								</c:when>
								<c:otherwise>
									<c:if test="${item.design.schemeType eq 2}">
										<span>修改</span>
									</c:if>
									<c:if test="${item.design.schemeType eq 1}">
										<a href="toEditPerson?id=${item.MSDesignID}&source=singleList?memberID=${item.memberID}">修改</a>
									</c:if>
									<a href="javascript: void(0);" class="mar-left" onclick="endMode(${item.MSDesignID}, ${item.MSExecID}, ${item.design.schemeType});">终止</a>
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
	<form action="singleTerminatedManagescheme?source=singleList?memberID=${pojo.memberID}" method="post">
		<input type="hidden" name="id">
		<input type="hidden" name="MSExecID">
		<input type="hidden" name="schemeType">
		<div class="layer-box">
			<span>终止原因：</span>
			<textarea rows="3" cols="45" class="text-top" name="massOffReason" maxlength="50"></textarea>
			<span class="fix-position">50字</span>
		</div>
		<div class="page-box align-center">
			<input type="submit" class="btn-inquiry" value="保存">
			<input type="button" class="btn-cancel" onclick="layer.closeAll()" value="取消">
		</div>
	</form>
</div>
</body>
</html>
