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
	<title>短信发送记录</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/plugins/zTree_v3/css/zTreeStyle/zTreeStyle.css">
	<link rel="stylesheet" href="<%=path %>/plugins/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="<%=path %>/css/tree.css">

	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/plugins/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.core-3.5.min.js"></script>
	<script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.excheck-3.5.js"></script>
	<script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.exhide-3.5.js"></script>
	<script type="text/javascript" src="<%=path %>/js/tree.js"></script>
	<script type="text/javascript">
		$(function(){
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
							$("#orgId").val(treeNode.id);
							$("#orgs").val(treeNode.name);
						},
						beforeClick: checkedBox,
						onExpand: zTreeOnExpand
					}
				};
			
			$.ajax({
				type : "GET",
				url : '<%=path %>/org/listAllOrg?pId=0',
				async: false,
				success : function(obj) {
	// 				var obj = rsp.data;
					$(obj).each(function(i, e) {
						e.nocheck=e.endTag==='Y'?false:true;
					});
					$.fn.zTree.init($("#treeDemo"), setting, obj);
					key = $("#key");
					key.on("keypress", searchNode);
				}
			});
			
			$("#showOrgsIcon").click(function(){
				var cityObj = $("#orgs");
				var cityOffset = $("#orgs").offset();
				
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
			});
			
		});
		
		function sendTest(){
			location.href="<%=path %>/msgCenter/sms/sendTest.jsp";
		}
		function statistic(){
			<%-- location.href="<%=path %>/sms/getSmsStatistic?smsParamsJson="+JSON.stringify(${smsParamsJson}); --%>
			$("#smsListForm").attr("action", "<%=path %>/sms/getSmsStatistic");
			$("#smsListForm").submit();
		}
	</script>
	<style type="text/css">
		.Wdate {
			width: 140px;
		}
	</style>
</head>
<body>
<div class="content">
	<div class="content-title">
   		短信发送记录
	</div>
    <form action="" method="POST" id="smsListForm">
		<div class="search-box-wrapper">
			<ul class="search-wrapper">
				<li>
					<label>组织名称：</label>
					<span>
			        	<input class="info" type="hidden" name="orgId" id="orgId" value="${orgId }" readonly="readonly"/>
			        	<input type="text" name="orgName" class="input-height margin-lf" id="orgs" value="${orgName }" readonly="readonly">
			        	<i class="org-search" id="showOrgsIcon"></i>
	        		</span>              
				</li>
				<li>
					<label>发送时间：</label>
					<input name="startTime" class="Wdate" id="startTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" 
						readonly="readonly" value="<fmt:formatDate value='${smsParams.startTime }' pattern='yyyy-MM-dd HH:mm:ss'/>"> 
					<span class="mar-left">至</span> 
					<input name="endTime" class="Wdate mar-left" id="endTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" 
						readonly="readonly" value="<fmt:formatDate value='${smsParams.endTime }' pattern='yyyy-MM-dd HH:mm:ss'/>">
				</li>
				<li>
					<label>短信类型：</label>
	                <select name="smsType">
						<option value="0" <c:if test="${smsParams.smsType==0}"> selected="selected"</c:if>>全部</option>
						<option value="1" <c:if test="${smsParams.smsType==1}"> selected="selected"</c:if>>会员注册</option>
						<option value="2" <c:if test="${smsParams.smsType==2}"> selected="selected"</c:if>>忘记密码</option>
						<option value="3" <c:if test="${smsParams.smsType==3}"> selected="selected"</c:if>>邀请短信</option>
						<option value="4" <c:if test="${smsParams.smsType==4}"> selected="selected"</c:if>>修改手机号码</option>
						<option value="5" <c:if test="${smsParams.smsType==5}"> selected="selected"</c:if>>测试短信</option>
					</select>
				</li>
				<li>
					<label>手机号码：</label>
	                <input type="text" name="recvNumber" value="${smsParams.recvNumber }">
				</li>
				<li>
					<label>发送状态：</label>
	                <select name="sendStatus">
						<option value="0">全部</option>
						<option value="1" <c:if test="${smsParams.sendStatus==1}"> selected="selected"</c:if>>待发送</option>
						<option value="2" <c:if test="${smsParams.sendStatus==2}"> selected="selected"</c:if>>已发送</option>
						<option value="3" <c:if test="${smsParams.sendStatus==3}"> selected="selected"</c:if>>发送成功</option>
						<option value="4" <c:if test="${smsParams.sendStatus==4}"> selected="selected"</c:if>>发送失败</option>
					</select>
				</li>
				<li>
					<button type="button" class="btn-inquiry ico-search" onclick="search(1);">查询</button>
					<button type="button" class="btn-inquiry" onclick="statistic();">统计</button>
					<button type="button" class="btn-inquiry" onclick="sendTest();">发送测试</button>
				</li>
			</ul>
		</div>
		<div id="menuContent" class="menuContent" style="display: none; position: absolute; background-color: #fff;">
			<div class="left-title">
				<input type="text" id="key" class="input-search" >
				<i class="icon-search" onclick="searchNode();"></i>
			</div>
			<ul id="treeDemo" class="pop-ztree ztree"></ul>
		</div>
		<c:choose>
		<c:when test="${page.totalCount eq 0}">
			<div class="empty-info">未查询到符合条件的短信记录</div>
		</c:when>
		<c:otherwise>
			<div class="table-box">
				<table class="table-content">
					<thead class="table-title">
						<tr>
							<th>组织名称</th>
							<th>短信类型</th>
							<th>接收号码</th>
							<th>发送方式</th>
							<th>发送内容</th>
							<th>发送时间</th>
							<th>优先级别</th>
							<th>发送状态</th>
							<th>MessageID</th>
							<th>接收时间</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${page.result}" var="item">
							<tr>
								<td>${item.orgName }</td>
								<td>${item.smsTypeName }</td>
								<td>${item.recvNumber}</td>
								<td>${item.contentTypeName}</td>
								<td>${item.content }</td>
								<td>${item.sendTime}</td>
								<td>${item.priorityName}</td>
								<td>${item.sendStatusName}</td>
								<td>${item.SSendID}</td>
								<td>${item.recvTime}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:otherwise>
		</c:choose>
		<div class="page-box">
			<jsp:include page="/public/pageFoot.jsp"></jsp:include>
		</div>
	</form>
</div>
</body>
</html>
