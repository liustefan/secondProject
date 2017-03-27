//异步判断账号名是否存在
function checkdocAccIsExistence(docAcc) {
   
	var docName = $(docAcc).val();

	if(isAcc(docAcc)){

		var url = "doctorAction!checkdocAccIsExistence";
	
		$.post(url, {
			docAcc : docName
		}, function(data) {
			if (data == 1) {
				$(docAcc).next().html($(docAcc).attr("title") + "已存在！");
//				$(docAcc).focus();
				return false;
			} else {
				return true;
			}
		})
	}
	if($(docAcc).val()==""){
	      $(docAcc).next().html("不能为空");
	      /*$(docAcc).focus();*/
	      return false;
	    }
	var reg=/^[A-Za-z0-9]+$/;
    if(!reg.test($(docAcc).val())){
      $(docAcc).next().html("用户名只能为数字或字母");
     /* $(docAcc).focus();*/
      return false;
    }
    else{
    	$(docAcc).next().html("*");
    }
    return true;
}

//异步判断手机号是否存在
function checkdocTelIsExistence(obj) {
	var docName = $(obj).val();
	//debugger;
	if(isPhone(obj)){

		var url = "doctorAction!checkdocTelIsExistence";
	
		$.post(url, {
			tel : docName
		}, function(data) {
			if (data == 1) {
				//$(obj).next().html($(obj).attr("title") + "已存在！");
				$("#myTel").html("手机号码已存在");
//				$(docAcc).focus();
				return false;
			} else {
				$("#myTel").html("*");
				return true;
			}
		})
	}else {
		return false;
	}
	
}
function addupt() {
	var oDiv = $('#center_content');
	var aBut = $('#center_new>label');
	var aDiv = $('.content_new');
	for ( var i = 0; i < aBut.length; i++) {
		aBut[i].index = i;
		aBut[i].onclick = function() {
			for ( var j = 0; j < aBut.length; j++) {
				aBut[j].style.background = '';
				aDiv[j].style.display = 'none';
			}
			;
			this.style.background = '#2e96e5';
			aDiv[this.index].style.display = 'block';
		};
	}
	;
};
function addupt_1() {
	var oDiva = $('#center_content_a');
	var aButa = $('#center_new_1>label');
	var aDiva = $('.content_new_1');
	for ( var i = 0; i < aButa.length; i++) {
		aButa[i].index = i;
		aButa[i].onclick = function() {
			for ( var j = 0; j < aButa.length; j++) {
				aButa[j].style.background = '';
				aDiva[j].style.display = 'none';
			}
			;
			this.style.background = '#2e96e5';
			aDiva[this.index].style.display = 'block';
		};
	}
	;
};
function a_show() {
	$("#label_a").css({
		"background" : "#2e96e5"
	});
	$("#label_b").css({
		"background" : "#4fc963"
	});
	$("#center_content").css({
		"display" : "block"
	});
	$("#center_content_a").css({
		"display" : "none"
	});
}
function b_show() {
	$("#label_b").css({
		"background" : "#2e96e5"
	});
	$("#label_a").css({
		"background" : "#4fc963"
	});
	$("#center_content").css({
		"display" : "none"
	});
	$("#center_content_a").css({
		"display" : "block"
	});
}

/**
 * 验证账号
 */
function isAcc(obj) {
	
	if ($(obj).val() == "") {
		$(obj).next().html($(obj).attr("title") + "不能为空！");
		/*$(obj).focus();*/
		return false;
	}
	//if ($(obj).val().length < 6) {
	//	$(obj).next().html($(obj).attr("title") + "必须大于6位！");
//		
	//	return false;
	//}
	//var reg = /.*[\u4e00-\u9fa5]+.*$/;
	//if (reg.test($(obj).val())) {
	//	$(obj).next().html($(obj).attr("title") + "不能输入中文！");
//		
		//return false;
	//}
	else {
		$(obj).next().html("");
		$("#addSubmint").attr("disabled", false);
		return true;
	}
}
/**
 * 验证姓名
 */
function findLength(obj) {
	if ($(obj).val() == "") {
		
		$(obj).next().html($(obj).attr("title") + "不能为空！");
		/*$(obj).focus();*/
		return false;
	}
	if ($(obj).val().length >10) {
		$(obj).next().html($(obj).attr("title") + "不能超过10个字符");
		/*$(obj).focus();*/
		return false;
	}
//	var reg = /^[\u4E00-\u9FA5]+$/;
//	if (!reg.test($(obj).val())) {
//		$(obj).next().html($(obj).attr("title") + "只能输入中文！");
//		
//		return false;
//	}
	else {
		$(obj).next().html("");
		return true;
	}
}
/**
 * 验证邮箱
 */
function isEmail(obj) {
	//zhouwp加
	if($(obj).val() == ""){
		$(obj).next().html($(obj).attr("title") + "不能为空！");
		/*$(obj).focus();*/
		return false;
	}
	//var myReg = /^[-_A-Za-z0-9]+@([_A-Za-z0-9]+\.)+[A-Za-z0-9]{2,3}$/;
	//var myReg = /^([/w/d_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
	
	var myReg = /^([a-zA-Z0-9]+\W)*[a-zA-Z0-9]+@([a-zA-Z0-9]+\W)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	
	if (myReg.test($(obj).val())) {
		$(obj).next().html("");
		return true;
	} else {
		$(obj).next().html($(obj).attr("title") + "格式错误！");
		/*$(obj).focus();*/
		return false;
	}
}
/**
 * 验证手机号码
 */
function isPhone(obj) {
	if($(obj).val() == ""){
		$(obj).next().html($(obj).attr("title") + "不能为空！");
		/*$(obj).focus();*/
		return false;
	}
	var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(17[0-9]{1}))+\d{8})$/;
	if ($(obj).val().length == 11) {
		if (myreg.test($(obj).val())) {
			$(obj).next().html("*");
			return true;
		} else {
			$(obj).next().html($(obj).attr("title") + "无效！");
			/*$(obj).focus();*/
			return false;
		}
	} else {
		$(obj).next().html($(obj).attr("title") + "长度错误！");
		/*$(obj).focus();*/
		return false;
	}
}
/**
 * 验证密码
 */
function isPsw(obj) {
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
	
	$(obj).next().html("*");
	return true;
}
/**
 * 检测2次密码输入是否相等
 */
function isPswtwo(obj) {
	var psw1 = $(obj).parent().parent().prev().find("input").val();
	var psw2 = $(obj).val();
	if (psw2 === psw1) {
		$(obj).next().html("");
		return true;
	} else {
		$(obj).next().html("两次密码输入不一样！");
		/*$(obj).focus();*/
		return false;
	}
}
/* 
* 身份证号码与出生日期的验证 
* 前提是：身份证号和出生日期格式都已经过格式验证 
* 身份证号为15或18位，出生日期格式为XXXX-XX-XX 
*/ 
function checkBirthdayAndIdCard(birthday, certiNum) {
	 	var dateTemp= new Date(),
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
}

function checkRequired(obj, msg) {
	var value = $(obj).val();

	if(value || value === "") {
		$(obj).next().html(msg);
		return false;
	}else {
		$(obj).next().html("*");
		return true;
	}
}


