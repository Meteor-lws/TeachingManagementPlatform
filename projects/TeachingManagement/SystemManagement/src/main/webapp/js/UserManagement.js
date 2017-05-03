/**
 * 用户管理脚本
 *
 * Created by lws on 2017/4/25.
 */

$(function () {
    prepareTools();
    $("#userDialog").dialog("close");
    $('#userDg').datagrid({
        url: '/system/selectUserByCondition',
        fit: true,
        fitColumns: false,
        striped: true,
        rownumbers: true,
        border: false,
        pagination: true,
        pageSize: 20,
        pageNumber: 1,
        columns: [[
            {field: 'id', itemid: 'ID', checkbox: true, width: 200},
            {field: 'userName', title: '用户名', width: 200},
            {field: 'userStatusView', title: '用户状态', width: 200},
            {field: 'userTypeView', title: '用户类型', width: 200},
            {field: 'userNumber', title: '用户编号', width: 200}
        ]],
        queryParams: {
            userStatus: $("#user-search-status").combobox("getValue"),
            userType: $("#user-search-type").combobox("getValue"),
            userName: $("#user-search-name").textbox("getValue")
        },
        toolbar: '#user-tool'
    });

    $("#user-search-status").combobox({
        url: "/system/getUserStatus",
        valueField: 'id',
        textField: 'dictionaryName'
    });

    $("#user-search-type").combobox({
        url: "/system/getUserType",
        valueField: 'id',
        textField: 'dictionaryName'
    });


    $("#search").click(function () {
        $("#userDg").datagrid("load", {
            userStatus: $("#user-search-status").combobox("getValue"),
            userType: $("#user-search-type").combobox("getValue"),
            userName: $("#user-search-name").textbox("getValue")
        })
    });


    $("#userStatus").combobox({
        url: "/system/getUserStatus",
        valueField: 'id',
        textField: 'dictionaryName'
    });

    $("#userType").combobox({
        url: "/system/getUserType",
        valueField: 'id',
        textField: 'dictionaryName'
    });

    $("#userEdit").click(function () {

        var selects = $("#userDg").datagrid("getSelections");
        if (selects.length == 0) {
            $.messager.alert('警告', '请选择一个需要修改的列');
            return;
        }
        if (selects.length > 1) {
            $.messager.alert('警告', '请勿选择多个');

        }

        else {
            $('#userDialog').dialog({
                title: "权限修改"
            });
            $("#userDialog").dialog('open');
            var selectRow = selects[0];
            $("#id").val(selectRow.id);
            $("#userName").textbox("setValue", selectRow.userName);
            $("#userStatus").combobox("select", selectRow.userStatus);
            $("#userType").combobox("select", selectRow.userType);
            $("#userNumber").textbox("setValue", selectRow.userNumber);
        }
    });

    $("#initPass").click(function () {
        var selects = $("#userDg").datagrid("getSelections");
        if (selects.length == 0) {
            $.messager.alert('警告', '请选择一个需要初始化密码的用户');
        }
        else {
            var ids = [];
            for (var i = 0; i < selects.length; i++) {
                ids[i] = selects[i].id;
            }
            $.ajax({
                url: "/system/initPass",
                data: {
                    ids: JSON.stringify(ids),
                },
                type: "post",
                success: function () {
                    $.messager.alert('警告', '初始化密码成功 ');
                }
            });
        }
    });

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

function cancel() {
    $("#userDialog").dialog("close");
    $("#userForm").form("clear");
}

function submitForm() {
    $.messager.progress(); // 显示进度条
    $('#userForm').form('submit', {
        url: "/system/saveOrUpdateUser",
        onSubmit: function () {
            var isValid = $(this).form('validate');
            if (!isValid) {
                $.messager.progress('close'); // 如果表单是无效的则隐藏进度条
            }
            return isValid; // 返回false终止表单提交
        },
        success: function () {
            $.messager.progress("close"); // 如果提交成功则隐藏进度条
            $("#userForm").form("clear");
            $("#userDg").datagrid("reload");
            $("#userDialog").dialog("close")
        }
    });

}