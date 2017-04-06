$(function () {
    $('#attDg').datagrid({
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
            {field: 'productid', title: '学号', width: 10},
            {field: 'productid', title: '姓名', width: 10}
        ]],
        toolbar: '#attTb'
    });


    var pager = $('#dg').datagrid().datagrid('getPager');
    pager.pagination({
        buttons: [{
            iconCls: 'icon-search',
            handler: function () {
                alert('search');
            }
        }, {
            iconCls: 'icon-add',
            handler: function () {
                alert('add');
            }
        }, {
            iconCls: 'icon-edit',
            handler: function () {
                alert('edit');
            }
        }]
    });

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

});