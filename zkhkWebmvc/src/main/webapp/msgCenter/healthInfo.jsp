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
	<title>健康资讯</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/js/jquery-ui/themes/overcast/jquery-ui.min.css">
	<link rel="stylesheet" href="<%=path %>/css/msgCenter.css">

	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-ui/jquery-ui.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script type="text/javascript" src="<%=path %>/js/dataPacker.js"></script>
	<script type="text/javascript" src="<%=path %>/js/msgCenter.js"></script>
	<script type="text/javascript" >
		var index = layer.getFrameIndex(window.name); //获取窗口索引
		/* function publish(title, id) {
			layer.closeAll();
			layer.open({
		   	    type: 2,
		   		skin : 'skin1',
		   	    title: '发布',
		   	    shadeClose: false,
		   	    shade: 0,
		   	    area: ['350px', '278px'],
		   	    content: 'publishNewsInfo?id='+id, //iframe的url
		   	}); 
		}; */
		function publish(title, id) {
			layer.closeAll();
		    layer.confirm('<div>您确认要发布吗？</div>',{
		    	title: title,
		        skin : 'skin1',
		        shade: 0,
		        btn: ['发布','取消'] //按钮
		    }, function(index){
		    	window.location.href = 'publishNewsInfo?id='+id;
		        layer.close(index);
		    });
		}
		
		function del() {
			var checkList = $(".table-content input[name='ids']:checked");
			if (checkList.length <= 0) {
				layer.alert('请选择健康资讯信息', {skin: 'skin1', shade: 0})
				return;
			}
			layer.closeAll();
			layer.confirm("您确定要删除吗？", {
				  skin : 'skin1',
				  shade: 0,
			      btn: ['确认','取消'] //按钮
			  }, function(i){
			  		var type1 = false;
			  		checkList.each(function(index,element){
			  			if($(this).attr('stadutype') == 3 ){
			  				type1 = true;
		  		    	}
			  		})
			  		if(type1) {
			  			layer.closeAll();
			  			layer.confirm('当前健康资讯已推送，删除后会造成会员无法查看，确定要删除吗？', {
		  		    		skin: 'skin1', 
		  		    		shade: 0,
		  		    		btn: ['确认','取消'] //按钮
		  		    	}, function(index){
		  		    		$.ajax({
		 					   type: "post",
		 					   url:  "deleteHealthnewsInfos",
		 					   data: $.param(checkList),
	 					  	   async: false,
		 					   success: function(msg){
		 					     layer.alert(msg.content, {skin: 'skin1', shade: 0, end: function(index){
		 					    	 layer.close(index);
		 					    	 if(msg.status){
		 					    		 window.location.reload();
		 					    	 }
	 					     	}});
		 					   }
		 					})
		 					layer.close(index);
  		    			})
		  			}else {
		  				$.ajax({
 						   type: "post",
 						   url:  "deleteHealthnewsInfos",
 						   data: $.param(checkList),
 						   success: function(msg){
 							   	layer.alert('删除成功!', {skin: 'skin1', shade: 0,});
 						    	layer.close(index);
 						    	window.location.reload();
 						   }
		  		  		})
		  			}
		  		}
		  	)
		}
		function dele(url,status){
			var msg = "你确定要删除健康资讯信息吗？"
			if(status == 3){
				msg = "当前健康资讯已推送，删除后会造成会员无法查看，确定要删除吗？"
			}
			layer.closeAll();
			layer.confirm( msg, {
				title : '提示信息',
				skin : 'skin1',
				shade : 0,
				btn : [ '确定', '取消' ]
			}, function(index) {
				$.ajax({
					url: url,
				   type: "POST",
				success: function(data) {
					alert(data.content);
	 		     	if(data.status) {
	 		     		location.href="../msgCenter/deleteHealthnewsInfo?id=${newsInfo.hninfoid}";
	 		     		window.location.reload();
	 		     	}
				}
				});
			});
		}
	
		$(function() {
			// 全选
			$("#allSelect").click(function() {
				$(":checkbox[name='ids']:not(:disabled)").each(function() {
					this.checked = true;
				});
			});
			// 反选
			$("#unSelect").click(function() {
				$(":checkbox[name='ids']:not(:disabled)").each(function() {
					this.checked = !this.checked;
				});
			});
		});
	</script>
</head>
<body>
	<div class="content">
	<div class="content-title">健康资讯</div>
	<form action="<%=path %>/msgCenter/listNewsInfo" method="post" id="pojo" enctype="multipart/form-data">
        <div class="search-box-wrapper">
	        <ul class="search-wrapper clearfix">
	            <li>
	                <label>标题：</label>
	                <input type="text" name="title" value="${pojo.title}" maxlength="50">
	            </li>
	            <li>
	                <label>状态：</label>
	                <select name="statustype">
	                    <option value="">全部</option>
	                    <option value="1" <c:if test="${pojo.statustype eq '1'}">selected="selected"</c:if>>新建</option>
	                    <option value="2" <c:if test="${pojo.statustype eq '2'}">selected="selected"</c:if>>已发布</option>
	                    <%-- <option value="3" <c:if test="${pojo.statustype eq '3'}">selected="selected"</c:if>>已推送</option> --%>
	                </select>
	            </li>
	            <li>
	                <label>标签：</label>
	                <select name="hnlabelid">
	                <option value="">全部</option>
	                <c:forEach items="${lableList}" var="lable">
	                <c:choose>
	                 <c:when test="${healthnewsLable.hnlabelid eq lable.hnlabelid }">
	                 <option value="${lable.hnlabelid}" selected="selected">${lable.content}</option>
	                 </c:when>
	                 <c:otherwise>
	                 <option value="${lable.hnlabelid}">${lable.content}</option>
	                 </c:otherwise>
	                 </c:choose>
	                </c:forEach> 
	                </select>
	            </li>
	            <li>
	                <label>是否置顶：</label>
	                <select name="isstickypost">
	                    <option value="">全部</option>
	                    <option value="1" <c:if test="${pojo.isstickypost eq '1'}">selected="selected"</c:if>>是</option>
	                    <option value="0" <c:if test="${pojo.isstickypost eq '0'}">selected="selected"</c:if>>否</option>
	                </select>
	            </li>
	            <li>
	                <label>更新日期：</label>
	                <input class="info-date" id="startDate" type="text"  name="startUpdatetime" value="<fmt:formatDate value="${pojo.startUpdatetime}" pattern="yyyy-MM-dd"/>" readonly="readonly"/>
	                <span  class="mar-left">至</span>
	                <input class="info-date" id="endDate" type="text"  name="endUpdatetime" value="<fmt:formatDate value="${pojo.endUpdatetime}" pattern="yyyy-MM-dd"/>" readonly="readonly"/>
	            </li>
	            <li>
	                <label>发布日期：</label>
	                <input class="info-date" id="startDate2" type="text" name="startReleasetime" value="<fmt:formatDate value="${pojo.startReleasetime}" pattern="yyyy-MM-dd"/>" readonly="readonly"/>
	                <span  class="mar-left">至</span>
	                <input class="info-date" id="endDate2" type="text" name="endReleasetime" value="<fmt:formatDate value="${pojo.endReleasetime}" pattern="yyyy-MM-dd"/>" readonly="readonly"/>
	            </li>
	            <li>
	                <button type="button" class="btn-inquiry ico-search" onclick="search(1)">查询</button>
	                <button type="button" id="addNewsInfo" class="btn-inquiry ico-add" onclick="window.location.href='editNewsInfo' ">新增</button>
	            </li>
	        </ul>
        </div>
        <div class="table-box">
	        <c:if test="${page.totalCount == 0}">
				<div class="empty-info border-1-solid">目前还没有健康资讯信息</div>
			</c:if>
			<c:if test="${page.totalCount > 0}">
				<table class="table-content" id="datalist">
				    <thead class="table-title">
				        <tr>
				            <!-- <th width="5%">选择</th> -->
				            <th>标题</th>
				            <th width="15%">标签</th>
				            <th width="10%">更新人</th>
				            <th width="10%">更新日期</th>
				            <th width="10%">发布日期</th>
				            <th width="10%">是否置顶</th>
				            <th width="5%">状态</th>
				            <th width="10%">操作</th>
				        </tr>
				    </thead>
				    <tbody>
						<c:forEach items="${page.result}" var="newsInfo">
							<tr align="center">
							    <%-- <td>
							    <input name="ids" type="checkbox" value="${newsInfo.hninfoid}" stadutype="${newsInfo.statustype}">
							    </td> --%>
							    <td>${newsInfo.title}</td>
							    <td>
									<c:forEach items="${newsInfo.healthnewsLables}" var="healthnewsLable">
									${healthnewsLable.content}&nbsp;
									</c:forEach>
								</td>
							    <td>${newsInfo.doctor.docname}</td>
							    <td><fmt:formatDate value="${newsInfo.updatetime}" pattern="yyyy-MM-dd"/></td>
							    <td><fmt:formatDate value="${newsInfo.releasetime}" pattern="yyyy-MM-dd"/></td>
							    <td>${newsInfo.isstickypost==1?'是':'否'}</td>
							    <td class="status-type">
							    <c:if test="${newsInfo.statustype==1}">新建</c:if>
							    <c:if test="${newsInfo.statustype==2}">已发布</c:if>
							    <c:if test="${newsInfo.statustype==3}">已推送</c:if>
							    <c:if test="${newsInfo.statustype==4}">已删除</c:if>
							    </td>
							    <td>
							    <a href="editNewsInfo?id=${newsInfo.hninfoid}">修改</a>
							    <c:if test="${newsInfo.statustype==1}">
							    <a href="javascript:void(0);" class="cursor-p mar-left" onclick='publish("发布", ${newsInfo.hninfoid})'>发布</a>
							  	</c:if>
							  	 <c:if test="${newsInfo.statustype!=1}">
							    <span class="mar-left">发布</span>
							  	</c:if>
							    <a class="mar-left" href="javascript: void(0);" onclick="dele('<%=path %>/msgCenter/deleteHealthnewsInfo?id=${newsInfo.hninfoid}','${newsInfo.statustype }');" >删除</a>
							    </td>
							</tr>
				        </c:forEach>
				    </tbody>
				</table>
				</c:if>
				<div class="page-box">
					<!-- <div class="fl">
						<button type="button" id="allSelect" class="btn-inquiry">全选</button>
				     	<button type="button" id="unSelect" class="btn-inquiry">反选</button>
					</div> -->
		            <jsp:include page="/public/pageFoot.jsp"/>
				</div>
        </div>
        </form>
	</div>
</body>
</html>