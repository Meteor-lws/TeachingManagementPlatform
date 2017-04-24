/**
 * 评价分析脚本
 *
 * Created by lws on 2017/3/31.
 */

$(function () {
    prepareTools();
    prepareResults();
    prepareDetail();
});

function prepareTools() {
    $('.analysis-search').searchbox({
        searcher: search
    });
}

function prepareResults() {
    var columns = [
        {field: 'userName', title: '姓名', width: 200},
        {field: 'className', title: '班级', width: 120},
        {field: 'evaluationScore', title: '总分', width: 80},
        {field: 'averageScore', title: '平均分', width: 80},
        {field: 'evaluationFeedback', title: '建议'}
    ];
    util.treegrid('analysis-result', 'GetAnalysisResults', [], columns, '#analysis-tool', 'id', 'userName');
    $('#analysis-result').treegrid({
        onClickRow: function (row) {
            console.log(row);
            $('#analysis-detail').datagrid({
                queryParams: {
                    id: row.id,
                    time: row.evaluationTime
                }
            });
        }
    });
}

function prepareDetail() {
    var columns = [
        {field: 'evaluationItem', title: '评价项', width: 50},
        {field: 'evaluationTime', title: '评价时间', width: 10},
        {field: 'evaluationScore', title: '评分', width: 5},
        {field: 'satisfaction', title: '满意度', width: 5}
    ];
    util.datagrid('analysis-detail', 'GetAnalysisDetails', [], columns);
}

function search() {
    var searchText = getSearchText();
    $('#analysis-result').treegrid({
        queryParams: {
            className: searchText.className,
            teacherName: searchText.teacherName,
            studentName: searchText.studentName
        }
    });
}

function getSearchText() {
    return {
        className: $('#analysis-search-class').searchbox('getValue').trim(),
        teacherName: $('#analysis-search-teacher').searchbox('getValue').trim(),
        studentName: $('#analysis-search-student').searchbox('getValue').trim()
    };
}
