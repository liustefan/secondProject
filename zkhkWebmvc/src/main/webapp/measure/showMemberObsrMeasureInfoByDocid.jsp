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
    <title>血糖测量信息</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/css/measureManage.css">
	
	<script src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script src="<%=path %>/js/placeholder.js"></script>

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
	
	var index = layer.getFrameIndex(window.name); //获取窗口索引
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
				 window.location = "../bloodSugar/queryBloodSugar?&wheAbnTag=${wheAbnTag}&docid=${userInfo.id }&pageSize="+pageSize+"&criteria="+encodeURI(encodeURI("${criteria}"));
			});
			
			$("#page-first").click(function(){
				var pageSize=$("#pageSize").val();
			  	var pageNum= "${page.pageNo}";
			  	if(pageNum==1){
			  		return;
			  	}
			  	window.location = "../bloodSugar/queryBloodSugar?wheAbnTag=${wheAbnTag}&docid=${userInfo.id }&pageNo=1&criteria="+encodeURI(encodeURI("${criteria}"))+"&pageSize="+pageSize; 
			});
			
			$("#page-last").click(function(){
				var pageSize=$("#pageSize").val();
			  	var pageNum= "${page.pageNo}";
			  	if(pageNum=="${page.totalPages}"){
			  		return false;
			  	}
			  	window.location = "../bloodSugar/queryBloodSugar?wheAbnTag=${wheAbnTag}&docid=${userInfo.id }&pageNo=${page.totalPages}&criteria="+encodeURI(encodeURI("${criteria}"))+"&pageSize="+pageSize;
			});
			
			$("#pre").click(function(){
				var pageSize=$("#pageSize").val();
			  	var pageNum= "${page.pageNo}";
			  	if(pageNum==1){
			  		return;
			  	}
			  	window.location = "../bloodSugar/queryBloodSugar?wheAbnTag=${wheAbnTag}&docid=${userInfo.id }&pageNo=${page.pageNo-1}&criteria="+encodeURI(encodeURI("${criteria}"))+"&pageSize="+pageSize; 
			});
			
			$("#nex").click(function(){
				var pageSize=$("#pageSize").val();
			  	var pageNum= "${page.pageNo}";
			  	if(pageNum=="${page.totalPages}"){
			  		return;
			  	}
			  	window.location = "../bloodSugar/queryBloodSugar?wheAbnTag=${wheAbnTag}&docid=${userInfo.id }&pageNo=${page.pageNo+1}&criteria="+encodeURI(encodeURI("${criteria}"))+"&pageSize="+pageSize; 
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
				else{
					var topage= $("#toPage");
					topage.val(pageNow);
				  	window.location = "../bloodSugar/queryBloodSugar?wheAbnTag=${wheAbnTag}&docid=${userInfo.id }&pageNo=" + num + "&criteria="+encodeURI(encodeURI("${criteria}"))+"&pageSize="+pageSize;			
				}
			});
			
			$("#select1").click(function(){
				var criteria=$("#find").val();
		  		var url = "../bloodSugar/queryBloodSugar?wheAbnTag=${wheAbnTag}&docid=${userInfo.id}&criteria="+encodeURI(encodeURI(criteria));
			  	window.location = url;
			});
			
			// 全选
			$("#allSelect").click(function() {
				$(":checkbox[name='checkbox']:not(:disabled)").each(function() {
					this.checked = true;
				});
			});
			// 反选
			$("#unSelect").click(function() {
				$(":checkbox[name='checkbox']:not(:disabled)").each(function() {
					this.checked = !this.checked;
				});
			});
		});
		
		//点击左下角删除时进行的一些判断
		function deleteInfo(docid, wheAbnTag){
			var checkboxs = $("input[name='checkbox']:checked").length;
			if(checkboxs <= 0){
				alert("请勾选需要删除的测量项");
				return false;
			}else{
				if (confirm("确定要删除这些测量信息吗？")) {
					var s = '';
					$("input[name='checkbox']:checked").each(function(){
					    s += $(this).val()+',';
					});
					if(wheAbnTag == 1){
						window.location = "../bloodSugar/deleteBatchBloodSugarInfo?parameter="+s+"&wheAbnTag=1&docid="+docid;
					}else{
						window.location = "../bloodSugar/deleteBatchBloodSugarInfo?parameter="+s+"&wheAbnTag=0&docid="+docid;
					}
				}else{
					return false;
				}
			}
		}
	</script>
</head>
<body>
<div class="content">
	<div class="content-title">
		血糖
	</div>
	<div class="clearfix" style="position: relative;">
		<div class="fr">  
			<input type="text" name="criteria" value="${criteria}" id="find" placeholder="模糊匹配姓名、手机、测量方式">
			<input type="hidden" name="myFlag" value="YAndN">
			<button type="button" id="select1" onclick="search()"><img src="${pageContext.request.contextPath}/img/sousuo.png"/></button>
		</div>
	</div>
	<ul class="content-tabs">
		<li>
		   	<a <c:if test="${wheAbnTag==1 }">class="current"</c:if>
	   		href="../bloodSugar/queryBloodSugar?wheAbnTag=1&docid=${userInfo.id }">异常测量数据</a>
		</li>
		<li>
	    	<a <c:if test="${wheAbnTag==0 }">class="current"</c:if>
	        href="../bloodSugar/queryBloodSugar?wheAbnTag=0&docid=${userInfo.id }">所有测量数据</a>
		</li>
	</ul>	
	<div class="border-1-solid">
		<c:if test="${empty page.result }">
			<div class="empty-info">
				<c:if test="${wheAbnTag==1 }">
			  		目前没有异常血糖测量信息
			  	</c:if>
			  	<c:if test="${wheAbnTag!=1 }">
			  		目前没有任何血糖测量信息
			  	</c:if>
			</div>
		</c:if >
		<c:if test="${not empty page.result }">
			<div class="table-box">
				<table class="table-content">
				<thead class="table-title">
					<tr>
						<th>选择</th>
						<th>会员姓名</th>
						<th>性别</th>
						<th>出生日期</th>
						<th>手机号码</th>
						<th>测量方式</th>
						<th>血糖(mmol/L)</th>
						<th>测量时间</th>
						<th>测量时段</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${page.result }" var="item">
					<tr>
					<td id="list"><input type="checkbox" name="checkbox" id="checkbox" value="${item.docentry }"></td>
					<td>${item.memName }</td>
					<td>${item.gender == 1?'男':item.gender== 2?'女':'未知'}</td>
					<td><fmt:formatDate value="${item.birthDate}" type="date"
							pattern="yyyy-MM-dd" dateStyle="long" /></td>
					<td>${item.tel }</td>
					<td>${item.devicecode }</td>
					<td>${item.bsvalue }</td>
					<td><fmt:formatDate value="${item.testtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td>
							<c:if test="${item.timeperiod == 0}">其它时间</c:if>
							<c:if test="${item.timeperiod == 1}">早餐前</c:if>
							<c:if test="${item.timeperiod == 2}">早餐后2小时</c:if>
							<c:if test="${item.timeperiod == 3}">午餐前</c:if>
							<c:if test="${item.timeperiod == 4}">午餐后2小时</c:if>
							<c:if test="${item.timeperiod == 5}">晚餐前</c:if>
							<c:if test="${item.timeperiod == 6}">晚餐后2小时</c:if>
							<c:if test="${item.timeperiod == 7}">睡前</c:if>
							<c:if test="${item.timeperiod == 8}">夜间</c:if>
					</td>
					<td>
					     <a href="../bloodSugar/showSingleBloodSugar?memberId=${item.memberid }&eventId=${item.eventid}&flag=${flag}" target="_blank">查看</a>
						<c:choose>
							<c:when test="${wheAbnTag == 1 }">
								<a class="mar-left" onclick="return confirm('确认删除吗？');" href="../bloodSugar/deleteBloodSugarInfo?docentry=${item.docentry }&wheAbnTag=1&docid=${userInfo.id}">删除</a>
							</c:when>
							<c:otherwise>
								<a class="mar-left" onclick="return confirm('确认删除吗？');" href="../bloodSugar/deleteBloodSugarInfo?docentry=${item.docentry }&wheAbnTag=0&docid=${userInfo.id}">删除</a>
							</c:otherwise>
						</c:choose>
					</td>
					</tr>
					</c:forEach>
				</tbody>
				</table>	
			</div>
			<div class="page-box">
			    <div class="fl">
			        <button type="button" id="allSelect" class="btn-inquiry">全选</button>
			        <button type="button" id="unSelect" class="btn-inquiry">反选</button>
			        <button type="button" id="" class="btn-inquiry" onclick="return deleteInfo(${userInfo.id }, ${wheAbnTag});">删除</button>
			    </div>
		    	<div class="page fr">
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
			     	<a id="page-last" class="page-btn">尾页</a> 
			    </div>
			</div>
		</c:if>
	</div>
</div>
</body>
</html>
