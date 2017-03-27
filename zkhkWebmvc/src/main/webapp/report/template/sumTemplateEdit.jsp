<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>修改汇总测量审核模板</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/css/vip.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/validate.js"></script>
	<script type="text/javascript">
		$(function(){
			var chlevel = ${sumTemplate.summaryAuditDetail == null ? 0 : fn:length(sumTemplate.summaryAuditDetail)};
			if(chlevel == 0) {
				$("#chTag").attr("disabled",true);
				$("#chTag").val("N");
				$("#chTag_temp").attr("disabled",false);
			}else{
				$("#chTagY").attr("selected",true);
			}
			$("#addch").click(function(){
				if(chlevel == 0){
					$("#chTag").attr("disabled",false);
					$("#chTag").val("Y");
					$("#chTag_temp").attr("disabled",true);
				}
				chlevel++;
				var t1 = "<tr><td colspan='2' style='padding-left:400px;background:#faefc5;border-top:1px #ddd solid; border-bottom:1px #ddd solid;'>模板明细" + chlevel+ "</td></tr>";
				var t2 = "<tr class='vi'><td>审核级别：</td><td align='left'>" + chlevel + "<input type='hidden' name='summaryAuditDetail[" + (chlevel-1) + "].auditLevel' value='"+ chlevel +"'/></td></tr>";
		    	$("#button").before(t1).before(t2);
			});
			
			$("#movech").click(function(){
				if(chlevel > 0){
					$("#button").prev("tr").remove();
					$("#button").prev("tr").remove();
					chlevel--;
				}
				if(chlevel === 0){
					$("#chTag").val("N");
					$("#chTag").attr("disabled",true);
					$("#chTag_temp").attr("disabled",false);
				}
			});
			
			function removeTr(){
				$("#button").prev("tr").remove();
				$("#button").prev("tr").remove();
				chlevel--;
			}
			
			$("#chTag").change(function(){
				if(this.value === 'N'){
					while(chlevel > 0){
						removeTr();
					}
				}else if(chlevel == 0){
					$("#addch").click();
				}
			});
			
			$("#return").click(function(){
				window.history.go(-1);
			}); 
			
	        $("#name").blur(function(){
					required(this);
					if($("#name").val().trim().length>20){
							checkInit($("#name"));
							$("#name").next().text("模板名称长度不能超过20个字符！").attr("style",errorMsgColor);
							$("#name").focus();
							return false;
					}
					var name=$("#name").val();
					var sumTemplateName="${sumTemplate.tempName}";
					var url="${pageContext.request.contextPath}/template/validateSumTemplateName";
					if(name != sumTemplateName){
					    $.ajax({  
					         type : "post",  
					         url : url,  
					         data : "templateName=" + name,  
					         async : false,  
					         success : function(data){  
						  			var flag=data;
						  			if(flag!="OK"){
						  				checkInit($("#name"));
										$("#name").next().text("模板名称不能重复！").attr("style",errorMsgColor);
										$("#name").focus();
										f = false;
						  			}
					         }  
					     }); 
					}
				});
				
	        	//光标离开时验证最大间隔天数
			  	$("#maxMumDay").blur(function(){
			     	if($("#maxMumDay").val().trim().length==0){
						checkInit($("#maxMumDay"));
						$("#maxMumDay").next().text("必须填写").attr("style",errorMsgColor);
						haveError = true;
						return false;
					}else{
			       		$("#maxMumDay").next().text("").attr("style",errorMsgColor);
						haveError =false;
				    }
			     	
			     	var val = $("#maxMumDay").val().trim();
					var reg = /^([1-9]\d*)$/;
				 	if(!reg.test(val)){
						$("#maxMumDay").next().text("必须为正整数").attr("style",errorMsgColor);
						return false;
					}
					//最大值与数据库保持一致
					if($("#maxMumDay").val()>32767){
						checkInit($("#maxMumDay"));
						$("#maxMumDay").next().text("请输入一个[0,32767]之间的正整数！").attr("style",errorMsgColor);
						haveError = true;
						return false;
					}else{
					       $("#maxMumDay").next().text("").attr("style",errorMsgColor);
							haveError =false;
				    } 
			  	});
			});
		
			function check(){
				//非空验证
				if($("#name").val().trim().length==0){
					checkInit($("#name"));
					$("#name").next().text("必须填写").attr("style",errorMsgColor);
					haveError = true;
					$("#name").focus();
					return false;
				}else{
				       $("#name").next().text("").attr("style",errorMsgColor);
						haveError =false;
			    	}
				if($("#name").val().trim().length>20){
							checkInit($("#name"));
							$("#name").next().text("模板名称长度不能超过20个字符！").attr("style",errorMsgColor);
							$("#name").focus();
							return false;
			   }
				
			    var name=$("#name").val().trim();
			    var sumTemplateName="${sumTemplate.tempName}";
		  		var f = true;
		  		if(name != sumTemplateName ){
					var url="${pageContext.request.contextPath}/template/validateSumTemplateName";
				    $.ajax({  
				         type : "post",  
				         url : url,  
				         data : "templateName=" + name,  
				         async : false,  
				         success : function(data){  
					  			var flag=data;
					  			if(flag!="OK"){
					  				checkInit($("#name"));
									$("#name").next().text("模板名称不能重复！").attr("style",errorMsgColor);
									$("#name").focus();
									f = false;
					  			}
				         }  
				     }); 
		  		}
			   
				if(!f){
					return false;
				}
				
				//表单提交时验证最大间隔天数
				if($("#maxMumDay").val().trim().length==0){
					checkInit($("#maxMumDay"));
					$("#maxMumDay").next().text("必须填写").attr("style",errorMsgColor);
					haveError = true;
					$("#maxMumDay").focus();
					return false;
				}else{
				       $("#maxMumDay").next().text("").attr("style",errorMsgColor);
						haveError =false;
			    }
				
				var val = $("#maxMumDay").val().trim();
				var reg = /^([1-9]\d*)$/;
				 if(!reg.test(val)){
					$("#maxMumDay").next().text("必须为正整数").attr("style",errorMsgColor);
					return false;
				}
				//最大值与数据库保持一致
				if($("#maxMumDay").val()>32767){
					checkInit($("#maxMumDay"));
					$("#maxMumDay").next().text("请输入一个[0,32767]之间的正整数！").attr("style",errorMsgColor);
					haveError = true;
					$("#maxMumDay").focus();
					return false;
				}else{
				       $("#maxMumDay").next().text("").attr("style",errorMsgColor);
						haveError =false;
			    }

				// 将提交按钮禁用避免重复提交表单
				$("#addSubmint").attr("disabled", "disabled");
			}
	</script>
</head>
<body>
<div class="content">
	<div class="content-title">
	    修改汇总测量审核模板
	</div>
	<form action="../template/saveOrUpdateSummaryTemplate" onsubmit="return check()"  method="post">
		<input type="hidden" name="sumRepTempCode" value="${sumTemplate.sumRepTempCode }" class="vs"/>
		<table cellpadding="0" cellspacing="0" class="vv" align="center">
	    <tr>
	       <td colspan="2"></td>
	    </tr>
		<tr>
			<td class="vi" width="30%">模板名称</td>
			<td><input id="name" name="tempName" value="${sumTemplate.tempName }" class="vs"/><span class="red">*</span></td>
		</tr>
		<tr>
			<td class="vi">最大间隔天数</td>
			<td><input maxlength="5" name="maxMumDay" id="maxMumDay" value="${sumTemplate.maxMumDay }" class="vs" onchange="if(isNaN(this.value)){alert('只能输入数字');this.value='';}"/><span class="red">*</span></td>
		</tr>
		<tr>
			<td class="vi">是否审核</td>
			<td>
				<select id="chTag" name="chTag" >
			    	<option id="chTagN" value="N" selected="selected" >否</option>
			    	<option id="chTagY" value="Y" >是</option>
			    </select>
			</td>
		</tr>
		<c:forEach var="item" items="${sumTemplate.summaryAuditDetail}" varStatus="status">
			<tr>
				<td colspan='2' style="padding-left:400px;background:#faefc5;border-top:1px solid #ddd; border-bottom:1px solid #ddd;">模板明细${status.index +1 }</td>
			</tr>
			<tr>
				<td class="vi">审核级别</td>
				<td>${item.auditLevel }<input type="hidden" name="summaryAuditDetail[${status.index}].auditLevel" value="${item.auditLevel }" class="vs"/></td>
			</tr>
		</c:forEach> 
		
		<tr id="button">
		    <td></td>
			<td align="left">
			    <input type="submit" id="addSubmint" value="提交" class="btn-normal"/>
				<button type="button" id="return" class="btn-normal">返回</button>
				<button type="button" id="addch" class="btn-normal">增加审核级别</button>
		       	<button type="button" id="movech" class="btn-normal">移除审核级别</button>
			</td>
		</tr>
	  </table>
	</form>
</div>
</body>
</html>