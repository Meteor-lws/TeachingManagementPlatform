<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/attendanceEdit.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>考勤管理</title>
</head>
<body>
<table id="attDg" style="width:100%;height:300px">
</table>
<div id="attTb" align="center" style="height:40px">
        <div style="margin-top:5px" align="left">
            <label>
                班级
            </label>
            <select id="classSel" class="easyui-combotree" style="width:120px;"></select>
            姓名
            <input id="stuName" type="text" class="easyui-datebox" style="width:120px"></input>
            日期
            <input id="date" type="text" class="easyui-datebox" style="width:120px"></input>
            &nbsp&nbsp&nbsp
            <a href="otherpage.php" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">搜索</a>
        </div>

    </div>


</body>
</html>