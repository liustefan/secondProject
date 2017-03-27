	
var app = angular.module('app', [], function($httpProvider){
});

app.controller('ctrl', function ($scope, $http) {
	
	$scope.member = {
			role: 0,
			roleName : '',
			name: '',
			idCard: '',
			phone: '',
			gender: '',
			birthDate: '',
			memId:'',
			cardNos: [],
			msg: {active:false},
			status: 0
	};
	$scope.familyCard = {
			familyMemberid: 0,
			cardNos: [],
			cardNosStr: '',
			role : 0,
			roleName : '',
			familyMember: {}
	};
	$scope.familyMember = {
			idcard: '',
			memname: '',
			tel: '',
			gender : '',
	        birthdate:'',
			memberType:{}
	};
	$scope.memberType = {
			memname : '',
			memid:0
	};
	$scope.onOff = true;
	$scope.memTypes = [];
	$scope.required;
	
	$scope.event = {
			
			getOmemInfo: function(){
				if($scope.member.idCard && this.checkIdCard()){
					this.callRemote(baseUrl + '/member/memberByIdcard', {idCard: $scope.member.idCard}, function(reponse){
						if(reponse.status){
		                	angular.extend($scope.member, reponse.data,{status :2});
		                }else{
		                	angular.extend($scope.member, parent.getBirthDate($scope.member.idCard), {
//		                		memId: 	$scope.orgsConfig.memId, 
//		                		phone: '',
		                		status: 1
		                		})
		                }
					});
				}else if(!$scope.member.idCard){
					angular.extend($scope.member, {
						status: 0,
						gender: '',
						birthDate: '',
						msg: {active:false}
                		})
				}
			},
			callRemote: function(url, data, callback){
				$scope.onOff = false;
	            transFn = function(data) {
	                return $.param(data);
	            },
	            postCfg = {
	                headers: { 'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
	                transformRequest: transFn
	            };
	            $http.post(url, data, postCfg).success(function(reponse){
	            	if(typeof(reponse)==='object'){
	            		$scope.onOff = true;
	            		callback(reponse);
                	}else{
                	   parent.layer.alert("登录信息过期，请重新登录", {shade: 0,skin : 'skin1',end: function(index){
	                		   parent.layer.close(index);
	                		   window.top.location.href="..";
                		   }}, function(index) {
	                		   parent.layer.close(index);
	                		   window.top.location.href="..";
                	   });
                	}
	            });
			},
			confirm: function(){
				$scope.member.msg.active = true;
				if(this.checkAll()){
					if($scope.member.memId == $scope.orgsConfig.memId){//组织机构配置中设置了家庭成员默认类型数量
						if(parent.getScope().orgsConfig.experienceNum == null){
							this.confirmAndCloseLayer();
						}else if(parent.getScope().orgsConfig.experienceNum == 0 && parent.getScope().orgsConfig.isDisplayCard==1){
							alert("当前智能卡号下不允许添加【" + $('select[ng-model="member.memId"] option:selected').text() + "】成员");
						}else{
							var exceedNo = [];
							angular.forEach($scope.member.cardNos, function(cardNo){
								if(cardNo.checked){//选中的智能卡
									var count = $scope.orgsConfig.memId == parent.$("#memId").val() ? 1 : 0;//户主类型为默认类型时为1
									angular.forEach(parent.getScope().familyMembers, function(familyMember){//迭代已经添加的成员
										if(familyMember.familyMember.memberType.memid == $scope.member.memId){//相同的会员默认类型
											angular.forEach(familyMember.cardNos, function(c){
												if(c.checked == true && c.cardNo == cardNo.cardNo){
														count++;
														return false;
												}
											});
										}
									});
									if(count >= $scope.orgsConfig.experienceNum)
										exceedNo.push(cardNo.cardNo);
								}
							});
							if(exceedNo.length > 0){
								alert("智能卡号【" + exceedNo.join("；") + "】已关联" + $scope.orgsConfig.experienceNum + "个【" + $('select[ng-model="member.memId"] option:selected').text() + "】成员，不可再添加！")
							} else {
								this.confirmAndCloseLayer();
							}
						}
					}else{
						this.confirmAndCloseLayer();
					}
				}else {
					if($scope.required.memname && $("input[name='name']").val() == ''){
						$("input[name='name']").prop('disabled',false);
					}
					if($scope.required.idcard && $("input[name='idCard']").val() == ''){
						$("input[name='idCard']").prop('disabled',false);
					}
					if($scope.required.tel && $("input[name='phone']").val() == ''){
						$("input[name='phone']").prop('disabled',false);
					}
				}
			},
			confirmAndCloseLayer: function(){
				if(!$scope.required.idcard && !$scope.member.idCard && $scope.member.status != 2) {
					$scope.member.status = 1;
				}
				if(1 == $scope.member.status) {
					parent.layer.confirm('该会员不存在，确定新增该会员并且添加为家庭成员吗？', {
						title : '提示信息',
						skin : 'skin1',
						shade : 0,
						btn : [ '确定并添加', '取消' ]
					}, function(index) {
						parent.layer.close(index);
						$.ajax({
							url: baseUrl + "/member/addMemFamily",
							data:{idcard: $scope.member.idCard, 
								  gender: $scope.member.gender,
								  memname:$scope.member.name, 
							      tel:$scope.member.phone,
							      birthdate:$scope.member.birthDate,
							      memid:$scope.member.memId
							     },
						   type: "POST",
						   async:false,
						   success: function(data) {
			 		     	if(data.status) {
			 		     		$scope.member.familyMemberId = data.content;
			 		     		$scope.event.getFamilyMember();
			 		     		parent.addFamilyMember($scope.familyCard);
			 		     		parent.layer.closeAll();
			 		     	} else {
			 		     		alert(data.content);
			 		     	}
						}
						});
					});
				} else {
					this.getFamilyMember();
					parent.addFamilyMember($scope.familyCard);
					parent.layer.closeAll();
				}
				
//				var $this = this;
//				if($scope.member.status != 2){//需要注册会员
//					this.callRemote(
//							'../mem/MemberAction_saveOrUpdateMemberByAjax', 
//							{
//								'omem.memName': $scope.member.name,
//								'omem.idCard': $scope.member.idCard,
//								'omem.tel': $scope.member.phone,
//								'omem.gender': $scope.member.gender,
//								'omem.birthDate': $scope.member.birthDate,
//								'omem.memId': $scope.member.memId,
//								'omem.memGrpid': parent.$("#memberGroupId").val()
//							}, 
//							function(reponse){
//								if(reponse.status){
//									layer.msg(reponse.content, {
//									    time: 3000, 
//									}, function(){
//										angular.extend($scope.member, reponse.data,{status :2});
//					                	parent.addFamilyMember($scope.member);
//					                	$this.closeLayer();
//									})
//				                }else{
//				                	alert(reponse.content)
//				                	return;
//				                }
//							}
//						
//					);
//				}else{
//					parent.addFamilyMember($scope.member);
//					parent.layer.closeAll();
//				}
			},
			closeLayer: function(){
				parent.layer.close(parent.layer.getFrameIndex(window.name));
			},
			checkName: function(){
				if($scope.member.name != ""){
					$scope.member.msg.name = "";
					return true;
				}else if($scope.required.memname){
					$scope.member.msg.name = "姓名不能为空!";
					$("input[ng-model='member.name']").focus();
					return false;
				}
				return true;
			},
			checkIdCard: function(){
				if($scope.required.idcard && !$scope.member.idCard){
					$scope.member.msg.idCard = "身份证号不能为空!";
					$("input[ng-model='member.idCard']").focus();
					return false;
				}
				if(!$scope.required.idcard && !$scope.member.idCard)
					return true;
				if(validateIdCard($scope.member.idCard)){
					if(parent.getOmemIdCard() !== $scope.member.idCard){
						if(parent.checkIdCardUnique($scope.member.idCard)){
							$scope.member.msg.idCard = "";
							return true;
						}else{
							$scope.member.msg.idCard = "当前成员已存在!";
						}
					}else{
						$scope.member.msg.idCard = "不能添加自己为家庭成员!";
					}
				}else{
					$scope.member.msg.idCard = "身份证格式输入错误!";
				}
				return false;
			},
			checkRole: function(){
				if($scope.member.role > 0){
					$scope.member.msg.role = "";
					return true;
				}else{
					$scope.member.msg.role = "请选择成员关系!";
				}
				return false;
			},
			checkPhone: function(){
				if($scope.member.phone != "" && !/^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(17[0-9]{1}))+\d{8})$/.test($scope.member.phone)){
					$scope.member.msg.phone = "手机号格式输入错误!";
					return false;
				}else if($scope.required.tel && $scope.member.phone == ""){
					$scope.member.msg.phone = "手机号不能为空!";
					return false;
				}
				$scope.member.msg.phone = "";
				return true;
			},
			checkGender: function(){
				$scope.member.msg.gender = "";
				if($scope.required.gender && $scope.member.gender.length === 0){
					$scope.member.msg.gender = "请选择性别!";
					$("input[ng-model='member.gender']").focus();
					return false;
				}
				return true;
			},
			checkBirthDate: function(){
				if($scope.required.birthDate && !$scope.member.birthDate){
					$scope.member.msg.birthDate = "出生日期不能为空!";
					$("input[ng-model='member.birthDate']").focus();
					return false;
				}
				$scope.member.msg.birthDate = "";
				return true;
			},
			checkMemId: function(){
				if($scope.member.memId > 0){
					$scope.member.msg.memId = "";
					return true;
				}else{
					$scope.member.msg.memId = "请选择会员类型!";
					return false;
				}
			},
			hasCheckedCardNo: function(){
				if($scope.orgsConfig.isDisplayCard){
					var flag = false;
					angular.forEach($scope.member.cardNos, function(item, index){
						if(item.checked){
							flag = true;
							return false;
						}
							
					});
					if(!flag)
						$scope.member.msg.cardNos = "请选择关联的智能卡号!";
					else
						$scope.member.msg.cardNos = "";
					
					return flag;
				}else{
					return true;
				}
			},
			checkAll: function(){
				if($scope.member.status === 2){
					return this.checkRole() && this.checkName() && this.checkIdCard() && this.checkPhone() && this.hasCheckedCardNo();
				}else{
					return this.checkRole() 
					&& this.checkName() 
					&& this.checkIdCard()
					&& this.checkPhone() 
					&& this.checkGender() 
					&& this.checkBirthDate() 
					&& this.checkMemId() 
					&& this.hasCheckedCardNo();
				}
			},
			getFamilyMember:function() {
				$scope.memberType.memname=$scope.member.memTypeName;
				$scope.memberType.memid=$scope.member.memId;
				
				$scope.familyMember.memberType=$scope.memberType;
				$scope.familyMember.idcard=$scope.member.idCard;
				$scope.familyMember.memname=$scope.member.name;
				$scope.familyMember.tel=$scope.member.phone;
				$scope.familyMember.birthdate=$scope.member.birthDate;
				$scope.familyMember.gender=$scope.member.gender;
				
				$scope.familyCard.familyMember = $scope.familyMember;
				$scope.familyCard.familyMemberid = $scope.member.familyMemberId;
				$scope.familyCard.cardNos = $scope.member.cardNos;
				$scope.familyCard.cardNosStr = $scope.member.cardNosStr;
				$scope.familyCard.role = $scope.member.role;
				if($scope.member.role == 7) {
					if(!$scope.member.roleName) {
						$scope.familyCard.roleName = parent.getRoles()[$scope.member.role].relation;
					} else {
						$scope.familyCard.roleName = $scope.member.roleName;
					}
				} else {
					$scope.familyCard.roleName = parent.getRoles()[$scope.member.role].relation;
				}
			},
			init: function(){
				$scope.roles = parent.getRoles();
				$scope.orgsConfig = parent.getScope().orgsConfig;
				$scope.required = parent.getRequired();
			}
	}
	
	$scope.$watch('member.cardNos', function(newValue, oldValue) {
		var array = [];
		angular.forEach(newValue, function(v, index){
			if(v.checked)
				array.push(v.cardNo);
		});
		$scope.member.cardNosStr = array.join('；');
	}, true);
	
/*	$scope.$watch('member', function(newValue, oldValue) {
		$scope.event.checkAll();
	}, true);*/
	
	$scope.$watch('member.memId', function(newValue, oldValue) {
		angular.forEach($scope.memTypes, function(memType){
			if(memType.value == $scope.member.memId){
				$scope.member.memTypeName = memType.name;
			}
		});
		
	}, true);
	$scope.event.init();
});

function getScope(){
	return angular.element(document.querySelector('[ng-controller=ctrl]')).scope();
}

function loadData(obj, memTypes){
	var $scope = getScope();
	angular.extend($scope.member, obj);
	$scope.memTypes = angular.copy(memTypes);
	$scope.$apply($scope.member);
}

function setDiagTime () {
	$('#birthDate').datepicker({
		dateFormat: "yy-mm-dd",
        maxDate: "+d",
        stepMonths: 12,
		defaultDate : new Date(),
        changeMonth: true,
        changeYear: true,
    });	
}

$(function(){
	$.datepicker.regional['zh-CN'] = {
	        clearText: '清除', 
	        clearStatus: '清除已选日期', 
	        closeText: '清空', 
	        closeStatus: '不改变当前选择', 
	        prevText: '<上月', 
	        prevStatus: '显示上月', 
	        prevBigText: '<<', 
	        prevBigStatus: '显示上一年', 
	        nextText: '下月>', 
	        nextStatus: '显示下月', 
	        nextBigText: '>>', 
	        nextBigStatus: '显示下一年', 
	        currentText: '今天', 
	        currentStatus: '显示本月', 
	        monthNames: ['一月','二月','三月','四月','五月','六月', '七月','八月','九月','十月','十一月','十二月'], 
	        monthNamesShort: ['一月','二月','三月','四月','五月','六月', '七月','八月','九月','十月','十一月','十二月'], 
	        monthStatus: '选择月份', 
	        yearStatus: '选择年份', 
	        weekHeader: '周', 
	        weekStatus: '年内周次', 
	        dayNames: ['星期日','星期一','星期二','星期三','星期四','星期五','星期六'], 
	        dayNamesShort: ['周日','周一','周二','周三','周四','周五','周六'], 
	        dayNamesMin: ['日','一','二','三','四','五','六'], 
	        dayStatus: '设置 DD 为一周起始', 
	        dateStatus: '选择 m月 d日, DD', 
	        dateFormat: 'yy-mm-dd', 
	        firstDay: 1, 
	        initStatus: '请选择日期', 
	        isRTL: false,
	        yearRange:"1915:2100",
	        showButtonPanel: true,
	        onClose: function (dateText, inst) {
	            if ($(window.event.srcElement).hasClass('ui-datepicker-close'))
	            {
	             document.getElementById(this.id).value = '';
	            }
	           },}; 
	
	        $.datepicker.setDefaults($.datepicker.regional['zh-CN']); 
	        setDiagTime();
	        $('#birthDate').datepicker({
				dateFormat: "yy-mm-dd",
		        maxDate: "+d",
		        stepMonths: 12,
				defaultDate : new Date(),
		        changeMonth: true,
		        changeYear: true,
				
		    });	
});

var validateIdCard = function(num) {
    num = new String(num).toUpperCase();

    var cityCode = {11: "北京", 12: "天津", 13: "河北", 14: "山西", 15: "内蒙古", 21: "辽宁", 22: "吉林", 23: "黑龙江 ", 31: "上海", 32: "江苏", 33: "浙江", 34: "安徽", 35: "福建", 36: "江西", 37: "山东", 41: "河南", 42: "湖北 ", 43: "湖南", 44: "广东", 45: "广西", 46: "海南", 50: "重庆", 51: "四川", 52: "贵州", 53: "云南", 54: "西藏 ", 61: "陕西", 62: "甘肃", 63: "青海", 64: "宁夏", 65: "新疆", 71: "台湾", 81: "香港", 82: "澳门", 91: "国外 "};

    if(!cityCode[num.substr(0,2)]){
//        alert("地址编码错误");
//    	alert("身份证格式输入错误");
        return false;
    }
    //身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X。
    if (!(/(^\d{15}$)|(^\d{17}([0-9]|X)$)/.test(num))) {
        //alert('输入的身份证号长度不对，或者号码不符合规定！\n15位号码应全为数字，18位号码末位可以为数字或X。');
//    	alert("身份证格式输入错误");
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
//        	alert("身份证格式输入错误");
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
//            alert('输入的身份证号里出生日期不对！');
//        	alert("身份证格式输入错误");
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
//                alert('18位身份证的校验码不正确！应该为：' + valnum);
//            	alert("身份证格式输入错误");
                return false;
            }
            return true;
        }
    }
    return false;
}
