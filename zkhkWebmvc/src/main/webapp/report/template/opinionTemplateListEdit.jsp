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
	<title>编辑审核意见模板</title>
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
		 });
		 function checkName(){
			  var dome = $('#name');
			  if(dome.val().trim().length <=0 || dome.val().length > 50) {
					 $('#name_msg').show();
					 dome.focus();
					 return false;
				 }else {
					 $('#name_msg').hide();
					 return true;
				 }
		  }
		 
		 function formReset() {
			 if(confirm("是否取消修改？")) {
				 document.getElementById('fm_template').reset();
				 editor.html($('#txtarea_content').val());
				 history.go(-1)
			 }
			 
			 //window.editor.sync();
		 }
		 
		 function checkContent() {
			 var length = editor.count('text');
		    if (length == 0) {
		        alert("模板内容不能为空！");
		        return false;
		    }
		    
		    if (length > 1000) {
		    		alert("模板内容不能够超过1000字符!");
		        return false;
		    }
		 }
		 
		 $(document).ready(function(){
			  /* $("input").keydown(checkName); */
			  $("input").keyup(checkName);
			});
	</script>
</head>
<body>
<div class="content">
	<div class="content-title">
	    审核意见模板 --- 修改
	</div>
	<div class="new-temp-box">
		<form id="fm_template" action="<%=request.getContextPath()%>/template/updateOpinionTemplate"   method="post" onsubmit="return checkName() && checkContent() && confirm('确认修改？');"> 
			<div class="title-temp">
		         <div class="fl"><span>模板名称：</span><input type="text" id="name"  name="name" class="temp-name" value="${template.name}" /><span id="name_msg" style="color:red; display: none;"> *长度应该为1~50个字符！</span></div>
		         <div class="fr">
		                           模板类型：
		         <select name="type" >
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
			     <textarea id="txtarea_content" name="content">
			     ${template.content}
			     </textarea>
			</div>
			<div class="page-box align-center">
				<input type="hidden"  name="orgId" value="${template.orgId}"/>
				<input type="hidden"  name="id" value="${template.id}"/>
				<!-- <input type="button" value="返回" class="btn-normal" onclick="javascript:history.go(-1)" /> -->
				<input type="button" value="取消" onclick="formReset();" class="btn-normal" />
				<input type="submit" value="确认" class="btn-normal" />
			</div>
		</form>
	</div>
</div>
</body>
</html>