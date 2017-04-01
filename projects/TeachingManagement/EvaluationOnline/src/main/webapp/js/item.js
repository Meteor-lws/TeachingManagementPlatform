/**
 * 评价项管理脚本
 *
 * Created by lws on 2017/3/31.
 */

$(function () {
    showDatagrid();
    util.bindSearchOption('item-search', search);
    bindEvaluationType();
});

function add() {
    showDialog(null);
}

function edit() {
    showDialog(1);
}

function remove() {

}

function search(value, name) {
    console.log(name + ':' + value);
}

function showDatagrid() {
    var columns = [
        {field: 'id', checkbox: true},
        {field: 'content', title: '评价项', width: 70},
        {field: 'enable', title: '是否启用', width: 10},
        {field: 'type', title: '评价类型', width: 20}
    ];

    var tools = [{
        iconCls: 'icon-add',
        text: '添加',
        width: 65,
        handler: add
    }, {
        iconCls: 'icon-edit',
        text: '修改',
        width: 65,
        handler: edit
    }, {
        iconCls: 'icon-remove',
        text: '删除',
        width: 65,
        handler: remove
    }, {
        text: '<input id="item-search" style="width: 300px">'
    }];

    util.datagrid('item-content', 'evaluation-item', columns, tools);
}

function bindEvaluationType() {
    $('#evaluation-type').combobox({
        url: 'item-type',
        valueField: 'id',
        textField: 'type',
        limitToList: true
    });
}

function showDialog(index) {
    console.log(index);
    if (index === null) {
        alert('添加');
    } else {
        alert('修改');
    }
}
