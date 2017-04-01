/**
 * Created by 朱高 on 2017/3/17.
 */
$(function () {
    $("#table").datagrid({
        url: "json/datagrid_data1.json",
        fit: true,
        fitColumns: true,
        striped: true,
        rownumbers: true,
        border: false,
        pagination: true,
        pageSize: 20,//显示的条数
        pageList: [10, 20, 30, 40, 50],
        pageNumber: 1,//也是排序项
        sortName: 'date',//排序项
        sortOrder: 'desc',//排序项
        toolbar: '#manager_tool',
        columns: [[
            {
                field: "productid",
                title: "产品编号",
                width: 100,
            },
            {
                field: "productname",
                title: "产品名字",
                width: 100,
            },
            {
                field: "unitcost",
                title: "产品代码",
                width: 100,
            },
            {
                field: "status",
                title: "产品状态",
                width: 100,
            },
            {
                field: "listprice",
                title: "产品价格",
                width: 100,
            },
            {
                field: "attr1",
                title: "产品数量",
                width: 100,
            },
            {
                field: "itemid",
                title: "产品嗲吗",
                width: 100,
            }
        ]],
    });

    $("#manager_add").dialog({
        width: 350,
        title: "新增管理",
        modal: true,
        closed: true,
        buttons: [
            {
                text: "提交",
                iconCls: "icon-add",
                handler: function () {
                    if ($("#manager_add").form("validate")) {
                        $.ajax({
                            url: "add",
                            type: "post",
                            data: {
                                manager: $("input[name = 'manager']").val(),
                                password: $("input[name = 'password']").val(),
                                auth: $("#auth").combobox("getText"),
                            },
                            beforeSend: function () {
                                $.messager.progress({
                                    text: '正在新增中...',
                                });
                            },
                            success: function (data, response, status) {
                                $.messager.progress('close');
                                if (data > 0) {
                                    $.messager.show({
                                        title: "提示",
                                        msg: "新增用户成功",
                                    });
                                    $("#manager_add").dialog("close").form("reset");
                                } else {
                                    $.messager.alert("新增失败", "未知错误导致失败", "warning");
                                }

                            }
                        })
                    }
                }
            },
            {
                text: "取消",
                iconCls: "icon-redo",
                handler: function () {
                    $("#manager_add").dialog("close").form("reset");
                }
            }
        ]
    });

    $("input[name='manager']").validatebox({
        required: true,
        validType: 'length[2,30]',
        missingMessage: '请输入管理名称',
        invalidMessage: '管理名称在 2-20 位',
    });

    $("input[name='password']").validatebox({
        required: true,
        validType: 'length[6,20]',
        missingMessage: '请输入管理密码',
        invalidMessage: '管理密码在 6-30 位',
    });

    $("#auth").combotree({
        url: "tree",
        required: true,
        required: true,
        lines: true,
        multiple: true,
        checkbox: true,
        onlyLeafCheck: true,
        onLoadSuccess: function (node, data) {
            var _this = this;
            if (data) {
                $(data).each(function (index, value) {
                    if (this.state == "closed") {
                        $(_this).tree('expandAll');
                    }
                });
            }
        },
    });

    $("#manager_edit").dialog({
        width: 350,
        title: "修改管理",
        modal: true,
        closed: true,
        buttons: [
            {
                text: "保存",
                iconCls: "icon-add",
                handler: function () {

                }
            },
            {
                text: "取消",
                iconCls: "icon-redo",
                handler: function () {
                    $("#manager_edit").dialog("close").form("reset");
                }
            }
        ],
    });
    manager_tool = {
        add: function () {
            $("#manager_add").dialog("open");
            $('input[name="manager"]').focus();
        },
        edit: function () {
            /*var rows = $("#manager_edit").datagrid("getSelections");
             if(rows.length == 0){

             }
             $("#manager_edit").dialog("open");*/
            alert("ss");
        }
    }
});