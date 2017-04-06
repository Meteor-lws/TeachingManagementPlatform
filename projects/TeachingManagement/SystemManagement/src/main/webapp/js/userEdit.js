$(function () {
    //定义变量接受行内容
    var rowValue;
    $('#userDg').datagrid({
        url: 'datagrid_data1.json',
        fit: true,
        fitColumns: false,
        striped: true,
        rownumbers: true,
        border: false,
        pagination: true,
        pageSize: 20,
        pageNumber: 1,
        columns: [[
            {field: 'code', itemid: 'ID', checkbox: true, width: 333},
            {field: 'productid', title: '用户名', width: 520},
            {field: 'productid', title: '密码', width: 520}
        ]],
        toolbar: '#userTb'
    });


    $('#userDg').datagrid({
        onDblClickCell: function (index, field, value) {
            $('#userDialog').dialog('open');

        },
        onSelect: function (rowIndex, rowData) {
            rowValue = rowData;
        }
    });

    var pager = $('#userDg').datagrid().datagrid('getPager'); // get the pager of datagrid

    $("#editUse").click(function () {

        var selects = $("#userdg").datagrid("getSelections");
        if (selects.length == 0) {
            $.messager.alert('警告', '请选择一个需要修改的列');
            return;
        }
        if (selects.length > 1) {
            $.messager.alert('警告', '请勿选择多个');

        }

        else {
            $('#userDialog').dialog({
                title: "密码修改"
            });
            $("#userDialog").dialog('open');
            var selectRow = selects[0];

        }
    });

    $("#search").click(function () {
        var no = $("#noSearch").val();
        $('#dg').datagrid('load', {
            'no': no
        });
    });


});

function submitForm() {
    $.messager.progress(); // 显示进度条
    $('#userForm').form('submit', {
        url: "/asada",
        onSubmit: function () {
            var isValid = $(this).form('validate');
            if (!isValid) {
                $.messager.progress('close'); // 如果表单是无效的则隐藏进度条
            }
            return isValid; // 返回false终止表单提交
        },
        success: function () {
            $.messager.progress("close"); // 如果提交成功则隐藏进度条
            $("#userDialog").dialog("close")
        }
    });

}
function cancel() {
    $("#userDialog").dialog("close");
}
		