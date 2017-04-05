/**
 * Created by 朱高 on 2017/3/25.
 */
$(function () {
    var myCharts = echarts.init($("#main")[0]);
    myCharts.setOption({
        title: {
            text: "学生信息"
        },
        tooltip: {},
        toolbox: {
            feature: {//各工具配置项。
                dataView: {show: true, readOnly: false},//展现表格的数据
                magicType: {show: true, type: ["line", "bar"]},//动态切换类型
                restore: {show: true},//还原
                saveAsImage: {show: true}//保存图片
            }
        },
        legend: {
            data: []
        },
        xAxis: {
            data: [],
            name: "考试科目"
        },
        yAxis: {
            type: "value",
            name: "分数"
        },
        series: []
    });
    myCharts.showLoading();//显示加载
    $.ajax({
        url: "echartsTest",
        type: "get",
        success: function (data, response, status) {
            myCharts.hideLoading();//隐藏加载
            var obj = $.parseJSON(data);
            var Item = function () {
                return {
                    name: "张三",
                    type: "bar",
                    data: []
                }
            };
            var series1 = [];
            for (var i = 0; i < obj.data.length; i++) {
                var tp = new Item();

                tp.name = obj.legend[i];
                tp.data = obj.data[i];
                if (i === 0) {
                    tp.type = "bar";
                } else {
                    tp.type = "line";
                }

                console.log(tp);
                series1.push(tp);
            }
            myCharts.setOption({
                legend: {
                    data: obj.legend
                },
                xAxis: {
                    data: obj.categories
                },
                series: series1
            });
        }
    });
});