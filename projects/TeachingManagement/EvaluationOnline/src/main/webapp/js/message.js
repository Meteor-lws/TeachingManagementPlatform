/**
 * 留言审核脚本
 *
 * Created by lws on 2017/3/31.
 */

$(function () {
    showContent();
    util.bindSearchOption('message-search', search);
});

function showContent() {
    var columns = [
        {field: 'id', checkbox: true},
        {field: 'content', title: '留言内容', width: 60},
        {field: 'type', title: '留言类型', width: 10},
        {field: 'from', title: '留言人', width: 10},
        {field: 'to', title: '留言对象', width: 10},
        {field: 'time', title: '留言时间', width: 20}
    ];

    var tools = [{
        iconCls: 'icon-remove',
        text: '删除',
        width: 65,
        handler: function () {
            var rows = util.selectedRows('message-content');
            if (rows) {
                remove(rows);
            } else {
                $.messager.alert('提示', '请选择要删除的评价项', 'warning');
            }
        }
    }, {
        text: '<input id="message-search" style="width: 300px">'
    }];

    util.datagrid('message-content', 'messageData', columns, tools);
}

function remove(rows) {
    $.ajax({
        type: 'post',
        url: 'removeMessage',
        data: {'messages': rows},
        success: function () {
            $('#message-content').datagrid('reload');
        },
        error: function () {
            alert('删除留言失败');
        }
    });
}

function search(value, name) {
    console.log(name + ':' + value);
}
