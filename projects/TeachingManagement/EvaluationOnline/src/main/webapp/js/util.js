/**
 * 通用工具脚本
 *
 * Created by lws on 2017/3/31.
 */

var util = {};

/**
 * 判断字符串是否包含内容
 */
util.isStrEmpty = function (str) {
    return !(str && str.trim().length !== 0);
};

/**
 * 弹出确认提示框，确认后完成任务
 */
util.remind = function (remind, work) {
    $.messager.confirm('提示', remind, function (choice) {
        if (choice) {
            work();
        }
    });
};

/**
 * 弹出警告提示框
 */
util.warning = function (warning) {
    $.messager.alert('警告', warning, 'warning');
};

/**
 * 弹出错误提示框
 */
util.error = function (error) {
    $.messager.alert('错误', error, 'error');
};

/**
 * 渲染EasyUI Datagrid组件
 */
util.datagrid = function (id, url, frozenColumns, columns, tools) {
    $('#' + id).datagrid({
        url: url,
        fit: true,
        fitColumns: true,
        border: false,
        striped: true,
        rownumbers: true,
        pagination: true,
        pageSize: 25,
        pageList: [10, 15, 20, 25, 30],
        pageNumber: 1,
        remoteSort: false,
        multiSort: true,
        frozenColumns: [frozenColumns],
        columns: [columns],
        toolbar: tools
    });
};

/**
 * 渲染EasyUI Treegrid组件
 */
util.treegrid = function (id, url, frozenColumns, columns, tools, idField, treeField) {
    $('#' + id).treegrid({
        url: url,
        fit: true,
        fitColumns: true,
        border: false,
        striped: true,
        rownumbers: true,
        remoteSort: false,
        multiSort: true,
        frozenColumns: [frozenColumns],
        columns: [columns],
        idField: idField,
        treeField: treeField,
        toolbar: tools,
        onLoadSuccess: function (row, data) {
            $.each(data, function (i) {
                $('#' + id).treegrid('collapseAll', data[i].id);
            });
        }
    });
};

/**
 * 发出异步请求
 */
util.ajax = function (url, data, success, error) {
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
            util.error(error);
        },
        complete: function () {
            $('.datagrid-mask').remove();
            $('.datagrid-mask-msg').remove();
        }
    });
};
