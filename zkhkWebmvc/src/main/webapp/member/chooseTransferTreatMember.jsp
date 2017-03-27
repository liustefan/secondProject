<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>选择会员(转诊)</title>
	<link rel="stylesheet" href="<%=path %>/js/jquery-ui/themes/overcast/jquery-ui.min.css">
	<link rel="stylesheet" href="<%=path %>/plugins/zTree_v3/css/zTreeStyle/zTreeStyle.css">
	<link rel="stylesheet" href="<%=path %>/plugins/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/css/tree.css">

	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-ui/jquery-ui.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.core-3.5.min.js"></script>
	<script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.excheck-3.5.js"></script>
	<script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.exhide-3.5.js"></script>
	<script type="text/javascript" src="<%=path %>/js/tree.js"></script>
	<script type="text/javascript" src="<%=path %>/js/members.js"></script>
	<style type="text/css">
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

		 function choose(memberid){
			$.ajax({
				type: "POST",
				url: "<%=path %>/transferTreatment/checkMember/",
				data: "memberid=" + memberid,
				async: false,
				success : function(data) {
					if(data.status == false){
						layer.alert('此会员当前已开转诊单!',{skin : 'skin1',shade : 0});
					}else{
						parent.location.href="<%=path %>/transferTreatment/jumpTransferTreatPage/"+memberid+"?flag=add";
					}
				}
			});
		} 
		
		function setLabelName(labelId, labelName){
			$("#omem_label").val(labelId);
			$("#label_name").val(labelName);
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
<div class="content" style="margin-top: 8px;">
    <form action="<%=path %>/transferTreatment/chooseMember" method="POST">
		<div class="search-box-wrapper">
			<ul class="search-wrapper">
				<li>
					<label>会员姓名：</label>
	                <input type="text" name="memName" value="${condition.memName }" maxlength="20">
				</li>
				<li>
					<label>手机号码：</label>
	                <input type="text" name="tel" value="${condition.tel }" maxlength="11">
				</li>
				<li>
					<label>身份证号码：</label>
	                <input type="text" name="idCard" value="${condition.idCard }" maxlength="18">
				</li>
				<li>
					<label>会员分组：</label>
	                <div class="position-r">
		                <input class="info" type="hidden" name="memGrpId" value="${condition.memGrpId }" id="memberGroupId" readonly="readonly" />
	                 	<div class="position-r">
							<input class="info info-search" type="text" name ="memberGroupName" value="${param.memberGroupName}" id="memberGroupName" readonly="readonly" />
							<i class="member-search" id="showGroupIcon" onclick="showGroups();"></i>
						</div>	
                 	</div>
				</li>
				<li>
					<label>会员类型：</label>
	                <select name="memId">
						<option value="">请选择</option>
						<c:forEach items="${memberType }" var="item">
							<c:choose>
								<c:when test="${condition.memId eq item.memid }">
									<option value="${item.memid }" selected>${item.memname }</option>
								</c:when>
								<c:otherwise>
									<option value="${item.memid }">${item.memname }</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</li>
				<li>
					<label>会员疾病史：</label>
	                <select name="disease_id">
						<option value="">请选择</option>
						<c:forEach items="${disease}" var="item">
	                		<c:choose>
	                			<c:when test="${condition.disease_id eq item.disease_id}">
	                				<option value="${item.disease_id}" selected>${item.disease_name }</option>
	                			</c:when>
	                			<c:otherwise>
	                				<option value="${item.disease_id}">${item.disease_name }</option>
	                			</c:otherwise>
	                		</c:choose>
	                	</c:forEach>
					</select>
				</li>
				<li>
					<label>会员标签：</label>
	                <div class="position-r">
		                <input id="label_name" type="text" name="lItemName_list" value="${condition.lItemName_list }" readonly>
		                 <input id="omem_label" type="hidden" name="lItemID_list" value="${condition.lItemID_list }">
		                <i class="member-search" onclick="openMemTag();"></i>
                 	</div>
				</li>
				<li>
					<button type="button" class="btn-inquiry ico-search" onclick="search('1')">查询</button>
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
						<th width="10%">会员姓名</th>
						<th width="8%">性别</th>
						<th width="12%">手机号码</th>
						<th width="18%">会员类型</th>
						<th>所属分组</th>
						<th width="20%">会员疾病史</th>
						<th width="12%">会员标签</th>
						<th width="8%">选择</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${page.result }" var="item">
						<tr>
							<td>${item.memName }</td>
							<td>
								<c:choose>
									<c:when test="${item.gender eq '1' }">男</c:when>
									<c:when test="${item.gender eq '2' }">女</c:when>
									<c:otherwise>未知</c:otherwise>
								</c:choose>
							</td>
							<td>${item.tel }</td>
							<td>${item.memberTypeName }</td>
							<td>${item.memGrpNames }</td>
							<td>${item.diseasNames }</td>
							<td>${item.omemLabel }</td>
							<td>
								<a href="javascript: void(0);" onclick="choose('${item.memberid}');">选择</a>
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
