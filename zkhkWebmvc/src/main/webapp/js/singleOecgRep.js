/*
 * 用于单项测量待审 > 三合一测量页面 (singleOecgRep.jsp)
 */
$(function() {
    $("#btn").toggle(function() {
            $(this).after("<div class='reason-box'><span>请填写退审原因</span><textarea name='approvalReason' rows='2' cols='50'/><input type='button' class='btn-normal' id='reback' onclick='rebacklevel()' value='退审'/></div>");
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
        /*background: '#EEE',
        width: '1400px',
        margin: '10px 0 10px',
        padding: '5px 10px',
        border: '1px solid #CCC'*/
        background: '#f6f6f6',
        width: '100%',
        border: '1px solid #ddd',
        overflow: 'hidden'
    };
    $("#chart").css(chartdivcss);

    var partdivcss = {
        /*width: '680px',
        margin: '10px 0 10px 10px',
        border: '1px solid #CCC',
        display:'inline-block'*/
        width: '47.7%',
        border: '1px solid #ddd',
        margin: '0.9%',
        float: 'left',
        background: '#fff',
        overflow: 'hidden'
    }
    $("#part1").css(partdivcss);
    $("#part2").css(partdivcss);

    //--------------------------------------------------------------------------------------------------------

    var chart1 = new Highcharts.Chart({
        chart: {
            type: 'scatter',
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            renderTo: 'chart1',
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
            max: 24,
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



    var chart2 = new Highcharts.Chart({
        chart: {
            type: 'column',
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            margin: [50, 50, 100, 80],
            renderTo: "chart2"
        },
        title: {
            text: '异常心电柱状图'
        },
        xAxis: {
            categories: [],
            labels: {
                rotation: -45,
                align: 'right',
                style: {
                    fontSize: '13px'
                }
            }
        },
        yAxis: {
            min: 0,
            tickInterval: 1,
            lineWidth: 1,
            tickWidth: 1,
            title: {
                text: '单位 (次数)'
            }
        },
        legend: {
            enabled: false
        },
        tooltip: {
            pointFormat: '次数: <b>{point.y:.0f} 次数</b>',
        },
        credits: {
            enabled: false
        },
        exporting: {
            enabled: false
        },
        series: [{
            name: 'Population',
            data: [],
            dataLabels: {
                enabled: true,
                rotation: 0,
                color: 'rgba(0, 0, 255, .5)', //柱状条上的数字显示的颜色，设置为透明
                align: 'center',
                x: 0,
                y: 0,
                style: {
                    fontSize: '13px',
                    fontFamily: 'Microsoft YaHei',
                    textShadow: '0 0 3px black'
                }
            }
        }]
    });


    var chart3 = new Highcharts.Chart({
        chart: {
            type: 'scatter',
            zoomType: '',
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            renderTo: 'chart3',
            marginLeft: 90
        },
        title: {
            text: '24小时脉搏指标分布图' //标题
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
            enabled: false,
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'top',
            x: 10,
            y: -10,
            floating: true,
            backgroundColor: 'rgba(0,0,0,0)',
            /*borderWidth : 1*/
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
            text: '异常脉搏指标柱状图'
        },
        xAxis: {
            categories: [],
            labels: {
                rotation: -45,
                align: 'right',
                style: {
                    fontSize: '13px'
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
        legend: {
            enabled: false
        },
        tooltip: {
            pointFormat: '异常次数: <b>{point.y:.0f} 次数</b>',
        },
        credits: {
            enabled: false
        },
        exporting: {
            enabled: false
        },
        series: [{
            name: 'Population',
            data: [],
            dataLabels: {
                enabled: true,
                rotation: 0, //倾斜度数
                color: 'rgba(0, 0, 255, .5)', //柱状条上的数字显示的颜色，设置为透明
                align: 'center',
                x: 0, //偏移
                y: 0, //偏移
                style: {
                    fontSize: '13px',
                    fontFamily: 'Microsoft YaHei',
                    textShadow: '0 0 3px black'
                }
            }
        }]
    });





    //-------------------------------------------------------------------------------------------------------
    // 读取图表数据
    $.post("../singleReport/singleMeasueChart", {
        memberid: memberid,
        reportNo: reportNo,
        funId: 3
            // 选项代码 1：血压 		2：血糖 		3：三合一 		4：心电
    }, function(d) {
        var data = JSON.parse(d);

        if (data && data.length == 4) {
            var ch1 = data[0]; //图一数据
            var ch2 = data[1]; //图二数据
            var ch3 = data[2]; //图三数据
            var ch4 = data[3]; //图四数据

            var c1 = toArrayData(ch1, 'chart1');
            if (c1 && c1.length > 0) {
                for (i = 0; i < c1.length; i++) {
                    var arr = c1[i].data;
                    if (arr.length == 2) {
                        var name = arr[0];
                        var dt = arr[1];

                        chart1.addSeries({
                            name: name,
                            data: dt
                        }, true);

                        chart1.yAxis[0].addPlotLine(c1[i].plotBand)
                    }
                }
                chart1.redraw();
            }

            var c2 = toArrayData(ch2, 'chart2');
            if (c2 && c2.length == 2) {
                chart2.xAxis[0].setCategories(c2[0]);
                chart2.series[0].setData(c2[1]);
            }
            
            var c3 = toArrayData(ch3, 'chart3');
            if (c3 && c3.length > 0) {
                for (i = 0; i < c3.length; i++) {
                    var arr = c3[i].data;
                    if (arr.length == 2) {
                        var name = arr[0];
                        var dt = arr[1];
                        
                        chart3.addSeries({
                            name: name,
                            data: dt
                        }, true);

                        chart3.yAxis[0].addPlotLine(c3[i].plotBand)
                    }
                }
                chart3.redraw();
            }

            var c4 = toArrayData(ch4, 'chart4');
            if (c4 && c4.length == 2) {
                chart4.xAxis[0].setCategories(c4[0]);
                chart4.series[0].setData(c4[1]);
            }
        }
    });
});


function toArrayData(obj, flag) {
    var data = [];
    var result = [];

    if (flag == 'chart1') {
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

function rebacklevel() {
    if ($.trim($("textarea[name='approvalReason']").val()) == '') {
        alert('退审原因不能为空');
        return;
    }
    //alert($("textarea[name='approvalReason']").val());
    var param = {
        reportNo: $("input[name='oasr.reportNo']").val(),
        cur_level: $("input[name='oasr.auditLevel']").val(),
        msg: $("textarea[name='approvalReason']").val()
    };
    //alert(param.reportNo);
    //alert(param.cur_level);
    // alert(param.msg);
    //http://127.0.0.1:8080/HKEJ/audit/SumMeasueRepAction!rebackLevel
    $.post(basePath + 'audit/SingleMeasueRepAction!rebackCheckSingle', param, function(date) {
        //alert(date);
        if (date.code == '0000') {
            alert('审核退回成功');
            window.location.href = date.URL;
        } else {
            alert("审核退回失败" + date.err);
            window.location.href = date.URL;
        }
    });
}

function checkAudit() {
    //判断审核内容
    editor.sync(); //同步代码
    var myAdvice = $("#myAdvice").val();
    myAdvice = $.trim(myAdvice);
    if (myAdvice == '') {
        alert("审核内容不能为空！");
        return false;
    }
    
    var length = editor.count('text');
    if (length > 1000) {
    		alert("审核内容不能够超过1000字符!");
        return false;
    }

    var ret = false;
    var serialNumber = $("#serialNumber").val();
    var optId = $("#optId").val();
    $.ajax({
        url: "../summaryReport/checkSumRepAudit", // 跳转到 action
        data: {
            docentry: serialNumber,
            optId: optId
        },
        type: 'post',
        cache: false,
        async: false,
        dataType: 'json',
        success: function(result) {
            if (result.ret == "Y") {
                ret = true;
            } else if (result.ret == "N") {
                alert("不能重复审核");
            }
        },
        error: function() {
            // view("异常！");
            alert("审核失败！");
        }
    });
    return ret;
}
