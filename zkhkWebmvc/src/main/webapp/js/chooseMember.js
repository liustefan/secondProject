/* chooseMember.jsp */
var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
    
function choose() {
	var obj = $("input[type='radio']:checked");
	if(obj.length == 0) {
		alert("请选择会员！");
	}else{
		parent.setBaseInfo({
			memberId: $(obj).val(),
			memName: $(obj).data('memname'),
			uniqueId: $(obj).data('unique'),
			gender: $(obj).data('gender'),
			birthDay: $(obj).data('birthday')
		});
		parent.layer.close(index);
	}
}