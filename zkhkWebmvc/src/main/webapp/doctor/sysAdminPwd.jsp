<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>修改密码和邮箱</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/common.css">
<script src="${pageContext.request.contextPath }/js/jquery-1.8.0.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/jquery.cookie.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath }/js/common.js" type="text/javascript"></script>
  
  
  <script type="text/javascript">
  function ckeckEmpty(){
	  if($("#originalPwd").val() == "") {
		  alert("原始密码不能为空");
		  return false;
	  }
		if(isPsw("#password") && isPsw("#repassword")){
			if($("#password").val() == $("#repassword").val()){
				return true;
			}else{
				alert("两次密码不一致");
				return false;
			}
		}
		return false;
	}
  
  
  function toLoginPage(){
		window.location.href = '<%=basePath%>'
	}
  
	$(document).ready(function(){
		 var isRemember = "${isRemember}";
		 //勾选了记住账号
		 if(isRemember == 1){
		 	$.cookie("docAcc","${docAcc}" ,{expires:365,path:"/"});
		 }
		 var removeOther = "<%=request.getAttribute("removeOther")%>";
		 //剔除其他客户端的登录状态
		 if(removeOther == 'Y'){
		 	alert('您上次登录没有正常退出系统..... \n\n 或 \n\n此账号在另一客户端登录，已被您强制剔除！');
		 }
	});
  </script>
  	
  </head>
  <body>
   <%--  <s:iterator value="#request.error" var="err">
  	<s:property value="err"/><br/>
  </s:iterator> --%>
   <div id="menu_new">
      <label onclick="a_show()" id="label_a">修改资料</label>
  </div>
  <div id="center_content">
  <div class="content_new">
    <div id="content_new_top">&nbsp;&nbsp;&nbsp;修改密码<c:if test="${userInfo.roleid eq 5}">和邮箱</c:if>
   <font color="red"><b><c:forEach items="${msg }" var="item">${item };</c:forEach></b></font>
    </div>
    <table id="table_new">
      <tr class="table_right"><td></td><td class="table_left"><label id="label_prompt"></label></td></tr>
    <form action="<%=path %>/user/updateAdminPwd" method="post" onsubmit="return checkEmpty();">
    <input type="hidden" name="docid" value="${userInfo.id }">
    <input type="hidden" name="roleid" value="${userInfo.roleid}">
    <tr><td class="table_right">请输入原始密码：</td><td class="table_left">
    <input  type="password" name="originalPwd" id="originalPwd" title="原始密码"/>
    </td></tr>
    <tr><td class="table_right">请输入新密码：</td><td class="table_left"><input type="password" id="password" name="doctorAccount.docpass" title="密码" onBlur="isPsw(this);"/><span></span></td></tr>
    <tr><td class="table_right">请输入重复密码：</td><td class="table_left"><input type="password" id="repassword" name="reDocPass" title="密码" onBlur="isPswtwo(this);"/><span></span></td></tr>
    	
    	<!-- 金钥匙这个角色第一次登录才要修改密码和邮箱 -->
    	<c:choose>
    	   <c:when test="${userInfo.roleid eq 5 }">
    			<tr><td class="table_right">请输入有效的邮箱：</td><td class="table_left"><input type="text" name="email" value="${userInfo.email }" title="Email" onBlur="isEmail(this);"/><span></span></td></tr>
    		</c:when>
    	</c:choose>
      <tr><td colspan="2" align="content">
    	<input type="submit" value="确定" id="addSubmint" class="new_but">
       <input type="reset" value="重置" class="new_but">
       </td></tr>
       <tr><td></td><td></td></tr>
    </table>
  </div>
  </div>
    </form>
  </body>
</html>
