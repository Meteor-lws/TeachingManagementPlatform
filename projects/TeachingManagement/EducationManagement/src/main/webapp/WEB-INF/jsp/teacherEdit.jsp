<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/easyui/themes/icon.css">
    <!--引入Jquery主文件-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
    <!--引入JqueryEasyUI主文件-->
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
    <!--让easyUI支持中文-->
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js"></script>
    <%--倒入主js--%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/teacherEdit.js"></script>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/td.css">
</head>
<body>
<table id="teaDg"></table>
<%--工具條--%>
<div id="teaTb" align="left" style="height:50px">
    <div>
        <%--添加教师--%>
        <a id="addTea" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
        <a id="editTea" href="javascript:void(0)" class="easyui-linkbutton"
           data-options="iconCls:'icon-edit',plain:true">修改</a>
        <%--批量删除--%>
        <a id="removeTea" href="javascript:void(0)" class="easyui-linkbutton"
           data-options="iconCls:'icon-remove',plain:true">刪除</a>

    </div>

    <div>
    教师编号 <input id="teacherNo" name="id" type="text" class="easyui-numberbox"
                data-options="min:0,precision:2" style="width: 120px"></input>
    教师姓名 <input id="teacherName" name="teacherName" class="easyui-validatebox" style="width: 120px"/>
    职教类型 <input id="teachingType" name="teacherType" />

<%--查询教师--%>
    <a id="selectTea" href="javascript:void(0)" class="easyui-linkbutton"
       data-options="iconCls:'icon-search',plain:true">搜索</a>
</div>
<%--教师修改添加框--%>
<div id="teaDialog" class="easyui-window" title="教师修改"
     data-options="modal:true,closed:true,iconCls:'icon-save'"
     style="width:700px;height:500px;padding:10px;">
    <form id="teaForm" method="post" action="/asa">
        <table style="height:100%" width="100% " align="center">
            <tr>
                <td class="tdLabel" align="right"><label>姓名</label></td>
                <td class="tdValue">
                    <input id="name" class="easyui-textbox" type="text" name="name" data-options="required:true">

                </td>
                <td class="tdLabel" align="right"><label>班级</label></td>
                <td class="tdValue">
                    <select id="teaClass" class="easyui-combotree" style="width:170px;"></select>
                </td>
            </tr>
            <tr>
                <td class="tdLabel" align="right"><label>专业</label></td>
                <td class="tdValue"><input class="easyui-textbox" type="text" name="major" data-options="required:true">
                </td>
                <td class="tdLabel" align="right"><label>手机</label></td>
                <td class="tdValue"><input class="easyui-textbox" type="text" name="phone" data-options="required:true">
                </td>
            </tr>
            <tr>
                <td class="tdLabel" align="right"><label>类型</label></td>
                <td class="tdValue">
                    <input class="easyui-textbox" type="text" name="type" data-options="required:true">
                </td>
                <td class="tdLabel" align="right"><label>性别</label></td>
                <td class="tdValue">
                    <input name="sex" type="radio" value="1"/>男 <input name="sex" type="radio" value="0"/>女
                </td>
            </tr>
            <tr>
                <td colspan="1" style="width: 100px ;height: 50px" align="right"><label>照片</label></td>
                <td colspan="3" style="width: 100px ;height: 50px">
                    <img alt="jiaoshi" src="${pageContext.request.contextPath}/js.jpg">
                </td>
            </tr>

            <tr>
                <td colspan="1" style="width: 100px ;height: 50px" align="right"><label>简介</label></td>
                <td colspan="3" style="width: 100px ;height: 50px">
                    <input class="easyui-textbox" data-options="multiline:true" value=""
                           style="width:300px;height:100px">
                </td>
            </tr>

            <tr align="center">
                <td colspan="2" class="tdLabel">
                    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add'"
                       onclick="submitForm()">保存</a>
                </td>
                <td colspan="2" class="tdValue">
                    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'"
                       onclick="cancel()">取消</a>
                </td>


            </tr>
        </table>
    </form>
</div>

</body>