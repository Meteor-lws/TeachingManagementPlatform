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
    $('#dictionary').tree({
        url: 'dictionaryData',
        onSelect: function (node) {
            select(node);
        }
    });
    $('#dictionary-detail').textbox({
        multiline: true,
        editable: false,
        border: false,
        prompt: '数据字典详情'
    });
    prepareDialog();
}

function prepareDialog() {
    $('#dictionary-parent').combotree({
        label: '父字典：',
        labelPosition: 'left',
        width: 350,
        height: 40,
        editable: true,
        url: 'dictionaryData'
    });
    $('#dictionary-sort').textbox({
        label: '字典序号：',
        labelPosition: 'left',
        width: 400,
        height: 40,
        prompt: '数据字典排序编号',
        value: 0
    });
    $('#dictionary-name').textbox({
        label: '字典名称：',
        labelPosition: 'left',
        width: 350,
        height: 40,
        prompt: '数据字典名称'
    });
    $('#dictionary-value').textbox({
        label: '字典值：',
        labelPosition: 'left',
        width: 400,
        height: 40,
        prompt: '数据字典值'
    });
    $('#dictionary-describe').textbox({
        multiline: true,
        label: '字典描述：',
        labelPosition: 'left',
        width: 810,
        height: 200,
        prompt: '数据字典描述'
    });
    $('#dictionary-dialog').dialog({
        title: '',
        inline: true,
        closable: false,
        resizable: false,
        draggable: false,
        border: false,
        toolbar: '#dictionary-tool'
    });
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
    $('#parent-clear').click(function () {
        $('#dictionary-parent').combotree('clear');
    });
}

function add() {
    ajax('addDictionary', getContent(), function () {
        refresh();
    }, '添加数据字典失败');
}

function edit() {
    ajax('editDictionary', getContent(), function () {
        refresh();
    }, '修改数据字典失败');
}

function remove() {
    var id = selectedId();
    if (id) {
        ajax('removeDictionaryById', {'id': id}, function () {
            refresh();
        }, '删除数据字典失败');
    } else {
        $.messager.alert('警告', '请选择要删除的数据字典', 'warning');
    }
}

function search(value) {
    alert('search:' + value);
}

function select(node) {
    ajax('getDictionaryById', {'id': node.id}, function (dictionary) {
        dictionary = $.parseJSON(dictionary);
        setContent(dictionary);
    }, '请求数据字典失败');
}

function selectedId() {
    var selection = $('#dictionary').tree('getSelected');
    return selection ? selection.id : null;
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
    $('#dictionary').tree('reload');
    $('#dictionary-parent').combotree('reload');
    setContent();
}

function setContent(dictionary) {
    if (dictionary.parentId) {
        $('#dictionary-parent').combotree('setValue', dictionary.parentId);
    } else {
        $('#dictionary-parent').combotree('clear');
    }
    $('#dictionary-name').textbox('setValue', dictionary.name);
    $('#dictionary-value').textbox('setValue', dictionary.value);
    $('#dictionary-sort').textbox('setValue', dictionary.sortNumber);
    $('#dictionary-describe').textbox('setValue', dictionary.describe);
    $('#dictionary-detail').textbox('setValue', dictionary.describe);
}

function getContent() {
    var parent = $('#dictionary-parent').combotree('getValue');
    var name = $('#dictionary-name').textbox('getValue');
    var value = $('#dictionary-value').textbox('getValue');
    var sort = $('#dictionary-sort').textbox('getValue');
    var describe = $('#dictionary-describe').textbox('getValue');
    return {'parentId': parent, 'name': name, 'value': value, 'sortNumber': sort, 'describe': describe};
}
