/**
 * Created by 朱高 on 2017/3/28.
 */
$.fn.combobox.defaults.filter = function(q, row){
    var opts = $(this).combobox('options');
    return row[opts.textField].indexOf(q) >= 0;
};
$(function () {
    var _table = $("#table");
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
            var questionObj = null;
            dialogOption("chooseQuestionType", "选择考试题目类型", function () {
                var _chooseQuestionType = $("input[name='questionType']:checked");
                var questionValue = _chooseQuestionType.val();
                $("#chooseQuestionType").dialog("close");
                init();
                //单选题
                if(questionValue === "single-choice"){
                    $("#answer").html("");
                    ajaxMethod("json/answer.json", "", "get", function (data) {
                        $.each(data, function (index, value) {
                            $("#answer").append('<label for='+ value.id +'>' + value.id +'</label><input name="single-choice" id='+ value.id +' ' +
                               'type="radio" value='+ value.id + ' //>')
                        });
                        $("input[name='single-choice']:first").attr('checked',true);
                    });
                    //多选题
                }else if(questionValue === "multi-choice"){
                    $("#answer").html("");
                    ajaxMethod("json/multi-choiceAnswer.json", "", "get", function (data) {
                        $.each(data, function (index, value) {
                            $("#answer").append('<label for='+ value.id +'>' + value.id +'</label><input name="multi-choice" id='+ value.id +' ' +
                                'type="checkbox" value='+ value.id + ' //>');
                        });
                        $("input[name='multi-choice']:first").attr('checked',true);
                    });
                    //填空题
                }else if(questionValue === "fill-in-blank"){
                    $("#answer").html("");
                    $("#answer").append('<input id="fill-in-blank">');
                    $("#fill-in-blank").show();
                    showTextbox("fill-in-blank", true);
                    //判断题
                }else if(questionValue === "judgment"){
                    $("#answer").html("");
                    ajaxMethod("json/answer1.json", "", "get", function (data) {
                        $.each(data, function (index, value) {
                            $("#answer").append('<label for='+ value.id +'>'+ (index+1) + '.' + value.dictionaryName +'</label><input name="single-choice" id='+ value.id +' ' +
                                'type="radio" value='+ value.id + ' //>')
                        });
                    });
                    //编程题
                }else if(questionValue === "programing"){
                    $("#answer").html("");
                    $("#answer").append('<form id="programingForm" enctype="multipart/form-data"> <input name="myfiles" id="programing"><a id="uploadFile">上传答案</a></form>');
                    $("#programing").filebox({
                        buttonText: '选择文件',
                        buttonAlign: 'left'
                    });
                    $("#uploadFile").linkbutton();
                    $("#uploadFile").click(function () {
                        uploadFile("uploadFile");
                    });
                }else{

                }
                dialogOption("addQuestion", "添加试题信息", function () {

                }, function () {
                    clearDialog();
                }, function () {
                    clearDialog();
                });
                showCombobox("classType", "findDicTypeName", true, "examination-subject");
                showCombobox("questionStage", "findDicTypeName", true, "examination-stage");
                showTextbox("questionScores", true);
            }, function () {
                
            }, function () {
                
            });
            //选择考试题目的类型
            ajaxMethod("findDicTypeName", {dicTypeName : "question_type"}, "post", function (data1) {
                questionObj = $.parseJSON(data1);
                var _chooseQuestionType = $("#chooseQuestionType");
                _chooseQuestionType.html('');
                $.each(questionObj, function (index, value) {
                    _chooseQuestionType.append('<p><label for='+ value.id +'>'+ (index+1) + '.' + value.dictionaryName +'</label><input name="questionType" id='+ value.dictionaryValue +' type="radio" value='+ value.dictionaryValue + ' //></p>')
                })
            });
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

    /*
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
     if (record.id === 1) {
     $("#answer_div").show();
     $("#answer1_div").hide();
     $("#answer2_div").hide();
     answerSelect("json/answer.json");
     } else if (record.id === 2) {
     $("#answer_div").show();
     $("#answer1_div").hide();
     $("#answer2_div").hide();
     answerSelect("json/answer1.json");
     } else if (record.id === 3) {
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
     */
});
function showQuery() {
    showCombobox("questionSubjectName", "findDicTypeName", false, "examination-subject");
    showCombobox("questionTypeName", "findDicTypeName", false, "question_type");
    showCombobox("questionStageName", "findDicTypeName", false, "examination-stage");
    showTextbox("questionSelections", false);
}
function showComboboxMulti(id, url, flag, dicTypeName) {
    $("#" + id).combobox({
        url : url,
        required : flag,
        valueField : 'id',//传递的值
        textField : "dictionaryName",//显示的值
        multiple : true,
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
        required: flag
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
    clearComboboxValue("classType");
    clearComboboxValue("questionStage");
    clearTextboboxValue("questionScores");
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
                })
                $("#_easyui_textbox_input5").val(obj.fileUrl);
                console.log($("#_easyui_textbox_input5").val());
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
