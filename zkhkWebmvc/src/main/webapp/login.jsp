<%@ page language="java" import="java.util.*,javax.servlet.http.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
if(session.getAttribute("userInfo") != null){
	response.sendRedirect(path+"/user/login");
}
%>

<!DOCTYPE html>
<html>
<head>
	<title><%=getServletContext().getAttribute("title") %></title>
	<base href="<%=basePath%>">
	<meta name="keywords" content="关键词">
	<meta name="description" content="网站描述">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<meta http-equiv="page-Enter" content="blendTrans(Duration=0.5)">
	<meta http-equiv="page-Exit" content="blendTrans(Duration=0.5)">
	<link rel="shortcut icon" href="<%=path %>/<%=getServletContext().getAttribute("img") %>/title_ico.ico" type="image/x-icon" />
	
	<link href="<%=path %>/css/general.css" rel="stylesheet" type="text/css">
	<link href="<%=path %>/css/log.css" rel="stylesheet" type="text/css">
	
	<%--<script src="<%=path %>/js/log.js" type="text/javascript"></script> --%>
	<script src="<%=path %>/js/jquery-1.7.2.min.js" type="text/javascript"></script>
	<script src="<%=path %>/js/jquery.msgbox.js" type="text/javascript"></script>
	<script src="<%=path %>/js/jquery.cookie.js" type="text/javascript"></script>
	<script src="<%=path %>/js/login.js" type="text/javascript"></script>
	<script src="<%=path %>/js/placeholder.js" type="text/javascript"></script>
	<script type="text/javascript">
	function toLoginPage(){
		window.location.href = '<%=basePath%>'
	}
	
	$(function(){ 
		$("#isRemember").click(function(){
			if($(this).prop("checked") == true){
				$(this).val(1);
			}else{
				$(this).val(0);
			}
		});
		
	   var docacc = $.cookie("docacc");
	   var errorMsg = "${requestScope.error}";
	   if(!"${requestScope.status}" && (!errorMsg || errorMsg =="[]")){
	      if(docacc){
	   		$("#docacc").val(docacc);
	   		$("#isRemember").prop("checked",true);
	   		$("#isRemember").val(1);
	   		$("#docpass").val("");
	   	  }	
	   }else{
	   	    $("#docacc").val("${requestScope.docacc}");
	   }	 
	   var brow = $.browser;
	   var msg = "";
	   var width = screen.width;
	   var alertWidth = 480;
	   //如果电脑分辨率低于1280
	   if(width < 1280){
	   	  msg = "您的电脑分辨率过低，请将电脑分辨率调整到1280以上  !</br>"; 
	   }
	   
	   //如果不是谷歌浏览器
	   if(!brow.chrome && !$.support.leadingWhitespace) {
	   	  msg += "请使用google或IE9及以上版本的浏览器，使用其他浏览器可能存在兼容问题  ! 请点击<a href='${pageContext.request.contextPath}/resource/Chrome_Setup.exe' style='color:red'>下载google浏览器</a>";
	   	  alertWidth = 600;
	   }
	   
	   if(msg){
	      msg = "<font size='3px'>" + msg + "</font>";
	   	  $("#isRemember").jalert(msg,{ 
			title : "系统提示", 
			width : alertWidth, 
			height : 130, 
			mask : false
		 });
	   }
	}); 
	</script>
	<%-- <script type="text/javascript">
	//重新生成验证码
	function change_code(imageObj){
		//因为这里的src和验证码那里的src地址一样，所有当点击的时候浏览器不会发送请求，
		//就不会刷新图片，所以最后加一个没实际意义的随机数,servlet那边不接收即可
		imageObj.src = "${pageContext.request.contextPath }/UserServlet?method=createImage&date="+Math.random();  
	}
	</script> --%>
</head>
 
<body>
<div class="box-out">
   	<div class="on-index">
    	<!-- <div id="warn" class="tips"></div> -->
	    <div class="box">
			<div class="box-logo">
				<img src="${pageContext.request.contextPath }/<%=getServletContext().getAttribute("img") %>/logo.png" title="<%=getServletContext().getAttribute("title") %>" width="460" height="40">
			</div>
      		<div class="login">
	        	<form action="user/login" method="post" name="form1" onsubmit="return checksubmit();">
			    <%-- 账号：<input type="text" name="docacc" value="${requestScope.docacc }"><br/>
			    	密码：<input type="password" name="docpass"><br/>
			    	<input type="submit" value="登录"> <input type="reset" value="重置">
			    --%>
			    	<table border="0" cellspacing="0" cellpadding="0" align="center" class="login-body">
			      		<tbody>
				          <tr>
				             <td class="listt">&nbsp;</td>
				             <td id="errmsg" width="250">
		              		 <c:if test="${!empty errorInfo}">
								<p class="mt10 pl130">
									<span class="field-validation-error">${errorInfo}</span>
								</p>
							 </c:if>
					 			<span class="red fl">&nbsp;${requestScope.status }</span>
					 	     </td>
				          </tr>
				          <tr>
				            <td class="listt">您的账号：</td>
				            <td align="left"  colspan="2">
					            <input class="inputbg2" id="docacc" name="docacc" value="" type="text" maxlength="25" tabindex="1" placeholder="手机号码/邮箱/账号" />
					            <!--input class="inputbg2 input-grey" name="docacc" value="${requestScope.docacc }" type="text" maxlength="25" tabindex="1" placeholder="手机号码/邮箱/账号" onfocus="if(this.value=='手机号码/邮箱/账号'){this.value='';this.className='input-black inputbg2'}" onblur="if(this.value==''){this.value='手机号码/邮箱/账号';this.className='input-grey inputbg2'}"-->
				            </td>
				          </tr>
				          <tr>
				            <td class="listt">登录密码：</td>
				            <td align="left" colspan="2">
				              <input class="inputbg2" type="password" id="docpass" name="docpass" maxlength="25" tabindex="1">
				            </td>
				          </tr>
			 			  <%-- <tr>
				            <td class="listt">验证码：</td>
				            <td>
				              <input class="inputbg" type="text" name="v_code" maxlength="6" tabindex="1" align="left"></td>
				            <td>
				             <span><img alt="code..." name="randImage" id="randImage" src="${pageContext.request.contextPath }/UserServlet?method=createImage" title="看不清，点击换一张" onclick="change_code(this)" width="60" height="20" border="1" align="absmiddle">
				              </span>
				             </td>
				          </tr> --%>
				          <tr>
				             <td class="listt"></td>
				             <td>
				                <div class="clearfix">
				                    <lable class="fl"><input type="checkbox" id="isRemember" name="isRemember" value="0" class="check" />&nbsp;记住账号</lable>
				                </div>
				             </td>
				          </tr>
				          <tr>
				            <td class="listt"></td>
				            <td width="165" align="left">
				           		<input class="inital-height" type="image" src="${pageContext.request.contextPath }/img/btn-login.png" />
				            </td>
				          </tr>
	        		  	</tbody>
			      	</table>
		 		</form>
			</div>
			<!--end login-->
		</div>
		<!--end box-->
    	<div class="box-bg"></div>
		<div class="customer-info clearfix">
	        <c:if test="${img != 'img'}">
	            <span>运营机构：</span>
		        <img width="250" src="${pageContext.request.contextPath }/<%=getServletContext().getAttribute("img") %>/hebei/zgltlogo2.png">
	    	</c:if>
	    	<p>客服热线 : 0755-83100120   客服信箱 : services@hk-bithealth.com
	    		<br/>所有内容未经授权， 不得转载或做其他使用 
				<br/>版本： V<%=getServletContext().getAttribute("version") %>
		    </p>
		</div>
    	<!-- <div class="foot">  
	        <table>
	             <tr>
	                <td>系统开发单位：</td>
	                <td><img src="${pageContext.request.contextPath }/img/foot-logo-hk.png"/>深圳中科汇康技术有限公司</td>
	             </tr>
	             <tr>
	                <td>医学支持单位：</td>
	                <td><img src="${pageContext.request.contextPath }/img/foot-logo-yy.png"/>深圳市第二中医院</td>
	             </tr>
	             <tr>
	                <td>核心技术提供：</td>
	                <td><img src="${pageContext.request.contextPath }/img/foot-logo-zk.png"/>中国科学院深圳先进技术研究院</td>
	             </tr>
	        </table>
	        <p>系统开发单位：<img src="${pageContext.request.contextPath }/img/foot-logo-hk.png"/>深圳中科汇康技术有限公司</p>
			<p>医学支持单位：<img src="${pageContext.request.contextPath }/img/foot-logo-yy.png"/>深圳市第二中医院&nbsp;核心技术提供：<img src="${pageContext.request.contextPath }/img/foot-logo-zk.png"/>中国科学院深圳先进技术研究院</p>
		    <div class="" style="background-image: url(${pageContext.request.contextPath }/img/foot_bg.png);">
		      Copyright © 2010-2020 深圳中科汇康技术有限公司 All rights reserved.     版本号:<%-- <%=getServletContext().getAttribute("version") %> --%>
		    </div>
	    </div> -->
	    <div class="foot-box">
		    <div class="foot-bottom">
		           系统开发单位：<img src="${pageContext.request.contextPath }/img/foot-logo-hk1.png"/>深圳中科汇康技术有限公司&nbsp;&nbsp;
		           医学支持单位：<img src="${pageContext.request.contextPath }/img/foot-logo-yy.png"/>广州中医药大学深圳医院&nbsp;&nbsp;核心技术提供：<img src="${pageContext.request.contextPath }/img/foot-logo-zk.png"/>中国科学院深圳先进技术研究院
		    </div>
	 	</div>
	</div>
	<!--on_index-->
</div>

<!-- <script type="text/javascript">
 pngHandler.init();
</script> -->
</body>
</html>
