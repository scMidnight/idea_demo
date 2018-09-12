// 基于准备好的dom，初始化echarts实例
var carChart = echarts.init(document.getElementById('carSys'));
var cityChart = echarts.init(document.getElementById('city'));
var provChart = echarts.init(document.getElementById('prov'));
carChart.showLoading();
cityChart.showLoading();
provChart.showLoading();
var carSysOption = {
    title: {
        text: '车系:Top20',
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
        name: '车系:Top20',
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
        text: '城市:Top20',
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
        name: '城市:Top20',
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
},provOption = {
    title: {
        text: '省份:Top20',
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
        name: '省份:Top20',
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
function carSysShow() {
    $.ajax({
        url:_baseContextPath + "/car/dataStatistics/carSys",
        dataType:"json",
        type:"post",
        data: {dateVal: dateVal, type: "carSys"},
        success:function (result) {
            if(result.status == "N") {
                // carChart.clear();
                // $("#carSys").html("暂无数据");
                // $("#carSys").addClass("nullShow");
                carSysOption.series[0].data = [];
                carChart.setOption(carSysOption);
                $("#carSysInfo").hide();
            }else {
                carSysOption.series[0].data = result.pieData;
                carChart.hideLoading();
                carChart.setOption(carSysOption);
                $("#carSysInfo").show();
            }
        }
    });
}
function cityShow() {
    $.ajax({
        url:_baseContextPath + "/car/dataStatistics/carSys",
        dataType:"json",
        type:"post",
        data: {dateVal: dateVal, type: "city"},
        success:function (result) {
            if(result.status == "N") {
                // carChart.clear();
                // $("#city").html("暂无数据");
                // $("#city").addClass("nullShow");
                cityOption.series[0].data = [];
                cityChart.setOption(cityOption);
                $("#cityInfo").hide();
            }else {
                cityOption.series[0].data = result.pieData;
                cityChart.hideLoading();
                cityChart.setOption(cityOption);
                $("#cityInfo").show();
            }
        }
    });
}
function provShow() {
    $.ajax({
        url:_baseContextPath + "/car/dataStatistics/carSys",
        dataType:"json",
        type:"post",
        data: {dateVal: dateVal, type: "prov"},
        success:function (result) {
            if(result.status == "N") {
                provOption.series[0].data = [];
                provChart.setOption(provOption);
                $("#provInfo").hide();
            }else {
                provOption.series[0].data = result.pieData;
                provChart.hideLoading();
                provChart.setOption(provOption);
                $("#provInfo").show();
            }
        }
    });
}
carSysShow();
cityShow();
provShow();