<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE HTML>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>新增医生分组</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script type="text/javascript" src="<%=path %>/js/addDoctor.js"></script>
	<style>
		.content-slice {
			margin: 25px 0;
		}
		.content-slice>label:first-child {
			font-size: 14px;
			height: 20px;
			line-height: 20px;
			width: 130px;
			text-align: right;
		}
		.v-top {
			vertical-align: top;
		}
	</style>
</head>
<body>
<form class="cmxform" id="form3" method="post" action="">
	<input type="hidden" name="parentGroup.odgpid" value="${parent.odgpid}"/>
	<input name="fathid" type="hidden" value="${group.fathid }"/>
	<input type="hidden" name="path" value="${group.path}"/>
	<input type="hidden" name="hasaudit" value="${not empty group.chlevel}"/>
    <input type="hidden" name="odgpid" value="${group.odgpid}"/>
    <input type="hidden" name="orgid" value="${userInfo.dept_id}"/>
	<div>
		<div>
			<div class="content-slice">
				<label>所属组织：</label>
				<span>${userInfo.orgName}</span>
			</div>
			<div class="content-slice">
				<label>上级分组：</label>
				<span>${parent.odgpname}</span>
			</div>
			<div class="content-slice">
				<label><span class="red">*</span>分组名称：</label>
				<input type="text" class="" name="odgpname" value="${group.odgpname}">
			</div>
			<div class="content-slice">
				<label><span class="red">*</span>排序号：</label>
				<input type="text" class="margin-lt" name="order" value="${defaultOrder}${group.order}">
			</div>
			<div class="content-slice">
				<label><span class="red">*</span>是否最终节点：</label>
				<label class="radio-inlines"><input type="radio" class="input-center" name="endblocktag" value="true" <c:if test="${group.endblocktag}">checked="checked"</c:if>>&nbsp;是&nbsp;</label>
				<label class="radio-inlines"><input type="radio" class="span-center" name="endblocktag" value="false" <c:if test="${!group.endblocktag}">checked="checked"</c:if>>&nbsp;否&nbsp;</label>
				<label for="elect" class="error"></label>
			</div>
			<div class="content-slice">
				<label class="v-top">分组说明：</label>
				<textarea name="remark" rows="4" cols="35">${group.remark}</textarea>
				<div style="padding-left: 130px; height: 20px;"><label for="remark" class="error"></label></div>
			</div>
		</div>
		<div class="page-box align-center">
			<button type="button" id="btnSubmit" class="btn-inquiry">保存</button>
			<button type="button" onclick="closeWd();" class="btn-cancel">取消</button>
		</div>
	</div>
</form>
</body>
</html>