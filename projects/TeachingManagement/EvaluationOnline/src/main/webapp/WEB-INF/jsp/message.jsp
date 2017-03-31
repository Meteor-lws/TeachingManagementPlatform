<%--
  Created by IntelliJ IDEA.
  User: lws
  Date: 2017/3/31
  Time: 16:03
  留言审核页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    final String path = request.getContextPath();
    final String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>留言审核</title>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="easyui/themes/default/easyui.css"/>
    <link rel="stylesheet" href="easyui/themes/icon.css"/>
    <script src="easyui/jquery.min.js"></script>
    <script src="easyui/jquery.easyui.min.js"></script>
    <script src="easyui/locale/easyui-lang-zh_CN.js"></script>
    <script src="js/util.js"></script>
    <script src="js/message.js"></script>
</head>
<body>
<div id="message-content" data-options="border:false"></div>
<div id="message-search-option">
    <div data-options="name:'content'">留言内容</div>
    <div data-options="name:'from'">留言人</div>
    <div data-options="name:'to'">留言对象</div>
    <div data-options="name:'time'">留言时间</div>
</div>
</body>
</html>
