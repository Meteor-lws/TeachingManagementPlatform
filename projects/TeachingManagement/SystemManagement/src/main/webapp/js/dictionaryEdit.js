$(function () {

    $('#dicDg').datagrid({
        //双击列
        onDblClickCell: function (index, field, value) {
            //弹出信息框
            $('#dicDialog').dialog('open');

        },
        onSelect: function (rowIndex, rowData) {
            //当前列对象
            rowValue = rowData;
        }
    });


    $('#dicList').combobox({
        url: 'datagrid_data1.json',
        valueField: 'productid',
        textField: 'productid'
    });

    $('#dicDg').datagrid({
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
            {field: 'productname', itemid: 'ID', checkbox: true, width: 10},
            {field: 'productid', title: '名称', width: 400},
            {field: 'productid', title: '代码', width: 400},
            {field: 'productid', title: '描述', width: 400},
        ]],
        toolbar: '#dicTb'
    });

    //点击添加按钮
    $("#addDic").click(function () {
        //弹出信息框
        $('#dicDialog').dialog({
            title: "学生添加"
        });
        $("#dicDialog").dialog('open');
    });

    //点击修改按钮
    $("#editDic").click(function () {

        var selects = $("#dicDg").datagrid("getSelections");
        if (selects.length == 0) {
            $.messager.alert('警告', '请选择一个需要修改的列');
            return;
        }

        $('#dicDg').datagrid({
            onSelect: function (rowIndex, rowData) {
                //当前列对象
                rowValue = rowData;
            }

        });

        if (selects.length > 1) {
            $.messager.alert('警告', '请勿选择多个');

        }

        else {
            $('#dicDialog').dialog({
                title: "字典修改"
            });
            $("#dicDialog").dialog('open');
            var selectRow = selects[0]

        }
    });

    $("#dicDialog").dialog('close');

    $("#removeDic").click(function () {
        var selects = $("#dicDg").datagrid("getSelections");
        if (selects.length == 0) {
            $.messager.alert('警告', '请选择一个需要修改的列');
        } else {
            $.messager.confirm('确认', '您确认想要这些记录吗？', function (choose) {
                if (choose) {
                    $.messager.alert('提示', '删除成功');
                }
            });

        }

    });


});
//提交按钮
function submitForm() {
    $.messager.progress(); // 显示进度条
    $('#ff').form('submit', {
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
            $("#dicDialog").dialog("close")
        }
    });
}
//取消按钮
function cancel() {
    $("#dicDialog").dialog("close");
}
