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
	<title>选择家庭成员</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css" />
	<link rel="stylesheet" href="<%=path %>/css/selectMember.css">
	<link rel="stylesheet" href="<%=path %>/js/jquery-ui/themes/overcast/jquery-ui.min.css">
	<script type="text/javascript" src="<%=path %>/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-ui/jquery-ui.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script type="text/javascript" src="<%=path %>/js/dataPacker.js"></script>
	
	<script>
	    var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	    
	    function choose() {
	    		var obj = $("input[type='radio']:checked");
	    		var data;
	    		if(obj.length >= 0) {
	    			if(obj.length > 0) {
	    				data = {
	    						familyMemberId: obj.val(),
	    						name: obj.data("memname"),
	    						idCard: obj.data("idcard"),
	    						phone: obj.data("phone"),
	    						gender: obj.data("gender"),
								birthDate: obj.data("birthdate"),
								memTypeName: obj.data("memtypename"),
								memId: obj.data("memid"),
								status: 2
	    				}
	    			}else {
	    				alert("请选择会员!")
	    				return false;
	    			}
	    		}
	    		parent.closeOpenPage(index, data);
	    }
	    function closeOpenPage(){
	    	parent.closeOpenPage(index, {});
	    }
	</script>
</head>
<body>
<form id="form1" action="<%=path %>/member/selMemFamily" method="POST">
	<div class="search-wrapper clearfix">
		<div class="fl">
			<p>
				<label>
					<span>会员姓名:</span>
					<input type="text" class="info-tel" name="memName" value="${condition.memName}">
				</label>
				<label>
					<span>身份证号:</span>
					<input type="text" class="info-idCard" name="idcard" value="${condition.idcard}">
				</label>
			</p>
			<p>
				<label>
					<span>手机号码:</span>
					<input type="text" class="info-tel" name="tel" value="${condition.tel}">
				</label>
				<label>
					<span>注册日期:</span>
					<input class="info-date" id="startDate" type="data" name="creTimeStart" value="${condition.creTimeStart}" readonly="readonly">
				</label>
				<label class="mg-0">
					<span>至</span>
					<input class="info-date" id="endDate" type="data" name="creTimeEnd" value="${condition.creTimeEnd}" readonly="readonly">
				</label> 
			</p>
		</div>
		<div class="btn-center">
			<input type="submit" class="btn-inquiry ico-search" value="查询" onclick="(function(){document.getElementsByName('pageNo')[0].value=1})()">
			<input type="button" class="btn-inquiry ico-add" value="新增" onclick="closeOpenPage()">
		</div>
	</div>
	<div class="result">
	  <c:choose>
			<c:when test="${empty message}">
			<c:choose>
	<c:when test="${page.totalCount eq 0}">
		<div class="empty-info"><h2>没有查询到符合条件的会员</h2></div>
	</c:when>
	<c:otherwise>
			<table class="table-content" id="datalist">
			<thead class="table-title">
				<tr>
					<th width="5%">选择</th>
					<th width="5%">姓名</th>
					<th width="9%">手机号码</th>
					<th width="9%">身份证号</th>
					<th width="8%">注册日期</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${page.result}" var="pojo">
					<tr>
						<td>
							<input type="radio" 
							name="chooseMember"
							value="${pojo.memberid}"
							data-memname ="<c:out value="${pojo.memname}" escapeXml="true"></c:out>" 
							data-idcard="${pojo.idcard}" 
							data-phone="${pojo.tel}"
							data-gender="${pojo.gender}"
							data-birthdate="<fmt:formatDate value="${pojo.birthdate }" pattern="yyyy-MM-dd"/>"
							data-memtypename="${pojo.memberType.memname}"
							data-memid="${pojo.memid}"
							>
						</td>
						<td><c:out value="${pojo.memname}" escapeXml="true"></c:out></td>
						<td>${fn:replace(pojo.tel, fn:substring(pojo.tel, 3, 8), 'XXXXX')}</td>
						<td>${fn:replace(pojo.idcard, fn:substring(pojo.idcard, 6, fn:length(pojo.idcard) == 15 ? 12 : 14), fn:length(pojo.idcard) == 15 ? 'XXXXXX' : 'XXXXXXXX')}</td>
						<td><fmt:formatDate value='${pojo.createtime}' pattern="yyyy-MM-dd HH:mm:ss"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
        <div class="page-box">
			<jsp:include page="/public/pageFoot.jsp"></jsp:include>
		</div>
		</c:otherwise>
		</c:choose>
	</c:when>
	<c:otherwise>
		<div class="empty-info"><h2>${message }</h2></div>
	</c:otherwise>
</c:choose>
</div>
</form>
<div class="page-box align-center ">
	<input type="button" class="btn-inquiry mg-lf-50" onclick="choose();" value="确定">
	<input type="button" class="btn-cancel mg-lf-50" onclick="parent.layer.close(index);" value="取消">
</div>
</body>

</html>
