<%@ page contentType="text/html; charset=utf-8" language="java" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>会员中心(我的会员)</title>
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
	<script type="text/javascript" src="<%=path %>/js/dataPacker.js"></script>
	<script type="text/javascript" src="<%=path %>/js/tree.js"></script>
	<script type="text/javascript" src="<%=path %>/js/members.js"></script>
	<style>
		.member-label {
			width: 414px;
			width: 395px\0;
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
		$(function(){
			$("#btnadd").click(function(){
				window.location = "<%=path %>/mem/MemberAction_toEditMemberPage?flag=other";
	       	}); 
			 
			//弹出批量导入会员页面
			$('#btnImportMember').on('click', function(){
				layer.closeAll();
			    layer.open({
			        type: 2,
			        skin: 'layui-layer-normal',
			        title: '批量导入会员',
			        maxmin: false,
			        shadeClose: true,
				    shade: 0,
			        area : ['600px' , '480px'],
			        content: '<%=path %>/member/importMember.jsp'
			    });
			});
			  
	        $("#checkAll").click(function() {
	        	var value = this.checked;
				$("input:checkbox[name='memId']").each(function () {  
					this.checked = value;  
				});
	        });
	        
	        $("input:checkbox[name='memId']").click(function(){
	            document.getElementById("checkAll").checked = ($("input:checkbox[name='memId']").length == $("input:checkbox[name='memId']:checked").length);
	        });
	            
	        
	        /* $("#showGroupIcon").click(function(){
	    		if($("#menuContent").css("display") =="none") {
	    			getData();
	    			showMenu();
	    		}
	    	}); */
	        
		});
		
		function del(url){
			layer.confirm('你确定需要删除此条记录吗？', {
				title : '提示信息',
				skin : 'skin1',
				shade : 0,
				btn : [ '确定', '取消' ]
			}, function(index) {
				$.ajax({
					url: url,
				   type: "POST",
				success: function(data) {
					alert(data.content);
	 		     	if(data.status) {
	 		     		location.href="<%=path %>/member/memberList?flag=" + $("#flag").val();
	 		     	}
				}
				});
				layer.closeAll();
			});
		}
		
		function remv(url){
			layer.confirm('你确定需要移除此条记录吗？', {
				title : '提示信息',
				skin : 'skin1',
				shade : 0,
				btn : [ '确定', '取消' ]
			}, function(){
				layer.msg("移除成功！",{icon: 1,time: 1000},
				function(index) {
				location.href=url;
				layer.close(index);
				});
			});
		}
		
		function openMemTag() {
			var layerLeft1;
			var layerTop1;
			var diseaseObj1 = $("input[name='labelItemNames']");
			var diseaseOffset1 = $("input[name='labelItemNames']").offset();
			layerLeft1 = diseaseOffset1.left + "px";
			layerTop1 = diseaseOffset1.top + diseaseObj1.outerHeight() + "px";
			
			layer.closeAll();
			layer.open({
		   	    type: 2,
		   		skin : 'skin1',
		   	    title: '会员标签',
		   	    shadeClose: false,
		   	    shade: 0,
		   	 	offset: [layerTop1, layerLeft1],
		   	    area: ['400px', '350px'],
		   	    content: '<%=path %>/label/listLabelItemsByDoc?flag=query&labelIds='+ $("#labelItemIds").val()
		   	}); 
		}
		
		function setLabelName(labelId, labelName) {
			$("#labelItemNames").val(labelName);
			$("#labelItemIds").val(labelId);
		}
		
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
	<div class="content-title">我的会员</div>
    <form action="<%=path %>/member/memberList" method="POST" id="condition">
		<div class="search-box-wrapper">
	    <input id="flag" type="hidden" value="${flag}" name="flag"/> 
		<!-- 问卷结束 -->
			<ul class="search-wrapper">
				<li>
					<span class="label">会员姓名：</span>
	                <input class="info info-name" type="text" name="memName" value="${condition.memName }" maxlength="20">
				</li>
				<li>
					<span class="label">姓名简码：</span>
	                <input class="info info-name" type="text" name="memNameCode" value="${condition.memNameCode }" maxlength="20">
				</li>
				<li>
					<span class="label label-4x">性别：</span>
                    <select class="info control-select" name="gender">
                        <option value="">全部</option>
                        <option value="1"  <c:if test="${condition.gender eq 1}">selected</c:if>>男</option>
                        <option value="2"  <c:if test="${condition.gender eq 2}">selected</c:if>>女</option>
                        <option value="3"  <c:if test="${condition.gender eq 3}">selected</c:if>>未知</option>
                    </select>
				</li>
				<li>
					<span class="label">手机号码：</span>
	                <input class="info info-tel" type="text" name="tel" value="${condition.tel }" maxlength="11">	
				</li>
				<li>
					<span class="label">身份证号：</span>
	                <input class="info info-idCard" type="text" name="idcard" value="${condition.idcard }" maxlength="18">
				</li>
				<c:if test="${flag eq 'my'}">
					<li>
						<span class="label">会员分组：</span>
						<input class="info" type="hidden" name="memGrpId" value="${condition.memGrpId }" id="memberGroupId" readonly />
	                 	<div class="position-r">
							<input class="info info-search" type="text" name ="memberGroupName" value="${param.memberGroupName}" id="memberGroupName" readonly />
							<i class="member-search" id="showGroupIcon" onclick="showGroups();"></i>
						</div>	              
					</li>
				</c:if>
				<li>
					<span class="label">会员疾病史：</span>
					<select class="info control-select" name="diseaseId">
						<option value="-1">全部</option>
						<c:forEach items="${diseases}" var="item">
						<c:if test="${item.disease_id ne 10}">
						<option value="${item.disease_id}" <c:if test="${condition.diseaseId eq  item.disease_id}"> selected='selected'</c:if>>${item.disease_name}</option>
						</c:if>
						</c:forEach>
			        </select>
				</li>
				<li>
					<span class="label">出生日期：</span>
	                    <input class="info info-date" id="startDate" type="data" name="birthDayStart" value="${condition.birthDayStart }" readonly="readonly"/>
	                    <span class="mar-left">至</span>
	                    <input class="info info-date" id="endDate" type="data" name="birthDayEnd" value="${condition.birthDayEnd }" readonly="readonly"/>	
				</li>
				<li>
					<span class="label">管理方案状态：</span>
					<select class="info control-select" name="execStatus">
						<option value="-1">请选择</option>
						<option value="0" <c:if test="${condition.execStatus eq 0}">selected="selected"</c:if>>无方案</option>
						<option value="1" <c:if test="${condition.execStatus eq 1}">selected="selected"</c:if>>制定中</option>
						<option value="2" <c:if test="${condition.execStatus eq 2}">selected="selected"</c:if>>执行中</option>
						<option value="3" <c:if test="${condition.execStatus eq 3}">selected="selected"</c:if>>无任务</option>
						<option value="4" <c:if test="${condition.execStatus eq 4}">selected="selected"</c:if>>已终止</option>
					</select>
				</li>
				<li>
					<span class="label">会员标签：</span>
					<div class="position-r">
						<input class="info info-2x member-label" type="text" name="labelItemNames" value="${condition.labelItemNames}" id="labelItemNames" readonly />
						<input type="hidden" value="${condition.labelItemIds}" name="labelItemIds" id="labelItemIds"/>
						<i class="member-search" onclick='openMemTag()'></i>
					</div>
				</li>
				<li>
					<button type="button" id="query" class="btn-inquiry ico-search" onclick="search(1);">查询</button>
					<c:if test="${flag eq 'other'}">
						<button type="button"  id="addListToGroup" class="btn-inquiry">会员批量加入分组</button>
					</c:if>
					<c:if test="${flag eq 'my'}">
						<button type="button" id="addMember" class="btn-inquiry ico-add" onclick="window.location.href='<%=path %>/member/edit/0?flag=my'">新增</button>
						<button type="button" id="btnImportMember" class="btn-inquiry ico-lead">批量导入会员</button>	
					</c:if>
				</li>
			</ul>
	</div>
	<c:choose>
	<c:when test="${page.totalCount eq 0}">
		<div class="empty-info"><h2>没有查询到符合条件的会员</h2></div>
	</c:when>
	<c:otherwise>
			<div class="table-box">
				<table class="table-content">
					<thead class="table-title">
						<tr>
							<c:if test="${flag eq 'other'}">
								<th width="5%">全选<input type="checkbox" id="checkAll"></th>
							</c:if>
							<!-- <th width="5%">序号</th> -->
							<th width="8%">姓名</th>
							<th width="5%">性别</th>
							<th width="8%">出生日期</th>
							<th width="9%">手机号码</th>
							<th width="8%">会员疾病史</th>
							<th width="12%">健康管理方案</th>
							<th width="6%">最近测量</th>
<%--							<th width="6%">活力指数</th>--%>
							<th width="13%">所属分组</th>
							<th width="8%">会员类型</th>
							<th width="5%">状态</th>
							<c:if test="${not empty flag}">
								<th>操作</th>
							</c:if>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${page.result}" varStatus="statu" var="item">
							<tr id="tr_${item.memberId}">
									<c:if test="${flag eq 'other'}">
										<td><input name="memId" type="checkbox" data-memname="${item.memName}"
											value="${item.memberId}"></td>
									</c:if>
									<%-- <td>${(page.pageSize)*(page.pageNo)-((page.pageSize))+(statu.index+1) }</td> --%>
								<td><a href="<%=path %>/member/${item.memberId }/memberPage" target="_blank"><c:out value="${item.memName}"></c:out></a></td>
								<td>
									<c:if test="${item.gender eq 1}">男</c:if>
									<c:if test="${item.gender eq 2}">女</c:if>
									<c:if test="${empty item.gender or item.gender eq 3}">未知</c:if>
								</td>
								<td><fm:formatDate value="${item.birthDay}" type="date" pattern="yyyy-MM-dd" dateStyle="long" /></td>
								<td>${item.tel }</td>
								<td>${item.diseaseNames}</td>
								<td><a href="<%=path%>/health/managescheme/toEdit?id=${item.designID}&view=true&source=../../member/memberList?flag=my">${item.schemeTitle}<a></td>
								<td>
								<fm:formatDate value="${item.lastTestTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
								</td>
								<td>${item.memGrpNames }</td>
								<td>${item.memDesc }</td>
								<td>
								<c:choose>
								<c:when test="${item.status eq 'T' }"><img src="<%=path %>/img/normal.png"/></c:when>
								<c:otherwise><img src="<%=path %>/img/frozen.png"/></c:otherwise>
								</c:choose>
								</td>
								<c:if test="${flag eq 'my'}">
									<td id="table_content_title_td">
										<a href="<%=path %>/member/edit/${item.memberId }?flag=${flag}">修改</a>&nbsp;										
										<a onclick="del('<%=path %>/member/${item.memberId }/delete?flag=${flag}');" 
											href="javascript:void(0);">删除</a>
										<c:choose>
											<c:when test="${item.status eq 'T' and (item.execStatus eq 0 or item.execStatus eq 4)}">
												<a href="javascript: void(0);" onclick="window.location.href = '<%=path%>/health/managescheme/toEditPerson?memberId=${item.memberId}&source=../../member/memberList?flag=my'">制定管理方案</a>
											</c:when>
											<c:otherwise>
												<span>制定管理方案</span>
											</c:otherwise>
										</c:choose>
									</td>
								</c:if>
								<c:if test="${flag eq 'other'}">
									<td id="table_content_title_td">
										<a href="javascript: void(0);" onclick="updateMemberGroup(${item.memberId},'${item.memName}','')">加入会员分组</a>&nbsp;
									</td>
								</c:if> 
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
	<div style="color:#999;display:none;" id="fail1" >以下会员的会员分组跟医生分组功能代码存在冲突,添加失败列表<br/><span id="fail"></span></div>
	
	<div id="loading-mask"></div>
	<div id="fullbg"></div>
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
