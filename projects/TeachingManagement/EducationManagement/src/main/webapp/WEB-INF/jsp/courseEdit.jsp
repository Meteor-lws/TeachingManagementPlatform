<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css">
    <!--引入Jquery主文件-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
    <!--引入JqueryEasyUI主文件-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
    <!--让easyUI支持中文-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/courseEdit.js"></script>
    <title>课表管理</title>
</head>
<body>
<table id="couDg" style="width:100%;height:500px">
    <thead>
    <div id="couTb" align="left" style="height:60px">
        <div>
            <a id="downSchedule"
               href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-remove',plain:true">批量下载</a>
            <a id="removeSchedule"
               href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-remove',plain:true">批量删除</a>
        </div>
        <div align="left">
            班级 <select id="classSel" class="easyui-combotree" style="width:120px;"></select>
            上传者 <select id="scheduleSel" class="easyui-combotree" style="width:120px;"></select>
            日期 <input id="dd" type="text" class="easyui-datebox" style="width: 120px;"></input> &nbsp&nbsp&nbsp <a
                href="javascript:void(0)" class="easyui-linkbutton"
                data-options="iconCls:'icon-search',plain:true">搜索</a>

        </div>

    </div>
    </thead>
</table>
<script type="text/javascript" src="js/scheduleEdit.js"/>
</body>
</html>