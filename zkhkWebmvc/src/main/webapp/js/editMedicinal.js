/*editMedicinal.js*/

var index = parent.layer.getFrameIndex(window.name); //获取窗口索引

$(function() {
	jQuery.validator.addMethod("string", function(value, element) {
		return this.optional(element) || !(/\<|\>|\'|\"|\\/g.test(value));
		}, "不允许包含特殊字符!");
	
	jQuery.validator.addMethod("isBlank", function(value, element) {
		return $.trim(value) != ''
		}, "必填!");
	
	// 表单验证
	var vForm = $("#form-drugDetail").validate({
		rules : {
			'drugName' : {
				required : true,
				isBlank: true,
				string: true,
				maxlength: 100
			},
			'count' : {
				number: true,
			},
			'remark' : {
				string: true,
				maxlength: 500
			},
			'drugUseTime' : {
				string: true,
			}
		},
		messages : {
			'drugName' : {
				required : "必填",
				isBlank : "必填",
				string : "不允许包含特殊字符!",
				maxlength : "长度不能超过100个字符"
			},
			'count' : {
				number : "请输入数字！"
			},
			'remark' : {
				string : "不允许包含特殊字符!",
				maxlength : "长度不能超过500个字符"
			},
			'drugUseTime' : {
				string : "不允许包含特殊字符!",
			}
		}
	});
	// 保存
	$("#drugDetail").on("click", function() {
		$("#drugDetail").attr("disabled", true);
		var form = $('#form-drugDetail'),obj ={};
		var page = $("#source").val();
		
		if(vForm.form()){
			obj.logID = $("#form-drugDetail input[type='hidden']").val();
			obj.drugName =  $("#form-drugDetail input[name='drugName']").val();
			obj.useMethod =  $("#form-drugDetail select[name='useMethod'] option:selected").text();
			obj.frequentness =  $("#form-drugDetail select[name='frequentness'] option:selected").text();
			obj.count =  $("#form-drugDetail input[name='count']").val();
			obj.dosageUnit =  $("#form-drugDetail select[name='dosageUnit'] option:selected").text();
			obj.compliance =  $("#form-drugDetail select[name='compliance']").val();
			obj.complianceDes =  $("#form-drugDetail select[name='compliance'] option:selected").text();
			obj.remark =  $("#form-drugDetail textarea[name='remark']").val();
			obj.index =  $("#form-drugDetail input[name='index']").val();
			obj.drugUseTime = $("#form-drugDetail input[name='drugUseTime']").val();
			obj.useMethod = obj.useMethod == "其他"? $("#form-drugDetail #txt1").val():obj.useMethod;
			obj.frequentness = obj.frequentness == "其他"? $("#form-drugDetail #txt2").val():obj.frequentness;
			obj.dosageUnit = obj.dosageUnit == "其他"? $("#form-drugDetail #txt3").val():obj.dosageUnit;
			
			if(obj.index) {
				parent.updateMedicinal(obj, "Medicinal", page);
			}else {
				parent.addMedicinal(obj, "Medicinal", page);
			}
			
			parent.layer.close(index);
			
		}else{
			$("#drugDetail").attr("disabled", false);
		};
	});
});