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
        url: '',
        fit: true,
        fitColumns: true,
        striped: true,
        rownumbers: true,
        pagination: true,
        pageSize: 20,
        pageNumber: 1,
        columns: [
            {},
            {}
        ],
        toolbar: ''
    });
}