<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title><%=getServletContext().getAttribute("title") %></title>
<meta name="keywords" content="关键词">
<meta name="description" content="网站描述">
<meta http-equiv="page-Enter" content="blendTrans(Duration=0.5)">
<meta http-equiv="page-Exit" content="blendTrans(Duration=0.5)">

<script type="text/javascript" src="<%=basePath%>js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery-ui.min.js"></script>


<script type="text/javascript">
	var url = '${URL}';
	$(document).ready(function() {
		$('#bak').click(function() {
			if (url != '') {
				window.location.href = url;
			} else
				history.go(-1);
		})
	});
</script>
<style type="text/css">
.notice {
	width:80%;
	min-width:500px;
	background:#f6f6f6;
	margin: 0 auto;
	text-align: center;
	
}

.notice .info {
    width:400px;
    padding: 30px;
	margin: 0 auto;
}

.notice img {
	border: 0;
	float: left;
}

.btn-normal {
	padding: 5px 10px;
	border-radius: 3px;
	border: none;
	color: #FFF;
	font-size: 13px;
	background: rgba(072, 214, 096, 0.8);
	background-image: -moz-linear-gradient(center top, rgba(072, 214, 096, 0.8),
		rgba(097, 185, 095, 0.8)) repeat scroll 0 0 rgba(072, 214, 096, 0.8);
	background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, rgba(072,
		214, 096, 0.8)), color-stop(1, rgba(097, 185, 095, 0.8)));
	filter: progid:DXImageTransform.Microsoft.Gradient(GradientType=0,
		StartColorStr='#48d660', EndColorStr='#61b95f');
	cursor: pointer;
	font-family: "Microsoft YaHei", "SimSun";
}

.clear {
	clear: both;
}
.notice-info{float:right;width:310px;text-align:left;}
.notice-info h3{
    font-size: 16px;
	font-weight: bold;
	margin:0;
	padding:7px 0;
	color: #090;
	font-family: "Microsoft YaHei";
}
</style>
</head>
<body>
	<div class="notice">

		<div class="info">
			<c:if test="${code=='0000' }">
				<img src="${pageContext.request.contextPath }/img/icon-yes.png" />
			</c:if>
			<c:if test="${code!='0000' }">
				<img src="${pageContext.request.contextPath }/img/icon-no.png" />
			</c:if>
			<div class="notice-info">
				<h3>${err_msg}</h3>
				<input id="bak" type="button" class="btn-normal" onclick="" value="返回" />
			</div>
			<div class="clear"></div>
		</div>
		
	</div>

</body>
</html>
