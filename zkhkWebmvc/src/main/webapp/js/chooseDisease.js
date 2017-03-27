/*
 * chooseDisease.jsp
 */
var setting = {
	check: {
		enable: true,
		chkStyle: "checkbox",
		chkboxType: {Y: '', N: ''}
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
		onCheck: onCheck
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
			   $(response).each(function(i, e) {
				   if(i == 0){
					   e.nocheck = true; 
				   }
			   });
			   $.fn.zTree.init($("#treeDemo"), setting, response);
		   }
		});
});

function zTreeOnCheck(event, treeId, treeNode) {
    var ztreeObj = $.fn.zTree.getZTreeObj(treeId);
    var cNodes = treeNode.children;
    if(treeNode.checked && cNodes){
        for(var i in cNodes) {
            cNodes[i].chkDisabled = true;
            cNodes[i].checked = false;
            ztreeObj.updateNode(cNodes[i])
        }
    } else if(!treeNode.checked && cNodes) {
        for(var u in cNodes) {
            cNodes[u].chkDisabled = false;
            cNodes[u].checked = false;
            ztreeObj.updateNode(cNodes[u]);
        }
    }
    

    /*var cNdes1 = treeNode.getParentNode();
    var cNodes2 = cNodes1.children;
    if(treeNode.checked && !cNodes){
        for(var k in nodes) {
            if(nodes[k] != treeNode) {
                nodes[k].chkDisabled = true;
                ztreeObj.updateNode(nodes[k])
            }
        }
    } else if(!treeNode.checked && !cNodes) {
        for(var j in nodes) {
            nodes[j].chkDisabled = false;
            ztreeObj.updateNode(nodes[j])
        }
    }*/
};

function onCheck(e, treeId, treeNode) {
	var ztreeObj = $.fn.zTree.getZTreeObj(treeId);
    var cNodes = treeNode.children;
    if(treeNode.checked && cNodes){
        for(var q in cNodes) {
            cNodes[q].chkDisabled = true;
            cNodes[q].checked = false;
            ztreeObj.updateNode(cNodes[q])
        }
    } else if(!treeNode.checked && cNodes) {
        for(var u in cNodes) {
            cNodes[u].chkDisabled = false;
            cNodes[u].checked = false;
            ztreeObj.updateNode(cNodes[u]);
        }
    }
	
	var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
	nodes = zTree.getCheckedNodes(true),
	v = "",
	checkedID = "";
	for (var i=0, l=nodes.length; i<l; i++) {
		v += nodes[i].name + ",";
		checkedID += nodes[i].id + ",";
	}
	if (v.length > 0 ) v = v.substring(0, v.length-1);
	if (checkedID.length > 0 ) checkedID = checkedID.substring(0, checkedID.length-1);
	var diseaseObj = $("#disease_name");
	var diseaseID = $("#checked_ID");
	diseaseObj.attr("value", v);
	diseaseID.attr("value", checkedID);
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