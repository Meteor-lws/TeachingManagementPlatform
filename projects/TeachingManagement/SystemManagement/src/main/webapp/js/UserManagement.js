/**
 * 用户管理脚本
 *
 * Created by lws on 2017/4/25.
 */

$(function () {
    prepareTools();
});

function prepareTools() {
    $('#user-search-type').combobox({
        url: '',
        valueField: 'id',
        textField: 'text'
    });
    $('#user-search-status').combobox({
        url: '',
        valueField: 'id',
        textField: 'text'
    });
    $('.user-search').searchbox({
        searcher: search
    });
}

function search() {
    alert('');
}
