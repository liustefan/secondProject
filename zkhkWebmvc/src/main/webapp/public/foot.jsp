<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>页脚页面</title>	
	<link href="${pageContext.request.contextPath }/css/reset.css" rel="stylesheet" type="text/css">
</head>
<style>

.foot-box{width:100%;color:#333;}
.foot-bottom{height:33px;margin:0 auto;text-align:center;line-height:34px;margin-left:320px;margin-right:10px;border-top:1px #ddd solid;}
.foot-box img{margin:0px 4px;width:24px;}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script type="text/javascript">
    $(function(){
    	 var mwidth=$(window).width();
       $(".foot-bottom").width(mwidth-330);
       $(window).resize(function() {
    	 var mwidth=$(window).width();
         $(".foot-bottom").width(mwidth-330);
		});
    });
    
</script>

<body style="/*background:#009c45;*/overflow:hidden;">
	  <div class="foot-box">
	       <div style="width:310px;background:#e5e5e5;position:fixed;left:0,bottom:0;height:34px;"></div>
	       <div class="foot-bottom">
		           系统开发：<img src="${pageContext.request.contextPath }/img/foot-logo-hk.png"/>深圳中科汇康技术有限公司&nbsp;&nbsp;
		           医学支持：<img src="${pageContext.request.contextPath }/img/foot-logo-yy.png"/>广州中医药大学深圳医院&nbsp;&nbsp;核心技术提供：<img src="${pageContext.request.contextPath }/img/foot-logo-zk.png"/>中国科学院深圳先进技术研究院
	       </div>
	       
	 </div>
</body>
</html>