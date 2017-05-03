$(function () {
    $('#teacherId').combobox({
        url: "/education/getUploader",
        valueField: 'id',
        textField: 'teacherName'
    });

    $('#couDg').datagrid({
        url: '/education/selectCourseByCondition',
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
            {field: 'teacherView', title: '上传者', width: 10},
            {field: 'workUploadTimeView', title: '上传时间', width: 10}
        ]],
        queryParams: {
            workType: $("#workType").val(),
            teacherId: $("#teacherId").combobox("getValue"),
            workUploadTime: $("#workUploadTime").datetimebox("getValue")
        },
        toolbar: '#couTb'
    });


    // 获取数据表单分页对象
    var pager = $('#couDg').datagrid().datagrid('getPager'); // get the pager of
    // datagrid
    // 点击批量删除按钮
    $("#removeSchedule").click(function () {
        var selects = $("#couDg").datagrid("getSelections");
        if (selects.length == 0) {
            $.messager.alert('警告', '请选择一个需要删除的列');
        } else {

            $.messager.confirm('确认', '您确认想要删除这些记录吗？', function (choose) {
                if (choose) {
                    var ids = [];
                    for (var i = 0; i < selects.length; i++) {
                        ids[i] = selects[i].id;
                    }
                    $.ajax({
                        url: "/education/deleteCouByBatch",
                        data: {
                            ids: JSON.stringify(ids)
                        },
                        type: "post",
                        success: function (data) {
                            $.messager.alert('提示', '删除成功');
                            $("#couDg").datagrid("reload");
                        }
                    });
                }
            });
        }

    });

    $("#downSchedule").click(function () {
        var selects = $("#couDg").datagrid("getSelections");
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
        $("#couDg").datagrid("load", {
            workType: $("#workType").val(),
            teacherId: $("#teacherId").combobox("getValue"),
            workUploadTime: $("#workUploadTime").datetimebox("getValue")
        });

    });


});