<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>问卷类别配置</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/js/skins/blue.css">
	<link rel="stylesheet" href="<%=path %>/css/oopt.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.artDialog.js"></script>
	<script type="text/javascript">
	$(function() {
		var isSuccessful = $("input[name=isSuccessful]").val();
		if("true" == isSuccessful){
			alert("创建问卷类别成功");
		}else if("false" == isSuccessful){
			alert("创建问卷类别失败");
		}else{
		  
		}
		
		var isDelete = $("input[name=isDelete]").val();
		if("-1" == isDelete){
			alert("删除问卷类别失败");
		}else if("1" == isDelete){
			alert("删除问卷类别成功");
		}else if("2" == isDelete){
			alert("该类别已使用，不允许删除。");
		}else{
		  
		}
		
		
		var isUpdated = $("input[name=isUpdated]").val();
		if("true" == isUpdated){
			alert("修改问卷类别成功");
		}else if("false" == isUpdated){
			alert("修改问卷类别失败");
		}else{
		  
		}
	});
	
	function update(a) {
		alert(a.action);
		alert($(a).attr('action'));
		$.post($(this).attr('action'), $(this).serialize(), function(data) {
			if (data.success)
				location.reload(true);
			else
				alert('修改失败');
		});
		
		return false;
	}
	
	function addOopt(){
		var optName=$('input[name=optName]');
		var optDes=$('textarea[name=optDes]');
		var chlevel=$('select[name=chlevel]');
		if(optName.val() == ""){
			alert("问卷类别不能为空");
			return false;
		}
		if(optDes.val() == ""){
			alert("问卷类别说明不能为空");
			return false;
		}
		if(chlevel.val() == ""){
			alert("审核级别不能为空");
			return false;
		}
		tocheckname();
		//tocheckdesc();
		var optNameValidate = $("#optNameValidate").text();
		if(optNameValidate != ""){
		   	//alert("问卷类别已存在,请修改后再提交。");
			   return false;
		 }
		var optDesValidate = $("#optDesValidate").text();
		if(optDesValidate != ""){
		   	//alert("问卷类别说明已存在,请修改后再提交。");
			   return false;
		 }	
		
		 //  提交表单
		$("#saveForm").submit();
	}
	
	function updateOopt(){
		var optName=$('input[name=optName]:eq(1)');
		var optDes=$('textarea[name=optDes]:eq(1)');
		var chlevel=$('select[name=chlevel]:eq(1)');
		//修改disabled
		$('select[name=funId]:eq(1)').attr("disabled",false); 
		chlevel.attr("disabled",false); 
		if(optName.val() == ""){
			alert("问卷类别不能为空");
			return false;
		}
		if(optDes.val() == ""){
			alert("问卷类别说明不能为空");
			return false;
		}
		if(chlevel.val() == ""){
			alert("审核级别不能为空");
			return false;
		}
		tocheckname1();
		//tocheckdesc1();
		//alert("修改功能正在维护中，暂时不支持修改");
		//return false;
		
		var optNameValidate = $("#optNameValidate2").text();
		if(optNameValidate != ""){
		   	//alert("问卷类别已存在,请修改后再提交。");
			   return false;
		 }
		var optDesValidate = $("#optDesValidate2").text();
		if(optDesValidate != ""){
		   	//alert("问卷类别说明已存在,请修改后再提交。");
			   return false;
		 }
		 //  提交表单
		$("#updateForm").submit();
	}
	
	function updateOoptList(optId, funId){
		$.post("selectById",{optId: optId, funId: funId},function(data){
			if(data){ 
				$('select[name=funId]:eq(1)').val(data.funId);
				$('input[name=optName]:eq(1)').val(data.optName);
				$('textarea[name=optDes]:eq(1)').val(data.optDes);
				$('select[name=chlevel]:eq(1)').val(data.chlevel);
				$('input[name=optId]').val(data.optId);
				$('input[name=optNameOriginalValue]').val(data.optName);
				$('input[name=optDesOriginalValue]').val(data.optDes);
				$('#optNameValidate2,#optDesValidate2').html('');
			}
		},"json");
	    	
		showBg('ques_type_3');
		
	}
	
	function deleteOoptList(optId, funId){
			art.dialog({
				 id: 'delete-dialog',
				title:'提示信息',
				skin: 'delete-dialog',
			    content: '你确定需要删除此条记录吗?',
			    ok: function () {
			    	$.ajax({
			    		   type: "POST",
			    		   url: "remove",
			    		   data: {optId: optId, funId: funId},
			    		   success: function(msg){
			    			   alert(msg.content);
				    		   if(msg.status)
				    		   	 window.location.reload();
			    		   }
			    		});
			        return false;
			    },
			    drag:true,
			    cancelVal: '取消',
			    cancel: true //为true等价于function(){}
			});
	}
	
	function tocheckname() 
	{ 
	    var optNameValue = $('input[name=optName]').val();
	    
	    	$.ajax({ 
	    		type:"POST", 
	    		cache:false, 
	    		url : "checkName", 
	//     		dataType : "text", 
	    		data:{"name":optNameValue}, 
	    		async:false, 
	    		success : function(data){
	    			if(!data.status){
	    				$('#optNameValidate').css("border-color","#ccc");
	    				$('#test').css("white-space","nowrap");
	    				$('#optNameValidate').text("问卷类别已存在");
	    				$('#optNameValidate').focus();
	    			}else{
	    				$('#optNameValidate').text("");
	    			}
	    		} 
	    	});
	}
	
	function tocheckdesc() 
	{ 
	    var optDesValue = $('textarea[name=optDes]').val();
	    
	    	$.ajax({ 
	    		type:"POST", 
	    		cache:false, 
	    		url : "checkDes", 
	//     		dataType : "text", 
	    		data:{"des":optDesValue}, 
	    		async:false, 
	    		success : function(data){
	    			if(!data.status){
	    				$('#optDesValidate').css("border-color","#ccc");
	    				$('#test1').css("white-space","nowrap");
	    				$('#optDesValidate').text("问卷类别说明已存在");
	    				$('#optDesValidate').focus();
	    			}else{
	    				$('#optDesValidate').text("");
	    			}
	    		} 
	    	});
	}
	//optNameValue optDesValue
	function tocheckname1() 
	{ 
	    var optNameValue = $('input[name=optName]:eq(1)').val();
	     var optNameOriginalValue = $('input[name=optNameOriginalValue]').val();
	    if(optNameValue != optNameOriginalValue){
	    	$.ajax({ 
	    		type:"POST", 
	    		cache:false, 
	    		url : "checkName", 
	//     		dataType : "text", 
	    		data:{"name":optNameValue}, 
	    		async:false, 
	    		success : function(data){
	    			if(!data.status){
	    				$('#optNameValidate2').css("border-color","#ccc");
	    				$('#test2').css("white-space","nowrap");
	    				$('#optNameValidate2').text("问卷类别已存在");
	    				$('#optNameValidate2').focus();
	    			}else{
	    				$('#optNameValidate2').text("");
	    			}
	    		} 
	    	});
	    }else{
	    	$('#optNameValidate2').text("");
	    }
	}
	
	function tocheckdesc1() 
	{ 
	    var optDesValue = $('textarea[name=optDes]:eq(1)').val();
	     var optDesOriginalValue = $('input[name=optDesOriginalValue]').val();
	    if(optDesValue != optDesOriginalValue){
	    	$.ajax({ 
	    		type:"POST", 
	    		cache:false, 
	    		url : "checkDes", 
	//     		dataType : "text", 
	    		data:{"des":optDesValue}, 
	    		async:false, 
	    		success : function(data){
	    			if(!data.status){
	    				$('#optDesValidate2').css("border-color","#ccc");
	    				$('#test3').css("white-space","nowrap");
	    				$('#optDesValidate2').text("问卷类别说明已存在");
	    				$('#optDesValidate2').focus();
	    			}else{
	    				$('#optDesValidate2').text("");
	    			}
	    		} 
	    	});
	    }else{
	    	$('#optDesValidate2').text("");
	    }
	}
	
	//打开div层
	function showBg(type){ 
			var bh = $(document).height(); 
			var bw = $(document).width(); 
			    $("#fullbg").css({ 
			    height:bh, 
			    width:bw, 
			    display:"block" 
			    }); 
			    $("#"+type+"").show(); 
			    /*以下为鼠标拖动弹出层改变其位置*/
			    var _x,_y,isMove=false;
			    $(function(){
			    $('.close').mousedown(function(e) {
				_x=e.pageX-parseInt($("#"+type+"").css("left"));
				_y=e.pageY-parseInt($("#"+type+"").css("top"));
				//$('.ques_type').fadeTo(20, 0.5);//点击后开始拖动并透明显
				isMove = true;
				});
				$(this).mousemove(function(e) {
				
				if(isMove){
					var x=e.pageX-_x;//移动时根据鼠标位置计算控件左上角的绝对位置
					var y=e.pageY-_y;
					$("#"+type+"").css({top:y,left:x});//控件新位置
					if( x < 0 ){$("#"+type+"").css({left:0});}
					if( y < 0 ){$("#"+type+"").css({top:0});}
				  }
				});
				$(this).mouseup(function(e) {
				isMove = false;
				$('.close').fadeTo("fast", 1);
				});
			  });
			    
	    } 
	    //关闭灰色 jQuery 遮罩 
	    function closeBg(type) { 
	    	if(type == "ques_type_2"){
	    		$("#saveForm")[0].reset(); 
	    	}
	    	$('#optNameValidate,#optDesValidate').text("");
		    $("#fullbg,#"+type+"").hide(); 
		    $("#"+type+"").find(".add_tr").remove();
		    $(".label_add").css('display','block');
	    } 
	</script>
</head>
<body>
	<div class="content">
		<div class="content-title">问卷类别配置</div>
		<input type="hidden" name="isDelete" value="${isDelete }" readonly/>
		<div class="box-btn clearfix">
		 	<input class="btn-normal fr" type="button" value="新增问卷类别" onclick="showBg('ques_type_2')">
		</div>
		<form action="list">
			<div class="table-box">
				<table class="table-content table-fixed">
					<thead class="table-title">
						<tr>
							<th width="5%">序号</th>
							<th width="25%">名称</th>
							<th width="25%">类别说明</th>
							<th width="20%">医生功能</th>
							<th width="25%">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${page.result}" var="item" varStatus="status">
							<tr>
								<td>${status.index+1}</td>
								<td>${item.optName}</td>
								<td title="<c:out value="${item.optDes}" escapeXml="true"/>"><c:out value="${item.optDes}" escapeXml="true"/></td>
								<td>${item.funId eq 3 ? '单份答卷' : '组合答卷' }</td>
								<td>
								<c:choose>
									<c:when test="${item.funId == 1 || item.funId == 2}">
										&nbsp;
									</c:when>
									<c:otherwise>
										<a href="javascript:void(0)" onclick="updateOoptList(${item.optId}, ${item.funId})">修改</a>
										<a href="javascript:void(0)" class="mar-left" onclick="deleteOoptList(${item.optId}, ${item.funId})">删除</a>
									</c:otherwise>
								</c:choose>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
		        <div class="page-box">    
			        <jsp:include  page="/public/pageFoot.jsp"/>
			    </div>
			</div>
		</form>
	</div> 
		
	<div id="fullbg"></div> 
	<form action="save" id="saveForm" method="post" onkeydown="if(event.keyCode==13){return false;}">
	<input type="hidden" name="isSuccessful" value="${isSuccessful }" readonly/>
		<div id="ques_type_2" class="ques_type"> 
			<p class="close clearfix" style="cursor:move;">
				添加问卷类别
				<img class="btn-close" src="<%=path %>/img/u67.png" alt="关闭按钮" onclick="closeBg('ques_type_2');">
			</p> 
			<div id="quer_type_que_2">
				<table>
					<tr>
						<td class="quer_td_title">类别名称：</td>
						<td colspan="2" id="test">
							<input name="optName" type="text" placeholder="" id="ku" class="ipnutcontent" onchange="tocheckname()" maxlength="50"/>
							<span id="optNameValidate" style="color:red; font-size:14px;" ></span>
						</td>
					</tr>
					<tr>
						<td class="quer_td_title"><span>医生功能：</span></td>
						<td colspan="2">
							<select name="funId" >
									<option value="3">单份答卷</option>
									<option value="4">组合答卷</option>
							</select>
						</td>
						<td></td>
					</tr>
					<tr>
						<td class="quer_td_title">类别说明：</td>
						<td colspan="2" id="test1">
							<textarea name="optDes" class="ipnutcontent" cols="40" rows="4" maxlength="150"></textarea>
							<span id="optDesValidate" style="color:red; font-size:14px;display:block;" ></span>
						</td>
					</tr>
				</table>
			</div> 
			<div class="ques_type_but">
				<input type="hidden" name="docId" value="${sessionScope.user_id }">
				<input class="btn-inquiry" type="button" value="确认" onclick="return addOopt();"/>
				<input class="btn-cancel" type="button" value="取消" onclick="closeBg('ques_type_2');"/>
			</div>
		</div>
	</form>
	
	<form action="save" id="updateForm" method="post">
	<input type="hidden" name="isUpdated" value="${isUpdated }" readonly/>
	<input type="hidden" value="" name="optId" readonly/>
	<input type="hidden" name="optNameOriginalValue" value="${oopt.optName}" readonly/>
	<input type="hidden" name="optDesOriginalValue" value="${oopt.optDes}" readonly/>
		<div id="ques_type_3" class="ques_type"> 
			<p class="close clearfix" style="cursor:move;">
				修改问卷类别
				<img class="btn-close" src="<%=path %>/img/u67.png" alt="关闭按钮" onclick="closeBg('ques_type_3');">
			</p>  
			<div id="quer_type_que_3">
				<table >
					<tr>
						<td class="quer_td_title">类别名称：</td>
						<td colspan="2" id="test2">
						<input name="optName" type="text" value="${oopt.optName}" placeholder="" id="ku" class="ipnutcontent" onchange="tocheckname1()"/>
						<span id="optNameValidate2" style="color:red; font-size:14px;" ></span>
						</td>
					</tr>
					<tr>
						<td class="quer_td_title"><span>医生功能：</span></td>
						<td colspan="2">
							<select name="funId" disabled >
								<option value="3">单份答卷</option>
								<option value="4">组合答卷</option>
							</select>
						</td>
					</tr>
					<tr>
						<td class="quer_td_title">类别说明：</td>
						<td colspan="2" id="test3">
						<textarea name="optDes" class="ipnutcontent" value="${oopt.optDes}" cols="30" rows="4" ></textarea>
						<span id="optDesValidate2" style="color:red; font-size:14px;display:block;" ></span>
						</td>
					</tr>
				</table>
			</div> 
			<div class="ques_type_but">
				<input type="hidden" name="docId" value="${sessionScope.user_id }">
				<input class="btn-inquiry" type="button" value="确认" onclick="return updateOopt();"/>
				<input class="btn-cancel" type="button" value="取消" onclick="closeBg('ques_type_3');"/>
			</div>
		</div>
	</form>
</body>
</html>