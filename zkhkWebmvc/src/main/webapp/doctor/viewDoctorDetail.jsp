<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
    <title>详细信息</title>
    <link rel="shortcut icon" href="<%=path %>/<%=getServletContext().getAttribute("img") %>/title_ico.ico" type="image/x-icon" />
    <link rel="stylesheet" href="<%=path %>/css/general.css">
    
    <script src="<%=path %>/js/jquery-1.9.1.min.js"></script>
    <script src="<%=path %>/js/common.js"></script>
  	<style type="text/css">
  		* {
  			margin: 0;
  			padding: 0;
  		}
  		
  		body {
		    font-size: 12px;
			line-height: 1.5;
			font-family: "Microsoft YaHei", "SimSun";
			color: #333;
			background: #f3f3f3;
		}
		
		/*合并表格边框，设置边框距为零*/
		table {
	        width: 100%;
		    border-collapse: collapse;
		    border-spacing: 0;
		    word-wrap: break-word;
		    word-break: break-all;
		}
		
		.user-info {
			width: 800px;
			margin: 0 auto;
			background: #fff;
			border: 1px solid #ddd;
			table-layout: fixed;
		}
		
		.user-info tr td {
		  padding: 10px;
		  font-size: 13px;
		  border: 1px solid #ddd;
		}
		
		.padding-tb {
			padding: 5px 0 15px 0;
			font-size: 14px;
			font-weight: 500;
		}
  	</style>
</head>
<body>
<div class="content">
<div class="content-title">管理员列表 --- 查看</div>
    <div class="align-center padding-tb">
    	<span>${requestScope.odoc.docname }的个人信息</span>
   	</div>
    <table class="user-info">
    	<tr>
			<td width="20%" align="right">头像：</td>
			<td> 
				<c:if test="${requestScope.odoc.headaddress != null && requestScope.odoc.headaddress != ''}">
					<img src="${pageContext.request.contextPath }/image/getImage?uniqueId=${odoc.headaddress}" width="80" height="80" />
				</c:if> 
			</td>
		</tr>
    	<tr>
    		<td align="right">账号：</td>
			<td>${requestScope.odoc.doctorAccount.docacc }</td>
		</tr>
		<tr>
			<td align="right">姓名：</td>
			<td>${requestScope.odoc.docname }</td>
		</tr>
		<tr>
			<td align="right">职称：</td>
			<td>${requestScope.odoc.title }</td>
		</tr>
		<tr>
			<td align="right">性别：</td>
			<td>
				<c:if test="${requestScope.odoc.gender == 'M' }">男</c:if>
				<c:if test="${requestScope.odoc.gender == 'F' }">女</c:if>
			</td>
		</tr>
		<tr>
			<td align="right">微信：</td>
			<td>${requestScope.odoc.weixin }</td>
		</tr>
		<tr>
			<td align="right">手机号码：</td>
			<td>${requestScope.odoc.tel }</td>
		</tr>
		<tr>
			<td align="right">Email：</td>
			<td>${requestScope.odoc.email }</td>
		</tr>
		<tr>
			<td align="right">联系电话：</td>
			<td>${requestScope.odoc.contacttel }</td>
		</tr>
		<tr>
			<td align="right">家庭地址：</td>
			<td>${requestScope.odoc.homeaddress }</td>
		</tr>
		<tr>
			<td align="right">工作单位：</td>
			<td>${requestScope.odoc.workaddress }</td>
		</tr>
		<tr>
			<td align="right">单位地址：</td>
			<td>${requestScope.odoc.unitaddress }</td>
		</tr>
		<tr>
			<td align="right">工作科室：</td>
			<td>${requestScope.odoc.workdepart }</td>
		</tr>
		<tr>
			<td align="right">户口地址：</td>
			<td>${requestScope.odoc.resideaddress }</td>
		</tr>
		<tr>
			<td align="right">证件类型：</td>
			<td>
				<c:if test="${requestScope.odoc.certitype == '1' }">
					身份证
				</c:if>
				<c:if test="${requestScope.odoc.certitype == '2' }">
					驾驶证
				</c:if>
				<c:if test="${requestScope.odoc.certitype == '3' }">
					港澳通行证
				</c:if>
			</td>
		</tr>	
		<tr>
			<td align="right">证件号码：</td>
			<td>${requestScope.odoc.certinum }</td>
		</tr>
		<tr>
			<td align="right">简介：</td>
			<td>${requestScope.odoc.desription }</td>
		</tr>
		<tr>
			<td align="right">签名：</td>
			<td style="padding: 10px;">
				<c:if test="${requestScope.odoc.signaddress != null && requestScope.odoc.signaddress != ''}">
					<img src="${pageContext.request.contextPath }/image/getImage?uniqueId=${odoc.signaddress}" width="80" height="80" />
				</c:if>
			</td>
		</tr>
		<tr>
			<th colspan="2" height="30">
				<div class="page-box">
					<input type="button" class="btn-inquiry" onclick="window.history.go(-1);" value="返回" >
				</div>
			</th>
		</tr>
	</table>
	<br/>
</div>
</body>
</html>
