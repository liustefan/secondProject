<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>网络异常</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/error.css" >
    <script>
    	var EventUtil = {
		    addHandler: function(element, type, handler) {
		        if (element.addEventListener) {
		            element.addEventListener(type, handler, false);
		        } else if (element.attachEvent) {
		            element.attachEvent("on" + type, handler);
		        } else {
		            element["on" + type] = handler;
		        }
		    }
		};
    	var Url = '';

		EventUtil.addHandler(window, "offline", function() {
			Url ='<%= path + "/error.jsp"%>';
		});
		EventUtil.addHandler(window, "online", function() {
			Url ='<%= path + "/login.jsp"%>';
		});
		
		function reload(){
			window.location.href = Url
		}
    </script>
</head>

<body>
	<div class="error-box">
    	<img src="${pageContext.request.contextPath }/img/error.png">
    	<p>网络出现异常，页面无法显示，请检查网络后尝试
        	<a href="javascript:void(0);" onclick="reload();">刷新</a>
    	</p>
	</div>
</body>
</html>