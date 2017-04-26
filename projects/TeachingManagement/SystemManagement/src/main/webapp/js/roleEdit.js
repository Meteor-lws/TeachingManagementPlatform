$(function () {
    //定义变量接受行内容
    var rowValue;


    $('#roleDg').datagrid({
        url: 'datagrid_data1.json',
        fit: true,
        fitColumns: true,
        striped: true,
        rownumbers: true,
        border: false,
        pagination: true,
        pageSize: 20,
        pageNumber: 1,
        columns: [[
            {field: 'code', itemid: 'ID', checkbox: true, width: 10},
            {field: 'productid', title: '角色名称', width: 10},
            {field: 'productid', title: '角色权限', width: 10},
            {field: 'productid', title: '角色描述', width: 10}
        ]],
        toolbar: '#roleTb'
    });


    $('#roleDg').datagrid({
        onDblClickCell: function (index, field, value) {
            $('#roleDialog').dialog('open');
            $("#name").val(rowValue.itemid);

        },
        onSelect: function (rowIndex, rowData) {
            rowValue = rowData;
        }
    });

    //var pager = $('#roleDg').datagrid().datagrid('getPager'); // get the pager of datagrid

    $("#addRole").click(function () {
        $('#roleDialog').dialog({
            title: "班级添加"
        });
        $("#roleDialog").dialog('open');
    });
    $("#editRole").click(function () {

        var selects = $("#roleDg").datagrid("getSelections");
        if (selects.length == 0) {
            $.messager.alert('警告', '请选择一个需要修改的列');
            return;
        }
        if (selects.length > 1) {
            $.messager.alert('警告', '请勿选择多个');

        }

        else {
            $('#roleDialog').dialog({
                title: "班级修改"
            });
            $("#roledialog").window('open');
            var selectRow = selects[0];

        }
    });

    $("#removeRole").click(function () {
        var selects = $("#roleDg").datagrid("getSelections");
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
        $('#roleDg').datagrid('load', {
            'no': no
        });
    });

    $('#roleNameSel').combotree('tree').tree({
        data: [{
            text: "JAVA",
            state: "closed",
            children: [{
                text: "1611"
            }, {
                text: "1612"
            }, {
                text: "1701"
            }]
        }, {
            text: "UI",
            state: "closed",
            children: [{
                text: "1611"
            }, {
                text: "1612"
            }, {
                text: "1701"
            }]
        }

        ]
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
            $("#roleDialog").dialog("close")
        }
    });

}

function cancel() {
    $("#roleDialog").dialog("close");
}
