$(function () {

    $('#resDg').datagrid({
        url: '/education/getResByCondition',
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
        toolbar: '#resTb'
    });



    var pager = $('#resDg').datagrid().datagrid('getPager');
    $("#removeRes").click(function () {
        var selects = $("#resDg").datagrid("getSelections");
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
                        url: "/education/deleteResByBatch",
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
    $("#downRes").click(function () {
        var selects = $("#resDg").datagrid("getSelections");
        if (selects.length == 0) {
            $.messager.alert('警告', '请选择一个需要下载的列');
        } else {
            $.messager.confirm('确认', '您确认想要下载这些记录吗？', function (choose) {
                if (choose) {
                    var paths = new Array();
                    for (var i = 0; i < selects.length; i++) {
                        paths[i] = selects[i].workUrl;
                    }

                    $.ajax({
                        url: "downloadByBatch",
                        type: "get"
                    });

                }
            });
        }

    });

    $('#teacherId').combobox({
        url: "/education/getUploader",
        valueField: 'id',
        textField: 'teacherName'
    });

    $("#search").click(function () {

        $("#resDg").datagrid("load", {
            workType: $("#workType").val(),
            teacherId: $("#teacherId").combobox("getValue"),
            workUploadTime: $("#workUploadTime").datetimebox("getValue")
        });

    });


});