//创建异常心电图
function createABEcg(id, i, excObj, page, data, docentry) {
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
		chart : {
			width: 1024,
			height : 300,
			renderTo : id + i
		//渲染到容器
		},
//		pr_id : id,
//		pr_i : i,
//		docentry : docentry,
//		page : page,
//		excObj : excObj,
		title : {
			text : '异常发生时间: ' + excObj.extimes + '  异常类型：' + excObj.expCname,
			verticalAlign : 'bottom',
			margin : 0,
			y : -20,
			x : -20
		//center
		},
		yAxis : {
			min : minValue,
			max : maxValue,
			tickInterval : cellHeight * 5, // 每大格0.5 毫伏 500
			gridLineWidth : 1,
			gridLineColor : '#ff6a6a', // #ed7b10
			minorGridLineWidth : 1, // 次级网格线的宽度 0.8
			minorGridLineColor : '#eda8b7', // 次级网格线的颜色 b0a091
			minorTickInterval : cellHeight, // 次级网格的间隔 0.1毫伏 100
			minorGridLineDashStyle : "shortdot", //次级网格线是点线
			labels : {
				enabled : false
			},
			title : {
				text : ''
			}
		},
		tooltip : {
			enabled : false,
			crosshairs : false
		//跟随光标的精准线
		},
		xAxis : {
			type : 'datetime',
			// minRange : 5000, // 最小放大比例 1S
			// min: objDt.measureTime,
			// max: objDt.measureTime ,
			//tickPixelInterval: 500, // 网格间隔宽度默认100
			tickLength : 0, // 刻度线的长度
			//                minTickInterval: 1000,
			tickInterval : 200, // 每大格0.2S   
			gridLineWidth : 1, // 网格线的宽度
			gridLineColor : '#ff6a6a', //网格线的颜色 #ed7b10
			minorGridLineColor : '#eda8b7', //次级网格线的颜色 b0a091
			minorGridLineWidth : 1, //次级网格线的宽度
			minorGridLineDashStyle : "shortdot", //次级网格线是点线
			minorTickInterval : 40, //次级网格的间距 0.04S
			labels : {
				enabled : false, //是否显示x轴

			},
		},
		plotOptions : {
			series : {
				connectNulls : false,
				enableMouseTracking : false, //禁用鼠标轨迹跟踪功能
				dataLabels : {
					enabled : false
				//显示数据点的值
				}
			}
		},
		legend : {
			enabled : false
		},
		credits : {
			enabled : false
		},
		exporting : {
			enabled : false
		},
		series : [ {
			states : {
				hover : {
					enabled : false
				}
			},
			pointStart : 1439193863073, // 第一个点的时间
			pointInterval : Hz, // 频率
			pointIntervalUnit : 'milliseconds',

			data : data.data,
			lineWidth : 1,
			color : '#000',
		} ],

	});
	/*//下一页
	var group1 = chart.renderer
			.g()
			.on(
					"click",
					function() {
						if (chart.options.page++ >= chart.options.excObj.objectId.length - 1) {
							chart.options.page = chart.options.excObj.objectId.length - 1;
							return;
						}
						getExcData(chart.options.docentry,
								chart.options.excObj, chart.options.page,
								chart.options.pr_id, chart.options.pr_i);
					}).attr({
				position : 'absolute',
				zIndex : 999
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
				getExcData(chart.options.docentry, chart.options.excObj,
						chart.options.page, chart.options.pr_id,
						chart.options.pr_i);

			}).attr({
		position : 'absolute',
		zIndex : 999
	}).add();
	chart.renderer.image('../img/banner_shadow_left.png', '0', '45%', 30, 30)
			.add(group2);*/
	return chart.getSVG();
}

function getExcData(docentry, excObj, page, id, i) {
	$.post("../electrocardioPulse/getPreviewExcElectrocardioChartData", {
		docentry : docentry,
		objectId : excObj.objectIds,
		measTime : excObj.extMss,
	}, function(data) {
		var obj = JSON.parse(data);
		if (!obj.data || obj.data.length <= 0) {
			return;
		}
		var svg = createABEcg(id, i, excObj, page, obj, docentry);
		shy_exc_List[i] = svg;
	});
}

function exportWord(memberid, eventid) {
	var shy_exc_Obj = {"shy_exc": false, svg: []};
	$("input[name='charts']:checkbox:checked").each(function(i, e) {
		if(e.value === 'shy_exc') {
			shy_exc_Obj.shy_exc = true;
			shy_exc_Obj.svg.push(shy_exc_List[$(e).attr("cindex")]);
		}
	});
	
	var chart = $('#ecgChart').highcharts();
	var ecgChartSvg = {svgEcg : ""};
	if(typeof(chart) != "undefined"){
		ecgChartSvg = {svgEcg : chart.getSVG()};
	}
	
	var url = "../electrocardioPulse/getElectrocardioPulseSVGData";
    $.ajax({
        url: url,
        type: "post",
        data: {
            jsonStr: JSON.stringify(shy_exc_Obj),
            jsonStrEcg: JSON.stringify(ecgChartSvg)
        },
        success: function(data) {
        	if(data == "1"){
        		window.location = "../electrocardioPulse/exportElectrocardioPulseWordData?memberId="+ memberid + "&eventId=" + eventid;
        	}
            
        }
    });
}