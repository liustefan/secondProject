<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
  String path = request.getContextPath();
%>

<!DOCTYPE html>
<html ng-app="checkUp">
<head>
<meta charset="utf-8">
<title>编辑健康体检详情</title>
<link rel="stylesheet" href="<%=path %>/css/general.css">
<link rel="stylesheet" href="<%=path %>/js/jquery-ui/themes/overcast/jquery-ui.min.css">
<link rel="stylesheet" href="<%=path %>/css/editCheckUpDetail.css">

<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/jquery-ui/jquery-ui.js"></script>
<script type="text/javascript" src="<%=path %>/js/jquery.validate.min.js"></script> 
<script type="text/javascript" src="<%=path %>/js/jquery.validate.messages_cn.js"></script>
<script type="text/javascript" src="<%=path %>/js/dataPacker.js"></script>
<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
<script type="text/javascript" src="<%=path %>/js/tab.js"></script>
<script type="text/javascript" src="<%=path %>/js/healthServicesComm.js"></script>
<script type="text/javascript" src="<%=path %>/js/editValid.js"></script>
<script>
function success(index){
	layer.close(index);
	location.href="../publicHealth/publicHealthAction!<c:if test='${empty omem}'>checkUpList</c:if><c:if test='${not empty omem}'>memberCheckUpList?omem.memberid=${omem.memberid}</c:if>";
}

$(function(){
	<c:choose>
		<c:when test="${not empty pojo.member}">
			if(${pojo.elderly})
				$('.elderly').show();
			else
				$('.elderly').hide();
			if(${pojo.member.gender == "2"})
				$('.genecology').show();
			else
				$('.genecology').hide();
		</c:when>
		<c:otherwise>
			$('.elderly').hide();
			$('.genecology').hide();
		</c:otherwise>
	</c:choose>
	
	$("input[type='radio'],input[type='checkbox']").change(function($this){
		if('phHealthexamdetail.sportFrequency' == $this.target.name){//体育锻炼
			var node = $($this.target.parentNode.parentNode.parentNode).find("input[value=4]");
			if(node.length === 1){
				$($this.target.parentNode.parentNode.parentNode.nextElementSibling).find("input").attr("disabled", node[0].checked);
				$($this.target.parentNode.parentNode.parentNode.nextElementSibling.nextElementSibling).find("input").attr("disabled", node[0].checked);
			}
		}
	});
});
</script>
</head>
<body ng-controller="checkUpCtrl">
  <div class="content">
  	<div class="content-title">健康体检 --- <c:if test="${empty pojo.HExamID}">新增</c:if><c:if test="${not empty pojo.HExamID}">修改</c:if></div>
    <form id="physical-examination" action="save" method="post">
      <input type="hidden" name="HExamID" value="${pojo.HExamID}">
      <input type="hidden" name="phHealthexamdetail.HExamID" value="${pojo.phHealthexamdetail.HExamID}"/>
      <input type="hidden" name="singleMembers" value="${param.singleMembers}">
   	  <table class="memberInfo search-wrapper">
        <tr>
          <td>健康档案编号：<input type="text" id="unique_ID" name="unique_ID" value="${pojo.unique_ID}"  readonly></td>
          <td>
   			<input type="hidden" id="memberId" name="memberID" value="${pojo.member.memberid}">
          	姓名：
			<input type="text" maxlength="10" class="fixed-width" id="memeberName" name="name" value="${pojo.member.memname}" required readonly>
			<c:if test="${empty pojo.member.memberid}">
       			<button type="button" class="button" onclick="openPage('会员','members')">...</button>
            </c:if>
            <label class="error" for="memeberName"></label></td>
          <td>体检编号：<input type="text" name="refDataPK" value="${pojo.refDataPK}" readonly="readonly"  size="32"></td>
        </tr>
        <tr>  
          <td>体检日期：<input class="info-date" id="startDate" type="text" name="examDate" value="<fmt:formatDate value='${pojo.examDate}' pattern="yyyy-MM-dd"/>" readonly="readonly" /> </td>
          <td>责任医生：
          <input type="text" class="fixed-width" maxlength="10" id="drName" name="responsibleDrName" value="${pojo.responsibleDrName}">
          <button type="button" class="button" onclick="openPage('选择医生','doctors')">...</button><label class="error" for="drName"></label>
          </td>
        </tr>
      </table>
      <nav>
        <ul id="tab_title" class="clearfix">
          <li>健康体检(必填项)</li>
          <li>健康体检(选填项)</li>
          <li>健康体检(其他)</li>
        </ul>
      </nav>
      <div class="tab-content">
        <div id="tab_conbox" class="clearfix">
          <section class="tab-conbox-item">
            <table class="table-normal table-fixed">
              <colgroup>
                <col span="2" width="10%" />
              </colgroup>
              <tr>
                <td class="top-info align-center">内容</td>
                <td colspan="9" class="align-center top-info">检查项目</td>
              </tr>
              <tr>
                <th>症状</th>
                <td colspan="9" id="symptomWrap">
                	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检/症状')}" var="dict" varStatus="var">
                		<label class="fl">
	                		<input class="input-center" name="phHealthexamdetail.symptom" type="checkbox" value="${dict.DItemID}" 
	                		<c:forEach items="${pojo.phHealthexamdetail.symptoms}" var="s">
	                			<c:if test="${dict.DItemID eq s}">checked="checked"</c:if>
	                		</c:forEach>
	                		/>
                			<span class="span-center">${dict.DItemName}</span>
                		</label>
                		<c:if test="${dict.DItemID eq 25}">
                			<input maxlength="100"  id="rest" class="middle fl-top" type="text" name="phHealthexamdetail.symptom_Desc" value="${pojo.phHealthexamdetail.symptom_Desc}">
						</c:if>
                	</c:forEach>
                </td>
              </tr>
              <tr>
                <th class="p_elderly" rowspan="${pojo.elderly ? 9 : 5}">一般状况</th>
                <td class="align-right" colspan="1">体温</td>
                <td colspan="3">
                  <input id="bodyTemperature" maxlength="5"  type="text"  name="phHealthexamdetail.bodyTemperature" value="${pojo.phHealthexamdetail.bodyTemperature}" onblur="VDblur2('bodyTemperature-error', '请输入一个介于 0 和 1000 之间且最多一位小数的值', 'bodyTemperature')">℃<span id="bodyTemperature-error" class="red"></span>
                </td>
                <td class="align-right" colspan="1">脉率</td>
                <td colspan="4">
                  <input id="pulseRate"  type="text" name="phHealthexamdetail.pulseRate" value="${pojo.phHealthexamdetail.pulseRate}" range="[-32768,32767]" 	digits="true" >次/分钟
                </td>
              </tr>
              <tr>
                <td rowspan="2" class="align-right">呼吸频率</td>
                <td rowspan="2" colspan="2">
                  <input id="respiratoryRate" type="text" name="phHealthexamdetail.respiratoryRate" value="${pojo.phHealthexamdetail.respiratoryRate}" range="[-32768,32767]" 	digits="true" >次/分钟
                </td>
                <td rowspan="2" class="align-right">血压</td>
                <td class="align-right" colspan="1">左侧</td>
                <td colspan="4">
                  <input id="leftSystolic" type="text" name="phHealthexamdetail.leftSystolic" value="${pojo.phHealthexamdetail.leftSystolic}" range="[-32768,32767]" 	digits="true" >/
                  <input id="leftDiastolic" type="text" name="phHealthexamdetail.leftDiastolic" value="${pojo.phHealthexamdetail.leftDiastolic}" range="[-32768,32767]" 	digits="true" >&nbsp;mmHg
                </td>
              </tr>
              <tr class="bgfff">
                <td class="align-right" colspan="1">右侧</td>
                <td colspan="4">
                  <input id="rightSystolic" type="text" name="phHealthexamdetail.rightSystolic" value="${pojo.phHealthexamdetail.rightSystolic}" range="[-32768,32767]" 	digits="true" >&nbsp;/&nbsp;
                  <input id="rightDiastolic" type="text" name="phHealthexamdetail.rightDiastolic" value="${pojo.phHealthexamdetail.rightDiastolic}" range="[-32768,32767]" 	digits="true" >mmHg
                </td>
              </tr>
              <tr>
                <td class="align-right" colspan="1">身高</td>
                <td colspan="2">
                  <input id="height" maxlength="6" type="text" name="phHealthexamdetail.height"  value="${pojo.phHealthexamdetail.height}" onchange="calcBMI('phHealthexamdetail.height', 'phHealthexamdetail.weight', 'phHealthexamdetail.BMI', 'bmides', 'BMI-error');" onblur="VDblur('height-error', '请输入一个介于 0 和 10000 之间且最多一位小数的值', 'height')">cm<span id="height-error" class="red"></span>
                </td>
                <td class="align-right" colspan="1">体重</td>
                <td colspan="5">
                  <input id="weight" maxlength="6" type="text" name="phHealthexamdetail.weight"  value="${pojo.phHealthexamdetail.weight}" onchange="calcBMI('phHealthexamdetail.height', 'phHealthexamdetail.weight', 'phHealthexamdetail.BMI', 'bmides', 'BMI-error');" onblur="VDblur('weight-error', '请输入一个介于 0 和 10000 之间且最多一位小数的值', 'weight')">Kg<span id="weight-error" class="red"></span>
                </td>
              </tr>
              <tr>
                <td class="align-right">腰围</td>
                <td colspan="2">
                  <input id="waist" maxlength="6" type="text" name="phHealthexamdetail.waist"  value="${pojo.phHealthexamdetail.waist}" onblur="VDblur('waist-error', '请输入一个介于 0 和 10000 之间且最多一位小数的值', 'waist')">cm<span id="waist-error" class="red"></span>
                </td>
                <td class="align-right">体质指数</td>
                <td colspan="5">
                  <input id="BMI" type="text" name="phHealthexamdetail.BMI"  value="${pojo.phHealthexamdetail.BMI}" readonly>
                  <span id="toggle">(<span id="bmides" class="red"></span>)</span><span id="BMI-error" class="red"></span>
                </td>
              </tr>
              <tr class="elderly">
                <td class="align-right">老年人健康状态自我评估</td>
                <td colspan="8">
                	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_一般状况/老年人健康状态自我评估')}" var="dict" varStatus="var">
                		<label>
                			<input class="input-center" name="phHealthexamdetail.agedHealthEvaluate" type="radio" value="${dict.DItemID}" 
	                		<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.agedHealthEvaluate}">checked="checked"</c:if>
	                		/>
                			<span class="span-center">${dict.DItemName}</span>
                		</label>
                	</c:forEach>
                </td>
              </tr>
              <tr class="elderly">
                <td class="align-right">老年人生活自理能力自我评估</td>
                <td colspan="8">
                	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_一般状况/老年人生活自理能力自我评估')}" var="dict" varStatus="var">
                		<label>
                			<input class="input-center" name="phHealthexamdetail.agedLifeEvaluate" type="radio" value="${dict.DItemID}" 
                			<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.agedLifeEvaluate}">checked="checked"</c:if>
                			/>
                			<span class="span-center">${dict.DItemName}</span>
               			</label>
                	</c:forEach>
                </td>
              </tr>
              <tr class="elderly">
                <td class="align-right">老年人认知功能</td>
                <td colspan="8">
                	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_一般状况/老年人认知功能')}" var="dict" varStatus="var">
                		<label>
                			<input class="input-center" name="phHealthexamdetail.agedCognition" type="radio" value="${dict.DItemID}" 
                			<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.agedCognition}">checked="checked"</c:if>
                			/>
                			<span class="span-center">${dict.DItemName}</span>
               			</label>
                	</c:forEach>
                  	<label>，简易智力状态检查，总分
                  		<input id="agedCognitionScore" name="phHealthexamdetail.agedCognitionScore" type="text" value="${pojo.phHealthexamdetail.agedCognitionScore}" range="[-128,127]" 	digits="true" />
               		</label>
                </td>
              </tr>
              <tr class="elderly">
                <td class="align-right">老年人情感状态</td>
                <td colspan="8">
                	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_一般状况/老年人情感状态')}" var="dict" varStatus="var">
                		<label>
                			<input class="input-center" name="phHealthexamdetail.agedFeeling" type="radio" value="${dict.DItemID}" 
                			<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.agedFeeling}">checked="checked"</c:if>
                			/>
                			<span class="span-center">${dict.DItemName}</span>
               			</label>
                	</c:forEach>
                 	<label>，老年人抑郁评分检查，总分
                 		<input id="agedFeelingScore" name="phHealthexamdetail.agedFeelingScore" type="text" value="${pojo.phHealthexamdetail.agedFeelingScore}" range="[-128,127]" 	digits="true" />
               		</label>
                </td>
              </tr>
              <tr>
                <th rowspan="16">生活方式</th>
                <td rowspan="3" class="align-right">体育锻炼</td>
                <td class="align-right">锻炼频率</td>
                <td colspan="7" id="temper">
                	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_生活方式_体育锻炼/锻炼频率')}" var="dict" varStatus="var">
                		<label>
                			<input class="input-center" name="phHealthexamdetail.sportFrequency" type="radio" value="${dict.DItemID}" 
                			<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.sportFrequency}">checked="checked"</c:if>
                			/>
                			<span class="span-center">${var.index+1}.${dict.DItemName}</span>
                		</label>
                	</c:forEach>
                </td>
              </tr>
              <tr class="temper-input">
                <td class="align-right" colspan="1">每次锻炼时间</td>
                <td colspan="2">
                  <input id="sportDuration" type="text" name="phHealthexamdetail.sportDuration" value="${pojo.phHealthexamdetail.sportDuration}" range="[-32768,32767]" 	digits="true" >分钟
                </td>
                <td class="align-right" colspan="1">坚持锻炼时间</td>
                <td colspan="4">
                  <input id="sportTotalTime" type="text" name="phHealthexamdetail.sportTotalTime" value="${pojo.phHealthexamdetail.sportTotalTime}" range="[-128,127]" 	digits="true" >年
                </td>
              </tr>
              <tr class="temper-input">
                <td class="align-right">锻炼方式</td>
                <td colspan="7">
                  <input maxlength="50" type="text" class="longer" name="phHealthexamdetail.sportWay" value="${pojo.phHealthexamdetail.sportWay}">
                </td>
              </tr>
              <tr>
                <td class="align-right">饮食习惯</td>
                <td colspan="8">
                	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_生活方式/饮食习惯')}" var="dict" varStatus="var">
                		<label>
                			<input class="input-center" name="phHealthexamdetail.eatingHabits" type="checkbox" value="${dict.DItemID}" 
                			<c:forEach items="${pojo.phHealthexamdetail.eatingHabitses}" var="s">
                				<c:if test="${dict.DItemID eq s}">checked="checked"</c:if>
                			</c:forEach>
                			/>
                			<span class="span-center">${var.index+1}.${dict.DItemName}</span>
                		</label>
                	</c:forEach>
                </td>
              </tr>
              <tr>
                <td rowspan="2" class="align-right">吸烟情况</td>
                <td class="align-right">吸烟状况</td>
                <td colspan="7" id="smoke-rate">
                	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_生活方式_吸烟情况/吸烟状况')}" var="dict" varStatus="var">
                		<label>
                			<input class="input-center" name="phHealthexamdetail.smokingState" type="radio" value="${dict.DItemID}" 
                			<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.smokingState}">checked="checked"</c:if>
                			/>
                			<span class="span-center">${var.index+1}.${dict.DItemName}</span>
               			</label>
                	</c:forEach>
                </td>
              </tr>
              <tr class="smokingWrap">
                <td class="align-right">日吸烟量</td>
                <td class="" colspan="2">平均
                	<input id="dailySmoking" type="text" name="phHealthexamdetail.dailySmoking" value="${pojo.phHealthexamdetail.dailySmoking}" range="[-32768,32767]" 	digits="true" >支
                </td>
                <td class="align-right">开始吸烟年龄</td>
                <td colspan="2">
                  <input id="smokingStartAge" type="text" name="phHealthexamdetail.smokingStartAge" value="${pojo.phHealthexamdetail.smokingStartAge}" range="[-128,127]" 	digits="true" >岁
                </td>
                <td class="align-right">戒烟年龄</td>
                <td>
                  <input id="smokingEndAge" type="text" name="phHealthexamdetail.smokingEndAge" value="${pojo.phHealthexamdetail.smokingEndAge}" range="[-128,127]" 	digits="true" >岁
                </td>
              </tr>
              <tr>
                <td rowspan="4" class="align-right">饮酒情况</td>
                <td class="align-right">饮酒频率</td>
                <td colspan="7" id="drink-rate">
                	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_生活方式_饮酒情况/饮酒频率')}" var="dict" varStatus="var">
                		<label>
                			<input class="input-center" name="phHealthexamdetail.drinkFrequency" type="radio" value="${dict.DItemID}" 
                			<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.drinkFrequency}">checked="checked"</c:if>
                			/>
                			<span class="span-center">${var.index+1}.${dict.DItemName}</span>
               			</label>
                	</c:forEach>
                </td>
              </tr>
              <tr class="drinkWrap">
                <td class="align-right">日饮酒量</td>
                <td class="" colspan="2">平均
                	<input id="dailyDrink" type="text" maxlength="4" name="phHealthexamdetail.dailyDrink" value="${pojo.phHealthexamdetail.dailyDrink}" onblur="VDblur3('dailyDrink-error', '请输入一个介于 0 和 100之间且最多一位小数的值', 'dailyDrink')">两<span id="dailyDrink-error" class="red"></span>
                </td>
                <td class="align-right">是否戒酒</td>
                <td id="wine" colspan="2">
                	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_生活方式_饮酒情况/是否戒酒')}" var="dict" varStatus="var">
                		<label>
                			<input class="input-center" name="phHealthexamdetail.isAbstinence" type="radio" value="${dict.DItemID}" 
                			<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.isAbstinence}">checked="checked"</c:if>
                			/>
                			<span class="span-center">${var.index+1}.${dict.DItemName}</span>
               			</label>
                	</c:forEach>
                </td>
                <td class="align-right" colspan="1">戒酒年龄</td>
                <td>
                  <input id="abstinenceAge" name="phHealthexamdetail.abstinenceAge" type="text" value="${pojo.phHealthexamdetail.abstinenceAge}" range="[-128,127]" 	digits="true" >岁
                </td>
              </tr>
              <tr class="drinkWrap">
                <td class="align-right">开始饮酒年龄</td>
                <td colspan="2">
                  <input id="drinkStartAge" name="phHealthexamdetail.drinkStartAge" type="text" value="${pojo.phHealthexamdetail.drinkStartAge}" range="[-128,127]" 	digits="true" >岁
                </td>
                <td colspan="3" class="align-right">近一年是否曾醉酒</td>
                <td colspan="2">
                	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_生活方式_饮酒情况/近一年内是否曾醉酒')}" var="dict" varStatus="var">
                		<label>
                			<input class="input-center" name="phHealthexamdetail.isTemulenceLastYear" type="radio" value="${dict.DItemID}" 
                			<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.isTemulenceLastYear}">checked="checked"</c:if>
                			/>
                			<span class="span-center">${var.index+1}.${dict.DItemName}</span>
               			</label>
                	</c:forEach>
                </td>
              </tr>
              <tr class="drinkWrap">
                <td class="align-right">饮酒种类</td>
                <td colspan="7" id="wine-type">
                	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_生活方式_饮酒情况/饮酒种类')}" var="dict" varStatus="var">
                		<label>
                			<input class="input-center" name="phHealthexamdetail.drinkType" type="checkbox" value="${dict.DItemID}" 
                			<c:forEach items="${pojo.phHealthexamdetail.drinkTypes}" var="s">
                				<c:if test="${dict.DItemID eq s}">checked="checked"</c:if>
                			</c:forEach>
                			/>
                			<span class="span-center">${var.index+1}.${dict.DItemName}</span>
               			</label>
                	</c:forEach>
                  <input maxlength="50" class="middle" type="text" name="phHealthexamdetail.drinkOther_Desc" value="${pojo.phHealthexamdetail.drinkOther_Desc}">
                </td>
              </tr>
              <tr>
                <td rowspan="6" class="align-right">职业暴露情况</td>
                <td colspan="8" id="vocation">
                  <c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_生活方式/职业病危害因素接触史')}" var="dict" varStatus="var">
                  	<label class="height-23">
                  		<input class="input-center" name="phHealthexamdetail.occupation" type="radio" value="${dict.DItemID}" 
                  		<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.occupation}">checked="checked"</c:if>
                  		/>
                  		<span class="span-center">${var.index+1}.${dict.DItemName}</span>
               		</label>
                  </c:forEach>
                  <label>（具体职业
                    <select name="phHealthexamdetail.typeOfWork">
                      <option <c:if test="${pojo.phHealthexamdetail.typeOfWork eq '国家机关党群组织、企业、事业单位负责人'}">selected="selected"</c:if> value="国家机关、党群组织、企业、事业单位负责人">国家机关、党群组织、企业、事业单位负责人</option>
					  <option <c:if test="${pojo.phHealthexamdetail.typeOfWork eq '专业技术人员'}">selected="selected"</c:if> value="专业技术人员">专业技术人员</option>
					  <option <c:if test="${pojo.phHealthexamdetail.typeOfWork eq '办事人员和有关人'}">selected="selected"</c:if> value="办事人员和有关人">办事人员和有关人</option>
					  <option <c:if test="${pojo.phHealthexamdetail.typeOfWork eq '商业、服务业人员'}">selected="selected"</c:if> value="商业、服务业人员">商业、服务业人员</option>
					  <option <c:if test="${pojo.phHealthexamdetail.typeOfWork eq '农、林、牧、渔、水利专业产人员'}">selected="selected"</c:if> value="农、林、牧、渔、水利专业产人员">农、林、牧、渔、水利专业产人员</option>
					  <option <c:if test="${pojo.phHealthexamdetail.typeOfWork eq '生成、运输设备操作人员及有关人员'}">selected="selected"</c:if> value="生成、运输设备操作人员及有关人员">生成、运输设备操作人员及有关人员</option>
					  <option <c:if test="${pojo.phHealthexamdetail.typeOfWork eq '军人'}">selected="selected"</c:if> value="军人">军人</option>
					  <option <c:if test="${pojo.phHealthexamdetail.typeOfWork eq '不便分类的其他从业人员'}">selected="selected"</c:if> value="不便分类的其他从业人员">不便分类的其他从业人员</option>
                    </select>）
                  </label>
                  <label>从业时间
                  	<input id="workTime" type="text" name="phHealthexamdetail.workTime" value="${pojo.phHealthexamdetail.workTime}" range="[-128,127]" 	digits="true" >年
                  </label>
                </td>
              </tr>
              <tr class="occupationWrap">
                <td rowspan="5" class="align-center">毒物种类</td>
                <td class="align-right">化学物质</td>
                <td colspan="2">
                  <input maxlength="25" type="text" class="middle" name="phHealthexamdetail.chemical" value="${pojo.phHealthexamdetail.chemical}">
                </td>
                <td rowspan="5" class="align-center" colspan="1">防护措施</td>
                <td colspan="3" id="chemicalGuard">
                	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_生活方式_职业病危害因素接触史/化学物质防护措施')}" var="dict" varStatus="var">
                		<label>
                			<input class="input-center" name="phHealthexamdetail.chemicalGuard" type="radio" value="${dict.DItemID}" 
                			<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.chemicalGuard}">checked="checked"</c:if>
                			/>
                			<span class="span-center">${var.index+1}.${dict.DItemName}</span>
               			</label>
                	</c:forEach>
                  	<input id="chemicalGuard-input" maxlength="25" type="text" class="middle" name="phHealthexamdetail.chemicalGuard_Desc" value="${pojo.phHealthexamdetail.chemicalGuard_Desc}">
                </td>
              </tr>
              <tr class="occupationWrap">
                <td class="align-right">物理因素</td>
                <td colspan="2">
                  <input maxlength="25" type="text" class="middle" name="phHealthexamdetail.physical" value="${pojo.phHealthexamdetail.physical}">
                </td>
                <td colspan="3" id="physicalGuard">
                	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_生活方式_职业病危害因素接触史/物理因素防护措施')}" var="dict" varStatus="var">
                		<label>
                			<input class="input-center" name="phHealthexamdetail.physicalGuard" type="radio" value="${dict.DItemID}" 
                			<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.physicalGuard}">checked="checked"</c:if>
                			/>
                			<span class="span-center">${var.index+1}.${dict.DItemName}</span>
               			</label>
                	</c:forEach>
                  	<input id="physicalGuard-input" maxlength="25" type="text" class="middle" name="phHealthexamdetail.physicalGuard_Desc" value="${pojo.phHealthexamdetail.physicalGuard_Desc}">
                </td>
              </tr>
              <tr class="occupationWrap">
                <td class="align-right">放射物质</td>
                <td colspan="2"> 
                  <input maxlength="25" type="text" class="middle" name="phHealthexamdetail.radiogen" value="${pojo.phHealthexamdetail.radiogen}">
                </td>
                <td colspan="3" id="radiogenGuard">
                	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_生活方式_职业病危害因素接触史/放射物质防护措施')}" var="dict" varStatus="var">
                		<label>
                			<input class="input-center" name="phHealthexamdetail.radiogenGuard" type="radio" value="${dict.DItemID}" 
                			<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.radiogenGuard}">checked="checked"</c:if>
                			/>
                			<span class="span-center">${var.index+1}.${dict.DItemName}</span>
               			</label>
                	</c:forEach>
                  	<input id="radiogenGuard-input" maxlength="25" type="text" class="middle" name="phHealthexamdetail.radiogenGuard_Desc" value="${pojo.phHealthexamdetail.radiogenGuard_Desc}">
                </td>
              </tr>
              <tr class="occupationWrap">
                <td class="align-right">粉尘</td>
                <td colspan="2">
                  <input maxlength="25" type="text" class="middle" name="phHealthexamdetail.dust" value="${pojo.phHealthexamdetail.dust}">
                </td>
                <td colspan="3" id="dustGuard">
                	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_生活方式_职业病危害因素接触史/粉尘防护措施')}" var="dict" varStatus="var">
                		<label>
                			<input class="input-center" name="phHealthexamdetail.dustGuard" type="radio" value="${dict.DItemID}" 
                			<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.dustGuard}">checked="checked"</c:if>
                			/>
                			<span class="span-center">${var.index+1}.${dict.DItemName}</span>
               			</label>
                	</c:forEach>
                  	<input id="dustGuard-input" maxlength="25" type="text" class="middle" name="phHealthexamdetail.dustGuard_Desc" value="${pojo.phHealthexamdetail.dustGuard_Desc}">
                </td>
              </tr>
              <tr class="occupationWrap">
                <td class="align-right">其他</td>
                <td colspan="2">
                  <input maxlength="25" type="text" class="middle" name="phHealthexamdetail.toxicOther" value="${pojo.phHealthexamdetail.toxicOther}">
                </td>
                <td colspan="3" id="toxicOtherGuard">
                	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_生活方式_职业病危害因素接触史/其他防护措施')}" var="dict" varStatus="var">
                		<label>
                			<input class="input-center" name="phHealthexamdetail.toxicOtherGuard" type="radio" value="${dict.DItemID}" 
                			<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.toxicOtherGuard}">checked="checked"</c:if>
                			/>
                			<span class="span-center">${var.index+1}.${dict.DItemName}</span>
               			</label>
                	</c:forEach>
                  	<input id="toxicOtherGuard-input" maxlength="25" type="text" class="middle" name="phHealthexamdetail.toxicOtherGuard_Desc" value="${pojo.phHealthexamdetail.toxicOtherGuard_Desc}">
                </td>
              </tr>
            </table>
          </section>
          <!-- 必填项 end -->
          <section class="tab-conbox-item">
            <table class="table-normal table-fixed">
              <colgroup>
                <col span="2" width="10%" />
              </colgroup>
              <tr>
                <th rowspan="6">脏器功能</th>
                <td rowspan="3" class="align-right bgfff">口腔</td>
                <td colspan="1" class="align-right">口唇</td>
                <td colspan="8">
                	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_脏器功能_口腔/口唇')}" var="dict" varStatus="var">
                		<label>
                			<input class="input-center" name="phHealthexamdetail.lips" type="radio" value="${dict.DItemID}" 
                			<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.lips}">checked="checked"</c:if>
                			/>
                			<span class="span-center">${var.index+1}.${dict.DItemName}</span>
               			</label>
                	</c:forEach>
                </td>
              </tr>
              <tr>
                <td colspan="1" class="align-right">齿列</td>
                <td colspan="4">
                	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_脏器功能_口腔/齿列')}" var="dict" varStatus="var">
                		<label>
                			<input class="input-center" name="phHealthexamdetail.dentition" type="radio" value="${dict.DItemID}" 
                			<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.dentition}">checked="checked"</c:if>
                			/>
                			<span class="span-center">${var.index+1}.${dict.DItemName}</span>
               			</label>
                	</c:forEach>
                </td>
                <td colspan="1" class="align-right">说明</td>
                <td colspan="3">
                  <input maxlength="50" id="explain" class="middle" name="phHealthexamdetail.dentition_Desc" type="text" value="${pojo.phHealthexamdetail.dentition_Desc}">
                </td>
              </tr>
              <tr>
                <td colspan="1" class="align-right">咽部</td>
                <td colspan="8">
                	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_脏器功能_口腔/咽部')}" var="dict" varStatus="var">
                		<label>
                			<input class="input-center" name="phHealthexamdetail.throat" type="radio" value="${dict.DItemID}" 
                			<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.throat}">checked="checked"</c:if>
                			/>
                			<span class="span-center">${var.index+1}.${dict.DItemName}</span>
               			</label>
                	</c:forEach>
                </td>
              </tr>
              <tr>
                <td class="align-right">视力</td>
                <td class="align-right">左眼</td>
                <td colspan="1">
                  <input id="leftVision" maxlength="4"  name="phHealthexamdetail.leftVision" type="text" value="${pojo.phHealthexamdetail.leftVision}" onblur="VDblur3('leftVision-error', '请输入一个介于 0 和 100 之间且最多一位小数的值', 'leftVision')"><span id="leftVision-error" class="red"></span>
                </td>
                <td class="align-right">右眼</td>
                <td colspan="1">
                  <input id="rightVision" maxlength="4" name="phHealthexamdetail.rightVision" type="text" value="${pojo.phHealthexamdetail.rightVision}" onblur="VDblur3('rightVision-error', '请输入一个介于 0 和 100 之间且最多一位小数的值', 'rightVision')"><span id="rightVision-error" class="red"></span>
                </td>
                <td colspan="1"  class="align-right">矫正视力：左眼</td>
                <td>
                  <input id="leftCorrectVision" maxlength="4" name="phHealthexamdetail.leftCorrectVision" type="text" value="${pojo.phHealthexamdetail.leftCorrectVision}" onblur="VDblur3('leftCorrectVision-error', '请输入一个介于 0 和 100 之间且最多一位小数的值', 'leftCorrectVision')"><span id="leftCorrectVision-error" class="red"></span>
                </td>
                <td colspan="1" class="align-right">矫正视力：右眼</td>
                <td colspan="2">
                  <input id="rightCorrectVision" maxlength="4" name="phHealthexamdetail.rightCorrectVision" type="text" value="${pojo.phHealthexamdetail.rightCorrectVision}" onblur="VDblur3('rightCorrectVision-error', '请输入一个介于 0 和 100 之间且最多一位小数的值', 'rightCorrectVision')"><span id="rightCorrectVision-error" class="red"></span>
                </td>
              </tr>
              <tr>
                <td class="align-right">听力</td>
                <td colspan="9">
                	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_脏器功能/听力')}" var="dict" varStatus="var">
                		<label>
                			<input class="input-center" name="phHealthexamdetail.hearing" type="radio" value="${dict.DItemID}" 
                			<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.hearing}">checked="checked"</c:if>
                			/>
                			<span class="span-center">${var.index+1}.${dict.DItemName}</span>
               			</label>
                	</c:forEach>
                </td>
              </tr>
              <tr>
                <td class="align-right">运动能力</td>
                <td colspan="9">
                	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_脏器功能/运动功能')}" var="dict" varStatus="var">	
                		<label>
                			<input class="input-center" name="phHealthexamdetail.movement" type="radio" value="${dict.DItemID}" 
                			<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.movement}">checked="checked"</c:if>
                			/>
                			<span class="span-center">${var.index+1}.${dict.DItemName}</span>
               			</label>
                	</c:forEach>
                </td>
              </tr>
              <tr>
                <th class="p_genecology" rowspan="${pojo.member.gender == '2' ? 20: 14}">查体</th>
                <td class="align-right">眼底</td>
                <td colspan="9" id="fundus">
	                <c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_查体/眼底')}" var="dict" varStatus="var">
						<label>
							<input class="input-center" name="phHealthexamdetail.eyeground" type="radio" value="${dict.DItemID}" 
							<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.eyeground}">checked="checked"</c:if>
							/>
							<span class="span-center">${var.index+1}.${dict.DItemName}</span>
						</label>
					</c:forEach>
                  	<input maxlength="50" class="middle" id="eye-input" type="text" name="phHealthexamdetail.eyeground_Desc" value="${pojo.phHealthexamdetail.eyeground_Desc}">
                </td>
              </tr>
              <tr>
                <td class="align-right">皮肤</td>
                <td colspan="9" id="skin">
                	 <c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_查体/皮肤')}" var="dict" varStatus="var">
						<label>
							<input class="input-center" name="phHealthexamdetail.skin" type="radio" value="${dict.DItemID}" 
							<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.skin}">checked="checked"</c:if>
							/>
							<span class="span-center">${var.index+1}.${dict.DItemName}</span>
						</label>
					</c:forEach>
                  	<input maxlength="50" class="middle" id="skin-input" type="text" name="phHealthexamdetail.skin_Desc" value="${pojo.phHealthexamdetail.skin_Desc}">
                </td>
              </tr>
              <tr>
                <td class="align-right">巩膜</td>
                <td colspan="9" id="sclero">
                	 <c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_查体/巩膜')}" var="dict" varStatus="var">
						<label>
							<input class="input-center" name="phHealthexamdetail.sclero" type="radio" value="${dict.DItemID}" 
							<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.sclero}">checked="checked"</c:if>
							/>
							<span class="span-center">${var.index+1}.${dict.DItemName}</span>
						</label>
					</c:forEach>
                  	<input maxlength="50" class="middle" id="sclero-input" type="text" name="phHealthexamdetail.sclero_Desc" value="${pojo.phHealthexamdetail.sclero_Desc}">
                </td>
              </tr>
              <tr>
                <td class="align-right">淋巴结</td>
                <td colspan="9" id="lymph">
                 	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_查体/淋巴结')}" var="dict" varStatus="var">
						<label>
							<input class="input-center"  name="phHealthexamdetail.lymph" type="radio" value="${dict.DItemID}" 
							<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.lymph}">checked="checked"</c:if>
							/>
							<span class="span-center">${var.index+1}.${dict.DItemName}</span>
						</label>
					</c:forEach>
                  	<input maxlength="50" class="middle" id="lymph-input" type="text" name="phHealthexamdetail.lymph_Desc" value="${pojo.phHealthexamdetail.lymph_Desc}">
                </td>
              </tr>
              <tr>
                <td rowspan="2" class="align-right">肺</td>
                <td colspan="4">
                    <p class="clearfix"><span class="left-span">桶状胸：</span>
                 	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_查体_肺/桶状胸')}" var="dict" varStatus="var">
						<label>
							<input class="input-center" name="phHealthexamdetail.lungBarrelChest" type="radio" value="${dict.DItemID}" 
							<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.lungBarrelChest}">checked="checked"</c:if>
							/>
							<span class="span-center">${var.index+1}.${dict.DItemName}</span>
						</label>
					</c:forEach>
					</p>
                </td>
                <td colspan="5" id="breathe-voice">
                   <p class="clearfix"><span class="left-span">呼吸音：</span>
                 	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_查体_肺/呼吸音')}" var="dict" varStatus="var">
						<label>
							<input class="input-center" name="phHealthexamdetail.lungBreathSounds" type="radio" value="${dict.DItemID}" 
							<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.lungBreathSounds}">checked="checked"</c:if>
							/>
							<span class="span-center">${var.index+1}.${dict.DItemName}</span>
						</label>
					</c:forEach>
                  	<input maxlength="50" class="middle" id="breathe-input" type="text" name="phHealthexamdetail.lungBreathSounds_Desc" value="${pojo.phHealthexamdetail.lungBreathSounds_Desc}">
                  </p>
                </td>
              </tr>
              <tr>
                <td colspan="9" id="lungRales">
                  <p class="clearfix"><span class="left-span">罗音：</span>
                	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_查体_肺/罗音')}" var="dict" varStatus="var">
						<label>
							<input class="input-center" name="phHealthexamdetail.lungRales" type="radio" value="${dict.DItemID}" 
							<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.lungRales}">checked="checked"</c:if>
							/>
							<span class="span-center">${var.index+1}.${dict.DItemName}</span>
						</label> 
					</c:forEach>
                  	<input maxlength="50" class="middle" id="lungRales-input" type="text" name="phHealthexamdetail.lungRales_Desc" value="${pojo.phHealthexamdetail.lungRales_Desc}">
                 </p>
                </td>
              </tr>
              <tr>
                <td rowspan="2" class="align-right">心脏</td>
                <td colspan="4">
                  <label>心率：
                  	<input id="heartRate" type="text" name="phHealthexamdetail.heartRate" value="${pojo.phHealthexamdetail.heartRate}" range="[-32768,32767]" 	digits="true" >次/分钟
                  </label>
                </td>
                <td colspan="5">
                	<p class="clearfix"><span class="left-span">心律：</span>
                	 	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_查体_心脏/心律')}" var="dict" varStatus="var">
							<label>
								<input class="input-center" name="phHealthexamdetail.rhythm" type="radio" value="${dict.DItemID}" 
								<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.rhythm}">checked="checked"</c:if>
								/>
								<span class="span-center">${var.index+1}.${dict.DItemName}</span>
							</label>
						</c:forEach>
					</p>
                </td>
              </tr>
              <tr>
                <td colspan="9" id="murmur">
                  <p class="clearfix"><span class="left-span">杂音：</span>
                 	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_查体_心脏/杂音')}" var="dict" varStatus="var">
						<label>
							<input class="input-center" name="phHealthexamdetail.murmur" type="radio" value="${dict.DItemID}" 
							<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.murmur}">checked="checked"</c:if>
							/>
							<span class="span-center">${var.index+1}.${dict.DItemName}</span>
						</label>
					</c:forEach>
                  	<input maxlength="50" class="middle" id="murmur-input" type="text" name="phHealthexamdetail.murmur_Desc" value="${pojo.phHealthexamdetail.murmur_Desc}">
                  </p>
                </td>
              </tr>
              <tr>
                <td rowspan="3" class="align-right">腹部</td>
                <td colspan="4" id="pain">
                  <p class="clearfix"><span class="left-span">压痛：</span>
                 	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_查体_腹部/压痛')}" var="dict" varStatus="var">
						<label>
							<input class="input-center" name="phHealthexamdetail.pain" type="radio" value="${dict.DItemID}" 
							<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.pain}">checked="checked"</c:if>
							/>
							<span class="span-center">${var.index+1}.${dict.DItemName}</span>
						</label>
					</c:forEach>
                  	<input maxlength="50" class="middle" id="pain-input" type="text" name="phHealthexamdetail.pain_Desc" value="${pojo.phHealthexamdetail.pain_Desc}">
                  </p>
                </td>
                <td colspan="5" id="block">
                  <p class="clearfix"><span class="left-span">包块：</span>
                 	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_查体_腹部/包块')}" var="dict" varStatus="var">
						<label>
							<input class="input-center" name="phHealthexamdetail.block" type="radio" value="${dict.DItemID}" 
							<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.block}">checked="checked"</c:if>
							/>
							<span class="span-center">${var.index+1}.${dict.DItemName}</span>
						</label>
					</c:forEach>
                  	<input maxlength="50" class="middle" id="block-input" type="text" name="phHealthexamdetail.block_Desc" value="${pojo.phHealthexamdetail.block_Desc}">
                  </p>
                </td>
              </tr>
              <tr>
                <td colspan="4" id="hepatomegaly">
                  <p class="clearfix"><span class="left-span">肝大：</span>
                 	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_查体_腹部/肝大')}" var="dict" varStatus="var">
						<label>
							<input class="input-center" name="phHealthexamdetail.hepatomegaly" type="radio" value="${dict.DItemID}" 
							<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.hepatomegaly}">checked="checked"</c:if>
							/>
							<span class="span-center">${var.index+1}.${dict.DItemName}</span>
						</label>
					</c:forEach>
                  	<input maxlength="50" class="middle" id="hepatomegaly-input" type="text" name="phHealthexamdetail.hepatomegaly_Desc" value="${pojo.phHealthexamdetail.hepatomegaly_Desc}">
                  </p>
                </td>
                <td colspan="5" id="splenomegaly">
                  <p class="clearfix"><span class="left-span">脾大：</span>
                 	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_查体_腹部/脾大')}" var="dict" varStatus="var">
						<label>
							<input class="input-center" name="phHealthexamdetail.splenomegaly" type="radio" value="${dict.DItemID}" 
							<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.splenomegaly}">checked="checked"</c:if>
							/>
							<span class="span-center">${var.index+1}.${dict.DItemName}</span>
						</label>
					</c:forEach>
                  	<input maxlength="50" class="middle" id="splenomegaly-input" type="text" name="phHealthexamdetail.splenomegaly_Desc" value="${pojo.phHealthexamdetail.splenomegaly_Desc}">
                  </p>
                </td>
              </tr>
              <tr>
                <td colspan="9" id="moveSonant"><p class="clearfix"><span class="left-span">移动性浊音：</span>
                 	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_查体_腹部/移动浊音')}" var="dict" varStatus="var">
						<label>
							<input class="input-center" name="phHealthexamdetail.moveSonant" type="radio" value="${dict.DItemID}" 
							<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.moveSonant}">checked="checked"</c:if>
							/>
							<span class="span-center">${var.index+1}.${dict.DItemName}</span>
						</label>
					</c:forEach>
                  	<input maxlength="50" class="middle" id="moveSonant-input" type="text" name="phHealthexamdetail.moveSonant_Desc" value="${pojo.phHealthexamdetail.moveSonant_Desc}">
                  </p>
                </td>
              </tr>
              <tr>
                <td class="align-right">下肢水肿</td>
                <td colspan="9">
                 	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_查体/下肢水肿')}" var="dict" varStatus="var">
						<label>
							<input class="input-center" name="phHealthexamdetail.lowLimbEdema" type="radio" value="${dict.DItemID}" 
							<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.lowLimbEdema}">checked="checked"</c:if>
							/>
							<span class="span-center">${var.index+1}.${dict.DItemName}</span>
						</label>
					</c:forEach>
                </td>
              </tr>
              <tr>
                <td class="align-right">足背动脉搏动</td>
                <td colspan="9">
                 	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_查体/足背动脉搏动')}" var="dict" varStatus="var">
						<label>
							<input class="input-center" name="phHealthexamdetail.arteriopalmus" type="radio" value="${dict.DItemID}" 
							<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.arteriopalmus}">checked="checked"</c:if>
							/>
							<span class="span-center">${var.index+1}.${dict.DItemName}</span>
						</label>
					</c:forEach>
                </td>
              </tr>
              <tr>
                <td class="align-right">肛门指诊</td>
                <td colspan="9" id="anusTactus">
                 	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_查体/肛门指诊')}" var="dict" varStatus="var">
						<label>
							<input class="input-center" name="phHealthexamdetail.anusTactus" type="radio" value="${dict.DItemID}" 
							<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.anusTactus}">checked="checked"</c:if>
							/>
							<span class="span-center">${var.index+1}.${dict.DItemName}</span>
						</label>
					</c:forEach>
                  	<input maxlength="50" class="middle" id="anusTactus-input" type="text" name="phHealthexamdetail.anusTactus_Desc" value="${pojo.phHealthexamdetail.anusTactus_Desc}">
                </td>
              </tr>
                <tr class="genecology">
                  <td rowspan="6" class="align-right">妇科</td>
                  <td class="align-right">乳腺</td>
                  <td colspan="8" id="breastCheck">
                      <c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_查体/乳腺')}" var="dict" varStatus="var">
                        <label>
                        	<input class="input-center" name="phHealthexamdetail.breast" type="checkbox" value="${dict.DItemID}" 
                        	<c:forEach items="${pojo.phHealthexamdetail.breasts}" var="s">
                             	<c:if test="${dict.DItemID eq s}">checked="checked"</c:if>
                        	</c:forEach>
                        	/>
                        	<span class="span-center">${var.index+1}.${dict.DItemName}</span>
                       	</label>
                    </c:forEach>
                    <input maxlength="50" id="breastCheck-input" class="middle" type="text" name="phHealthexamdetail.breast_Desc" value="${pojo.phHealthexamdetail.breast_Desc}">
                  </td>
                </tr>
                <tr class="genecology">
                  <td class="align-right">外阴</td>
                  <td colspan="8" id="pudendumRadio">
                  	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_查体_妇科/外阴')}" var="dict" varStatus="var">
						<label>
							<input class="input-center" name="phHealthexamdetail.pudendum" type="radio" value="${dict.DItemID}" 
							<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.pudendum}">checked="checked"</c:if>
							/>
							<span class="span-center">${var.index+1}.${dict.DItemName}</span>
						</label>
					</c:forEach>
                    <input id="pudendumRadio-input" maxlength="50" class="middle"  type="text" name="phHealthexamdetail.pudendum_Desc" value="${pojo.phHealthexamdetail.pudendum_Desc}">
                  </td>
                </tr>
                <tr class="genecology">
                  <td class="align-right">阴道</td>
                  <td colspan="8" id="vaginaRadio">
                  	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_查体_妇科/阴道')}" var="dict" varStatus="var">
						<label>
							<input class="input-center" name="phHealthexamdetail.vagina" type="radio" value="${dict.DItemID}" 
							<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.vagina}">checked="checked"</c:if>
							/>
							<span class="span-center">${var.index+1}.${dict.DItemName}</span>
						</label>
					</c:forEach>
                    <input id="vaginaRadio-input" maxlength="50" class="middle"  type="text" name="phHealthexamdetail.vagina_Desc" value="${pojo.phHealthexamdetail.vagina_Desc}">
                  </td>
                </tr>
                <tr class="genecology">
                  <td class="align-right">宫颈</td>
                  <td colspan="8" id="cervicalRadio">
                  	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_查体_妇科/宫颈')}" var="dict" varStatus="var">
						<label>
							<input class="input-center" name="phHealthexamdetail.cervical" type="radio" value="${dict.DItemID}" 
							<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.cervical}">checked="checked"</c:if>
							/>
							<span class="span-center">${var.index+1}.${dict.DItemName}</span>
						</label>
					</c:forEach>
                    <input id="cervicalRadio-input" maxlength="50" class="middle" type="text" name="phHealthexamdetail.cervical_Desc" value="${pojo.phHealthexamdetail.cervical_Desc}">
                  </td>
                </tr>
                <tr class="genecology">
                  <td class="align-right">宫体</td>
                  <td colspan="8" id="uteriRadio">
                  	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_查体_妇科/宫体')}" var="dict" varStatus="var">
						<label>
							<input class="input-center" name="phHealthexamdetail.uteri" type="radio" value="${dict.DItemID}" 
							<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.uteri}">checked="checked"</c:if>
							/>
							<span class="span-center">${var.index+1}.${dict.DItemName}</span>
						</label>
					</c:forEach>
                    <input id="uteriRadio-input" maxlength="50" class="middle"  type="text" name="phHealthexamdetail.uteri_Desc" value="${pojo.phHealthexamdetail.uteri_Desc}">
                  </td>
                </tr>
                <tr class="genecology">
                  <td class="align-right">附件</td>
                  <td colspan="8" id="enclosureRadio">
                  	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_查体_妇科/附件')}" var="dict" varStatus="var">
						<label>
							<input class="input-center" name="phHealthexamdetail.enclosure" type="radio" value="${dict.DItemID}" 
							<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.enclosure}">checked="checked"</c:if>
							/>
							<span class="span-center">${var.index+1}.${dict.DItemName}</span>
						</label>
					</c:forEach>
                    <input id="enclosureRadio-input" maxlength="50" class="middle" type="text" name="phHealthexamdetail.enclosure_Desc" value="${pojo.phHealthexamdetail.enclosure_Desc}">
                  </td>
                </tr>
              <tr>
                <th rowspan="18">辅助检查</th>
                <td class="align-right">空腹血糖</td>
                <td colspan="3">
                  <input id="GLU"  maxlength="6" type="text" name="phHealthexamdetail.GLU" value="${pojo.phHealthexamdetail.GLU}" onblur="VDblur4('GLU-error', '请输入一个介于 0 和 1000 之间且最多两位小数的值', 'GLU')">mmol/L<span id="GLU-error" class="red"></span>
                </td>
                <td class="align-right">餐后血糖</td>
                <td colspan="5">
                  <input id="PGLU"  maxlength="6" type="text" name="phHealthexamdetail.PGLU" value="${pojo.phHealthexamdetail.PGLU}" onblur="VDblur4('PGLU-error', '请输入一个介于 0 和 1000 之间且最多两位小数的值', 'PGLU')">mmol/L<span id="PGLU-error" class="red"></span>
                </td>
              </tr>
              <tr>
                <td rowspan="2" class="align-right">血常规</td>
                <td class="align-right">血红蛋白</td>
                <td colspan="2">
                  <input id="hemoglobin" type="text" name="phHealthexamdetail.hemoglobin" value="${pojo.phHealthexamdetail.hemoglobin}" range="[-32768,32767]" 	digits="true" >g/L
                </td>
                <td class="align-right">白细胞</td>
                <td colspan="2">
                  <input id="leukocyte" maxlength="5" type="text" name="phHealthexamdetail.leukocyte" value="${pojo.phHealthexamdetail.leukocyte}" onblur="VDblur2('leukocyte-error', '请输入一个介于 0 和 1000 之间且最多一位小数的值', 'leukocyte')">x10^9/L<span id="leukocyte-error" class="red"></span>
                </td>
                <td class="align-right">血小板</td>
                <td colspan="2">
                  <input id="platelet" type="text" name="phHealthexamdetail.platelet" value="${pojo.phHealthexamdetail.platelet}" range="[-32768,32767]" 	digits="true" >x10^9/L
                </td>
              </tr>
              <tr>
                <td class="align-right">其它</td>
                <td colspan="8">
                  <input maxlength="50" class="middle" type="text" name="phHealthexamdetail.bloodOther" value="${pojo.phHealthexamdetail.bloodOther}">
                </td>
              </tr>
              <tr>
                <td rowspan="2" class="align-right">尿常规</td>
                <td class="align-right">尿蛋白</td>
                <td>
                  <input maxlength="50" type="text" name="phHealthexamdetail.urineProtein" value="${pojo.phHealthexamdetail.urineProtein}" >
                </td>
                <td class="align-right">尿糖</td>
                <td>
                  <input maxlength="50" type="text" name="phHealthexamdetail.urineSugar" value="${pojo.phHealthexamdetail.urineSugar}" >
                </td>
                <td colspan="1" class="align-right">尿酮体</td>
                <td>
                  <input maxlength="50" type="text" name="phHealthexamdetail.urineAcetoneBody" value="${pojo.phHealthexamdetail.urineAcetoneBody}" >
                </td>
                <td class="align-right">尿潜血</td>
                <td colspan="2">
                  <input maxlength="50" type="text" name="phHealthexamdetail.urineOccultBlood" value="${pojo.phHealthexamdetail.urineOccultBlood}" >
                </td>
              </tr>
              <tr>
                <td class="align-right">其它</td>
                <td colspan="8">
                  <input maxlength="50" class="middle"  type="text" name="phHealthexamdetail.urineOther" value="${pojo.phHealthexamdetail.urineOther}">
                </td>
              </tr>
              <tr>
                <td class="align-right">尿微量蛋白</td>
                <td colspan="3">
                  <input id="urineMicroAlbumin" maxlength="6"  type="text" name="phHealthexamdetail.urineMicroAlbumin" value="${pojo.phHealthexamdetail.urineMicroAlbumin}" onblur="VDblur('urineMicroAlbumin-error', '请输入一个介于 0 和 10000 之间且最多一位小数的值', 'urineMicroAlbumin')">mg/dL<span id="urineMicroAlbumin-error" class="red"></span>
                </td>
                <td class="align-right">大便潜血</td>
                <td colspan="5">
                  <c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_辅助检查/大便潜血')}" var="dict" varStatus="var">
					<label>
						<input class="input-center" name="phHealthexamdetail.fecalOccultBlood" type="radio" value="${dict.DItemID}" 
						<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.fecalOccultBlood}">checked="checked"</c:if>
						/>
						<span class="span-center">${var.index+1}.${dict.DItemName}</span>
					</label>
				  </c:forEach>
                </td>
              </tr>
              <tr>
                <td rowspan="2" class="align-right">肝功能</td>
                <td colspan="1" class="align-right">血清谷丙转氨酶</td>
                <td colspan="2">
                  <input id="CPT" type="text" name="phHealthexamdetail.CPT" value="${pojo.phHealthexamdetail.CPT}" range="[-32768,32767]" 	digits="true" >U/L
                </td>
                <td class="align-right">血清谷草转氨酶</td>
                <td colspan="2">  
                  <input id="AST" type="text" name="phHealthexamdetail.AST" value="${pojo.phHealthexamdetail.AST}" range="[-32768,32767]" 	digits="true" >U/L
                </td>
                <td class="align-right">白蛋白</td>
                <td colspan="2">
                  <input id="ALB" type="text" name="phHealthexamdetail.ALB" value="${pojo.phHealthexamdetail.ALB}" range="[-32768,32767]" 	digits="true" >g/L
                </td>
              </tr>
              <tr>
                <td class="align-right">总胆红素</td>
                <td colspan="3">
                  <input id="TBIL" maxlength="5" type="text" name="phHealthexamdetail.TBIL" value="${pojo.phHealthexamdetail.TBIL}" onblur="VDblur2('TBIL-error', '请输入一个介于 0 和 1000 之间且最多一位小数的值', 'TBIL')">umol/L<span id="TBIL-error" class="red"></span>
                </td>
                <td class="align-right">结合胆红素</td>
                <td colspan="4">
                  <input  id="CBIL" maxlength="6" type="text" name="phHealthexamdetail.CBIL" value="${pojo.phHealthexamdetail.CBIL}" onblur="VDblur('CBIL-error', '请输入一个介于 0 和 10000 之间且最多一位小数的值', 'CBIL')">umol/L<span id="CBIL-error" class="red"></span>
                </td>
              </tr>
              <tr>
                <td class="align-right">肾功能</td>
                <td class="align-right">血清肌酐</td>
                <td>
                  <input id="CR" maxlength="7" type="text" name="phHealthexamdetail.CR" value="${pojo.phHealthexamdetail.CR}" onblur="VDblur5('CR-error', '请输入一个介于 0 和 10000 之间且最多两位小数的值', 'CR')">umol/L<span id="CR-error" class="red"></span>
                </td>
                <td class="align-right">血尿素氮</td>
                <td colspan="1">
                  <input id="BUN" maxlength="6" type="text" name="phHealthexamdetail.BUN" value="${pojo.phHealthexamdetail.BUN}" onblur="VDblur4('BUN-error', '请输入一个介于 0 和 1000 之间且最多两位小数的值', 'BUN')">umol/L<span id="BUN-error" class="red"></span>
                </td>
                <td class="align-right">血钾浓度</td>
                <td>
                  <input maxlength="6" id="serumPotassium"  type="text" name="phHealthexamdetail.serumPotassium" value="${pojo.phHealthexamdetail.serumPotassium}" onblur="VDblur4('serumPotassium-error', '请输入一个介于 0 和 1000 之间且最多两位小数的值', 'serumPotassium')">umol/L<span id="serumPotassium-error" class="red"></span>
                </td>
                <td class="align-right">血钠浓度</td>
                <td colspan="2">
                  <input id="serumSodium" maxlength="7" type="text" name="phHealthexamdetail.serumSodium" value="${pojo.phHealthexamdetail.serumSodium}" onblur="VDblur5('serumSodium-error', '请输入一个介于 0 和 10000 之间且最多两位小数的值', 'serumSodium')">umol/L<span id="serumSodium-error" class="red"></span>
                </td>
              </tr>
              <tr>
                <td rowspan="2" class="align-right">血脂</td>
                <td class="align-right">总胆固醇</td>
                <td colspan="2">
                  <input id="CHOL" maxlength="7" type="text" name="phHealthexamdetail.CHOL" value="${pojo.phHealthexamdetail.CHOL}" onblur="VDblur4('CHOL-error', '请输入一个介于 0 和 1000 之间且最多两位小数的值', 'CHOL')">mmol/L<span id="CHOL-error" class="red"></span>
                </td>
                <td class="align-right">甘油三酯</td>
                <td colspan="2">
                  <input id="TG" maxlength="5" type="text" name="phHealthexamdetail.TG" value="${pojo.phHealthexamdetail.TG}" onblur="VDblur7('TG-error', '请输入一个介于 0 和 100 之间且最多两位小数的值', 'TG')">mmol/L<span id="TG-error" class="red"></span>
                </td>
                <td colspan="1" class="align-right">血清低密度脂蛋白胆固醇</td>
                <td colspan="2">
                  <input id="LDL_C" maxlength="7" type="text" name="phHealthexamdetail.LDL_C" value="${pojo.phHealthexamdetail.LDL_C}" onblur="VDblur4('LDL_C-error', '请输入一个介于 0 和 1000 之间且最多两位小数的值', 'LDL_C')">mmol/L<span id="LDL_C-error" class="red"></span>
                </td>
              </tr>
              <tr>
                <td colspan="2" class="align-right">血清高密度脂蛋白胆固醇</td>
                <td colspan="7">
                  <input id="HDL_C" maxlength="7" type="text" name="phHealthexamdetail.HDL_C" value="${pojo.phHealthexamdetail.HDL_C}" onblur="VDblur4('HDL_C-error', '请输入一个介于 0 和 1000 之间且最多两位小数的值', 'HDL_C')">mmol/L<span id="HDL_C-error" class="red"></span>
                </td>
              </tr>
              <tr>
                <td class="align-right">糖化血红蛋白</td>
                <td colspan="9">
                  <input id="HBA1C" maxlength="5" type="text" name="phHealthexamdetail.HBA1C" value="${pojo.phHealthexamdetail.HBA1C}" onblur="VDblur2('HBA1C-error', '请输入一个介于 0 和 1000 之间且最多一位小数的值', 'HBA1C')">%<span id="HBA1C-error" class="red"></span>
                </td>
              </tr>
              <tr>
                <td class="align-right">乙肝表面抗原</td>
                <td colspan="9">
                	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_辅助检查/乙肝表面抗原')}" var="dict" varStatus="var">
						<label>
							<input class="input-center" name="phHealthexamdetail.HBSAG" type="radio" value="${dict.DItemID}" 
							<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.HBSAG}">checked="checked"</c:if>
							/>
							<span class="span-center">${var.index+1}.${dict.DItemName}</span>
						</label>
					</c:forEach>
                </td>
              </tr>
              <tr>
                <td class="align-right">心电图</td>
                <td colspan="9" id="cardiogram">
                	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_辅助检查/心电图')}" var="dict" varStatus="var">
						<label>
							<input class="input-center" name="phHealthexamdetail.cardiogram" type="radio" value="${dict.DItemID}" 
							<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.cardiogram}">checked="checked"</c:if>
							/>
							<span class="span-center">${var.index+1}.${dict.DItemName}</span>
						</label>
					</c:forEach>
                  	<input maxlength="50" class="middle" id="cardiogram-input" type="text" name="phHealthexamdetail.cardiogram_Desc" value="${pojo.phHealthexamdetail.cardiogram_Desc}">
                </td>
              </tr>
              <tr>
                <td class="align-right">胸部X线片</td>
                <td colspan="9" id="x_RAY">
                	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_辅助检查/胸部X线片')}" var="dict" varStatus="var">
						<label>
							<input class="input-center" name="phHealthexamdetail.x_RAY" type="radio" value="${dict.DItemID}" 
							<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.x_RAY}">checked="checked"</c:if>
							/>
							<span class="span-center">${var.index+1}.${dict.DItemName}</span>
						</label>
					</c:forEach>
                  	<input maxlength="50" class="middle" id="x_RAY-input" type="text" name="phHealthexamdetail.x_RAY_Desc" value="${pojo.phHealthexamdetail.x_RAY_Desc}">
                </td>
              </tr>
              <tr>
                <td class="align-right">B超</td>
                <td colspan="9" id="b_Ultrasonic">
                	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_辅助检查/B超')}" var="dict" varStatus="var">
						<label>
							<input class="input-center" name="phHealthexamdetail.b_Ultrasonic" type="radio" value="${dict.DItemID}" 
							<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.b_Ultrasonic}">checked="checked"</c:if>
							/>
							<span class="span-center">${var.index+1}.${dict.DItemName}</span>
						</label>
					</c:forEach>
                  	<input maxlength="50" class="middle" id="b_Ultrasonic-input" type="text" name="phHealthexamdetail.b_Ultrasonic_Desc" value="${pojo.phHealthexamdetail.b_Ultrasonic_Desc}">
                </td>
              </tr>
              <tr>
                <td class="align-right">宫颈涂片</td>
                <td colspan="9" id="cervicalSmear">
                	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_辅助检查/宫颈涂片')}" var="dict" varStatus="var">
						<label>
							<input class="input-center" name="phHealthexamdetail.cervicalSmear" type="radio" value="${dict.DItemID}" 
							<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.cervicalSmear}">checked="checked"</c:if>
							/>
							<span class="span-center">${var.index+1}.${dict.DItemName}</span>
						</label>
					</c:forEach>
                  	<input maxlength="50" class="middle" id="cervicalSmear-input" type="text" name="phHealthexamdetail.cervicalSmear_Desc" value="${pojo.phHealthexamdetail.cervicalSmear_Desc}">
                </td>
              </tr>
              <tr>
                <td class="align-right">其它</td>
                <td colspan="9">
                  <input maxlength="50"  class="longer" type="text" name="phHealthexamdetail.assistCheckOther" value="${pojo.phHealthexamdetail.assistCheckOther}">
                </td>
              </tr>
              <tr class="align-center">
                <th rowspan="3">中医体质辨识</th>
                <th>体 质</th>
                <th>气虚质</th>
                <th>阳虚质</th>
                <th>阴虚质</th>
                <th>痰湿质</th>
                <th>湿热质</th>
                <th>血瘀质</th>
                <th>气郁质</th>
                <th>特禀质</th>
                <th>平和质</th>
              </tr>
              <tr>
                <td class="align-right">辨识结果</td>
                <td colspan="1">
                  <ul class="s1" id="result-qixu">
                  	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_中医体质辨识_气虚质/辨识结果')}" var="dict" varStatus="var">
						<li class="clearfix">
							<label>
								<input class="input-center" name="phHealthexamdetail.TCM_QXZ" type="radio" value="${dict.DItemID}" 
								<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.TCM_QXZ}">checked="checked"</c:if>
								/>
								<span class="span-center">${var.index+1}.${dict.DItemName}</span>
							</label>
						</li>
					</c:forEach>
                  </ul>
                </td>
                <td colspan="1">
                  <ul class="s1" id="result-yangxu">
                  	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_中医体质辨识_阳虚质/辨识结果')}" var="dict" varStatus="var">
						<li class="clearfix">
							<label>
								<input class="input-center" name="phHealthexamdetail.TCM_YXZ" type="radio" value="${dict.DItemID}" 
								<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.TCM_YXZ}">checked="checked"</c:if>
								/>
								<span class="span-center">${var.index+1}.${dict.DItemName}</span>
							</label>
						</li>
					</c:forEach>
                  </ul>
                </td>
                <td colspan="1">
                  <ul class="s1" id="result-yinxu">
                  	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_中医体质辨识_阴虚质/辨识结果')}" var="dict" varStatus="var">
						<li class="clearfix">
							<label>
								<input class="input-center" name="phHealthexamdetail.TCM_YIXZ" type="radio" value="${dict.DItemID}" 
								<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.TCM_YIXZ}">checked="checked"</c:if>
								/>
								<span class="span-center">${var.index+1}.${dict.DItemName}</span>
							</label>
						</li>
					</c:forEach>
                  </ul>
                </td>
                <td colspan="1">
                  <ul class="s1" id="result-tanshi">
                  	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_中医体质辨识_痰湿质/辨识结果')}" var="dict" varStatus="var">
						<li class="clearfix">
							<label>
								<input class="input-center" name="phHealthexamdetail.TCM_TSZ" type="radio" value="${dict.DItemID}" 
								<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.TCM_TSZ}">checked="checked"</c:if>
								/>
								<span class="span-center">${var.index+1}.${dict.DItemName}</span>
							</label>
						</li>
					</c:forEach>
                  </ul>
                </td>
                <td colspan="1">
                  <ul class="s1" id="result-shire">
                  	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_中医体质辨识_湿热质/辨识结果')}" var="dict" varStatus="var">
						<li class="clearfix">
							<label>
								<input class="input-center" name="phHealthexamdetail.TCM_SRZ" type="radio" value="${dict.DItemID}" 
								<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.TCM_SRZ}">checked="checked"</c:if>
								/>
								<span class="span-center">${var.index+1}.${dict.DItemName}</span>
							</label>
						</li>
					</c:forEach>
                  </ul>
                </td>
                <td colspan="1">
                  <ul class="s1" id="result-xueyu">
                  	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_中医体质辨识_血瘀质/辨识结果')}" var="dict" varStatus="var">
						<li class="clearfix">
							<label>
								<input class="input-center" name="phHealthexamdetail.TCM_XTZ" type="radio" value="${dict.DItemID}" 
								<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.TCM_XTZ}">checked="checked"</c:if>
								/>
								<span class="span-center">${var.index+1}.${dict.DItemName}</span>
							</label>
						</li>
					</c:forEach>
                  </ul>
                </td>
                <td colspan="1">
                  <ul class="s1" id="result-qiyu">
                  	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_中医体质辨识_气郁质/辨识结果')}" var="dict" varStatus="var">
						<li class="clearfix">
							<label>
								<input class="input-center" name="phHealthexamdetail.TCM_QYZ" type="radio" value="${dict.DItemID}" 
								<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.TCM_QYZ}">checked="checked"</c:if>
								/>
								<span class="span-center">${var.index+1}.${dict.DItemName}</span>
							</label>
						</li>
					</c:forEach>
                  </ul>
                </td>
                <td colspan="1">
                  <ul class="s1" id="result-tebing">
                  	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_中医体质辨识_特秉质/辨识结果')}" var="dict" varStatus="var">
						<li class="clearfix">
							<label>
								<input class="input-center" name="phHealthexamdetail.TCM_TBZ" type="radio" value="${dict.DItemID}" 
								<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.TCM_TBZ}">checked="checked"</c:if>
								/>
								<span class="span-center">${var.index+1}.${dict.DItemName}</span>
							</label>
						</li>
					</c:forEach>
                  </ul>
                </td>
                <td colspan="1">
                  <ul class="s2" id="result-pinghe">
                  	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_中医体质辨识_平和质/辨识结果')}" var="dict" varStatus="var">
						<li class="clearfix">
							<label>
								<input class="input-center" name="phHealthexamdetail.TCM_PHZ" type="radio" value="${dict.DItemID}" 
								<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.TCM_PHZ}">checked="checked"</c:if>
								/>
								<span class="span-center">${var.index+1}.${dict.DItemName}</span>
							</label>
						</li>
					</c:forEach>
                  </ul>
                </td>
              </tr>
              <tr class="tcm">
                <td class="align-right">保健指导</td>
                <td class="padding-no">
                  <ul class="left-ul" id="healthGuide-qixu">
                  	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_中医体质辨识_气虚质/健康指导')}" var="dict" varStatus="var">
                  		<li class="clearfix">
                  			<label>
                  				<input class="input-center" class="input-center" name="phHealthexamdetail.TCM_QXZ_Guide" type="checkbox" value="${dict.DItemID}" 
		                		<c:forEach items="${pojo.phHealthexamdetail.TCM_QXZ_Guides}" var="s">
		                			<c:if test="${dict.DItemID eq s}">checked="checked"</c:if>
		                		</c:forEach>
		                		/>
		                		<span class="span-center">${dict.DItemName}</span>
	                		</label>
                		</li>
                  	</c:forEach>
                  	<li class="li-top">其他<input maxlength="50" type="text" name="phHealthexamdetail.TCM_QXZ_Guide_Desc" value="${pojo.phHealthexamdetail.TCM_QXZ_Guide_Desc}"></li>
                  </ul>
                </td>
                <td class="padding-no">
                  <ul class="left-ul" id="healthGuide-yangxu">
                  	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_中医体质辨识_阳虚质/健康指导')}" var="dict" varStatus="var">
                  		<li class="clearfix">
                  			<label>
                  				<input class="input-center" name="phHealthexamdetail.TCM_YXZ_Guide" type="checkbox" value="${dict.DItemID}" 
		                		<c:forEach items="${pojo.phHealthexamdetail.TCM_YXZ_Guides}" var="s">
		                			<c:if test="${dict.DItemID eq s}">checked="checked"</c:if>
		                		</c:forEach>
		                		/>
		                		<span class="span-center">${dict.DItemName}</span>
	                		</label>
                		</li>
                  	</c:forEach>
                    <li class="li-top">其他<input maxlength="50" type="text" name="phHealthexamdetail.TCM_YXZ_Guide_Desc" value="${pojo.phHealthexamdetail.TCM_YXZ_Guide_Desc}"></li>
                  </ul>
                </td>
                <td class="padding-no">
                  <ul class="left-ul" id="healthGuide-yinxu">
                  	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_中医体质辨识_阴虚质/健康指导')}" var="dict" varStatus="var">
                  		<li class="clearfix">
                  			<label>
                  				<input class="input-center" name="phHealthexamdetail.TCM_YIXZ_Guide" type="checkbox" value="${dict.DItemID}" 
		                		<c:forEach items="${pojo.phHealthexamdetail.TCM_YIXZ_Guides}" var="s">
		                			<c:if test="${dict.DItemID eq s}">checked="checked"</c:if>
		                		</c:forEach>/>
		                		<span class="span-center">${dict.DItemName}</span>
	                		</label>
                		</li>
                  	</c:forEach>
                    <li class="li-top">其他<input maxlength="50" type="text" name="phHealthexamdetail.TCM_YIXZ_Guide_Desc" value="${pojo.phHealthexamdetail.TCM_YIXZ_Guide_Desc}"></li>
                  </ul>
                </td>
                <td class="padding-no">
                  <ul class="left-ul" id="healthGuide-tanshi">
                  	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_中医体质辨识_痰湿质/健康指导')}" var="dict" varStatus="var">
                  		<li class="clearfix">
                  			<label>
                  				<input class="input-center" name="phHealthexamdetail.TCM_TSZ_Guide" type="checkbox" value="${dict.DItemID}" 
		                		<c:forEach items="${pojo.phHealthexamdetail.TCM_TSZ_Guides}" var="s">
		                			<c:if test="${dict.DItemID eq s}">checked="checked"</c:if>
		                		</c:forEach>
		                		/>
		                		<span class="span-center">${dict.DItemName}</span>
	                		</label>
                		</li>
                  	</c:forEach>
                    <li class="li-top">其他<input maxlength="50" type="text" name="phHealthexamdetail.TCM_TSZ_Guide_Desc" value="${pojo.phHealthexamdetail.TCM_TSZ_Guide_Desc}"></li>
                  </ul>
                </td>
                <td class="padding-no">
                  <ul class="left-ul" id="healthGuide-shire">
                  	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_中医体质辨识_湿热质/健康指导')}" var="dict" varStatus="var">
                  		<li class="clearfix">
                  			<label>
                  				<input class="input-center" name="phHealthexamdetail.TCM_SRZ_Guide" type="checkbox" value="${dict.DItemID}" 
		                		<c:forEach items="${pojo.phHealthexamdetail.TCM_SRZ_Guides}" var="s">
		                			<c:if test="${dict.DItemID eq s}">checked="checked"</c:if>
		                		</c:forEach>
		                		/>
		                		<span class="span-center">${dict.DItemName}</span>
	                		</label>
                		</li>
                  	</c:forEach>
                    <li class="li-top">其他<input maxlength="50" type="text" name="phHealthexamdetail.TCM_SRZ_Guide_Desc" value="${pojo.phHealthexamdetail.TCM_SRZ_Guide_Desc}"></li>
                  </ul>
                </td>
                <td class="padding-no">
                  <ul class="left-ul" id="healthGuide-xueyu">
                  	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_中医体质辨识_血瘀质/健康指导')}" var="dict" varStatus="var">
                  		<li class="clearfix">
                  			<label>
                  				<input class="input-center" name="phHealthexamdetail.TCM_XTZ_Guide" type="checkbox" value="${dict.DItemID}" 
		                		<c:forEach items="${pojo.phHealthexamdetail.TCM_XTZ_Guides}" var="s">
		                			<c:if test="${dict.DItemID eq s}">checked="checked"</c:if>
		                		</c:forEach>
		                		/>
		                		<span class="span-center">${dict.DItemName}</span>
	                		</label>
                		</li>
                  	</c:forEach>
                    <li class="li-top">其他<input maxlength="50" type="text" name="phHealthexamdetail.TCM_XTZ_Guide_Desc" value="${pojo.phHealthexamdetail.TCM_XTZ_Guide_Desc}"></li>
                  </ul>
                </td>
                <td class="padding-no">
                  <ul class="left-ul" id="healthGuide-qiyu">
                  	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_中医体质辨识_气郁质/健康指导')}" var="dict" varStatus="var">
                  		<li class="clearfix">
                  			<label>
                  				<input class="input-center" name="phHealthexamdetail.TCM_QYZ_Guide" type="checkbox" value="${dict.DItemID}" 
		                		<c:forEach items="${pojo.phHealthexamdetail.TCM_QYZ_Guides}" var="s">
		                			<c:if test="${dict.DItemID eq s}">checked="checked"</c:if>
		                		</c:forEach>
		                		/>
	                			<span class="span-center">${dict.DItemName}</span>
                			</label>
               			</li>
                  	</c:forEach>
     					<li class="li-top">其他<input maxlength="50" type="text" name="phHealthexamdetail.TCM_QYZ_Guide_Desc" value="${pojo.phHealthexamdetail.TCM_QYZ_Guide_Desc}"></li>
                  </ul>
                </td>
                <td class="padding-no">
                  <ul class="left-ul" id="healthGuide-tebing">
                  	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_中医体质辨识_特秉质/健康指导')}" var="dict" varStatus="var">
                  		<li class="clearfix">
                  			<label>
                  				<input class="input-center" name="phHealthexamdetail.TCM_TBZ_Guide" type="checkbox" value="${dict.DItemID}" 
		                		<c:forEach items="${pojo.phHealthexamdetail.TCM_TBZ_Guides}" var="s">
		                			<c:if test="${dict.DItemID eq s}">checked="checked"</c:if>
		                		</c:forEach>
		                		/>
		                		<span class="span-center">${dict.DItemName}</span>
	                		</label>
                		</li>
                  	</c:forEach>
                    <li class="li-top">其他<input maxlength="50" type="text" name="phHealthexamdetail.TCM_TBZ_Guide_Desc" value="${pojo.phHealthexamdetail.TCM_TBZ_Guide_Desc}"></li>
                  </ul>
                </td>
                <td class="padding-no">
                  <ul class="left-ul" id="healthGuide-pinghe">
                  	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_中医体质辨识_平和质/健康指导')}" var="dict" varStatus="var">
                  		<li class="clearfix">
                  			<label>
                  				<input class="input-center" name="phHealthexamdetail.TCM_PHZ_Guide" type="checkbox" value="${dict.DItemID}" 
		                		<c:forEach items="${pojo.phHealthexamdetail.TCM_PHZ_Guides}" var="s">
		                			<c:if test="${dict.DItemID eq s}">checked="checked"</c:if>
		                		</c:forEach>
		                		/>
		                		<span class="span-center">${dict.DItemName}</span>
	                		</label>
                		</li>
                  	</c:forEach>
                    <li class="li-top">其他<input maxlength="50" type="text" name="phHealthexamdetail.TCM_PHZ_Guide_Desc" value="${pojo.phHealthexamdetail.TCM_PHZ_Guide_Desc}"></li>
                  </ul>
                </td>
              </tr>
            </table>
          </section>
          <!-- 选填项 end -->
          <section class="tab-conbox-item">
            <table class="table-normal">
              <colgroup>
                <col span="2" width="10%" />
              </colgroup>
              <tr>
                <th rowspan="7">现存主要健康问题</th>
                <td class="align-right bgfff">脑血管疾病</td>
                <td colspan="10" id="cerebralVessel">
                	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_现存主要健康问题/脑血管疾病')}" var="dict" varStatus="var">
						<label>
							<input type="checkbox" class="input-center" name="phHealthexamdetail.cerebralVessel" value="${dict.DItemID}" 
							<c:forEach items="${pojo.phHealthexamdetail.cerebralVessels}" var="s">
	                			<c:if test="${dict.DItemID eq s}">checked="checked"</c:if>
	                		</c:forEach>
							/>
							<span class="span-center">${var.index+1}.${dict.DItemName}</span>
						</label>
					</c:forEach>
                	<input class="middle" id="cerebralVessel-input" type="text" maxlength="50" name="phHealthexamdetail.cerebralVessel_Desc" value="${pojo.phHealthexamdetail.cerebralVessel_Desc}">
                </td>
              </tr>
              <tr>
                <td class="align-right bgfff">肾脏疾病</td>
                <td colspan="10" id="kidney">
                	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_现存主要健康问题/肾脏疾病')}" var="dict" varStatus="var">
						<label>
							<input type="checkbox" class="input-center" name="phHealthexamdetail.kidney" value="${dict.DItemID}" 
							<c:forEach items="${pojo.phHealthexamdetail.kidneys}" var="s">
	                			<c:if test="${dict.DItemID eq s}">checked="checked"</c:if>
	                		</c:forEach>
							/>
							<span class="span-center">${var.index+1}.${dict.DItemName}</span>
						</label>
					</c:forEach>
                	<input class="middle"  id="kidney-input" type="text" maxlength="50" name="phHealthexamdetail.kidney_Desc" value="${pojo.phHealthexamdetail.kidney_Desc}">
                </td>
              </tr>
              <tr>
                <td class="align-right bgfff">心脏疾病</td>
                <td colspan="10" id="heart">
                	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_现存主要健康问题/心脏疾病')}" var="dict" varStatus="var">
						<label>
							<input type="checkbox" class="input-center" name="phHealthexamdetail.heart" value="${dict.DItemID}" 
							<c:forEach items="${pojo.phHealthexamdetail.hearts}" var="s">
	                			<c:if test="${dict.DItemID eq s}">checked="checked"</c:if>
	                		</c:forEach>
							/>
							<span class="span-center">${var.index+1}.${dict.DItemName}</span>
						</label>
					</c:forEach>
                	<input class="w-160" id="heart-input" type="text" maxlength="50" name="phHealthexamdetail.heart_Desc" value="${pojo.phHealthexamdetail.heart_Desc}">
                </td>
              </tr>
              <tr>
                <td class="align-right bgfff">血管疾病</td>
                <td colspan="10" id="bloodPipe">
                	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_现存主要健康问题/血管疾病')}" var="dict" varStatus="var">
						<label>
							<input type="checkbox" class="input-center" name="phHealthexamdetail.bloodPipe" value="${dict.DItemID}" 
							<c:forEach items="${pojo.phHealthexamdetail.bloodPipes}" var="s">
	                			<c:if test="${dict.DItemID eq s}">checked="checked"</c:if>
	                		</c:forEach>
							/>
							<span class="span-center">${var.index+1}.${dict.DItemName}</span>
						</label>
					</c:forEach>
                	<input class="middle" id="bloodPipe-input" type="text" maxlength="50" name="phHealthexamdetail.bloodPipe_Desc" value="${pojo.phHealthexamdetail.bloodPipe_Desc}">
                </td>
              </tr>
              <tr>
                <td class="align-right bgfff">眼部疾病</td>
                <td colspan="10" id="eyePart">
                	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_现存主要健康问题/眼部疾病')}" var="dict" varStatus="var">
						<label>
							<input type="checkbox" class="input-center" name="phHealthexamdetail.eyePart" value="${dict.DItemID}" 
							<c:forEach items="${pojo.phHealthexamdetail.eyeParts}" var="s">
	                			<c:if test="${dict.DItemID eq s}">checked="checked"</c:if>
	                		</c:forEach>
							/>
							<span class="span-center">${var.index+1}.${dict.DItemName}</span>
						</label>
					</c:forEach>
					<input class="middle" id="eyePart-input" type="text" maxlength="50" name="phHealthexamdetail.eyePart_Desc" value="${pojo.phHealthexamdetail.eyePart_Desc}">
                </td>
              </tr>
              <tr>
                <td class="align-right bgfff">神经系统疾病</td>
                <td colspan="10" id="nervousSystem">
                	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_现存主要健康问题/神经系统疾病')}" var="dict" varStatus="var">
						<label>
							<input type="radio" class="input-center" name="phHealthexamdetail.nervousSystem" value="${dict.DItemID}" 
                			<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.nervousSystem}">checked="checked"</c:if>
							/>
							<span class="span-center">${var.index+1}.${dict.DItemName}</span>
						</label>
					</c:forEach>
                	<input class="middle" id="nervousSystem-input" type="text" maxlength="50" name="phHealthexamdetail.nervousSystem_Desc" value="${pojo.phHealthexamdetail.nervousSystem_Desc}">
                </td>
              </tr>
              <tr>
                <td class="align-right bgfff">其它系统疾病</td>
                <td colspan="10" id="otherSystem">
                	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检_现存主要健康问题/其他系统疾病')}" var="dict" varStatus="var">
						<label>
							<input type="radio" class="input-center" name="phHealthexamdetail.otherSystem" value="${dict.DItemID}" 
							<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.otherSystem}">checked="checked"</c:if>
							/>
							<span class="span-center">${var.index+1}.${dict.DItemName}</span>
						</label>
					</c:forEach>
                	<input class="middle" id="otherSystem-input" type="text" maxlength="50" name="phHealthexamdetail.otherSystem_Desc" value="${pojo.phHealthexamdetail.otherSystem_Desc}">
                </td>
              </tr>
              <tr class="align-center">
                <th rowspan="2">住院治疗情况</th>
                <td>住院史</td>
                	<td colspan="7">
                		<ul class="inline-btn" >
                			<li><input type="button" value="新增" onclick="openPage('新增住院史', 'editHOIV');" data-tb="hoiv"></li>
	                		<li><input type="button" value="修改" onclick="editHOIV();"></li>
	                		<li><input type="button" value="删除" onclick="removeTr('hoiv','您确定要删除住院史信息吗？');"></li>
                		</ul>
                		<table class="inline-table table-normal" id="hoiv">
                			<thead>
                				<th>选择</th>
                				<th>*入院日期</th>
                				<th>出院日期</th>                				
                				<th>医疗机构名称</th>
                				<th>病案号</th>
                				<th>住院原因</th>
                			</thead>
                			<tbody>
                				<c:forEach items="${pojo.phHealthexamdetailinpatients}" var="pojo" varStatus="s">
                					<tr id="hoiv-cb-${s.index}">
	                					<td><input type="checkbox"  value="${s.index}" ><input type="hidden" name="phHealthexamdetailinpatients[${s.index }].logID" value="${pojo.logID}"/></td>
	                					<td><input type="hidden" name="phHealthexamdetailinpatients[${s.index}].startDate" value="<fmt:formatDate value='${pojo.startDate}' pattern="yyyy-MM-dd"/>"><span><fmt:formatDate value='${pojo.startDate}' pattern="yyyy-MM-dd"/></span></td>
	                					<td><input type="hidden" name="phHealthexamdetailinpatients[${s.index}].endTime" value="<fmt:formatDate value='${pojo.endTime}' pattern="yyyy-MM-dd"/>"><span><fmt:formatDate value='${pojo.endTime}' pattern="yyyy-MM-dd"/></span></td>
	                					<td><input type="hidden" name="phHealthexamdetailinpatients[${s.index}].institution" value="${pojo.institution}"><span>${pojo.institution}</span></td>
	                					<td><input type="hidden" name="phHealthexamdetailinpatients[${s.index}].patientID" value="${pojo.patientID}"><span>${pojo.patientID}</span></td>
	                					<td><input type="hidden" name="phHealthexamdetailinpatients[${s.index}].resson" value="${pojo.resson}"><span>${pojo.resson}</span></td>
	                				</tr>
                				</c:forEach>
                			</tbody>
                		</table>
                	</td>
              </tr>
                <tr class="align-center">
                	  <td>家庭病床史</td>
                	<td colspan="7">
                		<ul class="inline-btn" >
                			<li><input type="button" value="新增" onclick="openPage('新增家庭病床史', 'editHODSB')"></li>
	                		<li><input type="button" value="修改" onclick="editHospitalRecord()"></li>
	                		<li><input type="button" value="删除" onclick="removeTr('detailHODSB','删除家庭病床史?');"></li>
                		</ul>
                		<table id="detailHODSB" class="inline-table table-normal">
                			<thead>
                				<th>选择</th>
                				<th>*建床日期</th>
                				<th>撤床日期</th>
                				<th>医疗机构名称</th>
                				<th>病案号</th>
                				<th>住院原因</th>
                			</thead>
                			<tbody>
                				<c:forEach items="${pojo.phHealthexamdetailfamilybeds}" var="pojo" varStatus="s">
                					<tr id="detailHODSB-cb-${s.index}">
	                					<td><input type="checkbox"  value="${s.index}" ><input type="hidden" name="phHealthexamdetailfamilybeds[${s.index }].logID" value="${pojo.logID}"/></td>
	                					<td><input type="hidden" name="phHealthexamdetailfamilybeds[${s.index}].startDate" value="<fmt:formatDate value='${pojo.startDate}' pattern="yyyy-MM-dd"/>"><span><fmt:formatDate value='${pojo.startDate}' pattern="yyyy-MM-dd"/></span></td>
	                					<td><input type="hidden" name="phHealthexamdetailfamilybeds[${s.index}].endTime" value="<fmt:formatDate value='${pojo.endTime}' pattern="yyyy-MM-dd"/>"><span><fmt:formatDate value='${pojo.endTime}' pattern="yyyy-MM-dd"/></span></td>
	                					<td><input type="hidden" name="phHealthexamdetailfamilybeds[${s.index}].resson" value="${pojo.resson}"><span>${pojo.resson}</span></td>
	                					<td><input type="hidden" name="phHealthexamdetailfamilybeds[${s.index}].institution" value="${pojo.institution}"><span>${pojo.institution}</span></td>
	                					<td><input type="hidden" name="phHealthexamdetailfamilybeds[${s.index}].patientID" value="${pojo.patientID}"><span>${pojo.patientID}</span></td>
	                				</tr>
                				</c:forEach>
                			</tbody>
                		</table>
                	</td>
                </tr>
              <tr class="align-center">
                <th>主要用药情况</th>
                <td colspan="8">
                		<ul class="inline-btn align-center" >
                			<li><input type="button" value="新增" onclick="openPage('新增用药', 'editMedicinal',null,'healthExam')"></li>
	                		<li><input type="button" value="修改" onclick="editMedicinal('healthExam')"></li>
	                		<li><input type="button" value="删除" onclick="removeTr('Medicinal','删除用药情况?');"></li>
                		</ul>
                		<table id="Medicinal" class="inline-table table-normal">
                			<thead>
                				<th>选择</th>
                				<th>药物名称</th>
                				<th>用法</th>
                				<th>用量</th>
                				<th>单位</th>
                				<th>频度</th>
                				<th>用药时间</th>
                				<th>服药依从性</th>
                				<th>备注</th>
                			</thead>
                			<tbody>
                				<c:forEach items="${pojo.phHealthexamdetailmedicines}" var="pojo" varStatus="s">
                					<tr id="Medicinal-cb-${s.index}">
	                					<td><input type="checkbox"  value="${s.index}" ><input type="hidden" name="phHealthexamdetailmedicines[${s.index }].logID" value="${pojo.logID}"/></td>
	                					<td><input type="hidden" name="phHealthexamdetailmedicines[${s.index}].drugName" value="${pojo.drugName}"><span>${pojo.drugName}</span></td>
	                					<td><input type="hidden" name="phHealthexamdetailmedicines[${s.index}].drugUsage" value="${pojo.drugUsage}"><span>${pojo.drugUsage}</span></td>
	                					<td><input type="hidden" name="phHealthexamdetailmedicines[${s.index}].drugDosage" value="${pojo.drugDosage}"><span>${pojo.drugDosage}</span></td>
	                					<td><input type="hidden" name="phHealthexamdetailmedicines[${s.index}].drugUnit" value="${pojo.drugUnit}"><span>${pojo.drugUnit}</span></td>
	                					<td><input type="hidden" name="phHealthexamdetailmedicines[${s.index}].drugFreq" value="${pojo.drugFreq}"><span>${pojo.drugFreq}</span></td>
	                					<td><input type="hidden" name="phHealthexamdetailmedicines[${s.index}].drugUseTime" value="${pojo.drugUseTime}"><span>${pojo.drugUseTime}</span></td>
	                					<td><input type="hidden" name="phHealthexamdetailmedicines[${s.index}].drugCompliance" value="${pojo.drugCompliance}"><span>${pojo.drugComplianceDes}</span></td>
	                					<td><input type="hidden" name="phHealthexamdetailmedicines[${s.index}].remarks" value="${pojo.remarks}"><span>${pojo.remarks}</span></td>
	                				</tr>
                				</c:forEach>
                			</tbody>
                		</table>
                </td>
              </tr>
              <tr class="align-center">
                <th>非免疫规划预防接种史</th>
                <td colspan="8">
                		<ul class="inline-btn align-center" >
                			<li><input type="button" value="新增" onclick="openPage('编辑非免疫规划预防接种史', 'editIPVH')"></li>
	                		<li><input type="button" value="修改" onclick="editIPVH()"></li>
	                		<li><input type="button" value="删除" onclick="removeTr('detailIPVH','删除非免疫规划预防接种史?');"></li>
                		</ul>
                		<table id="detailIPVH" class="inline-table table-normal">
                			<thead>
                				<th>选择</th>
                				<th>疫苗名称</th>
                				<th>接种日期</th>
                				<th>接种机构</th>
                			</thead>
                			<tbody>
                				<c:forEach items="${pojo.phHealthexamdetailnonimmunes}" var="pojo" varStatus="s">
                					<tr id="detailIPVH-cb-${s.index}">
	                					<td><input type="checkbox"  value="${s.index}" ><input type="hidden" name="phHealthexamdetailnonimmunes[${s.index }].logID" value="${pojo.logID}"/></td>
	                					<td><input type="hidden" name="phHealthexamdetailnonimmunes[${s.index}].vaccinateName" value="${pojo.vaccinateName}"><span>${pojo.vaccinateName}</span></td>
	                					<td><input type="hidden" name="phHealthexamdetailnonimmunes[${s.index}].vaccinateDate" value="<fmt:formatDate value='${pojo.vaccinateDate}' pattern="yyyy-MM-dd"/>"><span><fmt:formatDate value='${pojo.vaccinateDate}' pattern="yyyy-MM-dd"/></span></td>
	                					<td><input type="hidden" name="phHealthexamdetailnonimmunes[${s.index}].institution" value="${pojo.institution}"><span>${pojo.institution}</span></td>
	                				</tr>
                				</c:forEach>
                			</tbody>
                		</table>
                </td>
              </tr>
              <tr>
                <th>健康评价</th>
                <td colspan="11" id="healthEvaluate">
                	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检/健康评价')}" var="dict" varStatus="var">
						<label>
							<input type="radio" class="input-center" name="phHealthexamdetail.healthEvaluate" value="${dict.DItemID}" 
							<c:if test="${dict.DItemID eq pojo.phHealthexamdetail.healthEvaluate}">checked="checked"</c:if>
							/>
							<span class="span-center">${var.index+1}.${dict.DItemName}</span>
						</label>
					</c:forEach>
               		<p class="display-p">异常1<input maxlength="100" class="middle" type="text" name="phHealthexamdetail.healthEvaluate_Desc" value="${pojo.phHealthexamdetail.healthEvaluate_Descs[0]}"></p>
               		<p class="p-top clearfix"><span class="span-center">异常2<input maxlength="100" class="middle" type="text" name="phHealthexamdetail.healthEvaluate_Desc" value="${pojo.phHealthexamdetail.healthEvaluate_Descs[1]}"></span><span class="span-center">异常3<input maxlength="100" class="middle" type="text" name="phHealthexamdetail.healthEvaluate_Desc" value="${pojo.phHealthexamdetail.healthEvaluate_Descs[2]}"></span></p>
               		<p class="p-top clearfix"><span class="span-center">异常4<input maxlength="100" class="middle" type="text" name="phHealthexamdetail.healthEvaluate_Desc" value="${pojo.phHealthexamdetail.healthEvaluate_Descs[3]}"></span><span class="span-center">异常5<input maxlength="100" class="middle" type="text" name="phHealthexamdetail.healthEvaluate_Desc" value="${pojo.phHealthexamdetail.healthEvaluate_Descs[4]}"></span></p>
                </td>
              </tr>
              <tr>
                <th>健康指导</th>
                <td colspan="11">
                	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检/健康指导')}" var="dict" varStatus="var">
						<label>
							<input type="checkbox" class="input-center" name="phHealthexamdetail.healthGuide" value="${dict.DItemID}" 
<%-- 						<c:if test="${dict.DItemID eq healthExam.phHealthexamdetail.healthGuide}">checked="checked"</c:if> --%>
							<c:forEach items="${pojo.phHealthexamdetail.healthGuides}" var="s">
	                			<c:if test="${dict.DItemID eq s}">checked="checked"</c:if>
	                		</c:forEach>
							/>
							<span class="span-center">${var.index+1}.${dict.DItemName}</span>
						</label>
					</c:forEach>
                </td>
              </tr>
              <tr>
                <th>危险因素控制</th>
                <td colspan="11" id="riskFactor">
                	<c:forEach items="${pojo.phHealthexamdetail.dicts.get('健康体检/危险因素控制')}" var="dict" varStatus="var">
						<label class="clearfix">
							<input onclick="bd(this)" type="checkbox" class="input-center" name="phHealthexamdetail.riskFactor" value="${dict.DItemID}" 
							<c:forEach items="${pojo.phHealthexamdetail.riskFactors}" var="s">
	                			<c:if test="${dict.DItemID eq s}">checked="checked"</c:if>
	                		</c:forEach>
							/>
							<span class="span-center">${var.index+1}.${dict.DItemName}</span>
						</label>
						<c:choose>
							<c:when test="${dict.DItemID==4}">
                				<br><br>
							</c:when>
							<c:when test="${dict.DItemID==5}">
                				<span>(目标<input maxlength="5" type="text" class="input-btm middle" name="phHealthexamdetail.riskFactor_Target" value="${pojo.phHealthexamdetail.riskFactor_Target}" disabled>kg)</span>
                				<br>
							</c:when>
							<c:when test="${dict.DItemID==6}">
                				<input maxlength="50" type="text" class="input-btm middle" name="phHealthexamdetail.riskFactor_Vaccine" value="${pojo.phHealthexamdetail.riskFactor_Vaccine}" disabled>
                				<br>
							</c:when>
							<c:when test="${dict.DItemID==7}">
                				<input maxlength="50" type="text" class="input-btm middle" name="phHealthexamdetail.riskFactor_Other" value="${pojo.phHealthexamdetail.riskFactor_Other}" disabled>
                				<br>	
							</c:when>
						</c:choose>
					</c:forEach>
                </td>
              </tr>
            </table>
          </section>
          <!-- 其他 end -->
        </div>
        <div class="btn-box">
          <input type="button" class="btn-inquiry font-change" id="save" value="保存">
          <input type="button" class="btn-cancel" onclick='cancelMsg("您当前信息未保存，确定要返回吗？");' value="取消">
        </div>
      </div>
    </form>
  </div>
</body>
</html>
