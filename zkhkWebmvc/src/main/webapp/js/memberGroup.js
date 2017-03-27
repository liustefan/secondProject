/*
 * addGroup.jsp
 */
function getRootPath(){
    /*//获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
    var curWwwPath=window.document.location.href;
    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8083
    var localhostPaht=curWwwPath.substring(0,pos);
    //获取带"/"的项目名，如：/uimcardprj
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    return(localhostPaht+projectName);*/
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
		return $.trim(value) !== '';
		}, "必填!");
	
	// 表单验证
	var vForm = $("#form3").validate({
		rules : {
			'memgrpname' : {
				required : true,
				isBlank: true,
				maxlength : 20,
				string: true,
				remote: {
				    url: getRootPath() + "/memberGrp/checkNameExists",     //后台处理程序
				    type: "post",               //数据发送方式
				    dataType: "json",           //接受数据格式   
				    data: {                     //要传递的数据
				    	'memgrpid': function(){
				    		return $("input[name='memgrpid']").val();
				    	},
				    	'famemid': function() {
				            return $("input[name='famemid']").val();
				        },
				        'memgrpname': function(){
				        	return $("input[name='memgrpname']").val();
				        }
				    }
				}
			},
			'order' : {
				required : true,
				digits:true,
				maxlength: 9
			},
			'memgrpdesc' : {
				maxlength : 50,
				string: true
			}
		},
		messages : {
			'memgrpname' : {
				required : "必填",
				maxlength : "长度不能超过{0}个字符",
				remote : "同级分组名称已存在"
			},
			'order' : {
				required : "必填",
				digits: "请输入正整数",
				maxlength: "请输入9位以下正整数"
			},
			'memgrpdesc' : {
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
				url : getRootPath() + "/memberGrp/add",
				data : $("#form3").serialize(),
				success : function(msg) {
					layer.msg(msg.content,{icon: 1,time: 1000},function(){
						if (msg.status) {
							parent.parent.reload($("input[name='famemid']").val());
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