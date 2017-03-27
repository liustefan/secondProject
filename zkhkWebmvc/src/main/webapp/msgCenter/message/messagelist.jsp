<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	<title>消息列表</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/js/skins/blue.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.7.2.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.artDialog.js"></script>
	<script type="text/javascript" src="<%=path %>/js/plugins/iframeTools.js"></script>
	<script type="text/javascript" src="<%=path %>/js/calendar.js"></script>

	<script type="text/javascript">
		//全选与反选功能
		$(function(){
			  $('#checkAll').click(function(){
				  $('input[name="ids"]').attr('checked', this.checked);
			  });
		});
		
		//验证结束时间是否小于开始时间进行带时间的查询
		function checkTime(memberId){
			var startTime = $("#startTime").val();
			var endTime = $("#endTime").val();		
			if((startTime != "") && (endTime != "")){
				if(startTime > endTime){
					alert("开始时间不能大于结束时间");
					return false;
				}else{
					$("form").submit();
				}
			}else{
				return false;
			}		
		}
		
		//点击左下角删除时进行的一些判断
		function deleteInfo(){
			var checkboxs = $("input[name='ids']:checked");
			if(checkboxs.length <= 0){
				alert("请勾选需要删除的记录");
				return false;
			}else{
				var prompt = "确定要删除这" +  checkboxs.length + "条信息吗？";
				if (confirm(prompt)) {
					
					 $.ajax({
			             type: "POST",
			             url: "remove",
			             data: $.param(checkboxs),
			             cache:false,
			             success: function(data){
			            	 if (data.status){
			            		 alert("删除成功");
			            		 location.reload(true);
			            	 }else{
			            		 alert("删除失败");
			            	 }
			              }
			         });
					
				}else{
					return false;
				}
			}
		}
		
	//删除记录
	 function del(id) {
			art.dialog({
				title:'<%=getServletContext().getAttribute("title") %>温馨提示：',
			    content: '<font color="red">你确定需要删除此条记录吗?</font>',
			    ok: function () {
			    	 $.ajax({
			             type: "POST",
			             url: "remove",
			             data: {ids:id},
			             cache:false,
			             success: function(data){
			            	 if (data.status){
			            		 alert("删除成功");
			            		 location.reload(true);
			            	 }else{
			            		 alert("删除失败");
			            	 }
			              }
			         });
					
			        return false;
			    },
			    cancelVal: '取消',
			    cancel: true //为true等价于function(){}
			});
	 	}
		 //删除记录
		 function ShowMsg(obj) {
				art.dialog({
					title:'查看消息',
					lock: true,
				    content: '<div style="width:400px;height:200px;overflow:visible;"><p>'+$(obj).html()+'</p></div>'
				});
		 }
	</script>
</head>
<body>
<div class="content">
		<div class="content-title">温馨提示 --- 查看消息</div>
		<div class="mess-title clearfix">
	         <div class="fl">
		         <span>姓名：${member.memname}</span>
		         <span class="mar-left">电话：${member.tel}</span>
	         </div>
	         <div class="fr">
	         	<input type="button" value="返回" onclick="javascript:history.go(-1);" class="btn-cancel">
	         </div>
		</div>
		<form action="msgView" method="get">
		<input type="hidden" name="memberId" value="${member.memberid}"/>
		<div class="search-box-wrapper">
			<ul class="search-wrapper clearfix">
				<li>
					<label>日期：</label>
					<input class="info-date" type="text" name="startTime" id="startTime" value="<fmt:formatDate value="${startTime}" type="both" pattern="yyyy-MM-dd" />" onclick="SelectDate(this,'yyyy-MM-dd')" onchange="return checkTime();" readonly="readonly">
					<span class="mar-left">至</span>
					<input class="info-date" type="text" name="endTime" id="endTime" value="<fmt:formatDate value="${endTime}" type="both" pattern="yyyy-MM-dd" />" onclick="SelectDate(this,'yyyy-MM-dd')" onchange="return checkTime();" readonly="readonly">
				</li>
				<li>
					<a href="toSendMsg?memberId=${member.memberid}" class="btn-normal">发送新消息</a>
				</li>
			</ul>
		</div>
		<c:if test="${page.totalCount == 0}">
			<div class="empty-info">没有查询到符合条件的消息</div>
		</c:if>
		<c:if test="${page.totalCount > 0}">
		<div class="table-box">
			<table class="table-content">
				<thead class="table-title">
				    <tr>
				       <th width="10%">全选<input type="checkbox" id="checkAll"></th>
					   <!-- <th width="10%">选择</th> -->
					   <th width="10%">序号</th>
					   <th width="15%">时间</th>
					   <th width="50%">消息内容</th>
					   <th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${page.result}" var="item" varStatus="vs">
						<tr>
						   <td><input name="ids" type="checkbox" value="${item.logID}"></td>
						   <td>${vs.index+1}</td>
						   <td>${item.createTime}</td>
						   <td><span class="msgindex" id="label_select" onclick="ShowMsg(this);" style="cursor:pointer;"><c:out value="${item.content}" escapeXml="true"/></span></td>
						   <td><a href="javascript:del(${item.logID});">删除</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	    </c:if>
	    <div class="page-box">
		    <div class="fl">
		        <button type="button" id="btndel2" onclick="deleteInfo();" class="btn-normal">批量删除</button>
		    </div>
		    <div class="fr page">
		    	<jsp:include page="/public/pageFoot.jsp"/>
		    </div>
	    </div>
	    </form>
</div>
</body>
</html>