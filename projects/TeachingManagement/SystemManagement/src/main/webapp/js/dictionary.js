/**
 * 数据字典管理脚本
 *
 * Created by lws on 2017/4/9.
 */

var typeDialogStatus = 'closed';
var dictionaryDialogStatus = 'closed';
var originTypeName = null;
var originDictionaryName = null;
var typeNamePassed = false;
var typeDescribePassed = false;
var dictionaryNamePassed = false;
var dictionaryValuePassed = false;

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
        remoteSort: false,
        multiSort: true,
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
            {field: 'dictionarySortNumber', title: '序号', width: 20, sortable: true}
        ]],
        toolbar: '#dictionary-tool'
    });
}

function prepareTextBox() {
    showTextBox('dictionary-name', '数据字典名称');
    showTextBox('dictionary-value', '数据字典值');
    showTextBox('dictionary-describe', '数据字典描述');
    showNumberBox('dictionary-sort');
    showTextBox('dictionary-type-name', '字典类型名称');
    showTextBox('dictionary-type-describe', '字典类型描述');
    showNumberBox('dictionary-type-sort');
}

function prepareHandler() {
    $('#dictionary-type-add').click(addDictionaryType);
    $('#dictionary-type-edit').click(editDictionaryType);
    $('#dictionary-type-remove').click(deleteDictionaryType);
    $('#dictionary-add').click(addDictionary);
    $('#dictionary-edit').click(editDictionary);
    $('#dictionary-remove').click(deleteDictionary);
    setTextBoxHandler('dictionary-name', clearDictionaryNameWarning, testDictionaryName);
    setTextBoxHandler('dictionary-value', clearDictionaryValueWarning, testDictionaryValue);
    setTextBoxHandler('dictionary-type-name', clearTypeNameWarning, testTypeName);
    setTextBoxHandler('dictionary-type-describe', clearTypeDescribeWarning, testTypeDescribe);
}

function showTypeDialog(type) {
    var title;
    var buttonTitle, buttonIcon, buttonHandler;
    if (type === null) {
        typeDialogStatus = 'add';
        title = '添加字典类型';
        buttonTitle = '添加';
        buttonIcon = 'icon-add';
        buttonHandler = function () {
            if (typeNamePassed && typeDescribePassed) {
                var dictionaryType = {};
                var type = getSelectedType();
                if (type) {
                    dictionaryType.parentId = type.id;
                }
                var content = getTypeContent();
                dictionaryType.dictionaryTypeName = content.name;
                dictionaryType.dictionaryTypeDescribe = content.describe;
                dictionaryType.dictionaryTypeSortNumber = content.sort;
                ajax('addDictionaryType', dictionaryType, function () {
                    $('#dictionary-type').tree('reload');
                }, '添加字典类型失败');
                typeDialogStatus = 'closed';
                closeDialog('dictionary-type-dialog');
            } else {
                $.messager.alert('警告', '请确认填写内容符合要求', 'warning');
            }
        };
    } else {
        typeDialogStatus = 'edit';
        title = '修改字典类型';
        buttonTitle = '修改';
        buttonIcon = 'icon-edit';
        buttonHandler = function () {
            if (typeNamePassed && typeDescribePassed) {
                var dictionaryType = getTypeContent();
                ajax('editDictionaryType', {
                    id: type.id,
                    dictionaryTypeName: dictionaryType.name,
                    dictionaryTypeDescribe: dictionaryType.describe,
                    dictionaryTypeSortNumber: dictionaryType.sort
                }, function () {
                    $('#dictionary-type').tree('reload');
                }, '修改字典类型失败');
                typeDialogStatus = 'closed';
                closeDialog('dictionary-type-dialog');
            } else {
                $.messager.alert('警告', '请确认填写内容符合要求', 'warning');
            }
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
    clearTypeNameWarning();
    clearTypeDescribeWarning();
}

function showDictionaryDialog(dictionary) {
    var title;
    var buttonTitle, buttonIcon, buttonHandler;
    if (dictionary === null) {
        dictionaryDialogStatus = 'edit';
        title = '修改字典';
        buttonTitle = '修改';
        buttonIcon = 'icon-edit';
        buttonHandler = function () {
            if (dictionaryNamePassed && dictionaryValuePassed) {
                var dictionary = getSelectedDictionaries()[0];
                var content = getDictionaryContent();
                dictionary.dictionaryName = content.dictionaryName;
                dictionary.dictionaryValue = content.dictionaryValue;
                dictionary.dictionaryDescribe = content.dictionaryDescribe;
                dictionary.dictionarySortNumber = content.dictionarySortNumber;
                ajax('editDictionary', dictionary, function () {
                    $('#dictionary-detail').datagrid('reload');
                }, '修改数据字典失败');
                dictionaryDialogStatus = 'closed';
                closeDialog('dictionary-dialog');
            } else {
                $.messager.alert('警告', '请确认填写内容符合要求', 'warning');
            }
        };
    } else {
        dictionaryDialogStatus = 'add';
        title = '添加字典';
        buttonTitle = '添加';
        buttonIcon = 'icon-add';
        buttonHandler = function () {
            if (dictionaryNamePassed && dictionaryValuePassed) {
                var content = getDictionaryContent();
                dictionary.dictionaryName = content.dictionaryName;
                dictionary.dictionaryValue = content.dictionaryValue;
                dictionary.dictionaryDescribe = content.dictionaryDescribe;
                dictionary.dictionarySortNumber = content.dictionarySortNumber;
                ajax('addDictionary', dictionary, function () {
                    $('#dictionary-detail').datagrid('reload');
                }, '添加数据字典失败');
                dictionaryDialogStatus = 'closed';
                closeDialog('dictionary-dialog');
            } else {
                $.messager.alert('警告', '请确认填写内容符合要求', 'warning');
            }
        };
    }
    $('#dictionary-dialog').dialog({
        title: title,
        width: 360,
        height: 312,
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
    clearDictionaryNameWarning();
    clearDictionaryValueWarning();
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
            originTypeName = dictionaryType.dictionaryTypeName;
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
        originDictionaryName = dictionaries[0].dictionaryName;
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

function getSelectedType() {
    return $('#dictionary-type').tree('getSelected');
}

function getSelectedDictionaries() {
    var selections = $('#dictionary-detail').datagrid('getSelections');
    return selections.length > 0 ? selections : null;
}

function getTypeContent() {
    var dictionaryType = {};
    dictionaryType.name = $('#dictionary-type-name').textbox('getValue').trim();
    dictionaryType.describe = $('#dictionary-type-describe').textbox('getValue').trim();
    dictionaryType.sort = $('#dictionary-type-sort').textbox('getValue').trim();
    return dictionaryType;
}

function setTypeContent(dictionaryType) {
    $('#dictionary-type-name').textbox('setValue', dictionaryType.dictionaryTypeName);
    $('#dictionary-type-describe').textbox('setValue', dictionaryType.dictionaryTypeDescribe);
    $('#dictionary-type-sort').textbox('setValue', dictionaryType.dictionaryTypeSortNumber);
}

function getDictionaryContent() {
    var dictionary = {};
    dictionary.dictionaryName = $('#dictionary-name').textbox('getValue').trim();
    dictionary.dictionaryValue = $('#dictionary-value').textbox('getValue').trim();
    dictionary.dictionaryDescribe = $('#dictionary-describe').textbox('getValue').trim();
    dictionary.dictionarySortNumber = $('#dictionary-sort').textbox('getValue').trim();
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

function testTypeName() {
    if (typeDialogStatus !== 'closed') {
        var warning = $('#dictionary-type-name-warning');
        var name = $('#dictionary-type-name').textbox('getValue').trim();
        if (name === '') {
            typeNamePassed = false;
            warning.html('字典类型名称不可为空');
        } else if (!(typeDialogStatus === 'edit' && name === originTypeName)) {
            ajax('isTypeNameExist', {typeName: name}, function (data) {
                if (data === 'true') {
                    typeNamePassed = false;
                    warning.html('字典类型名称已存在');
                } else {
                    typeNamePassed = true;
                    clearTypeNameWarning();
                }
            }, '验证字典类型名称是否重复时请求失败');
        } else {
            typeNamePassed = true;
            clearTypeNameWarning();
        }
    }
}

function clearTypeNameWarning() {
    $('#dictionary-type-name-warning').html('&nbsp');
}

function testTypeDescribe() {
    if ($('#dictionary-type-describe').textbox('getValue').trim().length === 0) {
        typeDescribePassed = false;
        $('#dictionary-type-describe-warning').html('字典类型描述不可为空');
    } else {
        typeDescribePassed = true;
        clearTypeDescribeWarning();
    }
}

function clearTypeDescribeWarning() {
    $('#dictionary-type-describe-warning').html('&nbsp');
}

function testDictionaryName() {
    if (dictionaryDialogStatus !== 'closed') {
        var warning = $('#dictionary-name-warning');
        var name = $('#dictionary-name').textbox('getValue').trim();
        if (name === '') {
            dictionaryNamePassed = false;
            warning.html('字典名称不可为空');
        } else if (!(dictionaryDialogStatus === 'edit' && name === originDictionaryName)) {
            ajax('isDictionaryNameExist', {dictionaryName: name}, function (data) {
                if (data === 'true') {
                    dictionaryNamePassed = false;
                    warning.html('字典名称已存在');
                } else {
                    dictionaryNamePassed = true;
                    clearDictionaryNameWarning();
                }
            }, '验证字典名称是否重复时请求失败');
        } else {
            dictionaryNamePassed = true;
            clearDictionaryNameWarning();
        }
    }
}

function clearDictionaryNameWarning() {
    $('#dictionary-name-warning').html('&nbsp');
}

function testDictionaryValue() {
    if ($('#dictionary-value').textbox('getValue').trim().length === 0) {
        dictionaryValuePassed = false;
        $('#dictionary-value-warning').html('字典值不可为空');
    } else {
        dictionaryValuePassed = true;
        clearDictionaryValueWarning();
    }
}

function clearDictionaryValueWarning() {
    $('#dictionary-value-warning').html('&nbsp');
}

function setTextBoxHandler(id, focus, blur) {
    var textBox = $('input', $('#' + id).next('span'));
    textBox.blur(blur);
    textBox.focus(focus);
}

function showTextBox(id, prompt) {
    $('#' + id).textbox({
        width: 250,
        height: 35,
        prompt: prompt
    });
}

function showNumberBox(id) {
    $('#' + id).numberbox({
        width: 250,
        height: 35,
        value: 0,
        min: 0,
        max: 999
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
