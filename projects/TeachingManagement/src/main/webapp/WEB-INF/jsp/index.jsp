<%--
  Created by IntelliJ IDEA.
  User: lws
  Date: 2017/3/30
  Time: 16:38
  教学管理平台首页
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    final String path = request.getContextPath();
    final String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>教学管理平台</title>
    <base href="<%=basePath%>">
</head>
<body>
<h2>教学管理平台</h2>
<h3><a href="background">后台管理侧</a></h3>
<h3><a href="front">用户侧</a></h3>
</body>
</html>
