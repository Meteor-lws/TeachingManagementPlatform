/**
 * 评价分析脚本
 *
 * Created by lws on 2017/3/31.
 */

$(function () {
    prepareResult();
    prepareDetail();
});

function prepareResult() {
    var frozenColumns = [
        {field: 'name', title: '姓名', width: 200},
        {field: 'class', title: '班级', width: 120},
        {field: 'total', title: '总分', width: 80},
        {field: 'average', title: '平均分', width: 80}
    ];
    var columns = [
        {field: 'advice', title: '建议'}
    ];
    util.treegrid('analysis-result', 'GetAnalysisResults', frozenColumns, columns, '#analysis-tool', 'id', 'name');
}

function prepareDetail() {
    var columns = [
        {field: 'evaluation', title: '评价项', width: 30},
        {field: 'time', title: '评价时间', width: 20},
        {field: 'score', title: '评分', width: 20},
        {field: 'satisfaction', title: '满意度', width: 20}
    ];
    util.datagrid('analysis-detail', '', [], columns);
}
