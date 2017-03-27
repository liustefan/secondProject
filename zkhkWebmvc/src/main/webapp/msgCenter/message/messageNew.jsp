<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>发送消息</title>
	
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/general.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/member.css"> 
	<link rel="stylesheet" type="text/css" href="<%=path %>/js/skins/blue.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.artDialog.js"></script>
	<script type="text/javascript" src="<%=path %>/js/plugins/iframeTools.js"></script>

	<script type="text/javascript">
	function send(){
		var text = $.trim($("#msgContent").val());
		if ("" == text){
			alert('消息不能为空');
			return;
		}
		
		$("#btndel2").prop('disabled',true);
		 $.ajax({
             type: "POST",
             url: "sendMsgByMemberId",
             data: {memberId:${param.memberId}, content:text},
             cache:false,
             async:false,
             success: function(data){
            	 if (data.status){
            		 alert("发送成功");
            		 location.reload(true);
            	 }else{
            		 alert("发送失败");
            		 $("#btndel2").prop('disabled',false);
            	 }
              }
         });
	}
	</script>
</head>
<body>
<div class="content">
	<div class="content-title">温馨提示 --- 发送新消息</div>
	<div class="mess-title clearfix">
         <div class="fl"><span>姓名：${member.memname}</span><span class="mar-left">电话：${member.tel}</span></div>
         <div class="fr"><input type="button" value="返回" onclick="javascript:history.go(-1);" class="btn-cancel"></div>
	</div>
	<form action="toSendMsg" method="get">
	<input type="hidden" name="memberId" value="${member.memberid}"/>
	<div class="box-mess m-t-15">
	     <div class="title">历史消息</div>
	     <ul class="content">
	     	<c:forEach items="${page.result}" var="item" varStatus="vs">
		         <li><a style="cursor:default"><c:out value="${item.content}" escapeXml="true"/></a><span>发送时间；${item.createTime}</span></li>
			</c:forEach>	
	     </ul>
	     <div class="page-box">
		    <div class="fr page">
		    	<jsp:include page="/public/pageFoot.jsp"/>
		    </div>
	    </div>
	</div>
	</form>
	<div class="box-mess m-t-15">
	     <div class="title">新消息</div>
	     <textarea id="msgContent"></textarea>
	</div>
	
	<div class="page-box align-center">
    	<button type="button" id="btndel2" class="btn-normal" onclick="send();">发送</button>
    </div>
</div>
</body>
</html>