/**
 * 评价分析脚本
 *
 * Created by lws on 2017/3/31.
 */

$(function () {
    prepareResults();
    prepareDetail();
});

function prepareResults() {
    var frozenColumns = [
        {field: 'userName', title: '姓名', width: 200},
        {field: 'className', title: '班级', width: 120},
        {field: 'evaluationScore', title: '总分', width: 80},
        {field: 'averageScore', title: '平均分', width: 80}
    ];
    var columns = [
        {field: 'evaluationFeedback', title: '建议'}
    ];
    util.treegrid('analysis-result', 'GetAnalysisResults', frozenColumns, columns, '#analysis-tool', 'id', 'userName');
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
