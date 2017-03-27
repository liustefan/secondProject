$(function(){
	$("#dl>a>dd").click(function(){
	    $("#dl>a>dd").each(function(i){
	        $(this).removeClass("h_nav_over");
	    });
	    $(this).addClass("h_nav_over");
	})

	$("#left>dl a>dd").click(function() {
	    $("#left>dl a>dd").each(function(i) {
	        $(this).removeClass("h_nav_over");
	    });
	    $(this).addClass("h_nav_over");
	})

    $(".seat p").click(function() {
        var child = $(this).siblings(".nav-child");
        var icon = $(this).find(".dd_span");

        if(child.is(":hidden")){
            $(".seat").addClass("margin-91");
            child.show();    //如果元素为隐藏,则将它显现
            icon.html("v");
        }else{
            $(".seat").removeClass("margin-91");
            child.hide();     //如果元素为显现,则将其隐藏
            icon.html(">");
        }
    })

    $(".seat1 p").click(function() {
        var child = $(this).siblings(".nav-child");
        var icon = $(this).find(".dd_span");

        if(child.is(":hidden")){
            $(".seat1").addClass("margin-91");
            child.show();    //如果元素为隐藏,则将它显现
            icon.html("v");
        }else{
            $(".seat1").removeClass("margin-91");
            child.hide();     //如果元素为显现,则将其隐藏
            icon.html(">");
        }
    })

    $(".seat2 p").click(function() {
        var child = $(this).siblings(".nav-child");
        var icon = $(this).find(".dd_span");

        if(child.is(":hidden")){
            $(".seat2").addClass("margin-91");
            child.show();    //如果元素为隐藏,则将它显现
            icon.html("v");
        }else{
            $(".seat2").removeClass("margin-91");
            child.hide();     //如果元素为显现,则将其隐藏
            icon.html(">");
        }
    })
    
    $("#pubServices p").click(function() {
        var child = $(this).siblings(".nav-child");
        var icon = $(this).find(".dd_span");

        if(child.is(":hidden")){
            $("#pubServices").addClass("margin-136");
            child.show();    //如果元素为隐藏,则将它显现
            icon.html("v");
        }else{
            $("#pubServices").removeClass("margin-136");
            child.hide();     //如果元素为显现,则将其隐藏
            icon.html(">");
        }
    })
    
     $("#question p").click(function() {
        var child = $(this).siblings(".nav-child");
        var icon = $(this).find(".dd_span");

        if(child.is(":hidden")){
            $("#question").addClass("margin-46");
            child.show();    //如果元素为隐藏,则将它显现
            icon.html("v");
        }else{
            $("#question").removeClass("margin-46");
            child.hide();     //如果元素为显现,则将其隐藏
            icon.html(">");
        }
    })
});

/*文字滚动效果*/
$(function () {
    var h=$("#div1").html();
	if($("#div1 li").length>10){
		$("#div2").html(h); //当数据大于10条的时候将div2的html设置成div1的html
	}
	var mar = function () {
		if ($("#ww1").scrollTop() > $("#div1").height()) { //当滚动条隐藏的长度大于div1的宽度
			$("#ww1").scrollTop(0);
		}
		else {
			$("#ww1").scrollTop($("#ww1").scrollTop() + 1); //每次滚动条往上移动1px；
		}
	};
	var vid = setInterval(mar, 50);
	$("#ww1").mouseenter(function () {
	    clearInterval(vid);
    }).mouseleave(function () {
	    vid = setInterval(mar,50);
    });
});

/*设置左边iframe下面div的高度消除空白*/
$(function(){
    //取到窗口的高度
    var winH = $(window).height();
    $(".desktop-left").css('height',winH-100);
    $(window).resize(function() {
        var winH = $(window).height();
        $(".desktop-left").css('height',winH-100);
    });
})

