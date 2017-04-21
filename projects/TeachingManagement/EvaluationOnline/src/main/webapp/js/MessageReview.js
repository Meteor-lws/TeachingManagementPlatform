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
        multiSort: true,
        rownumbers: true,
        pagination: true,
        pageSize: 25,
        pageList: [10, 15, 20, 25, 30],
        pageNumber: 1,
        columns: [[
            {field: 'id', checkbox: true},
            {field: 'messageContent', title: '留言内容', width: 1010, fixed: true},
            {field: 'from', title: '留言人', width: 10, sortable: true},
            {field: 'to', title: '留言对象', width: 10, sortable: true},
            {field: 'messageTime', title: '留言时间', width: 15, sortable: true},
            {field: 'status', title: '审核状态', width: 10, sortable: true}
        ]],
        toolbar: '#message-tool'
    });
}

function search() {
    $('#message-data').datagrid({
        queryParams: {
            searchParams: JSON.stringify(getSearchText())
        }
    });
}

function getSearchText() {
    var searchText = {};
    searchText.messageTime = $('#message-search-time').datebox('getValue');
    searchText.messageStatus = $('#message-search-status').combobox('getValue');
    searchText.messageContent = $('#message-search-content').searchbox('getValue').trim();
    searchText.from = $('#message-search-from').searchbox('getValue').trim();
    searchText.to = $('#message-search-to').searchbox('getValue').trim();
    return searchText;
}
