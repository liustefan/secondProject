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

// 删除疾病分类
function delDisById(id, name) {
	layer.confirm('删除当前疾病分类后，此疾病分类与管理方案模板的关联关系会被删除，您确定要删除吗？', {
		title : '提示信息',
		skin: 'skin1',
		shade : 0,
		btn : [ '确定', '取消' ]
	},function(index) {
		layer.close(index);
		$.ajax({
			type : "POST",
			url : getRootPath() + "/health/delete/"+ id,
			success : function(msg) {
				layer.msg(msg.content,{icon: 0,time: 1000});
				if(msg.status) {
					parent.reload($("input[name='msdiseaseid']").val());
				}
			}
		});

	});
}

// 修改疾病分类
function updateDisById(id) {
	layer.closeAll();
	layer.open({
		type : 2,
		skin: 'skin1',
		title : '修改疾病分类',
		shadeClose : true,
		shade : 0,
		area : [ '540px', '380px' ],
		content : getRootPath() + '/health/edit/' + id
	});
}
$(function() {
	//parent.reinitIframe();
	// 弹出新增疾病分类页面
	var pId = $("#pId").val();
	$('#add-group').on('click', function() {
		if($("#level").val() >= 2){
			/*layer.msg("疾病分类树仅支持三层分类，此分类下不可再创建子疾病分类！");*/
			layer.alert('疾病分类树仅支持三层分类，此分类下不可再创建子疾病分类！',{
				shade : 0,
				  skin: 'skin1' //该皮肤由layer.seaning.com友情扩展。关于皮肤的扩展规则，去这里查阅
				});
			return;
		}
		
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