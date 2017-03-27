/*editHOIV.js*/

var index = parent.layer.getFrameIndex(window.name); //获取窗口索引


$(function() {
	jQuery.validator.addMethod("string", function(value, element) {
		return this.optional(element) || !(/\<|\>|\'|\"|\\/g.test(value));
		}, "不允许包含特殊字符!");
	
	jQuery.validator.addMethod("isBlank", function(value, element) {
		return $.trim(value) != ''
		}, "必填!");
	
	// 表单验证
	var vForm = $("#form-hospitalization").validate({
		rules : {
			'admissionDate' : {
				required : true,
				isBlank: true,
				string: true,
			},
			'dischargeDate' : {
				string: true,
			},
			'organization' : {
				string: true,
				maxlength: 100
			},
			'fileNumber' : {
				string: true,
				maxlength: 50
				
			},
			'reason' : {
				string: true,
				maxlength : 500
			}
		},
		messages : {
			'admissionDate' : {
				required : "必填",
				isBlank : "必填",
				string : "不允许包含特殊字符!"
			},
			'dischargeDate' : {
				string : "不允许包含特殊字符!"
			},
			'organization' : {
				string : "不允许包含特殊字符!",
				maxlength : "长度不能超过100个字符"
			},
			'fileNumber' : {
				string : "不允许包含特殊字符!",
				maxlength : "长度不能超过50个字符"
			},
			'reason' : {
				string : "不允许包含特殊字符!",
				maxlength : "长度不能超过500个字符"
			}
		}
	});
	// 保存
	$("#hospitalization").on("click", function() {
		$("#hospitalization").attr("disabled", true);
		var form = $('#form-hospitalization'),obj ={};
		if(vForm.form()){
			obj.logID = $("#form-hospitalization input[type='hidden']").val();
			obj.admissionDate =  $("#form-hospitalization input[name='admissionDate']").val();
			obj.dischargeDate =  $("#form-hospitalization input[name='dischargeDate']").val();
			obj.organization =  $("#form-hospitalization input[name='organization']").val();
			obj.fileNumber =  $("#form-hospitalization input[name='fileNumber']").val();
			obj.reason =  $("#form-hospitalization textarea[name='reason']").val();
			obj.index =  $("#form-hospitalization input[name='index']").val();
			if(obj.index) {
				parent.updateHoiv(obj, "hoiv");
			}else {
				parent.addHoiv(obj, "hoiv");
			}
			
			parent.layer.close(index);
			
		}else{
			$("#hospitalization").attr("disabled", false);
		};
		 //parent.layer.close(index);
	});
	
});