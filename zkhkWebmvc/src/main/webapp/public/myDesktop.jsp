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
    <title>我的桌面</title>
    <link rel="stylesheet" href="<%=path %>/css/general.css">
    <link rel="stylesheet" href="<%=path %>/public/css/myDesktop.css">

    <script src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
		/*set height of the iframe by shenzhen20150415*/
		function reinitIframe(){
		    var iframe = document.getElementById("mainFrame");
		    try{
		        var bHeight = iframe.contentWindow.document.body.scrollHeight,
		            dHeight = iframe.contentWindow.document.documentElement.scrollHeight,
		            height = Math.min(bHeight, dHeight);
		            iframe.height =  height + 12;
		    }catch (ex){}
		
		}
		window.setInterval("reinitIframe()", 200);
		
		$(function(){
			$("#tab_title li:first").addClass("thistab");
			
			$("#tab_title li").click(function(){
		         $(this).addClass("thistab").siblings().removeClass("thistab");
	       	});
		})
		
		function openDeskMode(){
			window.location.href='../manageMode/editPersonManageMode.html'
		}
	</script>
</head>
<body>
    <div class="content">
        <%-- <div id="right_1">
            <embed src="${pageContext.request.contextPath}/img/xindiantu.swf" width="100%" height="230px">
            <br>
            <hr>
        </div> --%>
        <div>
            <nav>
				<ul id="tab_title" class="clearfix">
					<li><a href="../health/manageschemeTask/listDesktop" target="showBottom">健康管理任务</a></li>
					<!-- <li><a href="../singleReport/showSingAduitList" target="showBottom">单项测量审核</a></li>
					<li><a href="../summaryReport/showSumAduitList" target="showBottom">汇总测量审核</a></li> -->
					<li><a href="../question/singleAudit/list?home=1" target="showBottom">单份答卷审核列表</a></li>
					<li><a href="../question/comAudit/list?home=1" target="showBottom">组合答卷审核列表</a></li>
				</ul>
            </nav>
            <div class="tab-content">
            	<iframe id="mainFrame" src="../health/manageschemeTask/listDesktop" width="100%" height="100%" marginwidth="0" scrolling="no" frameborder="0" name="showBottom"></iframe>
            </div>
        </div>
    </div>
</body>
</html>