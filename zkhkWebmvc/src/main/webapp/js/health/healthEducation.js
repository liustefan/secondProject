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

//删除健教分类
function deleteHealthdele(url){
	var msg = "您确定要删除当前健教资料吗？"
	layer.closeAll();
	layer.confirm( msg, {
		title : '提示信息',
		skin : 'skin1',
		shade : 0,
		btn : [ '确定', '取消' ]
	}, function(index) {
		$.ajax({
			url: url,
		   type: "POST",
		success: function(data) {
			alert(data.content);
		     	if(data.status) {
		     		location.href="../health/deleteHealth?id=${health.heducationid}";
		     		window.location.reload();
		     	}
		}
		});
	});
}

// 修改健教库分类
function editHealth(id) {
	layer.closeAll();
	layer.open({
		type : 2,
		skin: 'skin1',
		title : '修改健教库',
		shadeClose : true,
		shade : 0,
		area : [ '540px', '380px' ],
		content : getRootPath() + '/health/editHealth/' + id
	});
}
$(function() {
	//parent.reinitIframe();
	// 弹出新增疾病分类页面
	var pId = $("#pId").val();
	$('#add-group').on('click', function() {
		if(pId =="") {
			layer.msg("请选择父级疾病分类再新增！", {offset: '100px'});
			return;
		}
		layer.closeAll();
		layer.open({
			type : 2,
			skin: 'skin1',
			title : '新增疾病分类',
			shadeClose : true,
			shade : 0,
			area : [ '540px', '380px' ],
            content : getRootPath() + '/health/edit/0?pId='+ pId
		});
	});
	
});