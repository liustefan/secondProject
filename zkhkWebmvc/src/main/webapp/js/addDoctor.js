/*
 * addGroup.jsp
 */
function getRootPath(){
    return top.getRoot();
}

var index = parent.layer.getFrameIndex(window.name); //获取窗口索引

// 取消
function closeWd() {
	 parent.layer.close(index);
}

$(function() {
	jQuery.validator.addMethod("string", function(value, element) {
		return this.optional(element) || !(/\<|\>|\'|\"|\\/g.test(value));
		}, "不允许包含特殊字符!");
	
	jQuery.validator.addMethod("isBlank", function(value, element) {
		return $.trim(value) != ''
		}, "必填!");
	
	// 表单验证
	var vForm = $("#form3").validate({
		rules : {
			'odgpname' : {
				required : true,
				isBlank: true,
				maxlength : 20,
				string: true,
				remote: {
				    url: getRootPath() + "/docGrp/checkNameExists",     //后台处理程序
				    type: "post",               //数据发送方式
				    dataType: "json",           //接受数据格式   
				    data: {                     //要传递的数据
				    	'odgpid': function(){
				    		return $("input[name='odgpid']").val();
				    	},
				    	'parentGroup.odgpid': function() {
				            return $("input[name='parentGroup.odgpid']").val();
				        },
				        'odgpname': function(){
				        	return $("input[name='odgpname']").val();
				        }
				    }
				}
			},
			'order':{
				required : true,
				digits:true,
				maxlength: 9
			},
			'remark' : {
				maxlength : 50,
				string: true
			}
		},
		messages : {
			'odgpname' : {
				required : "必填",
				maxlength : "长度不能超过{0}个字符",
				remote : "同级分组名称已存在"
			},
			'order' : {
				required : "必填",
				digits: "请输入正整数",
				maxlength: "请输入9位以下正整数"
			},
			'remark' : {
				maxlength : "长度不能超过{0}个字符"
			}
		}
	});
	// 保存
	$("#btnSubmit").on("click", function() {
		$("#btnSubmit").attr("disabled", true);
		if(vForm.form()){
			$.ajax({
				type : "POST",
				url : getRootPath() + "/docGrp/add",
				data : $("#form3").serialize(),
				success : function(msg) {
						layer.msg(msg.content,{icon: 1,time: 1000},function(){
						if (msg.status) {
							window.parent.location.href=getRootPath() + "/docGrp/listDoctorGrp?pId=" + $("input[name='parentGroup.odgpid']").val();
							parent.parent.getAllDoctorGroup();
						}else{
							$("#btnSubmit").attr("disabled", false);
						}	
					});
				}
			});
			
		}else{
			$("#btnSubmit").attr("disabled", false);
		};
		 //parent.layer.close(index);
	});
});