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
<title>健康体检详情</title>
<link rel="stylesheet" href="<%=path %>/css/general.css">
<link rel="stylesheet" href="<%=path %>/css/editCheckUpDetail.css">

<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/tab.js"></script>
</head>
<body>
	<div class="content">
		<div class="content-title">健康体检 --- 查看</div>
		<table class="memberInfo table-fixed">
			<tr>
				<td>健康档案编号：${pojo.unique_ID}</td>
				<td>姓名：${pojo.name}</td>
				<td>体检编号：${pojo.refDataPK}</td>
			</tr>
			<tr>	
				<td>体检日期：<fmt:formatDate value="${pojo.examDate}" /></td>
				<td>责任医生：${pojo.responsibleDrName}</td>
			</tr>
		</table>
		<nav>
			<ul id="tab_title" class="clearfix">
				<li>健康体检(必填项)</li>
				<li>健康体检(选填项)</li>
				<li>健康体检(其它)</li>
				<input type="button" class="btn-inquiry fr" onclick="window.location.href='list?memberID=${param.memberID}'" value="返回">
			</ul>
		</nav>
		<div class="tab-content">
			<div id="tab_conbox" class="clearfix">
				<section class="tab-conbox-item">
					<table class="table-normal table-fixed">
						<colgroup>
							<col span="2" width="16%"/>
						</colgroup>
						<tr>
							<th class="top-info">内容</th>
							<td colspan="7" class="align-center top-info">检查项目</td>
						</tr>
						<tr>
						<th>症状</th>
							<td colspan="7">
								${pojo.phHealthexamdetail.symptomStr}
							</td>
						</tr>
						<tr>
							<th rowspan="${pojo.elderly ? 9 : 5}">一般状况</th>
							<td class="align-right">体温</td>
							<td><c:if test="${not empty pojo.phHealthexamdetail.bodyTemperature}">${pojo.phHealthexamdetail.bodyTemperature}℃</c:if></td>
							<td class="align-right">脉率</td>
							<td colspan="4"><c:if test="${not empty pojo.phHealthexamdetail.pulseRate}">${pojo.phHealthexamdetail.pulseRate}次/分钟</c:if></td>
						</tr>
						<tr>
							<td rowspan="2" class="align-right">呼吸频率</td>
							<td rowspan="2"><c:if
									test="${not empty pojo.phHealthexamdetail.respiratoryRate}">${pojo.phHealthexamdetail.respiratoryRate}次/分钟</c:if></td>
							<td rowspan="2" class="align-right">血压</td>
							<td class="align-right">左侧</td>
							<td colspan="3"><c:if
									test="${ not empty pojo.phHealthexamdetail.leftSystolic && not empty pojo.phHealthexamdetail.leftDiastolic}">${pojo.phHealthexamdetail.leftSystolic}/${pojo.phHealthexamdetail.leftDiastolic}mmhg</c:if></td>
						</tr>
						<tr class="bgfff">
							<td class="align-right">右侧</td>
							<td colspan="3"><c:if
									test="${ not empty pojo.phHealthexamdetail.rightSystolic && not empty pojo.phHealthexamdetail.rightDiastolic}">${pojo.phHealthexamdetail.rightSystolic}/${pojo.phHealthexamdetail.rightDiastolic}mmhg</c:if></td>
						</tr>
						<tr>
							<td class="align-right">身高</td>
							<td>
								${pojo.phHealthexamdetail.height}
							</td>
							<td class="align-right">体重</td>
							<td colspan="4">
								${pojo.phHealthexamdetail.weight}
							</td>
						</tr>
						<tr>
							<td class="align-right">腰围</td>
							<td>
								${pojo.phHealthexamdetail.waist}
							</td>
							<td class="align-right">体质指数</td>
							<td colspan="4"><c:if
									test="${not empty pojo.phHealthexamdetail.BMI }">
		   				${pojo.phHealthexamdetail.BMI }
		   					(<span class="red"> <c:choose>
											<c:when test="${pojo.phHealthexamdetail.BMI < 18.5}">
						              体重过低
						       </c:when>
											<c:when
												test="${pojo.phHealthexamdetail.BMI >= 18.5 && pojo.phHealthexamdetail.BMI <= 23.9}">
												<span>体重正常</span>
											</c:when>
											<c:when
												test="${pojo.phHealthexamdetail.BMI >=24 && pojo.phHealthexamdetail.BMI <= 26.9}"> 
							      体重超重
						       </c:when>
											<c:otherwise>
						              体重肥胖      
						       </c:otherwise>
										</c:choose>
									</span>)
		   				</c:if></td>
						</tr>
						<tr <c:if test="${!pojo.elderly}">class="hide"</c:if>>
							<td class="align-right">老年人健康状态自我评估</td>
							<td colspan="6">${pojo.phHealthexamdetail.agedHealthEvaluateStr}</td>
						</tr>
						<tr <c:if test="${!pojo.elderly}">class="hide"</c:if>>
							<td class="align-right">老年人生活自理能力自我评估</td>
							<td colspan="6">${pojo.phHealthexamdetail.agedLifeEvaluateStr}</td>
						</tr>
						<tr <c:if test="${!pojo.elderly}">class="hide"</c:if>>
							<td class="align-right">老年人认知功能</td>
							<td colspan="6">${pojo.phHealthexamdetail.agedCognitionStr}<c:if
									test="${pojo.phHealthexamdetail.agedCognition == '2'}">，简易智力状态检查，&nbsp&nbsp总分${pojo.phHealthexamdetail.agedCognitionScore}</c:if>
							</td>
						</tr>
						<tr <c:if test="${!pojo.elderly}">class="hide"</c:if>>
							<td class="align-right">老年人情感状态</td>
							<td colspan="6">${pojo.phHealthexamdetail.agedFeelingStr}<c:if
									test="${pojo.phHealthexamdetail.agedFeeling == '2'}">，老年人抑郁评分检查，&nbsp&nbsp总分${pojo.phHealthexamdetail.agedFeelingScore}</c:if></td>
						</tr>
						<tr>
							<th rowspan="16">生活方式</th>
							<td rowspan="3" class="align-right">体育锻炼</td>
							<td class="align-right">锻炼频率</td>
							<td colspan="5">${pojo.phHealthexamdetail.sportFrequencyStr}</td>
						</tr>
						<tr>
							<td class="align-right">每次锻炼时间</td>
							<td colspan="2"><c:if
									test="${not empty pojo.phHealthexamdetail.sportDuration }">${pojo.phHealthexamdetail.sportDuration}分钟</c:if></td>
							<td class="align-right">坚持锻炼时间</td>
							<td colspan="2"><c:if
									test="${not empty pojo.phHealthexamdetail.sportTotalTime }">${pojo.phHealthexamdetail.sportTotalTime}年</c:if></td>
						</tr>
						<tr>
							<td class="align-right">锻炼方式</td>
							<td colspan="5">${pojo.phHealthexamdetail.sportWay}</td>
						</tr>
						<tr>
							<td class="align-right">饮食习惯</td>
							<td colspan="6">${pojo.phHealthexamdetail.eatingHabitsStr}</td>
						</tr>
						<tr>
							<td rowspan="2" class="align-right">吸烟情况</td>
							<td class="align-right">吸烟状况</td>
							<td colspan="5">${pojo.phHealthexamdetail.smokingStateStr}</td>
						</tr>
						<tr>
							<td class="align-right">日吸烟量</td>
							<td><c:if test="${not empty pojo.phHealthexamdetail.dailySmoking }">平均${pojo.phHealthexamdetail.dailySmoking}支</c:if></td>
							<td class="align-right">开始吸烟年龄</td>
							<td><c:if test="${not empty pojo.phHealthexamdetail.smokingStartAge}">${pojo.phHealthexamdetail.smokingStartAge}岁</c:if></td>
							<td class="align-right">戒烟年龄</td>
							<td><c:if test="${not empty pojo.phHealthexamdetail.smokingEndAge}">${pojo.phHealthexamdetail.smokingEndAge}岁</c:if></td>
						</tr>
						<tr>
							<td rowspan="4" class="align-right">饮酒情况</td>
							<td class="align-right">饮酒频率</td>
							<td colspan="5">${pojo.phHealthexamdetail.drinkFrequencyStr}</td>
						</tr>
						<tr>
							<td class="align-right">日饮酒量</td>
							<td><c:if test="${not empty pojo.phHealthexamdetail.dailyDrink }">平均${pojo.phHealthexamdetail.dailyDrink}两</c:if></td>
							<td class="align-right">是否戒酒</td>
							<td>${pojo.phHealthexamdetail.isAbstinenceStr}</td>
							<td class="align-right">戒酒年龄</td>
							<td><c:if test="${ not empty pojo.phHealthexamdetail.abstinenceAge}">${pojo.phHealthexamdetail.abstinenceAge}岁</c:if></td>
						</tr>
						<tr>
							<td class="align-right">开始饮酒年龄</td>
							<td><c:if test="${not empty pojo.phHealthexamdetail.drinkStartAge}">${pojo.phHealthexamdetail.drinkStartAge}岁</c:if></td>
							<td colspan="2" class="align-right">近一年是否曾醉酒</td>
							<td colspan="2">${pojo.phHealthexamdetail.isTemulenceLastYearStr}</td>
						</tr>
						<tr>
							<td class="align-right">饮酒种类</td>
							<td colspan="5">${pojo.phHealthexamdetail.drinkTypeStr}</td>
						</tr>
						<tr>
							<td rowspan="6" class="align-right">职业暴露情况</td>
							<td colspan="6">${pojo.phHealthexamdetail.occupationStr}<c:if
									test="${pojo.phHealthexamdetail.occupation == '2'}">(工种:${pojo.phHealthexamdetail.typeOfWork}&nbsp&nbsp&nbsp从业${pojo.phHealthexamdetail.workTime}年)</c:if>&nbsp;</td>
	
						</tr>
						<tr>
							<td rowspan="5" class="align-center">毒物种类</td>
							<td class="align-right">化学物质</td>
							<td>${pojo.phHealthexamdetail.chemical}</td>
							<td rowspan="5" class="align-center">防护措施</td>
							<td colspan="2">${pojo.phHealthexamdetail.chemicalGuardStr}<c:if
									test="${pojo.phHealthexamdetail.chemicalGuard == '2' && not empty pojo.phHealthexamdetail.chemicalGuard_Desc}">(${pojo.phHealthexamdetail.chemicalGuard_Desc})</c:if></td>
						</tr>
						<tr>
							<td class="align-right">物理因素</td>
							<td>${pojo.phHealthexamdetail.physical}</td>
							<td colspan="2">${pojo.phHealthexamdetail.physicalGuardStr}<c:if
									test="${pojo.phHealthexamdetail.physicalGuard == '2' && not empty pojo.phHealthexamdetail.physicalGuard_Desc}">(${pojo.phHealthexamdetail.physicalGuard_Desc})</c:if></td>
						</tr>
						<tr>
							<td class="align-right">放射物质</td>
							<td>${pojo.phHealthexamdetail.radiogen }</td>
							<td colspan="2">${pojo.phHealthexamdetail.radiogenGuardStr}<c:if
									test="${pojo.phHealthexamdetail.radiogenGuard == '2' && not empty pojo.phHealthexamdetail.radiogenGuard_Desc}">(${pojo.phHealthexamdetail.radiogenGuard_Desc})</c:if></td>
						</tr>
						<tr>
							<td class="align-right">粉尘</td>
							<td>${pojo.phHealthexamdetail.dust}</td>
							<td colspan="2">${pojo.phHealthexamdetail.dustGuardStr}<c:if
									test="${pojo.phHealthexamdetail.dustGuard == '2' && not empty pojo.phHealthexamdetail.dustGuard_Desc}">(${pojo.phHealthexamdetail.dustGuard_Desc})</c:if></td>
						</tr>
						<tr>
							<td class="align-right">其他</td>
							<td>${pojo.phHealthexamdetail.toxicOther}</td>
							<td colspan="2">${pojo.phHealthexamdetail.toxicOtherGuardStr }<c:if
									test="${pojo.phHealthexamdetail.toxicOtherGuard == '2' && not empty pojo.phHealthexamdetail.toxicOtherGuard_Desc}">(${pojo.phHealthexamdetail.toxicOtherGuard_Desc})</c:if></td>
						</tr>
					</table>
				</section>
				<!-- 必填项 end -->
				<section class="tab-conbox-item">
					<table class="table-normal table-fixed">
						<colgroup>
							<col span="2" width="16%" />
						</colgroup>
						<tr>
							<th rowspan="6">脏器功能</th>
							<td rowspan="3" class="align-right bgfff">口腔</td>
							<td colspan="2" class="align-right">口唇</td>
							<td colspan="7">${pojo.phHealthexamdetail.lipsStr}</td>
						</tr>
						<tr>
							<td colspan="2" class="align-right">齿列</td>
							<td colspan="2">${pojo.phHealthexamdetail.dentitionStr}</td>
							<td colspan="2" class="align-right">说明</td>
							<td colspan="3">${pojo.phHealthexamdetail.dentition_Desc}</td>
						</tr>
						<tr>
							<td colspan="2" class="align-right">咽部</td>
							<td colspan="7">${pojo.phHealthexamdetail.throatStr}</td>
						</tr>
						<tr>
							<td class="align-right">视力</td>
							<td class="align-right">左眼</td>
							<td>${pojo.phHealthexamdetail.leftVision}</td>
							<td class="align-right">右眼</td>
							<td>${pojo.phHealthexamdetail.rightVision}</td>
							<td class="align-right">矫正视力：左眼</td>
							<td>${pojo.phHealthexamdetail.leftCorrectVision}</td>
							<td class="align-right">矫正视力：右眼</td>
							<td colspan="2">${pojo.phHealthexamdetail.rightCorrectVision}</td>
						</tr>
						<tr>
							<td class="align-right">听力</td>
							<td colspan="9">${pojo.phHealthexamdetail.hearingStr }</td>
						</tr>
						<tr>
							<td class="align-right">运动能力</td>
							<td colspan="9">${pojo.phHealthexamdetail.movementStr}</td>
						</tr>
						<tr>
							<th rowspan="${ (pojo.member.gender == '2')? 20: 14}">查体</th>
							<td class="align-right">眼底</td>
							<td colspan="9">${pojo.phHealthexamdetail.eyegroundStr}<c:if
									test="${pojo.phHealthexamdetail.eyeground == '2' && not empty pojo.phHealthexamdetail.eyeground_Desc}">(${pojo.phHealthexamdetail.eyeground_Desc})</c:if></td>
						</tr>
						<tr>
							<td class="align-right">皮肤</td>
							<td colspan="9">${pojo.phHealthexamdetail.skinStr}<c:if
									test="${pojo.phHealthexamdetail.skin=='7' && not empty pojo.phHealthexamdetail.skin_Desc}">(${pojo.phHealthexamdetail.skin_Desc})</c:if></td>
						</tr>
						<tr>
							<td class="align-right">巩膜</td>
							<td colspan="9">${pojo.phHealthexamdetail.scleroStr}<c:if
									test="${pojo.phHealthexamdetail.sclero=='4' && not empty pojo.phHealthexamdetail.sclero_Desc}">(${pojo.phHealthexamdetail.sclero_Desc})</c:if></td>
						</tr>
						<tr>
							<td class="align-right">淋巴结</td>
							<td colspan="9">${pojo.phHealthexamdetail.lymphStr}<c:if
									test="${pojo.phHealthexamdetail.lymph=='4' && not empty pojo.phHealthexamdetail.lymph_Desc}">(${pojo.phHealthexamdetail.lymph_Desc})</c:if></td>
						</tr>
						<tr>
							<td rowspan="2" class="align-right">肺</td>
							<td colspan="4">桶状胸：${pojo.phHealthexamdetail.lungBarrelChestStr}</td>
							<td colspan="5">呼吸音：${pojo.phHealthexamdetail.lungBreathSoundsStr}<c:if
									test="${pojo.phHealthexamdetail.lungBreathSounds == '2' && not empty pojo.phHealthexamdetail.lungBreathSounds_Desc}">(${pojo.phHealthexamdetail.lungBreathSounds_Desc})</c:if></td>
						</tr>
						<tr>
							<td colspan="9">罗音：${pojo.phHealthexamdetail.lungRalesStr}
							<c:if test="${pojo.phHealthexamdetail.lungRales == '4' && not empty pojo.phHealthexamdetail.lungRales_Desc}">(${pojo.phHealthexamdetail.lungRales_Desc})</c:if></td>
						</tr>
						<tr>
							<td rowspan="2" class="align-right">心脏</td>
							<td colspan="4">心率：<c:if test="${not empty pojo.phHealthexamdetail.heartRate }">${pojo.phHealthexamdetail.heartRate}次/分钟</c:if></td>
							<td colspan="5">心律：${pojo.phHealthexamdetail.rhythmStr}</td>
						</tr>
						<tr>
							<td colspan="9">杂音:${pojo.phHealthexamdetail.murmurStr}<c:if
									test="${pojo.phHealthexamdetail.murmur == '2' && not empty pojo.phHealthexamdetail.murmur_Desc}">(${pojo.phHealthexamdetail.murmur_Desc})</c:if></td>
						</tr>
						<tr>
							<td rowspan="3" class="align-right">腹部</td>
							<td colspan="4">压痛：${pojo.phHealthexamdetail.painStr}<c:if
									test="${pojo.phHealthexamdetail.pain == '2' && not empty pojo.phHealthexamdetail.pain_Desc}">(${pojo.phHealthexamdetail.pain_Desc})</c:if></td>
							<td colspan="5">包块：${pojo.phHealthexamdetail.blockStr}<c:if
									test="${pojo.phHealthexamdetail.block == '2' && not empty pojo.phHealthexamdetail.block_Desc}">(${pojo.phHealthexamdetail.block_Desc})</c:if></td>
						</tr>
						<tr>
							<td colspan="4">肝大：${pojo.phHealthexamdetail.hepatomegalyStr}<c:if
									test="${pojo.phHealthexamdetail.hepatomegaly == '2' && not empty pojo.phHealthexamdetail.hepatomegaly_Desc}">(${pojo.phHealthexamdetail.hepatomegaly_Desc})</c:if></td>
							<td colspan="5">脾大：${pojo.phHealthexamdetail.splenomegalyStr}<c:if
									test="${pojo.phHealthexamdetail.splenomegaly == '2' && not empty pojo.phHealthexamdetail.splenomegaly_Desc}">(${pojo.phHealthexamdetail.splenomegaly_Desc})</c:if></td>
						</tr>
						<tr>
							<td colspan="9">移动性浊音：${pojo.phHealthexamdetail.moveSonantStr}<c:if
									test="${pojo.phHealthexamdetail.moveSonant == '2' && not empty pojo.phHealthexamdetail.moveSonant_Desc}">(${pojo.phHealthexamdetail.moveSonant_Desc})</c:if></td>
						</tr>
						<tr>
							<td class="align-right">下肢水肿</td>
							<td colspan="9">${pojo.phHealthexamdetail.lowLimbEdemaStr}</td>
						</tr>
						<tr>
							<td class="align-right">足背动脉搏动</td>
							<td colspan="9">${pojo.phHealthexamdetail.arteriopalmusStr}</td>
						</tr>
						<tr>
							<td class="align-right">肛门指诊</td>
							<td colspan="9">${pojo.phHealthexamdetail.anusTactusStr}<c:if
									test="${pojo.phHealthexamdetail.anusTactus=='5' && not empty pojo.phHealthexamdetail.anusTactus_Desc}">(${pojo.phHealthexamdetail.anusTactus_Desc})</c:if></td>
						</tr>
						<c:if test="${(pojo.member.gender == '2')? true: false}">
							<tr>
								<td rowspan="6" class="align-right">妇科</td>
								<td class="align-right">乳腺</td>
								<td colspan="8">${pojo.phHealthexamdetail.breastStr}</td>
							</tr>
							<tr>
								<td class="align-right">外阴</td>
								<td colspan="8">${pojo.phHealthexamdetail.pudendumStr}<c:if
										test="${pojo.phHealthexamdetail.pudendum == '2' && not empty pojo.phHealthexamdetail.pudendum_Desc}">(${pojo.phHealthexamdetail.pudendum_Desc})</c:if></td>
							</tr>
							<tr>
								<td class="align-right">阴道</td>
								<td colspan="8">${pojo.phHealthexamdetail.vaginaStr}<c:if
										test="${pojo.phHealthexamdetail.vagina == '2' && not empty pojo.phHealthexamdetail.vagina_Desc}">(${pojo.phHealthexamdetail.vagina_Desc})</c:if></td>
							</tr>
							<tr>
								<td class="align-right">宫颈</td>
								<td colspan="8">${pojo.phHealthexamdetail.cervicalStr}<c:if
										test="${pojo.phHealthexamdetail.cervical == '2' && not empty pojo.phHealthexamdetail.cervical_Desc}">(${pojo.phHealthexamdetail.cervical_Desc})</c:if></td>
							</tr>
							<tr>
								<td class="align-right">宫体</td>
								<td colspan="8">${pojo.phHealthexamdetail.uteriStr}<c:if
										test="${pojo.phHealthexamdetail.uteri == '2' && not empty pojo.phHealthexamdetail.uteri_Desc}">(${pojo.phHealthexamdetail.uteri_Desc})</c:if></td>
							</tr>
							<tr>
								<td class="align-right">附件</td>
								<td colspan="8">${pojo.phHealthexamdetail.enclosureStr}<c:if
										test="${pojo.phHealthexamdetail.enclosure == '2' && not empty pojo.phHealthexamdetail.enclosure_Desc}">(${pojo.phHealthexamdetail.enclosure_Desc})</c:if></td>
							</tr>
						</c:if>
						<tr>
							<th rowspan="18">辅助检查</th>
							<td class="align-right">空腹血糖</td>
							<td colspan="3"><c:if test="${not empty pojo.phHealthexamdetail.GLU}"> ${pojo.phHealthexamdetail.GLU}mmol/L</c:if></td>
							<td class="align-right">餐后血糖</td>
							<td colspan="5"><c:if test="${not empty pojo.phHealthexamdetail.PGLU}">${pojo.phHealthexamdetail.PGLU}mmol/L</c:if></td>
						</tr>
						<tr>
							<td rowspan="2" class="align-right">血常规</td>
							<td class="align-right">血红蛋白</td>
							<td colspan="2"><c:if test="${not empty pojo.phHealthexamdetail.hemoglobin }">${pojo.phHealthexamdetail.hemoglobin}g/L</c:if></td>
							<td class="align-right">白细胞</td>
							<td colspan="2"><c:if test="${not empty pojo.phHealthexamdetail.leukocyte }">${pojo.phHealthexamdetail.leukocyte}x10^9/L</c:if></td>
							<td class="align-right">血小板</td>
							<td colspan="2"><c:if test="${not empty pojo.phHealthexamdetail.platelet }">${pojo.phHealthexamdetail.platelet}x10^9/L</c:if></td>
						</tr>
						<tr>
							<td class="align-right">其它</td>
							<td colspan="8">${pojo.phHealthexamdetail.bloodOther}</td>
						</tr>
						<tr>
							<td rowspan="2" class="align-right">尿常规</td>
							<td class="align-right">尿蛋白</td>
							<td>${pojo.phHealthexamdetail.urineProtein}</td>
							<td class="align-right">尿糖</td>
							<td>${pojo.phHealthexamdetail.urineSugar}</td>
							<td colspan="2" class="align-right">尿酮体</td>
							<td>${pojo.phHealthexamdetail.urineAcetoneBody}</td>
							<td class="align-right">尿潜血</td>
							<td>${pojo.phHealthexamdetail.urineOccultBlood}</td>
						</tr>
						<tr>
							<td class="align-right">其它</td>
							<td colspan="8">${pojo.phHealthexamdetail.urineOther}</td>
						</tr>
						<tr>
							<td class="align-right">尿微量蛋白</td>
							<td><c:if test="${not empty pojo.phHealthexamdetail.urineMicroAlbumin }">${pojo.phHealthexamdetail.urineMicroAlbumin}mg/dL</c:if></td>
							<td class="align-right">大便潜血</td>
							<td colspan="7">${pojo.phHealthexamdetail.fecalOccultBloodStr}</td>
						</tr>
						<tr>
							<td rowspan="2" class="align-right">肝功能</td>
							<td class="align-right">血清谷丙转氨酶</td>
							<td colspan="2"><c:if test="${not empty pojo.phHealthexamdetail.CPT }">${pojo.phHealthexamdetail.CPT}U/L</c:if></td>
							<td class="align-right">血清谷草转氨酶</td>
							<td colspan="2"><c:if test="${not empty pojo.phHealthexamdetail.AST }">${pojo.phHealthexamdetail.AST}U/L</c:if></td>
							<td class="align-right">白蛋白</td>
							<td colspan="2"><c:if test="${not empty pojo.phHealthexamdetail.ALB }">${pojo.phHealthexamdetail.ALB}g/L</c:if></td>
						</tr>
						<tr>
							<td class="align-right">总胆红素</td>
							<td colspan="4"><c:if test="${not empty pojo.phHealthexamdetail.TBIL }">${pojo.phHealthexamdetail.TBIL}umol/L</c:if></td>
							<td class="align-right">结合胆红素</td>
							<td colspan="3"><c:if test="${not empty pojo.phHealthexamdetail.CBIL }">${pojo.phHealthexamdetail.CBIL}umol/L</c:if></td>
						</tr>
						<tr>
							<td class="align-right">肾功能</td>
							<td class="align-right">血清肌酐</td>
							<td><c:if test="${not empty pojo.phHealthexamdetail.CR }">${pojo.phHealthexamdetail.CR}umol/L</c:if></td>
							<td class="align-right">血尿素氮</td>
							<td colspan="2"><c:if test="${not empty pojo.phHealthexamdetail.BUN }">${pojo.phHealthexamdetail.BUN}umol/L</c:if></td>
							<td class="align-right">血钾浓度</td>
							<td><c:if test="${not empty pojo.phHealthexamdetail.serumPotassium }">${pojo.phHealthexamdetail.serumPotassium}umol/L</c:if></td>
							<td class="align-right">血钠浓度</td>
							<td><c:if test="${not empty pojo.phHealthexamdetail.serumSodium }">${pojo.phHealthexamdetail.serumSodium}umol/L</c:if></td>
						</tr>
						<tr>
							<td rowspan="2" class="align-right">血脂</td>
							<td class="align-right">总胆固醇</td>
							<td colspan="2"><c:if test="${not empty pojo.phHealthexamdetail.CHOL }">${pojo.phHealthexamdetail.CHOL}mmol/L</c:if></td>
							<td class="align-right">甘油三酯</td>
							<td colspan="2"><c:if test="${not empty pojo.phHealthexamdetail.TG }">${pojo.phHealthexamdetail.TG}mmol/L</c:if></td>
							<td class="align-right">血清低密度脂蛋白胆固醇</td>
							<td colspan="2"><c:if test="${not empty pojo.phHealthexamdetail.LDL_C }">${pojo.phHealthexamdetail.LDL_C}mmol/L</c:if></td>
						</tr>
						<tr>
							<td class="align-right">血清高密度脂蛋白胆固醇</td>
							<td colspan="8"><c:if test="${not empty pojo.phHealthexamdetail.HDL_C }">${pojo.phHealthexamdetail.HDL_C}mmol/L</c:if></td>
						</tr>
						<tr>
							<td class="align-right">糖化血红蛋白</td>
							<td colspan="9"><c:if test="${not empty pojo.phHealthexamdetail.HBA1C }">${pojo.phHealthexamdetail.HBA1C}%</c:if></td>
						</tr>
						<tr>
							<td class="align-right">乙肝表面抗原</td>
							<td colspan="9">${pojo.phHealthexamdetail.HBSAGStr}</td>
						</tr>
						<tr>
							<td class="align-right">心电图</td>
							<td colspan="9">${pojo.phHealthexamdetail.cardiogramStr}<c:if
									test="${pojo.phHealthexamdetail.cardiogram == '2' && not empty pojo.phHealthexamdetail.cardiogram_Desc}">(${pojo.phHealthexamdetail.cardiogram_Desc})</c:if></td>
						</tr>
						<tr>
							<td class="align-right">胸部X线片</td>
							<td colspan="9">${pojo.phHealthexamdetail.x_RAYStr}<c:if
									test="${pojo.phHealthexamdetail.x_RAY == '2' && not empty pojo.phHealthexamdetail.x_RAY_Desc}">(${pojo.phHealthexamdetail.x_RAY_Desc})</c:if></td>
						</tr>
						<tr>
							<td class="align-right">B超</td>
							<td colspan="9">${pojo.phHealthexamdetail.b_UltrasonicStr}<c:if
									test="${pojo.phHealthexamdetail.b_Ultrasonic == '2' && not empty pojo.phHealthexamdetail.b_Ultrasonic_Desc}">(${pojo.phHealthexamdetail.b_Ultrasonic_Desc})</c:if></td>
						</tr>
						<tr>
							<td class="align-right">宫颈涂片</td>
							<td colspan="9">${pojo.phHealthexamdetail.cervicalSmearStr}<c:if
									test="${pojo.phHealthexamdetail.cervicalSmear == '2' && not empty pojo.phHealthexamdetail.cervicalSmear_Desc}">(${pojo.phHealthexamdetail.cervicalSmear_Desc})</c:if></td>
						</tr>
						<tr>
							<td class="align-right">其它</td>
							<td colspan="9">${pojo.phHealthexamdetail.assistCheckOther}</td>
						</tr>
						<tr class="align-center">
							<th rowspan="3">中医体质辨识</th>
							<td class="align-right">体 质</td>
							<td>气虚质</td>
							<td>阳虚质</td>
							<td>阴虚质</td>
							<td>痰湿质</td>
							<td>湿热质</td>
							<td>血瘀质</td>
							<td>气郁质</td>
							<td>特禀质</td>
							<td>平和质</td>
						</tr>
						<tr class="align-center">
							<td class="align-right">辨识结果</td>
							<td>${pojo.phHealthexamdetail.TCM_QXZStr}</td>
							<td>${pojo.phHealthexamdetail.TCM_YXZStr}</td>
							<td>${pojo.phHealthexamdetail.TCM_YIXZStr}</td>
							<td>${pojo.phHealthexamdetail.TCM_TSZStr}</td>
							<td>${pojo.phHealthexamdetail.TCM_SRZStr}</td>
							<td>${pojo.phHealthexamdetail.TCM_XTZStr}</td>
							<td>${pojo.phHealthexamdetail.TCM_QYZStr}</td>
							<td>${pojo.phHealthexamdetail.TCM_TBZStr}</td>
							<td>${pojo.phHealthexamdetail.TCM_PHZStr}</td>
						</tr>
						<tr class="align-center">
							<td class="align-right">保健指导</td>
							<td>${pojo.phHealthexamdetail.TCM_QXZ_GuideStr}
							<c:if test="${not empty pojo.phHealthexamdetail.TCM_QXZ_GuideStr && not empty pojo.phHealthexamdetail.TCM_QXZ_Guide_Desc}">
							,
							</c:if>
							${pojo.phHealthexamdetail.TCM_QXZ_Guide_Desc}</td>
							<td>${pojo.phHealthexamdetail.TCM_YXZ_GuideStr}
							<c:if test="${not empty pojo.phHealthexamdetail.TCM_YXZ_GuideStr && not empty pojo.phHealthexamdetail.TCM_YXZ_Guide_Desc}">
							,
							</c:if>
							${pojo.phHealthexamdetail.TCM_YXZ_Guide_Desc}</td>
							<td>${pojo.phHealthexamdetail.TCM_YIXZ_GuideStr}
							<c:if test="${not empty pojo.phHealthexamdetail.TCM_YIXZ_GuideStr && not empty pojo.phHealthexamdetail.TCM_YIXZ_Guide_Desc}">
							,
							</c:if>
							${pojo.phHealthexamdetail.TCM_YIXZ_Guide_Desc}</td>
							<td>${pojo.phHealthexamdetail.TCM_TSZ_GuideStr}
							<c:if test="${not empty pojo.phHealthexamdetail.TCM_TSZ_GuideStr && not empty pojo.phHealthexamdetail.TCM_TSZ_Guide_Desc}">
							,
							</c:if>
							${pojo.phHealthexamdetail.TCM_TSZ_Guide_Desc}</td>
							<td>${pojo.phHealthexamdetail.TCM_SRZ_GuideStr}
							<c:if test="${not empty pojo.phHealthexamdetail.TCM_SRZ_GuideStr && not empty pojo.phHealthexamdetail.TCM_SRZ_Guide_Desc}">
							,
							</c:if>
							${pojo.phHealthexamdetail.TCM_SRZ_Guide_Desc}</td>
							<td>${pojo.phHealthexamdetail.TCM_XTZ_GuideStr}
							<c:if test="${not empty pojo.phHealthexamdetail.TCM_XTZ_GuideStr && not empty pojo.phHealthexamdetail.TCM_XTZ_Guide_Desc}">
							,
							</c:if>
							${pojo.phHealthexamdetail.TCM_XTZ_Guide_Desc}</td>
							<td>${pojo.phHealthexamdetail.TCM_QYZ_GuideStr}
							<c:if test="${not empty pojo.phHealthexamdetail.TCM_QYZ_GuideStr && not empty pojo.phHealthexamdetail.TCM_QYZ_Guide_Desc}">
							,
							</c:if>
							${pojo.phHealthexamdetail.TCM_QYZ_Guide_Desc}</td>
							<td>${pojo.phHealthexamdetail.TCM_TBZ_GuideStr}
							<c:if test="${not empty pojo.phHealthexamdetail.TCM_TBZ_GuideStr && not empty pojo.phHealthexamdetail.TCM_TBZ_Guide_Desc}">
							,
							</c:if>
							${pojo.phHealthexamdetail.TCM_TBZ_Guide_Desc}</td>
							<td>${pojo.phHealthexamdetail.TCM_PHZ_GuideStr}
							<c:if test="${not empty pojo.phHealthexamdetail.TCM_PHZ_GuideStr && not empty pojo.phHealthexamdetail.TCM_PHZ_Guide_Desc}">
							,
							</c:if>
							${pojo.phHealthexamdetail.TCM_PHZ_Guide_Desc}</td>
						</tr>
					</table>
				</section>
				<!-- 选填项 end -->
				<section class="tab-conbox-item">
					<table class="table-normal table-fixed">
						<tr>
							<th rowspan="7">现存主要健康问题</th>
							<td class="align-right bgfff">脑血管疾病</td>
							<td colspan="10">${pojo.phHealthexamdetail.cerebralVesseltr}</td>
						</tr>
						<tr>
							<td class="align-right bgfff">肾脏疾病</td>
							<td colspan="10">${pojo.phHealthexamdetail.kidneyStr}</td>
						</tr>
						<tr>
							<td class="align-right bgfff">心脏疾病</td>
							<td colspan="10">${pojo.phHealthexamdetail.heartStr}</td>
						</tr>
						<tr>
							<td class="align-right bgfff">血管疾病</td>
							<td colspan="10">${pojo.phHealthexamdetail.bloodPipeStr}</td>
						</tr>
						<tr>
							<td class="align-right bgfff">眼部疾病</td>
							<td colspan="10">${pojo.phHealthexamdetail.eyePartStr}</td>
						</tr>
						<tr>
							<td class="align-right bgfff">神经系统疾病</td>
							<td colspan="10">${pojo.phHealthexamdetail.nervousSystemStr}<c:if
									test="${pojo.phHealthexamdetail.nervousSystem == '2' && not empty pojo.phHealthexamdetail.nervousSystem_Desc}">(${pojo.phHealthexamdetail.nervousSystem_Desc})</c:if></td>
						</tr>
						<tr>
							<td class="align-right bgfff">其它系统疾病</td>
							<td colspan="10">${pojo.phHealthexamdetail.otherSystemStr}<c:if
									test="${pojo.phHealthexamdetail.otherSystem == '2' && not empty pojo.phHealthexamdetail.otherSystem_Desc}">(${pojo.phHealthexamdetail.otherSystem_Desc})</c:if></td>
						</tr>
						<tr>
							<th rowspan="${fn:length(pojo.phHealthexamdetailinpatients)+fn:length(pojo.phHealthexamdetailfamilybeds)+2}">住院治疗情况</th>
							<td class="align-center" rowspan="${fn:length(pojo.phHealthexamdetailinpatients)+1}">住院史</td>
							<td class="align-center" colspan="2">入院日期</td>
							<td class="align-center" colspan="2">出院日期</td>
							<td class="align-center" colspan="2">医疗机构名称</td>
							<td class="align-center" colspan="1">病案号</td>
							<td class="align-center" colspan="3">住院原因</td>
						</tr>
						<c:forEach var="In" items="${pojo.phHealthexamdetailinpatients}">
							<tr class="align-center">
								<td colspan="2"><fmt:formatDate value="${In.startDate}" />&nbsp;</td>
								<td colspan="2"><fmt:formatDate value="${In.endTime }" /></td>
								<td colspan="2">${In.institution}</td>
								<td colspan="1">${In.patientID}</td>
								<td colspan="3">${In.resson}</td>
							</tr>
						</c:forEach>
						<tr class="align-center">
							<td rowspan="${fn:length(pojo.phHealthexamdetailfamilybeds)+1}">家庭病床史</td>
							<td colspan="2">建床日期</td>
							<td colspan="2">撤床日期</td>
							<td colspan="2">医疗机构名称</td>
							<td colspan="1">病案号</td>
							<td colspan="3">住院原因</td>
						</tr>
						<c:forEach var="his" items="${pojo.phHealthexamdetailfamilybeds}">
							<tr class="align-center">
								<td colspan="2"><fmt:formatDate value="${his.startDate}" />&nbsp;</td>
								<td colspan="2"><fmt:formatDate value="${his.endTime }" /></td>
								<td colspan="2">${his.institution}</td>
								<td colspan="1">${his.patientID}</td>
								<td colspan="3">${his.resson}</td>
							</tr>
						</c:forEach>
						<tr>
							<th rowspan="${fn:length(pojo.phHealthexamdetailmedicines)+1}">主要用药情况</th>
							<td class="align-center" colspan="1">药物名称</td>
							<td class="align-center" colspan="1">用法</td>
							<td class="align-center" colspan="1">用量</td>
							<td class="align-center" colspan="1">单位</td>
							<td class="align-center" colspan="1">频度</td>
							<td class="align-center" colspan="1">用药时间</td>
							<td class="align-center" colspan="2">服药依从性</td>
							<td class="align-center" colspan="3">备注</td>
						</tr>
						<c:forEach var="med" items="${pojo.phHealthexamdetailmedicines}">
							<tr class="align-center">
								<td colspan="1">${med.drugName}&nbsp;</td>
								<td colspan="1">${med.drugUsage}</td>
								<td colspan="1">${med.drugDosage}</td>
								<td colspan="1">${med.drugUnit}</td>
								<td colspan="1">${med.drugFreq}</td>
								<td colspan="1">${med.drugUseTime}</td>
								<td colspan="2">${med.drugComplianceDes}</td>
								<td colspan="3">${med.remarks}</td>
							</tr>
						</c:forEach>
						<tr>
							<th rowspan="${fn:length(pojo.phHealthexamdetailnonimmunes)+1}">非免疫规划预防接种史</th>
							<td class="align-center" colspan="3">疫苗名称</td>
							<td class="align-center" colspan="3">接种日期</td>
							<td class="align-center" colspan="5">接种机构</td>
						</tr>
						<c:forEach var="vac" items="${pojo.phHealthexamdetailnonimmunes}">
							<tr class="align-center">
								<td colspan="3">${vac.vaccinateName}&nbsp;</td>
								<td colspan="3"><fmt:formatDate value="${vac.vaccinateDate}" /></td>
								<td colspan="5">${vac.institution}</td>
							</tr>
						</c:forEach>
	
	
						<tr>
							<th
								rowspan="${pojo.phHealthexamdetail.healthEvaluate == '2' ? 4 : 1}">健康评价</th>
							<td colspan="11">${pojo.phHealthexamdetail.healthEvaluateStr}</td>
						</tr>
	
						<c:if test="${pojo.phHealthexamdetail.healthEvaluate == '2'}">
	
	<%-- 						<c:forEach items="${detail.HealthEvaluate_Desc}" var="arr" --%>
	<%-- 							varStatus="sta"> --%>
	<!-- 							<tr> -->
	<%-- 								<td class="align-right" colspan="2">异常${sta.index+1}</td> --%>
	<%-- 								<td colspan="9">${arr}</td> --%>
	<!-- 							</tr> -->
	<%-- 						</c:forEach> --%>
								<tr>
									<td class="align-right">异常1</td>
									<td colspan="5">${pojo.phHealthexamdetail.healthEvaluate_Descs[0]}</td>
									<td class="align-right">异常2</td>
									<td colspan="5">${pojo.phHealthexamdetail.healthEvaluate_Descs[1]}</td>
								</tr>
								<tr>
									<td class="align-right">异常3</td>
									<td colspan="5">${pojo.phHealthexamdetail.healthEvaluate_Descs[2]}</td>
									<td class="align-right">异常4</td>
									<td colspan="5">${pojo.phHealthexamdetail.healthEvaluate_Descs[3]}</td>
								</tr>
								<tr>
									<td class="align-right">异常5</td>
									<td colspan="11">${pojo.phHealthexamdetail.healthEvaluate_Descs[4]}</td>
	<!-- 								<td class="align-right">异常6</td> -->
	<%-- 								<td colspan="5">${pojo.phHealthexamdetail.healthEvaluate_Descs[5]}</td> --%>
								</tr>
						</c:if>
						<tr>
							<th>健康指导</th>
							<td colspan="11">${pojo.phHealthexamdetail.healthGuideStr}</td>
						</tr>
						<tr>
							<th rowspan="4">危险因素控制</th>
							<td colspan="11">${pojo.phHealthexamdetail.riskFactorStr}&nbsp;</td>
						</tr>
						<tr>
							<td colspan="11">减体重(目标：${pojo.phHealthexamdetail.riskFactor_Target} <c:if test="${pojo.phHealthexamdetail.riskFactor_Target != null}">kg</c:if>)</td>
						</tr>
						<tr>
							<td colspan="11">建议疫苗接种：${pojo.phHealthexamdetail.riskFactor_Vaccine}</td>
						</tr>
						<tr>
							<td colspan="11">其他：${pojo.phHealthexamdetail.riskFactor_Other}</td>
						</tr>
					</table>
				</section>
				<!-- 其他 end -->
			</div>
		</div>
	</div>
</body>
</html>
