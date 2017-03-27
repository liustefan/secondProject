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
	<title>转诊记录</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/js/jquery-ui/themes/overcast/jquery-ui.min.css">
	<link rel="stylesheet" href="<%=path %>/plugins/font-awesome/css/font-awesome.min.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-ui/jquery-ui.js"></script>
	<script type="text/javascript" src="<%=path %>/js/dataPacker.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script type="text/javascript">
		function del(url, memName){
			layer.confirm('删除后将不能恢复，您确定要删除会员'+memName+'的转诊信息吗？', {
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
				 		     		location.href="<%=path %>/transferTreatment/getTransferTreatRecord";
				 		     	}
							}
				});
				layer.closeAll();
			});
		}
		
		function add(){
			layer.closeAll('iframe');
			layer.open({
			    type: 2,
				skin : 'skin1',
			    title: '选择会员',
			    shadeClose: false,
			    shade: 0,
			    area: ['900px', '485px'],
			    content: '<%=path %>/transferTreatment/chooseMember', //iframe的url
			}); 
		}
	</script>
</head>

<body>
<div class="content">
	<div class="content-title">
   		转诊记录
	</div>
    <form action="<%=path %>/transferTreatment/getTransferTreatRecord" method="POST" id="condition">
		<div class="search-box-wrapper">
			<ul class="search-wrapper">
				<li>
					<label>姓名：</label>
	                <input type="text" name="memName" value="${condition.memName }" maxlength="20">
				</li>
				<li>
					<label>会员疾病史：</label>
	                <select name="diseasName">
	                	<option value="">请选择</option>
	                	<c:forEach items="${disease}" var="item">
	                		<c:choose>
	                			<c:when test="${condition.diseasName eq item.disease_name}">
	                				<option value="${item.disease_name}" selected>${item.disease_name }</option>
	                			</c:when>
	                			<c:otherwise>
	                				<option value="${item.disease_name}">${item.disease_name }</option>
	                			</c:otherwise>
	                		</c:choose>
	                	</c:forEach>
					</select>
				</li>
				<li>
					<label>状态：</label>
	                <select name="treatStatus">
						<option value="">全部</option>
						<c:choose>
							<c:when test="${condition.treatStatus eq '1'}">
								<option value="1" selected>转诊申请</option>
							</c:when>
							<c:otherwise>
								<option value="1">转诊申请</option>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${condition.treatStatus eq '2'}">
								<option value="2" selected>取消转诊</option>
							</c:when>
							<c:otherwise>
								<option value="2">取消转诊</option>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${condition.treatStatus eq '3'}">
								<option value="3" selected>已转诊</option>
							</c:when>
							<c:otherwise>
								<option value="3">已转诊</option>
							</c:otherwise>
						</c:choose>
					</select>
				</li>
				<li>
					<label>更新日期：</label> 
					<input class="info-date" id="startDate" type="text" name="updateStartTime" required="required" value='<fm:formatDate value="${condition.updateStartTime }" pattern="yyyy-MM-dd"/>' readonly="readonly" /> 
					<span class="mar-left">至</span> 
					<input class="info-date" id="endDate" type="text" name="updateEndTime" required="required" value='<fm:formatDate value="${condition.updateEndTime }" pattern="yyyy-MM-dd"/>' readonly="readonly" />
				</li>
				<li>
					<button type="button" class="btn-inquiry ico-search" onclick="search(1)">查询</button>
					<button type="button" class="btn-inquiry ico-add" onclick="add();">新增</button>
				</li>
			</ul>
		</div>
		<div class="table-box">
			<table class="table-content">
				<thead class="table-title">
					<tr>
						<th width="6%">姓名</th>
						<th width="6%">性别</th>
						<th width="12%">会员疾病史</th>
						<th width="10%">转诊机构和科室</th>
						<th>转诊原因</th>
						<th width="12%">转诊结果</th>
						<th width="8%">状态</th>
						<th width="8%">创建人</th>
						<th width="8%">更新人</th>
						<th width="8%">更新日期</th>
						<th width="8%">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${page.result}" varStatus="statu" var="item">
						<tr>
							<td><a href="<%=path %>/transferTreatment/jumpTransferTreatPage?memberId=${item.memberId}&id=${item.ttreatmentid}&flag=scan">${item.memName }</a></td>
							<td>
								<c:if test="${item.gender eq '1'}">男</c:if>
								<c:if test="${item.gender eq '2'}">女</c:if>
								<c:if test="${empty item.gender or item.gender eq '3'}">未知</c:if>
							</td>
							<td>${item.diseasNames }</td>
							<td>${item.organddept }</td>
							<td>${item.reason }</td>
							<td>${item.result }</td>
							<td>${item.treatStatusName }</td>
							<td>${item.createDocName }</td>
							<td>${item.updateDocName }</td>
							<td><fm:formatDate value="${item.updatetime }" pattern="yyyy-MM-dd"/></td>
							<td>
								<a href="<%=path %>/transferTreatment/jumpTransferTreatPage?memberId=${item.memberId}&id=${item.ttreatmentid}&flag=edit" >修改</a>
								<a onclick="del('<%=path %>/transferTreatment/${item.ttreatmentid}/deleteTransferTreat','${item.memName }');" href="javascript:void(0);" class="mar-left">删除</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="page-box">
			<jsp:include page="/public/pageFoot.jsp"></jsp:include>
		</div>
	</form>
</div>
</body>
</html>