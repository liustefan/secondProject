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
	<title>添加汇总测量审核模板</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/css/common.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/validate.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#name").blur(function(){
				required(this);
				var name=$("#name").val().trim();
				if($("#name").val().trim().length>20){
					checkInit($("#name"));
					$("#name").next().text("模板名称长度不能超过20个字符！").attr("style",errorMsgColor);
					$("#name").focus();
					return false;
				}
				var url="${pageContext.request.contextPath}/template/validateSumTemplateName";
			  	
			    $.ajax({  
			         type : "post",  
			         url : url,  
			         data : "templateName=" + name,  
			         async : true,  
			         success : function(data){  
			  			 var flag=data;
			  			 if(flag != 'OK' ){
			  				 checkInit($("#name"));
							 $("#name").next().text("对不起，模板名称不能重复！").attr("style",errorMsgColor);
							 $("#name").focus();
			  				 return false;
			  			 }
			         }  
			    });  
			});
			
			$("#return").click(function(){
				  window.history.go(-1);
			});
			
			var chlevel = 0;
			$("#chTag").attr("disabled",true);
			$("#addch").click(function(){
				if(chlevel == 0){
					$("#chTag").attr("disabled",false);
					$("#chTag_temp").attr("disabled",true);
					$("#chTag").val("Y");
				}
				chlevel++;
				var t1 = "<tr><td colspan='2' align='center' bgcolor='#faefc6' style='border-top:1px #ddd solid; border-bottom:1px #ddd solid;'>模板明细" + chlevel+ "</td></tr>";
				var t2 = "<tr class='table_right'><td>审核级别：</td><td  class='table_left'>" + chlevel + "<input type='hidden' name='summaryAuditDetail[" + (chlevel-1) + "].auditLevel' value='"+ chlevel +"'/></td></tr>";
	<%--			var t3 = "<tr class='table_right'><td>是否提交其它组：</td><td  class='table_left'>"--%>
	<%--						+ "<input type='radio' name='summaryAuditDetail[" + (chlevel-1) + "].submitOther' value='Y' style='width: 13px;height: 13px;border: 0;padding: 0;box-sizing: border-box;' />是&nbsp;&nbsp;"--%>
	<%--						+ "<input type='radio' name='summaryAuditDetail[" + (chlevel-1) + "].submitOther' checked='checked' value='N' style='width: 13px;height: 13px;border: 0;padding: 0;box-sizing: border-box;' />否"--%>
	<%--						+ "</td></tr>";--%>
		    	$("#button").before(t1).before(t2);
			});
			
			$("#movech").click(function(){
				if(chlevel > 0){
					$("#button").prev("tr").remove();
					$("#button").prev("tr").remove();
					chlevel--;
				}
				if(chlevel == 0){
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
	  		var f = true;
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
	<div class="content-title">添加汇总测量审核模板</div>
	<form action="../template/saveOrUpdateSummaryTemplate" onsubmit="return check()" method="post">
		<table cellpadding="0" cellspacing="0" id="table_new">
			<tr class="table_right">
			<td></td>
			<td class="table_left"><label id="label_prompt"></label></td>
			</tr>
			<tr class="table_right">
				<td width="30%">模板名称：</td>
				<td class="table_left">
					<input id="name"  name="tempName" value="${tempName }" type="text" class="vs"/>
					<span class="red">*</span>
				</td>
			</tr>
			<tr class="table_right">
				<td>最大间隔天数：</td>
				<td class="table_left">
				<input maxlength="5" id="maxMumDay" name="maxMumDay" type="text" class="vs"onchange="if(isNaN(this.value)){alert('只能输入数字');this.value='';}"/>
				<span class="red">*</span>
				</td>
			</tr>
			<tr class="table_right">
				<td>是否审核：</td>
				<td class="table_left">
				    <select id="chTag" name="chTag" >
				    	<option value="N" selected="selected" >否</option>
				    	<option value="Y" >是</option>
				    </select>
				    <input id="chTag_temp" type="hidden" name="chTag" value="N">
			    </td>
			</tr>
			<tr id="button">
			    <td></td>
				<td align="left">
			       	<input type="submit" value="提交" id="addSubmint" class="btn-normal">
			       	<input type="reset" value="重置" class="btn-normal">
			       	<button type="button" id="return" class="btn-normal">返回</button>
			       	<button type="button" id="addch" class="btn-normal" >增加审核级别</button>
			       	<button type="button" id="movech" class="btn-normal" >移除审核级别</button>
			   </td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>
