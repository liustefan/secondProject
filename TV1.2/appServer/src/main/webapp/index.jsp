<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ page contentType="text/html; charset=GBK" %>

<%@ page import="java.util.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
  
 
<html>
  <head>
    <base href="<%=basePath%>">
    <title>Cluster Test (TOMCAT222222222)</title>
    <title>My JSP 'index.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
     <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <script type="text/javascript" src="<%=basePath %>/js/jquery-1.9.1.min.js"></script>
  </head>
  
  <body>
    This is my test <br>
    
<%

System.out.println(session.getId());

out.println("<br> This is (TOMCAT22   79   ), SESSION ID:" + session.getId()+"<br>");

%>


Server Info:   
SessionID:<%=session.getId()%>
<br>
SessionIP:<%=request.getServerName()%>  
<br>
SessionPort:<%=request.getServerPort()%>
<br>
<%
  out.println("111");
%>

 
 
    <table>
        <tr>
            <td>测试登录：</td>
            <td><input type="button" onclick="getInfo();" value="登录"></td>
        </tr>
        <tr>
            <td>测试请求链接：</td>
            <td><input type="button" onclick="getRequestUrl();" value="测试链接"></td>
            <td><input type="hidden"  id="sessionId" ></td>
            <td><input type="hidden"  id="memId" ></td>
        </tr>
    </table>
  </body>
  <script type="text/javascript">
    function getInfo(){
        alert("begin!");
        $.ajax({
            type:'POST',
             
             //会员登录
             url:'<%=basePath %>/member/login',
            
            data:'params={"appUser":{"userAccount":"18028721234","userPassword":"e10adc3949ba59abbe56e057f20f883e","userType":1,"deviceType":"Android"},"otherParam":""}',
            
            
            dataType:'json',
            success:function(data){
                $("#sessionId").val(data.data.session);
                $("#memId").val(data.data.userId);
                alert(data.message);
            },
            error:function(data){
                alert(data.message);
            }
        });
    }
    
    function getRequestUrl(){
        var session = $("#sessionId").val();
        if(session == null){
        	alert("请先登录！");
        	return;
        }
        var userId = $("#memId").val();
        if(userId == null){
        	alert("请先登录！");
        	return;
        }
        $.ajax({
            type:'POST',
             
             //会员登录
             url:'<%=basePath %>/member/findMemberBasicInfo',
            
            data:'params={"appUser":{"session":"'+session+'","userId":'+userId+',"userType":1,"deviceType":"Android"},"otherParam":{"memberId":26021}}',
            
            
            dataType:'json',
            success:function(data){
            	var arr = JSON.stringify(data.data);
                alert(arr);
                var message = JSON.stringify(data.message);
                alert(message);
                
                
            },
            error:function(data){
                alert(data.message);
            }
        });
    }
  </script>
</html>
