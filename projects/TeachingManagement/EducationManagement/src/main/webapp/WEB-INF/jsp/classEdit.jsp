<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    final String path = request.getContextPath();
    final String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<head>
    <title>班级管理</title>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="easyui/themes/default/easyui.css"/>
    <link rel="stylesheet" href="easyui/themes/icon.css"/>
    <script src="easyui/jquery.min.js"></script>
    <script src="easyui/jquery.easyui.min.js"></script>
    <script src="easyui/locale/easyui-lang-zh_CN.js"></script>
    <script src="js/classEdit.js"></script>
</head>
<body>
<table id="classDg"></table>
<div id="classTb" align="left">
    <a id="addCla" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
    <a id="editCla" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a>
    <a id="removeCla" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
    开班时间<input id="classStartDate" type="text" class="easyui-datebox" style="width: 120px"/>
    结业时间<input id="classEndDate" type="text" class="easyui-datebox" style="width: 120px"/>
    <a id="search" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">搜索</a>
</div>
<div id="classDialog" class="easyui-dialog" title="班级修改"
     data-options="modal:true,closable:false,iconCls:'icon-save',closable:true,buttons:[{
				text:'保存',
				iconCls:'icon-ok',
				handler:function(){
				 $.messager.progress(); // 显示进度条
    $('#classForm').form('submit', {
        url: '/education/saveOrUpdateClass',
        onSubmit: function () {
            var isValid = $(this).form('validate');
            if (!isValid) {
                $.messager.progress('close'); // 如果表单是无效的则隐藏进度条
            }
            return isValid; // 返回false终止表单提交
        },
        success: function () {
            $.messager.progress('close'); // 如果提交成功则隐藏进度条
            $('#classForm').form('clear');
            $('#classDg').datagrid('reload');
            $('#classDialog').dialog('close');
        }
    });


				}
			},{
				text:'关闭',
				iconCls:'icon-no',
				handler:function(){
				$('#classForm').form('clear');
                $('#classDialog').dialog('close');
				}
			}]"
     style="width:500px;height:400px;padding:10px;">
    <form id="classForm" method="post">
        <input type="hidden" id="id" name="id">
        <table align="center">
                <tr>
                    <td align="right"><label>班级名称:</label></td>
                    <td align="left"><input id="className" name="className" class="easyui-textbox"
                                                            data-options="required:true"/></td>
                </tr>
            <tr>
                <td align="right"><label>班级类型:</label></td>
                <td align="left">
                        <select id="classType" class="easyui-combobox" name="classType"
                                style="width:170px;" data-options="panelHeight:'80px',required:true">
                        </select>
                    </td>
                </tr>
                <tr>
                    <td align="right"><label>开班时间:</label></td>
                    <td align="left"><input id="classStartDateForm" name="classStartDate" type="text"
                                                            class="easyui-datetimebox"
                                                            data-options="required:true"/></td>
                </tr>
            <tr>
                <td align="right"><label>结业时间:</label></td>
                <td align="left"><input id="classdEndDateForm" name="classEndDate" type="text"
                                                            class="easyui-datetimebox"
                                                            data-options="required:true"/></td>
                </tr>
                <tr>

                </tr>
                <tr>
                    <td align="right"><label>主讲教师:</label></td>
                    <td align="left">
                        <select id="mainTeacherId" class="easyui-combobox" name="mainTeacherId"
                                style="width:170px;" data-options="panelHeight:'80px',required:true">
                        </select>
                    </td>
                </tr>
            <tr>
                <td align="right"><label>班主任:</label></td>
                <td align="left">
                        <select id="headTeacherId" class="easyui-combobox" name="headTeacherId"
                                style="width:170px;" data-options="panelHeight:'80px',required:true">
                        </select>
                    </td>
                </tr>
                <tr>
                    <td align="right"><label>助教:</label></td>
                    <td align="left">
                        <select id="assistantId" class="easyui-combobox" name="assistantId"
                                style="width:170px;" data-options="panelHeight:'80px',required:true">
                        </select>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>