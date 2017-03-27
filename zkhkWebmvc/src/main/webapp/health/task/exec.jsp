<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>健康管理执行任务</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/js/jquery-ui/themes/overcast/jquery-ui.min.css">
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-ui/jquery-ui.js"></script>
	<script type="text/javascript" src="<%=path %>/js/dataPacker.js"></script>
	<script type="text/javascript" src="<%=path %>/plugins/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="<%=path %>/js/kindeditor/kindeditor.js"></script>
    <script type="text/javascript" src="<%=path %>/js/kindeditor/lang/zh_CN.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<style>
		.info-date {
		    width: 90px;
		    background: url("<%=path %>/img/u17.png") no-repeat scroll right center white;
		    background-size: 15px 15px;
		    padding-top: 3px;
		    padding-bottom: 3px;
		    background-origin: content-box;
		    border: 1px solid #a9a9a9;
		}
		
		.detail-box {
			margin: 20px 0;
		    padding: 15px;
		    border: 1px solid #ccc;
		    font-size: 14px;
		    line-height: 28px;
		    background-color: #eff1f0;
		}
		
		.main-box {
			border: 1px solid #98cc6b;
		}
		
		.main-box ul li {
			margin: 15px 8px;
		}
		
		.fix-label {
			text-align: right;
			font-size: 14px;
			width: 120px;
			margin-right: 10px;
			font-weight: bold;
		}
		
		.mg-right {
			margin-right: 50px;
		}
		
		.mg-right1 {
			margin-right: 2%;
		}
		
		.text-top {
	        vertical-align: text-top;
	    }
	    
	    .task-title {
	    	height: 30px;
	    	line-height: 30px;
	    	color: #007735;
	    	background: #f2f1f1;
	    	font-weight: bold;
	    	padding-left: 8px;
	    	font-size: 14px;
	    }
	    
	    .div-block {
	    	display: inline-block;
	    }
	    
	    .blue {
	    	color: #0000ff;
	    }
	    
	    .Wdate {
	    	width: 140px;
	    }
	    
	    .width-fl {
	    	width: 85%;
	    }
	    
	    .width-fr {
	    	text-align: center;
		    width: 15%;
		    line-height: 56px;
	    }
	    
	    .width-label {
	    	width: 120px;
	    	text-align: left;
	    }
	</style>
	<script type="text/javascript">
		KindEditor.ready(function(K) {
	        window.editor = K.create('#richText',{
	        	/* pasteType : 1, */ 
	        	afterCreate : function(){
	                 this.sync();
	             },
	             afterChange: function(){ //编辑器内容发生变化后，将编辑器的内容设置到原来的textarea控件里
	                 this.sync();
	                 $('.word_count1').html(this.count()); //字数统计包含HTML代码
	                 //$('.word_count2').html(this.count('text'));  //字数统计包含纯文本、IMG、EMBED，不包含换行符，IMG和EMBED算一个文字
	                 //////////
	                 //限制字数
	                 var limitNum = 20000;  //设定限制字数
	                 var pattern = '还可以输入' + limitNum + '字符'; 
	                 $('.word_surplus').html(pattern); //输入显示
	                 if(this.count() > limitNum) {
	                  pattern = ('字数超过限制，请适当删除部分内容');
	                  $('.word_surplus').html(pattern);
	                  $('.word_surplus').addClass('red');
	                  } else {
	                  //计算剩余字数
	                  var result = limitNum - this.count(); 
	                  pattern = '还可以输入' +  result + '字符'; 
	                  $('.word_surplus').html(pattern); //输入显示
	                  $('.word_surplus').removeClass('red');
	                  }
	             },
	             afterBlur : function(){ //编辑器聚焦后，将编辑器的内容设置到原来的textarea控件里
	                 this.sync();
	             }
	        });
	    });	
		
		
		function goBack(url){
			if($.trim($("textarea[name='execResult']").val()) == ''){
				if($("select[name='conclusionType']").length > 0 && $("select[name='conclusionType']").val() != ''){
					layer.confirm("您填写的信息未保存，您是否要保存？", {
						skin : 'skin1',
				   	    shade: 0,
				   	 	btn: ['确定','取消']
					}, function(){
						save(true);
					}, function(){
						if(url)
							window.location.href = url;
						else
							window.history.go(-1);
					});
				}else {
					window.history.go(-1);
				}
			}else {
				layer.confirm("您填写的信息未保存，您是否要保存？", {
					skin : 'skin1',
			   	    shade: 0,
			   	 	btn: ['确定','取消']
				}, function(){
					save(true);
				}, function(){
					if(url)
						window.location.href = url;
					else
						window.history.go(-1);
				});
			}
		}
		function save(backSave){
			var exec = true;
			if(backSave){
				if($("#questionnaire").length > 0){
					exec = false;
				}else if($("#hypertension").length > 0){
					exec = false;
				}else if($("#diabetes").length > 0){
					exec = false;
				}else if($("select[name='conclusionType']").val() == ''){
					exec = false;
				}else if(${pojo.designTask.taskType ne 7} && $("textarea[name='execResult']").length > 0 && $.trim($("textarea[name='execResult']").val()) == ''){
					exec = false;
				}
			}else{
				if($("#questionnaire").length > 0){
					$("#questionnaire-error").html('请填写问卷!');
					return;
				}
				if($("#hypertension").length > 0){
					$("#hypertension-error").html('请填写高血压随访表!');
					return;
				}
				if($("#diabetes").length > 0){
					$("#diabetes-error").html('请填写糖尿病随访表!');
					return;
				}
				if($("select[name='conclusionType']").val() == ''){
					$("#conclusionType-error").html('必选!');
					return;
				}
				if(${pojo.designTask.taskType ne 7}){
					if($("textarea[name='execResult']").length > 0 && $.trim($("textarea[name='execResult']").val()) == ''){
						$("#execResult-error").html('必填!');
						$("textarea[name='execResult']").focus();
						return;
					}
				}
				
			}
			if(exec && '${pojo.design.schemeType}' == '1' && '${pojo.designTask.taskType}' != '7'){
				$.ajax({
					   type: "GET",
					   url: "../managescheme/selectHasOtherExecutoryTask",
					   data: {MSExecID: '${pojo.MSExecID}', MSETaskID: '${pojo.MSETaskID}'},
					   success: function(msg){
					     if(!msg.data){
					    	 layer.confirm("${member.memname}的${pojo.design.schemeTitle}中所有任务已执行完成，是否要终止此方案吗？", {
									skin : 'skin1',
							   	    shade: 0,
							   	 	btn: ['确定','否']
								}, function(){
									$('input[name="termination"]').val(true);
									layer.closeAll();
									$("#form_work").submit();
								}, function(){
									$('input[name="termination"]').val(false);
									layer.closeAll();
									$("#form_work").submit();
								});
					     }else{
					    	 $("#form_work").submit();
					     }
					   }
					});
			}else{
				$("#form_work").submit();
			}
		}
		$(function(){
			$("#save").click(function(){
				save(false);
			})
		})
	</script>
</head>
<body>
<div class="content">
	<div class="content-title">健康管理任务 --- 执行任务</div>
	<div class="detail-box clearfix">
		<div class="fl width-fl">
			<p>姓名：<span class="mg-right">${member.memname}</span>性别：<span class="mg-right">${member.gender eq 1 ? '男' : item.gender eq 2 ? '女' : '未知'}</span>年龄：<span class="mg-right">${age}</span>手机号码：<span class="mg-right">${member.tel}</span>身份证号码：<span class="mg-right">${member.idcard}</span>状态：<span class="mg-right">${member.status eq 'T' ? '正常' : '冻结'}</span></p>
			<p>会员疾病史：<span class="mg-right">
				<c:forEach items="${diseases}" var="disease">
					${disease.diseasename}；
				</c:forEach>
			</span>会员标签：<span>
				<c:forEach items="${labels}" var="label">
					${label.itemname};
				</c:forEach>
			</span></p>
		</div>
		<div class="fr width-fr">
			<button type="button" class="btn-inquiry" onclick="window.open('<%=path %>/member/${member.memberid }/memberPage', '_blank')">查看会员信息</button>
		</div>
	</div>
    <form action="exec" method="POST" id="form_work">
    	<input type="hidden" name="source" value="${param.source}">
    	<input type="hidden" name="MSExecID" value="${pojo.MSExecID}">
    	<input type="hidden" name="MSETaskID" value="${pojo.MSETaskID}">
    	<input type="hidden" name="MSDTaskID" value="${pojo.MSDTaskID}">
    	<input type="hidden" name="memberId" value="${member.memberid}">
    	<input type="hidden" name="designTask.taskType" value="${pojo.designTask.taskType}">
    	<input type="hidden" name="designTask.execWay" value="${pojo.designTask.execWay}">
    	<input type="hidden" name="designTask.taskRefID" value="${pojo.designTask.taskRefID}">
    	<input type="hidden" name="designTask.summary" value="${pojo.designTask.summary}">
    	<input type="hidden" name="design.MSDesignID" value="${pojo.design.MSDesignID}">
    	<input type="hidden" name="design.schemeType" value="${pojo.design.schemeType}">
    	<input type="hidden" name="termination" value="false">
		<div class="main-box">
			<div class="task-title">执行任务</div>
			<ul>
				<li>
					<label class="fix-label">计划执行时间：</label>
	                <label class="width-label"><fmt:formatDate value='${pojo.planTime}' pattern="yyyy-MM-dd"/></label>
	                <label class="fix-label">实际执行时间：</label>
	                <c:if test="${pojo.designTask.execWay ne 3}">
	                	<span><input type="text" class="Wdate" name="execTime" value="<fmt:formatDate value='${pojo.execTime}' pattern="yyyy-MM-dd HH:mm:ss"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});" readonly></span>
	                </c:if>
	                <c:if test="${pojo.designTask.execWay eq 3}">
	                	<span><input type="text" name="execTime" value="<fmt:formatDate value='${pojo.execTime}' pattern="yyyy-MM-dd HH:mm:ss"/>" style="width: 120px;" readonly></span>
	                </c:if>
				</li>
				<li>
					<label class="fix-label">执行医生：</label>
	                <label class="width-label">${pojo.design.execDrName}</label>
	                <c:if test="${pojo.designTask.taskType ne 7}">
	                <label class="fix-label">执行方式：</label>
	                <span>${pojo.designTask.execWayName}</span>
	                </c:if>
				</li>
				<li>
					<label class="fix-label">任务类型：</label>
	                <span>${pojo.designTask.taskTypeName}</span>
				</li>
				<li>
					<label class="fix-label">任务概述：</label>
	                <span>${pojo.designTask.summary}</span>
				</li>
				<c:choose>
					<c:when test="${pojo.designTask.taskType eq 1}">
						<li>
							<label class="fix-label">详情内容：</label>
			                <span><a href="getHealthEducationDetail?id=${pojo.designTask.taskRefID}">点击查看</a></span>
						</li>
					</c:when>
					<c:when test="${pojo.designTask.taskType eq 2 || pojo.designTask.taskType eq 3}">
						<li>
							<label class="fix-label">任务说明：</label>
			                <span>${pojo.designTask.content}</span>
						</li>
					</c:when>
					<c:when test="${pojo.designTask.taskType eq 4}">
						<c:if test="${pojo.designTask.execWay ne 3}">
						<li>
							<label class="fix-label"><span class="red">*</span>执行问卷：</label>
							<c:choose>
								<c:when test="${pojo.ref.done}">
									<span>${pojo.designTask.taskRef.name}(已填写)<button type="button" class="btn-cancel" onclick="window.location.href='toAnswerQuestion?MSETaskID=${pojo.MSETaskID}&qustId=${pojo.designTask.taskRefID}&memberId=${member.memberid}&source=${param.source}'">查看</button></span>
								</c:when>
								<c:otherwise>
									<span id="questionnaire">${pojo.designTask.taskRef.name}(未填写)<button type="button" class="btn-cancel" onclick="window.location.href='toAnswerQuestion?MSETaskID=${pojo.MSETaskID}&qustId=${pojo.designTask.taskRefID}&memberId=${member.memberid}&source=${param.source}'">填写</button></span>
								</c:otherwise>
							</c:choose>
			                <input type="hidden" name="ref['done']" value="${pojo.ref.done}">
			                <span class="red" id="questionnaire-error"></span>
						</li>
						</c:if>
					</c:when>
					<c:when test="${pojo.designTask.taskType eq 5}">
						<c:if test="${pojo.designTask.execWay ne 3}">
						<li>
							<label class="fix-label"><span class="red">*</span>高血压随访结果：</label>
							<c:choose>
								<c:when test="${pojo.ref.done}">
									<span>高血压随访表(已填写)<button type="button" class="btn-cancel" onclick="window.location.href='toHypertension?MSETaskID=${pojo.MSETaskID}&memberId=${member.memberid}&execWay=${pojo.designTask.execWay}&source=${param.source}'">查看</button></span>
								</c:when>
								<c:otherwise>
									<span id="hypertension">高血压随访表(未填写)<button type="button" class="btn-cancel" onclick="window.location.href='toHypertension?MSETaskID=${pojo.MSETaskID}&memberId=${member.memberid}&execWay=${pojo.designTask.execWay}&source=${param.source}'">填写</button></span>
								</c:otherwise>
							</c:choose>
			                <input type="hidden" name="ref['done']" value="${pojo.ref.done}">
			                <span class="red" id="hypertension-error"></span>
						</li>
						</c:if>
					</c:when>
					<c:when test="${pojo.designTask.taskType eq 6}">
						<c:if test="${pojo.designTask.execWay ne 3}">
						<li>
							<label class="fix-label"><span class="red">*</span>糖尿病随访结果：</label>
							<c:choose>
								<c:when test="${pojo.ref.done}">
									<span>糖尿病随访表(已填写)<button type="button" class="btn-cancel" onclick="window.location.href='toDiabetes?MSETaskID=${pojo.MSETaskID}&memberId=${member.memberid}&execWay=${pojo.designTask.execWay}&source=${param.source}'">查看</button></span>
								</c:when>
								<c:otherwise>
									<span id="diabetes">糖尿病随访表(未填写)<button type="button" class="btn-cancel" onclick="window.location.href='toDiabetes?MSETaskID=${pojo.MSETaskID}&memberId=${member.memberid}&execWay=${pojo.designTask.execWay}&source=${param.source}'">填写</button></span>
								</c:otherwise>
							</c:choose>
			                <input type="hidden" name="ref['done']" value="${pojo.ref.done}">
			                <span class="red" id="diabetes-error"></span>
						</li>
						</c:if>
					</c:when>
					<c:otherwise>
						<li>
							<label class="fix-label">总体管理目标：</label>
			                <span class="div-block text-top"><textarea rows="6" cols="90" disabled="disabled" >${pojo.designDetail.manageGoal}</textarea></span>
						</li>
						<li>
							<label class="fix-label">总结：</label>
			                <span class="div-block text-top"><textarea name="execResult" id="richText">${pojo.execResult}</textarea></span>
						</li>
						<li>
							<label class="fix-label"><span class="red">*</span>结论：</label>
			                <span>
			                	<select id="u263_input" name="conclusionType">
						          <option value="">请选择</option>
						          <option value="1" <c:if test="${pojo.conclusionType eq 1}">selected="selected"</c:if>>继续执行</option>
						          <option value="2" <c:if test="${pojo.conclusionType eq 2}">selected="selected"</c:if>>终止方案</option>
						          <option value="3" <c:if test="${pojo.conclusionType eq 3}">selected="selected"</c:if>>执行下一阶段方案</option>
						        </select>
			                </span>
			                <span class="red" id="conclusionType-error"></span>
						</li>
					</c:otherwise>
				</c:choose>
				<c:if test="${pojo.designTask.taskType ne 7 and pojo.designTask.execWay ne 3}">
					<li>
						<label class="fix-label"><span class="red">*</span>任务执行结果：</label>
		                <span><textarea rows="6" cols="80" name="execResult" class="text-top" maxlength="500">${pojo.execResult}</textarea></span>
		                <br>
		                <span class="red" id="execResult-error" style="margin-left: 132px; margin-top: 8px; display: inline-block;"></span>
					</li>
				</c:if>
			</ul>
		</div>
		<div class="page-box align-center">
	        <button type="button" class="btn-inquiry" id="save">${pojo.designTask.execWay eq 3 ? '立即发送' : '保存'}</button>
	        <c:if test="${pojo.designTask.execWay ne 3}">
	        	<button type="button" class="btn-cancel" onclick="goBack('${param.source}')">返回</button>
        	</c:if>
	        <c:if test="${pojo.designTask.execWay eq 3}">
	        	<button type="button" class="btn-cancel" onclick="history.go(-1);">返回</button>
	        </c:if>
        </div>
	</form>
</div>
</body>
</html>