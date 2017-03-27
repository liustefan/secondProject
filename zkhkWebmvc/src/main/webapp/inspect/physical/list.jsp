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
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=9">
<title>健康体检</title>
<link rel="stylesheet" href="<%=path %>/css/general.css">
<link rel="stylesheet" href="<%=path %>/css/PublicHealthList.css">
<link rel="stylesheet" href="<%=path %>/js/jquery-ui/themes/overcast/jquery-ui.min.css">

<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/jquery-ui/jquery-ui.js"></script>
<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
<script type="text/javascript" src="<%=path %>/js/dataPacker.js"></script>
<script type="text/javascript" src="<%=path %>/js/checkUpList.js"></script>
</head>
<body>
	<div class="content">
		<div class="content-title">健康体检</div>
		<form action="list" id="form1">
		<input type="hidden" name="memberID" value="${pojo.memberID}">
			<div class="search-box-wrapper">
				<ul class="search-wrapper clearfix">
					<c:if test="${empty pojo.memberID}">
					<li>
						<label>姓名：</label>
						<input class="info-name" type="text" name="member.memname" value="${pojo.member.memname}" maxlength="20">
					</li>
					<li>
						<label>身份证号码：</label> 
						<input class="info-idCard" type="text" name="member.idcard" value="${pojo.member.idcard}" maxlength="18">
					</li>
					<li>
						<label>手机号码：</label> 
						<input class="info-tel" type="text" name="member.tel" value="${pojo.member.tel}" maxlength="11">
					</li>
					</c:if>
					<li>
						<label>体检日期：</label>
						<input class="info-date" id="startDate" type="text" name="startExamDate" value="<fmt:formatDate value="${pojo.startExamDate}" pattern="yyyy-MM-dd"/>" readonly="readonly" />
						<span class="mar-left">至</span>
						<input class="info-date" id="endDate" type="text" name="endExamDate" value="<fmt:formatDate value="${pojo.endExamDate}" pattern="yyyy-MM-dd"/>" readonly="readonly" />
					</li>
					<li>
						<button type="button" onclick="search(1)" class="btn-inquiry ico-search">查询</button>
						<c:if test="${isMy || empty pojo.memberID}">
						<button type="button" onclick="window.location.href='toEdit?memberID=${pojo.memberID}&memName=<c:out value="${pojo.name}" escapeXml='true'/>&singleMembers=${empty pojo.memberID ? false : true}&unique_ID=${pojo.unique_ID}'" class="btn-inquiry ico-add" >新增</button>
						<button type="button" class="btn-inquiry ico-del" onclick="del();">删除</button>
						</c:if>
					</li>
				</ul>
			</div>
			<div class="table-box">
				<div id="footer_table">
					<c:if test="${page.totalCount == 0}">
						<div class="empty-info border-1-solid">目前还没有健康体检信息</div>
					</c:if>
					<c:if test="${page.totalCount > 0}">
						<table border="0" cellspacing="0"  class="table-content">
							<thead class="table-title">
								<tr>
									<th width="5%">选择</th>
									<c:if test="${empty pojo.memberID}">
									<th width="15%">姓名</th>
									<th width="5%">性别</th>
									<th width="10%">出生日期</th>
									<th width="10%">手机号码</th>
									<th width="15%">身份证号码</th>
									</c:if>
									<th width="10%">体检日期</th>
									<th width="8%">责任医生</th>
									<th width="7%">来源</th>
									<th width="15%">操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${page.result}" var="item" varStatus="vs">
									<tr>
										<td>
											<input name="ids" type="checkbox" value="${item.HExamID}" ${item.refCompany==0?'':'disabled'}>
										</td>
										<c:if test="${empty pojo.memberID}">
										<td>
											<a href="<%=path %>/member/${item.member.memberid}/memberPage?page=checkUp" target="_new">${item.member.memname}</a>
										</td>
										<td>${item.member.gender=='1'?'男':item.member.gender=='2'?'女':'未知'}</td>
										<td>
											<fmt:formatDate value="${item.member.birthdate}" pattern="yyyy-MM-dd" />
										</td>
										<td>${item.member.tel}</td>
										<td>${item.member.idcard}</td>
										</c:if>
										<td>
											<fmt:formatDate value="${item.examDate}" pattern="yyyy-MM-dd" />
										</td>
										<td>${item.responsibleDrName}</td>
										<td>${item.refCompany==0?'录入':'导入'}</td>
										<td class="operation-box">
											<a href="view?id=${item.HExamID}&memberID=${pojo.memberID}">查看</a>
											<c:if test="${isMy || empty pojo.memberID}">
												<c:if test="${item.refCompany==0}">
													<a class="mar-left" href="toEdit?id=${item.HExamID}&singleMembers=${empty pojo.memberID ? false : true}">修改</a>
												</c:if>
												<c:if test="${item.refCompany!=0}">
													<span>修改</span>
												</c:if>
											</c:if>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:if>
					<div class="page-box">
						<div class="fl">
							<button type="button" id="allSelect" class="btn-inquiry">全选</button>
							<button type="button" id="unSelect"  class="btn-inquiry">反选</button>
						</div>
						<jsp:include page="/public/pageFoot.jsp"/>
				  	</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
