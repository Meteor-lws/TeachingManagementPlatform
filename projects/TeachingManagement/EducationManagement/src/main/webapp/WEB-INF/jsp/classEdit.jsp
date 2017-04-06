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
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/classEdit.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/student.css">
</head>
<body>
<table id="classDg" style="width:100%;height:100%">
</table>
<div id="classTb" align="center" style="height:60px">
    <div align="left">
        <a id="addCla" href="javascript:void(0)" class="easyui-linkbutton"
           data-options="iconCls:'icon-add',plain:true">添加</a>
        <a id="editCla" href="javascript:void(0)" class="easyui-linkbutton"
           data-options="iconCls:'icon-edit',plain:true">修改</a>
        <a id="removeCla" href="javascript:void(0)" class="easyui-linkbutton"
           data-options="iconCls:'icon-remove',plain:true">删除</a>
        </div>

        <div align="left" style="margin-top:5px">
            班级名称 <select id="classSel" class="easyui-combotree" style="width:120px;"></select>
            开班时间 <input id="startTime" type="text" class="easyui-datebox" style="width: 120px"></input>
            结业时间<input id="endTime" type="text" class="easyui-datebox" style="width: 120px"></input>
            <a id="search" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">搜索</a>
        </div>
    </div>
<div id="classDialog" class="easyui-dialog" title="班级修改"
     data-options="modal:true,closed:true,iconCls:'icon-save'"
     style="width:500px;height:450px;padding:10px;">
        <form id="ff" method="post" action="/asa">
            <table style="height: 100%" width="100%" align="center">
                <tr>
                    <td class="tdLabel" align="center"><label>班级名称</label></td>
                    <td class="tdValue" align="left"><input id="className" class="easyui-validatebox"
                                                            data-options="required:true"/></td>
                </tr>
                <tr>
                    <td class="tdLabel" align="center"><label>开班时间</label></td>
                    <td class="tdValue" align="left"><input id="classStartTime" type="text"
                                                            class="easyui-datebox"></input></td>
                </tr>
                <tr>
                    <td class="tdLabel" align="center"><label>结业时间</label></td>
                    <td class="tdValue" align="left"><input id="classdEndTime" type="text"
                                                            class="easyui-datebox"></input></td>
                </tr>
                <tr>
                    <td class="tdLabel" align="center"><label>结业时间</label></td>
                    <td class="tdValue" align="left">
                        <select id="state" class="easyui-combobox" name="dept"
                                style="width:170px;" data-options="panelHeight:'80px'">
                            <option value="1">已开课</option>
                            <option value="0">待开课</option>
                            <option value="0">已结业</option>
                        </select>
                    </td>
                </tr>
                <tr align="center">
                    <td class="tdLabel">
                        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add'"
                           onclick="submitForm()">保存</a>
                    </td>
                    <td class="tdValue">
                        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'"
                           onclick="cancel()">取消</a>
                    </td>

                </tr>
            </table>
        </form>
    </div>

<script type="text/javascript">

</script>
</body>