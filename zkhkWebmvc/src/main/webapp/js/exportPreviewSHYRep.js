Highcharts.setOptions({
    global: {
        useUTC: false
    },
    lang: {
        contextButtonTitle: '图表导出菜单',
        downloadJPEG: '导出JPG格式图片',
        downloadPDF: '导出PDF格式文档',
        downloadPNG: '导出PNG格式图片',
        downloadSVG: '导出SVG矢量图',
        printChart: '打印图表',
        resetZoom: '重置缩放',
        loading: '加载中',
        rangeSelectorFrom: '从',
        rangeSelectorTo: '至',
        months: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月',
            '十一月', '十二月'
        ],
        shortMonths: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月',
            '十月', '十一月', '十二月'
        ],
        weekdays: ['星期一', '星期二', '星期三', '星期四', '星期五', '星期六', '星期天']
    }
});

//创建异常心电图
function createABEcg(id, i, excData, page, data) {
	var excObj = excData.data;
    var Hz = 1000 / data.fs;
    var cellHeight = 65.5; //(maxValue - minValue) / objDt.height * 10;
    switch (data.type) {
        case "ab_ecg":
            Hz = 6000 / data.data.length; //频率
            minValue = -1000;
            maxValue = 1000;
            break;
        case "ecg":
            minValue = -1000;
            maxValue = 1000;

            break;
        case "mi_ecg":
            cellHeight /= 16;
            minValue = -127;
            maxValue = 128;

            break;
        case "ab_ecg1":
            cellHeight /= 16;
            minValue = 0;
            maxValue = 255;

            break;
        case "ab_ecg2":
            cellHeight /= 16;
            minValue = -127;
            maxValue = 128;

            break;
        case "ppg":
            minValue = 0;
            maxValue = 128;

            break;
        case "hr_ecg":
            startTime = objDt.startTime;
            endTime = objDt.endTime;
            minValue = 0;
            maxValue = 150;

            break;
        case "hr_ppg":
            minValue = 30;
            maxValue = 200;
            startTime = objDt.startTime;
            endTime = objDt.endTime;
            break;
    }

    var chart = new Highcharts.Chart({
        chart: {
            height: 300,
            width: 1000,
            renderTo: id + i
                //渲染到容器
        },
        pr_id: id,
        pr_i: i,
//        docentry: excObj.docentry,
        page: page,
        excData: excData,
        title: {
            text: '异常发生时间: ' + excObj[page].extimes + '  异常类型：' + excData.type,
            verticalAlign: 'bottom',
            margin: 0,
            y: -20,
            x: -20
                //center
        },
        yAxis: {
            min: minValue,
            max: maxValue,
            tickInterval: cellHeight * 5, // 每大格0.5 毫伏 500
            gridLineWidth: 1,
            gridLineColor: '#ff6a6a', // #ed7b10
            minorGridLineWidth: 1, // 次级网格线的宽度 0.8
            minorGridLineColor: '#eda8b7', // 次级网格线的颜色 b0a091
            minorTickInterval: cellHeight, // 次级网格的间隔 0.1毫伏 100
            minorGridLineDashStyle: "shortdot", //次级网格线是点线
            labels: {
                enabled: false
            },
            title: {
                text: ''
            }
        },
        tooltip: {
            enabled: false,
            crosshairs: false
                //跟随光标的精准线
        },
        xAxis: {
            type: 'datetime',
            // minRange : 5000, // 最小放大比例 1S
            // min: objDt.measureTime,
            // max: objDt.measureTime ,
            //tickPixelInterval: 500, // 网格间隔宽度默认100
            tickLength: 0, // 刻度线的长度
            //                minTickInterval: 1000,
            tickInterval: 200, // 每大格0.2S   
            gridLineWidth: 1, // 网格线的宽度
            gridLineColor: '#ff6a6a', //网格线的颜色 #ed7b10
            minorGridLineColor: '#eda8b7', //次级网格线的颜色 b0a091
            minorGridLineWidth: 1, //次级网格线的宽度
            minorGridLineDashStyle: "shortdot", //次级网格线是点线
            minorTickInterval: 40, //次级网格的间距 0.04S
            labels: {
                enabled: false, //是否显示x轴

            },
        },
        plotOptions: {
            series: {
                connectNulls: false,
                enableMouseTracking: false, //禁用鼠标轨迹跟踪功能
                marker: {
                    enabled: false
                },
                dataLabels: {
                    enabled: false
                        //显示数据点的值
                }
            }
        },
        legend: {
            enabled: false
        },
        credits: {
            enabled: false
        },
        exporting: {
            enabled: false
        },
        series: [{
            states: {
                hover: {
                    enabled: false
                }
            },
            pointStart: excObj[page].extMilli, //1439193863073, // 第一个点的时间
            pointInterval: Hz, // 频率
            pointIntervalUnit: 'milliseconds',

            data: data.data,
            lineWidth: 1,
            color: '#000',
        }],

    });
    //下一页
    var group1 = chart.renderer
        .g()
        .on(
            "click",
            function() {
                if (chart.options.page++ >= chart.options.excData.data.length - 1) {
                    chart.options.page =  chart.options.excData.data.length - 1;
                    return;
                }
                getExcData1(chart.options.excData, chart.options.page,
                    chart.options.pr_id, chart.options.pr_i);
            }).attr({
            position: 'absolute',
            zIndex: 999
        }).add();
    chart.renderer
        .image('../img/banner_shadow_right.png', '96%', '45%', 30, 30).add(
            group1);
    //上一页
    var group2 = chart.renderer.g().on(
        "click",
        function() {
            if (chart.options.page-- <= 0) {
                chart.options.page = 0;
                return;
            }
            getExcData1(chart.options.excData,
                chart.options.page, chart.options.pr_id,
                chart.options.pr_i);

        }).attr({
        position: 'absolute',
        zIndex: 999
    }).add();
    chart.renderer.image('../img/banner_shadow_left.png', '0', '45%', 30, 30)
        .add(group2);
    return chart.getSVG();
}

////脉搏指标趋势图
function createMBChart(render, obj) {
    //      
    //          PRLevel     PR  平均心率
    //          KLevel      K   波形特征量
    //          SVLevel     SV  心脏每搏射血量
    //          COLevel     CO  平均每分射血量
    //          ACLevel     AC  血管顺应度
    //          SILevel     SI  血管硬化指数
    //          VLevel      V   血液粘度
    //          TPRLevel    TPR 外周阻力
    //          SPOLevel    Spo 血氧饱和度
    //          CILevel     CI  心指数
    //          SPILevel    SPI 心搏指数
    //          pm      pm  平均动脉压   70-105

    var minValue, maxValue, min, max;
    switch (obj.shortName) {
        case "PR":
            minValue = 55, maxValue = 100, min = 40, max = 120;
            break;
        case "CO":
            minValue = 3, maxValue = 7.5, min = 0, max = 12;
            break;
        case "SV":
            minValue = 55, maxValue = 105, min = 40, max = 120;
            break;
        case "SPO":
            minValue = 95, maxValue = 100, min = 50, max = 120;
            break;
        case "CI":
            minValue = 2.3, maxValue = 100, min = 0, max = 120;
            break;
        case "SPI":
            minValue = 33, maxValue = 200, min = 0, max = 250;
            break;
        case "K":
            minValue = 0.29, maxValue = 0.46, min = 0, max = 0.8;
            break;
        case "V":
            minValue = 3, maxValue = 5.04, min = 0, max = 10;
            break;
        case "TPR":
            minValue = 750, maxValue = 1450, min = 0, max = 2000;
            break;
        case "AC":
            minValue = 1.3, maxValue = 3, min = 0, max = 8;
            break;
        case "PM":
            minValue = 70, maxValue = 105, min = 0, max = 120;
            break;
        case "SI":
            minValue = 0, maxValue = 8, min = 0, max = 12;
            break;
    }
    var chart = new Highcharts.Chart({
        chart: {
            width: 1000,
            height: 300,
            renderTo: render,
            type: 'line', //显示类型 
        },
        title: {
            text: obj.name + '趋势图',
            x: -20
                //center
        },
        xAxis: {
            type: 'datetime',
            labels: {
                format: '{value:%m-%d}'
            }
        },
        yAxis: {
            title: {
                text: null
            },
            min: min,
            max: max,
            gridLineWidth: 0,
            lineWidth: 1,
            tickWidth: 1,
            plotLines: [{
                color: 'red',
                dashStyle: 'dash',
                value: minValue,
                width: 2,
                label: {
                    text: minValue,
                    x: -2,
                    y: 5,
                    textAlign: 'right',
                    style: {
                        color: 'blue',
                        fontWeight: 'bold'
                    }
                }
            }, {
                color: 'red',
                dashStyle: 'dash',
                value: maxValue,
                width: 2,
                label: {
                    text: maxValue,
                    x: -2,
                    y: 5,
                    textAlign: 'right',
                    style: {
                        color: 'blue',
                        fontWeight: 'bold'
                    }
                }
            }],
        },
        credits: {
            enabled: false,
        },
        exporting: {
            enabled: false,
        },
        legend: {
            enabled: false,
            floating: true,
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'top',
            y: 50,
            borderWidth: 0
        },
        series: [obj]
    });
    return chart.getSVG();
}

function toArrayData(obj, flag) {
    var data = [];
    var result = [];

    if (flag == 'chart1') {
	if (obj) {
		var min = 0;

		for ( var key in obj) {
			var arr = obj[key];
			var d = [];
			var plotBand = {};

			if (arr && arr.length > 0) {
				var lb = [];

				for (i = 0; i < arr.length; i++) {
					var o = arr[i];
					if (o) {
						for ( var k in o) {
							d.push([+k,Math.floor(min + Math.random() * 100) ]);
						}
						plotBand = { // mark the weekend
							color : 'red',
							width : 1,
							value : min + 100,
							label : {
								text : key,
								textAlign : 'right',
								x : -5,
								y : 20
							}
						};

					} else {
						d.push(null);
					}

				}
				lb = [ key, d ];

			} else {
				lb = [ key, null ];
			}

			result.push({
				data : lb,
				plotBand : plotBand
			});
			min += 100;
		}
	}

	return result;
} else if (flag == 'chart2') {
	if (obj) {
		var c = [];
		var d = [];
		for ( var key in obj) {
			c.push(key);
			d.push(obj[key]);
		}
		data.push(c);
		data.push(d);
	}
} else if (flag == 'chart3') {
	if (obj) {
		var min = 0;

		for ( var key in obj) {
			var arr = obj[key];
			var d = [];
			var plotBand = {};

			if (arr && arr.length > 0) {
				var lb = [];

				for (i = 0; i < arr.length; i++) {
					var o = arr[i];
					if (o) {
						for ( var k in o) {
							d.push([+k,Math.floor(min + Math.random() * 100) ]);
						}
						plotBand = {
							color : 'red',
							width : 1,
							value : min + 100,
							label : {
								text : key,
								textAlign : 'right',
								x : -5,
								y : 18
							}
						};

					} else {
						d.push(null);
					}

				}
				lb = [ key, d ];

			} else {
				lb = [ key, null ];
			}

			result.push({
				data : lb,
				plotBand : plotBand
			});
			min += 100;
		}
	}
	return result;
} else if (flag == 'chart4') {
		if (obj) {
			var c = [];
			var d = [];
			for ( var key in obj) {
				c.push(key);
				d.push(obj[key]);
			}
			data.push(c);
			data.push(d);
		}
	}
	return data;
}

function getJson() {
    var url = "../electrocardioPulse/getElectrocardioPulseChart";
    
    $
	.post(
			url,
			{
				oecgsJson: JSON.stringify(oecgsJson),
				memberid: memberid,
				flag: true
			},
        function(obj) {
			 var obj1 = JSON.parse(obj);
        	 var ch1 = obj1[0]; // 图一数据
             var ch2 = obj1[1]; // 图二数据
             var ch3 = obj1[2]; // 图三数据
             var ch4 = obj1[3]; // 图四数据
             var ch5 = obj1[4];
             
            // 24小时异常心电分布图
            if ($('#shy_chart1').length > 0) {
                shy_chart1_Obj = new Highcharts.Chart({
                    chart: {
                        height: 400,
                        width: 500,
                        type: 'scatter',
                        plotBackgroundColor: null,
                        plotBorderWidth: null,
                        plotShadow: false,
                        renderTo: 'shy_chart1',
                        marginLeft: 80
                    },
                    title: {
                        text: '24小时异常心电分布图' // 标题
                    },
                    xAxis: {
                        title: {
                            enabled: true,
                            text: '时间' // X轴单位
                        },
                        tickInterval: 6,
                        max: 23,
                        min: 0,
                        startOnTick: true,
                        endOnTick: true,
                        showLastLabel: true
                    },
                    tooltip: {
                        formatter: function () {
                            return '<b>'+this.series.name+'</b><br>' + this.x.toFixed(2).replace('.', ':') +
                                ',' + this.y + '</b>';
                        }
                    },
                    yAxis: {
                        title: {
                            text: ' '
                        },
                        gridLineWidth: 0,
                        lineWidth: 1,
                        labels: {
                            enabled: false
                        },
                        min: 0,
                        tickInterval: 100,
                        startOnTick: true,
                        endOnTick: true,
                        showLastLabel: true,
                    },
                    legend: {
                        enabled: false,
                    },
                    plotOptions: {
                        scatter: {
                            marker: {
                                radius: 3,
                                states: {
                                    hover: {
                                        enabled: true,
                                        lineColor: 'rgb(100,100,100)'
                                    }
                                }
                            },
                            states: {
                                hover: {
                                    marker: {
                                        enabled: false
                                    }
                                }
                            },
                        }
                    },
                    credits: {
                        enabled: false
                    },
                    exporting: {
                        enabled: false
                    },
                    series: []
                });
                
                var c1 = toArrayData(ch1, 'chart1');
                if (c1 && c1.length > 0) {
                    for (i = 0; i < c1.length; i++) {
                        var arr = c1[i].data;
                        if (arr.length == 2) {
                            var name = arr[0];
                            var dt = arr[1];

                            shy_chart1_Obj.addSeries({
                                name: name,
                                data: dt
                            }, true);

                            shy_chart1_Obj.yAxis[0].addPlotLine(c1[i].plotBand)
                        }
                    }
                    shy_chart1_Obj.redraw();
                }
            }
            
            //异常心电柱状图
            if ($('#shy_chart2').length > 0) {
                shy_chart2_Obj = new Highcharts.Chart({
                    chart: {
                        height: 400,
                        width: 500,
                        renderTo: 'shy_chart2',
                        type: 'column', //显示类型 
                        spacingBottom: 30
                    },
                    title: {
                        text: '异常心电柱状图', //图表的标题
                        style: {
                            fontWeight: 'bold'
                        }
                    },
                    legend: {
                        layout: 'vertical',
                        align: 'right',
                        verticalAlign: 'top',
                        x: 100,
                        y: 30,
                        floating: true,
                        backgroundColor: '#FFFFFF',
                        borderWidth: 1
                    },
                    credits: {
                        enabled: false,
                    },
                    exporting: {
                        enabled: false,
                    },
                    xAxis: {
                        type: 'category',
                        labels: {
                            rotation: -50,
                            style: {
                                fontWeight: 'bold',
                                color: '#000000'
                            }
                        }
                    },
                    yAxis: {
                        tickInterval: 1,
                        lineWidth: 1,
                        tickWidth: 1,
                        title: {
                            text: '单位(次数)',
                        },
                        min: 0
                    },
                    series: [{
                        name: '次数',
                        data: [],
                        dataLabels: {
                            enabled: true,
                            style: {
                                fontSize: '13px',
                                fontFamily: 'Verdana, sans-serif',
                                textShadow: '0 0 3px black'
                            }
                        }
                    }]
                });
                
                var c2 = toArrayData(ch2, 'chart2');
                if (c2 && c2.length == 2) {
                	shy_chart2_Obj.xAxis[0].setCategories(c2[0]);
                	shy_chart2_Obj.series[0].setData(c2[1]);
                }
            }
            
          //脉搏分布图
            if ($('#shy_chart4').length > 0) {
                var chartdt = toArrayData(obj.chart3);
                shy_chart4_Obj = new Highcharts.Chart({
                    chart: {
                        width: 500,
                        height: 400,
                        type: 'scatter',
                        zoomType: 'xy',
                        plotBackgroundColor: null,
                        plotBorderWidth: null,
                        plotShadow: false,
                        renderTo: 'shy_chart4',
                        marginLeft: 90
                    },
                    title: {
                        text: '24小时脉搏指标分布图' //标题
                    },
                    subtitle: {
                        text: ' ' //副标题
                    },
                    xAxis: {
                        title: {
                            enabled: true,
                            text: '时间' //X轴单位
                        },
                        tickInterval: 6,
                        max: 23,
                        min: 0,
                        startOnTick: true,
                        endOnTick: true,
                        showLastLabel: true
                    },
                    tooltip: {
                        formatter: function () {
                            return '<b>'+this.series.name+'</b><br>' + this.x.toFixed(2).replace('.', ':') +
                                ',' + this.y + '</b>';
                        }
                    },
                    yAxis: {
                        title: {
                            text: ' ' //Y轴单位
                        },
                        gridLineWidth: 0,
                        tickInterval: 100,
                        lineWidth: 1,
                        labels: {
                            enabled: false
                        },
                        min: 0,
                        max: 1200,
                        startOnTick: true,
                        endOnTick: true,
                        showLastLabel: true,
                    },
                    legend: {
                        enabled: false
                    },
                    plotOptions: {
                        scatter: {
                            marker: {
                                radius: 3,
                                states: {
                                    hover: {
                                        enabled: true,
                                        lineColor: 'rgb(100,100,100)'
                                    }
                                }
                            },
                            states: {
                                hover: {
                                    marker: {
                                        enabled: false
                                    }
                                }
                            },
                        }
                    },
                    credits: {
                        enabled: false
                    },
                    exporting: {
                        enabled: false
                    },
                    series: []
                });
                
                var c3 = toArrayData(ch3, 'chart3');
                if (c3 && c3.length > 0) {
                    for (i = 0; i < c3.length; i++) {
                        var arr = c3[i].data;
                        if (arr.length == 2) {
                            var name = arr[0];
                            var dt = arr[1];
                            
                            shy_chart4_Obj.addSeries({
                                name: name,
                                data: dt
                            }, true);

                            shy_chart4_Obj.yAxis[0].addPlotLine(c3[i].plotBand)
                        }
                    }
                    shy_chart4_Obj.redraw();
                }
            }
            
          //异常脉搏指标柱状图
            if ($('#shy_chart5').length > 0) {
                shy_chart5_Obj = new Highcharts.Chart({
                    chart: {
                        width: 500,
                        height: 400,
                        renderTo: 'shy_chart5',
                        type: 'column', //显示类型 
                        spacingBottom: 30
                    },
                    title: {
                        text: '异常脉搏指标柱状图', //图表的标题
                        // y: 20,
                        // verticalAlign: 'top',
                        style: {
                            // fontSize: '13px',
                            fontWeight: 'bold'
                        }
                    },
                    legend: {
                        enabled: false,
                        layout: 'vertical',
                        align: 'left',
                        verticalAlign: 'top',
                        x: 100,
                        y: 30,
                        floating: true,
                        backgroundColor: '#FFFFFF',
                        borderWidth: 1
                    },
                    credits: {
                        enabled: false,
                    },
                    exporting: {
                        enabled: false,
                    },
                    xAxis: {
                        type: 'category',
                        labels: {
                            rotation: -50,
                            style: {
                                fontWeight: 'bold',
                                color: '#000000'
                            }
                        }
                    },
                    yAxis: {
                        tickInterval: 1,
                        lineWidth: 1,
                        tickWidth: 1,
                        title: {
                            text: '单位(次数)'
                        },
                        min: 0
                    },
                    series: [{
                        name: "次数",
                        data: [],
                        dataLabels: {
                            enabled: true,
                            style: {
                                fontSize: '13px',
                                fontFamily: 'Verdana, sans-serif',
                                textShadow: '0 0 3px black'
                            }
                        }
                    }]
                });
                
                var c4 = toArrayData(ch4, 'chart4');
                if (c4 && c4.length == 2) {
                	shy_chart5_Obj.xAxis[0].setCategories(c4[0]);
                	shy_chart5_Obj.series[0].setData(c4[1]);
                }
            }
            
          //脉搏指标趋势图
          if (ch5.pulseTreChart.length > 0) {
            $(ch5.pulseTreChart)
                .each(
                    function(i, e) {
                        var dome = $("#shy_chart6_box");
                        dome
                            .append('<div class="imgholder m-10" style="overflow:hidden;">');
                        dome
                            .append('<label class="fr" for="shy_chart6_' + i + '_cb"> <input id="shy_chart6_' + i + '_cb" name="charts" value="shy_chart6" cindex= ' + i + '  type="checkbox" checked="checked" />打印</label>');
                        dome
                            .append('<div id="shy_chart6_' + i + '" style="height: 300px;"></div></div>');
                        shy_chart6_List
                            .push(createMBChart(
                                "shy_chart6_" + i,
                                e));
                    });
            }
        });
}

//打印
function exportWord() {
    var imgList = [];
    var obj, shy_obj = {
            "shy_chart3": false,
            "svg": []
        },
        shy_chart6_obj = {
            'shy_chart6': false,
            "svg": []
        };
    $("input[name='charts']:checkbox:checked").each(
        function(index, element) {
            obj = undefined;
            switch (element.value) {
                case "shy_tab1":
                    obj = {
                        "shy_tab1": true
                    }
                    break;
                case "shy_tab2":
                    obj = {
                        "shy_tab2": true
                    }
                    break;
                case "shy_tab3":
                    obj = {
                        "shy_tab3": true
                    }
                    break;
                case "shy_chart1":
                    obj = {
                        "shy_chart1": true,
                        "svg": [shy_chart1_Obj.getSVG()]
                    }
                    break;
                case "shy_chart2":
                    obj = {
                        "shy_chart2": true,
                        "svg": [shy_chart2_Obj.getSVG()]
                    }
                    break;
                case "shy_chart3":
                    shy_obj.shy_chart3 = true;
                    shy_obj.svg
                        .push(shy_chart3_List[$(element).attr("cindex")])
                    break;
                case "shy_chart4":
                    obj = {
                        "shy_chart4": true,
                        "svg": [shy_chart4_Obj.getSVG()]
                    }
                    break;
                case "shy_chart5":
                    obj = {
                        "shy_chart5": true,
                        "svg": [shy_chart5_Obj.getSVG()]
                    }
                    break;
                case "shy_chart6":
                    shy_chart6_obj.shy_chart6 = true;
                    shy_chart6_obj.svg.push(shy_chart6_List[$(element).attr(
                        "cindex")]);
                    break;
            }
            if (obj) {
                imgList.push(obj);
            }

        });
    if (shy_obj.shy_chart3) {
        imgList.push(shy_obj);
    }
    if (shy_chart6_obj.shy_chart6) {
        imgList.push(shy_chart6_obj);
    }
    var url = "../electrocardioPulse/getReportSVGData";
    $.ajax({
        url: url,
        type: "post",
        data: {
            jsonStr: JSON.stringify(imgList)
        },
        success: function(data) {
        	if(data == "1"){
        		exportWordMethod();
        	}
        }
    });
}

