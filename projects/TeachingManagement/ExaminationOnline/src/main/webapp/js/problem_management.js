/**
 * Created by 朱高 on 2017/3/28.
 */
$(function () {
    $("#table").datagrid({
        url: "question",
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
                field: "questionContent",
                title: "试题",
                width: 100
            },
            {
                field: "questionType",
                title: "试题类型",
                width: 100
            },
            {
                field: "questionTime",
                title: "出题时间",
                width: 100
            },
            {
                field: "proposer",
                title: "出题人",
                width: 100
            },
            {
                field: "phase",
                title: "适用阶段",
                width: 100
            },
            {
                field: "usageCount",
                title: "使用次数",
                width: 100
            }
        ]]
    });
    $("#addQuestion").dialog({
        width: 860,
        height: 500,
        title: "新增管理",
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

                }
            }
        ],
        onClose: function () {
            $("#manager_add").form("reset");
        },
    });
    manager_tool = {
        add: function () {
            $("#addQuestion").dialog("open");
            $("input[name='questionType']").combobox({
                url: "json/questionType.json",
                panelHeight: 100,
                valueField: 'id',//传递的值
                textField: 'text',//显示的值
                onSelect: function (record) {
                    //$("#answer").combobox("clear");
                    if (record.id == 1) {
                        $("#answer_div").show();
                        $("#answer1_div").hide();
                        $("#answer2_div").hide();
                        answerSelect("json/answer.json");
                    } else if (record.id == 2) {
                        $("#answer_div").show();
                        $("#answer1_div").hide();
                        $("#answer2_div").hide();
                        answerSelect("json/answer1.json");
                    } else if (record.id == 3) {
                        $("#answer").combobox("clear");
                        $("#answer_div").hide();
                        $("#answer1_div").show();
                        $("#answer2_div").hide();
                        $("#answer1").validatebox({});
                    } else {
                        $("#answer").combobox("clear");
                        $("#answer_div").hide();
                        $("#answer1_div").hide();
                        $("#answer2_div").show();
                    }
                }
            });
            $("input[name='phase']").combobox({
                url: "json/testPhase.json",
                panelHeight: 100,
                valueField: 'id',//传递的值
                textField: 'text'//显示的值
            })
        }
    };
    function answerSelect(url) {
        $("#answer").combobox({
            panelHeight: 100,
            valueField: 'id',//传递的值
            textField: 'text',//显示的值
            editable: false
        });
        $("#answer").combobox("reload", url);
    }

});

