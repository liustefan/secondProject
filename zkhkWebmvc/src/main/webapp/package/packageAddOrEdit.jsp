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
	<title>测量套餐编辑</title>
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/general.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/editopsp.css">
	
	<script src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script src="<%=path %>/js/calendar.js"></script>
	<script src="<%=path %>/js/validate.js"></script>

	<script type="text/javascript">
		$(function(){
			var listN = $("#count").val();
			for(var i = listN-1; i >= 0; i--){
				var type = $('input[name="packagDetailList['+ i +'].calcType"]:checked').val();
				if(type == 'T') {
					$('input[name = "packagDetailList['+ i +'].numTimes"]').attr('readOnly', true);
				}else {
					$('input[name = "packagDetailList['+ i +'].numDay"]').attr('readOnly', true);
				}
			}
			//  页面加载的时候，页面效果
			// ----------------  start -------------------
			var type = $('input[name="packagDetailList[0].calcType"]:checked').val();
			var count=$("#count").val(),n=1;
			
			if(type == 'T') {
				$("input[name = 'packagDetailList[0].numTimes']").attr('readOnly', true);
			}else {
				$("input[name = 'packagDetailList[0].numDay']").attr('readOnly', true);
			}
			// ----------------  end -------------------
			
			 if(count>0){
			 	n=count;
			 	count--;
			 }
			 
			$("#detail").click(function(){
				var option=$("#option").val();
				count++;
				n++;
				$("#button").before("<tr><td colspan='6'><h3>套餐明细"+"<span class='num'>"+n+"<span></h3></td></tr>"+
									"<tr><td colspan='6' class='table_new_table'>"+
									"<table style='width:100%;'>"+
									"<tr><td class='table_new_title' width='13%' align='right'><span class='red'>*</span>汇总模板：</td>"+
									"<td class='table_new_textipt' width='20%'><select id='select"+n+"' name='packagDetailList["+count+"].sumRepTempCode' onchange='select(this)'>"+option+"</select><span></span></td>"+
									"<td class='table_new_title' width='13%' align='right'>计算类型：</td>"+
									"<td class='table_new_textipt' width='20%'><input type='radio' name='packagDetailList["+count+"].calcType' value='T' checked='checked'/>计时"+
					 				"<input class='mar-left' type='radio' name='packagDetailList["+count+"].calcType' value='C'/>计次</td>"+
					 				"<td class='table_new_title' width='13%' align='right'>次数:</td>"+
					 				"<td class='table_new_textipt'><input name='packagDetailList["+count+"].numTimes' type='text' class='table_new_input' onchange='if(isNaN(this.value)){alert(\"只能输入数字\");this.value=\"\";return false;}if(this.value<=0){alert(\"必须大于0！\");this.value=\"\";return false;}'/>&nbsp;次</td></tr>"+
									"<tr><td class='table_new_title' align='right'>周期：</td>"+
									"<td class='table_new_textipt'><input name='packagDetailList["+count+"].numDay' type='text' class='table_new_input' onchange='if(isNaN(this.value)){alert(\"只能输入数字\");this.value=\"\";return false;}if(this.value<=0){alert(\"必须大于0！\");this.value=\"\";return false;}'/>&nbsp;天"+
									"<input name='packagDetailList["+count+"].createid' type='hidden' value='${sessionScope.userInfo.id }' class='table_new_input'/></td>"+
									"<td class='table_new_title'></td>"+
									"<td class='table_new_textipt'></td></tr>"+
									"</table></tr></td></tr>");
				document.getElementById("count").value = count;
				
				var type2 = $('input[name="packagDetailList['+ count +'].calcType"]:checked').val();
				if(type2 == 'T') {
					$('input[name = "packagDetailList['+ count +'].numTimes"]').prop('readOnly', true);
					$('input[name = "packagDetailList['+ count +'].numDay"]').prop('readOnly', false);
				}else {
					$('input[name = "packagDetailList['+ count +'].numDay"]').prop('readOnly', true);
					$('input[name = "packagDetailList['+ count +'].numTimes"]').prop('readOnly', false);
				}
				
				$('input[type="radio"]').click(function(){
					var $this = this;
					var c1 = $('input[type="text"]:eq(0)', $(this).parents('tbody')[0]);
					var t1 = $('input[type="text"]:eq(1)', $(this).parents('tbody')[0]);
					if($this.value == 'T'){
						c1.val('');
						c1.prop('readOnly', true);
						t1.prop('readOnly', false);
					}else{
						t1.val('');
						t1.prop('readOnly', true);
						c1.prop('readOnly', false);
					}
				});
				
				return false;
			});
			
			$("#remove").click(function(){
				if(count==0){
					alert("对不起，必须保留一个明细！");
					return false;
				}
				n--;
				count--;
				$("#button").prev("tr").remove();
				$("#button").prev("tr").remove();
				document.getElementById("count").value = count;
				return false;
			});
			function checkUnique(){
				var originalName = "${packag.packageName}";
	
				var obj = document.getElementById("name");
				var flag = false;//默认不唯一
				if(required(obj) == undefined){
					var name=obj.value.trim();
			 		if(originalName == name){			
						return true;
					}  
					var url="${pageContext.request.contextPath}/package/verifyPackageName";
					$.ajax({  
				         type : "post",  
				         url : url,  
				         data : "packageName=" + name,  
				         async : false,  
				         success : function(data){  
				  			if(data != "OK"){
				  				checkInit($("#name"));
								$("#name").next().text("对不起，服务套餐名称不能重复！").attr("style",errorMsgColor);
								flag = false;
				  			}else{
				  				flag = true;
				  			}
				         }  
				    });  
				}
				return flag;
			}
			$("#name").blur(function(){
				checkUnique();
			});
			$("#packageLevel").blur(function(){
				required(this);
				
			});
			
			
			$("#price").blur(function(){
				required(this);
				
			});
			
			$('#tj').click(function(){
				if(!checkUnique()){
					return;
				}
				
				var ary =[];
				$("select").each( function(){
				 	ary.push($(this).val());
				 });
				 
				var nary = ary.sort();
				var isRepeat = true;
				for(var i = 0; i < nary.length; i++){
					for(var j = 0;j<nary.length;j++){
		  				if (nary[i] != 0 && i != j && nary[i] == nary[j]){
		  			 		alert("模板不能重复！");
		  			 		return;
		   			 	}
					}
				};
				
				for(var i = 0; i < nary.length; i++){
					for(var j = 0;j<nary.length;j++){
		  				if(nary[i] == 0){
							alert("请选择汇总模板！");
							return false;
						}
					}
				};
				
				if($("#packageLevel").val().trim().length==0){
					checkInit($("#packageLevel"));
					$("#packageLevel").next().text("必须填写").attr("style",errorMsgColor);
					$("#packageLevel").focus();
					return false;
				}
				if(isNaN($.trim($("#packageLevel").val())) ){
					alert('套餐级别只能输入数字');
					$("#packageLevel").val('');
					$("#packageLevel").focus();
					return false;
				}
				var re=/^\d{1}$/;
				//alert($("#packageLevel").val());
				if(!re.test($.trim($("#packageLevel").val()))){
					alert('套餐级别只能输入<10的整数');
					$("#packageLevel").val('');
					$("#packageLevel").focus();
					return false;
				}
				if(isNaN($.trim($("#price").val()))){
					alert("价格只能输入数字！");
					$("#price").val('');
					$("#price").focus();
					return false;
				}
				if($.trim($("#price").val()).length==0){
					alert("价格必须填写！");
					$("#price").focus();
					return false;
				}
				if($.trim($("#price").val())<=0){
					alert("价格必须大于0");
					$("#price").val('');
					$("#price").focus();
					return false;
				}
				
				/* var selected_val = $("#select1").val();
				if(selected_val==0){
					alert("请选择汇总模板！");
					return false;
				} */
				
				var flag = true;
				$('.table_new_table').each(function(index, item){
					var $checkedRadio = $(item).find('input[type="radio"]:checked');
					var t = $(item).find('input[type="text"]:eq(1)');
					var c = $(item).find('input[type="text"]:eq(0)');
					var tValue = parseInt(t.val());
					var maxMumDayValue = parseInt($("#maxMumDay").val());
					if($checkedRadio.val()=='T'){
						if(t.val().trim().length==0){
							t.focus();
							flag = false;
							alert('周期不能为空');
							return false;
						}
						if(tValue < maxMumDayValue) {
							t.focus();
							flag = false;
							alert('套餐周期不能小于汇总模板的周期 ' + maxMumDayValue + ' 天');
							return false;
						}
					}else{
						if(c.val().trim().length==0){
							c.focus();
							flag = false;
							alert('次数不能为空');
							return false;
						}
					}
				});
				if(!flag){
					return false;
				}
				
				// 禁用提交按钮 反正重复提交表单
				$(this).attr("disabled","disabled");
				$('form').submit();
	         });
			
			if('${msg}')alert('${msg}');
			$('input[type="radio"]').click(function(){
				var $this = this;
				var c = $('input[type="text"]:eq(0)', $(this).parents('tbody')[0]);
				var t = $('input[type="text"]:eq(1)', $(this).parents('tbody')[0]);
				if($this.value == 'T'){
					c.val('');
					c.attr('readOnly', true);
					t.attr('readOnly', false);
				}else{
					t.val('');
					t.attr('readOnly', true);
					c.attr('readOnly', false);
				}
			});
			
			var id = $("#select1").val();
			if(id == 0) {
				return;
			}
			var url = "../template/getMaxMumDay";
			$.post( url,
					{sumRepTempCode : id},
					function(data){
						$("#maxMumDay").val(data);
					});
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
			
			function select(obj){
				var id = $(obj).val();
				if(id == 0) {
					return;
				}
				var url = "../template/getMaxMumDay";
				$.post( url,
						{sumRepTempCode : id},
						function(data){						
							$("#maxMumDay").val(data);
						});
						
				 var ary =[];
				$("select").each( function(){
				 	ary.push($(this).val());
				 });
				 
				var nary = ary.sort();
				var isRepeat = true;
				for(var i = 0; i < nary.length; i++){
					for(var j = 0;j<nary.length;j++){
		  				if (nary[i] != 0 && i != j && nary[i] == nary[j]){
		  			 		alert("模板不能重复！");
		  			 		return;
		   			 	}
					}
				}
			}
				
				function inputs(obj){
					if(isNaN($(obj).val())){alert('只能输入数字');this.value='';}
				}
				
				
				function checkRadio(num){
					if(num == undefined)
					{
						num = 0;
					}
					while(num >= 0)
					{
						var obj = document.getElementsByName('packagDetailList[' + num + '].calcType');
						var numDay = "";
						var numTimes = "";
						var sumRepTempCode = "";
						if(obj[0].checked)
						{
							numDay = document.getElementsByName('packagDetailList['+ num +'].numDay')[0].value;
							sumRepTempCode = document.getElementsByName('packagDetailList['+ num +'].sumRepTempCode')[0].value;
							if(numDay == null || numDay == "")
							{
								alert("套餐"+ (num + 1) +"选择了计时，必须输入周期");
								return false;
							}
							if(sumRepTempCode == null || sumRepTempCode == 0)
							{
								alert("套餐"+ (num + 1) +"必须选择汇总模板");
								return false;
							}
						}
						if(obj[1].checked)
						{
							numTimes = document.getElementsByName('packagDetailList['+ num +'].numTimes')[0].value;
							sumRepTempCode = document.getElementsByName('packagDetailList['+ num +'].sumRepTempCode')[0].value;
							if(numTimes == null || numTimes == "")
							{
								alert("套餐"+ (num + 1) +"选择了计次，必须输入次数");
								return false;
							}
							if(sumRepTempCode == null || sumRepTempCode == 0)
							{
								alert("套餐"+ (num + 1) +"必须选择汇总模板");
								return false;
							}
						}
						num--;
					}
					return true;
				}
				
				function test() {
					alert('coming');
				}
	</script>
</head>
<body>
<div class="content">
    <div class="content-title">
	   	<c:if test="${flag == 'add'}">
	   		添加测量套餐
	   	</c:if>
	   	<c:if test="${flag == 'update'}">
	   		 测量套餐编辑
	   	</c:if>
    </div>
    <div id="content_table">
		<form action="../package/saveOrUpdatePackage"  method="post">
			<input type="hidden" id="option" name="option" value="${option}">
	 		<input id="count" type="hidden" value="${fn:length(packag.packagDetailList)}">
			<input name="packageCode" type="hidden" value="${packag.packageCode }">
			<input id="maxMumDay" type="hidden" />
			<table id="table_new" style="width:100%;">
				<tr>
					<td height="10px;"></td>
				</tr>
				<tr>
				  <td class="table_new_title" align="right" width="13%"><span class="red">*</span>套餐名称：</td>
				  <td class="table_new_textipt" width="25%"><input id="name" name="packageName" type="text" value="${packag.packageName }" class="table_new_input"/>&nbsp;<span class="red"></span></td>
				  <td class="table_new_title" align="right" width="13%"><!-- 套餐类型: --></td>
				  <td class="table_new_textipt" width="20%">
				      <input type="hidden" name="packageType" id="packageType" value="${packag.packageType==null?1:packag.packageType}"/>
				  </td>
				   <td class="table_new_title" align="right" width="13%"><span class="red">*</span>套餐级别：</td>
				   <td class="table_new_textipt"><input name="packageLevel" id="packageLevel" type="text" value="${packag.packageLevel }" class="table_new_input"/><span class="red"></span></td>
				</tr>
				<tr>
				    <td class="table_new_title" align="right" valign="middle">套餐说明：</td><td colspan="3" id="table_new_textarea">
				   		<textarea rows="4" cols="30" name="packageDesc">${packag.packageDesc}</textarea>
				   	</td>
					 <td class="table_new_title" align="right"><span class="red">*</span>价格：</td>
					 <td class="table_new_textipt">
						 <input id="price" name="price" type="text" value="${packag.price }" class="table_new_input"/>&nbsp;元
						 <span class="red"></span>
					 </td>
				</tr>
				<tr>
				 	<td class="table_new_title" align="right">创建人姓名：</td>
				 	<td class="table_new_textipt">
				 		<input name="createName" type="text" value="${packag.createName }" readonly="readonly" class="table_new_input"/>
				 	</td>
				</tr>
				<c:if test="${empty packag.packagDetailList}">
					<tr><td colspan="6"><h3>套餐明细1</h3></td></tr>
					<tr><td colspan="6" class="table_new_table">
							<table style="width:100%;">
								<tr>
									<td class="table_new_title" align="right" width="13%"><span class="red">*</span>汇总模板：</td>
									<td class="table_new_textipt" width="20%">
										<select id="select1" name="packagDetailList[0].sumRepTempCode" onchange="select(this)" >
												<option value='0'>请选择</option>
												<c:if test="${!empty templateList}">
													<c:forEach var="template" items="${templateList}" varStatus="templateSt">
														<option value="${template.sumRepTempCode}" >${template.tempName}</option>
													</c:forEach>  
												</c:if>
										</select><span></span>
									</td>
									<td class="table_new_title" align="right" width="13%">计算类型：</td>
									<td class="table_new_textipt" width="20%"> 
									 	<input id="time" type="radio" name="packagDetailList[0].calcType" value="T" checked="checked"/>计时
									 	<input class="mar-left" id="count" type="radio" name="packagDetailList[0].calcType" value="C"/>计次
									 </td>
									 <td class="table_new_title" align="right" width="13%">次数：</td>
									 <td class="table_new_textipt">
									 	<input name="packagDetailList[0].numTimes" type="text" class="table_new_input" onchange="if(isNaN(this.value)){alert('只能输入数字');this.value='';return false;}if(this.value<=0){alert('必须大于0！');this.value='';return false;}"/>&nbsp;次
									 </td>
								</tr>	
								<tr>
									 <td class="table_new_title" align="right">周期：</td><td class="table_new_textipt">
									 	<input name="packagDetailList[0].numDay" type="text" class="table_new_input" onchange="if(isNaN(this.value)){alert('只能输入数字');this.value='';return false;}if(this.value<=0){alert('必须大于0！');this.value='';return false;}"/>&nbsp;天
									 	<input name="packagDetailList[0].createid" type="hidden" value="${sessionScope.userInfo.id}" class="table_new_input"/>
									 </td>
									 <td class="table_new_title"></td><td class="table_new_textipt"></td>
								</tr>
							</table>
						</td>
					</tr>
				</c:if>
				<c:if test="${!empty packag.packagDetailList}">
					<c:forEach var="item" items="${packag.packagDetailList}" varStatus="status">
						<tr><td colspan="6"><h3>套餐明细<span class="num">${status.index + 1}</span></h3></td></tr>
						<tr>
							<td colspan="6" class="table_new_table">
								<table style="width:100%;">
									<tr><td class="table_new_title" align="right" width="13%"><span class="red">*</span>汇总模板：</td>
										<td class="table_new_textipt" width="20%">
											<select id="select1" name="packagDetailList[${status.index}].sumRepTempCode" onchange="select(this)">
												<option value='0'>请选择</option>
												<c:if test="${!empty templateList}">
													<c:forEach var="template" items="${templateList}" varStatus="templateSt">
														<option value="${template.sumRepTempCode}" <c:if test="${item.sumRepTempCode == template.sumRepTempCode}">selected="selected"</c:if> >${template.tempName}</option>
													</c:forEach>  
												</c:if>
											</select>
										</td>
										<td class="table_new_title" align="right" width="13%">计算类型：</td><td class="table_new_textipt" width="20%">
										 	<input type="radio" name="packagDetailList[${status.index}].calcType" value="T" <c:if test="${item.calcType == 'T'}">checked</c:if>/>计时
										 	<input class="mar-left" type="radio" name="packagDetailList[${status.index}].calcType" value="C" <c:if test="${item.calcType == 'C'}">checked</c:if>/>计次
										 </td>
										 <td class="table_new_title" align="right" width="13%">次数：</td>
										 <td class="table_new_textipt" width="20%">
										 		<input name="packagDetailList[${status.index}].numTimes" type="text" value="${item.numTimes}" class="table_new_input" onchange="if(isNaN(this.value)){alert('只能输入数字');this.value='';return false;}if(this.value<=0){alert('必须大于0！');this.value='';return false;}"/>&nbsp;次
										 </td>
									</tr>	
									<tr>
										 <td class="table_new_title" align="right" width="13%">周期：</td>
										 <td class="table_new_textipt">
										 	<input name="packagDetailList[${status.index}].numDay" type="text" value="${item.numDay}" class="table_new_input" onchange="if(isNaN(this.value)){alert('只能输入数字');this.value='';return false;}if(this.value<=0){alert('必须大于0！');this.value='';return false;}"/>&nbsp;天
											<input name="packagDetailList[${status.index}].createid" type="hidden" value="${sessionScope.userInfo.id}" class="table_new_input"/>
										</td>
										<td class="table_new_title">&nbsp;</td>
										<td class="table_new_textipt">
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</c:forEach>  
				</c:if>
				<tr id="button">
					<td colspan="6" >
						<button type="button" id="detail" class="btn-normal">添加明细</button>
						<button type="button" id="remove" class="btn-normal fl">移出明细</button>
					</td>
				</tr>	
				<tr>
					<td colspan="6" class="align-center"><input type="button" id="tj" class="btn-normal" value="提   交"/></td>
				</tr>
			</table>
		</form>
	</div>
</div>
</body>
</html>