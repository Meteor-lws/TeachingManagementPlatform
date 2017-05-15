<%--
  Created by IntelliJ IDEA.
  User: lws
  Date: 2017/4/25
  Time: 16:36
  用户管理页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    final String path = request.getContextPath();
    final String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>用户管理</title>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="easyui/themes/default/easyui.css"/>
    <link rel="stylesheet" href="easyui/themes/icon.css"/>
    <script src="easyui/jquery.min.js"></script>
    <script src="easyui/jquery.easyui.min.js"></script>
    <script src="easyui/locale/easyui-lang-zh_CN.js"></script>
    <script src="js/user.js"></script>
</head>
<body>
<table id="userDg" style="width:100%;height:100%"></table>
<div id="user-tool" style="font-size: 8px">
    <a id="userEdit" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'">修改用户基本信息</a>
    <a id="initPass" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'">初始化用户密码</a>
    <label for="user-search-type" style="padding-left: 15px">用户类型：</label>
    <select id="user-search-type" style="width: 90px;height: 22px"></select>
    <label for="user-search-status" style="padding-left: 15px">用户状态：</label>
    <select id="user-search-status" style="width: 90px;height: 22px"></select>
    <label style="padding-left: 15px">用户名：<input id="user-search-name" class="easyui-textbox"></label>
    <a id="search" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'">搜索</a>
</div>
</div>
<div id="userDialog" class="easyui-window" title="用户修改"
     data-options="modal:true,closable:false,iconCls:'icon-save',buttons:[{
				text:'保存',
				iconCls:'icon-ok',
				handler:function(){
				$.messager.progress(); // 显示进度条
    $('#userForm').form('submit', {
        url: '/system/saveOrUpdateUser',
    onSubmit: function () {
        var isValid = $(this).form('validate');
            if (!isValid) {
            $.messager.progress('close'); // 如果表单是无效的则隐藏进度条
                            }
            return isValid; // 返回false终止表单提交
            },
    success: function () {
    $.messager.progress('close'); // 如果提交成功则隐藏进度条
    $('#userForm').form('clear');
    $('#userDg').datagrid('reload');
    $('#userDialog').dialog('close');
                        }
    });
				}
			},{
				text:'关闭',
				iconCls:'icon-no',
				handler:function(){
				$('#userDialog').dialog('close');
                $('#userForm').form('clear');

				}
			}]"
     style="padding:10px;">
    <form id="userForm" method="post">
        <table>
            <tr>
                <input type="hidden" name="id" id="id"/>
                <td width="105px" class="tdLabel"><label>用户名</label></td>
                <td colspan="2" class="tdValue"><input id="userName" name="userName" class="easyui-textbox"
                                                       style="width: 120px;height: 24px"/></td>
            </tr>
            <tr>
                <td class="tdLabel"><label>用户状态</label></td>
                <td colspan="2" class="tdValue"><select id="userStatus" name="userStatus"
                                                        style="width: 120px;height: 24px"></select></td>
            </tr>
            <tr>
                <td class="tdLabel"><label>用户类型</label></td>
                <td colspan="2" class="tdValue"><select id="userType" name="userType"
                                                        style="width: 120px;height: 24px"></select></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
