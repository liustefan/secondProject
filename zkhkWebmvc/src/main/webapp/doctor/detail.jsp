<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE HTML>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>修改医生信息</title>
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<style type="text/css">
		body {
		    font-size: 12px;
			line-height: 1.5;
			font-family: "Microsoft YaHei", "SimSun";/*默认字体微软雅黑，宋体*/
			color: #333;
		}
		
		body, h1, h2, h3, h4, h5, h6, hr, p, blockquote, dl, dt, dd, ul, ol, li, pre,fieldset, lengend, button, input, textarea,th, td {
		    margin: 0;
		    padding: 0;
		}
		
		img {
			border: none;
			outline: none;
		}
		
		.lt1_1_img {
			width: 64px;
			border-radius: 5%;
			height: 64px;
			margin: 5px 10px 5px 10px;
			float: left;
			text-align: right;
			/* background: url(../img/user_img.png) center no-repeat; */
		}
		
		.lt1_1_img img {
			width: 64px;
			border-radius: 5%;
			height: 64px;
		}
		
		.lt1_1_img2 {
			width: 64px;
			border-radius: 5%;
			height: 64px;
			margin: 5px 10px 5px 10px;
			float: left;
			text-align: right;
			/* background: url(../img/default_img.png) center no-repeat; background-size: cover; */
		}
		
		.lt1_1_img2 img {
			width: 64px;
			border-radius: 5%;
			height: 64px;
		}
		
		/*合并表格边框，设置边框距为零*/
		table {
			border-collapse: collapse;
			border-spacing: 0;
		}
		
		.table-border {
			width: 96%;
			margin: 0 auto;
			margin-top: 30px;
			border: 1px #ddd solid; 
			background: #f3f3f3;
	   	}
	   	
		.table-border tr td{
		   	padding:10px;
		   	border:1px #ddd solid;
		   	font-size:13px;
		} 
		 
		.btn-normal {
		  	height: 26px;
		  	line-height: 26px;
		  	border: 0px;
		  	border-radius: 3px;
		  	width: 80px;
		  	color: #FFF;
		  	padding: 0;
		  	cursor: pointer;
			font-family: "Microsoft YaHei", "SimSun";
		  	font-size: 14px;
		  	display: inline-block;
		  	font-family: "Microsoft YaHei";
		  	background-image: -moz-linear-gradient(center top, rgba(072, 214, 096, 0.8) , rgba(097, 185, 095, 0.8)) repeat scroll 0 0 rgba(072, 214, 096, 0.8);
		  	background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, rgba(072, 214, 096, 0.8)), color-stop(1, rgba(097, 185, 095, 0.8)));
		  	filter: progid:DXImageTransform.Microsoft.Gradient(GradientType=0, StartColorStr='#48d660', EndColorStr='#61b95f');
		}
		
		.content {
		    width: 100%;
		    padding: 10px 1% 0 1%;
		    margin-top: 0 !important;
		    -webkit-box-sizing: border-box;
		    -moz-box-sizing: border-box;
		    box-sizing: border-box;
		}
		
		/* 标题（无背景的）  */
		.content-title {
		    margin-bottom: 8px;
		    height: 40px;
		    line-height: 40px;
		    border-bottom: 1px solid;
		    font-size: 16px;
		    text-align: left;
		    font-weight: bold;
		}
	</style>
	<script type="text/javascript">
		var delArray = new Array();
		var choArray = new Array();
		var docid= '${odoc.docid}';
		$(document).ready(function(){
			$("[name='codgps']").click(function(){
				var dgpid = $(this).attr('value');
			    if ('checked' == $(this).attr("checked")) {
			    	choArray.push(dgpid);
			        //alert('array : '+choArray.join(","));
			    }else{
			    	for (var i = 0; i < choArray.length; i++) {
			            if (choArray[i] == dgpid) {
			            	choArray.splice(i, 1)
			            }
			        }
			    	 //alert( 'array : '+choArray.join(","));
			    }
			});
			$("[name='delodgps']").click(function(){
				var dgpid = $(this).attr('value');
			    if ('checked' == $(this).attr("checked")) {
			    	for (var i = 0; i < delArray.length; i++) {
			            if (delArray[i] == dgpid) {
			            	delArray.splice(i, 1)
			            }
			        }
			    	 //alert( 'array : '+delArray.join(","));
			    	
			    }else{
			    	delArray.push(dgpid);
			        //alert('array : '+delArray.join(","));
			    }
			});
		});
		
		function showUpdateOdgpUI(){
			//alert($("#odpgList").css("display"));
			$("#detail").css("display","none");
			$("#odpgList").css("display","block");
		}
		
		function saveDgp(){
			var orgId = $('#orgId').val();
			var url = '${pageContext.request.contextPath }/group/odgp!addDoctors';
			//alert(delArray.join(','));
			var param={"docid":docid,"odgpIds":choArray.join(','),"orgId":orgId,"dels":delArray.join(',')};
			
			$.post(url,param,function(date){
				
				if(date.success=='0000' || date.success!='true'){
					alert('修改医生与分组对应关系成功!');
				}else{
					alert('修改医生与分组对应关系失败!');
				}
			});
		}
	</script>
</head>
<body>
	<div class="content">
		<div class="content-title">医生管理 --- 查看</div>
		<table class="table-border">
			<tr>
				<td width="15%" align="right">医生代码</td>
				<td width="30%">${odoc.docid}</td>
				<td width="15%" align="right">角色</td>
				<td>${odoc.orol.rolename}</td>
			</tr>
			<tr>
				<td align="right">组织代码</td>
				<td>${odoc.orgid}</td>
				<td align="right">姓名</td>
				<td>${odoc.docname}</td>
			</tr>
			<tr>
				<td align="right">职称</td>
				<td>${odoc.title}</td>
				<td align="right">性别</td>
				<td>
				    <c:if test="${odoc.gender eq 'M' }">男</c:if>
				    <c:if test="${odoc.gender eq 'F' }">女</c:if>
				</td>
			</tr>
			<tr>
				<td align="right">出生日期</td>
				<td><fm:formatDate value="${odoc.birthdate}" pattern="yyyy-MM-dd"/></td>
				<td align="right">手机号</td>
				<td>${odoc.tel}</td>
			</tr>
			<tr>
				<td align="right">邮箱</td>
				<td>${odoc.email}</td>
				<td align="right">微信号</th>
				<td>${odoc.weixin}</td>
			</tr>
			<tr>
				<td align="right">家庭地址</td>
				<td colspan="3">${odoc.homeaddress}</td>
			</tr>
			<tr>
				<td align="right">工作单位</td>
				<td colspan="3">${odoc.workaddress}</td>
			</tr>
			<tr>
				<td align="right">户口地址</td>
				<td colspan="3">${odoc.unitaddress}</td>
			</tr>
			<tr>
				<td align="right">证件类型</td>
				<td colspan="3">
				    <c:if test="${odoc.certitype eq 1}">身份证</c:if>
				    <c:if test="${odoc.certitype eq 2}">驾驶证</c:if>
				    <c:if test="${odoc.certitype eq 3}">港澳通行证</c:if>
				</td>
			</tr>
			<tr>
				<td align="right">证件号</td>
				<td colspan="3">
					${odoc.certinum}
				</td>
			</tr>
			<tr>
				<td align="right">简介</td><td colspan="3">${odoc.desription}</td>
			</tr>
			<tr>
				<td align="right">工作科室</td><td colspan="3">${odoc.workdepart}</td>
			</tr>
			<tr>
				<td align="right">头像</td><td colspan="3">
				    <div class="lt1_1_img">
					  	<c:choose>
						  	<c:when test="${odoc.headaddress != null }">
								<img src="${pageContext.request.contextPath }/image/getImage?uniqueId=${odoc.headaddress}" onerror="javascript:this.src='${pageContext.request.contextPath }/img/user_img.png';" />
						  	</c:when>
						  	<c:otherwise>
						  		<img src="${pageContext.request.contextPath }/img/user_img.png"  /> 
						  	</c:otherwise>
					  	</c:choose>
				  	</div>
				</td>
			</tr>
			<tr>
				<td align="right">签名</td><td colspan="3">
				    <div class="lt1_1_img2">
				        <c:choose>
						  	<c:when test="${odoc.signaddress != null }">
						  		<img src="${pageContext.request.contextPath }/image/getImage?uniqueId=${odoc.signaddress}" onerror="javascript:this.src='${pageContext.request.contextPath }/img/user_img.png';" />
						  	</c:when>
						  	<c:otherwise>
						 	 	<img src="${pageContext.request.contextPath }/img/default_img.png"  /> 
						  	</c:otherwise>
						</c:choose>
					</div>
				</td>
			</tr>
			<tr>
				<td align="right">状态</td><td colspan="3">
					<c:if test='${odoc.tag eq "T" }'>激活</c:if>
					<c:if test='${odoc.tag eq "E" }'>激活</c:if>
				</td>
			</tr>
			<tr>
				<td align="right">所属分组</td>
				<td colspan="3">
					<div >
						<c:forEach items="${groups}" var="group">
							${group.doctorGroup.odgpname},
						</c:forEach>
						<input type="hidden" value="${odoc.orgid}" id="orgId"/>
					</div>
					<!--  
					<div id="odpgList" style="display:none;">
						<form action="">
							<c:forEach items="${odgpList}" var="odgp">
								<c:set var="isChecked" value="0"></c:set>
								<c:forEach items="${odoc.docGroupList}" var="group">
									<c:if test="${odgp.odgpId == group.odgpId}">
										<c:set var="isChecked" value="1"></c:set>
									</c:if>
								</c:forEach>
								<c:choose>
									<c:when test="${isChecked == 1}">
										<input type="checkbox" checked="checked" value="${odgp.odgpId}" id="delodgps" name="delodgps" >&nbsp;&nbsp;${odgp.odgpName}&nbsp;
									</c:when>
									<c:otherwise>
										<input type="checkbox" value="${odgp.odgpId}" id="codgps" name="codgps" >&nbsp;${odgp.odgpName}&nbsp;&nbsp;
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<p style="margin-top:10px;">
								<input type="button" class="btn-normal" value="保存" onclick="saveDgp();"/>
								<input type="button" class="btn-normal" value="取消"/>
							</p>
						</form>
					</div>-->
				</td>
			</tr>
		</table>
	</div>
</body>
</html>