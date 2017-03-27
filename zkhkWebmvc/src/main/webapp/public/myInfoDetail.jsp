<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %> 

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
  	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
  	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
  	<title>修改个人资料</title>
   	<link rel="stylesheet" href="<%=path %>/css/general.css">
   	<link rel="stylesheet" href="<%=path %>/css/content.css">
   	
	<script src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script src="<%=path %>/js/common.js" ></script>
	<script src="<%=path %>/js/previewIMG.js"></script>

	<script> 
	  	function isCardNo(card) {
			// 身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X
			var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
			if(reg.test(card.value) === false)
			{
				alert("身份证输入不合法");
				card.value = '';
			}
		}
		
		function checkSubmit(){
			if(!isPhone($("#phone"))){
				return false;
			}
			if($("#name").val() == ""){
	  	  				$("#name").next().html("姓名不能为空！");
	  	  				$("#name").focus();
	  	  				return false;
	  	  			}
			
			if(!isEmail($("#email"))){
				return false;
			}
			if($("#myTel").html().length > 1){
				return false;
			}
			return true;
		}
		
		function isDisplayMySpan(obj){
			if("${requestScope.doctor.tel }" == obj.value){
				$("#myTel").html("");
				$("#myTel").css('display','none');
			}else{
				$("#myTel").css('display','');
			}
		}
		
		function submitForm(){
	 	   if(checkSubmit()){
	 		  $("#selefInfoForm").submit();
// 	 		   $.ajax({
// 	     		   type: "POST",
// 	     		   url:  $("#selefInfoForm").attr("action"),
// 	     		   data: $("#selefInfoForm").serialize(),
// 	     		  contentType: false, 
// 	     		 processData: false,
// 	     		   success: function(msg){
// 	     		     	alert(msg.content);
// 	     		     	if(msg.status)
// 	     		     		window.location.href="../user/myInfoDetail";
// 	     		   }
// 	     		});
	 	   }
	    }
		
		$(function(){
		       var mwidth=$(window).width();
		       $(".right").width(mwidth-330);
		       $(window).resize(function() {
				 var mwidth=$(window).width();
		         $(".right").width(mwidth-330);
				});
		    });
		<c:if test="${not empty success && success}">
		parent.loadHead('${doctor.headaddress}', '${doctor.docname}');
		</c:if>
	</script>
	<style>
		fieldset {
		    padding: 0;
			height: 100%;
			border: 0px solid #f8f8f8;
			border-radius: 3px;
			-moz-border-radius: 3px;
    		-webkit-border-radius: 3px;
		}
		
		.btn-sure{
			  border-radius: 3px;
			  -moz-border-radius: 3px;
   			  -webkit-border-radius: 3px;
			  color: #FFF;
			  padding: 5px 20px;
			  cursor: pointer;
			  font-size: 14px;
			  display: inline-block;
			  font-family: "Microsoft YaHei";
			  background: #01ba54;
			  border: 1px solid #00863c;
		}
		
		a.btn-grey,
		.btn-grey {
			  border-radius: 3px;
			  -moz-border-radius: 3px;
    		  -webkit-border-radius: 3px;
			  color: #333;
			  border: 1px solid #c7c7c7 ;
			  padding: 5px 20px;
			  cursor: pointer;
			  font-size: 14px;
			  display: inline-block;
			  background: #e9e9e9;
		}
		
		a.btn-grey:hover {
			text-decoration: none;
		}
	</style>
</head>

<body>
<div class="content">
	   <form action="<%=path %>/doctor/updateSelfInfo" enctype="multipart/form-data" method="post" id="selefInfoForm">
		<fieldset style="background:#f5f5f5;">
    	<div class="content-title clearfix"><span>个人资料 --- 修改</span> <span style="color: red"><b>${msg }</b></span> </div>
    	<div class="clearfix">
	     <table id="table_new" class="table-info fl">
	       <tr>
	          <td width="18%"></td>
	          <td width="30%"></td>
	          <td width="18%"></td>
	          <td><label id="label_prompt"></label></td>
	        </tr>
	    	<input type="hidden" name="docid" value="${requestScope.doctor.docid }">
	    	<input type="hidden" name="roleid" value="${userInfo.roleid }">
	    	<input type="hidden" name="docGUID" value="${doctor.docGUID }"/>

	     	 <tr>
	     	    <td align="right"><i style="color:red;font-style:normal;">*</i>账号：</td>
	     	    <td><input type="text" name="doctorAccount.docacc" value="${requestScope.doctor.doctorAccount.docacc }" title="账号" readonly="readonly" id="acc"/><span></span></td>
	     	    <td align="right"><i style="color:red;font-style:normal;">*</i>手机号码：</td>
	     	    <td><input type="text" name="tel" value="${requestScope.doctor.tel }"onchange="if(isNaN(this.value)){alert('请输入数字');this.value='';}" maxlength='11' onBlur="checkdocTelIsExistence(this);isDisplayMySpan(this);" id="phone" title="手机号码"><span id="myTel" style="display:none"></span></td>
	     	 </tr>
	     	 <tr>
	     	    <td align="right"><i style="color:red;font-style:normal;">*</i>姓名：</td>
	     	    <td><input type="text" name="docname" value="${requestScope.doctor.docname }" title="姓名" id="name" maxlength="10"><span></span></td>
	     	    <td align="right"><i style="color:red;font-style:normal;">*</i>Email：</td>
	     	    <td><input type="text" name="email" value="${requestScope.doctor.email }" title="Email" onBlur="isEmail(this);" id="email" maxlength="30"><span></span></td>
	     	 </tr>
	     	 <tr>
	     	    <td align="right">职称：</td>
	     	    <td><input type="text" name="title" value="${requestScope.doctor.title }" maxlength="12"><span></span></td>
	            <td align="right">联系电话：</td>
	            <td><input type="text" name="contacttel" value="${requestScope.doctor.contacttel }"><span></span></td>
	         </tr>
	     	 <tr>
		     	<td align="right">性别：</td>
		     	<td class="table_left_a">
		     	    <input type="radio" name="gender" value="M" <c:if test="${requestScope.doctor.gender eq 'M' }"> checked="checked" </c:if> />男
			     	<input type="radio" name="gender" value="F" <c:if test="${requestScope.doctor.gender eq 'F' }"> checked="checked" </c:if>/>女
		        <span></span>	
		        </td>
	            <td align="right">微信：</td>
	            <td><input type="text" name="weixin" value="${requestScope.doctor.weixin }"><span></span></td>
	         </tr>
	         <tr>
	            <td align="right">证件类型：</td><td>
	     		<select name="certitype">
	     		<option value="">请选择</option>
	     		<c:forEach items="${certiType }" var="item">
	     		<c:choose>
	     		<c:when test="${item.code eq  doctor.certitype}">
	     		<option value="${item.code }" selected="selected">${item.desc }</option>
	     		</c:when>
	     		<c:otherwise>
	     		<option value="${item.code }">${item.desc }</option>
	     		</c:otherwise>
	     		</c:choose>
	     		</c:forEach>
	     		</select><span></span>
	     	    </td>
	     	    <td align="right">工作科室：</td>
	     	    <td><input type="text" name="workdepart" value="${requestScope.doctor.workdepart }" maxlength="100"><span></span></td>
	     	 </tr>
	     	 <tr>
	     	    <td align="right">证件号码：</td>
	     	    <td><input type="text" name="certinum" value="${requestScope.doctor.certinum }" onchange="isCardNo(this);"></td>
	     	    <td align="right">工作单位：</td>
	     	    <td><input type="text" name="workaddress" value="${requestScope.doctor.workaddress }" maxlength="50"><span></span></td>
	     	 </tr>
	     	 <tr><td align="right">家庭地址：</td><td colspan="3"><input type="text" name="homeaddress" value="${requestScope.doctor.homeaddress }" maxlength="100"><span></span></td></tr>
	     	 <tr><td align="right">户口地址：</td><td colspan="3"><input type="text" name="resideaddress"value="${requestScope.doctor.resideaddress }" maxlength="100"><span></span></td></tr>
	         <tr><td align="right">单位地址：</td><td colspan="3"><input type="text" name="unitaddress"value="${requestScope.doctor.unitaddress }" maxlength="100"><span></span></td></tr>	     	 
	         <tr><td align="right">简介：</td><td colspan="3"><textarea rows="10" cols="25" name="desription">${requestScope.doctor.desription }</textarea><span></span></td></tr>	     	     
	        </table>
	        <div class="fr" style="width:20%;">
	             <div class="img-box">
	                 <p>头像</p>
		             <div id="preview" class="preview">
					    <c:if test="${empty sessionScope.userInfo.headAddress}">
					    	<img id="imghead" class="imghead" width="120" height="120" border=0 src='<%=request.getContextPath()%>/img/user_img.png' />
					    </c:if>
					    <c:if test="${not empty sessionScope.userInfo.headAddress}">
					   	    <img id="imghead" class="imghead" border=0 src='${pageContext.request.contextPath }/image/getImage?uniqueId=${ sessionScope.userInfo.headAddress}' />
					        <input type="hidden" name="headaddress" value="${ sessionScope.userInfo.headAddress}"/>
					    </c:if>
 					 </div>
	                 <input type="file" name="fieldName" id="fieldName" class="fieldName" onchange="fileChange(this);" accept="image/*"/><span></span>
	             </div>
	             <div class="img-box">
	                 <p>签名</p>
		             <div id="preview2" class="preview">
		             <c:if test="${empty sessionScope.userInfo.signAddress}">
					    <img id="imghead2" class="imghead" width="120" height="120" border=0 src='<%=request.getContextPath()%>/img/default_img.png' />
					 </c:if>
					 <c:if test="${not empty sessionScope.userInfo.signAddress}">
					    <input type="hidden" name="signaddress" value="${ sessionScope.userInfo.signAddress}"/>
					 	<img id="imghead2" class="imghead" border=0 src='${pageContext.request.contextPath }/image/getImage?uniqueId=${sessionScope.userInfo.signAddress}' />
					 </c:if>
					 </div>
	                 <input type="file" name="field2Name" id="field2Name" class="fieldName" onchange="fileChange2(this);" accept="image/*" /><span></span>
	             </div>
	        </div>
	       <!-- <input type="submit" value="确定" id="addSubmint" class="new_but" > -->
       </div>
       <div class="btn-box">
			<c:if test='${userInfo.roleid == 1 }'>
				<!-- <a href="javascript:window.top.homePage();" class="btn-cancel">返回</a> -->
				<input type="button" value="返回" class="btn-cancel" onclick="history.go(-1)">
			</c:if>
	        <input type="reset" value="重置" class="btn-cancel">
	        <input type="button" value="确定" id="addSubmint" class="btn-inquiry" onclick="submitForm();">
	   </div> 
    </fieldset>
    </form>
</div>
</body>
</html>