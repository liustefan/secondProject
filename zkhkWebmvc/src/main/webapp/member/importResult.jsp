<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>批量导入会员结果页面</title>
    <link rel="stylesheet" href="<%=path %>/css/importMember.css" type="text/css"/>
    
    <script>
    function colose() {
    		var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
        parent.layer.close(index);
    }
    </script>
</head>

<body class="importResult">
<c:choose>
<c:when test="${!empty msg }">
${msg }
</c:when>
<c:otherwise>
<h3 class="impR_title">本次批量导入结果</h3>
	<table>
		<tr>
			<td colspan="2">已提交后台处理，稍后请在我的会员中查看</td>
		</tr>
		
<!-- 		<tr> -->
<!-- 			<td>导入失败的会员:</td> -->
<%-- 			<c:choose> --%>
<%-- 				<c:when test="${failCount gt 0 }"> --%>
<!-- 					<td><a target="_blank" class="download" -->
<%-- 						href="<%=path %>/download/downloadXls?objectId=${objectId}"> --%>
<%-- 							${failCount} </a>个</td> --%>
<%-- 				</c:when> --%>
<%-- 				<c:otherwise> --%>
<!-- 					<td>0个</td> -->
<%-- 				</c:otherwise> --%>
<%-- 			</c:choose> --%>
<!-- 		</tr> -->
		
<!-- 		<tr> -->
<!-- 			<td>当前我的会员总数:</td> -->
<%-- 			<td>${total }</td> --%>
<!-- 		</tr> -->

	</table>
<%-- 	<c:if test="${failCount gt 0 }"> --%>
<%--     <div class="row"><a  target="_blank" class="download" href="<%=path %>/download/downloadXls?objectId=${objectId}">请点击下载导入失败的数据文件</a></div> --%>
<%--     </c:if> --%>
</c:otherwise>
</c:choose>
    <div class="row btns">
    	<button type="button" onclick="colose();" class="btn-normal">关闭</button>
    </div>
</body>

</html>
