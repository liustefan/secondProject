<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
  	<meta charset="utf-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=9">
    <title>单一会员高血压随访详情页</title>
    
    <link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/css/hypertensionFllowDetail.css">
</head>
<body>
	<div class="content">
		<div class="content-title">高血压随访 --- 查看</div>
		<c:choose>
	   		<c:when test="${not empty param.title}">
	   			<%-- <div class="content-title">${param.title}任务--- 查看</div> --%>
	   		</c:when>
	   		<c:otherwise>
	   			<ul class="detail">
					<li class="detail-list">健康档案编号：${pojo.unique_ID }</li>
					<li class="detail-list">姓名：${pojo.member.memname }</li>
					<li class="fr">
<%-- 						<button type="button" id="" onclick="window.location.href='list?memberID=${param.memberID}'" class="btn-inquiry">返回</button>	 --%>
					</li>
				</ul>
	   		</c:otherwise>
	   	</c:choose>
		<table border="1" cellspacing="0" class="table-normal table-fixed">
    		<tbody>
    		<tr>
    			<th class="align-right">随访日期</th>
    			<td colspan="8">
    				<fmt:formatDate value="${pojo.visitDate}" pattern="yyyy-MM-dd"/>
    			</td>
    		</tr>
    		<tr>
    			<th class="align-right">随访方式</th>
    			<td colspan="8">
    				${pojo.phHypertensiondetail.visitWayStr }
    			</td>
    		</tr>
    		<tr>
    			<th class="align-right">症状</th>
    			<td colspan="8">
	    			${pojo.phHypertensiondetail.symptomStr}
    			</td>
    		</tr>
    		<tr>
    			<th class="align-right" rowspan="3">体征</th>
    			<td class="align-right" colspan="2">收缩压</td>
    			<td colspan="2">
    				<c:if test="${not empty pojo.phHypertensiondetail.systolic}">
    					${pojo.phHypertensiondetail.systolic }mmHg
    				</c:if>
    			</td>
    			<td class="align-right" colspan="2">舒张压</td>
    			<td colspan="2">
    				<c:if test="${not empty pojo.phHypertensiondetail.diastolic }">
    					${pojo.phHypertensiondetail.diastolic }mmHg
    				</c:if>
    			</td>
    		</tr>
    		<tr>
    			<td class="align-right">身高</td>
    			<td>
    				<c:choose>
    					<c:when test="${(not empty pojo.phHypertensiondetail.height) && pojo.phHypertensiondetail.height != 0}">
    						${pojo.phHypertensiondetail.height }cm
    					</c:when>
<%--     					<c:otherwise> --%>
<%--     						<c:if test="${not empty pojo.omem.height }">${pojo.omem.height }cm</c:if> --%>
<%--     					</c:otherwise> --%>
    				</c:choose>
    			</td>
    			<td class="align-right" colspan="2">体重</td>
    			<td colspan="2">
    				<c:choose>
    					<c:when test="${(not empty pojo.phHypertensiondetail.weight) && pojo.phHypertensiondetail.weight != 0 }">
    						${pojo.phHypertensiondetail.weight }Kg
    					</c:when>
<%--     					<c:otherwise> --%>
<%--     						<c:if test="${not empty pojo.omem.weight }">${pojo.omem.weight }Kg</c:if> --%>
<%--     					</c:otherwise> --%>
    				</c:choose>
    			</td>
    			<td class="align-right">体质指数</td>
    			<td>
	   				<c:if test="${not empty pojo.phHypertensiondetail.BMI }">
	   				${pojo.phHypertensiondetail.BMI }
	   					(<span style="color: red;">
		   				<c:choose>
					       <c:when test="${pojo.phHypertensiondetail.BMI < 18.5}">
					                 轻体重
					       </c:when>
					       <c:when test="${pojo.phHypertensiondetail.BMI >= 18.5 && pojo.phHypertensiondetail.BMI <= 23.9}">
					             <span style="color: black;">健康体重</span>
					       </c:when>
					       <c:when test="${pojo.phHypertensiondetail.BMI >=24 && pojo.phHypertensiondetail.BMI <= 26.9}"> 
						      超重
					       </c:when>
						   <c:otherwise>
					              肥胖      
					       </c:otherwise>
						</c:choose>
						</span>)
	   				</c:if>
    			</td>
    		</tr>
    		<tr>
    			<td class="align-right" colspan="2">心率</td>
    			<td colspan="2">
    				<c:if test="${not empty pojo.phHypertensiondetail.heartRate }">
    					${pojo.phHypertensiondetail.heartRate }次/分钟
    				</c:if>
    			</td>
    			<td class="align-right" colspan="2">其他</td>
    			<td colspan="2">${pojo.phHypertensiondetail.otherSign }</td>
    		</tr>
    		<tr>
    			<th class="align-right" rowspan="3">生活方式指导</th>
    			<td class="align-right">吸烟</td>
    			<td>
    				<c:if test="${not empty pojo.phHypertensiondetail.dailySmoking }">
    					${pojo.phHypertensiondetail.dailySmoking }支/天
    				</c:if>
    			</td>
    			<td class="align-right">目标值</td>
    			<td>
    				<c:if test="${not empty pojo.phHypertensiondetail.dailySmoking_Next }">
    					${pojo.phHypertensiondetail.dailySmoking_Next }支/天
    				</c:if>
    			</td>
    			<td class="align-right">饮酒</td>
    			<td>
    				<c:if test="${not empty pojo.phHypertensiondetail.dailyDrink }">
    					${pojo.phHypertensiondetail.dailyDrink }两/天
    				</c:if>
    			</td>
    			<td class="align-right">目标值</td>
    			<td>
    				<c:if test="${not empty pojo.phHypertensiondetail.dailyDrink_Next }">
    					${pojo.phHypertensiondetail.dailyDrink_Next }两/天
    				</c:if>
    			</td>
    		</tr>
    		<tr>
    			<td class="align-right" colspan="2">运动</td>
    			<td colspan="2">
    				<c:if test="${not empty pojo.phHypertensiondetail.sportFrequency }">
    					${pojo.phHypertensiondetail.sportFrequency }次/周
    				</c:if>
    			</td>
    			<td class="align-right" colspan="2">每次运动</td>
    			<td colspan="2">
    				<c:if test="${not empty pojo.phHypertensiondetail.sportDuration }">
    					${pojo.phHypertensiondetail.sportDuration }分钟
    				</c:if>
    			</td>
    		</tr>
    		<tr>
    			<td class="align-right">心理调整</td>
    			<td>
    				${pojo.phHypertensiondetail.psychoRecoStr}
    			</td>
    			<td class="align-right">遵医行为</td>
    			<td>
    				${pojo.phHypertensiondetail.compliBehavStr}
    			</td>
    			<td class="align-right" colspan="2">涉盐情况</td>
    			<td colspan="2">${pojo.phHypertensiondetail.intakeSaltStr }</td>
    		</tr>
    		<tr>
    			<th class="align-right">辅助检查</th>
    			<td colspan="8">${pojo.phHypertensiondetail.checkResult }</td>
    		</tr>
    		<tr>
    			<th class="align-right">服药依从性</th>
    			<td colspan="8">
	    			${pojo.phHypertensiondetail.drugCompliStr }
    			</td>
    		</tr>
    		<tr>
    			<th class="align-right">服药不良反应</th>
    			<td colspan="8">
    			${pojo.phHypertensiondetail.drugAdverReaStr}
    			<c:if test="${pojo.phHypertensiondetail.drugAdverseReaction == '2' }">
    				<c:if test="${not empty pojo.phHypertensiondetail.drugAdverseReaction_Desc}">
    					 (${pojo.phHypertensiondetail.drugAdverseReaction_Desc})
    				</c:if>
    			</c:if>
    			</td>
    		</tr>
    		<tr>
    			<th class="align-right">此次随访分类</th>
    			<td colspan="8">
    				${pojo.visitClassStr}
    			</td>
    		</tr>
    		<tr>
    			<th class="align-right" rowspan="${fn:length(pojo.phHypertensiondetailmedicines)==0 ? 2:  pojo.phHypertensiondetailmedicines.size()+1}">用药情况(医嘱)</th>
    			<td class="align-center">药物名称</td>
    			<td class="align-center">用法</td>
    			<td class="align-center">用量</td>
    			<td class="align-center">单位</td>
    			<td class="align-center">频度</td>
    			<td class="align-center" colspan="3">备注</td>
    		</tr>
    		<c:if test="${fn:length(pojo.phHypertensiondetailmedicines)==0}">
    			<tr>
	    			<td class="align-center">&nbsp;</td>
	    			<td class="align-center"></td>
	    			<td class="align-center"></td>
	    			<td class="align-center"></td>
	    			<td class="align-center"></td>
	    			<td class="align-center" colspan="3"></td>
	    		</tr>
    		</c:if>
    		<c:forEach var="item" items="${pojo.phHypertensiondetailmedicines}">
	    		<tr>
	    			<td class="align-center">${item.drugName}</td>
	    			<td class="align-center">${item.drugUsage}</td>
	    			<td class="align-center">${item.drugDosage}</td>
	    			<td class="align-center">${item.drugUnit}</td>
	    			<td class="align-center">${item.drugFreq}</td>
	    			<td class="align-center" colspan="3">${item.remarks}</td>
	    		</tr>
    		</c:forEach>
    		<tr>
    			<th class="align-right">转诊</th>
    			<td class="align-right">原因</td>
    			<td colspan="3">${pojo.phHypertensiondetail.transferReason }</td>
    			<td class="align-right">机构及科室</td>
    			<td colspan="3">${pojo.phHypertensiondetail.transferOrgAndDept }</td>
    		</tr>
    		<tr>
    			<th class="align-right">随访医生</th>
    			<td colspan="4">${pojo.visitDrName }</td>
    			<td class="align-right" colspan="1">${empty param.title ? '下次随访日期' : ''}</td>
    			<td colspan="3">
    				<c:if test="${empty param.title}">
    				<fmt:formatDate value="${pojo.phHypertensiondetail.visitDate_Next}" pattern="yyyy-MM-dd"/>
    				</c:if>
    			</td>
    		</tr>
    		<tr>
    			<td colspan="9" style="text-align: center;"><input type="button" class="btn-normal" value="返回" onclick="history.go(-1)"/></td>
    		</tr>
    		</tbody>
	    </table>
	</div>
</body>
</html>
