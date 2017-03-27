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
	<title>单份答卷列表</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/css/questManage.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script type="text/javascript" src="<%=path %>/js/placeholder.js"></script>
	<script type="text/javascript">
		var index = layer.getFrameIndex(window.name); //获取窗口索引
		// 删除
		function del(node) {
			layer.confirm('确认需删除此答卷?', {shade: 0, skin: "skin1",offset: "100px;"}, function(index){
				$.ajax({
					type : "GET",
					url : "remove?ids="+node,
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
		         //全选和反选
				  $("#checkAll").click(function() {
		              $('input[name="ansNumbers"]:checkbox').not(':disabled').prop("checked",this.checked); 
		          });
		          var $subBox = $("input[name='ansNumbers']");
		          $subBox.click(function(){
		              $("#checkAll").prop("checked",$subBox.length == $("input[name='ansNumbers']:checked").not(':disabled').length ? true : false);
		          });
				  //禁用分页回车键
				  $("#toPage").keydown(function(e){
						if(e.keyCode==13) {
							return false;
						}
				  }); 
	
				  $('.printBtn').click(function(){
					    var data;
					  	if(this.getAttribute("data")){
					  		data = "ansNumbers="+this.getAttribute("data");
					  	}else{
					  		var checkedRows = $("input[name='ansNumbers']:checked");
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
		<c:if test="${empty pojo.memberid}">单份答卷列表</c:if><c:if test="${not empty pojo.memberid}">答卷管理</c:if>
	</div>
	<form action="list" id="searchForm">
		<input type="hidden" name="memberid" value="${pojo.memberid}">
		<div class="search-box-wrapper">
			<ul class="search-wrapper clearfix">
				<li>筛选：</li>
				<li>
					<label>状态</label>
					<select name="qustTag" onchange="search(1);">
						<option value="">全部</option>
						<option value="F" <c:if test="${pojo.qustTag eq 'F'}">selected="selected"</c:if>>未作答</option>
						<option value="T" <c:if test="${pojo.qustTag eq 'T'}">selected="selected"</c:if>>已作答</option>
						<option value="C" <c:if test="${pojo.qustTag eq 'C'}">selected="selected"</c:if>>已审核</option>
					</select>
				</li>
				<li>
					<div class="quick-search-box clearfix fl">
						<div id="content_title_input" class="fl">    
							<input type="text" name="criteria" value="${criteria}" id="find"  placeholder="问卷名称/接收会员名称/发放人">
							<input type="hidden" name="myFlag" value="YAndN">
						</div>
						<div id="content_title_img_2" class="search-icon">
							<button id="select1" type="button" onclick="search(1)"><img src="${pageContext.request.contextPath}/img/sousuo.png"/></button>
						</div>
					</div>
					<div class="fr">
						<button class="btn-normal printBtn" type="button">批量打印</button>
					</div>
				</li>
			</ul>
		</div>
		<div class="table-box">
			<c:if test="${page.totalCount == 0}">
				<div class="empty-info border-1-solid">没有满足条件的单份答卷</div>
			</c:if>
			<c:if test="${page.totalCount > 0}">
				<table class="table-content">
			    	<thead class="table-title">
			   			<tr>
				   		    <th width="5%"><label>全选<input id="checkAll" type="checkbox" /></label></th>
				   		    <th>答卷编号</th>
							<th>答卷名称</th>
							<th>作答会员</th>
							<th>发放医生/发放时间</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${page.result}" var="ouai">
							<tr>
							    <td><input type="checkbox" name="ansNumbers" <c:if test="${ouai.qustTag != 'C'}">disabled="disabled"</c:if> value="${ouai.ansNumber}"/></td>
							    <td>${ouai.ansNumber}</td>
								<td><c:out value="${ouai.omfq.qustname}" escapeXml="true"/></td>
								<td>${ouai.member.memname}</td>
								<td>${ouai.docName}/<fmt:formatDate value="${ouai.publisherTime }" pattern="yyyy-MM-dd"/></td>
								
								<td id="table_content_title_td">
									${ouai.qustTagName}
								</td>
								<td id="table_content_title_td">
									<c:if test='${ouai.qustTag eq "T" || ouai.qustTag eq "C"}'>
										<a href="answerView?ansNumber=${ouai.ansNumber}">查看</a>
									</c:if>
									<c:if test='${ouai.qustTag eq "B"}'>
										<c:choose>
											<c:when test="${isMy}">
											<a href="answerInfo?ansNumber=${ouai.ansNumber}&memberId=${pojo.memberid}">继续作答</a>
											</c:when>
											<c:otherwise>
												<span class="right">继续作答</span>
											</c:otherwise>
										</c:choose>
									</c:if>
									<c:if test='${ouai.qustTag eq "F"}'>
										<c:choose>
											<c:when test="${isMy}">
												<a href="answerInfo?ansNumber=${ouai.ansNumber}&memberId=${pojo.memberid}">作答</a>
											</c:when>
											<c:otherwise>
												<span class="right">作答</span>
											</c:otherwise>
										</c:choose>
									</c:if>
									<c:if test='${ouai.qustTag eq "C"}'>
										<a href="javascript:;" class="mar-left printBtn" data="${ouai.ansNumber}">打印</a>
									</c:if>
									<c:if test="${ouai.qustTag ne 'C'}">
										<span class="mar-left">打印</span>
									</c:if>
									<c:choose>
										<c:when test="${ouai.qustTag eq 'F' and isMy}">
											<a class="mar-left" onclick="javascript:del('${ouai.ansNumber}')" href="javascript:void(0);">删除</a>
										</c:when>
										<c:otherwise>
											<span class="mar-left">删除</span>
										</c:otherwise>
									</c:choose>
					   			</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
			<div class="page-box">
				<jsp:include  page="/public/pageFoot.jsp"/>
			</div>
		</div>
	</form>
</div>
</body>
</html>
