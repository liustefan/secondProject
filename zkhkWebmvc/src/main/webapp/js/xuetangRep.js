/*
 * 血糖测量页面 (singleObsrRep.jsp)
 */
Highcharts.setOptions({ global: { useUTC: false } });
//创建小图
function createSubPie(render, title) {
    var chart = new Highcharts.Chart({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            renderTo: render,
        },
        title: {
            text: title,
            x: -20
                // center
        },
        plotOptions: {
            pie: {
                allowPointSelect: false,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    color: '#333',
                    connectorColor: '#333',
                    connectorPadding: 0,
                    distance: 5,
                    format: '{point.name}:<b>{point.percentage:.2f}%</b>'
                },
                showInLegend: true
            }
        },
        tooltip: {
        		pointFormat: '{series.name}: <b>{point.percentage:.2f}%</b>'
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            floating: true,
            verticalAlign: 'top',
            x: 5,
            y: 0,
            borderWidth: 0,
            backgroundColor: 'rgba(0,0,0,0)',
            labelFormatter: function() {
                return this.name + '&nbsp';
            },
            useHTML: true
        },
        credits: {
            enabled: false
        },
        exporting: {
            enabled: false
        },
        series: [{
            type: 'pie',
            name: '占比',
            data: []
        }]

    });
    return chart;
}

$(function() {
    $("#btn")
        .toggle(
            function() {
                $(this)
                    .after(
                        "<div class='reason-box'><span>请填写退审原因</span><textarea name='approvalReason' rows='2' cols='50'/><br/><input type='button' class='btn-normal' id='reback' onclick='rebacklevel()' value='退审'/></div>");
                return false;
            },
            function() {
                $(this).next("div").remove();
                return false;
            });
    $("#return").click(function() {
        window.history.go(-1);
        return false;
    });

    var chartdivcss = {
        background: '#f3f3f3',
        /*
         * width: '1400px', margin: '10px 0 10px', padding: '5px 10px',
         */
        width: '100%',
        border: '1px solid #ddd',
        fontFamily: 'Microsoft YaHei',
        overflow: 'hidden'

    };
    $("#chart").css(chartdivcss);

    var partdivcss = {
        /*
         * width: '680px', margin: '10px 0 10px 10px', border: '1px solid #CCC',
         * display:'inline-block'
         */
        width: '47.7%',
        border: '1px solid #ddd',
        margin: '0.9%',
        float: 'left',
        background: '#fff',
        fontFamily: 'Microsoft YaHei',
        overflow: 'hidden'
    }
    $("#part1").css(partdivcss);
    $("#part2").css(partdivcss);

    // chart4_1
    var subchartcss = {
        width: '49%',
        margin: '0.1%',
        // border: '1px solid #CCC',
        fontFamily: 'Microsoft YaHei',
        display: 'inline-block'

    }
    $("#chart4_1").css(subchartcss);
    $("#chart4_2").css(subchartcss);
    $("#chart4_3").css(subchartcss);
    $("#chart4_4").css(subchartcss);
    $("#chart4_5").css(subchartcss);
    $("#chart4_6").css(subchartcss);
    $("#chart4_7").css(subchartcss);
    $("#chart4_8").css(subchartcss);
    $("#chart4_9").css(subchartcss);
    // --------------------------------------------------------------------------------------------------------

    var chart1 = new Highcharts.Chart({
        chart: {
            type: 'scatter',
            renderTo: 'chart1',
            showAxes: true,
            marginRight: 25
        },
        colors: ['#ffc000','#ff0000','#c00000','#00b050','#92d050','#0070c0','#00b0f0','#7030a0','#002060'],
        title: {
            text: '24小时血糖分布图' // 标题
        },
        subtitle: {
            text: ' ' // 副标题
        },
        xAxis: {
            title: {
                enabled: true,
                text: '时间' // X轴单位
            },
            tickInterval: 3,
            max: 24,
            min: 0,
            startOnTick: true,
            endOnTick: true,
            showLastLabel: true,

        },
        tooltip: {
            formatter: function () {
                return '<b>'+this.series.name+'</b><br>' + this.x.toFixed(2).replace('.', ':') +
                    ',' + this.y + '</b>';
            }
        },
        yAxis: {
            title: {
                text: '血糖值（mmol/L）' // Y轴单位
            },
            tickInterval: 2, // 刻度
            gridLineWidth: 0,
            lineWidth: 1,
            tickWidth: 1,
            max: 25,
            min: 0,
            plotLines: [{
                value: 11.1,
                dashStyle: 'Dash',
                color: 'red',
                width: 1,
                label: {
                    text: '11.1',
                    y: 5,
                    textAlign: 'right',
                    style: {
                        color: 'blue',
                        fontFamily: 'Microsoft YaHei'
                    }
                }
            }, {
                value: 7.8,
                dashStyle: 'Dash',
                color: 'red',
                width: 1,
                label: {
                    text: '7.8',
                    y: 5,
                    textAlign: 'right',
                    style: {
                        color: 'blue',
                        fontFamily: 'Microsoft YaHei'
                    }
                }
            }, {
                value: 7.0,
                dashStyle: 'Dash',
                color: 'red',
                width: 1,
                label: {
                    text: '7.0',
                    y: 5,
                    textAlign: 'right',
                    style: {
                        color: 'blue',
                        fontFamily: 'Microsoft YaHei'
                    }
                }
            }, {
                value: 3.9,
                dashStyle: 'Dash',
                color: 'red',
                width: 1,
                label: {
                    text: '3.9',
                    y: 5,
                    textAlign: 'right',
                    style: {
                        color: 'blue',
                        fontFamily: 'Microsoft YaHei'
                    }
                }
            }]
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'top',
            //            x: 15,
            //            y: 0,
            floating: true,
            backgroundColor: 'rgba(0,0,0,0)',
            borderWidth: 1
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
                }
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

    var chart2 = new Highcharts.Chart({
        chart: {
            type: 'boxplot',
            renderTo: 'chart2',
            marginRight: 25
        },
        title: {
            text: '血糖分布盒图' // 标题
        },
        legend: {
            enabled: false
        },
        xAxis: {
            categories: [],
            title: {
                text: '时间段'
            }
        },
        yAxis: {
            title: {
                text: '血糖值（mmol/L）' // Y轴单位
            },
            tickInterval: 2, // 刻度
            gridLineWidth: 0,
            lineWidth: 1,
            tickWidth: 1,
            max: 25,
            min: 0,
            plotLines: [{
                value: 11.1,
                dashStyle: 'Dash',
                color: 'red',
                width: 1,
                label: {
                    text: '11.1',
                    y: 5,
                    textAlign: 'right',
                    style: {
                        color: 'blue',
                        fontFamily: 'Microsoft YaHei'
                    }
                }
            }, {
                value: 7.8,
                dashStyle: 'Dash',
                color: 'red',
                width: 1,
                label: {
                    text: '7.8',
                    y: 5,
                    textAlign: 'right',
                    style: {
                        color: 'blue',
                        fontFamily: 'Microsoft YaHei'
                    }
                }
            }, {
                value: 7.0,
                dashStyle: 'Dash',
                color: 'red',
                width: 1,
                label: {
                    text: '7.0',
                    y: 5,
                    textAlign: 'right',
                    style: {
                        color: 'blue',
                        fontFamily: 'Microsoft YaHei'
                    }
                }
            }, {
                value: 3.9,
                dashStyle: 'Dash',
                color: 'red',
                width: 1,
                label: {
                    text: '3.9',
                    y: 5,
                    textAlign: 'right',
                    style: {
                        color: 'blue',
                        fontFamily: 'Microsoft YaHei'
                    }
                }
            }]
        },
        credits: {
            enabled: false
        },
        exporting: {
            enabled: false
        },
        tooltip: {
	        	formatter: function() {
	            		return '<em>时段:' +this.key +
            			   '</em><br/><em>最大值:' + this.point.q1 +
            			   '</em><br/><em>上四分位:'+this.point.high+
            			   '</em><br/><em>中位数:'+ this.point.median+
            			   '</em><br/><em>下四分位:' +this.point.low+
            			   '</em><br/><em>最小值:' + this.point.q3+
            			   '</em>';
        		}
        },
        series: [{
            name: '血糖值',
            data: [],
        }]
    });

    var chart3 = new Highcharts.Chart({
        chart: {
            type: 'line',
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            renderTo: 'chart3',
            marginRight: 25
        },
        title: {
            text: '血糖最值趋势图', // 标题
            x: -20
                // center
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'top',
            floating: true,
            borderWidth: 1
        },
        xAxis: {
            categories: [],
            lineWidth: 1,
            tickWidth: 1,
        },
        yAxis: {
            title: {
                text: '血糖值（mmol/L）' // Y轴单位
            },
            tickInterval: 2, // 刻度
            gridLineWidth: 0,
            lineWidth: 1,
            tickWidth: 1,
            max: 25,
            min: 0,
            plotLines: [{
                value: 11.1,
                dashStyle: 'Dash',
                color: 'red',
                width: 1,
                label: {
                    text: '11.1',
                    y: 5,
                    textAlign: 'right',
                    style: {
                        color: 'blue',
                        fontFamily: 'Microsoft YaHei'
                    }
                }
            }, {
                value: 7.8,
                dashStyle: 'Dash',
                color: 'red',
                width: 1,
                label: {
                    text: '7.8',
                    y: 5,
                    textAlign: 'right',
                    style: {
                        color: 'blue',
                        fontFamily: 'Microsoft YaHei'
                    }
                }
            }, {
                value: 7.0,
                dashStyle: 'Dash',
                color: 'red',
                width: 1,
                label: {
                    text: '7.0',
                    y: 5,
                    textAlign: 'right',
                    style: {
                        color: 'blue',
                        fontFamily: 'Microsoft YaHei'
                    }
                }
            }, {
                value: 3.9,
                dashStyle: 'Dash',
                color: 'red',
                width: 1,
                label: {
                    text: '3.9',
                    y: 5,
                    textAlign: 'right',
                    style: {
                        color: 'blue',
                        fontFamily: 'Microsoft YaHei'
                    }
                }
            }]
        },
        tooltip: {
            enabled: true
        },
        plotOptions: {
        		series: {
                marker: {
                    radius: 3
                }
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

    var chart5 = new Highcharts.Chart({
        chart: {
            type: 'line',
            renderTo: 'chart5',
            zoomType: '',
            marginRight: 25
        },
        colors: ['#ffc000','#ff0000','#c00000','#00b050','#92d050','#0070c0','#00b0f0','#7030a0','#002060'],
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
            startOnTick: true,
            endOnTick: true,
            labels: {
                step: 1,
//                enabled: true,
                format: '{value:%m-%d}'
            },
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
        plotOptions: {
            series: {
                marker: {
                    radius: 3
                }
            }
        },
        series: [{
            name: '其他时间',
            data: [],
            id: '1'
        }, {
            name: '早餐前',
            data: [],
            id: '2'
        }, {
            name: '早餐后2小时',
            data: [],
            id: '3'
        }, {
            name: '午餐前',
            data: [],
            id: '4'
        }, {
            name: '午餐后2小时',
            data: [],
            id: '5'
        }, {
            name: '晚餐前',
            data: [],
            id: '6'
        }, {
            name: '晚餐后2小时',
            data: [],
            id: '7'
        }, {
            name: '睡前',
            data: [],
            id: '8'
        }, {
            name: '夜间',
            data: [],
            id: '9'
        }]
    });

    // 读取图表数据
    $
        .post(
            "../bloodSugar/getBloodSugarChart", {
                memberid: memberid,
                obsrsJson: JSON.stringify(obsrsJson),
            },
            function(d) {
                if (d) {
                    var data = JSON.parse(d);
                    if (data && data.length > 0) {
                        var ch1 = data[0]; // 图一数据
                        var ch2 = data[1]; // 图二数据
                        var ch3 = data[2]; // 图三数据
                        var ch4 = data[3]; // 图四数据
                        var ch5 = data[4]; // 图5数据
                        var arrlist = [];
                        var c1 = toArrayData(ch1, 'chart1');

                        if (c1 && c1.length > 0) {
                            for (i = 0; i < c1.length; i++) {
                                var arr = c1[i];
                                if (arr.length == 2) {
                                    var name = arr[0];
                                    var dt = arr[1];
                                    arrlist.push({
                                        name: name,
                                        data: dt
                                    });
                                    chart1.addSeries({
                                        name: name,
                                        data: dt
                                    }, true);
                                }
                            }
                            // console.log(JSON.stringify(arrlist));
                            chart1.redraw();
                        }

                        // ----------------------------------
                        var c2 = toArrayData(ch2, 'chart2');
                        if (c2 && c2.length == 2) {
                            chart2.xAxis[0].setCategories(c2[0]);
                            chart2.series[0].setData(c2[1]);
                        }

                        // ----------------------------------
                        var c3 = toArrayData(ch3, 'chart3'); // n,c,d
                        if (c3 && c3.length == 3) {
                            var names = c3[1];
                            var ds = c3[2];

                            chart3.xAxis[0].setCategories(c3[0]); // X
                            // console.log(c3[0]);
                            if (names && names.length > 0) {
                                for (i = 0; i < names.length; i++) {
                                    chart3.addSeries({
                                        name: names[i],
                                        data: ds[i]
                                    }, true);
                                }
                                chart3.redraw();
                            }
                        }

                        // ----------------------------------
                        var c4 = toArrayData(ch4, 'chart4');
                        if (c4 && c4.length > 0) {
                            var chart4_1, chart4_2, chart4_3, chart4_4, chart4_5, chart4_6, chart4_7, chart4_8, chart4_9;
                            for (i = 0; i < c4.length; i++) {
                                var ds = [
                                    [c4[i][1], c4[i][2]],
                                    [c4[i][3], c4[i][4]],
                                    [c4[i][5], c4[i][6]]
                                ];
                                var render = 'chart4_' + (i + 1);
                                if ((i + 1) == 1) {
                                    chart4_1 = createSubPie(render,
                                        c4[i][0]);
                                    chart4_1.series[0].setData(ds);
                                } else if ((i + 1) == 2) {
                                    chart4_2 = createSubPie(render,
                                        c4[i][0]);
                                    chart4_2.series[0].setData(ds);
                                } else if ((i + 1) == 3) {
                                    chart4_3 = createSubPie(render,
                                        c4[i][0]);
                                    chart4_3.series[0].setData(ds);
                                } else if ((i + 1) == 4) {
                                    chart4_4 = createSubPie(render,
                                        c4[i][0]);
                                    chart4_4.series[0].setData(ds);
                                } else if ((i + 1) == 5) {
                                    chart4_5 = createSubPie(render,
                                        c4[i][0]);
                                    chart4_5.series[0].setData(ds);
                                } else if ((i + 1) == 6) {
                                    chart4_6 = createSubPie(render,
                                        c4[i][0]);
                                    chart4_6.series[0].setData(ds);
                                } else if ((i + 1) == 7) {
                                    chart4_7 = createSubPie(render,
                                        c4[i][0]);
                                    chart4_7.series[0].setData(ds);
                                } else if ((i + 1) == 8) {
                                    chart4_8 = createSubPie(render,
                                        c4[i][0]);
                                    chart4_8.series[0].setData(ds);
                                } else if ((i + 1) == 9) {
                                    chart4_9 = createSubPie(render,
                                        c4[i][0]);
                                    chart4_9.series[0].setData(ds);
                                }
                            }

                        }

                        // ----------------------------------
                        if (ch5) {
                            var ChartData = ch5.trend;
//                            console.log(JSON.stringify(ChartData));

                            if (ChartData.other.length > 0) {
                                chart5.get('1')
                                    .setData(ChartData.other);
                            } else {
                                // chart5.get('1').remove();
                            }

                            if (ChartData.kongfu.length > 0) {
                                chart5.get('2').setData(
                                    ChartData.kongfu);
                            } else {
                                // chart5.get('2').remove();
                            }

                            if (ChartData.afterBr.length > 0) {
                                chart5.get('3').setData(
                                    ChartData.afterBr);
                            } else {
                                // chart5.get('3').remove();
                            }

                            if (ChartData.bfLunch.length > 0) {
                                chart5.get('4').setData(
                                    ChartData.bfLunch);
                            } else {
                                // chart5.get('4').remove();
                            }

                            if (ChartData.afLunch.length > 0) {
                                chart5.get('5').setData(
                                    ChartData.afLunch);
                            } else {
                                // chart5.get('5').remove();
                            }

                            if (ChartData.bfAf.length > 0) {
                                chart5.get('6').setData(ChartData.bfAf);
                            } else {
                                // chart5.get('6').remove();
                            }

                            if (ChartData.afAf.length > 0) {
                                chart5.get('7').setData(ChartData.afAf);
                            } else {
                                // chart5.get('7').remove();
                            }

                            if (ChartData.bfSleep.length > 0) {
                                chart5.get('8').setData(
                                    ChartData.bfSleep);
                            } else {
                                // chart5.get('8').remove();
                            }

                            if (ChartData.midNight.length > 0) {
                                chart5.get('9').setData(
                                    ChartData.midNight);
                            } else {
                                // chart5.get('9').remove();
                            }
                        }

                        //                    end
                    }
                }
            });

});

function toArrayData(obj, flag) {
    var data = [];
    if (flag == 'chart1') {
        if (obj) {
            for (var key in obj) {
                var arr = obj[key];
                var d = [];
                if (arr && arr.length > 0) {
                    for (i = 0; i < arr.length; i++) {
                        var o = arr[i];
                        if (o) {
                            for (var k in o) {
                                var kv = [+k, o[k]]; // 把k转换成数字
                                d.push(kv);
                            }
                        } 
                        else {
                            var kv = [];
                            d.push(kv);
                        }
                    }
                    var lb = [key, d];
                    data.push(lb);
                }
                else {
                    var kv = [];
                    d.push(kv);

                    var lb = [key, d];
                    data.push(lb);
                }
            }
        }
    } else if (flag == 'chart2') {
        if (obj) {
            var c = [];
            var d = [];
            for (var key in obj) {
                c.push(key);
                var arr = obj[key];
                var sub = [];
                if (arr && arr.length > 0) {
                    for (i = 0; i < arr.length; i++) {
                        var o = arr[i];
                        if (o) {
                            for (var k in o) {
                                sub.push(o[k]);
                            }
                        }
                    }
                }
                d.push(sub);
            }
            data.push(c);
            data.push(d);
        }
    } else if (flag == 'chart3') {
        if (obj) {
            var n = []; // name
            var c = []; // X
            var d = [];
            var ac = true;
            for (var key in obj) {
                n.push(key);
                var ds = []; // Y
                var arr = obj[key];
                if (arr && arr.length > 0) {
                    for (var i = 0; i < arr.length; i++) {
                        var o = arr[i];
                        if (o) {
                            for (var k in o) {
                                if (ac) {
                                    c.push(k);
                                }
                                ds.push(o[k]);
                            }
                        }
                    }
                    d.push(ds);
                    ac = false;
                }
            }
            data.push(c);
            data.push(n);
            data.push(d);
        }
    } else if (flag == 'chart4') {
        if (obj) {
            for (var key in obj) {
                var sub = [];
                sub.push(key);

                var arr = obj[key];
                if (arr && arr.length > 0) {
                    for (i = 0; i < arr.length; i++) {
                        var o = arr[i];
                        if (o) {
                            for (var k in o) {
                                sub.push(k);
                                sub.push(o[k]);
                            }
                        }
                    }
                }
                data.push(sub);
            }
        }
    }

    return data;
}
