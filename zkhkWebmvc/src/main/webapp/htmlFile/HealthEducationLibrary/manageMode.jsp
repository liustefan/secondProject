<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>管理方案</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/js/jquery-ui/themes/overcast/jquery-ui.min.css">
	<link rel="stylesheet" href="<%=path %>/plugins/font-awesome/css/font-awesome.min.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-ui/jquery-ui.js"></script>
	<script type="text/javascript" src="<%=path %>/js/dataPacker.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<style>
		.position-r {
			position: relative;
			display: inline-block;
		}
		
		.member-search {
		    position: absolute;
		    right: 5px;
		    top: 5px;
		    width: 20px;
		    height: 20px;
		    display: inline-block;
		    background: url(../../img/u125.png) no-repeat center;
		    cursor: pointer;
		}
	</style>
	<script type="text/javascript">
		var index = layer.getFrameIndex(window.name); //获取窗口索引
	
		function chooseProgramme(title){
			layer.closeAll();
			layer.open({
		   	    type: 2,
		   		skin : 'skin1',
		   	    title: title,
		   	    shadeClose: false,
		   	    shade: 0,
		   	    area: ['650px', '350px'],
		   	    content: '', //iframe的url
		   	}); 
		}
		
		function openMemTag() {
			layer.closeAll();
			layer.open({
		   	    type: 2,
		   		skin : 'skin1',
		   	    title: '会员标签',
		   	    shadeClose: false,
		   	    shade: 0,
		   	    area: ['400px', '350px'],
		   	    content: 'chooseLabel.html', //iframe的url
		   	}); 
		}
	</script>
</head>
<body>
<div class="content">
	<div class="content-title">
   		管理方案
	</div>
    <form action="" method="POST" id="">
		<div class="search-box-wrapper">
			<ul class="search-wrapper">
				<li>
					<label>会员姓名：</label>
					<input type="text">
				</li>
				<li>
					<label>手机号码：</label>
					<input type="text">
				</li>
				<li>
					<label>会员疾病史：</label>
	                <select name="">
						<option value="0">全部</option>
						<option value="1">高血压</option>
						<option value="2">糖尿病</option>
						<option value="3">冠心病</option>
						<option value="4">慢性阻塞性肺疾病</option>
						<option value="5">恶性肿瘤</option>
						<option value="6">脑卒中</option>
						<option value="7">重型精神病</option>
						<option value="8">结核病</option>
						<option value="9">肝炎</option>
					</select>
				</li>
				<li>
					<label>会员类型：</label>
	                <select name="">
						<option value="0">全部</option>
						<option value="1">收费会员</option>
						<option value="2">体验会员</option>
					</select>
				</li>
				<li>
					<label>管理方案：</label>
					<div class="position-r">
		                <input type="text" readonly>
		                <i class="member-search" onclick="chooseProgramme('选择管理方案');"></i>
                 	</div>
				</li>
				<li>
					<label>状态：</label>
	                <select name="">
						<option value="0">全部</option>
						<option value="1">执行中</option>
						<option value="2">已终止</option>
					</select>
				</li>
				<li>
					<label>更新日期：</label> 
					<input class="info-date" id="startDate" type="text" name="" required="required" value='' readonly="readonly" /> 
					<span class="mar-left">至</span> 
					<input class="info-date" id="endDate" type="text" name="" required="required" value='' readonly="readonly" />
				</li>
				<li>
					<label>会员标签：</label>
					<div class="position-r">
		                <input type="text" readonly>
		                <i class="member-search" onclick="openMemTag();"></i>
                 	</div>
				</li>
				<li>
					<button type="button" class="btn-inquiry ico-search" onclick="">查询</button>
					<button type="button" class="btn-inquiry" onclick="">个人管理方案</button>
					<button type="button" class="btn-inquiry" onclick="">群建管理方案</button>
				</li>
			</ul>
		</div>
		<div class="table-box">
			<table class="table-content">
				<thead class="table-title">
					<tr>
						<th>会员姓名</th>
						<th>性别</th>
						<th>手机号码</th>
						<th>会员标签</th>
						<th>管理方案</th>
						<th>状态</th>
						<th>更新时间</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td>
							<a href="javascript: void(0);" onclick="">修改</a>
							<a href="javascript: void(0);" class="mar-left" onclick="">终止</a>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="page-box">
			<jsp:include page="/public/pageFoot.jsp"></jsp:include>
		</div>
	</form>
</div>
</body>
</html>
