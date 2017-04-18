<%--
  Created by IntelliJ IDEA.
  User: lws
  Date: 2017/3/30
  Time: 16:55
  评价项管理首页
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    final String path = request.getContextPath();
    final String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>评价项管理</title>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="easyui/themes/default/easyui.css"/>
    <link rel="stylesheet" href="easyui/themes/icon.css"/>
    <script src="easyui/jquery.min.js"></script>
    <script src="easyui/jquery.easyui.min.js"></script>
    <script src="easyui/locale/easyui-lang-zh_CN.js"></script>
    <script src="js/util.js"></script>
    <script src="js/item.js"></script>
</head>
<body>
<div id="item-data"></div>
<div id="item-tool" style="padding: 3px 0">
    <table>
        <tr>
            <td>
                <a id="item-add" class="easyui-linkbutton"
                   data-options="width:95,plain:true,iconCls:'icon-add'">添加评价项</a>
                <a id="item-edit" class="easyui-linkbutton"
                   data-options="width:95,plain:true,iconCls:'icon-edit'">修改评价项</a>
                <a id="item-remove" class="easyui-linkbutton" data-options="width:95,plain:true,iconCls:'icon-remove'">删除评价项</a>
            </td>
        </tr>
        <tr>
            <td>
                <label for="item-search-content" style="font-size: smaller">评价项内容：</label>
                <input id="item-search-content" class="easyui-searchbox" data-options="prompt:'请输入搜索内容'"
                       style="width:250px">
            </td>
            <td>
                <label for="item-search-type" style="font-size: smaller;margin-left: 20px">评价项类型：</label>
                <input id="item-search-type" class="easyui-searchbox" data-options="prompt:'请输入搜索内容'"
                       style="width:250px">
            </td>
            <td>
                <label for="item-search-enable" style="font-size: smaller;margin-left: 20px">是否启用：</label>
                <input id="item-search-enable" class="easyui-searchbox" data-options="prompt:'请输入搜索内容'"
                       style="width:250px">
            </td>
        </tr>
    </table>
</div>
<div id="item-dialog">
    <table align="center" style="margin-top: 10px">
        <tr>
            <td align="right">
                <label for="item-type">评价项类型：</label>
            </td>
            <td>
                <select id="item-type" style="width: 180px;height: 30px"></select>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <span id="item-type-warning" style="font-size: smaller;color: red">&nbsp</span>
            </td>
        </tr>
        <tr>
            <td align="right" style="vertical-align: top">
                <label for="item-content">评价项内容：</label>
            </td>
            <td>
                <input id="item-content" data-options="multiline:true" style="width: 180px;height: 80px">
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <span id="item-content-warning" style="font-size: smaller;color: red">&nbsp</span>
            </td>
        </tr>
        <tr>
            <td align="right">是否启用：</td>
            <td>
                <label>
                    <input name="item-enable" type="radio" value="true" checked>
                    是
                </label>
                <label>
                    <input name="item-enable" type="radio" value="false">
                    否
                </label>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
