<%@ page contentType="text/html; charset=utf-8" language="java" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<title>会员中心(温馨提示)</title>
	<link rel="stylesheet" href="<%=path %>/js/jquery-ui/themes/overcast/jquery-ui.min.css">
	<link rel="stylesheet" href="<%=path %>/plugins/zTree_v3/css/zTreeStyle/zTreeStyle.css">
	<link rel="stylesheet" href="<%=path %>/plugins/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="<%=path %>/css/general.css">
<%-- 	<link rel="stylesheet" href="<%=path %>/css/tree.css"> --%>

	<link rel="stylesheet" href="<%=path %>/js/jquery-ui/themes/overcast/jquery-ui.min.css">
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-ui/jquery-ui.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.core-3.5.min.js"></script>
	<script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.excheck-3.5.js"></script>
	<script type="text/javascript" src="<%=path %>/plugins/zTree_v3/js/jquery.ztree.exhide-3.5.js"></script>
	<script type="text/javascript" src="<%=path %>/js/dataPacker.js"></script>
	<script type="text/javascript" src="<%=path %>/js/tree.js"></script>
	<script type="text/javascript" src="<%=path %>/js/members.js"></script>
	<script type="text/javascript">
		$(function(){
			var $condition = $("#condition");
		  	function submit(url){
		  		$condition.attr("action", url).submit();
			}
			
			$("#query").click(function(){
				var flag = $("#flag").val();
				submit("<%=path %>/message/memberList?flag="+flag);
			});
			
			$("#report").click(function(){
				 var memid=$("input[name='memId']:checked").val();
			  	  if(memid==null){
			  	  	alert("请选中你要查看的会员");
			  	  	return null;
			  	  }
			  	 var ids =[];
				  $("input[name='memId']:checked").each(function(){
					ids.push($(this).val());
				});
					if(ids.length>1){
					alert("你只能选中单条记录！");
					return;
					}
				window.location = "<%=path %>/audit/SingleMeasueRepAction!showSingMemMeasRepList?memberid="+memid;
			});
			  $("#lines").change(function(){
			  	  	
			  	    var lines=$("#lines").val();
			  	    var flag=$("#flag").val();
			  	  submit("<%=path %>/message/memberList?flag=" + flag + "&page.pageNo=1&page.pageSize="+lines+"<%= request.getParameter("qustid") == null ? "" : "&qustid=" + request.getParameter("qustid") %><%= request.getParameter("combQustid") == null ? "" : "&combQustid=" + request.getParameter("combQustid")%>");
			  });
			
			  $("#btnadd").click(function(){
				window.location = "<%=path %>/mem/MemberAction_toEditMemberPage?flag=other";
	          }); 
			  
				//弹出批量导入会员页面
				$('#btnImportMember').on('click', function(){
					layer.closeAll();
				    layer.open({
				        type: 2,
				        skin: 'layui-layer-normal',
				        title: '批量导入会员',
				        maxmin: false,
				        shadeClose: true,
					    shade: 0,
				        area : ['600px' , '480px'],
				        content: '<%=path %>/member/importMember.jsp'
				    });
				});
			  
	          //置灰效果
	          var pageNum= "${page.pageNo}";
	          var pageLast="${page.totalPages}";
	          if(pageNum != 1){
	             $("#page-first").css({"color":"#333","cursor":"pointer"});
	             $("#pre span").css({"background":"url(../img/arrow-l.png) center no-repeat"});
	             $("#pre").css({"cursor":"pointer"});
	          }
	          if(pageNum == pageLast){
	             $("#page-last").css({"color":"#ccc","cursor":"default"});
	             $("#nex span").css({"background":"url(../img/arrow-r-gray.png) center no-repeat","cursor":"default"});
	             $("#nex").css({"cursor":"default"});
	          }
	          $("#page-first").click(function(){
	                var lines=$("#lines").val();
	                var flag=$("#flag").val();
				  	var pageNum= "${page.pageNo}";
				  	if(pageNum==1){
				  		return;
				  	}
				  	submit("<%=path %>/message/memberList?flag=" + flag + "&page.pageNo=1&page.pageSize="+lines+"<%= request.getParameter("qustid") == null ? "" : "&qustid=" + request.getParameter("qustid") %><%= request.getParameter("combQustid") == null ? "" : "&combQustid=" + request.getParameter("combQustid")%>");
	          }); 
	          $("#page-last").click(function(){
	                var lines=$("#lines").val();
	                var flag=$("#flag").val();
				  	var pageNum= "${page.pageNo}";
				  	if(pageNum == "${page.totalPages}"){
				  		return;
				  	}
				  	submit("<%=path %>/message/memberList?flag="+flag+"&page.pageNo=${page.totalPages}&page.pageSize="+lines+"<%= request.getParameter("qustid") == null ? "" : "&qustid=" + request.getParameter("qustid") %><%= request.getParameter("combQustid") == null ? "" : "&combQustid=" + request.getParameter("combQustid")%>");
	          });
			  $("#pre").click(function(){
			        var lines=$("#lines").val();
			        var flag=$("#flag").val();
				  	var pageNum= new Number("${page.pageNo}");
				  	
				  	if(pageNum == 1){
				  		return;
				  	}
				  	pageNum = pageNum - 1;
				  	submit("<%=path %>/message/memberList?flag=" + flag + "&page.pageNo=" + pageNum + "&page.pageSize="+lines+"<%= request.getParameter("qustid") == null ? "" : "&qustid=" + request.getParameter("qustid") %><%= request.getParameter("combQustid") == null ? "" : "&combQustid=" + request.getParameter("combQustid")%>");
	          }); 
			  $("#nex").click(function(){
			        var lines=$("#lines").val();
			        var flag=$("#flag").val();
				    var pageNum= new Number("${page.pageNo}");
				    
				  	if(pageNum=="${page.totalPages}"){
				  		return;
				  	}
				  	pageNum = pageNum + 1;
				  	submit("<%=path %>/message/memberList?flag="+flag+"&page.pageNo=" + pageNum + "&page.pageSize="+lines+"<%= request.getParameter("qustid") == null ? "" : "&qustid=" + request.getParameter("qustid") %><%= request.getParameter("combQustid") == null ? "" : "&combQustid=" + request.getParameter("combQustid")%>");
	          }); 
			  $("#toPage-btn").click(function(){
			        var lines=$("#lines").val();
			        var flag=$("#flag").val();
					var num = $("#toPage").val();
					var totalPage=${page.totalPages};
					var pageNow=${page.pageNo};
					var reg= /^[0-9]\d*$/;
					
					if(!reg.test(num)){
							alert("输入页数应为数字！");
							$("#toPage").val(pageNow);
							return false;
					}
					if(num>totalPage){
							alert("超过最大页了！");
							$("#toPage").val(pageNow);
							return false;
					}
					var topage= $("#toPage");
					//topage.val(pageNow);
					submit("<%=path %>/message/memberList?flag="+flag+"&page.pageNo="+num+"&page.pageSize="+lines);
			  });
			  //禁用分页回车键
			  $("#toPage").keydown(function(e){
					if(e.keyCode==13) {
					return false;
					}
			  }); 
			   $("#find").each(function(){
			   		var oldVal=$(this).val();   //默认的提示性文本   
	  				 $(this)   
	   				.css({"color":"#888"})  //灰色   
	   			.keydown(function(){$(this).css({"color":"#000"})})  
			   		
			     });
	// 		  $("#select1").click(function(){
	// 		  	   var qustid= "${param.qustid}";
	// 		  	   var combQustid= "${param.combQustid}";
	// 			    var criteria=$("#find").val();
	// 			    $("#advanceQuery").children(":hidden").val("");
	// 			    $("#criteria").val(criteria);
	<%-- 			    submit("<%=path %>/message/memberList"); --%>
				    
	//        	 }); 
	       	 
	//          $("#select2").click(function(){
	//         	 $("#FuzzyQuery").children(":hidden").val("");
	//         	 var qustid= "${param.qustid}";
	// 		  	 var combQustid= "${param.combQustid}";
	// 		  	 if(qustid != ""){
	<%-- 		  		 submit("<%=path %>/mem/MemberAction_toQueryPage?qustid=${qustid}"); --%>
	// 		     }else if(combQustid != ""){
	<%-- 		    	 submit("<%=path %>/mem/MemberAction_toQueryPage?combQustid=${combQustid}"); --%>
	// 		     }else{
	<%-- 		    	 submit("<%=path %>/mem/MemberAction_toQueryPage"); --%>
	// 		     }
	//         }); 
	// 		  $("#btnedit").click(function(){
	// 		  	  var memid=$("input[name='memId']:checked").val();
	// 		  	  if(memid==null){
	// 		  	  	alert("请选中你要修改的行");
	// 		  	  	return null;
	// 		  	  }
	// 		  	 var ids =[];
	// 			  $("input[name='memId']:checked").each(function(){
	// 				ids.push($(this).val());
	// 			});
	// 				if(ids.length>1){
	// 				alert("你只能选中单条记录！");
	// 				return;
	// 				}
	<%-- 			  window.location = "<%=path %>/mem/MemberAction_tofindMemInfoPage?memid="+memid; --%>
	//         }); 
	        
	//          $("#btnpkg").click(function(){
	// 		  	  var memid=$("input[name='memId']:checked").val();
	// 		  	  if(memid==null){
	// 		  	  	alert("请选你要查看的会员！");
	// 		  	  	return null;
	// 		  	  }
	// 		  	 var ids =[];
	// 			  $("input[name='memId']:checked").each(function(){
	// 				ids.push($(this).val());
	// 			});
	// 				if(ids.length>1){
	// 				alert("你只能选中单条记录！");
	// 				return;
	// 				}
	<%-- 			  window.location = "<%=path %>/mem/Mem5Action_tofindMem5Page?memid="+memid; --%>
	//         }); 
	        $("#checkAll").click(function() {
	        		var value = this.checked;
	        		
				$("input:checkbox[name='memId']").each(function () {  
					this.checked = value;  
				});
	        });
	        
	        $("input:checkbox[name='memId']").click(function(){
	            document.getElementById("checkAll").checked = ($("input:checkbox[name='memId']").length == $("input:checkbox[name='memId']:checked").length);
	        });
	            
	        $(".sendQuestion").click(function(){
	        	 var $this = this; 
	        	 var url = $this.getAttribute('data-href');
				 if(!$this.disabled&&confirm('确认发放问卷？')){
					 $this.disabled=true;
					  $.ajax({
						   type: "GET",
						   url: url,
						   success: function(msg){
	// 						 msg = eval("("+msg+")");
							 alert(msg.content);
							 $this.disabled = false;
							 if(msg.status){
								 if(url.indexOf('giveGroup') > 0)
									window.location.href="../question/questionAction!showGroupQuestionInfo?orgId=${sessionScope.org_id }";
								 else if(url.indexOf('give') > 0)
								 	window.location.href="../question/questionAction!showDisplayQuestionUI?myFlag=YAndN&orgId=${sessionScope.org_id }";
							 }
						   }
						});
				 }
	        });
	        
	        $("#showGroupIcon").click(function(){
	    		if($("#menuContent").css("display") =="none") {
	    			getData();
	    			showMenu();
	    		}
	    	});
		});
		
		function del(url){
			layer.confirm('你确定需要删除此条记录吗？', {
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
	 		     		location.href="../message/memberList?flag=" + $("#flag").val();
	 		     	}
				}
				});
			});
			}
		
		function remv(url){
			layer.confirm('你确定需要移除此条记录吗？', {
				title : '提示信息',
				skin : 'skin1',
				shade : 0,
				btn : [ '确定', '取消' ]
			}, function(){
				layer.msg("移除成功！",{icon: 1,time: 1000},
				function(index) {
				location.href=url;
				layer.close(index);
				})
			})
		}
		
		function give(index,qid){
				$("#btndel2").attr("disabled", true);
				   var mems =[];
					$("input[name='memId']:checked").each(function(){ 
						mems.push($(this).val());
					});
					if (mems.length == 0) {
						alert("请选中你要发放的会员！");
		             return ;
		       	     }
		       	   
			 	 var values=mems.toString();
			 	 var url ="";
			 	 var location = "";
				if (index ==1){
					url = "<%=path %>/answer/ouai!multiGive";
	               location = "<%=path %>/mem/MemberAction_getAllMemberList" ;
				}else if (index == 2) {
					url = "<%=path %>/answer/ouai!multiGiveGroup";
	                location = "<%=path %>/mem/MemberAction_getAllMemberList";
				}	 
			 	$.ajax( {
			    	url: url,
					data:{
						qustid:qid,
						mems : values
					},
					type:'post',
					cache:false,
					async: false,
					dataType:'json',
					success:function(result) {
						if (result.ret){
								alert("发放成功");
								 $("#condition").attr("action", location).submit();
						}else{
							alert("发放失败！");
							$("#btndel2").attr("disabled", false);
						}
					},
					error : function() {
						alert("发放失败！");
					}
				});
			 	$("#btndel2").attr("disabled", false);
			}
		function toMass(){
			window.location.href = '../msgCenter/message/messageGroup.jsp';
		}
	</script>
</head>
<body>
<div class="content">
	<div class="content-title">温馨提示</div>
	<div class="search-box-wrapper">
		<input id="flag" type="hidden" value="${flag}"/> 
	    <form action="memberList" method="POST" id="condition">
			<ul class="search-wrapper">
				<li>
					<label>会员姓名：</label>
	                <input type="text" name="memName" value="${condition.memName }" maxlength="20">
				</li>
				<li>
					<label>性别：</label>
                    <select name="gender">
                        <option value="">全部</option>
                        <c:choose>
                        <c:when test="${condition.gender eq 1}">
                          <option value="1" selected>男</option>
                        </c:when>
                        <c:otherwise>
                          <option value="1">男</option>
                        </c:otherwise>
                        </c:choose>
                        
                        <c:choose>
                        <c:when test="${condition.gender eq 2}">
                          <option value="2" selected>女</option>
                        </c:when>
                        <c:otherwise>
                          <option value="2">女</option>
                        </c:otherwise>
                        </c:choose>
                        <c:choose>
                        <c:when test="${condition.gender eq 3}">
                          <option value="3" selected>未知</option>
                        </c:when>
                        <c:otherwise>
                          <option value="3">未知</option>
                        </c:otherwise>
                        </c:choose>
                    </select>
				</li>
				<li>
					<label>出生日期：</label>
                    <input class="info-date" id="startDate" type="text" name="birthDayStart" value="${condition.birthDayStart }" readonly="readonly"/>
                    <span class="mar-left">至</span>
                    <input class="info-date" id="endDate" type="text" name="birthDayEnd" value="${condition.birthDayEnd }" readonly="readonly"/>	
				</li>
				<li>
					<label>会员类型：</label>
                    <select name="memType">
                        <option value="">全部</option>
                        <c:forEach items="${typeList }" var="item">
                        <c:choose>
                        <c:when test="${condition.memType eq item.memid }">
                        <option value="${item.memid }" selected>${item.memname }</option>
                        </c:when>
                        <c:otherwise>
                        <option value="${item.memid }">${item.memname }</option>
                        </c:otherwise>
                        </c:choose>
                        </c:forEach>
                    </select>	
				</li>
				<li>
					<label>疾病状况：</label>
                    <input type="text" name="diseaseName" value="${condition.diseaseName }" maxlength="30">	
				</li>
				<li>
					<label>身份证号：</label>
	                <input type="text" name="idcard" value="${condition.idcard }" maxlength="18">
				</li>
				<li>
					<label>手机号码：</label>
	                <input type="text" name="tel" value="${condition.tel }" maxlength="11">	
				</li>
				<li>
					<button type="submit" id="query" class="btn-inquiry ico-search">查询</button>
				</li>
			</ul>
	    </form>
	</div>
	<c:choose>
	<c:when test="${page.totalCount eq 0}">
		<div class="empty-info">没有查询到符合条件的会员</div>
	</c:when>
	<c:otherwise>
			<div class="table-box">
				<table class="table-content">
					<thead class="table-title">
						<tr>
							<th width="5%">序号</th>
							<th width="5%">姓名</th>
							<th width="5%">性别</th>
							<th>出生日期</th>
							<th>手机号码</th>
							<th>疾病状况</th>
							<th>活力指数</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${page.result}" varStatus="statu" var="item">
							<tr id="tr_${item.memberId}">
								<td>${(page.pageSize)*(page.pageNo)-((page.pageSize))+(statu.index+1) }</td>
								<td><c:out value="${item.memName}"></c:out></td>
								<td>
									<c:if test="${item.gender== 1}">男</c:if>
									<c:if test="${item.gender== 2}">女</c:if>
									<c:if test="${item.gender== 3}">未知</c:if>
								</td>
								<td><fm:formatDate value="${item.birthDay}" type="date" pattern="yyyy-MM-dd" dateStyle="long" /></td>
								<td>${item.tel }</td>
								<td>${item.diseaseNames }</td>
								<td></td>
								<td id="table_content_title_td">
					               <a href="toSendMsg?memberId=${item.memberId}">发送新消息</a>&nbsp;&nbsp;&nbsp;
					               <a href="msgView?memberId=${item.memberId}">查看消息</a>
				               </td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="page-box">
				<div class="fl">
					<button type="button" id="btndel2" class="btn-inquiry" onclick="toMass()">群发消息</button>
				</div>
	            <div class="page fr">
			     	<a id="page-first" class="page-btn">首页</a>
			     	<a id="pre" class="page-btn"><span style="top:0;"></span></a>
			     	<span>一页显示
			     	<select id="lines" class="page-num" name="lines">
			     	<c:choose>
				     	<c:when test="${page.pageSize eq 10 }">
				     		<option value="10" selected>10</option>
				     	</c:when>
				     	<c:otherwise>
				     		<option value="10">10</option>
				     	</c:otherwise>
			     	</c:choose>
			     	<c:choose>
				     	<c:when test="${page.pageSize eq 20 }">
				     		<option value="20" selected>20</option>
				     	</c:when>
				     	<c:otherwise>
				     		<option value="20">20</option>
				     	</c:otherwise>
			     	</c:choose>
			     	<c:choose>
				     	<c:when test="${page.pageSize eq 30 }">
				     		<option value="30" selected>30</option>
				     	</c:when>
				     	<c:otherwise>
				    		<option value="30">30</option>
				     	</c:otherwise>
			     	</c:choose>
			     	</select>条</span>
		         	<span class="page-total">共<i>${page.totalPages}</i>页</span>
		         	<a id="nex" class="page-btn"><span style="top:0;"></span></a>
			     	<span>跳转到：<input type="text" id="toPage" class="page-go" value="${page.pageNo}"/></span><a class="page-btn" id="toPage-btn">Go</a>
			     	<!--span>共<i>${pagination.totalCount}</i>条记录</span-->
			     	<a id="page-last" class="page-btn">尾页</a> 
	            </div>
			</div>
		</c:otherwise>
	</c:choose>
	<div style="color:#999;display:none;" id="fail1">以下会员的会员分组跟医生分组功能代码存在冲突,添加失败列表<br/><span id="fail"></span></div>
	<div id="loading-mask"></div>
	<div id="fullbg"></div>
</div>
</body>
</html>
