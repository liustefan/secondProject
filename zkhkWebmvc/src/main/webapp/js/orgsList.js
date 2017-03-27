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
//编辑组织，定位编辑的父节点，并显示子节点
function reload(id){
	window.location.href=getRootPath() + "/org/orgPage?id="+id;
}

function showOrgs(event, treeId, treeNode) {
	//	window.location = "../group/orgs!getOrgsList?orgId=" + treeNode.id;
	$("#dataTable").attr(
			"src",
			getRootPath() + "/org/listOrg?orgId=" + treeNode.id + "&pName="
					+ encodeURI(encodeURI(treeNode.name))+ "&level="
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
	getOrganizationList();

});
//删除单行组织信息
function delOrg(id) {
	$.ajax({
		type : "get",
		url : "../orgs!deleteOrgsById?orgId="+id,
		success : function(msg) {
			switch (msg.data) {//0、删除失败	1、删除成功 2.该节点下有子组织 	3该节点下有子管理员
			case 0:
				alert("删除失败！");
				break;
			case 1:
				alert("删除成功！");
				parent.location.reload();
				break;
			case 2:
				alert("该节点下有子组织，不可删除!");
				break;
			case 3:
				alert("该节点下有子管理员，不可删除!");
				break;
			default:
				alert("未知错误！");
			}
		}
	});
}
