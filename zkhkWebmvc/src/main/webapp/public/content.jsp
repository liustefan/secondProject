<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt"%>
 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=9">
    <title>我的桌面左侧iframe模块</title>
    <link rel="stylesheet" href="<%=path %>/css/general.css">
    <link rel="stylesheet" href="<%=path %>/public/css/left.css">

    <script src="<%=path %>/js/jquery-1.9.1.min.js"></script>
    <script src="<%=path %>/public/js/left.js"></script>
</head>
<script type="text/javascript">
	$(function(){
		$.ajax({
			url : '../measureRecord/getLastestOmds',
			success: function(data){
				var json = JSON.parse(data);
				for(var i in json){
					if(json[i].typeName == "血压"){ 
						$("#div1").append(
								 "<li><a href='../bloodPressure/showSingleBloodPress?memberId="+json[i].memberId+"&eventId="+json[i].eventId+"' target='_blank'>"
										 +json[i].measTime+"&nbsp;&nbsp;"+json[i].name+"&nbsp;&nbsp;"+json[i].typeName+"&nbsp;&nbsp;</a></li>"
						); 
					}else	if(json[i].typeName == "血糖"){ 
						$("#div1").append(
								 "<li><a href='../bloodSugar/showSingleBloodSugar?memberId="+json[i].memberId+"&eventId="+json[i].eventId+"' target='_blank'>"
										 +json[i].measTime+"&nbsp;&nbsp;"+json[i].name+"&nbsp;&nbsp;"+json[i].typeName+"&nbsp;&nbsp;</a></li>"
						); 					
					}else	if(json[i].typeName == "三合一"){ 
						$("#div1").append(
								 "<li><a href='../electrocardioPulse/showSingleElectroPulse?memberId="+json[i].memberId+"&eventId="+json[i].eventId+"' target='_blank'>"
										 +json[i].measTime+"&nbsp;&nbsp;"+json[i].name+"&nbsp;&nbsp;"+json[i].typeName+"&nbsp;&nbsp;</a></li>"
						); 
					}else	{ 
						$("#div1").append(
								 "<li><a href='../electrocardio/showSingleElectrocardio?memberId="+json[i].memberId+"&eventId="+json[i].eventId+"' target='_blank'>"
										 +json[i].measTime+"&nbsp;&nbsp;"+json[i].name+"&nbsp;&nbsp;"+json[i].typeName+"&nbsp;&nbsp;</a></li>"
						); 
					}
					
				}
			}
		});
	});
</script>
<body class="over-hidden">
<div id="left">
    <div id="lt1_2">
        <table>
            <tr>
                <td class="lt1_td_img" width="5%"><img src="../img/yuan.png"></td>
                <td class="lt1_td_title">积<span class="w25"></span>分：</td>
                <td class="lt1_td_title_1">本月：650分</td>
                <td class="lt1_td_title_2">累计：1213分</td>
            </tr>
            <tr>
                <td class="lt1_td_img"><img src="../img/yuan.png"></td>
                <td class="lt1_td_title">报<span class="w25"></span>告：</td>
                <td class="lt1_td_title_1">本月：650份</td>
                <td class="lt1_td_title_2">累计：1213份</td>
            </tr>
            <tr>
                <td class="lt1_td_img"><img src="../img/yuan.png"></td>
                <td class="lt1_td_title">回复咨询：</td>
                <td class="lt1_td_title_1">本月：650条</td>
                <td class="lt1_td_title_2">累计：1213条</td>
            </tr>
        </table>
    </div>
    <div class="desktop-left">
        <div class="ww">
            <h3>最近测量</h3>
        </div>
        <div class="ww1" id="ww1">
            <ul id="div1">
            </ul>
            <ul id="div2"></ul>
        </div>
    </div>
</div>
</body>
</html>