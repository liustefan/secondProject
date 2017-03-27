// 日期格式
function checkDate(object){
   /* if(!(/[0-9]{4}-[0-9]{2}-[0-9]{2}$/).test($(object).val())){*/
   var reg = /^((((1[6-9]|[2-9]\d)\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\d|3[01]))|(((1[6-9]|[2-9]\d)\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\d|30))|(((1[6-9]|[2-9]\d)\d{2})-0?2-(0?[1-9]|1\d|2[0-8]))|(((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-))(\s(([01]\d{1})|(2[0123])):([0-5]\d):([0-5]\d))?$/;
   if(!reg.test($(object).val())){
	alert("日期格式错误！");
    	$(object).focus();
    	return false;
    }
    return true;
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
	            if ($(window.event.srcElement).hasClass('ui-datepicker-close'))
	            {
	             document.getElementById(this.id).value = '';
	            }
	           },}; 
	        $.datepicker.setDefaults($.datepicker.regional['zh-CN']); 
	        
	$("#startDate").datepicker({
        dateFormat: "yy-mm-dd",
        maxDate: "+d",
        stepMonths: 12,
        changeMonth: true,
        changeYear: true,
        
		onSelect:function(dateText, inst) {
            $( "#endDate" ).datepicker( "option","minDate",dateText );
        },
    });
	
	$("#endDate").datepicker({
        dateFormat: "yy-mm-dd",
        maxDate: "+d",
        stepMonths: 12,
		defaultDate : new Date(),
        changeMonth: true,
        changeYear: true,
        
		onSelect:function(dateText, inst) {
            $( "#startDate" ).datepicker( "option","maxDate",dateText );
        },
        
//        onClose : function(dateText, inst) {
//        	
//            if (dateText && dateText < $("#startDate").val()){
//              $( "#endDate" ).datepicker( "show" );
//			    alert("结束日期不能小于开始日期！");
////				$("#endDate").val(new Date())
//            }
//        }
    });
	
	$("#startDate").on("click",function(){
        $("#endDate").attr("disabled",false);
    });
	
	//生效日期
	$("#startDate2").datepicker({
        dateFormat: "yy-mm-dd",
        maxDate: "+d",
        stepMonths: 12,
        changeMonth: true,
        changeYear: true,
        
		onSelect:function(dateText, inst) {
            $( "#endDate2" ).datepicker( "option","minDate",dateText );
        },
    });
	
	$("#endDate2").datepicker({
        dateFormat: "yy-mm-dd",
        maxDate: "+d",
        stepMonths: 12,
		defaultDate : new Date(),
        changeMonth: true,
        changeYear: true,
        
		onSelect:function(dateText, inst) {
            $( "#startDate2" ).datepicker( "option","maxDate",dateText );
        },
        
//        onClose : function(dateText, inst) {
//        	
//            if (dateText && dateText < $("#startDate").val()){
//              $( "#endDate" ).datepicker( "show" );
//			    alert("结束日期不能小于开始日期！");
////				$("#endDate").val(new Date())
//            }
//        }
    });
	
	$("#startDate2").on("click",function(){
        $("#endDate2").attr("disabled",false);
    });
	
	//发布日期
	$("#availDate").datepicker({
        dateFormat: "yy-mm-dd",
        //maxDate: "+d",
        stepMonths: 12,
        changeMonth: true,
        changeYear: true,
	});
	
/*	function availDate () {
		$("#availDate").datepicker({
	        dateFormat: "yy-mm-dd",
	        maxDate: "+d",
	        stepMonths: 12,
	        changeMonth: true,
	        changeYear: true,
		});
	}*/
	
	$('#birthStart').datepicker({
        dateFormat: "yy-mm-dd",
        maxDate: "+d",
        stepMonths: 12,
        changeMonth: true,
        changeYear: true,
        
		onSelect:function(dateText, inst) {
            $( "#birthEnd" ).datepicker( "option","minDate",dateText );
        },
    });
	
	$("#birthEnd").datepicker({
        dateFormat: "yy-mm-dd",
        maxDate: "+d",
        stepMonths: 12,
		defaultDate : new Date(),
        changeMonth: true,
        changeYear: true,
    });
	
	$("#birthStart").on("click",function(){
        $("#birthEnd").attr("disabled",false);
    });
	

	$("#visitDate").datepicker({
        dateFormat: "yy-mm-dd",
        maxDate: "+d",
        stepMonths: 12,
		defaultDate : new Date(),
        changeMonth: true,
        changeYear: true,
        onSelect:function(dateText, inst) {
        	// 下次随访日期+1天
        	
        	var tempF = new Date(dateText).valueOf(); // 先将随访日期 转成 毫秒数
        	var numNextD = tempF + 60* 60 * 24 * 1000; // 毫秒数 + 一天 （一天= 60s * 60m * 24h * 1000ms)
        	var nextD = new Date(numNextD); // 将计算后的毫秒数转成日期格式 
        	
            $( "#followDate" ).datepicker( "option","minDate",nextD );
        },
    });
	
	var MinD = $("#visitDate").val();
	var dateMS = new Date(MinD).valueOf(); // 先将随访日期 转成 毫秒数
	var NextDateMS = dateMS + 60* 60 * 24 * 1000; // 毫秒数 + 一天 （一天= 60s * 60m * 24h * 1000ms)
	var NDdefault = new Date(NextDateMS); // 将计算后的毫秒数转成日期格式 
	
	$("#followDate").datepicker({
        dateFormat: "yy-mm-dd",
        minDate: NDdefault,
        stepMonths: 12,
        defaultDate : new Date(),
        changeMonth: true,
        changeYear: true,
    });
	
	//延迟任务计划执行时间
	var tempF1 = new Date().valueOf(); // 先将当前日期 转成 毫秒数
	var numNextD1 = tempF1 + 60* 60 * 24 * 1000; // 毫秒数 + 一天 （一天= 60s * 60m * 24h * 1000ms)
	var nextD1 = new Date(numNextD1); // 将计算后的毫秒数转成日期格式 
	$("#planTime,#execTime,#planTime2").datepicker({
        dateFormat: "yy-mm-dd",
        minDate: nextD1,
        stepMonths: 12,
        changeMonth: true,
        changeYear: true,
    });
	
	//任务计划时间包括当天及以后
	$("#planTime3").datepicker({
        dateFormat: "yy-mm-dd",
        minDate: new Date(),
        stepMonths: 12,
        changeMonth: true,
        changeYear: true,
    });
	
	$("#firstTime,#lastTime").datepicker({
        dateFormat: "yy-mm-dd",
        stepMonths: 12,
        changeMonth: true,
        changeYear: true,
    });
  });