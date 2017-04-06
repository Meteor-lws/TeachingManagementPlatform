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
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/userEdit.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/css/student.css">
    <title>密码管理</title>
</head>
<body>
<table id="userDg" style="width:100%;height:100%">
</table>
<div id="userTb" align="center">
    <div align="left">
        <a id="editUse" href="javascript:void(0)" class="easyui-linkbutton"
           data-options="iconCls:'icon-edit',plain:true">修改</a>
        <a id="addUse" href="javascript:void(0)" class="easyui-linkbutton"
           data-options="iconCls:'icon-edit',plain:true">添加</a>
        <a id="removeUse" href="javascript:void(0)" class="easyui-linkbutton"
           data-options="iconCls:'icon-edit',plain:true">删除</a>
        <a id="initUse" href="javascript:void(0)" class="easyui-linkbutton"
           data-options="iconCls:'icon-edit',plain:true">初始化密码</a>
        </div>
        <div align="left" style="margin-top:5px">
            用户名 <input id="selectUserName" class="easyui-textbox" name="stuName"/>
            用户编号 <input name="selectUserNo" type="text" class="easyui-textbox"
                        data-options="min:0,precision:2"></input>
            <a id="search" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">搜索</a>
        </div>
    </div>
    <span></span>

<div id="userDialog" class="easyui-window" title="用户修改"
     data-options="modal:true,closed:true,iconCls:'icon-save'"
     style="width:500px;height:300px;padding:10px;">
    <form id="userForm" method="post" action="/asa">
        <table>
            <tr>
                <td class="tdLabel"><label>用户名</label></td>
                <td class="tdValue"><input id="userName" class="easyui-textbox"/></td>
            </tr>
            <tr>
                <td class="tdLabel"><label>密码</label></td>
                <td class="tdValue"><input id="passWord" class="easyui-textbox"></input></td>
            </tr>
            <tr>
                <td><a href="javascript:void(0)" class="easyui-linkbutton"
                       data-options="iconCls:'icon-add'" onclick="submitForm()">保存</a></td>
                <td><a href="javascript:void(0)"
                       class="easyui-linkbutton" data-options="iconCls:'icon-cancel'"
                       onclick="cancel()">取消</a></td>

            </tr>
        </table>
        </form>
    </div>

<script type="text/javascript">
    $(function () {
        var pager = $('#dg').datagrid().datagrid('getPager');	// get the pager of datagrid
    })
</script>
</body>
</html>