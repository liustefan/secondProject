//top.js头部菜单
$(function(){
   var mwidth = $(window).width();
   $("#menu_right").css({'width':mwidth-330,'min-width':'694px'})
   /*$("#menu_right").width(mwidth-330);*/

   $(window).resize(function() {
	 var mwidth=$(window).width();
     /*$("#menu_right").width(mwidth-330);*/
     $("#menu_right").css({'width':mwidth-330,'min-width':'694px'})
	});

	$('th').click(function(e){
		$("th").each(function(){
			$(this).removeClass('thcolor');
		});
		$(this).addClass('thcolor');
	})
});

/*动态改变中间层左侧的iframe高度 */
$(function(){
	//取到窗口的高度
	var winH = $(window).height();
	var winW = $(window).width();

	$('#content_box').css({
		'height': winH-102,
		'width': winW,
	 	'min-width':'1024px'
	})

	$("#left").css('height',winH-102);
	$("#leftIframe").css('height',winH-229);

	$("#right").css({'height':winH-102,'width':winW-310});
	$("#rightIframe").css({'height':winH-102,'width':winW-310});


	$(window).resize(function() {
		var winH = $(window).height();
		var winW = $(window).width();
		$('#content_box').css({
		'height': winH-102,
		'width': winW,
		'min-width':'1024px'
		})

		$('body').css({
		'min-width':'1024px'
		})

		$("#left").css('height',winH-102);
		$("#leftIframe").css('height',winH-229);

		$("#right").css({'height':winH-102,'width':winW-310});
		$("#rightIframe").css({'height':winH-102,'width':winW-310});
	});
})


//初始化中间层右侧的iframe高度
function reinitIframe(){
    var iframe = document.getElementById("rightIframe");
    try{
        var bHeight = iframe.contentWindow.document.body.scrollHeight,
            dHeight = iframe.contentWindow.document.documentElement.scrollHeight,
            height = Math.max(bHeight, dHeight);
            iframe.height =  height;
    }catch (ex){}

}
window.setInterval("reinitIframe()", 200);

//左侧无缝滚动
$(function () {
	var h=$("#div1").html();
	if($("#div1 li").length>10){
		$("#div2").html(h); //当数据大于10条的时候将div2的html设置成div1的html
	}
	var mar = function () {
		if ($("#ww1").scrollTop() > $("#div1").height()) { //当滚动条隐藏的长度大于div1的宽度
			$("#ww1").scrollTop(0);
		}else {
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

//心电动画
(function(A){
	function _DEMO(obj){
	this.ele = document.getElementById(obj);
	this.interval = false;
	this.currentNode = 0;
	this.passNode = 0;
	this.speed = 100;
	this.childs = _childs(this.ele);
	this.childHeight = parseInt(_style(this.childs[0])['height']);
	    addEvent(this.ele,'mouseover',function(){
            window._loveYR.pause();
		});
	    addEvent(this.ele,'mouseout',function(){
			window._loveYR.start(_loveYR.speed);
		});
   }
   function _style(obj){
     return obj.currentStyle || document.defaultView.getComputedStyle(obj,null);
   }
   function _childs(obj){
	  var childs = [];
	  for(var i=0;i<obj.childNodes.length;i++){
		 var _this = obj.childNodes[i];
		 if(_this.nodeType===1){
			childs.push(_this);
		 }
	  }
	  return childs;
   }
	function addEvent(elem,evt,func){
	   if(-[1,]){
		   elem.addEventListener(evt,func,false);
	   }else{
		   elem.attachEvent('on'+evt,func);
	   };
	}
	function innerest(elem){
      var c = elem;
	  while(c.childNodes.item(0).nodeType==1){
	      c = c.childNodes.item(0);
	  }
	  return c;
	}
	_DEMO.prototype = {
		start:function(s){
			var _this = this;
			_this.speed = s || 100;
			_this.interval = setInterval(function(){
		    	_this.ele.scrollTop += 1;
				_this.passNode++;
				if(_this.passNode%_this.childHeight==0){
					  var o = _this.childs[_this.currentNode] || _this.childs[0];
					  _this.currentNode<(_this.childs.length-1)?_this.currentNode++:_this.currentNode=0;
					  _this.passNode = 0;
					  _this.ele.scrollTop = 0;
					  _this.ele.appendChild(o);
				}
			},_this.speed);
		},
		pause:function(){
			var _this = this;
			clearInterval(_this.interval);
		}
	}
    A.marqueen = function(obj){A._loveYR = new _DEMO(obj); return A._loveYR;}
})(window);
//marqueen('demo').start(50/*速度默认100*/);

function xuan(type){
	var qcheck=document.getElementsByName("check[]");
	if(type=="qx"){
	for(var i=0;i<=qcheck.length;i++){
	    qcheck[i].checked=true;
	    }
	}
	if(type=="qxx"){
		for(var i=0;i<=qcheck.length;i++){
		     if(qcheck[i].checked){
				qcheck[i].checked=false;
		      }else{
					qcheck[i].checked=true;
		      }
	     }
	}
}
function xianum(){
	var eee=$("#ipta_a").val();
	var ddd=parseInt(eee)+1;
	$("#ipta_a").val(ddd);
}
function shangnum(){
	var eee=$("#ipta_a").val();
	var ddd=parseInt(eee)-1;
	if(ddd<1){
		$("#ipta_a").val(eee);
	}else{
		$("#").val(ddd);
	}
}

//待处理报告宽度设置
$(function(){
    $(".right_2_2 div").click(function(){
      $(this).addClass("baogao-current").siblings().removeClass("baogao-current");
    });
    var mwidth=$(window).width();
    $(".right").width(mwidth-330);
    $(window).resize(function() {
		 var mwidth=$(window).width();
      $(".right").width(mwidth-330);
		});
 });

//footer.js
$(function(){
		var mwidth=$(window).width();
		$(".foot-bottom").width(mwidth-330);
		$(window).resize(function() {
		var mwidth=$(window).width();
		$(".foot-bottom").width(mwidth-330);
	});
});