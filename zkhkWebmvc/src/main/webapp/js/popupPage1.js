var dialog;
function loadjscssfile(filename, filetype) {

	if (filetype == "js") {
		var fileref = document.createElement('script');
		fileref.setAttribute("type", "text/javascript");
		fileref.setAttribute("src", filename);
	} else if (filetype == "css") {

		var fileref = document.createElement('link');
		fileref.setAttribute("rel", "stylesheet");
		fileref.setAttribute("type", "text/css");
		fileref.setAttribute("href", filename);
	}
	if (typeof fileref != "undefined") {
		document.getElementsByTagName("head")[0].appendChild(fileref);
	}

}
function setContent(id) {
	$.get(window.top.getRoot() + "/template/getOpintionTemplat?id=" + id,
			function(result) {
				editor['html'](result.content).hideDialog().focus();
				editor.sync();
			});
}

function popup(orgid, type, actionName) {	
	var pageNum = $('#toPage').val() || 1 ,num = +$("#pageNo").val(),totalPage = +$("#pageTotal").html(), pageSize =$('#pageSize option:selected').val() || 10;
	
	var url = window.top.getRoot() + "/template/getOpintionTemplatList?orgId=" + orgid
	+ "&type=" + type;
	
	if (actionName === 'pageFirst') {
		if (num == 1) {
			return;
		}
		url += "&pageNo=1";
	} else if (actionName === 'pre') {
		if (num == 1) {
			return;
		}
		url += "&pageNo=" + (num - 1);

	} else if (actionName === 'nex') {
		if (num == totalPage) {
			return;
		}
		url += "&pageNo=" + (num + 1);

	} else if (actionName === 'pageLast') {
		if (num == totalPage) {
			return;
		}
		url += "&pageNo=" + totalPage;
	} else if (actionName === 'go') {

		if(isNaN(pageNum) || +pageNum < 1) {
			alert("请输入正确的页数！");
			$('#toPage').val(1);
			return ;
		}
		if (pageNum > totalPage) {
			alert("超过最大页了！");
			$('#toPage').val(num);
			return ;
		}
		url += "&pageNo=" + pageNum;
	}
	
	editor.hideDialog();
	
	$.get(url, function(result) {
		if (result.totalCount <= 0) {
			alert('当前管理员未创建报告审核意见模板');
			return false;
		}
		var arr = [ '<div style="padding:10px 20px;">',
				'<table class="table" style="width: 100%">',
				'    <tr><th>序号</th><th>模板名称</th><th>选择</th></tr>'

		];
		var page = ('<div class = "page" style = "margin:10px 0;" > <input id="pageNo" type="hidden" value=" ' + result.pageNo + '"/><a id="page-first" class="page-btn" onclick=" popup(' + orgid + ',' + type + ',' + '\'pageFirst\')">首页</a>' + '<a id="pre" class="page-btn" onclick="popup(' + orgid + ',' + type + ',\'pre\'' + ')">' + '<span></span>' + '</a>' +
				'<span>一页显示' + '<select id="pageSize" class="page-num" name="pageSize"  onchange="popup(' + orgid + ',' + type +')"> <option value ="10"' + ((result.pageSize == 10)? 'selected = "selected"': '') + '>10</option>' + '<option value ="20" ' + ((result.pageSize == 20)? 'selected = "selected"': '') + '>20</option>' + '<option value="30" ' + ((result.pageSize == 30)? 'selected = "selected"': '') + '>30</option></select>' +
				'条</span>' + '<span class="page-total">共<i id="pageTotal">' + result.totalPages + '</i>页</span>' + '<a id="nex" class="page-btn" onclick="popup(' + orgid + ',' + type + ',\'nex\'' + ')"><span></span></a>' + '<span>跳转到：' + '<input type="text" id="toPage" class="page-go" value="' + result.pageNo + '"/>' + '</span>' + '<a class="page-btn" id="toPage-btn" onclick="popup(' + orgid + ',' + type + ',\'go\'' + ')">Go</a>' + '<a id="page-last" style="color: #333" class="page-btn" onclick=" popup(' + orgid + ',' + type + ',' + '\'pageLast\')">尾页</a>' + '</div></div>');
		$(result.result).each(
				function(index, template) {
					arr.push('<tr><td>' + (index + 1) + '</td><td>'
							+ template.name
							+ '</td><td><input name="radioBtn" type="radio" '
							+ (index === 0 ? 'checked="checked"' : '')
							+ ' value="' + template.id + '" /> </td></tr>');
				})
		html = [ arr.join(''), '</table>',page, '</div>' ].join('');
		dialog = editor.createDialog({
			name : name,
			width : 700,
			title : '载入审核意见模板',
			body : html,
			yesBtn : {
				name : '确定',
				click : function(e) {					
					var id = $('input[name=radioBtn]:checked').val();
					setContent(id);

				}
			}
		});
		//定位 载入审核意见模板 
		$(".ke-dialog").css({top: '160px', left: '250px'});
		//禁用载入审核意见模板的移动事件
		KindEditor('.ke-dialog-header').css({cursor: 'default'});
		KindEditor('.ke-dialog-header').unbind();
		if(result.pageNo > 1){
	        $("#page-first").css({"color":"#333","cursor":"pointer"});
	        $("#pre span").css({"background":"url("+window.top.getRoot() +"/img/arrow-l.png) center no-repeat"});
	        $("#pre").css({"cursor":"pointer"});
	     }
		if(result.pageNo === result.totalPages){
	        $("#page-last").css({"color":"#ccc","cursor":"default"});
	        $("#nex span").css({"background":"url("+window.top.getRoot() + "/img/arrow-r-gray.png) center no-repeat","cursor":"default"});
	        $("#nex").css({"cursor":"default"});
	     }
	});
}

loadjscssfile(window.top.getRoot() + "/css/popupstyle.css", "css")