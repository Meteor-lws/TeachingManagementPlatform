/**
 * Created by XuMing on 2017/4/1.
 */

$(function () {
    var teachingType ;
    var rowValue;
    var roleList;//教师角色列表
    var uploadPath = "http://localhost:8081/Upload/";

    $.ajax({
        url: '/education/getSexRadion',
        type: 'post',
        success: function (data) {
            var list = $.parseJSON(data);
            var sexDiv = $("#sex");
            var content = "";
            for (var i = 0; i < list.length; i++) {
                content += "<input type='radio' id='" + list[i].id + "' name='teacherSex' value=" + list[i].id + ">" + list[i].dictionaryName;
            }
            sexDiv.html(content);

        }
    });

    /**
     * 获取所有教师的角色
     */
    $.ajax({
        url: "/education/getTeacherRole",
        async: false,
        success: function (data) {
            var content = "";
            roleList = $.parseJSON(data);
        }


    });

    /**
     * 职教类型
     */
    $('#teachingType').combobox({
        url:'/education/teachingTypeList',
        valueField:'id',
        textField:'dictionaryName',
        onSelect:function (sel) {
            teachingType = sel.id;
        }
    });

    $('#teacherTypeForm').combobox({
        url: '/education/teachingTypeList',
        valueField: 'id',
        textField: 'dictionaryName',
        onSelect: function (sel) {
            teachingType = sel.id;
        }
    });


    $('#teacherSpecialityForm').combobox({
        url: '/education/getTeacherSpeciality',
        valueField: 'id',
        textField: 'dictionaryName'
    });


    $('#teaDg').datagrid({
        onDblClickRow: function (index, row) {
            //数据的回写
            $('#teaDialog').window('open');
            $("#teaId").val(row.id);
            $("#userId").val(row.userId);
            $("#teacherNameForm").textbox("setValue", row.teacherName);
            $("#teacherTypeForm").combobox("select", row.teacherType);
            $("#teacherSpecialityForm").combobox("select", row.teacherSpeciality);
            $("#teacherPhoneForm").textbox("setValue", row.teacherPhone);
            $("#pic").attr("src", uploadPath + row.teacherPicture);
            $("#teacherPicture").val(row.teacherPicture);
            $("#teacherIntroductionForm").textbox("setValue", row.teacherIntroduction);
            $("#teacherNumber").textbox("setValue", row.teacherNumber);
            var teacherSex = row.teacherSex;
            $("#" + teacherSex).attr("checked", "checked");

            $.ajax({
                url: "/education/getTeacherInfo",
                data: {"userId": row.userId},
                success: function (data) {
                    var teacherRole = $.parseJSON(data);
                    var roles = [];
                    //将教师高喊的角色的ID存入数组
                    for (var i = 0; i < teacherRole.length; i++) {
                        roles[i] = teacherRole[i].id;
                    }
                    var content = "";
                    //教师角色复选框的回写
                    for (var i = 0; i < roleList.length; i++) {
                        if (roles.indexOf(roleList[i].id) !== -1) {
                            content += "<input type='checkbox' name='role' checked='checked' value='" + roleList[i].id + "'>" + roleList[i].roleName + "</input>";
                        }
                        else {
                            content += "<input type='checkbox' name='role'  value='" + roleList[i].id + "'>" + roleList[i].roleName + "</input>";
                        }
                    }
                    $("#roleDiv").html(content);
                }
            });
        },
        onSelect: function (rowIndex, rowData) {
            rowValue = rowData;
        }
    });
    var pager = $('#teaDg').datagrid().datagrid('getPager'); // get the pager of datagrid
    $("#addTea").click(function () {
        $('#teaDialog').dialog({
            title: "添加老师"
        });
        $("#teaDialog").dialog('open');
        $("#pic").attr("src", "");
        var content = "";
        for (var i = 0; i < roleList.length; i++) {
            content += "<input type='checkbox' name='role'  value='" + roleList[i].id + "'>" + roleList[i].roleName + "</input>";
        }
        $("#roleDiv").html(content);



    });
    //修改
    $("#editTea").click(function () {
        var selects = $("#teaDg").datagrid("getSelections");
        if (selects.length === 0) {
            $.messager.alert('警告', '请选择一个需要修改的列');
            return;
        }
        if (selects.length > 1) {
            $.messager.alert('警告', '请勿选择多个');
        }

        else {
            $('#teaDialog').dialog({
                title: "学生修改"
            });
            $("#teaDialog").dialog('open');
            var selRow = $('#teaDg').datagrid('getSelected');//选中行
            var roles = selRow.roles;
            //隐藏域赋值
            $("#teaid").val(selRow.id);
            $("#teacherPicture").val(selRow.teacherPicture);
            $("#userId").val(selRow.userId);
            var teacherSex = selRow.teacherSex;
            $("#" + teacherSex).attr("checked", "checked");
            $.ajax({
                url: "/education/getTeacherInfo",
                data: {"userId": selRow.userId},
                success: function (data) {
                    var teacherRole = $.parseJSON(data);
                    var roles = [];
                    //将教师高喊的角色的ID存入数组
                    for (var i = 0; i < teacherRole.length; i++) {
                        roles[i] = teacherRole[i].id;
                    }
                    var content = "";
                    //教师角色复选框的回写
                    for (var i = 0; i < roleList.length; i++) {
                        if (roles.indexOf(roleList[i].id) !== -1) {
                            content += "<input type='checkbox' name='role' checked='checked' value='" + roleList[i].id + "'>" + roleList[i].roleName + "</input>";
                        }
                        else {
                            content += "<input type='checkbox' name='role'  value='" + roleList[i].id + "'>" + roleList[i].roleName + "</input>";
                        }
                    }
                    $("#roleDiv").html(content);
                }
            });
            //数据的回写
            $("#teaId").val(selRow.id);
            $("#pic").attr("src", uploadPath + selRow.teacherPicture);
            $("#teacherNameForm").textbox("setValue", selRow.teacherName);
            $("#teacherTypeForm").combobox("select", selRow.teacherType);
            $("#teacherSpecialityForm").combobox("select", selRow.teacherSpeciality);
            $("#teacherPhoneForm").textbox("setValue", selRow.teacherPhone);
            $("#teacherIntroductionForm").textbox("setValue", selRow.teacherIntroduction);
            $("#teacherName").textbox("setValue", selRow.teacherNumber);
        }
    });
//删除
    $("#removeTea").click(function () {
        var selects = $("#teaDg").datagrid("getSelections");
        if (selects.length === 0) {
            $.messager.alert('警告', '请选择一个需要删除的列');
        } else {
            $.messager.confirm('确认', '您确认想要删除这些记录吗？', function (choose) {
                var teacherIds = [];
                var userIds = [];
                if (choose) {
                    for (var i = 0; i < selects.length; i++) {
                        teacherIds[i] = selects[i].id;
                        userIds[i] = selects[i].userId;
                    }
                    $.ajax({
                        url: "/education/deleteTeacher",
                        datatype: "json",
                        data: {
                            "teacherIds": JSON.stringify(teacherIds),
                            "userIds": JSON.stringify(userIds)
                        },
                        type: "post",
                        success: function (data) {
                            $("#teaDg").datagrid("reload");
                        }

                    })

                }
            });

        }

    });

    $('#teaDg').datagrid({
        url: '/education/teacherSelect',
        fitColumns: true,
        fit: true,
        striped: true,
        rownumbers: true,
        border: false,
        pagination: true,
        pageSize: 20,
        pageNumber: 1,
        columns: [[
            {field: 'id', itemid: 'ID', checkbox: true, width: 1000},
            {field: 'teacherName', title: '姓名', width: 10, width: 100},
            {field: 'teacherSexView', title: '性别', width: 100},
            {field: 'teacherTypeView', title: '类型', width: 100},
            {field: 'teacherSpecialityView', title: '专业', width: 100},
            {field: 'teacherPhone', title: '手机', width: 100},
        ]],
        queryParams: {
            id: $("#teacherNo").val(),
            teacherName: $("teacherName").val(),
            teacherType: teachingType
        },
        toolbar: '#teaTb'
    });

    $("#selectTea").click(function()
    {
        alert($("#teacherName").textbox("getValue"));
        var id = $("#teacherNo").val();//教师id
        var teacherName = $("#teacherName").val();//教师姓名
        $('#teaDg').datagrid('load', {
            id: id,
            teacherName:$("#teacherName").textbox("getValue"),
            teacherType: teachingType
        });
    });


});

function submitForm() {
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
function cancel() {
    $('#teaDialog').dialog('close');
    $('#teaForm').form('clear');
    $('#pic').attr('src', '');
}

function showPic() {
    var uploadPath = "http://localhost:8081/Upload/";//文件服务器路径
    var formData = new FormData($("#teaForm")[0]);
    $.ajax({
        url: '/education/UpLoadStudentPic',
        type: 'POST',
        data: formData,
        async: false,
        cache: false,
        contentType: false,
        processData: false,
        success: function (returndata) {
            $("#pic").attr("src", uploadPath + returndata);
            $("#teacherPicture").val(returndata);
        }
    });

}
