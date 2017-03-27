var setting = {
	data : {
		simpleData : {
			enable : true
		}
	},
	view : {
		dblClickExpand: false,
		selectedMulti : false,
		showIcon: false
	},
	callback : {
		onClick : listGroup,
		onExpand: zTreeOnExpand
	}
};
function listGroup(event, treeId, treeNode) {
	$("input[name='pId']").val(treeNode.id);
	$("#dataTable").attr("src",getRootPath() + "/docGrp/listDoctorGrp?pId=" + treeNode.id);
}

function goPage(url) {
	if(url && url !== "") {
		window.location = url;
	}
}

//function reload(pId){
//	window.location.href="../group/odgp!showAllLowerStr?pId="+pId;
//}

//自动调整iframe高度
function reinitIframe() {
	var iframe = document.getElementById("dataTable");
	try {
		var bHeight = iframe.contentWindow.document.body.scrollHeight;
		var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
		var height = Math.max(bHeight, dHeight);
		iframe.height = dHeight;
	} catch (ex) {
	}
}
$(document).ready(function() {
	// 初始化Tree			
	getAllDoctorGroup();
});
