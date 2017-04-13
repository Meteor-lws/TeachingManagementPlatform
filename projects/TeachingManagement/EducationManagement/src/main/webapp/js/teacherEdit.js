/**
 * Created by XuMing on 2017/4/1.
 */

$(function () {
    var teachingType ;
    var rowValue;
    $('#teachingType').combobox({
        url:'/education/teachingTypeList',
        valueField:'id',
        textField:'dictionaryName',
        onSelect:function (sel) {
            teachingType = sel.id;
        }
    });


    $('#teaDg').datagrid({
        onDblClickCell: function (index, field, value) {
            $('#teaDialog').window('open');
            $("#name").val(rowValue.itemid);

        },
        onSelect: function (rowIndex, rowData) {
            rowValue = rowData;
        }
    });
    var pager = $('#teaDg').datagrid().datagrid('getPager'); // get the pager of datagrid
    $("#addTea").click(function () {
        $('#teaDialog').dialog({
            title: "添加老师"
        });
        $("#teaDialog").dialog('open');
    });
    $("#editTea").click(function () {

        var selects = $("#teaDg").datagrid("getSelections");
        if (selects.length == 0) {
            $.messager.alert('警告', '请选择一个需要修改的列');
            return;
        }
        if (selects.length > 1) {
            $.messager.alert('警告', '请勿选择多个');
        }

        else {
            $('#teaDialog').dialog({
                title: "学生修改"
            });
            $("#teaDialog").dialog('open');
            var selectRow = selects[0]

        }
    });

    $("#removeTea").click(function () {
        var selects = $("#teaDg").datagrid("getSelections");
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
    $("#search").click(function () {
        var no = $("#noSearch").val();
        $('#teaDg').datagrid('load', {
            'no': no
        });
    });

    $('#teaDg').datagrid({
        url: '/education/teacherSelect',
        fitColumns: false,
        fit: true,
        striped: true,
        rownumbers: true,
        border: false,
        pagination: true,
        pageSize: 20,
        pageNumber: 1,
        columns: [[
            {field: 'id', itemid: 'ID', checkbox: true, width: 1000},
            {field: 'teacherName', title: '姓名', width: 10, width: 100},
            {field: 'teacherSexView', title: '性别', width: 100},
            {field: 'teacherTypeView', title: '类型', width: 100},
            {field: 'teacherSpecialityView', title: '专业', width: 100},
            {field: 'teacherPhone', title: '手机', width: 100},
            {field: 'productid', title: '入职时间', width: 200}
        ]],
        toolbar: '#teaTb'
    });

    $("#selectTea").click(function()
    {

        var id = $("#teacherNo").val();//教师id
        var teacherName = $("#teacherName").val();//教师姓名
        $('#teaDg').datagrid('load', {
            id: id,
            teacherName: teacherName,
            teacherType: teachingType
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
            $("#teaDialog").dialog("close")
        }
    });

}
function cancel() {
    $("#teaDialog").dialog("close");
}
