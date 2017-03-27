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
	<title>标签管理</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/js/jquery-ui/themes/overcast/jquery-ui.min.css">

	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-ui/jquery-ui.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script type="text/javascript" src="<%=path %>/js/dataPacker.js"></script>
	<script type="text/javascript">
	 	var index = layer.getFrameIndex(window.name); //获取窗口索引
		function editTitle(title, id) {
			layer.closeAll();
			layer.confirm("修改标签分类，会造成健康资讯分类修改，您确认要修改吗？",{
		    	title: title,
		        skin : 'skin1',
		        shade: 0,
		        btn: ['确定','取消'] //按钮
		    }, function(index){
		    	layer.closeAll();
		    	layer.open({
			   	    type: 2,
			   		skin : 'skin1',
			   	    title: title,
			   	    shadeClose: false,
			   	    shade: 0,
			   	    area: ['350px', '278px'],
			   	    content: 'editLable?id='+ id, //iframe的url
			   	    success: function(msg) {
			   	    	if(msg.status) {
							window.location.href ="window.location.href" ;
						}
			   	    }
			   	}); 
		    });
		};
	
		function addTitle(title) {
			layer.closeAll();
			layer.open({
		   	    type: 2,
		   		skin : 'skin1',
		   	    title: title,
		   	    shadeClose: false,
		   	    shade: 0,
		   	    area: ['350px', '278px'],
		   	    content: 'editLable', //iframe的url
		   	    success: function(msg) {
		   	    	if(msg.status) {
						window.location.href ="window.location.href" ;
					}
		   	    }
		   	}); 
			layer.close(index);
		};
		
	    function changeStatus1(title, id) {
	    	layer.closeAll();
		    layer.confirm("您确认要启用当前标签吗？",{
		    	title: title,
		        skin : 'skin1',
		        shade: 0,
		        btn: ['确定','取消'] //按钮
		    }, function(index){
		    	window.location.href = 'userLable?id='+id;
		        layer.close(index);
		    });
		}
	    
	    function changeStatus2(title, id) {
	    	layer.closeAll();
		    layer.confirm("您确认要禁用当前标签吗？",{
		    	title: title,
		        skin : 'skin1',
		        shade: 0,
		        btn: ['确定','取消'] //按钮
		    }, function(index){
		    	window.location.href = 'banLable?id='+id;
		        layer.close(index);
		    });
		}
	</script>
</head>
<body>
	<form action="<%=path %>/msgCenter/listTitleTag" method="post" id="condition">
    	<div class="content">
    		<div class="content-title">标签管理</div>
	        <div class="search-box-wrapper">
	                <ul class="search-wrapper clearfix">
	                    <li>
	                        <label>标签内容：</label>
	                        <input type="text" name="content" value="${pojo.content}" maxlength="6">
	                    </li>
	                    <li>
	                        <label>创建日期：</label>
	                        <input class="info-date" id="startDate" type="text" name="startCreatetime" value="<fmt:formatDate value="${pojo.startCreatetime}" pattern="yyyy-MM-dd"/>" readonly="readonly"/>
	                        <span  class="mar-left">至</span>
	                        <input class="info-date" id="endDate" type="text" name="endCreatetime" value="<fmt:formatDate value="${pojo.endCreatetime}" pattern="yyyy-MM-dd"/>" readonly="readonly"/>
	                    </li>
	                    <li>
	                        <button type="button" class="btn-inquiry ico-search" onclick="search(1)">查询</button>
	                        <button type="button" id="addtitleTag" class="btn-inquiry ico-add" onclick='addTitle("新增标签")'>新增</button> 
	                    </li>
	                </ul>
	        </div>
	        <div class="table-box">
		        <c:if test="${page.totalCount == 0}">
					<div class="empty-info border-1-solid">目前没有标签信息</div>
				</c:if>
				<c:if test="${page.totalCount > 0}">
					<table class="table-content" id="datalist">
		                <thead class="table-title">
		                    <tr>
		                        <th>标签内容</th>
		                        <th width="10%">创建人</th>
		                        <th width="20%">创建日期</th>
		                        <th width="20%">操作</th>
		                    </tr>
		                </thead>
		                <tbody>
		                	<c:forEach items="${page.result}" var="lable">
			                    <tr align="center">
			                   		<td>${lable.content}</td>
			                        <td>${lable.doctor.docname}</td>
			                        <td><fmt:formatDate value="${lable.createtime}" pattern="yyyy-MM-dd"/></td>
			                        <td>
			                        <a href="javascript:void(0);" onclick='editTitle("修改标签", ${lable.hnlabelid})'>修改</a>
			                        <c:if test="${lable.statustype==1 || lable.statustype==3 }">
			                        <a href="javascript:void(0);" id="changeStatus1" class="mar-left" onclick='changeStatus1("启用",${lable.hnlabelid})'>启用</a>
			                        </c:if>
			                         <c:if test="${lable.statustype==2}">
			                        <a href="javascript:void(0);" id="changeStatus2" class="mar-left" onclick='changeStatus2("禁用",${lable.hnlabelid})'>禁用</a>
			                        </c:if>
			                        </td>
			                    </tr>
		                    </c:forEach>
	                    </tbody>
		            </table>
		            </c:if>
					<div class="page-box">
						<jsp:include  page="/public/pageFoot.jsp"/>
				  	</div>
	        </div>
		</div>
	</form>
</body>
</html>