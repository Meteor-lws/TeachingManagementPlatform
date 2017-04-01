<%--
  Created by IntelliJ IDEA.
  User: 朱高
  Date: 2017/3/21
  Time: 10:59
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
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css"/>
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="js/online_test.js"></script>
</head>
<body>

<table id="table">

</table>
<div id="manager_tool" style="padding:5px;">
    <div style="margin-bottom:5px;">
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="manager_tool.add();">添加</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="manager_tool.edit();">修改</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="manager_tool.remove();">删除</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true" id="save" onclick="obj.save();">保存</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-redo" plain="true" id="redo" onclick="obj.redo();">取消编辑</a>
    </div>
    <div style="padding:0 0 0 7px;color:#333;">
        查询班级：<input id="condition_Name" type="text" class="textbox" name="user" style="width:130px">
        创建时间从：<input id="condition_date_from" type="text" name="date_from" class="easyui-datebox" editable="false"
                     style="width:110px">
        到：<input type="text" id="condition_date_to" name="date_to" class="easyui-datebox" editable="false"
                 style="width:110px">
        <a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="manager_tool.search();">查询</a>
    </div>
</div>

<form id="manager_add" class="easyui-dialog" data-options="closed : true,modal:true"
      style="margin:0;padding:5px 0 0 25px;color:#333;">
    <p>考试班级：<input id="className" name="className" editable="false" style="width:125px;"></p>
    <p>考试阶段：<input id="testPhase" name="testPhase" class="textbox" editable="false" style="width:125px;"></p>
    <p>考试时间：<input name="testTime" class="easyui-datebox" editable="false" required="required" style="width:125px;"></p>
    <p>监考老师：<input id="invigilator" name="invigilator" editable="false" style="width:125px;"></p>
    <p>考试地点：<input id="testPlace" name="testPlace" editable="false" style="width:125px;"></p>
</form>

<%--<form id="manager_edit" style="margin:0;padding:5px 0 0 25px;color:#333;">
    <p>考试班级：<input  name="className" editable="false" style="width:125px;"></p>
    <p>考试阶段：<input  name="testPhase" class="textbox" editable="false" style="width:125px;"></p>
    <p>考试时间：<input  name="testTime" class="easyui-datebox" editable="false" required="required" style="width:125px;"></p>
    <p>监考老师：<input  name="invigilator" editable="false" style="width:125px;"></p>
    <p>考试地点：<input  name="testPlace" editable="false" style="width:125px;"></p>
</form>--%>
</body>
</html>
