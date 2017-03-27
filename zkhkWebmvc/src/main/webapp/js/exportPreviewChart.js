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
                return this.name;
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


function toArrayData(obj, flag) {
    var data = [];
    var result = [];

    if (flag == 'pie1') {
        if (obj && obj.length > 0) {
            for (i = 0; i < obj.length; i++) {
                var o = obj[i];
                if (o) {
                    for (var key in o) {
                        var kv = [key, o[key]];
                        data.push(kv);
                    }
                }
            }
        }
        return data;
    } else if (flag == 'pie2') {
        if (obj) {
            for (var key in obj) {
                var os = obj[key];
                for (var k in os) {
                    var kv = [k, os[k]];
                    data.push(kv);
                }
            }
        }
        return data;
    } else if (flag == 'bar4') {
        if (obj && obj.length > 0) {
            var c = [];
            var d = [];
            for (i = 0; i < obj.length; i++) {
                var o = obj[i];
                if (o) {
                    for (var key in o) {
                        c.push(key);
                        d.push(o[key]);
                    }
                }
            }
            data.push(c);
            data.push(d);
        }
        return data;
    } else if (flag == 'scot3') {
        if (obj && obj.length > 0) {
            for (i = 0; i < obj.length; i++) {
                var o = obj[i];
                if (o) {
                    for (var key in o) {
                        var kv = [key - 0, o[key]];
                        data.push(kv);
                    }
                }
            }
        }
        return data;
    }else if (flag == 'xtchart1') {
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
        return data;
    } else if (flag == 'xtchart2') {
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
        return data;
    } else if (flag == 'xtchart3') {
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
        return data;
    } else if (flag == 'xtchart4') {
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
        return data;
    }else if (flag == 'chart1') {
        if (obj) {
            var min = 0;

            for (var key in obj) {
                var arr = obj[key];
                var d = [];
                var plotBand = {};

                if (arr && arr.length > 0) {
                    var lb = [];


                    for (i = 0; i < arr.length; i++) {
                        var o = arr[i];
                        if (o) {
                            for (var k in o) {
                                d.push([+k, Math.floor(min + Math.random() * 100)]);
                            }
                            plotBand = { // mark the weekend
                                color: 'red',
                                width: 1,
                                value: min + 100,
                                label: {
                                    text: key,
                                    textAlign: 'right',
                                    x: -5,
                                    y: 20
                                }
                            };

                            
                        } else {
                            d.push(null);
                        }

                    }
                    lb = [key, d];

                } else {
                    lb = [key, null];
                }

                result.push({
                    data: lb,
                    plotBand: plotBand
                });
                min += 100;
            }
        }

        return result;
    } else if (flag == 'chart2') {
        if (obj) {
            var c = [];
            var d = [];
            for (var key in obj) {
                c.push(key);
                d.push(obj[key]);
            }
            data.push(c);
            data.push(d);
        }
    } else if (flag == 'chart3') {
        if (obj) {
            var min = 0;

            for (var key in obj) {
                var arr = obj[key];
                var d = [];
                var plotBand = {};

                if (arr && arr.length > 0) {
                    var lb = [];

                    for (i = 0; i < arr.length; i++) {
                        var o = arr[i];
                        if (o) {
                            for (var k in o) {
                                d.push([+k, Math.floor(min + Math.random() * 100)]);
                            }
                            plotBand = {
                                color: 'red',
                                width: 1,
                                value: min + 100,
                                label: {
                                    text: key,
                                    textAlign: 'right',
                                    x: -5,
                                    y: 18
                                }
                            };

                            
                        } else {
                            d.push(null);
                        }

                    }
                    lb = [key, d];

                } else {
                    lb = [key, null];
                }

                result.push({
                    data: lb,
                    plotBand: plotBand
                });
                min += 100;
            }
        }
        return result;
    } else if (flag == 'chart4') {
        if (obj) {
            var c = [];
            var d = [];
            for (var key in obj) {
                c.push(key);
                d.push(obj[key]);
            }
            data.push(c);
            data.push(d);
        }
    }
    return data;
}

function getJson(IsXY, IsXT, IsSHY, IsXD) {
    // 选项代码 1：血压        2：血糖        3：三合一        4：心电
    var url = "../singleReport/singleMeasueChart";
    
    if (IsXY) {
        $.getJSON(
                url, {
                    memberid: memberid,
                    reportNo: id_1,
                    funId: 1
                },
                function(obj) {
                    // 血压趋势图   
                    if ($('#xy_chart1_0').length > 0) {
                        xy_chart1_0_Obj = new Highcharts.Chart({
                            chart: {
                                width: 1000,
                                height: 350,
                                renderTo: 'xy_chart1_0',
                                type: 'line', //显示类型 
                                spacingBottom: 30
                            },
                            title: {
                                text: '所有血压趋势图', //图表的标题
                                y: 20,
                                verticalAlign: 'top',
                                style: {
                                    fontWeight: 'bold'
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
                            credits: {
                                enabled: false,
                            },
                            exporting: {
                                enabled: false,
                            },
                            xAxis: {
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
                                    dashStyle: 'Dash',
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
                                    dashStyle: 'Dash',
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
                                    dashStyle: 'Dash',
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
                                }],
                            },
                            series: [{
                                name: '收缩压',
                                data: []
                            }, {
                                name: '舒张压',
                                data: []
                            }, ]
                        });
                    }

                    if ($('#xy_chart1_1').length > 0) {
                        xy_chart1_1_Obj = new Highcharts.Chart({
                            chart: {
                                width: 1000,
                                height: 350,
                                renderTo: 'xy_chart1_1',
                                type: 'line', //显示类型 
                                spacingBottom: 30
                            },
                            title: {
                                text: '起床后血压趋势图', //图表的标题
                                y: 20,
                                verticalAlign: 'top',
                                style: {
                                    fontWeight: 'bold'
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
                            credits: {
                                enabled: false,
                            },
                            exporting: {
                                enabled: false,
                            },
                            xAxis: {
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
                                    dashStyle: 'Dash',
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
                                    dashStyle: 'Dash',
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
                                    dashStyle: 'Dash',
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
                                }],
                            },
                            series: [{
                                name: '收缩压',
                                data: []
                            }, {
                                name: '舒张压',
                                data: []
                            }, ]
                        });
                    }
                    if ($('#xy_chart1_2').length > 0) {
                        xy_chart1_2_Obj = new Highcharts.Chart({
                            chart: {
                                width: 1000,
                                height: 350,
                                renderTo: 'xy_chart1_2',
                                type: 'line', //显示类型 
                                spacingBottom: 30
                            },
                            title: {
                                text: '睡前血压趋势图', //图表的标题
                                y: 20,
                                verticalAlign: 'top',
                                style: {
                                    fontWeight: 'bold'
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
                            credits: {
                                enabled: false,
                            },
                            exporting: {
                                enabled: false,
                            },
                            xAxis: {
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
                                    dashStyle: 'Dash',
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
                                    dashStyle: 'Dash',
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
                                    dashStyle: 'Dash',
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
                                }],
                            },
                            series: [{
                                name: '收缩压',
                                data: []
                            }, {
                                name: '舒张压',
                                data: []
                            }, ]
                        });
                    }
                    //血压饼图
                    if ($('#xy_chart2_0').length > 0) {
                        xy_chart2_0_Obj = new Highcharts.Chart({
                            chart: {
                                //                    	width: 500,
                                height: 400,
                                renderTo: 'xy_chart2_0',
                                plotBackgroundColor: null,
                                plotBorderWidth: null,
                                plotShadow: false,
                                margin: [20, 130, 0, 0]
                            },
                            title: {
                                text: '血压饼图'
                            },
                            tooltip: {
                                pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
                            },
                            legend: {
                                layout: 'vertical',
                                verticalAlign: 'top',
                                align: 'right',
                                itemMarginTop: 5,
                            },
                            credits: {
                                enabled: false,
                            },
                            exporting: {
                                enabled: false,
                            },
                            plotOptions: {
                                pie: {
                                    size: 200,
                                    allowPointSelect: true,
                                    cursor: 'pointer',
                                    dataLabels: {
                                        enabled: true,
                                        color: '#000000',
                                        connectorColor: '#000000',
                                        //                                formatter: function() {
                                        //                                	return this.y *100 + '%'
                                        //                                }
                                        format: '{point.percentage:.1f}%',

                                    },
                                    showInLegend: true
                                }
                            },
                            series: [{
                                type: 'pie',
                                name: '血压异常分布',
                                data: []
                            }]
                        });
                    }
                    
                    xy_chart2_1_Obj = new Highcharts.Chart({
                        chart: {
                            plotBackgroundColor: null,
                            plotBorderWidth: null,
                            plotShadow: false,
                            renderTo: "xy_chart2_1"
                        },
                        title: {
                            text: '8点前',
                            x: -20 //center
                        },
                        tooltip: {
                            formatter: function() {
                                var s = this.point.name;
                                var value = Highcharts.numberFormat(this.point.percentage, 2) + ' %';
                                if (s == "正常") {
                                    s = '正常状态';
                                } else {
                                    s = '异常状态';
                                }
                                return this.point.name + '<br><b>' + s + '</b>: ' + Highcharts.numberFormat(this.percentage, 2) + ' %';
                            }
                        },
                        plotOptions: {
                            pie: {
                                allowPointSelect: true,
                                cursor: 'pointer',
                                dataLabels: {
                                    enabled: true,
                                    color: '#333',
                                    connectorColor: '#333',
                                    format: '<b>{point.name}</b>: {point.percentage:.2f} %'
                                },
                                showInLegend: true
                            }
                        },
                        legend: {
                            layout: 'vertical',
                            align: 'right',
                            verticalAlign: 'top',
                            x: 5,
                            y: 0,
                            borderWidth: 0,
                            labelFormatter: function() {
                                return this.name;
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
                            name: '异常状态',
                            data: []
                        }]
                    });

                    xy_chart2_2_Obj = new Highcharts.Chart({
                        chart: {
                            plotBackgroundColor: null,
                            plotBorderWidth: null,
                            plotShadow: false,
                            renderTo: "xy_chart2_2"
                        },
                        title: {
                            text: '8-12点',
                            x: -20 //center
                        },
                        tooltip: {
                            formatter: function() {
                                var s = this.point.name;
                                var value = Highcharts.numberFormat(this.point.percentage, 2) + ' %';
                                if (s == "正常") {
                                    s = '正常状态';
                                } else {
                                    s = '异常状态';
                                }
                                return this.point.name + '<br><b>' + s + '</b>: ' + Highcharts.numberFormat(this.percentage, 2) + ' %';
                            }
                        },
                        plotOptions: {
                            pie: {
                                allowPointSelect: true,
                                cursor: 'pointer',
                                dataLabels: {
                                    enabled: true,
                                    color: '#333',
                                    connectorColor: '#333',
                                    format: '<b>{point.name}</b>: {point.percentage:.2f} %'
                                },
                                showInLegend: true
                            }
                        },
                        legend: {
                            layout: 'vertical',
                            align: 'right',
                            verticalAlign: 'top',
                            x: 5,
                            y: 0,
                            borderWidth: 0,
                            labelFormatter: function() {
                                return this.name;
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
                            name: '异常状态',
                            data: []
                        }]
                    });

                    xy_chart2_3_Obj = new Highcharts.Chart({
                        chart: {
                            plotBackgroundColor: null,
                            plotBorderWidth: null,
                            plotShadow: false,
                            renderTo: "xy_chart2_3"
                        },
                        title: {
                            text: '12-18点',
                            x: -20 //center
                        },
                        tooltip: {
                            formatter: function() {
                                var s = this.point.name;
                                var value = Highcharts.numberFormat(this.point.percentage, 2) + ' %';
                                if (s == "正常") {
                                    s = '正常状态';
                                } else {
                                    s = '异常状态';
                                }
                                return this.point.name + '<br><b>' + s + '</b>: ' + Highcharts.numberFormat(this.percentage, 2) + ' %';
                            }
                        },
                        plotOptions: {
                            pie: {
                                allowPointSelect: true,
                                cursor: 'pointer',
                                dataLabels: {
                                    enabled: true,
                                    color: '#333',
                                    connectorColor: '#333',
                                    format: '<b>{point.name}</b>: {point.percentage:.2f} %'
                                },
                                showInLegend: true
                            }
                        },
                        legend: {
                            layout: 'vertical',
                            align: 'right',
                            verticalAlign: 'top',
                            x: 5,
                            y: 0,
                            borderWidth: 0,
                            labelFormatter: function() {
                                return this.name;
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
                            name: '异常状态',
                            data: []
                        }]
                    });
                    xy_chart2_4_Obj = new Highcharts.Chart({
                        chart: {
                            plotBackgroundColor: null,
                            plotBorderWidth: null,
                            plotShadow: false,
                            renderTo: "xy_chart2_4"
                        },
                        title: {
                            text: '18点以后',
                            x: -20 //center
                        },
                        tooltip: {
                            formatter: function() {
                                var s = this.point.name;
                                var value = Highcharts.numberFormat(this.point.percentage, 2) + ' %';
                                if (s == "正常") {
                                    s = '正常状态';
                                } else {
                                    s = '异常状态';
                                }
                                return this.point.name + '<br><b>' + s + '</b>: ' + Highcharts.numberFormat(this.percentage, 2) + ' %';
                            }
                        },
                        plotOptions: {
                            pie: {
                                allowPointSelect: true,
                                cursor: 'pointer',
                                dataLabels: {
                                    enabled: true,
                                    color: '#333',
                                    connectorColor: '#333',
                                    format: '<b>{point.name}</b>: {point.percentage:.2f} %'
                                },
                                showInLegend: true
                            }
                        },
                        legend: {
                            layout: 'vertical',
                            align: 'right',
                            verticalAlign: 'top',
                            x: 5,
                            y: 0,
                            borderWidth: 0,
                            labelFormatter: function() {
                                return this.name;
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
                            name: '异常状态',
                            data: []
                        }]
                    });
                    
                    //24小时血压分布图
                    if ($('#xy_chart3').length > 0) {
                        xy_chart3_Obj = new Highcharts.Chart({
                            chart: {
                                width: 500,
                                height: 400,
                                renderTo: 'xy_chart3',
                                type: 'scatter', //显示类型 
                                spacingBottom: 30
                            },
                            title: {
                                text: '24小时血压分布图', //图表的标题
                                style: {
                                    fontWeight: 'bold'
                                }
                            },
                            legend: {
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
                                min: 0,
                                max: 24,
                                endOnTick: true,
                                tickInterval: 6,
                                title: {
                                    text: '时间'
                                }
                            },
                            tooltip: {
                                formatter: function () {
                                    return '<b>'+this.series.name+'</b><br>' + this.x.toFixed(2).replace('.', ':') +
                                        ',' + this.y + '</b>';
                                }
                            },
                            yAxis: {
                                lineWidth: 1,
                                tickWidth: 1,
                                title: {
                                    text: '血压值（mmHg）'
                                },
                                min: 0,
                                max: 260,
                                tickInterval: 20, // 刻度
                                gridLineWidth: 0,	
                                plotLines: [{
                                    color: 'red',
                                    dashStyle: 'dash',
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
                                    color: 'red',
                                    dashStyle: 'dash',
                                    value: 90,
                                    width: 2,
                                    label: {
                                        text: '90',
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
                                    value: 60,
                                    width: 2,
                                    label: {
                                        text: '60',
                                        y: 5,
                                        textAlign: 'right',
                                        style: {
                                            color: 'blue',
                                            fontWeight: 'bold'
                                        }
                                    }
                                }],
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
                            series: []
                        });
                    }
                    //各级血压次数
                    if ($('#xy_chart4').length > 0) {
                        xy_chart4_Obj = new Highcharts.Chart({
                            chart: {
                                width: 500,
                                height: 400,
                                renderTo: 'xy_chart4',
                                type: 'column'
                            },
                            title: {
                                text: '各级血压次数',
                                style: {
                                    fontWeight: 'bold'
                                }
                            },
                            subtitle: {
                                text: '按次统计'
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
                            legend: {
                                enabled: false,
                            },
                            credits: {
                                enabled: false,
                            },
                            exporting: {
                                enabled: false,
                            },
                            yAxis: {
                                lineWidth: 1,
                                tickWidth: 1,
                                min: 0,
                                tickInterval: 1,
                                title: {
                                    text: '单位(次数)'
                                }
                            },
                            tooltip: {
                                enabled: false,
                            },
                            plotOptions: {
                                column: {
                                    pointPadding: 0.2,
                                    borderWidth: 0
                                }
                            },
                            series: [{
                                color: '#990000',
                                data: [],
                                keys: ['name', 'y'],
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
                    }
                    
                    var timeQ = obj[2].timeQ;
                    var scatSD = obj[3];
                    //------------------------------------
                    xy_chart2_0_Obj.series[0].setData(toArrayData(obj[0].pie1, 'pie1')); //饼图
                    //---------------------------------
                    var bar4 = toArrayData(obj[1].bar4, 'bar4'); //柱状
                    if (bar4 && bar4.length == 2) {
                    	xy_chart4_Obj.xAxis[0].setCategories(bar4[0]);
                    	xy_chart4_Obj.series[0].setData(bar4[1]);
                    }

                    var timeQ = obj[2].timeQ;
                    if (timeQ && timeQ.length == 4) {
                    	xy_chart2_1_Obj.series[0].setData(toArrayData(timeQ[0], 'pie2')); //饼图
                    	xy_chart2_2_Obj.series[0].setData(toArrayData(timeQ[1], 'pie2')); //饼图
                    	xy_chart2_3_Obj.series[0].setData(toArrayData(timeQ[2], 'pie2')); //饼图
                    	xy_chart2_4_Obj.series[0].setData(toArrayData(timeQ[3], 'pie2')); //饼图
                    }

                    //----------------------------
                    var scotS = toArrayData(obj[3].scotS, 'scot3');
                    var scotD = toArrayData(obj[3].scotD, 'scot3');
                    xy_chart3_Obj.addSeries({
                        name: '收缩压',
//                        color: 'rgba(223, 83, 83, .5)',
                        data: scotS
                    }, true);
                    xy_chart3_Obj.addSeries({
                        name: '舒张压',
//                        color: 'rgba(119, 152, 191, .5)',
                        data: scotD
                    }, true);
                    xy_chart3_Obj.redraw();
                    //---------------
                    if (obj[4] && obj[4].trend1) {
                    	xy_chart1_0_Obj.xAxis[0].setCategories(obj[4].trend1.time);
                    	xy_chart1_0_Obj.series[0].setData(obj[4].trend1.sbp);
                    	xy_chart1_0_Obj.series[1].setData(obj[4].trend1.dbp);
                    	xy_chart1_0_Obj.redraw();
                    }
                    if (obj[5] && obj[5].trend2) {
                    	xy_chart1_1_Obj.xAxis[0].setCategories(obj[5].trend2.time);
                    	xy_chart1_1_Obj.series[0].setData(obj[5].trend2.sbp);
                    	xy_chart1_1_Obj.series[1].setData(obj[5].trend2.dbp);
                    	xy_chart1_1_Obj.redraw();
                    }
                    if (obj[6] && obj[6].trend3) {
                    	xy_chart1_2_Obj.xAxis[0].setCategories(obj[6].trend3.time);
                    	xy_chart1_2_Obj.series[0].setData(obj[6].trend3.sbp);
                    	xy_chart1_2_Obj.series[1].setData(obj[6].trend3.dbp);
                    	xy_chart1_2_Obj.redraw();
                    }
                });
    }
    
    //血糖
    if (IsXT) {
        $.getJSON(url, {
            memberid: memberid,
            reportNo: id_2,
            funId: 2
        }, function(obj) {
        	if ($('#xt_chart2').length > 0) {
        		xt_chart2_Obj = new Highcharts.Chart({
        	        chart: {
        	            type: 'scatter',
        	            renderTo: 'xt_chart2',
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
        	}

        	 if ($('#xt_chart4').length > 0) {
        		 xt_chart4_Obj = new Highcharts.Chart({
         	        chart: {
         	            type: 'boxplot',
         	            renderTo: 'xt_chart4',
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
         	            			   '</em><br/><em>最大值:' + this.point.high +
         	            			   '</em><br/><em>上四分位:'+this.point.q1+
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
        	 }

        	  //血糖最值趋势图
                if ($('#xt_chart3').length > 0) {
                	xt_chart3_Obj = new Highcharts.Chart({
            	        chart: {
            	            type: 'line',
            	            plotBackgroundColor: null,
            	            plotBorderWidth: null,
            	            plotShadow: false,
            	            renderTo: 'xt_chart3',
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
                }
        	    
        	    
        	    if ($('#xt_chart1').length > 0) {
        	    	xt_chart1_Obj = new Highcharts.Chart({
             	        chart: {
             	            type: 'line',
             	            renderTo: 'xt_chart1',
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
//             	                enabled: true,
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
        	    }
        	    
                if (obj && obj.length > 0) {
                    var ch1 = obj[0]; // 图一数据
                    var ch2 = obj[1]; // 图二数据
                    var ch3 = obj[2]; // 图三数据
                    var ch4 = obj[3]; // 图四数据
                    var ch5 = obj[4]; // 图5数据
                    var arrlist = [];
                    var c1 = toArrayData(ch1, 'xtchart1');
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
                                xt_chart2_Obj.addSeries({
                                    name: name,
                                    data: dt
                                }, true);
                            }
                        }
                        xt_chart2_Obj.redraw();
                    }

                    var c2 = toArrayData(ch2, 'xtchart2');
                    if (c2 && c2.length == 2) {
                    	xt_chart4_Obj.xAxis[0].setCategories(c2[0]);
                    	xt_chart4_Obj.series[0].setData(c2[1]);
                    }

                    var c3 = toArrayData(ch3, 'xtchart3'); // n,c,d
                    if (c3 && c3.length == 3) {
                        var names = c3[1];
                        var ds = c3[2];

                        xt_chart3_Obj.xAxis[0].setCategories(c3[0]); // X
                        if (names && names.length > 0) {
                            for (i = 0; i < names.length; i++) {
                            	xt_chart3_Obj.addSeries({
                                    name: names[i],
                                    data: ds[i]
                                }, true);
                            }
                            xt_chart3_Obj.redraw();
                        }
                    }

                    var c4 = toArrayData(ch4, 'xtchart4');
                    if (c4 && c4.length > 0) {
                        var chart4_1, chart4_2, chart4_3, chart4_4, chart4_5, chart4_6, chart4_7, chart4_8, chart4_9;
                        for (i = 0; i < c4.length; i++) {
                            var ds = [
                                [c4[i][1], c4[i][2]],
                                [c4[i][3], c4[i][4]],
                                [c4[i][5], c4[i][6]]
                            ];
                            var render = 'xt_chart5_' + i;
                            if ((i + 1) == 1) {
                                chart4_1 = createSubPie(render,
                                    c4[i][0]);
                                chart4_1.series[0].setData(ds);
                                xt_chart5_List.push(chart4_1.getSVG());
                            } else if ((i + 1) == 2) {
                                chart4_2 = createSubPie(render,
                                    c4[i][0]);
                                chart4_2.series[0].setData(ds);
                                xt_chart5_List.push(chart4_2.getSVG());
                            } else if ((i + 1) == 3) {
                                chart4_3 = createSubPie(render,
                                    c4[i][0]);
                                chart4_3.series[0].setData(ds);
                                xt_chart5_List.push(chart4_3.getSVG());
                            } else if ((i + 1) == 4) {
                                chart4_4 = createSubPie(render,
                                    c4[i][0]);
                                chart4_4.series[0].setData(ds);
                                xt_chart5_List.push(chart4_4.getSVG());
                            } else if ((i + 1) == 5) {
                                chart4_5 = createSubPie(render,
                                    c4[i][0]);
                                chart4_5.series[0].setData(ds);
                                xt_chart5_List.push(chart4_5.getSVG());
                            } else if ((i + 1) == 6) {
                                chart4_6 = createSubPie(render,
                                    c4[i][0]);
                                chart4_6.series[0].setData(ds);
                                xt_chart5_List.push(chart4_6.getSVG());
                            } else if ((i + 1) == 7) {
                                chart4_7 = createSubPie(render,
                                    c4[i][0]);
                                chart4_7.series[0].setData(ds);
                                xt_chart5_List.push(chart4_7.getSVG());
                            } else if ((i + 1) == 8) {
                                chart4_8 = createSubPie(render,
                                    c4[i][0]);
                                chart4_8.series[0].setData(ds);
                                xt_chart5_List.push(chart4_8.getSVG());
                            } else if ((i + 1) == 9) {
                                chart4_9 = createSubPie(render,
                                    c4[i][0]);
                                chart4_9.series[0].setData(ds);
                                xt_chart5_List.push(chart4_9.getSVG());
                            }
                        }
                    }

                    if (ch5) {
                        var ChartData = ch5.trend;

                        if (ChartData.other.length > 0) {
                        	xt_chart1_Obj.get('1')
                                .setData(ChartData.other);
                        } 
                        if (ChartData.kongfu.length > 0) {
                        	xt_chart1_Obj.get('2').setData(
                                ChartData.kongfu);
                        }
                        
                        if (ChartData.afterBr.length > 0) {
                        	xt_chart1_Obj.get('3').setData(
                                ChartData.afterBr);
                        }

                        if (ChartData.bfLunch.length > 0) {
                        	xt_chart1_Obj.get('4').setData(
                                ChartData.bfLunch);
                        } 

                        if (ChartData.afLunch.length > 0) {
                        	xt_chart1_Obj.get('5').setData(
                                ChartData.afLunch);
                        }
                        
                        if (ChartData.bfAf.length > 0) {
                        	xt_chart1_Obj.get('6').setData(ChartData.bfAf);
                        }
                        
                        if (ChartData.afAf.length > 0) {
                        	xt_chart1_Obj.get('7').setData(ChartData.afAf);
                        }

                        if (ChartData.bfSleep.length > 0) {
                        	xt_chart1_Obj.get('8').setData(
                                ChartData.bfSleep);
                        } 
                        
                        if (ChartData.midNight.length > 0) {
                        	xt_chart1_Obj.get('9').setData(
                                ChartData.midNight);
                        } 
                    }
                }
        });
    }
    
    //三合一
    if (IsSHY) {
        $
            .getJSON(
                url, {
                    memberid: memberid,
                    reportNo: id_3,
                    funId: 3,
                    flag: true
                },
                function(obj) {
                	 var ch1 = obj[0]; //图一数据
                     var ch2 = obj[1]; //图二数据
                     var ch3 = obj[2]; //图三数据
                     var ch4 = obj[3]; //图四数据
                     var ch5 = obj[4];
                	
                    //24小时异常心电分布图
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
                                text: '24小时异常心电分布图' //标题
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
    
    //动态心电
    if (IsXD) {
        $.getJSON(url, {
            memberid: memberid,
            reportNo: id_4,
            funId: 4
        }, function(obj) {
        	var ch1 = obj[0]; //图一数据
            var ch2 = obj[1]; //图二数据
            
            //24小时异常心电分布图
            if ($('#xd_chart1').length > 0) {
                xd_chart1_Obj = new Highcharts.Chart({
                    chart: {
                        height: 400,
                        width: 500,
                        type: 'scatter',
                        plotBackgroundColor: null,
                        plotBorderWidth: null,
                        plotShadow: false,
                        renderTo: 'xd_chart1',
                        marginLeft: 80
                    },
                    title: {
                        text: '24小时异常心电分布图' //标题
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

                            xd_chart1_Obj.addSeries({
                                name: name,
                                data: dt
                            }, true);
                            xd_chart1_Obj.yAxis[0].addPlotLine(c1[i].plotBand)
                        }
                    }
                    xd_chart1_Obj.redraw();
                }
            }

            if ($('#xd_chart2').length > 0) {
                xd_chart2_Obj = new Highcharts.Chart({
                    chart: {
                        height: 400,
                        width: 500,
                        renderTo: 'xd_chart2',
                        type: 'column', //显示类型 
                        //                        spacingBottom: 30
                    },
                    title: {
                        text: '异常心电柱状图 ', //图表的标题
                        // y: 20,
                        // verticalAlign: 'top',
                        style: {
                            // fontSize: '13px',
                            fontWeight: 'bold'
                        }
                    },
                    legend: {
                        enabled: false,
                    },
                    credits: {
                        enabled: false,
                    },
                    exporting: {
                        enabled: false,
                    },
                    plotOptions: {
                        series: {
                            events: {
                                legendItemClick: false
                            }
                        },
                        column: {
                            dataLabels: {
                                enabled: false
                            }
                        }
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
                        min: 0,
                        tickInterval: 1,
                        lineWidth: 1,
                        tickWidth: 1,
                        title: {
                            text: '单位 (次数)',
                        }

                    },
                    series: [{
                        name: '次数',
                        data: obj.chart2 || [],
                        keys: ['name', 'y'],
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
                	xd_chart2_Obj.xAxis[0].setCategories(c2[0]);
                	xd_chart2_Obj.series[0].setData(c2[1]);
                }
            }
        });
    }
}

//打印
function exportWord(reportId, auditLevel, docSign) {
    var imgList = [];
    var obj, xd_obj = {
            "xd_chart3": false,
            "svg": []
        },
        shy_obj = {
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
                case "xy_tab1":
                    obj = {
                        "xy_tab1": true
                    }
                    break;
                case "xy_tab2":
                    obj = {
                        "xy_tab2": true
                    }
                    break;
                case "xy_chart1_0":
                    obj = {
                        "xy_chart1_0": true,
                        "svg": [xy_chart1_0_Obj.getSVG()]
                    }
                    break;
                case "xy_chart1_1":
                    obj = {
                        "xy_chart1_1": true,
                        "svg": [xy_chart1_1_Obj.getSVG()]
                    }
                    break;
                case "xy_chart1_2":
                    obj = {
                        "xy_chart1_2": true,
                        "svg": [xy_chart1_2_Obj.getSVG()]
                    }
                    break;
                case "xy_chart2":
                    obj = {
                        "xy_chart2": true,
                        "svg": [xy_chart2_0_Obj.getSVG(),
                            xy_chart2_1_Obj.getSVG(),
                            xy_chart2_2_Obj.getSVG(),
                            xy_chart2_3_Obj.getSVG(),
                            xy_chart2_4_Obj.getSVG()
                        ]
                    }
                    break;
                case "xy_chart3":
                    obj = {
                        "xy_chart3": true,
                        "svg": [xy_chart3_Obj.getSVG()]
                    }
                    break;
                case "xy_chart4":
                    obj = {
                        "xy_chart4": true,
                        "svg": [xy_chart4_Obj.getSVG()]
                    }
                    break;
                case "xt_tab1":
                    obj = {
                        "xt_tab1": true
                    }
                    break;
                case "xt_tab2":
                    obj = {
                        "xt_tab2": true
                    }
                    break;
                case "xt_chart1":
                    obj = {
                        "xt_chart1": true,
                        "svg": [xt_chart1_Obj.getSVG()]
                    }
                    break;
                case "xt_chart2":
                    obj = {
                        "xt_chart2": true,
                        "svg": [xt_chart2_Obj.getSVG()]
                    }
                    break;
                case "xt_chart3":
                    obj = {
                        "xt_chart3": true,
                        "svg": [xt_chart3_Obj.getSVG()]
                    }
                    break;
                case "xt_chart4":
                    obj = {
                        "xt_chart4": true,
                        "svg": [xt_chart4_Obj.getSVG()]
                    }
                    break;
                case "xt_chart5":
                    obj = {
                        "xt_chart5": true,
                        "svg": xt_chart5_List
                    }
                    break;
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
                case "xd_tab1":
                    obj = {
                        "xd_tab1": true
                    }
                    break;
                case "xd_tab2":
                    obj = {
                        "xd_tab2": true
                    }
                    break;
                case "xd_chart1":
                    obj = {
                        "xd_chart1": true,
                        "svg": [xd_chart1_Obj.getSVG()]
                    }
                    break;
                case "xd_chart2":
                    obj = {
                        "xd_chart2": true,
                        "svg": [xd_chart2_Obj.getSVG()]
                    }
                    break;
                case "xd_chart3":
                    xd_obj.xd_chart3 = true;
                    xd_obj.svg.push(xd_chart3_List[$(element).attr("cindex")]);
                    break;
            }
            if (obj) {
                imgList.push(obj);
            }

        });
    if (xd_obj.xd_chart3) {
        imgList.push(xd_obj);
    }
    if (shy_obj.shy_chart3) {
        imgList.push(shy_obj);
    }
    if (shy_chart6_obj.shy_chart6) {
        imgList.push(shy_chart6_obj);
    }
    var url = "../summaryReport/getReportSVGData";
    $.ajax({
        url: url,
        type: "post",
        data: {
            jsonStr: JSON.stringify(imgList)
        },
        success: function(data) {
        	if(data == "1"){
            window.location = "../summaryReport/exportReportWord?reportNo=" + reportId + "&auditLevel=" + auditLevel + "&docSign="+docSign;
        	}
        }
    });
}

