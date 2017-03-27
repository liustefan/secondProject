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
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9">
<title>编辑药物</title>

<link rel="stylesheet" href="<%=path %>/css/general.css">
<link rel="stylesheet" href="<%=path %>/css/leadInformation.css">

<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/editMedicinal.js"></script>
<script type="text/javascript" src="<%=path %>/js/placeholder.js"></script>

<script type="text/javascript">
	function selected(name, txt){
		var obj = $("select[name ='"+name+"'] option:checked");
		
		if(obj.val() == ' '){
			$("#" + txt).show();
			$("#" + txt).focus();
		} else {
			$("#" + txt).hide();
		}
	}
</script>
</head>

<body>
	<div class="layer-box">
		<form id="form-drugDetail" action="">
			<input type="hidden" name="logID">
			<input type="hidden" name="index">
			<input type="hidden" id="source" value="${param.source}">
			<div class="input-block">
				<p>
					<span class="content-left">药物名称：</span>
					<input maxlength="25" type="text" class="none-difference" name="drugName">
					<span class="red">*</span>
				</p>
			</div>
			<div class="input-block">
				<p>
					<span class="content-left">用法：</span>
					<select name="useMethod" class="same-width" onchange="selected('useMethod', 'txt1')">
                      <option value ="口服">口服</option>
                      <option value ="静脉点滴">静脉点滴</option>
                      <option value="肌肉注射">肌肉注射</option>
                      <option value="皮下注射">皮下注射</option>
                      <option value="外用">外用</option>
                      <option value="雾化">雾化</option>
                      <option value=" " data-input='txt1'>其他</option>
                    </select>
                    <input maxlength="15" type="text" id="txt1" value="" placeholder="其他" class="otherDes" />
				</p>
			</div>
			<div class="input-block">
				<p>
					<span class="content-left">用量：</span>
					<input maxlength="5" type="text" class="none-difference" name="count">
				</p>
			</div>
			<div class="input-block">
				<p>
					<span class="content-left">单位：</span>
					<select name="dosageUnit" class="same-width" onchange="selected('dosageUnit', 'txt3')">
                      <option value ="片">片</option>
                      <option value ="支">支</option>
                      <option value ="包">包</option>
                      <option value="克">克</option>
                      <option value="毫克">毫克</option>
                      <option value="毫升">毫升</option>
                      <option value=" " data-input='txt3'>其他</option>
                    </select>
                    <input maxlength="10" type="text" id="txt3" value="" placeholder="其他" class="otherDes" />
				</p>
			</div>
			<div class="input-block">
				<p>
					<span class="content-left">频度：</span>
					<select name="frequentness" class="same-width" onchange="selected('frequentness', 'txt2')">
                      <option value ="每日一次">每日一次</option>
                      <option value ="每日两次">每日两次</option>
                      <option value="每日三次">每日三次</option>
                      <option value="每日四次">每日四次</option>
                      <option value="紧急时">紧急时</option>
                      <option value="睡前">睡前</option>
                      <option value=" " data-input='txt2'>其他</option>
                    </select>
                    <input maxlength="15" type="text" id="txt2" value="" placeholder="其他" class="otherDes" />
				</p>
			</div>
			<c:if test="${param.source eq 'healthExam'}">
				<div class="input-block">
					<p>
						<span class="content-left">用药时间：</span>
						<input maxlength="10" type="text" class="none-difference" name="drugUseTime">
					</p>
				</div>
				<div class="input-block">
					<p>
						<span class="content-left">服药依从性：</span>
						<select name="compliance" class="same-width">
	                      <option value ="1">规律</option>
	                      <option value ="2">间断</option>
	                      <option value="3">不服药</option>
	                    </select>
					</p>
				</div>
			</c:if>
			<div class="textarea-block">
				<p>
					<span class="content-left">备注：</span>
					<textarea maxlength="100" class="size" name="remark"></textarea>
				</p> 
			</div>
			<div class="btn-box align-center">
				<input type="button" id="drugDetail" class="btn-inquiry mg-lf-50" value="确定">
				<input type="button" class="btn-cancel mg-lf-50" onclick="parent.layer.closeAll('iframe');" value="取消">
			</div>
		</form>
	</div>
</body>
</html>
