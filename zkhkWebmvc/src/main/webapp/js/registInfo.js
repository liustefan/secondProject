var errorMsgColor = "color: red";		//(样式)错误消息的颜色
var firstMsgColor = "color: #888";
var haveError;
var errorMsgColor = "color: red";		//(样式)错误消息的颜色
var firstMsgColor = "color: #888"; //(样式)初始的提示语的颜色   用于之后的判断,中间要加空格,全文小写
function basicInit(object){//初始化基本方法
	if(object==null){
		return false;
	}
	$(object).next().text('');//把验证对象后面的提示信息清空
}

//进行验证后,补写提示语
function supplyMsg(object){
	if(object==null){
		return false;
	}
	if($(object).attr("firstMsg")!=undefined){
		$(object).next().text($(object).attr("firstMsg"));
		$(object).next().attr("style",$(object).attr("firstMsgColor"));
	}
}
	
//文本框验证初始化 
function checkInit(object){
	basicInit(object);
	$(object).val(jQuery.trim($(object).val()));//去掉左右空格
}

//非空验证
function Required(object){
	checkInit(object);
	if($.trim($(object).val()).length==0){
		$(object).next().text("必须填写").attr("style",errorMsgColor);
		haveError = true;
		return false;
	}
	if($.trim($(object).val())<=0){
		$(object).next().text("必须大于0").attr("style",errorMsgColor);
		haveError = true;
		return false;
	}
	supplyMsg(object);
	return true;
}

//验证姓名格式
function checkName(obj) {
	if (Required(obj)) {
		var pattern = /[`~!@#$%^&*()_+<>?:"{},.\/;'[\]]/im;
		var value = $(obj).val();
		if (pattern.test(value)) {
			$(obj).next().text("姓名不能包含特殊字符");
			return false;
		}
	}
}

// 验证手机号码
function isPhone(object) {
	if($(object).val()){
		checkInit(object);
		var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|18[0-9]|17[0-9])+\d{8})$/;
		if ($(object).val().trim().length == 11) {
			if (myreg.test($(object).val())) {
				$(object).next().html("");
				$("#content_sub").attr("disabled", false);
				return true;
			}else{
				alert("手机号格式输入错误,请重新输入");
				return false;
			}
		}else {
			alert("手机号格式输入错误,请重新输入");
				return false;
			}
	}
}

//正则表达式
function regularExpression(object,msg,myReg){
	checkInit(object);
	if(!myReg.test($(object).val())){
		$(object).next().text(msg).attr("style",errorMsgColor);
		haveError = true;
		$("#content_sub").attr("disabled", true);
		return false;
	}else{
		supplyMsg(object);
		$("#content_sub").attr("disabled", false);
		return true;
	}
}

//邮箱验证
function isEmail(object){
	if($(object).val()) {
		var myReg =/^.+\@(\[?)[a-zA-Z0-9\-\.]+\.([a-zA-Z]{2,3}|[0-9]{1,3})(\]?)$/;
		return regularExpression(object,"格式错误！",myReg);
	} else {
		$(object).next().html("");
	}
}

//把身份证上的出生日期赋值到出生日期输入框中，同时选中相应的性别
function getBirthDateFromIdCard(idCard) {  
	var obj = getBirthDate(idCard);
	$("input:radio[name=sexual]").prop('disabled',false);
	$("input[name=birthDate]").prop('disabled',false);
	
	$("input:radio[name=sexual]").prop("checked", false);
	$("input:radio[name=sexual][value="+obj.gender+"]").prop("checked", true);
	$("input[name=birthDate]").val(obj.birthDate);
	 
	if(idCard == ""){
		$("input:radio[name=sexual]").prop('disabled',false);
		$("input[name=birthDate]").prop('disabled',false);
	}
	$('input[name="gender"]').val(obj.gender);
	$('input[name="birthdate"]').val(obj.birthDate);
 }

function getBirthDate(idCard) {
	var data = {birthDate:'', gender: 3};
	if (idCard.length == 15) {
		data.birthDate = idCard.substring(6, 12);
		data.birthDate = "19" + data.birthDate;
		data.birthDate = data.birthDate.substring(0, 4) + "-" + data.birthDate.substring(4, 6) + "-" + data.birthDate.substring(6)
		if(parseInt(idCard.charAt(14) / 2) * 2 != idCard.charAt(14))
			data.gender = 1;
        else
        	data.gender = 2;
	}else if(idCard.length == 18){
		data.birthDate = idCard.substring(6, 14);
		data.birthDate = data.birthDate.substring(0, 4) + "-" + data.birthDate.substring(4, 6) + "-" + data.birthDate.substring(6)
		if (parseInt(idCard.charAt(16) / 2) * 2 != idCard.charAt(16))
			data.gender = 1;
		else
			data.gender = 2;
	}else if(idCard.length == 0){
		data = {birthDate:'', gender: 3};
	}
	return data;
}

//身份证验证
function isIDCard(object){
	var obj = $("#idCard").val();
	$("#idCard").val(obj);
	checkInit(object);
	var result = checkIdCard($(object).val());
	if(result){
		getBirthDateFromIdCard($(object).val());
	}else{
		alert("身份证格式输入错误");
		$(object).focus();
	}
	
	if(!$(object).val()) {
		$(object).next().html("");
	}
	return result;
}

//出生年月日验证
function checkDate(object){
   var reg = /^((((1[6-9]|[2-9]\d)\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\d|3[01]))|(((1[6-9]|[2-9]\d)\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\d|30))|(((1[6-9]|[2-9]\d)\d{2})-0?2-(0?[1-9]|1\d|2[0-8]))|(((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-))(\s(([01]\d{1})|(2[0123])):([0-5]\d):([0-5]\d))?$/;
    if(!reg.test($(object).val())){
    	checkInit(object);
    	$(object).next().text("日期格式错误！").attr("style",errorMsgColor);
    	haveError=true;
    	$(object).focus();
    	return false;
    }else{
    	$(object).next().html("");
    }
    
    var date = new Date();
    var oDate = new Date($(object).val().replace(/-/g,"/"));
    if(oDate > date){
    	$(object).next().text("日期不能大于当天日期！").attr("style",errorMsgColor);
    	haveError=true;
    	$(object).focus();
    	return false;
    }else{
    	$(object).next().html("");
    }
}
$.extend({
    //  获取对象的长度，需要指定上下文 this
    Object:     {
        count: function( p ) {
            p = p || false;
         
            return $.map( this, function(o) {
                if( !p ) return o;
                 
                return true;
            } ).length;
        }
    }
});

//验证身高
function validateHeight(obj){
	if(isNaN(obj.val())){
		alert('只能输入数字');
		obj.val('');
		return false;
	}

	if(obj.val().length > 0 && (obj.val() < 100 || obj.val() > 210)){
		alert("身高范围为100~210，范围已超出，请重新输入！");
		return false;
	}
	return true;
}

//收缩压验证
function validateBloodH(obj){
	if(isNaN(obj.val())){
		alert('只能输入数字');
		obj.val('');
		return false;
	}
	if(obj.val()){
		if(obj.val() < 40 || obj.val() > 260){
			alert("收缩压的正常范围为40~260，范围已超出，请重新输入！");
			return false;
		}
	}
	return true;
}

//舒张压验证
function validateBloodL(obj){
	if(isNaN(obj.val())){
		alert('只能输入数字');
		obj.val('');
		return false;
	}
	if(obj.val()){
		if(obj.val() < 40 || obj.val() > 180){
			alert("舒张压的正常范围为40~180，范围已超出，请重新输入！");
			return false;
		}
	}
	return true;
}
	

//体格检测数据格式验证[0.00,50.00]
function physiqueData(id1, msg, id2, touch) {
	reg=/^(?:[1-9]\d{0,1}|0)(?:\.\d{1,2})?$/;
       if(reg.test($("#"+id2).val()) || $("#" + id2).val() == ""){
    	   if($("#"+id2).val() >= 0.00 && $("#"+id2).val() <= 50.00){
          		$("#" + id1).html("");
    	   }else {
               $("#" + id1).html(msg);
               if(touch){
           		   $("#" + id2).focus();
               }
    	   }
       }else {
           $("#" + id1).html(msg);
           if(touch){
               $("#" + id2).focus();
           }
       } 
}

//点击保存按钮，进行表单验证
$(function(){
	$("#registInfo_form").click(function(){
		if($("input[name='tel']").val()){
			var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|18[0-9]|17[0-9])+\d{8})$/;
			if ($("input[name='tel']").val().trim().length == 11) {
				if (!myreg.test($("input[name='tel']").val())) {
					alert("手机号格式输入错误,请重新输入");
					$("input[name='tel']").focus();
					return false;
				}
			}else {
				alert("手机号格式输入错误,请重新输入");
				$("input[name='tel']").focus();
				return false;
			}
		}else {
			$("input[name='tel']").next().text("");
		}
		
		$("input[name='gender']").val($("input[name='sexual']:checked").val());
		$("input[name='birthdate']").val($("input[name='birthDate']").val());
		
		if(!checkIdCard($.trim($("input[name='idcard']").val()))){
			alert("身份证格式输入错误!");
			$("input[name='idcard']").focus();
			return false;
		}
		
		if($.trim($("input[name='physical.height']").val())<0 ){
			checkInit($("input[name='physical.height']"));
			$("input[name='physical.height']").next().text("不能为负").attr("style",errorMsgColor);
			haveError = true;
			$("input[name='physical.height']").focus();
			return false;
		}else {
			$("input[name='physical.height']").next().text("");
		}
		
		if(!validateHeight($('input[name="physical.height"]'))){
			$('input[name="physical.height"]').focus();
			return false;				
		}
		
		if($.trim($("input[name='physical.weight']").val())<0 ){
			checkInit($("input[name='physical.weight']"));
			$("input[name='physical.weight']").next().text("不能为负").attr("style",errorMsgColor);
			haveError = true;
			$("input[name='physical.weight']").focus();
			return false;
		}else {
			$("input[name='physical.weight']").next().text("");
		}
		
	 	if($.trim($("input[name='physical.waist']").val())<0 ){
			checkInit($("input[name='physical.waist']"));
			$("input[name='physical.waist']").next().text("不能为负").attr("style",errorMsgColor);
			haveError = true;
			$("input[name='physical.waist']").focus();
			return false;
		}else {
			$("input[name='physical.waist']").next().text("");
		}
		
		if($.trim($("input[name='physical.hip']").val())<0 ){
			checkInit($("input[name='physical.hip']"));
			$("input[name='physical.hip']").next().text("不能为负").attr("style",errorMsgColor);
			haveError = true;
			$("input[name='physical.hip']").focus();
			return false;
		}else {
			$("input[name='physical.hip']").next().text("");
		}
		
		if($.trim($("input[name='physical.bloodh']").val())<0 ){
			checkInit($("input[name='physical.bloodh']"));
			$("input[name='physical.bloodh']").next().text("不能为负").attr("style",errorMsgColor);
			haveError = true;
			$("input[name='physical.bloodh']").focus();
			return false;
		}else {
			$("input[name='physical.bloodh']").next().text("");
		}
		
		if(!validateBloodH($('input[name="physical.bloodh"]'))){
			$('input[name="physical.bloodh"]').focus();
			return false;
		}
		
		if($.trim($("input[name='physical.bloodl']").val())<0 ){
			checkInit($("input[name='physical.bloodl']"));
			$("input[name='physical.bloodl']").next().text("不能为负").attr("style",errorMsgColor);
			haveError = true;
			$("input[name='physical.bloodl']").focus();
			return false;
		}else {
			$("input[name='physical.bloodl']").next().text("");
		}

		if(!validateBloodL($('input[name="physical.bloodl"]'))){
			$('input[name="physical.bloodl"]').focus();
			return false;				
		}
		
		if(parseInt($("input[name='physical.bloodh']").val()) <= parseInt($("input[name='physical.bloodl']").val())){
			alert("收缩压要大于舒张压!");
			$('input[name="physical.bloodh"]').focus();
			return false;	
		}
		
		if($.trim($("input[name='physical.heartrate']").val())<0 ){
			checkInit($("input[name='physical.heartrate']"));
			$("input[name='physical.heartrate']").next().text("不能为负").attr("style",errorMsgColor);
			haveError = true;
			$("input[name='physical.heartrate']").focus();
			return false;
		}else {
			$("input[name='physical.heartrate']").next().text("");
		}

		if($.trim($("input[name='physical.pulse']").val())<0 ){
			checkInit($("input[name='physical.pulse']"));
			$("input[name='physical.pulse']").next().text("不能为负").attr("style",errorMsgColor);
			haveError = true;
			$("input[name='physical.pulse']").focus();
			return false;
		}else {
			$("input[name='physical.pulse']").next().text("");
		}
		
		physiqueData('FG-error', '请输入[0.00,50.00]之间的数值', 'fastingGlucose', 'touch');
		if($("#FG-error").html() == '请输入[0.00,50.00]之间的数值'){
		    return false;
		}
		physiqueData('TC-error', '请输入[0.00,50.00]之间的数值', 'totalCholesterol', 'touch');
		if($("#TC-error").html() == '请输入[0.00,50.00]之间的数值'){
		    return false;
		}
		physiqueData('triglyceride-error', '请输入[0.00,50.00]之间的数值', 'triglyceride', 'touch');
		if($("#triglyceride-error").html() == '请输入[0.00,50.00]之间的数值'){
		    return false;
		}
		physiqueData('DL-error', '请输入[0.00,50.00]之间的数值', 'densityLipop', 'touch');
		if($("#DL-error").html() == '请输入[0.00,50.00]之间的数值'){
		    return false;
		}
		physiqueData('ldlip-error', '请输入[0.00,50.00]之间的数值', 'ldlip', 'touch');
		if($("#ldlip-error").html() == '请输入[0.00,50.00]之间的数值'){
		    return false;
		}

		if($.trim($("input[name='physical.uricacid']").val())<0 ){
			checkInit($("input[name='physical.uricacid']"));
			$("input[name='physical.uricacid']").next().text("不能为负").attr("style",errorMsgColor);
			haveError = true;
			$("input[name='physical.uricacid']").focus();
			return false;
		}else {
			$("input[name='physical.uricacid']").next().text("");
		}
	
	});
});

/**
*
* @descrition: 判断输入的参数是否是一个合格的身份证号码。这个函数对输入的参数检查时候是合格的身份证号码，其身份证有效性无法判断。检测的颗粒度可以定制。
* @param->str : 待验证的参数
* @return : true是合格的身份证   false为不合法的身份证
* 
*/
var checkIdCard = function(num) {
	if($.trim($("input[name='idcard']").val()).length > 0){
		num = num.toUpperCase();

	    var cityCode = {11: "北京", 12: "天津", 13: "河北", 14: "山西", 15: "内蒙古", 21: "辽宁", 22: "吉林", 23: "黑龙江 ", 31: "上海", 32: "江苏", 33: "浙江", 34: "安徽", 35: "福建", 36: "江西", 37: "山东", 41: "河南", 42: "湖北 ", 43: "湖南", 44: "广东", 45: "广西", 46: "海南", 50: "重庆", 51: "四川", 52: "贵州", 53: "云南", 54: "西藏 ", 61: "陕西", 62: "甘肃", 63: "青海", 64: "宁夏", 65: "新疆", 71: "台湾", 81: "香港", 82: "澳门", 91: "国外 "};

	    if(!cityCode[num.substr(0,2)]){
//	        alert("地址编码错误");
//	    	alert("身份证格式输入错误");
	        return false;
	    }
	    //身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X。
	    if (!(/(^\d{15}$)|(^\d{17}([0-9]|X)$)/.test(num))) {
	        //alert('输入的身份证号长度不对，或者号码不符合规定！\n15位号码应全为数字，18位号码末位可以为数字或X。');
//	    	alert("身份证格式输入错误");
	        return false;
	    }
	    //校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。
	    //下面分别分析出生日期和校验位
	    var len, re;
	    len = num.length;
	    if (len == 15) {
	        re = new RegExp(/^(\d{6})(\d{2})(\d{2})(\d{2})(\d{3})$/);
	        var arrSplit = num.match(re);

	        //检查生日日期是否正确
	        var dtmBirth = new Date('19' + arrSplit[2] + '/' + arrSplit[3] + '/' + arrSplit[4]);
	        var bGoodDay;
	        bGoodDay = (dtmBirth.getYear() == Number(arrSplit[2])) && ((dtmBirth.getMonth() + 1) == Number(arrSplit[3])) && (dtmBirth.getDate() == Number(arrSplit[4]));
	        if (!bGoodDay) {
	            //alert('输入的身份证号里出生日期不对！');
//	        	alert("身份证格式输入错误");
	            return false;
	        }
	        else {
	            //将15位身份证转成18位
	            //校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。
	            var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);
	            var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');
	            var nTemp = 0, k;
	            num = num.substr(0, 6) + '19' + num.substr(6, num.length - 6);
	            for (k = 0; k < 17; k++) {
	                nTemp += num.substr(k, 1) * arrInt[k];
	            }
	            num += arrCh[nTemp % 11];
	            return true;
	        }
	    }
	    if (len == 18) {
	        re = new RegExp(/^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/);
	        var arrSplit = num.match(re);

	        //检查生日日期是否正确
	        var dtmBirth = new Date(arrSplit[2] + "/" + arrSplit[3] + "/" + arrSplit[4]);
	        var bGoodDay;
	        bGoodDay = (dtmBirth.getFullYear() == Number(arrSplit[2])) && ((dtmBirth.getMonth() + 1) == Number(arrSplit[3])) && (dtmBirth.getDate() == Number(arrSplit[4]));
	        if (!bGoodDay) {
	            //alert(dtmBirth.getYear());
	            //alert(arrSplit[2]);
//	            alert('输入的身份证号里出生日期不对！');
//	        	alert("身份证格式输入错误");
	            return false;
	        }
	        else {
	            //检验18位身份证的校验码是否正确。
	            //校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。
	            var valnum;
	            var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);
	            var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');
	            var nTemp = 0, k;
	            for (k = 0; k < 17; k++) {
	                nTemp += num.substr(k, 1) * arrInt[k];
	            }
	            valnum = arrCh[nTemp % 11];
	            if (valnum != num.substr(17, 1)) {
//	                alert('18位身份证的校验码不正确！应该为：' + valnum);
//	            	alert("身份证格式输入错误");
	                return false;
	            }
	            return true;
	        }
	    }
	    return false;
	} else {
		return true;
	}
};