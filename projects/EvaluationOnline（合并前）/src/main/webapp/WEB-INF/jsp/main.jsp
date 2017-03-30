<%--
  Created by IntelliJ IDEA.
  User: lws
  Date: 2017/3/27
  Time: 10:39
  后台管理主页面
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
    <script src="js/main.js"></script>
</head>
<body class="easyui-layout">
<div data-options="region:'west',title:'后台管理',split:true" style="width:240px">
    <div id="main-nav" class="easyui-accordion" data-options="multiple:true" style="width: 100%">
        <div title="系统管理">
            <h3 style="color:#0099FF;">系统管理</h3>
            <p>此处待填充系统通用管理功能</p>
        </div>
        <div title="在线评教子系统" data-options="selected:true">
            <ul id="main-evaluation">
                <li><a class="easyui-linkbutton" data-options="plain:true">评价项管理</a></li>
                <li><a class="easyui-linkbutton" data-options="plain:true">留言审核</a></li>
                <li><a class="easyui-linkbutton" data-options="plain:true">评价分析</a></li>
            </ul>
        </div>
        <div title="在线考试子系统">
            <h3 style="color:#0099FF;">在线考试子系统</h3>
            <p>此处待填充在线考试子系统管理功能</p>
        </div>
        <div title="教务管理子系统">
            <h3 style="color:#0099FF;">教务管理子系统</h3>
            <p>此处待填充教务管理子系统管理功能</p>
        </div>
    </div>
</div>
<div data-options="region:'center',border:false">
    <div id="main-content" class="easyui-tabs" data-options="fit:true">
        <div data-options="iconCls:'icon-home'" style="padding: 5px"> 欢迎来到后台管理系统！</div>
    </div>
</div>
<div data-options="region:'north'" style="height:83px">
    <div style="position: absolute"><img src="image/logo.png"></div>
    <div style="position: absolute;width: 100%;text-align: center"><h1>瑞才科技教学管理平台</h1></div>
</div>
<div data-options="region:'south'" style="height:36px;line-height:30px;text-align: center">&copy;2017-2027瑞才科技教学管理平台
</div>
</body>
</html>
