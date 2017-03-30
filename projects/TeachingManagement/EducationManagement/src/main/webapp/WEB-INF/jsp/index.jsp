<%--
  Created by IntelliJ IDEA.
  User: lws
  Date: 2017/3/30
  Time: 17:03
  教务管理首页
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    final String path = request.getContextPath();
    final String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>教务管理</title>
    <base href="<%=basePath%>">
</head>
<body>
<h2>教务管理</h2>
</body>
</html>
