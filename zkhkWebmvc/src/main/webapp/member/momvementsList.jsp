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
	<link rel="stylesheet" href="<%=path %>/js/jquery-ui/themes/overcast/jquery-ui.min.css">
	<link rel="stylesheet" href="<%=path %>/plugins/font-awesome/css/font-awesome.min.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-ui/jquery-ui.js"></script>
	<script type="text/javascript" src="<%=path %>/js/dataPacker.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<style type="text/css">
		/* tab 切换页样式 */
		nav ul li {
			float: left;
			margin-bottom: 2px;
			width: 157px;
			height: 35px;
			line-height: 35px;
			font-size: 16px;
			color: #333;
			text-align: center;
			background: #E4E4E4;
			cursor: pointer;
		}
		
		nav ul li.active {
			background: #67C15F;
			color: #fff;
		}
		
		nav ul li a {
			color: #333;
			display: block;
		}
	</style>
	<script type="text/javascript">
		function deleteRecord(msg, id) {
			layer.closeAll();
			layer.confirm( msg, {
				title : '提示信息',
				skin : 'skin1',
				shade : 0,
				btn : [ '确定', '取消' ]
			}, function(index) {
				$.ajax({
					url: "<%=path %>/member/deleteMovement/" + id,
				   type: "POST",
				   dataType:"json",
				success: function(data) {
	 		     	if(data.status) {
	 		     		window.location.reload();
	 		     	} else {
	 		     		alert(data.content);
	 		     	}
				}
				});
			});
		}
		
		function dispose(id){
			layer.closeAll();
			layer.open({
		   	    type: 2,
		   		skin : 'skin1',
		   	    title: '提示信息',
		   	    shadeClose: false,
		   	    shade: 0,
		   	    area: ['650px', '350px'],
		   	    content: '<%=path%>/member/confirmResult/' + id
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
	  			<c:when test="${flag eq 'inner' }">
	  				<li class="active">转入申请</li>
					<li><a href="<%=path %>/member/momvementsList?flag=outer&status=1">转出处理</a></li>
  				</c:when>
  				<c:otherwise>
					<li><a href="<%=path %>/member/momvementsList?flag=inner">转入申请</a></li>
  					<li class="active">转出处理</li>
  				</c:otherwise>
  			</c:choose>
	  	</ul>
	  </nav>
	  <form action="<%=path %>/member/momvementsList" id="" method="POST">
	  <input type="hidden" name="flag" value="${flag}"/>
		  <div class="search-box-wrapper">
				<ul class="search-wrapper clearfix">
					<li>
						<label>会员姓名：</label>
		                <input class="info-name" type="text" name="memberName" value="${condition.memberName}" maxlength="20">
					</li>
					<li>
						<label>手机号码：</label>
		                <input class="info-tel" type="text" name="tel" value="${condition.tel}" maxlength="11">	
					</li>
					<li>
						<label>身份证号码：</label>
		                <input class="info-idCard" type="text" name="idcard" value="${condition.idcard}" maxlength="18">
					</li>
					<li>
						<label>申请日期：</label>
	                    <input class="info-date" id="startDate" type="text" name="applyStartDate" value="${condition.applyStartDate}" readonly="readonly"/>
	                    <span style="padding-left: 8px;">至</span>
	                    <input class="info-date" id="endDate" type="text" name="applyEndDate" value="${condition.applyEndDate}" readonly="readonly"/>
					</li>
					<li>
						<label>状态：</label>
						<select class="info-result free-width" name="status" onchange="search(1)">
	               			<option value="">全部</option>
	               			<c:forEach items="${status}" var="st">
	               			<option value="${st.status}" <c:if test="${st.status eq condition.status}">selected="selected"</c:if>>${st.desc}</option>
	               			</c:forEach>
	               		</select>
					</li>
					<li>
						<button type="button" onclick="search(1)" id="" class="btn-inquiry ico-search">查询</button>	
						<c:if test="${flag eq 'inner' }">
  							<button type="button" onclick="javascript:location.href='<%=path %>/member/editMovment/0'" class="btn-inquiry ico-add">新增</button>
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
				    		<c:if test="${flag eq 'inner'}"><th width="20%">转出组织</th></c:if>
				    		<c:if test="${flag eq 'outer'}"><th width="20%">转入组织</th></c:if>
				    		<c:if test="${flag eq 'outer'}"><th width="6%">申请医生</th></c:if>
				    		<th width="8%">申请时间</th>
				    		<c:if test="${flag eq 'inner'}"><th width="6%">确认医生</th></c:if>
				    		<th width="8%">确认时间</th>
				    		<th width="20%">拒绝原因</th>
				    		<th width="6%">状态</th>
				    		<th>操作</th>
			    		</tr>
			    		</thead>
			    		<tbody>
			    		<c:forEach items="${page.result }" var="item">
			    			<tr>
					    		<td>${item.member.memname }</td>
					    		<td>${item.member.tel }</td>
					    		<c:if test="${flag eq 'inner'}"><td>${item.outOrgName}</td></c:if>
				    		    <c:if test="${flag eq 'outer'}"><td>${item.inOrgName}</td></c:if>
				    		    <c:if test="${flag eq 'outer'}"><td>${item.createDrName }</td></c:if>
				    		    <td><fmt:formatDate value="${item.createTime }" pattern="yyyy-MM-dd"/></td>
				    		    <c:if test="${flag eq 'inner'}"><td>${item.outDrName }</td></c:if>
				    		    <td><fmt:formatDate value="${item.confirmTime }" pattern="yyyy-MM-dd"/></td>
				    		    <td>${item.refuseReason }</td>
				    		    <td><c:forEach items="${status}" var="st"><c:if test="${st.status eq item.moveStatus}">${st.desc }</c:if></c:forEach></td>
					    		<td>
					    		    <c:if test="${flag eq 'outer'}">
					    		    <c:choose>
					    		    <c:when test="${item.moveStatus eq 1}">
					    		    <a href="javascript: void(0);" onclick="dispose(${item.MMovementID})">处理</a>
					    		    </c:when>
					    		    <c:otherwise>
					    		    <span class="font-gray">处理</span>
					    		    </c:otherwise>
					    		    </c:choose>
					    		    </c:if>
					    		    
					    		    <c:if test="${flag eq 'inner'}">
					    		    <c:choose>
					    		    <c:when test="${item.moveStatus eq 1}">
					    		    <a href="<%=path %>/member/editMovment/${item.MMovementID}">修改</a>
									<a href="javascript: void(0);" class="mar-left" onclick="deleteRecord('您确定要删除当前记录吗？', ${item.MMovementID})">删除</a>
									</c:when>
									<c:otherwise>
									<span class="font-gray">修改</span>
									<span class="mar-left font-gray">删除</span>
									</c:otherwise>
					    		    </c:choose>
					    		    <a href="<%=path %>/member/viewMovment/${item.MMovementID}" class="mar-left">查看</a>
					    		    </c:if>
					    		</td>
				    		</tr>
				    	</c:forEach>
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
