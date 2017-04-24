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
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/resourcesEdit.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>课件管理</title>
</head>
<body>
<table id="resDg" style="width:100%;height:100%"
       data-options="rownumbers:true,singleSelect:false,pagination:true,url:'${pageContext.request.contextPath}/datagrid_data1.json',method:'get',fit:true,toolbar:'#tb'">
    <thead>
    <div id="resTb" align="center" style="height:60px">
        <div align="left">
            <a id="downRes" href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-remove',plain:true">批量下载</a>
            <a id="removeRes" href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-remove',plain:true">批量删除</a>
        </div>
        <div style="margin-top:5px" align="left">
            上传者
            <select id="teacherId" class="easyui-combobox" style="width:120px;"></select>
            日期
            <input id="workUploadTime" type="text" class="easyui-datetimebox" style="width: 120px;"></input>
            &nbsp&nbsp&nbsp
            <a id="search" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">搜索</a>
            <input id="workType" type="hidden" name="workType" value="resource">
        </div>
    </div>
    </thead>
</table>
</body>
</html>