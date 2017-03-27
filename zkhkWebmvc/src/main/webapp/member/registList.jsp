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
	<title>会员中心(导入失败会员)</title>
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
	<script type="text/javascript">
		$(function(){
	        $("#checkAll").click(function() {
	        	var value = this.checked;
				$("input:checkbox[name='memId']").each(function () {  
					this.checked = value;  
				});
	        });
	        
	        $("input:checkbox[name='memId']").click(function(){
	            document.getElementById("checkAll").checked = ($("input:checkbox[name='memId']").length == $("input:checkbox[name='memId']:checked").length);
	        });
	            
		});
		
		function exportData(){
			$("#submitForm").attr("action", "<%=path %>/data/exportData");
			$("#submitForm").attr("target", "_blank");
			$("#submitForm").submit();
			$("#submitForm").attr("action", "<%=path %>/data/registList");
			$("#submitForm").removeAttr("target");
		}
		
		function del(uuid){
			layer.confirm('你确定需要删除选中的记录吗？', {
				title : '提示信息',
				skin : 'skin1',
				shade : 0,
				btn : [ '确定', '取消' ]
			}, function(index) {
				$.ajax({
					url: "<%=path %>/data/delete?uuid=" + uuid,
				   type: "POST",
				success: function(data) {
					if(data != "null" && data != "") {
						alert(data);
					}
					location.href="<%=path %>/data/registList";
				}
				});
				layer.closeAll();
			});
		}
		
		function batchDel(){
			if($("input:checkbox[name='memId']:checked").size() == 0) {
				alert("选择要删除的行");
				return;
			}
			var arr = [];
			$("input:checkbox[name='memId']:checked").each(function () {  
				arr.push(this.value);
			});
			del(arr.toString());
			
		}
		
		function delAll(){
			layer.confirm('你确定需要删除全表记录吗？', {
				title : '提示信息',
				skin : 'skin1',
				shade : 0,
				btn : [ '确定', '取消' ]
			}, function(index) {
				$.ajax({
					url: "<%=path %>/data/deleteAll",
				   type: "POST",
				success: function(data) {
					if(data != "null" && data != "") {
						alert(data);
					} else {
						location.href="<%=path %>/data/registList";
					}
				}
				});
				layer.closeAll();
			});
			
		}
	</script>
</head>
<body>
<div class="content">
	<div class="content-title">导入失败会员</div>
	<c:if test="${importCount gt 0}">
	<b><font color="red" size="5px">尚有${importCount}条正在导入</font></b>
	</c:if>
    <form action="<%=path %>/data/registList" method="POST" id="submitForm">
		<div class="search-box-wrapper">
		<!-- 问卷结束 -->
			<ul class="search-wrapper">
				<li>
					<span class="label">会员姓名：</span>
	                <input class="info info-name" type="text" name="memname" value="${member.memname }" maxlength="20">
				</li>
				<li>
					<span class="label">身份证号：</span>
	                <input class="info info-idCard" type="text" name="idcard" value="${member.idcard }" maxlength="18">
				</li>
				<li>
					<span class="label">手机号码：</span>
	                <input class="info info-tel" type="text" name="tel" value="${member.tel }" maxlength="11">	
				</li>
				<li>
					<button type="submit" id="query" class="btn-inquiry ico-search">查询</button>
					<button type="button" id="batchDelete" class="btn-inquiry ico-del" onclick="batchDel()">删除</button>
					<button type="button" id="allDelete" class="btn-inquiry ico-del" onclick="delAll()">全部删除</button>
					<button type="button" id="exportAll" class="btn-inquiry" onclick="exportData()">导出所有</button>
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
								<th width="5%">全选<input type="checkbox" id="checkAll"></th>
								<th width="8%">姓名</th>
								<th width="17%">身份证</th>
								<th width="5%">性别</th>
								<th width="10%">出生日期</th>
								<th width="10%">手机号码</th>
								<th width="10%">注册日期</th>
								<th width="23%">失败原因</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${page.result}" var="item">
								<tr id="tr_${item.memberGUID}">
								<td>
								<input name="memId" type="checkbox" data-memname="${item.memname}" value="${item.memberGUID}"/>
								</td>
									<td>${item.memname}</td>
									<td>${item.idcard}</td>
									<td>
										<c:if test="${item.gender eq 1}">男</c:if>
										<c:if test="${item.gender eq 2}">女</c:if>
										<c:if test="${item.gender eq 3}">未知</c:if>
									</td>
									<td><fm:formatDate value="${item.birthday}" type="date" pattern="yyyy-MM-dd" dateStyle="long" /></td>
									<td>${item.tel }</td>
									<td><fm:formatDate value="${item.createTime}" type="date" pattern="yyyy-MM-dd" dateStyle="long" /></td>
									<td><span title="${item.reason }">${fn:substring(item.reason,0,20) }</span></td>
									<td id="table_content_title_td">
										<a href="<%=path%>/data/registInfo?memberId=${item.memberid}">修改</a>&nbsp;										
										<a onclick="del('${item.memberGUID}');" href="javascript:void(0);">删除</a>
									</td>
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
