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

// 弹出修改医生分组页面
function updateMemberGroup(id) {
	layer.closeAll();
	layer.open({
		type : 2,
		skin: 'skin1',
		title : '修改会员分组',
		shadeClose : true,
		shade : 0,
		area : [ '450px', '450px' ],
//		content : 'addDoctor.jsp?docId=' + id
		content : getRootPath() + '/memberGrp/edit/' + id
	});
}

function removeRecord(id, obj) {
	layer.confirm('确定需要删除 '+obj.getAttribute("memGrpName")+' 医生分组吗？', {
		title : '提示信息',
		skin: 'skin1',
		shade : 0,
		btn : [ '确定', '取消' ]
	}, function(index) {
		layer.close(index);
		$.ajax({
			type : "POST",
			url : getRootPath() + '/memberGrp/delete/' + id,
			success : function(msg) {
				layer.msg(msg.content, {icon: 0,time: 1000});
				if(msg.status) {
					parent.reload($("input[name='pId']").val());
				}
			}
		});
	})
}

$(function() {
	var pId = $("input[name='pId']").val();
	$(".icon-group-search").click(function(){
		search(1);
	});
	//弹出新增会员分组页面
	$('#add-group').on('click', function() {
		if(!pId){
			layer.msg("请选择父节点后再点击新增!", {time: 2000, offset: '100px'});
			return;
		}
		layer.closeAll();
		//iframe层
		layer.open({
			type : 2,
			skin: 'skin1',
			title : '新增会员分组',
			shadeClose : true,
			shade : 0,
			area : [ '450px', '450px' ],
			content : getRootPath() + '/memberGrp/edit/0?pId=' + pId//iframe的url
		});
	});
});