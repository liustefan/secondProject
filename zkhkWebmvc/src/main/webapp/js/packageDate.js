/*memberInfoView.jsp的时间控件*/

function setDiagTime () {
	$('.diagTime').datepicker({
		dateFormat: "yy-mm-dd",
        maxDate: "+d",
        stepMonths: 12,
		defaultDate : new Date(),
        changeMonth: true,
        changeYear: true,
    });	
}

$(function() {
		$.datepicker.regional['zh-CN'] = {
		        clearText: '清除', 
		        clearStatus: '清除已选日期', 
		        closeText: '清空', 
		        closeStatus: '不改变当前选择', 
		        prevText: '<上月', 
		        prevStatus: '显示上月', 
		        prevBigText: '<<', 
		        prevBigStatus: '显示上一年', 
		        nextText: '下月>', 
		        nextStatus: '显示下月', 
		        nextBigText: '>>', 
		        nextBigStatus: '显示下一年', 
		        currentText: '今天', 
		        currentStatus: '显示本月', 
		        monthNames: ['一月','二月','三月','四月','五月','六月', '七月','八月','九月','十月','十一月','十二月'], 
		        monthNamesShort: ['一月','二月','三月','四月','五月','六月', '七月','八月','九月','十月','十一月','十二月'], 
		        monthStatus: '选择月份', 
		        yearStatus: '选择年份', 
		        weekHeader: '周', 
		        weekStatus: '年内周次', 
		        dayNames: ['星期日','星期一','星期二','星期三','星期四','星期五','星期六'], 
		        dayNamesShort: ['周日','周一','周二','周三','周四','周五','周六'], 
		        dayNamesMin: ['日','一','二','三','四','五','六'], 
		        dayStatus: '设置 DD 为一周起始', 
		        dateStatus: '选择 m月 d日, DD', 
		        dateFormat: 'yy-mm-dd', 
		        firstDay: 1, 
		        initStatus: '请选择日期', 
		        isRTL: false,
		        yearRange:"1915:2100",
		        showButtonPanel: true,
		        onClose: function (dateText, inst) {
		            if ($(window.event.srcElement).hasClass('ui-datepicker-close')) {
		            	document.getElementById(this.id).value = '';
		            }
		        },
		}; 
		$.datepicker.setDefaults($.datepicker.regional['zh-CN']); 
		setDiagTime();
		$('#birthDate').datepicker({
			dateFormat: "yy-mm-dd",
		    maxDate: "+d",
		    stepMonths: 12,
			defaultDate : new Date(),
		    changeMonth: true,
		    changeYear: true,
		});	    
});
	
//点击添加家庭成员的弹框  选择会员
//打开弹出页面 title 页面标题 ， type 页面类型， cb 打开页面之后的回调函数， source 要给页面传的参数
function openPage(title, type, cb, source) {
	var url = '',
		area = ['750px', '500px'];
	
	if(type == "member") {
		// 选择会员
//		url = '../Member/chooseFamilyMember.jsp';
		url = baseUrl + '/member/selMemFamily';
	}
	
	layer.closeAll('iframe');
	layer.open({
	    type: 2,
		skin : 'skin1',
	    title: title,
	    shadeClose: false,
	    shade: 0,
	    area: area,
	    content: url, //iframe的url
	    success: function(layero, index) {
	    		if(cb) {
	    			cb(layero, index);
	    		}
	    }
	}); 
}
function closeOpenPage(index, obj) {
	layer.close(index);
	if(obj){
		if(!obj.memId)
			obj.memId = getScope().orgsConfig.memId;
		var cardNoArr = getCardNos();
		obj.cardNos = [];
		angular.forEach(cardNoArr, function(item){
			obj.cardNos.push({cardNo: item.cardNo});
		});
		layer.open({
	   	    type: 2,
	   		skin : 'skin1',
	   	    title: '添加家庭成员',
	   	    shadeClose: false,
	   	    shade: 0,
	   	    area: ['470px', '560px'],
	   	    content: baseUrl + '/member/addFamilyMembers.jsp?tmp=' + Math.random(), //iframe的url
	   	    success: function(layero, index) {
	   	    	$("iframe")[0].contentWindow.loadData(obj, getMemTypes());
	   	    }
	   	}); 
	}
	
}