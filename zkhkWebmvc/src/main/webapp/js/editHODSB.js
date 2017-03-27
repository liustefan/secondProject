/*editHODSB.js*/

var index = parent.layer.getFrameIndex(window.name); //获取窗口索引

$(function() {
	jQuery.validator.addMethod("string", function(value, element) {
		return this.optional(element) || !(/\<|\>|\'|\"|\\/g.test(value));
		}, "不允许包含特殊字符!");
	
	jQuery.validator.addMethod("isBlank", function(value, element) {
		return $.trim(value) != ''
		}, "必填!");
	
	// 表单验证
	var vForm = $("#form-detailHODSB").validate({
		rules : {
			'startDate' : {
				required : true,
				isBlank: true,
				string: true,
			},
			/*'endDate' : {
				required : true,
				isBlank: true,
				number: true,
			},*/
			'organizationName' : {
				string: true,
				maxlength: 100
			},
			'fileNumber' : {
				string: true,
				maxlength: 50
			},
			'account' : {
				string: true,
				maxlength: 500
			}
		},
		messages : {
			'startDate' : {
				required : "必填",
				isBlank : "必填",
				string : "不允许包含特殊字符!",
			},
			/*'endDate' : {
				required : "必填",
				isBlank : "必填",
				number : "请输入数字！"
			},*/
			'organizationName' : {
				string : "不允许包含特殊字符!",
				maxlength : "长度不能超过100个字符"
			},
			'fileNumber' : {
				string : "不允许包含特殊字符!",
				maxlength : "长度不能超过50个字符"
			},
			'account' : {
				string : "不允许包含特殊字符!",
				maxlength : "长度不能超过500个字符"
			}
		}
	});
	// 保存
	$("#hospitalDetail").on("click", function() {
		$("#hospitalDetail").attr("disabled", true);
		var form = $('#form-detailHODSB'),obj ={};
		if(vForm.form()){
			obj.logID = $("#form-detailHODSB input[type='hidden']").val();
			obj.startDate =  $("#form-detailHODSB input[name='startDate']").val();
			obj.endDate =  $("#form-detailHODSB input[name='endDate']").val();
			obj.organizationName =  $("#form-detailHODSB input[name='organizationName']").val();
			obj.fileNumber =  $("#form-detailHODSB input[name='fileNumber']").val();
			obj.account =  $("#form-detailHODSB textarea[name='account']").val();
			obj.index =  $("#form-detailHODSB input[name='index']").val();
			
			if(obj.index) {
				parent.updateHospitalRecord(obj, "detailHODSB");
			}else {
				parent.addHospitalRecord(obj, "detailHODSB");
			}
			
			parent.layer.close(index);
			
		}else{
			$("#hospitalDetail").attr("disabled", false);
		};
		 //parent.layer.close(index);
	});
});