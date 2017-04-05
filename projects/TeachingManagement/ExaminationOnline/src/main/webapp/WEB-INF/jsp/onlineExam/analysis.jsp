<%--
  Created by IntelliJ IDEA.
  User: 朱高
  Date: 2017/3/23
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
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
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css"/>
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="js/echarts.min.js"></script>
    <script type="text/javascript" src="js/ajaxEcharts.js"></script>
</head>
<body>
<div id="manager_tool" style="padding:5px;">
    <div style="padding:0 0 0 7px;color:#333;">
        <label for="className">查询班级：</label><input type="text" id="className" class="textbox" name="className"
                                                   style="width:125px">
        <label for="testPhase">创建阶段：</label><input id="testPhase" type="text" name="testPhase" style="width:110px">
        <label for="stuName">查询学生：</label><input type="text" id="stuName" name="stuName" style="width:110px">
        <a id="search" class="easyui-linkbutton" iconCls="icon-search">查询</a>
    </div>
</div>
<div style="position: absolute">
    <div id="main"></div>
</div>
<div style="position:absolute;margin-left: 650px">
    <div id="main1"></div>
</div>
</body>
</html>
