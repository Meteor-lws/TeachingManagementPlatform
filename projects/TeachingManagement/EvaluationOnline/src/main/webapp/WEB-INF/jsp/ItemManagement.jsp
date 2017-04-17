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
    <script src="js/ItemManagement.js"></script>
</head>
<body>
<div id="item-content" data-options="border:false"></div>
<div id="item-search-option">
    <div data-options="name:'content'">评价项</div>
    <div data-options="name:'enable'">是否启用</div>
    <div data-options="name:'type'">评价类型</div>
</div>
<div id="item-dialog" align="center">
    <table>
        <tr>
            <td colspan="2" align="center">
                <span id="evaluation-warning" style="font-size: smaller;color: red">&nbsp</span>
            </td>
        </tr>
        <tr>
            <td align="right" width="70px"><label for="evaluation-enable">是否启用:</label></td>
            <td><input id="evaluation-enable" class="easyui-switchbutton" checked></td>
        </tr>
        <tr>
            <td align="right"><label for="evaluation-type">评价类型:</label></td>
            <td>
                <select id="evaluation-type" style="width: 140px"></select>
            </td>
        </tr>
        <tr>
            <td align="right" style="vertical-align: top"><label for="evaluation-content">评价项:</label></td>
            <td>
                <input id="evaluation-content" class="easyui-textbox" data-options="multiline:true" style="width: 140px;height: 70px">
            </td>
        </tr>
    </table>
</div>
</body>
</html>
