/**
 * 评价项管理脚本
 *
 * Created by lws on 2017/3/27.
 */

$(function () {
    //为datagrid绑定工具栏和数据请求地址
    $('#evaluation-data').datagrid({
        url: 'EvaluationData',
        fitColumns: true,
        striped: true,
        rownumbers: true,
        pagination: true,
        pageSize: 30,
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
            width: 60,
            handler: function () {
                setDialog('是', '讲师', '');
                showDialog(null);
            }
        }, {
            iconCls: 'icon-edit',
            text: '修改',
            width: 60,
            handler: function () {
                var selectedRows = util.getSelectedRows('evaluation-data');
                if (selectedRows) {
                    var row = selectedRows[0];
                    setDialog(row.data.enable, row.data.type, row.data.content);
                    showDialog(row);
                }
            }
        }, {
            iconCls: 'icon-remove',
            text: '删除',
            width: 60,
            handler: function () {
                util.deleteSelectedRows('evaluation-data');
            }
        }, {
            text: '<input id="evaluation-search" style="width: 300px">'
        }]
    });

    //为搜索框绑定菜单
    $('#evaluation-search').searchbox({
        searcher: function (value, name) {
            console.log(name + ':' + value);
        },
        menu: '#evaluation-search-option',
        prompt: '请输入搜索内容'
    });

    //为评价类型绑定数据
    $('#evaluation-type').combobox({
        url: 'EvaluationType',
        valueField: 'id',
        textField: 'type',
        limitToList: true
    });
});

function showDialog(row) {
    var title, buttonText, buttonIcon;
    if (row === null) {
        title = '添加评价项';
        buttonText = '添加';
        buttonIcon = 'icon-add';
    } else {
        title = '修改评价项';
        buttonText = '修改';
        buttonIcon = 'icon-edit';
    }
    $('#evaluation-dialog').dialog({
        title: title,
        width: 300,
        height: 230,
        modal: true,
        closable: false,
        resizable: false,
        buttons: [{
            width: 80,
            text: buttonText,
            iconCls: buttonIcon,
            handler: function () {
                var evaluation = getDialog();
                if (util.isStringEmpty(evaluation.content)) {
                    $('#evaluation-warning').val('请填写评价项内容');
                } else {
                    var data = getDialog();
                    if (row === null) {
                        $.ajax({
                            type: 'post',
                            url: 'AddEvaluation',
                            data: data,
                            success: function () {
                                $('#evaluation-data').datagrid('load');
                            },
                            error: function () {
                                alert('添加评价项失败');
                            }
                        });
                    } else {
                        $.ajax({
                            type: 'post',
                            url: 'EditEvaluation',
                            data: {
                                'id': row.data.id,
                                'enable': data.enable,
                                'type': data.type,
                                'content': data.content
                            },
                            success: function () {
                                $('#evaluation-data').datagrid('reload');
                            },
                            error: function () {
                                alert('修改评价项失败');
                            }
                        });
                    }
                    closeDialog();
                }
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

function setDialog(enable, type, content) {
    var evaluationEnable = $('#evaluation-enable');
    var evaluationType = $('#evaluation-type');

    if (enable === '是') {
        evaluationEnable.switchbutton('check');
    } else {
        evaluationEnable.switchbutton('uncheck');
    }

    switch (type) {
        case '讲师':
            evaluationType.combobox('select', '1');
            break;
        case '班主任':
            evaluationType.combobox('select', '2');
            break;
        case '助教':
            evaluationType.combobox('select', '3');
            break;
        default:
            break;
    }
    $('#evaluation-content').textbox('setValue', content);
}

function getDialog() {
    return {
        'enable': $('#evaluation-enable').switchbutton('options').checked ? '是' : '否',
        'type': $('#evaluation-type').combobox('getText'),
        'content': $('#evaluation-content').textbox('getText')
    };
}

function closeDialog() {
    $('#evaluation-warning').val('&nbsp');
    $('#evaluation-dialog').dialog('close');
}
