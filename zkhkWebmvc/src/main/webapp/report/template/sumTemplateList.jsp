<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt"%>   
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>汇总测量审核模板</title>
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/general.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script type="text/javascript">
	 	function showTops(id, name) {
	 		layer.tips(name +' 单项测量报告的报告周期大于本汇总报告周期，请更改！', '#'+id, {
	 		    tips: [2, '#78BA32']
	 		});
	 	}
		$(function(){
			  $("#add_model2").click(function(){
				window.location = "${pageContext.request.contextPath}/template/toAddSummaryTemplatePage";
	          }); 
		});
	
		function validateDel(id){
			if(validateqw(id) && confirm('确认删除吗？')) {
				window.location.href="../template/deleteTemplate?tempCode="+id+"&teyp=2";
			}
		}
		
		function validateqw(id) {
			var isDel = false;
			var url = "../template/validateDeleteTemplate";
			$.ajax({ 
				  type: 'POST', 
				  url: url, 
				  data: {tempCode : id,type:2},
				  cache : false,
				  success: function(data){
					  console.log(data);
					  if(data != "OK"){
							alert("该汇总模板已关联服务套餐，无法删除！");
						}else{
							isDel = true;
						}
				  }, 
				  dataType: 'text', 
				  async:false 
				}); 
			return isDel;
		}
	</script>
</head>
<body>
<div class="content">
	<div class="content-title">
		汇总测量审核模板
	</div>
	<c:if test="${page.totalCount == 0 }">
		<div class="empty-info">暂无汇总测量审核模板</div>
	</c:if>
	<c:if test="${page.totalCount != 0 }">
		<div class="table-box">
			 <table class="table-content">
			    <thead class="table-title">
					<tr>
						<th title='汇总报告审核模板ID'>模板号</th>
						<th>模板名称</th>
						<th>是否已添加单项测量</th>
						<th>最大间隔天数</th>
						<th>是否审核</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${sumTemplatelist}" varStatus="status">
						<tr>
						   <td>${item.sumRepTempCode}</td>
			               <td>${item.tempName}</td>
			               <td>
			               		<c:if test="${item.isAddSingleTempalte=='T'}">
			               			<font color="green">已添加</font>
			               		</c:if>
			               		<c:if test="${item.isAddSingleTempalte!='T'}">
			               			<font color="red">未添加</font>
			               		</c:if>
			               </td>
			               <td>${item.maxMumDay}
			               			<c:if test="${item.warnFlag =='T'}"> 
			               				<div id="tip_${item.sumRepTempCode }" class="tips" onmouseout="layer.closeAll('tips');"  onmouseover="showTops('tip_${item.sumRepTempCode }', '${item.tempName }');">
			               				<img src="${pageContext.request.contextPath}/img/warn.png" alt="warning">
			               				</div>
			               			</c:if>
		           	       </td>
			               <td>${item.chTag=='Y'?'是':'否' }</td>
			               <td class="table_content_title_td">
				               <a href="../template/getOtherSingleTemplateList?sumRepTempCode=${item.sumRepTempCode }" title='添加单项模板操作'>添加</a>&nbsp;
				               <a href="../template/getSumRelationSinglTemplate?sumRepTempCode=${item.sumRepTempCode }" title='查看已关联单项模板'>查看</a>&nbsp;
				               <a href="../template/toEditSumTemplate?sumRepTempCode=${item.sumRepTempCode }">修改</a>&nbsp;
				               <a onclick="validateDel(${item.sumRepTempCode});" href="javascript:void(0)">删除</a>
			               </td>
	            		</tr>
		        	</c:forEach> 
		        </tbody>
			</table>
			<div class="page-box align-center">
	        	<button type="button" id="add_model2" class="btn-inquiry">添加</button>
			</div>
		</div>
	</c:if>
</div>
</body>
</html>