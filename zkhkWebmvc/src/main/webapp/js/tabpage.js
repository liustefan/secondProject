$(document).ready(function(){
	
	$(".tab li").click(function() {
		$(".tab li").removeClass("active");
		$(this).addClass("active");

		$(".tab-page").hide();
		var page = $(this).data("page");
		$('#' + page).show();
	});
});