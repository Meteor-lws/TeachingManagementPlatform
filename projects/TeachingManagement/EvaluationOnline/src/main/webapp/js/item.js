/**
 * 评价项管理脚本
 *
 * Created by lws on 2017/3/31.
 */

$(function () {
    showDatagrid();
    bindSearchOption();
    bindEvaluationType();
});

function showDatagrid() {
    $('#item-content').datagrid({
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
            {field: 'content', title: '评价项', width: 70},
            {field: 'enable', title: '是否启用', width: 10},
            {field: 'type', title: '评价类型', width: 20}
        ]],
        toolbar: [{
            iconCls: 'icon-add',
            text: '添加',
            width: 65,
            handler: function () {
            }
        }, {
            iconCls: 'icon-edit',
            text: '修改',
            width: 65,
            handler: function () {
            }
        }, {
            iconCls: 'icon-remove',
            text: '删除',
            width: 65,
            handler: function () {
            }
        }, {
            text: '<input id="item-search" style="width: 300px">'
        }]
    });
}

function bindSearchOption() {
    $('#item-search').searchbox({
        searcher: function (value, name) {
            console.log(name + ':' + value);
        },
        menu: '#item-search-option',
        prompt: '请输入搜索内容'
    });
}

function bindEvaluationType() {
    $('#evaluation-type').combobox({
        url: '',
        valueField: 'id',
        textField: 'type',
        limitToList: true
    });
}
