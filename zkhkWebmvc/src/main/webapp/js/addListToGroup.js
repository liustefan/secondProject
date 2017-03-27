/*
 * addListToGroup.jsp
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

function closeWd() {
	parent.layer.close(index);
}

// 保存
function addMember() {
	var treeObj=$.fn.zTree.getZTreeObj("treeDemo"),
		nodes=treeObj.getCheckedNodes(true),
		nodeIds = [];
	
  if (nodes.length == 0){
	  	layer.msg("请选择要添加的组",{time: 1000});    
		return; 
    }
  
  for (var p in nodes){
  		nodeIds	.push(nodes[p].id);
	}
  	var url = '../group/omgs!addMultiMemberByDoc?grpids='+ nodeIds.toString()+'&ids='+$('#ids').val();
	$.getJSON(url, function(data) {
		if (data.success) {
			layer.msg("会员分配分组成功！正在刷新页面",{icon: 1,time: 1000},function(){
				parent.location.reload(true);
				}
			);
		} 
		else{
			layer.msg("添加失败！原因："+data.msg,{icon: 0});
			return
		}
	});
};

function addMemberGroup() {
	parent.layer.close(index);
}

$(function() {
	// 获取分组数据
	getData();
});