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
    $('#item-data').datagrid({
        url: 'getEvaluationItems',
        fit: true,
        fitColumns: true,
        striped: true,
        remoteSort: false,
        rownumbers: true,
        pagination: true,
        pageSize: 25,
        pageList: [10, 15, 20, 25, 30],
        pageNumber: 1,
        columns: [[
            {field: 'id', checkbox: true},
            {field: 'itemContent', title: '评价项', width: 70},
            {field: 'enable', title: '是否启用', width: 10},
            {field: 'type', title: '评价类型', width: 20, sortable: true}
        ]],
        toolbar: '#item-tool'
    });
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

function addItem() {
    alert('add');
}

function editItem() {
    alert('edit');
}

function removeItem() {
    alert('remove');
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
