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
	<title>广告</title>
   	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/js/jquery-ui/themes/overcast/jquery-ui.min.css">
	<link rel="stylesheet" href="<%=path %>/css/msgCenter.css">

	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-ui/jquery-ui.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script type="text/javascript" src="<%=path %>/js/dataPacker.js"></script>
	<script type="text/javascript">
		var index = layer.getFrameIndex(window.name); //获取窗口索引
		
		function publish(title, id) {
			layer.closeAll();
		    layer.confirm('<div>您确认要发布吗？</div>',{
		    	title: title,
		        skin : 'skin1',
		        shade: 0,
		        btn: ['发布','取消'] //按钮
		    }, function(index){
		    	window.location.href = 'publishAdvert?id='+id;
		        layer.close(index);
		    });
		}
		
		//删除
		function del() {
			var checkList = $(".table-content input[name='ids']:checked");
			
			if (checkList.length <= 0) {
				layer.alert('请选择广告信息', {skin: 'skin1', shade: 0})
				return;
			}
			layer.closeAll();
			layer.confirm("您确定要删除吗？", {
				  skin : 'skin1',
				  shade: 0,
			      btn: ['确认','取消'] //按钮
			  }, function(i){
				  $.ajax({
					   type: "post",
					   url:  "deleteAdverts",
					   data: $.param(checkList),
					   success: function(msg){
						   	alert('删除成功!');
					    	window.location.reload();
					   }
					});
			  });
		} 
		
		$(function() {
			// 全选
			$("#allSelect").click(function() {
				$(":checkbox:not(:disabled)").each(function() {
					this.checked = true;
				});
			});
			// 反选
			$("#unSelect").click(function() {
				$(":checkbox:not(:disabled)").each(function() {
					this.checked = !this.checked;
				});
			});
		});
	</script>
</head>
<body>
	<div class="content">
	<div class="content-title">广告</div>
	<form action="<%=path %>/msgCenter/listAdvert" method="POST" id="pojo">
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
                        </select>
                    </li>
                    <li>
                        <label>发布日期：</label>
                        <input class="info-date" id="startDate" type="text" name="startReleasetime" value="<fmt:formatDate value="${pojo.startReleasetime}" pattern="yyyy-MM-dd"/>" readonly="readonly"/>
                        <span  class="mar-left">至</span>
                        <input class="info-date" id="endDate" type="text" name="endReleasetime" value="<fmt:formatDate value="${pojo.endReleasetime}" pattern="yyyy-MM-dd"/>" readonly="readonly"/>
                    </li>
                    <li>
                        <label>使用页面：</label>
                        <select name="usepage">
                          <option value="">全部</option>
                          <option value="1" <c:if test="${pojo.usepage eq '1'}">selected="selected"</c:if>>APP首页</option>
                          <option value="2" <c:if test="${pojo.usepage eq '2'}">selected="selected"</c:if>>APP健康中心页面</option>
                          <option value="3" <c:if test="${pojo.usepage eq '3'}">selected="selected"</c:if>>APP选择测量类型页面</option>
                          <option value="4" <c:if test="${pojo.usepage eq '4'}">selected="selected"</c:if>>健康服务套餐</option>	
                        </select>
                    </li>
                    <li>
                        <button type="button" class="btn-inquiry ico-search" onclick="search(1)">查询</button>
                       	<button type="button" id="addAdvert" class="btn-inquiry ico-add" onclick="window.location.href='editAdvert'">新增</button>
                        <button type="button" class="btn-inquiry ico-del" onclick="del();">删除</button>
                    </li>
                </ul>
        </div>
        
        <div class="table-box">
        	<c:if test="${page.totalCount == 0}">
				<div class="empty-info border-1-solid">目前没有广告信息</div>
			</c:if>
			<c:if test="${page.totalCount > 0}">
				<table class="table-content" id="datalist">
	                <thead class="table-title">
	                    <tr>
	                        <th width="5%">选择</th>
	                        <th>标题</th>
	                        <th width="10%">创建人</th>
	                        <th width="15%">发布日期</th>
	                        <th width="10%">状态</th>
	                        <th width="10%">操作</th>
	                    </tr>
	                </thead>
	                <tbody>
	                	<c:forEach items="${page.result}" var="advert">
		                    <tr align="center">
		                        <td>
		                        <input name="ids" type="checkbox" value="${advert.aid}">
		                        </td>
		                        <td>${advert.title}</td>
		                        <td>${advert.doctor.docname}</td>
		                        <td><fmt:formatDate value="${advert.releasetime}" pattern="yyyy-MM-dd"/></td>
		                        <td>${advert.statustype==1?'新建':'已发布' }</td>
		                        <td>
		                        <a href="editAdvert?id=${advert.aid}">修改</a>
		                        <c:if test="${advert.statustype==1}">
		                      	<a href="javascript:void(0);" class="mar-left" onclick='publish("发布", ${advert.aid})'>发布</a>
		                      	</c:if>
		                      	<c:if test="${advert.statustype!=1}">
		                      	<span class="mar-left">发布</span>
		                      	</c:if>
		                        </td>
		                    </tr>
	                    </c:forEach>
	                </tbody>
	            </table>
			</c:if>
		        <div class="page-box">
					<div class="fl">
						<button type="button" id="allSelect" class="btn-inquiry">全选</button>
				     	<button type="button" id="unSelect" class="btn-inquiry">反选</button>
					</div>
		            <jsp:include  page="/public/pageFoot.jsp"/>
				</div>
			</div>
		</form>
	</div>     
</body>
</html>

