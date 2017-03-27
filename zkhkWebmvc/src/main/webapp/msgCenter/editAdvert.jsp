<%@ page contentType="text/html; charset=utf-8" language="java" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=9">
    <title>新增广告</title>
    <link rel="stylesheet" href="<%=path %>/css/general.css">
	
    <script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
    <script type="text/javascript" src="<%=path %>/js/kindeditor/kindeditor.js"></script>
    <script type="text/javascript" src="<%=path %>/js/kindeditor/lang/zh_CN.js"></script>	
    <script type="text/javascript" src="<%=path %>/js/advertIMG.js"></script>
	<style type="text/css">
		body {
			font-size: 14px;
		}
		
	     .table-box table td {
	        padding-top: 20px;
	    }
		
		.table-box table td p {
			line-height: 24px;
		}
		
	    .table-box table input[type="text"] {
	        width: 500px;
	    }
	
		.table-box table input[name="coverimageFile"] {
	    	vertical-align: bottom;
	    }
	    
	    .text-top {
	        vertical-align: text-top;
	        text-align: right;
	        padding-right: 10px;
	    }
	    
	    .preview img {
	    	margin-top: 0 !important;
	    }
	    
	    .word-info {
	    	width: 903px;
	    	overflow:　auto;
	    }
	</style>
	<script type="text/javascript">
	    KindEditor.ready(function(K) {
	        window.editor = K.create('textarea[name="content"]',{
	        	/* pasteType : 1, */ 
	        	afterCreate : function(){
	                 this.sync();
	             },
	             afterChange: function(){ //编辑器内容发生变化后，将编辑器的内容设置到原来的textarea控件里
	                 this.sync();
	                 $('.word_count1').html(this.count()); //字数统计包含HTML代码
	                 //$('.word_count2').html(this.count('text'));  //字数统计包含纯文本、IMG、EMBED，不包含换行符，IMG和EMBED算一个文字
	                 //////////
	                 //限制字数
	                 var limitNum = 20000;  //设定限制字数
	                 var pattern = '还可以输入' + limitNum + '字符'; 
	                 $('.word_surplus').html(pattern); //输入显示
	                 if(this.count() > limitNum) {
	                  pattern = ('字数超过限制，请适当删除部分内容');
	                  $('.word_surplus').html(pattern);
	                  $('.word_surplus').addClass('red');
	                  } else {
	                  //计算剩余字数
	                  var result = limitNum - this.count(); 
	                  pattern = '还可以输入' +  result + '字符'; 
	                  $('.word_surplus').html(pattern); //输入显示
	                  $('.word_surplus').removeClass('red');
	                  }
	             },
	             afterBlur : function(){ //编辑器聚焦后，将编辑器的内容设置到原来的textarea控件里
	                 this.sync();
	             }
	        });
	    });
	    
	    // 判断标题和封面图必填
	    function existVal(){
	    	if($('input[name="title"]').val() == ''){
                $("#error-title").html("请输入标题!").css("color","red");
                return;
            }else {
            	$("#error-title").html("");
            }
        	
        	if($("#img_up").val() == '' && typeof($("#img_up2").attr("src")) == "undefined"){
                $("#error-img").html("请添加封面图!").css("color","red");
                return;
            }else {
            	$("#error-img").html("");
            }
	    }
	    
		$(function(){
			$('textarea[name="content"]').css({'width':"900px",'height':"250px"});
			
			var $form = $('#forms');
            $('#save').click(function() {
            	if($('input[name="title"]').val() == ''){
            		$('input[name="title"]').focus();
                    $("#error-title").html("请输入标题!").css("color","red");
                    return;
                }else {
                	$("#error-title").html("");
                }
            	
            	if($("#img_up").val() == '' && typeof($("#img_up2").attr("src")) == "undefined"){
            		$('#img_up').focus();
                    $("#error-img").html("请添加封面图!").css("color","red");
                    return;
                }else {
                	$("#error-img").html("");
                }
            	
            	if($(".word_surplus").html() == '字数超过限制，请适当删除部分内容'){
            		alert('资讯内容超出限制，请删除部分内容!')
            		$('#new-temp-content').focus();
            		return;
            	}
            	
            	$form.submit();
            });
        })
	</script>
</head>
<body>
    <div class="content">
    	<c:if test="${pojo.aid==null}">
        	<div class="content-title">广告 --- 新增</div>
        </c:if>
        <c:if test="${pojo.aid!=null}">
        	<div class="content-title">广告 --- 修改</div>
        </c:if>
        <form id="forms" action="saveAdvert" method="post" enctype="multipart/form-data">
        	<input type="hidden" name="aid" value="${pojo.aid}"/>
        	<input type="hidden" name="statustype" value="${pojo.statustype}"/>
	        <div class="table-box">
	            <table>
	                <tr>
	                    <td width="12%" class="text-top"><span class="red">*</span>标题：</td>
	                    <td>
	                    	<input type="text" name="title" maxlength="50" value="${pojo.title}" onblur="existVal();">
	                    	<span id="error-title"></span>
	                   	</td>
	                </tr>
	                <tr>
	                    <td class="text-top"><span class="red">*</span>封面图：</td>
	                    <td>
	                    	<div id="preview" class="preview">
								<c:if test="${not empty pojo.coverimage}">
									<img id="img_up2" width="720" height="260" border="0" src='<%=path%>/image/getImage?uniqueId=${pojo.coverimage}' />
								</c:if>
							</div>
	                        <input id="img_up" type="file" name="coverimageFile" onblur="existVal();" onchange="fileChange(this);" accept="image/*"><span id="error-img"></span>
	                        <p>限制上传图片大小720*260像素，用于手机端广告栏显示。</p>
	                        <input type="hidden" name="coverimage" value="${pojo.coverimage}"/>
	                    </td>
	                </tr>
	                <tr>
	                    <td class="text-top">内容：</td>
	                    <td>
	                        <div class="new-temp-content">
                             	<textarea name="content">${pojo.content}</textarea>
                             	<div class="word-info">
                             		您当前输入了 <span class="word_count1">0</span> 个字符。
							   		<div class="word_surplus fr"></div> 
							 	</div>
	                        </div>
	                    </td>
	                </tr>
	                <tr>
	                    <td class="text-top">使用页面：</td>
	                    <td>
	                        <select name="usepage">
	                          <option value="1" <c:if test="${pojo.usepage eq '1'}">selected="selected"</c:if>>APP首页</option>
	                          <option value="2" <c:if test="${pojo.usepage eq '2'}">selected="selected"</c:if>>APP健康中心页面</option>
	                          <option value="3" <c:if test="${pojo.usepage eq '3'}">selected="selected"</c:if>>APP选择测量类型页面</option>
	                          <option value="4" <c:if test="${pojo.usepage eq '4'}">selected="selected"</c:if>>健康服务套餐</option>	 	                        
	                        </select>
	                    </td>
	                </tr>
	            </table>
	        </div>
	        <div class="page-box align-center">
	            <input type="button" class="btn-inquiry" id="save" value="保存">
	            <input type="button" class="btn-cancel" onclick='window.location.href="../msgCenter/listAdvert"' value="取消">
	        </div>
        </form>
    </div>
</body>
</html>