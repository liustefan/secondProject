function isPsw1(obj) {
	var val = $(obj).val();
	
	if (val == "") {
		$(obj).next().html("不能为空！");
		return false;
	}
	var re = /^[a-zA-Z0-9]{6,20}$/;
	

	if (!re.test(val)) {
		$(obj).next().html("密码由6至20位字母数字组成");
		$(obj).focus();
		return false;
	}
//	if ($(obj).val().length < 6) {
//		$(obj).next().html("必须大于等于6位！");
//		return false;
//	}
//	if ($(obj).val().length > 20) {
//		$(obj).next().html("必须小于20位！");
//		return false;
//	}
	$(obj).next().html("*");
	return true;
}
function clearTipsInfo() {
	$('.table_left').find("span").text('');
}

function checkPsd() {
	var pass = $("#password").val();
	var rePass = $("#password2").val();
	if (rePass == "") {
		$("#password2").next().html("确认密码不能为空");
		return false;
	}
	if (pass != rePass) {
		$("#password2").next().html("密码两次输入不一致");
		return false;
	} else {
		$("#password2").next().html("*");
		return true;
	}
}

function ckeckEmpty() {
	var $orgId = $("#orgId");
	if($orgId && $orgId.val() ==''){
		alert("请选择组织机构！");
		$("#orgs").focus();
		return false;
	}
	var myAcc = $("#acc").next().html();
	if ($("#acc").val() == "") {
		alert("账号不能为空！");
		$("#acc").focus();
		return false;
	}
	if (myAcc.length > 1) {
		alert("账号已存在！");
		return false;
	}
	if (isAcc("#acc") && isPsw("#password") && isPswtwo("#password2")
			&& findLength("#name") && isEmail("#email")) {

		if ($("#birthday").val() == "") {
			$("#birthday").focus();
			$("#birthday").next().html($("#birthday").attr("title") + "不能为空！");
			return false;
		} else if ($("#birthday").val() != "") {
			var date = new Date();
			var oDate = new Date($("#birthday").val().replace(/-/g, "/"));
			if (oDate > date) {
				$("#birthday").focus();
				$("#birthday").next().html("日期不能大于当天日期！");
				return false;
			} else {
				$("#birthday").next().html("");
			}
		}
		if($("#myTel").html() !== "*") {
			//alert("手机号已存在");
			$("#phone").focus();
			return false;
		}
	} else {
		alert("信息不能为空");
		return false;
	}

	var certiNum = $("#certiNum").val();
	if (certiNum != "") {
		var certiType = $("#certiType").val();
		if (certiType == 1) {
			var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
			if (reg.test(certiNum) === false) {
				alert("身份证输入不合法");
				return false;
			}
		} else if (certiType == 0) {
			alert("请选择证件类型");
			return false;
		}
	}
	var dateTemp= new Date(),
	birthday = $("#birthday").val();
	certiNum = $("#certiNum").val();
 	arr_date = birthday.split("-"),
    inputDate = new Date(arr_date[0],arr_date[1]-1,arr_date[2]);
	
	if(birthday !== ""){
		if(inputDate > dateTemp){ 
			alert("出生日期时间不能大于今天！请检查！"); 
			return false; 
		}
	     //15位身份证 
	    if(certiNum.length == 15){ 
	      //从ID NO 中截取生日6位数字，前面加上19 
	    	var idBirthday = "19"+certiNum.substr(6,6); 
	      //日期字符串中的8位生日数字 
	    	var textBirthday = arr_date[0]+arr_date[1]+arr_date[2]; 
	    	if(idBirthday == textBirthday){ 
	    		return true; 
	    	}else{ 
	    		alert("出生日期与身份证日期不一致，请检查！"); 
	    		return false; 
	    	}               
	    } 
	    //18位身份证 
	    if(certiNum.length == 18){
	    	 //从ID NO 中截取生日8位数字 
	    	var idBirthday = certiNum.substr(6,8); 
	    	 //日期字符串中的8位生日数字 
	    	var textBirthday = arr_date[0]+arr_date[1]+arr_date[2]; 
	    	 //alert(idBirthday); 
	    	 //alert(textBirthday); 
	    	if(idBirthday == textBirthday){ 
	        	return true; 
	    	}else{ 
	    		alert("出生日期与身份证日期不一致，请检查！"); 
	    		return false; 
	    	} 
	    }
	}

	$("#addSubmint").attr("disabled", true);
	$(".new_but").attr("disabled", true);
}

function isCardNo(card) {
	// 1：身份证 2：驾驶证 3：港澳通行证
	var certiType = $("#certiType").val();
	if (certiType == 1) {
		// 身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X
		var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
		if (reg.test(card.value) === false) {
			alert("身份证输入不合法");
			card.value = '';
		}
	} else if (certiType == 2) {

	} else if (certiType == 3) {

	} else if (certiType == 0) {
		alert("请选择证件类型");
		card.value = '';
	}
}

// 打印必填星号*
function printAsterisk(obj) {
	$(obj).next().html("*");
}

function checkBirthday(obj) {
	if ($(obj).val() == "") {
		$(obj).next().html("出生日期不能为空!");
	} else {
		$(obj).next().html("*");
	}
}
