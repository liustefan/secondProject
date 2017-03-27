var measTime = "";
var timeLength = "";
var heartNum = ""; // 总心博数
var slowestBeat = "";
var slowestTime = "";
var fastestBeat = "";
var fastestTime = "";
var averageHeart = "";

function showInfo_label(obj) {
	$.ajax({
		type: "GET",
		url: "../electrocardioPulse/showSingleElectrocardioInfo",
		data: {docentry: $(obj).next("input").val()},
		success: function(data){
			if (data) {
				var myInfo = JSON.parse(data);

				measTime = myInfo.measTime;
				timeLength = myInfo.timeLength;
				heartNum = myInfo.heartNum;
				slowestBeat = myInfo.slowestBeat;
				slowestTime = myInfo.slowestTime;
				fastestBeat = myInfo.fastestBeat;
				fastestTime = myInfo.fastestTime;
				averageHeart = myInfo.averageHeart;

				var pageii = $
						.layer({
							type : 1,
							title : ['测量项详细内容','background:#09c;'],
							area : [ 'auto', 'auto' ],
							border : [5, 1, '#09c'], // 去掉默认边框
							shade : [0.7, 0, '#000'], // 去掉遮罩
							closeBtn : [ 1, true ], // 去掉默认关闭按钮
							/*shift : 'left', // 从左动画弹出*/
							fadeIn: 50,
							page : {
								html : '<div style="width:420px; height:260px; padding:20px; background-color:#fff;"><span id="mySpan"></span></div>'
							}
						});

				$('#mySpan')
						.html(
								"最小心率："
										+ slowestBeat
										+ "&nbsp;&nbsp;&nbsp;最小心率时间(秒/s)："
										+ slowestTime
										+ "<br/><br/>最大心率："
										+ fastestBeat
										+ "&nbsp;&nbsp;&nbsp;最大心率时间(秒/s) ："
										+ fastestTime
										+ "<br/><br/>平均心率："
										+ averageHeart
										+ "&nbsp;&nbsp;&nbsp;总心搏数："
										+ heartNum
										+ "<br/><br/>测量时间："
										+ measTime
										+ "<br/><br/>测量时长(秒/s)："
										+ timeLength
										+ "<br/><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
			} else {
				alert("没有找到你需要的信息");
				return;
			}
		}
		
	});
};
