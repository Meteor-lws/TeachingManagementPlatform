/**
 * 留言审核脚本
 *
 * Created by lws on 2017/3/31.
 */

$(function () {
    showContent();
    bindSearchOption();
});

function showContent() {
    $('#message-content').datagrid({
        url: '',
        fit: true,
        fitColumns: true,
        striped: true,
        rownumbers: true,
        border: false,
        pagination: true,
        pageSize: 20,
        pageNumber: 1,
        columns: [[
            {field: 'id', checkbox: true},
            {field: 'content', title: '留言内容', width: 60},
            {field: 'from', title: '留言人', width: 10},
            {field: 'to', title: '留言对象', width: 10},
            {field: 'time', title: '留言时间', width: 20}
        ]],
        toolbar: [{
            iconCls: 'icon-remove',
            text: '删除',
            width: 65,
            handler: function () {
            }
        }, {
            text: '<input id="message-search" style="width: 300px">'
        }]
    });
}

function bindSearchOption() {
    $('#message-search').searchbox({
        searcher: function (value, name) {
            console.log(name + ':' + value);
        },
        menu: '#message-search-option',
        prompt: '请输入搜索内容'
    });
}
