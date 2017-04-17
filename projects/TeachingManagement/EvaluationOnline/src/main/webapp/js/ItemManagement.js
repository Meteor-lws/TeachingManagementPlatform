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
        handler: function () {
            showDialog(null);
        }
    }, {
        iconCls: 'icon-edit',
        text: '修改',
        width: 65,
        handler: function () {
            var rows = util.selectedRows('item-content');
            if (rows) {
                showDialog(rows);
            } else {
                $.messager.alert('提示', '请选择要修改的评价项', 'warning');
            }
        }
    }, {
        iconCls: 'icon-remove',
        text: '删除',
        width: 65,
        handler: function () {
            var rows = util.selectedRows('item-content');
            if (rows) {
                remove(rows);
            } else {
                $.messager.alert('提示', '请选择要删除的评价项', 'warning');
            }
        }
    }, {
        text: '<input id="item-search" style="width: 300px">'
    }];

    util.datagrid('item-content', 'evaluationItem', columns, tools);
}

function bindEvaluationType() {
    $('#evaluation-type').combobox({
        url: 'evaluationType',
        valueField: 'id',
        textField: 'value',
        limitToList: true
    });
}

function showDialog(rows) {
    var title, buttonText, buttonIcon, handle;
    if (rows === null) {
        title = '添加评价项';
        buttonText = '添加';
        buttonIcon = 'icon-add';
        handle = add;
    } else {
        title = '修改评价项';
        buttonText = '修改';
        buttonIcon = 'icon-edit';
        handle = edit;
    }
    $('#item-dialog').dialog({
        title: title,
        width: 300,
        height: 240,
        modal: true,
        closable: false,
        resizable: false,
        buttons: [{
            width: 80,
            text: buttonText,
            iconCls: buttonIcon,
            handler: function () {
                handle(rows[0]);
                closeDialog();
            }
        }, {
            width: 80,
            text: '取消',
            iconCls: 'icon-cancel',
            handler: function () {
                closeDialog();
            }
        }]
    });
}

function closeDialog() {
    $('#evaluation-warning').val('&nbsp');
    $('#item-dialog').dialog('close');
}

function add(data) {
    console.log(data);
}

function edit(data) {
    console.log(data);
}

function remove(rows) {
    console.log(rows);
}

function search(value, name) {
    console.log(name + ':' + value);
}
