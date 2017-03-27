<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
    <title>添加组合问卷界面</title>
   	<link rel="stylesheet" href="<%=path %>/css/general.css">
   	<link rel="stylesheet" href="<%=path %>/css/showques.css">
   	<link rel="stylesheet" href="<%=path %>/css/questionnaire.css">
	<link rel="stylesheet" href="<%=path %>/css/tab.css">
    
   	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.validate.min.js"></script>
	
	<style type="text/css">
	.txt-normal {
		 padding: 5px 2px; 
		 border: 1px solid #ccc;
		 font: 12px "Microsoft YaHei",Helvetica,Verdana,Sans-serif;
		 color: #333;
	}
	
	input.error {
	  border: 1px dotted red;
	}
	
	form label.error, label.error, span.error {
	  color: red;
	  margin-left: 10px;
	}
	
	input[name="combQustName"] {
		width: 293px;
	}
	</style>
	
	<script type="text/javascript">
	var questList = [];
	<c:forEach items="${pojo.cqt1s}" var="cqt1">questList.push({id:${cqt1.qustid}, content: '<c:out value="${cqt1.qustname}" escapeXml="true"/>'});</c:forEach>
	function addSingle(){
		layer.open({
		    type: 2,
		    skin: 'layui-layer-normal',
		    title: '<b>载入单份问卷</b>',
		    fix: false,
		    area: ['700px', '470px'],
		    content: ['../singleQuestion/chooseQuestions?tmp=' + Math.random(), 'no']
		});
	}
	
	function btnMethod(OK){
		 if(OK){
			 $("#singleList").html('');
			 $(questList).each(function(i,e) {
				 add(e);
			 })
			}
		layer.closeAll();
	}
	
	function getQustIds(){
		return questList;
	}
		
	function addSelectedRow(omfq){
		questList.push({id:omfq.qustid, content: omfq.qustname});
	}
	
	function removeSelectedRow(qustid){
		questList.removeValue(qustid);
	}
	
	function add(omfq){
		if(!omfq) return;
		var ol = $("#singleList");
		var li = '<li id="id_' + omfq.id + '" class="selectedRow"><span>'+ omfq.content +'</span><input type="button" class="btn btn-delete1" value=" " onclick="removeRow(' + omfq.id +');"></li>';
		ol.append(li);
	}
	
	function submitForm(){
		if($("#qustname").val() == ""){
			alert("问卷名称不能为空");
			return ;
		}else if($("#Questionnaireexplain").val() == ""){
			alert("简介不能为空");
			return ;
		}
		if(questList.length == 0){
			alert("您尚未添加该问卷包含的单份问卷，请添加！");
			return;
		}
		$("#myForm").submit();
	}
	
	Array.prototype.removeValue = function(val){
		for(var i = 0; i < this.length; i++){
			if(this[i].id == val){
				this.splice(i,1);
				break;
			}
		}
	};
	
	function removeRow(qustid){
		$('#singleList .selectedRow').remove('#id_'+qustid);
		questList.removeValue(qustid);
	}
	
	function release(){
		$("input[name='qustTag']").val("T");		
	}
	
	$(function(){
			$("#form1").validate({
				rules: {
					'combQustName': {
						required: true,
						// 新建则验证唯一 修改不验证
						remote: ${empty pojo.combQustid}?{
							url:"checkNameUnique",
							data:{
								name: function(){return $("input[name='combQustName']").val();}
							}
						}: false
					},
					'combDesc': {
						maxlength: 200
					}
				},
				messages: {
					'combQustName': {
						required: "问卷名称不能为空",
						remote: "问卷名称已存在"
					},
					'combDesc': "最大长度不能超过{0}"
				},submitHandler: function(form){     
					if(questList.length == 0){
						alert("您尚未添加该问卷包含的单份问卷，请添加！");
					}else{
						var questIdsList = [];
						$(questList).each(function(index, element) {
							questIdsList.push(element.id);
						});
						$("#questIds").val(questIdsList.join(","));
						console.log($("#questIds").val());
						form.submit();
					}
				}
			});
	});
	</script>
</head>
<body>
<div class="content">
	<div class="content-title">
		组合问卷列表 --- <c:if test="${empty pojo.combQustid}">创建问卷</c:if><c:if test="${not empty pojo.combQustid}">修改</c:if>
	</div>
	<div class="tab-content">
		<div id="tab1-page" class="tab-page active">
		<form id="form1" action="save">
			<input type="hidden" name="questIds" id="questIds"/>
			<input type="hidden" name="combQustid" value="${pojo.combQustid}" />
			<input type="hidden" name="qustTag" value="${pojo.qustTag}" />
			<div class="page-wrapper">
				<div class="row">
					<label>
						<span class="form-label">问卷名称：</span>
						<c:if test="${empty pojo.combQustid}">
						<input type="text" class="form-control qustname" name="combQustName"  value="${pojo.combQustName}"/>
						</c:if>
						<c:if test="${not empty pojo.combQustid}">
							<input type="text" class="form-control qustname" name="combQustName" readonly value="${pojo.combQustName}"/>
						</c:if>
						<span class="error">*</span>
					</label>
				</div>
				<div class="row">
					<label>
						<span class="form-label">问卷类别：</span>
						<select name="optId" class="form-control">
							<c:forEach items="${options}" var="oopt">
								<option value="${oopt.optId }" <c:if test="${oopt.optId == pojo.optId}">selected="selected"</c:if>>${oopt.optName }</option>
							</c:forEach>
						</select>
					</label>
				</div>
				<div class="row">
					<label>
						<span class="form-label">问卷说明：</span>
						<textarea name="combDesc" class="desription" cols="70" rows="4">${pojo.combDesc}</textarea>
					</label>
				</div>
				<div class="row">
					<span class="form-label">单份问卷：</span>
					<ol type="1" class="ol" id="singleList">
						<c:forEach items="${pojo.cqt1s}" var="cqt1">
							<li id="id_${cqt1.qustid}" class="selectedRow"><span><c:out value="${cqt1.qustname}" escapeXml="true" /></span>
								<input type="button" class="btn btn-delete1" value=" " onclick="removeRow(${cqt1.qustid});">
							</li>
						</c:forEach>
					</ol>
				</div>
				<div>
					<a href="javascript:void(0);" onclick="addSingle();">
					<input type="button" class="btn btn-add-logic show" value=" " data-pid="set-1" id="addSingleBtn"/>
					增加单份问卷</a>
			    </div>
			</div>
			<div class="page-box">
				<button type="submit" class="btn-inquiry">保存</button>
				<button type="button" class="btn-inquiry" onclick="history.go(-1)">取消</button>
				<button type="submit" class="btn-inquiry" onclick="release();">发布</button>
			</div>
		</form>
		</div>
	</div>
</div>
</body>
</html>
