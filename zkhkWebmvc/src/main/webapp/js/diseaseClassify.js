/*
 * diseaseClassify.jsp
 */
var setting = {
	check: {
		enable: false
	},
	data : {
		simpleData : {
			enable : true
		}
	},
	view : {
		dblClickExpand: false,
		selectedMulti: false,
		showIcon: false
	},
	callback : {
		onClick : onClick
	}
};

var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
var key, lastValue = "", nodeList = [], fontCss = {}, zNodes;

$(document).ready(function(){
//	$.fn.zTree.init($("#treeDemo"), setting, zNodes);
	$.ajax({
		   type: "GET",
		   url: '../listAllDisease?pId=0',
		   asyn: false,
		   success: function(response){
			   $.fn.zTree.init($("#treeDemo"), setting, response);
		   }
		});
});

function onClick(e, treeId, treeNode) {
	var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
	nodes = zTree.getSelectedNodes(),
	cNodes = treeNode.children,
	v = "",
	childID = "",
	checkedID = "";
	nodes.sort(function compare(a,b){return a.id-b.id;});
	if(cNodes != ''){
		for (var w=0, t=cNodes.length; w<t; w++) {
			childID += "'"+cNodes[w].id + "',";
		}
	}
	for (var i=0, l=nodes.length; i<l; i++) {
		v += nodes[i].name + ",";
		checkedID += "'"+nodes[i].id + "',";
	}
	if (v.length > 0 ) v = v.substring(0, v.length-1);
	if (childID.length > 0 ) childID = childID.substring(0, childID.length-1);
	if (checkedID.length > 0 ) checkedID = checkedID.substring(0, checkedID.length-1);
	var diseaseObj = $("#checked_name");
	var diseaseID = $("#checked_ID")
	diseaseObj.attr("value", v);
	if(childID != ''){
		diseaseID.attr("value", checkedID +','+childID);
	}else{
		diseaseID.attr("value", checkedID);
	}
	if(v == '全部'){
		diseaseID.attr("value", '');
	}
}

function searchDisease() {
	var zTree = $.fn.zTree.getZTreeObj("treeDemo");
	var value = $.trim($("#key").val());
	// 展开所有节点
	zTree.expandAll(true);
	// 隐藏所有节点
	nodeList = zTree.transformToArray(zTree.getNodes());
	updateNodes(true);
	// 显示符合条件的节点
	nodeList = zTree.getNodesByParamFuzzy('name', value);
	updateNodes(false, value);
}

//将节点隐藏或显示
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