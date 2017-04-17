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
     data-options="modal:true,closed:true,iconCls:'icon-save',closable:false"
     style="width:700px;height:600px;padding:10px;">
    <form id="teaForm" method="post" action="/asa" enctype="multipart/form-data">
        <table style="height:100%" width="100% " align="center">
            <tr>
                <input type="hidden" name="teacherId" id="teaId">
                <td class="tdLabel" align="right"><label>姓名</label></td>
                <td class="tdValue">
                    <input id="teacherNameForm" name="teacherName" class="easyui-textbox" type="text"
                           data-options="required:true">

                </td>
                <td class="tdLabel" align="right"><label>类型</label></td>
                <td class="tdValue">
                    <select id="teacherTypeForm" name="teacherType" class="easyui-combotree"
                            style="width:170px;"></select>
                </td>
            </tr>
            <tr>
                <td class="tdLabel" align="right"><label>专业</label></td>
                <td class="tdValue"><select id="teacherSpecialityForm" name="teacherSpeciality" class="easyui-combotree"
                                            style="width:170px;"></select>
                </td>
                <td class="tdLabel" align="right"><label>手机</label></td>
                <td class="tdValue"><input class="easyui-textbox" id="teacherPhone" type="text" name="teacherPhone"
                                           data-options="required:true">
                </td>
            </tr>
            <tr>
                <td class="tdLabel" align="right" colspan="2"><label>性别</label></td>
                <td class="tdValue" colspan="2">
                    <div id="sex">
                    </div>
                </td>
            </tr>
            <tr>
                <td colspan="1" style="width: 100px ;height: 50px" align="left"><label>照片</label></td>
                <td colspan="3" style="width: 100px ;height: 50px" align="left">
                    <img alt="jiaoshi" id="pic" src="${pageContext.request.contextPath}/js.jpg">
                    <input id="teacherPicture" type="hidden" name="teacherPicture"/>
                </td>
            </tr>
            <tr>
                <td colspan="1" style="width: 100px ;height: 50px" align="left"><label>上传</label></td>
                <td colspan="3" style="width: 100px ;height: 50px" align="left">
                    <input id="teacherPicForm" type="file" name="teapic" onchange="showPic()">
                </td>
            </tr>

            <tr>
                <td colspan="1" style="width: 100px ;height: 50px" align="right"><label>简介</label></td>
                <td colspan="3" style="width: 100px ;height: 50px">
                    <input id="teacherIntroductionForm" name="teacherIntroduction" class="easyui-textbox"
                           data-options="multiline:true" value=""
                           style="width:300px;height:100px">
                </td>
            </tr>
            <tr>
                <td colspan="1">角色</td>
                <td colspan="3">
                    <div id="roleDiv"></div>
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