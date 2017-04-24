/**
 * 评价项管理脚本
 *
 * Created by lws on 2017/3/31.
 */

$(function () {
    prepareDialog();
    prepareDatagrid();
    prepareTools();
});

function prepareDialog() {
    $('#item-content').textbox();
    $('#item-type').combobox({
        url: 'getEvaluationItemTypes',
        limitToList: true,
        valueField: 'id',
        textField: 'dictionaryName',
        onChange: function () {
            $('#item-type').combobox('reload');
        }
    });
}

function prepareDatagrid() {
    var columns = [
        {field: 'id', checkbox: true},
        {field: 'itemContent', title: '评价项', width: 70},
        {field: 'enable', title: '是否启用', width: 10},
        {field: 'type', title: '评价类型', width: 20, sortable: true}
    ];
    util.datagrid('item-data', 'getEvaluationItems', [], columns, '#item-tool');
}

function prepareTools() {
    $('#item-add').click(addItem);
    $('#item-edit').click(editItem);
    $('#item-remove').click(removeItem);
    $('#item-search-type').combobox({
        url: 'getEvaluationItemTypes',
        limitToList: true,
        valueField: 'id',
        textField: 'dictionaryName',
        onChange: function () {
            $('#item-search-type').combobox('reload');
        }
    });
    $('#item-search-enable').combobox({
        limitToList: true,
        valueField: 'value',
        textField: 'text',
        data: [{
            value: 'true',
            text: '是'
        }, {
            value: 'false',
            text: '否'
        }]
    });
    $('#item-search-content').searchbox({
        prompt: '请输入搜索内容',
        searcher: searchItems
    });
}

function showDialog(item) {
    var title, buttonText, buttonIcon, buttonHandler;
    if (item === null) {
        title = '添加评价项';
        buttonText = '添加';
        buttonIcon = 'icon-add';
        buttonHandler = function () {
            var content = getDialogContent();
            var item = {};
            if (content.enable === '0') {
                item.itemEnable = 0;
            } else {
                item.itemEnable = 1;
            }
            item.itemContent = content.content;
            item.itemType = content.type;
            ajax('addEvaluationItem', item, function () {
                closeDialog();
                $('#item-data').datagrid('reload');
            }, '添加评价项失败');
        };
    } else {
        title = '修改评价项';
        buttonText = '修改';
        buttonIcon = 'icon-edit';
        buttonHandler = function () {
            var content = getDialogContent();
            if (content.enable === '0') {
                item.itemEnable = 0;
            } else {
                item.itemEnable = 1;
            }
            item.itemContent = content.content;
            item.itemType = content.type;
            ajax('editEvaluationItem', item, function () {
                closeDialog();
                $('#item-data').datagrid('reload');
            }, '修改评价项失败');
        };
    }
    $('#item-dialog').dialog({
        width: 350,
        height: 260,
        title: title,
        onClose: resetDialog,
        buttons: [{
            width: 65,
            iconCls: 'icon-reload',
            text: '重置',
            handler: resetDialog
        }, {
            width: 65,
            iconCls: buttonIcon,
            text: buttonText,
            handler: buttonHandler
        }]
    });
}

function resetDialog() {
    $('#item-type').combobox('reset');
    $('#item-content').textbox('reset');
    var enableChoices = $('input:radio[name=item-enable]');
    enableChoices[1].checked = false;
    enableChoices[0].checked = true;
}

function closeDialog() {
    $('#item-dialog').dialog('close');
}

function getSelections() {
    var selections = $('#item-data').datagrid('getSelections');
    return selections.length > 0 ? selections : null;
}

function addItem() {
    showDialog(null);
}

function editItem() {
    var selections = getSelections();
    if (selections) {
        setDialogContent(selections[0]);
        showDialog(selections[0]);
    } else {
        $.messager.alert('警告', '请选择需要修改的评价项', 'warning');
    }
}

function removeItem() {
    var selections = getSelections();
    if (selections) {
        $.messager.confirm('删除确认', '确认要删除选中的评价项吗？', function (choice) {
            if (choice) {
                ajax('deleteEvaluationItems', {data: JSON.stringify(selections)}, function () {
                    $('#item-data').datagrid('reload');
                }, '删除评价项失败');
            }
        });
    } else {
        $.messager.alert('警告', '请选择需要删除的评价项', 'warning');
    }
}

function searchItems() {
    var searchText = getSearchText();
    $('#item-data').datagrid({
        queryParams: {
            typeId: searchText.type,
            enable: searchText.enable,
            itemContent: searchText.content
        }
    });
}

function getSearchText() {
    return {
        type: $('#item-search-type').combobox('getValue').trim(),
        enable: $('#item-search-enable').combobox('getValue').trim(),
        content: $('#item-search-content').searchbox('getValue').trim()
    };
}

function getDialogContent() {
    return {
        type: $('#item-type').combobox('getValue').trim(),
        content: $('#item-content').textbox('getValue').trim(),
        enable: $('input:radio[name=item-enable]:checked').val()
    };
}

function setDialogContent(item) {
    $('#item-type').combobox('setValue', item.itemType);
    $('#item-content').textbox('setValue', item.itemContent);
    var enableChoices = $('input:radio[name=item-enable]');
    if (item.itemEnable === 0) {
        enableChoices[0].checked = false;
        enableChoices[1].checked = true;
    } else {
        enableChoices[1].checked = false;
        enableChoices[0].checked = true;
    }
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
