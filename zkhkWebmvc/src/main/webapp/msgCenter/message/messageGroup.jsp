<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	<title>群发消息</title>
	
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/css/member.css">
	<link rel="stylesheet" href="<%=path %>/js/skins/blue.css">
	<link rel="stylesheet" href="<%=path %>/css/zTreeStyle/zTreeStyle.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.7.2.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.artDialog.js"></script>
	<script type="text/javascript" src="<%=path %>/js/plugins/iframeTools.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.ztree.core-3.5.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.ztree.excheck-3.5.js"></script>
</head>
<body>
<div class="content">
	<div class="content-title">温馨提示 --- 群发消息</div>
	<div class="mess-title clearfix">
         <div class="fl"><span>群发消息</span></div>
         <div class="fr">
         	<input type="button" value="返回" onclick="javascript:history.go(-1);" class="btn-cancel">
         </div>
	</div>
	<div class="clearfix m-t-15">
		<div class="fl box-tree w30">
		     <div class="title">请选择发送群组</div>
		     <div class="content-tree">
		          <div class="ztree" id="updateTree"></div>
		     </div>
		</div>
		<div class="fr w60">
		    <div class="send-title">以下消息发送给&nbsp;<b id="sendGroup"></b>&nbsp;所有人员</div>
			<div class="box-mess m-t-15">
			     <div class="title">新消息</div>
			     <textarea id="msgContent"></textarea>
			</div>
		    <div class="page-box align-center">
				<button type="button" id="btndel2" class="btn-normal" onclick="send()">发送</button>
			</div>
		</div>
	</div>
</div>
</body>
<script type="text/javascript">
var setting = {
		check: {
			enable: true,
			chkStyle: "radio",
			radioType: "all"
		},
		data: {
			simpleData: {
				enable: true,
			}
		},
		view: {
			showIcon: false,
			selectedMulti: false
		}
		
	};
	
	$(function(){
		 $.ajax({
             type: "POST",
             url: "../../memberGrp/listMemGrpByDoctor",
             cache:false,
             success: function(data){
					$.fn.zTree.init($("#updateTree"), setting, data);
              }
         });
		$('.chk').live('click',function(){
			if($(this).hasClass('radio_true_full_focus')){
				$('#sendGroup').text($(this).next().attr('title'));
			}
		});
	});
	
	function send(){
		 var treeObj=$.fn.zTree.getZTreeObj("updateTree");
         var  nodes=treeObj.getCheckedNodes(true);
         if (nodes.length == 0){
	          alert("请选择发送群组");
	          return;
       	}
         
         var text = $.trim($("#msgContent").val());
 		if ("" == text){
 			alert('消息不能为空');
 			return;
 		}
 		
 		$("#btndel2").prop('disabled',true);
 		 $.ajax({
              type: "POST",
              url: "../../message/sendMsgByGroupId",
              data: {groupId:nodes[0].id, content:text},
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
</html>