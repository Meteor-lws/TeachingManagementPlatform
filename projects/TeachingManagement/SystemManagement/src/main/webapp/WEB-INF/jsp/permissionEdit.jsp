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
        权限名称 <input id="resourceName" class="easyui-textbox"  style="width: 120px;"/>
        权限编码 <input id="resourceValue" class="easyui-textbox"  style="width: 120px;"/>
        <a id="search"  class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">搜索</a>
    </div>
</div>
<div id="preDialog" class="easyui-dialog" title="权限修改"
     data-options="modal:true,closable:false,iconCls:'icon-save'"
     style="width:500px;height:450px;padding:10px;">
    <form id="preForm" method="post" >
        <table style="height:100%" width="100%">
            <tr>
                <input type="hidden" name="id" id="id">
                <td><label>权限名称</label></td>
                <td><input id="resourceNameForm" name="resourceName" class="easyui-textbox"/></td>
            </tr>
            <tr>
                <td><label>权限代码</label></td>
                <td><input id="resourceValueForm" name="resourceValue" class="easyui-textbox"/></td>
            </tr>
            <tr>
                <td>权限类型</td>
                <td>
                    <select id="resourceType" name="resourceType" class="easyui-combotree"
                            style="width:170px;"></select>
                </td>
            </tr>

            <tr>
                <td><label>权限状态</label></td>
                <td>
                    <input id="resourceEnableFrom" class="easyui-switchbutton" data-options="onText:'启用',offText:'不启用'">
                    <input id="resourceEnable" type="hidden" name="resourceEnable">
            </tr>

            <tr>
                <td><label>权限显示</label></td>
                <td>
                    <input id="resourceVisibleForm" class="easyui-switchbutton">
                    <input id="resourceVisible" type="hidden" name="resourceVisible">
            </tr>

            <tr>
                <td><label>权限描述</label></td>
                <td><input id="resourceDescribe" name="resourceDescribe" class="easyui-textbox"
                           data-options="multiline:true" value=""
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
