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
    <title>新增健康资讯</title>
    <link rel="stylesheet" href="<%=path %>/css/general.css">
    
    <script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-ui/jquery-ui.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
    <script type="text/javascript" src="<%=path %>/js/kindeditor/kindeditor.js"></script>
    <script type="text/javascript" src="<%=path %>/js/kindeditor/lang/zh_CN.js"></script>
    <script type="text/javascript" src="<%=path %>/js/advertIMG.js"></script>
    <script type="text/javascript" src="<%=path %>/js/msgCenter.js"></script>
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
	
   		.table-box table input[name="thumbnailFile"] {
	    	vertical-align: bottom;
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
	    
	    .checkboxs input[type=checkbox], .checkbox-inlines input[type=checkbox], .radios input[type=radio], .radio-inlines input[type=radio] {
		    margin-left: -18px !important;
		    margin-top: 3px !important;
		    position: absolute;
		}
		
		.word-info {
			width: 903px;
			overflow: auto;
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
        
        function existVal(){
        	if($('input[name="title_"]').val() == ''){
                $("#error-title").html("请输入标题!").css("color","red");
                return;
        	}else {
            	$("#error-title").html("");
            }
        	
        	if($('input[name="author"]').val() == ''){
                $("#error-author").html("请输入作者姓名!").css("color","red");
                return;
            }else {
            	$("#error-author").html("");
            }
        	
        	if($("#thumb").val() == '' && typeof($("#thumb2").attr("src")) == "undefined"){
                $("#error-thumb").html("请添加缩略图!").css("color","red");
                return;
            }else {
            	$("#error-thumb").html("");
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
        	
        	if(${pojo.statustype > '1'}){
			  	$('input[name="title_"]').prop("disabled",true).css("cursor","not-allowed");
			}	
            
        	var $form = $('#forms');
            $('#save').click(function() {
            	var title = $('input[name="title_"]').val();
            	$('input[name="title"]').val(title);
            	if($('input[name="title_"]').val() == ''){
            		$('input[name="title_"]').focus();
                    $("#error-title").html("请输入标题!").css("color","red");
                    return;
            	}else {
                	$("#error-title").html("");
                }
            	
            	if($('input[name="author"]').val() == ''){
            		$('input[name="author"]').focus();
                    $("#error-author").html("请输入作者姓名!").css("color","red");
                    return;
                }else {
                	$("#error-author").html("");
                }
            	
            	if($("#thumb").val() == '' && typeof($("#thumb2").attr("src")) == "undefined"){
            		$('#thumb').focus();
                    $("#error-thumb").html("请添加缩略图!").css("color","red");
                    return;
                }else {
                	$("#error-thumb").html("");
                }
            	
            	if($("#img_up").val() == '' && typeof($("#img_up2").attr("src")) == "undefined"){
            		$('#img_up').focus();
                    $("#error-img").html("请添加封面图!").css("color","red");
                    return;
                }else {
                	$("#error-img").html("");
                }
            	
            	if($('textarea[name="content"]').val() == ''){
            		$('#new-temp-content').focus();
                    $("#error-txtarea").html("请添加健教内容!").css("color","red");
                    return;
                }else {
                	$("#error-txtarea").html("");
                }
            	
            	if($(".word_surplus").html() == '字数超过限制，请适当删除部分内容'){
            		alert('健教内容超出限制，请删除部分内容!')
            		$('#new-temp-content').focus();
            		return;
            	}
            	
            	$form.submit();
           	});
            
            $(".new-temp-content").mouseout(function(){
            	if($('textarea[name="content"]').val() != ''){
                	$("#error-txtarea").html("");
                }
            });
        });
    </script>
</head>
<body>
    <div class="content">
    	<c:if test="${pojo.hninfoid==null}">
        	<div class="content-title">健康资讯 --- 新增</div>
        </c:if>
        <c:if test="${pojo.hninfoid!=null}">
        	<div class="content-title">健康资讯 --- 修改</div>
        </c:if>
        <form id="forms" action="saveNewsInfo" method="post" enctype="multipart/form-data">
	        <input type="hidden" name="hninfoid" value="${pojo.hninfoid}"/>
	        <input type="hidden" name="statustype" value="${pojo.statustype}"/>
	        <div class="table-box">
	            <table>
	                <tr>
	                    <td width="12%" class="text-top"><span class="red">*</span>标题：</td>
	                    <td>
	                    	<input type="hidden" name="title" value="">
	                    	<input type="text" name="title_" maxlength="50" value="${pojo.title}" onblur="existVal();">
	                    	<span id="error-title"></span>
	                    </td>
	                </tr>
	                <tr>
	                    <td class="text-top"><span class="red">*</span>作者：</td>
	                    <td>
	                    	<input type="text" name="author" value="${pojo.author}" maxlength="20" onblur="existVal();">
	                    	<span id="error-author"></span>
	                    </td>
	                </tr>
	                <tr>
	                    <td class="text-top"><span class="red">*</span>缩略图：</td>
	                    <td>
			             	<div id="preview2" class="preview">
		                    	<c:if test="${not empty pojo.coverimage}">
		                    		<img id="thumb2" src="<%=path%>/image/getImage?uniqueId=${pojo.thumbnail}" width="64" height="64">
		                    	</c:if>
	                    	</div>
	                        <input id="thumb" type="file" name="thumbnailFile" onblur="existVal();" onchange="fileChange2(this);" accept="image/*"><span id="error-thumb"></span>
	                        <p class="red">推荐64*64px，小于200KB，文件格式 jpg，bmp，png，gif</p>
	                        <input type="hidden" name="thumbnail" value="${pojo.thumbnail}"/>
	                    </td>
	                </tr>
	                <tr>
	                    <td class="text-top"><span class="red">*</span>封面图：</td>
	                    <td>
			             	<div id="preview" class="preview">
		                    	<c:if test="${not empty pojo.coverimage}">
		                    		<img id="img_up2" src="<%=path%>/image/getImage?uniqueId=${pojo.coverimage}" width="720" height="260">
		                    	</c:if>
	                    	</div>
	                        <input id="img_up" type="file" name="coverimageFile" onblur="existVal();" onchange="fileChange(this);" accept="image/*"><span id="error-img"></span>
	                        <p class="red">推荐720*260px，小于1M，文件格式 jpg，bmp，png，gif</p>
	                        <input type="hidden" name="coverimage" value="${pojo.coverimage}"/>
	                    </td>
	                </tr>
	                <tr>
	                    <td class="text-top"><span class="red">*</span>内容：</td>
	                    <td>
	                        <div class="new-temp-content">
                             	<textarea name="content">${pojo.content}</textarea>
                             	<div class="word-info">
							  		您当前输入了 <span class="word_count1">0</span> 个字符。
							   		<div class="word_surplus fr"></div>
							 	</div>
	                        </div>
	                        <span id="error-txtarea"></span>
	                    </td>
	                </tr>
	             	<tr>
	                    <td class="text-top">标签：</td>
	                    <td>
							<div id="lable.hnlabelid" class="clearfix">
								<c:choose>
									<c:when test="${not empty lableList}">
										<c:forEach items="${lableList}" var="lable" varStatus="var">
			               		<%-- 			<div class="fl padding-r">
			               					    <input name="hnlabelids" type="checkbox" value="${lable.hnlabelid }"
			               					    <c:forEach items="${pojo.healthnewsLables}" var="healthnewsLable"> 
			               					      <c:if test="${healthnewsLable.hnlabelid eq lable.hnlabelid }">checked="checked"</c:if>
			               					      </c:forEach> />
			               					    <span class="span-center">${lable.content}</span>
			               					</div> --%>
			               					<label class="checkbox-inlines">
				               					<input name="hnlabelids" type="checkbox" value="${lable.hnlabelid }"
			               					    <c:forEach items="${pojo.healthnewsLables}" var="healthnewsLable"> 
		               					        	<c:if test="${healthnewsLable.hnlabelid eq lable.hnlabelid }">checked="checked"</c:if>
		               					        </c:forEach> />
				               					${lable.content}
			               					</label>
			                			</c:forEach> 
									</c:when>
								</c:choose>
		                	</div>
	                    </td>
	                </tr>
	                <tr>
	                    <td class="text-top">是否置顶显示：</td>
	                    <td>
	                        <label class="radio-inlines">
	                        <input type="radio" name="isstickypost" value="1" checked <c:if test="${pojo.isstickypost eq '0'}">checked</c:if>>是</label>
	                        <label class="radio-inlines">
	                        <input type="radio" name="isstickypost" value="0" checked<c:if test="${pojo.isstickypost eq '1'}" >checked</c:if>>否</label>
	                    </td>
	                </tr>
	            </table>
	        </div>
	        <div class="page-box align-center">
	            <input type="button" class="btn-inquiry" id="save" value="保存">
	            <input type="button" class="btn-cancel" onclick='window.location.href="../msgCenter/listNewsInfo"' value="取消">
	        </div>
        </form>
    </div>
</body>
</html>