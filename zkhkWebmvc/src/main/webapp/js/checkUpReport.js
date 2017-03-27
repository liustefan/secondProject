// 老年人年度体检状况

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

//各地区老人体检管理状况
function drawCheckUp(obj, length) {
    $('#chart-checkUp').highcharts({
        chart: {
            type: 'bar',
            borderWidth: 1,
            borderColor: '#ccc',
            height: 90 * length
        },
        title: {
            text: '各地区老人体检管理状况'
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
            name: '未体检',
            data: obj.noCheckUpList
        }, {
            name: '老人总数',
            data: obj.totalList
        }]
    });
}

// 填充table
function onloadTable(list) {
    var result = '',
        obj = {};
    for (var i = 0; i < list.length; i++) {
        obj = list[i];
        result += '<tr><td>' + obj.placeName + '</td><td>' + obj.total + '</td><td>' + obj.noCheckUp + '</td></tr>';
    }
    $("#datalist tbody").empty();
    $("#datalist tbody").append(result);
}

// 初始化
function initPage(data) {
    //各地区老人体检管理状况 数据
    var list1 = {
            spanceNameList: [], // 地区名称集合
            noCheckUpList: [], // 为体检集合
            totalList: [], // 老人总数集合
        },
        dataCount = data.length < 5 ? 4 : data.length,
        obj = {};

    // 数据处理
    for (var i = 0; i < data.length; i++) {
        obj = data[i];
        list1.spanceNameList.push(obj.placeName);
        list1.totalList.push(obj.total);
        list1.noCheckUpList.push(obj.noCheckUp);
    }
    //填充table
    onloadTable(data);
    //各地区老人体检管理状况表
    drawCheckUp(list1, dataCount);
}

function clean() {
    $("#datalist tbody").empty();
    $("#chart-checkUp").empty();
}

// 查询
function search() {
    var orgId = $("#memberGroupId").val(),
        year = $("#infoYear").val();

    if (orgId) {
        $(".loadBox").show();
        $.get("../statistic/exProSelectElderlyHealthByYear", { orgId: orgId, year: year }, function(data) {
            $(".loadBox").hide();
            if (data.status) {
                // 先清空之前的数据以及图表
                clean();
                // 如果有数据 则加载
                if (data.data.length > 0) {
                    initPage(data.data);
                } else {
                    $("#datalist tbody").append('<tr><td colspan="3" class="empty-info">没有数据</td></tr>');
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

//建档年度 显示以当前年度向前推10年
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