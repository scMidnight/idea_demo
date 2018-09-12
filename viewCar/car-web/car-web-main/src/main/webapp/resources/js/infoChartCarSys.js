// 基于准备好的dom，初始化echarts实例
var provChart = echarts.init(document.getElementById('prov'));
var cityChart = echarts.init(document.getElementById('city'));

provChart.showLoading();
cityChart.showLoading();

var provOption = {
    title: {
        text: carSysName + '车系:省份比例',
        x:'center'
    },
    tooltip: {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend:{
        type:'scroll',
        orient: 'vertical',
        right: 50,
        top: 20,
        bottom: 20
    },
    series: [{
        name: carSysName + '车系:省份比例',
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
},cityOption = {
    title: {
        text: carSysName + '车系:城市比例',
        x:'center'
    },
    tooltip: {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend:{
        type:'scroll',
        orient: 'vertical',
        right: 50,
        top: 20,
        bottom: 20
    },
    series: [{
        name: carSysName + '车系:城市比例',
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
function provChartShow() {
    $.ajax({
        url:_baseContextPath + "/car/dataStatistics/infoChart",
        dataType:"json",
        type:"post",
        data: {dateVal: dateVal, type: "prov", id: id},
        success:function (result) {
            if(result.status == "N") {
                provOption.series[0].data = [];
                provChart.setOption(provOption);
            }else {
                provOption.series[0].data = result.pieData;
                provChart.hideLoading();
                provChart.setOption(provOption);
            }
        }
    });
}
function cityChartShow() {
    $.ajax({
        url:_baseContextPath + "/car/dataStatistics/infoChart",
        dataType:"json",
        type:"post",
        data: {dateVal: dateVal, type: "city", id: id},
        success:function (result) {
            if(result.status == "N") {
                cityOption.series[0].data = [];
                cityChart.setOption(cityOption);
            }else {
                cityOption.series[0].data = result.pieData;
                cityChart.hideLoading();
                cityChart.setOption(cityOption);
            }
        }
    });
}
provChartShow();
cityChartShow();