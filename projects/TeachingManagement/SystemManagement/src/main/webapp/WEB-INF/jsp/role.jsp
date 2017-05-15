<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    final String path = request.getContextPath();
    final String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>角色管理</title>
    <base href="<%=basePath%>"/>
    <link rel="stylesheet" href="easyui/themes/default/easyui.css"/>
    <link rel="stylesheet" href="easyui/themes/icon.css"/>
    <script src="easyui/jquery.min.js"></script>
    <script src="easyui/jquery.easyui.min.js"></script>
    <script src="easyui/locale/easyui-lang-zh_CN.js"></script>
    <script src="js/role.js"></script>
</head>
<body class="easyui-layout">
<div data-options="region:'west',split:true" style="width: 240px">
    <ul id="treeRole"></ul>
</div>
<div data-options="region:'center',split:true">
    <div id="roleTb" align="center">
        <div align="left">
            <a id="addRole" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
            <a id="editRole" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a>
            <a id="removeRole" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
        </div>
    </div>
    <div id="dictionary-detail"></div>
    <div id="roleDialog" class="easyui-dialog" title="角色修改"
         data-options="modal:true,closed:true,iconCls:'icon-save'"
         style="padding:10px;">
        <form id="ff" class="" method="post">
            <table align="center">
                <tr>
                    <td class="tdRoleLabel" width="90px"><label>角色名称</label></td>
                    <td colspan="3" class="tdRoleValue"><input id="idCar" class="easyui-textbox" type="text"
                                                               data-options="required:true"></td>
                </tr>
                <tr>
                    <td class="tdRoleCodeLabel"><label>角色代码</label></td>
                    <td colspan="3" class="tdRoleCodeValue"><input id="roleCodes" class="easyui-textbox" type="text"
                                                                   data-options="required:true"></td>
                </tr>
                <tr>
                    <td class="tdPreRoleLabel"><label>角色权限</label></td>
                    <!-- 用json来append -->
                    <td colspan="3" class="tdPreRoleValue"></td>
                </tr>
                <tr>
                    <td class="tdRoleInheritLabel"><label>是否继承</label></td>
                    <!-- 用json来append -->
                    <td colspan="3" class="tdRoleInheritValue">
                        <label>是</label><input id="1" checked="checked" type="radio" name="roleInherit" value="1"/>
                        <label>否</label><input id="0" type="radio" name="roleInherit" value="0"/>
                    </td>
                </tr>
                <tr>
                    <td class="tdDesRoleLabel"><label>角色描述:</label></td>
                    <td colspan="3" class="tdDesRoleValue"><input id="roleDescribe" class="easyui-textbox"
                                                                  data-options="multiline:true" value=""
                                                                  style="width:300px;height:100px"></td>
                </tr>
                <tr>
                    <td colspan="2"></td>
                    <td align="right"><a class="easyui-linkbutton" data-options="iconCls:'icon-add'"
                                         onclick="submitForm()">保存</a></td>
                    <td align="left"><a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'"
                                        onclick="clearForm()" style="margin-left: 20px">取消</a></td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>