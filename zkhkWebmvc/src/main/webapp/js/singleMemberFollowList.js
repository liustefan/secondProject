function delHypertension() {
	var checkList = $(".tabel_content input[name='ids']:checked");
	if (checkList.length <= 0) {
		alert("请勾选要删除的体检信息.");
		return;
	}

	$.ajax({
		   type: "post",
		   url:  "../publicHealth/publicHealthAction!removeHypertension",
		   data: $.param(checkList),
		   success: function(msg){
		     alert(msg.content);
		   }
		})
}

function delGlycuresis() {
	var checkList = $(".tabel_content input[name='ids']:checked");
	if (checkList.length <= 0) {
		alert("请勾选要删除的体检信息.");
		 location.reload();
		return;
	}

	$.ajax({
		   type: "post",
		   url:  "../publicHealth/publicHealthAction!removeDiabetes",
		   data: $.param(checkList),
		   success: function(msg){
		     alert(msg.content);
		   }
		})
}

function judgeHypertensionDisease(memberid, type, disease){
	if(disease == 'N'){
		alert("当前会员无高血压疾病，请添加！");
	}else{
		window.location.href="../publicHealth/publicHealthAction!toAddHypertensionFllow?memberid="+memberid+"&operate=singlenew&type="+type;
	}
}

function judgeDiabetesDisease(memberid, type, disease){
	if(disease == 'N'){
		alert("当前会员无糖尿病疾病，请添加！");
	}else{
		window.location.href="../publicHealth/publicHealthAction!toAddGlycuresisFllow?memberid="+memberid+"&operate=singlenew&type="+type;
	}
}


$(function() {
	//全选
	$("#allSelect").click(function() {
		$(":checkbox:not(:disabled)").each(function() {
			this.checked = true;
		});
	});
	//全不选
	$("#unSelect").click(function() {
		$(":checkbox:not(:disabled)").each(function() {
			this.checked = !this.checked;
		});
	});
});