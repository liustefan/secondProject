<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title><%=getServletContext().getAttribute("title") %></title>
<meta name="keywords" content="关键词">
<meta name="description" content="网站描述">
<meta http-equiv="page-Enter" content="blendTrans(Duration=0.5)">
<meta http-equiv="page-Exit" content="blendTrans(Duration=0.5)">


<script>
	if(window != top)
	{
		top.location.href = location.href;
	}
</script>
<%-- <script type="text/javascript">
//重新生成验证码
function change_code(imageObj){
	//因为这里的src和验证码那里的src地址一样，所有当点击的时候浏览器不会发送请求，
	//就不会刷新图片，所以最后加一个没实际意义的随机数,servlet那边不接收即可
	imageObj.src = "${pageContext.request.contextPath }/UserServlet?method=createImage&date="+Math.random();  
}
</script> --%>

<style>
html ,body{
 background:url(${pageContext.request.contextPath }/img/web_bg0.jpg) no-repeat 50% 0 #000;
}
img{
border:0px solid #444;
border:0;

}
.on_indext{
 height:100%;
 overflow: hidden;
}
.on_index{
 margin:0 auto;
 width:1003px
 overflow: hidden;
}

</style>
</head>
<body>
<script>
//alert(1);
var outLine = "<%=request.getAttribute("outLine")%>";
var timeOut = "<%=request.getAttribute("timeOut")%>";
if(outLine == 'Y'){
	alert("此账号已在另一客户端登录，您被强制剔除！");
}else if(timeOut == 'Y'){
	alert("登录会话超时，请重新登录！");
}
	
var topw = window.top;
if(topw==window.self){
	window.location.href = '<%=basePath%>'
}else{
	try{
	topw.toLoginPage();
	}catch(e){
		window.location.href = '<%=basePath%>'
	}
}
</script>
</body>
</html>
