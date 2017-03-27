<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>查看转诊</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/plugins/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="<%=path %>/js/jquery-ui/themes/overcast/jquery-ui.min.css">

	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-ui/jquery-ui.js"></script>
	<script type="text/javascript" src="<%=path %>/js/dataPacker.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#back").click(function(){
				location.href="<%=path %>/transferTreatment/getTransferTreatRecord";
			});
		});
	</script>
	<style>
		.detail-box {
			margin: 20px 0;
		    padding-left: 8px;
		    border: 1px solid #ccc;
		    font-size: 14px;
		    line-height: 28px;
		    background-color: #eff1f0;
		}
		
		.mg-right {
			margin-right: 50px;
		}
		
		.mg-right1 {
			margin-right: 2%;
		}
		
		.main-box ul li {
			margin: 20px 8px;
		}
		
		.fix-label {
			text-align: right;
			font-size: 14px;
			width: 15%;
			margin-right: 10px;
		}
		
		.text-top {
	        vertical-align: text-top;
	    }
	    
	    .mg-lt15 {
	    	margin: 15px 0 15px 25%;
	    }
	    
	    .width-fl {
	    	width: 85%;
	    }
	    
	    .width-fr {
	    	text-align: center;
		    width: 15%;
		    line-height: 56px;
	    }
	</style>
</head>
<body>
<div class="content">
	<div class="content-title">
   		转诊记录 --- 查看
	</div>
	<div class="detail-box clearfix">
		<div class="fl width-fl">
			<p>姓名：<span class="mg-right">${transferTreatMemVo.memName}</span>
			性别：<span class="mg-right">
					<c:if test="${transferTreatMemVo.gender eq '1'}">男</c:if>
					<c:if test="${transferTreatMemVo.gender eq '2'}">女</c:if>
					<c:if test="${empty transferTreatMemVo.gender or transferTreatMemVo.gender eq '3'}">未知</c:if></span>
			年龄：<span class="mg-right">${age}</span>
			手机号码：<span class="mg-right">${transferTreatMemVo.tel}</span>
			身份证号：<span class="mg-right">${transferTreatMemVo.idCard}</span>
			状态：<c:if test="${transferTreatMemVo.status =='T'}"><span>正常</span></c:if>
				<c:if test="${transferTreatMemVo.status =='F'}"><span>冻结</span></c:if>
			</p>
			<p>会员疾病史：<span class="mg-right1"></span>会员标签：<span>${transferTreatMemVo.omemLabel}</span></p>
		</div>
		<div class="fr width-fr">
			<button type="button" class="btn-inquiry" onclick="window.open('<%=path %>/member/${transferTreatMemVo.memberId }/memberPage', '_blank')">查看会员信息</button>
		</div>
	</div>
	<div class="main-box">
		<ul>
			<li>
				<label class="fix-label">转诊机构和科室：</label>
                <input type="text" name="organddept" maxlength="50" value="${transferTreatMemVo.organddept }" disabled>
			</li>
			<li>
				<label class="fix-label">转诊原因：</label>
                <textarea name="reason" cols="50" rows="4" maxlength="100" class="text-top" disabled>${transferTreatMemVo.reason }</textarea>
			</li>
			<li>
				<label class="fix-label">转诊结果：</label>
                <textarea name="result" cols="50" rows="4" maxlength="100" class="text-top" disabled>${transferTreatMemVo.result }</textarea>
			</li>
			<li>
				<label class="fix-label">转诊时间：</label> 
				<input class="info-date" id="startDate" type="text" name="treattime" value='<fm:formatDate value="${transferTreatMemVo.treattime }" pattern="yyyy-MM-dd"/>' readonly disabled/>
			</li>
			<li>
				<label class="fix-label">状态：</label>
                <select name="treatstatus" disabled>
					<option value="">请选择</option>
					<c:choose>
						<c:when test="${transferTreatMemVo.treatstatus eq '1'}">
							<option value="1" selected>转诊申请</option>
						</c:when>
						<c:otherwise>
							<option value="1">转诊申请</option>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${transferTreatMemVo.treatstatus eq '2'}">
							<option value="2" selected>取消转诊</option>
						</c:when>
						<c:otherwise>
							<option value="2">取消转诊</option>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${transferTreatMemVo.treatstatus eq '3'}">
							<option value="3" selected>已转诊</option>
						</c:when>
						<c:otherwise>
							<option value="3">已转诊</option>
						</c:otherwise>
					</c:choose>
				</select>
			</li>
			<li>
				<label class="fix-label">创建人：</label>
                <span>${transferTreatMemVo.createDocName}</span>
			</li>
			<li>
				<label class="fix-label">更新人：</label>
                <span>${transferTreatMemVo.updateDocName}</span>
			</li>
		</ul>
	</div>
	<div class="mg-lt15">
        <button class="btn-cancel" type="button" id="back">返回</button>
    </div>
</div>
</body>
</html>