/**
 * 评价分析脚本
 *
 * Created by lws on 2017/3/27.
 */

$(function () {
    $('#analysis-data1').treegrid({
        url: 'data/evaluation.json',
        fitColumns: true,
        idField: 'id',
        treeField: 'name',
        showFooter: true,
        rownumbers: true,
        frozenColumns: [[
            {field: 'name', title: '姓名', width: 160},
            {field: 'class', title: '所属班级', width: 150},
            {field: 'total', title: '总分', width: 80},
            {field: 'average', title: '平均分', width: 80}
        ]],
        columns: [[
            {field: 'advice', title: '建议'}
        ]],
        toolbar: [{
            text: '<input id="analysis-search" style="width: 300px">'
        }],
        onLoadSuccess: function (row, data) {
            $.each(data, function (i) {
                $('#analysis-data1').treegrid('collapseAll', data[i].id);
            });
        }
    });

    $('#analysis-search').searchbox({
        searcher: function (value, name) {
            console.log(name + ':' + value);
        },
        menu: '#analysis-search-option',
        prompt: '请输入搜索内容'
    });

    $('#analysis-data2').datagrid({
        url: 'data/evaluation-detail.json',
        fitColumns: true,
        columns: [[
            {field: 'evaluation', title: '评价项', width: 30},
            {field: 'time', title: '评价时间', width: 20},
            {field: 'score', title: '评分', width: 20},
            {field: 'satisfaction', title: '满意度', width: 20}
        ]]
    });
});