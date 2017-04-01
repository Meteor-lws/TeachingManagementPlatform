/**
 * 通用工具脚本
 *
 * Created by lws on 2017/3/31.
 */

var util = {};

util.isEmpty = function (str) {
    return !(str && str.replace(/(^s*)|(s*$)/g, '').length !== 0);
};

util.datagrid = function (id, url, columns, tools) {
    $('#' + id).datagrid({
        url: url,
        fit: true,
        fitColumns: true,
        striped: true,
        rownumbers: true,
        border: false,
        pagination: true,
        pageSize: 20,
        pageNumber: 1,
        columns: [columns],
        toolbar: tools
    });
};

util.bindSearchOption = function (id, searcher) {
    $('#' + id).searchbox({
        searcher: searcher,
        menu: '#' + id + '-option',
        prompt: '请输入搜索内容'
    });
};
