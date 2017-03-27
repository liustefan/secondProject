<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%
String path = request.getContextPath();
%>
<!DOCTYPE HTML>
<html>
<head>
   	<meta charset="utf-8">
   	<meta http-equiv="X-UA-Compatible" content="IE=9">
    <title>批量导入会员页面</title>
    
    <link rel="stylesheet" href="<%=path %>/css/comm.css">
    <link rel="stylesheet" href="<%=path %>/css/importMember.css">
    <link rel="stylesheet" href="<%=path %>/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" href="<%=path %>/css/tree.css">
    
    <script type="text/javascript" src="<%=path %>/js/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="<%=path %>/js/jquery.ztree.core-3.5.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.ztree.excheck-3.5.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script type="text/javascript" src="<%=path %>/js/tree.js"></script>
	<script type="text/javascript" src="<%=path %>/js/importMember.js"></script>
</head>

<body>
    <div class="row">
    	<a target="_blank" class="download" href="<%=path %>/doc/MemberTemplate.xls">如果您需要批量导入会员的Excel模板,请点击下载</a>
    </div>
    <form id="form1" action="<%=path %>/data/memberImport" enctype="multipart/form-data" method="post" >
	    <div class="row ">请选择需要上传导入的Excel： 
			<div class="file-chose clearfix">
				<div class="file-box">
					<input type='text' name='textfield' id='textfield1' class='txt' />
					<input type='button' class='btn-file' value='浏览' />
					<input type="file" name="fieldName" class="file" id="fileField1" size="28" onchange="fileChange1(this)" accept=".xls" />
				</div>
			</div>
		</div>
	    <div class="row clearfix">
	    	<div>请选择导入的会员分组：</div>
	    	<ul id="treeDemo" class="ztree"></ul>
	    </div>
	    <input type="hidden" id="grpIds" name="grpIds"/>
	    
	    <div class="row btns">
	    	<button type="button" id="uploading" class="btn-normal">上传</button>
	    	<button type="button" id="closeIframe" class="btn-normal">退出</button>
	    </div>
    </form>
</body>
</html>
