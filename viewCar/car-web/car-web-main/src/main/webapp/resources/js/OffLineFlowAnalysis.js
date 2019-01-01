var flowAralysisChart = echarts.init(document.getElementById('flowAnalysisChart'));
flowAralysisChart.showLoading();
// 指定图表的配置项和数据
var flowAralysisOption = {
    title: {
        text: ''
    },
    tooltip: {
        trigger: 'axis'
    },
    legend: {
        data:['线下流量']
    },
    grid: {
        left: '5%',
        right: '5%',
        bottom: '15%',
        containLabel: true
    },
    toolbox: {
        feature: {
            saveAsImage: {show: true}
        }
    },
    xAxis: {
        type: 'category',
        boundaryGap: false,
        data: []
    },
    yAxis: {
        type: 'value'
    },
    dataZoom:[
        {
            type: 'slider',
            start: 10,
            end: 40
        },
        {
            type: 'inside',
            start: 10,
            end: 40
        }
    ],
    series: []
};
function flowAnalysisShow() {
    $.ajax({
        url:_baseContextPath + "/offLine/chart",
        dataType:"json",
        type:"post",
        data: {dateVal: dateChartVal, dateType: dateChartType},
        success:function (result) {
            if(result.status == "N") {
                flowAralysisChart.hideLoading();
                layer.msg(result.msg);
            }else {
                flowAralysisOption.xAxis.data = result.xAxisData;
                flowAralysisOption.series = result.series;
                flowAralysisChart.hideLoading();
                flowAralysisChart.setOption(flowAralysisOption);
            }
        }
    });
}
flowAnalysisShow();

var demo = {
    title: {
        text: ''
    },
    tooltip: {
        trigger: 'axis'
    },
    legend: {
        data:['曝光','点击']
    },
    grid: {
        left: '5%',
        right: '5%',
        bottom: '15%',
        containLabel: true
    },
    toolbox: {
        feature: {
            saveAsImage: {show: true}
        }
    },
    xAxis: {
        type: 'category',
        boundaryGap: false,
        data: ['周一','周二','周三','周四','周五','周六','周日','周一1','周二2','周三3','周四4','周五5','周六6','周日7']
    },
    yAxis: {
        type: 'value'
    },
    dataZoom:[
        {
            type: 'slider',
            start: 10,
            end: 60
        },
        {
            type: 'inside',
            start: 10,
            end: 60
        }
    ],
    series: [
        {
            name:'曝光',
            type:'line',
            stack:'量',
            data:[120, 132, 101, 134, 90, 230, 210,1201, 1322, 1013, 1344, 905, 2306, 2107]
        },
        {
            name:'点击',
            type:'line',
            stack:'量',
            data:[120, 132, 101, 134, 90, 230, 210,1201, 1322, 1013, 1344, 905, 2306, 2107]
        }
    ]
};