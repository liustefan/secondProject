<%@ page contentType="text/html; charset=utf-8" language="java" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html ng-app="app">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=9">
    <title>咨询详情</title>
	<link rel="stylesheet" href="<%=path %>/css/general.css">
	<link rel="stylesheet" href="<%=path %>/js/jquery-ui/themes/overcast/jquery-ui.min.css">
	<link rel="stylesheet" href="<%=path %>/css/msgCenter.css">

	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-ui/jquery-ui.js"></script>
	<script type="text/javascript" src="<%=path %>/layer/layer-v2.0/layer.js"></script>
	<script type="text/javascript" src="<%=path %>/js/angular.js"></script>
	<script type="text/javascript" src="<%=path %>/js/dataPacker.js"></script>
	<script type="text/javascript" src="<%=path %>/js/interflow.js"></script>
	<style type="text/css">
        .mr-15 {
            margin: 15px 0;
        }

        .send {
            position: relative;
            width: 95%;
            height: auto;
            min-height: 135px;
            line-height: 24px;
            padding: 3px 6px;
            border: 1px solid #d8e0e9;
            border-radius: 5px; /* 圆角 */
        }

        .send .arrow {
            position: absolute;
            top: 10px;
            left: -5px; /* 圆角的位置需要细心调试哦 */
            width: 8px;
            height: 8px;
            font-size: 0;
            background: #fff;
            border-bottom: 1px solid #d8e0e9;
            border-left: 1px solid #d8e0e9;

            transform:rotate(45deg);
            -ms-transform:rotate(45deg);     /* IE 9 */
            -moz-transform:rotate(45deg);    /* Firefox */
            -webkit-transform:rotate(45deg); /* Safari 和 Chrome */
            -o-transform:rotate(45deg);  /* Opera */
        }

        .TempContainer {
            position: absolute;
            z-index: 101;
            margin-right: 0px;
            margin-left: 0px;
            text-align: center;
            width: 100%;
        }

        .TempContainer img {
            cursor: pointer;
            max-height: 450px;
        }
        
        .info-box li {
        	padding-top: 12px;
        }
    </style>
    <script type="text/javascript">
	    var id = ${param.id};
	    var sId = ${param.sId};
	    var rId = ${param.rId};
//  	var memName = '${param.name}';
//  	var image = '${param.image}';
//  	var memGender='${param.memGender}';
//  	var gender='${userInfo.gender}';  //测试时使用
    </script>
</head>
<body ng-controller="ctrl">
    <div class="content">
        <div id="Over" style="display:none; position:absolute;left: 0; top: 0; width:100%;z-index:9;"></div>
        <div class="content-title">医患沟通 --- 查看</div>
       	<div ng-show="page.totalPages > 1">
	        <div class="align-center page-box">
	            <img src="<%=path %>/img/more.png">
	            <a href="javascript:void(0)" ng-click="event.loadMore(page.pageNo,page.totalPages)">查看更多消息</a>
	        </div>
       	</div>
        <div class="chat-box" ng-repeat="result in arrayObj">
            <div class="info-box">
                <ul id="load_more">
                    <li class="clearfix">
                        <div class="fl align-center" style="width: 15%;" ng-show="{{result.sendType}} == 1">
                        <c:if test="${empty userInfo.headAddress}">
	                      <c:if test="${userInfo.gender=='M'}">
	                        <img id="imghead" class="imghead center-block" width="120" height="130" border="0" src="<%=path%>/img/man_Doctors-face_@3x.png">
	                      </c:if>
                          <c:if test="${userInfo.gender=='F'}">
                        	<img id="imghead" class="imghead center-block" width="120" height="130" border="0" src="<%=path%>/img/woman_Doctors-face_@3x.png">
                          </c:if> 
                          </c:if>
                         <c:if test="${not empty userInfo.headAddress}">  
                            <img src="<%=path%>/image/getImage?uniqueId=${userInfo.headAddress}" width="120" height="130">
                         </c:if> 
                            <p>医生：${userInfo.realName}</p>
                        </div>
                        <div class="fl align-center" style="width: 15%;" ng-show="{{result.sendType}} == 2">
                       <c:if test="${empty param.image}">
	                       	<c:if test="${param.memGender=='1' || param.memGender=='3'}">
	                        <img id="imghead" class="imghead center-block" width="120" height="130" border="0" src="<%=path%>/img/man_@3x.png">
	                        </c:if>
	                        <c:if test="${param.memGender=='2'}">
	                        <img id="imghead" class="imghead center-block" width="120" height="130" border="0" src="<%=path%>/img/woman_@3x.png">
	                        </c:if>
                        </c:if>
                        <c:if test="${not empty param.image}">
                        <img src="<%=path%>/image/getImage?uniqueId=${param.image}" width="120" height="130">
                        </c:if>
                            <p>会员：${param.name}</p>
                        </div>
                        <div class="fl" style="width: 85%;" >
                            <div class="send">
	                            <span ng-show="result.contentType == 1 && result.refType!=4 && result.refType!=5">
	                              {{result.content}}
	                            </span>
	                            
	                            <span ng-show="result.contentType == 1 && result.refType==4">
	                             <span ng-show="result.refStatus==1">
	                           		<a href="<%=path %>/question/singleAnswer/answerInfo?ansNumber={{result.refID}}&memberId=78674">{{result.content}}</a>
	                           	 </span>
	                           	 <span ng-show="result.refStatus==2">
	                              <a href="<%=path %>/question/singleAnswer/answerView?ansNumber={{result.refID}}">{{result.content}}</a> 
	                           	 </span>
	                           	 <span ng-show="result.refStatus==3">
	                              <a href="<%=path %>/question/singleAnswer/answerView?ansNumber={{result.refID}}">{{result.content}}</a>
	                           	 </span>
	                           	 <span ng-show="result.refStatus==4">
	                               {{result.content}}(已撤回)
	                           	 </span>
	                            </span>
	                            
	                            <span ng-show="result.contentType == 1 && result.refType==5">
	                             <span ng-show="result.refStatus==1">
	                              <a href="<%=path %>/question/singleAnswer/answerInfo?combAnsId={{result.refID}}&memberId={{result.memberid}}">{{result.content}}</a> 
	                           	 </span>
	                           	 <span ng-show="result.refStatus==2">
	                              <a href="<%=path %>/question/comAnswer/answerInfo?combAnsId={{result.refID}}">{{result.content}}</a>
	                           	 </span>
	                           	 <span ng-show="result.refStatus==3">
	                              <a href="<%=path %>/question/comAnswer/answerInfo?combAnsId={{result.refID}}">{{result.content}}</a>
	                           	 </span>
	                           	 <span ng-show="result.refStatus==4">
	                                {{result.content}}(已撤回)
	                           	 </span>
	                           	</span>
	                            
	                            <span ng-show="result.contentType == 2"> 
	                                <img class="img EnlargePhoto" ng-click='event.showImg(result.contentStr)' src="<%=path%>/image/getImage?uniqueId={{result.contentStr}}" style="width: 100px; height: 100px; vertical-align: text-bottom;">
	                            </span>
	                            <span ng-show="result.contentType == 3"> 
	                                <audio controls="controls">
                                    	<source ng-src="{{result.contentStr | trusted}}" type="audio/mpeg">
                                           Your browser does not support the audio tag.
	                                </audio>
	                            </span>
                                <div class="arrow"></div>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
            <div class="align-center mr-15">
            {{result.validSendTime}}
           </div>
        </div>
        <div class="align-center mr-15">
            <button type="button" id="" class="btn-cancel" onclick='window.location.href="../communicate/listCommunicate"'>返回</button>
        </div>
    </div>
</body>
</html>