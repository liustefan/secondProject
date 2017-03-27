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
	    <title>广告详情</title>
	    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/healthInformation.css">
	</head>
	<body>
	        <img id ="coverImg" src="" alt="广告详情图片" class="img-responsive center-block">
	        <article>
	          <h2>${data.title}</h2>
	          <p><small>${data.createtime}</small></p>
	          <b>${data.content}</b>
	          <br>
	          <b id="id" style="display: none">${data.coverimage}</b>
	        </article>
	</body>
	<script type="text/javascript">
	$(function(){
		//var imgStr = "57c8124ee4352feb4fa97b69";
		var imgStr = $("#id").text();
		var imgPath = "<%=basePath%>file/downloadFileOrImage?fileName=" + imgStr;
		$("#coverImg").attr("src",imgPath);
	})
	</script>
</html>
