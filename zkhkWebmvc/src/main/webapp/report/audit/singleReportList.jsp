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
	<title>单项测量数据</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<script src="<%=path %>/js/jquery-1.9.1.min.js"></script>
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
				window.location = "${pageContext.request.contextPath}/singleReport/showSingleReportList?funId=1&pageSize="+lines;
			});
			
			$("#toPage-btn").click(function(){
			    var lines=$("#lines").val();
				var num = $("#toPage").val();
				var totalPage=${page.totalPages};
				var pageNow=${page.pageNo};
				var reg = /^[0-9]+.?[0-9]*$/;
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
				else{
					var topage= $("#toPage");
					topage.val(pageNow);
					window.location = "${pageContext.request.contextPath}/singleReport/showSingleReportList?funId=1&pageNo="+num+"&pageSize="+lines;
				}
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
				var pageNow=${page.pageNo};
				if(pageNum==1){
				  	/* alert("已经到达首页！  "); */
				  	return;
				  }
				window.location = "${pageContext.request.contextPath}/singleReport/showSingleReportList?funId=1&pageNo=1&pageSize="+lines;
			});
			$("#pre").click(function(){
			    var lines=$("#lines").val();
				var pageNum= "${page.pageNo}";
				if(pageNum==1){
				  	/* alert("已经到达首页！"); */
				  	return;
				  }
				window.location = "${pageContext.request.contextPath}/singleReport/showSingleReportList?funId=1&pageNo=${page.pageNo-1}&pageSize="+lines;
			}); 
			$("#nex").click(function(){
			    var lines=$("#lines").val();
				var pageNum= "${page.pageNo}";
				if(pageNum=="${page.totalPages}"){
				  	/* alert("已经到达未页！"); */
				  	return;
				}
				window.location = "${pageContext.request.contextPath}/singleReport/showSingleReportList?funId=1&pageNo=${page.pageNo+1}&pageSize="+lines;
			}); 
			$("#page-last").click(function(){
			    var lines=$("#lines").val();
				var pageNum= "${page.pageNo}";
				if(pageNum=="${page.totalPages}"){
				  	a/* lert("已经到达未页！"); */
				  	return;
				}
				window.location = "${pageContext.request.contextPath}/singleReport/showSingleReportList?funId=1&pageNo=${page.totalPages}&pageSize="+lines;
			}); 
		});
	</script>
</head>
<body>
<div class="content">
	<div class="content-title">单项测量数据</div>
	<ul class="content-tabs">
		<li>
			<a <c:if test="${funId==1}">
				class="current"
			</c:if>
			href="../singleReport/showSingleReportList?funId=1">单项测量数据</a>
		</li>
		<li>
			<a <c:if test="${funId==2}">
		    	class="current"
		    </c:if>
			href="../summaryReport/showSumReportList?funId=2">汇总测量数据</a>
		</li>
	</ul>
	<div class="border-1-solid">
		<c:if test="${count==0 }">
			<div class="empty-info">您目前还没有已审核过的记录</div>
		</c:if>
		<c:if test="${count!=0 }">
			<div class="table-box">
				<table class="table-content">
				<thead class="table-title">
					<tr>
						<th>序号</th>
						<th>报告编号</th>
						<th>姓名</th>
						<th>报告产生时间</th>
						<th>测量内容</th>
						<th>测量时间段</th>
						<th>测量次数</th>
						<th>状态</th>
						<th>待审核级别</th>
						<th>操作</th>
					</tr>
					</thead>
					<tbody>
					<c:forEach var="item" items="${page.result}" varStatus="status">
						<tr>
							<td>${(page.pageSize)*(page.pageNo)-((page.pageSize))+(status.index+1) }</td>
							<td>${item.ID}</td>
							<td>${item.memName}</td>
							<td><fm:formatDate value="${item.grenerTime}" type="date" pattern="yyy-MM-dd HH:mm:ss" dateStyle="long" /></td>
							<td>${item.templateName}</td>
							<td><fm:formatDate value="${item.measTime}" type="date"
									pattern="MM月dd日" dateStyle="long" />-<fm:formatDate
									value="${item.measTermTime}" type="date" pattern="MM月dd日"
									dateStyle="long" />
							</td>
							<td>${item.measNum}</td>
							<td>
				               	<c:choose>
									<c:when test="${item.reportState == 0}">
										待单项审核
									</c:when>
									<c:when test="${item.reportState == 1}">
										待他组意见
									</c:when>									
									<c:when test="${item.reportState == 2}">
										报告已发布
									</c:when>
									<c:when test="${item.reportState == 3}">
										报告已阅读
									</c:when>										
								</c:choose>
							</td>
							<td>
								<c:choose>
									<c:when test="${item.auditLevel == null}">
										免审
									</c:when>
									<c:otherwise>
										${item.pendingLevel}
									</c:otherwise>
								</c:choose>
							</td>
							<td>
								<a href="../singleReport/getSingleReportDetail?isAudit=N&auditLevel=${item.auditLevel }&reportNo=${item.ID}">查看</a>
							</td>
						</tr>
					 </c:forEach>  
					</tbody>
				</table>
			</div>
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
	   </c:if>
   </div>
</div>
</body>
</html>
