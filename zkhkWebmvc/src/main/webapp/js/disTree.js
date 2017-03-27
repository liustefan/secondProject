var key, lastValue = "", nodeList = [], fontCss = {}, zNodes;

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

// 选择分组
function searchNode(e) {
	if (e && e.which !== 13) {
		return;
	}
	var zTree = $.fn.zTree.getZTreeObj("treeDemo");
	var value = $.trim(key.get(0).value);

	// 展开所有节点
	zTree.expandAll(true);
	// 隐藏所有节点
	nodeList = zTree.transformToArray(zTree.getNodes());
	updateNodes(true);
	// 显示符合条件的节点
	nodeList = zTree.getNodesByParamFuzzy('name', value);
	updateNodes(false, value);

}
// 将节点隐藏或显示
function updateNodes(isHidden, value) {
	var zTree = $.fn.zTree.getZTreeObj("treeDemo");
	
	if(isHidden) {
		for (var i = 0, l = nodeList.length; i < l; i++) {
			// 隐藏节点
			zTree.hideNode(nodeList[i])
		}
	}else {
		for (var i = 0, l = nodeList.length; i < l; i++) {
			// 显示节点
			zTree.showNodes(nodeList[i].getPath())
			// 如果是父节点 并且下面没有符合条件的子节点 则此父节点折叠
			if(nodeList[i].isParent && zTree.getNodesByParamFuzzy('name', value, nodeList[i]).length <= 0) {
				zTree.expandNode(nodeList[i], false, true, false, true);
			}
			
		}
	}

}

// 获取疾病分类分组
function getDiseaseList() {
	$.ajax({
		type : "POST",
		url : getRootPath() + '/health/listAllDisease',
		async : true,
		success : function(response) {
//			zNodes = response;
			var zTree = $.fn.zTree.init($("#treeDemo"), setting, response);
			zTree.selectNode(zTree.getNodeByParam("id", $("#id").val()));
			key = $("#key");
			key.bind("keypress", searchNode);
		}
	});
}

function beforeClick(treeId, treeNode) {
	return false;
}

function checkedBox(treeId, treeNode) {
	var zTree = $.fn.zTree.getZTreeObj("treeDemo");
	zTree.checkNode(treeNode, !treeNode.checked, null, true);
	return false;
}


function onCheck(e, treeId, treeNode) {
	var zTree = $.fn.zTree.getZTreeObj("treeDemo"), nodes = zTree
			.getCheckedNodes(true), v = "", v1 = "", cityObj = $("#memberGroupId"), cityObj1 = $("#memberGroupName");
	for (var i = 0, l = nodes.length; i < l; i++) {
		v += nodes[i].id + ",";
		v1 += nodes[i].name + ",";
	}
	if (v.length > 0) {
		v = v.substring(0, v.length - 1);
	}
	if (v1.length > 0) {
		v1 = v1.substring(0, v1.length - 1);
	}
	cityObj.attr("value", v);
	cityObj1.attr("value", v1);
	var cityObj2 = $("#citySel");
	cityObj2.attr("value", v);
}

// tree单击选择
function onClick(e, treeId, treeNode) {
	var zTree = $.fn.zTree.getZTreeObj("treeDemo"), cityObj = $("#memberGroupId"), cityObj1 = $("#memberGroupName"), nodes = zTree
			.getSelectedNodes(), v = "", v1 = "";

	nodes.sort(function compare(a, b) {
		return a.id - b.id;
	});

	for (var i = 0, l = nodes.length; i < l; i++) {
		v += nodes[i].id + ",";
		v1 += nodes[i].name + ",";
	}
	if (v.length > 0) {
		v = v.substring(0, v.length - 1);
	}
	if (v1.length > 0) {
		v1 = v1.substring(0, v1.length - 1);
	}

	cityObj.attr("value", v);
	cityObj1.attr("value", v1);
}

// 点击父节点的时候显示所有子节点
function zTreeOnExpand(event, treeId, treeNode)  {
	var zTree = $.fn.zTree.getZTreeObj("treeDemo");

	if(treeNode.isParent && zTree.getNodesByParam('isHidden', true, treeNode).length > 0) {
		zTree.showNodes(treeNode.children);
		$(treeNode.children).each(function(i,e) {
			zTree.expandNode(e, false, false, true);
		})
		
	}
	
    return true;
};

function goback() {
	history.go(-1);
}
