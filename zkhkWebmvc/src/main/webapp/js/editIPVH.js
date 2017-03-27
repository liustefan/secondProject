/*editIPVH.js*/

var index = parent.layer.getFrameIndex(window.name); //获取窗口索引

$(function() {
	jQuery.validator.addMethod("string", function(value, element) {
		return this.optional(element) || !(/\<|\>|\'|\"|\\/g.test(value));
		}, "不允许包含特殊字符!");
	
	jQuery.validator.addMethod("isBlank", function(value, element) {
		return $.trim(value) != ''
		}, "必填!");
	
	// 表单验证
	var vForm = $("#form-vaccine").validate({
		rules : {
			'vaccineName' : {
				required : true,
				isBlank: true,
				string: true,
				maxlength: 100
			},
			/*'startDate' : {
				required : true,
				isBlank: true,
			},*/
			'vaccineOrganization' : {
				string: true,
				maxlength: 100
			}
		},
		messages : {
			'vaccineName' : {
				required : "必填",
				isBlank : "必填",
				string : "不允许包含特殊字符!",
				maxlength : "长度不能超过100个字符"
			},
			/*'startDate' : {
				required : "必填",
				isBlank : "必填",
			},*/
			'vaccineOrganization' : {
				string : "不允许包含特殊字符!",
				maxlength : "长度不能超过100个字符"
			}
		}
	});
	// 保存
	$("#vaccineDetail").on("click", function() {
		$("#vaccineDetail").attr("disabled", true);
		var form = $('#form-vaccine'),obj ={};
		if(vForm.form()){
			obj.logID = $("#form-vaccine input[type='hidden']").val();
			obj.vaccineName =  $("#form-vaccine input[name='vaccineName']").val();
			obj.vaccineDate =  $("#form-vaccine input[name='vaccineDate']").val();
			obj.vaccineOrganization =  $("#form-vaccine input[name='vaccineOrganization']").val();
			obj.index =  $("#form-vaccine input[name='index']").val();
			
			if(obj.index) {
				parent.updateIPVH(obj, "detailIPVH");
			}else {
				parent.addIPVH(obj, "detailIPVH");
			}

			parent.layer.close(index);
			
		}else{
			$("#vaccineDetail").attr("disabled", false);
		};
		 //parent.layer.close(index);
	});
});