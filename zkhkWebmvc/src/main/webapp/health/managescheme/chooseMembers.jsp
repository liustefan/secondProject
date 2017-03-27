<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>选择会员(个人管理方案)</title>
	<link rel="stylesheet" href="<%=path %>/plugins/zTree_v3/css/zTreeStyle/zTreeStyle.css">
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/css/tree.css">

	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.core-3.5.min.js"></script>
	<script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.excheck-3.5.js"></script>
	<script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.exhide-3.5.js"></script>
	<script type="text/javascript" src="<%=path %>/js/tree.js"></script>
	<script type="text/javascript" src="<%=path %>/js/members.js"></script>
	<style type="text/css">
		.content {
			margin-top: 8px;
		}
		
		select {
			width: 183px;
			width: 162px\0;
		}
		
		#label_name {
			width: 443px;
			width: 402px\0;
		}
		
		.pop-ztree {
		    width: 250px !important;
		    height: 240px !important;
		    padding: 12px !important;
		    padding-top: 0 !important;
		    margin-bottom: 5px !important;
	    }
	    
	    #menuContent .input-search {
	    	width: 240px !important;
		    margin: 5px 8px 0 8px !important;
		    
	    }
	</style>
	<script type="text/javascript">
		/* $(function(){
			$("#showGroupIcon").click(function(){
	    		if($("#menuContent").css("display") =="none") {
	    			getData();
	    			showMenu();
	    		}
	    	});
		}); */
		
		var index = layer.getFrameIndex(window.name); //获取窗口索引
		
		function openMemTag() {
			layer.closeAll();
			layer.open({
		   	    type: 2,
		   		skin : 'skin1',
		   	    title: '会员标签',
		   	    shadeClose: false,
		   	    shade: 0,
		   	    area: ['400px', '350px'],
		   	 	content: '<%=path %>/label/listLabelItemsByDoc?flag=query&labelIds='+ $("#omem_label").val()
		   	}); 
		}
		
		function confirm(){
			if($("tbody").find("tr").length > 0)
				parent.chooseMemberCallback(null, $("form").serialize());
		}
		
		function setLabelName(labelId, labelName){
			$("#omem_label").val(labelId);
			$("#label_name").val(labelName);
		}
		
		function chooseMemberCallback(memberId){
			layer.closeAll();
			if('${map.iMSDesignID}')
				parent.chooseMemberCallback(memberId);
			else
				window.open("toEditPerson?memberId="+memberId, '_parent');
		}
		
		//选择会员分组
		function showGroups(){
			layer.closeAll();
			getData();
			$("#key").val("");
			layer.open({
		   	    type: 1,
		   		skin : 'skin1',
		   	    title: '会员分组',
		   	    shadeClose: false,
		   	    shade: 0,
		   	    area: ['275px', '380px'],
		   	 	content: $("#menuContent"), //iframe的url
		   	}); 
		}
	</script>
</head>
<body>
<div class="content">
    <form action="listMember" method="POST" id="">
    	<input type="hidden" name="iMSDesignID" value="${map.iMSDesignID}">
    	<input type="hidden" name="iDocId" value="${map.iDocId}">
    	<input type="hidden" name="massEffectProcess" value="${pojo.massEffectProcess}"> 
		<div class="search-box-wrapper">
			<ul class="search-wrapper">
				<li>
					<label>会员姓名：</label>
	                <input type="text" name="vMemName" value="${map.vMemName}" maxlength="20">
				</li>
				<li>
					<label>手机号码：</label>
	                <input type="text" name="vTel" value="${map.vTel}" maxlength="11">
				</li>
				<li>
					<label>身份证号码：</label>
	                <input type="text" name="vIdCard" value="${map.vIdCard}" maxlength="18">
				</li>
				<li>
					<span class="label">会员分组：</span>
					<input class="info" type="hidden" name="iMemGrpid" value="${map.iMemGrpid}" id="memberGroupId" readonly />
                 	<div class="position-r">
						<input class="info info-search" type="text" name ="memberGroupName" value="${map.memberGroupName}" id="memberGroupName" readonly/>
						<i class="member-search" id="showGroupIcon" onclick="showGroups();"></i>
					</div>	              
				</li>
				<li>
					<label>会员类型：</label>
	                <select name="iMemId">
						<option value="">请选择</option>
						<c:forEach items="${typeList}" var="type">
	                		<option value="${type.memid}" <c:if test="${map.iMemId eq type.memid}">selected="selected"</c:if>>${type.memname}</option>
	                	</c:forEach>
					</select>
				</li>
				<li>
					<label>会员疾病史：</label>
	                <select name="idisease_id">
						<option value="">请选择</option>
	                	<c:forEach items="${diseases}" var="disease">
	                		<option value="${disease.disease_id}" <c:if test="${map.idisease_id eq disease.disease_id}">selected="selected"</c:if>>${disease.disease_name}</option>
	                	</c:forEach>
					</select>
				</li>
				<li>
					<label>会员标签：</label>
	                <div class="position-r">
	                	<input class="info" type="hidden" id="omem_label" name="vLItemID_list" value="${map.vLItemID_list }" />
		                <input type="text" id="label_name" name="vLItemID_listName" value="${map.vLItemID_listName }" readonly>
		                <i class="member-search" onclick="openMemTag();"></i>
                 	</div>
				</li>
				<li>
					<button type="button" class="btn-inquiry ico-search" onclick="search(1)">查询</button>
				</li>
			</ul>
		</div>
		<c:if test="${page.totalCount == 0}">
			<div class="align-center"> 
				<span class="empty-info">目前还没有相关会员信息</span>
			</div>
		</c:if>
		<div class="table-box">
			<c:if test="${page.totalCount > 0}">
				<table class="table-content">
					<thead class="table-title">
						<tr>
							<th width="8%">会员姓名</th>
							<th width="5%">性别</th>
							<th width="12%">手机号码</th>
							<th width="10%">会员类型</th>
							<th>所属分组</th>
							<th width="18%">会员疾病史</th>
							<th width="15%">会员标签</th>
							<th width="8%">选择</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${page.result}" var="item">
						<tr>
							<td>${item.MemName}</td>
							<td>${item.Gender eq 1 ? '男' : item.Gender eq 2 ? '女' : '未知'}</td>
							<td>${item.Tel }</td>
							<td>${item.MemberTypeName}</td>
							<td>${item.MemGrpName_List }</td>
							<td>${item.DiseaseName_List}</td>
							<td>${item.ItemName_List}</td>
							<td>
								<a href="javascript:void(0);" onclick="chooseMemberCallback(${item.MemberID})">选择</a>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
		<div class="page-box">
			<jsp:include page="/public/pageFoot.jsp"></jsp:include>
		</div>
		<c:if test="${not empty map.iMSDesignID}">
		<div class="page-box align-center">
			<button type="button" id="ipt_submit" class="btn-inquiry" onclick="confirm();">确定</button>
			<button type="button" id="ipt_reset" class="btn-cancel" onclick="parent.closeAllLayer();">取消</button>
		</div>
		</c:if>
	</form>
	<!-- 会员分组 -->
	<div id="menuContent" class="menuContent" style="display:none;">
		<div class="left-title">
			<input type="text" id="key" class="input-search" >
			<i class="icon-search" onclick="searchNode();"></i>
		</div>
		<ul id="treeDemo" class="pop-ztree ztree"></ul>
		<div class="page-box align-center">
	        <button type="button" onclick="layer.closeAll();" class="btn-inquiry">确定</button>
	        <button type="button" onclick="cancelSeclectGroup();" class="btn-cancel">取消</button>
        </div>
	</div>
</div>
</body>
</html>
