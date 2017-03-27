	
var app = angular.module('app', [], function($httpProvider){
});

app.controller('ctrl', function ($scope, $http) {
	$scope.arrayObj = [];
	$scope.page = {pageNo : 1, totalPages: 0};
	$scope.event = {
			showImg: function(currsrc){
				with($('#Over')){
	                css('height',$(document).height());
	                css('display','block');
	                css('opacity',0.5);
	                css("background-color","#000");
		        }
                var TempContainer = $('<div class=TempContainer></div>');
                with(TempContainer){
                    appendTo("body");
                    css('top',document.body.scrollTop+120);
                    html('<img border=0 src="../image/getImage?uniqueId=' + currsrc + '">');
                }
                TempContainer.click(function(){
                    this.remove();
                    with($('#Over')){
		                css('display','none');
    		        }
                });
			},
			callRemote: function(url, data, callback){
				$scope.onOff = false;
	            transFn = function(data) {
	                return $.param(data);
	            },
	            postCfg = {
	                headers: { 'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
	                transformRequest: transFn
	            };
	            $http.post(url, data, postCfg).success(function(reponse){
	            	if(typeof(reponse)==='object'){
	            		$scope.onOff = true;
	            		callback(reponse);
                	}else{
                	   parent.layer.alert("登录信息过期，请重新登录", {shade: 0,skin : 'skin1',end: function(index){
	                		   parent.layer.close(index);
	                		   window.top.location.href="..";
                		   }}, function(index) {
	                		   parent.layer.close(index);
	                		   window.top.location.href="..";
                	   });
                	}
	            });
			},
			init: function(){
				this.callRemote("../communicate/viewDetailJsonPage", {sId:sId,rId:rId}, function(reponse){
					if(reponse.status){
						$scope.arrayObj = $scope.arrayObj.concat(reponse.data.result);
						$scope.arrayObj = $scope.arrayObj.reverse();
						$scope.page.pageNo = reponse.data.pageNo;
						$scope.page.totalPages = reponse.data.totalPages;
	                }else{
	                	return;
	                }
				})
			},
			loadMore: function(pageNo){
				pageNo = pageNo+1;
				if(pageNo <= $scope.page.totalPages){
					$scope.page.pageNo = pageNo;
					this.callRemote("../communicate/viewDetailJsonPage", {id: id, pageNo: pageNo,sId:sId,rId:rId}, function(reponse){
						if(reponse.status){
							$scope.arrayObj = reponse.data.result.reverse().concat($scope.arrayObj);
		                }else{
		                	return;
		                }
					})
				}else{
					alert("没有更多消息");
				}
			}
	};
	$scope.event.init();
});
app.filter('trusted', ['$sce', function ($sce) {
    return function(url) {
        return "../communicate/getaudio?uniqueId="+$sce.trustAsResourceUrl(url);
    };
}])