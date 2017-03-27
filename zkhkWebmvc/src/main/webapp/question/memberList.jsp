<%@ page contentType="text/html; charset=utf-8" language="java" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>会员中心</title>
	<link rel="stylesheet" href="<%=path %>/js/jquery-ui/themes/overcast/jquery-ui.min.css">
	<link rel="stylesheet" href="<%=path %>/plugins/zTree_v3/css/zTreeStyle/zTreeStyle.css">
	<link rel="stylesheet" href="<%=path %>/plugins/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/css/tree.css">

	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-ui/jquery-ui.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.core-3.5.min.js"></script>
	<script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.excheck-3.5.js"></script>
	<script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.exhide-3.5.js"></script>
	<script type="text/javascript" src="<%=path %>/js/dataPacker.js"></script>
	<script type="text/javascript" src="<%=path %>/js/tree.js"></script>
	<script type="text/javascript" src="<%=path %>/js/members.js"></script>

	<script type="text/javascript">
		$(function(){
			//全选和反选
			$("#checkAll").click(function() {
	            $('input[name="memberIds"]:checkbox').not(':disabled').prop("checked",this.checked); 
	        });
	        var $subBox = $("input[name='memberIds']");
	        $subBox.click(function(){
	            $("#checkAll").prop("checked",$subBox.length == $("input[name='memberIds']:checked").not(':disabled').length ? true : false);
	        });
	        
	        $(".sendQuestion").click(function(){
	        	 var $this = this; 
	        	 var url = $this.getAttribute('data-href');
				 if(!$this.disabled&&confirm('确认发放问卷？')){
					 $this.disabled=true;
					  $.ajax({
						   type: "GET",
						   url: url,
						   success: function(msg){
							 alert(msg.content);
							 $this.disabled = false;
							 if(msg.status){
								 search();
							 }
						   }
						});
				 }
	        });
		});
		
		function give(index,qid){
				$("#btndel2").attr("disabled", true);
				var checkeds = $("input[name='memberIds']:checked");
				if(checkeds.length == 0) {
					alert("请选中你要发放的会员！");
	       	    }else{
	       	    	var url ="";
	    		 	var location = "";
	    			if (index ==1){
	    				url = "singleAnswer/give";
	                   location = "<%=path %>/mem/MemberAction_getAllMemberList" ;
	    			}else if (index == 2) {
	    				url = "comAnswer/give";
	                    location = "<%=path %>/mem/MemberAction_getAllMemberList";
	    			}	 
	    		 	$.ajax( {
	    		    	url: url+"?qustId="+qid,
	    		    	data: $.param(checkeds),
	    				type:'post',
	    				cache:false,
	    				async: false,
	    				success:function(result) {
	    					if (result.status){
	    						alert("发放成功");
	    						search();
	    					}else{
	    						alert("发放失败！");
	    						$("#btndel2").attr("disabled", false);
	    					}
	    				},
	    				error : function() {
	    					alert("发放失败！");
	    				}
	    			});
	       	    }
		       	   
	// 		 	var values=mems.toString();
			 	$("#btndel2").attr("disabled", false);
			}
	</script>
</head>
<body>
<div class="content">
	<div class="content-title"><c:if test="${condition.qustid gt 0}">单份</c:if><c:if test="${condition.combQustid gt 0}">组合</c:if>问卷列表 --- 发放</div>
	<form action="members" id="condition">
		<div class="search-box-wrapper">
			<input id="flag" type="hidden" value="${flag}"/> 
		    <!-- 问卷开始 -->                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
		    <c:if test="${condition.qustid != null}">
				<input type="hidden" name="qustid" value="${condition.qustid}">
			</c:if>
			<c:if test="${condition.combQustid != null}">
				<input type="hidden" name="combQustid" value="${condition.combQustid}" />
			</c:if>
			<!-- 问卷结束 -->
			<ul class="search-wrapper">
				<li>
					<span class="label">会员姓名：</span>
	                <input class="info info-name" type="text" name="memName" value="${condition.memName }">
				</li>
				<li>
					<span class="label label-4x">性别：</span>
                    <select class="info control-select" name="gender">
                        <option value="">全部</option>
                        <c:choose>
                        <c:when test="${condition.gender eq 1}">
                          <option value="1" selected>男</option>
                        </c:when>
                        <c:otherwise>
                          <option value="1">男</option>
                        </c:otherwise>
                        </c:choose>
                        
                        <c:choose>
                        <c:when test="${condition.gender eq 2}">
                          <option value="2" selected>女</option>
                        </c:when>
                        <c:otherwise>
                          <option value="2">女</option>
                        </c:otherwise>
                        </c:choose>
                        
                        <c:choose>
                        <c:when test="${condition.gender eq 3}">
                          <option value="3" selected>未知</option>
                        </c:when>
                        <c:otherwise>
                          <option value="3">未知</option>
                        </c:otherwise>
                        </c:choose>
                    </select>
				</li>
				<li>
					<span class="label">会员类型：</span>
                    <select class="info control-select" name="memType">
                        <option value="">全部</option>
                        <c:forEach items="${typeList }" var="item">
                        <c:choose>
                        <c:when test="${condition.memType eq item.memid }">
                        <option value="${item.memid }" selected>${item.memname }</option>
                        </c:when>
                        <c:otherwise>
                        <option value="${item.memid }">${item.memname }</option>
                        </c:otherwise>
                        </c:choose>
                        </c:forEach>
                    </select>	
				</li>
				<li>
					<span class="label">出生日期：</span>
                    <input class="info info-date" id="startDate" type="data" name="birthDayStart" value="${condition.birthDayStart }" readonly="readonly"/>
                    <span style="margin-left: 15px;">至</span>
                    <input class="info info-date" id="endDate" type="data" name="birthDayEnd" value="${condition.birthDayEnd }" readonly="readonly"/>	
				</li>
				<li>
					<span class="label">疾病状况：</span>
                    <input class="info info-illness" type="text" name="diseaseName" value="${condition.diseaseName }">	
				</li>
				<li>
					<span class="label">身份证号：</span>
	                <input class="info info-idCard" type="text" name="idcard" value="${condition.idcard }">
				</li>
				<li>
					<span class="label">手机号码：</span>
	                <input class="info info-tel" type="text" name="tel" value="${condition.tel }">	
				</li>
				<li>
					<button type="button" id="query" onclick="search(1)" class="btn-inquiry ico-search font-change">查询</button>
				</li>
			</ul>
		</div>
		<c:choose>
		<c:when test="${page.totalCount eq 0}">
		<div class="empty-info">没有查询到符合条件的会员</div>
		</c:when>
		<c:otherwise>
			<div class="table-box">
				<table class="table-content">
					<thead class="table-title">
						<tr>
							<th width="5%">全选<input type="checkbox" id="checkAll"></th>
							<th width="5%">序号</th>
							<th width="5%">姓名</th>
							<th width="5%">性别</th>
							<th width="8%">出生日期</th>
							<th width="9%">手机号码</th>
							<th width="8%">注册日期</th>
							<th width="10%">疾病状况</th>
							<th width="6%">最近测量</th>
							<th>所属分组</th>
							<th width="8%">备注</th>
							<th width="8%">状态</th>
							<th width="8%">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${page.result}" varStatus="statu" var="item">
							<tr id="tr_${item.memberId}">
								<td><input name="memberIds" type="checkbox" data-memname="${item.memName}" value="${item.memberId}"></td>
								<td>${(page.pageSize)*(page.pageNo)-((page.pageSize))+(statu.index+1) }</td>
								<td><a href="<%=path %>/member/${item.memberId }/memberPage" target="_blank"><c:out value="${item.memName}"></c:out></a></td>
								<td>
									<c:if test="${item.gender== 1}">男</c:if>
									<c:if test="${item.gender== 2}">女</c:if>
									<c:if test="${item.gender== 3}">未知</c:if>
								</td>
								<td><fm:formatDate value="${item.birthDay}" type="date" pattern="yyyy-MM-dd" dateStyle="long" /></td>
								<td>${item.tel }</td>
								<td><fm:formatDate value="${item.createTime}" type="date" pattern="yyyy-MM-dd" dateStyle="long" /></td>
								<td>${item.diseaseNames }</td>
								<td>
								<fm:formatDate value="${item.lastTestTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
								</td>
								<td>${item.memGrpNames }</td>
								<td>
								${fn:substring(item.memDesc,0,10) }
								</td>
								<td>
								<c:choose>
								<c:when test="${item.status eq 'T' }"><img src="<%=path %>/img/normal.png"/></c:when>
								<c:otherwise><img src="<%=path %>/img/frozen.png"/></c:otherwise>
								</c:choose>
								</td>
								<c:if test="${condition.qustid > 0}">
									<td id="table_content_title_td">
										<a href="javascript:void(0);" class="sendQuestion" data-href="singleAnswer/give?qustId=${condition.qustid}&memberIds=${item.memberId}">发放单份</a>
									</td>
								</c:if> 
								<c:if test="${condition.combQustid > 0}">
									<td id="table_content_title_td">
										<a href="javascript:void(0);" class="sendQuestion" data-href="comAnswer/give?qustId=${condition.combQustid}&memberIds=${item.memberId}">发放组合</a>
									</td>
								</c:if>
								
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			</c:otherwise>
		</c:choose>
		<div class="page-box">
				<div class="fl">
					<c:if test="${condition.qustid > 0}">
						<button id="btndel2" type="button" class="btn-inquiry" onclick="give(1,${condition.qustid})">批量发放</button>
					</c:if>
					<c:if test="${condition.combQustid > 0}">
						<button id="btndel2" type="button" class="btn-inquiry" onclick="give(2,${condition.combQustid})">批量发放</button>
					</c:if>
				</div>
				<jsp:include page="/public/pageFoot.jsp"/>
		    </div>
		<div id="loading-mask"></div>
		<div id="fullbg"></div>
	</form>
</div>
</body>
</html>
