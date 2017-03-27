<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http：//www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>会员基本信息与健康档案</title>
<script type="text/javascript"src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
<link rel="stylesheet"href="${pageContext.request.contextPath}/css/relation.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/member.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/zTree_v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/editMember.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/tree.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/plugins/zTree_v3/js/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/plugins/zTree_v3/js/jquery.ztree.excheck-3.5.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tree.js"></script>
<script type="text/javascript"src="${pageContext.request.contextPath }/js/calendar.js"></script>


<style type="text/css">
#treeDemo a:hover
{
	text-decoration: none;
}

#group-list .group-name {
	text-align: left;
    padding-left: 1em;
}
</style>


<script type="text/javascript">
var setting = {
		check: {
			enable: true,
			chkStyle: "checkbox",
			chkboxType: {Y: '', N: ''}
		},
		data: {
			simpleData: {
				enable: true,
			}
		},
		view: {
			dblClickExpand: false,
			showIcon: false,
			selectedMulti: false
		},
		callback: {
			beforeClick: beforeClick,
			onCheck: onCheck
		}
	};
function NoToChinese(num) {
		if (!/^\d*(\.\d*)?$/.test(num))
		{
			alert("Number is wrong!");
			return "Number is wrong!"; 
		} 
		//var AA = new Array("零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖");
		//var BB = new Array("", "拾", "佰", "仟", "萬", "億", "点", "");
		var AA = new Array("零", "一", "二", "三", "四", "五", "六", "七", "八", "九");
		var BB = new Array("", "十", "百", "千", "万", "亿", "点", "");
		var a = ("" + num).replace(/(^0*)/g, "").split("."), k = 0, re = "";
		for (var i = a[0].length - 1; i >= 0; i--) {
			switch (k) {
				case 0: re = BB[7] + re; break;
				case 4: if (!new RegExp("0{4}\\d{" + (a[0].length - i - 1) + "}$").test(a[0]))
				re = BB[4] + re; break;
				case 8: re = BB[5] + re; BB[7] = BB[5]; k = 0; break;
			}
			if (k % 4 == 2 && a[0].charAt(i + 2) != 0 && a[0].charAt(i + 1) == 0) re = AA[0] + re;
			if (a[0].charAt(i) != 0) re = AA[a[0].charAt(i)] + BB[k % 4] + re; k++;
		}
		
		if (a.length > 1) //加上小数部分(如果有小数部分)
		{
			re += BB[6];
			for (var i = 0; i < a[1].length; i++) re += AA[a[1].charAt(i)];
		}
		return re;
	}
$(function(){
		// 加载Tree数据 不可编辑
		getData(true);
});
</script>

</head>
<body>
<div id="content">
	<div class="title-normal">
		<span>基本信息与健康档案</span>	
		<!--  
		<button type="button" id="return" class="go-back">返回</button>
		-->
	</div>
	<div>
			<table cellpadding="0" cellspacing="0" class="table-border" align="center"width="100%"  id="tabel_content">
				<tr >
					<th colspan="6" class="l"><b>会员基本信息</b></th>
				</tr>
				<tr>
					<td class="v" width="12%">会员编号：</td>
					<td class="u" >${omem.logname }</td>
					<td class="v" width="12%">健康档案编号：</td>
					<td class="u" width="20%">${omem.relation.uniqueId }</td>
					
					<td class="v" width="15%">出生日期：</td>
					<td class="u" width="22%"><fmt:formatDate pattern="yyyy-MM-dd" value="${omem.birthdate}"/></td>
				</tr>
				<tr>
					<td class="v">会员姓名：</td>
					<td class="u">${omem.memname}</td>
					<td class="v">籍贯：</td>
					<td class="u">${omem.nativeaddr }</td>
					<td class="v">婚姻状况：</td>
					<td class="u">
					<%-- ${ omem.marrystatus eq'Y'?'已婚':'未婚'} --%>
						<c:choose>
							<c:when test="${omem.marrystatus eq '1'}">未婚</c:when>
							<c:when test="${omem.marrystatus eq '2'}">已婚</c:when>
							<c:when test="${omem.marrystatus eq '3'}">初婚</c:when>
							<c:when test="${omem.marrystatus eq '4'}">再婚</c:when>
							<c:when test="${omem.marrystatus eq '5'}">复婚</c:when>
							<c:when test="${omem.marrystatus eq '6'}">丧偶</c:when>
							<c:when test="${omem.marrystatus eq '7'}">离异</c:when>
							<c:when test="${omem.marrystatus eq '8'}">未说明的婚姻状况</c:when>
							<c:otherwise></c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr>
					<td class="v">手机：</td>
					<td class="u">${omem.tel }</td>
					<td class="v">性别：</td>
					<td class="u">
						<c:if test="${omem.gender eq '1'}">男</c:if>
						<c:if test="${omem.gender eq '2'}">女</c:if>
						<c:if test="${omem.gender eq '3'}">未知</c:if>
					</td>
					<td class="v">建档医生：</td>
					<td class="u">${omem.docname }</td>
				</tr>
				
				<tr>
					<td class="v">证件类型：</td>
					<td class="u">
					<c:choose>
					<c:when test="${omem.relation.certificateType eq 2}">护照(外籍人士)</c:when>
					<c:when test="${omem.relation.certificateType eq 3}">军官证</c:when>
					<c:otherwise>身份证</c:otherwise>
					</c:choose>
					</td>
					<td class="v">邮箱：</td>
					<td class="u">${omem.email }</td>
					<td class="v">会员类型：</td>
					<td class="u">${omem.memberType.memname}</td>
				</tr>
				<tr>
					<td class="v">身份证号：</td>
					<td class="u">${omem.idcard }</td>
					<td class="v">地址：</td>
					<td class="u">${omem.address }</td>
					<td class="v">类型说明：</td>
					<td class="u">${omem.memberType.memdesc }</td>
				</tr>
				
				<tr>
					<td class="v">教育程度：</td>
					<td class="u">
						<%-- <c:if test="${omem.educationstatus eq '0'}">未知</c:if>
						<c:if test="${omem.educationstatus eq '1'}">高中及以下</c:if>
						<c:if test="${omem.educationstatus eq '2'}">大专</c:if>
						<c:if test="${omem.educationstatus eq '3'}">本科</c:if>
						<c:if test="${omem.educationstatus eq '4'}">硕士</c:if>
						<c:if test="${omem.educationstatus eq '5'}">博士</c:if> --%>
						<c:choose>
							<c:when test="${omem.educationstatus eq '1'}">研究生及以上</c:when>
							<c:when test="${omem.educationstatus eq '2'}">大学本科</c:when>
							<c:when test="${omem.educationstatus eq '3'}">大学专科和专科学校</c:when>
							<c:when test="${omem.educationstatus eq '4'}">中等专业学校</c:when>
							<c:when test="${omem.educationstatus eq '5'}">技工学校</c:when>
							<c:when test="${omem.educationstatus eq '6'}">高中</c:when>
							<c:when test="${omem.educationstatus eq '7'}">初中</c:when>
							<c:when test="${omem.educationstatus eq '8'}">小学</c:when>
							<c:when test="${omem.educationstatus eq '9'}">文盲或半文盲</c:when>
							<c:when test="${omem.educationstatus eq '10'}">学历不详</c:when>
							<c:when test="${omem.educationstatus eq '11'}">无</c:when>
							<c:otherwise></c:otherwise>
						</c:choose>
					</td>
					<td class="v">职业：</td>
					<td class="u">
						<%-- ${occupation } --%>
						<c:choose>
							<c:when test="${omem.occupation eq '1'}">农林牧渔水利业生产人员</c:when>
							<c:when test="${omem.occupation eq '2'}">生产运输设备操作人员及有关人员</c:when>
							<c:when test="${omem.occupation eq '3'}">专业技术人员</c:when>
							<c:when test="${omem.occupation eq '4'}">办事人员和有关人员</c:when>
							<c:when test="${omem.occupation eq '5'}">商业、服务业人员</c:when>
							<c:when test="${omem.occupation eq '6'}">国家机关、党群组织、企事业单位负责人</c:when>
							<c:when test="${omem.occupation eq '7'}">在校学生</c:when>
							<c:when test="${omem.occupation eq '8'}">家务</c:when>
							<c:when test="${omem.occupation eq '9'}">待业</c:when>
							<c:when test="${omem.occupation eq '10'}">离退休人员</c:when>
							<c:when test="${omem.occupation eq '11'}">婴幼、学龄前儿童</c:when>
							<c:when test="${omem.occupation eq '12'}">军人</c:when>
							<c:when test="${omem.occupation eq '13'}">其他劳动者</c:when>
							<c:otherwise>${omem.occupation}</c:otherwise>
						</c:choose>
					</td>
					<td class="v">行政区域：</td>
					<td class="u">${omem.relation.neighborhoodCommittee}</td>
				</tr>
				<tr>
					<td class="v">医疗费用支付方式：</td>
					<td class="u">
						<c:if test="${omem.relation.payType eq 1 }">全自费</c:if>
						<c:if test="${omem.relation.payType eq 2 }">全公费</c:if>
						<c:if test="${omem.relation.payType eq 3 }">城镇职工基本医疗保险</c:if>
						<c:if test="${omem.relation.payType eq 4 }">城镇居民基本医疗保险</c:if>
						<c:if test="${omem.relation.payType eq 5 }">新型农村合作医疗</c:if>
						<c:if test="${omem.relation.payType eq 6 }">社会医疗保险</c:if>
						<c:if test="${omem.relation.payType eq 7 }">商业医疗保险</c:if>
						<c:if test="${omem.relation.payType eq 8 }">贫困救助</c:if>
						<c:if test="${omem.relation.payType eq 99 }">其他</c:if>
					</td>
					<td class="v">医疗保险号：</td>
					<td class="u">${omem.relation.medicalAccount}</td>
					<td class="v">新农合号：</td>
					<td class="u">${omem.relation.agroAccount}</td>
				</tr>
				<tr>
					<td class="v">其它医疗费用支付方式：</td>
					<td class="u">
						<c:if test="${omem.relation.payType eq 99 }">${omem.relation.otherPay}</c:if>
					</td>
					<td class="v">家庭档案编号：</td>
					<td class="u">${omem.relation.familyCode}</td>
					<td class="v">居住状况：</td>
					<td class="u">
						<c:if test="${omem.relation.liveStatus eq 1}">本地户籍常住</c:if>
						<c:if test="${omem.relation.liveStatus eq 2}">本地户籍不常住</c:if>
						<c:if test="${omem.relation.liveStatus eq 3}">外地户籍常住</c:if>
						<c:if test="${omem.relation.liveStatus eq 4}">不详</c:if>
					</td>
				</tr>
				<tr>
					<td class="v">民族：</td>
					<td class="u">${omem.relation.nation}</td>
					<td class="v">与户主关系：</td>
					<td class="u">
						<c:if test="${omem.relation.relation eq 1 }">户主</c:if>
						<c:if test="${omem.relation.relation eq 2 }">配偶</c:if>
						<c:if test="${omem.relation.relation eq 3 }">子女</c:if>
						<c:if test="${omem.relation.relation eq 4 }">(外)孙子女</c:if>
						<c:if test="${omem.relation.relation eq 5 }">父母</c:if>
						<c:if test="${omem.relation.relation eq 6 }">(外)祖父母</c:if>
						<c:if test="${omem.relation.relation eq 7 }">兄弟姐妹</c:if>
						<c:if test="${omem.relation.relation eq 8 }">儿媳</c:if>
						<c:if test="${omem.relation.relation eq 9 }">女婿</c:if>
						<c:if test="${omem.relation.relation eq 10}">孙子女</c:if>
						<c:if test="${omem.relation.relation eq 11 }">侄子女</c:if>
						<c:if test="${omem.relation.relation eq 12 }">曾孙子女</c:if>
						<c:if test="${omem.relation.relation eq 13 }">祖父母</c:if>
						<c:if test="${omem.relation.relation eq 99 }">其他</c:if>
					</td>
					<td class="v">怀孕情况：</td>
					<td class="u">
						<c:if test="${omem.relation.fetationStatus eq 0 }">未孕</c:if>
						<c:if test="${omem.relation.fetationStatus eq 1 }">已孕未生产</c:if>
						<c:if test="${omem.relation.fetationStatus eq 2 }">已生产(随访期内)</c:if>
						<c:if test="${omem.relation.fetationStatus eq 3 }">已生产(随访期外)</c:if>
					</td>
				</tr>
				<tr>
					<td class="v">活力指数：</td>
					<td class="u"><c:if test="omem.vigorIndex != null">${omem.vigorIndex.vigorindex }</c:if></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td colspan="6">&nbsp;</td>
				</tr>
				<tr >
					<th colspan="6" class="l"><b>紧急联系人</b></th>
				</tr>

				<c:forEach items="${omem.linkmanList }" var="item" varStatus="statu">
				  <tr>
						<td colspan="6" class="o"><b>紧急联系人
						<c:choose>
						<c:when test="${statu.index+1 eq 1}">一</c:when>
						<c:when test="${statu.index+1 eq 2}">二</c:when>
						<c:when test="${statu.index+1 eq 3}">三</c:when>
						<c:when test="${statu.index+1 eq 4}">四</c:when>
						<c:when test="${statu.index+1 eq 5}">五</c:when>
						<c:when test="${statu.index+1 eq 6}">六</c:when>
						<c:when test="${statu.index+1 eq 7}">七</c:when>
						<c:when test="${statu.index+1 eq 8}">八</c:when>
						<c:when test="${statu.index+1 eq 9}">九</c:when>
						<c:when test="${statu.index+1 eq 10}">十</c:when>
						<c:otherwise>${statu.index+1}</c:otherwise>
						</c:choose>
						</b></td>
					</tr>
					<tr>
						<td class="v">联系人姓名：</td>
						<td class="u">${item.contactname }</td>
						<td class="v">关系：</td>
						<td class="u">${item.relation }</td>
						<td class="v">联系人手机号：</td>
						<td class="u">${item.contactmobphone }</td>
					</tr>
					<tr>
						<td class="v">是否接收消息：</td>
						<td class="u">${item.messagetag eq 'Y'?'是':'否'}</td>
						<td></td>
						<td></td>
						<td class="v">是否接收回复：</td>
						<td class="u">${item.messagetag eq 'Y'?'是':'否'}</td>
					</tr>
				
				</c:forEach>
				<tr>
					<td colspan="6">&nbsp;</td>
				</tr>
				<tr  >
					<th colspan="6" class="l"><b>会员疾病史</b></th>
				</tr>
				<c:forEach items="${omem.diseasesHistoryList }" var="item" varStatus="statu">
				    <tr>
						<td class="v">疾病名称：</td>
						<td class="u">${item.diseasename }</td>
						<td class="v">发生：</td>
						<td class="u">${item.protag eq 'N'?'过去':'现在'}</td>
						<td class="v">确诊时间：</td>
						<td class="u"><fmt:formatDate value="${item.diagtime }" type="date" pattern="yyyy-MM-dd"/></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="6">&nbsp;</td>
				</tr>
				<tr >
					<th colspan="6" class="l"><b>体格检测与生活习惯</b></th>
				</tr>
				<tr>
					<td colspan="6" class="o"><b>体格检测</b></td>
				</tr>
				<tr>
					<td class="v">档案类别：</td>
					<td class="u">
						<c:if test="${omem.relation.fileType eq 1}">城镇</c:if>
						<c:if test="${omem.relation.fileType eq 2}">农村</c:if>
					</td>
					<td class="v">档案状态：</td>
					<td class="u">
						<c:if test="${omem.relation.fileStatus eq 1}">活动</c:if>
						<c:if test="${omem.relation.fileStatus eq 2}">非活动</c:if>
					</td>
					<td class="v">档案非活动状态原因：</td>
					<td class="u">
						<c:if test="${omem.relation.fileStatusDesc eq 1 }">死亡</c:if>
						<c:if test="${omem.relation.fileStatusDesc eq 2 }">失踪</c:if>
						<c:if test="${omem.relation.fileStatusDesc eq 3 }">迁出</c:if>
						<c:if test="${omem.relation.fileStatusDesc eq 4 }">其他</c:if>
						<c:if test="${omem.relation.fileStatusDesc eq 5 }">长期外出</c:if>
					</td>
				</tr>
				<tr>
					<td class="v">过敏史：</td>
					<td class="u">${omem.physical.allergichisname }</td>
					<td class="v">血型：</td>
					<td class="u">${omem.physical.bloodtype}</td>
					<td class="v">身高：</td>
					<td class="u"><c:if test="${omem.physical.height gt 0 }">${omem.physical.height }</c:if>cm</td>
				</tr>
				<tr>
					<td class="v">空腹血糖：</td>
					<td class="u"><c:if test="${omem.physical.fastingglucose gt 0 }">${omem.physical.fastingglucose }</c:if>mmol/L</td>
					<td class="v">体重：</td>
					<td class="u"><c:if test="${omem.physical.weight gt 0}">${omem.physical.weight}</c:if>KG</td>
					<td class="v">腰围：</td>
					<td class="u"><c:if test="${omem.physical.waist gt 0 }">${omem.physical.waist }</c:if>cm</td>
				</tr>
				<tr>	
					<td class="v">甘油三酯：</td>
					<td class="u"><c:if test="${omem.physical.triglyceride gt 0 }">${omem.physical.triglyceride }</c:if>mmol/L</td>
					<td class="v">脉搏：</td>
					<td class="u"><c:if test="${omem.physical.pulse gt 0 }">${omem.physical.pulse }</c:if>次/分</td>
					<td class="v">收缩压：</td>
					<td class="u"><c:if test="${omem.physical.bloodh gt 0 }">${omem.physical.bloodh }</c:if>mmHg</td>
				</tr>
				<tr>
					<td class="v">总胆固醇：</td>
					<td class="u"><c:if test="${omem.physical.totalcholesterol gt 0 }">${omem.physical. }</c:if>mmol/L</td>
					<td class="v">臀围：</td>
					<td class="u"><c:if test="${omem.physical.hip gt 0 }">${omem.physical.hip }</c:if></td>
					<td class="v">舒张压：</td>
					<td class="u"><c:if test="${omem.physical.bloodl gt 0}">${omem.physical.bloodl }</c:if>mmHg</td>
				</tr>
				<tr>
					<td class="v">高密度脂蛋白：</td>
					<td class="u"><c:if test="${omem.physical.densitylipop gt 0 }">${omem.physical.densitylipop }</c:if>mmol/L</td>
					<td class="v">心率：</td>
					<td class="u"><c:if test="${omem.physical.heartrate gt 0}">${omem.physical.heartrate }</c:if>次/分</td>
					<td class="v">尿酸：</td>
					<td class="u"><c:if test="${omem.physical.uricacid gt 0}">${omem.physical.uricacid }</c:if>umol/L</td>
				</tr>
				<tr>
					<td class="v">低密度脂蛋白：</td>
					<td class="u"><c:if test="${omem.physical.ldlip gt 0}">${omem.physical.ldlip }</c:if>mmol/L</td>
					<td class="v"></td>
					<td class="u"></td>
					<td class="v"></td>
					<td class="u"></td>
				</tr>
				<tr>
					<td colspan="6">&nbsp;</td>
				</tr>
				<tr>
					<td colspan="6" class="o"><b>生活习惯</b></td>
				</tr>
				<tr>
					<td class="v">是否抽烟：</td>
					<td class="u">${ omem.habit.smoking eq 'Y'?'是':'否'}</td>
					<td class="v">主食：</td>
					<td class="u">${ omem.habit.staplefood}</td>
					<td class="v">不喜欢的食物：</td>
					<td class="u">${omem.habit.dontfood }</td>
				</tr>

				<tr>
					<td class="v">是否喝酒：</td>
					<td class="u">${ omem.habit.dodrink eq 'Y'?'是':'否'}</td>
					<td class="v">睡眠质量：</td>
					<td class="u">${ omem.habit.sleepcond eq 'Y'?'好':'差'}</td>
					<td class="v">喜欢运动：</td>
					<td class="u">${omem.habit.likesports }</td>
				</tr>
				<tr>
					<td class="v">运动时长：</td>
					<td class="u">${omem.habit.movelong }小时</td>
					<td class="v">每周：</td>
					<td class="u">${omem.habit.weeknumtimes == null ? 0 : omem.habit.weeknumtimes}次</td>
					<td class="v">时间段：</td>
						<td class="u">	
							<c:if test="${omem.habit.timeseg eq '0'}">5:30-7:30</c:if>
							<c:if test="${omem.habit.timeseg eq '1'}">7:30-9:30</c:if>
							<c:if test="${omem.habit.timeseg eq '2'}">9:30-11:30</c:if>
							<c:if test="${omem.habit.timeseg eq '3'}">11:30-13:30</c:if>
							<c:if test="${omem.habit.timeseg eq '4'}">13:30-15:30</c:if>
							<c:if test="${omem.habit.timeseg eq '5'}">15:30-17:30</c:if>
							<c:if test="${omem.habit.timeseg eq '6'}">17:30-19:30</c:if>
							<c:if test="${omem.habit.timeseg eq '7'}">19:30-21:30</c:if>
							<c:if test="${omem.habit.timeseg eq '8'}">21:30-23:30</c:if>
						</td>
				</tr>
				<tr>
					<td colspan="6">&nbsp;</td>
				</tr>
				<tr >
					<th colspan="6" class="l"><b>会员家族病史</b></th>
				</tr>
				<c:forEach items="${omem.familyHistoryList }" var="item">
				<tr>
					<td class="v">关系</td>
					<td class="u">
						<input type="text" class="vp1"  value="${item.relation }" style="border:1px solid #fff;font-size:14px;"/>
					</td>
					<td class="v">所患疾病</td>
					<td colspan="3" class="u">
						<c:if test="${item.hypertension eq 'Y' }">高血压&nbsp;</c:if>
						<c:if test="${item.diabmell eq 'Y' }">糖尿病&nbsp;</c:if>
						<c:if test="${item.coronaryheart eq 'Y' }">冠心病&nbsp;</c:if>
						<c:if test="${item.cancer eq 'Y' }">癌症&nbsp;</c:if>
						<c:if test="${item.migraine eq 'Y' }">偏头症&nbsp;</c:if>
						<c:if test="${item.lungdisease eq 'Y' }">慢性阻塞性肺疾病&nbsp;</c:if>
						<c:if test="${item.depression eq 'Y' }">抑郁症&nbsp;</c:if>
						<c:if test="${item.hepatitis eq 'Y' }">肝炎&nbsp;</c:if>
						<c:if test="${item.stroke eq 'Y' }">中风&nbsp;</c:if>
						<c:if test="${item.hipjoint eq 'Y' }">髋关节骨折&nbsp;</c:if>
						<c:if test="${item.seniledementia eq 'Y' }">老年痴呆症&nbsp;</c:if>
						<c:if test="${item.gout eq 'Y' }">痛风&nbsp;</c:if>
						<c:if test="${item.tag eq 'Y' }">其它疾病：${item.diseasename }</c:if>
					</td>
				</tr>
				</c:forEach>
				<tr>
					<th class='l' colspan="6"><b>会员分组</b></th>
				</tr>
				
				<c:forEach items="${groupNames}" var="item" varStatus="stu">
				<tr id="group-list">
					<td class="v">分组${stu.index+1}</td>
					<td class="u group-name" colspan="5"^>
						${item }
					</td>
				</tr>
				</c:forEach>
			</table>
			<div style="height:15px;width:100%;"></div>
			<!-- <button type="button" onclick="history.go(-1)" class="btn-normal">返回</button> -->
	</div>
	<input id="memGrpid" type="hidden" value="${memGrpid}" />
</div>
</body>
</html>