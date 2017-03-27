/*
 * 用于单项测量待审 > 血压测量页面 (singleOsbpRep.jsp)
 */

$(function() {
	
    /****************************图表****************************/
    var chartdivcss = {
        background: '#f6f6f6',
        /*width: '1400px',
        margin: '10px 0 10px',
        padding: '5px 10px',
        border: '1px solid #CCC'*/
        width: '100%',
        border: '1px solid #ddd',
        overflow: 'hidden'
    };
    $("#chart").css(chartdivcss);

    var partdivcss = {
        /*width: '680px',
        margin: '10px 0 10px 10px',
        //border: '1px solid #CCC',
        display:'inline-block'*/
        width: '47.7%',
        border: '1px solid #ddd',
        margin: '0.9%',
        float: 'left',
        background: '#fff',
        overflow: 'hidden'
    };
    $("#part1").css(partdivcss);
    $("#part2").css(partdivcss);

    var subchartcss = {
        width: '47%',
        margin: '0 0 0 0',
        //border: '1px solid #CCC',
        display: 'inline-block'
    };
    $("#chart2_1").css(subchartcss);
    $("#chart2_2").css(subchartcss);
    $("#chart2_3").css(subchartcss);
    $("#chart2_4").css(subchartcss);

    var chart = new Highcharts.Chart({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            renderTo: "chart1"
        },
        title: {
            text: '血压饼图',
            x: -30 //center
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
                return this.name + '&nbsp';
            },
            useHTML: true,
            backgroundColor: 'rgba(0,0,0,0)'
                //backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColorSolid) || 'white'
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

    //-3-------------------------------------------------------------------
    //
    var chart3 = new Highcharts.Chart({
        chart: {
            type: 'scatter',
            renderTo: 'chart3'
        },
        title: {
            text: '24小时血压分布图' //标题
        },
        tooltip: {
            formatter: function () {
                return '<b>'+this.series.name+'</b><br>' + this.x.toFixed(2).replace('.', ':') +
                    ',' + this.y + '</b>';
            }
        },
        xAxis: {
            title: {
                enabled: true,
                text: '时间'
            },
            tickInterval: 6,
            max: 23,
            min: 0,
            startOnTick: true,
            endOnTick: true,
            showLastLabel: true
        },
        yAxis: {
            lineWidth: 1,
            tickWidth: 1,
            tickInterval: 20,
            gridLineWidth: 0,
            title: {
                text: '血压值（mmHg）'
            },
            min: 0,
            max: 260,
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
//                tooltip: {
//                    headerFormat: '<b>{series.name}</b><br>',
//                    pointFormat: '{point.x}, {point.y}'
//                }
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

    //-4-------------------------------------------------------------------
    var chart4 = new Highcharts.Chart({
        chart: {
            type: 'column',
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            margin: [50, 50, 100, 80],
            renderTo: "chart4"
            
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
            categories: [],
            labels: {
                rotation: -50,
                align: 'right',
                style: {
                    fontSize: '13px',
                    color: '#000000'
                }
            }
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
        legend: {
            enabled: false
        },
        tooltip: {
            pointFormat: '各级血压次数: <b>{point.y:.0f} 次数</b>',
        },
        credits: {
            enabled: false
        },
        exporting: {
            enabled: false
        },
        series: [{
            name: 'Population',
            color: '#990000',
            data: [],
            dataLabels: {
                enabled: true,
                rotation: 0,
                //color : 'rgba(0, 0, 255, .5)',	//柱状条上的数字显示的颜色，设置为透明
                align: 'center',
                x: 0,
                y: 0,
                style: {
                    fontSize: '13px',
                    fontFamily: 'Verdana, sans-serif',
                    textShadow: '0 0 3px black'
                }
            }
        }]
    });


    //-5-------------------------------------------------------------------
    var chart5 = new Highcharts.Chart({
        chart: {
            type: 'line',
            renderTo: 'chart5'
        },
        title: {
            text: '所有血压趋势图',
            x: -20 //center
        },
        credits: {
            enabled: false
        },
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
        tooltip: {
            formatter: function() {
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
            data: [],
        }]
    });
    //-chart6-------------------------------------------------------------------
    var chart6 = new Highcharts.Chart({
        chart: {
            type: 'line',
            renderTo: 'chart6'
        },
        title: {
            text: '起床后血压趋势图',
            x: -20 //center
        },
        exporting: {
            enabled: false
        },
        xAxis: {
            //'Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun','Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'
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
        credits: {
            enabled: false // 禁用版权信息
        },
        tooltip: {
            formatter: function() {
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
    //-chart7-------------------------------------------------------------------
    var chart7 = new Highcharts.Chart({
        chart: {
            //type: 'line',
            renderTo: 'chart7'
        },
        title: {
            text: '睡前血压趋势图',
            x: -20 //center
        },
        credits: {
            enabled: false // 禁用版权信息
        },
        exporting: {
            enabled: false
        },
        xAxis: {
            //'Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun','Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'
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
        credits: {
            enabled: false // 禁用版权信息
        },
        tooltip: {
            formatter: function() {
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
    
     
  //血压所有测量数据中的脉率趋势图
     
    	var mypulse = new Highcharts.Chart({
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
    	  
   
    //-5-------------------------------------------------------------------
    var chart5 = new Highcharts.Chart({
        chart: {
            type: 'line',
            renderTo: 'chart5'
        },
        title: {
            text: '所有血压趋势图',
            x: -20 //center
        },
        credits: {
            enabled: false
        },
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
        tooltip: {
            formatter: function() {
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
            data: [],
        }]
    });

    //-------------------------------------------------------------------------------------------------------
    var time1chart = new Highcharts.Chart({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            renderTo: "chart2_1"
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
            name: '异常状态',
            data: []
        }]
    });

    var time2chart = new Highcharts.Chart({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            renderTo: "chart2_2"
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
            name: '异常状态',
            data: []
        }]
    });

    var time3chart = new Highcharts.Chart({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            renderTo: "chart2_3"
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
            name: '异常状态',
            data: []
        }]
    });
    var time4chart = new Highcharts.Chart({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            renderTo: "chart2_4"
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
            name: '异常状态',
            data: []
        }]
    });
    
    //-------------------------------------------------------------------------------------------------------
    // 读取图表数据
    $.post("../bloodPressure/getBloodPressChart", {
    	osbpsJson: JSON.stringify(osbpsJson),
    	memberid: memberid
    }, function(data) {
        if (data) {
            var myInfo = JSON.parse(data);
            if (myInfo.length > 0) {
                var timeQ = myInfo[2].timeQ;
                var scatSD = myInfo[3];
                //------------------------------------
                chart.series[0].setData(toArrayData(myInfo[0].pie1, 'pie1')); //饼图
                //---------------------------------
                var bar4 = toArrayData(myInfo[1].bar4, 'bar4'); //柱状
                if (bar4 && bar4.length == 2) {
                    chart4.xAxis[0].setCategories(bar4[0]);
                    chart4.series[0].setData(bar4[1]);
                }

                var timeQ = myInfo[2].timeQ;
                if (timeQ && timeQ.length == 4) {
                    time1chart.series[0].setData(toArrayData(timeQ[0], 'pie2')); //饼图
                    time2chart.series[0].setData(toArrayData(timeQ[1], 'pie2')); //饼图
                    time3chart.series[0].setData(toArrayData(timeQ[2], 'pie2')); //饼图
                    time4chart.series[0].setData(toArrayData(timeQ[3], 'pie2')); //饼图
                }

                //----------------------------
                var scotS = toArrayData(myInfo[3].scotS, 'scot3');
                var scotD = toArrayData(myInfo[3].scotD, 'scot3');
                chart3.addSeries({
                    name: '收缩压',
//                    color: 'rgba(223, 83, 83, .5)',
                    data: scotS
                }, true);
                chart3.addSeries({
                    name: '舒张压',
//                    color: 'rgba(119, 152, 191, .5)',
                    data: scotD
                }, true);
                chart3.redraw();
                //---------------
                //---所有血压趋势图
                if (myInfo[4] && myInfo[4].trend1) {
                    chart5.xAxis[0].setCategories(myInfo[4].trend1.time);
                    chart5.series[0].setData(myInfo[4].trend1.sbp);
                    chart5.series[1].setData(myInfo[4].trend1.dbp);
                    chart5.redraw();
                }
                //---起床后血压趋势图
                if (myInfo[5] && myInfo[5].trend2) {
                    chart6.xAxis[0].setCategories(myInfo[5].trend2.time);
                    chart6.series[0].setData(myInfo[5].trend2.sbp);
                    chart6.series[1].setData(myInfo[5].trend2.dbp);
                    chart6.redraw();
                }
                //睡前血压趋势图----
                if (myInfo[6] && myInfo[6].trend3) {
                    chart7.xAxis[0].setCategories(myInfo[6].trend3.time);
                    chart7.series[0].setData(myInfo[6].trend3.sbp);
                    chart7.series[1].setData(myInfo[6].trend3.dbp);
                    chart7.redraw();
                }
                
                //---所有脉搏趋势图
                if (myInfo[7] && myInfo[7].pulseRate) {
                	mypulse.xAxis[0].setCategories(myInfo[7].pulseRate.time);
                	mypulse.series[0].setData(myInfo[7].pulseRate.pulseRate); 
                	mypulse.redraw();
                }
                
                

                //---------------
            }
        }
    });
});


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
    }
    return data;
}



