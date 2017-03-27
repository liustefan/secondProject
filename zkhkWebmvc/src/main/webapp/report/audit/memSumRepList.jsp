<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	<title>会员汇总项测量报告列表</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	
    <script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/calendar.js"></script>
	<script type="text/javascript">
	$(function(){
		//置灰效果
          var pageNum= "${page.pageNo}";
          var pageLast="${page.totalPages}";
          if(pageNum!=1){
             $("#page-first").css({"color":"#333","cursor":"pointer"});
             $("#pre span").css({"background":"url(../img/arrow-l.png) center no-repeat"});
             $("#pre").css({"cursor":"pointer"});
          }
          if(pageNum==pageLast){
             $("#page-last").css({"color":"#ccc","cursor":"default"});
             $("#nex span").css({"background":"url(../img/arrow-r-gray.png) center no-repeat","cursor":"default"});
             $("#nex").css({"cursor":"default"});
          }
          $("#lines option[value='${page.pageSize}']").attr("selected", true);
          
		$("#lines").change(function(){
			var lines=$("#lines").val();
			window.location = "${pageContext.request.contextPath}/summaryReport/toMemSumReportPage?memberid=${memberid}&pageSize="+lines;
		});
		
		$("#toPage-btn").click(function(){
		    var lines=$("#lines").val();
			var num = $("#toPage").val();
			var totalPage=${page.totalPages};
			var pageNow=${page.pageNo};
			var reg= /^[0-9]\d*$/;
					if(!reg.test(num)){
						alert("输入页数应为数字！");
						$("#toPage").val(pageNow);
						return false;
					}
					if(num>totalPage){
						alert("超过最大页了！");
						$("#toPage").val(pageNow);
						return false;
					}
			var topage= $("#toPage");
			topage.val(pageNow);
			window.location = "${pageContext.request.contextPath}/summaryReport/toMemSumReportPage?memberid=${memberid}&pageNo="+num+"&pageSize="+lines;
		});
		//禁用分页回车键
		  $("#toPage").keydown(function(e){
				if(e.keyCode==13) {
				return false;
				}
		  }); 
		$("#page-first").click(function(){
		    var lines=$("#lines").val();
			var pageNum= "${page.pageNo}";
			if(pageNum==1){
			  	/* alert("已经到达首页！"); */
			  	return;
			  }
			window.location = "${pageContext.request.contextPath}/summaryReport/toMemSumReportPage?memberid=${memberid}&pageNo=1&pageSize="+lines;
		});
		$("#pre").click(function(){
		    var lines=$("#lines").val();
			var pageNum= "${page.pageNo}";
			if(pageNum==1){
			  	/* alert("已经到达首页！"); */
			  	return;
			  }
			window.location = "${pageContext.request.contextPath}/summaryReport/toMemSumReportPage?memberid=${memberid}&pageNo=${page.pageNo-1}&pageSize="+lines;
		}); 
		$("#nex").click(function(){
		    var lines=$("#lines").val();
			var pageNum= "${page.pageNo}";
			if(pageNum=="${page.totalPages}"){
			  	/* alert("已经到达未页！"); */
			  	return;
			}
			window.location = "${pageContext.request.contextPath}/summaryReport/toMemSumReportPage?memberid=${memberid}&pageNo=${page.pageNo+1}&pageSize="+lines;
		}); 
		$("#page-last").click(function(){
		    var lines=$("#lines").val();
			var pageNum= "${page.pageNo}";
			if(pageNum=="${page.totalPages}"){
			  	/* alert("已经到达未页！"); */
			  	return;
			}
			window.location = "${pageContext.request.contextPath}/summaryReport/toMemSumReportPage?memberid=${memberid}&pageNo=${page.totalPages}&pageSize="+lines;
		}); 
	});
	</script>
</head>
<body>
<div class="content">
	<c:if test="${page.totalCount == 0 }">
	 <div class="empty-info">
		<span>目前还没有测量报告产生！</span>
	 </div>
	</c:if>
	<c:if test="${page.totalCount != 0 }">
		<div class="content-title">
			会员汇总项测量报告列表
		</div>
		<div class="table-box">
			<table class="table-content">
				<thead class="table-title">
					<tr>
						<th>报告编号</th>
						<th>汇总模板</th>
						<th>自动生成时间</th>
						<th>报告状态</th>
						<th>待审级别</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${page.result}" varStatus="status">
						<tr>
						   <td>${item.ID}</td>
			               <td>${item.templateName}</td>
						   <td><fm:formatDate value="${item.grenerTime}" type="date" pattern="yyy-MM-dd HH:mm:ss" dateStyle="long"/></td>
				   			<c:choose>
								<c:when test="${item.reportState == 0}">
									<td>待审核</td>
									<td>${item.pendingLevel}</td>
			              			<td><a href="${pageContext.request.contextPath}/summaryReport/toReportAuditPage?sourceType=memSumRep&reportNo=${item.ID}&auditLevel=${item.pendingLevel}">立即处理</a></td>
								</c:when>
								<c:when test="${item.reportState == 1}">
									<td>审核完毕</td>
									<td>${item.pendingLevel}</td>
			               			<td><a href="${pageContext.request.contextPath}/summaryReport/toReportAuditPage?sourceType=memSumRep&reportNo=${item.ID}&auditLevel=${item.pendingLevel}">查看</a></td>
								</c:when>									
								<c:when test="${item.reportState == 2}">
									<td>会员已阅读</td>
									<td>${item.pendingLevel}</td>
			               			<td><a href="${pageContext.request.contextPath}/summaryReport/toReportAuditPage?sourceType=memSumRep&reportNo=${item.ID}&auditLevel=${item.pendingLevel}">查看</a></td>
								</c:when>										
							</c:choose>
			             </tr>
			         </c:forEach> 
		         </tbody> 
			</table>
			<div class="page-box">
				<div class="page fr">
				     <a id="page-first" class="page-btn">首页</a>
				     <a id="pre" class="page-btn"><span></span></a>
				     <span>一页显示
					 	<select  id="lines" class="page-num" name="lines">
							<option value="10">10</option>
							<option value="20">20</option>
							<option value="30">30</option>
					    </select>
				              条
				     </span>
			         <span class="page-total">共<i>${page.totalPages}</i>页</span>
			         <a id="nex" class="page-btn"><span></span></a>
				     <span>跳转到：<input type="text" id="toPage" class="page-go" value="${page.pageNo}"/></span><a class="page-btn" id="toPage-btn">Go</a>
				     <a id="page-last" class="page-btn">尾页</a> 
		       </div>
			</div>
	    </div>
	</c:if>
</div>
</body>
</html>