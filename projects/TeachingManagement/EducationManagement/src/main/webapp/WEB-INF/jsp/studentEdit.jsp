<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    final String path = request.getContextPath();
    final String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<head>
    <link rel="stylesheet" href="easyui/themes/default/easyui.css"/>
    <link rel="stylesheet" href="easyui/themes/icon.css"/>
    <script src="easyui/jquery.min.js"></script>
    <script src="easyui/jquery.easyui.min.js"></script>
    <script src="easyui/locale/easyui-lang-zh_CN.js"></script>
    <script src="js/studentEdit.js" charset="utf-8">
    </script>
</head>
<body>
<table id="stuDg"></table>
<%--工具條--%>
<div id="stuTb" align="left">
    <a id="addStu" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
    <a id="editStu" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a>
    <a id="removeStu" href="javascript:void(0)" class="easyui-linkbutton"
       data-options="iconCls:'icon-edit',plain:true">刪除</a>
    学生姓名
    <input id="stuName" class="easyui-validatebox" name="studentName" style="width: 120px;"/> </input> &nbsp
    班级
    <select id="classSel" name="classID" class="easyui-combotree" style="width:120px;"></select>
    毕业时间
    <input id="studentGraduation" name="studentGraduation" type="text" class="easyui-datetimebox" style="width: 120px;">
    <a id="search" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true"
       onclick="loadStuDg()">搜索</a>
</div>
<div id="stuDialog" class="easyui-dialog" title="学生修改"
     data-options="modal:true,closable:true,iconCls:'icon-save',onClose:function(){$('#stuForm').form('clear'); $('#pic').attr('src','') },buttons:[{
				text:'保存',
				iconCls:'icon-ok',
				handler:function(){
				  $.messager.progress(); // 显示进度条
             $('#stuForm').form('submit', {
        url: '/education/saveOrUpdateStudent',
        onSubmit: function () {
            var isValid = $(this).form('validate');
            if (!isValid) {
                $.messager.progress('close'); // 如果表单是无效的则隐藏进度条
            }
            return isValid; // 返回false终止表单提交
        },
        success: function () {
            $.messager.progress('close'); // 如果提交成功则隐藏进度条
            $('#stuForm').form('clear');
            $('#pic').attr('src', '');
            $('#stuDg').datagrid('reload');
            $('#stuDialog').dialog('close');
        }
    });
				}
			},{
				text:'关闭',
				iconCls:'icon-no',
				handler:function(){
				 $('#stuDialog').dialog('close');
    $('#pic').attr('src', '');
    $('#stuForm').form('clear');
				}
			}]" ,
     style="width:700px;height:400px;padding:10px;">
    <form id="stuForm" method="post" enctype="multipart/form-data">
        <table align="center">
            <tr>
                <td align="right"><label>姓名:</label></td>
                <td>
                    <%--隐藏域--%>
                    <input type="hidden" name="id" id="id">
                    <input type="hidden" name="userId" id="userId">
                    <input id="studentName" name="studentName" class="easyui-textbox" type="text"
                           data-options="required:true,width:170">
                </td>
                <td align="right"><label>毕业学校:</label></td>
                <td>
                    <input id="schoolName" name="studentSchool" class="easyui-textbox" type="text" style="width:170px;">
                    <%-- <input type="text" id="schoolName" readonly class="easyui-validatebox"/>--%>
                    <div id="proSchool" class="easyui-window">
                        <div class="title">
                            <span>已选择:</span>
                        </div>
                        <div class="proSelect">
                            <select></select> <span>如没找到选择项，请选择其他手动填写</span> <input
                                type="text">
                        </div>
                        <div class="schoolList">
                            <ul>
                            </ul>
                        </div>
                    </div>
                </td>
            </tr>
            <tr>
                <td align="right"><label>专业:</label></td>
                <td>
                    <select id="studentSpecialty" name="studentSpecialty" class="easyui-combobox"
                            style="width:170px;" data-options="panelHeight:'80px',required:true">
                    </select>
                </td>
                <td align="right"><label>班级:</label></td>
                <td>
                    <select id="classId" name="classId" class="easyui-combotree" style="width:170px;"
                            data-options="required:true"></select>
                </td>
            </tr>
            <tr>
                <td align="right"><label>毕业时间:</label></td>
                <td>
                    <input id="graduateTime" name="studentGraduation" type="text" class="easyui-datetimebox"
                           style="width:170px;"
                           required="required"/>
                </td>
                <td align="right"><label>操行分:</label></td>
                <td>
                    <input id="studentConduct" name="studentConduct" class="easyui-textbox" type="text"
                           style="width:170px;"
                           data-options="required:true"/>
                </td>
            </tr>
            <tr>
                <td align="right">
                    学生编号:
                </td>
                <td>
                    <input id="studentIdNumber" name="studentIdNumber" class="easyui-textbox" type="text"
                           style="width:170px;"
                           data-options="required:true"/>
                </td>
                <td align="right">
                    学历:
                </td>
                <td>
                    <select id="studentEducation" name="studentEducation" class="easyui-combobox"
                            style="width:170px;" data-options="required:true"></select>
                </td>
            </tr>

            <tr>
                <td align="right"><label>家长联系方式:</label></td>
                <td>
                    <input id="studentFamilyPhone" name="studentFamilyPhone" class="easyui-textbox" type="text"
                           data-options="required:true" style="width:170px;"/>
                </td>
                <td align="right"><label>本人联系方式:</label></td>
                <td>
                    <input id="studentPhone" name="studentPhone" class="easyui-textbox" type="text"
                           data-options="required:true" style="width:170px;"/>
                </td>
            </tr>
            <tr>
                <td align="right"><label>性别:</label></td>
                <td>
                    <div id="sexDiv">
                    </div>
                </td>
                <td align="right"><label>保险是否缴纳:</label></td>
                <td>
                    <div id="insuranceDiv">
                    </div>

                </td>

            </tr>
            <tr>
                <td align="right">
                    照片:
                </td>
                <td>
                    <input type="hidden" name="studentPicture" id="studentPicture">
                    <input type="file" id="file" name="stuPic" onchange="uploadPic()">
                </td>
                <td colspan="2">
                    <img id="pic" width="100px" height="100px">
                </td>
            </tr>
            <%-- <tr>
                 <td align="right">角色:</td>
                 <td colspan="3">
                     <div id="roleDiv">

                     </div>
                 </td>
             </tr>--%>
        </table>
        </form>
    </div>

</body>