<%--
  Created by IntelliJ IDEA.
  User: 朱高
  Date: 2017/3/17
  Time: 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basePath%>"/>
    <link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
    <link rel="stylesheet" type="text/css" href="css/login.css" />
    <link rel="stylesheet" type="text/css" href="css/admin.css"/>
    <title>Title</title>
</head>
<body class="easyui-layout">

    <!--noheader:true表示不要头标签-->
    <div data-options="region:'north',title:'North Title',split:true, noheader:true" style="height:60px;background:#666;">
        <div class="logo">后台管理</div>
        <div class="logout">您好，| <a href="logout.php">退出</a></div>
    </div>
    <!--底部标签-->
    <div data-options="region:'south',title:'footer',split:true,noheader:true" style="height:35px;line-height:30px;text-align:center;">
        &copy;2009-2017 瑞才科技教务管理系统.
    </div>
    <!--左边标签-->
    <div data-options="region:'west',title:'导航',split:true" style="width:180px;iconCls:'icon-world'">
        <ul id="nav"></ul>
    </div>
    <!--中间标签-->
    <div data-options="region:'center'" style="overflow:hidden;">
        <!--中间选项卡-->
        <div id="tabs">
            <div title="起始页" iconCls="icon-house" style="padding:0 10px;display:block;">
                欢迎来到后台管理系统！
            </div>
        </div>
    </div>
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js" ></script>
    <script type="text/javascript" src="js/admin.js"></script>
</body>
</html>
