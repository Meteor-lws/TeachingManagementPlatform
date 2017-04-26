$(function () {
    //定义变量接受行内容
    var rowValue;
    $('#preDg').datagrid({
        url: "/system/getPerByCondition",
        fit: true,
        fitColumns: false,
        striped: true,
        rownumbers: true,
        border: false,
        pagination: true,
        pageSize: 20,
        pageNumber: 1,
        columns: [[
            {field: 'id', itemid: 'ID', checkbox: true, width: 100},
            {field: 'resourceName', title: '权限名称', width: 520},
            {field: 'resourceValue', title: '权限代码', width: 520},
            {field: 'resourceTypeView', title: '权限类型', width: 520}
        ]],
        queryParams: {
            resourceName: $("#resourceName").textbox("getValue"),
            resourceValue:$("#resourceValue").textbox("getValue")
        },
        toolbar: '#preTb'
    });

    $("#search").click(function(){
        $('#preDg').datagrid("load",{
            resourceName: $("#resourceName").textbox("getValue"),
            resourceValue:$("#resourceValue").textbox("getValue")
        });
    });



    $('#preDg').datagrid({
        onDblClickCell: function (index, field, value) {
            $('#preDialog').dialog('open');
            $("#name").val(rowValue.itemid);

        },
        onSelect: function (rowIndex, rowData) {
            rowValue = rowData;
        }
    });

    var pager = $('#preDg').datagrid().datagrid('getPager'); // get the pager of datagrid

    $("#addPre").click(function () {
        $('#preDialog').dialog({
            title: "权限添加"
        });
        $("#preDialog").dialog('open');
    });
    $("#editPre").click(function () {

        var selects = $("#preDg").datagrid("getSelections");
        if (selects.length == 0) {
            $.messager.alert('警告', '请选择一个需要修改的列');
            return;
        }
        if (selects.length > 1) {
            $.messager.alert('警告', '请勿选择多个');

        }

        else {
            $('#preDialog').dialog({
                title: "权限修改"
            });
            $("#preDialog").dialog('open');
            var selectRow = selects[0];

        }
    });

    $("#removePre").click(function () {
        var selects = $("#preDg").datagrid("getSelections");
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
        var no = $("#noSearch").val();
        $('#preDg').datagrid('load', {
            'no': no
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
            $("#preDialog").dialog("close")
        }
    });

}

function cancel() {
    $("#preDialog").dialog("close");
}
		