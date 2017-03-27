<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 

<!DOCTYPE HTML>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>查看模板</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/css/member.css">
	<link rel="stylesheet" href="<%=path %>/js/skins/blue.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.artDialog.js"></script>
	<script type="text/javascript" src="<%=path %>/js/plugins/iframeTools.js"></script>
	<script type="text/javascript" src="<%=path %>/js/kindeditor/kindeditor.js"></script>
	<script type="text/javascript" src="<%=path %>/js/kindeditor/lang/zh_CN.js"></script>
	<script type="text/javascript">
		 KindEditor.ready(function(K) {
	         window.editor = K.create('#txtarea_content',{
	        		 afterCreate : function(){ 
	                     this.sync();   
	              },
	              afterChange: function(){ //编辑器内容发生变化后，将编辑器的内容设置到原来的textarea控件里
	                     this.sync();   
	              },
	              afterBlur : function(){ //编辑器聚焦后，将编辑器的内容设置到原来的textarea控件里
	                  this.sync(); 
	              } 
	         });
	         editor.readonly(true);
	         
	         
		 });
	</script>
</head>
<body>
<div class="content">
	<div class="content-title">
	    审核意见模板 --- 查看
	</div>
	<div class="new-temp-box">
		<div class="title-temp">
	         <div class="fl"><span>模板名称：</span><input type="text"  name="template.name" class="temp-name" value="${template.name}" readonly="readonly"/></div>
	         <div class="fr">
	                           模板类型：
	         <select name="template.type" disabled="disabled">
	          <c:if test="${template.type==1}">
	             <option value="1">报告审核意见</option>
	             <option value="2">答卷审核意见</option>
	           </c:if>
	           <c:if test="${template.type==2}">
	             <option value="2">答卷审核意见</option>
	             <option value="1">报告审核意见</option>
	           </c:if>
	         </select>
	         </div>
		</div>
		<div class="new-temp-content">
		     <textarea id="txtarea_content" name="template.content" disabled="disabled">
		     ${template.content}
		     </textarea>
		</div>
		<div class="page-box align-center">
		    <input type="hidden"  name="template.orgId" value="${template.orgId}"/>
		    <input type="hidden"  name="template.id" value="${template.id}"/>
		    <input type="button" value="返回" class="btn-normal" onclick="javascript:history.go(-1)" />
		</div>
	</div>
</div>
</body>
</html>