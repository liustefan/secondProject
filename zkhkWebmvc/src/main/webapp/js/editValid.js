	function setBaseInfo(obj){
		$("input[name='unique_ID']").val(obj.uniqueId);
		$("input[name='name']").val(obj.memName);
		$("input[name='memberID']").val(obj.memberId);
		if(obj.gender == 2){
			$('.genecology').show();
			$('.p_genecology').attr("rowspan", 20);
		}else{
			$('.genecology').hide();
			$('.p_genecology').attr("rowspan", 14);
		}
//		alert(ages(obj.birthDay));
		if(ages(obj.birthDay) >= 65){
			$('.elderly').show();
			$('.p_elderly').attr("rowspan", 9);
		}else{
			$('.elderly').hide();
			$('.p_elderly').attr("rowspan", 5);
		}
	}
	
	function setDocBaseInfo(obj){
		$("input[name='responsibleDrName']").val(obj.docName);
	}
	function ages(str) {   
        var r = str.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);     
        if(r==null)
        	return 0;     
        var d= new Date(r[1],   r[3]-1,   r[4]);     
        if(d.getFullYear()==r[1]&&(d.getMonth()+1)==r[3]&&d.getDate()==r[4]){   
              var   Y   =   new   Date().getFullYear();   
              return Y-r[1];   
        }
        return 0;
	} 
	//数值大小验证
	function numberRange(id, minN, maxN){
        var val = $("#" +  id ).val();
        var numberVal = parseInt(val);
        var reg = /^(0|[1-9]\d*)$/;
        if($("#"+id).val() != ''){
        	if(!reg.test($("#"+id).val())) {
        		$("#" + id).focus();
            	return;
            }else if(numberVal<=maxN && numberVal>=minN) {
            	return;
            }else {
        		$("#" + id).focus();
            	return;
            }
        }   
    }

	//decimal(6,2)form表单提交验证
	function VDblur5(id1, msg, id2, touch) {
		reg=/^(?:[1-9]\d{0,3}|0)(?:\.\d{1,2})?$/;
           if(reg.test($("#"+id2).val()) || $("#" + id2).val() == ""){
           		$("#" + id1).html("");
           }else {
               $("#" + id1).html(msg);
               if(touch){
	               layer.alert("请填写正确的信息", {shade: 0,skin : 'skin1'}, function(index) { 
					   layer.close(index);
               		   $("#" + id2).focus();
				       $("#save").removeAttr("disabled");
				   });
               }
           } 
	}
	
	//decimal(5,2)form表单提交验证
	function VDblur4(id1, msg, id2, touch) {
		reg=/^(?:[1-9]\d{0,2}|0)(?:\.\d{1,2})?$/;
           if(reg.test($("#"+id2).val()) || $("#" + id2).val() == ""){
           		$("#" + id1).html("");
           }else {
               $("#" + id1).html(msg);
               if(touch){
	               layer.alert("请填写正确的信息", {shade: 0,skin : 'skin1'}, function(index) { 
					   layer.close(index);
               		   $("#" + id2).focus();
               		   if(id2 == 'BMI'){
               			   $("#height").focus();
               		   }
				       $("#save").removeAttr("disabled");
				   });
               }
           } 
	}

	//decimal(5,1)form表单提交验证
	function VDblur(id1, msg, id2, touch) {
		reg=/^(?:[1-9]\d{0,3}|0)(?:\.\d{1})?$/;
           if(reg.test($("#"+id2).val()) || $("#" + id2).val() == ""){
           		$("#" + id1).html("");
           }else {
               $("#" + id1).html(msg);
               if(touch){
	               layer.alert("请填写正确的信息", {shade: 0,skin : 'skin1'}, function(index) { 
					   layer.close(index);
               		   $("#" + id2).focus();
				       $("#save").removeAttr("disabled");
				   });
               }
           } 
	}
	
	//decimal(4,1)form表单提交验证
	function VDblur2(id1, msg, id2, touch) {
		reg=/^(?:[1-9]\d{0,2}|0)(?:\.\d{1})?$/;
           if(reg.test($("#"+id2).val()) || $("#" + id2).val() == ""){
           		$("#" + id1).html("");
           }else {
               $("#" + id1).html(msg);
               if(touch){
	               layer.alert("请填写正确的信息", {shade: 0,skin : 'skin1'}, function(index) { 
					   layer.close(index);
               		   $("#" + id2).focus();
				       $("#save").removeAttr("disabled");
				   });
               }
           } 
	}
	
	//decimal(3,1)form表单提交验证
	function VDblur3(id1, msg, id2, touch) {
		reg=/^(?:[1-9]\d{0,1}|0)(?:\.\d{1})?$/;
           if(reg.test($("#"+id2).val()) || $("#" + id2).val() == ""){
           		$("#" + id1).html("");
           }else {
               $("#" + id1).html(msg);
               if(touch){
	               layer.alert("请填写正确的信息", {shade: 0,skin : 'skin1'}, function(index) { 
					   layer.close(index);
               		   $("#" + id2).focus();
				       $("#save").removeAttr("disabled");
				   });
               }
           } 
	}
	
	//decimal(2,1)form表单提交验证
	function VDblur6(id1, msg, id2, touch) {
		reg=/^(?:[1-9]\d{0,0}|0)(?:\.\d{1})?$/;
           if(reg.test($("#"+id2).val()) || $("#" + id2).val() == ""){
           		$("#" + id1).html("");
           }else {
               $("#" + id1).html(msg);
               if(touch){
	               layer.alert("请填写正确的信息", {shade: 0,skin : 'skin1'}, function(index) { 
					   layer.close(index);
               		   $("#" + id2).focus();
				       $("#save").removeAttr("disabled");
				   });
               }
           } 
	}
	
	//decimal(4,2)form表单提交验证
	function VDblur7(id1, msg, id2, touch) {
		reg=/^(?:[1-9]\d{0,1}|0)(?:\.\d{1,2})?$/;
           if(reg.test($("#"+id2).val()) || $("#" + id2).val() == ""){
           		$("#" + id1).html("");
           }else {
               $("#" + id1).html(msg);
               if(touch){
	               layer.alert("请填写正确的信息", {shade: 0,skin : 'skin1'}, function(index) { 
					   layer.close(index);
               		   $("#" + id2).focus();
				       $("#save").removeAttr("disabled");
				   });
               }
           } 
	}
	
	//decimal(6,2)onblur光标验证
	function VDblur5_(id1, msg, id2, touch) {
		reg=/^(?:[1-9]\d{0,3}|0)(?:\.\d{1,2})?$/;
           if(reg.test($("#"+id2).val()) || $("#" + id2).val() == ""){
           		$("#" + id1).html("");
           }else {
               $("#" + id1).html(msg);
               if(touch){
               		   $("#" + id2).focus();
				       $("#save").removeAttr("disabled");
               }
           } 
	}
	
	//decimal(5,2)onblur光标验证
	function VDblur4_(id1, msg, id2, touch) {
		reg=/^(?:[1-9]\d{0,2}|0)(?:\.\d{1,2})?$/;
           if(reg.test($("#"+id2).val()) || $("#" + id2).val() == ""){
           		$("#" + id1).html("");
           }else {
               $("#" + id1).html(msg);
               if(touch){
               		   $("#" + id2).focus();
				       $("#save").removeAttr("disabled");
               }
           } 
	}

	//decimal(5,1)onblur光标验证
	function VDblur_(id1, msg, id2, touch) {
		reg=/^(?:[1-9]\d{0,3}|0)(?:\.\d{1})?$/;
           if(reg.test($("#"+id2).val()) || $("#" + id2).val() == ""){
           		$("#" + id1).html("");
           }else {
               $("#" + id1).html(msg);
               if(touch){
               		   $("#" + id2).focus();
				       $("#save").removeAttr("disabled");
               }
           } 
	}
	
	//decimal(4,1)onblur光标验证
	function VDblur2_(id1, msg, id2, touch) {
		reg=/^(?:[1-9]\d{0,2}|0)(?:\.\d{1})?$/;
           if(reg.test($("#"+id2).val()) || $("#" + id2).val() == ""){
           		$("#" + id1).html("");
           }else {
               $("#" + id1).html(msg);
               if(touch){
               		   $("#" + id2).focus();
				       $("#save").removeAttr("disabled");
               }
           } 
	}
	
	//decimal(3,1)onblur光标验证
	function VDblur3_(id1, msg, id2, touch) {
		reg=/^(?:[1-9]\d{0,1}|0)(?:\.\d{1})?$/;
           if(reg.test($("#"+id2).val()) || $("#" + id2).val() == ""){
           		$("#" + id1).html("");
           }else {
               $("#" + id1).html(msg);
               if(touch){
               		   $("#" + id2).focus();
				       $("#save").removeAttr("disabled");
               }
           } 
	}
	
	//decimal(2,1)onblur光标验证
	function VDblur6_(id1, msg, id2, touch) {
		reg=/^(?:[1-9]\d{0,0}|0)(?:\.\d{1})?$/;
           if(reg.test($("#"+id2).val()) || $("#" + id2).val() == ""){
           		$("#" + id1).html("");
           }else {
               $("#" + id1).html(msg);
               if(touch){
               		   $("#" + id2).focus();
				       $("#save").removeAttr("disabled");
               }
           } 
	}
	
	//decimal(4,2)onblur光标验证
	function VDblur7_(id1, msg, id2, touch) {
		reg=/^(?:[1-9]\d{0,1}|0)(?:\.\d{1,2})?$/;
           if(reg.test($("#"+id2).val()) || $("#" + id2).val() == ""){
           		$("#" + id1).html("");
           }else {
               $("#" + id1).html(msg);
               if(touch){
               		   $("#" + id2).focus();
				       $("#save").removeAttr("disabled");
               }
           } 
	}
	
	function VDblurF(id, msg){
		if($("#" + id ).html() == msg){
			$("#save").removeAttr("disabled");
		    return;
		}
	}
	
	function firstChecked(id1, id2) {
		if($("#" + id1 + " label:first-child input[type='checkbox']").attr("checked")){
			$("#" + id1 + " label:first-child").siblings('label').find('input').attr("disabled", true);
			$("#" + id2).attr("disabled",true);
		}
	}
	
	function checkboxClick(id1, name, id2) {
		$("#"+ id1 + ' input[name="'+ name +'"]').click(function () {
			var value = $(this).val(),
				state = $(this).prop("checked");
			
			if(value == '1') {
				if(state) {
					$(this).parent().siblings('label').find('input').attr("checked", false);
					$(this).parent().siblings('label').find('input').attr("disabled", true);
					$("#"+ id2).val("");
					$("#"+ id2).attr("disabled", true);
				}else {
					$(this).parent().siblings('label').find('input').removeAttr("disabled");
					inputInitLast(id1, id2);
				}
			}
			
		});
	}
		
	function inputAbled(a, b) {
		$("#" + a +" label").last().find("input").click(function() {
			if($(this).is(':checked')) {
				$("#" + b).removeAttr("disabled");
			}else if(!$(this).is(':checked')){
				$("#" + b).val("");
				$("#" + b).attr("disabled", true);
			}else {
				$("#" + b).val("");
				$("#" + b).attr("disabled", true);
			}
		});
	}
/* 	function firstinputAbled(a, b) {
		$("#" + a +" label").first().find("input").click(function() {
			if($(this).is(':checked')) {
				$("#" + b).val("");
				$("#" + b).attr("disabled", true);
			}
		});
		$("#" + a +" label").last().find("input").click(function() {
			if($(this).is(':checked')) {
				$("#" + b).removeAttr("disabled");
			}else if(!$(this).is(':checked')){
				$("#" + b).val("");
				$("#" + b).attr("disabled", true);
			}else {
				$("#" + b).val("");
				$("#" + b).attr("disabled", true);
			}
		});
	} */
	
	function inputInit(a, b) {
	 if($("#" + a +" label").first().find("input").is(':checked')){
			$("#" + b).attr("disabled", true);
		}else if($("#" + a +" label").last().find("input").is(':checked')){
			$("#" + b).removeAttr("disabled");
		}else {
			$("#" + b).attr("disabled", true);
		} 
	}
	
	function inputInitLast(a, b) {
	 if(!$("#" + a +" label").last().find("input").is(':checked')){
		$("#" + b).attr("disabled", true);
		}else {
			$("#" + b).removeAttr("disabled");
		} 
	}
	
	function initTizhi(id1, id2) {
		if(!$("#" + id1 + " input").is(':checked') || $("#" + id1 + " input[value = '3' ]").is(':checked') ){
			$("#" + id2 + " input").attr("disabled",true);
		}else {
			$("#" + id2 + " input").removeAttr("disabled");
		}
	}
	
	function tizhiDisabled(name, id) {
		$('input[name="'+ name +'"]').click(function() {
			if($(this).val() == 1 || $(this).val() == 2 ) {
				$("#" + id + " input").removeAttr("disabled");
			}else {
				$("#" + id).last().find("input").val("");
				$("#" + id + " input").attr("checked",false);
				$("#" + id + " input").attr("disabled",true);
			}
		});
	}
	
	function radiuDisabled(name, id, f, t) {
		$('input[name="'+ name +'"]').click(function() {
			if($(this).val() == f) {
				$("#" +id).val("");
				$("#" +id).attr("disabled", "disabled");
			}else if ($(this).val() == t){
				$("#" +id).removeAttr("disabled");
			}else {
				$("#" +id).val("");
				$("#" +id).attr("disabled", "disabled");
			}
		});
	}

	function changeDisabled(isChecked, name) {
		isChecked? $('[name="' + name + '"]').removeAttr("disabled"):$('[name="' + name + '"]').attr("disabled", true).val("");
	}
	
	// 危险因素控制 输入框 disabled 控制
	function bd(obj) {
		var value = $(obj).val();
		var isChecked = $(obj).is(':checked');
		
		if(value == '5') {
			changeDisabled(isChecked, "phHealthexamdetail.riskFactor_Target");
		}else if(value == '6') {
			changeDisabled(isChecked, "phHealthexamdetail.riskFactor_Vaccine");
		}else if(value == '7') {
			changeDisabled(isChecked, "phHealthexamdetail.riskFactor_Other");
		}
		
	}
	// 页面初始化
	function init() {
		// 症状 无 其他禁用
		firstChecked("symptomWrap", "rest");
		firstChecked("cerebralVessel", "cerebralVessel-input");
		firstChecked("kidney", "kidney-input");
		firstChecked("heart", "heart-input");
		firstChecked("bloodPipe", "bloodPipe-input");
		firstChecked("eyePart", "eyePart-input");
		//妇科的乳腺情况
		firstChecked("breastCheck", "breastCheck-input");
		
		
		$("ul.s1 input[type='radio']:checked").click();
		$("ul.s2 input[type='radio']:checked").click();
		$('input[name="phHealthexamdetail.smokingState"]:checked').click();
		$('input[name="phHealthexamdetail.drinkFrequency"]:checked').click();
		$('input[name="phHealthexamdetail.occupation"]:checked').click();
		$('input[name="phHealthexamdetail.sportFrequency"]:checked').change();
		
		// 未选择按钮时部分输入框禁用
		if($("#temper label").last().find("input").is(':checked')){
			$('.temper-input input').attr("disabled", true);
		}else if($("#temper  input[name='phHealthexamdetail.sportFrequency']:checked").length == 0){
			$('.temper-input input').attr("disabled", true);
		}else {
			$('.temper-input input').removeAttr("disabled");
		}
		
		if($("#smoke-rate label").first().find("input").is(':checked')){
			$('.smokingWrap input').attr("disabled", true);
		}else if($("#smoke-rate  input[name='phHealthexamdetail.smokingState']:checked").length == 0){
			$('.smokingWrap input').attr("disabled", true);
		}else if($("#smoke-rate label").last().find("input").is(':checked')){
			$('.smokingWrap input').removeAttr("disabled");
			$('input[name="phHealthexamdetail.smokingEndAge"]').attr("disabled", true);
		}else {
			$('.smokingWrap input').removeAttr("disabled");
		}
		
		if($("#drink-rate label").first().find("input").is(':checked')){
			$('.drinkWrap input').attr("disabled", true);
		}else if($("#drink-rate  input[name='phHealthexamdetail.drinkFrequency']:checked").length == 0){
			$('.drinkWrap input').attr("disabled", true);
		}else {
			$('.drinkWrap input').removeAttr("disabled");
			if($("#wine label").last().find("input").is(':checked')){
				$('input[name="phHealthexamdetail.abstinenceAge"]').removeAttr("disabled");
			}else {
				$('input[name="phHealthexamdetail.abstinenceAge"]').attr("disabled", true);
			}
			if($("#wine-type label").last().find("input").is(':checked')){
				$('input[name="phHealthexamdetail.drinkOther_Desc"]').removeAttr("disabled");
			}else {
				$('input[name="phHealthexamdetail.drinkOther_Desc"]').attr("disabled", true);
			}
		}
		
		if($("#vocation label").first().find("input").is(':checked')){
			$('select[name="phHealthexamdetail.typeOfWork"]').attr("disabled", true);
			$('input[name="phHealthexamdetail.workTime"]').attr("disabled", true);
			$('.occupationWrap input').attr("disabled", true);
		}else if($("#vocation  input[name='phHealthexamdetail.occupation']:checked").length == 0){
			$('select[name="phHealthexamdetail.typeOfWork"]').attr("disabled", true);
			$('input[name="phHealthexamdetail.workTime"]').attr("disabled", true);
			$('.occupationWrap input').attr("disabled", true);
		}else {
			$('select[name="phHealthexamdetail.typeOfWork"]').removeAttr("disabled");
			$('input[name="phHealthexamdetail.workTime"]').removeAttr("disabled");
			
		//防护措施输入框禁用
		inputInit("chemicalGuard", "chemicalGuard-input");
		inputInit("physicalGuard", "physicalGuard-input");
		inputInit("radiogenGuard", "radiogenGuard-input");
		inputInit("dustGuard", "dustGuard-input");
		inputInit("toxicOtherGuard", "toxicOtherGuard-input");
			
		}
		
		if($("#healthEvaluate label").first().find("input").is(':checked')){
			$('#healthEvaluate p input').attr("disabled", true);
		}else if($("#healthEvaluate label").last().find("input").is(':checked')){
			$('#healthEvaluate p input').removeAttr("disabled");
		}else {
			$('#healthEvaluate p input').attr("disabled", true);
		}
		
		if($("input[name='phHealthexamdetail.dentition']:checked").length == 0){
			$('#explain').attr("disabled", true);
		}else {
			$('#explain').removeAttr("disabled");
		}
		
		inputInitLast("symptomWrap", "rest");
		inputInit("fundus", "eye-input");
		inputInit("skin", "skin-input");
		inputInit("sclero", "sclero-input");
		inputInit("lymph", "lymph-input");
		inputInit("breathe-voice", "breathe-input");
		inputInit("lungRales", "lungRales-input");
		inputInit("murmur", "murmur-input");
		inputInit("pain", "pain-input");
		inputInit("block", "block-input");
		inputInit("hepatomegaly", "hepatomegaly-input");
		inputInit("splenomegaly", "splenomegaly-input");
		inputInit("moveSonant", "moveSonant-input");
		inputInit("anusTactus", "anusTactus-input");
		inputInit("cardiogram", "cardiogram-input");
		inputInit("x_RAY", "x_RAY-input");
		inputInit("b_Ultrasonic", "b_Ultrasonic-input");
		inputInit("cervicalSmear", "cervicalSmear-input");
		inputInitLast("cerebralVessel", "cerebralVessel-input");
		inputInitLast("kidney", "kidney-input");
		inputInitLast("heart", "heart-input");
		inputInitLast("bloodPipe", "bloodPipe-input");
		inputInitLast("eyePart", "eyePart-input");
		inputInitLast("breastCheck", "breastCheck-input");
		inputInit("nervousSystem", "nervousSystem-input");
		inputInit("otherSystem", "otherSystem-input");
		//妇科的情况
		inputInit("breastCheck", "breastCheck-input");
		inputInit("pudendumRadio", "pudendumRadio-input");
		inputInit("vaginaRadio", "vaginaRadio-input");
		inputInit("cervicalRadio", "cervicalRadio-input");
		inputInit("uteriRadio", "uteriRadio-input");
		inputInit("enclosureRadio", "enclosureRadio-input");
		
		//危险因素控制初始化
		var listRiskFactor = $("#riskFactor  input[name='phHealthexamdetail.riskFactor']:checked");
		if(listRiskFactor.length > 0){
			listRiskFactor.each(function(i, e) {
				var value = $(e).val();
				if(value == '5') {
					$('[name="phHealthexamdetail.riskFactor_Target"]').removeAttr("disabled");
				}else if(value == '6') {
					$('[name="phHealthexamdetail.riskFactor_Vaccine"]').removeAttr("disabled");
				}else if(value == '7') {
					$('[name="phHealthexamdetail.riskFactor_Other"]').removeAttr("disabled");
				}
			});
		}
		
		initTizhi("result-qixu", "healthGuide-qixu");
		initTizhi("result-yangxu", "healthGuide-yangxu");
		initTizhi("result-yinxu", "healthGuide-yinxu");
		initTizhi("result-tanshi", "healthGuide-tanshi");
		initTizhi("result-shire", "healthGuide-shire");
		initTizhi("result-xueyu", "healthGuide-xueyu");
		initTizhi("result-qiyu", "healthGuide-qiyu");
		initTizhi("result-tebing", "healthGuide-tebing");
		initTizhi("result-pinghe", "healthGuide-pinghe");
		
		
	}
	$(function(){
		
		// 输入框启用
		inputAbled("symptomWrap","rest");
		inputAbled("cerebralVessel","cerebralVessel-input");
		inputAbled("kidney","kidney-input");
		inputAbled("heart","heart-input");
		inputAbled("bloodPipe","bloodPipe-input");
		inputAbled("eyePart","eyePart-input");
		
		radiuDisabled("phHealthexamdetail.eyeground", "eye-input", 1, 2);
		radiuDisabled("phHealthexamdetail.skin", "skin-input", 1, 7);
		radiuDisabled("phHealthexamdetail.sclero", "sclero-input", 1, 4);
		radiuDisabled("phHealthexamdetail.lymph", "lymph-input", 1, 4);
		radiuDisabled("phHealthexamdetail.lungBreathSounds", "breathe-input", 1, 2);
		radiuDisabled("phHealthexamdetail.lungRales", "lungRales-input", 1, 4);
		radiuDisabled("phHealthexamdetail.murmur", "murmur-input", 1, 2);
		radiuDisabled("phHealthexamdetail.pain", "pain-input", 1, 2);
		radiuDisabled("phHealthexamdetail.block", "block-input", 1, 2);
		radiuDisabled("phHealthexamdetail.hepatomegaly", "hepatomegaly-input", 1, 2);
		radiuDisabled("phHealthexamdetail.splenomegaly", "splenomegaly-input", 1, 2);
		radiuDisabled("phHealthexamdetail.moveSonant", "moveSonant-input", 1, 2);
		radiuDisabled("phHealthexamdetail.anusTactus", "anusTactus-input", 1, 5);
		radiuDisabled("phHealthexamdetail.cardiogram", "cardiogram-input", 1, 2);
		radiuDisabled("phHealthexamdetail.x_RAY", "x_RAY-input", 1, 2);
		radiuDisabled("phHealthexamdetail.b_Ultrasonic", "b_Ultrasonic-input", 1, 2);
		radiuDisabled("phHealthexamdetail.cervicalSmear", "cervicalSmear-input", 1, 2);
		radiuDisabled("phHealthexamdetail.nervousSystem", "nervousSystem-input", 1, 2);
		radiuDisabled("phHealthexamdetail.otherSystem", "otherSystem-input", 1, 2);
		//妇科情况
		inputAbled("breastCheck", "breastCheck-input")
		radiuDisabled("phHealthexamdetail.pudendum", "pudendumRadio-input", 1, 2);
		radiuDisabled("phHealthexamdetail.vagina", "vaginaRadio-input", 1, 2);
		radiuDisabled("phHealthexamdetail.cervical", "cervicalRadio-input", 1, 2);
		radiuDisabled("phHealthexamdetail.uteri", "uteriRadio-input", 1, 2);
		radiuDisabled("phHealthexamdetail.enclosure", "enclosureRadio-input", 1, 2);
		
		
		$('input[name="phHealthexamdetail.healthEvaluate"]').click(function() {
			if($(this).val() == 1) {
				$('#healthEvaluate p input').val("");
				$('#healthEvaluate p input').attr("disabled", true);
			}else if ($(this).val() == 2){
				$('#healthEvaluate p input').removeAttr("disabled");
			}else {
				$('#healthEvaluate p input').attr("disabled", true);
			}
		});
		
		$('input[name="phHealthexamdetail.dentition"]').click(function() {
			$('#explain').removeAttr("disabled");
		});

		tizhiDisabled("phHealthexamdetail.TCM_QXZ", "healthGuide-qixu");
		tizhiDisabled("phHealthexamdetail.TCM_YXZ", "healthGuide-yangxu");
		tizhiDisabled("phHealthexamdetail.TCM_YIXZ", "healthGuide-yinxu");
		tizhiDisabled("phHealthexamdetail.TCM_TSZ", "healthGuide-tanshi");
		tizhiDisabled("phHealthexamdetail.TCM_SRZ", "healthGuide-shire");
		tizhiDisabled("phHealthexamdetail.TCM_XTZ", "healthGuide-xueyu");
		tizhiDisabled("phHealthexamdetail.TCM_QYZ", "healthGuide-qiyu");
		tizhiDisabled("phHealthexamdetail.TCM_TBZ", "healthGuide-tebing");
		tizhiDisabled("phHealthexamdetail.TCM_PHZ", "healthGuide-pinghe");
		
		//表单验证
		$("#physical-examination").validate();
		
		$("ul.s1 input[type='radio']").click(function() {
			var value = '',
				state1 = 0,
				state2 = 0,
				state3 = 0,
				all = $("ul.s1 input[type='radio']:checked");
			$(all).each(function(i, e) {
				value = $(e).val();
				
				if(value == '1') {
					state1++;
				}else if(value == '2') {
					state2++;
				}else {
					state3++;
				}
			});
			
			$("ul.s2 input[type='radio'][value='1']").removeAttr("disabled");
			$("ul.s2 input[type='radio'][value='2']").removeAttr("disabled");
			
			if(state1 >0) {
				$("ul.s2 input[type='radio'][value='1']").attr("disabled", true);
				$("ul.s2 input[type='radio'][value='2']").attr("disabled", true);
			}else if(state2 > 0) {
				$("ul.s2 input[type='radio'][value='1']").attr("disabled", true);
			}
			
		});
		
		$("ul.s2 input[type='radio']").click(function() {
			var value = $(this).val();
			
			$("ul.s1 input[type='radio'][value='1']").removeAttr("disabled");
			$("ul.s1 input[type='radio'][value='2']").removeAttr("disabled");
			
			if(value == '1') {
				$("ul.s1 input[type='radio'][value='1']").attr("disabled", true);
				$("ul.s1 input[type='radio'][value='2']").attr("disabled", true);
			}else if(value == '2') {
				$("ul.s1 input[type='radio'][value='1']").attr("disabled", true);
			}
		});
		// 首选项 无 其他禁用
		checkboxClick("symptomWrap", "phHealthexamdetail.symptom", "rest");
		checkboxClick("cerebralVessel", "phHealthexamdetail.cerebralVessel", "cerebralVessel-input");
		checkboxClick("kidney", "phHealthexamdetail.kidney", "kidney-input");
		checkboxClick("heart", "phHealthexamdetail.heart", "heart-input");
		checkboxClick("bloodPipe", "phHealthexamdetail.bloodPipe", "bloodPipe-input");
		checkboxClick("eyePart", "phHealthexamdetail.eyePart", "eyePart-input");
		//妇科的乳腺情况
		checkboxClick("breastCheck","phHealthexamdetail.breast", "breastCheck-input");
		
		/* // 症状 无 其他禁用
		$("#symptomWrap input[name='healthExam.phHealthexamdetail.symptom']").click(function () {
			var value = $(this).val(),
				state = $(this).prop("checked");
			
			if(value == '1') {
				if(state) {
					$(this).parent().siblings('label').find('input').attr("disabled", true);
					$("#rest").attr("disabled",true);
				}else {
					$(this).parent().siblings('label').find('input').removeAttr("disabled");
					inputInitLast("symptomWrap", "rest");
				}
			}
			
		}); */
		// 吸烟状况 无 其他禁用
		$('input[name="phHealthexamdetail.smokingState"]').click(function() {
			if($(this).val() == "1") {
				$('.smokingWrap input').attr("disabled", true);
			}else if($(this).val() == "3"){
				$('.smokingWrap input').removeAttr("disabled");
				$('input[name="phHealthexamdetail.smokingEndAge"]').attr("disabled", true);
			}else {
				$('.smokingWrap input').removeAttr("disabled");
			}
		});
		// 饮酒状况 无 其他禁用
		$('input[name="phHealthexamdetail.drinkFrequency"]').click(function() {
			if($(this).val() == "1") {
				$('.drinkWrap input').attr("disabled", true);
			}else {
				$('.drinkWrap input').removeAttr("disabled");
				if($("#wine label").last().find("input").is(':checked')){
					$('input[name="phHealthexamdetail.abstinenceAge"]').removeAttr("disabled");
				}else {
					$('input[name="phHealthexamdetail.abstinenceAge"]').attr("disabled", true);
				}
				$("#wine label").last().find("input").click(function(){
						$('input[name="phHealthexamdetail.abstinenceAge"]').removeAttr("disabled");
				});
				$("#wine label").first().find("input").click(function(){
						$('input[name="phHealthexamdetail.abstinenceAge"]').val("");
						$('input[name="phHealthexamdetail.abstinenceAge"]').attr("disabled", true);
				});
				
				if($("#wine-type label").last().find("input").is(':checked')){
					$('input[name="phHealthexamdetail.drinkOther_Desc"]').removeAttr("disabled");
				}else {
					$('input[name="phHealthexamdetail.drinkOther_Desc"]').attr("disabled", true);
				}
				$("#wine-type label").last().find("input").click(function(){
					if($(this).is(':checked')) {
						$('input[name="phHealthexamdetail.drinkOther_Desc"]').removeAttr("disabled");
					}else {
						$('input[name="phHealthexamdetail.drinkOther_Desc"]').val("");
						$('input[name="phHealthexamdetail.drinkOther_Desc"]').attr("disabled", true);
					}
				});
			}
		});
		// 职业暴露情况 无 其他禁用
		$('input[name="phHealthexamdetail.occupation"]').click(function() {
			if($(this).val() == "1") {
				$('select[name="phHealthexamdetail.typeOfWork"]').attr("disabled", true);
				$('input[name="phHealthexamdetail.workTime"]').attr("disabled", true);
				$('.occupationWrap input').attr("disabled", true);
				$('input[name="phHealthexamdetail.workTime"]').val("");
				$('.occupationWrap input[type="text"]').val("");
				$('.occupationWrap input').attr("checked",false);
			}else {
				$('select[name="phHealthexamdetail.typeOfWork"]').removeAttr("disabled");
				$('input[name="phHealthexamdetail.workTime"]').removeAttr("disabled");
				$('.occupationWrap input').removeAttr("disabled");
				inputInit("chemicalGuard", "chemicalGuard-input");
				radiuDisabled("phHealthexamdetail.chemicalGuard", "chemicalGuard-input", 1, 2);
				inputInit("physicalGuard", "physicalGuard-input");
				radiuDisabled("phHealthexamdetail.physicalGuard", "physicalGuard-input", 1, 2);
				inputInit("radiogenGuard", "radiogenGuard-input");
				radiuDisabled("phHealthexamdetail.radiogenGuard", "radiogenGuard-input", 1, 2);
				inputInit("dustGuard", "dustGuard-input");
				radiuDisabled("phHealthexamdetail.dustGuard", "dustGuard-input", 1, 2);
				inputInit("toxicOtherGuard", "toxicOtherGuard-input");
				radiuDisabled("phHealthexamdetail.toxicOtherGuard", "toxicOtherGuard-input", 1, 2);
				
				//单选防护措施有无启用
				/* firstinputAbled("chemicalGuard", "chemicalGuard-input");
				firstinputAbled("physicalGuard", "physicalGuard-input");
				firstinputAbled("radiogenGuard", "radiogenGuard-input");
				firstinputAbled("dustGuard", "dustGuard-input");
				firstinputAbled("toxicOtherGuard", "toxicOtherGuard-input"); */
			}
		});
		
		// 保存
		$("#save").click(function(){
			var $form = $('#physical-examination'); 
			if(!$form.valid()) {
 				layer.alert("请填写正确的信息", {shade: 0,skin : 'skin1'}, function(index) { 
 					layer.close(index);
 					VDblur2_('HBA1C-error', '请输入一个介于 0 和 1000 之间且最多一位小数的值', 'HBA1C', 'be');
 					VDblur4_('HDL_C-error', '请输入一个介于 0 和 1000 之间且最多两位小数的值', 'HDL_C', 'be');
 					VDblur4_('LDL_C-error', '请输入一个介于 0 和 1000 之间且最多两位小数的值', 'LDL_C', 'be');
 					VDblur7_('TG-error', '请输入一个介于 0 和 100 之间且最多两位小数的值', 'TG', 'be');
 					VDblur4_('CHOL-error', '请输入一个介于 0 和 1000 之间且最多两位小数的值', 'CHOL', 'be');
 					/*numberRange("serumSodium", -32768, 32767);*/
 					VDblur5_('serumSodium-error', '请输入一个介于 0 和 10000之间且最多两位小数的值', 'serumSodium', 'be');
 					VDblur4_('serumPotassium-error', '请输入一个介于 0 和 1000 之间且最多两位小数的值', 'serumPotassium', 'be');
 					VDblur4_('BUN-error', '请输入一个介于 0 和 1000 之间且最多两位小数的值', 'BUN', 'be');
 					VDblur5_('CR-error', '请输入一个介于 0 和 10000之间且最多两位小数的值', 'CR', 'be');
 					VDblur_('CBIL-error', '请输入一个介于 0 和 10000 之间且最多一位小数的值', 'CBIL', 'be');
 					VDblur2_('TBIL-error', '请输入一个介于 0 和 1000 之间且最多一位小数的值', 'TBIL', 'be');
 					numberRange("ALB", -32768, 32767);
 					numberRange("AST", -32768, 32767);
 					numberRange("CPT", -32768, 32767);
 					VDblur_('urineMicroAlbumin-error', '请输入一个介于 0 和 10000 之间且最多一位小数的值', 'urineMicroAlbumin', 'be');
 					numberRange("platelet", -32768, 32767);
 					VDblur2_('leukocyte-error', '请输入一个介于 0 和 1000 之间且最多一位小数的值', 'leukocyte', 'be');
 					numberRange("hemoglobin", -32768, 32767);
 					VDblur4_('PGLU-error', '请输入一个介于 0 和 1000 之间且最多两位小数的值', 'PGLU', 'be');
 					VDblur4_('GLU-error', '请输入一个介于 0 和 1000 之间且最多两位小数的值', 'GLU', 'be');
 					numberRange("heartRate", -32768, 32767);
 					VDblur3_('rightCorrectVision-error', '请输入一个介于 0 和 100 之间且最多一位小数的值', 'rightCorrectVision', 'be');
 					VDblur3_('leftCorrectVision-error', '请输入一个介于 0 和 100 之间且最多一位小数的值', 'leftCorrectVision', 'be');
 					VDblur3_('rightVision-error', '请输入一个介于 0 和 100 之间且最多一位小数的值', 'rightVision', 'be');
 					VDblur3_('leftVision-error', '请输入一个介于 0 和 100 之间且最多一位小数的值', 'leftVision', 'be');
 					numberRange("workTime", -128, 127);
 					numberRange("drinkStartAge", -128, 127);
 					numberRange("abstinenceAge", -128, 127);
 					/*	numberRange("dailyDrink", -32768, 32767);*/
 					VDblur3_('dailyDrink-error', '请输入一个介于 0 和 100之间且最多一位小数的值', 'dailyDrink', 'be');
 					numberRange("smokingEndAge", -128, 127);
 					numberRange("smokingStartAge", -128, 127);
 					numberRange("dailySmoking", -32768, 32767);
 					numberRange("sportTotalTime", -128, 127);
 					numberRange("sportDuration", -32768, 32767);
 					numberRange("agedFeelingScore", -128, 127);
 					numberRange("agedCognitionScore", -128, 127);
 					VDblur4_('BMI-error', '请输入有效的身高体重', 'BMI', 'be');
 					VDblur_('waist-error', '请输入一个介于 0 和 10000 之间且最多一位小数的值', 'waist', 'be');
 					VDblur_('weight-error', '请输入一个介于 0 和 10000 之间且最多一位小数的值', 'weight', 'be');
 					VDblur_('height-error', '请输入一个介于 0 和 10000 之间且最多一位小数的值', 'height', 'be');
 					numberRange("rightDiastolic", -32768, 32767);
 					numberRange("rightSystolic", -32768, 32767);
 					numberRange("leftDiastolic", -32768, 32767);
 					numberRange("leftSystolic", -32768, 32767);
 					numberRange("respiratoryRate", -32768, 32767);
 					numberRange("pulseRate", -32768, 32767);
 					VDblur2_('bodyTemperature-error', '请输入一个介于 0 和 1000 之间且最多一位小数的值', 'bodyTemperature', 'be');
 					if($("#memeberName").val() == ""){
 						$("#memeberName").focus();
 					}
				});
				$("#save").removeAttr("disabled");
				return;
			}
			
			$(this).attr("disabled","disabled");
			
			VDblur2('bodyTemperature-error', '请输入一个介于 0 和 1000 之间且最多一位小数的值', 'bodyTemperature', 'be');
				if($("#bodyTemperature-error").html() == '请输入一个介于 0 和 1000 之间且最多一位小数的值'){
					$("#save").removeAttr("disabled");
				    return;
				}
			VDblur('height-error', '请输入一个介于 0 和 10000 之间且最多一位小数的值', 'height', 'be');
				if($("#height-error").html() == '请输入一个介于 0 和 10000 之间且最多一位小数的值'){
					$("#save").removeAttr("disabled");
				    return;
				}
			VDblur('weight-error', '请输入一个介于 0 和 10000 之间且最多一位小数的值', 'weight', 'be');
				if($("#weight-error").html() == '请输入一个介于 0 和 10000 之间且最多一位小数的值'){
					$("#save").removeAttr("disabled");
				    return;
				}
			VDblur('waist-error', '请输入一个介于 0 和 10000 之间且最多一位小数的值', 'waist', 'be');
				if($("#waist-error").html() == '请输入一个介于 0 和 10000 之间且最多一位小数的值'){
					$("#save").removeAttr("disabled");
				    return;
				}	
			VDblur4('BMI-error', '请输入有效的身高体重', 'BMI', 'be');
				if($("#BMI-error").html() == '请输入有效的身高体重'){
					$("#weight").val("");
					$("#height").val("");
					$("#save").removeAttr("disabled");
				    return;
				}
			VDblur3('dailyDrink-error', '请输入一个介于 0 和 100 之间且最多一位小数的值', 'dailyDrink', 'be');
				if($("#dailyDrink-error").html() == '请输入一个介于 0 和 100 之间且最多一位小数的值'){
					$("#save").removeAttr("disabled");
				    return;
				}
			VDblur3('leftVision-error', '请输入一个介于 0 和 100 之间且最多一位小数的值', 'leftVision', 'be');
				if($("#leftVision-error").html() == '请输入一个介于 0 和 100 之间且最多一位小数的值'){
					$("#save").removeAttr("disabled");
				    return;
				}	
			VDblur3('rightVision-error', '请输入一个介于 0 和 100 之间且最多一位小数的值', 'rightVision', 'be');
				if($("#rightVision-error").html() == '请输入一个介于 0 和 100 之间且最多一位小数的值'){
					$("#save").removeAttr("disabled");
				    return;
				}	
			VDblur3('leftCorrectVision-error', '请输入一个介于 0 和 100 之间且最多一位小数的值', 'leftCorrectVision', 'be');
				if($("#leftCorrectVision-error").html() == '请输入一个介于 0 和 100 之间且最多一位小数的值'){
					$("#save").removeAttr("disabled");
				    return;
				}	
			VDblur3('rightCorrectVision-error', '请输入一个介于 0 和 100 之间且最多一位小数的值', 'rightCorrectVision', 'be');
				if($("#rightCorrectVision-error").html() == '请输入一个介于 0 和 100 之间且最多一位小数的值'){
					$("#save").removeAttr("disabled");
				    return;
				}	
			VDblur4('GLU-error', '请输入一个介于 0 和 1000 之间且最多两位小数的值', 'GLU', 'be');
				if($("#GLU-error").html() == '请输入一个介于 0 和 1000 之间且最多两位小数的值'){
					$("#save").removeAttr("disabled");
				    return;
				}
			VDblur4('PGLU-error', '请输入一个介于 0 和 1000 之间且最多两位小数的值', 'PGLU', 'be');
				if($("#PGLU-error").html() == '请输入一个介于 0 和 1000 之间且最多两位小数的值'){
					$("#save").removeAttr("disabled");
				    return;
				}
			VDblur2('leukocyte-error', '请输入一个介于 0 和 1000 之间且最多一位小数的值', 'leukocyte', 'be');
				if($("#leukocyte-error").html() == '请输入一个介于 0 和 1000 之间且最多一位小数的值'){
					$("#save").removeAttr("disabled");
				    return;
				}
			VDblur('urineMicroAlbumin-error', '请输入一个介于 0 和 10000 之间且最多一位小数的值', 'urineMicroAlbumin', 'be');
				if($("#urineMicroAlbumin-error").html() == '请输入一个介于 0 和 10000 之间且最多一位小数的值'){
					$("#save").removeAttr("disabled");
				    return;
				}	
			VDblur2('TBIL-error', '请输入一个介于 0 和 1000 之间且最多一位小数的值', 'TBIL', 'be');
				if($("#TBIL-error").html() == '请输入一个介于 0 和 1000 之间且最多一位小数的值'){
					$("#save").removeAttr("disabled");
				    return;
				}	
			VDblur('CBIL-error', '请输入一个介于 0 和 10000 之间且最多一位小数的值', 'CBIL', 'be');
				if($("#CBIL-error").html() == '请输入一个介于 0 和 10000 之间且最多一位小数的值'){
					$("#save").removeAttr("disabled");
				    return;
				}	
			VDblur5('CR-error', '请输入一个介于 0 和 10000 之间且最多两位小数的值', 'CR', 'be');
				if($("#CR-error").html() == '请输入一个介于 0 和 10000 之间且最多两位小数的值'){
					$("#save").removeAttr("disabled");
				    return;
				}	
			VDblur4('BUN-error', '请输入一个介于 0 和 1000 之间且最多两位小数的值', 'BUN', 'be');
				if($("#BUN-error").html() == '请输入一个介于 0 和 1000 之间且最多两位小数的值'){
					$("#save").removeAttr("disabled");
				    return;
				}	
			VDblur5('serumSodium-error', '请输入一个介于 0 和 10000 之间且最多两位小数的值', 'serumSodium', 'be');
			if($("#serumSodium-error").html() == '请输入一个介于 0 和 10000 之间且最多两位小数的值'){
				$("#save").removeAttr("disabled");
			    return;
			}	
			VDblur4('serumPotassium-error', '请输入一个介于 0 和 1000 之间且最多两位小数的值', 'serumPotassium', 'be');
				if($("#serumPotassium-error").html() == '请输入一个介于 0 和 1000 之间且最多两位小数的值'){
					$("#save").removeAttr("disabled");
				    return;
			}
			VDblur4('CHOL-error', '请输入一个介于 0 和 1000 之间且最多两位小数的值', 'CHOL', 'be');
				if($("#CHOL-error").html() == '请输入一个介于 0 和 1000 之间且最多两位小数的值'){
					$("#save").removeAttr("disabled");
				    return;
				}
			VDblur7('TG-error', '请输入一个介于 0 和 100 之间且最多两位小数的值', 'TG', 'be');
				if($("#TG-error").html() == '请输入一个介于 0 和 100 之间且最多两位小数的值'){
					$("#save").removeAttr("disabled");
				    return;
				}	
			VDblur4('LDL_C-error', '请输入一个介于 0 和 1000 之间且最多两位小数的值', 'LDL_C', 'be');
				if($("#LDL_C-error").html() == '请输入一个介于 0 和 1000 之间且最多两位小数的值'){
					$("#save").removeAttr("disabled");
				    return;
				}
			VDblur4('HDL_C-error', '请输入一个介于 0 和 1000 之间且最多两位小数的值', 'HDL_C', 'be');
				if($("#HDL_C-error").html() == '请输入一个介于 0 和 1000 之间且最多两位小数的值'){
					$("#save").removeAttr("disabled");
				    return;
				}
			VDblur2('HBA1C-error', '请输入一个介于 0 和 1000 之间且最多一位小数的值', 'HBA1C', 'be');
				if($("#HBA1C-error").html() == '请输入一个介于 0 和 1000 之间且最多一位小数的值'){
					$("#save").removeAttr("disabled");
				    return;
				}	
			$form.submit();
// 			$.ajax({
// 				   type: "POST",
// 				   url:  "publicHealthAction!addOrModifyPhysical",
// 				   data: $("form").serialize(),
// 				   success: function(msg){
// 					   if(typeof(msg)==='object'){
// 						   if(msg && msg.status) {
// 							   layer.alert("保存成功！", {shade: 0,skin : 'skin1',end: function(index){success(index);}}, function(index) {success(index);});
// 						   }else {
// 							   layer.alert(msg.content, {shade: 0,skin : 'skin1'});
// 							   $("#save").removeAttr("disabled");
// 						   }
// 					   }else{
// 						   layer.alert("登录信息过期，请重新登录", {shade: 0,skin : 'skin1'}, function(index) {
// 							   layer.close(index);
// 							   location.href="..";
// 						   });
// 					   }
// 				   }
// 				})
			
		});
		
		// 初始化 体质指数
		calcBMI('phHealthexamdetail.height', 'phHealthexamdetail.weight', 'phHealthexamdetail.BMI', 'bmides', 'BMI-error');
		
		init();
	});