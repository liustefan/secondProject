/*
 * showAllDoctors.jsp 
 */
function getRootPath(){
   /* //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
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
// 加入医生分组
function addDoctorGroup(docid, orgId) {
	layer.closeAll();
	layer.open({
		type : 2,
		skin: "skin1",
		title : '选择医生分组',
		shadeClose : false,
		shade : 0,
		area : [ '550px', '480px' ],
		content : getRootPath() + '/doctor/popAddDocGroup.jsp?docid=' + docid + "&orgid=" + orgId //iframe的url
	});
}

// 删除
function removeRecord(url) {
	layer.confirm('确认删除吗？', {shade: 0, skin: "skin1",offset: "100px;"}, function(index){
		$.ajax({
			type : "GET",
			url : url,
			success : function(msg) {
				layer.msg(msg.content,{offset: "100px;", time: 1000});
				if(msg.status) {
					window.location.href = window.location.href;
				}
			}
		});
	    layer.close(index);
	})
}

// 重置密码
function resertPwd(url) {
	layer.confirm('确认重置密码？', {shade: 0, skin: "skin1",offset: "100px;"}, function(index){
		$.ajax({
			type : "GET",
			url : url,
			success : function(msg) {
				layer.msg(msg.content,{offset: "100px;"});
			}
		});
	    layer.close(index);
	});
}