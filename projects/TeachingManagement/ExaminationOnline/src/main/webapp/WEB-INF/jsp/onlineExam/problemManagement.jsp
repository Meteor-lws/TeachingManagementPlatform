<%--
  Created by IntelliJ IDEA.
  User: 朱高
  Date: 2017/3/28
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basePath%>"/>
    <link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css"/>
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="js/problemManagement.js"></script>
    <script type="text/javascript" src="js/ajaxfileupload.js"></script>
    <script charset="utf-8" src="kindeditor/kindeditor.js"></script>
    <script charset="utf-8" src="kindeditor/lang/zh_CN.js"></script>
    <script>
        var editor;
        KindEditor.ready(function (K) {
            editor = K.create('div[name="text"]', {
                allowFileManage: true,
                uploadJson: 'kindeditor/jsp/upload_json.jsp',
                fileManagerJson: 'kindeditor/jsp/file_manager_json.jsp',
                afterBlur: function () {
                    this.sync();
                    K.ctrl(document, 13, function () {
                        K('form[name="myForm"]')[0].submit();
                    });
                    K.ctrl(this.edit.doc, 13, function () {
                        K('form[name="myForm"]')[0].submit();
                    });
                }
            });
        });
    </script>
    <title>Title</title>
</head>
<body>
<table id="table"></table>
<div id="manager_tool" style="padding:5px;">
    <div style="margin-bottom:5px;">
        <a class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="manager_tool.add();">添加</a>
        <a class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="manager_tool.edit();">修改</a>
        <a class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="manager_tool.remove();">删除</a>
        <a class="easyui-linkbutton" iconCls="icon-search" onclick="manager_tool.search();">查询</a>
        <a class="easyui-linkbutton" iconCls="icon-reload" onclick="manager_tool.clear();">重置查询条件</a>
    </div>
    <div style="padding:0 0 0 7px;color:#333;">
        <label for="questionSubjectName">题目使用班级类型：</label><input id="questionSubjectName" type="text" class="textbox" style="width:130px">
        <label for="questionTypeName">试题类型：</label><input id="questionTypeName" type="text" style="width:130px">
        <label for="questionStageName">查询阶段：</label><input id="questionStageName" type="text" style="width:130px">
        <label for="questionSelections">使用次数：</label><input id="questionSelections" type="text" style="width:110px">
    </div>
</div>
<div>
    <div id="chooseQuestionType" align="center" style="vertical-align: middle"></div>
    <form id="addQuestion" name="myForm" style="margin:0;padding:5px 0 0 25px;color:#333;">
        <%--<label for="classType">班级类型：</label><input id="classType" editable="false" style="width:125px;">
        <label for="questionStage">适用阶段：</label><input id="questionStage" class="textbox" editable="false" style="width:125px;">
        <label for="questionScores">题目分数：</label><input id="questionScores" class="textbox" style="width: 100px;"/>
        <label >题目答案：<span id="answer"></span></label>--%>
        <%--<div id="judgment"></div>
        <input type="hidden" name="proposer" editable="false" value="徐明" style="width:125px;">
        <input type="hidden" name="usageCount" editable="false" value="0" style="width:125px;">--%>
        <div name="text" >

        </div>
    </form>

</div>
</body>
</html>
