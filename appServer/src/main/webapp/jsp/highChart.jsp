<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<!-- <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
<head>
<meta charset="UTF-8">
<title>心电展示</title>
<style type="text/css">
body {
	margin: 0;
	padding: 0;
}

loading-indicator {
	font-size: 8pt;
	background-image: url(<%=path %>/img/loading.gif);
	background-repeat: no-repeat;
	background-position: top left;
	padding-left: 20px;
	height: 18px;
	text-align: left;
}

#loading{
	display: none;
	position: absolute;
	left: 45%;
	top: 40%;
	border: 3px solid #B2D0F7;
	background: white url(<%=path %>/img/block-bg.gif) repeat-x;
	padding: 10px;
	font: bold 14px verdana, tahoma, helvetica;
	color: #003366;
	width: 180px;
	text-align: center;
}

#msg {
	display:none;
	position: absolute;
	left: 45%;
	top: 40%;
	text-align: center;
	color: red;
}
</style>
<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/highstock.js"></script>
<script type="text/javascript" src="<%=path %>/js/exporting.js"></script>
<script type="text/javascript" src="<%=path %>/js/data.js"></script>
</head>
<body>
	<div id="msg">没有数据</div>
	<b id="id" style="display: none">${data}</b>
	<div id="loading">
		<div class="loading-indicator">页面正在加载中...</div>
	</div>
	<div id="ecgChart" style="margin: 0 auto;"></div>
</body>
<script type="text/javascript">
	//判断页面是否加载完毕，如果加载完毕，就删除加载信息的DIV
	document.onreadystatechange = function() {
		console.log(document.readyState);
		try {
			if (document.readyState == "complete") {
				delNode("loading");
			}
		} catch (e) {
			console.log("页面加载失败");
		}
	}

	//删除指定的DIV
	function delNode(nodeId) {
		try {
			var node = $("#" + nodeId);
			if (node !== null) {
				node.remove();
			}
		} catch (e) {
			console.log("删除ID为" + nodeId + "的节点出现异常");
		}
	}
	$(function(){
		var dt = $("#id").text();
		if(dt != null){
			var json = eval("("+dt+")"); 
			setChart("ecgChart", json);
		}else{
			$('#msg').show();
		}
	});
</script>
</html>