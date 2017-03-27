<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="com.bithealth.sdk.common.utils.TimeUtil"%>
<%@ page language="java" import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.net.URLDecoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
    <title>测量管理查看页面头部</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<link rel="shortcut icon" type="image/x-icon" href="<%=path %>/<%=getServletContext().getAttribute("img") %>/title_ico.ico"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/celiangsing.css">
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
		function toLoginPage(){
			window.location.href = '<%=basePath%>'
		}
		function getRoot(){
			return '<%=basePath%>';
		}
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
		EventUtil.addHandler(window, "offline", function() {
		    window.location.href='<%= path + "/error.jsp"%>';
		});
	</script>
</head>
<body>
<div style="height: 100px;">
	<div class="single_report_head">
		<div class="person-info clear-fix">
			<div class="fl person-img">
				<c:if test="${not empty param.headAddress}">
				    <img src="<%=path %>/image/getImage?uniqueId=${param.headAddress}" style="width: 64px; height: 64px;">
				</c:if>
				<c:if test="${empty param.headAddress}">
				    <img src="<%=path %>/img/mem_img.png" style="width: 64px; height: 64px;">
				</c:if>	
			</div>
			<div class="fr">
				<p>姓名：<%String name=URLDecoder.decode(request.getParameter("memName"),"UTF-8"); %><%=name %></p>
				<p>性别：${param.gender eq '1'?'男': param.gender eq '2'?'女': '未知'}</p>
				<p>年龄：<%String birthday=request.getParameter("birthDate");
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
								int age=0;
								try{
									if(!birthday.isEmpty()){
										age = TimeUtil.getAge(sdf.parse(birthday));
									}
								}catch(Exception e){
									e.printStackTrace();
								}%>
								<%=age %></p>
			</div>
		</div>
		<h3 id="headMeasure_title"></h3>
	</div>
</div>
</body>
</html>
 