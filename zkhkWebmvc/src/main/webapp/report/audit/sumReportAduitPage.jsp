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
	<title>汇总审核报告</title>

	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/css/vip.css">

	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/calendar.js"></script>
	<script type="text/javascript" src="<%=path %>/js/kindeditor/kindeditor.js"></script>
	<script type="text/javascript" src="<%=path %>/js/kindeditor/lang/zh_CN.js"></script>
	<script type="text/javascript" src="<%=path %>/js/popupPage1.js"></script>
	<script type="text/javascript">
		var userInfo_orgId = ${empty userInfo.dept_id}?0:${userInfo.dept_id};
		KindEditor.ready(function(K) {		
			window.editor = K.create('#myAdvice', {
				height : '300px',
				width : '100%',
				orgid: userInfo_orgId
			});
			
		});
		function sumReport(reportId,auditLevel) {
			console.log(reportId);
			window.location.href="../audit/SumMeasueRepAction!toExportPreview?reportNo="+reportId+"&auditLevel="+auditLevel;
		}
	
		//医生签名没有图片的时候，加载一个默认图片（此处加载的为1*1px透明图）
		function nofind(){
		var img=event.srcElement;
		img.src="<%=basePath%>/img/namedefault.png";
		img.onerror=null; //控制onerror事件只触发一次 
		}

		$(function(){
			 $("#btn").toggle(function(){
				$(this).after("<div class='reason-box'><span>请填写退审原因</span><textarea name='approvalReason' rows='2' cols='50'/><br /><input type='button' class='btn-normal' id='reback' onclick='rebacklevel()' value='退审'/></div>");
				return false;
			},
			function(){$(this).next("div").remove();
				return false;
			});
			$("#return").click(function(){
				//var sourceType = "${sourceType}";
				//if(sourceType == 'memSumRep' ){
				//	window.location.href = "<%=path %>/summaryReport/toMemSumReportPage?memberid=${omem.memberid}";
				//}else{
					
				//}
				window.history.go(-1);
				return false;
			});
			
			$("#reAuditContent").toggle(function(){
				$(this).after("<div class='reason-box'><span>请填写重审内容</span><textarea id='reAudit' rows='2' cols='50'/><br /><input type='button' class='btn-normal' onclick='reAuditAjax()' value='提交'/></div>");
				return false;
			},
			function(){$(this).next("div").remove();
				return false;
			});
	 		
		});
		
		function rebacklevel(){
			if($.trim($("textarea[name='approvalReason']").val())==''){
				   alert('退审内容不能为空');
				   return;
			   }
			   //alert($("textarea[name='approvalReason']").val());
			   var param = {reportNo:$("input[name='oasr.reportNo']").val(),cur_level:$("input[name='oasr.auditLevel']").val(),msg:$("textarea[name='approvalReason']").val()};
			   //alert(param.reportNo);
			   //alert(param.cur_level);
			  // alert(param.msg);
			   //http://127.0.0.1:8080/HKEJ/audit/SumMeasueRepAction!rebackLevel
			   $.post('<%=basePath%>audit/SumMeasueRepAction!rebackLevel',param,function(date){
				   //alert(date);
				   if(date.code=='0000'){
					   alert('审核退回成功');
					   window.location.href = date.URL;
				   }else{
					   alert("审核退回失败"+date.err);
					   window.location.href = date.URL;
				   }
			   });
		}
		
		function checkAudit(){
			//判断审核内容
			var myAdvice = $("#myAdvice").val();
			myAdvice = $.trim(myAdvice);
			var length = editor.count('text');
			if(myAdvice==''){
				alert("审核内容不能为空！");
				return false;
			}
			if(length > 1000) {
				alert("审核内容不能够超过1000个字符!");
				//字数统计包含纯文本、IMG、EMBED，不包含换行符，IMG和EMBED算一个文字。）
				return false;
			}
			
			var ret = false;
			var serialNumber = $("#num").val();
			$.ajax( {
		    	url:"../summaryReport/checkSumRepAudit",// 跳转到 action
				data:{
					docentry : serialNumber
				},
				type:'post',
				cache:false,
				async: false,
				dataType:'json',
				success:function(result) {
					if(result.ret =="Y" ){
						ret = true;
					}else if(result.ret=="N"){
						alert("不能重复审核");
					}
				},
				error : function() {
					alert("审核失败！");
				}
			});
			return ret;
		}
		
		function reAuditAjax(){
			var content = $.trim($("#reAudit").val());
			
			if(content == ''){
				alert("请填写重审内容！");
				return false;
			}else{
				var serialNumber = '<s:property value="oasr.serialNumber"/>';
				$.ajax( {
			    	url:"SumMeasueRepAction!reAuditSumRep",// 跳转到 action
					data:{
						serialNumber : serialNumber,
						auditContent : content
					},
					type:"post",
					cache:false,
					async: false,
					dataType:"json",
					success:function(result) {
						if(result.ret =="success" ){
							alert("重新提交审核成功！");
							window.location.reload();
	<%--						$("#chkDescSpanId").html(content);--%>
						}else if(result.ret=="timeOut"){
							alert("终审时间已超过半小时，不能修改审核意见！");
						}else if(result.ret=="empty"){
							alert("重新提交的审核内容不能为空！");
						}else if(result.ret=="error"){
							alert("提交异常！");
						}else{
							alert(result.ret);
						}
					},
					error : function() {
						alert("重新提交审核意见失败！");
						return false;
					}
				});
			}
		}
	</script>

	<style type="text/css">
	  #myAdvice {
			margin: 0;
			padding: 0;
			border: 1px solid #ddd;
			width: 90%;
			resize: none;
			font-family: "Microsoft YaHei";
			color: #333;
	   }
	   
	   .reason-box { 
			background: #faefc6;
			padding: 15px;
	   }
	   
	   .reason-box textarea {
			min-height: 40px;
			border: 1px solid #ddd;
			resize: none;
			width: 90%;
	   }
	   
	  .reason-box span { 
			display: block; 
			margin-bottom: 5px;
	  }
	  
	  .btn-blue {
			font-family: "Microsoft YaHei";
			font-size: 14px; 
			margin-top: 10px;
			font-weight: bold; 
			padding: 3px 10px;
			background: #f60;
			border-radius: 3px;
			background-image: -moz-linear-gradient(center top, rgba(255, 102, 0, 0.8) , rgba(253, 113, 28, 0.8)) repeat scroll 0 0 rgba(255, 102, 0, 0.8);
			background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, rgba(255, 102, 0, 0.8)), color-stop(1, rgba(253, 113, 28, 0.8)));
			color: #fff;
			cursor: pointer;
			outline: none; 
			margin-bottom: 10px;
			display: block;
	  }  
	</style>
</head>
<body>
<div class="content">
	<form action="<%=basePath%>/summaryReport/saveReportAudit" onsubmit="javascript: editor.sync();return checkAudit();" method="post" enctype="application/x-www-form-urlencoded">
		<input type="hidden" name="auditProgress.auditLevel" value="${auditProgress.auditLevel }"/>
		<input type="hidden" id="num" name="auditProgress.serialNumber" value="${auditProgress.serialNumber }"/>
		<input type="hidden" name="oasr.docGrpCode" value="${auditProgress.docGrpCode }"/>
		<input type="hidden" id="docid" name="auditProgress.docid" value="${userInfo.id}"/>
		<input type="hidden" name="auditProgress.reportNo" value="${auditProgress.reportNo }"/>
		<input type="hidden" name="auditProgress.optId" value="${auditProgress.optId }"/>
		<input type="hidden" name="auditProgress.optName" value="${auditProgress.optName }"/>
		<input type="hidden" name="auditProgress.submitOther" value="${auditProgress.submitOther }"/>
		<input type="hidden" name="auditProgress.memberid" value="${auditProgress.memberid}"/>
		<input type="hidden" name="auditProgress.measTime" value="${auditProgress.measTime }"/>
		<input type="hidden" name="auditProgress.measTermTime" value="${auditProgress.measTermTime }"/>
		<input type="hidden" name="auditProgress.measNum" value="${auditProgress.measNum }"/>
		<input type="hidden" name="auditProgress.tempCode" value="${auditProgress.tempCode }"/>
		<input type="hidden" name="auditProgress.grenerTime" value="${auditProgress.grenerTime }"/>
	    
		<input type="hidden" name="serialNumber" value="${auditProgress.serialNumber }"/>
		
		<input type="hidden" name="sourceType" value="${sourceType}"/>
		<input type="hidden" name="memberid" value="${summaryReport.memberid}"/>
		
		<input type="hidden" name="docid" value="${userInfo.id}"/>
		<table class="table-border">
		<c:if test="${fn:length(summaryReport.singleReportList) != 0}">
			<tr><td>报告编号</td><td>产生时间</td><td>测量选项</td><td>测量时间段</td><td>测量次数</td><td>操作</td></tr>
		</c:if>
		<c:if test="${fn:length(summaryReport.singleReportList) == 0}"><span style="color:#333;font-size:16px;font-weight:bold;">没有单项报告产生</span></c:if>
		<c:if test="${fn:length(summaryReport.singleReportList) != 0}">
			<c:forEach var="item" items="${summaryReport.singleReportList}" varStatus="status">
				<tr>
					<td>${item.ID}</td>
					<td><fm:formatDate value="${item.grenerTime}" type="date" pattern="yyy-MM-dd HH:mm:ss" dateStyle="long"/></td>
		            <td>
		               	<c:if test="${item.optId==1 }">血压</c:if>
		               	<c:if test="${item.optId==2 }">血糖</c:if>
		               	<c:if test="${item.optId==3 }">三合一</c:if>
		               	<c:if test="${item.optId==4 }">动态心电</c:if>
		            </td>
		            <td><fm:formatDate value="${item.measTime}" type="date" pattern="MM月dd日" dateStyle="long"/>-<fm:formatDate value="${item.measTermTime}" type="date" pattern="MM月dd日" dateStyle="long"/></td>
		            <td>${item.measNum}</td>
		            <td><a href="../singleReport/getSingleReportDetail?reportNo=${item.ID}">查看</a></td>
	            </tr> 
	         </c:forEach>      
		</c:if>
	</table>
	<div class="result-list-box">	
		     <div class="caption-title">同组医生建议</div>
		     <div class="result-list">	
				 <c:if test="${fn:length(smr1Commons)!= 0}">
				 	<c:set  value="0" var="next"></c:set>	
				 	<c:forEach var="item" items="${smr1Commons}" varStatus="st">
						<li class="audit-box">
						  <div class="audit-content">
						    	<c:choose>
									<c:when test="${fn:length(smr1Commons) == auditProgress.auditLevel && isReAudit == 'Y'}">
										<span id="chkDescSpanId">${item.auditDesc }</span>
									</c:when>
									<c:otherwise>
										${item.auditDesc }
									</c:otherwise>
								</c:choose>
						  </div>
						  <div class="audit-foot clearfix">
							   <div class="fr doc-sign">
							  	审核医生：${item.doctorName }
							  	&nbsp;&nbsp;&nbsp;&nbsp;
							  	<img alt="签名" src="${pageContext.request.contextPath }/image/getImage?uniqueId=${item.signaddress}" width="50"/>
							    </div>
							    <div class="fl">审核时间：<fm:formatDate value="${item.auditTime}" type="both"/> </div>
							    <div class="fl">审核级别： 						    
									<c:choose>
										<c:when test="${item.auditMode eq '2'}">
											[退审]<c:set var="next" value="item.auditMode" />
										</c:when>
										<c:when test="${item.auditMode eq '3' || next eq '2'}">
											[审核]<c:set var="next" value="0" />
										</c:when>
										<c:otherwise>
											<c:set var="next" value="0" />
										</c:otherwise>
									</c:choose>
									${item.auditLevel }
								</div>
						    </div>
						</li>
					</c:forEach>  
					<!-- 重新提交审核 -->
					<c:if test="${request.isReAudit=='Y'}">
						<div><input type="button" id="reAuditContent" value="重新提交审核意见" /></div>
					</c:if>
				</c:if>
				<c:if test="${fn:length(smr1Commons) == 0}">
					<span style="color:#999;">还没有医生建议</span><br><br>
				</c:if>
			</div>
			</div>
			<div class="result-list-box">
				<div class="caption-title">其他组医生建议</div>
				<div class="result-list">
					 <c:if test="${fn:length(smr1Others) != 0}">
					 <c:forEach var="item" items="${mrrOthers}" varStatus="st">
						  <!-- <s:property value="getDocGrpName(docGrpCode)"/>: -->${item.doctorName }
						  &nbsp;&nbsp;&nbsp;&nbsp;
						  <img alt="签名" src="${pageContext.request.contextPath }/image/getImage?uniqueId=${item.signaddress}"/>
						  <br/>
						  时间 ：<fm:formatDate value="${item.auditTime }" type="date" dateStyle="default"/><br/>
						 ${item.auditDesc };<br>
					  </c:forEach>  
					  <br>
					 </c:if>
					 <c:if test="${fn:length(smr1Others) == 0}">
					 	<span style="color:#999;">目前还没有其它组建议</span><br>
					 </c:if>
				 </div>
			 </div>
			 
			 <!-- 判断是否为审核操作，如果为审核操作，isAudit标志不等于N -->
			<c:if test="${auditProgress.serialNumber != null && isAudit != 'N'}">
			       <div class="result-list-box">
					     <div class="caption-title">我的意见建议:<input type="button" value="载入审核意见模板" class="btn-normal float" onclick="popup(userInfo_orgId,1);"></div>
					     <div class="result-list">
					     	<c:if test="${auditProgress.auditLevel==1}">
					     		<c:set var="singlesChkDesc" value=""/>
					     		<c:if test="${fn:length(summaryReport.singleReportList) != 0}">
					     			<c:forEach var="item" items="${summaryReport.singleReportList}" varStatus="st">
					     				<c:if test="${item.chkDesc!=null && item.chkDesc!=''}">
						     				<c:choose>
												<c:when test="${item.optId == 1}">
													<c:set var="singlesChkDesc" value="${singlesChkDesc}血压:${item.chkDesc}&nbsp&nbsp"/>
												</c:when>
												<c:when test="${item.optId == 2}">
													<c:set var="singlesChkDesc" value="${singlesChkDesc}血糖:${item.chkDesc}&nbsp&nbsp"/>
												</c:when>
												<c:when test="${item.optId == 3}">
													<c:set var="singlesChkDesc" value="${singlesChkDesc}三合一:${item.chkDesc}&nbsp&nbsp"/>
												</c:when>
												<c:when test="${item.optId == 4}">
													<c:set var="singlesChkDesc" value="${singlesChkDesc}动态心电:${item.chkDesc}&nbsp&nbsp"/>
												</c:when>																								
											</c:choose>
					     				</c:if>
					     			</c:forEach> 
					     			<textarea id="myAdvice" name="myAdvice" cols="40" rows="5">${singlesChkDesc.trim()}</textarea>
					     		</c:if>
					     		<c:if test="${fn:length(summaryReport.singleReportList) == 0}">
					     			<textarea id="myAdvice" name="myAdvice" cols="40" rows="5"></textarea>
					     		</c:if>
					     	</c:if>
					     		
					     	<c:if test="${fn:length(smr1Commons)!=0}">
					     		<c:if test="${fn:length(smr1Others) != 0}">
					     			<textarea id="myAdvice" name="myAdvice" cols="40" rows="5">${smr1Commons.get(0).auditDesc}</textarea>
					     		</c:if>
					     		<c:if test="${fn:length(smr1Others) == 0}">
					     			<textarea id="myAdvice" name="myAdvice" cols="40" rows="5"></textarea>
					     		</c:if>
					     	</c:if>
					     	<br>
					      </div>
			       </div>
			       <br/>
		           <div><button type="button" class="btn-normal">提交</button> <button type="button" id="return" class="btn-normal">返回</button></div>
		  </c:if>
		  <br/>
		  <a style="color:#f00;text-decoration:none;" href="${pageContext.request.contextPath}/member/detail/${summaryReport.memberid}?resource=report" target="_blank">快速查看会员健康档案>></a><br>
		  <c:if test="${flag==null}">
			<c:if test="${auditProgress.auditLevel>1}">
				<button type="button" id="btn" class="btn-blue">退审</button><br/>
			</c:if>
		 </c:if>
		<c:if test="${isAudit =='N' && fn:length(summaryReport.singleReportList) != 0}">
		<a href="../summaryReport/toExportPreview?reportNo=${auditProgress.reportNo}&auditLevel=${auditProgress.auditLevel}" target="_blank"><input type="button" class="btn-normal" value="导出测量报告"/></a>
		</c:if>
	</form>
</div>
</body>
</html>