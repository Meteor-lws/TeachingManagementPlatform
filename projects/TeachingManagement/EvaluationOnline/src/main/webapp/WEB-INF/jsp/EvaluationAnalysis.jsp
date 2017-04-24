<%--
  Created by IntelliJ IDEA.
  User: lws
  Date: 2017/3/31
  Time: 16:04
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
    <script src="js/EvaluationAnalysis.js"></script>
</head>
<body class="easyui-layout" style="background: #E0ECFF">
<div data-options="region:'north'" style="height: 70%">
    <div id="analysis-result"></div>
</div>
<div data-options="region:'south'" style="height: 28%">
    <div id="analysis-detail"></div>
</div>
<div id="analysis-tool" style="padding: 5px">
    <label for="analysis-search-class" style="padding-left: 10px">班级：</label>
    <input id="analysis-search-class" class="analysis-search" type="text">
    <label for="analysis-search-teacher" style="padding-left: 15px">教师：</label>
    <input id="analysis-search-teacher" class="analysis-search" type="text">
    <label for="analysis-search-student" style="padding-left: 15px">学生：</label>
    <input id="analysis-search-student" class="analysis-search" type="text">
</div>
</body>
</html>
