var uploadTime = "";
var testTime = "";
var abnormal = ""; // 异常状态
var timePeriod = "";  //测量时间段
var sbp = "";  //收缩压
var dbp = "";  //舒张压
var pulseRate = "";  //脉搏率

function showInfo_label(obj) {
	
	$.ajax({
		type: "GET",
		url : "../bloodPressure/showSingleBloodPressInfo",
		data: {docentry: $(obj).next("input").val()},
		success: function(data){
			if (data) {
				var myInfo = JSON.parse(data);

				uploadTime = myInfo.uploadTime;
				testTime = myInfo.testTime;
				abnormal = myInfo.abnormal;
				timePeriod = myInfo.timePeriod;
				sbp = myInfo.sbp;
				dbp = myInfo.dbp;
				pulseRate = myInfo.pulseRate;
				//解决重复弹框问题
				layer.closeAll();
				var pageii = $
						.layer({
							id:1,
							type : 1,
							title : ['血压测量单次详细内容','background:#09c;'],
							area : [ 'auto', 'auto' ],
							border : [2, 1, '#09c'], // 去掉默认边框
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
								"测量时间："
										+ testTime
										+ "<br/><br/>上传时间："
										+ uploadTime
										+ "<br/><br/>状态："
										+ abnormal
										+ "&nbsp;&nbsp;&nbsp;测量时间段 ："
										+ timePeriod
										+ "<br/><br/>收缩压："
										+ sbp
										+ "&nbsp;&nbsp;&nbsp;舒张压："
										+ dbp
										+ "<br/><br/>脉搏率："
										+ pulseRate
										+ "<br/><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
			} else {
				alert("没有找到你需要的信息");
				return;
			}
		}
	});
};


//血压所有测量数据中的血压趋势图
$(function () {
	var chart = new Highcharts.Chart({
		chart: {
			//type: 'line',
			renderTo: 'myxueya'
		},
        title: {
            text: '血压趋势图',
            x: -20  //center
        },
//        subtitle: {
//            text: 'Source: WorldClimate.com',
//            x: -20
//        },
        xAxis: {
            categories: [],
            title: {
                text: '日期',
                align: 'high'
            }
        },
        yAxis: {
            title: {
                text: '血压值（mmHg）',
                align: 'high'
            },
            min: 0,
            max: 260,
            tickInterval: 20, // 刻度
            gridLineWidth: 0,
            lineWidth: 1,
            tickWidth: 1,
            plotLines: [{
                color: 'red',
                dashStyle: 'solid',
                value: 140,
                width: 2,
                label: {
                    text: '140',
                    y: 5,
                    textAlign: 'right',
                    style: {
                        color: 'blue',
                        fontWeight: 'bold'
                    }
                }
            }, {
                color: '#01b7f9',
                dashStyle: 'solid',
                value: 90,
                width: 2,
                label: {
                    text: '90',
                    y: 5,
                    textAlign: 'right',
                    style: {
                        color: '#01b7f9',
                        fontWeight: 'bold'
                    }
                }
            }, {
                color: '#97d559',
                dashStyle: 'solid',
                value: 60,
                width: 2,
                label: {
                    text: '60',
                    y: 5,
                    textAlign: 'right',
                    style: {
                        color: '#97d559',
                        fontWeight: 'bold'
                    }
                }
            }]
        },
        exporting: {
            enabled: false
        },
        credits:{
            enabled:false // 禁用版权信息
        },
        tooltip: {
            formatter: function () {
                return '<b>' + this.series.name + '</b><br>' + this.x + '（月-日）: ' + this.y + '（mmHg）';
            }
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'top',
            floating: true,
            backgroundColor: 'rgba(0,0,0,0)',
            borderWidth: 1
        },
        series: [{
            name: '收缩压',
            data: []
        }, {
            name: '舒张压',
            data: []
        }]
    });
	chart.xAxis[0].setCategories(result.time);
	chart.series[0].setData(result.sbp);            
	chart.series[1].setData(result.dbp);
});

//血压所有测量数据中的脉率趋势图
$(function () {
	var chart = new Highcharts.Chart({
		chart: {
			//type: 'line',
			renderTo: 'mypulse'
		},
		colors: ['#000000'],
        title: {
            text: '脉率趋势图',
            x: -20  //center
        },
        xAxis: {
            categories: [],
            tickWidth: 1,
        	tickPosition: 'inside',
            title: {
                text: '日期',
                align: 'high'
            }
        },
        yAxis: {
            title: {
                text: '',
                align: 'high'
            },
            min: 0,
            max: 250,
            tickInterval: 25, // 刻度
            gridLineWidth: 0,
            lineWidth: 1,
            tickWidth: 1,
            plotLines: [{
                color: 'red',
                dashStyle: 'solid',
                value: 100,
                width: 2,
                label: {
                    text: '100',
                    y: 5,
                    textAlign: 'right',
                    style: {
                        color: 'blue',
                        fontWeight: 'bold'
                    }
                }
            },  {
                color: '#97d559',
                dashStyle: 'solid',
                value: 50,
                width: 2,
                label: {
                    text: '50',
                    y: 5,
                    textAlign: 'right',
                    style: {
                        color: '#97d559',
                        fontWeight: 'bold'
                    }
                }
            }]
        },
        exporting: {
            enabled: false
        },
        credits:{
            enabled:false // 禁用版权信息
        },
        tooltip: {
            formatter: function () {
                return '<b>' + this.series.name + '</b><br>' + this.x + '（月-日）: ' + this.y + '（bpm）';
            }
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'top',
            floating: true,
            backgroundColor: 'rgba(0,0,0,0)',
            borderWidth: 1
        },
        series: [{
            name: '脉率',
            data: []
        }]
    });   
	chart.xAxis[0].setCategories(result.time);  
	chart.series[0].setData(result.pulseRate);   
});