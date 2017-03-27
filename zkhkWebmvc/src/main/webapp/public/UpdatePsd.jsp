<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>修改密码</title>
   	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<script src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
	/*set height of the iframe by shenzhen20150415*/
	function reinitIframe(){
	    var iframe = document.getElementById("mainFrame");
	    try{
	        var bHeight = iframe.contentWindow.document.body.scrollHeight,
	            dHeight = iframe.contentWindow.document.documentElement.scrollHeight,
	            height = Math.max(bHeight, dHeight);
	            iframe.height =  height;
	    }catch (ex){}
	
	}
	window.setInterval("reinitIframe()", 200);
	</script>
	<script type="text/javascript">
	//表单提交验证所填信息是否为空
		function checkEmpty(){
			if($("#password2").html() != ""){
				/*alert("密码不能超过20个字符");*/
				return false;
			}else if("" == $("#pass1").val()){
				alert("原始密码不能为空");
				return false;
			}else if("" == $("#pass2").val()){
				alert("新密码不能为空");
				return false;
			}else if($("#pass1").val() == $("#pass2").val()){
				alert("新密码与原始密码相同，请重新输入");
				return false;
			}else if(!checkEqual()){
				alert("新密码两次输入不一致");
				return false;
			}else{
				return true;
			}
		}
		
		//验证原始密码是否正确
		//	function checkOriginalPass(parameter1, parameter2) {
		//		var url = "doctorAction!checkOriginalPass";
		
		//		$.post(url, {
		//			docPass : parameter1, docid : parameter2
		//		}, function(data) {
		//			if (data == 1) {
		//				$("#password").html("<font color='red' size='2px'>原始密码错误</font>");
		//				return false;
		//			} else {
		//				$("#password").html("");
		//				return true;
		//			}
		//		});
		//	}
		
		function checkPassLength()
		{
			var value = $("#pass2").val().trim();
			var regx = /^[a-zA-Z0-9]{6,20}$/;
		    var rs = regx.test(value)
		    
			if(!rs){
				$("#password2").html("<font color='red' size='2px'>密码由6至20位字母数字组成</font>");
				return false;
			 }
		   else {
				$("#password2").html("");
				return true;
			}
		}
		
		//验证新密码和重复的新密码是否相同
		function checkEqual(){
			var pass = $("#pass2").val();
			var rePass = $("#pass3").val();
			if(pass != rePass){
				//$("#rePassword").html("<font color='red' size='2px'>新密码两次输入不一致</font>");				
				return false;
			}else{
				return true;
			}
		}
		function clearMsg(){
		  $('table span font').html('');
// 		  history.go(-1);
		}
	    $(function(){
		   var $form = $("form");
	       var mwidth=$(window).width();
	       $(".right").width(mwidth-330);
	       $(window).resize(function() {
			 var mwidth=$(window).width();
	         $(".right").width(mwidth-330);
		   });
	       $("#btn_sure").click(function(){
	    	   if(checkEmpty()){
	    		   $.ajax({
	        		   type: "POST",
	        		   url:  $form.attr("action"),
	        		   data: $form.serialize(),
	        		   success: function(msg){
	//         			    msg = eval("("+ msg +")");
	        		     	alert(msg.content);
	        		     	if(msg.status)
	        		     		window.top.location.href="../user/logout";
	        		   }
	        		});
	    	   }
	       });
	    });
	</script>

	<style type='text/css'>
		fieldset {
		    padding: 0;
			height: 100%;
			padding-top: 50px;
			border-radius: 3px;
			border: none;
		}
		
		td {
			padding: 5px 0;
		}
	
		.th {
			width: 35%;
			text-align: right;
			font-size: 14px;
		}
		
		.tp {
			width: 400px;
			border: 1px solid #ccc;
			border-radius: 3px;
			padding: 7px 3px !important;
		}
	</style>
</head>

<body>
<div class="content">
	<div class="content-title">修改密码</div>
	<div>
		<fieldset>
    	<form action="../user/updateSelfPwd" method="post">
    		<input type="hidden" name="docid" value="${userInfo.id }">
    		<input type="hidden" name="logrole" value="${userInfo.roleid}">
    		<table  border="0" cellspacing="0" width="100%">
    			<tr>
    				<td class="th">请输入原始密码：</td>
    				<td>
    					<input type="password" name="oldDocPass" id="pass1" class="tp">&nbsp;<span id="password" class="red">${error}</span>
    				</td>
    			</tr>
    			<tr>
    				<td class="th">请输入新密码：</td>
    				<td>
    					<input type="password" name="docpass" id="pass2" class="tp" onblur="return checkPassLength();" placeholder="密码由6至20位字母数字组成">&nbsp;<span id="password2"></span>
    				</td>
    			</tr>
    			<tr>
    				<td class="th">请确认新密码：</td>
    				<td>
    					<input type="password" name="rePassword" id="pass3" class="tp">&nbsp;<span id="rePassword"></span>
    				</td>
    			</tr>
    			<tr>
    			    <td></td>
    				<td class="lign-left">
    					<input class="btn-inquiry" id="btn_sure" type="button" value="保存">
    				    <input class="btn-cancel" type="reset" value="重置" onclick="clearMsg();">
    				</td>
    			</tr>
    		</table>
    	</form>
    </fieldset>
	</div>
	
	<c:if test='${userInfo.roleid == 5 || userInfo.roleid == 1 || userInfo.roleid == 6}'>
		<div style="width: 100%; height:900px;"></div>
	</c:if>
</div>
</body>
</html>