$(function () {
    $('#classSel').combotree('tree').tree({
        data: [
            {
                text: "JAVA",
                state: "closed",
                children: [{text: "1611"}, {text: "1612"}, {text: "1701"}]
            },
            {
                text: "UI",
                state: "closed",
                children: [{text: "1611"}, {text: "1612"}, {text: "1701"}]
            }

        ]
    });


    $('#couDg').datagrid({
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
            {field: 'productid', title: '班级', width: 10},
            {field: 'productid', title: '上传者', width: 10},
            {field: 'productid', title: '上传时间', width: 10}
        ]],
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
                    $.messager.alert('提示', '删除成功');
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


    //   上传者 树形下拉列表
    $('#scheduleSel').combotree('tree').tree({
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