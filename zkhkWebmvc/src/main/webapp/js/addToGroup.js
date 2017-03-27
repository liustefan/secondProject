/*
 * addToGroup.jsp
 */
var setting = {
		check: {
			enable: true,
			chkStyle: "checkbox",
			chkboxType: {Y: '', N: ''}
		},
		data: {
			simpleData: {
				enable: true,
			}
		},
		view: {
			dblClickExpand: false,
			showIcon: false,
			selectedMulti: false
		},
        callback: {
        		beforeClick: checkedBox,
            onCheck: onCheck
        }
	};

var index = parent.layer.getFrameIndex(window.name); //获取窗口索引

// 取消
function closeWd() {
	parent.layer.close(index);
}

// 保存
function updateMember() {
	var treeObj = $.fn.zTree.getZTreeObj("treeDemo"),
		nodes = treeObj.getCheckedNodes(true),
		nodeIds = [],
		url = '';
	if (nodes.length == 0){
	  	layer.msg("请选择要添加的组",{time: 1000});    
		return; 
    }
	if (nodes.length != 0) {
		for ( var p in nodes) {
			nodeIds.push(nodes[p].id);
		}
	}
	if (nodeIds.length > 0) {
		url = '../group/omgs!updateMemberOmgsByDoc?grpids=' + nodeIds.toString() + '&memberid=' + $("#memberid").val();
	} else {
		url = '../group/omgs!updateMemberOmgsByDoc?memberid=' + $("#memberid").val();
	}
	$.getJSON(url, function(data) {
		if (data.success) {
			parent.layer.msg("修改成功! 正在刷新页面", {icon: 1,time: 1000},function(){
				parent.location.reload(true);
				}
			);
		} else {
			layer.msg("修改失败!<br>原因:" + data.msg, {icon: 0});
			return;
		}
		
	});
}

function addMemberGroup() {
	parent.layer.close(index);
}

$(function() {
	// 获取分组数据 填充tree
	getData();
});