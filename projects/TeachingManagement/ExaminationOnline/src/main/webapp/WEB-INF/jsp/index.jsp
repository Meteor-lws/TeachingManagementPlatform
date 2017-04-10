<%--
  Created by IntelliJ IDEA.
  User: lws
  Date: 2017/3/30
  Time: 16:58
  在线考试首页
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    final String path = request.getContextPath();
    final String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>在线考试</title>
    <base href="<%=basePath%>">
</head>
<body>
<h2>在线考试</h2>
<a href="mybatistest">ss</a>
</body>
</html>
