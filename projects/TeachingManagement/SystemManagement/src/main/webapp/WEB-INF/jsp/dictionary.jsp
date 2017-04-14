<%--
  Created by IntelliJ IDEA.
  User: lws
  Date: 2017/4/9
  Time: 1:43
  数据字典管理页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    final String path = request.getContextPath();
    final String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>数据字典</title>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="easyui/themes/default/easyui.css"/>
    <link rel="stylesheet" href="easyui/themes/icon.css"/>
    <script src="easyui/jquery.min.js"></script>
    <script src="easyui/jquery.easyui.min.js"></script>
    <script src="easyui/locale/easyui-lang-zh_CN.js"></script>
    <script src="js/dictionary.js"></script>
</head>
<body class="easyui-layout">
<div data-options="region:'west',split:true" style="width: 240px">
    <ul id="dictionary-type"></ul>
</div>
<div data-options="region:'center',split:true">
    <div id="dictionary-detail"></div>
    <div id="dictionary-tool" style="padding: 3px 0">
        <table>
            <tr>
                <td>
                    <a id="dictionary-type-add" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" style="width: 110px">添加字典类型</a>
                    <a id="dictionary-type-edit" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" style="width: 110px">修改字典类型</a>
                    <a id="dictionary-type-remove" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" style="width: 110px">删除字典类型</a>
                    <a id="dictionary-add" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" style="width: 80px">添加字典</a>
                    <a id="dictionary-edit" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" style="width: 80px">修改字典</a>
                    <a id="dictionary-remove" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" style="width: 80px">删除字典</a>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="dictionary-search-name" style="font-size: smaller">字典名称：</label><input id="dictionary-search-name" class="search" style="width:250px;height:26px"/>
                    <label for="dictionary-search-value" style="font-size: smaller">字典值：</label><input id="dictionary-search-value" class="search" style="width:250px;height:26px"/>
                    <label for="dictionary-search-describe" style="font-size: smaller">字典描述：</label><input id="dictionary-search-describe" class="search" style="width:250px;height:26px"/>
                </td>
            </tr>
        </table>
    </div>
    <div id="dictionary-type-dialog">
        <table align="center">
            <tr style="line-height:40px">
                <td align="right"><label for="dictionary-type-name">字典类型名称:</label></td>
                <td><input id="dictionary-type-name" type="text"></td>
            </tr>
            <tr>
                <td></td>
                <td><span id="dictionary-type-name-warning" style="font-size: 10px;color: red">&nbsp</span></td>
            </tr>
            <tr style="line-height:40px">
                <td align="right"><label for="dictionary-type-describe">字典类型描述:</label></td>
                <td><input id="dictionary-type-describe" type="text"></td>
            </tr>
            <tr>
                <td></td>
                <td><span id="dictionary-type-describe-warning" style="font-size: 10px;color: red">&nbsp</span></td>
            </tr>
            <tr style="line-height:40px">
                <td align="right"><label for="dictionary-type-sort">字典类型序号:</label></td>
                <td><input id="dictionary-type-sort" type="text"></td>
            </tr>
        </table>
    </div>
    <div id="dictionary-dialog">
        <table align="center">
            <tr style="line-height:40px">
                <td align="right"><label for="dictionary-name">字典名称:</label></td>
                <td><input id="dictionary-name" type="text"></td>
            </tr>
            <tr>
                <td></td>
                <td><span id="dictionary-name-warning" style="font-size: 10px;color: red">&nbsp</span></td>
            </tr>
            <tr style="line-height:40px">
                <td align="right"><label for="dictionary-value">字典值:</label></td>
                <td><input id="dictionary-value" type="text"></td>
            </tr>
            <tr>
                <td></td>
                <td><span id="dictionary-value-warning" style="font-size: 10px;color: red">&nbsp</span></td>
            </tr>
            <tr style="line-height:40px">
                <td align="right"><label for="dictionary-describe">字典描述:</label></td>
                <td><input id="dictionary-describe" type="text"></td>
            </tr>
            <tr>
                <td></td>
                <td><span style="font-size: 10px;color: red">&nbsp</span></td>
            </tr>
            <tr style="line-height:40px">
                <td align="right"><label for="dictionary-sort">字典序号:</label></td>
                <td><input id="dictionary-sort" type="text"></td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
