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
    <title>糖尿病随访页面</title>
   	<meta charset="utf-8">
   	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/css/PublicHealthList.css">
	<link rel="stylesheet" href="<%=path %>/js/jquery-ui/themes/overcast/jquery-ui.min.css">
	<link rel="stylesheet" href="<%=path %>/plugins/font-awesome/css/font-awesome.min.css">

	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-ui/jquery-ui.js"></script>
	<script type="text/javascript" src="<%=path %>/js/dataPacker.js"></script>
	<script type="text/javascript" src="<%=path %>/js/singleMemberFollowList.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>

	<script type="text/javascript">
	function search() {
		document.getElementById("form1").submit();
	}
	
	function hasDisease(Url){
		var hasDiseases = '${hasDiseases}';
		if(hasDiseases  && hasDiseases  == 'false'){
		   alert('当前会员无糖尿病疾病，请添加！');
		}else {
			window.location.href=Url;
		}
	}
	
	function delGlycuresis() {
		var checkList = $(".table-content input[name='ids']:checked");
		
		if (checkList.length <= 0) {
			layer.alert('请选择糖尿病随访信息', {skin: 'skin1', shade: 0})
			return;
		}
		
		layer.confirm("确定要删除？", {
			  skin : 'skin1',
			  shade: 0,
		      btn: ['确认','取消'] //按钮
		  }, function(i){
			  $.ajax({
				   type: "post",
				   url:  "remove",
				   data: $.param(checkList),
				   success: function(msg){
					   layer.alert(msg.content, {skin: 'skin1', shade: 0, end: function(index){
					    	 if(msg.status)
					    		 window.location.reload();
					     }}, function() {
					    	 if(msg.status)
					    		 window.location.reload();
					     });
				   }
				})
				layer.close(i);
		  }, function(){
		      
		  });
	}
	</script>
</head>
  
<body>
  <div class="content">
	  <div class="content-title">
	   		Ⅱ型糖尿病随访
	  </div>
<!-- 	  <nav> -->
<!-- 	  	<ul class="clearfix"> -->
<%-- 	  		<c:choose> --%>
<%-- 	  			<c:when test="${pojo.pending}"> --%>
<!-- 	  				<li class="active">待随访</li> -->
<%-- 					<a href="list?memberID=${pojo.memberID}&name=${pojo.name}&unique_ID=${pojo.unique_ID}"><li>已随访</li></a> --%>
<%--   				</c:when> --%>
<%--   				<c:otherwise> --%>
<%--   					<c:choose> --%>
<%--   						<c:when test="${isMy || empty pojo.memberID}"> --%>
<%--   							<a href="plist?memberID=${pojo.memberID}&name=${pojo.name}&unique_ID=${pojo.unique_ID}"><li>待随访</li></a> --%>
<%--   						</c:when> --%>
<%--   						<c:otherwise> --%>
<!--   							<li>待随访</li> -->
<%--   						</c:otherwise> --%>
<%--   					</c:choose> --%>
<!--   					<li class="active">已随访</li> -->
<%--   				</c:otherwise> --%>
<%--   			</c:choose> --%>
<!-- 	  	</ul> -->
<!-- 	  </nav> -->
	  <form action="list" id="form1">
	  <input type="hidden" name="memberID" value="${pojo.memberID}">
		  <div class="search-box-wrapper">
				<ul class="search-wrapper">
					<c:if test="${empty pojo.memberID}">
					<li>
						<label>姓名：</label>
		                <input class="info-name" type="text" name="member.memname" value="${pojo.member.memname}" maxlength="20">
					</li>
					<li>
						<label>身份证号码：</label>
		                <input class="info-idCard" type="text" name="member.idcard" value="${pojo.member.idcard}" maxlength="18">
					</li>
					<li>
						<label>手机号码：</label>
		                <input class="info-tel" type="text" name="member.tel" value="${pojo.member.tel}" maxlength="11">	
					</li>
					</c:if>
<%-- 					<c:if test="${!pojo.pending}"> --%>
					<li>
						<label>随访结果：</label>
						<select class="info-result free-width" name="visitClass" onchange="search()">
	               			<option value="">请选择</option>
	                		<c:forEach items="${pojo.dicts.get('2型糖尿病随访/此次随访分类')}" var="dict" varStatus="var">
	             				<option value="${dict.DItemID}" <c:if test="${dict.DItemID eq pojo.visitClass}">selected="selected"</c:if>>${dict.DItemName}</option>
	            			</c:forEach> 
	               		</select>
					</li>
<%-- 					</c:if> --%>
					<li>
						<label>随访日期：</label>
	                    <input class="info-date" id="startDate" type="text" name="startVisitDate" value="<fmt:formatDate value="${pojo.startVisitDate}" pattern="yyyy-MM-dd"/>" readonly="readonly"/>
	                    <span style="padding-left: 8px;">至</span>
	                    <input class="info-date" id="endDate" type="text" name="endVisitDate" value="<fmt:formatDate value="${pojo.endVisitDate}" pattern="yyyy-MM-dd"/>" readonly="readonly"/>
					</li>
					<li>
						<button type="button" onclick="search(1)" id="" class="btn-inquiry ico-search">查询</button>	
<%-- 						<c:if test="${pojo.pending}"> --%>
<%-- 							<c:choose> --%>
<%--   								<c:when test="${empty pojo.memberID || page.totalCount eq 0}"> --%>
<%--   									<button type="button" onclick="hasDisease('toEdit?memberID=${pojo.memberID}&memName=<c:out value="${pojo.name}" escapeXml='true'/>&singleMembers=${empty pojo.memberID ? false : true}&unique_ID=${pojo.unique_ID}')" class="btn-inquiry ico-add">添加随访</button> --%>
<%--   								</c:when> --%>
<%--   								<c:otherwise> --%>
<!--   									<button type="button" class="btn-disabled add-ico">添加随访</button> -->
<%--   								</c:otherwise> --%>
<%--   							</c:choose> --%>
<%-- 						</c:if> --%>
<%-- 						<c:if test="${!pojo.pending}"> --%>
<%-- 							 <c:choose> --%>
<%--   								<c:when test="${isMy || empty pojo.memberID}"> --%>
<!-- 									<button type="button" id="" class="btn-inquiry ico-del font-change" onclick="delGlycuresis()">删除</button> -->
<%-- 								</c:when> --%>
<%-- 								<c:otherwise> --%>
<!-- 									<button type="button" class="btn-disabled">删除</button> -->
<%-- 								</c:otherwise> --%>
<%-- 						     </c:choose> --%>
<%-- 						</c:if> --%>
					</li>
				</ul>
		</div>
	
      	<div class="table-box"> 
	  		<c:if test="${page.totalCount == 0}">
	  			<div class="empty-info border-1-solid">目前还没有随访服务信息</div>
	  		</c:if>
			<c:if test="${page.totalCount > 0}">
		   		<table class="table-content">
		   		    <thead class="table-title">
		    		<tr>
<%-- 		    			<c:if test="${!pojo.pending}"> --%>
<!-- 		    			<th width="5%"><input type="checkbox"></th> -->
<%-- 		    			</c:if> --%>
		    			<c:if test="${empty pojo.memberID}">
			    		<th width="6%">姓名</th>
			    		<th width="6%">性别</th>
			    		<th width="12%">出生日期</th>
			    		<th width="12%">手机号码</th>
			    		<th width="13%">身份证号码</th>
			    		</c:if>
			    		<th width="10%">实际随访日期</th>
<%-- 			    		<c:if test="${!pojo.pending}"> --%>
			    		<th width="9%">随访结果</th>
			    		<th width="6%">来源</th>
<%-- 			    		</c:if> --%>
			    		<th width="6%">操作</th>
		    		</tr>
		    		</thead>
		    		<c:forEach items="${page.result}" var="item" varStatus="vs">
		    		<tr>
<%-- 		    			<c:if test="${!pojo.pending}"> --%>
<%-- 		    			<td><input type="checkbox" name="ids" value="${item.diabetesID}" ${item.refCompany==0 ? '':'disabled'}></td> --%>
<%-- 		    			</c:if> --%>
		    			<c:if test="${empty pojo.memberID}">
		    			<td><a href="<%=path%>/member/${item.member.memberid}/memberPage?page=followUp2" target="_new">${item.member.memname}</a></td>
		    			<td>${item.member.gender=='1'?'男':item.member.gender=='2'?'女':'未知'}</td>
		    			<td><fmt:formatDate value="${item.member.birthdate}" pattern="yyyy-MM-dd"/></td>
		    			<td>${item.member.tel}</td>
		    			<td>${item.member.idcard}</td>
		    			</c:if>
		    			<td>
		    			<fmt:formatDate value="${item.visitDate}" pattern="yyyy-MM-dd"/>
		    			</td>
<%-- 		    			<c:if test="${!item.pending}"> --%>
		    			<td>${item.visitClassStr}</td>
		    			<td>${item.refCompany==0?'录入':'导入'}</td>
<%-- 		    			</c:if> --%>
		    			<td>
<%-- 	    				<c:choose> --%>
<%-- 	    					<c:when test="${pojo.pending}"> --%>
<%-- 	    						<a href="toEdit?id=${item.diabetesID}&singleMembers=${empty pojo.memberID ? false : true}">进行随访</a> --%>
<%-- 	    					</c:when> --%>
<%-- 	    					<c:otherwise> --%>
	    						<a href="view?id=${item.diabetesID}&memberID=${pojo.memberID}">查看</a>&nbsp;
<%-- 	    						<c:if test="${isMy || empty pojo.memberID}"> --%>
<%-- 			    					<c:if test="${item.refCompany==0}"> --%>
<%-- 			    						<a class="mar-left" href="toEdit?id=${item.diabetesID}&singleMembers=${empty pojo.memberID ? false : true}">修改</a>&nbsp; --%>
<%-- 			    					</c:if> --%>
<%-- 				    				<c:if test="${item.refCompany!=0}"> --%>
<!-- 										<span class="mar-left">修改</span> -->
<%-- 									</c:if> --%>
<%-- 								</c:if> --%>
<%-- 	    					</c:otherwise> --%>
<%-- 	    				</c:choose> --%>
		    			</td>
		    		</tr>
		    		</c:forEach>
		    		<tbody>
		    		</tbody>
		    	</table>
	    	</c:if>
	    	<div class="page-box">
<%-- 				<c:if test="${!pojo.pending}"> --%>
<!-- 					<div class="fl"> -->
<!-- 						<button type="button" id="allSelect" class="btn-inquiry">全选</button> -->
<!-- 						<button type="button" id="unSelect"  class="btn-inquiry">反选</button> -->
<!-- 					</div> -->
<%-- 				</c:if> --%>
				<jsp:include  page="/public/pageFoot.jsp"/>
			</div>
	    </div>
		</form>
	</div>
</body>
</html>
