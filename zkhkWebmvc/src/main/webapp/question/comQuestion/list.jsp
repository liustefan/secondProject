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
	<title>组合问卷列表</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/css/questManage.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script type="text/javascript" src="<%=path %>/js/placeholder.js"></script>
	<script type="text/javascript">
		var index = layer.getFrameIndex(window.name); //获取窗口索引
		// 删除
		function deleteOoptList(node) {
			layer.confirm('你确定需要删除此条记录吗?', {shade: 0, skin: "skin1",offset: "100px;"}, function(index){
				$.ajax({
					type : "GET",
					url : $(node).data("href"),
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
				$(".toUpdate").click(function(){
					var $this = this;
					if($this.getAttribute("cStatus") === "D"){
						window.location.href="toEdit?id="+$this.getAttribute("combQustid");
					}else{
						var flag = true;
						$.ajax({
						     type: 'POST',
						     url: 'hasDraft',
						     data: {name: $this.getAttribute("combQustName")},
						     async : false, //默认为true 异步
						     success: function(msg){
						    	 flag = msg.data;
						     } 
						});
						this.disabled = false;
						if(flag){
							alert("已有该问卷的未发布版本，请在相应的草稿里更改");
						}else{
							layer.confirm('该问卷已发布生效，修改后会产生新版本问卷，<br/>确定需要修改吗?', {shade: 0, skin: "skin1",offset: "100px;"}, function(index){
								window.location.href="toEdit?id="+$this.getAttribute("combQustid");
						        return false;
								layer.close(index);
							});
						}
					}
				});
		});
	</script>
</head>
<body>
<!-- 搜索框结束 -->
<!-- 组合问卷列表开始 -->
<div class="content">
	<div class="content-title">
	 	组合问卷列表
	</div>
  	<form action="list" id="searchForm">
  		<div class="search-box-wrapper">
			<ul class="search-wrapper clearfix">
				<li>筛选:</li>
				<li>
					<label>问卷类别</label>
					<select name="optId" onchange="search(1);">
						<option value="">全部</option>
						<c:forEach items="${options}" var="oopt">
							<option value="${oopt.optId}" <c:if test="${pojo.optId eq oopt.optId}">selected="selected"</c:if>>${oopt.optName}</option>
						</c:forEach>
					</select>
				</li>
				<li>
					<lable>状态 </lable>
					<select name="qustTag" onchange="search(1);">
						<option value="">全部</option>
						<option value="D" <c:if test="${pojo.qustTag eq 'D'}">selected="selected"</c:if>>草稿</option>
						<option value="T" <c:if test="${pojo.qustTag eq 'T'}">selected="selected"</c:if>>生效</option>
					</select>
				</li>
				<li>
					<div class="quick-search-box clearfix fl">
						<div id="content_title_input" class="fl">    
							<input type="text" name="criteria" id="find" value="${criteria}"  placeholder="问卷名称/创建人"/>
						</div>
						<div id="content_title_img_2" class="search-icon">
							<button id="select1" type="button"  onclick="search(1)"><img src="${pageContext.request.contextPath}/img/sousuo.png"/></button>
						</div>
					</div>
					<div class="fr">
						<button class="btn-normal" type="button" onclick="javascript: window.location ='toEdit'">创建问卷</button>
					</div>
				</li>
			</ul>
  		</div>
		<c:if test="${page.totalCount == 0}">
		  <div class="empty-info border-1-solid"><span>没有找到符合条件的问卷信息</span></div>
		</c:if>
		<c:if test="${page.totalCount > 0}">
  			<div id="table-box">
   				<table class="table-content">
           			<thead class="table-title">
			        	<tr>
			        		<th width="6%">问卷编号</th>
			        		<th>问卷名称</th>
			        		<th width="8%">单份问卷数</th>
			        		<th width="10%">问卷类别</th>
			        		<th width="5%">状态</th>
			        		<th width="5%">版本号</th>
			        		<th width="15%">创建人/创建时间</th>
			        		<th width="10%">备注</th>
			        		<!-- <s:if test='#session.logRole == "1"'>管理员才有操作功能，即删除组合问卷
			     	    		<th>操作</th>
			       			</s:if> -->
<%-- 			        		<c:if test='${userInfo.roleid == "2" || userInfo.roleid == "3" || userInfo.roleid == "4"}'> --%>
			        			<!-- <th width="5%">发放</th> -->
			        			<th width="15%">其他操作</th>
<%-- 			        		</c:if> --%>
			        	</tr>
       				</thead>
       				<tbody>
       					<c:forEach items="${page.result}" var="ocqt">
       						<tr>
			        			<td>${ocqt.combQustCode }</td>
			        			<td><c:out value="${ocqt.combQustName }" escapeXml="true"/></td>
								<td>${ocqt.singleAnswerTotal}</td>
								<td>${ocqt.optName}</td>
								<td>
									<c:choose>
					    				<c:when test="${ocqt.qustTag eq 'D'}">草稿</c:when>
					    				<c:when test="${ocqt.qustTag eq 'T'}">生效</c:when>
					    				<c:otherwise>未知</c:otherwise>
					    			</c:choose>
								</td>
								<td>${ocqt.qustVer}</td>
			        			<td>${ocqt.createName }/<fmt:formatDate value="${ocqt.createDate }" pattern="yyyy-MM-dd"/></td>
			        			<td>${ocqt.combDesc}</td>
<%-- 			        			<c:if test='${userInfo.roleid == "2" || userInfo.roleid == "3" || userInfo.roleid == "4"}'> --%>
			        			    <%-- <td class="table-content-td">
			        			    	<c:choose>
						    				<c:when test="${ocqt.qustTag eq 'T'}">
												<a href="../members?combQustid=${ocqt.combQustid}">发放</a>
											</c:when>
						    				<c:otherwise>发放</c:otherwise>
						    			</c:choose>
			        			    </td> --%>
			        				<td class="table-content-td">
			        					<c:choose>
						    				<c:when test="${ocqt.qustTag eq 'T'}">
												<a href="../members?combQustid=${ocqt.combQustid}">发放</a>
											</c:when>
						    				<c:otherwise>发放</c:otherwise>
						    			</c:choose>
			        					<a class="mar-left" onclick="deleteOoptList(this);" data-href="remove?ids=${ocqt.combQustid}">删除</a>
			        					<a class="mar-left toUpdate" cStatus=${ocqt.qustTag} combQustName="${ocqt.combQustName}" combQustid="${ocqt.combQustid}">修改</a>
			        				</td>
<%-- 			        			</c:if> --%>
       						</tr>
       					</c:forEach>
       				</tbody>
       			</table> 
   			</div>
		</c:if>
		<div class="page-box">    
	        <jsp:include  page="/public/pageFoot.jsp"/>
	    </div>
    </form>
</div> 
<!-- 组合问卷列表结束 -->
</body>
</html>
