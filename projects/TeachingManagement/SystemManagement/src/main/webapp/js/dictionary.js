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
    prepareDatagrid();
    prepareTextBox();
}

function prepareDictionaryType() {
    $('#dictionary-type').tree({
        url: 'getDictionaries',
        onSelect: function (node) {
            select(node);
        }
    });
}

function prepareDatagrid() {
    $('#dictionary-detail').datagrid({
        url: '',
        fit: true,
        fitColumns: true,
        striped: true,
        rownumbers: true,
        pagination: true,
        pageSize: 30,
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
}

function showDialog(dictionary) {
    var title;
    var buttonTitle, buttonIcon, buttonHandler;
    if (dictionary === 0) {
        title = '添加字典';
        buttonTitle = '添加';
        buttonIcon = 'icon-add';
        buttonHandler = function () {
            alert('添加');
        };
    } else {
        title = '修改字典';
        buttonTitle = '修改';
        buttonIcon = 'icon-edit';
        buttonHandler = function () {
            alert('修改');
        };
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
            handler: clearDialog
        }, {
            text: buttonTitle,
            width: 65,
            iconCls: buttonIcon,
            handler: buttonHandler
        }]
    });
}

function clearDialog() {
    $('#dictionary-name').textbox('reset');
    $('#dictionary-value').textbox('reset');
    $('#dictionary-describe').textbox('reset');
    $('#dictionary-sort').textbox('reset');
}

function prepareHandler() {
    $('#dictionary-add').click(add);
    $('#dictionary-edit').click(edit);
    $('#dictionary-remove').click(remove);
    $('.search').searchbox({
        searcher: function (value) {
            search(value);
        }
    });
}

function add() {
    showDialog(0);
    // ajax('addDictionary', getContent(), function () {
    //     refresh();
    // }, '添加数据字典失败');
}

function edit() {
    var id = selectedId();
    if (id) {
        showDialog(1);
        // var content = getContent();
        // ajax('editDictionary', {
        //     'id': id,
        //     'parentId': content.parentId,
        //     'dictionaryName': content.dictionaryName,
        //     'dictionaryValue': content.dictionaryValue,
        //     'dictionaryDescribe': content.dictionaryDescribe,
        //     'dictionarySortNumber': content.dictionarySortNumber
        // }, function () {
        //     refresh();
        // }, '修改数据字典失败');
    } else {
        $.messager.alert('警告', '请选择要修改的数据字典', 'warning');
    }
}

function remove() {
    var id = selectedId();
    if (id) {
        // ajax('removeDictionaryById', {'id': id}, function () {
        //     refresh();
        // }, '删除数据字典失败');
    } else {
        $.messager.alert('警告', '请选择要删除的数据字典', 'warning');
    }
}

function search(value) {
    alert('search:' + value);
}

function select(node) {
    ajax('getDictionary', {'id': node.id}, function (dictionary) {
        dictionary = $.parseJSON(dictionary);
        setContent(dictionary);
    }, '请求数据字典失败');
}

function selectedId() {
    var selection = $('#dictionary-type').tree('getSelected');
    return selection === null ? null : selection.id;
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

function refresh() {
    var id = selectedId();
    $('#dictionary-type').tree('reload');
    if (id) {
        ajax('getDictionary', {'id': id}, function (dictionary) {
            dictionary = $.parseJSON(dictionary);
            setContent(dictionary);
        }, '请求数据字典失败');
    }
}

function setContent(dictionary) {
    $('#dictionary-name').textbox('setValue', dictionary.dictionaryName);
    $('#dictionary-value').textbox('setValue', dictionary.dictionaryValue);
    $('#dictionary-sort').textbox('setValue', dictionary.dictionarySortNumber);
    $('#dictionary-describe').textbox('setValue', dictionary.dictionaryDescribe);
}

function getContent() {
    var parent = null;
    var name = $('#dictionary-name').textbox('getValue');
    var value = $('#dictionary-value').textbox('getValue');
    var sort = $('#dictionary-sort').textbox('getValue');
    var describe = $('#dictionary-describe').textbox('getValue');
    return {'parentId': parent, 'dictionaryName': name, 'dictionaryValue': value, 'dictionarySortNumber': sort, 'dictionaryDescribe': describe};
}

function showTextBox(id, prompt) {
    $('#' + id).textbox({
        width: 250,
        height: 35,
        prompt: prompt
    });
}
