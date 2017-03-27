<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	<title>创建一般账户</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/css/common.css">
	<link rel="stylesheet" href="<%=path %>/plugins/zTree_v3/css/zTreeStyle/zTreeStyle.css">
	<link rel="stylesheet" href="<%=path %>/css/tree.css">
	<link rel="stylesheet" href="<%=path %>/js/jquery-ui/themes/overcast/jquery-ui.min.css">

	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-ui/jquery-ui.js"></script>
	<script type="text/javascript" src="<%=path %>/js/common.js"></script>
	<script type="text/javascript" src="<%=path %>/js/createDocInfo.js"></script>
	<script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.core-3.5.min.js"></script>
	<script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.excheck-3.5.js"></script>
	<script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.exhide-3.5.js"></script>
	<script type="text/javascript" src="<%=path %>/js/tree.js"></script>
	<style type="text/css">
	.disabled optgroup {
		font-size: 12px;
		font-style: normal;
		font-weight: normal;
		font-variant: normal;
		color: #333;
		background-color: #F5F5F5;
	}
	
	.disabled option {
		padding-left: 0px;
		color: #333;
	}
	
	#menuContent .input-search {
	    width: 242px;
	    height: 20px;
	    line-height: 20px;
	    border: 1px solid #ccc;
	    padding: 3px 5px;
	    margin: 5px;
	}
	
	.pop-ztree {
		width: 250px !important;
		height: 340px !important;
	}
	
	#menuContent {
		border: 1px solid #ccc;
		border-top: 0;
	}
	
	.icon-search {
		top: 10px;
		right: 5px;
	}
	</style>
	<script type="text/javascript">
		$(function(){
			var setting = {
					check: {
						enable: true,
						chkStyle: "radio",
						radioType: "all"
					},
					data : {
						simpleData : {
							enable : true
						}
					},
					view : {
						dblClickExpand: false,
						selectedMulti: false,
						showIcon: false
					},
					callback : {
						onCheck : function(e, treeId, treeNode){
							$("#orgId").val(treeNode.id);
							$("#orgs").val(treeNode.name);
						},
						beforeClick: checkedBox,
						onExpand: zTreeOnExpand
					}
				};
		var roleId = '${userInfo.roleid}';
		if(roleId == 6) {
			$.ajax({
				type : "GET",
				url : '<%=path %>/org/listAllOrg?pId=0',
				async: false,
				success : function(obj) {
	// 				var obj = rsp.data;
					$(obj).each(function(i, e) {
						e.nocheck=e.endTag==='Y'?false:true;
					});
					$.fn.zTree.init($("#treeDemo"), setting, obj);
					key = $("#key");
					key.on("keypress", searchNode);
				}
			});
		}
			
			$("#orgs_search").click(function(){
				var cityObj = $("#orgs");
				var cityOffset = $("#orgs").offset();
				
				$("#menuContent").css({
					left : cityOffset.left + "px",
					top : cityOffset.top + cityObj.outerHeight() + "px"
				}).slideDown("fast");
	
				$("body").bind("mousedown", function(event){
					if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(
							event.target).parents("#menuContent").length > 0)) {
						$("#menuContent").fadeOut("fast");
						$("body").unbind("mousedown", function(event){
							if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(
									event.target).parents("#menuContent").length > 0)) {
								hideMenu();
							}
						});
					}
				});
			});
			
			$.datepicker.regional['zh-CN'] = { 
			        clearText: '清除', 
			        clearStatus: '清除已选日期', 
			        closeText: '清空', 
			        closeStatus: '不改变当前选择', 
			        prevText: '<上月', 
			        prevStatus: '显示上月', 
			        prevBigText: '<<', 
			        prevBigStatus: '显示上一年', 
			        nextText: '下月>', 
			        nextStatus: '显示下月', 
			        nextBigText: '>>', 
			        nextBigStatus: '显示下一年', 
			        currentText: '今天', 
			        currentStatus: '显示本月', 
			        monthNames: ['一月','二月','三月','四月','五月','六月', '七月','八月','九月','十月','十一月','十二月'], 
			        monthNamesShort: ['一月','二月','三月','四月','五月','六月', '七月','八月','九月','十月','十一月','十二月'], 
			        monthStatus: '选择月份', 
			        yearStatus: '选择年份', 
			        weekHeader: '周', 
			        weekStatus: '年内周次', 
			        dayNames: ['星期日','星期一','星期二','星期三','星期四','星期五','星期六'], 
			        dayNamesShort: ['周日','周一','周二','周三','周四','周五','周六'], 
			        dayNamesMin: ['日','一','二','三','四','五','六'], 
			        dayStatus: '设置 DD 为一周起始', 
			        dateStatus: '选择 m月 d日, DD', 
			        dateFormat: 'yy-mm-dd', 
			        firstDay: 1, 
			        initStatus: '请选择日期', 
			        isRTL: false,
			        yearRange:"1915:2100",
			        showButtonPanel: true,
			        onClose: function (dateText, inst) {
			            if ($(window.event.srcElement).hasClass('ui-datepicker-close'))
			            {
			             document.getElementById(this.id).value = '';
			            }
			           },}; 
			        $.datepicker.setDefaults($.datepicker.regional['zh-CN']); 
			
			$('#birthday').datepicker({
				dateFormat: "yy-mm-dd",
		        maxDate: "+d",
		        stepMonths: 12,
				defaultDate : new Date(),
		        changeMonth: true,
		        changeYear: true,
				
		    });	
		});
	</script>
</head>
<body>
	<!-- 选择组织 -->
	<c:if test="${userInfo.roleid eq 6 }">
		<div id="menuContent" class="menuContent" style="display: none; position: absolute; background-color: #fff;">
			<div class="left-title">
				<input type="text" id="key" class="input-search" >
				<i class="icon-search" onclick="searchNode();"></i>
			</div>
			<ul id="treeDemo" class="pop-ztree ztree"></ul>
		</div>
	</c:if>
	<div class="content">
		<div class="content_new">
			<div class="content-title">
				<c:if test="${userInfo.roleid eq 6 }">
					管理员列表 --- <c:if test="${not empty doctor.docGUID }">修改</c:if><c:if test="${empty doctor.docGUID }">创建管理员</c:if>
				</c:if>
				<c:if test="${userInfo.roleid eq 1 }">
					医生管理 --- <c:if test="${not empty doctor.docid }">修改</c:if><c:if test="${empty doctor.docid }">新增</c:if>
				</c:if>
				<span style="color: red"><b>${msg }</b></span>
			</div>
			<form action="<%=path %>/doctor/add" enctype="multipart/form-data" method="post" onsubmit="return ckeckEmpty();">
			    <input type="hidden" value="${doctor.docid }" name="docid"/>
			    <input type="hidden" value="${doctor.tag }" name="tag"/>
			    <input type="hidden" value="${doctor.docGUID }" name="docGUID"/>
				<table id="table_new">
					<tr class="table_right">
						<td></td>
						<td class="table_left"></td>
					</tr>

                    <c:choose>
                    <c:when test="${userInfo.roleid eq 6 }">
                    <tr>
						<td class="table_right">组织机构：</td>
						<td class="table_left">
						<input class="info" type="hidden" name="orgid" value="${doctor.orgid }" id="orgId" readonly="readonly" />
						<div class="position-r">
							<input class="info" type="text" name ="orgName" value="${doctor.orgName }" id="orgs" readonly="readonly"/>
							<i class="org-search" id="orgs_search"></i>
						</div>
						<font color="red">*</font></td>
					</tr>
                    </c:when>
                    <c:when test="${userInfo.roleid eq 1 }">
                    <input type="hidden" name="orgid" value="${userInfo.dept_id}"/>
                    </c:when>
                    </c:choose>
                    
					<tr>
					<c:choose>
						<c:when test="${userInfo.roleid eq 6 }">
						<td class="table_right">角色：</td>
						<td class="table_left">
						管理员<input type="hidden" name="roleid" value="1">
						</td>
						</c:when>
						<c:when test="${userInfo.roleid eq 1 }">
						<c:if test="${doctor.docid == null || doctor.docid eq 0}">
						<td class="table_right">角色：</td>
						<td class="table_left">
						   <select name="roleid">
							<c:forEach items="${roles }" var="orol">
							    <option value="${orol.roleid }" <c:if test="${doctor.roleid eq orol.roleid}"> selected="selected" </c:if> >
							    ${orol.rolename }</option>
							</c:forEach>
						</select>
						<font color="red">*</font>
						</td>
						</c:if>
						<c:if test="${doctor.docid != null && doctor.docid gt 0}">
						<input type="hidden" value="${doctor.roleid }" name="roleid"/>
						</c:if>
						</c:when>
						</c:choose>
					<tr>
						<td class="table_right">账号：</td>
						<td class="table_left">
						<input type="text" id="acc" name="doctorAccount.docacc" placeholder="数字或字母" value="${doctor.doctorAccount.docacc }" title="账号" onblur="checkdocAccIsExistence(this);" maxlength='20'
						<c:if test="${doctor.docid != null && doctor.docid gt 0 }">
						 readonly="readonly"
						</c:if> >
							<font color="red">*</font>
							<span id="myAcc"></span>
						</td>
					</tr>
					<c:if test="${doctor.docid == null || doctor.docid eq 0 }">
					<tr>
						<td class="table_right">密码：</td>
						<td class="table_left">
							<input type="password" id="password" name="doctorAccount.docpass" placeholder="由6至20位字母数字组成"  title="密码" onBlur="isPsw1(this);">
							<font color="red">*</font>
							<span></span>
						</td>
					</tr>
					<tr>
						<td class="table_right">确认密码：</td>
						<td class="table_left">
							<input type="password" id="password2" title="确认密码" onBlur="checkPsd(this);">
							<font color="red">*</font>
							<span></span>
						</td>
					</tr>
					</c:if>
					<tr>
						<td class="table_right">姓名：</td>
						<td class="table_left">
							<input type="text" id="name" name="docname" value="${doctor.docname }" title="姓名" onBlur="findLength(this);" onfocus="printAsterisk(this);" maxlength='20' >
							<span>*</span>
						</td>
					</tr>
					<tr>
						<td class="table_right">职称：</td>
						<td class="table_left">
							<input type="text" maxlength="20" name="title" value="${doctor.title }">
							<span></span></td>
					</tr>
					<tr>
						<td class="table_right">性别：</td>
						<td class="table_left_a">
							<label><input type="radio" name="gender" value="M" <c:if test="${doctor.gender eq 'M' }"> checked="checked" </c:if> >男</label>
							<label><input type="radio" name="gender" value="F" <c:if test="${doctor.gender eq 'F' }"> checked="checked" </c:if> >女</label>
						</td>
					</tr>
					<tr>
						<td class="table_right">出生日期：</td>
						<td class="table_left">
							<input type="text" id="birthday" name="birthdate" title="出生日期" value='<fm:formatDate value="${doctor.birthdate }" pattern="yyyy-MM-dd"/>'  onfocus="printAsterisk(this);" readonly="readonly" >
							<span>*</span>
						</td>
					</tr>
					<tr>
						<td class="table_right">联系电话：</td>
						<td class="table_left">
							<input type="text" maxlength="20" name="contacttel" value="${doctor.contacttel}">
							<span></span>
						</td>
					</tr>
					<tr>
						<td class="table_right">手机号码：</td>
						<td class="table_left">
							<input id="phone" type="text" name="tel" value="${doctor.tel }" title="手机号" onBlur="checkdocTelIsExistence(this);">
							<span id="myTel">*</span>
						</td>
					</tr>
					<tr>
						<td class="table_right">Email：</td>
						<td class="table_left">
							<input type="text" id="email" name="email" value="${doctor.email }" title="Email" onBlur="isEmail(this);" onfocus="printAsterisk(this);" >
							<font color="red">*</font>
							<span></span>
						</td>
					</tr>
					<tr>
						<td class="table_right">微信：</td>
						<td class="table_left">
							<input type="text" maxlength="20" name="weixin" value="${doctor.weixin }">
							<span></span>
						</td>
					</tr>
					<tr>
						<td class="table_right">家庭地址：</td>
						<td class="table_left">
							<input type="text" name="homeaddress" maxlength="100" value="${doctor.homeaddress }">
							<span></span>
						</td>
					</tr>
					<tr>
						<td class="table_right">工作单位：</td>
						<td class="table_left">
							<input type="text" name="workaddress" maxlength="50" value="${doctor.workaddress }">
							<span></span>
						</td>
					</tr>
					<tr>
						<td class="table_right">单位地址：</td>
						<td class="table_left">
							<input type="text" name="unitaddress" maxlength="100" value="${doctor.unitaddress }">
							<span></span>
						</td>
					</tr>
					<tr>
						<td class="table_right">工作科室：</td>
						<td class="table_left">
							<input type="text" maxlength="20" name="workdepart" maxlength="100" value="${doctor.workdepart }">
							<span></span>
						</td>
					</tr>
					<tr>
						<td class="table_right">户口地址：</td>
						<td class="table_left">
							<input type="text" name="resideaddress" maxlength="100" value="${doctor.resideaddress }">
							<span></span>
						</td>
					</tr>
					<tr>
						<td class="table_right">证件类型：</td>
						<td class="table_left">
							<select id="certiType" name="certitype">
								<option value="0">请选择</option>
								<c:forEach items="${certiType }" var="item">
								<option value="${item.code }" <c:if test="${item.code eq doctor.certitype }"> selected </c:if> >${item.desc }</option>
								</c:forEach>
							</select>
							<span></span>
						</td>
					</tr>
					<tr>
						<td class="table_right">证件号码：</td>
						<td class="table_left">
							<input type="text" id="certiNum" name="certinum" value="${doctor.certinum }" onchange="isCardNo(this);">
							<span></span>
						</td>
					</tr>
					<tr>
						<td class="table_right">简介：</td>
						<td class="table_left">
							<textarea rows="10" cols="25" maxlength="5000" name="desription">${doctor.desription }</textarea>
							<span></span>
						</td>
					</tr>
					<tr>
						<td class="table_right">头像：</td>
						<td class="table_left">
						    <input type="hidden" name="headaddress" value="${doctor.headaddress }"/>
							<input type="file" name="fieldName" accept="image/gif, image/jpeg, image/png">
							<label style="color:#000;">（只能上传单张png、jpg、gif图片）</label>
						</td>
					</tr>
					<tr>
						<td class="table_right">签名：</td>
						<td class="table_left">
						    <input type="hidden" name="signaddress" value="${doctor.signaddress }"/>
							<input type="file" name="field2Name" accept="image/gif, image/jpeg, image/png">
							<label style="color:#000;">（只能上传单张png、jpg、gif图片）</label>
						</td>
					</tr>
					<tr>
						<td></td>
						<td align="left">
							<input type="submit" value="保存" id="addSubmint" class="btn-normal">
							<input type="reset" value="重置" class="btn-normal" onclick="clearTipsInfo();">
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>
