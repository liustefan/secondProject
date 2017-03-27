// 糖尿病随访

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

//糖尿病随访状况
function drawGlycureis1(obj, length) {
    $('#chart-glycureis1').highcharts({
        chart: {
            type: 'bar',
            borderWidth: 1,
            borderColor: '#ccc',
            height: 90 * length
        },
        title: {
            text: '糖尿病随访状况'
        },
        subtitle: {
            text: ''
        },
        xAxis: {
            categories: obj.placeNameList,
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
            name: '糖尿病总人数',
            data: obj.totalList
        }, {
            name: '最近一次随访血糖达标',
            data: obj.glycuresisOkList
        }, {
            name: '规范管理',
            data: obj.normManageList
        }, {
            name: '年内累计管理',
            data: obj.totalManageOneYearList
        }, {
            name: '新发现',
            data: obj.newCustomeList
        }]
    });
}

// 各地区糖尿病随访状况横向对比
function drawGlycureis2(series, length) {
    $('#chart-glycureis2').highcharts({
        chart: {
            type: 'bar',
            borderWidth: 1,
            borderColor: '#ccc',
            height: 90 * length
        },
        title: {
            text: '各地区糖尿病随访状况横向对比'
        },
        subtitle: {
            text: ''
        },
        xAxis: {
            categories: ['糖尿病总人数', '最近一次随访血糖达标', '规范管理', '年内累计管理', '新发现'],
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

// 填充table
function onloadTable(list) {
    var result = '',
        obj = {};
    for (var i = 0; i < list.length; i++) {
        obj = list[i];
        result += '<tr><td>' + obj.placeName + '</td><td>' + obj.total + '</td><td>' + obj.totalManageOneYear + '</td><td>' + obj.normManage + '</td><td>' + obj.newCustome + '</td><td>' + obj.glycuresisOk + '</td></tr>';
    }
    $("#datalist tbody").append(result);
}

// 初始化
function initPage(data) {
    var list1 = {
            placeNameList: [], // 地区名称集合
            totalList: [], // 糖尿病总人数集合
            glycuresisOkList: [], // 最近一次随访血糖达标集合
            normManageList: [], // 规范管理集合
            totalManageOneYearList: [], // 年内累计管理集合
            newCustomeList: [] // 新发现集合
        },
        list2 = [],
        dataCount = data.length < 5? 4: data.length,
        obj = {};

    // 数据处理
    for (var i = 0; i < data.length; i++) {
        obj = data[i];
        list1.placeNameList.push(obj.placeName);
        list1.totalList.push(obj.total);
        list1.glycuresisOkList.push(obj.glycuresisOk);
        list1.normManageList.push(obj.normManage);
        list1.totalManageOneYearList.push(obj.totalManageOneYear);
        list1.newCustomeList.push(obj.newCustome);

        list2.push({
            name: obj.placeName,
            data: [obj.total, obj.glycuresisOk, obj.normManage, obj.totalManageOneYear, obj.newCustome]
        });
    }
    // 填充table
    onloadTable(data);
    // 各地区老人体检管理状况表
    drawGlycureis1(list1, dataCount);
    // 各地区高血压随访状况横向对比表
    drawGlycureis2(list2, dataCount);
}

function clean() {
    $("#datalist tbody").empty();
    $("#chart-glycureis1").empty();
    $("#chart-glycureis2").empty();
}

// 查询
function search() {
    var orgId = $("#memberGroupId").val(),
        year = $("#infoYear").val();

    if (orgId) {
        $(".loadBox").show();
        $.get("../statistic/exProSelectDiabetesVisit", { orgId: orgId, year: year }, function(data) {
            $(".loadBox").hide();
            if (data.status) {
                // 先清空之前的数据以及图表
                clean();
                // 如果有数据 则加载
                if (data.data.length > 0) {
                    initPage(data.data);
                } else {
                    $("#datalist tbody").append('<tr><td colspan="6" class="empty-info">没有数据</td></tr>');
                }
            } else {
                alert("获取数据失败");
            }

        });
    } else {
        alert("请选择组织");
    }
}

// 建档年度 显示以当前年度向前推10年
function addYear() {
    var currentYear = $("#currentYear").val();
    var infoYear = $("#infoYear");
    var str = '<option value="' + currentYear + '" selected="selected">' + currentYear + '</option>';
    var temp = 0;
    for (var i = 1; i <= 10; i++) {
        temp = +currentYear - i;
        str += '<option value="' + temp + '">' + temp + '</option>';
    }
    infoYear.append(str);
}

// 显示组织分组
function showGroupList() {
    if ($("#menuContent").css("display") == "none") {
        getOrganizationList();
        showMenu();
    }
}
