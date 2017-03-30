<%--
  Created by IntelliJ IDEA.
  User: lws
  Date: 2017/3/27
  Time: 11:19
  评价项管理页面
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
    <script src="js/evaluation.js"></script>
</head>
<body>
<table id="evaluation-data" data-options="border:false,fit:true"></table>
<div id="evaluation-search-option">
    <div data-options="name:'content'">评价项</div>
    <div data-options="name:'enable'">是否启用</div>
    <div data-options="name:'type'">评价类型</div>
</div>
<table id="evaluation-dialog" align="center">
    <tr>
        <td colspan="2" align="center">
            <span id="evaluation-warning" style="font-size: smaller;color: red">&nbsp</span>
        </td>
    </tr>
    <tr>
        <td align="right">是否启用:</td>
        <td><input id="evaluation-enable" class="easyui-switchbutton" checked></td>
    </tr>
    <tr>
        <td align="right">评价类型:</td>
        <td>
            <select id="evaluation-type" style="width: 140px"></select>
        </td>
    </tr>
    <tr>
        <td align="right" style="vertical-align: top">评价项:</td>
        <td>
            <input id="evaluation-content" class="easyui-textbox" data-options="multiline:true"
                   style="width: 140px;height: 70px">
        </td>
    </tr>
</table>
</body>
</html>
