<%@ page contentType="text/html; charset=utf-8" language="java" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=9">
    <title>重新注册</title>
    <link rel="stylesheet" href="<%=path %>/plugins/bootstrap/css/bootstrap.min.css">
   	<link rel="stylesheet" href="<%=path %>/js/jquery-ui/themes/overcast/jquery-ui.min.css">
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/css/memberInfo.css">

    <script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
   	<script type="text/javascript" src="<%=path %>/js/jquery-ui/jquery-ui.js"></script>
   	<script type="text/javascript" src="<%=path %>/js/dataPacker.js"></script>
	<script type="text/javascript" src="<%=path %>/js/registInfo.js"></script>
</head>
<body>
<div class="content">
    <div class="content-title">会员导入信息<font color="red"><b>${msg }</b></font></div>
    <form id="registInfo_form" name="myForm" action="<%=path %>/data/regist" method="post" enctype="multipart/form-data">
	    <input type="hidden" name="memberGUID" value="${member.memberGUID }"/>
	    <input type="hidden" name="memberid" value="${member.memberid }"/>
	    <input type="hidden" name="memid" value="${member.memid }"/>
	    <input type="hidden" name="orgid" value="${member.orgid }">
	    <input type="hidden" name="docid" value="${member.docid }">
	     <input type="hidden" name="docname" value="${member.docname }">
	     <input name="source" value="${member.source }" type="hidden"/>
	    <div class="table-box">
	        <table class="table table-bordered table-fixed">
	            <tbody>
	                <tr>
	                    <th colspan="12">会员基本信息</th>
	                </tr>
	                <tr>
	                    <td colspan="3">姓名：</td>
	                    <td colspan="3">
	                        <input maxlength="20" type="text" name="memname" value="${member.memname }" onchange="checkName(this)"/>
	                        <span class="red"></span>
	                    </td>
	                    <td colspan="3">身份证号：</td>
	                    <td colspan="3">
	                        <input id="idcard" type="text" name="idcard" value="${member.idcard }" onkeyup="this.value = this.value.toUpperCase();" onchange="isIDCard(this)"/>
	                        <span class="red"></span>
	                    </td>
	                </tr>
	                <tr>
	                    <td colspan="3">性别：</td>
	                    <td colspan="3">
	                        <label class="radio-inline check-gender">
							  <input type="radio" name="sexual" value="1" <c:if test="${member.gender eq '1'}">checked</c:if>/>男
							</label>
							<label class="radio-inline check-gender">
							  <input type="radio" name="sexual" value="2" <c:if test="${member.gender eq '2'}">checked</c:if>/>女
							</label>
							<label class="radio-inline mr-align check-gender">
							  <input type="radio" name="sexual" value="3" <c:if test="${member.gender ne '1' and member.gender ne '2'}">checked</c:if>/>未知
							</label>
							<input type="hidden" name="gender" value="${member.gender}" />
	                    </td>
	                    <td colspan="3">出生日期：</td>
	                    <td colspan="3">
	                        <input class="info-date" id="startDate" type="text" name="birthDate" value='<fmt:formatDate value="${member.birthdate }" pattern="yyyy-MM-dd"/>' readonly />
	                        <input type="hidden" name="birthdate" value="<fmt:formatDate value="${member.birthdate }" pattern="yyyy-MM-dd"/>" />
	                    </td>
	                </tr>
	                <tr>
	                    <td colspan="3">手机号：</td>
	                    <td colspan="3">
	                        <input maxlength='11' type="text" name="tel" value="${member.tel }" onblur="isPhone(this);" />
	                        <span class="red"></span>
	                    </td>
	                    <td colspan="3">籍贯：</td>
	                    <td colspan="3">
	                        <input maxlength='20' type="text" name="" value="${member.nativeaddr }"/>
	                    </td>
	                </tr>
	                <tr>
	                    <td colspan="3">邮箱：</td>
	                    <td colspan="3">
	                        <input maxlength='30' type="text" name="email" value="${member.email }" onchange="isEmail(this);"/>
	                        <span></span>
	                    </td>
	                    <td colspan="3">婚姻状况：</td>
	                    <td colspan="3">
	                         <select class="select-normal" name="marrystatus">
								   <c:forEach items="${marryStatus }" var="item">
									   <option value="${item.val}" <c:if test="${item.val eq member.marrystatus }"> selected </c:if> >${item.descr }</option>
								   </c:forEach>
						     </select>		
	                    </td>
	                </tr>
	                <tr>
	                    <td colspan="3">教育状况：</td>
	                    <td colspan="3">
	                        <select class="select-normal" name="educationstatus">
								 <c:forEach items="${educationStatus }" var="item">
									 <option value="${item.value }" <c:if test="${item.value eq member.educationstatus }"> selected </c:if>>${item.descr }</option>
								 </c:forEach>
						    </select>
	                        </td>
	                        <td colspan="3">职业：</td>
	                        <td colspan="3">
	                        <select name="occupation" class="occupation">
						        <c:forEach items="${accupations }" var="item">
						            <option value="${item.value }" <c:if test="${item.value eq member.occupation }"> selected </c:if>>${item.desc }</option>
						        </c:forEach>
						    </select>           
	                    </td>
	                </tr>
	                <tr>
	                    <td colspan="3">地址：</td>
	                    <td colspan="3">
	                        <input maxlength='200' type="text" name="address" value="${member.address }" style="width: 245px;"/>
	                    </td>
	                    <td colspan="3">紧急联系人姓名：</td>
	                    <td colspan="3">
	                        <input maxlength="20" type="text" name="linkmanList[0].contactname" value="${member.linkmanList[0].contactname}"/>
	                        <span class="red"></span>
	                    </td>
	                </tr>
	                <tr>
	                    <td colspan="3">紧急联系人手机号：</td>
	                    <td colspan="3">
	                        <input maxlength='11' type="text" name="linkmanList[0].contactmobphone" value="${member.linkmanList[0].contactmobphone}" onblur="isPhone(this)"/>
	                    </td>
	                    <td colspan="3">紧急联系人与本人关系：</td>
	                    <td colspan="3">
	                        <input type="text" name="linkmanList[0].relation" value="${member.linkmanList[0].relation}"/>
	                    </td>
	                </tr>
	                <tr>
	                    <th colspan="12">会员疾病史</th>
	                </tr>
	                <tr>
	                    <td colspan="12">
	                        <c:forEach var="dict" items="${diseases}">
	                        <c:if test="${dict.disease_id ne 10 }">
								<label class="checkbox-inline">
									<input id="dict_${dict.disease_id}" type="checkbox" value="${dict.disease_id}" 
										<c:forEach items="${member.diseasesHistoryList }" var="item" varStatus="statu">
									    <c:if test="${item.diseaseid eq dict.disease_id}">checked</c:if>
									    </c:forEach> />${dict.disease_name}&nbsp;&nbsp;
									<input id="hidDict_${dict.disease_id}" type="hidden" value="${dict.disease_name}" />
								</label>
							</c:if>
							</c:forEach>
	                    </td>
	                </tr>
	                <tr>
	                    <th colspan="12">体格检测与生活习惯</th>
	                </tr>
	                <tr>
	                    <td colspan="2">血型：</td>
	                    <td colspan="4"><input type="text" name="physical.bloodtype" value="${member.physical.bloodtype }"/></td>
	                    <td colspan="2">过敏史：</td>
	                    <td colspan="4">
	                        <label class="radio-inline h27">
	                              <input id="allergicHisN" type="radio" value="N" name="physical.allergichis" <c:if test="${empty member.physical.allergichis or member.physical.allergichis eq 'N'}">checked</c:if>/>无
	                        </label>
	                        <label class="radio-inline h27">
	                              <input id="allergicHisY" type="radio" value="Y" name="physical.allergichis" <c:if test="${member.physical.allergichis eq 'Y'}">checked</c:if> />有
	                        </label>
	                    </td>
	                </tr>
	                <tr>
	                    <td colspan="2">身高：</td>
	                    <td colspan="4">
	                        <input name="physical.height" id="mem2.height" type="text" value="${member.physical.height eq 0 ? '' : member.physical.height}" maxlength='3' onchange="if(isNaN(this.value)){alert('只能输入数字');this.value='';}" >cm
	                        <span class="red"></span>
	                    </td>
	                    <td colspan="2">体重：</td>
	                    <td colspan="4">
	                        <input name="physical.weight" id="mem2.weight" type="text" value="${member.physical.weight eq 0 ? '' : member.physical.weight}" maxlength='3' onchange="if(isNaN(this.value)){alert('只能输入数字');this.value='';}">KG
	                        <span class="red"></span>
	                    </td>
	                </tr>
	                <tr>
	                    <td colspan="2">腰围：</td>
	                    <td colspan="4">
	                        <input name="physical.waist" type="text" value="${member.physical.waist eq 0 ? '' : member.physical.waist}" maxlength='5' onchange="if(isNaN(this.value)){alert('只能输入数字');this.value='';}">cm
	                        <span class="red"></span>
	                    </td>
	                    <td colspan="2">臀围：</td>
	                    <td colspan="4">
	                       <input name="physical.hip" type="text" value="${member.physical.hip eq 0 ? '' : member.physical.hip}" maxlength='5' onchange="if(isNaN(this.value)){alert('只能输入数字');this.value='';}">cm
	                       <span class="red"></span>
	                    </td>
	                </tr>
	                <tr>
	                    <td colspan="2">收缩压：</td>
	                    <td colspan="4">
	                        <input name="physical.bloodh" type="text" value="${member.physical.bloodh eq 0 ? '' : member.physical.bloodh}" maxlength='3' onchange="if(isNaN(this.value)){alert('只能输入数字');this.value='';}">mmHg
	                        <span class="red"></span>
	                    </td>
	                    <td colspan="2">舒张压：</td>
	                    <td colspan="4">
	                        <input name="physical.bloodl" type="text" value="${member.physical.bloodl eq 0 ? '' : member.physical.bloodl}" maxlength='3' onchange="if(isNaN(this.value)){alert('只能输入数字');this.value='';}">mmHg
	                        <span class="red"></span>
	                    </td>
	                </tr>
	                <tr>
	                    <td colspan="2">心率：</td>
	                    <td colspan="4">
	                        <input name="physical.heartrate" type="text" value="${member.physical.heartrate eq 0 ? '' : member.physical.heartrate}" maxlength='3' onchange="if(isNaN(this.value)){alert('只能输入数字');this.value='';}">次/分
	                    </td>
	                    <td colspan="2">脉搏：</td>
	                    <td colspan="4">
	                        <input name="physical.pulse" type="text" value="${member.physical.pulse eq 0 ? '' : member.physical.pulse}" maxlength='3' onchange="if(isNaN(this.value)){alert('只能输入数字');this.value='';}">次/分
	                    </td>
	                </tr>
	                <tr>
						<td colspan="2">空腹血糖：</td>
						<td colspan="4">
							<input id="fastingGlucose" name="physical.fastingglucose" type="text" value="${member.physical.fastingglucose eq 0 ? '' : member.physical.fastingglucose}" maxlength='5' onchange="physiqueData('FG-error', '请输入[0.00,50.00]之间的数值', 'fastingGlucose')">mmol/L<span class="red" id="FG-error"></span>
						</td>
						<td colspan="2">总胆固醇：</td>
						<td colspan="4">
							<input id="totalCholesterol" name="physical.totalcholesterol" type="text" value="${member.physical.totalcholesterol eq 0 ? '' : member.physical.totalcholesterol}" maxlength='5' onchange="physiqueData('TC-error', '请输入[0.00,50.00]之间的数值', 'totalCholesterol')">mmol/L<span class="red" id="TC-error"></span>
						</td>
					</tr>
					<tr>
						<td colspan="2">甘油三酯：</td>
						<td colspan="4">
							<input id="triglyceride" name="physical.triglyceride" type="text" value="${member.physical.triglyceride eq 0 ? '' : member.physical.triglyceride}" maxlength='5' onchange="physiqueData('triglyceride-error', '请输入[0.00,50.00]之间的数值', 'triglyceride')">mmol/L<span class="red" id="triglyceride-error"></span>
							<span></span>
						</td>
						<td colspan="2">高密度脂蛋白：</td>
						<td colspan="4">
							<input id="densityLipop" name="physical.densitylipop" type="text" value="${member.physical.densitylipop eq 0 ? '' : member.physical.densitylipop}" maxlength='5' onchange="physiqueData('DL-error', '请输入[0.00,50.00]之间的数值', 'densityLipop')">mmol/L<span class="red" id="DL-error"></span>
						</td>
					</tr>
					<tr>
						<td colspan="2">低密度脂蛋白：</td>
						<td colspan="4">
							<input id="ldlip" name="physical.ldlip" type="text" value="${member.physical.ldlip eq 0 ? '' : member.physical.ldlip}" maxlength='5' onchange="physiqueData('ldlip-error', '请输入[0.00,50.00]之间的数值', 'ldlip')">mmol/L<span class="red" id="ldlip-error"></span>
						</td>
						<td colspan="2">尿酸：</td>
						<td colspan="4">
							<input id="uricAcid-input" name="physical.uricacid" type="text" value="${member.physical.uricacid eq 0 ? '' : member.physical.uricacid}" onchange="if(isNaN(this.value)){alert('只能输入数字');this.value='';}" maxlength='3'  onblur="checkInt2('uricAcid-input','checked-false')">umol/L
							<span class="red" id="checked-false"></span>
						</td>
					</tr>
	                <tr>
	                    <td colspan="2">是否抽烟：</td>
	                    <td colspan="4">
	                        <label class="radio-inline">
	                             <input type="radio" name="habit.smoking" value="Y" <c:if test="${ member.habit.smoking eq 'Y'}">checked</c:if> />是
							</label>
							<label class="radio-inline">
								 <input type="radio" name="habit.smoking" value="N" <c:if test="${ member.habit.smoking eq 'N' }">checked</c:if> />否
							</label>
	                    </td>
	                    <td colspan="2">是否喝酒：</td>
	                    <td colspan="4">
	                         <label class="radio-inline">
	                             <input type="radio" name="habit.dodrink" value="Y" <c:if test="${ member.habit.dodrink eq 'Y'}">checked</c:if> />是
							</label>
							<label class="radio-inline">
								 <input type="radio" name="habit.dodrink" value="N" <c:if test="${ member.habit.dodrink eq 'N'}">checked</c:if> />否
							</label>
	                    </td>
	                </tr>
	                <tr>
	                    <td colspan="2">睡眠状况：</td>
	                    <td colspan="10">
	                        <label class="radio-inline">
							     <input name="habit.sleepcond" type="radio" value="Y" class="input_radio" <c:if test="${ member.habit.sleepcond eq 'Y'}">checked</c:if> />好
							</label>
							<label class="radio-inline">
								 <input name="habit.sleepcond" type="radio" value="N" class="input_radio" <c:if test="${ member.habit.sleepcond eq 'N'}">checked</c:if> />差
							</label>
	                    </td>
	                </tr>
	                <tr>
	                    <th colspan="12">失败原因</th>
	                </tr>
	                <tr>
	                    <td colspan="2">失败原因</td>
	                    <td colspan="10">
	                       <textarea rows="2" cols="100" disabled="disabled">${importLog.reason }</textarea>
	                    </td>
	                </tr>
	            </tbody>
	        </table>
	    </div>
	    <div class="text-center margin-10">
			<input type="submit" value="保存" id="content_sub" class="btn-inquiry mg-lf-50"/>
		</div>
	</form>
</div>
</body>
</html>
