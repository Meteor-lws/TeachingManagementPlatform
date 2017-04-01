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
    <script type="text/javascript" src="js/problem_management.js"></script>
    <script charset="utf-8" src="kindeditor/kindeditor.js"></script>
    <script charset="utf-8" src="kindeditor/lang/zh_CN.js"></script>
    <script>
        var editor;
        KindEditor.ready(function (K) {
            editor = K.create('textarea[name="questionContent"]', {
                allowFileManage: true,
                uploadJson: 'kindeditor/jsp/upload_json.jsp',
                fileManagerJson: 'kindeditor/jsp/file_manager_json.jsp',
                afterBlur: function () {
                    this.sync();
                    K.ctrl(document, 13, function () {
                        K('form[name="myform"]')[0].submit();
                    });
                    K.ctrl(this.edit.doc, 13, function () {
                        K('form[name="myform"]')[0].submit();
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
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="manager_tool.add();">添加</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="manager_tool.edit();">修改</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="manager_tool.remove();">删除</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true" id="save" onclick="obj.save();">保存</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-redo" plain="true" id="redo" onclick="obj.redo();">取消编辑</a>
    </div>
    <div style="padding:0 0 0 7px;color:#333;">
        查询题目类型：<input id="questionType" type="text" class="textbox" style="width:130px">
        查询出题人：<input id="proposer" type="text" class="textbox" style="width:130px">
        查询阶段：<input id="phase" type="text" class="textbox" style="width:130px">
        出题时间从：<input id="condition_date_from" type="text" name="date_from" class="easyui-datebox" editable="false"
                     style="width:110px">
        到：<input type="text" id="condition_date_to" name="date_to" class="easyui-datebox" editable="false"
                 style="width:110px">
        <a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="manager_tool.search();">查询</a>
    </div>
</div>
<form id="addQuestion" style="margin:0;padding:5px 0 0 25px;color:#333;">
    试题类型：<input name="questionType" editable="false" style="width:125px;">
    适用阶段：<input name="phase" class="textbox" editable="false" style="width:125px;">
    出题时间：<input name="questionTime" class="easyui-datebox" editable="false" required="required" style="width:125px;">
    <div id="answer_div">标准答案：<input id="answer" name="answer" type="text" style="width:125px;"></div>
    <div id="answer1_div" style="display:none;">标准答案：<input id="answer1" name="answer" style="width:125px;"></div>
    <div id="answer2_div" style="display:none;">标准答案：<input id="answer2" name="answer" class="easyui-filebox"
                                                            style="width:180px;"></div>
    <textarea id="content" name="questionContent" rows="" cols=""
              style="width: 800px; height: 400px; visibility: hidden;"></textarea>
    <input type="hidden" name="proposer" editable="false" value="徐明" style="width:125px;">
    <input type="hidden" name="usageCount" editable="false" value="0" style="width:125px;">
</form>
</body>
</html>
