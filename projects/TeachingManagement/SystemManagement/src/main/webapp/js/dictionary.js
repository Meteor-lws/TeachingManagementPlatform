/**
 * 数据字典管理脚本
 *
 * Created by lws on 2017/4/9.
 */

$(function () {
    prepareContent();
    prepareHandler();
});

function prepareContent() {
    prepareDictionaryType();
    prepareSearchBox();
    prepareDatagrid();
    prepareTextBox();
}

function prepareDictionaryType() {
    $('#dictionary-type').tree({
        url: 'getDictionaryTypes',
        onSelect: function (node) {
            select(node);
        }
    });
}

function prepareSearchBox() {
    $('.search').searchbox({
        prompt: '请输入搜索内容',
        handler: search
    });
}

function prepareDatagrid() {
    $('#dictionary-detail').datagrid({
        url: 'getDictionariesByTypeId',
        fit: true,
        fitColumns: true,
        striped: true,
        rownumbers: true,
        pagination: true,
        pageSize: 20,
        pageNumber: 1,
        columns: [[
            {field: 'id', checkbox: true},
            {field: 'dictionaryName', title: '键', width: 40},
            {field: 'dictionaryValue', title: '值', width: 40},
            {field: 'dictionaryDescribe', title: '描述', width: 60},
            {field: 'dictionarySortNumber', title: '序号', width: 20}
        ]],
        toolbar: '#dictionary-tool'
    });
}

function prepareTextBox() {
    showTextBox('dictionary-name', '数据字典名称');
    showTextBox('dictionary-value', '数据字典值');
    showTextBox('dictionary-describe', '数据字典描述');
    showTextBox('dictionary-sort', '数据字典排序编号');
    showTextBox('dictionary-type-name', '字典类型名称');
    showTextBox('dictionary-type-describe', '字典类型描述');
    showTextBox('dictionary-type-sort', '字典类型排序编号');
}

function prepareHandler() {
    $('#dictionary-type-add').click(function () {
        showTypeDialog(null);
    });
    $('#dictionary-type-edit').click(function () {
        var type = getSelections().type;
        if (type) {
            ajax('getDictionaryTypeById', {id: type.id}, function (dictionaryType) {
                dictionaryType = $.parseJSON(dictionaryType);
                setTypeContent(dictionaryType);
                showTypeDialog(type);
            }, '获取选中字典类型失败');
        } else {
            $.messager.alert('警告', '请选择要修改的字典类型', 'warning');
        }
    });
    $('#dictionary-type-remove').click(function () {
        var type = getSelections().type;
        if (type) {
            deleteDictionaryType(type.id);
        } else {
            $.messager.alert('警告', '请选择要删除的字典类型', 'warning');
        }
    });
    $('#dictionary-add').click(function () {
        showDictionaryDialog(null);
    });
    $('#dictionary-edit').click(function () {
        showDictionaryDialog(1);
    });
    $('#dictionary-remove').click(function () {
        alert('删除字典');
    });
}

function showDictionaryDialog(dictionary) {
    var title;
    var buttonTitle, buttonIcon, buttonHandler;
    if (dictionary) {
        title = '修改字典';
        buttonTitle = '修改';
        buttonIcon = 'icon-edit';
        buttonHandler = editDictionary;
    } else {
        title = '添加字典';
        buttonTitle = '添加';
        buttonIcon = 'icon-add';
        buttonHandler = addDictionary;
    }
    $('#dictionary-dialog').dialog({
        title: title,
        width: 360,
        height: 252,
        resizable: false,
        modal: true,
        buttons: [{
            text: '重置',
            width: 65,
            iconCls: 'icon-reload',
            handler: clearDictionaryDialog
        }, {
            text: buttonTitle,
            width: 65,
            iconCls: buttonIcon,
            handler: buttonHandler
        }]
    });
}

function clearDictionaryDialog() {
    $('#dictionary-name').textbox('reset');
    $('#dictionary-value').textbox('reset');
    $('#dictionary-describe').textbox('reset');
    $('#dictionary-sort').textbox('reset');
}

function showTypeDialog(type) {
    var title;
    var buttonTitle, buttonIcon, buttonHandler;
    if (type === null) {
        title = '添加字典类型';
        buttonTitle = '添加';
        buttonIcon = 'icon-add';
        buttonHandler = addDictionaryType;
    } else {
        title = '修改字典类型';
        buttonTitle = '修改';
        buttonIcon = 'icon-edit';
        buttonHandler = function () {
            editDictionaryType(type.id);
        };
    }
    $('#dictionary-type-dialog').dialog({
        title: title,
        width: 385,
        height: 210,
        resizable: false,
        modal: true,
        buttons: [{
            text: '重置',
            width: 65,
            iconCls: 'icon-reload',
            handler: clearTypeDialog
        }, {
            text: buttonTitle,
            width: 65,
            iconCls: buttonIcon,
            handler: buttonHandler
        }]
    });
}

function clearTypeDialog() {
    $('#dictionary-type-name').textbox('reset');
    $('#dictionary-type-describe').textbox('reset');
    $('#dictionary-type-sort').textbox('reset');
}

function select(node) {
    $('#dictionary-detail').datagrid({
        queryParams: {
            typeId: node.id
        }
    });
}

function addDictionary() {
    console.log(getSelection());
}

function editDictionary() {
    console.log(getSelection());
}

function addDictionaryType() {
    var type = {};
    var content = getTypeContent();
    var selections = getSelections();
    if (selections.type) {
        type.parentId = selections.type.id;
    }
    type.dictionaryTypeName = content.name;
    type.dictionaryTypeDescribe = content.describe;
    type.dictionaryTypeSortNumber = content.sort;
    ajax('addDictionaryType', type, function () {
        $('#dictionary-type').tree('reload');
    }, '添加字典类型失败');
    $('#dictionary-type-dialog').dialog('close');
}

function editDictionaryType(id) {
    var dictionaryType = getTypeContent();
    ajax('editDictionaryType', {id: id, dictionaryTypeName: dictionaryType.name, dictionaryTypeDescribe: dictionaryType.describe, dictionaryTypeSortNumber: dictionaryType.sort}, function () {
        $('#dictionary-type').tree('reload');
    }, '修改字典类型失败');
    $('#dictionary-type-dialog').dialog('close');
}

function deleteDictionaryType(id) {
    ajax('deleteDictionaryType', {id: id}, function () {
        $('#dictionary-type').tree('reload');
    }, '删除字典类型失败');
}

function search() {
    console.log(getSelection());
}

function showTextBox(id, prompt) {
    $('#' + id).textbox({
        width: 250,
        height: 35,
        prompt: prompt
    });
}

function ajax(url, data, success, error) {
    $.ajax({
        type: 'post',
        url: url,
        data: data,
        success: function (data) {
            success(data);
        },
        error: function () {
            $.messager.alert('错误', error, 'error');
        }
    });
}

function getSelections() {
    var type = $('#dictionary-type').tree('getSelected');
    var dictionaries = $('#dictionary-detail').datagrid('getSelections');
    return {type: type, dictionaries: dictionaries};
}

function getTypeContent() {
    var dictionaryType = {};
    dictionaryType.name = $('#dictionary-type-name').textbox('getValue');
    dictionaryType.describe = $('#dictionary-type-describe').textbox('getValue');
    dictionaryType.sort = $('#dictionary-type-sort').textbox('getValue');
    return dictionaryType;
}

function setTypeContent(dictionaryType) {
    $('#dictionary-type-name').textbox('setValue', dictionaryType.dictionaryTypeName);
    $('#dictionary-type-describe').textbox('setValue', dictionaryType.dictionaryTypeDescribe);
    $('#dictionary-type-sort').textbox('setValue', dictionaryType.dictionaryTypeSortNumber);
}
