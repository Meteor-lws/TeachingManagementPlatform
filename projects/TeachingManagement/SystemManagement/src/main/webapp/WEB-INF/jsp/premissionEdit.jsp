<%--
  Created by IntelliJ IDEA.
  User: XuMing
  Date: 2017/4/4
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css"
          href="easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css"
          href="easyui/themes/icon.css">
    <!--引入Jquery主文件-->
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <!--引入JqueryEasyUI主文件-->
    <script type="text/javascript"
            src="easyui/jquery.easyui.min.js"></script>
    <!--让easyUI支持中文-->
    <script type="text/javascript"
            src="easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/premissionEdit.js"></script>
</head>
<body>
<table id="preDg" style="width:100%;height:100%"></table>
<div id="preTb" align="center" style="height:60px">
    <div align="left">
        <a id="addPre" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
        <a id="editPre" href="javascript:void(0)" class="easyui-linkbutton"
           data-options="iconCls:'icon-edit',plain:true">修改</a>
        <a id="removePre" href="javascript:void(0)" class="easyui-linkbutton"
           data-options="iconCls:'icon-remove',plain:true">删除</a>
    </div>
    <div align="left" style="margin-top:5px">
        角色名称 <select id="preNameSel" class="easyui-combotree" style="width:120px;"></select>
        角色编码 <input id="precode" class="easyui-validatebox" name="stuName" style="width: 120px;"/>
        <a id="search" href="" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">搜索</a>
    </div>
</div>
<div id="preDialog" class="easyui-dialog" title="权限修改"
     data-options="modal:true,closed:true,iconCls:'icon-save'"
     style="width:500px;height:300px;padding:10px;">
    <form id="ff" method="post" action="/asa">
        <table style="height:100%" width="100%">
            <tr>
                <td><label>权限名称</label></td>
                <td><input id="preName" class="easyui-validatebox"/></td>
            </tr>
            <tr>
                <td><label>权限URL</label></td>
                <td><input id="preUrl" class="easyui-validatebox"/></td>
            </tr>
            <tr>
                <td><label>权限描述</label></td>
                <td><input id="preDes" class="easyui-textbox" data-options="multiline:true" value=""
                           style="width:300px;height:100px"></td>
            </tr>
            <tr align="center">
                <td><a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add'"
                       onclick="submitForm()">保存</a></td>
                <td><a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'"
                       onclick="cancel()">取消</a></td>
            </tr>
        </table>
    </form>
</div>


</body>
</html>
