<%@ page contentType="text/html; charset=utf-8" language="java" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%> 
<%
String path = request.getContextPath();
String datetime=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()); //获取系统时间 
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>新增/修改会员标签</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.validate.min.js"></script>
	<style>
		.main-box ul li {
			margin: 20px 8px;
		}
		
		.fix-label {
			text-align: right;
			font-size: 14px;
			width: 15%;
		}
		
		.text-top {
	        vertical-align: text-top;
	    } 
	    
	    .width-input {
	    	width: 250px;
	    }
	    
	    .mg-18 {
	    	margin: 15px 0 15px 15%;
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
	</style>
	<script type="text/javascript">
		function validTitle(){
			$.ajax({
				type : "POST",
				url : "selectLabelItemIsExist",
				data : {                     //要传递的数据
			    	'itemname': function() {
			            return $("input[name='itemname']").val().trim();
			        }
				},
				success : function(reponse) {
					if(reponse.status){
						layer.confirm("当前输入的标签名称与现有"+reponse.content+"标签中名称重复，请确认是否增加？", {
							skin : 'skin1',
					   	    shade: 0.3,
					   	 	btn: ['确定','取消']
						}, function(){
							layer.closeAll();
						}, function(){
							$("input[name='itemname']").val('');
							layer.closeAll();
						});
					}
					
				}
			});
			
		}
		
		$(function() {
			jQuery.validator.addMethod("isBlank", function(value, element) {
				return $.trim(value) != '';
				}, "必填!");
			
			var validate = $("#form1").validate({
				rules : {
					'itemname' : {
						isBlank: true,
					},
				},
				messages : {
					'itemname' : {
						isBlank: "必填!",
					},
				}
			});
	
			var $form = $('#form1'); 
			$('#save').click(function() {
				if($("select[name='lclassid'] option:selected").val() == ''){
					$("#lclassid_error").html("请选择标签分类!");
					return;
				}else {
					$("#lclassid_error").html("");
				}
				
				if(validate.form()){
					$("#save").attr("disabled", true);
					$.ajax({
						type : "POST",
						url : "saveLabel",
						data : $("#form1").serialize(),
						success : function(msg,index) {
							alert(msg.content);
							if (msg.status) {
								window.location.href = "../label/listLabel";
							}else{
								$("#save").attr("disabled", false);
							}	
						}
					});
				}
			});
		});
	</script>
</head>
<body>
<div class="content">
	<c:if test="${pojo.litemid == null}">
	<div class="content-title">
   		会员标签管理 --- 新增
	</div>
	</c:if>
	<c:if test="${pojo.litemid != null}">
	<div class="content-title">
   		会员标签管理 --- 修改
	</div>
	</c:if>
    <form action="saveLabel" method="POST" id="form1">
    <input type="hidden" name="litemid" value="${pojo.litemid}"/>
		<div class="main-box">
			<ul>
				<li>
					<label class="fix-label">使用范围：</label> <span class="red"></span>
					<c:choose>
					<c:when test='${userInfo.roleid == "6"}'>全局</c:when>
					<c:when test='${userInfo.roleid == "1"}'>组织内</c:when>
					<c:when test='${userInfo.roleid != "1"}'>私人</c:when>
					</c:choose>
				</li>
				<c:if test='${userInfo.roleid == "6" || userInfo.roleid == "1" }'>
				<li>
					<label class="fix-label"><span class="red">*</span>标签分类：</label>
	                <select name="lclassid">
	                <option value="">请选择</option>
	                <c:forEach items="${labelClassListEdit}" var="lableClass">
	                <c:choose>
	                 <c:when test="${pojo.lclassid eq lableClass.lclassid }">
	                 <option value="${lableClass.lclassid}" selected="selected">${lableClass.classname}</option>
	                 </c:when>
	                 <c:otherwise>
	                 <option value="${lableClass.lclassid}">${lableClass.classname}</option>
	                 </c:otherwise>
	                 </c:choose>
	                </c:forEach> 
	                </select>
					<span class="red" id="lclassid_error"></span>
				</li>

				</c:if>
				<c:if test='${userInfo.roleid != "1" && userInfo.roleid != "6" }'>
				<li>
				<label class="fix-label"><span class="red">*</span>标签分类：</label>
				<span>其他</span>
				</li>
				</c:if>
				<li>
					<label class="fix-label"><span class="red">*</span>标签内容：</label>
	                <input maxlength="10" class="width-input" type="text" name="itemname" value="${pojo.itemname}" onchange="validTitle();" onKeypress="javascript:if(event.keyCode == 32)event.returnValue = false;">
	                <span id="error-itemname" class="red"></span>
				</li>
				<li>
					<label class="fix-label">备注：</label>
	                <textarea name="remarks" cols="50" rows="4" maxlength="50" class="text-top">${pojo.remarks}</textarea>
	                <span class="red"></span>
				</li>
				<li>
					<label class="fix-label">更新人：</label>
	                <span>${userInfo.realName}</span>
	                <span class="red"></span>
				</li>
				<li>
					<label class="fix-label">所属组织：</label>
					<c:choose>
					<c:when test='${userInfo.roleid == "6"}'>无组织</c:when>
					<c:when test='${userInfo.roleid == "1"}'>
					<span>${pojo.orgName}</span>
					</c:when>
					<c:when test='${userInfo.roleid != "1"}'>
					<span>${pojo.orgName}</span>
					</c:when>
					</c:choose>
	                <span class="red"></span>
				</li>
				<li>
					<label class="fix-label">更新日期：</label>
					<c:if test="${pojo.updatetime==null}">
					<%=datetime%>
					</c:if>
	                <span><fmt:formatDate value="${pojo.updatetime}" pattern="yyyy-MM-dd"/></span>
	                <span class="red"></span>
				</li>
			</ul>
		</div>
		<div class="mg-18">
	        <input type="button" class="btn-inquiry" id="save" value="保存"/>
	        <input type="button" class="btn-cancel" onclick='history.go(-1);' value="返回"/>
        </div>
	</form>
</div>
</body>
</html>
