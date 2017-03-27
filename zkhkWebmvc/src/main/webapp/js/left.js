$(function(){ 
	$("#left>dl>dd").mouseover(function(){ 
		$("#left>dl>dd").each(function(i){ 
			$(this).removeClass("h_nav_over"); 
		}); 
		$(this).addClass("h_nav_over"); 
	}).mouseout(function(){ 
		$(this).addClass("h_nav_over"); 
	}); 
}); 
$(function(){   
//alert(1);
	var winH = $('#left').height();
	var winW1=  $('#left').width();
	var winH1=$(window).height();
	var winW = $(window).width();  
		if(winH>winH1){
			$('#mainFrame').css({
			'height':winH,
			'width':winW-winW1,
			'min-width':'710px'
			});
		}else{
			$('#mainFrame').css({
			'height':winH1,
			'width':winW-winW1,
			'min-width':'710px'
			});
			$('#left').css({
				'height':winH1
			});
		}
	$(window).resize(function() {
     var winH = $('#left').height();
	var winW1=  $('#left').width();
	var winH1=$(window).height();
	var winW = $(window).width();  
		if(winH>winH1){
			$('#mainFrame').css({
			'height':winH,
			'width':winW-winW1,
			'min-width':'710px'
			});
		}else{
			$('#mainFrame').css({
			'height':winH1,
			'width':winW-winW1,
			'min-width':'710px'
			});
			$('#left').css({
				'height':winH1
			});
		}
    });
});