<%--
  Created by IntelliJ IDEA.
  User: XuMing
  Date: 2017/4/5
  Time: 19:08
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
    <script type="text/javascript " src="${pageContext.request.contextPath}/js/dictionaryEdit.js"></script>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/td.css">
</head>
<body>
<table id="dicDg">
</table>
<div id="dicTb" align="left" style="height:50px">
    <div align="left">
        <a id="addDic" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
        <a id="editDic" href="javascript:void(0)" class="easyui-linkbutton"
           data-options="iconCls:'icon-edit',plain:true">修改</a>
        <%--批量删除--%>
        <a id="removeDic" href="javascript:void(0)" class="easyui-linkbutton"
           data-options="iconCls:'icon-edit',plain:true">刪除</a>
    </div>
    <div>
        字典类型<input id="dicList" name="dept">
        <a id="search" href="javascript:void(0)" class="easyui-linkbutton"
           data-options="iconCls:'icon-search',plain:true">搜索</a>
    </div>
</div>
<div id="dicDialog" class="easyui-dialog" title="字典修改" style="height: 550px;width: 500px">
    <form>
        <table align="" width="100%" style="height: 100%">
            <tr>
                <td class="tdLabel" align="right"><label>名称</label></td>
                <td class="tdValue"><input id="idCar" class="easyui-textbox" type="text"
                                           data-options="required:true"></input></td>
            </tr>
            <tr>
                <td class="tdLabel" align="right"><label>代码</label></td>
                <td class="tdValue"><input id="idCar" class="easyui-textbox" type="text"
                                           data-options="required:true"></input></td>
            </tr>
            <tr>
                <td class="tdLabel" align="right"><label>描述</label></td>
                <td class="tdValue"><input class="easyui-textbox" data-options="multiline:true" value=""
                                           style="width:300px;height:100px"></td>
            </tr>
            <tr align="center">
                <td align="right">
                    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add'"
                       onclick="submitForm()">保存</a>
                </td>
                <td>
                    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'"
                       onclick="cancel()">取消</a>
                </td>
            </tr>

        </table>

    </form>

</div>
</body>
</html>
