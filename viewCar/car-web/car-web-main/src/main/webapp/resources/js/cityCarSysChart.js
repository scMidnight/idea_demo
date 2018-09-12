// 基于准备好的dom，初始化echarts实例
var cityCarSysChart = echarts.init(document.getElementById('cityCarSys'));

cityCarSysChart.showLoading();

var cityCarSysOption = {
    title: {
        text: cityName + ':车系比例',
        x:'center'
    },
    tooltip: {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend:{
        type:'scroll',
        orient: 'vertical',
        right: 100,
        top: 20,
        bottom: 20
    },
    series: [{
        name: cityName + ':车系比例',
        type: 'pie',
        clockwise:'true',
        startAngle:'0',
        radius : ['20%','60%'],
        center: ['40%', '50%'],
        data: [],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }]
};
function cityCarSysShow() {
    $.ajax({
        url:_baseContextPath + "/car/dataStatistics/infoChart",
        dataType:"json",
        type:"post",
        data: {dateVal: dateVal, type: "cityCarSys", id: id},
        success:function (result) {
            if(result.status == "N") {
                cityCarSysOption.series[0].data = [];
                cityCarSysChart.setOption(cityCarSysOption);
            }else {
                cityCarSysOption.series[0].data = result.pieData;
                cityCarSysChart.hideLoading();
                cityCarSysChart.setOption(cityCarSysOption);
            }
        }
    });
}
cityCarSysShow();