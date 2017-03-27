<%@ page contentType="text/html; charset=utf-8" language="java" import="java.util.*" %>
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
	<title>短信发送测试</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/plugins/zTree_v3/css/zTreeStyle/zTreeStyle.css">
	<link rel="stylesheet" href="<%=path %>/plugins/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="<%=path %>/css/tree.css">

	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.core-3.5.min.js"></script>
	<script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.excheck-3.5.js"></script>
	<script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.exhide-3.5.js"></script>
	<script type="text/javascript" src="<%=path %>/js/tree.js"></script>
	<script type="text/javascript">
		var obj1;
		$(function(){
			$.ajax({
				type : "GET",
				url : '<%=path %>/org/listAllOrg?pId=0',
				async: false,
				success : function(obj) {
					obj1 = obj;
				}
			});
			
			var index=0;
			$("#add_sms").click(function(){
				index++;
				var str = "<div class='search-term add-bottom'><div class='send-detail'><ul><li><label><span class='red'>*</span>组织名称：</label>"
					+" <div class='position-r'><input class='info' type='hidden' name='smsSendParams["+index+"].orgId' id='orgId_"+index+"' value='${orgId }' readonly='readonly'/><input type='text' "
					+"class='width-nomal' id='orgs_"+index+"' value='${orgName }' readonly='readonly'><i class='member-search' onclick=\"orgInfo(\'"+index+"\')\"></i></div> <span class='error-msg' id='errorOrgs_"+index+"'></span> <label>组织ID：</label>"
					+" <span id='org_id_"+index+"'>${orgId }</span></li><li><label><span class='red'>*</span>发送号码：</label> <input type='text' "
					+"name='smsSendParams["+index+"].recvNumbers' class='width-large' maxlength='119'><span class='error-msg' id='errorNumber_"+index+"'></span><br><span class='mg-l'>相连号码之间用逗号隔开</span></li><li><label><span class='red'>*</span>短信类型：</label>"
					+" <select class='width-select' name='smsSendParams["+index+"].smsType'><option value='0'>请选择</option><option value='1'>会员注册</option>"
					+"<option value='2'>忘记密码</option><option value='3'>邀请短信</option></select>	<span class='error-msg' id='errorSms_"+index+"'></span> <label>优先级：</label>"
					+" <select name='smsSendParams["+index+"].priority' class='width-select'><option value='0'>请选择</option><option value='1'>紧急</option>"
					+"<option value='2'>较高</option>	<option value='3'>普通</option><option value='4'>较低</option><option value='5'>最低</option></select></li>"
					+"<li><input type='hidden' name='smsSendParams["+index+"].contentType' value='1' /><label>发送内容：</label> <div class='relative'>"
			        +"<textarea class='text-top' name='smsSendParams["+index+"].content' cols='87' rows='9' maxlength='300' disabled='disabled'>    尊敬的用户，你收到的是由中科汇康 发出的测试短信。如有打扰，请见谅。</textarea>"
		            +"</div></li></ul></div></div>";
		            
				$("#add_div").before(str);
				$("#list").val(index);
			});
		});
		
		function orgInfo(index){
			var setting = {
					check: {
						enable: true,
						chkStyle: "radio",
						radioType: "all"
					},
					data : {
						simpleData : {
							enable : true
						}
					},
					view : {
						dblClickExpand: false,
						selectedMulti: false,
						showIcon: false
					},
					callback : {
							onCheck : function(e, treeId, treeNode){
								$("#orgId_"+index).val(treeNode.id);
								$("#orgs_"+index).val(treeNode.name);
								$("#org_id_"+index).text(treeNode.id);
							},
							beforeClick: checkedBox,
							onExpand: zTreeOnExpand
						}
					
				};
			
			$(obj1).each(function(i, e) {
				e.nocheck=e.endTag==='Y'?false:true;
			});
			$.fn.zTree.init($("#treeDemo"), setting, obj1);
			key = $("#key");
			key.on("keypress", searchNode);
			
			var cityObj = $("#orgs_"+index);
			var cityOffset = $("#orgs_"+index).offset();
			
			$("#menuContent").css({
				left : cityOffset.left + "px",
				top : cityOffset.top + cityObj.outerHeight() + "px"
			}).slideDown("fast");

			$("body").bind("mousedown", function(event){
				if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(
						event.target).parents("#menuContent").length > 0)) {
					$("#menuContent").fadeOut("fast");
					$("body").unbind("mousedown", function(event){
						if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(
								event.target).parents("#menuContent").length > 0)) {
							hideMenu();
						}
					});
				}
			});
		}
		
		function sendSms(){
			var list = $("#list").val();
			var staduSMS = true;
			for(var u = 0; u <= list; u++){
				if($("#orgs_" + u).val() == ''){
					$("#errorOrgs_" + u).html("必填!");
					staduSMS = false;
					return;
				}else {
					$("#errorOrgs_" + u).html("");
				}
				
				if($.trim($("input[name='smsSendParams["+ u +"].recvNumbers']").val()) == ''){
					$("#errorNumber_" + u).html("必填!");
					staduSMS = false;
					return;
				}else {
					$("#errorNumber_" + u).html("");
				}
				
				if($("select[name='smsSendParams["+ u +"].smsType'] option:selected").val() == 0){
					$("#errorSms_" + u).html("必填!");
					staduSMS = false;
					return;
				}else {
					$("#errorSms_" + u).html("");
				}
				
				if($("select[name='smsSendParams["+ u +"].priority'] option:selected").val() == 0){
					$("#errorPriority_" + u).html("必填!");
					staduSMS = false;
					return;
				}else {
					$("#errorSms_" + u).html("");
				}
			}
			
			if(staduSMS){
				$("#form1").submit();
			}
		}
	</script>
	
	<style>
		.search-term {
			padding: 10px;
		}
		
		.add-bottom {
			border-bottom: 1px solid #000; 
		}
		
		.mg-right {
			margin-right: 50px;
		}
		
		.circle {
			height: 25px;
			width: 25px;
		    border-radius: 3px;
		    -moz-border-radius: 3px;
		    -webkit-border-radius: 3px;
		    border: none;
		    outline: none;
		    background: url(../../img/u100.png) no-repeat center center;
		    float: right;
		}
		
		.btn-box {
			padding: 10px 20px 0 0;
		}
		
		.text-top {
	        vertical-align: text-top;
	    } 
	    
	    .send-detail li {
	    	margin: 20px 0;
	    	font-size: 14px;
	    }
	    
	    .send-detail label {
	    	width: 156px;
	    	text-align: right;
	    }
	    
	    .width-nomal {
	    	width: 200px;
	    }
	    
	    .width-select {
	    	width: 208px;
	    }
	    
	    .width-large {
	    	width: 585px;
	    }
	    
	    .relative {
	    	display: inline-block;
	    	position: relative;
	    }
	    
	    .word-limit {
	    	position: absolute;
	    	bottom: 8px;
	    	right: 10px;
	    }
	    
	    .member-search {
	    	right: 2px;
    		top: 1px;
	    }
	    
	    .pop-ztree {
		    width: 200px;
		    height: 250px;
	    }
	    
	    #menuContent .input-search {
    		width: 190px;
   		}
   		
   		.icon-search {
   			right: 0.5em;
		}
		
		.error-msg {
			color: red;
			width: 50px;
			display: inline-block;
		}
		
		.mg-l {
			display: inline-block;
			margin-left: 165px;
			color: #a1a1a1;
		}
	</style>
</head>
<body>
<input type="hidden" id="list" value="0">
<form action="<%=path %>/sms/smsSend" method="post" id="form1">
<div class="content">
	<div class="content-title">
   		短信发送记录 --- 发送测试
	</div>
    <div class="search-term add-bottom">
    	<div class="send-detail">
			<ul>
				<li>
					<label><span class="red">*</span>组织名称：</label>
					<div class="position-r">
						<input class="info" type="hidden" name="smsSendParams[0].orgId" id="orgId_0" readonly="readonly"/>
						<input type="text" class="width-nomal" id="orgs_0" readonly="readonly">
						<i class="member-search" onclick="orgInfo('0')"></i>
					</div>
					<span class="error-msg" id="errorOrgs_0"></span>
					<label>组织ID：</label>
					<span id="org_id_0">${orgId }</span>
				</li>
				<li>
					<label><span class="red">*</span>发送号码：</label>
					<input type="text" name="smsSendParams[0].recvNumbers" class="width-large" maxlength="119">
					<span class="error-msg" id="errorNumber_0"></span>
					<br>
					<span class="mg-l">相连号码之间用逗号隔开</span>
				</li>
				<li>
					<label><span class="red">*</span>短信类型：</label>
					<select class="width-select" name="smsSendParams[0].smsType">
						<option value="5">测试短信</option>
<!-- 						<option value="1">会员注册</option>
						<option value="2">忘记密码</option>
						<option value="3">邀请短信</option> -->
					</select>
					<span class="error-msg" id="errorSms_0"></span>
					<label>优先级：</label>
					<select name="smsSendParams[0].priority" class="width-select">
						<option value="0">请选择</option>
						<option value="1">紧急</option>
						<option value="2">较高</option>
						<option value="3">普通</option>
						<option value="4">较低</option>
						<option value="5">最低</option>
					</select>
					<span class="error-msg" id="errorPriority_0"></span>
				</li>
				<li>
					<input type="hidden" name="smsSendParams[0].contentType" value="1" />
					<label>发送内容：</label>
					<div class="relative">
	                	<textarea class="text-top" name="smsSendParams[0].content" cols="87" rows="9" maxlength="300" disabled="disabled">    尊敬的用户，你收到的是由中科汇康 发出的测试短信。如有打扰，请见谅。</textarea>
	                	<!-- <span class="word-limit">300字</span> -->
                	</div>
				</li>
			</ul>
		</div>
    </div>
    <div class="btn-box clearfix" id="add_div">
    	<button type="button" class="circle" id="add_sms"></button>
    </div>
	<div class="page-box align-center">
        <button type="button" class="btn-inquiry" onclick="sendSms();">保存</button>
      	<button type="button" class="btn-cancel" type="button" onclick="javascript:location.href='<%=path %>/sms/getSmsRecord';">返回</button>
	</div>
</div>
</form>
<div id="menuContent" class="menuContent" style="display: none; position: absolute; background-color: #fff;">
	<div class="left-title">
		<input type="text" id="key" class="input-search" >
		<i class="icon-search" onclick="searchNode();"></i>
	</div>
	<ul id="treeDemo" class="pop-ztree ztree"></ul>
</div>
</body>
</html>
