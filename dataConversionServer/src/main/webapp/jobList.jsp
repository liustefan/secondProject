<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>中科汇康数据中心</title>
<%@ include file="/common.jsp" %>
<script type="text/javascript"> 
function input(){
	window.location.href='${basePath}/jobConfigController/input.do';
}
</script>

</head>

<body>
<!--*************************当前位置*************************-->
<div id="location">
  <span class="ui-icon ui-icon-site"></span>
  <label>当前位置：</label>
  <a href="#">系统配置</a>
  &gt;
  <span class="ui-font-color-red">定时器配置列表</span>
</div>
<!--*************************当前位置****END*********************-->
<!--**每一个内容页面必须包含 wrapper 容器***
******且除当前位置以外所有页面内容都必须放***
*********置在 wrapper 容器之内*********-->
<div id="wrapper">
  <!--*************************单列输入表单表头*************************-->
  <div id="accordion" class="ui-accordion ui-widget ui-helper-reset" role="tablist">
    <!--*************************数据列表*************************-->
    <table cellpadding="0" cellspacing="0" border="0" width="100%" class="ui-datalist-view" style="margin-top:5px;">
      <tr class="ui-datalist-title">
        <th>&nbsp;</th>
        <th align="left">编号</th>
        <th align="left">名称</th>
        <th align="left">状态</th>
         <th align="left">执行时间</th>
          <th align="left">备注</th>
        <th align="left"> 操作 </th>
      </tr>
      <c:forEach  items="${list}" var="s">
      <tr onmouseover="this.className='ui-state-highlight'" onmouseout="this.className=''">
        <td ><input type="radio" name="radio" id="radio" value="radio" /></td>
        <td>${s.jobId}</td>
        <td align="left">${s.jobName}</td>
        <td align="left">
          <c:if test="${s.jobStatus == '0'}">启用</c:if>
        	<c:if test="${s.jobStatus == '1'}">禁用</c:if>
        </td>
        <td>${s.jobTimeExpression}</td>
        <td>${s.jobDesc }</td>
         <td><a href="${s.id}/edit.do">修改</a>
         <br/>
         
         
         </td>
      </tr>
      </c:forEach>
    </table>
    <!--数据列表 END-->
    <!--*************************数据列表操作区*************************-->
    <table cellpadding="0" cellspacing="0" border="0" width="100%" class="ui-function-box ui-pager">
      <tr>
        <td class="ui-btn-area"><div >
            <input type="button" value="新增" class="ui-btn ui-btn-add" onmouseover="this.className='ui-btn ui-btn-add-hover'" onmouseout="this.className='ui-btn ui-btn-add'" onclick="input()"/>
          </div></td>
      </tr>
    </table>
    <!--*************************数据列表操作区*************************-->
  </div>
</div>
</body>
</html>
