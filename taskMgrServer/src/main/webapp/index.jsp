<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>中科汇康任务中心</title>
<%@ include file="common.jsp" %>
</head>
<body  style="background:#0069ac;">
<!--主要内容--begin-->
<iframe id="mainFrame" name="mainFrame" class="ui-layout-center" width="100%"  frameborder="0" scrolling="auto" 
src="${basePath}/jobConfigController/list.do"></iframe>
<!--主要内容--end-->

<!--菜单--begin-->
<div class="ui-layout-west" style="overflow:hidden;">
  <div style="margin-top:0px; margin-right:0px; margin-left:5px; " id="ui-menu-content">
  </div>
</div>
<!--菜单--end-->

<!--头部--begin-->
<div class="ui-layout-north">
  <div class="ui-logo">
  	中科汇康研发部
  </div>
  <div id="ui-header-nav">
    <dl>
      <dt>
        <span class="ui-icon ui-icon-user"></span>
        当前用户：【${login.username }】 </dt>
      <dt class="ui-help-nomal" onmouseover="this.className='ui-help-hover'" onmouseout="this.className='ui-help-nomal'">
        <a href="#">
        <span class="ui-icon ui-icon-help"></span>
        帮助</a>
        <ul>
          <li>
            <a href="#">关于系统</a>
            <a href="#">系统帮助</a>
          </li>
        </ul>
      </dt>
      <dt>
        <a href="${basePath}/loginController/loginout.do">
        <span class="ui-icon ui-icon-loginout"></span>
        退出</a>
      </dt>
      <dt onmouseover="document.getElementById('ui-theme').style.display='';" onmouseout="document.getElementById('ui-theme').style.display='none';">
        <a href="#" >
        <span class="ui-icon ui-icon-theme"></span>
         </a>
        <div class="ui-theme" id="ui-theme" style="display:none;">
        </div>
      </dt>
    </dl>
  </div>
</div>
<!--头部--end-->
<!--底部--begin-->
<div class="ui-layout-south" style="overflow:hidden; display:none;"></div>
<!--底部--end-->
<script type="text/javascript">
var menuSource = [
        {
            name: "系统配置",
            icon: "GlobalStyle/images/ui-icon_home.gif",
            items: [
                
                { name: "定时器配置",  target: "mainFrame", url: "${basePath}/jobConfigController/list.do" }
            ]
        }
    ];
var pushleft= '<div class="ui-push-left"></div>',
    pushright= '<div class="ui-push-right"></div>',
	pushtop= '<div class="ui-push-top"></div>',
    pushbottom= '<div class="ui-push-bottom"></div>';
	
    $(document).ready(function () {
        $('body').layout({
            west: {
            size: 190
            , spacing_closed: 4
			, togglerLength_open: 100
			, togglerLength_closed: 100
            , togglerAlign_closed: "LEFT"
            , togglerContent_closed: pushright
			, togglerContent_open: pushleft
            , togglerTip_closed: "显示菜单"
            , sliderTip: "显示/隐藏菜单"
            , slideTrigger_open: "mouseover"
            }
			, north: {
			    spacing_closed: 4
			, togglerLength_open: 100
			, togglerLength_closed: 100
            , togglerAlign_closed: "center"
            , togglerContent_closed: pushbottom
			, togglerContent_open: pushtop
            , togglerTip_closed: "显示"
            , sliderTip: "显示/隐藏"
            , slideTrigger_open: "mouseover"
			,onresize :function(){
				$("#ui-menu-content").menu("refresh");
				return true;
			}
			,onclose :function(){
				$("#ui-menu-content").menu("refresh");
				return true;
			}
			}
			, center: {
			    maskContents: true  // IMPORTANT - enable iframe masking
			}
			, south: {
			    size: 0
			, spacing_closed: 0
			, togglerLength_open: 0
			, togglerLength_closed: 0
			, closable: false
			
			}
        });
		 //修正隐藏和显示条按钮的对齐方式
		$('div[title="隐藏"]').each(function(){
		    $(this).first().css("text-align", "left");
		});
		
		
        // 左边菜单
		$("#ui-menu-content").menu({
        source: menuSource
        });


        $(window).resize(function() {
            $("#ui-menu-content").menu("refresh");
        });
    });
    
    
</script>
</body>
</html>
