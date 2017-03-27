function update(memberid,name){
	 $("#upMid").val(memberid);
	 
	 $("#del_gp").css("display","none");
	 $.ajax({
		 type: "GET",
		 url: '../mem/MemberAction!getTreeByDocid',
		 asyn: false,
       success: function(data){
            var zNodes =eval(data);
            
				$.fn.zTree.init($("#updateTree"), setting2, zNodes);
				$("#del_gp").show();
				var bh = $(document).height(); 
				var bw = $(document).width(); 
				    $("#fullbg").css({ 
				    height:bh, 
				    width:bw, 
				    display:"block" 
				    }); 
				/*以下为鼠标拖动弹出层改变其位置*/
			    var _x,_y,isMove=false;
			    $(function(){
			    $('.closes').mousedown(function(e) {
				_x=e.pageX-parseInt($("#del_gp").css("left"));
				_y=e.pageY-parseInt($("#del_gp").css("top"));
				//$('.ques_type').fadeTo(20, 0.5);//点击后开始拖动并透明显
				isMove = true;
				});
				$(this).mousemove(function(e) {
				
				if(isMove){
					var x=e.pageX-_x;//移动时根据鼠标位置计算控件左上角的绝对位置
					var y=e.pageY-_y;
					$("#del_gp").css({top:y,left:x});//控件新位置
					if( x < 0 ){$("#del_gp").css({left:0});}
					if( y < 0 ){$("#del_gp").css({top:0});}
				  }
				});
				$(this).mouseup(function(e) {
				isMove = false;
				$('.closes').fadeTo("fast", 1);
				});
			  });
			  /*拖动结束*/
				$("#upMsg").html("您将要修改 " + name +" 的分组类别");	
        }
   });
}
$(function() {
	$("#addListToGroup").click(function(){
	    var names =[];
		$("input[name='memId']:checked").each(function(){ 
			names.push($(this).data("memname"));
		});
		 if (names.length == 0) {
			alert("请选中你要分组的会员！");
         return ;
   	     } 
		 
   	     $("#memMsg").html("您要将 "+names.toString()+" 加入到以下勾选的分组中");
       	  $.ajax({
              type: "GET",
              url: "../mem/MemberAction!getTreeByDocid",
              asyn: false,
              success: function(data){
  	             var zNodes =eval(data);
  					$.fn.zTree.init($("#treeboxbox"), setting2, zNodes);
  					$("#ques_type_1").show();
  					var bh = $(document).height(); 
  					var bw = $(document).width(); 
  					    $("#fullbg").css({ 
  					    height:bh, 
  					    width:bw, 
  					    display:"block" 
  					    }); 
  					/*以下为鼠标拖动弹出层改变其位置*/
  				    var _x,_y,isMove=false;
  				    $(function(){
  				    $('.closes').mousedown(function(e) {
  					_x=e.pageX-parseInt($("#ques_type_1").css("left"));
  					_y=e.pageY-parseInt($("#ques_type_1").css("top"));
  					//$('.ques_type').fadeTo(20, 0.5);//点击后开始拖动并透明显
  					isMove = true;
  					});
  					$(this).mousemove(function(e) {
  					
  					if(isMove){
  						var x=e.pageX-_x;//移动时根据鼠标位置计算控件左上角的绝对位置
  						var y=e.pageY-_y;
  						$("#ques_type_1").css({top:y,left:x});//控件新位置
  						if( x < 0 ){$("#ques_type_1").css({left:0});}
  						if( y < 0 ){$("#ques_type_1").css({top:0});}
  					  }
  					});
  					$(this).mouseup(function(e) {
  					isMove = false;
  					$('.closes').fadeTo("fast", 1);
  					});
  				  });
  				  /*拖动结束*/
               }
          });
      });
});