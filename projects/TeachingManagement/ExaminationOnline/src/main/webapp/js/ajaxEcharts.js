/**
 * Created by 朱高 on 2017/3/25.
 */
$(function () {
    //生成图片面板，讲图像显示在面板中
    $('#main').panel({
        width: 640,
        height: 460,
        title: '成绩信息查询1',
        toolbar: '#manager_tool',
        tools: [{
            iconCls: 'icon-add',
            handler: function () {
                alert('new')
            }
        }, {
            iconCls: 'icon-save',
            handler: function () {
                alert('save')
            }
        }]
    });
    $('#main1').panel({
        width: 500,
        height: 460,
        title: '测光日本',
        toolbar: '#manager_tool',
        tools: [{
            iconCls: 'icon-add',
            handler: function () {
                alert('new')
            }
        }, {
            iconCls: 'icon-save',
            handler: function () {
                alert('save')
            }
        }]
    });

    //为班级生成一个combotree将所有的班级显示出来，按照JAVA、UI、H5三大类进行划分
    $("input[name='className']").combotree({
        url: "className",
        valueField: 'id',//传递的值
        textField: 'text',//显示的值
        //required : true,//是否必填
        lines: true,//是否显示虚线
        //multiple : true,//是否支持多选
        //checkbox : true,//选择的正方形的小框
        onlyLeafCheck: true,//只能选取叶子结点
        //不为叶子节点不让选上
        onBeforeSelect: function (node) {
            //node.target代表的是选取的结点
            //node代表整个结点对象
            if (!$(this).tree('isLeaf', node.target)) {
                return false;
            }
        },
        //
        onClick: function (node) {
            //在点击选择的时候进行判断是不是叶子结点不是就显示下拉框
            if (!$(this).tree('isLeaf', node.target)) {
                $("#className").combo('showPanel');
            }
        },
        onLoadSuccess: function (node, data) {
            var _this = this;
            if (data) {
                $(data).each(function (index, value) {
                    if (this.state === 'closed') {
                        $(_this).tree('expandAll');
                    }
                });
            }
        }
    });
    $("input[name='testPhase']").combobox({
        url: "json/testPhase.json",
        valueField: 'id',//传递的值
        textField: 'text',//显示的值
        //mode : "remote",//定义是够从服务器加载
        filter: function (q, row) {
            var opts = $(this).combobox('options');
            return row[opts.textField].indexOf(q) >= 0;
        }
    });
    $("input[name='stuName']").combobox({
        //url : "testPhase.json"
    });
    //在点击搜素的时候执行的js代码将数据传递到后台中
    $("#search").click(function () {
        var className = $("input[name='className']").val();
        var testPhase = $("input[name='testPhase']").val();
        var stuName = $("input[name='stuName']").val();
        var _url = null;
        _url = "searchGrade";
        $.ajax({
            url: _url,
            type: "post",
            dataType: "json",
            data: {
                className: className,
                testPhase: testPhase,
                stuName: stuName
            },
            beforeSend: function () {
                $.messager.progress({
                    text: '正在查询中...',
                });
            },
            success: function (data, response, status) {
                $.messager.progress('close');
                var _data = data;
                echartsContent("班级考试信息", "阶段", "平均分", "echartsTest");
                if (data !== null) {
                    $("#stuName").combobox({
                        valueField: 'id',//传递的值
                        textField: 'text',//显示的值
                        data: _data,
                        filter: function (q, row) {
                            var opts = $(this).combobox('options');
                            return row[opts.textField].indexOf(q) >= 0;
                        }
                    });
                    var data = $('#stuName').combobox('getData');//获取下拉数据
                    $("#stuName ").combobox('select', data[0].text);//选中第一条数据
                } else {
                    $.messager.alert("查询学生信息失败", "未知错误导致失败", "warning");
                }
            }
        })
    });
    echartsContent("java班级考试信息", "阶段", "平均分", "echartsTest");
    echartsContent1("java班级考试信息", "阶段", "平均分", "searchPie");
    function echartsContent(text, x_name, y_name, _url) {
        var myCharts = echarts.init($("#main")[0]);
        myCharts.setOption({
            title: {
                text: text
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
                name: x_name
            },
            yAxis: {
                type: "value",
                name: y_name
            },
            series: []
        });
        myCharts.showLoading();//显示加载
        $.ajax({
            url: _url,
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
                    series1.push(tp);
                }
                console.log(series1);
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
    }

    function echartsContent1(text, x_name, y_name, _url) {
        var myCharts = echarts.init($("#main1")[0]);
        myCharts.setOption({
            title: {
                text: text
            },
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            toolbox: {
                feature: {//各工具配置项。
                    dataView: {show: true, readOnly: false},//展现表格的数据
                    //magicType : {show : true, type : ["line", "bar"]},//动态切换类型
                    //restore : {show : true},//还原
                    saveAsImage: {show: true}//保存图片
                }
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                top: 30,
                data: []
            },
            series: [{
                type: "pie",
                radius: '55%',
                center: ['50%', '60%'],
                data: []
            }]
        });
        myCharts.showLoading();//显示加载
        $.ajax({
            url: _url,
            type: "get",
            dataType: "json",
            success: function (data, response, status) {
                myCharts.hideLoading();//隐藏加载

                var series1 = [];

                for (var i = 0; i < data.length; i++) {
                    series1.push(data[i].name);
                }
                console.log(series1);
                myCharts.setOption({
                    legend: {
                        data: series1
                    },
                    series: [
                        {
                            data: data
                        }
                    ]
                });
            }
        });
    }
});