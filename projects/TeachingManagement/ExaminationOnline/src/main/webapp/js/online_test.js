/**
    * Created by 朱高 on 2017/3/21.
    */
/*$.fn.combobox.defaults.filter = function(q, row){
    var opts = $(this).combobox('options');
    return row[opts.textField].indexOf(q) >= 0;
};*/
$(function () {
    var _table = $("#table");
    var _manager_add = $("#manager_add");
    _table.datagrid({
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
        toolbar: "#manager_tool",
        autoRowHeight: false,
        multiSort : true,
        remoteSort : false,
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
                width: 100,
                sortable : true
            },
            {
                field: "testPhase",
                title: "考试阶段",
                width: 100,
                sortable : true
            },
            {
                field: "testTime",
                title: "考试时间",
                width: 100,
                sortable : true
            },
            {
                field: "invigilator",
                title: "监考老师",
                width: 100,
                sortable : true
            },
            {
                field: "testPlace",
                title: "考试地点",
                width: 100,
                sortable : true
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
*/
    manager_tool = {
        add: function () {
            dialogOption("新增管理", "addExaminationArrangementMessage", function (url, data) {
                if ($("#manager_add").form("validate")) {
                    ajaxMethod(url, data, function (data) {
                        $.messager.show({
                            title: "提示",
                            msg: data
                        }, "由于系统原因添加考试安排失败请重新添加", "正在添加考试安排请等待");
                    });
                }
            });
            _manager_add.dialog("open");
           showFormOption();
        },
        edit: function () {
            var length = _table.datagrid("getSelections").length;
            if (length > 1) {
                $.messager.alert('警告操作！', '编辑记录只能选定一条数据！', 'warning');
            } else if (length === 1) {
                var obj = _table.datagrid("getSelected");
                dialogOption("修改管理", "updateExaminationArrangementMessage", function (url, data) {
                    if ($("#manager_add").form("validate")) {
                        ajaxMethod(url, data, function (data) {
                            $.messager.show({
                                title: "提示",
                                msg: data
                            }, "由于系统原因修改考试安排失败请重新修改", "正在修改中");
                        });
                    }
                }, obj.id);
                showFormOption();
                $("#className").combotree("setValue",{
                    id : obj.classId
                });
                $("#testPhase").combobox("select",obj.examinationStage);
                $("#testTime").datetimebox("setValue",obj.testTime);
                $("#invigilator").combobox("setValue",obj.teacherId);
                $("#testPlace").textbox("setText",obj.testPlace);
                _manager_add.dialog("open");
            } else {
                $.messager.alert('警告操作！', '编辑记录至少选定一条数据！', 'warning');
            }
        },
        remove: function () {
            var _table = $("#table");
            var length = _table.datagrid("getSelections").length;
            if (length === 0) {
                $.messager.alert('警告操作！', '未选择删除行！', 'warning');
            } else {
                var ids = null;
                var selections = _table.datagrid("getSelections");
                for (var i = 0; i < selections.length; i++) {
                    if (i === selections.length - 1) {
                        ids = ids + selections[i].id;
                    } else {
                        ids = ids + selections[i].id + ",";
                    }
                }
                var data = {
                    ids : ids
                };
                alert("ids = " + ids);
                ajaxMethod("removeExaminationArrangementMessage", data, function () {
                    $.messager.show({
                        title: "提示",
                        msg: "信息删除成功"
                    });
                }, "删除数据失败，请稍后再试", "正在删除数据");
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
});
function dialogOption(title, url, save, selectId) {
    var _manager_add = $("#manager_add");
    _manager_add.dialog({
        width: 350,
        title: title,
        modal: true,
        closed: true,
        buttons: [
            {
                text: "保存",
                iconCls: "icon-add",
                handler: function () {
                    var data = {
                        id : selectId,
                        classId: $("#className").combotree("getValue"),
                        examinationStage: $("#testPhase").combobox("getValue"),
                        examinationTime: $("#testTime").datetimebox("getValue"),
                        teacherId: $("#invigilator").combobox("getValue"),
                        examinationAddress: $("#testPlace").textbox("getText")
                    };
                    save(url, data);
                }
            },
            {
                text: "取消",
                iconCls: "icon-redo",
                handler: function () {
                    _manager_add.dialog("close").form("reset");
                    $("#table").datagrid("clearSelections");
                }
            }
        ],
        onClose: function () {
            _manager_add.form("reset");
        }
    });
}
function showFormOption() {
    $("#testPhase").combobox({
        required: true,
        valueField: 'id',//传递的值
        textField: 'dictionaryName',//显示的值
        url: "findDicTypeName",
        queryParams : {
            dicTypeName : "examination-stage"
        },
        filter: function(q, row){
            var opts = $(this).combobox('options');
            return row[opts.textField].indexOf(q) >= 0;
        }
    });
    $("#invigilator").combobox({
        required: true,
        valueField: 'id',//传递的值
        textField: 'teacherName',//显示的值
        url: "findTeacherName",
        filter: function(q, row){
            var opts = $(this).combobox('options');
            console.log(row[opts.textField].indexOf(q));
            return row[opts.textField].indexOf(q) > -1;
        }
    });
    $("#testPlace").textbox({
        required: true
    });
    testComboTree($("#className"), "className");
}
function ajaxMethod(url, data, success, error, text) {
    $.ajax({
        url: url,
        type: "POST",
        data: data,
        beforeSend: function () {
            $.messager.progress({
                text : text
            })
         },
        success: function(data){
            success(data);
        },
        error: function () {
            $.messager.alert('错误', error, 'error');
        },
        complete: function () {
            $.messager.progress("close");
            $("#manager_add").dialog("close").form("reset");
            var _table = $("#table");
            _table.datagrid("clearSelections");
            _table.datagrid("reload");
        }
    })
}
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
        onClick: function (node) {
            if (!$(this).tree('isLeaf', node.target)) {
                $("#className").combo('showPanel');
            }
        },
        onLoadSuccess: function (node, data) {
            var _this = this;
            if (data) {
                $(data).each(function () {
                    if (this.state === 'closed') {
                        $(_this).tree('expandAll');
                    }
                });
            }
        }
    });
}