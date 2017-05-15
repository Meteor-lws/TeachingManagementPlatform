<%--
  Created by IntelliJ IDEA.
  User: XuMing
  Date: 2017/4/4
  Time: 21:40
  权限管理页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    final String path = request.getContextPath();
    final String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>权限管理</title>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="easyui/themes/default/easyui.css">
    <link rel="stylesheet" href="easyui/themes/icon.css">
    <script src="easyui/jquery.min.js"></script>
    <script src="easyui/jquery.easyui.min.js"></script>
    <script src="easyui/locale/easyui-lang-zh_CN.js"></script>
    <script src="js/permission.js"></script>
</head>
<body>
<table id="preDg" style="width:100%;height:100%"></table>
<div id="preTb">
    <a id="addPre" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,width:60">添加</a>
    <a id="editPre" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true,width:60">修改</a>
    <a id="removePre" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true,width:60">删除</a>
    权限名称 <input id="resourceName" class="easyui-textbox" style="width: 120px;"/>
    权限编码 <input id="resourceValue" class="easyui-textbox" style="width: 120px;"/>
    <a id="search" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">搜索</a>
</div>
<div id="preDialog" class="easyui-dialog" title="权限修改"
     data-options="modal:true,closable:false,iconCls:'icon-save'"
     style="padding:10px;">
    <form id="preForm" method="post" >
        <table style="height:100%" width="100%">
            <tr>
                <input type="hidden" name="id" id="id">
                <td style="width: 76px"><label>权限名称</label></td>
                <td colspan="3"><input id="resourceNameForm" name="resourceName" class="easyui-textbox"
                                       data-options="width:240"></td>
            </tr>
            <tr>
                <td><label>权限代码</label></td>
                <td colspan="3"><input id="resourceValueForm" name="resourceValue" class="easyui-textbox"
                                       data-options="width:240"></td>
            </tr>
            <tr>
                <td>权限类型</td>
                <td colspan="3"><select id="resourceType" name="resourceType" class="easyui-combotree"
                                        style="width:240px"></select></td>
            </tr>
            <tr>
                <td><label>权限状态</label></td>
                <td>
                    <input id="resourceEnableFrom" class="easyui-switchbutton" data-options="onText:'启用',offText:'不启用'">
                    <input id="resourceEnable" type="hidden" name="resourceEnable">
                </td>
                <td><label>权限显示</label></td>
                <td>
                    <input id="resourceVisibleForm" class="easyui-switchbutton">
                    <input id="resourceVisible" type="hidden" name="resourceVisible">
                </td>
            </tr>
            <tr>
                <td><label>权限描述</label></td>
                <td colspan="3"><input id="resourceDescribe" name="resourceDescribe" class="easyui-textbox"
                                       data-options="multiline:true" value="" style="width:240px;height:120px"></td>
            </tr>
            <tr align="center">
                <td colspan="2"></td>
                <td><a class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="submitForm()">保存</a></td>
                <td><a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="cancel()">取消</a></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
