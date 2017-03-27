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
    <title>单一会员II型糖尿病随访详情页</title>
    
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/css/hypertensionFllowDetail.css">
</head>
<body>
	<div class="content">
		<div class="content-title">Ⅱ型糖尿病随访 --- 查看</div>
		<c:choose>
	   		<c:when test="${not empty param.title}">
	   			<%-- <div class="content-title">${param.title}任务--- 查看</div> --%>
	   		</c:when>
	   		<c:otherwise>
	   			<ul class="detail">
					<li class="detail-list">健康档案编号：${pojo.unique_ID }</li>
					<li class="detail-list">姓名：${pojo.member.memname }</li>
					<li class="fr">
<%-- 						<button type="submit" id="" class="btn-inquiry" onclick="window.location.href='list?memberID=${param.memberID}'">返回</button>	 --%>
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
    			<td colspan="8">${pojo.phDiabetesdetail.visitWayStr }</td>
    		</tr>
    		<tr>
    			<th class="align-right">症状</th>
    			<td colspan="8">${pojo.phDiabetesdetail.symptomStr}</td>
    		</tr>
    		<tr>
    			<th class="align-right" rowspan="3">体征</th>
    			<td class="align-right" colspan="2">收缩压</td>
    			<td colspan="2">
    				<c:if test="${not empty pojo.phDiabetesdetail.systolic}">
    					${pojo.phDiabetesdetail.systolic }mmHg
    				</c:if>
    			</td>
    			<td class="align-right" colspan="2">舒张压</td>
    			<td colspan="2">
    				<c:if test="${not empty pojo.phDiabetesdetail.diastolic }">
    					${pojo.phDiabetesdetail.diastolic }mmHg
    				</c:if>
    			</td>
    		</tr>
    		<tr>
    			<td class="align-right">身高</td>
    			<td>
    				<c:choose>
    					<c:when test="${(not empty pojo.phDiabetesdetail.height) && pojo.phDiabetesdetail.height != 0}">
    						${pojo.phDiabetesdetail.height }cm
    					</c:when>
<%--     					<c:otherwise> --%>
<%--     						<c:if test="${not empty pojo.omem.height }">${pojo.omem.height }cm</c:if> --%>
<%--     					</c:otherwise> --%>
    				</c:choose>
    			</td>
    			<td class="align-right" colspan="2">体重</td>
    			<td colspan="2">
    				<c:choose>
    					<c:when test="${(not empty pojo.phDiabetesdetail.weight) && pojo.phDiabetesdetail.weight != 0 }">
    						${pojo.phDiabetesdetail.weight }Kg
    					</c:when>
<%--     					<c:otherwise> --%>
<%--     						<c:if test="${not empty pojo.omem.weight }">${pojo.omem.weight }Kg</c:if> --%>
<%--     					</c:otherwise> --%>
    				</c:choose>
    			</td>
    			<td class="align-right">体质指数</td>
    			<td>
	   				<c:if test="${not empty pojo.phDiabetesdetail.BMI }">
	   				${pojo.phDiabetesdetail.BMI }
	   					(<span style="color: red;">
		   				<c:choose>
					       <c:when test="${pojo.phDiabetesdetail.BMI < 18.5}">
					              轻体重
					       </c:when>
					       <c:when test="${pojo.phDiabetesdetail.BMI >= 18.5 && pojo.phDiabetesdetail.BMI <= 23.9}"> 
						     <span style="color: black;">健康体重</span>
					       </c:when>
					       <c:when test="${pojo.phDiabetesdetail.BMI >=24 && pojo.phDiabetesdetail.BMI <= 26.9}"> 
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
    			<td class="align-right" colspan="2">足背动脉搏动</td>
    			<td colspan="2">${pojo.phDiabetesdetail.arteriopalmusStr }</td>
    			<td class="align-right" colspan="2">其他</td>
    			<td colspan="2">${pojo.phDiabetesdetail.otherSign }</td>
    		</tr>
    		<tr>
    			<th class="align-right" rowspan="3">生活方式指导</th>
    			<td class="align-right">吸烟</td>
    			<td>
    				<c:if test="${not empty pojo.phDiabetesdetail.dailySmoking }">
    					${pojo.phDiabetesdetail.dailySmoking }支/天
    				</c:if>
    			</td>
    			<td class="align-right">目标值</td>
    			<td>
    				<c:if test="${not empty pojo.phDiabetesdetail.dailySmoking_Next }">
    					${pojo.phDiabetesdetail.dailySmoking_Next }支/天
    				</c:if>
    			</td>
    			<td class="align-right">饮酒</td>
    			<td>
    				<c:if test="${not empty pojo.phDiabetesdetail.dailyDrink }">
    					${pojo.phDiabetesdetail.dailyDrink }两/天
    				</c:if>
    			</td>
    			<td class="align-right">目标值</td>
    			<td>
    				<c:if test="${not empty pojo.phDiabetesdetail.dailyDrink_Next }">
    					${pojo.phDiabetesdetail.dailyDrink_Next }两/天
    				</c:if>
    			</td>
    		</tr>
    		<tr>
    			<td class="align-right">运动</td>
    			<td>
    				<c:if test="${not empty pojo.phDiabetesdetail.sportFrequency }">
    					${pojo.phDiabetesdetail.sportFrequency }次/周
    				</c:if>
    			</td>
    			<td class="align-right">每次运动</td>
    			<td>
    				<c:if test="${not empty pojo.phDiabetesdetail.sportDuration }">
    					${pojo.phDiabetesdetail.sportDuration }分钟
    				</c:if>
    			</td>
    			<td class="align-right" colspan="2">主食</td>
	    		<td colspan="2">
	    			<c:if test="${not empty pojo.phDiabetesdetail.mainFood }">
	    				${pojo.phDiabetesdetail.mainFood } g/天
	    			</c:if>
	    		</td>
    		</tr>
    		<tr>
    			<td class="align-right" colspan="2">心理调整</td>
    			<td colspan="2">${pojo.phDiabetesdetail.psychoRecoStr }</td>
    			<td class="align-right" colspan="2">遵医行为</td>
    			<td colspan="2">${pojo.phDiabetesdetail.compliBehavStr }</td>
    		</tr>
    		<tr>
    			<th class="align-right" rowspan="2">辅助检查</th>
    			<td class="align-right">空腹血糖值</td>
    			<td>
    				<c:if test="${not empty pojo.phDiabetesdetail.FPG }">
    					${pojo.phDiabetesdetail.FPG } mmol/l
    				</c:if>
    			</td>
    			<td class="align-right">餐后血糖值</td>
    			<td>
    				<c:if test="${not empty pojo.phDiabetesdetail.PGLU }">
    					${pojo.phDiabetesdetail.PGLU } mmol/l
    				</c:if>
    			</td>
    			<td class="align-right" colspan="2">糖化血红蛋白</td>
    			<td colspan="2">
    				<c:if test="${not empty pojo.phDiabetesdetail.HBA1C }">
    					${pojo.phDiabetesdetail.HBA1C } %
    				</c:if>
    			</td>
    		</tr>
    		<tr>
    			<td class="align-right">其他检查</td>
    			<td colspan="7">${pojo.phDiabetesdetail.checkResult }</td>
    		</tr>
    		<tr>
    			<th class="align-right">服药依从性</th>
    			<td colspan="8">${pojo.phDiabetesdetail.drugCompliStr }</td>
    		</tr>
    		<tr>
    			<th class="align-right">低血糖反应</th>
    			<td colspan="8">${pojo.phDiabetesdetail.rhgStr }</td>
    		</tr>
    		<tr>
    			<th class="align-right">服药不良反应</th>
    			<td colspan="8">
    			${pojo.phDiabetesdetail.drugAdverReaStr}
    			<c:if test="${pojo.phDiabetesdetail.drugAdverseReaction == '2' }">
    				<c:if test="${not empty pojo.phDiabetesdetail.drugAdverseReaction_Desc}">
    					 (${pojo.phDiabetesdetail.drugAdverseReaction_Desc})
    				</c:if>
    			</c:if>
    			</td>
    		</tr>
    		<tr>
    			<th class="align-right">此次随访分类</th>
    			<td colspan="8">${pojo.visitClassStr}</td>
    		</tr>
    		<tr>
    			<th class="align-right" rowspan="${fn:length(pojo.phDiabetesdetailmedicines)==0 ? 2:  pojo.phDiabetesdetailmedicines.size()+1}">用药情况(医嘱)</th>
    			<td class="align-center">药物名称</td>
    			<td class="align-center">用法</td>
    			<td class="align-center">用量</td>
    			<td class="align-center">单位</td>
    			<td class="align-center">频度</td>
    			<td class="align-center" colspan="3">备注</td>
    		</tr>
    		<c:if test="${fn:length(pojo.phDiabetesdetailmedicines)==0}">
    			<tr>
	    			<td class="align-center">&nbsp;</td>
	    			<td class="align-center"></td>
	    			<td class="align-center"></td>
	    			<td class="align-center"></td>
	    			<td class="align-center"></td>
	    			<td class="align-center" colspan="3"></td>
	    		</tr>
    		</c:if>
    		<c:forEach var="item" items="${pojo.phDiabetesdetailmedicines}">
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
    			<td colspan="3">${pojo.phDiabetesdetail.transferReason }</td>
    			<td class="align-right">机构及科室</td>
    			<td colspan="3">${pojo.phDiabetesdetail.transferOrgAndDept }</td>
    		</tr>
    		<tr>
    			<th class="align-right">随访医生</th>
    			<td colspan="4">${pojo.visitDrName }</td>
    			<td class="align-right" colspan="1">${empty param.title ? '下次随访日期' : ''}</td>
    			<td colspan="3">
    				<c:if test="${empty param.title}">
    				<fmt:formatDate value="${pojo.phDiabetesdetail.visitDate_Next}" pattern="yyyy-MM-dd"/>
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
