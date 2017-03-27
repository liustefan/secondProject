// 添加系统管理员
function add(){
	 window.location= "../doctor/createSysAdmin.jsp";
}

$(function(){
	$(".resetPwd").click(function(){
		  var $this = this;
		  if(!$this.disabled&&confirm('确认重置密码？')){
			  $this.disabled=true;
			  $.ajax({
				   type: "GET",
				   url: $this.getAttribute("data-href"),
				   success: function(msg){
//					 msg = eval("("+msg+")");
					 alert(msg.content);
					 $this.disabled = false;
				   }
			  });
		  }
	  });
});