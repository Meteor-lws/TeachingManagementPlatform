<%--
  Created by IntelliJ IDEA.
  User: lws
  Date: 2017/3/27
  Time: 11:20
  评价分析页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    final String path = request.getContextPath();
    final String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>评价分析</title>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="easyui/themes/default/easyui.css"/>
    <link rel="stylesheet" href="easyui/themes/icon.css"/>
    <script src="easyui/jquery.min.js"></script>
    <script src="easyui/jquery.easyui.min.js"></script>
    <script src="easyui/locale/easyui-lang-zh_CN.js"></script>
    <script src="js/util.js"></script>
    <script src="js/analysis.js"></script>
</head>
<body class="easyui-layout" style="background: #E0ECFF">
<div data-options="region:'north'" style="height: 64%">
    <div id="analysis-data1" data-options="fit:true,border:false"></div>
</div>
<div data-options="region:'south'" style="height: 34%">
    <div id="analysis-data2" data-options="fit:true,border:false"></div>
</div>
<div id="analysis-search-option">
    <div data-options="name:'teacher'">教师</div>
    <div data-options="name:'class'">班级</div>
    <div data-options="name:'student'">学生</div>
</div>
</body>
</html>
