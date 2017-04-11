<%--
  Created by IntelliJ IDEA.
  User: lws
  Date: 2017/3/30
  Time: 19:11
  后台管理侧首页
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    final String path = request.getContextPath();
    final String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>后台管理</title>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="easyui/themes/default/easyui.css"/>
    <link rel="stylesheet" href="easyui/themes/icon.css"/>
    <script src="easyui/jquery.min.js"></script>
    <script src="easyui/jquery.easyui.min.js"></script>
    <script src="easyui/locale/easyui-lang-zh_CN.js"></script>
    <script src="js/background.js"></script>
</head>
<body class="easyui-layout">
<div data-options="region:'west',title:'后台管理',split:true" style="width: 240px">
    <div id="back-nav" class="easyui-accordion" data-options="multiple:true,border:false" style="width: 100%">
        <div title="系统管理">
            <ul>
                <li><a class="easyui-linkbutton" data-options="plain:true">用户管理</a></li>
                <li><a class="easyui-linkbutton" data-options="plain:true">角色管理</a></li>
                <li><a class="easyui-linkbutton" data-options="plain:true">权限管理</a></li>
                <li><a class="easyui-linkbutton" data-options="plain:true">数据字典</a></li>
            </ul>
        </div>
        <div title="在线评教子系统">
            <ul>
                <li><a class="easyui-linkbutton" data-options="plain:true">评价项管理</a></li>
                <li><a class="easyui-linkbutton" data-options="plain:true">留言审核</a></li>
                <li><a class="easyui-linkbutton" data-options="plain:true">评价分析</a></li>
            </ul>
        </div>
        <div title="在线考试子系统">
            <ul>
                <li><a class="easyui-linkbutton" data-options="plain:true">考试安排</a></li>
                <li><a class="easyui-linkbutton" data-options="plain:true">试题管理</a></li>
                <li><a class="easyui-linkbutton" data-options="plain:true">评分分析</a></li>
            </ul>
        </div>
        <div title="教务管理子系统">
            <ul>
                <li><a class="easyui-linkbutton" data-options="plain:true">教师管理</a></li>
                <li><a class="easyui-linkbutton" data-options="plain:true">学生管理</a></li>
                <li><a class="easyui-linkbutton" data-options="plain:true">班级管理</a></li>
                <li><a class="easyui-linkbutton" data-options="plain:true">考勤管理</a></li>
                <li><a class="easyui-linkbutton" data-options="plain:true">周报管理</a></li>
                <li><a class="easyui-linkbutton" data-options="plain:true">课表管理</a></li>
                <li><a class="easyui-linkbutton" data-options="plain:true">课件管理</a></li>
            </ul>
        </div>
    </div>
</div>
<div data-options="region:'center',border:false">
    <div id="back-tabs" class="easyui-tabs" data-options="fit:true">
        <div data-options="iconCls:'icon-home'" style="padding: 4px"> 欢迎来到后台管理系统！</div>
    </div>
</div>
<div data-options="region:'north'" style="height:83px">
    <div style="position: absolute;width: 100%;text-align: center"><h1>瑞才科技教学管理平台</h1></div>
    <div style="position: absolute"><a href=""><img src="image/logo.png"></a></div>
</div>
<div data-options="region:'south'" style="height:36px;line-height:30px;text-align: center">&copy;2017-2027瑞才科技教学管理平台</div>
</body>
</html>
