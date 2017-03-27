<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>上传数据</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css" />
	<link rel="stylesheet" href="<%=path %>/css/celiang.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer/layer.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/showInfo.js"></script>
	<script type="text/javascript" src="<%=path %>/js/highcharts.js"></script>
	<script type="text/javascript" src="<%=path %>/js/exporting.js"></script>
	<script type="text/javascript" src="<%=path %>/js/calendar.js"></script>
	<script type="text/javascript" src="<%=path %>/js/FileControl.js"></script>
	<script type="text/javascript">
		function toLoginPage(){
			window.location.href = '<%=basePath%>'
		}
		function getRoot(){
			return '<%=basePath%>';
		}
		var EventUtil = {
		    addHandler: function(element, type, handler) {
		        if (element.addEventListener) {
		            element.addEventListener(type, handler, false);
		        } else if (element.attachEvent) {
		            element.attachEvent("on" + type, handler);
		        } else {
		            element["on" + type] = handler;
		        }
		    }
		};
		EventUtil.addHandler(window, "offline", function() {
		    window.location.href='<%= path + "/error.jsp"%>';
		});
		$(document).ready(function(){ 
		   //tab功能切换
			jQuery.jqtab = function(tabtit,tab_conbox,shijian) {
				var uploadShow = $("#uploadShow").val();
				
				$(tab_conbox).find("div.tab_conbox_item2").hide();
				if(uploadShow == "obsr"){
					$("#box4").addClass("thistab").show();
					$($(tabtit).find("li")[3]).addClass("thistab").show(); 
				}else if(uploadShow == "osbp")
				{
					$("#box3").addClass("thistab").show(); 
					$($(tabtit).find("li")[2]).addClass("thistab").show();
				}else if(uploadShow == "sanheyi")
				{
					$("#box2").addClass("thistab").show(); 
					$($(tabtit).find("li")[1]).addClass("thistab").show();
				}else {
					$("#box1").addClass("thistab").show();
					$($(tabtit).find("li")[0]).addClass("thistab").show(); 
				}
				
				//$(tab_conbox).find("div.tab_conbox_item2:first").show();
				$(tabtit).find("li").bind(shijian,function(){
					$(this).addClass("thistab").siblings("li").removeClass("thistab"); 
					var activeindex = $(tabtit).find("li").index(this);
					$(tab_conbox).children().eq(activeindex).show().siblings().hide();
					return false;
					});
			};
			$.jqtab("#tab_title2","#tab_conbox2","click");
		});

	    $(function(){
	    	//会员为冻结状态时，上传的提交按钮不可用
	    	var status = '${member.status}';
	    	if(status == 'F'){
	    		$("input:submit").attr("disabled","disabled");
	    	}
	    	
            //验证血氧饱和度
             $("#spo").blur(function(){
			var spo = $("#spo").val();
			var startTime1 = $("#startTime1").val();
			var re=/^(?=[\d.]{1,4})([1-9]\d{1,5}|\d)?$/;
			if(re.test(spo)){
				if(startTime1 == "" && spo == ""){
					return false;
				}else if(spo < 95 || spo > 100){
					alert("血氧饱和度测量范围为95~100，范围已超出，请重新输入！");
					return false;
				}
			}else{
				if(spo == ""){
					alert("血氧饱和度值为空，请输入！");
					return false;
				}else{
					alert("格式不正确，请重新输入！");
					return false;
				}
			}
			});
			//验证收缩压 舒张压  脉率
			
			$("#sbp").blur(function(){
				var sbp = $("#sbp").val();
				var timePeriod1 = $("#timePeriod1").val();
				var startTime2 =$("#startTime2").val();
				var re=/^(?=[\d.]{1,8})([1-9]\d{1,10}|\d)?$/;
				if(re.test(sbp)){
					if((timePeriod1 == "" || startTime2 == "") && sbp == ""){
						return false;
					}else if(sbp < 40 || sbp > 260){
						alert("收缩压测量范围为40~260，范围已超出，请重新输入！");
						return false;
					}
				}else{
					 if(sbp == ""){
						alert("收缩压值为空，请输入！");
						return false;
					}else{
						alert("格式错误，请重新输入！");
						return false;
					}
				}
			});
			$("#dbp").blur(function(){
				var dbp = $("#dbp").val();
				var sbp = $("#sbp").val();
				var timePeriod1 = $("#timePeriod1").val();
				var startTime2 =$("#startTime2").val();
				var re=/^(?=[\d.]{1,8})([1-9]\d{1,10}|\d)?$/;
				if(re.test(dbp)){
					if((timePeriod1 == "" || startTime2 == "" || sbp == "") && dbp == ""){
						return false;
					}else if(dbp < 40 || dbp > 180){
						alert("舒张压测量范围为40~180，范围已超出，请重新输入！");
						return false;
					}
				}else{
				 	if(dbp == ""){
						alert("舒张压值为空，请输入！");
						return false;
					}else{
						alert("格式错误，请重新输入！");
						return false;
					}	
				}			
			});
				
			$("#pulseRate").blur(function(){
				var dbp = $("#dbp").val();
				var sbp = $("#sbp").val();
				var pulseRate = $("#pulseRate").val();
				var timePeriod1 = $("#timePeriod1").val();
				var startTime2 =$("#startTime2").val();
				var re=/^(?=[\d.]{1,6})([1-9]\d{1,10}|\d)?$/;
				if(re.test(pulseRate)){
					if((timePeriod1 == "" || startTime2 == "" || sbp == "" || dbp == "") && pulseRate == ""){
						return false;
					}else if(pulseRate < 0 || pulseRate > 200){
						alert("脉率测量范围为0~200，范围已超出，请重新输入！");
						return false;
					}
				}else{
					if(pulseRate == ""){
						alert("脉率值为空，请输入！");
						return false;
					}else{
						alert("格式错误，请重新输入！");
						return false;
					}
				}
			});
				
			//验证血糖
			 $("#bsValue").blur(function(){
				var re=/^(?=[\d.]{1,7})([1-9]\d{1,6}|\d)(\.\d{1,1})?$/;
				var timePeriod2 = $("#timePeriod2").val();
				var startTime3 = $("#startTime3").val();
				var bsValue = $("#bsValue").val();
				if(re.test(bsValue)){
					if((timePeriod2 == "" || startTime3 == "") && bsValue == ""){
						return false;
					}else if(bsValue < 0 || bsValue > 25){
						alert("血糖测量范围为0~25，范围已超出，请重新输入！");
						return false;
					}
				}else{
					if(bsValue == ""){
						alert("血糖值信息为空，请输入！");
						return false;
					}else{
						alert("格式错误，请重新输入！");
						return false;
					}
				}
			}); 
	    });

		//全选与反选功能
		$(function(){
			//全选
			$("#allSelect").click(function(){
				$(":checkbox").attr("checked", "checked");
			});
			//反选
			$("#unSelect").click(function(){
				$(":checkbox").each(function () {  
		            this.checked = !this.checked;  
		         });
			});
		});
			
		//验证选择时间是否大于当前时间 2015-05-05由sz添加
		function checkTime(){
		    var d = new Date();
		    //取当前年月日，舍去时分秒
		    //d = new Date(d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate());
		    var d2 = new Date(document.getElementById("startTime").value);
		   
		    if (d2 == "Invalid Date") {
		        alert("非日期");
		        return;
		    }
		    //getTime 从1970.1.1开始的毫秒数
		    var n = d.getTime() - d2.getTime();
		 
		    if (n == 0) {
		       return true;
		    } else if (n > 0) {
		        return true;
		    } else {
		        alert("不能大于当前日期");
		        document.getElementById("startTime").value="";
		        return false;
		    }
		}
			
		function checkTime1(){
		    var d = new Date();
		    //取当前年月日，舍去时分秒
		    //d = new Date(d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate());
		    var d2 = new Date(document.getElementById("startTime1").value);
		   
		    if (d2 == "Invalid Date") {
		        alert("非日期");
		        return;
		    }
		    //getTime 从1970.1.1开始的毫秒数
		    var n = d.getTime() - d2.getTime();
		 
		    if (n == 0) {
		       return true;
		    } else if (n > 0) {
		        return true;
		    } else {
		        alert("不能大于当前日期");
		        document.getElementById("startTime1").value="";
		        return false;
		    }
		}
			
		function checkTime2(){
		    var d = new Date();
		    //取当前年月日，舍去时分秒
		    //d = new Date(d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate());
		    var d2 = new Date(document.getElementById("startTime2").value);
		   
		    if (d2 == "Invalid Date") {
		        alert("非日期");
		        return;
		    }
		    //getTime 从1970.1.1开始的毫秒数
		    var n = d.getTime() - d2.getTime();
		 
		    if (n == 0) {
		       return true;
		    } else if (n > 0) {
		        return true;
		    } else {
		        alert("不能大于当前日期");
		        document.getElementById("startTime2").value="";
		        return false;
		    }
		}
			
		function checkTime3(){
		    var d = new Date();
		    //取当前年月日，舍去时分秒
		    //d = new Date(d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate());
		    var d2 = new Date(document.getElementById("startTime3").value);
		   
		    if (d2 == "Invalid Date") {
		        alert("非日期");
		        return;
		    }
		    //getTime 从1970.1.1开始的毫秒数
		    var n = d.getTime() - d2.getTime();
		 
		    if (n == 0) {
		       return true;
		    } else if (n > 0) {
		        return true;
		    } else {
		        alert("不能大于当前日期");
		        document.getElementById("startTime3").value="";
		        return false;
		    }
		}
			
		//点击对比的时候判断所选择的checkbox是否超过5个
		function checkCount(){
			var checkboxs = $("input[name='checkbox']:checked").length;
			if(checkboxs <= 0){
				alert("请勾选需要对比的测量项");
				return false;
			}else if(checkboxs < 2){
				alert("至少选择2次测量进行对比");
				return false;
			}else if(checkboxs > 5){
				alert("最多只能选择5次测量进行对比");
				return false;
			}else{
				var s = '';
				$("input[name='checkbox']:checked").each(function(){
				    s += $(this).val()+',';
				});
				//window.location = "reportAction!showSanHeYiCompareUI?parameter="+s;
				window.open('reportAction!showSanHeYiCompareUI?parameter='+s,'blank_','scrollbars=yes,resizable=no,width=900,height=400');
			}
		}
			
		//点击左下角删除时进行的一些判断
		function deleteInfo(memberId){
			var checkboxs = $("input[name='checkbox']:checked").length;
			if(checkboxs <= 0){
				alert("请勾选需要删除的测量项");
				return false;
			}else{
				if (confirm("确定要删除这些测量信息吗？")) {
					var s = '';
					$("input[name='checkbox']:checked").each(function(){
					    s += $(this).val()+',';
					});
					window.location = "reportAction!deleteInfoInXinDian?parameter="+s+"&memberId="+memberId;
				}else{
					return false;
				}
			}
		}
			
		function isEmpty(){
			if($("#startTime").val() == "" || $("#textfield").val() == ""){
				alert("信息不全，请填写！");
				return false;
			}
		}
			
		function isObsrEmpty(){
			var bsValue = $("#bsValue").val();
			if($("startTime3").val() == "" || $("#timePeriod2").val() == "" || $("#bsValue").val() == ""){
				alert("信息不全，请填写！");
				return false;
			}
			
			var re=/^(?=[\d.]{1,7})([1-9]\d{1,6}|\d)(\.\d{1,1})?$/;	
			if(re.test(bsValue)){
				 if(bsValue < 0 || bsValue > 50){
					alert("血糖测量范围为0~50，范围已超出，请重新输入！");
					return false;
				}
			}else{
				alert("格式错误，请重新输入！");
				return false;
			}
		}
			
		function isOsbpEmpty(){
			var dbp = +$("#dbp").val();
			var sbp = +$("#sbp").val();
			var pulseRate = $("#pulseRate").val();
			if($("startTime2").val() == "" || $("#timePeriod1").val() == "" || $("#sbp").val() == "" || $("#dbp").val() == ""|| $("#pulseRate").val() == ""){
				alert("信息不全，请填写！");
				return false;
			}else if(sbp <= 40 || sbp > 260){
				alert("收缩压测量范围为40~260，范围已超出，请重新输入！");
				return false;
			}else if(dbp < 40 || dbp > 180){
				alert("舒张压测量范围为40~180，范围已超出，请重新输入！");
				return false;
			}else if(pulseRate < 0 || pulseRate > 200){
				alert("脉率测量范围为0~200，范围已超出，请重新输入！");
				return false;
			}else if(dbp >= sbp){
				alert("舒张压必须小于收缩压的值，条件不符，请重新输入！");
				return false;
			}
		}
			
		function isSanheyiEmpty(){
			var spo = $("#spo").val();
			if($("#startTime1").val() == "" || $("#textfield2").val() == "" || $("#textfield3").val() == "" || $("#spo").val() == ""){
				alert("信息不全，请填写！");
				return false;
			}else if(spo < 95 || spo > 100){
				alert("血氧饱和度测量范围为95~100，范围已超出，请重新输入！");
				return false;
			}
		}
	</script>
</head>

<body>
	<input type="hidden" id="uploadShow" value="${uploadShow}" />
	<div class="content" class="box-upload">
		<div class="content-title">上传测量数据</div>
		<ul id="tab_title2" class="tab_title2 clearfix">
			<li>上传动态心电测量数据</li>
			<li>上传三合一测量数据</li>
			<li>手动输入血压测量数据</li>
			<li style="border-right:none;">手动输入血糖测量数据</li>
		</ul>
		<div id="tab_conbox2" class="border-1-solid">
			<div id="box1" class="tab_conbox_item2">
				<form enctype="multipart/form-data" method="post" action="../uploadMeasData/uploadElectricardioData?memberId=${memberId}" onsubmit="return isEmpty();">
					<table class="table-upload">
						<tr>
							<td width="40%" align="right">测量时间：</td>
							<td>
								<input type="text" name="startTime" id="startTime" readonly="readonly" onclick="SelectDate(this,'yyyy-MM-dd hh:mm:ss')" onchange="checkTime()">
							</td>
						</tr>
						<tr>
							<td align="right">文件选择：</td>
							<td>
								<div class="file-chose">
									<div class="file-box fl">
										<input type='text' name='textfield' id='textfield1' class='txt' /> 
										<input type='button' class="btn-normal" value='浏览' /> 
										<input type="file" name="fileField" class="file" id="fileField1" size="28" onchange="fileChange1(this)" accept=".txt" />
									</div>
								</div>
							</td>
						</tr>
						<tr>
							<td></td>
							<td>
								<input id="dd" type="submit" value="提交" class="btn-normal" />
								<span>${upload}</span>
							</td>
						</tr>
					</table>
				</form>
			</div>
			<div id="box2" class="tab_conbox_item2">
				<form enctype="multipart/form-data" method="post" action="../uploadMeasData/uploadElectrocardioPulseData?memberId=${memberId}" onsubmit="return isSanheyiEmpty();">
					<table class="table-upload">
						<tr>
							<td width="40%" align="right">测量时间：</td>
							<td>
								<input type="text" name="startTime1" id="startTime1" readonly="readonly" onclick="SelectDate(this,'yyyy-MM-dd hh:mm:ss')" onchange="checkTime1()">
							</td>
						</tr>
						<tr>
							<td align="right">血氧饱和度：</td>
							<td>
								<input type="text" name="spo" id="spo" maxlength="4" />
							</td>
						</tr>
						<tr>
							<td align="right">心电文件：</td>
							<td>
								<div class="file-chose">
									<div class="file-box fl">
										<input type='text' name='textfield1' id='textfield2' class='txt' /> 
										<input type='button' class="btn-normal" value='浏览' /> 
										<input type="file" name="fileField1" class="file" id="fileField2" size="28" onchange="fileChange2(this)" accept=".txt" />
									</div>
								</div>
							</td>
						<tr>
							<td align="right">脉搏文件：</td>
							<td>
								<div class="file-chose">
									<div class="file-box fl">
										<input type='text' name='textfield2' id='textfield3' class='txt' /> 
										<input type='button' class="btn-normal" value='浏览' /> 
										<input type="file" name="fileField2" class="file" id="fileField3" size="28" onchange="fileChange3(this)" accept=".txt" />
									</div>
								</div>
							</td>
						</tr>
						<tr>
							<td></td>
							<td>
								<input id="dd1" type="submit" value="提交" class="btn-normal" />
								<span>${uploadShy}</span>
							</td>
						</tr>
					</table>
				</form>
			</div>
			<div id="box3" class="tab_conbox_item2">
				<form enctype="multipart/form-data" method="post" action="../uploadMeasData/uploadBloodPresData?memberId=${memberId}" onsubmit="return isOsbpEmpty();">
					<table class="table-upload">
						<tr>
							<td width="40%" align="right">测量时间：</td>
							<td>
								<input type="text" name="startTime2" id="startTime2" readonly="readonly" onclick="SelectDate(this,'yyyy-MM-dd hh:mm:ss')" onchange="checkTime2()">
							</td>
						</tr>
						<tr>
							<td align="right">测量时间段：</td>
							<td>
								<select id="timePeriod1" name="timePeriod1">
									<option></option>
									<option value="0">其他（随机测量）</option>
									<option value="1">起床后2小时</option>
									<option value="2">睡觉前</option>
								</select>
							</td>
						</tr>
						<tr>
							<td align="right">收缩压：</td>
							<td>
								<input type="text" name="sbp" id="sbp" maxlength="8" />&nbsp;mmHg
							</td>
						</tr>
						<tr>
							<td align="right">舒张压：</td>
							<td>
								<input type="text" name="dbp" id="dbp" maxlength="8" />&nbsp;mmHg
							</td>
						</tr>
						<tr>
							<td align="right">脉率：</td>
							<td>
								<input type="text" name="pulseRate" id="pulseRate" maxlength="6" />&nbsp;次/分
							</td>
						<tr>
							<!-- <td align="right">上传方式：</td> -->
							<td>
								<input type="hidden" name="deviceCode1" id="deviceCode1" value="Hand" />
							</td>
						</tr>
						<tr>
							<td></td>
							<td>
								<input id="dd2" type="submit" value="提交" class="btn-normal" />
								<span>${uploadOsbp}</span>
							</td>
						</tr>
					</table>
				</form>
			</div>
			<div id="box4" class="tab_conbox_item2">
				<form enctype="multipart/form-data" method="post" action="../uploadMeasData/uploadBloodSugarData?memberId=${memberId}" onsubmit="return isObsrEmpty();">
					<table class="table-upload">
						<tr>
							<td width="40%" align="right">测量时间：</td>
							<td>
								<input type="text" name="startTime3" id="startTime3" readonly="readonly" onclick="SelectDate(this,'yyyy-MM-dd hh:mm:ss')" onchange="checkTime3()">
							</td>
						</tr>
						<tr>
							<td align="right">测量时间段：</td>
							<td>
								<select id="timePeriod2" name="timePeriod2">
									<option></option>
									<option value='0'>其它时间</option>
									<option value='1'>早餐前</option>
									<option value='2'>早餐后2小时</option>
									<option value='3'>午餐前</option>
									<option value='4'>午餐后2小时</option>
									<option value='5'>晚餐前</option>
									<option value='6'>晚餐后2小时</option>
									<option value='7'>睡前</option>
									<option value='8'>夜间</option>
								</select>
							</td>
						</tr>
						<tr>
							<td align="right">血糖值：</td>
							<td>
								<input type="text" name="bsValue" id="bsValue" maxlength="7" />
							</td>
						</tr>
						<td>
							<input type="hidden" name="deviceCode2" id="deviceCode2" value="Hand" />
						</td>
						<tr>
							<td>
							<td>
								<input id="dd3" type="submit" value="提交" class="btn-normal" />
								<span>${uploadObsr}</span>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<script src="<%=path %>/js/report.js" type="text/javascript"></script>
	</div>
</body>
</html>
