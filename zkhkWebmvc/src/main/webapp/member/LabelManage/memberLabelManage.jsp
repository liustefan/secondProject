<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>会员标签管理(系统管理员)</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">

	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-ui/jquery-ui.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script type="text/javascript" src="<%=path %>/js/dataPacker.js"></script>
	<script type="text/javascript">
		var index = layer.getFrameIndex(window.name); //获取窗口索引
		
		function changeStatus1(title,id) {
	    	layer.closeAll();
		    layer.confirm("您确认要启用当前标签吗？",{
		        title : '启用标签',
		    	skin : 'skin1',
		        shade: 0,
		        btn: ['确定','取消'] //按钮
		    }, function(index){
		    	window.location.href = 'userLabel?id='+id;
		        layer.close(index);
		    });
		}
	    
	    function changeStatus2(title,id) {
	    	layer.closeAll();
		    layer.confirm("禁用标签后所有相关会员将解除与此标签的关系，确定禁用吗？",{
		    	title : '禁用标签',
		    	skin : 'skin1',
		        shade: 0,
		        btn: ['确定','取消'] //按钮
		    }, function(index){
		    	window.location.href = 'banLabel?id='+id;
		        layer.close(index);
		    });
		}
	</script>
</head>
<body>
<div class="content">
	<div class="content-title">
   		会员标签管理
	</div>
    <form action="<%=path %>/label/listLabel" method="POST" id="pojo">
		<div class="search-box-wrapper">
			<ul class="search-wrapper">
				<li>
					<label>标签分类：</label>
	                <select name="lclassid">
						<option value="">全部</option>
						<c:forEach items="${labelClassList}" var="lableClass">
							<c:choose>
								<c:when test="${labelTag.lclassid eq lableClass.lclassid }">
									<option value="${lableClass.lclassid}" selected="selected">${lableClass.classname}</option>
								</c:when>
								<c:otherwise>
									<option value="${lableClass.lclassid}">${lableClass.classname}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach> 
	                </select> 
				</li>
				<li>
					<label>标签内容：</label>
	                <input maxlength="10" type="text" name="itemname" value="${pojo.itemname}">
				</li>
				<li>
					<label>使用范围：</label>
	                <select name="userange">
						<option value="0">全部</option>
						<option value="1" <c:if test="${pojo.userange eq '1'}">selected="selected"</c:if>>全局</option>
						<option value="2" <c:if test="${pojo.userange eq '2'}">selected="selected"</c:if>>组织内</option>
						<option value="3" <c:if test="${pojo.userange eq '3'}">selected="selected"</c:if>>私人</option>
					</select>
				</li>
				<li>
					<label>状态：</label>
	                <select name="itemstatus">
	                	<option value="">全部</option>
						<option value="2" <c:if test="${pojo.itemstatus eq '2'}">selected="selected"</c:if>>启用</option>
						<option value="3" <c:if test="${pojo.itemstatus eq '3'}">selected="selected"</c:if>>禁用</option>
					</select>
				</li>
				<li>
					<button type="button" class="btn-inquiry ico-search" onclick="search(1)">查询</button>
					<button type="button" class="btn-inquiry ico-add" onclick="window.location.href='editLabel'">新增</button>
				</li>
			</ul>
		</div>
		<div class="table-box">
		<c:if test="${page.totalCount == 0}">
		  		<div class="empty-info border-1-solid">目前没有标签信息</div>
	  		</c:if>
			<c:if test="${page.totalCount > 0}">
			<table class="table-content">
				<thead class="table-title">
					<tr>
						<th width="10%">标签分类</th>
						<th width="10%">标签内容</th>
						<th>备注</th>
						<th width="10%">使用范围</th>
						<th width="10%">更新人</th>
						<th width="20%">所属组织</th>
						<th width="10%">更新日期</th>
						<th width="10%">操作</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${page.result}" var="label">
					<tr>
						<td>${label.labelTag.classname}</td>
						<td>${label.itemname}</td>
						<td>${label.remarks}</td>
							<c:if test="${label.userange==1}"><td>全局</td></c:if>
							<c:if test="${label.userange==2}"><td>组织内</td></c:if>
							<c:if test="${label.userange==3}"><td>私人</td></c:if>
						<td>${label.docname}</td>
						<td>${label.orgName}</td>
						<td><fmt:formatDate value="${label.updatetime}" pattern="yyyy-MM-dd"/></td>
						<td>
						 <c:choose>
							<c:when test='${userInfo.roleid == "6"}'>
								<c:if test='${label.userange=="1" && label.litemid==1 || label.litemid==2}'><span>修改</span></c:if>
								<c:if test='${label.userange=="1" && label.litemid!=1 && label.litemid!=2}'><a href="<%=path %>/label/editLabel?id=${label.litemid}">修改</a></c:if>
								<c:if test='${label.userange!="1"}'><span>修改</span></c:if>
							</c:when>
							
							<c:when test='${userInfo.roleid == "1"}'>
								<c:if test='${label.userange=="2" && userInfo.dept_id==label.orgid}'><a href="<%=path %>/label/editLabel?id=${label.litemid}">修改</a></c:if>
								<c:if test='${label.userange=="2" && userInfo.dept_id!=label.orgid}'><span>修改</span></c:if>
								<c:if test='${label.userange!="2"}'><span>修改</span></c:if>
							</c:when>
							
							<c:when test='${userInfo.roleid != "1"}'>
								<c:if test="${label.createid eq userInfo.id}"><a href="<%=path %>/label/editLabel?id=${label.litemid}">修改</a></c:if>
								<c:if test="${label.createid ne userInfo.id}"><span>修改</span></c:if>
							</c:when>

						</c:choose> 
						<c:choose>
							<c:when test='${userInfo.roleid == "6"}'>
							<c:if test='${label.userange=="1" && label.litemid!=1 && label.litemid!=2}'><c:if test="${label.itemstatus==1 || label.itemstatus==3}">
	                        	<a href="javascript:void(0);" id="changeStatus1" class="mar-left" onclick='changeStatus1("启用",${label.litemid})'>启用</a></c:if>
                         		<c:if test="${label.itemstatus==2}"><a href="javascript:void(0);" id="changeStatus2" class="mar-left" onclick='changeStatus2("禁用",${label.litemid})'>禁用</a></c:if>
                         	</c:if>
		                    <c:if test='${label.userange=="1" && label.litemid==1 || label.litemid==2}'>
								<c:if test="${label.itemstatus==1 || label.itemstatus==3}"><span class="mar-left">启用</span></c:if>
                         		<c:if test="${label.itemstatus==2}"><span class="mar-left">禁用</span></c:if>
	  						</c:if>
	                        </c:when>
	                        
	                        <c:when test='${userInfo.roleid == "1"}'>
		                        <c:if test='${label.userange=="2" && userInfo.dept_id==label.orgid}'>
								<c:if test="${label.itemstatus==1 || label.itemstatus==3}"><a href="javascript:void(0);" id="changeStatus1" class="mar-left" onclick='changeStatus1("启用",${label.litemid})'>启用</a></c:if>
                         		<c:if test="${label.itemstatus==2}"><a href="javascript:void(0);" id="changeStatus2" class="mar-left" onclick='changeStatus2("禁用",${label.litemid})'>禁用</a></c:if></c:if>
	                        
	                        	<c:if test='${label.userange=="2" && userInfo.dept_id!=label.orgid}'>
								<c:if test="${label.itemstatus==1 || label.itemstatus==3}"><span class="mar-left">启用</span></c:if>
                         		<c:if test="${label.itemstatus==2}"><span class="mar-left">禁用</span></c:if>
	                        	</c:if>
	              				<c:if test='${label.userange!="2"}'><c:if test="${label.itemstatus==1 || label.itemstatus==3}"><span class="mar-left">启用</span></c:if><c:if test="${label.itemstatus==2}"><span class="mar-left">禁用</span></c:if></c:if>
	                        </c:when>
	                        
	                        <c:when test='${userInfo.roleid != "1"}'>
								<c:if test="${label.createid eq userInfo.id}">
								<c:if test="${label.itemstatus==1 || label.itemstatus==3}"><a href="javascript:void(0);" id="changeStatus1" class="mar-left" onclick='changeStatus1("启用",${label.litemid})'>启用</a></c:if>
                         		<c:if test="${label.itemstatus==2}"><a href="javascript:void(0);" id="changeStatus2" class="mar-left" onclick='changeStatus2("禁用",${label.litemid})'>禁用</a></c:if>
	                        	</c:if>
	                        	<c:if test="${label.createid ne userInfo.id}"><c:if test="${label.itemstatus==1 || label.itemstatus==3}"><span class="mar-left">启用</span></c:if>
	                          	<c:if test="${label.itemstatus==2}"><span class="mar-left">禁用</span></c:if>
	                       		</c:if>
	                        </c:when>
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
</body>
</html>
