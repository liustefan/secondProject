/*
 * addMember.jsp
 */

var validate,
	index = parent.layer.getFrameIndex(window.name); //获取窗口索引

//保存会员分组
function saveMemberGroup() {
	if(!validate.form()) { return false;}
	
//	$.ajax({
//		type : "POST",
//		url : "",
//		data : $("#form4").serialize(),
//		success : function(msg) {
//			alert(msg.content)
//			if (msg.status) {
//				parent.location.reload();
//			}
//		}
//	});
	parent.layer.close(index);
}

// 取消
function cancelMemberGroup() {
	  parent.layer.close(index);
}

$(function() {
	// 验证数据格式
	validate = $("#form4").validate({
		rules : {
			nomenclature : {
				required : true,
			},
			rank : {
				required : true,
				number : true
			},
			maxlength : {
				maxlength:50,
			},
		},
		messages : {
			nomenclature : {
				required : "必填",
			},
			rank : {
				required : "必填",
				number : "请输入数字"
			},
			maxlength: {
				maxlength:"内容超过字符限制"
			}
		}
	});
});