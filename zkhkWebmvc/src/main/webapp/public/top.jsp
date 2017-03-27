<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%
String path = request.getContextPath();
%>
<!DOCTYPE html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>顶部菜单页面</title>
	<link href="<%=path %>/css/top.css" rel="stylesheet" type="text/css" />
	<script src="<%=path %>/js/jquery.min.js" type="text/javascript"></script>
</head>

<script type="text/javascript">
    $(function(){
       var mwidth = $(window).width();
       
       $("#menu_right").width(mwidth-330);
       
       $(window).resize(function() {
		 var mwidth=$(window).width();
         $("#menu_right").width(mwidth-330);
		});

		$('th').click(function(e){
			$("th").each(function(){ 
				$(this).removeClass('thcolor');
			});
			
			$(this).addClass('thcolor');
		})
		
	});
	
</script>

<body>
	<div id="menu" class="clear-fix">
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
				<tr>
				 
                 <c:if test="${userInfo.roleid != 6 && userInfo.roleid != 1 && userInfo.roleid != 5}" >
					<th class="thcolor"><a href="<%= path + "/public/content.jsp"%>" target ="showframe" class="bgc">我的桌面</a></th>
				</c:if>
				<c:if test="${userInfo.roleid != 6 && userInfo.roleid != 5}" >
					<th><a href="<%= path + "/public/memberManage.jsp"%>" target ="showframe">会员管理</a></th>
				</c:if>
				<c:if test="${userInfo.roleid != 6 && userInfo.roleid != 1 && userInfo.roleid != 5}" >	
					<th><a href="<%= path + "/public/measureManager.jsp"%>" target ="showframe">测量管理</a></th>
					<th><a href="<%= path + "/public/reportManager.jsp"%>" target ="showframe">报告管理</a></th>
				</c:if>
				<c:if test="${userInfo.roleid != 5  && userInfo.roleid != 1  && userInfo.roleid != 2   && userInfo.roleid != 3  && userInfo.roleid != 4  && userInfo.roleid != 7  }" >
					<th><a href="<%= path + "/public/groupManage.jsp"%>" target ="showframe">系统管理</a></th>
				</c:if>
				
				<c:if test="${userInfo.roleid == 1}" >
					<th><a href="<%= path + "/public/reportManager.jsp"%>" target ="showframe">模板管理</a></th>
				</c:if>
				
				<c:if test="${userInfo.roleid == 5 || userInfo.roleid == 6|| userInfo.roleid == 1}" >
					<th><a href="<%= path + "/public/userCenter.jsp"%>" target ="showframe">用户管理</a></th>
				</c:if>
				<c:if test="${userInfo.roleid != 1 && userInfo.roleid != 5}" >
					<th><a href="<%= path + "/public/questionManager.jsp"%>" target ="showframe">问卷管理</a></th>
				</c:if>
				<c:if test="${userInfo.roleid == 5 || userInfo.roleid == 6|| userInfo.roleid == 1 || userInfo.roleid == 2 }" >
					<th><a href="<%= path + "/public/statisticalReports.jsp"%>" target ="showframe">统计报表</a></th>
				</c:if>
				<c:if test="${userInfo.roleid == 7 }" >
					<th><a href="<%= path + "/public/messageManager.jsp"%>" target ="showframe">消息管理</a></th>
				</c:if>
				<c:if test="${logRole==2 || logRole==3 || logRole==4 || logRole==7}">
					<th><a href="<%= path + "/public/publicHealthServices.jsp"%>" target ="showframe">公卫服务</a></th>
				</c:if>




			</table>
		</div>
	</div>	
</body>
</html>