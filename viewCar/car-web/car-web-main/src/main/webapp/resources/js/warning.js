// 基于准备好的dom，初始化echarts实例
var bigLibChart = echarts.init(document.getElementById('bigLib'));
var bigLibCountChart = echarts.init(document.getElementById('bigLibCount'));
var carSysChart = echarts.init(document.getElementById('carSys'));
var phoneChart = echarts.init(document.getElementById('phone'));
var blackChart = echarts.init(document.getElementById('black'));

bigLibChart.showLoading();
bigLibCountChart.showLoading();
carSysChart.showLoading();
phoneChart.showLoading();
blackChart.showLoading();

var bigLibOption = {
    title: {
        text: '大库重复组/数量占比',
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
        name: '大库重复组/数量占比',
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
},bigLibCountOption = {
    title: {
        text: '大库重复次数占比',
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
        name: '大库重复次数占比',
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
},carSysOption = {
    title: {
        text: '车系重复占比',
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
        name: '车系重复占比',
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
},phoneOption = {
    title: {
        text: '号段错误占比',
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
        name: '号段错误占比',
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
},blackOption = {
    title: {
        text: '黑名单占比',
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
        name: '黑名单占比',
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

function bigLibShow() {
    $.ajax({
        url:_baseContextPath + "/car/warning",
        dataType:"json",
        type:"post",
        data: {dateVal: dateVal, type: "bigLib"},
        success:function (result) {
            if(result.status == "N") {
                bigLibOption.series[0].data = [];
                bigLibChart.setOption(bigLibOption);
            }else {
                bigLibOption.series[0].data = result.pieData;
                bigLibChart.hideLoading();
                bigLibChart.setOption(bigLibOption);
            }
        }
    });
}
function bigLibCountShow() {
    $.ajax({
        url:_baseContextPath + "/car/warning",
        dataType:"json",
        type:"post",
        data: {dateVal: dateVal, type: "bigLibCount"},
        success:function (result) {
            if(result.status == "N") {
                bigLibCountOption.series[0].data = [];
                bigLibCountChart.setOption(bigLibCountOption);
            }else {
                bigLibCountOption.series[0].data = result.pieData;
                bigLibCountChart.hideLoading();
                bigLibCountChart.setOption(bigLibCountOption);
            }
        }
    });
}
function carSysShow() {
    $.ajax({
        url:_baseContextPath + "/car/warning",
        dataType:"json",
        type:"post",
        data: {dateVal: dateVal, type: "carSys"},
        success:function (result) {
            if(result.status == "N") {
                carSysOption.series[0].data = [];
                carSysChart.setOption(carSysOption);
            }else {
                carSysOption.series[0].data = result.pieData;
                carSysChart.hideLoading();
                carSysChart.setOption(carSysOption);
            }
        }
    });
}
function phoneShow() {
    $.ajax({
        url:_baseContextPath + "/car/warning",
        dataType:"json",
        type:"post",
        data: {dateVal: dateVal, type: "phone"},
        success:function (result) {
            if(result.status == "N") {
                phoneOption.series[0].data = [];
                phoneChart.setOption(phoneOption);
            }else {
                phoneOption.series[0].data = result.pieData;
                phoneChart.hideLoading();
                phoneChart.setOption(phoneOption);
            }
        }
    });
}
function blackShow() {
    $.ajax({
        url:_baseContextPath + "/car/warning",
        dataType:"json",
        type:"post",
        data: {dateVal: dateVal, type: "black"},
        success:function (result) {
            if(result.status == "N") {
                blackOption.series[0].data = [];
                blackChart.setOption(blackOption);
            }else {
                blackOption.series[0].data = result.pieData;
                blackChart.hideLoading();
                blackChart.setOption(blackOption);
            }
        }
    });
}
bigLibShow();
bigLibCountShow();
carSysShow();
phoneShow();
blackShow();