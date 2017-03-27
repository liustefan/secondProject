//tab功能切换
$(document).ready(function(){ 
	jQuery.jqtab = function(tabtit,tab_conbox,shijian) {
		// 隐藏所有section
		$(tab_conbox).find(".tab-conbox-item").hide();
		// 选中第一个nav 
		$(tabtit).find("li:first").addClass("thistab").show(); 
		// 显示第一个nav对应的内容 
		$(tab_conbox).find(".tab-conbox-item:first").show();
		// 给所有nav项 添加点击事件
		$(tabtit).find("li").bind(shijian,function(){
			$(this).addClass("thistab").siblings("li").removeClass("thistab"); 
			var activeindex = $(tabtit).find("li").index(this);
			$(tab_conbox).children().eq(activeindex).show().siblings().hide();
			return false;
			});
	};
	/*调用方法如下*/
	$.jqtab("#tab_title","#tab_conbox","click");
	/*测量结果页面tab切换*/
	$.jqtab("#nav_title","#nav_conbox","click");
})

    