/**
 * Created by 朱高 on 2017/3/28.
 */
$.fn.combobox.defaults.filter = function(q, row){
    var opts = $(this).combobox('options');
    return row[opts.textField].indexOf(q) >= 0;
};
var questionObj = null;
$(function () {
    var _table = $("#table");
    $("#addQuestion").dialog("close");
    _table.datagrid({
        url: "selectQuestion",
        fit: true,
        fitColumns: true,
        striped: true,
        rownumbers: true,
        border: false,
        pagination: true,
        pageSize: 10,//显示的条数
        pageList: [10, 20, 30, 40, 50],
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
                field: "questionSubjectName",
                title: "试题适用班级类型",
                width: 100
            },
            {
                field: "questionTypeName",
                title: "试题类型",
                width: 100
            },
            {
                field: "questionScore",
                title: "试题分数",
                width: 100
            },
            {
                field: "questionContent",
                title: "试题内容",
                width: 100
            },
            {
                field: "questionStageName",
                title: "适用阶段",
                width: 100
            },
            {
                field: "questionAnswer",
                title: "试题答案",
                width: 100
            },
            {
                field: "questionSelections",
                title: "使用次数",
                width: 100
            }
        ]]
    });
    showQuery();
    manager_tool = {

        add : function () {
            $("#typeText").hide();
            $("#questionType2").hide();
            dialogOption("chooseQuestionType", "选择考试题目类型", function () {
                var _chooseQuestionType = $("input[name='questionType']:checked");
                var questionValue = _chooseQuestionType.val();
                $("#chooseQuestionType").dialog("close");
                init();
                //单选题
                chooseType(questionValue, "");
                var _questionType = $("input[name='questionType']:checked");
                $("#addQuestion").dialog({
                    modal: true,
                    resizable: true,
                    title: "修改题目信息",
                    buttons: [
                        {
                            text: "保存",
                            iconCls: "icon-add",
                            handler: function () {
                                var _answer = $("input[name='questionAnswer']:checked");
                                console.log(_questionType);
                                var data = {
                                    questionSubject: $("#classType").combobox("getValue"),
                                    questionType: _questionType.attr("id"),
                                    questionStage: $("#questionStage").combobox("getValue"),
                                    questionScore: $("#questionScores").textbox("getValue"),
                                    questionAnswer: "",
                                    questionContent: $("textarea[name='questionContent']").val(),
                                    questionSelections: 0
                                };
                                if (_questionType.val() === "multi-choice") {
                                    var ids = "";
                                    for (var i = 0; i < _answer.length; i++) {
                                        if (i === _answer.length - 1) {
                                            ids = ids + _answer[i].id;
                                        } else {
                                            ids = ids + _answer[i].id + ",";
                                        }
                                    }
                                    data.questionAnswer = ids;
                                } else if (_questionType.val() === "fill-in-blank") {
                                    data.questionAnswer = $("#fill-in-blank").textbox("getValue");
                                } else if (_questionType.val() === "programing") {
                                    data.questionAnswer = $("#_easyui_textbox_input5").val();
                                } else {
                                    data.questionAnswer = _answer.attr("id");
                                }
                                console.log(data);
                                ajaxMethod("insertQuestion", data, "post", function (data) {
                                    _table.datagrid("clearSelections");
                                    _table.datagrid("reload");
                                    $("#addQuestion").dialog("close");
                                    $.messager.show({
                                        title: "提示",
                                        msg: data
                                    });
                                })
                            }
                        },
                        {
                            text: "取消",
                            iconCls: "icon-redo",
                            handler: function () {
                                clearDialog();
                            }
                        }
                    ],
                    onClose: function () {
                        clearComboboxValue("classType");
                        clearComboboxValue("questionStage");
                        $("#questionScores").textbox("reset");
                        KindEditor.instances[0].html("");
                    }
                });
                showCombobox("classType", "findDicTypeName", true, "examination-subject");
                showCombobox("questionStage", "findDicTypeName", true, "examination-stage");
                showTextbox("questionScores", true);
            }, function () {
                
            }, function () {
                
            });
            //选择考试题目的类型
            checkQuestionType("chooseQuestionType", 'input[name="questionType"]:first', "", "");
        },
        edit: function () {
            var length = _table.datagrid("getSelections").length;
            if (length > 1) {
                $.messager.alert('警告操作！', '编辑记录只能选定一条数据！', 'warning');
            } else if (length === 1) {
                var obj = _table.datagrid("getSelected");
                var _questionType = $("input[name='questionType']:checked");
                checkQuestionType("questionType2", '#' + obj.questionTypeId, obj.questionType, obj.questionAnswer);
                console.log(obj);
                $("#typeText").show();
                $("#questionType2").show();
                showCombobox("classType", "findDicTypeName", true, "examination-subject");
                showCombobox("questionStage", "findDicTypeName", true, "examination-stage");
                showTextbox("questionScores", true);
                $("#classType").combobox("select", obj.questionSubject);
                $("#questionStage").combobox("select", obj.questionStage);
                $("#questionScores").textbox("setText", obj.questionScore);
                KindEditor.instances[0].html(obj.questionContent);
                $("#addQuestion").dialog({
                    modal: true,
                    resizable: true,
                    buttons: [
                        {
                            text: "保存",
                            iconCls: "icon-add",
                            title: "修改试题信息",
                            handler: function () {
                                var _answer = $("input[name='questionAnswer']:checked");
                                var _questionType = $("input[name='questionType']:checked");
                                var score = $("#questionScores").textbox("getValue");
                                var data = {
                                    id: obj.id,
                                    questionSubject: $("#classType").combobox("getValue"),
                                    questionType: _questionType.attr("id"),
                                    questionStage: $("#questionStage").combobox("getValue"),
                                    questionScore: "",
                                    questionAnswer: "",
                                    questionContent: KindEditor.instances[0].html().trim(),
                                    questionSelections: 0
                                };
                                if (score.length > 0) {
                                    data.questionScore = score;
                                } else {
                                    data.questionScore = obj.questionScore;
                                }
                                if (_questionType.val() === "multi-choice") {
                                    var ids = "";
                                    for (var i = 0; i < _answer.length; i++) {
                                        if (i === _answer.length - 1) {
                                            ids = ids + _answer[i].id;
                                        } else {
                                            ids = ids + _answer[i].id + ",";
                                        }
                                    }
                                    data.questionAnswer = ids;
                                } else if (_questionType.val() === "fill-in-blank") {
                                    data.questionAnswer = $("#fill-in-blank").textbox("getValue");
                                } else if (_questionType.val() === "programing") {
                                    data.questionAnswer = $("#_easyui_textbox_input5").val();
                                } else {
                                    data.questionAnswer = _answer.attr("id");
                                }
                                console.log(data);
                                ajaxMethod("updateQuestion", data, "post", function (data) {
                                    _table.datagrid("clearSelections");
                                    _table.datagrid("reload");
                                    $("#addQuestion").dialog("close");
                                    $.messager.show({
                                        title: "提示",
                                        msg: data
                                    });
                                })
                            }
                        },
                        {
                            text: "取消",
                            iconCls: "icon-redo",
                            handler: function () {
                                clearDialog();
                            }
                        }
                    ],
                    onClose: function () {
                        clearComboboxValue("classType");
                        clearComboboxValue("questionStage");
                        $("#questionScores").textbox("reset");
                        KindEditor.instances[0].html("");
                    }
                });
            } else {
                $.messager.alert('警告操作！', '编辑记录至少选定一条数据！', 'warning');
            }
        },
        search : function () {
            var questionSubjectName = getCombobox("questionSubjectName");
            var questionTypeName = getCombobox("questionTypeName");
            var questionStageName = getCombobox("questionStageName");
            var questionSelections = getTextbox("questionSelections");
            if(questionSubjectName === "" && questionTypeName === "" && questionStageName === "" && questionSelections === ""){
                $.messager.alert('警告', "为选择查询条件，请重试", 'warning');
            }else {
                _table.datagrid({
                    queryParams : {
                        questionSubject : questionSubjectName,
                        questionType : questionTypeName,
                        questionStage : questionStageName,
                        questionSelections : questionSelections
                    }
                })
            }

        },
        clear : function () {
            clearComboboxValue("questionSubjectName");
            clearComboboxValue("questionTypeName");
            clearComboboxValue("questionStageName");
            clearTextboboxValue("questionSelections");
            _table.datagrid({
                queryParams : {
                }
            });
        }
    };
    $("input[name='questionType']").change(function () {
        alert("s");
        chooseType(obj.questionType, "");
    });
});
function showQuery() {
    showCombobox("questionSubjectName", "findDicTypeName", false, "examination-subject");
    showCombobox("questionTypeName", "findDicTypeName", false, "question_type");
    showCombobox("questionStageName", "findDicTypeName", false, "examination-stage");
    showTextbox("questionSelections", false);
}
function showCombobox(id, url, flag, dicTypeName) {
    $("#" + id).combobox({
        url : url,
        required : flag,
        valueField : 'id',//传递的值
        textField : "dictionaryName",//显示的值
        limitToList : true,
        queryParams : {
            dicTypeName : dicTypeName
        },
        onSelect : function (record) {
            if(id === "questionType"){
                console.log(record);
            }
        }
    })
}
function showTextbox(id, flag) {
    $("#" + id).textbox({
        required: flag,
        width: 100
    })
}
function getCombobox(id) {
    return $("#" + id).combobox("getValue");
}
function getTextbox(id) {
    return $("#" + id).textbox("getValue");
}
function clearComboboxValue(id) {
    $("#" + id).combobox("clear");
}
function clearTextboboxValue(id) {
    $("#" + id).textbox("clear");
}
function dialogOption(id, title, save, redo, close) {
    var _manager_add = $("#" + id);
    _manager_add.dialog({
        title: title,
        modal: true,
        resizable : true,
        buttons: [
            {
                text: "保存",
                iconCls: "icon-add",
                handler: function () {
                    save();
                }
            },
            {
                text: "取消",
                iconCls: "icon-redo",
                handler: function () {
                    _manager_add.dialog("close");
                    redo()
                }
            }
        ],
        onClose: function () {
            close();
            /*clearComboboxValue("classType");
            clearComboboxValue("questionType");
            clearComboboxValue("questionStageName");*/
        }

    });
}
function ajaxMethod(url, data, method, success) {
    $.ajax({
        url : url,
        method : method,
        data : data,
        beforeSend : function () {

        },
        success : function (data1) {
            success(data1);
        },
        error : function () {
            
        },
        complete : function () {
            $.messager.progress("close");
        }
    })
}
function init() {
    $("#single-choice").hide();
    //clearComboboxValue("single-choice");
    $("#multi-choice").hide();
    //clearComboboxValue("multi-choice");
    $("#fill-in-blank").hide();
    //clearTextboboxValue("fill-in-blank");
    $("#judgment").hide();
    $("#programing").hide()
    //clearComboboxValue("judgment");
}
function clearDialog(){
    $("#addQuestion").dialog("close");
}
function uploadFile(url) {
    var formData = new FormData($("#programingForm")[0]);
    $.ajax({
        url: url,
        type: 'POST',
        data: formData,
        async: false,
        cache: false,
        contentType: false,
        processData: false,
        beforeSend : function () {
            $.messager.progress({
                text : "正在上传文件"
            })
        },
        success: function (data) {
            var obj = $.parseJSON(data);
            console.log(obj.fileUrl);
            console.log(obj.fileUrl !== null && obj.fileUrl !=="" && obj.fileUrl !== undefined);
            if(obj.fileUrl !== null && obj.fileUrl !== "" && obj.fileUrl !== undefined){
                $.messager.show({
                    title: "提示",
                    msg: obj.message
                });
                $("#_easyui_textbox_input5").val(obj.fileUrl);
            }else {
                $.messager.alert('警告', obj.message, 'warning');
            }
        },
        complete : function () {
            $.messager.progress("close");
        },
        error: function () {
        }
    });
}
function checkQuestionType(id, objStr, typeValue, answerValue) {
    ajaxMethod("findDicTypeName", {dicTypeName: "question_type"}, "post", function (data1) {
        questionObj = $.parseJSON(data1);
        var _chooseQuestionType = $("#" + id);
        _chooseQuestionType.html('');
        console.log(objStr.length);
        if (objStr.length > 32) {
            $.each(questionObj, function (index, value) {
                var typeValue = value.dictionaryValue;
                _chooseQuestionType.append('<label for=' + value.id + '>' + (index + 1) + '.' + value.dictionaryName + '</label><input disabled name="questionType"  id=' + value.id + ' type="radio" value=' + typeValue + ' //>')
            });
            _chooseQuestionType.append('<br/');
            $("" + objStr).attr('checked', true);
            chooseType(typeValue, answerValue);
        } else {
            $.each(questionObj, function (index, value) {
                _chooseQuestionType.append('<p><label for=' + value.id + '>' + (index + 1) + '.' + value.dictionaryName + '</label><input name="questionType" id=' + value.id + '  type="radio" value=' + value.dictionaryValue + ' //></p>')
            });
            $("input[name='questionType']:first").attr('checked', true);
        }
    });
}
function chooseType(questionValue, answerValue) {

    if (questionValue === "single-choice") {
        console.log("111");
        $("#answer").html("");
        ajaxMethod("json/answer.json", "", "get", function (data) {
            $.each(data, function (index, value) {
                $("#answer").append('<label for=' + value.id + '>' + value.id + '</label><input name="questionAnswer" id=' + value.id + ' ' +
                    'type="radio" value=' + value.id + ' //>')
            });
            if (answerValue.length > 0) {
                $("#" + answerValue).attr("checked", true);
            } else {
                $("input[name='questionAnswer']:first").attr('checked', true);
            }
        });
        //多选题
    } else if (questionValue === "multi-choice") {
        $("#answer").html("");
        ajaxMethod("json/multi-choiceAnswer.json", "", "get", function (data) {
            $.each(data, function (index, value) {
                $("#answer").append('<label for=' + value.id + '>' + value.id + '</label><input name="questionAnswer" id=' + value.id + ' ' +
                    'type="checkbox" value=' + value.id + ' //>');
            });
            if (answerValue.length > 0) {
                var str = answerValue.split(",");
                console.log(str);
                $.each(str, function (index, value) {
                    $("#" + value).attr("checked", true);
                });
            } else {
                $("input[name='questionAnswer']:first").attr('checked', true);
            }
        });
        //填空题
    } else if (questionValue === "fill-in-blank") {
        $("#answer").html("");
        $("#answer").append('<input id="fill-in-blank"  name="questionAnswer">');
        showTextbox("fill-in-blank", true);
        if (answerValue.length > 0) {
            $("#fill-in-blank").textbox("setValue", answerValue);
        }
        //判断题
    } else if (questionValue === "judgment") {
        $("#answer").html("");
        ajaxMethod("json/answer1.json", "", "get", function (data) {
            $.each(data, function (index, value) {
                $("#answer").append('<label for=' + value.dictionaryName + '>' + (index + 1) + '.' + value.dictionaryName + '</label><input name="questionAnswer" id=' + value.dictionaryName + ' ' +
                    'type="radio" value=' + value.dictionaryName + ' //>')
            });
            if (answerValue.length > 0) {
                $("#" + answerValue).attr("checked", true);
            } else {
                $("input[name='questionAnswer']:first").attr('checked', true);
            }
        });
        //编程题
    } else if (questionValue === "programing") {
        $("#answer").html("");
        $("#answer").append('<form id="programingForm" enctype="multipart/form-data"> <input name="questionAnswer" id="programing" style="padding-left: 160px"><a id="uploadFile">上传答案</a></form>');
        $("#programing").filebox({
            buttonText: '选择文件',
            buttonAlign: 'left'
        });
        $("#uploadFile").linkbutton();
        $("#uploadFile").click(function () {
            uploadFile("uploadFile");
        });
        if (answerValue.length > 0) {
            $("#_easyui_textbox_input5").val(answerValue);
        }
    } else {

    }
    console.log("answer = " + questionValue);
    $("input[name='questionAnswer']").val(answerValue);
}

