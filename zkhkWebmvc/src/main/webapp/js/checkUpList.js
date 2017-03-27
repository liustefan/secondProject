function del() {
	var checkList = $(".table-content input[name='ids']:checked");
	
	if (checkList.length <= 0) {
		layer.alert('请选择健康体检信息', {skin: 'skin1', shade: 0})
		return;
	}
	
	layer.confirm("确定要删除？", {
		  skin : 'skin1',
		  shade: 0,
	      btn: ['确认','取消'] //按钮
	  }, function(i){
		  $.ajax({
			   type: "post",
			   url:  "remove",
			   data: $.param(checkList),
			   success: function(msg){
			     layer.alert(msg.content, {skin: 'skin1', shade: 0, end: function(index){
			    	 if(msg.status)
			    		 window.location.reload();
			     }}, function() {
			    	 if(msg.status)
			    		 window.location.reload();
			     });
			   }
			})
			layer.close(i);
	  }, function(){
	      
	  });
}

$(function() {
	// 全选
	$("#allSelect").click(function() {
		$(":checkbox:not(:disabled)").each(function() {
			this.checked = true;
		});
	});
	// 反选
	$("#unSelect").click(function() {
		$(":checkbox:not(:disabled)").each(function() {
			this.checked = !this.checked;
		});
	});
});