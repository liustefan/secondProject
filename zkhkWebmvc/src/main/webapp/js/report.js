Highcharts.setOptions({ global: { useUTC: false } });

//24小时异常心电分布图
$(function() {
    $('#oecg').highcharts({
        chart: {
            type: 'scatter',
            zoomType: 'xy'
        },
        title: {
            text: '24小时异常心电分布图'
        },
        xAxis: {
            title: {
                enabled: true,
                text: '时间(h)'
            },
            startOnTick: true,
            endOnTick: true,
            showLastLabel: true
        },
        yAxis: {
            title: {
                text: '异常项'
            }
        },
        credits: {
            enabled: false
                // 禁用版权信息
        },
        legend: {
            layout: 'vertical',
            align: 'left',
            verticalAlign: 'top',
            x: 100,
            y: 70,
            floating: true,
            backgroundColor: '#FFFFFF',
            borderWidth: 1
        },
        plotOptions: {
            scatter: {
                marker: {
                    radius: 5,
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
                tooltip: {
                    headerFormat: '<b>{series.name}</b><br>',
                    pointFormat: '{point.x} cm, {point.y} kg'
                }
            }
        },
        series: [{
            name: 'Female',
            color: 'rgba(223, 83, 83, .5)',
            data: [
                [161.2, 51.6],
                [167.5, 59.0],
                [159.5, 49.2],
                [157.0, 63.0],
                [155.8, 53.6],
                [170.0, 59.0],
                [159.1, 47.6],
                [166.0, 69.8],
                [176.2, 66.8],
                [160.2, 75.2],
                [172.5, 55.2],
                [170.9, 54.2],
                [172.9, 62.5],
                [153.4, 42.0],
                [160.0, 50.0],
                [147.2, 49.8],
                [168.2, 49.2],
                [175.0, 73.2],
                [157.0, 47.8],
                [167.6, 68.8]
            ]
        }, {
            name: 'Male',
            color: 'rgba(119, 152, 191, .5)',
            data: [
                [174.0, 65.6],
                [175.3, 71.8],
                [193.5, 80.7],
                [186.5, 72.6],
                [187.2, 78.8],
                [181.5, 74.8],
                [184.0, 86.4],
                [184.5, 78.4],
                [175.0, 62.0],
                [184.0, 81.6],
                [180.0, 76.6],
                [177.8, 83.6],
                [192.0, 90.0],
                [176.0, 74.6],
                [174.0, 71.0],
                [184.0, 79.6],
                [192.7, 93.8],
                [171.5, 70.0],
                [173.0, 72.4],
                [176.0, 85.9]
            ]
        }]
    });
});

//24小时脉搏指标分布图
$(function() {
    $('#oppg').highcharts({
        chart: {
            type: 'scatter',
            zoomType: 'xy'
        },
        title: {
            text: '24小时脉搏指标分布图'
        },
        xAxis: {
            title: {
                enabled: true,
                text: '时间(h)'
            },
            startOnTick: true,
            endOnTick: true,
            showLastLabel: true
        },
        yAxis: {
            title: {
                text: '异常项'
            }
        },
        credits: {
            enabled: false
                // 禁用版权信息
        },
        legend: {
            layout: 'vertical',
            align: 'left',
            verticalAlign: 'top',
            x: 100,
            y: 70,
            floating: true,
            backgroundColor: '#FFFFFF',
            borderWidth: 1
        },
        plotOptions: {
            scatter: {
                marker: {
                    radius: 5,
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
                tooltip: {
                    headerFormat: '<b>{series.name}</b><br>',
                    pointFormat: '{point.x} cm, {point.y} kg'
                }
            }
        },
        series: [{
            name: 'Female',
            color: 'rgba(223, 83, 83, .5)',
            data: [
                [161.2, 51.6],
                [167.5, 59.0],
                [159.5, 49.2],
                [157.0, 63.0],
                [155.8, 53.6],
                [170.0, 59.0],
                [159.1, 47.6],
                [166.0, 69.8],
                [176.2, 66.8],
                [160.2, 75.2],
                [172.5, 55.2],
                [170.9, 54.2],
                [172.9, 62.5],
                [153.4, 42.0],
                [160.0, 50.0],
                [147.2, 49.8],
                [168.2, 49.2],
                [175.0, 73.2],
                [157.0, 47.8],
                [167.6, 68.8]
            ]
        }, {
            name: 'Male',
            color: 'rgba(119, 152, 191, .5)',
            data: [
                [174.0, 65.6],
                [175.3, 71.8],
                [193.5, 80.7],
                [186.5, 72.6],
                [187.2, 78.8],
                [181.5, 74.8],
                [184.0, 86.4],
                [184.5, 78.4],
                [175.0, 62.0],
                [184.0, 81.6],
                [180.0, 76.6],
                [177.8, 83.6],
                [192.0, 90.0],
                [176.0, 74.6],
                [174.0, 71.0],
                [184.0, 79.6],
                [192.7, 93.8],
                [171.5, 70.0],
                [173.0, 72.4],
                [176.0, 85.9]
            ]
        }]
    });
});

//异常心电柱状图
$(function() {
    $('#leftimgorder').highcharts({
        chart: {
            type: 'column',
            margin: [50, 50, 100, 80]
        },
        title: {
            text: '异常心电柱状图'
        },
        xAxis: {
            gridLineWidth: 1,
            lineColor: '#000',
            tickColor: '#000',
            categories: ['二联律', '三联律', '室性早搏', '心动过缓', '心律不齐', '漏搏',
                '插入性室早搏', '心动过速', '阵发性心动过速', '宽搏', '停搏', '房性早搏'
            ],
            labels: {
                rotation: -45,
                align: 'right',
                style: {
                    fontSize: '13px',
                    fontFamily: 'Verdana, sans-serif'
                }
            }
        },
        yAxis: {
            minorTickInterval: 'auto',
            lineColor: '#000',
            lineWidth: 1,
            tickWidth: 1,
            tickColor: '#000',
            min: 0,
            title: {
                text: '次数'
            }
        },
        legend: {
            enabled: false
        },
        credits: {
            enabled: false
                // 禁用版权信息
        },
        tooltip: {
            pointFormat: '<b>{point.y:1f} 次</b>',
        },
        series: [{
            name: 'Population',
            data: [20, 59, 10, 3, 1, 2, 5, 10, 15, 36, 55, 14],
            dataLabels: {
                enabled: true,
                rotation: -90,
                color: '#FFFFFF',
                align: 'right',
                x: 4,
                y: 10,
                style: {
                    fontSize: '13px',
                    fontFamily: 'Verdana, sans-serif',
                    textShadow: '0 0 3px black'
                }
            }
        }],
    });
});

//异常脉搏指标柱状图
$(function() {
    $('#rightimgorder').highcharts({
        chart: {
            type: 'column',
            margin: [50, 50, 100, 80]
        },
        title: {
            text: '异常脉搏指标柱状图'
        },
        xAxis: {
            gridLineWidth: 1,
            lineColor: '#000',
            tickColor: '#000',
            categories: ['平均脉率PR', '血氧饱和度SO', '平均每分射血量CO',
                '心脏每搏射血量SV', '心指数CI', '心搏指数SPI', '波形特征量K',
                '外周阻力TPR', '血管顺应度AC', '平均动脉压PM', '血液黏度V',
                '血管硬化指数SI'
            ],
            labels: {
                rotation: -45,
                align: 'right',
                style: {
                    fontSize: '13px',
                    fontFamily: 'Verdana, sans-serif'
                }
            }
        },
        yAxis: {
            minorTickInterval: 'auto',
            lineColor: '#000',
            lineWidth: 1,
            tickWidth: 1,
            tickColor: '#000',
            min: 0,
            title: {
                text: '次数'
            }
        },
        legend: {
            enabled: false
        },
        credits: {
            enabled: false
                // 禁用版权信息
        },
        tooltip: {
            pointFormat: '<b>{point.y:1f} 次</b>',
        },
        series: [{
            name: 'Population',
            data: [10, 39, 50, 30, 1, 26, 53, 70, 50, 36, 25, 14],
            dataLabels: {
                enabled: true,
                rotation: -90,
                color: '#FFFFFF',
                align: 'right',
                x: 4,
                y: 10,
                style: {
                    fontSize: '13px',
                    fontFamily: 'Verdana, sans-serif',
                    textShadow: '0 0 3px black'
                }
            }
        }],
    });
});

//血糖所有测量数据中的血糖趋势图
$(function() {
	if($("#xuetang").length <= 0) {
		return;
	}
    var ChartData = getData(result);
    var chart = new Highcharts.Chart({
        chart: {
            type: 'spline',
            renderTo: 'xuetang',
            zoomType: '',
            marginRight: 25
        },
        colors: ['#ffc000','#ff0000','#c00000','#00b050'],
        title: {
            text: '血糖趋势图',
            x: -20
        },
        xAxis: {
            title: {
                text: '日期',
                align: 'high'
            },
            type: 'datetime',
            labels: {
                step: 1,
                enabled: true,
                format: '{value:%m-%d}'
            },
            startOnTick: true,
            endOnTick: true,
            showLastLabel: true,
        },
        yAxis: {
            title: {
                text: '血糖值（mmol/L）',
                align: 'high'
            },
            min: 0,
            max: 26,
            tickInterval: 2, // 刻度
            gridLineWidth: 0,
            lineWidth: 1,
            tickWidth: 1,
            plotLines: [{
                label: {
                    text: '4.4',
                    y: 5,
                    textAlign: 'right',
                    style: {
                        color: 'red',
                        fontSize: '1em',
                        fontFamily: 'Microsoft YaHei'
                    }
                },
                color: 'red', //线的颜色，定义为红色
                dashStyle: 'Dash',
                value: 4.4, //定义在那个值上显示标示线，这里是在x轴上刻度为3的值处垂直化一条线
                width: 1
                    //标示线的宽度，2px
            }, {
                label: {
                    text: '7.8',
                    y: 5,
                    textAlign: 'right',
                    style: {
                        color: 'red',
                        fontSize: '1em',
                        fontFamily: 'Microsoft YaHei'
                    }
                },
                color: 'red', //线的颜色，定义为红色
                dashStyle: 'Dash',
                value: 7.8, //定义在那个值上显示标示线，这里是在x轴上刻度为3的值处垂直化一条线
                width: 1
                    //标示线的宽度，2px
            }, {
                label: {
                    text: '3.9',
                    align: 'right',
                    x: 25,
                    y: 5,
                    style: {
                        color: '#82e3e5',
                        fontSize: '1em',
                        fontFamily: 'Microsoft YaHei'
                    }
                },
                color: '#82e3e5', //线的颜色，定义为红色
                dashStyle: 'Dash', //默认值，这里定义为实线
                value: 3.9, //定义在那个值上显示标示线，这里是在x轴上刻度为3的值处垂直化一条线
                width: 1
                    //标示线的宽度，2px
            }, {
                label: {
                    text: '6.1',
                    align: 'right',
                    x: 25,
                    y: 5,
                    style: {
                        color: '#82e3e5',
                        fontSize: '1em',
                        fontFamily: 'Microsoft YaHei'
                    }
                },
                color: '#82e3e5', //线的颜色，定义为红色
                dashStyle: 'Dash', //默认值，这里定义为实线
                value: 6.1, //定义在那个值上显示标示线，这里是在x轴上刻度为3的值处垂直化一条线
                width: 1
                    //标示线的宽度，2px
            }]
        },
        credits: {
            enabled: false
                // 禁用版权信息
        },
        tooltip: {
            formatter: function() {
                return '<b>' + this.series.name + '</b><br>' + Highcharts.dateFormat('%m-%d', this.x) + '（月-日）: ' + this.y + '（mmol/L）';
            }
        },
        exporting: {
            enabled: false,
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'top',
            floating: true,
            borderWidth: 1
        },
        series: [{
            name: '随机',
            data: [],
            id: '4'
        }, {
            name: '空腹',
            data: [],
            id: '1'	
        }, {
            name: '餐后',
            data: [],
            id: '3'
        }, {
            name: '餐前',
            data: [],
            id: '2'
        }]
    });

    if (ChartData.kongfu.length > 0) {
    		chart.get('1').setData(ChartData.kongfu);
    } else {
        // chart.get('1').remove();
    }

    if (ChartData.beforeDinner.length > 0) {
    		chart.get('2').setData(ChartData.beforeDinner);
    } else {
        // chart.get('2').remove();
    }

    if (ChartData.afterDinner.length > 0) {
    		chart.get('3').setData(ChartData.afterDinner);
    } else {
        // chart.get('3').remove();
    }

    if (ChartData.random.length > 0) {
    		chart.get('4').setData(ChartData.random);
    } else {
        // chart.get('4').remove();
    }
});

function getData(obj) {
    var returnData = {
    		kongfu: [],
    		beforeDinner: [],
    		afterDinner: [],
    		random: []
    };
    returnData.kongfu = CoverData(obj.kongfu);
    returnData.beforeDinner = CoverData(obj.beforeDinner);
    returnData.afterDinner = CoverData(obj.afterDinner);
    returnData.random = CoverData(obj.random);
    return returnData;

}

function CoverData(data) {
    var returnObj = [];
    for (var i in data)
        returnObj.push([data[i].time || 0, data[i].value || 0]);

    return returnObj;
}
