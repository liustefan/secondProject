<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*"%>
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
	<title>组合答卷审核界面</title>
	<link rel="stylesheet" href="<%=path %>/js/kindeditor/themes/default/default.css">
	<link rel="stylesheet" href="<%=path %>/css/vip.css">
	<link rel="stylesheet" href="<%=path %>/css/reset.css">
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/kindeditor/kindeditor-min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/popupPage1.js"></script>
	<script type="text/javascript" src="<%=path %>/js/kindeditor/lang/zh_CN.js"></script>

	<style type="text/css">
	.content {
	    width: 100%;
	    padding: 10px 1% 0 1%;
	    margin-top: 0 !important;
	    -webkit-box-sizing: border-box;
	    -moz-box-sizing: border-box;
	    box-sizing: border-box;
	}

	.reason-box {
		margin: 1em 2em 0 2em;
		background: #faefc6;
		padding: 15px;
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
		background-image: -moz-linear-gradient(center top, rgba(255, 102, 0, 0.8),
			rgba(253, 113, 28, 0.8)) repeat scroll 0 0 rgba(255, 102, 0, 0.8);
		background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, rgba(255,
			102, 0, 0.8)), color-stop(1, rgba(253, 113, 28, 0.8)));
		color: #fff;
		cursor: pointer;
		outline: none;
		margin-bottom: 10px;
	}
	
	.caption-title {
		border-top-left-radius: 3px;
		border-top-right-radius: 3px;
		background: #bcdee0;
		height: 35px;
		text-align: left;
		font-weight: bold;
		color: #333;
		font-size: 14px;
		line-height: 35px;
		text-indent: 1em;
	}
	
	.result-list-box {
		width: 100%;
		margin: 0 auto;
		margin-top: 20px;
	}
	
	.result-list {
		padding: 15px;
		font-size: 14px;
	}
	
	.result-list ol li {
		font-size: 14px;
		color: #333;
		margin: 7px 0;
	}
	
	.result-list ol li img,.sz-answer-list ol li img {
		max-width: 64px;
		max-height: 64px;
		border: none;
		outline: none;
	}
	
	.answer-box {
		background: #f6ff6;
		border: 1px solid #ddd;
		padding: 20px;
	}
	
	.answer-box ol {
		width: 80%;
		margin: 0 auto;
	}
	
	.question-title {
		font-size: 14px;
		padding: 10px 0px;
	}
	
	.answer-conclusion {
		padding: 15px;
		font-size: 14px;
		background: #fcf8e3;
	}
	
	.answer-list li {
		padding: 5px 0px;
		font-size: 12px;
	}
	
	.sz-answer-list ol {
		border: 1px solid #ddd;
	}
	
	.sz-answer-list ol li {
		padding: 0px 15px;
	}
	
	.sz-answer-list ol li div {
		font-size: 13px;
		color: #333;
		border-bottom: 1px dotted #dedede;
		line-height: 26px;
		position: relative;
		padding-left: 10px;
	}
	
	.sz-answer-list ol li div::before {
		border: 1px solid #6fa2a5;
		border-radius: 50%;
		content: "";
		display: block;
		height: 2px;
		left: 0;
		margin-right: 5px;
		position: absolute;
		top: 50%;
		transform: translateY(-50%);
		vertical-align: 2px;
		width: 2px;
	}
	</style>
	
	<script type="text/javascript">
	//医生签名没有图片的时候，加载一个默认图片（此处加载的为1*1px透明图）
		function nofind(){
			var img=event.srcElement;
			img.src="<%=basePath%>/img/namedefault.png";
			img.onerror=null; //控制onerror事件只触发一次 
		}
		
	// 	var userInfo_orgId = ${empty userInfo.dept_id} ? 0 : ${userInfo.dept_id}+0;
		
		KindEditor.ready(function(K) {		
			window.editor = K.create('#myAdvice', {
				height : '300px',
				width : '100%'
	// 			orgid: userInfo_orgId
			});
			
		});
		
		function sumReport(reportId) {
		    var dialog = KindEditor.dialog({
		        width : 500,
		        title : '测试窗口',
		        body : '<div style="margin:10px;"><strong>内容</strong><div class="ke-textarea">dasfdasdfa </div></div>',
		        closeBtn : {
		                name : '关闭',
		                click : function(e) {
		                        dialog.remove();
		                }
		        },
		        yesBtn : {
		                name : '确定',
		                click : function(e) {
		                        alert(this.value);
		                }
		        },
		        noBtn : {
		                name : '取消',
		                click : function(e) {
		                        dialog.remove();
		                }
		        }
		    });
		}
		
		$(function() {
			$(".btn-blue").click(function(){
			$(".reason-box").toggle();
			});
		});
	
		function checkAudit() {
			if ($('textarea[name="diagnosis"]').val().length == 0) {
				alert('诊断内容不能为空');
				return false;
			}
			
			if ($('textarea[name="diagnosis"]').val().length > 100) {
				alert('诊断内容长度不能大于100');
				return false;
			}
			
			$('#myAdvice').val(editor.html());
			if (editor.count('text') == 0) {
				alert('审核意见不能为空');
				return false;
			}
			
			if(editor.count('text') > 1000){
				alert('审核内容不能够超过1000字符!');
				return false;
			}
	
			return true;
		}
	</script>
</head>
<body>
<div class="content">
	<div class="content-title">待审核组合答卷列表 --- 审核</div>
	<form action="audit" onsubmit="return checkAudit();" method="post">
		<input type="hidden" id="serialNumber" name="serialNumber" value="${serialNumber}" />
		<input type="hidden" name="combAnsid" value="${pojo.combAnsid}" />
		<input type="hidden" name="memberId" value="${pojo.member.memberid}" />
		<input type="hidden" name="content" value="${pojo.ocqt.combQustName}" />
		<!-- 进度流水号 -->
		<table border="0" cellspacing="0" id="tabel_content" class="table-border">
			<thead>
				<tr id="table_content_title">
					<th>问卷名称</th>
					<th>发放医生</th>
					<th>接收会员</th>
					<th>发放时间</th>
					<th>答卷状态</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${fn:length(pojo.cam1s) == 0}">
					<tr>
						<td colspan="5">
							<div class="empty-info">暂时没有单份答卷数据</div>
						</td>
					</tr>
				</c:if>
				<c:if test="${fn:length(pojo.cam1s) > 0}">
					<c:forEach items="${pojo.cam1s}" var="cam1">
						<tr>
							<td>${cam1.ouai.omfq.qustname}</td>
							<td>${pojo.docName}</td>
							<td>${pojo.member.memname}</td>
							<td><fmt:formatDate value="${pojo.publisherTime}" pattern="yyyy-MM-dd"/></td>
							<td id="table_content_title_td">
								<c:choose>
									<c:when test='${cam1.ouai.qustTag == "T" || cam1.ouai.qustTag == "C"}'>
										<a class="toView" href="../singleAnswer/answerView?ansNumber=${cam1.ouai.ansNumber}&combAnsId=${pojo.combAnsid}">
											已答
										</a>
									</c:when>
									<c:when test='${cam1.ouai.qustTag == "B"}'>
										<a class="toAnswer" href="../singleAnswer/answerInfo?ansNumber=${cam1.ouai.ansNumber}&combAnsId=${pojo.combAnsid}">
											继续作答
										</a>
									</c:when>
									<c:otherwise>
										<a class="toAnswer" href="../singleAnswer/answerInfo?ansNumber=${cam1.ouai.ansNumber}&combAnsId=${pojo.combAnsid}">
											作答
										</a>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>

		<div class="result-list-box">
			<div class="caption-title">诊断</div>
			<div class="result-list">
				<ol>
					<li><textarea class="w100-txtarea" name="diagnosis"
							placeholder="单击此处填写诊断意见...">${audit.diagnosis}</textarea></li>
				</ol>
			</div>
		</div>
		<div class="result-list-box">
			<div class="caption-title clear-fix">
				<span class="fl">审核意见</span>
				<div class="fr">
					<input type="button" value="载入审核意见模板" id="loadTemplate"
						class="btn-normal" onclick="popup(${userInfo.dept_id},2);" />&nbsp;&nbsp;
				</div>
			</div>
			<div class="result-list">
				<textarea id="myAdvice" name="auditDesc" cols="30" rows="8"></textarea>
				<br /> 
				<input name="submit" type="submit" value="提交审核" class="btn-normal" style="margin-bottom:10px;" /> <br />
				<br />
			</div>
		</div>
		<br />
	</form>
</div>
</body>
</html>