$(function () {

    $('#depSel').combotree('tree').tree({
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


    $('#weeDg').datagrid({
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
            {field: 'productid', title: '部门', width: 10},
            {field: 'productid', title: '上传者', width: 10},
            {field: 'productid', title: '上传时间', width: 10}
        ]],
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
                    $.messager.alert('提示', '删除成功');
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


    $('#uploderSel').combotree('tree').tree({
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