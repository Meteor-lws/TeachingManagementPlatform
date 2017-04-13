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
        <a class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="manager_tool.add();">添加</a>
        <a class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="manager_tool.edit();">修改</a>
        <a class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="manager_tool.remove();">删除</a>
        <a class="easyui-linkbutton" iconCls="icon-save" plain="true" id="save">保存</a>
        <a class="easyui-linkbutton" iconCls="icon-redo" plain="true" id="redo">取消编辑</a>
    </div>
    <div style="padding:0 0 0 7px;color:#333;">
        <label for="condition_Name">查询班级：</label><input id="condition_Name" type="text" class="textbox" name="user"
                                                        style="width:130px">
        <label for="condition_date_from">创建时间从：</label><input id="condition_date_from" type="text" name="date_from"
                                                              class="easyui-datebox" editable="false"
                                                              style="width:110px">
        <label for="condition_date_to">到：</label><input type="text" id="condition_date_to" name="date_to"
                                                        class="easyui-datebox" editable="false" style="width:110px">
        <a class="easyui-linkbutton" iconCls="icon-search" onclick="manager_tool.search();">查询</a>
    </div>
</div>

<form id="manager_add" class="easyui-dialog" data-options="closed : true,modal:true"
      style="margin:0;padding:5px 0 0 25px;color:#333;">
    <p><label for="className">考试班级：</label><input id="className" name="className" editable="false" style="width:125px;">
    </p>
    <p><label for="testPhase">考试阶段：</label><input id="testPhase" name="testPhase" class="textbox" editable="false"
                                                  style="width:125px;"></p>
    <p><label for="testTime">考试时间：</label><input id="testTime" name="testTime" class="easyui-datetimebox" editable="false"
                                                 required="required" style="width:125px;"></p>
    <p><label for="invigilator">监考老师：</label><input id="invigilator" name="invigilator"
                                                    style="width:125px;"></p>
    <p><label for="testPlace">考试地点：</label><input id="testPlace" name="testPlace" style="width:125px;">
    </p>
</form>
</body>
</html>
