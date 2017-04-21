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
        limitToList: true,
        valueField: 'id',
        textField: 'dictionaryName',
        onSelect: function (status) {
            search(status.id);
        }
    });
    $('#message-search-time').datebox({
        onSelect: function () {
            search();
        }
    });
    $('.message-search').searchbox({
        searcher: function () {
            search();
        }
    });
    $('#message-pass').click(function () {
        updateMessagesStatus(true);
    });
    $('#message-fail').click(function () {
        updateMessagesStatus(false);
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
            {field: 'messageContent', title: '留言内容', width: 100},
            {field: 'from', title: '留言人', width: 10, sortable: true},
            {field: 'to', title: '留言对象', width: 10, sortable: true},
            {field: 'messageTime', title: '留言时间', width: 20, sortable: true},
            {field: 'status', title: '审核状态', width: 10, sortable: true}
        ]],
        toolbar: '#message-tool'
    });
}

function search(messageStatus) {
    var searchText = getSearchText();
    if (messageStatus) {
        searchText.messageStatus = messageStatus;
    }
    $('#message-data').datagrid({
        queryParams: {
            searchParams: JSON.stringify(searchText)
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

function updateMessagesStatus(status) {
    var selections = getSelections();
    if (selections) {
        $.messager.confirm('提示', '确认当前审核结果正确？', function (choice) {
            if (choice) {
                ajax('UpdateMessagesStatus', {selections: JSON.stringify(selections), status: status}, function () {
                    $('#message-data').datagrid('reload');
                }, '更新留言审核结果失败');
            }
        });
    } else {
        $.messager.alert('警告', '请选择要审核的留言', 'warning');
    }
}

function getSelections() {
    var selections = $('#message-data').datagrid('getSelections');
    return selections.length > 0 ? selections : null;
}

function ajax(url, data, success, error) {
    $.ajax({
        type: 'post',
        url: url,
        data: data,
        beforeSend: function () {
            $('<div class="datagrid-mask"></div>').css({
                display: 'block',
                width: '100%',
                height: $(window).height()
            }).appendTo('body');
            $('<div class="datagrid-mask-msg"></div>').html('正在处理，请稍候。。。').appendTo('body').css({
                display: 'block',
                left: ($(document.body).outerWidth - 190) / 2,
                top: ($(window).height() - 45) / 2
            });
        },
        success: function (data) {
            success(data);
        },
        error: function () {
            $.messager.alert('错误', error, 'error');
        },
        complete: function () {
            $('.datagrid-mask').remove();
            $('.datagrid-mask-msg').remove();
        }
    });
}
