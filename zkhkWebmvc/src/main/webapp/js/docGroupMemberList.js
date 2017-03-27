/*
 * docGroupMemberList.jsp
 */
var setting = {
	data : {
		simpleData : {
			enable : true,
		}
	},
	view : {
		showIcon : false,
		selectedMulti : false
	},
	callback : {
		onClick : onClick,
		onExpand: zTreeOnExpand
	}
};

function submitForm() {
	$("#menuContent").hide();
	if($("#memberGroupName").val() &&$("#memberGroupName").val() !== '') {
		$("#form1").submit();	
	}
}

// 删除
function del(memGrpid, memberid) {
	layer.confirm('你确定需要删除此条记录吗？', {
		title : '提示信息',
		skin : 'skin1',
		shade : 0,
		btn : [ '确定', '取消' ]
	}, function(index) {
		$.ajax({
			type: "post",
			url: "../group/omgs!deleteMemberBydoc",
			data: {memGroupid: memGrpid, memberId: memberid},
			success: function(data){
				if(data==1){
					layer.msg("删除成功！", {
					icon: 1,
					time : 1000
					}, function(index) {
						window.location = "../group/omgs!groupMemberByDocid";
					});
				}else{
					layer.msg("删除失败！", {icon: 0});
				}
			},
		});
//		window.location="../group/omgs!deleteMemberBydoc?memGroupid="+ memGrpid + "&memberId=" +  memberid;
		//location.reload();
		layer.close(index);
	});
}

$(function() {
	// 分页
	// 置灰效果
	var 	prePage = $("#h_pre_page").val(),
		nextPage = $("#h_next_page").val(),
		pageSize = $("#pageSize").val(),
		pageNow = $("#h_page_now").val(),
		totalPage = $("#h_total_page").val();
		//url = "../group/omgs!groupMemberByDocid";
	
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
		$("#h_page_size").attr("value", pageSize);
		$("#h_page_now").attr("value", 1);
		$("#form1").submit();
		//window.location = url+"?pageSize=" + pageSize ;
	});
	
	$("#page-first").click(function() {
		var pageSize = $("#pageSize").val();
		
		if (pageNow == 1) {
			return;
		}
		$("#h_page_size").attr("value", pageSize);
		$("#h_page_now").attr("value", 1);
		
		$("#form1").submit();
		//window.location = url+"?pageSize=" + pageSize;
	});
	
	$("#page-last").click(function() {
		var pageSize = $("#pageSize").val();
		$("#h_page_size").attr("value", pageSize);
		$("#h_page_now").attr("value", totalPage);
		
		if (pageNow == totalPage) { return; }
		
		$("#form1").submit();
		//window.location = url+"?pageNow="+ totalPage +"&pageSize="+ pageSize;
	});
	
	$("#pre").click(function() {
		var pageSize = $("#pageSize").val();
		$("#h_page_size").attr("value", pageSize);
		$("#h_page_now").attr("value", prePage);
		
		if (pageNow == 1) { return; }
		
		$("#form1").submit();
		//window.location = url+"?pageNow="+prePage+"&pageSize=" + pageSize;
	});
	
	$("#nex").click(function() {
		var pageSize = $("#pageSize").val();
		$("#h_page_size").attr("value", pageSize);
		$("#h_page_now").attr("value", nextPage);
		
		if (pageNow == totalPage) { return; }
		
		$("#form1").submit();
		//window.location = url+"?pageNow="+nextPage+"&pageSize=" + pageSize;
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
		$("#h_page_size").attr("value", pageSize);
		$("#h_page_now").attr("value", num);
		$("#form1").submit();
		//window.location = url+"?pageNow=" + num + "&pageSize=" + pageSize;
	});
});