var setting = {
	check : {
		enable : true,
		chkStyle : "checkbox",
		chkboxType : {
			Y : '',
			N : ''
		}
	},
	data : {
		simpleData : {
			enable : true,
		}
	},
	view : {
		dblClickExpand: false,
		showIcon : false,
		selectedMulti : false
	},
	callback : {
		beforeClick : checkedBox_a
	}
};

function checkedBox_a(treeId, treeNode) {
	var zTree = $.fn.zTree.getZTreeObj("treeDemo");
	zTree.checkNode(treeNode, !treeNode.checked, null, true);
	return false;
}
// 检测上传文件的类型
function fileChange1(target) {
	var file = document.getElementById("fileField1");
	var imgName = file.value;
	var ext, idx;
	idx = imgName.lastIndexOf(".");
	if (idx != -1) {
		ext = imgName.substr(idx + 1).toUpperCase();
		ext = ext.toLowerCase();
		if (ext != 'xls') {
			alert("只能上传.xls类型文件，请下载模板，录入数据后重新上传！");
			if (file.outerHTML) {
				file.outerHTML = file.outerHTML;
			} else {
				file.value = "";
			}
			return false;
		}
	} else {
		//document.all.submit_upload.disabled=true; 
		alert("只能上传.xls类型的文件，请下载模板，录入数据后重新上传！");
		if (file.outerHTML) {
			file.outerHTML = file.outerHTML;
		} else { // FF(包括3.5)
			file.value = "";
		}
		return false;
	}
	document.getElementById('textfield1').value = imgName;
}

$(document).ready(function() {

	getData();  //tree.js中的方法，加载会员分组数据

	// 绑定关闭窗口事件 
	$("#closeIframe").click(function() {
		var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
		parent.layer.close(index);
	});

	// 绑定上传事件
	$("#uploading").click(function() {
		// 获取选中的会员分组
		var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
		var nodes = treeObj.getCheckedNodes(true);
		var textField1 = $("#textfield1").val();

		if (textField1 == "") {
			layer.msg("请先上传表格！", {
				time : 1000
			});
			return false;
		}

		if (nodes.length == 0) {
			layer.msg("请选择分组!", {
				time : 1000
			});
			return false;
		}

		var grpIds = "";
		for (var i = 0; i < nodes.length; i++) {
			grpIds += nodes[i].id + ",";
		}
		$("#grpIds").val(grpIds);
		//    	window.location.href="../mem/MemberAction!importBatchMems?grpIds=" + grpIds;
		$(this).attr("disabled", "disabled");
		$('#form1').submit();
	});
});
