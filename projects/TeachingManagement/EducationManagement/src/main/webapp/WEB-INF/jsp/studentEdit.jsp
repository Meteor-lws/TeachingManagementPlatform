<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="http://libs.baidu.com/jquery/1.6.4/jquery.min.js"></script>
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
    <script type="text/javascript" src="js/studentEdit.js" charset="utf-8">
    </script>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/css/student.css">
</head>
<body>
<table id="stuDg">
</table>
<%--工具條--%>
<div id="stuTb" align="left" style="height:50px">
    <div align="left">
        <a id="addStu" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
        <a id="editStu" href="javascript:void(0)" class="easyui-linkbutton"
           data-options="iconCls:'icon-edit',plain:true">修改</a>
        <%--批量删除--%>
        <a id="removeStu" href="javascript:void(0)" class="easyui-linkbutton"
           data-options="iconCls:'icon-edit',plain:true">刪除</a>
        </div>
    学生姓名
    <input id="stuName" class="easyui-validatebox" name="studentName" style="width: 120px;"/> </input> &nbsp
    班级
    <select id="classSel" name="classID" class="easyui-combotree" style="width:120px;"></select>
    毕业时间
    <input id="studentGraduation" name="studentGraduation" type="text" class="easyui-datetimebox" style="width: 120px;">
    <%--搜索按鈕--%>
    <a id="search" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true"
       onclick="loadStuDg()">搜索</a>
    </div>
    <span></span>

<%--学生修改添加框--%>
<div id="stuDialog" class="easyui-dialog" title="学生修改"
     data-options="modal:true,closable:false,iconCls:'icon-save'"
     style="width:700px;height:600px;padding:10px;">
    <form id="stuForm" method="post" enctype="multipart/form-data">
        <table style="height:100%" width="100% " align="center">
            <tr>
                <td class="tdLabel" align="right"><label>姓名</label></td>
                <td class="tdValue">
                    <%--隐藏域--%>
                    <input type="hidden" name="id" id="id">
                    <input type="hidden" name="userId" id="userId">
                    <input id="studentName" name="studentName" class="easyui-textbox" type="text"
                           data-options="required:true">
                </td>
                <td class="tdLabel" align="right"><label>毕业学校</label></td>
                <td class="tdValue">
                    <input id="schoolName" name="studentSchool" class="easyui-textbox" type="text">
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
                <td class="tdLabel" align="right"><label>专业</label></td>
                <td class="tdValue">
                    <select id="studentSpecialty" name="studentSpecialty" class="easyui-combobox"
                            style="width:170px;" data-options="panelHeight:'80px'">
                    </select>
                </td>
                <td class="tdLabel" align="right"><label>班级</label></td>
                <td class="tdValue">
                    <select id="classId" name="classId" class="easyui-combotree" style="width:170px;"></select>
                </td>
            </tr>
            <tr>
                <td class="tdLabel" align="right"><label>毕业时间</label></td>
                <td class="tdValue">
                    <input id="graduateTime" name="studentGraduation" type="text" class="easyui-datetimebox"
                           required="required"></input>
                </td>
                <td class="tdLabel" align="right"><label>操行分</label></td>
                <td class="tdValue">
                    <input id="studentConduct" name="studentConduct" class="easyui-textbox" type="text"
                           data-options="required:true"></input>
                </td>
            </tr>
            <tr>
                <td class="tdLabel" align="right">
                    学生编号
                </td>
                <td class="tdValue">
                    <input id="studentIdNumber" name="studentIdNumber" class="easyui-textbox" type="text"
                           data-options="required:true"></input>
                </td>
                <td class="tdLabel" align="right">
                    学历
                </td>
                <td class="tdValue">
                    <select id="studentEducation" name="studentEducation" class="easyui-combobox"
                            style="width:170px;"></select>
                </td>
            </tr>

            <tr>
                <td class="tdLabel" align="right"><label>家长联系方式</label></td>
                <td class="tdValue">
                    <input id="studentFamilyPhone" name="studentFamilyPhone" class="easyui-textbox" type="text"
                           data-options="required:true"></input>
                </td>
                <td class="tdLabel" align="right"><label>本人联系方式</label></td>
                <td class="tdValue">
                    <input id="studentPhone" name="studentPhone" class="easyui-textbox" type="text"
                           data-options="required:true"></input>
                </td>
            </tr>
            <tr>
                <td colspan="4">
                    <img id="pic">
                </td>
            </tr>
            <tr>
                <td colspan="1">
                    照片
                </td>
                <td colspan="3">
                    <input type="hidden" name="studentPicture" id="studentPicture">
                    <input type="file" id="file" name="stuPic" onchange="uploadPic()">
                </td>
            </tr>


            <tr>
                <td class="tdLabel" align="right"><label>性别</label></td>
                <td class="tdValue">
                    <div id="sexDiv">
                    </div>
                </td>
                <td class="tdLabel" align="right"><label>保险是否缴纳</label></td>
                <td class="tdValue">
                    <div id="insuranceDiv">
                    </div>

                </td>

            </tr>
            <tr>
                <td>角色</td>
                <td colspan="3">
                    <div id="roleDiv">

                    </div>
                </td>
            </tr>

            <tr align="center">
                <td colspan="2" class="tdValue">
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