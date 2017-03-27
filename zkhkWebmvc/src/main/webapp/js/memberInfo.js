/*memberInfoView.jsp*/

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
			beforeClick: checkedBox,
			onCheck: onCheck
		}
	};
	
	function openAddFamily(){
		if(!cardValidate) {
			alert("请输入正确的智能卡号");
			return;
		}
		openPage('选择会员','member');
	}

	//根据会员类型名称改变会员类型说明
	function changeMemId(){
		var memId = $("#memId").val();
		if(memId != 0){
//			url= baseUrl + "/mem/MemberAction_getOmesInfo?memId=" + memId;
//			$.post(url,function(data){
//				var memDesc=$("#memDesc");
//				memDesc.val(data);
//			});
			checkMemType(memId);
		}
	}
	
	//验证添加的家庭默认会员类型成员是否超限
	function checkMemType(memId){
		if(memId>0){
			var scope = getScope();
			if(scope.orgsConfig.experienceNum != null){
				var exceedNo = [];
				$.each(scope.cardNos, function(index, cardNo){
					var count = scope.orgsConfig.memId == memId ? 1 : 0;
					$.each(scope.familyMembers, function(index2, f){
						if(f.memId == scope.orgsConfig.memId){
							$.each(f.cardNos, function(index3, c){
								if(c.checked && c.cardNo == cardNo.cardNo){
									count++;
									return false;
								}
							});
						}
					});
					if(count > scope.orgsConfig.experienceNum)
						exceedNo.push(cardNo.cardNo);
				});
				if(exceedNo.length > 0){
					if(scope.orgsConfig.experienceNum == 0 && scope.orgsConfig.isDisplayCard==1)
						alert("当前智能卡号下不允许添加【" + $('#memId option[value="' + scope.orgsConfig.memId + '"]').text() + "】成员");
					else
						alert("智能卡号【" + exceedNo.join("；") + "】已关联" + scope.orgsConfig.experienceNum + "个【" + $('#memId option[value="' + scope.orgsConfig.memId + '"]').text() + "】成员，不可再添加！")
					return false;
				}
			}
			return true;
		}else{
			alert('请选择会员类型');
			$("#memId").focus();
			return false;
		}
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
					   $("#tab-ul a").last().tab('show');
               		   $("#" + id2).focus();
                   }
        	   }
           }else {
               $("#" + id1).html(msg);
               if(touch){
				   $("#tab-ul a").last().tab('show');
	               $("#" + id2).focus();
               }
           } 
	}
	
	function isReturn(url){
		layer.confirm('您当前信息未保存，确定要返回吗？', {
				title : '提示信息',
				skin : 'skin1',
				shade : 0,
				btn : [ '确定', '取消' ]
			}, function(){
				window.location.href = url;
			}, function(){
				layer.close();
			});
	}
	
	$(function(){
		//会员信息查看页面不可编辑
		if(!isEdit){
			$(".table tr input").attr("readonly", true);
			$(".table tr select, .diagTime, .table button, #fieldName").attr("disabled", true);
			$(".table tr input[type='radio'], .table tr input[type='checkbox']").attr("disabled", true);
			$("#editImg label").addClass("editImg-btn");
			$(".btnshow").hide();
	        $(".btnhide").show().attr("disabled", false).css("cursor","default");
		}
		//会员疾病史选中疾病名称的功能
		var objs = $('tr[id^="disease_"]');
		var hyp_is_abled = $("#hyp_is_abled").val();
		var dia_is_abled = $("#dia_is_abled").val();
		
		for(var i=0;i<objs.length;i++){
			var id = $(objs[i]).attr("id");
			var id_dr = id.replace("disease","dict");
			var name = $("#"+id_dr).next().val();
			
			$("#"+id_dr).attr("checked","checked");

			if(name == "高血压" && hyp_is_abled == "true") {
				$("#"+id_dr).attr("disabled","disabled");
			}
			if(name == "糖尿病" && dia_is_abled == "true") {
				$("#"+id_dr).attr("disabled","disabled");
			}
			
			if(name=='其他'){
				var index = id.substring(8);
				var other_val = $("#hidDisName_"+index).val();
				$("#showDisName_"+index).removeAttr("disabled").attr("name","diseasesHistoryList["+index+"].diseasename");
				$("#hidDisName_"+index).removeAttr("name");
				$("#hidDict_"+index).val(other_val);
			}
		}
		// 加载Tree数据
		getData();
		
		//会员状态图片切换
		$("#useTag").change(function(){
			var useTag = $("#useTag").val();
			if(useTag == "T"){
				$("#statusImg").attr("src", baseUrl + "/img/normal.png");
			}else{
				$("#statusImg").attr("src", baseUrl + "/img/frozen.png");
			}
		});
		
		$("#memId").change(changeMemId);

		/*返回按钮功能
		 * $("#return").click(function(){
				window.history.go(-1);
          }); */
		
		/*$("input[name='tel'],input[name='email'],input[name='idCard']").change(function(){
			checkAccountUnique([this]);
		});*/
//		input[name='tel'],input[name='email'],
		$("input[name='idcard']").blur(function(){
			checkAccountUnique([this]);
		});
	});
	
	var errorMsgColor ="color:red";		//(样式)错误消息的颜色
	var firstMsgColor = "color: #888";
	var haveError;
	var errorMsgColor ="color:red";		//(样式)错误消息的颜色
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
	
	//姓名简码不为汉字
	function CheckChinese(val){
		var reg = new RegExp("[\\u4E00-\\u9FFF]+","g");
		if(reg.test(val)){
			alert("姓名简码不能汉字!");
			$("#tab-ul a").first().tab('show');
			$("input[name='memNameCode']").val('').focus();
			return false;
		}else {
			return true;
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
				/* $(object).next().text("长度不对！").attr("style",errorMsgColor); */
				alert("手机号格式输入错误,请重新输入");
				return false;
			}
		}
	}
		
	//验证联系人手机号码格式、长度是否符合要求。
	function isRelatePhone(object) {
		checkInit(object);
		var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|18[0-9]|17[0-9])+\d{8})$/;
		if ($.trim($(object).val()).length == 11) {
			if(!myreg.test($(object).val())){
				/*$(object).next().text("格式错误！").attr("style",errorMsgColor);*/
				alert("手机号格式输入错误,请重新输入");
				$("#addSubmint").attr("disabled", true);
				submitFlag.phone = false;
				$(object).focus();
				return false;
			}
		}else if($.trim($(object).val()).length == 0){
			return true;
		}else {
			/*$(object).next().text("长度不对！").attr("style",errorMsgColor);*/
			alert("手机号格式输入错误,请重新输入");
			$("#addSubmint").attr("disabled", true);
			submitFlag.phone = false;
			$(object).focus();
			return false;
		}
	}
	
	//邮箱验证
	function regularExpression(object,msg,myReg){
		checkInit(object);
		if(!myReg.test($(object).val())){
			$(object).next().text(msg).attr("style",errorMsgColor);
			haveError = true;
			$("#addSubmint").attr("disabled", true);
			return false;
		}else{
			supplyMsg(object);
			$("#addSubmint").attr("disabled", false);
			return true;
		}
	}
	function isEmail(object){
		if($(object).val()) {
			var myReg =/^.+\@(\[?)[a-zA-Z0-9\-\.]+\.([a-zA-Z]{2,3}|[0-9]{1,3})(\]?)$/;
			return regularExpression(object,"格式错误！",myReg);
		} else {
			$(object).next().html("");
		}
	}
	//把身份证上的出生日期赋值到出生日期输入框中
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
		}else {
			$("input:radio[name=sexual]").prop('disabled',true);
			$("input[name=birthDate]").prop('disabled',true);
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
		obj = obj.toUpperCase();
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
	   /* if(!(/[0-9]{4}-[0-9]{2}-[0-9]{2}$/).test($(object).val())){*/
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
	//验证手机号、邮箱、身份证账号唯一性
	function checkAccountUnique(nodes){
			var data = {}, flag = false;
			for(var i = 0; i < nodes.length; i++){
				if($.trim(nodes[i].value).length > 0){
					data[nodes[i].name] = nodes[i].value;
					if($.Object.count.call(data) > 0){
						data.memberid = $("input[name='memberid']").val();
						$.ajax({
							  url: baseUrl + "/member/checkUnique",
							  async: false,
							  data: data,
							  success: function(msg){
								  if(typeof(msg)==='object'){
									  flag = msg.status;
									  if(!flag){
										  alert(msg.content);
										  $("input[name='"+msg.data+"']").focus().removeAttr("readonly");
									  }
										/*$("#tab-ul a").first().tab('show');*/
								  }else{
								     layer.alert("登录信息过期，请重新登录", {shade: 0,skin : 'skin1',end: function(index){
								  		   layer.close(index);
								  		   window.top.location.href="..";
								  	   }}, function(index) {
								  		   layer.close(index);
								  		   window.top.location.href="..";
								     });
								  }
							  }
							});
						return flag;
					}
				}
			}
			return true;
	}
	//验证紧急联系人姓名
	function contact(){
		var flag = true;
    	$(".name").find("input").each(function(v, u){
    		var xinm = u.value;
			if(xinm == ''){
	    		flag = false;
	    		return false; 
	    	}
		})
		return flag;
    }
	
	function check(){
		if(!checkMemType($("#memId").val()))
			return false;
		//必填
		if(!checkedRequired())
			return false;
		
		/*if($.trim($("#simple_name").val()) == ''){
			alert("姓名简码不能为空!");
			$("#tab-ul a").first().tab('show');
			$("#simple_name").focus();
			return false;
		}*/
		if($("input[name='memname']").next().text() == '输入中英文和"."'){
			alert('姓名只能输入中英文和"."');
			$("#tab-ul a").first().tab('show');
			$("input[name='memname']").focus();
			return false;
		}
		if(!CheckChinese($("input[name='memNameCode']").val()))
			return false;
		/*if($.trim($("input[name='memName']").val()).length==0 ){
			checkInit($("input[name='memName']"));
				$("input[name='memName']").next().text("必须填写").attr("style",errorMsgColor);
			haveError = true;
			$("input[name='memName']").focus();
			return false;
		}*/
		
		/*if($.trim($("input[name='omemCardNos[{{$index}}].cardNo']").val()).length==0 ){
			alert("请填写智能卡号");
			$("input[name='omemCardNos[{{$index}}].cardNo']").focus();
			return false;
		}*/
		if($("input[name='tel']").val()){
			var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|18[0-9]|17[0-9])+\d{8})$/;
			if ($("input[name='tel']").val().trim().length == 11) {
				if (!myreg.test($("input[name='tel']").val())) {
					/*$("input[name='tel']").next().text("格式错误！").attr("style",errorMsgColor);*/
					alert("手机号格式输入错误,请重新输入");
					$("#tab-ul a").first().tab('show');
					$("input[name='tel']").focus();
					return false;
				}
			}else {
				/*$("input[name='tel']").next().text("长度不对！").attr("style",errorMsgColor);*/
				alert("手机号格式输入错误,请重新输入");
				$("#tab-ul a").first().tab('show');
				$("input[name='tel']").focus();
				return false;
			}
		}else {
			$("input[name='mem2.tel']").next().text("");
		}
		/* if($.trim($("input[name='idCard']").val()).length==0){
		checkInit($("input[name='idCard']"));	
			alert("身份证号必须填写！");
			$("input[name='idCard']").focus();
		haveError = true;
		return false;
		}*/
		
		if(!checkIdCard($.trim($("input[name='idcard']").val()))){
			alert("身份证格式输入错误!");
			$("#tab-ul a").first().tab('show');
			$("input[name='idcard']").focus();
			return false;
		}
	    
	  	//验证手机号、邮箱、身份证账号唯一性
//		input[name='tel'],input[name='email'],
	    if(!checkAccountUnique($("input[name='idcard']")))
	    	return false;
	    
//			if($.trim($("input[name='mem2.height']").val()).length==0 ){
//				checkInit($("input[name='mem2.height']"));
//					$("input[name='mem2.height']").next().text("必须填写").attr("style",errorMsgColor);
//				haveError = true;
//				$("input[name='mem2.height']").focus();
//				return false;
//			}
	    if(!$.trim($("input[name='memGrpid']").val())){
	    	alert("请选择会员分组");
	    	$("#tab-ul a").first().tab('show');
			$("#position").focus();
			return false;
		}
	    
    	if(!contact()){
    		alert("请输入联系人姓名！");
	    	$("#other-information").tab('show');
	    	$("#addbutton button").focus();
    		return false;
    	}
    	
    	if($(".valid").prev().val()){
    		var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(17[0-9]{1}))+\d{8})$/;
			if ($(".valid").prev().val().trim().length == 11) {
				if (!myreg.test($(".valid").prev().val())) {
					/*$("input[name='tel']").next().text("格式错误！").attr("style",errorMsgColor);*/
		    		$("#other-information").tab('show');
					alert("手机号格式输入错误,请重新输入");
		    		$("#addbutton button").focus();
					return false;
				}
			}else {
				/*$("input[name='tel']").next().text("长度不对！").attr("style",errorMsgColor);*/
	    		$("#other-information").tab('show');
				alert("手机号格式输入错误,请重新输入");
	    		$("#addbutton button").focus();
				return false;
			}
		}
	    
		if($.trim($("input[name='physical.height']").val())<0 ){
			checkInit($("input[name='physical.height']"));
			$("input[name='physical.height']").next().text("不能为负").attr("style",errorMsgColor);
			haveError = true;
			$("#tab-ul a").last().tab('show');
			$("input[name='physical.height']").focus();
			return false;
		}else {
			$("input[name='physical.height']").next().text("");
		}
		
		if(!validateHeight($('input[name="physical.height"]'))){
			$("#tab-ul a").last().tab('show');
			$('input[name="physical.height"]').focus();
			return false;				
		}
//			if($.trim($("input[name='mem2.weight']").val()).length==0 ){
//				checkInit($("input[name='mem2.weight']"));
//					$("input[name='mem2.weight']").next().text("必须填写").attr("style",errorMsgColor);
//				haveError = true;
//				$("input[name='mem2.weight']").focus();
//				return false;
//			}
		if($.trim($("input[name='physical.weight']").val())<0 ){
			checkInit($("input[name='physical.weight']"));
				$("input[name='physical.weight']").next().text("不能为负").attr("style",errorMsgColor);
			haveError = true;
			$("#tab-ul a").last().tab('show');
			$("input[name='physical.weight']").focus();
			return false;
		}else {
			$("input[name='physical.weight']").next().text("");
		}
	 	if($.trim($("input[name='physical.waist']").val())<0 ){
			checkInit($("input[name='physical.waist']"));
			$("input[name='physical.waist']").next().text("不能为负").attr("style",errorMsgColor);
			haveError = true;
			$("#tab-ul a").last().tab('show');
			$("input[name='physical.waist']").focus();
			return false;
		}else {
			$("input[name='physical.waist']").next().text("");
		}
		
		if($.trim($("input[name='physical.hip']").val())<0 ){
			checkInit($("input[name='physical.hip']"));
			$("input[name='physical.hip']").next().text("不能为负").attr("style",errorMsgColor);
			haveError = true;
			$("#tab-ul a").last().tab('show');
			$("input[name='physical.hip']").focus();
			return false;
		}else {
			$("input[name='physical.hip']").next().text("");
		}
		
		if($.trim($("input[name='physical.bloodh']").val())<0 ){
			checkInit($("input[name='physical.bloodh']"));
			$("input[name='physical.bloodh']").next().text("不能为负").attr("style",errorMsgColor);
			haveError = true;
			$("#tab-ul a").last().tab('show');
			$("input[name='physical.bloodh']").focus();
			return false;
		}else {
			$("input[name='physical.bloodh']").next().text("");
		}
		
		if(!validateBloodH($('input[name="physical.bloodh"]'))){
			$("#tab-ul a").last().tab('show');
			$('input[name="physical.bloodh"]').focus();
			return false;
		}
		
		if($.trim($("input[name='physical.bloodl']").val())<0 ){
			checkInit($("input[name='physical.bloodl']"));
			$("input[name='physical.bloodl']").next().text("不能为负").attr("style",errorMsgColor);
			haveError = true;
			$("#tab-ul a").last().tab('show');
			$("input[name='physical.bloodl']").focus();
			return false;
		}else {
			$("input[name='physical.bloodl']").next().text("");
		}

		if(!validateBloodL($('input[name="physical.bloodl"]'))){
			$("#tab-ul a").last().tab('show');
			$('input[name="physical.bloodl"]').focus();
			return false;				
		}
		
		if(parseInt($("input[name='physical.bloodh']").val()) <= parseInt($("input[name='physical.bloodl']").val())){
			alert("收缩压要大于舒张压!");
			$("#tab-ul a").last().tab('show');
			$('input[name="physical.bloodh"]').focus();
			return false;	
		}
		
		if($.trim($("input[name='physical.heartrate']").next().text()) != ''){
			alert("心率字段应为正整数!");
			$("#tab-ul a").last().tab('show');
			$("input[name='physical.heartrate']").focus();
			return false;
		}
		
		if($.trim($("input[name='physical.pulse']").next().text()) != ''){
			alert("脉搏字段应为正整数!");
			$("#tab-ul a").last().tab('show');
			$("input[name='physical.pulse']").focus();
			return false;
		}
		
		/*if($.trim($("input[name='mem2.triglyceride']").val())<0 ){
			checkInit($("input[name='mem2.triglyceride']"));
			$("input[name='mem2.triglyceride']").next().text("不能为负").attr("style",errorMsgColor);
			haveError = true;
			return false;
		}*/
		
		/*if($.trim($("input[name='mem2.fastingGlucose']").val())<0 ){
			checkInit($("input[name='mem2.fastingGlucose']"));
			$("input[name='mem2.fastingGlucose']").next().text("不能为负").attr("style",errorMsgColor);
			haveError = true;
			return false;
		}*/
		
		/*if($.trim($("input[name='mem2.totalCholesterol']").val())<0 ){
			checkInit($("input[name='mem2.totalCholesterol']"));
			$("input[name='mem2.totalCholesterol']").next().text("不能为负").attr("style",errorMsgColor);
			haveError = true;
			return false;
		}*/
		/*if($.trim($("input[name='mem2.densityLipop']").val())<0 ){
			checkInit($("input[name='mem2.densityLipop']"));
			$("input[name='mem2.densityLipop']").next().text("不能为负").attr("style",errorMsgColor);
			haveError = true;
			return false;
		}*/
		/*if($.trim($("input[name='mem2.ldlip']").val())<0 ){
			checkInit($("input[name='mem2.ldlip']"));
			$("input[name='mem2.ldlip']").next().text("不能为负").attr("style",errorMsgColor);
			haveError = true;
			return false;
		}*/

		digits2('physical.height','height_err');
		if($("#height_err").html() != ''){
			alert("身高字段应为正整数!");
			$("#tab-ul a").last().tab('show');
			$("input[name='physical.height']").focus();
		    return false;
		}
		
		VDblur4_('weight_err', '请输入三位整数且最多两位小数的值', 'physical.weight');
		if($("#weight_err").html() != ''){
			alert("体重字段应为正整数!");
			$("#tab-ul a").last().tab('show');
			$("input[name='physical.weight']").focus();
		    return false;
		}
		
		digits('waist','waist_err');
		if($("#waist_err").html() != ''){
			alert("腰围字段应为正整数!");
			$("#tab-ul a").last().tab('show');
			$("input[name='physical.waist']").focus();
		    return false;
		}
		
		digits('hip','hip_err');
		if($("#hip_err").html() != ''){
			alert("臀围字段应为正整数!");
			$("#tab-ul a").last().tab('show');
			$("input[name='physical.hip']").focus();
		    return false;
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

		if($.trim($("input[name='physical.uricacid']").next().text()) != ''){
			alert("尿酸字段应为正整数!");
			$("#tab-ul a").last().tab('show');
			$("input[name='physical.uricacid']").focus();
			return false;
		}
		
		if($.trim($("input[name='habit.weeknumtimes']").next().text()) != ''){
			alert("每周几次字段应为正整数!");
			$("#tab-ul a").last().tab('show');
			$("input[name='habit.weeknumtimes']").focus();
			return false;
		}
		
		
//		if(getCardNos().length === 0){
//			alert("请添加智能卡号");
//			return false;
//		}
		//验证图片上传格式，支持jpg、bmp、png
		if(!validateFile()) {
			return false;
		}
		getFamilyHistory(); // 获取家族病史
		return true;
	}
	
	//验证文件格式有效性
	function validateFile(){
		$("input[name='fieldName']").next().text("");
		if($("input[name='fieldName']").val()){
			var fileName = $("input[name='fieldName']").val().trim();
			
			var myregs = /[^\s]+\.(jpg|gif|png|bmp)/i;
			if (!myregs.test(fileName)) {
				$("input[name='fieldName']").next().text("上传图片格式错误！").attr("style",errorMsgColor);
				$("#tab-ul a").first().tab('show');
				$("input[name='fieldName']").focus();
				return false;
			}else {
				$("input[name='fieldName']").next().text("");
			}
			return true;
		}
		return true;
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
		
	
	//会员疾病史点击事件
	function onChecked(obj){
		 if(obj.checked){
			var val = $(obj).next("input").val();
			$(obj).parent().parent().parent().after("<tr id='disease_"+obj.value+"'><td colspan='2'>疾病名称：</td><td colspan='4'><input id='showDisName_"+obj.value+"' type='text' value="+val+" disabled='disabled' />"
					+ "<input id='hidDisId_"+obj.value+"' type='hidden' name='diseasesHistoryList["+obj.value+"].diseaseid' value="+obj.value+" /><input id='hidDisName_"+obj.value+"' type='hidden' name='diseasesHistoryList["+obj.value+"].diseasename' value="+val+" /></td>"
					+ "<td colspan='2'>确诊时间：</td><td colspan='4'><input  id='diagTime_"+obj.value+"' onchange='checkDate(this)' type='text' class='diagTime' name='diseasesHistoryList["+obj.value+"].diagtime'"
					+ "/></td></tr>");
			
			var dTval = $("#diag_"+obj.value).val();
			if(dTval != ''){
				$("#diagTime_"+obj.value).attr("value", dTval);
			}
			
			if(obj.value == 10){
				$("#showDisName_"+obj.value).removeAttr("disabled").attr("value",val).attr("name","diseasesHistoryList["+obj.value+"].diseasename");
				$("#hidDisName_"+obj.value).removeAttr("name");
			}
			setDiagTime();
		}else{
			$("#disease_"+obj.value).remove();
		};
	}
	
    $(function(){
		var idCard = $("#idCard").val();
     	if(idCard != null && idCard != ""){
     		getBirthDateFromIdCard(idCard);
     	}
	});
     
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
	
	function validateHeight(obj){
		if(isNaN(obj.val())){
			alert('只能输入数字');
			obj.val('');
			return false;
		}
	
		if(Number(obj.val()).length > 0 && Number((obj.val()) < 100 || Number(obj.val()) > 210)){
			alert("身高范围为100~210，范围已超出，请重新输入！");
			return false;
		}
		return true;
	}
	
	var cardValidate = true;
	var app = angular.module('app', [], function($httpProvider){
	}).directive('cardVerify', ['$http', function($http){
		return {
			restrict: "A",
			require: 'ngModel',
		    link: function(scope, element, attrs, ngModelController) {
		    	scope.$watch(attrs.ngModel, function(a, b, scope) {
		    		cardValidate = true;
		    		ngModelController.$setValidity('cardVerify', true);
		    		scope.c.error = '';
		    		if(!a || a.length == 0){
		    			scope.c.error = '智能卡号不能为空';
		    			cardValidate = false;
		    			ngModelController.$setValidity('cardVerify', false);
		    		}else if(!/^([1-9]{1}||[0-9]{2,18})$/.test(a)){
		    			scope.c.error = '请输入最多18位的数字';
		    			cardValidate = false;
		    			ngModelController.$setValidity('cardVerify', false);
		    		}else{
				    	angular.forEach(scope.cardNos, function(item, index){
				    		if(index != element.attr('index')){
				    			if(item.cardNo == element.val()){
				    				scope.c.error = '智能卡号已存在';
				    				cardValidate = false;
				    				ngModelController.$setValidity('cardVerify', false);
				    			}
				    		}
				    	});
				    	var flag;
				    	for(var i = scope.cardNos.length - 1; i > 0; i--){
				    		flag = 0;
				    		for(var j = i-1; j >= 0; j--){
				    			if((i == element.attr('index') || j == element.attr('index')) && scope.cardNos[element.attr('index')].error){
				    				flag = 2; 
				    				continue;
				    			}
				    			if(scope.cardNos[i].cardNo && scope.cardNos[i].cardNo == scope.cardNos[j].cardNo)
				    				flag = 1;
				    		}
				    		if(flag == 1){
				    			scope.cardNos[i].error = '智能卡号已存在';
				    		}else if(flag == 0){
				    			scope.cardNos[i].error = '';
				    		}
				    	}
				    	//有效值验证后台唯一性
			    		if(ngModelController.$valid){
				             transFn = function(data) {
				                return $.param(data);
				             },
				             postCfg = {
				                headers: { 'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
				                transformRequest: transFn
				             };
			    			 $http.post(baseUrl+ "/family/checkCardNoExist", {
			    				 cardNos: scope.c.cardNo,
			    				 'memberid': memberId
			    			 }, postCfg).success(function(reponse){
					            	if(typeof(reponse)==='object'){
					            		if(reponse.data && reponse.data.length > 0){
					            			scope.c.error = '智能卡号已存在';
					            			cardValidate = false;
					            			ngModelController.$setValidity('cardVerify', false);
					            		}
				                	}else{
				                	   layer.alert("登录信息过期，请重新登录", {shade: 0,skin : 'skin1',end: function(index){
					                		   parent.layer.close(index);
					                		   window.top.location.href="..";
				                		   }}, function(index) {
					                		   parent.layer.close(index);
					                		   window.top.location.href="..";
				                	   });
				                	}
					            });
			    		}
		    		}
		    	});
		    }
		}
	}]);

	app.controller('ctrl', function ($scope, $http) {
		$scope.required = {memname: false,tel: false,idcard: false,gender: false,birthDate: false};
		$scope.memType = {};
		$scope.contacts = [];
		$scope.digit = ['一','二','三','四','五','六','七','八','九','十'];
		$scope.activate = true;
		$scope.event = {
				removeFamilyMember: function(index){
					var $this = this;
					$scope.familyMembers.splice(index, 1);
					$.each($scope.cardNos, function(index, item){
						item.readonly = false;
						if($this.hasFamilyMember(item.cardNo)){
							item.readonly = true;
						}
					});
				},
				removeCardNo: function(index){
					if(this.hasFamilyMember($scope.cardNos[index].cardNo))
						alert("当前智能卡号已关联家庭成员，请先移除家庭成员");
					else{
						$scope.cardNos.splice(index, 1);
					}
				},
				addCardNo: function(invalid){
					if($scope.orgsConfig.isDisplayCard && invalid){
						alert("当前智能卡号输入有误,请输入正确的智能卡号后添加!")
					}else {
						$scope.cardNos.push({});
					};
				},
				removeContact: function(index){
					$scope.contacts.splice(index, 1);
				},
				addContact: function(){
					$scope.contacts.push({});
				},
				submit: function(invalid){
					if(check()){
						if($scope.orgsConfig.isDisplayCard && invalid){
							$scope.activate = true;
							$("#other-information").tab('show');
							$("#intelligence-number button").focus();
							return false;
						}else{
							$("form").submit();
						}
					}
				},
				cardValid: function(invalid){
					if($scope.orgsConfig.isDisplayCard && invalid){
						$scope.activate = true;
						$("#other-information").tab('show');
						$("#intelligence-number button").focus();
						return false;
					}
				},
				getMemTypes: function(){
					var memTypes = [];
					$("#memId").find("option").each(function(index, item){
						memTypes.push({name: item.innerText, value: parseInt(item.value)});
					});
					return memTypes;
				},
				hasFamilyMember: function(cardNo){
					var flag = false;
					angular.forEach($scope.familyMembers, function(v, index){
						angular.forEach(v.cardNos, function(item, index2){
							if(!flag && cardNo == item.cardNo){
								flag = true;
							}
						});
					});
					return flag;
				},
				init: function(){
					/*if(contacts.length === 0)
						contacts.push({});*/
					$scope.contacts = contacts;
					$scope.familyMembers = familyMembers;
//					if(cardNos.length === 0)
//						cardNos.push({});
					$scope.cardNos = cardNos;
					$scope.orgsConfig = orgsConfig == null ? {experienceNum: 3, memId: 0} : orgsConfig;
					$scope.roles = roles;
					if(!memberId && $scope.orgsConfig.memId){
						$("#memId").val($scope.orgsConfig.memId);
						changeMemId();
					}
					if(orgsConfig && orgsConfig.memMustSetItemArr){
						for(var i = 0; i < orgsConfig.memMustSetItemArr.length; i++){
							if(orgsConfig.memMustSetItemArr[i] == 1)
								$scope.required.memname = true;
							else if(orgsConfig.memMustSetItemArr[i] == 16)
								$scope.required.tel = true;
							else if(orgsConfig.memMustSetItemArr[i] == 2)
								$scope.required.gender = true;
							else if(orgsConfig.memMustSetItemArr[i] == 4)
								$scope.required.birthDate = true;
							else if(orgsConfig.memMustSetItemArr[i] == 8)
								$scope.required.idcard = true;
						}
					}
				}
		}
		$scope.$watch('familyMembers', function(newValue, oldValue) {
			angular.forEach($scope.familyMembers, function(item){
				if($('#memId option[value="' + item.memId + '"]').length > 0)
					item.memTypeName = $('#memId option[value="' + item.memId + '"]').text();
			});
		});
		$scope.event.init();
	});
	function getScope(){
		return angular.element(document.querySelector('[ng-controller=ctrl]')).scope();
	}
	function addFamilyMember(obj){
		if(obj.cardNos && obj.cardNos.length > 0){
			$.each(obj.cardNos, function(index, item){
				if(item.checked)
					item.readonly=true;
			});
		}
		var $scope = getScope();
		$scope.familyMembers.push(obj);
		$scope.$apply();
	}
	
	function getCardNos(){
		return getScope().cardNos;
	}
	function getMemTypes(){
		return getScope().event.getMemTypes();
	}
	
	function getRoles(){
		return getScope().roles;
	}
	
	function getRequired(){
		return getScope().required;
	}
	
	function checkIdCardUnique(idCard){
		var familyMembers = getScope().familyMembers;
		var flag = true;
		angular.forEach(familyMembers, function(item, index){
			if(item.familyMember.idcard === idCard){
				flag = false;
				return false;
			}
		});
		return flag;
	}
	function checkedRequired(){
		if(getRequired().memname && $.trim($("input[name='memname']").val()).length == 0){
			alert("姓名不能为空");
			$("#tab-ul a").first().tab('show');
			$("input[name='memname']").focus();
			return false;
		}
		if($.trim($("input[name='memname']").val()).length != 0 && $.trim($("input[name='memNameCode']").val()).length == 0){
			alert("姓名简码不能为空");
			$("#tab-ul a").first().tab('show');
			$("input[name='memNameCode']").focus();
			return false;
		}
		if($("input[name='sexual']:checked").val() != '') {
			$("input[name='gender']").val($("input[name='sexual']:checked").val());
		}
		if(getRequired().gender && $.trim($("input[name='sexual']:checked").val()).length == 0){
			alert("性别不能为空");
			$("#tab-ul a").first().tab('show');
			$("input[name='gender']").focus();
			return false;
		}
		if(getRequired().idcard && $.trim($("input[name='idcard']").val()).length == 0){
			alert("身份证号不能为空");
			$("#tab-ul a").first().tab('show');
			$("input[name='idcard']").focus();
			return false;
		}
		if($("input[name='birthDate']").val() != '') {
			$("input[name='birthdate']").val($("input[name='birthDate']").val());
		}
		if(getRequired().birthDate && $.trim($("input[name='birthdate']").val()).length == 0){
			alert("出生日期不能为空");
			$("#tab-ul a").first().tab('show');
			$("input[name='birthDate']").focus();
			return false;
		}
		if(getRequired().tel && $.trim($("input[name='tel']").val()).length == 0){
			alert("手机号不能为空");
			$("#tab-ul a").first().tab('show');
			$("input[name='tel']").focus();
			return false;
		}
		return true;
	}
	
	function getOmemIdCard(){
		return $("#idCard").val();
	}
	
	function getFamilyHistory() {
		var jsonStr = "";
		$(".checkbox-inline[title='familyHistory'] input[type='checkbox']:checked").each(function(){
			var other = "";
			if(this.value == 10) {
				other = $("#other_" + this.id).val();
			}
			var obj = '"relation":' + this.id.split("_")[0] + ', "diseaseID":' + this.value + ',"diseaseName":"' + other +'"';
			if(jsonStr == "") {
				jsonStr += "{" + obj + "}";
			} else {
				jsonStr += ",{" + obj + "}";
			}
		});
		$("#fmlHistories").val("[" + jsonStr + "]");
		return jsonStr;
	}
	
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
