/*
* groupMemberTable.jsp 
*/

function submitForm() {
		$("#form1").submit();
	}

//  弹出修改会员分组页面
function updateMemberGroup(id) {
	layer.closeAll();
	layer.open({
	    type: 2,
		skin: 'skin1',
	    title: '修改会员分组',
	    shadeClose: true,
	    shade: 0,
	    area: ['450px', '450px'],
	    content: 'addMember.jsp?type=update&memberOrgId=' + id //iframe的url
	});
}

// 删除
function removeMemberGroup(id ,name) {
	layer.confirm('确定需要删除 '+name+' 医生分组吗？', {
		title: '提示信息',
		skin: 'skin1',
		shade: 0,
	    btn: ['确定','取消']
	}, function(){
		layer.msg("删除成功！",{time: 1000},function(index) {
			location.href=url;
			layer.close(index);
			})
	})
}

$(function() {
	//弹出新增会员分组页面
	$('#add-member').on('click', function(){
		layer.closeAll();
		layer.open({
		    type: 2,
			skin: 'skin1',
		    title: '新增会员分组',
		    shadeClose: true,
		    shade: 0,
		    area: ['450px', '450px'],
		    content: 'addMember.jsp?type=new' //iframe的url
		});
	});
	// 分页
	// 置灰效果
	var 	prePage = $("#h_pre_page").val(),
		nextPage = $("#h_next_page").val(),
		pageSize = $("#pageSize").val(),
		pageNow = $("#h_page_now").val(),
		totalPage = $("#h_total_page").val();
		orgId = $("#org_id").val();
		url = "";
	
	if (pageNow != 1) {
		$("#page-first").css({
			"color" : "#333",
			"cursor" : "pointer"
		});
		
		$("#pre span").css({
			"background" : "url(../img/arrow-l.png) center no-repeat"
		});
		
		$("#pre").css({
			"cursor" : "pointer"
		});
	}
	//  最后一页时 
	if (pageNow == totalPage) {
		$("#page-last").css({
			"color" : "#ccc",
			"cursor" : "default"
		});
		
		$("#nex span").css({
			"background" : "url(../img/arrow-r-gray.png) center no-repeat",
			"cursor" : "default"
		});
		
		$("#nex").css({
			"cursor" : "default"
		});
	}
	
	$("#pageSize").change(function() {
		var pageSize = $("#pageSize").val();
		
		window.location = url+"?orgId="+orgId+"&pageSize=" + pageSize ;
	});
	
	$("#page-first").click(function() {
		var pageSize = $("#pageSize").val();
		
		if (pageNow == 1) {
			return;
		}
		window.location = url+"?orgId="+orgId+"&pageSize=" + pageSize;
	});
	
	$("#page-last").click(function() {
		var pageSize = $("#pageSize").val();
		
		if (pageNow == totalPage) { return; }
		
		window.location = url+"?orgId="+orgId+"&pageNow="+ totalPage +"&pageSize="+ pageSize;
	});
	
	$("#pre").click(function() {
		var pageSize = $("#pageSize").val();
		
		if (pageNow == 1) { return; }
		
		window.location = url+"?orgId="+orgId+"&pageNow="+prePage+"&pageSize=" + pageSize;
	});
	
	$("#nex").click(function() {
		var pageSize = $("#pageSize").val();
		
		if (pageNow == totalPage) { return; }
		
		window.location = url+"?orgId="+orgId+"&pageNow="+nextPage+"&pageSize=" + pageSize;
	});
	
	$("#toPage-btn").click(function() {
		var pageSize = $("#pageSize").val(),
			num = $("#toPage").val(),
			reg = /^[1-9]\d*$/,
			topage = $("#toPage");

		if (!reg.test(num)) {
			alert("请输入正确的页码！");
			topage.val(pageNow);
			return false;
		}
		
		if (+num > +totalPage) {
			alert("超过最大页了！");
			topage.val(pageNow);
			return false;
		}
		
		window.location = url+"?orgId="+orgId+"&pageNow=" + num + "&pageSize=" + pageSize;
	});
});