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
	<title>选择医生</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script>
	    var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	    
	    function choose() {
				var obj = $("input[type='radio']:checked");
				
	    		if(obj.length == 0) {
	    			alert("请选择会员！");
	    		}else{
	    			parent.setDocBaseInfo({
	    				docName: $(obj).data('docname'),
	    				docId: $(obj).val()
	    			});
	        		parent.layer.close(index);
	    		}
		}
	</script>
</head>
<body>
<div class="content">
	<form id="form1" action="doctors">
		<div class="search-box-wrapper">
			<ul class="search-wrapper clearfix">
				<li>
					<label>姓名：</label>
					<input type="text" class="info-idCard" name="docname" value="${pojo.docname}">
				</li>
				<li>
					<label>账号：</label>
					<input type="text" class="info-idCard" name="doctorAccount.docacc" value="${pojo.doctorAccount.docacc}">
				</li>
				<li>
					<button type="button" onclick="search(1)" class="btn-inquiry ico-search">查询</button>
				</li>
			</ul>
		</div>	
		
		<div class="table-box">
			<table class="table-content">
				<thead class="table-title">
					<tr>
						<th width="5%">选择</th>
						<th width="5%">姓名</th>
						<th width="9%">性别</th>
						<th width="9%">账号</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${page.result}" var="item">
						<tr>
							<td><input type="radio" name="doctor" data-docname ="<c:out value="${item.docname}" escapeXml='true'/>" value="${item.docid}"></td>
							<td>${item.docname}</td>
							<td>${item.gender == 'M' ? '男' : '女'}</td>
							<td>${item.doctorAccount.docacc}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="page-box">
				<jsp:include page="/public/pageFoot.jsp"/>
			</div>
		</div>
	</form>
	<div class="page-box align-center">
		<input type="button" class="btn-inquiry" onclick="choose()" value="确定">
		<input type="button" class="btn-cancel" onclick="parent.layer.close(index);" value="取消">
	</div>
</div>
</body>
</html>
