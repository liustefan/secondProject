var setting = {
	data : {
		simpleData : {
			enable : true
		}
	},
	view : {
		showIcon: false,
		selectedMulti: false,
	},
	callback: {
		onClick: showOrgs,
		onExpand: zTreeOnExpand
	}
};
var treeNode;
function showOrgs(event, treeId, treeNode) {
	$("input[name='pId']").val(treeNode.id);
	$("#dataTable").attr("src",getRootPath() + "/memberGrp/listMemberGroup?pId=" + treeNode.id);
}

function goPage(url, memGrpId) {
	if(url && url !== "") {
		var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
		var node = treeObj.getNodeByParam("id", memGrpId, null);
		window.location = url + "?memGrpId="+memGrpId+"&pathName="+encodeURIComponent(encodeURIComponent(getPathName(node)));
	}
	
}

function reload(pId){
	window.location.href= getRootPath() +"/memberGrp/groupTotal?pId="+pId;
}

function getPathName(node){
	var pathName = node.name;
	if(node.level > 0){
		pathName = getPathName(node.getParentNode()) + ">" + node.name;
	}
	return pathName;
}

//自动调整iframe高度
function reinitIframe(){  
	var iframe = document.getElementById("dataTable");  
	try{  
	    var bHeight = iframe.contentWindow.document.body.scrollHeight;  
	    var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;  
	    var height = Math.max(bHeight, dHeight);  
	    iframe.height = height;  
	}catch (ex){}  
}  

$(document).ready( function() {
	getAllMemberGroup();
	
});