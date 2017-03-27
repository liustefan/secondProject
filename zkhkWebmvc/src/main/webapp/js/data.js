// Highcharts 全局设置 语言
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
        rangeSelectorZoom: ' ',
        resetZoom: '重置缩放',
        loading: '加载中',
        rangeSelectorFrom: '从',
        rangeSelectorTo: '至',
        months: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月',
            '十一月', '十二月'
        ],
        weekdays: ['星期一', '星期二', '星期三', '星期四', '星期五', '星期六', '星期天']
    }
});

var chart, G_selectPbId = null,
    G_selectStart = null,
    G_selectEnd = null,
    G_deleteStart = null,
    G_deleteEnd = null,
    G_deleteName = null,
    BaseData = {},
    UndoList = {
        pointData: [],
        data: [],
        operateList: []
    },
    BackList = {
        pointData: [],
        data: [],
        operateList: []
    },
    clickDetected = false,
    isOk = false,
    oTimer = null;

//加载异常详情
function appendBox(objectIds, extimes, extMillis, name) {
    //排序
    var objlist = [];
    $(objectIds).each(function(i, e) {
        objlist.push({
            id: e,
            extime: extimes[i],
            extMilli: extMillis[i]
        })
    });
    objlist.sort(function(a, b) {
            return (b.extMilli < a.extMilli) ? 1 : -1
        })
        //添加数据
    $("#tabl").html("");
    $("#tabl").append("<tr><th>序号</th><th>异常时间</th><th> </th></tr>");
    if (objectIds.length == 0) {
        layer.close(layerIndex);
    }
    for (var i = 0; i < objlist.length; i++) {
        $("#tabl").append('<tr><td>' + (i + 1) + '</td><td>' + (objlist[i].extime || '') + '</td><td><a href="#ecgChart" onclick="locating(\'' + objlist[i].id + '\',' + (objlist[i].extMilli || '') + ');">定位</a> &nbsp;&nbsp;<a href="javascript:deleteECGExc(\'' + objlist[i].id + '\',\'' + name + '\')">删除</a></td></tr>');
    }
}

//定位
function locating(id, start) {
    if (isOk) {
    	if($("#ecgType").val() == "miecg"){
    		jumpPageLocation(start);
    	}
    	
        $('#ecgbox').removeClass('hidden');
        $('#ecgbox').addClass('show');
        var end = start + 6000,
            chart = $('#ecgChart').highcharts();
        var max = chart.xAxis[0].getExtremes().dataMax;
        var p1 = end > max ? max : end;
        if (p1 - start < 6000) {
            chart.xAxis[0].setExtremes(p1 - 6000, p1);
        }else {
            chart.xAxis[0].setExtremes(start, end > max ? max : end);
        }
        toggleBands(chart, id);
        G_selectPbId = id;
        
        $.each(chart.xAxis[0].plotLinesAndBands, function(index, e) {
            if(e.options.id == id){
            	 var strStart = Highcharts.dateFormat('%H:%M:%S:%L', start);
                 var strEnd = Highcharts.dateFormat('%H:%M:%S:%L',  e.options.endTime - e.options.startTime + start);
                 G_deleteStart = strStart;
                 G_deleteEnd = strEnd;
            	 G_deleteName = e.options.excName;
            }
        });
    }
}

function jumpPageLocation(locateTime){
	$("#startTime").val("");
	$("#endTime").val("");
	load_xdt("4");
	var measTime = new Date($("#measTime").val()).getTime();
	var showTimeLength = $("#showTimeLength").val();
	xdt_num = Math.ceil((locateTime - measTime)/(showTimeLength*60*1000));
	if(xdt_num != $("#jumpPage").val()){
		$("#jumpPage").val(xdt_num);
		load_xdt('3');
	}
}

// 全屏
function fullScr() {
    $('.chart-container:first').toggleClass('modal');
    //$('#ecgChart').css({'width': '90%', 'height': '60%'});
    $('#ecgChart').highcharts().reflow();
}

// GUID
function guid() {
    function S4() {
        return (((1 + Math.random()) * 0x10000) | 0).toString(16).substring(1);
    }
    return (S4() + S4() + "" + S4() + "" + S4() + "" + S4() + "" + S4() + S4() + S4());
}

//选中高亮边框
function toggleBands(chart, id) {
    $.each(chart.xAxis[0].plotLinesAndBands, function(index, el) {
        if (el.svgElem != undefined) {
            if (el.id.replace(/\"/g, "") != id.replace(/\"/g, "")) {
                el.svgElem.attr({
                    'stroke-width': 0,
                    stroke: '',
                });
            } else {
                el.svgElem.attr({
                    'stroke-width': 1,
                    stroke: '#009944'
                });
            }

        }
    });
}

//清除选择框
function clearSelect() {
    var chart = $('#ecgChart').highcharts();
    chart.xAxis[0].removePlotBand('selected');

    G_selectStart = null;
    G_selectEnd = null;
}

//初始化心电异常
function initECG() {
    var memberid1 = $("#memberid").val();
    var pagenow1 = $("#pagenow").val();
    var eventid = $("#eventid").val();
        
    var url="";
    if($("#ecgType").val() == "miecg"){
    	url = "../electrocardio/initElectrocardioExcAndDelData";
    }else if($("#ecgType").val() == "ecg"){
    	url = "../electrocardioPulse/initElectrocardioExcAndDelData";
    }else{
    	return;
    }

    $.post(url, {
            memberId: memberid1,
            pageNo: pagenow1,
            eventId: eventid
        },
        function(data) {
            //重新加载异常心电
            clearEcg($('#ecgChart').highcharts());
            initExcOrDelete(JSON.parse(data));
        }
    );
}

//获取当前plotBand  选择的除外
function getPB(arr) {
    return arr.filter(function(x, index) {
        return x.id != 'selected';
    });
}

//清空异常
function clearEcg(chart) {
    var objlist = chart.xAxis[0].options.plotBands
    $(objlist).each(function(index, e) {
        if (e.pbType == 'Exc') {
            chart.xAxis[0].removePlotBand(e.id);
        }
    });
}

//更新图表
function updateChart(obj, obj2) {
    var chart = $('#ecgChart').highcharts();
    chart.xAxis[0].update({
        plotBands: obj.slice(0),
    }, false);
    //    chart.series[0].setData(obj2.slice(0),false,false); //禁用绘制
    chart.redraw();
}

// 更新操作记录
function updateOL() {
    var box1 = $("#operateList");
    box1.html('');
    // UndoList.operateList.forEach(function(x, index) {
    //     box1.append('(' + (index + 1) + ') ' + x + '\n');
    // });
    $.each(UndoList.operateList, function(index, el) {
        box1.append('(' + (index + 1) + ') ' + el + '\n');
    });
}

// 在心电图上添加异常块
function addPlotBand(start, end, name, id) {
    var strId = guid();
    var strStart = Highcharts.dateFormat('%H:%M:%S:%L', start);
    var strEnd = Highcharts.dateFormat('%H:%M:%S:%L', end);
    var strTime = Highcharts.dateFormat('%S.%L秒', end - start);
    var chart = $('#ecgChart').highcharts();
    var startP = chart.options.series[0].pointStart;
    var objPb = {
        // borderColor: 'yellow',
        // borderWidth: 1,
        color: 'rgba(69, 114, 167, 0.25)',
        startTime: start - startP,
        endTime: end - startP,
        from: start,
        to: end,
        id: id || strId,
        pbType: 'Exc',
        excName: name,
        excData: getSelDate(start, end),
        zIndex: 8,
        label: {
            useHTML: true,
            textAlign: 'center',
            text: '异常：' + name + '</br>时长:' + strTime,
            align: 'center',
            verticalAlign: 'bottom',
            y: -100,
            style: {
                color: '#000',
                fontSize: 10,
            }
        },
        events: {
            // 记录选中状态
            click: function(e) {
                G_selectPbId = id || strId;
                G_deleteStart = strStart;
                G_deleteEnd = strEnd;
                G_deleteName = name;
                //高亮选中
                toggleBands(chart, G_selectPbId);
            }
        }
    };
    chart.xAxis[0].addPlotBand(objPb);
}

// 在心电图上添加删除块
function addPlotBand1(start, end, id) {
    var strStart = Highcharts.dateFormat('%H:%M:%S:%L', start);
    var strEnd = Highcharts.dateFormat('%H:%M:%S:%L', end);
    //var strTime = Highcharts.dateFormat('%M:%S', end - start);
    var strId = guid();
    var chart = $('#ecgChart').highcharts();
    var startP = chart.options.series[0].pointStart;

    var objPb = {
        // borderColor: 'yellow',
        // borderWidth: 1,
        color: '#fff',
        pbType: 'delete',
        startTime: start - startP,
        endTime: end - startP,
        from: start,
        to: end,
        id: id || strId,
        zIndex: 8,
        label: {
            // useHTML: true,
            textAlign: 'center',
            text: '标记删除',
            align: 'center',
            verticalAlign: 'bottom',
            y: -100,
            style: {
                color: '#000',
                fontSize: 10,
            }
        }
    };
    chart.xAxis[0].addPlotBand(objPb);
}

//删除心电图
function setNull(start, end) {
    var chart = $('#ecgChart').highcharts();
    var yData = chart.series[0].yData;
    var xData = chart.series[0].xData;
    var obj = [];
    for (i = 0; i < xData.length; i++) {
        if (xData[i] >= start && xData[i] <= end) {
            obj.push(null);
        } else {
            obj.push(yData[i]);
        }
    }
    chart.series[0].update({
        data: obj
    });
}

function getSelDate(start, end) {
    var chart = $('#ecgChart').highcharts();
    var yData = chart.series[0].yData;
    var xData = chart.series[0].xData;
    var obj = [];
    for (i = 0; i < xData.length; i++) {
        if (xData[i] >= start && xData[i] <= end) {
            obj.push(yData[i]);
        }
    }
    return obj;
}
//初始化异常 及删除心电图
function initExcOrDelete(excList) {
    $.each(excList, function(i, obj) {
        //      console.log(obj);
        if (obj.pbType === 'Exc') {

            addPlotBand(obj.startTime, obj.endTime, obj.excName, obj.objid);
        } else {
            addPlotBand1(obj.startTime, obj.endTime);
            //            setNull(obj.startTime, obj.endTime);
        }
    });
}

//拖动
function moveECG() {
    $('#btn_move').css({
        'background': '#e7f0f9',
        'font-weight': 'bold '
    });
    $('#btn_select').css({
        'background': '#DDDDDD',
        'font-weight': 'normal '
    });
    $("#isMove").val('true');
}

// 选择
function cheEcg() {
    $('#btn_select').css({
        'background': '#e7f0f9',
        'font-weight': 'bold '
    });
    $('#btn_move').css({
        'background': '#DDDDDD',
        'font-weight': 'normal '
    });
    $("#isMove").val('false');
}

//放大
function zoomIn() {
    var chart = $('#ecgChart').highcharts();
    var xExtremes = chart.xAxis[0].getExtremes();
    var yExtremes = chart.yAxis[0].getExtremes();
    var min = chart.xAxis[0].min - 500;
    var max = chart.xAxis[0].max + 500;
    //    chart.yAxis[0].setExtremes(
    //          chart.yAxis[0].userMin - 50,
    //          chart.yAxis[0].userMax + 50, true, false
    //    );
    chart.xAxis[0].setExtremes(min < xExtremes.dataMin ? xExtremes.dataMin : min, max > xExtremes.dataMax ? xExtremes.dataMax : max);
}

//缩小
function zoomOut() {
    var chart = $('#ecgChart').highcharts();
    var xExtremes = chart.xAxis[0].getExtremes();
    var yExtremes = chart.yAxis[0].getExtremes();
    var min = chart.xAxis[0].min;
    var max = chart.xAxis[0].max;
    //    chart.yAxis[0].setExtremes(
    //          chart.yAxis[0].userMin + 50,
    //          chart.yAxis[0].userMax - 50, true, false
    //    );
    if (max - min > 1500) {
        chart.xAxis[0].setExtremes(min + 500, max - 500);
    }
}

//原始大小
function zoomReset() {
    var chart = $('#ecgChart').highcharts();
    var min = chart.xAxis[0].min;
    var xExtremes = chart.xAxis[0].getExtremes();
    chart.xAxis[0].setExtremes(min,
        min + 6000 > xExtremes.dataMax ? xExtremes.dataMax : min + 6000);
    chart.yAxis[0].setExtremes();
}

//添加异常
function addExc() {
    if (!G_selectStart || !G_selectEnd)
        return;
    $.layer({
        type: 1,
        title: ['测量项详细内容', 'background:#09c;'],
        area: ['310px', '150px'],
        border: [5, 1, '#09c'], // 去掉默认边框
        shade: [0.7, 0, '#000'], // 去掉遮罩
        closeBtn: false, // 去掉默认关闭按钮
        offset: ['200px', ''],
        /*shift : 'left', // 从左动画弹出*/
        btns: 2,
        btn: ['确定', '取消'],
        fadeIn: 50,
        move: false,
        page: {
            html: '<div style="padding:25px 40px;"> ' + '    <p> ' + '        异常的心电指标: ' + '        <select id="selectExc" name="selectExc"> ' + '            <option value="心动过速">心动过速</option> ' + '            <option value="二联律">二联律</option> ' + '            <option value="宽搏">宽搏</option> ' + '            <option value="室性早搏">室性早搏</option> ' + '            <option value="阵发性心动过速">阵发性心动过速</option> ' + '            <option value="漏搏">漏搏</option> ' + '            <option value="心动过缓">心动过缓</option> ' + '            <option value="三联律">三联律</option> ' + '            <option value="停博">停博</option> ' + '            <option value="房性早搏">房性早搏</option> ' + '            <option value="插入性室性早搏">插入性室性早搏</option> ' + '            <option value="心律不齐">心律不齐</option> ' + '        </select> ' + '    </p> ' + '</div>'
        },
        yes: function(index) {
            var excName = $("#selectExc").val();
            var chart = $('#ecgChart').highcharts();
            //            UndoList.pointData.push(chart.series[0].yData.slice(0));
            UndoList.data.push(getPB(chart.xAxis[0].options.plotBands));
            UndoList.operateList.push("将" + Highcharts.dateFormat('%H:%M:%S:%L', G_selectStart) + "到" + Highcharts.dateFormat('%H:%M:%S:%L', G_selectEnd) + "的心电图标记异常" + ' “' + excName + '”');

            addPlotBand(G_selectStart, G_selectEnd, excName);

            updateOL();
            clearSelect();
            layer.close(index);
        },
        no: function(index) {
            layer.close(index);
            //clearSelect();
        }
    });

}

// 添加删除
function deleteECG() {
    if (G_selectStart && G_selectEnd) {
        var chart = $('#ecgChart').highcharts();
        var len = chart.xAxis[0].options.plotBands.length;
        //      console.log(chart.series[0].yData);
        //        UndoList.pointData.push(chart.series[0].yData.slice(0));
        UndoList.data.push(getPB(chart.xAxis[0].options.plotBands));
        UndoList.operateList.push('删除' + Highcharts.dateFormat('%H:%M:%S:%L', G_selectStart) + '到' + Highcharts.dateFormat('%H:%M:%S:%L', G_selectEnd) + '的心电图');

        addPlotBand1(G_selectStart, G_selectEnd);
        //        setNull(G_selectStart, G_selectEnd);
        updateOL();

        clearSelect();
    }
}

//移除异常
function RemoveExc() {
    if (!G_selectPbId)
        return;
    var chart = $('#ecgChart').highcharts();
    //    UndoList.pointData.push(chart.series[0].yData.slice(0));
    UndoList.data.push(getPB(chart.xAxis[0].options.plotBands));
    UndoList.operateList.push('删除' + G_deleteStart + '到' + G_deleteEnd + '的 ”' + G_deleteName + '“ 异常');

    chart.xAxis[0].removePlotBand(G_selectPbId);
    updateOL();
    G_selectPbId = null;
}

function deleteECGExc(id, name1) {
    var chart = $('#ecgChart').highcharts();
    chart.xAxis[0].removePlotBand(id);
    G_selectPbId = null;

    var pagenow1 = $("#pagenow").val();
    var memberid1 = $("#memberid").val();
    var eventid = $("#eventid").val();
    
    var url = "";
    if($("#ecgType").val() == "miecg"){
    	url = "../electrocardio/deleteExcElectrocardio";
    }else if($("#ecgType").val() == "ecg"){
    	url = "../electrocardioPulse/deleteExcElectrocardio";
    }else{
    	return;
    }
    
    $.post(url, {
            objectId: id,
            pageNo: pagenow1,
            memberId: memberid1,
            eventId: eventid
        },
        function(data) {
        	if(data != null && data != ""){
        		var datas = eval(data)
                if (datas[0]["result"] == 1) {
                    alert("删除成功！");

                    appendTbody(datas, name1);
                } else {
                    alert("删除失败！");
                }
        	}
        });
}

//撤销
function Undo() {

    if (UndoList.data.length) {

        var obj = UndoList.data.pop();
        var obj2 = []; //UndoList.pointData.pop();
        var chart = $('#ecgChart').highcharts();
        BackList.pointData.push(chart.series[0].yData.slice(0));
        BackList.data.push(getPB(chart.xAxis[0].options.plotBands));
        BackList.operateList.push(UndoList.operateList.pop());

        console.time('undo');
        updateChart(obj, obj2);
        console.timeEnd('undo');
        updateOL();

    }

}

//返回
function Back() {
    if (BackList.data.length) {
        var obj = BackList.data.pop();

        var obj2 = []; //BackList.pointData.pop();

        var chart = $('#ecgChart').highcharts();
        //        UndoList.pointData.push(chart.series[0].yData.slice(0));
        UndoList.data.push(getPB(chart.xAxis[0].options.plotBands));
        UndoList.operateList.push(BackList.operateList.pop());
        updateChart(obj, obj2);
        updateOL();
    }
}
//初始化变量
function initVar() {
    G_selectPbId = null;
    G_selectStart = null;
    G_selectEnd = null;
    G_deleteStart = null;
    G_deleteEnd = null;
    G_deleteName = null;
    UndoList = {
        pointData: [],
        data: [],
        operateList: []
    };
    BackList = {
        pointData: [],
        data: [],
        operateList: []
    };
}

function getStatus(ly, docentry) {
	var url = "";
    if($("#ecgType").val() == "miecg"){
    	url = "../electrocardio/getOrginalElectrocardioData";
    }else if($("#ecgType").val() == "ecg"){
    	url = "../electrocardioPulse/getOrginalElectrocardioData";
    }else{
    	return;
    }
    
	$.post(
			url, 
			{docentry : docentry}, 
			function (data, textStatus){
					var obj = JSON.parse(data);
					var length = obj.length -1;
					var status = obj[length].status;
					if(status != 0) {
						clearInterval(oTimer);
						layer.close(ly);
						if(status == 1) {
							alert('分析失败');
							
						}else if(status == 2) {
							alert('分析成功');
							initECG();
				            var content = obj.slice(0,length);
				            appendTbody(content, false);
				            initVar();
				            updateOL();
						}
					}
		
	});
}

//还原到最初
function reseChart() {
    var ly = layer.load(0);
    updateChart(BaseData.data, BaseData.pointData);
    initVar();
    updateOL();

    var pagenow1 = $("#pagenow").val();
    var memberid1 = $("#memberid").val();
    var eventid = $("#eventid").val();
    
    var url = "";
    if($("#ecgType").val() == "miecg"){
    	url = "../electrocardio/renewOrginalElectrocardioChart";
    }else if($("#ecgType").val() == "ecg"){
    	url = "../electrocardioPulse/renewOrginalElectrocardioChart";
    }else{
    	return;
    }

    $.post(url, {
            pageNo: pagenow1,
            memberId: memberid1,
            eventId: eventid
        },
        function(data) {
        	if(data != null && data != ""){
        		var json = JSON.parse(data);
        		oTimer = setInterval(function() {getStatus(ly, json.docentry);}, 1000);
        	}
        });
}

//重新分析
function reannalyse() {
    var ly = layer.load(0);
    var chart = $('#ecgChart').highcharts();
    var obj = getPB(chart.xAxis[0].options.plotBands);
    var pagenow1 = $("#pagenow").val();
    var memberid1 = $("#memberid").val();
    var eventid = $("#eventid").val();

    var startTimes = '';
    var endTimes = '';
    var excNames = '';
    var pbTypes = '';
    var excData = '';
    var ids = '';
    var start = 0,
        end = 0;
    
    var url = "";
    if($("#ecgType").val() == "miecg"){
    	url = "../electrocardio/reanalysisElectrocardio";
    }else if($("#ecgType").val() == "ecg"){
    	url = "../electrocardioPulse/reanalysisElectrocardio";
    }else{
    	return;
    }
    
    for (var i = 0; i < obj.length; i++) {
        if (obj[i].startTime > obj[i].endTime) {
            start = obj[i].endTime;
            end = obj[i].startTime;
        } else {
            start = obj[i].startTime;
            end = obj[i].endTime;
        }

        if (i == 0) {
            startTimes += start;
            endTimes += end;
            excNames += obj[i].excName;
            pbTypes += obj[i].pbType;
            excData += obj[i].excData || [];
            ids += obj[i].id;
            continue;
        }

        startTimes += ',' + start;
        endTimes += ',' + end;
        excNames += ',' + obj[i].excName;
        pbTypes += ',' + obj[i].pbType;
        excData += '#' + obj[i].excData || [];
        ids += ',' + obj[i].id;

    }
    
    $.post(url, {
            startTimes: startTimes,
            endTimes: endTimes,
            excNames: excNames,
            pbTypes: pbTypes,
            excData: excData,
            ids: ids,
            pageNo: pagenow1,
            memberId: memberid1,
            eventId: eventid
        },
        function(data) {
        	if(data != null && data != ""){
        		initECG();
                var datas = JSON.parse(data);
                appendTbody(datas, false);
                initVar();
                updateOL();
                layer.close(ly);
                //layer.msg('更新成功',2, -1);
        	}
        });

}

// 重新加载心电测量指标
function appendTbody(datas, openName) {
    $("#tbody").html("");
    for (var i = 0; i < 12; i++) {
        $("#tbody").append("<tr><td>" + datas[i]["测量项"] + "</td><td>" + datas[i]["异常次数"] + "</td><td>" +
            datas[i]["异常比率"] + "%</td><td>" + (datas[i]["异常次数"] > 0 ? "<img src='../img/icon_add_16.png'>" : "") + "</td><td>" +
            (datas[i]["异常次数"] > 0 ? "<a href=\"javascript:showExtImgXdt('" + datas[i]['测量项'] +
                "',[" + datas[i]['异常Id'] + "],[" + datas[i]['异常时间'] + "],[" + datas[i]['异常毫秒'] + "]);\">异常详情</a>" : "") + "</td><tr>");
        if (openName && openName == datas[i]["测量项"]) {
            appendBox(datas[i]['异常Id'], datas[i]['异常时间'], datas[i]['异常毫秒'], datas[i]["测量项"]);
        }
    }
}

function zoomChart(alax, min, max) {
    chart.xAxis[0].setExtremes(min, max);

}

function addStartLine(chart, measureTime, cellHeight) {
    //心电图最前面一段标线
    var a1 = chart.xAxis[0].toPixels(measureTime + 50, true);
    var a2 = chart.yAxis[0].toPixels(0);
    var a3 = chart.xAxis[0].toPixels(measureTime + 200, true);
    var a4 = chart.yAxis[0].toPixels(0);
    var a5 = chart.yAxis[0].toPixels(cellHeight * 10);
    var a6 = chart.xAxis[0].toPixels(measureTime + 300, true);
    var a7 = chart.xAxis[0].toPixels(measureTime + 400, true);
    chart.renderer.path(['M', a1, a2, 'L', a3, a4, a3, a5, a6, a5, a6, a2, a7, a2])
        .attr({
            id: 'startLine',
            'stroke-width': 2,
            stroke: 'red'
        })
        .add();
}

function setChart(id, objDt) {
	console.log(objDt);
    var elist = [];
    var chartbox = $("#" + id),
        Hz = 1000 / objDt.fs,
        startdt = objDt.measureTime,
        startTime = "",
        endTime = "",
        pageDt = 6 * (objDt.page || 0 - 1) * 1000,
        maxValue = 2000,
        minValue = -2000,
        $report = $('#report'),
        chartWidth = objDt.width,
        chartHeight = objDt.height;

    startdt += pageDt;
    var cellHeight = 65.5; //(maxValue - minValue) / objDt.height * 10;
    switch (objDt.type) {
        case "ab_ecg":
            Hz = 6000 / objDt.data.length; //频率
            minValue = -1000;
            maxValue = 1000;
            break;
        case "ecg":
            minValue = -1000;
            maxValue = 1000;

            break;
        case "mi_ecg":
        	cellHeight = cellHeight / 16 * 13;
            minValue = -1700;
            maxValue = 1700;

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


    //心电 ecgChart
    if (chartbox.length > 0 && id == "ecgChart") {
        //      console.log(objDt)
        // 创建highcharts
        chart = new Highcharts.StockChart({
            chart: {
                //              reflow : false, //图会根据当窗口或者框架改变大小时而改变
                selectionMarkerFill: 'rgba(69,114,167,0.50)', //选中区域会有背景颜色
                renderTo: id, // 对应的div id
                animation: true,
                panning: false, //禁用放大
                //                pinchType: null, //禁用手势操作
                //                zoomType: 'x',
                panKey: 'shift',
                showAxes: false, //当一个空图动态的添加数据集时是否要显示轴，默认为false，不显示
                //                height: chartHeight,
                //                width: chartWidth,
                events: {
                    selection: function(evt) {
                        if (evt.xAxis && $("#isMove").val() === 'false') {
                            var selectStart = Math.round(evt.xAxis[0].min);
                            var selectEnd = Math.round(evt.xAxis[0].max);
                            G_selectStart = selectStart;
                            G_selectEnd = selectEnd;
                            this.xAxis[0].removePlotBand('selected');
                            this.xAxis[0].addPlotBand({
                                color: 'rgba(69, 114, 167, 0.25)',
                                id: 'selected',
                                from: selectStart,
                                to: selectEnd,
                                zIndex: 10,
                                label: {
                                    useHTML: true,
                                    textAlign: 'center',
                                    text: Highcharts.dateFormat('%H:%M:%S:%L',
                                        selectStart) + ' - ' + Highcharts.dateFormat('%H:%M:%S:%L',
                                        selectEnd) + '</br>时长：' + Highcharts.dateFormat('%S.%L秒',
                                        selectEnd - selectStart) + '</br>',
                                    align: 'center',
                                    verticalAlign: 'bottom',
                                    y: -100,
                                    style: {
                                        color: '#000',
                                        fontSize: 10,
                                    }
                                },
                            });
                        }
                        return false;
                    },
                    click: function(evt) {
                        if (clickDetected) {
                            fullScr();
                            clickDetected = false;
                        } else {
                            clickDetected = true;
                            setTimeout(function() {
                                clickDetected = false;
                            }, 200);
                        }
                        clearSelect();
                        //this.xAxis[0].removePlotBand('selected');
                    },
                    load: function() {
                        $("#startLine").remove();
                        addStartLine(this, objDt.measureTime, cellHeight);

                    },
                    redraw: function() {
                        $("#startLine").remove();
                        addStartLine(this, objDt.measureTime, cellHeight);
                    }
                },

            },
            // 选中缩放的地方
            rangeSelector: {
                buttons: [{
                    type: 'second',
                    count: 4,
                    text: '4秒'
                }, {
                    type: 'second',
                    count: 5,
                    text: '5秒'
                }, {
                    type: 'second',
                    count: 6,
                    text: '6秒'
                }],
                buttonTheme: {
                    width: 50
                },
                inputEnabled: true,
                inputDateFormat: '%Y-%m-%d %H:%M:%S',
                inputEditDateFormat: '%Y-%m-%d %H:%M:%S',
                inputBoxWidth: 160,
                selected: 2,
            },
            // 图表缩放导航
            navigator: {
                enabled: false,
            },
            exporting: {
                enabled: false
            },
            title: {
                text: null
            },
            yAxis: {
                id: 'a1',
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
                min: objDt.measureTime + 80,
                max: objDt.measureTime + 6000,
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
                //设置区域带 表示删除 或异常
                plotBands: [],
                showFirstLabel: false,
                labels: {
                    enabled: true, //是否显示x轴
                    step: 5,
                    //                    align: 'left',
                    //                    format: '{value:%H:%M:%S}',

                },
            },
            plotOptions: {
                series: {
                    connectNulls: false,
                    enableMouseTracking: false, //禁用鼠标轨迹跟踪功能
                    dataLabels: {
                        enabled: false //显示数据点的值
                    }
                }
            },

            series: [{
                type: 'spline',
                states: {
                    hover: {
                        enabled: false
                    }
                },
                pointStart: objDt.measureTime, // 第一个点的时间
                pointInterval: Hz, // 频率
                pointIntervalUnit: 'milliseconds',
                dashStyle: 'solid',
                data: objDt.data,

                lineWidth: 1,
                color: '#000',
                enabled: true
            }, { //心电图最前面一段标线
                type: 'line',
                states: {
                    hover: {
                        enabled: false
                    }
                },
                pointStart: objDt.measureTime + 80, // 第一个点的时间
                pointInterval: 80, // 频率

                dashStyle: 'solid',
                data: [], //[0, 0, cellHeight * 10, cellHeight * 10, 0, 0],
                step: 'left',
                lineWidth: 1,
                color: 'red',

            }],
            credits: {
                enabled: false
            },
            scrollbar: {
                //              liveRedraw: true,
                enabled: true,
                barBackgroundColor: 'gray',
                barBorderRadius: 7,
                barBorderWidth: 0,
                buttonBackgroundColor: 'gray',
                buttonBorderWidth: 0,
                buttonArrowColor: 'yellow',
                buttonBorderRadius: 7,
                rifleColor: 'gray',
                trackBackgroundColor: 'white',
                trackBorderWidth: 1,
                trackBorderColor: 'silver',
                trackBorderRadius: 7,
                minWidth: 30,
            }
        }, function(chart) {
            chart.renderer.text('10mm/mv    25mm/s', 80, 100)
                .css({
                    color: 'red',
                    fontSize: '16px'
                })
                .add();

            BaseData = {
                data: chart.xAxis[0].options.plotBands.slice(0),
                pointData: [] //chart.series[0].yData.slice(0)
            };
            chart.pointer.cmd = chart.pointer.onContainerMouseDown;
            chart.pointer.onContainerMouseDown = function(a) {
                if ($("#isMove").val() == 'false') {
                    this.zoomX = this.zoomHor = this.hasZoom = true;
                } else {
                    this.zoomX = this.zoomHor = this.hasZoom = false;
                }
                this.cmd(a);

            };
            //          console.log(chart.renderer);
            var group = chart.renderer.g().on("click", fullScr).on("mousemove",
                function() {
                    this.style.cursor = 'pointer';
                }).attr({
                position: 'absolute',
                zIndex: 999
            }).add();

            initECG();
            var dtBox = $(".highcharts-range-selector");
            dtBox.attr("readonly", "readonly");
            chart.renderer.image('../img/icnFullScr.png', '93%', '15%', 35, 35).add(group);
            $('#btn_move').css({
                'background': '#e7f0f9',
                'font-weight': 'bold '
            });
            $('#loadImg').hide();
            isOk = true;
        });
        //      console.log($('#ecgChart').width(), $('#ecgChart').height());
        //      chart.setSize($('#ecgChart').width(), $('#ecgChart').height());

    }
    /**
     * 异常心电
     */
    if (chartbox.length > 0 && id == "abEcgChart") {
        // 创建highcharts

        var chart = new Highcharts.StockChart({
            //            loading: {
            //                hideDuration: 1000,
            //                showDuration: 1000
            //            },
            chart: {
                //          reflow: false,//图会根据当窗口或者框架改变大小时而改变
                //              height : objDt.height,
                //              width : objDt.width,
                // animation: true,//是否开启动画
                renderTo: id, // 对应的div id
                panning: false, //禁用放大
                pinchType: '', //禁用手势操作
                zoomType: "",
                panKey: 'shift',

            },
            // 选中缩放的地方
            rangeSelector: {
                inputEnabled: true,
                buttons: [],
                buttonTheme: {
                    width: 50
                },
                inputDateFormat: '%Y-%m-%d %H:%M:%S:%L',
                inputBoxWidth: 160,
                //                inputEditDateFormat: '%Y-%m-%d %H:%M:%S:%L',
                selected: 0,
                // 格式化form 和TO
                // inputDateParser : function(value) {
                // value = value.split(/[:\.]/);
                // console.log(value);
                // return Date.UTC(2015, 05, 28, 11 + parseInt(value[0], 10),
                // 23 + parseInt(value[1], 10),
                // 05 + parseInt(value[2], 10), parseInt(value[3], 10));
                // }
            },
            // 图表缩放导航
            navigator: {
                enabled: false,
                margin: 10
            },
            exporting: {
                enabled: false
            },
            title: {
                text: ' '
            },
            yAxis: {
                min: minValue,
                max: maxValue,
                tickInterval: cellHeight * 5, // 每大格0.5 毫伏 500
                gridLineWidth: 1,
                gridLineColor: '#ff6a6a', // #ed7b10
                minorGridLineWidth: 0.5, // 次级网格线的宽度 0.5
                minorGridLineColor: '#eda8b7', // 次级网格线的颜色 b0a091
                minorTickInterval: cellHeight, // 次级网格的间隔 0.1毫伏 100
                labels: {
                    enabled: false
                        // 是否显示y轴
                }
            },
            tooltip: {
                enabled: false,
                crosshairs: false
                    //跟随光标的精准线
                    // valueDecimals: 2
            },
            xAxis: {
                type: 'datetime',
                //          minRange : 3000, // 最小放大比例 1S
                //                min: startdt,
                tickPixelInterval: 100, // 网格间隔宽度默认100
                tickLength: 0, // 刻度线的长度
                tickInterval: 200, // 每大格0.2S
                gridLineWidth: 1, // 网格线的宽度
                gridLineColor: '#ff6a6a', //网格线的颜色 #ed7b10
                minorGridLineColor: '#eda8b7', //次级网格线的颜色 b0a091
                minorGridLineWidth: 0.5, //次级网格线的宽度
                minorTickInterval: 40, //次级网格的间距 0.04S
                labels: {
                    enabled: false
                        //是否显示x轴
                }

            },
            series: [{
                type: 'line',
                states: {
                    hover: {
                        enabled: false
                    }
                },
                pointStart: objDt.measureTime + Hz, // 第一个点的时间
                pointInterval: Hz, // 频率
                pointIntervalUnit: 'milliseconds',
                data: objDt.data,
                lineWidth: 1,
                zones: [{
                    color: '#000000', //设置折线的颜色
                }],
                enabled: true
            }],
            credits: {
                enabled: false,

            },
            scrollbar: {
                enabled: false
            }
        });
        var dtBox = $(".highcharts-range-selector");
        dtBox.attr("readonly", "readonly");
    }

    //瞬时心率图 instantChart hr_ecg
    if (chartbox.length > 0 && id == "instantChart") {
        chartbox.highcharts({
            chart: {
                type: 'line',
                plotBackgroundColor: 'rgba(238, 254, 238, 1)',
                plotBorderColor: '#000',
                plotBorderWidth: 1,
                height: chartHeight,
                width: chartWidth,
            },
            title: {
                text: ' ',
            },
            xAxis: {
                type: 'datetime',
                labels: {
                    // step: 2,
                    enabled: false,
                    format: '{value:%H:%M:%S}'
                },
                tickWidth: 1,
                tickLength: 0,
                tickColor: '#000',
                lineColor: '#000',
                lineWidth: 1,
            },
            yAxis: {
                // offset: 5,
                min: minValue,
                max: maxValue,
                tickInterval: 25, //每大格25
                gridLineWidth: 0,
                tickWidth: 1,
                tickLength: 5,
                tickColor: '#000',
                // lineColor: '#000',
                // lineWidth: 1,
                title: {
                    text: ' '
                },
                plotLines: [{
                    value: 55,
                    width: 1,
                    color: 'red',
                    zIndex: 1,
                    label: {
                        text: '正常值范围 55 ~ 100',
                        y: -20,
                        align: 'center',
                        style: {
                            color: 'red',
                            fontSize: 18
                        },

                    }
                }, {
                    value: 100,
                    width: 1,
                    color: 'red'
                }, ]
            },

            plotOptions: {
                line: {
                    dataLabels: {
                        enabled: false,
                    },
                    enableMouseTracking: false,
                    marker: {
                        enabled: false,
                    }
                }
            },
            exporting: {
                enabled: false
            },
            series: [{
                data: objDt.data,
                pointStart: startdt,
                pointInterval: 10 * 1000,
                lineWidth: 1,
                zones: [{
                    color: '#000' //设置折线的颜色
                }],
            }],
            credits: {
                enabled: false,
            },
            legend: {
                enabled: false,
            },
        });
        var chart = chartbox.highcharts();
        chart.setTitle({
            text: startTime + " 至 " + endTime
        });
    }
    //脉搏波图 sphygmusChart ppg
    if (chartbox.length > 0 && id == "sphygmusChart") {
        chartbox.highcharts({
            chart: {
                type: 'line',
                plotBackgroundColor: 'rgba(238, 254, 238, 1)',
                plotBorderColor: '#000',
                plotBorderWidth: 1,
                height: objDt.height,
                width: objDt.width,
            },
            title: {
                text: ' ',
            },
            xAxis: {
                labels: {
                    step: 5,
                    align: 'left',
                    format: '{value:%Y-%m-%d %H:%M:%S}'
                },
                type: 'datetime',
                tickWidth: 1,
                tickLength: 5,
                tickColor: '#000',
                lineColor: '#000',
                lineWidth: 1,
            },
            yAxis: {
                labels: {
                    enabled: false,
                },
                min: minValue,
                max: maxValue,
                tickInterval: 22, //每大格22
                gridLineWidth: 0,
                tickWidth: 0,
                tickLength: 5,
                tickColor: '#000',
                title: {
                    text: ' '
                },
            },

            plotOptions: {
                line: {
                    dataLabels: {
                        enabled: false,
                    },
                    enableMouseTracking: false,
                    marker: {
                        enabled: false,
                    }
                }
            },
            exporting: {
                enabled: false
            },
            series: [{
                data: objDt.data,
                pointStart: startdt,
                pointInterval: Hz,
                lineWidth: 1,
                zones: [{
                    color: '#000' //设置折线的颜色
                }],
            }],
            credits: {
                enabled: false,
            },
            legend: {
                enabled: false,
            },
        });
        //        var chart = chartbox.highcharts();
        //        chart.setTitle({
        //            text: Highcharts.dateFormat('%Y-%m-%d %H:%M:%S:%L', chart.series[0].xAxis.min) + " 至 " + Highcharts.dateFormat('%Y-%m-%d %H:%M:%S:%L', chart.series[0].xAxis.max)
        //        });
    }
    // 瞬时脉率图  instantSphygmusChart hr_ppg
    if (chartbox.length > 0 && id == "instantSphygmusChart") {
        chartbox.highcharts({
            chart: {
                type: 'line',
                plotBackgroundColor: 'rgba(238, 254, 238, 1)',
                plotBorderColor: '#000',
                plotBorderWidth: 1,
                height: chartHeight,
                width: chartWidth,
            },
            title: {
                text: ' ',
            },
            xAxis: {
                labels: {
                    // step: 2,
                    enabled: false,
                    format: '{value:%H:%M:%S}'
                },
                type: 'datetime',
                //                tickWidth: 0,
                tickLength: 0,
                //                tickColor: '#000',
                lineColor: '#000',
                lineWidth: 1,
            },
            yAxis: {
                // offset: 5,
                min: minValue,
                max: maxValue,
                tickInterval: 25, //每大格25
                gridLineWidth: 0,
                tickWidth: 1,
                tickLength: 5,
                tickColor: '#000',
                title: {
                    text: ' '
                },
                plotLines: [{
                    value: 55,
                    width: 1,
                    color: 'red',
                    zIndex: 1,
                    label: {
                        text: '正常值范围 55 ～ 100',
                        y: -20,
                        align: 'center',
                        style: {
                            color: 'red',
                            fontSize: 18
                        },

                    }
                }, {
                    value: 100,
                    width: 1,
                    color: 'red'
                }, ]
            },

            plotOptions: {
                line: {
                    dataLabels: {
                        enabled: false,
                    },
                    enableMouseTracking: false,
                    marker: {
                        enabled: false,
                    }
                }
            },
            exporting: {
                enabled: false
            },
            series: [{
                data: objDt.data,
                pointStart: startdt,
                pointInterval: 1,
                lineWidth: 1,
                zones: [{
                    color: '#000' //设置折线的颜色
                }],
            }],
            credits: {
                enabled: false,
            },
            legend: {
                enabled: false,
            },
        });
        var chart = chartbox.highcharts();
        chart.setTitle({
            text: startTime + " 至 " + endTime
        });
    }

//    console.timeEnd('setChart');
}

$(function() {
    //  $('#btn_full').bind("click", fullScr);
    $('#btn_addExc').bind("click", addExc);

    $('#btn_delExc').bind("click", RemoveExc);
    $('#btn_delECG').bind("click", deleteECG);
    $('#btn_undo').bind("click", Undo);
    $('#btn_back').bind("click", Back);
    $('#btn_rese').bind("click", reseChart);
    $('#btn_reanalyse').bind("click", reannalyse);
    $('#btn_move').bind("click", moveECG);
    $('#btn_select').bind("click", cheEcg);
    //    $('#btn_zoomIn').bind("click", zoomIn);
    //    $('#btn_zoomOut').bind("click", zoomOut);
    //    $('#btn_zoomReset').bind("click", zoomReset);
    //      $('#ecgChart').bind('dblclick', fullScr);
    $(document).keyup(function(event) {
        if ($('.chart-container').hasClass('modal'))
            switch (event.keyCode) {
                case 27:
                    fullScr();
                    break;
            }
    });
});
