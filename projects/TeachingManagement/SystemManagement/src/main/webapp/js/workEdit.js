$(function () {
    var pager = $('#dg').datagrid().datagrid('getPager');	// get the pager of datagrid
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

    $('#cc').combotree('tree').tree({
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