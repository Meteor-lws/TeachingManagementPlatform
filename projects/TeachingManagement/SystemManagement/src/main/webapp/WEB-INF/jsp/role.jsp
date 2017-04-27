<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basePath%>"/>
    <link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css"/>
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="js/role.js"></script>
</head>

<body class="easyui-layout">
<div data-options="region:'west',split:true" style="width: 240px">
    <ul id="treeRole"></ul>
</div>

<div data-options="region:'center',split:true">
    <div id="roleTb" align="center" style="height:60px">
        <div align="left">
            <a id="addRole" href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-add',plain:true">添加</a>
            <a id="editRole" href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-edit',plain:true">修改</a>
            <a id="removeRole" href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-remove',plain:true">删除</a>
        </div>
    </div>
    <div id="dictionary-detail"></div>
    <div id="roleDialog" class="easyui-dialog" title="角色修改"
         data-options="modal:true,closed:true,iconCls:'icon-save'"
         style="width:600px;height:450px;padding:100px;">
        <form id="ff" class="" method="post" action="/asa">
            <table width="350px" style="height:250px" align="center">
                <tr>
                    <td class="tdRoleLabel"><label>角色名称</label></td>
                    <td class="tdRoleValue"><input id="idCar" class="easyui-textbox" type="text"
                                                   data-options="required:true"></td>
                </tr>
                <tr>
                    <td class="tdRoleCodeLabel"><label>角色代码</label></td>
                    <td class="tdRoleCodeValue"><input id="roleCodes" class="easyui-textbox" type="text"
                                                   data-options="required:true"></td>
                </tr>
                <tr>
                    <td class="tdPreRoleLabel"><label>角色权限选择</label></td>
                    <!-- 用json来append -->
                    <td class="tdPreRoleValue">
                    </td>
                </tr>
                <tr>
                    <td class="tdRoleInheritLabel"><label>是否继承父角色资源</label></td>
                    <!-- 用json来append -->
                    <td class="tdRoleInheritValue">
                        <label>是</label><input checked="checked" type="radio" name="roleInherit" value="1"/>
                        <label>否</label><input type="radio" name="roleInherit" value="0"/>
                    </td>
                </tr>
                <tr>
                    <td class="tdDesRoleLabel"><label>角色描述:</label></td>
                    <td class="tdDesRoleValue"><input id="roleDescribe" class="easyui-textbox" data-options="multiline:true"
                                                      value=""
                                                      style="width:300px;height:100px"></td>
                </tr>
                <tr align="center">
                    <td><a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add'"
                           onclick="submitForm()">保存</a></td>
                    <td><a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'"
                           onclick="clearForm()">取消</a></td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>