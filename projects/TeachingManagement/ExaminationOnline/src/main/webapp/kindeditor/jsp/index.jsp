<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basePath%>"/>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="../../easyui/themes/default/easyui.css"/>
        <link rel="stylesheet" type="text/css" href="../../easyui/themes/icon.css"/>
        <link rel="stylesheet" type="text/css" href="../../css/login.css"/>
        <title>Title</title>
    </head>
<body>
<div id="login">
    <p>管理员账号: <input type="text" id="manager" class="textbox"></p>
    <p>管理员密码: <input type="password" id="password" class="textbox"></p>
    <a href="#" class="easyui-linkbutton">登陆</a>
</div>
<script type="text/javascript" src="../../easyui/jquery.min.js"></script>
<script type="text/javascript" src="../../easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../../easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../../js/index.js"></script>
</body>
</html>