<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
    <title>单份问卷列表</title>
    <link rel="stylesheet" href="<%=path %>/css/general.css">
    <link rel="stylesheet" href="<%=path %>/plugins/zTree_v3/css/zTreeStyle/zTreeStyle.css">
	<link rel="stylesheet" href="<%=path %>/css/tree.css">
	<link rel="stylesheet" href="<%=path %>/css/questManage.css">
	
    <script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.artDialog.js"></script>
	<script type="text/javascript" src="<%=path %>/js/plugins/iframeTools.js"></script>
	<script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.core-3.5.min.js"></script>
	<script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.excheck-3.5.js"></script>
	<script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.exhide-3.5.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script type="text/javascript" src="<%=path %>/js/tree.js"></script>

	<script>
		function EnterPress(e){ //传入 event
			var e = e || window.event;
			if(e.keyCode == 13){
				document.getElementById("searchForm").submit();
			} 
		}
		
		// 删除
		function del(node) {
			layer.confirm('确认删除吗？', {shade: 0, skin: "skin1",offset: "100px;"}, function(index){
				$.ajax({
					type : "GET",
					url : $(node).data("href"),
					success : function(msg) {
						layer.msg(msg.content,{offset: "100px;", time: 1000},function(){
							if(msg.status) {
								window.location.href = window.location.href;
							}
						});
					}
				});
				layer.close(index);
			})
		}
		
		/* function del(node) {
			art.dialog({
				id: 'delete-dialog',
				title:'提示信息',
				skin: 'delete-dialog',
			    content: '确认需删除此问卷?',
			    ok: function () {
					var reponse = $.ajax({
					  url: $(node).data("href"),
					  async: false
					 }).responseJSON;
					if(typeof(reponse)==='object'){
						alert(reponse.content);
						if(reponse.status){
							search();
						}
					}else{
						alert("登录信息过期，请重新登录");
						window.top.location.href="..";
					}
			        return true;
			    },
			    drag:true,
			    cancelVal: '取消',
			    cancel: true //为true等价于function(){}
			});
		} */
		
		function selectDisabled(){
			$("#orgs").val("");
			if($('select[name="useRange"] option:selected').val() == "1"){
				$("#orgs").prop('disabled', true);
			}else {
				$("#orgs").prop('disabled', false);
			}
		}
		function setOpts(orgId){
			if(orgId){
				$.ajax({
					type : "GET",
					url : '../queryOption?funId=3&orgId='+orgId,
					async: false,
					success : function(response) {
						var options = "<option value=''>全部</option>";
						for(var i = 0; i < response.data.length; i++){
							options += "<option value='" + response.data[i].optId + "'>" + response.data[i].optName + "</option>";
						}
						$("select[name='optId']").html(options);
					}
				});
			}
		}
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
							setOpts(treeNode.id);
							$("input[name='orgId']").val(treeNode.id);
							$("input[name='orgName']").val(treeNode.name);
						},
						beforeClick: checkedBox,
						onExpand: zTreeOnExpand
					}
				};
			$.ajax({
				type : "GET",
				url : '../../org/listAllOrg?pId=0',
				async: false,
				success : function(rsp) {
					var obj = rsp;
					$(obj).each(function(i, e) {
						e.nocheck=e.endTag==='Y'?false:true;
					});
					$.fn.zTree.init($("#treeDemo"), setting, obj);
				}
			});
			$("#orgs").click(function(){
				$("#orgs").val("");
				$.ajax({
					type : "GET",
					url : '../../org/listAllOrg?pId=0',
					async: false,
					success : function(rsp) {
						var obj = rsp;
						$(obj).each(function(i, e) {
							e.nocheck=e.endTag==='Y'?false:true;
						});
						$.fn.zTree.init($("#treeDemo"), setting, obj);
					}
				});
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
				   //禁用分页回车键
				  $("#toPage").keydown(function(e){
						if(e.keyCode==13) {
						return false;
						}
				  }); 
			$(".toUpdate").click(function(){
				if(this.disabled)
					return;
				this.disabled = true;
				var $this = this;
				if($this.getAttribute("qStatus") === "D"){
					window.location.href="toEdit?id="+$this.getAttribute("qustId");
				}else{
					var flag = true;
					$.ajax({
					     type: 'POST',
					     url: 'hasDraft',
					     data: {
					    	 name: $this.getAttribute("qustName"),
					    	 orgId: $this.getAttribute("orgId")
					    	 },
					     async : false, //默认为true 异步
					     success: function(msg){
					    	 flag = msg.data;
					     }
					});
					this.disabled = false;
					if(flag){
						alert("已有该问卷的未发布版本，请在相应的草稿里更改");
					}else{
						layer.closeAll();
						layer.confirm("该问卷已发布生效，修改后会产生新版本问卷，<br/>确定需要修改吗?", {
							  skin : 'skin1',
							  shade: 0,
						      btn: ['确认','取消'] //按钮
						  }, function(i){
						    	window.location.href="toEdit?id="+$this.getAttribute("qustId");
						  })
						/* art.dialog({
							id: 'update-dialog',
							title:'提示信息',
							skin: 'delete-dialog',
						    content: '该问卷已发布生效，修改后会产生新版本问卷，<br/>确定需要修改吗?',
						    ok: function () {
						    	window.location.href="toEdit?id="+$this.getAttribute("qustId");
						        return false;
						    },
						    drag:true,
						    cancelVal: '取消',
						    cancel: true //为true等价于function(){}
						}); */
					}
				}
			});
		});
	</script>
</head>
<body>
<div class="content">
	<div class="content-title">
   		单份问卷列表
	</div>
	<form class="vertical-center" action="list" id="searchForm">
		<div class="search-box-wrapper">
			<ul class="search-wrapper clearfix">
				<li>
					<label>应用范围：</label>
					<select name="useRange" class="select-width" onchange="selectDisabled()">
						<option value="">全部</option>
						<option value="1" <c:if test="${pojo.useRange == 1}"> selected="selected"</c:if>>全局</option>
						<option value="2" <c:if test="${pojo.useRange == 2}"> selected="selected"</c:if>>组织内共享</option>
					</select>
				</li>
				<li>
					<label>问卷类别：</label>
					<select name="optId" class="select-width">
						<option value="">全部</option>
						<c:forEach items="${options}" var="oopt">
							<option value="${oopt.optId}" <c:if test="${pojo.optId eq oopt.optId}">selected="selected"</c:if>>${oopt.optName}</option>
						</c:forEach>
					</select>
				</li>
				<li>
					<label>评测方式：</label>
					<select name="ansMode">
						<option value="">全部</option>
						<option value="1" <c:if test="${pojo.ansMode eq 1}">selected="selected"</c:if>>自评</option>
						<option value="2" <c:if test="${pojo.ansMode eq 2}">selected="selected"</c:if>>测评</option>
					</select>
				</li>
				<li>
					<label>状态：</label>
					<select name="qustTag">
						<option value="">全部</option>
						<option value="D" <c:if test="${pojo.qustTag eq 'D'}">selected="selected"</c:if>>草稿</option>
						<option value="T" <c:if test="${pojo.qustTag eq 'T'}">selected="selected"</c:if>>生效</option>
					</select>
				</li>
				<c:if test="${userInfo.roleid eq 6}">
				<li>
		  			<label>组织名称：</label>
					<input type="hidden" name="orgId" value="${pojo.orgId}"/>
					<input class="text-width" type="text" name="orgName" id="orgs" readonly="readonly" value="${pojo.orgName}"/>
				</li>
			  	</c:if>
				<li>
				  	<label>问卷名称：</label>
			  		<input class="text-width" type="text" name="qustname" value="${pojo.qustname}"/>
				</li>
				
				<li>
					<button class="btn-normal" type="button" onclick="javascript: window.location = 'toEdit'">创建问卷</button>
					<button type="button" onclick="search(1)" class="btn-inquiry ico-search">查询</button>
				</li>
			</ul>
		 </div>
		<div class="table-box">
		<c:if test="${page.totalCount == 0}">
			<div class="empty-info border-1-solid">目前还没有问卷信息</div>
		</c:if>
		<c:if test="${page.totalCount > 0}">
			<table class="table-content">
			    <thead class="table-title">
			 		<tr>
				  		<th>问卷名称</th>
				  		<th width="10%">应用范围</th>
				  		<th width="8%">版本</th>
				  		<th width="8%">状态</th>
				  		<th width="8%">创建人</th>
				  		<th width="10%">问卷类别</th>
				  		<th width="8%">评测方式</th>
				  		<th width="10%">创建时间</th>
				  		<!-- <th>审核</th> -->
				  		<%-- <c:if test="${userInfo.roleid ne 6}">
				  		<th width="5%">发放</th>
				  		</c:if> --%>
				  		<th width="15%">操作</th>
			 		</tr>
				</thead>
				<tbody>
					<c:forEach items="${page.result}" var="omfq">
					<tr>
						<td><a style="width:auto;" href="toView?id=${omfq.qustid}"><c:out value="${omfq.qustname }" escapeXml="true"/></a></td>
						<td>${omfq.useRange==1 ? '全局' : '组织内共享'}</td>
						<td>${omfq.qustVer }</td>
						<td>
			 			<c:choose>
			 				<c:when test="${omfq.qustTag eq 'D'}">草稿</c:when>
			 				<c:when test="${omfq.qustTag eq 'T'}">生效</c:when>
			 				<c:otherwise>未知</c:otherwise>
			 			</c:choose>
						</td>
						<td>${omfq.createName }</td>
						<td>${omfq.optName}</td>
						<td>
						<c:if test="${omfq.ansMode == 1}">自评</c:if>
						<c:if test="${omfq.ansMode == 2}">测评</c:if>
						</td>
						<td><fmt:formatDate value="${omfq.createDate }" pattern="yyyy-MM-dd"/></td>
						<%-- <c:if test="${userInfo.roleid ne 6}">
						<td id="table_content_title_td">
				 			<c:if test="${omfq.qustTag=='D'}">
								<span class="muted">发放</span>
							</c:if>
							<c:if test="${omfq.qustTag=='T'}">
								<a href="../members?qustid=${omfq.qustid}">
				 					发放
				 				</a>
							</c:if>
						</td>
						</c:if> --%>
						<td id="table_content_title_td" class="table-content-td">
							<c:if test="${userInfo.roleid ne 6}">
				  				<c:if test="${omfq.qustTag=='D'}">
									<span class="muted">发放</span>
								</c:if>
								<c:if test="${omfq.qustTag=='T'}">
									<a href="../members?qustid=${omfq.qustid}">
					 					发放
					 				</a>
								</c:if>
				  			</c:if>
				  			<c:choose>
								<c:when test="${userInfo.roleid == 6 || (omfq.useRange == 3 && userInfo.dept_id eq omfq.orgId)}">
									<a class="mar-left" onclick="del(this)" data-href="remove?ids=${omfq.qustid }">删除</a>
									<a href="javascript:;" class="toUpdate mar-left" qustName="${omfq.qustname}" qustId="${omfq.qustid}" qStatus="${omfq.qustTag}" orgId="${omfq.orgId}">修改</a>
								</c:when>
								<c:otherwise>
									<span class="mar-left">删除</span>
									<span class="mar-left">修改</span>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			</c:if>
			<div class="page-box">
				<jsp:include page="/public/pageFoot.jsp"/>
			</div>
		</div>
	</form>
</div>

<%-- 选择组织 start --%>
<div id="menuContent" class="menuContent" style="display:none; position: absolute;background-color: #fff;">
	<ul id="treeDemo" class="pop-ztree ztree"></ul>
</div>
<%-- 选择组织 end --%>
</body>
</html>
