//血压异常分布图
$(function () {
    $('#left-top').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: '血压异常分布图'
        },
        credits:{
     		enabled:false // 禁用版权信息
		},
        tooltip: {
    	    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    color: '#000000',
                    connectorColor: '#000000',
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %'
                },
                 center: ["50%", "50%"],
                 size: 150,
                 showInLegend: true
            }
        },
         legend: {
            layout: 'vertical',
            backgroundColor: 'white',
            align: 'right',
            verticalAlign: 'top',
            y: 60,
            x: -10,
            borderWidth: 1,
            borderRadius: 0,
            floating: true,
            draggable: true,
            zIndex: 20
        },
        series: [{
            type: 'pie',
            name: ' 血压值',
            data: [
                ['正常血压',   20.62],
                ['正常高压',       59.79],
                {
                    name: '高血压',
                    y: 10.31,
                    sliced: true,
                    selected: true
                },
                ['1级高血压（轻度）',    3.09],
                ['2级高血压（中度）',     1.03],
                ['3级高血压（重度）',   0.00],
                ['单纯收缩期高血压',   5.15]
            ]
        }],
    });
});	
//8点前
$(function () {
    $('#left-northwest').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: '8点前'
        },
        credits:{
            enabled:false // 禁用版权信息
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    color: '#000000',
                    connectorColor: '#000000',
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %'
                },
                 center: ["50%", "50%"],
                 size: 60,
                 showInLegend: true
            }
        },
        series: [{
            type: 'pie',
            name: '血压值',
            data: [
                ['正常',   85.10],
                ['偏低',       9.10],
                {
                    name: '偏高',
                    y: 5.80,
                    sliced: true,
                    selected: true
                }
            ]
        }],
    });
});
//8-12点
$(function () {
    $('#left-northeast').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: '8-12点'
        },
        credits:{
            enabled:false // 禁用版权信息
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    color: '#000000',
                    connectorColor: '#000000',
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %'
                },
                 center: ["50%", "50%"],
                 size: 60,
                 showInLegend: true
            }
        },
        series: [{
            type: 'pie',
            name: '血压值',
            data: [
                ['正常',   55.10],
                ['偏低',       7.10],
                {
                    name: '偏高',
                    y: 10.90,
                    sliced: true,
                    selected: true
                }
            ]
        }],
    });
});
//12-18点
$(function () {
    $('#left-southwest').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: '12-18点'
        },
        credits:{
            enabled:false // 禁用版权信息
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    color: '#000000',
                    connectorColor: '#000000',
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %'
                },
                 center: ["50%", "50%"],
                 size: 60,
                 showInLegend: true
            }
        },
        series: [{
            type: 'pie',
            name: '血压值',
            data: [
                ['正常',   45.60],
                ['偏低',       68.50],
                {
                    name: '偏高',
                    y: 20.23,
                    sliced: true,
                    selected: true
                }
            ]
        }],
    });
});
//18点以后
$(function () {
    $('#left-southeast').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: '18点以后'
        },
        credits:{
            enabled:false // 禁用版权信息
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    color: '#000000',
                    connectorColor: '#000000',
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %'
                },
                 center: ["50%", "50%"],
                 size: 60,
                 showInLegend: true
            }
        },
        series: [{
            type: 'pie',
            name: '血压值',
            data: [
                ['正常',   80.60],
                ['偏低',       18.50],
                {
                    name: '偏高',
                    y: 45.23,
                    sliced: true,
                    selected: true
                }
            ]
        }],
    });
});  
//24小时血压分布图     
$(function () {                                                                                  
    $('#right-top').highcharts({                                                             
        chart: {                                                                             
            type: 'scatter',                                                                 
            zoomType: 'xy'                                                                   
        },                                                                                   
        title: {                                                                             
            text: '24小时血压分布图'                        
        },  
        credits:{
            enabled:false // 禁用版权信息
        },                                                                                
        subtitle: {                                                                          
            text: ' '                                                      
        },                                                                                   
        xAxis: {  
            gridLineWidth: 1, 
            lineColor: '#000',
            tickColor: '#000',
            labels: {
                style: {
                color: '#000',
                font: '11px Trebuchet MS, Verdana, sans-serif'
            }
        },                                                                          
            title: {                                                                         
                enabled: true,                                                               
                text: '24小时'                                                          
            },                                                                               
            startOnTick: true,                                                               
            endOnTick: true,                                                                 
            showLastLabel: true                                                              
        },                                                                                   
        yAxis: {
            minorTickInterval: 'auto',
            lineColor: '#000',
            lineWidth: 1,
            tickWidth: 1,
            tickColor: '#000',
            labels: {
            style: {
                color: '#000',
                font: '11px Trebuchet MS, Verdana, sans-serif'
            },
        },                                                                             
         title: {                                                                         
            text: '血压值'                                                          
        },
        
            plotLines:[
                       {
                color:'yellow',            //线的颜色，定义为红色
                dashStyle:'',     //默认是值，这里定义为长虚线
                value:90,              //定义在那个值上显示标示线，这里是在x轴上刻度为3的值处垂直化一条线
                width:3,               //标示线的宽度，2px
                label:{
                    text:'值',     //标签的内容
                    align:'left',                //标签的水平位置，水平居左,默认是水平居中center
                    x:-20,                         //标签相对于被定位的位置水平偏移的像素，重新定位，水平居左10px
                    style:{
                        fontSize:'14px',
                        fontWeight:'bold'
                    }
                },
                events:{
                    click:function(e){
                        alert("yAxis plotLine Clicked!");
                        //当标示线被单击时，触发的事件
                    },
                    mouseover:function(){
                        console.log("yAxis plotLine Hovered!");
                        //当标示线被鼠标悬停时，触发的事件
                    },
                
                    mouseout:function(){
                        //当标示线被鼠标移出时，触发的事件
                    },
                    
                    mousemove:function(){
                        //当标示线被鼠标移动(时，触发的事件
                    }
                }
            },
             {
                color:'red',            //线的颜色，定义为红色
                dashStyle:'',     //默认是值，这里定义为长虚线
                value:140,              //定义在那个值上显示标示线，这里是在x轴上刻度为3的值处垂直化一条线
                width:3,               //标示线的宽度，2px
                label:{
                    text:'值',     //标签的内容
                    align:'left',                //标签的水平位置，水平居左,默认是水平居中center
                    x:-20,                         //标签相对于被定位的位置水平偏移的像素，重新定位，水平居左10px
                    style:{
                        fontSize:'14px',
                        fontWeight:'bold'
                    }
                },
                events:{
                    click:function(e){
                        alert("yAxis plotLine Clicked!");
                        //当标示线被单击时，触发的事件
                    },
                    mouseover:function(){
                        console.log("yAxis plotLine Hovered!");
                        //当标示线被鼠标悬停时，触发的事件
                    },
                
                    mouseout:function(){
                        //当标示线被鼠标移出时，触发的事件
                    },
                    
                    mousemove:function(){
                        //当标示线被鼠标移动(时，触发的事件
                    }
                }
            },{
                color:'green',            //线的颜色，定义为红色
                dashStyle:'',     //默认是值，这里定义为长虚线
                value:60,              //定义在那个值上显示标示线，这里是在x轴上刻度为3的值处垂直化一条线
                width:3,               //标示线的宽度，2px
                label:{
                    text:'值',     //标签的内容
                    align:'left',                //标签的水平位置，水平居左,默认是水平居中center
                    x:-20,                         //标签相对于被定位的位置水平偏移的像素，重新定位，水平居左10px
                    style:{
                        fontSize:'14px',
                        fontWeight:'bold'
                    }
                },
                events:{
                    click:function(e){
                        alert("yAxis plotLine Clicked!");
                        //当标示线被单击时，触发的事件
                    },
                    mouseover:function(){
                        console.log("yAxis plotLine Hovered!");
                        //当标示线被鼠标悬停时，触发的事件
                    },
                
                    mouseout:function(){
                        //当标示线被鼠标移出时，触发的事件
                    },
                    
                    mousemove:function(){
                        //当标示线被鼠标移动(时，触发的事件
                    }
                }
            }]  
        },                                                                                   
        legend: {                                                                            
            layout: 'vertical',                                                              
            align: 'left',                                                                   
            verticalAlign: 'top',                                                            
            x: 100,                                                                          
            y: 70,                                                                           
            floating: true,                                                                  
            backgroundColor: '#FFFFFF',                                                      
            borderWidth: 1                                                                   
        },                                                                                   
        plotOptions: {                                                                       
            scatter: {                                                                       
                marker: {                                                                    
                    radius: 5,                                                               
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
                tooltip: {                                                                   
                    headerFormat: '<b>{series.name}</b><br>',                                
                    pointFormat: '{point.x}h, {point.y} mmHg'                                
                }                                                                            
            }                                                                                
        },                                                                                   
        series: [{                                                                           
            name: '收缩压',                                                                  
            color: 'rgba(223, 83, 83, .5)',                                                  
            data: [[2, 98], [5, 120],[7, 113], [9, 140],[12, 135], [15, 124],[17, 135], [18, 133]]   
                                                                                             
        }, {                                                                                 
            name: '舒张压',                                                                    
            color: 'rgba(119, 152, 191, .5)',                                                
            data: [[2, 65], [5, 70],[7, 69], [9, 75],[12, 65], [15, 78],[17, 77], [18, 68], [19, 62]]                                                
        }
        ]                                                                                   
    });                                                                                      
});     






//各级血压次数                        			
$(function () {
    $('#right-bottom').highcharts({
        chart: {
            type: 'column',
            margin: [ 50, 50, 100, 80]
        },
        title: {
            text: '各级血压次数'
        },
        xAxis: {
             gridLineWidth: 1, 
            lineColor: '#000',
            tickColor: '#000',
            categories: [
                '正常血压',
                '正常高值',
                '高血压',
                '1级高血压（轻度）',
                '2级高血压（中度）',
                '3级高血压（重度）',
                '单纯收缩期高血压'
            ],
            labels: {
                rotation: -45,
                align: 'right',
                style: {
                    fontSize: '13px',
                    fontFamily: 'Verdana, sans-serif'
                }
            }
        },
        yAxis: {
            minorTickInterval: 'auto',
            lineColor: '#000',
            lineWidth: 1,
            tickWidth: 1,
            tickColor: '#000',
            min: 0,
            title: {
                text: '次数'
            }
        },
        legend: {
            enabled: false
        },
        tooltip: {
            pointFormat: '<b>{point.y:1f} 次</b>',
        },
        credits:{
            enabled:false // 禁用版权信息
        },
        series: [{
            name: 'Population',
            data: [20,59,10,3,1,2,5],
            dataLabels: {
                enabled: true,
                rotation: -90,
                color: '#FFFFFF',
                align: 'right',
                x: 4,
                y: 10,
                style: {
                    fontSize: '13px',
                    fontFamily: 'Verdana, sans-serif',
                    textShadow: '0 0 3px black'
                }
            }
        }],
    });
});


/*
$(function () {                                                                                  
    $('#leftimgtime').highcharts({                                                             
        chart: {                                                                             
            type: 'scatter',                                                                 
            zoomType: 'xy'                                                                   
        },                                                                                   
        title: {                                                                             
            text: '24小时血压分布图'                        
        },  
        credits:{
            enabled:false // 禁用版权信息
        },                                                                                
        subtitle: {                                                                          
            text: ' '                                                      
        },                                                                                   
        xAxis: {  
            gridLineWidth: 1, 
            lineColor: '#000',
            tickColor: '#000',
            labels: {
                style: {
                color: '#000',
                font: '11px Trebuchet MS, Verdana, sans-serif'
            }
        },                                                                          
            title: {                                                                         
                enabled: true,                                                               
                text: '24小时'                                                          
            },                                                                               
            startOnTick: true,                                                               
            endOnTick: true,                                                                 
            showLastLabel: true                                                              
        },                                                                                   
        yAxis: {
            minorTickInterval: 'auto',
            lineColor: '#000',
            lineWidth: 1,
            tickWidth: 1,
            tickColor: '#000',
            labels: {
            style: {
                color: '#000',
                font: '11px Trebuchet MS, Verdana, sans-serif'
            },
        },                                                                             
         title: {                                                                         
            text: '血压值'                                                          
        },
        
            plotLines:[
                       {
                color:'yellow',            //线的颜色，定义为红色
                dashStyle:'',     //默认是值，这里定义为长虚线
                value:90,              //定义在那个值上显示标示线，这里是在x轴上刻度为3的值处垂直化一条线
                width:3,               //标示线的宽度，2px
                label:{
                    text:'值',     //标签的内容
                    align:'left',                //标签的水平位置，水平居左,默认是水平居中center
                    x:-20,                         //标签相对于被定位的位置水平偏移的像素，重新定位，水平居左10px
                    style:{
                        fontSize:'14px',
                        fontWeight:'bold'
                    }
                },
                events:{
                    click:function(e){
                        alert("yAxis plotLine Clicked!");
                        //当标示线被单击时，触发的事件
                    },
                    mouseover:function(){
                        console.log("yAxis plotLine Hovered!");
                        //当标示线被鼠标悬停时，触发的事件
                    },
                
                    mouseout:function(){
                        //当标示线被鼠标移出时，触发的事件
                    },
                    
                    mousemove:function(){
                        //当标示线被鼠标移动(时，触发的事件
                    }
                }
            },
             {
                color:'red',            //线的颜色，定义为红色
                dashStyle:'',     //默认是值，这里定义为长虚线
                value:140,              //定义在那个值上显示标示线，这里是在x轴上刻度为3的值处垂直化一条线
                width:3,               //标示线的宽度，2px
                label:{
                    text:'值',     //标签的内容
                    align:'left',                //标签的水平位置，水平居左,默认是水平居中center
                    x:-20,                         //标签相对于被定位的位置水平偏移的像素，重新定位，水平居左10px
                    style:{
                        fontSize:'14px',
                        fontWeight:'bold'
                    }
                },
                events:{
                    click:function(e){
                        alert("yAxis plotLine Clicked!");
                        //当标示线被单击时，触发的事件
                    },
                    mouseover:function(){
                        console.log("yAxis plotLine Hovered!");
                        //当标示线被鼠标悬停时，触发的事件
                    },
                
                    mouseout:function(){
                        //当标示线被鼠标移出时，触发的事件
                    },
                    
                    mousemove:function(){
                        //当标示线被鼠标移动(时，触发的事件
                    }
                }
            },{
                color:'green',            //线的颜色，定义为红色
                dashStyle:'',     //默认是值，这里定义为长虚线
                value:60,              //定义在那个值上显示标示线，这里是在x轴上刻度为3的值处垂直化一条线
                width:3,               //标示线的宽度，2px
                label:{
                    text:'值',     //标签的内容
                    align:'left',                //标签的水平位置，水平居左,默认是水平居中center
                    x:-20,                         //标签相对于被定位的位置水平偏移的像素，重新定位，水平居左10px
                    style:{
                        fontSize:'14px',
                        fontWeight:'bold'
                    }
                },
                events:{
                    click:function(e){
                        alert("yAxis plotLine Clicked!");
                        //当标示线被单击时，触发的事件
                    },
                    mouseover:function(){
                        console.log("yAxis plotLine Hovered!");
                        //当标示线被鼠标悬停时，触发的事件
                    },
                
                    mouseout:function(){
                        //当标示线被鼠标移出时，触发的事件
                    },
                    
                    mousemove:function(){
                        //当标示线被鼠标移动(时，触发的事件
                    }
                }
            }]  
        },                                                                                   
        legend: {                                                                            
            layout: 'vertical',                                                              
            align: 'left',                                                                   
            verticalAlign: 'top',                                                            
            x: 100,                                                                          
            y: 70,                                                                           
            floating: true,                                                                  
            backgroundColor: '#FFFFFF',                                                      
            borderWidth: 1                                                                   
        },                                                                                   
        plotOptions: {                                                                       
            scatter: {                                                                       
                marker: {                                                                    
                    radius: 5,                                                               
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
                tooltip: {                                                                   
                    headerFormat: '<b>{series.name}</b><br>',                                
                    pointFormat: '{point.x}h, {point.y} mmHg'                                
                }                                                                            
            }                                                                                
        },                                                                                   
        series: [{                                                                           
            name: '收缩压',                                                                  
            color: 'rgba(223, 83, 83, .5)',                                                  
            data: [[2, 98], [5, 120],[7, 113], [9, 140],[12, 135], [15, 124],[17, 135], [18, 133]]   
                                                                                             
        }, {                                                                                 
            name: '舒张压',                                                                    
            color: 'rgba(119, 152, 191, .5)',                                                
            data: [[2, 65], [5, 70],[7, 69], [9, 75],[12, 65], [15, 78],[17, 77], [18, 68], [19, 62]]                                                
        }
        ]                                                                                   
    });                                                                                      
});  


$(function () {
    $('#leftimgorder').highcharts({
        chart: {
            type: 'column',
            margin: [ 50, 50, 100, 80]
        },
        title: {
            text: '各级血压次数'
        },
        xAxis: {
             gridLineWidth: 1, 
            lineColor: '#000',
            tickColor: '#000',
            categories: [
                '正常血压',
                '正常高值',
                '高血压',
                '1级高血压（轻度）',
                '2级高血压（中度）',
                '3级高血压（重度）',
                '单纯收缩期高血压'
            ],
            labels: {
                rotation: -45,
                align: 'right',
                style: {
                    fontSize: '13px',
                    fontFamily: 'Verdana, sans-serif'
                }
            }
        },
        yAxis: {
            minorTickInterval: 'auto',
            lineColor: '#000',
            lineWidth: 1,
            tickWidth: 1,
            tickColor: '#000',
            min: 0,
            title: {
                text: '次数'
            }
        },
        legend: {
            enabled: false
        },
        tooltip: {
            pointFormat: '<b>{point.y:1f} 次</b>',
        },
        credits:{
            enabled:false // 禁用版权信息
        },
        series: [{
            name: 'Population',
            data: [20,59,10,3,1,2,5],
            dataLabels: {
                enabled: true,
                rotation: -90,
                color: '#FFFFFF',
                align: 'right',
                x: 4,
                y: 10,
                style: {
                    fontSize: '13px',
                    fontFamily: 'Verdana, sans-serif',
                    textShadow: '0 0 3px black'
                }
            }
        }],
    });
});*/

//堆叠图
/*$(function () {
    $('#rightimgorder').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: '各级血压次数'
        },
        xAxis: {
            categories: ['Apples', 'Oranges', 'Pears', 'Grapes', 'Bananas']
        },
        yAxis: {
            min: 0,
            title: {
                text: 'Total fruit consumption'
            },
            stackLabels: {
                enabled: true,
                style: {
                    fontWeight: 'bold',
                    color: (Highcharts.theme && Highcharts.theme.textColor) || 'gray'
                }
            }
        },
        legend: {
            align: 'right',
            x: -70,
            verticalAlign: 'top',
            y: 20,
            floating: true,
            backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColorSolid) || 'white',
            borderColor: '#CCC',
            borderWidth: 1,
            shadow: false
        },
        tooltip: {
            formatter: function() {
                return '<b>'+ this.x +'</b><br>'+
                    this.series.name +': '+ this.y +'<br>'+
                    'Total: '+ this.point.stackTotal;
            }
        },
        plotOptions: {
            column: {
                stacking: 'normal',
                dataLabels: {
                    enabled: true,
                    color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || 'white'
                }
            }
        },
        series: [{
            name: 'John',
            data: [5, 3, 4, 7, 2]
        }, {
            name: 'Jane',
            data: [2, 2, 3, 2, 1]
        }, {
            name: 'Joe',
            data: [3, 4, 4, 2, 5]
        }]
    });
});*/