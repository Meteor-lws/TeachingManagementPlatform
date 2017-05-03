$(function () {
    //定义变量接受行内容
    var rowValue;
    var visList; //权限是否可视列表
    var enableList; // 权限启用列表
    $("#preDialog").dialog("close");
    $.ajax({
        url: "/system/getResourceVisible",
        type: "post",
        async: false,
        success: function (data) {
            visList = $.parseJSON(data);
        }

    });

    $("#resourceVisibleForm").switchbutton({
        onText: visList[1].dictionaryName,
        offText: visList[0].dictionaryName,
        onChange: function (change) {
            if (change) {
                $("#resourceVisible").val(visList[1].id);
            }
            else {
                $("#resourceVisible").val(visList[0].id);
            }
        }
    });


    $.ajax({
        url: "/system/getResourceEnable",
        type: "post",
        async: false,
        success: function (data) {
            enableList = $.parseJSON(data);
        }

    });

    $("#resourceEnableFrom").switchbutton({
        onText: enableList[1].dictionaryName,
        offText: enableList[0].dictionaryName,
        onChange: function (change) {
            if (change) {
                $("#resourceEnable").val(enableList[1].id);
            }
            else {
                $("#resourceEnable").val(enableList[0].id);
            }
        }
    });


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
        onDblClickRow: function (index, row) {
            $('#preDialog').dialog('open');
            $("#id").val(row.id);
            $("#resourceNameForm").textbox("setValue", row.resourceName);
            $("#resourceValueForm").textbox("setValue", row.resourceValue);
            $("#resourceType").combobox("select", row.resourceType);
            $("#resourceEnable").val(row.resourceEnable);
            $("#resourceVisible").val(row.resourceVisible);
            $("#resourceDescribe").textbox("setValue", row.resourceDescribe);
            var visi = row.resourceVisible;
            var enable = row.resourceEnable;
            if (visi == visList[1].id) {
                $("#resourceVisibleForm").switchbutton("check");
            }
            else {
                $("#resourceVisibleForm").switchbutton("uncheck");
            }
            if (enable == enableList[1].id) {
                $("#resourceEnableFrom").switchbutton("check");
            }
            else {
                $("#resourceEnableFrom").switchbutton("uncheck");
            }
        }
    });

    var pager = $('#preDg').datagrid().datagrid('getPager'); // get the pager of datagrid

    $("#addPre").click(function () {
        $('#preDialog').dialog({
            title: "权限添加"
        });
        $("#resourceVisible").val(visList[0].id);
        $("#resourceEnable").val(enableList[0].id);
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

    $("#resourceType").combobox({
        url: "/system/getAllResourceType",
        valueField: 'id',
        textField: 'dictionaryName'
    });



});
function clearForm() {
    $("input").each(function () {
        $(this).val("");
    });
}
function submitForm() {
    $.messager.progress(); // 显示进度条
    $('#preForm').form('submit', {
        url: "/system/saveOrUpdateResource",
        onSubmit: function () {
            var isValid = $(this).form('validate');
            if (!isValid) {
                $.messager.progress('close'); // 如果表单是无效的则隐藏进度条
            }
            return isValid; // 返回false终止表单提交
        },
        success: function () {
            $.messager.progress("close"); // 如果提交成功则隐藏进度条
            $("#preForm").form("clear");
            $("#preDg").datagrid("reload");
            $("#preDialog").dialog("close")
        }
    });

}

function cancel() {
    $("#preForm").form("clear");
    $("#preDialog").dialog("close");
}
