<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=9">
<title>列表分页查询底部按钮</title>
<script type="text/javascript">
function search(pageNo){
	var totalPages = ${page.totalPages};
	if((pageNo !=1) && (pageNo <= 0 || pageNo > totalPages))
		return;
	if(pageNo !== undefined)
		$("input[name='pageNo']").val(pageNo);
	if($("input[name='pageNo']").val() > totalPages){
		alert("页码超过最大值");
		return;
	}
	$("form")[0].submit();
}

function changeSize() {
	$("input[name='pageNo']").val(1);
	$("form")[0].submit();
}

if("${message}")
	alert("${message}");
</script>
</head>
<body>
	<c:if test="${page.totalCount > 0}">
	<div class="page">
		<a id="page-first" class="page-btn" href="javascript:search(1);" <c:if test="${page.pageNo ne 1}"> style="color: #333;cursor: pointer;" </c:if>>首页</a> 
		<a id="pre" class="page-btn" href="javascript:search(${page.pageNo-1});" <c:if test="${page.pageNo ne 1}">style="cursor: pointer;" </c:if>><span <c:if test="${page.pageNo ne 1}">style="background: url(<%=path %>/img/arrow-l.png) center no-repeat;"}</c:if>></span></a>
		<span>一页显示
		<select id="pageSize" name="pageSize" class="page-num" onchange="changeSize()">
			<option value="10" <c:if test="${page.pageSize==10}">selected="selected"</c:if>>10</option>
			<option value="20" <c:if test="${page.pageSize==20}">selected="selected"</c:if>>20</option>
			<option value="30" <c:if test="${page.pageSize==30}">selected="selected"</c:if>>30</option>
		</select>条
		</span>
		<span class="page-total">共<i>${page.totalPages}</i>页</span>
		<a id="nex" class="page-btn" href="javascript:search(${page.pageNo+1});" <c:if test="${page.pageNo eq page.totalPages}"> style="cursor: default;" </c:if>><span <c:if test="${page.pageNo eq page.totalPages}">style="background: url(<%=path %>/img/arrow-r-gray.png) center no-repeat;cursor: default;"</c:if>></span></a>
		<span>跳转到：<input type="text" name="pageNo" class="page-go" value="${page.pageNo}" onchange="if(isNaN(this.value)){alert('请输入数字!');this.value='${page.pageNo}';}"/></span>
		<a class="page-btn" href="javascript:search();">Go</a> <a id="page-last" class="page-btn" href="javascript:search(${page.totalPages});" ${page.pageNo == page.totalPages ? 'style="color: #ccc;cursor: default;"' : ''}>尾页</a>
	</div>
	</c:if>
</body>
</html>