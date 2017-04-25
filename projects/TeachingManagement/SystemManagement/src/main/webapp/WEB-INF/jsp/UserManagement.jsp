<%--
  Created by IntelliJ IDEA.
  User: lws
  Date: 2017/4/25
  Time: 16:36
  用户管理页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    final String path = request.getContextPath();
    final String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>用户管理</title>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="easyui/themes/default/easyui.css"/>
    <link rel="stylesheet" href="easyui/themes/icon.css"/>
    <script src="easyui/jquery.min.js"></script>
    <script src="easyui/jquery.easyui.min.js"></script>
    <script src="easyui/locale/easyui-lang-zh_CN.js"></script>
    <script src="js/UserManagement.js"></script>
</head>
<body>
<div id="user-data"></div>
<div id="user-tool" style="font-size: 8px">
    <label for="user-search-type" style="padding-left: 15px">用户类型：</label>
    <select id="user-search-type" style="width: 90px;height: 22px"></select>
    <label for="user-search-status" style="padding-left: 15px">用户状态：</label>
    <select id="user-search-status" style="width: 90px;height: 22px"></select>
    <label style="padding-left: 15px">用户名：
        <input id="user-search-name" class="user-search">
    </label>
    <label style="padding-left: 15px">用户编号：
        <input id="user-search-number" class="user-search">
    </label>
    <a id="user-edit-status" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'">修改用户状态</a>
    <a id="user-edit-password" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'">修改用户密码</a>
</div>
</body>
</html>
