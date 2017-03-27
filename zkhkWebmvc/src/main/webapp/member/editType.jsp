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
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=9">
<title>新增/修改会员类型</title>

<link rel="stylesheet" type="text/css" href="<%=path %>/css/general.css">
<link rel="stylesheet" type="text/css" href="<%=path %>/css/common.css">

<script src="<%=path %>/js/jquery-1.9.1.min.js"></script>
<script src="<%=path %>/js/common.js"></script>
<script src="<%=path %>/js/validate.js"></script>
<script type="text/javascript">
$(function(){
	$("#return").click(function(){
		window.history.go(-1);
	}); 
});

$(function() {
	$("#name").blur(function(){
		required(this);
	});
});
		
function check(){
	//非空验证
	if($("#name").val().trim().length==0){
		checkInit($("#name"));
		$("#name").next().text("必须填写").attr("style",errorMsgColor);
		haveError = true;

		return false;
	}
  	if($("#name").val().trim().length>20){
   			checkInit($("#name"));
   			$("#name").next().text("最多输入20个字符!").attr("style",errorMsgColor);
			haveError = true;
			return false;
   		}
   		if($("#memDesc").val().trim().length>100){
   			$("#memDesc").next().text("最多输入100个字符!").attr("style",errorMsgColor);
			haveError = true;
			return false;
   		}
   		// 禁用提交按钮 防止重复提交
   		$("#addSubmint").attr("disabled","disabled");
 }
</script>
</head>
<body>
<div class="content">
	<div class="content-title">
		<label onclick="a_show()" id="label_a">
			<c:if test="${memberType.memid == null}">会员类型管理 --- 添加</c:if> 
			<c:if test="${memberType.memid != null && memberType.memid gt 0}">会员类型管理 --- 修改</c:if>    
		</label>
	</div>
	<div id="center_content">
		<div class="content_new">
			<div id="content_new_top">
				<c:if test="${memberType.memid == null}">添加会员类型</c:if> 
				<c:if test="${memberType.memid != null && memberType.memid gt 0}">修改会员类型</c:if>  
				<font color="red"><b>${msg }</b></font>
			</div>
			<form action="<%=path %>/memberType/add" onsubmit="return check()" method="post">
				<table id="table_new">
			        <tr class="table_right">
				        <td></td>
				        <td class="table_left">
					        <label id="label_prompt">
					        </label>
				        </td>
			        </tr>
					<tr class="table_right">
						<td colspan="2">
							<input name="memid" type="hidden" value="${memberType.memid }"> 
							<span></span>
						</td>
					</tr>
					<tr class="table_right">
					<td>类型名称：</td>
						<td class="table_left">
							<input id="name" name="memname" type="text" value="${memberType.memname }"  onchange="if(!isNaN(this.value)){alert('不能只输入数字');this.value='${memberType.memname }';}"/>
							<span class="red">*</span> 
							<span></span>
						</td>
					</tr>
					<tr class="table_right">
						<td>类型描述：</td>
						<td class="table_left">
							<input id="memDesc" name="memdesc" type="text" value="${memberType.memdesc }" onchange="if(!isNaN(this.value)){alert('不能只输入数字');this.value='${memberType.memdesc }';}">
							<span></span>
						</td>
					</tr>
					<tr class="table_right">
						<td>标志：</td>
						<td class="table_left">
							<select name="tag">
								<c:forEach items="${tags }" var="item">
								   <c:choose>
									   <c:when test="${item eq memberType.tag }">
										   <option value="${item }" selected>
										   <c:if test="${item eq 'T' }">有效</c:if>
										   <c:if test="${item eq 'F' }">无效</c:if>
										   </option>
									   </c:when>
									   <c:otherwise>
										   <option value="${item }">
										   <c:if test="${item eq 'T' }">有效</c:if>
										   <c:if test="${item eq 'F' }">无效</c:if>
										   </option>
									   </c:otherwise>
								   </c:choose>
							   </c:forEach>
						   </select>
					   	   <span></span>
					   </td>
				    </tr>
				    <tr>
					    <td></td>
					    <td align="left">
				    	    <input type="submit" value="确定" id="addSubmint" class="btn-inquiry">
				    	    <button type="button" id="return" class="btn-cancel">取消</button> 
					    </td>
					</tr>
		       		<tr>
			       		<td></td>
			       		<td></td>
		       		</tr>
				</table>
			</form>
		</div>
  </div>
</div>
</body>
</html>