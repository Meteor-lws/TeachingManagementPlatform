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
        searcher: search
    });
}

function prepareDatagrid() {
    $('#dictionary-detail').datagrid({
        url: 'getDictionaries',
        fit: true,
        fitColumns: true,
        striped: true,
        rownumbers: true,
        pagination: true,
        pageSize: 25,
        pageList: [10, 15, 20, 25, 30],
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
    $('#dictionary-type-add').click(addDictionaryType);
    $('#dictionary-type-edit').click(editDictionaryType);
    $('#dictionary-type-remove').click(deleteDictionaryType);
    $('#dictionary-add').click(addDictionary);
    $('#dictionary-edit').click(editDictionary);
    $('#dictionary-remove').click(deleteDictionary);
}

function showTypeDialog(type) {
    var title;
    var buttonTitle, buttonIcon, buttonHandler;
    if (type === null) {
        title = '添加字典类型';
        buttonTitle = '添加';
        buttonIcon = 'icon-add';
        buttonHandler = function () {
            var content = getTypeContent();
            ajax('isTypeNameExist', content.name, function (data) {
                if (data === 'false') {
                    if (content.value.trim().length > 0) {
                        var dictionaryType = {};
                        var type = getSelectedType();
                        if (type) {
                            dictionaryType.parentId = type.id;
                        }
                        dictionaryType.dictionaryTypeName = content.name;
                        dictionaryType.dictionaryTypeDescribe = content.describe;
                        dictionaryType.dictionaryTypeSortNumber = content.sort;
                        ajax('addDictionaryType', dictionaryType, function () {
                            $('#dictionary-type').tree('reload');
                        }, '添加字典类型失败');
                        closeDialog('dictionary-type-dialog');
                    } else {

                    }
                } else {

                }
            }, '查询类型名是否存在失败');
        };
    } else {
        title = '修改字典类型';
        buttonTitle = '修改';
        buttonIcon = 'icon-edit';
        buttonHandler = function () {
            var dictionaryType = getTypeContent();
            ajax('editDictionaryType', {
                id: type.id,
                dictionaryTypeName: dictionaryType.name,
                dictionaryTypeDescribe: dictionaryType.describe,
                dictionaryTypeSortNumber: dictionaryType.sort
            }, function () {
                $('#dictionary-type').tree('reload');
            }, '修改字典类型失败');
            closeDialog('dictionary-type-dialog');
        };
    }
    $('#dictionary-type-dialog').dialog({
        title: title,
        width: 390,
        height: 250,
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
        }],
        onClose: clearTypeDialog
    });
}

function clearTypeDialog() {
    $('#dictionary-type-name').textbox('reset');
    $('#dictionary-type-describe').textbox('reset');
    $('#dictionary-type-sort').textbox('reset');
}

function showDictionaryDialog(dictionary) {
    var title;
    var buttonTitle, buttonIcon, buttonHandler;
    if (dictionary === null) {
        title = '修改字典';
        buttonTitle = '修改';
        buttonIcon = 'icon-edit';
        buttonHandler = function () {
            var dictionary = getSelectedDictionaries()[0];
            var content = getDictionaryContent();
            dictionary.dictionaryName = content.dictionaryName;
            dictionary.dictionaryValue = content.dictionaryValue;
            dictionary.dictionaryDescribe = content.dictionaryDescribe;
            dictionary.dictionarySortNumber = content.dictionarySortNumber;
            ajax('editDictionary', dictionary, function () {
                $('#dictionary-detail').datagrid('reload');
            }, '添加数据字典失败');
            closeDialog('dictionary-dialog');
        };
    } else {
        title = '添加字典';
        buttonTitle = '添加';
        buttonIcon = 'icon-add';
        buttonHandler = function () {
            var content = getDictionaryContent();
            dictionary.dictionaryName = content.dictionaryName;
            dictionary.dictionaryValue = content.dictionaryValue;
            dictionary.dictionaryDescribe = content.dictionaryDescribe;
            dictionary.dictionarySortNumber = content.dictionarySortNumber;
            ajax('addDictionary', dictionary, function () {
                $('#dictionary-detail').datagrid('reload');
            }, '添加数据字典失败');
            closeDialog('dictionary-dialog');
        };
    }
    $('#dictionary-dialog').dialog({
        title: title,
        width: 360,
        height: 292,
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
        }],
        onClose: clearDictionaryDialog
    });
}

function clearDictionaryDialog() {
    $('#dictionary-name').textbox('reset');
    $('#dictionary-value').textbox('reset');
    $('#dictionary-describe').textbox('reset');
    $('#dictionary-sort').textbox('reset');
}

function select(node) {
    $('#dictionary-detail').datagrid({
        queryParams: {
            type: node.id
        }
    });
}

function addDictionaryType() {
    showTypeDialog(null);
}

function editDictionaryType() {
    var type = getSelectedType();
    if (type) {
        ajax('getDictionaryTypeById', {id: type.id}, function (dictionaryType) {
            dictionaryType = $.parseJSON(dictionaryType);
            setTypeContent(dictionaryType);
            showTypeDialog(type);
        }, '获取选中字典类型失败');
    } else {
        $.messager.alert('警告', '请选择要修改的字典类型', 'warning');
    }
}

function deleteDictionaryType() {
    var type = getSelectedType();
    if (type) {
        $.messager.confirm('删除字典类型', '确认删除当前字典类型？', function (choice) {
            if (choice) {
                ajax('deleteDictionaryType', {id: type.id}, function () {
                    $('#dictionary-type').tree('reload');
                }, '删除字典类型失败');
            }
        });
    } else {
        $.messager.alert('警告', '请选择要删除的字典类型', 'warning');
    }
}

function addDictionary() {
    var dictionaryType = getSelectedType();
    if (dictionaryType) {
        var dictionary = {};
        dictionary.dictionaryTypeId = dictionaryType.id;
        showDictionaryDialog(dictionary);
    } else {
        $.messager.alert('警告', '请选择要添加的数据字典所属的字典类型', 'warning');
    }
}

function editDictionary() {
    var dictionaries = getSelectedDictionaries();
    if (dictionaries) {
        setDictionaryContent(dictionaries[0]);
        showDictionaryDialog(null);
    } else {
        $.messager.alert('警告', '请选择要修改的数据字典', 'warning');
    }
}

function deleteDictionary() {
    var dictionaries = getSelectedDictionaries();
    if (dictionaries) {
        $.messager.confirm('删除字典类型', '确认删除当前数据字典？', function (choice) {
            if (choice) {
                ajax('deleteDictionaries', {data: JSON.stringify(dictionaries)}, function () {
                    $('#dictionary-detail').datagrid('reload');
                }, '删除数据字典失败');
            }
        });
    } else {
        $.messager.alert('警告', '请选择要删除的数据字典', 'warning');
    }
}

function search() {
    var dictionaryType = getSelectedType();
    if (dictionaryType) {
        var searchContent = getSearchContent();
        $('#dictionary-detail').datagrid({
            queryParams: {
                type: dictionaryType.id,
                name: searchContent.name,
                value: searchContent.value,
                describe: searchContent.describe
            }
        });
    } else {
        $.messager.alert('警告', '请选择要搜索的数据字典所属类型', 'warning');
    }
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
        beforeSend: function () {
            $('<div class="datagrid-mask"></div>').css({display: 'block', width: '100%', height: $(window).height()}).appendTo('body');
            $('<div class="datagrid-mask-msg"></div>').html('正在处理，请稍候。。。').appendTo('body').css({display: 'block', left: ($(document.body).outerWidth - 190) / 2, top: ($(window).height() - 45) / 2});
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

function getSelectedType() {
    return $('#dictionary-type').tree('getSelected');
}

function getSelectedDictionaries() {
    var selections = $('#dictionary-detail').datagrid('getSelections');
    return selections.length > 0 ? selections : null;
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

function getDictionaryContent() {
    var dictionary = {};
    dictionary.dictionaryName = $('#dictionary-name').textbox('getValue');
    dictionary.dictionaryValue = $('#dictionary-value').textbox('getValue');
    dictionary.dictionaryDescribe = $('#dictionary-describe').textbox('getValue');
    dictionary.dictionarySortNumber = $('#dictionary-sort').textbox('getValue');
    return dictionary;
}

function setDictionaryContent(dictionary) {
    $('#dictionary-name').textbox('setValue', dictionary.dictionaryName);
    $('#dictionary-value').textbox('setValue', dictionary.dictionaryValue);
    $('#dictionary-describe').textbox('setValue', dictionary.dictionaryDescribe);
    $('#dictionary-sort').textbox('setValue', dictionary.dictionarySortNumber);
}

function getSearchContent() {
    var searchContent = {};
    searchContent.name = $('#dictionary-search-name').searchbox('getValue');
    searchContent.value = $('#dictionary-search-value').searchbox('getValue');
    searchContent.describe = $('#dictionary-search-describe').searchbox('getValue');
    return searchContent;
}

function closeDialog(id) {
    $('#' + id).dialog('close');
}
