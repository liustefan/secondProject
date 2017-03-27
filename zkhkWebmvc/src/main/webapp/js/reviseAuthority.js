function getRootPath(){
   /* //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
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

/*
 * reviseAuthority.js
 */
$(function() {
	var $chLevel = $(".chLevel");
	var $chLevelHidden = $(".chLevelHidden");
	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	var vForm = $("#form-examine").validate({
		rules : {
			'funid' : {
				required : true,
			},
			'optid' : {
				required : true,
			},
		},
		messages : {
			'funid' : {
				required : "必选",
			},
			'optid' : {
				required : "必选",
			},
		}
	});
	
	
	// 获取功能代码列表
	function sFun(funId, first) {
		if (funId && (funId == 1 || funId == 2))
			$('select[name="funid"]').val(funId)
		var findID = $('select[name="funid"]').val();
		if (!findID) {
			$('select[name="optid"]').html("<option value=''>请选择</option>");
			$('select[name="optid"]').val("");
			$chLevelHidden.val("");
			$chLevel.html("");
		} else {
			$.post(getRootPath() + "/docGrp/listOption", {
				funId : findID
			}, function(data) {
				if (data == "") {
					$('select[name="optid"]').html('');
					layer.msg("没有找到相关选项", {icon: 0,offset:["50px", "30px"] });
					$chLevelHidden.val("");
					$chLevel.html("");
				} else {
					$('select[name="optid"]').html('');
					$.each(data, function(k, v) {
						if (k > 0) {
							$('select[name="optid"]').append(
									"<option value=" + v.optId + ">" + v.optName
											+ "</option>");
						} else {
							if (!first && k == 0) {
								$('select[name="optid"]').append(
										"<option value=''>请选择</option>");
								$chLevelHidden.val("");
								$chLevel.html("");
							}
							$('select[name="optid"]').append(
									"<option value=" + v.optId + ">" + v.optName
											+ "</option>");
						}
					});
					if (funId && (funId == 1 || funId == 2))
						sOpt($("#optId").val(), first);
				}
			});
		}
	}
	// 获取选项代码列表
	function sOpt(optId, first) {
		if (optId)
			$('select[name="optid"]').val(optId);
		var optId = $('select[name="optid"]').val();
		var funId = $('select[name="funid"]').val();
		if (optId == "") {
			$chLevelHidden.val("");
			$chLevel.html("");
			return;
		}
		if(!first){
			$.ajax({
				url : getRootPath() + "/docGrp/getMaxLevel",
				type : "post",
				async : false,
				dataType : 'text',
				data : {
					optId : optId,
					funId : funId
				},
				success : function(data) {
					if (data == null || data == "") {
						$chLevelHidden.val("");
						$chLevel.html("");
						$('select[name="optid"]').val("");
						layer.msg("没有创建模板或模板为免审，不能设置审核权限！", {icon: 0,offset:["50px", "30px"] });
						flag = false;
					} else {
						flag = true;
						$chLevelHidden.val(data);
						$chLevel.html(data);
					}
				}
			});
		}
	}
	
	function save() {
		$.ajax({
			type : "POST",
			url : getRootPath() + "/docGrp/grant",
			data : $("#form-examine").serialize(),
			success : function(msg) {
				parent.layer.msg(msg.content, {icon: 1,offset: "100px"});
				if (msg.status) {
					 parent.layer.close(index);
				}
			}
		});
	}
	
	// 保存
	$("#submit").on("click", function() {
		if (vForm.form()) {
			save();
		}
	});

	// 清空
	$("#btnReset").on("click", function() {
		layer.confirm('您确定要清空审核权限？',{
			skin: 'skin1',
			shade : 0,
			closeBtn: 0,
		    btn: ['确定','取消'] //按钮
		}, function(index){
			$("#form-examine")[0].reset();
			$chLevelHidden.val("");
			$('select[name="optid"]').html('');
			save();
			//layer.close(index)
		}, function(index){
			layer.close(index)
		});
		
	});

	$("#sFun").change(function() {
		sFun();
	});
	$("#sOpt").change(function() {
		sOpt();
	});
	sFun($("#funId").val(), true);
});