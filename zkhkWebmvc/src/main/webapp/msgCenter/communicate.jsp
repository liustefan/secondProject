<%@ page contentType="text/html; charset=utf-8" language="java" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>医患沟通</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/js/jquery-ui/themes/overcast/jquery-ui.min.css">
	<link rel="stylesheet" href="<%=path %>/css/msgCenter.css">

	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-ui/jquery-ui.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script type="text/javascript" src="<%=path %>/js/dataPacker.js"></script>
</head>

<body>
    <div class="content">
    <div class="content-title">医患沟通</div>
    <form action="<%=path %>/communicate/listCommunicate" method="POST" id="pojo">
        <div class="search-box-wrapper">
            <input type="hidden" value="${pojo._logid }">
                <ul class="search-wrapper clearfix">
                    <li>
                        <label>姓名：</label>
                        <input type="text" name="memname" value="${memChat.memname}" maxlength="20">
                    </li>
                    <li>
                        <label>最新消息日期：</label>
                        <input class="info-date" id="startDate" type="text" name="dateFrom" value="<fmt:formatDate value="${memChat.dateFrom}" pattern="yyyy-MM-dd"/>" readonly="readonly"/>
                        <span  class="mar-left">至</span>
                        <input class="info-date" id="endDate" type="text" name="dateTo" value="<fmt:formatDate value="${memChat.dateTo}" pattern="yyyy-MM-dd"/>" readonly="readonly"/>
                    </li>
                    <li>
                        <button type="button" class="btn-inquiry ico-search" onclick="search(1)">查询</button>
                    </li>
                </ul>
        </div>
        <div class="table-box">
        <c:if test="${page.totalCount == 0}">
				<div class="empty-info border-1-solid">目前没有医患沟通信息</div>
			</c:if>
			<c:if test="${page.totalCount > 0}">
            <table class="table-content" id="datalist">
                <thead class="table-title">
                    <tr>
                        <th width="10%">姓名</th>
                        <th width="5%">性别</th>
                        <th width="10%">出生日期</th>
                        <th width="10%">手机号码</th>
                        <th>最新消息内容</th>
                        <th width="10%">最新发送人</th>
                        <th width="10%">最新消息时间</th>
                        <th width="10%">操作</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${page.result}" var="communicate">
                    <tr>
                        <td>${communicate.memname}</td>
                        <td>
                         <c:if test="${communicate.gender==1}">男</c:if>
                         <c:if test="${communicate.gender==2}">女</c:if>
                         <c:if test="${communicate.gender==3}">未知</c:if>
                        </td>
                        <td><fmt:formatDate value="${communicate.birthdate}" pattern="yyyy-MM-dd"/></td>
                        <td>${communicate.tel}</td>
                        
                        <td>
                        <c:if test="${communicate.sendType==1 && communicate.contentType==1}">
                        ${communicate.content}
                        </c:if>
                        <c:if test="${communicate.sendType==2 && communicate.contentType==1}">
                       	<span class="red">${communicate.content}</span>
                        </c:if>
                        </td>
                        <td>
                        <c:if test="${communicate.sendType==1}">${communicate.doctor.docname}</c:if>
                        <c:if test="${communicate.sendType==2}">${communicate.memname}</c:if>
                        </td>
                        <td>
                        <fmt:formatDate value="${communicate.sendTime}" pattern="yyyy-MM-dd"/>
                        </td>
                        <td><a href="../msgCenter/interflow.jsp?id=${communicate._logid}&sId=${communicate.sender}&rId=${communicate.receiver}
                        &name=<c:out value="${communicate.memname}" escapeXml="true"/>&image=${communicate.headaddress}&refType=${communicate.refType}
                        &refID=${communicate.refID}&refStatus=${communicate.refStatus}&memberid=${communicate.memberid}">查看</a></td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
           <div class="page-box">
		            <jsp:include  page="/public/pageFoot.jsp"/>
		   </div>
	   	</c:if>
      </div>
      </form>
    </div>
</body>
</html>

