/**
 * Created by 朱高 on 2017/3/21.
 */
$(function () {

    $("#table").datagrid({
        url: "datagrid",
        fit: true,
        fitColumns: true,
        striped: true,
        rownumbers: true,
        border: false,
        pagination: true,
        pageSize: 10,//显示的条数
        pageList: [10, 20, 30, 40, 50],
        pageNumber: 1,//也是排序项
        sortName: 'date',//排序项
        sortOrder: 'desc',//排序项
        toolbar: "#manager_tool",
        autoRowHeight: false,
        align: "center",
        columns: [[
            {
                field: "id",
                title: "编号",
                checkbox: true
            },
            {
                field: "className",
                title: "班级名字",
                width: 100
            },
            {
                field: "testPhase",
                title: "考试阶段",
                width: 100
            },
            {
                field: "testTime",
                title: "考试时间",
                width: 100
            },
            {
                field: "invigilator",
                title: "监考老师",
                width: 100
            },
            {
                field: "testPlace",
                title: "考试地点",
                width: 100
            }
        ]]
    });

    /*$("#condition_Name").combotree({
        url: "className",
        lines: true,//是否显示虚线
        onlyLeafCheck: true,//只能选取叶子结点
        //不为叶子节点不让选上
        onBeforeSelect: function (node) {
            //node.target代表的是选取的结点
            //node代表整个结点对象
            if (!$(this).tree('isLeaf', node.target)) {
                return false;
            }
        },
        //
        onClick: function (node) {
            if (!$(this).tree('isLeaf', node.target)) {
                $("#className").combo('showPanel');
            }
        },
        onLoadSuccess: function (node, data) {
            var _this = this;
            if (data) {
                $(data).each(function (index, value) {
                    if (this.state === 'closed') {
                        $(_this).tree('expandAll');
                    }
                });
            }
        }
    });

    manager_tool = {
        edit: function () {
            var length = $("#table").datagrid("getSelections").length;

            if (length > 1) {
                $.messager.alert('警告操作！', '编辑记录只能选定一条数据！', 'warning');
            } else if (length === 1) {
                dialogOption("修改管理", "update");
                $("#manager_add").dialog("open");
                testComboTree($("#className"), "className");
                var obj = $("#table").datagrid("getSelected");
                var data = {
                    id: obj.id,
                    className: obj.className,
                    testPhase: obj.testPhase,
                    testTime: obj.testTime,
                    invigilator: obj.invigilator,
                    testPlace: obj.testPlace
                };
                $("#manager_add").form("load", obj).dialog("open");
            } else {
                $.messager.alert('警告操作！', '编辑记录至少选定一条数据！', 'warning');
            }
        },
        add: function () {
            dialogOption("新增管理", "add");
            $("#manager_add").dialog("open");
            $("#testPhase").combobox({
                required: true,
                valueField: 'id',//传递的值
                textField: 'text',//显示的值
                url: "json/testPhase.json"
            });
            $("#invigilator").combobox({
                required: true,
                valueField: 'id',//传递的值
                textField: 'text',//显示的值
                url: "json/invigilator.json"
            });
            $("#testPlace").combobox({
                required: true,
                valueField: 'id',//传递的值
                textField: 'text',//显示的值
                url: "json/testPlace.json"
            });
            testComboTree($("#className"), "className");
        },
        remove: function () {
            var length = $("#table").datagrid("getSelections").length;
            if (length === 0) {
                $.messager.alert('警告操作！', '为选择删除行！', 'warning');
            } else {
                var ids = "";
                var selections = $("#table").datagrid("getSelections");
                for (var i = 0; i < selections.length; i++) {
                    if (i === selections.length - 1) {
                        ids = ids + selections[i].id;
                    } else {
                        ids = ids + selections[i].id + ",";
                    }
                }
                $.ajax({
                    url: "remove",
                    type: "post",
                    data: {
                        ids: ids
                    },

                    beforeSend: function () {
                        $.messager.progress({
                            text: "正在删除信息中....."
                        })
                    },

                    success: function (data, response, status) {
                        $.messager.progress("close");
                        $.messager.show({
                            title: "提示",
                            msg: "信息删除成功",
                        });
                        $("#table").datagrid("reload");
                    }
                });
            }
        },
        search: function () {
            //var condition = $("#condition_Name").val();
            console.log($("#condition_Name").val());
            console.log($("input[name='date_from']").val());
            console.log($("input[name='date_to']").val());
            //$.ajax()
        }
    };

    function testComboTree(idObject, url) {

        idObject.combotree({
            url: url,
            required: true,//是否必填
            lines: true,//是否显示虚线
            onlyLeafCheck: true,//只能选取叶子结点
            //不为叶子节点不让选上
            onBeforeSelect: function (node) {
                //node.target代表的是选取的结点
                //node代表整个结点对象
                if (!$(this).tree('isLeaf', node.target)) {
                    return false;
                }
            },
            //
            onClick: function (node) {
                if (!$(this).tree('isLeaf', node.target)) {
                    $("#className").combo('showPanel');
                }
            },
            onLoadSuccess: function (node, data) {
                var _this = this;
                if (data) {
                    $(data).each(function (index, value) {
                        if (this.state === 'closed') {
                            $(_this).tree('expandAll');
                        }
                    });
                }
            }
        });
    }

    function ajaxMethod(url, data) {
        $.ajax({
            url: url,
            type: "POST",
            data: data,
            dataType: "json",
            beforeSend: function () {
                $.messager.progress({
                    text: "正在新增中....."
                })
            },
            success: function (data, response, status) {
                $.messager.progress("close");
                console.log(data);
                if (url === 'update') {

                }
                if (data !== 0) {
                    $.messager.show({
                        title: "提示",
                        msg: "新增用户成功"
                    });
                    $("#manager_add").dialog("close").form("reset");
                    $("#table").datagrid("clearSelections");
                    $("#table").datagrid("reload");
                } else {
                    $.messager.alert("新增失败", "未知错误导致失败", "warning");
                }
            }
        })
    }

    function dialogOption(title, url) {
        $("#manager_add").dialog({
            width: 350,
            title: title,
            modal: true,
            closed: true,
            buttons: [
                {
                    text: "保存",
                    iconCls: "icon-add",
                    handler: function () {
                        if ($("#manager_add").form("validate")) {
                            var id = null;
                            if (url !== 'add') {
                                id = $("#table").datagrid("getSelected").id;
                            }
                            var data = {
                                id: id,
                                className: $("input[name='className']").val(),
                                testPhase: $("input[name='testPhase']").val(),
                                testTime: $("input[name='testTime']").val(),
                                invigilator: $("input[name='invigilator']").val(),
                                testPlace: $("input[name='testPlace']").val()
                            };
                            ajaxMethod(url, data);
                        }
                    }
                },
                {
                    text: "取消",
                    iconCls: "icon-redo",
                    handler: function () {
                        $("#manager_add").dialog("close").form("reset");
                        $("#table").datagrid("clearSelections");
                    }
                }
            ],
            onClose: function () {
                console.log("hhh");
                $("#manager_add").form("reset");
            }
        });
     }*/
});
