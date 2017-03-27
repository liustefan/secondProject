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
	<title>修改单项测量审核模板</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/css/vip.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/validate.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#select1").change(function(){
				var id=this.value;
				window.location="${pageContext.request.contextPath}/measure/OrtsAction_toEditOrtsPage?rid="+id+"&id=${tempCode}";
			});
			
			var chlevel=${fn:length(singleTemplate.singleAuditDetail)};	//审核总级数
			$("#optId").change(function(){
				var id=this.value;
			  	
			  	if(chlevel>0){
		  			while(chlevel>0){
						$("#button").prev("tr").remove();
						$("#button").prev("tr").remove();
						$("#button").prev("tr").remove();
						$("#button").prev("tr").remove();
						chlevel--;
					}
		  			$("#chTagN").prop("checked",true)
					$("input:radio[name='chTag']").attr("disabled",true);
			  	}
			  	
		    	$("#button").before("<tr><td colspan='2' style='padding-left:400px;background:#faefc6;border-top:1px #ddd solid; border-bottom:1px #ddd solid;'>模板明细1</td></tr>")
					.before("<tr><td class='vi'>审核级别：</td><td>1<input type='hidden' class='vs' name='singleAuditDetail[0].auditLevel' value='1'/></td></tr>")
					.before("<tr><td class='vi'>是否允许其他组医生给审核意见：</td><td><input class='vc' type='radio' name='singleAuditDetail[0].submitOther' value='Y'/>是&nbsp&nbsp<input type='radio' class='vc' name='singleAuditDetail[0].submitOther' value='N'  checked='checked'/>否</td></tr>")
					.before("<tr><td class='vi'>标志：</td><td><input class='vc'  type='radio' name='singleAuditDetail[0].tag'  checked='checked' value='T'/>启用&nbsp&nbsp<input class='vc' type='radio' name='singleAuditDetail[0].tag' value='F' />禁用</td></tr>");
			  	
			  	chlevel = 1;
			});
			
			$("#addch").click(function(){
				if(chlevel == 0){
					$("input:radio[name='chTag']").attr("disabled",false);
					$("#chTagY").prop("checked",true)
				}
				chlevel++;
		    	$("#button").before("<tr><td colspan='2' style='padding-left:400px;background:#faefc6;border-top:1px #ddd solid; border-bottom:1px #ddd solid;'>模板明细"+ chlevel +"</td></tr>")
					.before("<tr><td class='vi'>审核级别：</td><td class='table_left'>"+chlevel+"<input class='vs' type='hidden' name='singleAuditDetail[" + (chlevel-1) + "].auditLevel' value='"+ chlevel +"'/></td></tr>")
					.before("<tr><td class='vi'>是否允许其他组医生给审核意见：</td><td class='table_left'><input class='vc' type='radio' name='singleAuditDetail[" + (chlevel-1) + "].submitOther' value='Y' style='width: 14px;height: 14px;border: 0;padding: 0;box-sizing: border-box;'/>是&nbsp&nbsp<input type='radio' class='vc' name='singleAuditDetail[" + (chlevel-1) + "].submitOther' value='N'  checked='checked' style='width: 14px;height:14px;border: 0;padding: 0;box-sizing: border-box;'/>否</td></tr>")
					.before("<tr><td class='vi'>标志：</td><td class='table_left'><input class='vc'  type='radio' name='singleAuditDetail[" + (chlevel-1) + "].tag'  checked='checked' value='T' style='width: 14px;height: 14px;border: 0;padding: 0;box-sizing: border-box;'/>启用&nbsp&nbsp<input class='vc' type='radio' name='singleAuditDetail[" + (chlevel-1) + "].tag' value='F' style='width: 14px;height: 14px;border: 0;padding: 0;box-sizing: border-box;'/>禁用</td></tr>");
			});
			
			$("#movech").click(function(){
				if(chlevel > 0){
					$("#button").prev("tr").remove();
					$("#button").prev("tr").remove();
					$("#button").prev("tr").remove();
					$("#button").prev("tr").remove();
					chlevel--;
				}
				if(chlevel === 0){
					$("#chTagN").click();
					//$("input:radio[name='chTag']").attr("disabled",true);
				}
			});
			var singleAuditDetailSize = ${fn:length(singleTemplate.singleAuditDetail)};
			if(singleAuditDetailSize ==0 ){
				$("#chTagN").prop("checked",true)	
				$("input:radio[name='chTag']").attr("disabled",true);
			}else{
				$("#chTagY").prop("checked",true);
			}
			function removeTr(){
				$("#button").prev("tr").remove();
				$("#button").prev("tr").remove();
				$("#button").prev("tr").remove();
				$("#button").prev("tr").remove();
				chlevel--;
			}
			$("input:radio[name='chTag']").click(function(){
				if(this.value === 'N'){
					while(chlevel > 0){
						removeTr();
					}
					n = 1;
				}else if(chlevel == 0){
					$("#addch").click();
				}
			});	
			
		  	$("#return").click(function(){
				window.history.go(-1);
          	}); 
	          
           $("#name").blur(function(){
				required(this);
				var templateNmae = '${singleTemplate.tempName}';
				var name=$("#name").val().trim();
				if(templateNmae == name){
					return true;
				}
				if($("#name").val().trim().length==0){
						checkInit($("#name"));
						$("#name").next().text("必须填写").attr("style",errorMsgColor);
						$("#name").focus();
						return false;
				}
				if($("#name").val().length>20){
						checkInit($("#name"));
						$("#name").next().text("对不起，模板名称长度不能超过20个字符！").attr("style",errorMsgColor);
						$("#name").focus();
						return false;
				}
				
				var url="${pageContext.request.contextPath}/template/validateSingleTemplateName";
				
				   $.ajax({  
				         type : "get",  
				         url : url,  
				         data : "templateName=" + name,  
				         async : true,  
				         success : function(data){  
					  			var flag=data;
					  			if(flag != 'OK'){
					  				checkInit($("#name"));
									$("#name").next().text("对不起，模板名称不能重复！").attr("style",errorMsgColor);
									$("#name").focus();
									f = false;
					  			}
				         }  
				    }); 
			 });
          	//光标离开时验证最少记录天数
           	$("#minDisDay").blur(function(){
	           	if($("#minDisDay").val().trim().length==0){
	      			checkInit($("#minDisDay"));
	      			$("#minDisDay").next().text("必须填写").attr("style",errorMsgColor);
	      			haveError = true;
	      			return false;
	      		}else{
             		$("#minDisDay").next().text("").attr("style",errorMsgColor);
	      			haveError =false;
	      	    }
	           	
	           	var val = $("#minDisDay").val().trim();
	      		var reg = /^([1-9]\d*)$/;
	      	 	if(!reg.test(val)){
	      			$("#minDisDay").next().text("必须为正整数").attr("style",errorMsgColor);
	      			return false;
	      		}
	      		//最大值与数据库保持一致
	      		if($("#minDisDay").val()>32767){
	      			checkInit($("#minDisDay"));
	      			$("#minDisDay").next().text("请输入一个[0,32767]之间的正整数！").attr("style",errorMsgColor);
	      			haveError = true;
	      			return false;
	      		}else{
	      		       $("#minDisDay").next().text("").attr("style",errorMsgColor);
	      				haveError =false;
	      		    } 
	      	  });   	
          	
           	//光标离开时验证报告周期
           	$("#maxCycle").blur(function(){
	           	if($("#maxCycle").val().trim().length==0){
	      			checkInit($("#maxCycle"));
	      			$("#maxCycle").next().text("必须填写").attr("style",errorMsgColor);
	      			haveError = true;
	      			return false;
	      		}else{
            		$("#maxCycle").next().text("").attr("style",errorMsgColor);
	      			haveError =false;
	      	    }
	           	
	           	var val = $("#maxCycle").val().trim();
	      		var reg = /^([1-9]\d*)$/;
	      	 	if(!reg.test(val)){
	      			$("#maxCycle").next().text("必须为正整数").attr("style",errorMsgColor);
	      			return false;
	      		}
	      		//最大值与数据库保持一致
	      		if($("#maxCycle").val()>32767){
	      			checkInit($("#maxCycle"));
	      			$("#maxCycle").next().text("请输入一个[0,32767]之间的正整数！").attr("style",errorMsgColor);
	      			haveError = true;
	      			return false;
	      		}else{
	      		       $("#maxCycle").next().text("").attr("style",errorMsgColor);
	      				haveError =false;
	      		    } 
	      	  });   	
		  });

	   	function check(){
			//非空验证
			if ($("#optId").val()=="0"){
				checkInit($("#optId"));
				$("#optId").next().text("对不起，请选择测量选项").attr("style",errorMsgColor);
				$("#optId").focus();
			    return false;
			}
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
						$("#name").next().text("对不起，模板名称长度不能超过20个字符！").attr("style",errorMsgColor);
						haveError = true;
						$("#name").focus();
						return false;
		    }
		   var templateNmae = '${singleTemplate.tempName}';
		   var name=$("#name").val().trim();
		   var url="${pageContext.request.contextPath}/template/validateSingleTemplateName";
		   var f = true;
		   if(templateNmae != name){
			   $.ajax({  
			         type : "get",  
			         url : url,  
			         data : "templateName=" + name,  
			         async : true,  
			         success : function(data){  
				  			var flag=data;
				  			if(flag != 'OK'){
				  				checkInit($("#name"));
								$("#name").next().text("对不起，模板名称不能重复！").attr("style",errorMsgColor);
								$("#name").focus();
								f = false;
				  			}
			         }  
			    });  
		   }
		   
	  		if(!f){
	  			return false;
	  		}
	  			
	  		//表单提交时验证最少记录天数	
  			if($("#minDisDay").val().trim().length==0){
				checkInit($("#minDisDay"));
				$("#minDisDay").next().text("必须填写").attr("style",errorMsgColor);
				haveError = true;
				$("#minDisDay").focus();
				return false;
			}else{
			       $("#minDisDay").next().text("").attr("style",errorMsgColor);
					haveError =false;
		    }
				
			var val = $("#minDisDay").val().trim();
			var reg = /^([1-9]\d*)$/;
			 if(!reg.test(val)){
				$("#minDisDay").next().text("必须为正整数").attr("style",errorMsgColor);
				return false;
			}
			//最大值与数据库保持一致
			if($("#minDisDay").val()>32767){
				checkInit($("#minDisDay"));
				$("#minDisDay").next().text("请输入一个[0,32767]之间的正整数！").attr("style",errorMsgColor);
				haveError = true;
				$("#minDisDay").focus();
				return false;
			}else{
			       $("#minDisDay").next().text("").attr("style",errorMsgColor);
					haveError =false;
		    }
			
			//表单提交时验证报告周期
			if($("#maxCycle").val().trim().length==0){
				checkInit($("#maxCycle"));
				$("#maxCycle").next().text("必须填写").attr("style",errorMsgColor);
				haveError = true;
				$("#maxCycle").focus();
				return false;
			}else{
				$("#maxCycle").next().text("").attr("style",errorMsgColor);
				haveError =false;
		    }
				
			var val = $("#maxCycle").val().trim();
			var reg = /^([1-9]\d*)$/;
			 if(!reg.test(val)){
				$("#maxCycle").next().text("必须为正整数").attr("style",errorMsgColor);
				return false;
			}
			//最大值与数据库保持一致
			if($("#maxCycle").val()>32767){
				checkInit($("#maxCycle"));
				$("#maxCycle").next().text("请输入一个[0,32767]之间的正整数！").attr("style",errorMsgColor);
				haveError = true;
				$("#maxCycle").focus();
				return false;
			}else{
		       	$("#maxCycle").next().text("").attr("style",errorMsgColor);
			   	haveError =false;
		    }
				
			if(new Number($("#maxCycle").val()) < new Number($("#minDisDay").val())) {
				checkInit($("#maxCycle"));
				$("#maxCycle").next().text("报告周期不能小于最少记录天数").attr("style",errorMsgColor);
				haveError = true;
				$("#maxCycle").focus();
				return false;
			}else{
		       	$("#maxCycle").next().text("").attr("style",errorMsgColor);
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
	修改单项测量审核模板
	</div>
	<form action="../template/saveOrUpdateSingleTemplate" onsubmit="return check()" method="post">
		<input name="tempCode" type="hidden" value="${singleTemplate.tempCode }" />
		<input name="funId" type="hidden" value="1" />
		<input name="optId" type="hidden" value="${singleTemplate.optId}" />
	  <table cellpadding="0" cellspacing="0" class="vv" align="center" width="60%">
	    <tr>
	       <td width="30%"></td>
	       <td></td>
	    </tr>
		<tr>
			<td class="vi">模板名称：</td>
			<td><input id="name" readonly="readonly" value="${singleTemplate.tempName}" class="vs"/>&nbsp;<span></span></td>
		</tr>
		<tr>
			<td class="vi">测量类型：</td>
			<td>
				<select id="optId" name="optId" disabled="disabled">
						<option value='0'>请选择</option>
						<c:if test="${!empty optionList}">
							<c:forEach var="item" items="${optionList}" varStatus="templateSt">
								<option value="${item.optId}"   <c:if test="${item.optId ==singleTemplate.optId}">selected="selected" </c:if> >${item.optName}</option>
							</c:forEach>  
						</c:if>
				</select>
			</td>
		</tr>
		<tr>
			<td class="vi">设置说明：</td>
			<td><input maxlength="100" name="setDesc" value="${singleTemplate.setDesc }" class="vs"/></td>
		</tr>
		<tr>
			<td class="vi">最少记录天数：</td>
			<td>
			<input maxlength="5" name="minDisDay" id="minDisDay" value="${singleTemplate.minDisDay }" class="vs" onchange="if(isNaN(this.value)){alert('只能输入数字');this.value='';}" />&nbsp;<span style="color:red">*</span>
			</td>
		</tr>
			<tr>
			<td class="vi">报告周期：</td>
			<td><input maxlength="5" id="maxCycle" name="maxCycle" value="${singleTemplate.maxCycle}" type="text" class="vs" onchange="if(isNaN(this.value)){alert('只能输入数字');this.value='';}" />天<span style="color:red">*</span>
			</td>
		</tr>
		<tr>
			<td class="vi">医生审核后才能发报告：</td>
			<td>
				<input type="radio" id= "chTagN" name="chTag" value="N"  checked />否
				<input type="radio" id= "chTagY" name="chTag" value="Y"/>是
			</td>
		</tr>
		 <c:forEach var="item" items="${singleTemplate.singleAuditDetail}" varStatus="status">
			<tr>
				<td colspan='2' style="padding-left:400px;background:#faefc6;  border-top:1px #ddd solid; border-bottom:1px #ddd solid;">模板明细${status.index+1}</td>
			</tr>
			<tr>
				<td class="vi">审核级别：</td>
				<td>
					${item.auditLevel}
					<input type="hidden"  name="singleAuditDetail[${status.index }].auditLevel" value="${item.auditLevel}" class="vs"/>
				</td>
			</tr>
			<tr>
				<td class="vi">是否允许其他组医生给审核意见：</td>
				<td>
					<input type="radio" name="singleAuditDetail[${status.index }].submitOther"  value="Y" <c:if test="${item.submitOther eq 'Y'}">checked</c:if> class="vc"/>是&nbsp;&nbsp;
					<input type="radio" name="singleAuditDetail[${status.index }].submitOther" value="N"  <c:if test="${item.submitOther eq 'N'}">checked</c:if> class="vc"/>否
				</td>
			</tr>
			<tr>
				<td class="vi">标记：</td>
				<td>
					<input type="radio" name="singleAuditDetail[${status.index }].tag"  value="T"  <c:if test="${item.tag eq 'T'}">checked</c:if> class="vc"/>启用&nbsp;&nbsp;
					<input type="radio" name="singleAuditDetail[${status.index }].tag" value="F" <c:if test="${item.tag eq 'F'}">checked</c:if> class="vc"/>禁用
				</td>
			</tr>
		</c:forEach>  
		<tr id="button">
		    <td></td>
			<td align="left">
			    <input type="submit" value="提交" id="addSubmint" class="btn-normal"/>
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
