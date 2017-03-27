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
	<title>统计结果</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">

	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<style>
		.search-term {
			padding: 10px;
		}
		
		.add-bottom {
			border-bottom: 1px solid #000; 
		}
		
		.tip {
			font-size: 16px;
			font-weight: bold;
		}
		
		.search-term p {
			margin: 8px 0 0 25px;
			font-size: 14px;
			line-height: 28px;
		}
		
		.mg-right {
			margin-right: 50px;
		}
		
		.table-box {
			margin-left: 25px;
			margin-bottom: 30px;
		}
	</style>
</head>
<body>
<div class="content">
	<div class="content-title">
   		短信发送记录 --- 统计
	</div>
    <div class="search-term add-bottom">
    	<div class="tip">查询条件</div>
    	<p>
    	短信类型：
    	<span class="mg-right">${smsParams.smsTypeName }</span> 
    	手机号码： <span>${smsParams.recvNumber }</span>
    	</p>
    	<p>
    	发送时间： <span><fmt:formatDate value="${smsParams.startTime }" pattern="yyyy-MM-dd HH:mm:ss"/> </span> 
    		至 <span><fmt:formatDate value="${smsParams.endTime }" pattern="yyyy-MM-dd HH:mm:ss"/></span></p>
    </div>
    <div class="search-term">
    	<div class="tip">统计内容</div>
    	<c:choose>
		<c:when test="${fn:length(map) > 0}">
	    	<c:forEach items="${map }" var="item">
			   	<p>组织ID： <span class="mg-right">${item.key }</span> 组织名称： <span>${item.value[0].orgName }</span></p>
			   	<div class="table-box">
					<table class="table-content">
						<thead class="table-title">
							<tr>
								<th>发送方式</th>
								<th>总发送条数</th>
								<th>发送成功</th>
								<th>发送失败</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${item.value }" var="it">
								<tr>
									<td>
										<c:if test="${it.contentType eq 1}">文本</c:if>
										<c:if test="${it.contentType eq 2}">语音</c:if>
									</td>
									<td>${it.total }</td>
									<td>${it.success }</td>
									<td>${it.fail }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</c:forEach>		
		</c:when>
		<c:otherwise>
			<div class="empty-info">未查询到符合条件的短信统计数据</div>
		</c:otherwise>
		</c:choose>
    </div>
	<div class="page-box align-center">
      <button type="button" class="btn-cancel" onclick="history.go(-1);">返回</button>
	</div>
</div>
</body>
</html>
