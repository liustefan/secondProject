<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
request.setAttribute("basePath", basePath);
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>

<!-- jquery UI -->
<link href="${basePath}/GlobalStyle/Style.css" rel="stylesheet" type="text/css" />
<link href="${basePath}/Themes/Default/Site.css" rel="stylesheet" type="text/css" />
<link href="${basePath}/Themes/Default/Css/jquery.ui.all.css" rel="stylesheet" type="text/css" />

<link href="${basePath}/css/demo.css" rel="stylesheet" type="text/css" />
<link href="${basePath}/css/zTreeStyle.css" rel="stylesheet" type="text/css" />
<script src="${basePath}/Scripts/WdatePicker.js"  type="text/javascript"></script>
<script src="${basePath}/tree/js/jquery.ztree.core-3.5.js" type="text/javascript"></script>
<script src="${basePath}/tree/js/jquery.ztree.excheck-3.5.js" type="text/javascript"></script>




<script src="${basePath}/Scripts/jquery.min.js" type="text/javascript"></script>
<script src="${basePath}/Scripts/jquery.ui.min.js" type="text/javascript"></script>
<script src="${basePath}/Scripts/jquery.ui.accordion.min.js" type="text/javascript"></script>
<script src="${basePath}/Scripts/jquery.mvcui.menu.js" type="text/javascript"></script>
<script src="${basePath}/Scripts/jquery.layout-latest.min.js" type="text/javascript"></script>

<%--
<!-- jquery validate
<script src="${basePath}/scripts/jquery/jquery.validate.min.js" type="text/javascript"></script>
<script src="${basePath}/scripts/jquery/jQuery.validate.message_cn.js" type="text/javascript"></script>
 -->
 
<!-- jquery form -->
<script src="${basePath}/scripts/jquery/jquery.form.js" type="text/javascript"></script>
<script src="${basePath}/scripts/jquery/jquery.json-2.2.js" type="text/javascript"></script>

<!-- jquery dialog -->
<script src="${basePath}/scripts/jquery/jquery.ui.dialog.js" type="text/javascript"></script>
<script src="${basePath}/scripts/jquery/jquery.ui.draggable.js" type="text/javascript"></script>
<script src="${basePath}/scripts/jquery/jquery.ui.mouse.js" type="text/javascript"></script>
<script src="${basePath}/scripts/jquery/jquery.ui.position.js" type="text/javascript"></script>
<link type="text/css" rel="stylesheet" href="${basePath}/scripts/jquery/demos.css"/>

<!-- jquery treeview -->
<link rel="stylesheet" href="${basePath}/scripts/treeview/jquery.treeview.css" />
<script src="${basePath}/scripts/treeview/jquery.cookie.js" type="text/javascript"></script>
<script src="${basePath}/scripts/treeview/jquery.treeview.js" type="text/javascript"></script>
<script src="${basePath}/scripts/treeview/demo.js" type="text/javascript"></script>

<!-- datePicker -->
<script src="${basePath}/scripts/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<!-- Highlighter -->

<script type="text/javascript" src="${basePath}/scripts/syntaxhighlighter_3.0.83/scripts/shCore.js"></script>
<script type="text/javascript" src="${basePath}/scripts/syntaxhighlighter_3.0.83/scripts/shBrushJScript.js"></script>
<link type="text/css" rel="stylesheet" href="${basePath}/scripts/syntaxhighlighter_3.0.83/styles/shCoreDefault.css"/>

--%><!-- 自定义通用的JS 
<script src="${basePath}/scripts/common.js" type="text/javascript"></script>
 -->

<script type="text/javascript">
	var basePath = "${basePath}";
</script>





