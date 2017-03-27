<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE HTML>
<html>
<head>
   	<title>编辑会员转移</title>
   	<meta charset="utf-8">
   	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<style type="text/css">
		.main-box ul li {
			margin: 25px 8px;
		}
		
		.fix-label {
			text-align: right;
			font-size: 14px;
			width: 15%;
		}
		
		.mg-left {
			margin-left: 15.3%;
		}
		
		.btn-cancel {
			margin-left: 30px;
		}
		
		.org-width {
			width: 350px;
		}
		
		.group-width {
			width: 600px;
		}
		
		.dis-span {
			display: inline-block;
			vertical-align: top;
    		width: 60%;
    		word-wrap: break-word;
    		word-break: break-all;
		}
	</style>
	<script>
		function getRootPath(){
			return top.getRoot();
		}
	
		var index = layer.getFrameIndex(window.name); //获取窗口索引
		var hasDoc = true;
		var vForm;
		//选择会员
		function chooseIframe(title, url){
			layer.closeAll();
			layer.open({
		   	    type: 2,
		   		skin : 'skin1',
		   	    title: title,
		   	    shadeClose: false,
		   	    shade: 0,
		   	    area: ['820px', '450px'],
		   	    content: url, //iframe的url
		   	}); 
		}

		function chooseDoctor() {
			if($("#memberID").val() == "") {
				alert("请先选择会员");
				return;
			}
			if(hasDoc) {
				chooseIframe("选择医生", "<%=path %>/member/memberDoctors?memberId=" + $("#memberID").val());
			} else {
				alert("所申请会员没有管理医生");
				return;
			}
		}
		
		function setConfirmDoc(docId, docName) {
			$("#outDrID").val(docId);
			$("#outDrName").val(docName);
			layer.closeAll();
		}
		
		function setMemberInfo(obj) {
			if(!obj) {
				alert("请选择会员");
				return;
			}
			if($("#memberGUID").val() == obj.memberGUID) {
				layer.closeAll();
				return;
			}
			$.ajax({
				  url: "<%=path%>/member/checkUCMember",
				  async: false,
				  data: {"memberGUID" : obj.memberGUID, "serverID" : obj.serverId},
				  dataType:"json",
				  success:function(data){
					  if(data.status) {
						  if($("#memberGUID").val() != obj.memberGUID) {
							  $("#memberName").val(obj.memberName);
							  $("#gender").val(obj.gender);
							  $("#tel").val(obj.tel);
							  $("#memberGUID").val(obj.memberGUID);
							  $("#memberID").val(data.data.memberID);
							  $("#orgName").val(data.data.orgName);
							  $("#outOrgID").val(data.data.orgId);
							  hasDoc = data.data.hasDoc;
							  $("#outDrID").val("");
							  if(hasDoc) {
								  $("#outDrName").val("");
							  } else {
								  $("#outDrName").val("无");
							  }
						  }
						  layer.closeAll();
					  } else {
						  if(data.content == "Not Included") {
							  alert("此会员不在本平台，不可转移，请联系" + obj.serverName + "系统管理员");
						  } else {
							  alert(data.content);
						  }
					  }
				  },
				  error : function(data) {
					  alert("服务器内部错误");
				  }
			});
		}
		//选择会员分组
		function chooseGroup() {
			layer.closeAll();
			layer.open({
				type : 2,
				skin : 'skin1',
				title : '选择会员分组',
				shadeClose : true,
				shade : 0,
				area : [ '300px', '380px' ],
				content : "<%=path %>/member/chooseGroup.jsp?groupIds=" + $("#inMemGrpidList").val()
			});
		}
		
		function setGroup(groups) {
			if(!groups) {
				alert("请选择会员分组");
				return;
			}
			var groupIds = [];
			var groupName = '';
			var groupNames = '';
			for(var p=0; p<groups.length; p++) {
				groupIds.push(groups[p].id);
				var u = groups[p].getPath();
				for (var j=0; j<u.length; j++) {
					groupName = u[j].name;
					groupNames += groupName + "-->";
				}
				if (groupNames.length > 0 ) groupNames = groupNames.substring(0, groupNames.length-2);
				groupNames += ",";
			}
			if (groupNames.length > 0 ) groupNames = groupNames.substring(0, groupNames.length-2);
			$("#inMemGrpidList").val(groupIds.toString());
			$("#groupNames").val(groupNames.toString());
			layer.closeAll();
		}
		
		function submitForm() {
			if(vForm.form()){
				$.ajax({
	                cache: true,
	                type: "POST",
	                url: $("#formId").attr("action"),
	                data:$('#formId').serialize(),// 你的formid
	                dataType: 'json',
	                async: false,
	                error: function(request) {
	                    alert("Connection error");
	                },
	                success: function(data) {
	                    if(data.status) {
	                    	window.location.href="<%=path %>/member/momvementsList?flag=inner";
	                    } else {
	                    	alert(data.content);
	                    }
	                }
	            });
			}
		}
		
		$(function(){
			jQuery.validator.addMethod("isBlank", function(value, element) {
				return $.trim(value) != ''
				}, "必填!");
			
			// 表单验证
			vForm = $("#formId").validate({
				rules : {
					'memberName' : {
						isBlank: true,
					},
					'orgName' : {
						isBlank: true,
					},
					'outDrName' : {
						isBlank: true,
					},
					'groupNames' : {
						isBlank: true,
					}
				},
				messages : {
					'memberName' : {
						isBlank : "必填!",
					},
					'orgName' : {
						isBlank : "必填!",
					},
					'outDrName' : {
						isBlank : "必填!",
					},
					'groupNames' : {
						isBlank : "必填!",
					}
				}
			});
		});
		
		function confirmBack(view) {
			window.location.href="<%=path%>/member/momvementsList?flag=inner";
// 			if(view == '') {
// 				if(confirm("信息未保存，是否返回")) {
<%-- 					window.location.href="<%=path%>/member/momvementsList?flag=inner"; --%>
// 				}
// 			} else {
<%-- 				window.location.href="<%=path%>/member/momvementsList?flag=inner"; --%>
// 			}
		}
	</script>
</head>
<body>
	<div class="content">
		<div class="content-title">转入申请 ---
			<c:choose>
			<c:when test="${movment.MMovementID gt 0 }">
			<c:choose>
			<c:when test="${empty view }">修改</c:when><c:otherwise>查看</c:otherwise>
			</c:choose>
			</c:when>
			<c:otherwise>新增</c:otherwise></c:choose>
		</div>
		<input type="hidden" value="${movment.member.memberGUID}" id="memberGUID"/>
		<input type="hidden" value="" id="memberGrpIds"/>
		<form action="<%=path %>/member/addMovement" id="formId">
		<input type="hidden" value="${movment.MMovementID}" name="MMovementID"/>
			<div class="main-box">
				<ul>
					<li>
						<label class="fix-label"><c:if test="${empty view }"><span class="red">*</span></c:if>会员姓名：</label>
						<div class="position-r">
							<input class="info info-search" type="text" name ="memberName" value="${movment.member.memname}" readonly id="memberName"/>
							<input type="hidden" name="memberID" value="${movment.memberID }" id="memberID"/>
							<c:if test="${empty movment.MMovementID or movment.MMovementID eq 0}">
		                 	<i class="member-search2" onclick="chooseIframe('选择会员','<%=path %>/member/ucMembers.jsp');"></i>
		                 	</c:if>
	                 	</div>
	                 	<label id="memberName-error" class="error" for="memberName"></label>
					</li>
					<li>
						<label class="fix-label">性别：</label>
						<c:if test="${movment.member.gender eq 1}"><input type="text" value="男" readonly id="gender"/></c:if>
						<c:if test="${movment.member.gender eq 2}"><input type="text" value="女" readonly id="gender"/></c:if>
						<c:if test="${empty movment.member.gender}"><input type="text" value="" readonly id="gender"/></c:if>
						<c:if test="${movment.member.gender eq 3}"><input type="text" value="未知" readonly id="gender"/></c:if>
					</li>
					<li>
						<label class="fix-label">手机号码：</label>
						<input type="text" value="${movment.member.tel }" readonly id="tel"/>
					</li>
					<li>
						<label class="fix-label">转出组织：</label>
						<input class="org-width" type="text" name="orgName" value="${movment.outOrgName }" readonly id="orgName"/>
						<input type="hidden" name="outOrgID" value="${movment.outOrgID }" id="outOrgID"/>
					</li>
					<li>
						<label class="fix-label"><c:if test="${empty view }"><span class="red">*</span></c:if>转出确认医生：</label>
						<div class="position-r">
							<input type="hidden" value="${movment.outDrID }" name="outDrID" id="outDrID"/>
							<input class="" type="text" name ="outDrName" value="${movment.outDrName }" readonly id="outDrName"/>
							<c:if test="${empty view }">
		                 	<i class="member-search2" onclick="chooseDoctor()"></i>
		                 	</c:if>
	                 	</div>
	                 	<label id="outDrName-error" class="error" for="outDrName"></label>
					</li>
					<li>
						<label class="fix-label"><c:if test="${empty view }"><span class="red">*</span></c:if>申请转入分组：</label>
						<div class="position-r">
							<input type="hidden" value="${movment.inMemGrpidList}" name="inMemGrpidList" id="inMemGrpidList"/>
							<input class="group-width" type="text" name ="groupNames" value="${movment.groupNames}" id="groupNames" readonly />
							<c:if test="${empty view}">
		                 	<i class="member-search2" onclick="chooseGroup();"></i>
		                 	</c:if>
	                 	</div>
	                 	<label id="groupNames-error" class="error" for="groupNames"></label>
					</li>
					<c:if test="${movment.moveStatus != null and movment.moveStatus ne 1}">
					<li>
						<label class="fix-label">申请时间：</label>
						<span><fmt:formatDate value="${movment.createTime }" pattern="yyyy-MM-dd"/></span>
					</li>
					<li>
						<label class="fix-label">确认时间：</label>
						<span><fmt:formatDate value="${movment.confirmTime }" pattern="yyyy-MM-dd"/></span>
					</li>
					<li>
						<label class="fix-label">拒绝原因：</label>
						<span class="dis-span">${movment.refuseReason }</span>
					</li>
					<li>
						<label class="fix-label">状态：</label>
						<span><c:forEach items="${status}" var="st"><c:if test="${st.status eq movment.moveStatus}">${st.desc }</c:if></c:forEach></span>
					</li>
					</c:if>
				</ul>
			</div>
			<div class="mg-left">
			    <c:if test="${empty view }">
				<input type="button" id="" onclick="submitForm()" class="btn-inquiry" value="保存">
				</c:if>
	   			<input type="button" class="btn-cancel" value="返回" onclick="confirmBack('${view}')">
			</div>
		</form>
	</div>	  
</body>
</html>
