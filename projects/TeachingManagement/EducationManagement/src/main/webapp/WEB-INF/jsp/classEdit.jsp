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
            开班时间 <input id="classStartDate" type="text" class="easyui-datebox" style="width: 120px"></input>
            结业时间<input id="classEndDate" type="text" class="easyui-datebox" style="width: 120px"></input>
            <a id="search" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">搜索</a>
        </div>
    </div>
<div id="classDialog" class="easyui-dialog" title="班级修改"
     data-options="modal:true,closable:false,iconCls:'icon-save'"
     style="width:500px;height:400px;padding:10px;">
    <form id="classForm" method="post">
        <input type="hidden" id="id" name="id">
            <table style="height: 100%" width="100%" align="center">
                <tr>
                    <td class="tdLabel" align="center"><label>班级名称</label></td>
                    <td class="tdValue" align="left"><input id="className" name="className" class="easyui-textbox"
                                                            data-options="required:true"/></td>
                    <td class="tdLabel" align="center"><label>班级类型</label></td>
                    <td class="tdValue" align="left">
                        <select id="classType" class="easyui-combobox" name="classType"
                                style="width:170px;" data-options="panelHeight:'80px',required:true">
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="tdLabel" align="center"><label>开班时间</label></td>
                    <td class="tdValue" align="left"><input id="classStartDateForm" name="classStartDate" type="text"
                                                            class="easyui-datetimebox"
                                                            data-options="required:true"></input></td>
                    <td class="tdLabel" align="center"><label>结业时间</label></td>
                    <td class="tdValue" align="left"><input id="classdEndDateForm" name="classEndDate" type="text"
                                                            class="easyui-datetimebox"
                                                            data-options="required:true"></input></td>
                </tr>
                <tr>

                </tr>
                <tr>
                    <td class="tdLabel" align="center"><label>主讲教师</label></td>
                    <td class="tdValue" align="left">
                        <select id="mainTeacherId" class="easyui-combobox" name="mainTeacherId"
                                style="width:170px;" data-options="panelHeight:'80px',required:true">
                        </select>
                    </td>
                    <td class="tdLabel" align="center"><label>班主任</label></td>
                    <td class="tdValue" align="left">
                        <select id="headTeacherId" class="easyui-combobox" name="headTeacherId"
                                style="width:170px;" data-options="panelHeight:'80px',required:true">
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="tdLabel" align="center"><label>助教</label></td>
                    <td class="tdValue" align="left">
                        <select id="assistantId" class="easyui-combobox" name="assistantId"
                                style="width:170px;" data-options="panelHeight:'80px',required:true">
                        </select>
                    </td>
                </tr>
                <tr align="center">
                    <td colspan="4" align="right">
                        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add'"
                           onclick="submitForm()">保存</a>
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