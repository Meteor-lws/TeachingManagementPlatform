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
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/passEdit.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>密码管理</title>
</head>
<body>
<table id="dg" style="width:100%;height:100%"
       data-options="rownumbers:true,singleSelect:false,pagination:true,url:'${pageContext.request.contextPath}/list.json',method:'get',fitColumns:true,fit:true,toolbar:'#tb'">
    <thead>

    <div id="tb" align="center" style="height:80px">
        <div align="left" style="margin-top:5px">
            <a id="editStu"
               href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-edit'">修改</a> <a id="search"
                                                            href="#" class="easyui-linkbutton"
                                                            data-options="iconCls:'icon-search'">搜索</a>
        </div>
        <div align="left" style="margin-top:5px">
            用户名 <input
                id="stuName" class="easyui-validatebox" name="stuName"/>
            &nbsp&nbsp&nbsp&nbsp
            学生编号 <input name="stuNo" type="text" class="easyui-numberbox"
                        value="100" data-options="min:0,precision:2"></input>
        </div>

    </div>
    <span></span>

    <tr>
        <th data-options="field:'ck',checkbox:true">是否启用</th>
        <th data-options="field:'classId'">用户名</th>
        <th data-options="field:'graduteTime',align:'right'">密码</th>
        <th data-options="field:'status',align:'center'">状态</th>
    </tr>
    <div id="w" class="easyui-window" title="学生修改"
         data-options="modal:true,closed:true,iconCls:'icon-save'"
         style="width:500px;height:300px;padding:10px;">
        <form id="ff" method="post" action="/asa">
            <div align="center" style="padding:5px;">
                <label for="classNo">用户名:</label> &nbsp &nbsp &nbsp &nbsp &nbsp
                &nbsp <input id="classNo" class="easyui-validatebox" readonly="readonly"/>
            </div>
            <div align="center" style="padding:10px;">
                <label for="startTime">密码:</label> &nbsp &nbsp &nbsp &nbsp &nbsp
                &nbsp <input id="classStartTime" type="text"
                             class="easyui-datebox"></input>
            </div>


            <div style="text-align:center;padding:5px">
                <a href="javascript:void(0)" class="easyui-linkbutton"
                   data-options="iconCls:'icon-add'" onclick="submitForm()">保存</a>
                &nbsp &nbsp &nbsp <a href="javascript:void(0)"
                                     class="easyui-linkbutton" data-options="iconCls:'icon-cancel'"
                                     onclick="cancel()">取消</a>
            </div>
        </form>
    </div>
    </thead>
</table>
<script type="text/javascript">
    $(function () {
        var pager = $('#dg').datagrid().datagrid('getPager');	// get the pager of datagrid
    })
</script>
</body>
</html>