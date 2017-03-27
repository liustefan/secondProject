var setting = {
	data : {
		simpleData : {
			enable : true
		}
	},
	view : {
		dblClickExpand : false,
		selectedMulti : false,
		//fontCss : getFontCss
	},
	callback : {
		onClick : showOrgs,
		onExpand: zTreeOnExpand
	}
};
//编辑疾病，定位编辑的父节点，并显示子节点
function reload(id){
	window.location.href=getRootPath() + "/health/illType?id="+id;
}

function showOrgs(event, treeId, treeNode) {
	var level = treeNode.level;
	$("#dataTable").attr(
			"src",
			getRootPath() + "/health/illManagement?msdiseaseid=" + treeNode.id + "&pName="
					+ encodeURI(encodeURI(treeNode.name)) + "&level="
					+ treeNode.level);
}

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
	getDiseaseList();

});

