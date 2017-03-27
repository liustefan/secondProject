var setting = {
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
	check: {
		enable: true,
		chkStyle: "checkbox",
	},
	callback: {
		beforeClick: checkedBox,
	}
};

function saveGroup() {
	var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
	nodes = zTree.getCheckedNodes(true),
	list = [];
//	var hash = {};
	for (var i=0, l=nodes.length; i<l; i++) {
		list.push({odgpid:nodes[i].id,memgrpid:$("input[name='memGrpId']").val()});
//		--------2016-01-14 2.0.4变更需求 去掉此判断
//		if(nodes[i].optId && hash[nodes[i].optId]){
//			layer.msg("不能绑定审核类型相同的医生分组！");
//			return;
//		}
//		hash[nodes[i].optId] = true;
	}
	$.ajax({
		   type: "POST",
		   url: getRootPath() + '/memberGrp/bindDoctorGroup',
		   data: {json: JSON.stringify(list), memGrpid: $("input[name='memGrpId']").val()},
		   asyn: false,
		   success: function(response){
			   layer.msg(response.content,{icon: 1,time: 1000},function(){
				   if(response.status) {
					   goback();
				   }
			   });
		   }
		});
}

$(function() {
	//  根据选择的会员分组 初始化医生分组Tree
	$.ajax({
		   type: "GET",
		   url: getRootPath() + '/docGrp/initDocGrpTreeByMemGrp?memGrpId='+$("input[name='memGrpId']").val(),
		   asyn: false,
		   success: function(response){
			   $.fn.zTree.init($("#treeDemo"), setting, response);
			   key = $("#key");
			   key.bind("keypress", searchNode);
		   }
		});
});
