/**
 * 留言审核脚本
 *
 * Created by lws on 2017/4/19.
 */

$(function () {
    prepareTools();
});

function prepareTools() {
    $('#message-search-status').combobox({
        url: 'MessageStatuses',
        valueField: 'id',
        textField: 'dictionaryName'
    });
    $('.message-search').searchbox({
        searcher: search
    });
}

function search() {
    alert('search');
}
