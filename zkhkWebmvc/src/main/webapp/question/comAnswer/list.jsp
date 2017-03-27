<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" %>
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
	<title>组合答卷列表</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/css/questManage.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script type="text/javascript" src="<%=path %>/js/placeholder.js"></script>
	<script type="text/javascript">
		var index = layer.getFrameIndex(window.name); //获取窗口索引
		// 删除
		function del(combAnsid) {
			layer.confirm('确认需删除此答卷?', {shade: 0, skin: "skin1",offset: "100px;"}, function(index){
				$.ajax({
					type : "GET",
					url : "remove?ids="+combAnsid,
					success : function(msg) {
						layer.msg(msg.content,{offset: "100px;", time: 1000},function(index){
							layer.close(index);
							if(msg.status) {
								window.location.href = window.location.href;
							}
						});
					}
				});
				layer.close(index);
			})
		}
	
		$(function(){
	 		var $form = $("form");
			function submit(url){
				$form.attr("action", url);
				$form.submit();
			} 
			//全选和反选
			$("#checkAll").click(function() {
				console.log($('input[name="combAnsIds"]:checkbox'));
	            $('input[name="combAnsIds"]:checkbox').not(':disabled').prop("checked",this.checked); 
	        });
	        var $subBox = $("input[name='combAnsIds']");
	        $subBox.click(function(){
	            $("#checkAll").prop("checked",$subBox.length == $("input[name='combAnsIds']:checked").not(':disabled').length ? true : false);
	        });
			
			$('.printBtn').click(function(){
			   var data;
			 	if(this.getAttribute("data")){
			 		data = "combAnsIds="+this.getAttribute("data");
			 	}else{
			 		var checkedRows = $("input[name='combAnsIds']:checked");
				data = $.param(checkedRows);
				if(!data){
					alert("请选择答卷");
					return;
				}
			 	}
			 	window.location.href="queryPrintQuestionInfoByIds?"+data;
			});
		});
	</script>
</head>
<body>
<div class="content">
	<div class="content-title">
	 	组合答卷列表
	</div>
  	<form action="list" id="searchForm">
	    <div class="search-box-wrapper">
			<ul class="search-wrapper clearfix">
				<li>筛选：</li>
				<li>
					<label>状态</label>
					<select name="combTag" onchange="search(1);">
						<option value="">全部</option>
						<c:forEach items="${combTags}" var="combTag">
							 <option value="${combTag.code}" <c:if test="${combTag.code eq pojo.combTag}">selected="selected"</c:if>>${combTag.name}</option>
						</c:forEach>
					</select>
				</li>
				<li>
					<div class="quick-search-box clearfix fl">
					<div id="content_title_input" class="fl">    
						<input type="text" name="criteria" value="${criteria}" id="find"  placeholder="接受会员/问卷名称/创建人">
						<input type="hidden" name="myFlag" value="YAndN">
					</div>
					<div id="content_title_img_2" class="search-icon">
						<button type="button" id="select1" onclick="search(1)"><img src="${pageContext.request.contextPath}/img/sousuo.png"/></button>
					</div>
					</div>
					<div class="fr">
						<button  class="btn-normal printBtn" type="button">批量打印</button>
					</div>
				</li>
			</ul>
		</div>
		<div class="table-box">
			<c:if test="${page.totalCount == 0}">
			<tr>
			   <td colspan="7">
			        <div class="empty-info border-1-solid">暂时没有任何组合答卷</div>
			   </td>
			</tr>
			</c:if>
			<c:if test="${page.totalCount > 0}">
			   <table class="table-content">
				    <thead class="table-title">
					    <tr>
					     	<th width="5%"><label>全选<input id="checkAll" type="checkbox" /></label></th>
							<th>问卷编号</th>
							<th>问卷名称</th>
							<th>作答会员</th>
							<th>发放医生/发放时间</th>
							<th>答卷状态</th>
							<th>其他操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${page.result}" var="ocam">
						<tr>
							<td><input type="checkbox" name="combAnsIds" <c:if test="${ocam.combTag != 2}">disabled="disabled"</c:if> value="${ocam.combAnsid}"/></td>
							<td>${ocam.combQustCode}</td>
							<td id="table_content_title_td"><c:out value="${ocam.combQustName}" escapeXml="true"/></td>
							<td>${ocam.member.memname }</td>
							<td>${ocam.docName }/<fmt:formatDate value="${ocam.publisherTime }" pattern="yyyy-MM-dd"/></td>
							<td>
								${ocam.combTagName}
							</td>
							<td>
								<c:if test='${ocam.combTag == "0"}'><a href="answerInfo?combAnsId=${ocam.combAnsid}">作答</a><span class="mar-left">打印</span><a class="mar-left" href="javascript:;" onclick="del(${ocam.combAnsid})">删除</a></c:if>
								<c:if test='${ocam.combTag == "3"}'><a href="answerInfo?combAnsId=${ocam.combAnsid}">继续作答</a><span class="mar-left">打印</span><span class="mar-left">删除</span></c:if>
								<c:if test='${ocam.combTag == "1" || ocam.combTag == "4"}'><a href="answerInfo?combAnsId=${ocam.combAnsid}">查看</a><span class="mar-left">打印</span><span class="mar-left">删除</span></c:if>
								<c:if test='${ocam.combTag == "2"}'><a href="answerInfo?combAnsId=${ocam.combAnsid}">查看</a><a href="javascript:;" class="mar-left printBtn" data="${ocam.combAnsid}">打印</a><span class="mar-left">删除</span></c:if>
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
</body>
</html>