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
    <title>载入单份问卷</title>
   	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/css/showques.css">
	
	<script src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
	//全选与反选
	$(function(){
		$("#all").click(function(){
		    if(this.checked){      //全选之后需要动态在form表单中添加元素
		        $("input[name='checkbox']").prop("checked", true).each(function(index, item){
		        	parent.addSelectedRow(selectedRowToJson(item));
				});	
		    }else{      //反选之后需要在form表单中删除元素
		        $("input[name='checkbox']").prop("checked", false).each(function(){ 
		       		parent.removeSelectedRow(this.value);
		        });
		    }    
		}); 
		   var selectList = parent.getQustIds();
		   console.log(selectList);
		  if(selectList.length>0){
			  $.each(selectList,function(index, item){
				  $('input[type="checkbox"][value="'+item.id+'"]').prop('checked', 'checked');
			  });
		  }
	});
	
	//表单提交的时候验证用户是否选择了问卷信息进行添加到组合问卷中
	function checkSelect(){
		parent.checkSelect();
	}
	//用户单击某个复选框时或者再次单击时动态添加或者删除input
	function checkboxClick(obj){
		if(obj.checked)
			parent.addSelectedRow(selectedRowToJson(obj));
		else
			parent.removeSelectedRow(obj.value);
	}
	function selectedRowToJson(obj){
		var json = {};
		$(obj).parent().parent().find('td').each(function(index, item){
			switch(index){
				case 1 :
					json.qustname = item.innerHTML;
					break;
				case 2 :
					json.qustCode = item.innerText;
					break;
				case 3 :
					json.qustid = item.childNodes[0].value;
					break;
			}
		});
		console.log(json);
		return json;
	}
	</script>
</head>
<body style="padding: 8px;">
	<c:if test="${page.totalCount == 0}">
		<div class="align-center"> 
			<span class="empty-info">目前还没有相关问卷信息</span>
			<a href="../question/questionAction!showCreateQuestionUI" target="showRight" class="btn-normal">创建</a>
		</div>
	</c:if>
	<c:if test="${page.totalCount > 0}">
		<form action="chooseQuestions">
		<div>
			<table class="table-normal" cellpadding="0" cellspacing="0">
			<tr>
    		<th class="th_td" width="10%">序号</th>
    		<th class="th_td_name" width="35%">问卷名称</th>
    		<th class="th_td_title" width="25%">问卷编号</th>			    		
    		<th class="th_td" width="30%"><input type="checkbox" id="all"/>全选</th>
    		</tr>
			</table>
		</div>
		<div style="overflow-y: auto; overflow-x:hidden;height:280px;">
			<table class="table-normal" cellpadding="0" cellspacing="0">
				<c:forEach items="${page.result}" var="omfq" varStatus="status">
		    		<tr>
		    			<td class="th_td" width="10%">${status.index + 1}</td>
		    			<td class="th_td_name" width="35%" ><c:out value="${omfq.qustname }" escapeXml="true"/></td>
		    			<td class="th_td_title" width="25%" >${omfq.qustCode }</td>
		    			<td class="th_td" width="30%"><input type="checkbox" name="checkbox" id="checkbox" value="${omfq.qustid }" onclick="checkboxClick(this);"/></td>
		    		</tr>
	    		</c:forEach>
			</table>
		</div>
		<div class="page-box">
			<jsp:include page="/public/pageFoot.jsp"/>
		</div>
		<div class="page-box align-center">
			<button type="button" id="ipt_submit" class="btn-inquiry" onclick="parent.btnMethod(true);">确定</button>
			<button type="button" id="ipt_reset" class="btn-cancel" onclick="parent.btnMethod(false);">取消</button>
		</div>
		</form>
</c:if>
</body>
</html>
