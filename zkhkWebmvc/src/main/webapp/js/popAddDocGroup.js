/*
 * popAddDocGroup.jsp
 */
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

var IDMark_Switch = "_switch",
        IDMark_Icon = "_ico",
        IDMark_Span = "_span",
        IDMark_Input = "_input",
        IDMark_Check = "_check",
        IDMark_Edit = "_edit",
        IDMark_Remove = "_remove",
        IDMark_Ul = "_ul",
        IDMark_A = "_a";

var zTree;

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

// 取消勾选医生分组
function cancelCheckBox(id) {
	var nodes = zTree.getNodesByParam("id", id, null);
	zTree.checkNode(nodes[0], false, false);
	$("#info_checked").html(zTree.getCheckedNodes(true).length);
}

//取消勾选医生分组 后移除下拉框
function removeSelectedBox(id) {
	$("#diyBtn_" + id).unbind().remove();
    $("#diyBtn_space_" + id).unbind().remove();
}

function showAuditLevel(treeNode){
	 var Obj = $("#" + treeNode.tId + IDMark_A),
	 	editStr = "<select class='selDemo' id='diyBtn_" + treeNode.id + "'><option value=0>请选择审核级别</option>";
     // 如果设置了审核级数N 则添加审核级别 1 － N  
     if(treeNode.maxLevel){
    	 for(var i = 1; i <= treeNode.maxLevel; i++){
        	 editStr += "<option value=" +i+" " + (treeNode.auditLevel&&treeNode.auditLevel==i?'selected="selected"':'') + ">"+i+"</option>";
         }
     }
	 editStr +="</select>";
	 Obj.after(editStr);
	 var btn = $("#diyBtn_" + treeNode.id);
     if (btn) btn.bind("change", function() {
     		if($(btn).val() !== '0') {
     			treeNode.auditLevel = $(btn).val();
     			$('i.'+treeNode.id+'_level').text('(审核级别'+$(btn).val()+')');
             $('a.'+treeNode.id+'_level').attr("title", treeNode.name+'(审核级别'+$(btn).val()+')');
     		}else {
     			treeNode.auditLevel = null;
     			$('i.'+treeNode.id+'_level').text('(审核级别)');
     			$('a.'+treeNode.id+'_level').attr("title", treeNode.name+'(审核级别)');
     		}
     });
}
// 勾选树节点操作
function onCheck(e, treeId, treeNode) {
	treeNode.auditLevel = '';
    if (treeNode.checked) {
        showAuditLevel(treeNode);
        addPanel(treeNode);
    }else {
    		removeSelectedBox(treeNode.id);
    		removePanel(treeNode.id);
	}
    $("#info_checked").html(zTree.getCheckedNodes(true).length);
}

// 删除分组
function removePanel(id) {
	$("#" +id).remove();
}

// 删除所有分组
function removeAllGroup(){
	var checkedNodes = zTree.getCheckedNodes(true);
	$(checkedNodes).each(function(i, e) {
		removeSelectedBox(e.id);
		removePanel(e.id);
	});
	zTree.checkAllNodes(false);
	//$("#selectedList").empty();
	$("#info_checked").html(zTree.getCheckedNodes(true).length);
}



function addPanel(obj) {
	if(!obj) {return;} 
	var domeStr = '<li id="'+obj.id+'"><a class="'+obj.id+'_level" href="javascript: void(0);" title="'+obj.name+'(审核级别'+(obj.auditLevel==0?'':obj.auditLevel)+')"><span class="wd4">'+obj.name+'<i class="'+obj.id+'_level">(审核级别'+(obj.auditLevel==0?'':obj.auditLevel)+')</i></span><i class="icon icon-close" onclick="cancelCheckBox('+obj.id+');removeSelectedBox('+obj.id+');removePanel('+obj.id+');"></i></a></li>';
	$("#selectedList").append(domeStr);
}

function drawSelectedGroup(list) {
	$("#info_checked").html(list.length);
	$(list).each(function(i,e) {
		showAuditLevel(e);
		addPanel(e);
	});
}

$(function() {
	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	
	// 初始化Tree			
	$.ajax({
		   type: "GET",
		   url: getRootPath() + '/docGrp/initDocGrpTree',
		   data: {doctorid: $("#docid").val()},
		   asyn: false,
		   success: function(data){
			   zTree = $.fn.zTree.init($("#treeDemo"), setting, data);
			   $("#info_total").html(data.length);
			   drawSelectedGroup(zTree.getCheckedNodes(true) || []);
		   }
		});
	// 加入医生分组 并 关闭弹框
	$("#btn-ok").bind('click', function() {
		var checkedNodes = zTree.getCheckedNodes(true);
		var postData = [];
		
//		if(checkedNodes.length <= 0) {
//			layer.msg("请选择要加入的医生分组", {offset: "100px"});
//			return;
//		}
		$(checkedNodes).each(function(i, e) {
			if(!e.auditLevel)e.auditLevel=0;
			postData.push({odgpid: e.id, docid: $("#docid").val(), auditlevel: e.auditLevel, orgid: $("#orgid").val()});
		})
		
		$.ajax({
		   type: "post",
		   url: getRootPath() + '/docGrp/bindGroup',
		   data: {json:JSON.stringify(postData), docId:$("#docid").val(), orgId: $("#orgid").val()},
		   asyn: false,
		   success: function(response){
			   if(!response.status) {
				   parent.layer.msg("加入分组失败", {icon: 0,offset: "100px"});
				   return;
			   }
			   parent.layer.msg("添加成功!", {icon: 1,offset: "100px"});
			   parent.layer.close(index);
		   },
		   error: function(response, msg) {
			   parent.layer.msg(msg);
		   }
		});
			
		 //parent.layer.close(index);
	});
	
	// 关闭弹框
	$("#btn-cancel").bind('click', function() {
		 parent.layer.close(index);
	});
});