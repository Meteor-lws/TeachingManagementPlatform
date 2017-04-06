<%--
  Created by IntelliJ IDEA.
  User: XuMing
  Date: 2017/4/4
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css"
          href="easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css"
          href="easyui/themes/icon.css">
    <!--引入Jquery主文件-->
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <!--引入JqueryEasyUI主文件-->
    <script type="text/javascript"
            src="easyui/jquery.easyui.min.js"></script>
    <!--让easyUI支持中文-->
    <script type="text/javascript"
            src="easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/roleEdit.js"></script>
</head>
<body>
<table id="roleDg" style="width:100%;height:100%">
</table>

<div id="roleTb" align="center" style="height:60px">
    <div align="left">
        <a id="addRole" href="javascript:void(0)" class="easyui-linkbutton"
           data-options="iconCls:'icon-add',plain:true">添加</a>
        <a id="editRole" href="javascript:void(0)" class="easyui-linkbutton"
           data-options="iconCls:'icon-edit',plain:true">修改</a>
        <a id="removeRole" href="javascript:void(0)" class="easyui-linkbutton"
           data-options="iconCls:'icon-remove',plain:true">删除</a>
    </div>

    <div align="left" style="margin-top:5px">
        角色名称 <select id="roleNameSel" class="easyui-combotree" style="width:120px;"></select>
        角色编码 <input id="rolecode" class="easyui-validatebox" name="stuName" style="width: 120px;"/>
        <a id="search" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">搜索</a>
    </div>

</div>
<div id="roleDialog" class="easyui-dialog" title="角色修改"
     data-options="modal:true,closed:true,iconCls:'icon-save'"
     style="width:600px;height:550px;padding:10px;">
    <form id="ff" class="" method="post" action="/asa">
        <table width="100%" style="height:100%" align="center">
            <tr>
                <td class="tdRoleLabel"><label>角色名称</label></td>
                <td class="tdRoleValue"><input id="idCar" class="easyui-textbox" type="text"
                                               data-options="required:true"></input></td>
            </tr>
            <tr>
                <td class="tdPreRoleLabel"><label>角色权限选择</label></td>
                <td class="tdPreRoleValue"><input type="checkbox" name="qx" value="1"/>用户管理
                    <input type="checkbox" name="qx" value="2"/>业务模板定制管理<br/><br/>
                    <input type="checkbox" name="qx" value="1"/>用户管理
                    <input type="checkbox" name="qx" value="2"/>业务模板定制管理<br/>
                </td>
            </tr>
            <tr>
                <td class="tdDesRoleLabel"><label>角色描述:</label></td>
                <td class="tdDesRoleValue"><input id="" class="easyui-textbox" data-options="multiline:true" value=""
                                                  style="width:300px;height:100px"></td>
            </tr>
            <tr align="center">
                <td><a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add'"
                       onclick="submitForm()">保存</a></td>
                <td><a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'"
                       onclick="cancel()">取消</a></td>
            </tr>
        </table>
    </form>
</div>


</body>
</html>
