/**
 * Created by XuMing on 2017/4/1.
 */

$(function () {
    var teachingType ;
    var rowValue;
    var roleList;//教师角色列表

    $.ajax({
        url: '/education/getSexRadion',
        type: 'post',
        success: function (data) {
            var list = $.parseJSON(data);
            var sexDiv = $("#sex");
            var content = "";
            for (var i = 0; i < list.length; i++) {
                content += "<input type='radio' name='teacherSex' value=" + list[i].id + ">" + list[i].dictionaryName;
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
            $("#teacherNameForm").textbox("setValue", row.teacherName);
            $("#teacherTypeForm").combobox("select", row.teacherType);
            $("#teacherSpecialityForm").combobox("select", row.teacherSpeciality);
            $("#teacherPhoneForm").textbox("setValue", row.teacherPhone);
            $("#teacherIntroductionForm").textbox("setValue", row.teacherIntroduction);
            var roles = row.roles;
            var content = "";
            for (var i = 0; i < roleList.length; i++) {
                for (var l = 0; l < roles.length; l++) {
                    if (roleList[i].id == roles[l].roleId) {
                        content += "<input type='checkbox' name='role' checked='checked' value='" + roleList[i].id + "'>" + roleList[i].roleName + "</input>";
                    }
                    else {
                        content += "<input type='checkbox' name='role'  value='" + roleList[i].id + "'>" + roleList[i].roleName + "</input>";
                    }

                }

            }
            $("#roleDiv").html(content);
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
        var content = "";
        for (var i = 0; i < roleList.length; i++) {
            content += "<input type='checkbox' name='role'  value='" + roleList[i].id + "'>" + roleList[i].roleName + "</input>";
        }
        $("#roleDiv").html(content);



    });
    //修改
    $("#editTea").click(function () {

        var selects = $("#teaDg").datagrid("getSelections");
        if (selects.length == 0) {
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
            var content = "";
            for (var i = 0; i < roleList.length; i++) {
                for (var l = 0; l < roles.length; l++) {
                    if (roleList[i].id == roles[l].roleId) {
                        content += "<input type='checkbox' name='role' checked='checked' value='" + roleList[i].id + "'>" + roleList[i].roleName + "</input>";
                    }
                    else {
                        content += "<input type='checkbox' name='role'  value='" + roleList[i].id + "'>" + roleList[i].roleName + "</input>";
                    }

                }
            }
            //数据的回写
            $("#roleDiv").html(content);
            $("#teaId").val(selRow.id);
            $("#teacherNameForm").textbox("setValue", selRow.teacherName);
            $("#teacherTypeForm").combobox("select", selRow.teacherType);
            $("#teacherSpecialityForm").combobox("select", selRow.teacherSpeciality);
            $("#teacherPhoneForm").textbox("setValue", selRow.teacherPhone);
            $("#teacherIntroductionForm").textbox("setValue", selRow.teacherIntroduction);

        }
    });
//删除
    $("#removeTea").click(function () {
        var selects = $("#teaDg").datagrid("getSelections");
        if (selects.length == 0) {
            $.messager.alert('警告', '请选择一个需要修改的列');
        } else {
            $.messager.confirm('确认', '您确认想要这些记录吗？', function (choose) {
                if (choose) {
                    $.messager.alert('提示', '删除成功');
                }
            });

        }

    });
    $("#search").click(function () {
        var no = $("#noSearch").val();
        $('#teaDg').datagrid('load', {
            'no': no
        });
    });

    $('#teaDg').datagrid({
        url: '/education/teacherSelect',
        fitColumns: false,
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
            {field: 'teacherSex', title: '性别', width: 100},
            {field: 'teacherType', title: '类型', width: 100},
            {field: 'teacherSpeciality', title: '专业', width: 100},
            {field: 'teacherPhone', title: '手机', width: 100},
            {field: 'productid', title: '入职时间', width: 200}
        ]],
        toolbar: '#teaTb'
    });

    $("#selectTea").click(function()
    {

        var id = $("#teacherNo").val();//教师id
        var teacherName = $("#teacherName").val();//教师姓名
        $('#teaDg').datagrid('load', {
            id: id,
            teacherName: teacherName,
            teacherType: teachingType
        });
    });


});

function submitForm() {
    $.messager.progress(); // 显示进度条
    $('#teaForm').form('submit', {
        url: "/education/saveOrUpdate",
        onSubmit: function () {
            var isValid = $(this).form('validate');
            if (!isValid) {
                $.messager.progress('close'); // 如果表单是无效的则隐藏进度条
            }
            return isValid; // 返回false终止表单提交
        },
        success: function () {
            $.messager.progress("close"); // 如果提交成功则隐藏进度条
            $("#teaForm").form("clear");//清除表单内容
            $("#pic").attr("src", "");
            $("#teaDg").datagrid("reload");
            $("#teaDialog").dialog("close")
        }
    });

}
function cancel() {
    $("#teaDialog").dialog("close");
    $("#teaForm").form("clear");
}

function showPic() {
    var uploadPath = "http://localhost:8081/Upload/";//文件服务器路径
    var formData = new FormData($("#teaForm")[0]);
    $.ajax({
        url: '/education/getUpLoadPath',
        type: 'POST',
        data: formData,
        async: false,
        cache: false,
        contentType: false,
        processData: false,
        success: function (returndata) {
            $("#pic").attr("src", uploadPath + returndata);
            $("#teacherPicture").val(returndata);
        },
        error: function (returndata) {
        }
    });
}
