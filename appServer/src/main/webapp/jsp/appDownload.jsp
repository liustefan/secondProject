<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%  String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<!DOCTYPE html>
<html lang="en">
	<head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	    <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">    
        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
        <script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
        <title>邀请会员下载</title>
        <link rel="stylesheet" type="text/css" href="<%=basePath%>css/xz.css">
	</head>
	<body>
	     <content>
	        <div class="bottom-img">
	            <img src="<%=basePath%>img/hdbg-xz.png" class="center-block">
	        </div>
	        <div class="top">
	            <img src="<%=basePath%>img/logo-xz.png" class="center-block logo-xz">
	            <p class="logo-font">汇康e家</p>
	        </div>
	        <div class="middle">
	            <div class="left-img">
	                <img class="img-btn" src="<%=basePath%>img/android-xz.png" onclick="downloadAndroid()" />
	                <b id="androidId" style="display: none">${data.androidAddress}</b>
	            </div>
	            <div class="right-img">
	                <img class="img-btn" src="<%=basePath%>img/ios-xz.png" onclick="downloadIos()" />
	                <b id="iosId" style="display: none">${data.iosAddress}</b>
	            </div>
	        </div>
	        <div class="foot">
	            <img src="<%=basePath%>img/phone-bg.png" class="center-block full-height">
	        </div>
	    </content>
	</body>
	<script type="text/javascript">
	function downloadAndroid(){
		var androidAddress = $("#androidId").text();
		if(androidAddress != null){
			window.location.href = androidAddress;  
		}else{
			alert("未配置下载链接地址");
		}
	}
	
	function downloadIos(){
		var iosAddress = $("#iosId").text();
		if(iosAddress != null){
			window.location.href = iosAddress;  
		}else{
			alert("未配置下载链接地址");
		}
	}
	</script>
</html>
