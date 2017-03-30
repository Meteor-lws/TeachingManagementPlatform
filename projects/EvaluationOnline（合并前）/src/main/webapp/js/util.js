/**
 * 通用工具脚本
 *
 * Created by lws on 2017/3/27.
 */

var util = {};

util.isStringEmpty = function (str) {
    return !(str && str.replace(/(^s*)|(s*$)/g, '').length !== 0);
};

util.getSelectedRows = function (id) {
    var datagrid = $('#' + id);
    var result = null;
    var rows = datagrid.datagrid('getSelections');
    if (rows.length > 0) {
        result = [];
        $.each(rows, function (index, data) {
            result.push({'index': datagrid.datagrid('getRowIndex', data), 'data': data});
        });
    }
    return result;
};

util.deleteSelectedRows = function (id) {
    var selectedRows = util.getSelectedRows(id);
    if (selectedRows) {
        var i = 0;
        $.each(selectedRows, function (index, data) {
            $('#' + id).datagrid('deleteRow', data.index - (i++));
        });
    }
};
