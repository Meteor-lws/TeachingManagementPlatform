$(function () {

    $("#teacherId").combobox({
        url: "/education/getAllHeadTeacher",
        valueField: 'id',
        textField: 'teacherName'
    });

    $('#weeDg').datagrid({
        url: '/education/selectWeeByCondition',
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
        toolbar: '#weeTb'
    });


    var pager = $('#weeDg').datagrid().datagrid('getPager');

    $("#removeWeekly").click(function () {
        var selects = $("#weeDg").datagrid("getSelections");
        if (selects.length == 0) {
            $.messager.alert('警告', '请选择一个需要删除的列');
        } else {

            $.messager.confirm('确认', '您确认想要删除这些记录吗？', function (choose) {
                if (choose) {
                    var ids = new Array();
                    for (var i = 0; i < selects.length; i++) {
                        ids[i] = selects[i].id;
                    }
                    $.ajax({
                        url: "/education/deleteWeeByBatch",
                        data: {
                            ids: JSON.stringify(ids)
                        },
                        type: "post",
                        success: function (data) {
                            $.messager.alert('提示', '删除成功');
                            $("#resDg").datagrid("reload");
                        }
                    });
                }
            });
        }

    });

    $("#downWeekly").click(function () {
        var selects = $("#weeDg").datagrid("getSelections");
        if (selects.length == 0) {
            $.messager.alert('警告', '请选择一个需要下载的列');
        } else {

            $.messager.confirm('确认', '您确认想要下载这些记录吗？', function (choose) {
                if (choose) {
                }
            });
        }
    });

    $("#search").click(function () {
        $("#weeDg").datagrid("load", {
            workType: $("#workType").val(),
            teacherId: $("#teacherId").combobox("getValue"),
            workUploadTime: $("#workUploadTime").datetimebox("getValue")
        });
    });



});