/**
 * 留言审核脚本
 *
 * Created by lws on 2017/4/19.
 */

$(function () {
    prepareTools();
    prepareDatagrid();
});

function prepareTools() {
    $('#message-search-status').combobox({
        url: 'MessageStatuses',
        valueField: 'id',
        textField: 'dictionaryName'
    });
    $('.message-search').searchbox({
        searcher: search
    });
}

function prepareDatagrid() {
    $('#message-data').datagrid({
        url: 'GetMessages',
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
            {field: 'messageContent', title: '留言内容', width: 1010, fixed: true},
            {field: 'from', title: '留言人', width: 10},
            {field: 'to', title: '留言对象', width: 10},
            {field: 'messageTime', title: '留言时间', width: 15, sortable: true},
            {field: 'status', title: '审核状态', width: 10, sortable: true}
        ]],
        toolbar: '#message-tool'
    });
}

function search() {
    console.log(getSearchText());
}

function getSearchText() {
    return {
        date: $('#message-search-time').datebox('getValue'),
        status: $('#message-search-status').combobox('getValue'),
        content: $('#message-search-content').searchbox('getValue').trim(),
        from: $('#message-search-from').searchbox('getValue').trim(),
        to: $('#message-search-to').searchbox('getValue').trim()
    };
}
