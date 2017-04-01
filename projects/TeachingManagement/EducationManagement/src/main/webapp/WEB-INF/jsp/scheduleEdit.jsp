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
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/studentEdit.js"></script>
    <title>课表管理</title>
</head>
<body>
<table id="dg" style="width:100%;height:500px"
       data-options="rownumbers:true,singleSelect:false,pagination:true,url:'${pageContext.request.contextPath}/datagrid_data1.json',method:'get',toolbar:'#tb',fit:true">
    <thead>

    <div id="tb" align="center" style="height:40px">

        <div style="margin-top:5px" align="left">
            <label> 班级 </label> <input id="vv" class="easyui-validatebox"/>
            上传者 <select id="scheduleClass" class="easyui-combotree"
                        style="width:200px;"></select> 日期 <input id="dd" type="text"
                                                                 class="easyui-datebox"></input> &nbsp&nbsp&nbsp <a
                href="javascript:void(0)" class="easyui-linkbutton"
                data-options="iconCls:'icon-search'">搜索</a>
            <a id="downSchedule"
               href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-remove'">批量下载</a>
            <a id="removeSchedule"
               href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-remove'">批量删除</a>
        </div>

    </div>
    <tr>
        <th data-options="field:'ck',checkbox:true">是否启用</th>
        <th data-options="field:'itemid',width:80">ID</th>
        <th data-options="field:'productid',width:100">班级</th>
        <th data-options="field:'listprice',width:80,align:'right'">上传者</th>
        <th data-options="field:'unitcost',width:80,align:'right'">日期</th>
        <th data-options="field:'attr1',width:240">下载</th>
    </tr>
    </thead>
</table>
<script type="text/javascript" src="js/scheduleEdit.js"/>
</body>
</html>