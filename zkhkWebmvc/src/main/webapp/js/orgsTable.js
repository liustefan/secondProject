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

function submitForm() {
		$("#form1").submit();
	}

function reloadPage() {
	console.log('reloadPage');
	parent.location.reload();
}

//配置
function configOrgById(id){
	layer.closeAll();
	layer.open({
		type : 2,
		skin: 'skin1',
		title : '组织机构配置',
		shadeClose : true,
		shade : 0,
		area : [ '510px', '530px' ],
		content : getRootPath() + '/org/setting/' + id
	});
}

// 删除
function delOrgById(id, name) {
	layer.confirm('您确定要删除 '+name+' 节点吗？', {
		title : '提示信息',
		skin: 'skin1',
		shade : 0,
		btn : [ '确定', '取消' ]
	},function(index) {
		layer.close(index);
		$.ajax({
			type : "POST",
			url : getRootPath() + "/org/delete/"+ id,
			success : function(msg) {
				layer.msg(msg.content,{icon: 0,time: 1000});
				if(msg.status) {
					parent.reload($("input[name='orgId']").val());
				}
			}
		});

	});
}

// 修改组织机构页面
function updateOrgById(id) {
	layer.closeAll();
	layer.open({
		type : 2,
		skin: 'skin1',
		title : '修改组织机构',
		shadeClose : true,
		shade : 0,
		area : [ '400px', '380px' ],
		content : getRootPath() + '/org/edit/' + id
	});
}
$(function() {
	//parent.reinitIframe();
	// 弹出新增组织机构页面
	var pId = $("#pId").val();
	$('#add-group').on('click', function() {
		if($("#level").val() >= 9){
			layer.msg("组织机构树最多为10级!");
			return;
		}
		
		if(pId =="") {
			layer.msg("请选择父组织后再点击新增！", {offset: '100px'});
			return;
		}
		/*if($("#endTag").val() == "Y") {
			layer.msg("对外服务机构下不可增加子组织", {offset: '100px'});
			return;
		}*/
		layer.closeAll();
		layer.open({
			type : 2,
			skin: 'skin1',
			title : '新增组织机构',
			shadeClose : true,
			shade : 0,
			area : [ '400px', '380px' ],
            content : getRootPath() + '/org/edit/0?pId='+ pId
		});
	});
	
});