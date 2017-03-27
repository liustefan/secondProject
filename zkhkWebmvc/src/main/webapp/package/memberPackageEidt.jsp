<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>编辑会员套餐</title>
    <link rel="stylesheet" type="text/css" href="<%=path %>/css/general.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/common.css">
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/calendar.js"></script>
	<script type="text/javascript">
		$(function(){
			 
		});
		var haveError;
			var errorMsgColor ="color:red";		//(样式)错误消息的颜色
			var firstMsgColor = "color: #888"; //(样式)初始的提示语的颜色   用于之后的判断,中间要加空格,全文小写
			
			function basicInit(object){//初始化基本方法
				if(object==null){
					return false;
				}
				$(object).next().text('');//把验证对象后面的提示信息清空
			}
			//文本框验证初始化 
			function checkInit(object){
				
				basicInit(object);
				$(object).val(jQuery.trim($(object).val()));//去掉左右空格
			}
			
		function check(){
			if($("#select").val()=="01"){
					checkInit($("#select1"));
					$("#select").next().text("对不起,请选择套餐！").attr("style",errorMsgColor);
				return false;
			}
		}
	</script>
</head>
<body>
<div class="content">
	<div class="content-title">
		<c:if test="${pageType == 'add'}">
			修改会员套餐
		</c:if>
		<c:if test="${pageType == 'edit'}">
			修改会员套餐
		</c:if>
	</div>
	<form action="<%=path%>/package/saveOrUpdateMemberPackage" onsubmit="return check()"  method="post">
		<input type="hidden" name="memberid" value="${memberPackag.memberid}" />
		<input type="hidden" name="lineNum" value="${memberPackag.lineNum}" />
		<input type="hidden" name="createid" value="${userInfo.id }"/>
		<input type="hidden" name="createName" value="${userInfo.realName }"/>
		<input type="hidden" name="type" value="${pageType}"/>
		<input type="hidden" class="vs"name="createTime" value="${createTime!=null?createTime:(requestScope.now) }" readonly="readonly"/>
		
		 <table id="table_new" cellpadding="0" cellspacing="0" >
	      	 <tr>
		      	 <td class="table_right"></td>
		      	 <td class="table_left"></td>
	      	 </tr>
			 <tr>
			 	<td class="table_right">选择套餐</td>
			 	<td class="table_left">
				 	<select id="select" name="packageCode" >
							<option value='01'>请选择</option>
							<c:if test="${!empty packagList}">
								<c:forEach var="item" items="${packagList}" varStatus="packageSt">
									<option value="${item.packageCode}"   <c:if test="${item.packageCode ==memberPackag.packageCode}">selected="selected" </c:if> >${item.packageName}</option>
								</c:forEach>  
							</c:if>
					</select>
				 	<span></span>
			 	</td>
			 </tr>
			<c:choose>
				<c:when test="${pageType == 'add'}">
					<tr>
					 	<td class="table_right">标志</td>
					 	<td class="table_left">
					 		<select id="select" name="tag" >
								<option value='T'>有效</option>
								<option value='F'>无效</option>
							</select>
					 	</td>
			 		</tr>
				</c:when>
				<c:otherwise>
					<input type="hidden" name="tag" value="T"/>
				</c:otherwise>
			</c:choose>
			<tr>
			    <td></td>
			 	<td align="left">
			 		<input type="submit" value="提交" class="btn-normal"/>
			 	</td>
			</tr>
			<tr>
				<td></td>
				<td></td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>