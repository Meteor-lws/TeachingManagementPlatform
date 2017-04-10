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
<div data-options="region:'west',split:true,border:false" style="width: 280px">
    <ul id="dictionary"></ul>
</div>
<div data-options="region:'center',split:true">
    <div class="easyui-layout" style="height: 100%;background: #E0ECFF">
        <div data-options="region:'north',border:false" style="height: 63%">
            <div id="dictionary-dialog" style="width: 100%;height: 100%">
                <table align="center" style="padding-top: 80px">
                    <tr>
                        <td><input id="dictionary-parent" type="text"></td>
                        <td width="50px" id="parent-clear"></td>
                        <td><input id="dictionary-sort" type="text"></td>
                    </tr>
                    <tr>
                        <td><input id="dictionary-name" type="text"></td>
                        <td width="50px"></td>
                        <td><input id="dictionary-value" type="text"></td>
                    </tr>
                    <tr>
                        <td colspan="3"><input id="dictionary-describe" type="text"></td>
                    </tr>
                </table>
            </div>
        </div>
        <div id="dictionary-tool" style="padding:6px 0">
            <table>
                <tr>
                    <td>
                        <a id="dictionary-add" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" style="width: 65px">添加</a>
                        <a id="dictionary-edit" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" style="width: 65px">修改</a>
                        <a id="dictionary-remove" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" style="width: 65px">删除</a>
                        <label for="dictionary-search-name" style="font-size: smaller">字典名称：</label><input id="dictionary-search-name" class="search" style="width:250px;height:26px"/>
                        <label for="dictionary-search-value" style="font-size: smaller">字典值：</label><input id="dictionary-search-value" class="search" style="width:250px;height:26px"/>
                        <label for="dictionary-search-describe" style="font-size: smaller">字典描述：</label><input id="dictionary-search-describe" class="search" style="width:250px;height:26px"/>
                    </td>
                </tr>
            </table>
        </div>
        <div data-options="region:'south',border:false" style="height: 35%">
            <input id="dictionary-detail" type="text" style="width: 100%;height: 100%">
        </div>
    </div>
</div>
</body>
</html>
