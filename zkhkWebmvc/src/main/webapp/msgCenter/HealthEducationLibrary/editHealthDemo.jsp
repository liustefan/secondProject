<%@ page contentType="text/html; charset=utf-8" language="java" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=9">
    <title>编辑健教库</title>
    <link rel="shortcut icon" href="<%=path %>/<%=getServletContext().getAttribute("img") %>/title_ico.ico" type="image/x-icon" />
    <link rel="stylesheet" href="<%=path %>/css/general.css">
	
    <script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="<%=path %>/js/jquery.validate.min.js"></script>
    <script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
    <script type="text/javascript" src="<%=path %>/js/kindeditor/kindeditor.js"></script>
    <script type="text/javascript" src="<%=path %>/js/kindeditor/lang/zh_CN.js"></script>
    <script type="text/javascript" src="<%=path %>/js/angular.min.js"></script>
    <script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.core-3.5.min.js"></script>
	<script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.excheck-3.5.js"></script>
	<script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.exhide-3.5.js"></script>	
	<script type="text/javascript" src="<%=path %>/js/disTree.js"></script>	
	<style type="text/css">
		.table-box {
			padding-top: 20px;
		}
		
	     .table-box table td {
	        padding-bottom: 20px;
	        font-size: 14px;
	    }
		
		.table-box table td p {
			line-height: 24px;
		}
		
	    .table-box table input[type="text"] {
	        width: 500px;
	    }
	
	    .text-top {
	        vertical-align: text-top;
	        text-align: right;
	        padding-right: 10px;
	    }
	    
	     .ke-container {
	    	display: inline-block !important;
	    	vertical-align: text-top;
	    }
	    
	    .display-inlinebk {
	    	display: inline-block;
	    }
	    
		.radios input[type=radio], .radio-inlines input[type=radio] {
			margin-top: 0\0 !important;
			margin-top: 3px\9 !important;
			margin-top: 3px !important;
		}
		
		body .skin1 .layui-layer-btn1 {
		    height: 28px;
		    margin: 0 5px;
		    padding: 0 15px;
		    font: normal 14px "Microsoft YaHei",Arial,"宋体",Helvetica,Verdana,Sans-serif;
		    color: #000;
		    display: inline-block;
		    line-height: 28px;
		    text-decoration: none;
		    border: 1px solid #6AD279;
		    border-radius: 3px;
		    -moz-border-radius: 3px;
		    -webkit-border-radius: 3px;
		    background-color: #DAF6D7 !important;
		    cursor: pointer;
		    outline: none;
		}
		
		body .skin1 .layui-layer-btn1:hover {
		    color: #fff !important;
		    font-weight: bold;
		    background-color: #64C25A !important;
		}
		
		body .skin1 .layui-layer-btn0 {
		    border: 1px solid #A9A9A9;
		    background-color: #F1F1F1 !important;
		}
		
		body .skin1 .layui-layer-btn0:hover {
		    color: #000 !important;
		    font-weight: normal !important;
		    background-color: #F1F1F1 !important;
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
	        	readonlyMode : false,
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
	    
	    //判断健教类型必填
	    function vilidState(){
	    	if($("#jjlx option:selected").val()==''){
        		$("#error-jjlx").html("请选择健教类型！").css("color","red");
        		return;
        	}else{
        		$("#error-jjlx").html("");
        	}
	    }
	    
	 	//判断标题必填
	    function existVal(){
	    	if($.trim($('input[name="title"]').val()) == ''){
                $("#error-title").html("请输入标题！").css("color","red");
                return;
            }else {
            	$("#error-title").html("");
            }
	    }
	    
	 	function changeStadu(){
	 		if($("#source_stadu option:selected").val() == 1){
				$("#show_Url input").prop("disabled",true);
				$("#show_Info textarea").prop("disabled",false);
				$("#show_Info, #show_Mode, #show_Url").hide();
				window.editor.text('');
				$("#show_Url input").val('');
				$("#show_Info").show();
			}else if($("#source_stadu option:selected").val() == 2){
				$("#show_Url input").prop("disabled",true);
				$("#show_Info textarea").prop("disabled",false);
				$("#show_Info, #show_Mode, #show_Url").hide();
				window.editor.text('');
				$("#show_Url input").val('');
				$("#show_Info, #show_Mode").show();
			}else if($("#source_stadu option:selected").val() == 3){
				$("#show_Info textarea").prop("disabled",true);
				if('${empty pojo.heducationid}' == 'true'){
					$(".content-1").prop("disabled",true);
					$(".content-2").prop("disabled",false);
				}else {
					$(".content-2").prop("disabled",true);
					$(".content-1").prop("disabled",false);
				}
				$("#show_Info, #show_Mode, #show_Url").hide();
				window.editor.text('');
				$("#show_Url input").val('');
				$("#show_Url").show();
			}
	 	}
	 	
		$(function(){
		  	//健教库查看页面不可编辑
			if('${pojo.heducationid}' != '' && '${param.view }'){
				$("#save").hide();
				$("#healthInfo").hide();
				$("input[type='text'], input[type='radio'], select").prop("disabled",true);
				KindEditor.ready(function(K) {
					editor.readonly(true);
				});
				$(".word-info").hide();
			}
			//健教库修改页面不可编辑
			if('${pojo.heducationid}' != '' && '${!param.view }'){
				$("input[name='title']").prop('readonly',true);
				$("select[name='sourceway']").prop('disabled',true);
			}
		  	
		  	
			$("#show_Info, #show_Mode, #show_Url").hide();
			if($("#source_stadu option:selected").val() == 1){
				$("#show_Url input").prop("disabled",true);
				$("#show_Info").show();
			}else if($("#source_stadu option:selected").val() == 2){
				$("#show_Url input").prop("disabled",true);
				$("#show_Info, #show_Mode").show();
			}else if($("#source_stadu option:selected").val() == 3){
				$("#show_Info textarea").prop("disabled",true);
				if('${empty pojo.heducationid}' == 'true'){
					$(".content-1").prop("disabled",true);
				}else {
					$(".content-2").prop("disabled",true);
				}
				$("#show_Url").show();
			}
			
			$('textarea[name="content"]').css({'width':"900px",'height':"250px"});
			
			var $form = $('#forms');
            $('#save').click(function() {
            	if($("#jjlx option:selected").val()==''){
            		$(window).scrollTop(0,0);
            		$("#error-jjlx").html("请选择健教类型！").css("color","red");
            		return;
            	}else{
            		$("#error-jjlx").html("");
            	}
            	
            	if($.trim($('input[name="title"]').val()) == ''){
            		$('input[name="title"]').focus();
                    $("#error-title").html("请输入标题！").css("color","red");
                    return;
                }else {
                	$("#error-title").html("");
                }
            	
            	if($(".word_surplus").html() == '字数超过限制，请适当删除部分内容'){
            		alert('资讯内容超出限制，请删除部分内容!')
            		$('#new-temp-content').focus();
            		return;
            	}
            	
            	if(!$("input[name='userange']:checked").val()){
    	    		$("#error-range").html("请选择使用范围！").css("color","red");
    	    		return;
            	}else{
            		$("#error-range").html("");
            	}
            	
            	$form.submit();
            });
        })
        
        var index = layer.getFrameIndex(window.name); //获取窗口索引
        
        function chooseDisease(){
			layer.closeAll();
			layer.open({
		   	    type: 2,
		   		skin : 'skin1',
		   	    title: '选择疾病分类',
		   	    shadeClose: false,
		   	    shade: 0,
		   	    area: ['420px', '450px'],
		   	 	content: '<%=path%>/health/templet/chooseDisease.jsp', //iframe的url
		   	}); 
		}
        
        function chooseDiseaseInfo(obj){
			$("input[name='diseaseClassify']").val(obj.diseaseName);
			$("input[name='MSDiseaseIDs']").val(obj.diseaseId);
		}
        
        //选择健康资讯
		function openHealthInfo(){
			layer.closeAll();
			layer.open({
		   	    type: 2,
		   		skin : 'skin1',
		   	    title: '选择健康资讯',
		   	    shadeClose: false,
		   	    shade: 0,
		   	    area: ['700px', '400px'],
		   	    content:'<%=path %>/health/chooseHealthInfo',
		   	}); 
		}
        
        
		function setHed(hninfoid){
			$.ajax({
				type : "POST",
				url : "chooseNewsInfoContent?id="+hninfoid,
				success : function(reponse) {
					window.editor.html(reponse)
				}
			});
			$("#sourceid").val(hninfoid);
			layer.closeAll();
		}
        
		function validTitle(){
			$.ajax({
				type : "POST",
				url : "selectHealthEducationIsExist",
				data : {                     //要传递的数据
			    	'title': function() {
			            return $("input[name='title']").val().trim();
			        }
				},
				success : function(reponse) {
					if(reponse.status){
						layer.confirm("当前输入的健教标题与现有"+reponse.content+"标签中名称重复，请确认是否增加？", {
							skin : 'skin1',
					   	    shade: 0,
					   	 	btn: ['确定','取消']
						}, function(){
							layer.closeAll();
						}, function(){
							$("input[name='title']").val('');
							layer.closeAll();
						});
					}
					
				}
			});
			
		}

	</script>
</head>
<body>
    <div class="content">
       	<div class="content-title">健教库管理 --- 
       	<c:if test="${empty pojo.heducationid}">新增</c:if>
       	<c:if test="${not empty pojo.heducationid and !param.view}">修改</c:if>
        <c:if test="${not empty pojo.heducationid and param.view}">查看</c:if></div>
        <form id="forms" action="saveHealthEducation" method="post" enctype="multipart/form-data">
	        <input type="hidden" name="heducationid" value="${pojo.heducationid}"/>
	        <div class="table-box">
	            <table>
	            	<tr>
	                    <td width="12%" class="text-top"><span class="red">*</span>健教类型：</td>
	                    <td>
		                    <select id="jjlx" name="heducationtype" onchange="vilidState();">
					          	<option value="">请选择</option>
					          	<option value="1"  <c:if test="${pojo.heducationtype eq '1'}">selected="selected"</c:if>>饮食指导</option>
					          	<option value="2"  <c:if test="${pojo.heducationtype eq '2'}">selected="selected"</c:if>>运动指导</option>
					          	<option value="3"  <c:if test="${pojo.heducationtype eq '3'}">selected="selected"</c:if>>心理指导</option>
					          	<option value="4"  <c:if test="${pojo.heducationtype eq '4'}">selected="selected"</c:if>>中医指导</option>
					          	<option value="5"  <c:if test="${pojo.heducationtype eq '5'}">selected="selected"</c:if>>生活方式指导</option>
					          	<option value="6"  <c:if test="${pojo.heducationtype eq '6'}">selected="selected"</c:if>>用药指导</option>
			        		</select>
			        		<span id="error-jjlx"></span>
	                   	</td>
	                </tr>
	                <tr>
	                    <td width="12%" class="text-top">适用疾病分类：</td>
	                    <td>
							<div class="position-r">
								<input type="hidden" name="MSDiseaseIDs" value='<c:forEach items="${pojo.diseases}" var="ds" varStatus="vs">${ds.msdiseaseid}<c:if test="${fn:length(pojo.diseases) > vs.index+1}">,</c:if></c:forEach>'>
								<input type="text" class="width-disease" readonly name="diseaseClassify" value='<c:forEach items="${pojo.diseases}" var="ds">${ds.diseaseName}；</c:forEach>'>
								<c:if test="${!param.view}">
									<i class="member-search2" onclick="chooseDisease('选择疾病分类');"></i>
								</c:if>
								<c:if test="${not empty pojo.heducationid and param.view}">
									<i class="member-search2"></i>
								</c:if>
							</div>
	                   	</td>
	                </tr>
	                <tr>
	                    <td width="12%" class="text-top"><span class="red">*</span>标题：</td>
	                    <td>
	                    	<input type="text" name="title" maxlength="50" value="${pojo.title}" onchange="validTitle();" onKeypress="javascript:if(event.keyCode == 32)event.returnValue = false;">
	                    	<span id="error-title" style="height: 20px; line-height: 20px;"></span>
	                   	</td>
	                </tr>
	                <tr>
	                    <td width="12%" class="text-top"><span class="red">*</span>来源方式：</td>
	                    <td>
	                    	<select id="source_stadu" name="sourceway" onchange="changeStadu()">
								<option value="1" <c:if test="${pojo.sourceway eq '1'}">selected="selected"</c:if>>自定义</option>
								<option value="2" <c:if test="${pojo.sourceway eq '2'|| pojo.sourceway==null}">selected="selected"</c:if>>健康资讯</option>
								<option value="3" <c:if test="${pojo.sourceway eq '3'}">selected="selected"</c:if>>复制网址</option>
							</select>
	                   	</td>
	                </tr>
	                <input type="hidden" id="sourceid" name="sourceid" value="" >
	                <tr id="show_Info">
	                    <td width="12%" class="text-top">健教内容：</td>
	                    <td>
	                        <div class="new-temp-content">
                             	<textarea name="content">${pojo.content}</textarea>
                             	<div class="display-inlinebk" id="show_Mode">
                             	<a href="javascript:void(0);" id="healthInfo" onclick="openHealthInfo()">从健康资讯中选择</a>
                             	</div>
                             	<div class="word-info">
                             		您当前输入了 <span class="word_count1">0</span> 个字符。
							   		<div class="word_surplus fr"></div>
							 	</div>
	                        </div>
	                    </td>
	                </tr>
	                <tr id="show_Url">
	                    <td width="12%" class="text-top">复制网址：</td>
	                    <td>
	                    	<c:if test="${not empty pojo.heducationid and param.view}">
	                    	<a href="${pojo.content}" target="_blank">${pojo.content}</a>
	                    	</c:if>
	                    	<c:if test="${not empty pojo.heducationid and !param.view}">
	                    	<input type="text" class="content-1" name="content" value="${pojo.content}">
	                    	</c:if>
	                    	<c:if test="${empty pojo.heducationid}">
	                    	<input type="text" class="content-2" name="content" value="${pojo.content}">
	                    	</c:if>
	                   	</td>
	                </tr>
	                <tr>
	                    <td width="12%" class="text-top"><span class="red">*</span>使用范围：</td>
	                    <td>
	                        <label class="radio-inlines">
	                        <input type="radio" name="userange" value="1" <c:if test="${pojo.userange eq '1'}">checked</c:if>>全局可见
	                        </label>
	                        <label class="radio-inlines">
	                        <input type="radio" name="userange" value="2" <c:if test="${pojo.userange eq '2'}">checked</c:if>>组织内可见
	                        </label>
	                        <label class="radio-inlines">
	                        <input type="radio" name="userange" value="3" <c:if test="${pojo.userange eq '3'}">checked</c:if>>私人可见
	                        </label>
	                        <label class="radio-inlines" id="error-range"></label>
	                    </td>
	                </tr>
	            </table>
	        </div>
	        <div class="page-box align-center">
	            <input type="button" class="btn-inquiry" id="save" value="保存">
	            <c:if test="${!param.close}">
	            	<input type="button" class="btn-cancel" value="返回" onclick='window.location.href="../health/listHealth"'>
            	</c:if>
	            <c:if test="${param.close}">
	            	<input type="button" class="btn-cancel" value="关闭" onclick='window.close();'>
	            </c:if>
	        </div>
        </form>
    </div>
</body>
</html>