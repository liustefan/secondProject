// 人口基本状况

var setting = {
    data: {
        simpleData: {
            enable: true
        }
    },
    view: {
        dblClickExpand: false,
        selectedMulti: false,
        showIcon: false
    },
    callback: {
        onClick: onClick,
        onExpand: zTreeOnExpand
    }
};

//各地区人口基本资料表
function drawPopulation(obj, length) {
    $('#chart-population').highcharts({
        chart: {
            type: 'bar',
            borderWidth: 1,
            borderColor: '#ccc',
            height: 90 * length
        },
        title: {
            text: '各地区人口基本资料表'
        },
        subtitle: {
            text: ''
        },
        xAxis: {
            categories: obj.spanceNameList,
            title: {
                text: null
            }
        },
        yAxis: {
            min: 0,
            allowDecimals: false,
            title: {
                text: '',
                align: 'high'
            },
            labels: {
                overflow: 'justify'
            }
        },
        tooltip: {
            valueSuffix: ''
        },
        plotOptions: {
            bar: {
                dataLabels: {
                    enabled: true
                }
            }
        },
        legend: {
            layout: 'horizontal',
            align: 'center',

        },
        credits: {
            enabled: false
        },
        series: [{
            name: '糖尿病人数',
            data: obj.diabetesList
        }, {
            name: '高血压人数',
            data: obj.hypertensionCountList
        }, {
            name: '65以上老人',
            data: obj.age65List
        }, {
            name: '人口总数',
            data: obj.populationCountList
        }]
    });
}

// 绘制各地区需随访人群资料
function drawfollowUp(series, length) {
    $('#chart-followUp').highcharts({
        chart: {
            type: 'bar',
            borderWidth: 1,
            borderColor: '#ccc',
            height: 90 * length
        },
        title: {
            text: '各地区需随访人群资料'
        },
        subtitle: {
            text: ''
        },
        xAxis: {
            categories: ['糖尿病人数', '高血压人数', '65以上老人', '人口总数'],
            title: {
                text: null
            }
        },
        yAxis: {
            min: 0,
            allowDecimals: false,
            title: {
                text: '',
                align: 'high'
            },
            labels: {
                overflow: 'justify'
            }
        },
        tooltip: {
            valueSuffix: ''
        },
        plotOptions: {
            bar: {
                dataLabels: {
                    enabled: true
                }
            }
        },
        legend: {
            layout: 'horizontal',
            align: 'center',

        },
        credits: {
            enabled: false
        },
        series: series
    });
}

// 绘制人口基本状况表
function drawPopulationDetail(id, obj) {
    $(id).highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            marginLeft: 10
        },
        title: {
            text: obj.placeName + '人口基本状况表'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.y}({point.percentage:.2f}%)</b>'
        },
        credits: {
            enabled: false
        },
        plotOptions: {
            pie: {
                allowPointSelect: false,
                cursor: 'pointer',
                inside: true,
                dataLabels: {
                    enabled: true,
                    format: '<b>{point.percentage:.2f} %</b>'
                },
                showInLegend: true
            }
        },
        series: [{
            type: 'pie',
            name: obj.placeName,
            data: [
                ['人口总数', obj.populationCount],
                ['65以上老人', obj.age65],
                ['高血压人数', obj.hypertensionCount],
                ['糖尿病人数', obj.diabetes]
            ]
        }]
    });
}

function onloadTable(list) {
    var result = '',
        obj = {};
    for (var i = 0; i < list.length; i++) {
        obj = list[i];
        result += '<tr><td>' + obj.placeName + '</td><td>' + obj.populationCount + '</td><td>' + obj.age65 + '</td><td>' + obj.hypertensionCount + '</td><td>' + obj.diabetes + '</td></tr>';
    }
    $("#datalist tbody").append(result);
}

// 初始化
function initPage(populationList) {
	
    //各地区人口基本资料图表 数据
    var list1 = {
            spanceNameList: [], // 地区名称集合
            populationCountList: [], // 人口总数集合
            age65List: [], // 65岁以上老人集合
            hypertensionCountList: [], // 高血压集合
            diabetesList: [] // 糖尿病集合
        },
        obj = {},
        dataCount = populationList.length <5 ? 4 : populationList.length,
        list2 = []; // 各地区需随访人群资料图表 数据

    // 数据处理
    for (var i = 0; i < populationList.length; i++) {
        obj = populationList[i];
        list1.spanceNameList.push(obj.placeName);
        list1.populationCountList.push(obj.populationCount);
        list1.age65List.push(obj.age65);
        list1.hypertensionCountList.push(obj.hypertensionCount);
        list1.diabetesList.push(obj.diabetes);

        list2.push({
            name: obj.placeName,
            data: [obj.diabetes, obj.hypertensionCount, obj.age65, obj.populationCount]
        });
    }
    //填充table
    onloadTable(populationList);
    //各地区人口基本资料表
    drawPopulation(list1, dataCount);
    // 绘制各地区需随访人群资料
    drawfollowUp(list2, dataCount);
//    // 循环绘制人口基本状况表
//    $(populationList).each(function(i, e) {
//        $("#barBox").append(' <div id="chart-populationDetail' + i + '" style="min-width:45%;height:400px; border: 1px solid #ccc; display: inline-block; margin: 10px;"></div>')
//        drawPopulationDetail('#chart-populationDetail' + i, e);
//    });
}

function clean() {
    $("#datalist tbody").empty();
    $("#chart-population").empty();
    $("#chart-followUp").empty();
    $("#barBox").empty();
}
// 查询
function search() {
    var orgId = $("#memberGroupId").val();

    if (orgId) {
        $(".loadBox").show();
        $.get("../statistic/exProSelectPopulation", { "orgId": orgId }, function(data) {
            $(".loadBox").hide();
            if (data.status) {
                // 先清空之前的数据以及图表
                clean();
                // 如果有数据 则加载
                if (data.data.length > 0) {
                    initPage(data.data);
                } else {
                    $("#datalist tbody").append('<tr><td colspan="5" class="empty-info">没有数据</td></tr>');
                }
            } else {
                alert("获取数据失败");
            }
        });
    } else {
        alert("请选择组织");
    }
}

// 显示组织分组
function showGroupList() {
    if ($("#menuContent").css("display") == "none") {
        getOrganizationList();
        showMenu();
    }
}
