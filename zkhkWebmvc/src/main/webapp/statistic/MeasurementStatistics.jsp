<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" language="java" import="java.util.*" %>
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
	<title>测量状况统计</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/plugins/zTree_v3/css/zTreeStyle/zTreeStyle.css">
	<link rel="stylesheet" href="<%=path %>/js/jquery-ui/themes/overcast/jquery-ui.min.css">
	<link rel="stylesheet" href="<%=path %>/plugins/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="<%=path %>/css/tree.css">
	<link rel="stylesheet" href="<%=path %>/css/populationReport.css">

	<script type="text/javascript" src="<%=path %>/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.core-3.5.min.js"></script>
	<script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.exhide-3.5.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-ui/jquery-ui.js"></script>
	<script type="text/javascript" src="<%=path %>/js/dataPacker.js"></script>
	<script type="text/javascript" src="<%=path %>/js/tree.js"></script>
	<script type="text/javascript">
		var setting = {
			data : {
				simpleData : {
					enable : true
				}
			},
			view : {
				dblClickExpand : false,
				selectedMulti : false,
				showIcon : false
			},
			callback : {
				onClick : onClick,
				onExpand : zTreeOnExpand
			}
		};
	
		// 显示组织分组
		function showGroupList() {
			if ($("#menuContent").css("display") == "none") {
				getOrganizationList();
				showMenu();
			}
		}
		function check(){
			var $startDate = $("#startDate").val();
			var $endDate = $("#endDate").val();
			if($startDate && $endDate){
				var startD = $startDate.split("-");
				var endD = $endDate.split("-");
				
				var startY = startD[0];
				var startM = startD[1];
				var startDay = startD[2];
				var endY = endD[0];
				var endM = endD[1];
				var endDay = endD[2];
				var year = 0;
				if(startY != endY){
					if(startM > endM){
						year = endY - startY - 1;
					}else if(startM < endM){
						year = endY - startY
					}else{
						if(startDay > endDay){
							year = endY - startY - 1 + 0.5;
						}else if(startDay < endDay){
							year = endY - startY + 0.5;
						}else{
							year = endY - startY;
						}
					}
				}
				
				if(year > 3){
					alert("查询时间不能超过三年");
					$("#query").removeAttr("disabled");
					return false;				
				}else {
					return true;
				}
			}else{
				alert("请选择测量日期");
				$("#query").removeAttr("disabled");
				return false;
			}
		}
		
		$(function(){
			$("#query").click(function(){
				$("#query").attr("disabled","disabled");
				if(check()){
					$("#form1").submit();
				}
			});
		})
	</script>
</head>
<body>
<form action="../statistic/exProcSelectMeasurementStatics" onsubmit="return check()" method="post" id="form1">
<div class="content">
	<div class="loadBox">
		<div class="loading"></div>
		数据加载中。。。
	</div>
	<div class="content-title">测量状况统计</div>
	<div class="search-box-wrapper">
		<ul class="search-wrapper clearfix">
			<li>
				<label>组织名称：</label>
				<span <c:if test="${userInfo.roleid == 6}">onclick="showGroupList();"</c:if><c:if test="${userInfo.roleid != 6}">class="disable-change"</c:if>>
	        	<input class="info" type="hidden" name="orgId" id="memberGroupId"  value="${org.orgId}"/>
	        	<input type="text" name="orgName" class="input-height margin-lf" id="memberGroupName" value="${org.orgName}" readonly="readonly">
	        	<i class="org-search"></i>
        		</span>
			</li>
			<li>
				<label>测量日期：</label> 
				<input class="info-date" id="startDate" type="text" name="sTestTime" required="required" value='${measure.sTestTime}' readonly="readonly" /> 
				<span class="mar-left">至</span> 
				<input class="info-date" id="endDate" type="text" name="eTestTime" required="required" value='${measure.eTestTime}' readonly="readonly" />
			</li>
			<li>
				<label>出生日期：</label> 
				<input class="info-date" id="birthStart" type="text" name="sBirthday" value='${measure.sBirthday}' readonly="readonly" /> 
				<span class="mar-left">至</span> 
				<input class="info-date" id="birthEnd" type="text" name="eBirthday" value='${measure.eBirthday}' readonly="readonly" />
			</li>
			<li>
				<label>会员性别：</label>
              	<select class="margin-lf select-adjust" name="gender">
                  <option value="">全部</option>
                     <option value="1" <c:if test='${measure.gender eq 1}'>selected</c:if>>男</option>
                     <option value="2" <c:if test='${measure.gender eq 2}'>selected</c:if>>女</option>
                     <option value="3" <c:if test='${measure.gender eq 3}'>selected</c:if>>未知</option>
              	</select>
            </li>
            <li>
                <label class="fl">会员疾病史：</label>
              	<c:forEach var="dict" items="${diseases}">
				<input class="input-center" name="diseaseIds" type="checkbox" value="${dict.disease_id}" 
				<c:forEach items="${measure.diseaseIds}" var="d">
					<c:if test="${dict.disease_id eq d}">checked="checked"</c:if>
				</c:forEach>
				/><span class="span-center">${dict.disease_name}&nbsp;&nbsp;</span>
				</c:forEach>
            </li>
			<li>
				<button type="button" id="query" class="btn-inquiry ico-search">查询</button>
			</li>
		</ul>
		
	</div>
	<div class="table-box">
		<table class="table-content">
			<thead class="table-title">
				<tr>
					<th rowspan="2">地区</th>
					<th colspan="2">血压测量</th>
					<th colspan="2">血糖测量</th>
					<th colspan="2">三合一心血管测量</th>
					<th colspan="2">动态心电测量</th>
				</tr>
				<tr>
					<th>总人数</th>
					<th>总次数</th>
					<th>总人数</th>
					<th>总次数</th>
					<th>总人数</th>
					<th>总次数</th>
					<th>总人数</th>
					<th>总次数</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${page.result }"  varStatus="statu"  var="item">
				<tr>
					<td>${item.area}</td>
					<td>${item.osbpNum}</td>
					<td>${item.osbpFreq}</td>
					<td>${item.obsrNum}</td>
					<td>${item.obsrFreq}</td>
					<td>${item.oppgNum}</td>
					<td>${item.oppgFreq}</td>
					<td>${item.oecgNum}</td>
					<td>${item.oecgFreq}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	 <div class="page-box">
		<jsp:include  page="/public/pageFoot.jsp"/>
	 </div>
	<div id="menuContent" class="menuContent">
		<div class="menu-title">选择组织名称</div>
		<div class="left-title">
			<input type="text" id="key" class="input-search" >
			<i class="icon-search" onclick="searchNode();"></i>
		</div>
		<ul id="treeDemo" class="pop-ztree ztree"></ul>
		<div class="menu-footer">
			<button type="button" class="btn-inquiry" onclick="javascript: $('#menuContent').hide();">确定</button>
			<button type="button" class="btn-cancel" onclick="cancelSeclectGroup();">取消</button>
		</div>
	</div>
</div>
</form>
</body>
</html>
