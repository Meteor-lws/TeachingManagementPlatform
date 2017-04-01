<%--
  Created by IntelliJ IDEA.
  User: 朱高
  Date: 2017/3/17
  Time: 14:29
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
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="../../easyui/themes/default/easyui.css"/>
        <link rel="stylesheet" type="text/css" href="../../easyui/themes/icon.css"/>
        <link rel="stylesheet" type="text/css" href="../../css/admin.css"/>
        <title>Title</title>
    </head>
<body>
<table id="table">

</table>
<div id="manager_tool" style="padding:5px;">
    <div style="margin-bottom:5px;">
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="manager_tool.add();">添加</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="manager_tool.edit();">修改</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="obj.remove();">删除</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true" id="save" onclick="obj.save();">保存</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-redo" plain="true" id="redo" onclick="obj.redo();">取消编辑</a>
    </div>
    <div style="padding:0 0 0 7px;color:#333;">
        查询帐号：<input type="text" class="textbox" name="user" style="width:110px">
        创建时间从：<input type="text" name="date_from" class="easyui-datebox" editable="false" style="width:110px">
        到：<input type="text" name="date_to" class="easyui-datebox" editable="false" style="width:110px">
        <a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="obj.search();">查询</a>
    </div>
</div>
<form id="manager_add" style="margin:0;padding:5px 0 0 25px;color:#333;">
    <p>管理帐号：<input type="text" name="manager" class="textbox" style="width:200px;"></p>
    <p>管理密码：<input type="password" name="password" class="textbox" style="width:200px;"></p>
    <p>分配权限：<input id="auth" class="textbox" name="auth" style="width:205px;"></p>
</form>

<form id="manager_edit" style="margin:0;padding:5px 0 0 25px;color:#333;">
    <input type="hidden" name="id" class="textbox" style="width:200px;">
    <p>管理帐号：<input type="text" name="manager" class="textbox" style="width:200px;"></p>
    <p>管理密码：<input type="password" name="password" class="textbox" style="width:200px;"></p>
    <p>分配权限：<input id="auth_edit" class="textbox" name="auth" style="width:205px;"></p>
</form>
<script type="text/javascript" src="../../easyui/jquery.min.js"></script>
<script type="text/javascript" src="../../easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../../easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../../js/manager.js"></script>
</body>
</html>