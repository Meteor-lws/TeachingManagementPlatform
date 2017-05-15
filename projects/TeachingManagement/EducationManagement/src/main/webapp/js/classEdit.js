$(function () {
    //定义变量接受行内容
    var rowValue;
    $("#classDialog").dialog("close");
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
        onDblClickRow: function (index, row) {
            $('#classDialog').dialog('open');
            $("#className").textbox("setValue", row.className);
            $("#classType").combobox("select", row.classType);
            $("#assistantId").combobox("select", row.assistantId);
            $("#headTeacherId").combobox("select", row.headTeacherId);
            $("#mainTeacherId").combobox("select", row.mainTeacherId);
            $("#classdEndDateForm").datetimebox("setValue", row.classEndDateView);
            $("#classStartDateForm").datetimebox("setValue", row.classStartDateView);
            $("#id").val(row.id);
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
        if (selects.length === 0) {
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
            $('#classDialog').dialog('open');
            $("#className").textbox("setValue", selectRow.className);
            $("#classType").combobox("select", selectRow.classType);
            $("#assistantId").combobox("select", selectRow.assistantId);
            $("#headTeacherId").combobox("select", selectRow.headTeacherId);
            $("#mainTeacherId").combobox("select", selectRow.mainTeacherId);
            $("#classdEndDateForm").datetimebox("setValue", selectRow.classEndDateView);
            $("#classStartDateForm").datetimebox("setValue", selectRow.classStartDateView);
            $("#id").val(selectRow.id);
        }
    });

    $("#removeCla").click(function () {
        var selects = $("#classDg").datagrid("getSelections");
        if (selects.length === 0) {
            $.messager.alert('警告', '请选择一个需要删除的列');
        } else {
            $.messager.confirm('确认', '您确认想要删除这些记录吗？', function (choose) {
                if (choose) {
                    var ids = [];
                    for (var i = 0; i < selects.length; i++) {
                        ids[i] = selects[i].id;
                    }

                    $.ajax({
                        url: "/education/deleteClassByBatch",
                        data: {
                            ids: JSON.stringify(ids),
                        },
                        type: "post",
                        success: function (data) {
                            $.messager.alert('提示', '删除成功');
                            $("#classDg").datagrid("reload");

                        }

                    });

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

    $("#classType").combobox({
        url: "/education/getClassType",
        valueField: 'id',
        textField: 'dictionaryName'
    });

    $("#mainTeacherId").combobox({
        url: "/education/getAllMainTeacher",
        valueField: 'id',
        textField: 'teacherName'
    });

    $("#headTeacherId").combobox({
        url: "/education/getAllHeadTeacher",
        valueField: 'id',
        textField: 'teacherName'
    });

    $("#assistantId").combobox({
        url: "/education/getAllAssiTeacher",
        valueField: 'id',
        textField: 'teacherName'
    });
















});
function clearForm() {
    $("input").each(function () {
        $(this).val("");
    });
}
function submitForm() {

}

function cancel() {
    $("#classForm").form('clear');
    $("#classDialog").dialog('close');
}
		