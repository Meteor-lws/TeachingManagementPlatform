$(function () {
    //定义变量接受行内容
    var rowValue;


    $('#classDg').datagrid({
        url: '/education/selectClassByCondition',
        fit: true,
        fitColumns: true,
        striped: true,
        rownumbers: true,
        border: false,
        pagination: true,
        pageSize: 20,
        pageNumber: 1,
        columns: [[
            {field: 'id', itemid: 'ID', checkbox: true, width: 10},
            {field: 'className', title: '班级名称', width: 10},
            {field: 'classStartDateView', title: '开班时间', width: 10},
            {field: 'classEndDateView', title: '结业时间', width: 10},
            {field: 'mainTeacher', title: '主讲老师', width: 10},
            {field: 'classType', title: '班级类型', width: 10},
            {field: 'headTeacher', title: '班主任', width: 10},
            {field: 'assistantView', title: '助教', width: 10},

        ]],
        queryParams: {
            classStartDate: $("#classStartDate").datetimebox("getValue"),
            classEndDate: $("#classEndDate").datetimebox("getValue")
        },
        toolbar: '#classTb'
    });


    $('#classDg').datagrid({
        onDblClickCell: function (index, field, value) {
            $('#classDialog').dialog('open');
            $("#name").val(rowValue.itemid);

        },
        onSelect: function (rowIndex, rowData) {
            rowValue = rowData;
        }
    });

    var pager = $('#classDg').datagrid().datagrid('getPager'); // get the pager of datagrid

    $("#addCla").click(function () {
        $('#classDialog').dialog({
            title: "班级添加"
        });
        $("#classDialog").dialog('open');
    });
    $("#editCla").click(function () {

        var selects = $("#classDg").datagrid("getSelections");
        if (selects.length == 0) {
            $.messager.alert('警告', '请选择一个需要修改的列');
            return;
        }
        if (selects.length > 1) {
            $.messager.alert('警告', '请勿选择多个');

        }

        else {
            $('#classDialog').dialog({
                title: "班级修改"
            });
            $("#classDialog").dialog('open');
            var selectRow = selects[0];

        }
    });

    $("#removeCla").click(function () {
        var selects = $("#classDg").datagrid("getSelections");
        if (selects.length == 0) {
            $.messager.alert('警告', '请选择一个需要删除的列');
        } else {
            $.messager.confirm('确认', '您确认想要删除这些记录吗？', function (choose) {
                if (choose) {
                    $.messager.alert('提示', '删除成功');
                }
            });

        }

    });
    $("#search").click(function () {
        $('#classDg').datagrid('load', {
            classStartDate: $("#classStartDate").datetimebox("getValue"),
            classEndDate: $("#classEndDate").datetimebox("getValue")
        });
    });



});
function clearForm() {
    $("input").each(function () {
        $(this).val("");
    });
}
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
            $("#classDialog").dialog("close")
        }
    });

}

function cancel() {
    $("#classDialog").dialog("close");
}
		