<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>汇康e家首页</title>
	<link rel="shortcut icon" type="image/x-icon" href="<%=path %>/<%=getServletContext().getAttribute("img") %>/title_ico.ico" />
   	<link rel="stylesheet" type="text/css" href="<%=path %>/css/general.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/public/css/index.css">

	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.cookie.js"></script>
	<script type="text/javascript" src="<%=path %>/public/js/index.js"></script>
	<script>
		<%-- var EventUtil = {
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
			window.location.href = '<%= path + "/error.jsp"%>';
		}); --%>
		 
<%-- 	var myTime = setTimeout("Timeout()", 6000);   
		function resetTime() { 
		    clearTimeout(myTime);
		    myTime = setTimeout('Timeout()', 6000);
		}  
		function Timeout() {
			console.log(123)
			console.log(document.readyState)
			if(document.readyState != 'complete'){
				document.location.href='<%= path + "/error.jsp"%>';
			}
		}   
 		document.documentElement.onkeydown=resetTime;  
 		document.documentElement.onclick=resetTime;
 		document.getElementsByTagName("iframe").onreadystatechange = function(){ 
			if (iframe.readyState != "complete"){ 
				alert(222);
				resetTime();
			} 
 		}
 		$("a[target='showRight']").click(function () {
			resetTime();
		})
		
 		var ifmurl=document.getElementById('rightIframe').contentWindow.location.href;
		
 		$("#rightIframe").on('load', function(){
			resetTime();
		}); --%>
		
		function toLoginPage(){
			window.location.href = '<%=basePath%>'
		}
		function getRoot(){
			return '<%=basePath%>';
		}
		$(document).ready(function(){
			 var isRemember = "${isRemember}";
			 //勾选了记住账号
			 if(isRemember == 1){
			 	$.cookie("docAcc","${docAcc}" ,{expires:365,path:"/"});
			 }
	 		 var removeOther = "<%=request.getAttribute("removeOther")%>";
			 //剔除其他客户端的登录状态
			 if(removeOther == 'Y'){
			 	alert('您上次登录没有正常退出系统..... \n\n 或 \n\n此账号在另一客户端登录，已被您强制剔除！');
			 }
		});
		
		/* function homePage(){
			var menu = $("frame")[0].contentWindow.document.getElementById("menu_right");
			$($("frame")[1]).attr('src', $('a', $(menu)).first().attr('href'));
		} */
		
		/* 点击头部菜单默认加载的页面 */
		function loadInit (link) {
			$("#rightIframe").attr("src",link);
		}
		/* 角色登录成功，页面默认加载的初始页面 */
		$(function(){
			$("#menu_right tr th:first").addClass("thcolor").siblings().removeClass("thcolor");
			
			if(${userInfo.roleid != 6 && userInfo.roleid != 1 && userInfo.roleid != 5}){
				$("#leftIframe").attr("src",'<%= path + "/public/content.jsp"%>');
				$("#rightIframe").attr("src",'<%= path + "/public/myDesktop.jsp"%>');
			}
			if(${userInfo.roleid == 1}){
				$("#leftIframe").attr("src",'<%= path + "/public/memberManage.jsp"%>');
				$("#rightIframe").attr("src",'<%=path %>/memberType/listMemberType');
			}
			if(${userInfo.roleid == 5}){
				$("#leftIframe").attr("src",'<%= path + "/public/userCenter.jsp"%>');
				$("#rightIframe").attr("src",'<%= path%>/doctor/listSysAdmin');
			}
			if(${userInfo.roleid == 6}){
				$("#leftIframe").attr("src",'<%= path + "/public/groupManage.jsp"%>');
				$("#rightIframe").attr("src",'<%= path %>/ofun/getOfunList');
			}
		});
		
		function loadHead(uniqueId, docName) {
			$("#docNameHref").text(docName);
			document.getElementById("imageDiv").src= "${pageContext.request.contextPath }/image/getImage?uniqueId=" + uniqueId;
		}
	</script>
</head>
<body class="over-hidden">
	<!-- 头部内容  -->
	<div id="menu" class="clearfix">
		<c:if test="${img != 'img'}">
			<div id="logo_left" style="background: #68ba5f;">
				<img src="<%=path %>/<%=getServletContext().getAttribute("img") %>/zgltwlogo0.png" alt="logo"/>
			</div>
		</c:if>
		<c:if test="${img == 'img'}">
			<div id="logo_left" style="background: #fff;">
				<img src="<%=path %>/img/zkhklogo0.png" alt="logo"/>
			</div>
		</c:if>
		<div id="menu_right">
			<table border="0" cellpadding="0" cellspacing="0">
				<tbody>
					<tr>
					<c:if test="${userInfo.roleid != 6 && userInfo.roleid != 1 && userInfo.roleid != 5}" >
						<th class="thcolor"><a href="<%= path + "/public/content.jsp"%>" target="showframe" class="bgc" onclick='loadInit("<%= path + "/public/myDesktop.jsp"%>")'>我的桌面</a></th>
					</c:if>
					<c:if test="${userInfo.roleid != 6 && userInfo.roleid != 5}" >
					<c:choose>
					<c:when test="${userInfo.roleid == 1}">
					<th><a href="<%= path + "/public/memberManage.jsp"%>" target="showframe" onclick='loadInit("<%= path %>/memberType/listMemberType")'>会员管理</a></th>
					</c:when>
					<c:otherwise>
					<th><a href="<%= path + "/public/memberManage.jsp"%>" target="showframe" onclick='loadInit("<%= path %>/member/memberList?flag=my")'>会员管理</a></th>
					</c:otherwise>
					</c:choose>
					</c:if>
					<c:if test="${userInfo.roleid != 6 && userInfo.roleid != 1 && userInfo.roleid != 5}" >	
					<th><a href="<%= path + "/public/measureManager.jsp"%>" target ="showframe" onclick='loadInit("../bloodPressure/queryBloodPressure?wheAbnTag=1&docid=${userInfo.id}")'>测量管理</a></th>
					
					<%-- <th><a href="<%= path + "/public/reportManager.jsp"%>" target ="showframe" onclick='loadInit("<%= path + "/singleReport/showSingAduitList"%>")'>报告管理</a></th> --%>
				</c:if>
				<c:if test="${userInfo.roleid != 5  && userInfo.roleid != 1  && userInfo.roleid != 2   && userInfo.roleid != 3  && userInfo.roleid != 4  && userInfo.roleid != 7  }" >
					<th><a href="<%= path + "/public/groupManage.jsp"%>" target ="showframe" onclick='loadInit("<%= path + "/ofun/getOfunList"%>")'>系统管理</a></th>
				</c:if>
				
				<c:if test="${userInfo.roleid == 1}" >
					<th><a href="<%= path + "/public/reportManager.jsp"%>" target ="showframe" onclick='loadInit("<%= path%>/template/toOpintionTemplatPage?type=1")'>模板管理</a></th>
				</c:if>
				
				<c:if test="${userInfo.roleid == 5 || userInfo.roleid == 6|| userInfo.roleid == 1}" >
			     	<!-- 金钥匙账户 -->
					<c:if test='${userInfo.roleid == "5"}'>
					    <th><a href="<%= path + "/public/userCenter.jsp"%>" target ="showframe" onclick='loadInit("<%= path%>/doctor/listSysAdmin")'>用户管理</a></th>
				 	</c:if>
	                <!-- 系统管理员账户 -->
				 	<c:if test='${userInfo.roleid == "6"}'>
				 	<th><a href="<%= path + "/public/userCenter.jsp"%>" target ="showframe" onclick='loadInit("<%= path%>/doctor/listCommonAdmin")'>用户管理</a></th>
				 	</c:if>
				 	
	               <!-- 管理员账户 -->
				 	<c:if test='${userInfo.roleid == "1"}'>
				 	<th><a href="<%= path + "/public/userCenter.jsp"%>" target ="showframe" onclick='loadInit("<%= path%>/doctor/listDoctor?orgId=${userInfo.dept_id}")'>用户管理</a></th>
				 	</c:if>
				 	
				<!-- 一般账户 ,显示所有的问卷信息-->
			<%-- 		<c:if test='${userInfo.roleid == "2" || userInfo.roleid == "3" || userInfo.roleid == "4"}'> --%>
			<%-- 		    <th><a href="<%= path + "/public/userCenter.jsp"%>" target ="showframe" onclick='loadInit("<%= path %>/doctor/doctorAction!showUpdateInfoByIdUI?docid=${userInfo.id }")'>用户管理</a></th> --%>
			<%-- 		</c:if> --%>
				</c:if>
				
				<c:if test="${userInfo.roleid == 5 || userInfo.roleid == 6|| userInfo.roleid == 1 || userInfo.roleid == 2 }" >
					<th><a href="<%= path + "/public/statisticalReports.jsp"%>" target ="showframe" onclick='loadInit("../statistic/exProcSelectMeasurementStatics")'>统计报表</a></th>
				</c:if>
				
				<c:if test="${userInfo.roleid != 6 && userInfo.roleid != 1 && userInfo.roleid != 5}" >
<%-- 				<c:if test="${userInfo.roleid == 7}" > --%>
					<th><a href="<%= path + "/public/questionManager.jsp"%>" target ="showframe" onclick='loadInit("../question/singleQuestion/list")'>问卷管理</a></th>
				</c:if>
				<c:if test="${userInfo.roleid != 5  && userInfo.roleid != 1  && userInfo.roleid != 2   && userInfo.roleid != 3  && userInfo.roleid != 4  && userInfo.roleid != 7  }" >
					<th><a href="<%= path + "/public/questionManager.jsp"%>" target ="showframe" onclick='loadInit("../question/singleQuestion/list")'>模板管理</a></th>
				</c:if>
				
				
				<c:if test="${userInfo.roleid == 7}">
					<th><a href="<%= path + "/public/messageManager.jsp"%>" target ="showframe" onclick='loadInit("../msgCenter/listTitleTag")'>消息管理</a></th>
				</c:if>
				<c:if test="${userInfo.roleid != 7 && userInfo.roleid != 6 && userInfo.roleid != 5 && userInfo.roleid != 1}" >
					<th><a href="<%= path + "/public/messageManager.jsp"%>" target ="showframe" onclick='loadInit("../communicate/listCommunicate")'>消息管理</a></th>
				</c:if>
				<c:if test="${userInfo.roleid != 6 && userInfo.roleid != 5 && userInfo.roleid != 1}" >
					<th><a href="<%= path + "/public/publicHealthServices.jsp"%>" target ="showframe" onclick='loadInit("../health/listHealth")'>健康管理</a></th>
				</c:if>
				</tr>
				</tbody>
			</table>
		</div>
	</div>

	<!-- 中间两个frame层  -->
	<div id="content_box" class="main-content clearfix over-hidden">
		<div id="left" class="clearfix">
			<div class="lt1">
				<div id="lt1_1">
					<div class="clearfix">
						<div id="lt1_1_img" class="fl">
							<c:if test="${not empty userInfo.headAddress}">
							    <img id="imageDiv" src="${pageContext.request.contextPath }/image/getImage?uniqueId=${userInfo.headAddress}" style="width: 64px; height: 64px;">
							</c:if>
							<c:if test="${empty userInfo.headAddress}">
							    <img src="${pageContext.request.contextPath }/img/user_img.png" style="width: 64px; height: 64px;">
							</c:if>
					 	</div>
						
						<div id="lt1_1_welcome" class="fl">
							<span id="doctor_name"><a href="${pageContext.request.contextPath }/doctor/viewDoctorDetail?docid=${userInfo.id }" target="_blank" id="docNameHref">${userInfo.realName }</a>
									<c:if test='${userInfo.roleid ==2 || userInfo.roleid == "3" || userInfo.roleid == "4" }'>医生</c:if></span>
							<span id="designation">&nbsp;</span>
						 	<span id="welcome_title">欢迎您!</span>
						 	<p>上次登录时间：<fm:formatDate value="${userInfo.lastLoginTime }" pattern="MM-dd HH:mm"/><br><i>上次登录地址：<c:out value="${userInfo.lastLoginAddr }"></c:out></i></p>
						</div>
					</div>
		     		<div class="user-operate clearfix">
		     		<c:choose>
		     		<c:when test="${userInfo.roleid ne 5 && userInfo.roleid ne 1 && userInfo.roleid ne 6 }">
		     		    <a class="icon-info" href="<%=path %>/public/content.jsp" target="showframe" onclick='loadInit("${pageContext.request.contextPath }/user/myInfoDetail?docid=${userInfo.id }")'>个人资料</a>&nbsp;<b></b>
						<a class="icon-cgpassword"  href="<%=path %>/public/content.jsp" target="showframe" onclick='loadInit("<%= path %>/public/UpdatePsd.jsp")'>修改密码</a><b></b>
						<a class="icon-help" href="<%= path %>/public/content.jsp" onclick='loadInit("<%= path %>/public/help.jsp")' target="showframe">帮助</a><b></b>
		     		</c:when>
		     		<c:otherwise>
		     		    <a class="icon-info" href="<%=path %>/public/blank_menu.jsp" target="showframe" onclick='loadInit("${pageContext.request.contextPath }/user/myInfoDetail?docid=${userInfo.id }")'>个人资料</a>&nbsp;<b></b>
						<a class="icon-cgpassword"  href="<%=path %>/public/blank_menu.jsp" target="showframe" onclick='loadInit("<%= path %>/public/UpdatePsd.jsp")'>修改密码</a><b></b>
						<a class="icon-help" href="<%= path %>/public/blank_menu.jsp" onclick='loadInit("<%= path %>/public/help.jsp")' target="showframe">帮助</a><b></b>
		     		</c:otherwise>
		     		</c:choose>
						<a class="icon-logout" href="<%=path %>/user/logout" target="_top" class="exit-bg">注销</a>
					</div>
				</div>
			</div>
<%-- 			<c:if test="${userInfo.roleid == '5'}">
			<iframe id="leftIframe" name="showframe" width="100%" src="${pageContext.request.contextPath }/public/userCenter.jsp"></iframe>
			</c:if>
			
			<c:if test="${userInfo.roleid == '1'}"> 
			<iframe id="leftIframe" name="showframe" width="100%" src="${pageContext.request.contextPath }/public/memberManage.jsp"/>
			</c:if>
			
			<c:if test="${userInfo.roleid == '6'}">
			<iframe id="leftIframe" name="showframe" width="100%" src="${pageContext.request.contextPath }/public/groupManage.jsp"/>
			</c:if>
			
			<c:if test='${userInfo.roleid == "2" || userInfo.roleid == "3" || userInfo.roleid == "4" || userInfo.roleid == "7"}'>
			<iframe id="leftIframe" name="showframe" width="100%" src="${pageContext.request.contextPath }/public/content.jsp"/>
			</c:if> --%>
			<iframe id="leftIframe" name="showframe" width="100%" height="" src=""></iframe>
		</div>
		<div id="right" class="clearfix fr">
	 		<iframe id="rightIframe" name="showRight" width="100%" height="" src=""></iframe>
		</div>
	</div>
	<!-- 底部内容  -->
	<div class="foot-box clearfix">
        <div class="foot-left"></div>
        <div class="foot-bottom">
	           系统开发：<img src="${pageContext.request.contextPath }/img/foot-logo-hk.png"/>深圳中科汇康技术有限公司&nbsp;&nbsp;
	           医学支持：<img src="${pageContext.request.contextPath }/img/foot-logo-yy.png"/>广州中医药大学深圳医院&nbsp;&nbsp;核心技术提供：<img src="${pageContext.request.contextPath }/img/foot-logo-zk.png"/>中国科学院深圳先进技术研究院
        </div>
	</div>
</body>
</html>