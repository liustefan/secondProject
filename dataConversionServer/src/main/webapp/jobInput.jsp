<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${basePath}/GlobalStyle/style.css" rel="stylesheet" type="text/css" />
<link href="${basePath}/themes/default/Site.css" rel="stylesheet" type="text/css" />
<!--皮肤样式-->
<link href="${basePath}/themes/default/css/jquery.ui.all.css" rel="stylesheet" type="text/css" />
<title>表单</title>
<%@ include file="common.jsp" %>
<script type="text/javascript"> 
	 function save(){
		 var name =$("#jobName").val();
		 if(!$.trim(name)){
			 alert("定时器的名称不能为空");
			 return false;
		 }
		 
		 var status=$('input:radio[name="jobStatus"]:checked').val();
		 if(!$.trim(status)){
			 alert("请选择状态");
			 return false;
		 }
		 
		
		 var month =$("#month").val();
		 var day =$("#day").val();
		 var r=/^[0-9*/]*$/; 
		 if(!r.test(day)){ //isNaN也行的,正则可以随意扩展 
			 alert('日期只能输入正整数和*');
		 		return false;
		 }else if(day>31){
			alert('日期必须小于31天');
				return false;
		 }
		
		 var hour =$("#hour").val();
		 if(!$.trim(hour)){
			alert('小时不能为空');
			return false;
		}else if(!r.test(hour)){ //isNaN也行的,正则可以随意扩展 
			 alert('小时只能输入正整数和*');
		 		return false;
		 }else if(hour>24){
			alert('小时必须小于24H');
				return false;
		 }
		 
		 var minute =$("#minute").val();
		 if(!$.trim(minute)){
			alert('分钟不能为空');
			return false;
		}else if(!r.test(minute)){ //isNaN也行的,正则可以随意扩展 
			 alert('分钟只能输入正整数和*');
		 		return false;
		 }else if(minute>60){
			alert('分钟必须小于60S');
				return false;
		 }
		 if(day==0||day==null||day ==''){
			 day="*";
		 }
		 if(month==0){
			 month="*";
		 }
		 var expre="0 "+minute+' '+hour+' '+day+' '+month+' ?';
		 $("#jobTimeExpression").val(expre);
		 
		 
		document.getElementById("jobConfigFrom").submit();
	 }
	 
	 function rese(){
		 window.location.href='${basePath}/jobConfigController/list.do';
	 }
	 
	 function init(){
		 var month="${map.month}";
		 if(month!="*" && month!=""){
		 	$("#month option[value='"+month+"']").attr("selected",true);
		 }
	 }
</script>

</head>

<body onload="init();">
<!--*************************当前位置*************************-->
<div id="location">
  <span class="ui-icon ui-icon-site"></span>
  <label>当前位置：</label>
  <a href="#">配置信息</a>
  &gt;
  <span class="ui-font-color-red">编辑</span>
</div>
<!--*************************当前位置****END*********************-->
<!--**每一个内容页面必须包含 wrapper 容器***
******且除当前位置以外所有页面内容都必须放***
*********置在 wrapper 容器之内*********-->
<div id="wrapper">
  <div role="tablist" id="chartcon" >
    <!--*************************输入表单*************************-->
    <div id="accordion" class="ui-accordion  ui-widget-content" role="tablist" style="padding:5px;">
      <div id="con_one_1"  name="a">
        <!--*************************单列输入表单*************************-->
        
        
        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="ui-table" id="con_one_1"  name="a">
         <form name="jobConfigFrom" id="jobConfigFrom" action="${basePath}/jobConfigController/update.do" method="post">
        <tbody>
	       <tr>
	          <th width="120" align="right">编号:<br /></th>
	          <td  width="15%">
	          <input type="hidden" name="id" id="id" value="${jobConfig.id}" /> 
	          <input type="text" class="ui-input-txt-must" id="jobId" name="jobId" value="${jobConfig.jobId}"  size="30"  /></td>
	          <td >&nbsp;</td>
	          <th>名称<span class="ui-input-must" >&nbsp;</span></th>
	          <td> <input type="text" class="ui-input-txt-must" id="jobName" name="jobName"  value="${jobConfig.jobName}" size="30" /></td>
	          <td >&nbsp;</td>
	        </tr>
      
         <tr>
            <th width="120">状态<span class="ui-input-must" >&nbsp;</span></th>
            <td colspan="6">
            	  <input type="radio" name="jobStatus" id="jobStatus" value="0" <c:if test="${jobConfig.jobStatus == '0'}"> checked=true </c:if> />启用
          		  <input type="radio" name="jobStatus" id="jobStatus" value="1" <c:if test="${jobConfig.jobStatus == '1'}"> checked=true </c:if>/>禁用
            </td>
            <td></td>
          </tr>
          <tr>
            <th>执行时间<span class="ui-input-must" >&nbsp;</span></td>
            <td colspan="6"><div class="icons">
            	<select id="month"  name="month" class="ui-input-txt-must">
            		<option	value="0">--全部*--</option>
            		<option value="1" >1</option><option value="2">2</option>
            		<option value="3">3</option><option value="4">4</option>
            		<option value="5">5</option><option value="6">6</option>
            		<option value="7">7</option><option value="8">8</option>
            		<option value="9">9</option><option value="10">10</option>
            		<option value="11">11</option><option value="12">12</option>
            	</select>
            	月
            	<input type="text" id="day" name="day" class="ui-input-txt-must"  maxlength="2"  value="${map.day}" size="2">日
            	<input type="text" id="hour" name="hour" class="ui-input-txt-must" maxlength="2" value="${map.hour}" size="2">时
            	<input type="text" name="minute" id="minute"  class="ui-input-txt-must" maxlength="3" value="${map.minute}" size="3">分
             	<span style="color:#F00">备注:如果月/日为*/为空/0，代表每月/每日执行</span>
               	<input type="hidden" class="ui-input-txt-must" id="jobTimeExpression" name="jobTimeExpression"  value="${jobConfig.jobTimeExpression}" size="80" />
              </div></td>
            <td></td>
          </tr>
          <tr>
            <th>备注<span class="ui-input-must" >&nbsp;</span></th>
            <td colspan="6"><textarea cols="80" rows="6" class="ui-textarea-style" id="jobDesc" name="jobDesc">${jobConfig.jobDesc}</textarea></td>
          </tr>
          <tr class="ui-pager ui-function-box">
            <td colspan="2">&nbsp;</td>
            <td colspan="6"><div class="icons">
                <input type="button" value="保存" onclick="save()";  class="ui-btn ui-btn-save" onmouseover="this.className='ui-btn ui-btn-save-hover'" onmouseout="this.className='ui-btn ui-btn-save'"/>
                <input type="button" value="取消" onclick="rese()"  class="ui-btn ui-btn-cancel" onmouseover="this.className='ui-btn ui-btn-cancel-hover'" onmouseout="this.className='ui-btn ui-btn-cancel'"/>
              </div></td>
          </tr>
          </tbody>
          </form>
        </table>
       
        <!--*************************单列输入表单*END************************-->
      </div>
    </div>
  </div>
</div>
<script>



	
	

</script>
<!--TAB脚本-->
</body>
</html>
