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
    }
}

function getJson() {
    var url = "../bloodPressure/getBloodPressChart";
    
        $.getJSON(
                url, {
                    osbpsJson: JSON.stringify(osbpsJson),
    				memberid: memberid
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
                    
                    //脉膊图
                    if ($('#xy_chart1_3').length > 0) {
                        xy_chart1_3_Obj = new Highcharts.Chart({
                            tooltip: {
                                formatter: function () {
                                    return '<b>' + this.series.name + '</b><br>' + this.x + '（月-日）: ' + this.y + '（bpm）';
                                }
                            },
                            title: {
                                text: '脉率趋势图',
                                x: -20  //center
                            },
                            
                            chart: {
                    			//type: 'line',
                    			renderTo: 'xy_chart1_3'
                    		},
                    		colors: ['#000000'],
                            xAxis: {
                                  categories: [],
                                  tickWidth: 1,
                              	tickPosition: 'inside',
                                  title: {
                                      text: '日期',
                                      align: 'high'
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
                          
                            yAxis: {
                                title: {
                                    text: ' ',
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
                                }],
                            },
                            series: [{
                                name: '脉率',
                                data: []
                            }]
                             
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

                    //---所有脉搏趋势图 
                    if (obj[7] && obj[7].pulseRate) {
                    	xy_chart1_3_Obj.xAxis[0].setCategories(obj[7].pulseRate.time);
                    	xy_chart1_3_Obj.series[0].setData(obj[7].pulseRate.pulseRate); 
                    	xy_chart1_3_Obj.redraw();
                    }
                    
                    
                    
                });
}

//打印
function exportWord() {
    var imgList = [];
    var obj, xd_obj = {
            "xd_chart3": false,
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
                    
                case "xy_chart1_3":
                    obj = {
                        "xy_chart1_3": true,
                        "svg": [xy_chart1_3_Obj.getSVG()]
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
            }
            if (obj) {
                imgList.push(obj);
            }

        });

    var url = "../bloodPressure/getReportSVGData";
    $.ajax({
        url: url,
        type: "post",
        data: {
            jsonStr: JSON.stringify(imgList)
        },
        success: function(data) {
        	if(data == "1"){
            window.location = "../bloodPressure/exportReportWord?osbpsJson=" + JSON.stringify(osbpsJson) + "&memberId="+memberid+"&generTime="+$("#generTime").val();
        	}
        }
    });
}