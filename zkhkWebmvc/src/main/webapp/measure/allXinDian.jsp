<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
    <title>心电所有结果页面</title>
   	<meta charset="utf-8">
   	<meta http-equiv="X-UA-Compatible" content="IE=9">
   	<link rel="shortcut icon" type="image/x-icon" href="<%=path %>/<%=getServletContext().getAttribute("img") %>/title_ico.ico" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/reset.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/celiang.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer/layer.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/showInfo.js"></script>
	<script type="text/javascript" src="<%=path %>/js/highcharts.js"></script>
	<script type="text/javascript" src="<%=path %>/js/exporting.js"></script>
	<script type="text/javascript" src="<%=path %>/js/calendar.js"></script>

	<script type="text/javascript">
		function toLoginPage(){
			window.location.href = '<%=basePath%>'
		}
		function getRoot(){
			return '<%=basePath%>';
		}
		
		var EventUtil = {
		    addHandler: function(element, type, handler) {
		        if (element.addEventListener) {
		            element.addEventListener(type, handler, false);
		        } else if (element.attachEvent) {
		            element.attachEvent("on" + type, handler);
		        } else {
		            element["on" + type] = handler;
		        }
		    }
		};
		EventUtil.addHandler(window, "offline", function() {
		    window.location.href='<%= path + "/error.jsp"%>';
		});
		$(function(){
			var pageSize = "${page.pageSize}";
			$("select option[value='"+pageSize+"']").attr("selected", "selected"); 
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
			
			$("#pageSize").change(function(){
				  var pageSize=$("#pageSize").val();
				  window.location = "../electrocardio/showAllElectrocardio?memberId=${omem.memberid }&pageSize="+pageSize+"&startTime=${startTime}&endTime=${endTime}&eventId=${eventId}&flag=${flag}";
			    });
			
			$("#page-first").click(function(){
				var pageSize=$("#pageSize").val();
			  	var pageNum= "${page.pageNo}";
			  	if(pageNum==1){
			  		return;
			  	}
				window.location = "../electrocardio/showAllElectrocardio?memberId=${omem.memberid }&pageNo=1&startTime=${startTime}&endTime=${endTime}&eventId=${eventId}&pageSize="+pageSize+"&flag=${flag}";
          }); 
			
			$("#page-last").click(function(){
          		var pageSize=$("#pageSize").val();
			  	var pageNum= "${page.pageNo}";
			  	if(pageNum=="${page.totalPages}"){
			  		return;
			  	}
				window.location = "../electrocardio/showAllElectrocardio?memberId=${omem.memberid }&pageNo=${page.totalPages}&startTime=${startTime}&endTime=${endTime}&eventId=${eventId}&pageSize="+pageSize+"&flag=${flag}";
          });
			
			$("#pre").click(function(){
		  		var pageSize=$("#pageSize").val();
			  	var pageNum= "${page.pageNo}";
			  	if(pageNum==1){
			  		return;
			  	}
				window.location = "../electrocardio/showAllElectrocardio?memberId=${omem.memberid }&pageNo=${page.pageNo-1}&startTime=${startTime}&endTime=${endTime}&eventId=${eventId}&pageSize="+pageSize+"&flag=${flag}";
          }); 
			
			$("#nex").click(function(){
		  		var pageSize=$("#pageSize").val();
			    var pageNum= "${page.pageNo}";
			  	if(pageNum=="${page.totalPages}"){
			  		return;
			  	}
			  window.location = "../electrocardio/showAllElectrocardio?memberId=${omem.memberid }&pageNo=${page.pageNo+1}&startTime=${startTime}&endTime=${endTime}&eventId=${eventId}&pageSize="+pageSize+"&flag=${flag}";
          });
			
			$("#toPage-btn").click(function(){
		  		var pageSize=$("#pageSize").val();
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
				window.location = "../electrocardio/showAllElectrocardio?pageNo="+num+"&memberId=${omem.memberid}&pageSize="+pageSize+"&flag=${flag}";
		  }); 
			
		});
		
		 //验证结束时间是否小于开始时间进行带时间的查询
		function checkTime(){
			var startTime = $("#startTime").val();
			var endTime = $("#endTime").val();
			if((startTime != "") && (endTime != "")){
				if(startTime > endTime){
					alert("开始时间不能大于结束时间");
					return false;
				}else{
					return true;
				}
			}else{
				return true;
			}
		}
		// 提交查询
		function toResearch(memberId){
			var startTime = $("#startTime").val();
			var endTime = $("#endTime").val();
			
			if(!checkTime()) {
				return false;
			}
			window.location = "../electrocardio/showAllElectrocardio?startTime="+startTime+"&endTime="+endTime+"&memberId="+memberId+"&flag=${flag}";
		}
		
		//post提交数据方法
		function post(url, params) {
		    var temp = document.createElement("form");
		    temp.action = url;
		    temp.target = "_blank";
		    temp.method = "post";
		    temp.style.display = "none";
		    for (var x in params) {
		        var opt = document.createElement("input");
		        opt.name = x;
		        opt.value = params[x];
		        temp.appendChild(opt);
		    }
		    document.body.appendChild(temp);
		    temp.submit();
		    return temp;
		}
		
		function genReport(){
			post("../electrocardio/getReportXDDetail",{oecgsJson:JSON.stringify(${oecgJsonArr}),memberid:${omem.memberid}});
		}
	</script>
</head>
<body>
  	<div>
		<c:if test="${empty page.result }">
			<div class="empty-info">
				目前还没有心电测量数据
				<c:if test="${startTime != null || endTime != null}">
	 				<a class="btn-normal" href="javascript:history.go(-1)">返回</a>
	 			</c:if>
			</div>
		</c:if >
	 	<c:if test="${not empty page.result }">
			<div id="footer_content1_top_div">
				测量时间：<input type="text" name="startTime" id="startTime" value="${startTime }" onclick="SelectDate(this,'yyyy-MM-dd')" onchange="return checkTime();">&nbsp;&nbsp;至&nbsp;&nbsp;
				<input type="text" name="endTime" id="endTime" value="${endTime }" onclick="SelectDate(this,'yyyy-MM-dd')" onchange="return checkTime();">
				<div class="dp-inline fr">
					<input type="button" value="查询" class="btn-inquiry ico-search small-icon" onclick="toResearch(${omem.memberid});"/>
					<input type="button" value="生成测量报告" class="btn-inquiry" onclick="genReport();">
				</div>
	 	    </div>
		  	<table id="footer_content1_table">
				<tr align="center">
					<th>序号</th>
					<th>测量时间</th>
					<th width="10%">平均心率</th>
					<th width="30%">分析结果</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${page.result }" var="oecg" varStatus="st">
					<tr align="center">
						<td id="list">${st.index+1 }</td>
						<td><fmt:formatDate value="${oecg.meastime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						<td>${oecg.averageheart }</td>
						<td>
							<c:forEach items="${map }" var="map">
								<c:if test="${map.key.docentry == oecg.docentry }">
								<c:choose>
									<c:when test="${fn:length(map.value) <= 0}">
				   						<span style="color:green">未见异常</span>
				   					</c:when>
				   					<c:otherwise>
				   						<span style="color:red">异常(${fn:length(map.value)})：
					   						<c:forEach items="${map.value }" var="value">
					   							${value.abnname }&nbsp;
					   						</c:forEach>
					   					</span>
				   					</c:otherwise>
				   				</c:choose>
								</c:if>
							</c:forEach>
						</td>
						<td id="footer_content1_table_td_a">
							  <label id="label_select">
							  		<a href="../electrocardio/showSingleElectrocardio?memberId=${omem.memberid }&docentry=${oecg.docentry}&flag=${flag}&view=1">查看</a>
							  </label>
						<input type="hidden" value="${oecg.docentry }">
						&nbsp;&nbsp;
						</td>
					</tr>
				</c:forEach>
			</table>
			<div class="page" style="padding:15px 0;">
		     	<a id="page-first" class="page-btn">首页</a>
		     	<a id="pre" class="page-btn"><span></span></a>
		     	<span>一页显示
			     	<select id="pageSize" class="page-num" name="pageSize">
				    	<option value="10">10</option>
				    	<option value="20">20</option>
				    	<option value="30">30</option>
				    </select>
		     	条</span>
	        	<span class="page-total">共<i>${page.totalPages}</i>页</span>
	         	<a id="nex" class="page-btn"><span></span></a>
		     	<span>跳转到：<input type="text" id="toPage" class="page-go" value="${page.pageNo}"/></span><a class="page-btn" id="toPage-btn">Go</a>
		     	<!--span>共<i>${pagination.totalCount}</i>条记录</span-->
		     	<a id="page-last" class="page-btn">尾页</a> 
    		</div>
		</c:if>	
	</div>
	<script src="<%=path %>/js/report.js" type="text/javascript"></script>
</body>
</html>
 