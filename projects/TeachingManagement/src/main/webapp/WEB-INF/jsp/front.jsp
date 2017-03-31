<%--
  Created by IntelliJ IDEA.
  User: lws
  Date: 2017/3/30
  Time: 19:13
  用户侧首页
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    final String path = request.getContextPath();
    final String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>用户侧</title>
    <base href="<%=basePath%>">
</head>
<body>
<h2>用户侧</h2>
</body>
</html>
