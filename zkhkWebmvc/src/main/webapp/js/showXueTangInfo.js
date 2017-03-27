var uploadTime = "";
var testTime = "";
var bsValue = ""; //本次测量血糖值
var timePeriod = "";  //测量时间段
var analysisResult = "";  //收缩压

function showInfo_label(obj) {
		$.ajax({
			url: "../bloodSugar/showSingleBloodSugarInfo",
			data: {docentry : $(obj).next("input").val()},
			success: function(data){
				if (data) {
					var myInfo = JSON.parse(data);

					uploadTime = myInfo.uploadTime;
					testTime = myInfo.testTime;
					bsValue = myInfo.bsValue;
					analysisResult = myInfo.analysisResult;
					timePeriod = myInfo.timePeriod;

					var pageii = $
							.layer({
								type : 1,
								title : ['血糖测量项详细内容','background:#09c;'],
								area : [ 'auto', 'auto' ],
								border : [5, 1, '#09c'], // 去掉默认边框
								shade : [0.7, 0, '#000',], 
								closeBtn : [ 1, true ], // 去掉默认关闭按钮
								/*shift : 'left', // 从左动画弹出*/
								fadeIn: 50,
								page : {
									html : '<div style="width:420px; height:260px; padding:20px; background-color:#fff;"><span id="mySpan"></span></div>'
								}
							});
					
					$('#mySpan')
							.html(
									"测量时间："
											+ testTime
											+ "<br/><br/>测量时间段 ："
											+ timePeriod
											+ "<br/><br/>本次测量血糖值："
											+ bsValue
											+ "<br/><br/>分析结果："
											+ analysisResult
											+ "<br/><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
				} else {
					alert("没有找到你需要的信息");
					return;
				}
			}
		});
};