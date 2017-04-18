/**
 * 评价项管理脚本
 *
 * Created by lws on 2017/3/31.
 */

$(function () {
    prepareDialog();
    prepareDatagrid();
});

function prepareDialog() {
    $('#item-content').textbox();
    $('#item-type').combobox({
        url: 'getEvaluationItemTypes',
        limitToList: true,
        valueField: 'id',
        textField: 'dictionaryName',
        onChange: function () {
            $('#item-type').combobox('reload');
        }
    });
}

function prepareDatagrid() {
    $('#item-data').datagrid({
        url: 'getEvaluationItems',
        fit: true,
        fitColumns: true,
        striped: true,
        remoteSort: false,
        rownumbers: true,
        pagination: true,
        pageSize: 25,
        pageList: [10, 15, 20, 25, 30],
        pageNumber: 1,
        columns: [[
            {field: 'id', checkbox: true},
            {field: 'itemContent', title: '评价项', width: 70},
            {field: 'enable', title: '是否启用', width: 10},
            {field: 'type', title: '评价类型', width: 20, sortable: true}
        ]],
        toolbar: '#item-tool'
    });
}