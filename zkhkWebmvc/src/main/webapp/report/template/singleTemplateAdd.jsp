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
	<title>添加单项测量审核模板</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/css/common.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/validate.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#return").click(function(){
				window.history.go(-1);
				return false;
			}); 
			
			$("#select1").change(function(){
				var id=this.value;
				window.location="${pageContext.request.contextPath}/measure/OrtsAction_toAddOrtsPage?id="+id;
			});
			
			/*****************************************************************************/
			var chlevel=0;
			var n=1;
			$("#optId").change(function(){
				while(chlevel>0){
					$("#button").prev("tr").remove();
					$("#button").prev("tr").remove();
					$("#button").prev("tr").remove();
					$("#button").prev("tr").remove();
					chlevel--;
					n--;
				}
				var id = this.value;	//选项代码
				if(id > 0){
					$("#addch").css("display", "");
					$("#movech").css("display", "");
					$("#chTagN").prop("checked",true)	
					$("input:radio[name='chTag']").attr("disabled",true);
				}else{
					$("#addch").css("display", "none");
					$("#movech").css("display", "none");
				}
			});
			
			$("#addch").click(function(){
				if(chlevel == 0){
					$("#chTagY").prop("checked",true)
					$("input:radio[name='chTag']").attr("disabled",false);
				}
				chlevel++;
		    	$("#button").before("<tr><td colspan='2' align='center' style='padding-left:400px;background:#faefc6;border-top:1px #ddd solid; border-bottom:1px #ddd solid;'>模板明细"+n+"</td></tr>")
					.before("<tr class='table_right'><td>审核级别：</td><td class='table_left'>"+n+"<input class='vs' type='hidden' name='singleAuditDetail[" + (n-1) + "].auditLevel' value='"+n+"'/></td></tr>")
					.before("<tr class='table_right'><td>是否允许其他组医生给审核意见：</td><td class='table_left'><input class='vc' type='radio' name='singleAuditDetail[" + (n-1) + "].submitOther' value='Y' style='width: 14px;height: 14px;border: 0;padding: 0;box-sizing: border-box;'/>是&nbsp&nbsp<input type='radio' class='vc' name='singleAuditDetail[" + (n-1) + "].submitOther' value='N'  checked='checked' style='width: 14px;height:14px;border: 0;padding: 0;box-sizing: border-box;'/>否</td></tr>")
					.before("<tr class='table_right'><td>标志：</td><td class='table_left'><input class='vc'  type='radio' name='singleAuditDetail[" + (n-1) + "].tag'  checked='checked' value='T' style='width: 14px;height: 14px;border: 0;padding: 0;box-sizing: border-box;'/>启用&nbsp&nbsp<input class='vc' type='radio' name='singleAuditDetail[" + (n-1) + "].tag' value='F' style='width: 14px;height: 14px;border: 0;padding: 0;box-sizing: border-box;'/>禁用</td></tr>");
				n++;
			});
			
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
			
			$("#movech").click(function(){
				if(chlevel > 0){
					$("#button").prev("tr").remove();
					$("#button").prev("tr").remove();
					$("#button").prev("tr").remove();
					$("#button").prev("tr").remove();
					chlevel--;
					n--;
				}
				if(chlevel == 0){
					$("#chTagN").prop("checked",true)
					$("input:radio[name='chTag']").attr("disabled",true);
				}
			});
			
			$("#chTagN").prop("checked",true)	
			$("input:radio[name='chTag']").attr("disabled",true);

		    $("#optId").blur(function(){
				required(this);				
			});
				
			$("#name").blur(function(){
				required(this);
				if($("#name").val().trim().length==0){
						checkInit($("#name"));
						$("#name").next().text("必须填写").attr("style",errorMsgColor);
						$("#name").focus();
						return false;
				}
				if($("#name").val().trim().length>20){
						checkInit($("#name"));
						$("#name").next().text("对不起，模板名称长度不能超过20个字符！").attr("style",errorMsgColor);
						$("#name").focus();
						return false;
				}
					
				var name=$("#name").val().trim();
				var url="${pageContext.request.contextPath}/template/validateSingleTemplateName";
		/* 	  		
			  		$.getJSON(url,function(data){
			  			var flag=data;
			  			if(flag!=null){
			  				checkInit($("#name"));
							$("#name").next().text("对不起，模板名称不能重复！").attr("style",errorMsgColor);
							$("#name").focus();
			  				return false;
			  			}
				   }); */
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
					haveError = true;
					$("#optId").focus();
				    return false;
				}
				if($("#name").val().trim().length==0){
					checkInit($("#name"));
					$("#name").next().text("必须填写").attr("style",errorMsgColor);
					haveError = true;
					$("#name").focus();
					return false;
				}
				
	   	       if($("#name").val().trim().length>20){
						checkInit($("#name"));
						$("#name").next().text("对不起，模板名称长度不能超过20个字符！").attr("style",errorMsgColor);
						$("#name").focus();
						return false;
				}
				
				var name=$("#name").val().trim();
				var url="${pageContext.request.contextPath}/template/validateSingleTemplateName";
				var f = true;
			   	$.ajax({  
			         type : "post",  
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
			   	
		  		if(!f) {
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
	<div class="content-title">添加单项测量审核模板&nbsp;<span style="font-size: 14px;color:red;font-weight:bold;">(以下有 "*" 的为必填项)</span></div>	
	<form action="../template/saveOrUpdateSingleTemplate" onsubmit="return check();" method="post">
		<input name="funId" type="hidden" value="1" />
		<table cellpadding="0" cellspacing="0" id="table_new">
			<tr class="table_right"><td></td><td class="table_left"><label id="label_prompt"></label></td></tr>
		
			<tr class="table_right">
				<td>模板名称：</td>
				<td class="table_left">
					<input id="name" name="tempName"  type="text"  class="vs"/>
					<span class="red">*</span>
				</td>
			</tr>
			<tr class="table_right">
				<td>测量类型：</td>
				<td class="table_left">
					<select id="optId" name="optId">
							<option value='0'>请选择</option>
							<c:if test="${!empty optionList}">
							<c:forEach var="item" items="${optionList}" varStatus="templateSt">
								<option value="${item.optId}" >${item.optName}</option>
							</c:forEach>  
						</c:if>
				</select>
				<span class="red">*</span>
				<!-- <s:select id="optId" name="optId" list="getOptNameList(1)" headerKey="0" headerValue="请选择" theme="simple" ></s:select> -->
					
				</td>
			</tr>
			<tr class="table_right">
				<td>设置说明：</td>
				<td class="table_left">
					<input maxlength="100" name="setDesc" type="text" class="vs"/>
				</td>
			</tr>
<%--		<tr class="table_right">--%>
<%--			<td>最少记录天数：</td>--%>
<%--			<td class="table_left"><input id="minRecords" name="minRecords"  type="text" class="vs" onchange="if(isNaN(this.value)){alert('只能输入数字');this.value='';}"/>--%>
<%--			<span style="color:red">*</span>--%>
<%--			</td>--%>
<%--		</tr>--%>
			<tr class="table_right">
				<td>最少记录天数：</td>
				<td class="table_left">
					<input maxlength="5" id="minDisDay" name="minDisDay" type="text" class="vs" onchange="if(isNaN(this.value)){alert('只能输入数字');this.value='';}"/>
					<span class="red">*</span>
				</td>
			</tr>
			<tr class="table_right">
				<td>报告周期：</td>
				<td class="table_left">
					<input maxlength="5" id="maxCycle" name="maxCycle" type="text" class="vs" onchange="if(isNaN(this.value)){alert('只能输入数字');this.value='';}"/>天
					<span class="red">*</span>
				</td>
			</tr>
<%--		<tr class="table_right">--%>
<%--			<td>最大间隔天数：</td>--%>
<%--			<td class="table_left"><input id="maxMumDay" name="maxMumDay"  type="text" class="vs" onchange="if(isNaN(this.value)){alert('只能输入数字');this.value='';}"/>--%>
<%--			<span style="color:red">*</span>--%>
<%--			</td>--%>
<%--		</tr>--%>
<%--		<tr class="table_right">--%>
<%--			<td>连续超过：</td>--%>
<%--			<td class="table_left">--%>
<%--			<input id="maxMumDay" name="maxMumDay"  type="text" class="vs" onchange="if(isNaN(this.value)){alert('只能输入数字');this.value='';}"/>--%>
<%--			天无测量数据则需要重新测量--%>
<%--			<span style="color:red">*</span>--%>
<%--			<i style=" display:block;font-size:12px;font-style:normal;color:#676767;position:relative;">超过该规定天数未测量将影响医生判断，无法出具准确的健康报告</i>--%>
<%--			</td>--%>
<%--		</tr>--%>
		
			<tr class="table_right">
				<td>医生审核后才能发报告：</td>
				<td style="text-align: left;">
					<input type="radio" id= "chTagN" name="chTag" value="N"  checked />否
					<input type="radio" id= "chTagY" name="chTag" value="Y"/>是
					<!-- <s:radio list="tags()" name="chTag"  theme="simple"  cssClass="vc"></s:radio> -->
				</td>
			</tr>
		
			<tr id="button">
			    <td></td>
				<td align="left">
			       	<input type="submit" value="提交" id="addSubmint" class="btn-normal"/>
			       	<input type="reset" value="重置" class="btn-normal"/>
			       	<button type="button" id="return" class="btn-normal">返回</button>
			       	<button type="button" id="addch" class="btn-normal" style="display: none;">增加审核级别</button>
			       	<button type="button" id="movech" class="btn-normal" style="display: none;">移除审核级别</button>
			       	<!-- button默认的type是button，而其他浏览器和W3C标准中button默认的属性都是submit -->
			   </td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>
