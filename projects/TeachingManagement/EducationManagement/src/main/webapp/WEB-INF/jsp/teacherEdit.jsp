<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    final String path = request.getContextPath();
    final String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>教师管理</title>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="easyui/themes/default/easyui.css"/>
    <link rel="stylesheet" href="easyui/themes/icon.css"/>
    <script src="easyui/jquery.min.js"></script>
    <script src="easyui/jquery.easyui.min.js"></script>
    <script src="easyui/locale/easyui-lang-zh_CN.js"></script>
    <script src="js/teacherEdit.js"></script>
</head>
<body>
<table id="teaDg"></table>
<div id="teaTb" align="left">
    <a id="addTea" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
    <a id="editTea" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a>
    <a id="removeTea" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">刪除</a>
    教师姓名: <input id="teacherName" name="teacherName" class="easyui-textbox" style="width: 120px"/>
    职教类型:<input id="teachingType" name="teacherType"/>
    <a id="selectTea" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">搜索</a>
</div>
<div id="teaDialog" class="easyui-dialog" title="教师修改" data-options="modal:true,closed:true,iconCls:'icon-save',closable:true,onClose:function(){$('#teaForm').form('clear');$('#pic').attr('src','')},

buttons:[{
				text:'保存',
				iconCls:'icon-ok',
				handler:function(){
                $.messager.progress(); // 显示进度条
                     $('#teaForm').form('submit', {
        url: '/education/saveOrUpdate',
        onSubmit: function () {
            var isValid = $(this).form('validate');

            if (!isValid) {
                $.messager.progress('close'); // 如果表单是无效的则隐藏进度条
            }
            return isValid; // 返回false终止表单提交
        },
        success: function () {
            $.messager.progress('close'); // 如果提交成功则隐藏进度条
            $('#teaForm').form('clear');//清除表单内容
            $('#pic').attr('src', '');
            $('#teaDg').datagrid('reload');
            $('#teaDialog').dialog('close')
        }
    });

				}
			},{
				text:'关闭',
				iconCls:'icon-no',
				handler:function(){
				 $('#teaDialog').dialog('close');
                 $('#teaForm').form('clear');
                 $('#pic').attr('src', '');
				}
			}]" style="padding:10px;">
    <form id="teaForm" method="post" enctype="multipart/form-data">
        <table align="center">
            <tr>
                <input type="hidden" name="id" id="teaId">
                <input type="hidden" name="userId" id="userId">
                <td class="tdLabel" align="right"><label>姓名:</label></td>
                <td class="tdValue">
                    <input id="teacherNameForm" name="teacherName" class="easyui-textbox" type="text"
                           data-options="required:true,width:170">
                </td>
                <td class="tdLabel" align="right"><label>类型:</label></td>
                <td class="tdValue">
                    <select id="teacherTypeForm" name="teacherType" class="easyui-combotree"
                            data-options="required:true,width:170"></select>
                </td>
            </tr>
            <tr>
                <td class="tdLabel" align="right"><label>专业:</label></td>
                <td class="tdValue"><select id="teacherSpecialityForm" name="teacherSpeciality" class="easyui-combotree"
                                            data-options="required:true,width:170"></select>
                </td>
                <td class="tdLabel" align="right"><label>手机:</label></td>
                <td class="tdValue"><input class="easyui-textbox" id="teacherPhoneForm" type="text" name="teacherPhone"
                                           data-options="required:true,width:170">
                </td>
            </tr>
            <tr>
                <td class="tdLabel" align="right"><label>教师编号:</label></td>
                <td>
                    <input id="teacherNumber" name="teacherNumber" class="easyui-textbox"
                           data-options="required:true,width:170"/>
                </td>
                <td class="tdLabel" align="right"><label>性别:</label></td>
                <td class="tdValue">
                    <div id="sex">
                    </div>
                </td>
            </tr>
            <tr>
                <td align="right"><label>照片:</label></td>
                <td align="left">
                    <input id="teacherPicForm" type="file" name="teapic" onchange="showPic()">
                </td>
                <td colspan="2" align="left">
                    <img alt="照片" id="pic" src="" width="100px" height="100px">
                    <input id="teacherPicture" type="hidden" name="teacherPicture"/>
                </td>
            </tr>

            <tr>
                <td align="right"><label>简介:</label></td>
                <td colspan="3">
                    <input id="teacherIntroductionForm" name="teacherIntroduction" class="easyui-textbox"
                           data-options="multiline:true" value="" style="width:450px;height:120px">
                </td>
            </tr>
            <tr>
                <td align="right">角色:</td>
                <td colspan="3">
                    <div id="roleDiv"></div>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>