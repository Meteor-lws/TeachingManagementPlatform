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
    var _phase = $("#testPhase");
    var _invigilator = $("#invigilator");
    var _place = $("#testPlace");
    var _className = $("#className");
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
        autoRowHeight: true,
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
    showFormOption($("#conditionPhase"), $("#conditionInvigilator"), $("#conditionPlace"), $("#condition_Name"), false);
    manager_tool = {
        add: function () {
            dialogOption("新增管理", "addExaminationArrangementMessage", function (url, data) {
                if ($("#manager_add").form("validate")) {
                    ajaxMethod(url, data, function (data) {
                        $.messager.show({
                            title: "提示",
                            msg: data
                        });
                        clear();
                    }, "由于系统原因添加考试安排失败请重新添加", "正在添加考试安排请等待");
                }
            });
            _manager_add.dialog("open");
            showFormOption(_phase, _invigilator, _place, _className, true);
        },
        edit: function () {
            var length = _table.datagrid("getSelections").length;
            if (length > 1) {
                $.messager.alert('警告操作！', '编辑记录只能选定一条数据！', 'warning');
            } else if (length === 1) {
                var obj = _table.datagrid("getSelected");

                dialogOption("修改管理", "updateExaminationArrangementMessage", function (url, data) {
                    if (_manager_add.form("validate")) {
                        ajaxMethod(url, data, function (data) {
                            $.messager.show({
                                title: "提示",
                                msg: data
                            }, "由于系统原因修改考试安排失败请重新修改", "正在修改中");
                        });
                    }
                }, obj.id);
                showFormOption(_phase, _invigilator, _place, _className, true);
                _className.combotree("setValue",{
                    id : obj.classId
                });
                _phase.combobox("select",obj.examinationStage);
                $("#testTime").datetimebox("setValue",obj.testTime);
                _invigilator.combobox("setValue",obj.teacherId);
                _place.textbox("setText",obj.testPlace);
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
                $.messager.confirm("确认对话框", "确定要删除所选数据吗？", function (flag) {
                    if(flag){
                        var ids = "";
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
                        ajaxMethod("removeExaminationArrangementMessage", data, function () {
                            $.messager.show({
                                title: "提示",
                                msg: "信息删除成功"
                            });
                        }, "删除数据失败，请稍后再试", "正在删除数据");
                    }else {
                        _table.datagrid("clearSelections");
                    }
                })
            }
        },
        search: function () {
            var condition_Name = $("#condition_Name").combotree("getValue");
            var conditionPhase = $("#conditionPhase").combobox("getValue");
            var conditionTime = $("#conditionTime").datetimebox("getValue");
            var conditionInvigilator = $("#conditionInvigilator").combobox("getValue");
            var conditionPlace = $("#conditionPlace").textbox("getText");
            var cn = $("#condition_Name");
            if(condition_Name == "" && conditionPhase == "" && conditionTime == "" && conditionInvigilator == "" && conditionPlace == ""){
                $.messager.alert('警告', "为选择查询条件，请重试", 'warning');
            }else {
                var target = cn.combotree("tree").tree("getSelected");
                var page = _table.datagrid("options").pageNumber;
                var rows = _table.datagrid("options").pageSize;
                var data = {
                    examinationStage : conditionPhase,
                    testTime : conditionTime,
                    teacherId : conditionInvigilator,
                    testPlace : conditionPlace,
                    page : page,
                    rows : rows
                };
                if(target != null){
                    if(cn.combotree("tree").tree("isLeaf", target.target)){
                        data.classId = condition_Name;
                    }else {
                        data.parentNode = target.id;
                    }
                }
                _table.datagrid("options").queryParams = data;
                _table.datagrid("reload");
            }
        },
        clear : function () {
            $("#condition_Name").combotree("clear");
            $("#conditionPhase").combobox("clear");
            $("#conditionTime").datetimebox("setValue", "");
            $("#conditionInvigilator").combobox("clear");
            $("#conditionPlace").textbox("clear");
            var data = {
                examinationStage : "",
                testTime : "",
                teacherId : "",
                testPlace : "",
                page : _table.datagrid("options").pageNumber,
                rows : _table.datagrid("options").pageSize
            };
            _table.datagrid("options").queryParams = data;
            _table.datagrid("load", "datagrid");
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
                    _manager_add.dialog("close");
                    alert("取消");
                }
            },
            {
                text: "取消",
                iconCls: "icon-redo",
                handler: function () {
                    clear();
                    $("#table").datagrid("clearSelections");
                    _manager_add.dialog("close");
                }
            }
        ],
        onClose: function () {
            _manager_add.form("reset");
        }
    });
}
function showFormOption(_phase, _invigilator, _place, _className, flag) {
    _phase.combobox({
        required: flag,
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
    _invigilator.combobox({
        required: flag,
        valueField: 'id',//传递的值
        textField: 'teacherName',//显示的值
        url: "findTeacherName",
        filter: function(q, row){
            var opts = $(this).combobox('options');
            console.log(row[opts.textField].indexOf(q));
            return row[opts.textField].indexOf(q) > -1;
        }
    });
    _place.textbox({
        required: flag
    });
    testComboTree(_className, "className", flag);
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
            var _table = $("#table");
            _table.datagrid("clearSelections");
            _table.datagrid("reload");
        },
        error: function () {
            $.messager.alert('错误', error, 'error');
        },
        complete: function () {
            $.messager.progress("close");
            $("#manager_add1").dialog("close").form("reset");
            $("#testPlace").textbox("reset");
        }
    })
}
function testComboTree(idObject, url, flag) {
    idObject.combotree({
        url: url,
        required: flag,//是否必填
        lines: true,//是否显示虚线
        onlyLeafCheck: flag,//只能选取叶子结点
        //不为叶子节点不让选上
        onBeforeSelect: function (node) {
            //node.target代表的是选取的结点
            //node代表整个结点对象
            if (!$(this).tree('isLeaf', node.target)) {
                return !flag;
            }
        },
        onClick: function (node) {
            if(flag){
                if (!$(this).tree('isLeaf', node.target)) {
                    idObject.combo('showPanel');
                }
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
function clear() {
        $("#className").combotree("clear");
        $("#testPhase").combobox("clear");
        $("#testTime").datetimebox("setValue", "");
        $("#invigilator").combobox("clear");
        $("#testPlace").textbox("clear");
}