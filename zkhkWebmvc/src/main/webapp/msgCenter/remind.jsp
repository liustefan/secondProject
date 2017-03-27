<%@ page contentType="text/html; charset=utf-8" language="java" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>温馨提示</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/css/msgCenter.css">
	<link rel="stylesheet" href="<%=path %>/js/jquery-ui/themes/overcast/jquery-ui.min.css">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-ui/jquery-ui.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script type="text/javascript" src="<%=path %>/js/dataPacker.js"></script>
</head>

<body>
    <div class="content">
        <div class="search-box-wrapper border-1-solid2">
            <form action="" method="POST" id="condition">
                <ul class="search-wrapper clearfix">
                    <li>
                        <label>会员姓名：</label>
                        <input type="text" name="" value="">
                    </li>
                    <li>
                        <label>性别：</label>
                        <select name="">
                            <option value="">全部</option>
                            <option value="1">男</option>
                            <option value="2">女</option>
                            <option value="3">未知</option>
                        </select>
                    </li>
                    <li>
                        <label>出生日期：</label>
                        <input class="info-date" id="startDate" type="text" name="" value="" readonly="readonly"/>
                        <span  class="mar-left">至</span>
                        <input class="info-date" id="endDate" type="text" name="" value="" readonly="readonly"/>
                    </li>
                    <li>
                        <label>手机号码：</label>
                        <input type="text" name="" value="">
                    </li>

                    <li>
                        <label>疾病状况：</label>
                        <input type="text" name="" value="">
                    </li>
                    <li>
                        <label>会员类型：</label>
                        <select name="">
                            <option value="">全部</option>
                            <option value="137" >sdfg</option>
                            <option value="138" >2gh</option>
                            <option value="139" >53ujhk</option>
                        </select>
                    </li>
                    <li>
                        <button type="submit" id="query" class="btn-inquiry ico-search">查询</button>
                    </li>
                </ul>
            </form>
        </div>
        <div class="table-box">
            <table class="table-content" id="datalist">
                <thead class="table-title">
                    <tr>
                        <th width="5%">序号</th>
                        <th width="10%">姓名</th>
                        <th width="5%">性别</th>
                        <th width="10%">出生日期</th>
                        <th width="10%">手机号码</th>
                        <th>疾病状况</th>
                        <th width="5%">活力指数</th>
                        <th width="15%">操作</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td>试用者44297</td>
                        <td>女</td>
                        <td>1989-10-08</td>
                        <td>18599964582</td>
                        <td>正常</td>
                        <td>98%</td>
                        <td>
	                        <a href="javascript: void(0);">发送新消息</a>
	                        <a href="javascript: void(0);">查看消息</a>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div class="page-box">
                <div class="fl">
                    <button type="button" id="" class="btn-inquiry">群发消息</button>
					</div>
		            <jsp:include  page="/public/pageFoot.jsp"/>
				</div>
</body>
</html>

