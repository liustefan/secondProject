/*
 * members.jsp
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

// 修改会员分组
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
	callback : {
		onClick : onClick,
		onExpand: zTreeOnExpand
	}
};

//// 加入会员分组
//function update(memberid, name) {
//	layer.closeAll();
//	layer.open({
//		type : 2,
//		skin : 'skin1',
//		title : '加入会员分组',
//		shadeClose : true,
//		shade : 0,
//		area : [ '330px', '400px' ],
//		content : getRootPath() + '/member/addToGroup.jsp?name=' + encodeURI(encodeURI(name)) + '&memberid='
//				+ memberid // iframe的url
//	});
//}

//修改所属会员分组
function updateMemberGroup(memberid, name, memGrpid) {
	layer.closeAll();
	var url = getRootPath() + '/member/reviseMemberGroup.jsp?name=' + encodeURI(encodeURI(name)) + '&memberid=' + memberid + '&memGrpid=' + memGrpid;
	if(memGrpid == '') {
		url = getRootPath() + '/member/reviseMemberGroup.jsp?name=' + encodeURI(encodeURI(name)) + '&memberid=' + memberid + '&batch=N';  //其他会员单个会员加入分组
	}
	layer.open({
		type : 2,
		skin : 'skin1',
		title : '修改会员分组',
		shadeClose : true,
		shade : 0,
		area : [ '300px', '380px' ],
		content : url // iframe的url
	});
}

$(function() {
	// 会员批量加入分组
	$("#addListToGroup").click(
			function() {
				var names = [], memberList = [];
				$("input[name='memId']:checked").each(function() {
					names.push($(this).data("memname"));
					memberList.push($(this).val());
				});
				if (names.length == 0) {
					layer.msg("请选中你要分组的会员！", {
						time : 1000
					});
					return;
				}
				layer.closeAll();
				layer.open({
					type : 2,
					skin : 'skin1',
					title : '会员批量加入分组',
					shadeClose : true,
					shade : 0,
					area : [ '320px', '390px' ],
					content : getRootPath() + '/member/reviseMemberGroup.jsp?name='
							+ encodeURI(encodeURI(names.toString())) + '&memberid='
							+ memberList.toString() + "&batch=Y" //iframe的url
				});
			});
});
