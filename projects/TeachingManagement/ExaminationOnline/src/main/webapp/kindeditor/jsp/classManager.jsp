<%--
  Created by IntelliJ IDEA.
  User: 朱高
  Date: 2017/3/21
  Time: 9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../../easyui/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="../../easyui/themes/icon.css"/>
    <script type="text/javascript">
        $(function () {
            $("#table").datagrid({
                fit: true,
                fitColumns: true,
                //url : "datagrid_data1.json",
                //method : "get",
                toolbar: "#tb",
                columns: [[
                    {
                        field: "productid",
                        title: "产品编号",
                        width: 100,
                    },
                    {
                        field: "productname",
                        title: "产品名字",
                        width: 100,
                    },
                    {
                        field: "unitcost",
                        title: "产品代码",
                        width: 100,
                    },
                    {
                        field: "status",
                        title: "产品状态",
                        width: 100,
                    },
                    {
                        field: "listprice",
                        title: "产品价格",
                        width: 100,
                    },
                    {
                        field: "attr1",
                        title: "产品数量",
                        width: 100,
                    },
                    {
                        field: "itemid",
                        title: "产品嗲吗",
                        width: 100,
                    }
                ]],
            });
        })
    </script>
    <title>Title</title>
</head>
<body>
<div style="margin:20px 0;"></div>
<table id="table">

</table>
<div id="tb" style="height:auto">
    <div style="margin-bottom:5px">
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"></a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true"></a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true"></a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true"></a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"></a>
    </div>
    <div>
        Date From: <input class="easyui-datebox" style="width:80px">
        To: <input class="easyui-datebox" style="width:80px">
        Language:
        <select class="easyui-combobox" panelHeight="auto" style="width:100px">
            <option value="java">Java</option>
            <option value="c">C</option>
            <option value="basic">Basic</option>
            <option value="perl">Perl</option>
            <option value="python">Python</option>
        </select>
        <a href="#" class="easyui-linkbutton" iconCls="icon-search">Search</a>
    </div>
</div>
<script type="text/javascript" src="../../easyui/jquery.min.js"></script>
<script type="text/javascript" src="../../easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../../easyui/locale/easyui-lang-zh_CN.js"></script>
</body>
</html>
