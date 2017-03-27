<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
    <title>血压所有测量数据</title>
	<link rel="shortcut icon" href="<%=path %>/<%=getServletContext().getAttribute("img") %>/title_ico.ico" type="image/x-icon" />
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/js/skins/blue.css">
	<link rel="stylesheet" href="<%=path %>/css/celiang.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer/layer.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/showXueYaInfo.js"></script>
	<script type="text/javascript" src="<%=path %>/js/highcharts.js"></script>
	<script type="text/javascript" src="<%=path %>/js/exporting.js"></script>
	<script type="text/javascript" src="<%=path %>/js/calendar.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.artDialog.js"></script>
	<script type="text/javascript" src="<%=path %>/js/plugins/iframeTools.js"></script>
	
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
			  	window.location = "../bloodPressure/showAllBloodPress?memberId=${omem.memberid }&pageSize="+pageSize+"&startTime=${startTime}&endTime=${endTime}&eventId=${eventId}&flag=${flag}";
		  	}); 
	          
			$("#page-first").click(function(){
				var pageSize=$("#pageSize").val();
			  	var pageNum= "${page.pageNo}";
			  	if(pageNum==1){
			  		return;
			  	}
				window.location = "../bloodPressure/showAllBloodPress?pageNo=1&memberId=${omem.memberid}&eventId=${eventId}&startTime=${startTime}&endTime=${endTime}&pageSize="+pageSize+"&flag=${flag}";
          	}); 
			
			$("#page-last").click(function(){
          		var pageSize=$("#pageSize").val();
			  	var pageNum= "${page.pageNo}";
			  	if(pageNum=="${page.totalPages}"){
			  		return;
			  	}
				window.location = "../bloodPressure/showAllBloodPress?pageNo=${page.totalPages}&memberId=${omem.memberid}&eventId=${eventId}&startTime=${startTime}&endTime=${endTime}&pageSize="+pageSize+"&flag=${flag}";
          	});
			
			$("#pre").click(function(){
		  		var pageSize=$("#pageSize").val();
			  	var pageNum= "${page.pageNo}";
			  	if(pageNum==1){
			  		return;
			  	}
				window.location = "../bloodPressure/showAllBloodPress?pageNo=${page.pageNo-1}&memberId=${omem.memberid}&eventId=${eventId}&startTime=${startTime}&endTime=${endTime}&pageSize="+pageSize+"&flag=${flag}";
          	});
			
		 	$("#nex").click(function(){
		  		var pageSize=$("#pageSize").val();
			    var pageNum= "${page.pageNo}";
			  	if(pageNum=="${page.totalPages}"){
			  		return;
			  	}
			  	window.location = "../bloodPressure/showAllBloodPress?pageNo=${page.pageNo+1}&memberId=${omem.memberid}&eventId=${eventId}&startTime=${startTime}&endTime=${endTime}&pageSize="+pageSize+"&flag=${flag}";
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
				window.location = "../bloodPressure/showAllBloodPress?pageNo="+num+"&memberId=${omem.memberid}&eventId=${eventId}&startTime=${startTime}&endTime=${endTime}&pageSize="+pageSize+"&flag=${flag}";
		  });
		});	
		//血压趋势图json数据	
		var result=${json};
		
		//验证结束时间是否小于开始时间进行带时间的查询
		function checkTime(){
			var startTime = $("#startTime").val(),
				endTime = $("#endTime").val();
			
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
			window.location = "../bloodPressure/showAllBloodPress?eventId=${eventId}&startTime="+startTime+"&endTime="+endTime+"&memberId="+memberId+"&flag=${flag}";
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
			post("../bloodPressure/getReportDetail",{osbpsJson:JSON.stringify(${jsonArr}),memberid:${omem.memberid}});
		}
	</script>
</head>
<body <c:if test="${flag ne 1 }">style="background:#f3f3f3;"</c:if>>
  	<div <c:if test="${flag eq 1 }">class="content"</c:if><c:if test="${flag ne 1 }">id="w1280"</c:if>>
  	<c:if test="${flag ne 1 }">
  		<div class="single_report_head">
            <div class="person-info clearfix">
                 <div class="fl person-img">
                  	<c:if test="${not empty omem.headaddress}">
					    <img src="<%=path %>/image/getImage?uniqueId=${omem.headaddress}" style="width: 64px; height: 64px;">
					</c:if>
					<c:if test="${empty omem.headaddress}">
					    <img src="<%=path %>/img/mem_img.png" style="width: 64px; height: 64px;">
					</c:if>
                 </div>
                 <div class="fr">
                      <p>姓名：${omem.memname }</p>
                      <p>性别：${omem.gender eq '1'?'男': omem.gender eq '2'?'女': '未知'}</p>
                      <p>年龄：${age}</p>
                 </div>
            </div>
  			<h3>血压测量结果</h3>
	    </div>
	</c:if>
	<c:if test="${flag eq 1 }">
		<div class="content-title">血压测量</div>
	</c:if>
	<div>
		<ul class="footer_content_ul clearfix">
			<li><a href="../bloodPressure/showSingleBloodPress?memberId=${omem.memberid}&eventId=${eventId}&flag=${flag}">单次测量结果</a></li>
			<li><a href="../bloodPressure/showAllBloodPress?memberId=${omem.memberid}&eventId=${eventId}&flag=${flag}" class="current">所有测量数据</a></li>
		</ul>
	</div>
	<c:if test="${empty page.result }">
 		<div class="empty-info">
 			目前还没有血压测量数据
 			<c:if test="${startTime != null || endTime != null}">
 				<a class="btn-normal" href="javascript:history.go(-1)">返回</a>
 			</c:if>
 		</div>
  	</c:if>
  	<c:if test="${not empty page.result }">
  		<div id="footer_content">
	  		<div id="footer_content1_top_div">
			  	测量时间：<input type="text" name="startTime" id="startTime" value="${startTime }" onclick="SelectDate(this,'yyyy-MM-dd')" onchange="return checkTime();"><span class="padding-8">至</span>
			  	<input type="text" name="endTime" id="endTime" value="${endTime }" onclick="SelectDate(this,'yyyy-MM-dd')" onchange="return checkTime();">
			  	<div class="dp-inline fr">
				  	<input type="button" value="查询" class="btn-inquiry ico-search small-icon" onclick="toResearch(${omem.memberid});"/>
			  		<input type="button" value="生成测量报告" class="btn-inquiry" onclick="genReport();">
		  		</div>
            </div>
  		<table class="table-content">
        	<thead class="table-title">
            	<tr>
		  			<th>序号</th>
		  			<th>测量时间</th>
		  			<th>测量方式</th>
		  			<th>时间类型</th>
		  			<th>收缩压</th>
		  			<th>舒张压</th>
		  			<th>脉压差</th>
		  			<th>操作</th>
		  		</tr>
	  		</thead>
	  		<tbody>
		  		<c:forEach items="${page.result}" var="osbp" varStatus="st">
		  			<tr>
		  				<td id="list">${st.index+1 }</td>
		  				<td><fmt:formatDate value="${osbp.testtime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		  				<td>${osbp.devicecode }</td>
		  				<td>
		  					<c:if test="${osbp.timeperiod == 0}">其他（随机测量）</c:if>
							<c:if test="${osbp.timeperiod == 1}">起床后2小时</c:if>
							<c:if test="${osbp.timeperiod == 2}">睡觉前</c:if>
		  				</td>
		  				<td>${osbp.sbp }</td>
		  				<td>${osbp.dbp}</td>
		  				<td>${osbp.sbp - osbp.dbp }</td>
		  				
		  				<td id="footer_content1_table_td_a">
		  					 <label id="label_select" onclick="showInfo_label(this);">
		  						<a id="label_select" href="javascript:void(0)">
		  							查看
		  						</a>
		  					</label>
							<input type="hidden" value="${osbp.docentry }">
							&nbsp;&nbsp;
							<c:if test="${flags == 'my'}">
		  						<a href="javascript:void(0);" onclick="del('reportAction!deleteOsbpInfoByDocentryInAllXueYa?docentry=${osbp.docentry }&flag=SINGLE&memberId=${requestScope.memberId}&flagTag=${requestScope.flagTag}&flags=${requestScope.flags}');">删除</a>
		  					</c:if>
		  				</td>
		  			</tr>
		  		</c:forEach>
	  		</tbody>
  		</table>
  		<div class="page-box">
  			<div class="page">
			     <a id="page-first" class="page-btn">首页</a>
			     <a id="pre" class="page-btn"><span></span></a>
			     <span>一页显示
			     	<select id="pageSize" class="page-num" name="pageSize">
				    	<option value="10">10</option>
				    	<option value="20">20</option>
				    	<option value="30">30</option>
				    </select>条
		    	 </span>	
		         <span class="page-total">共<i>${page.totalPages}</i>页</span>
		         <a id="nex" class="page-btn"><span></span></a>
			     <span>跳转到：<input type="text" id="toPage" class="page-go" value="${page.pageNo}"/></span><a class="page-btn" id="toPage-btn">Go</a>
			     <a id="page-last" class="page-btn">尾页</a> 
	    	</div>
  		</div>
		<div id="myxueya" style="min-width:700px; height:400px;"></div>
		<div id="mypulse" style="min-width:700px; height:400px;"></div>
	</div>
	</c:if>
</div>
</body>
</html>
