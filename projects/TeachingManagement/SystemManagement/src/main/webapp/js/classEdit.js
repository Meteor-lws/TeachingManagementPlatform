$(function () {
    //定义变量接受行内容
    var rowValue;
    $('#dg').datagrid({
        onDblClickCell: function (index, field, value) {
            $('#w').window('open');
            $("#name").val(rowValue.itemid);

        },
        onSelect: function (rowIndex, rowData) {
            rowValue = rowData;
        }
    });

    var pager = $('#dg').datagrid().datagrid('getPager'); // get the pager of datagrid

    $("#addStu").click(function () {
        $('#w').window({
            title: "班级添加"
        });
        $("#w").window('open');
    });
    $("#editStu").click(function () {

        var selects = $("#dg").datagrid("getSelections");
        if (selects.length == 0) {
            $.messager.alert('警告', '请选择一个需要修改的列');
            return;
        }
        if (selects.length > 1) {
            $.messager.alert('警告', '请勿选择多个');

        }

        else {
            $('#w').window({
                title: "班级修改"
            });
            $("#w").window('open');
            var selectRow = selects[0];

        }
    });

    $("#removeStu").click(function () {
        var selects = $("#dg").datagrid("getSelections");
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
        $('#dg').datagrid('load', {
            'no': no
        });
    });

    $('#cc').combotree('tree').tree({
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
            $("#w").window("close")
        }
    });

}

function cancel() {
    $("#w").window("close");
}
		