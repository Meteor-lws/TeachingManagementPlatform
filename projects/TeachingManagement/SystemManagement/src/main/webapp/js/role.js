/**
 * Created by 朱高 on 2017/4/25.
 */
$(function () {
    showTree("treeRole", "findRole", true);
    $("#addRole").click(function () {
        showCheckBox();
        showDialog("添加角色");
    });
    $("#editRole").click(function () {
        var parentObj = $("#treeRole").tree("getSelected");
        if (parentObj != null) {
            showDialog("修改角色信息");
            showCheckBox();

            var data = {
                id: parentObj.id
            };
            ajax("findRoleDetails", data, function (data) {
                var obj = $.parseJSON(data);
                console.log(obj);
                $("#roleCodes").textbox("setValue", obj[0].roleCode);
                if (obj[0] !== undefined) {
                    $("#roleDescribe").textbox("setValue", obj[0].roleDescribe);
                }
                $("#" + obj[0].roleInherit).attr("checked", true);
                $.each(obj, function (index, value) {
                    $("#" + value.id).attr("checked", true);
                })
            }, "查询失败");
            console.log(parentObj);
            $("#idCar").textbox("setValue", parentObj.text);
        } else {
            alert("为选择修改对象");
        }
    });
    $("#removeRole").click(function () {
        var parentObj = $("#treeRole").tree("getSelected");
        var resObj = $("#dictionary-detail").datagrid("getChecked");
        if (parentObj !== null && resObj.length === 0) {
            $.messager.confirm("删除确认对话窗", "您确定要删除" + parentObj.text + "这个角色？", function (flag) {
                if (flag) {
                    $.messager.progress();
                    var data = {
                        id: parentObj.id
                    };
                    ajax("deleteRole", data, function (data) {
                        $.messager.progress("close");
                        $.messager.show({
                            title: '提示',
                            msg: data,
                            timeout: 5000,
                            showType: 'slide'
                        });
                        $("#treeRole").tree("reload");
                    }, "删除角色失败")
                }
            })
        } else if (parentObj !== null && resObj.length > 0) {
            $.messager.confirm("删除确认对话窗", "您确定要删除这些资源吗？", function (flag) {
                if (flag) {
                    $.messager.progress();
                    var ids = "";
                    for (var i = 0; i < resObj.length; i++) {
                        if (i === resObj.length - 1) {
                            ids = ids + resObj[i].id;
                        } else {
                            ids = ids + resObj[i].id + ",";
                        }
                    }
                    var data = {
                        roleId: parentObj.id,
                        resId: ids
                    };
                    ajax("deleteResource", data, function () {
                        $.messager.progress("close");
                        $.messager.show({
                            title: '提示',
                            msg: data,
                            timeout: 5000,
                            showType: 'slide'
                        });
                        $("#dictionary-detail").datagrid("load");
                    }, "删除资源失败")
                }
            });
        } else {
            alert("还未选择删除对象");
        }
    });
    prepareDatagrid();
});
function submitForm() {
    $.messager.progress();
    var title = $('#roleDialog').panel('options').title;
    console.log(title);
    var url = "";
    var parentObj = $("#treeRole").tree("getSelected");
    var resourceObj = $("input[name='qx']:checked");
    var resourceId = "";
    for (var i = 0; i < resourceObj.length; i++) {
        if (i === resourceObj.length - 1) {
            resourceId = resourceId + resourceObj[i].id;
        } else {
            resourceId = resourceId + resourceObj[i].id + ",";
        }
    }
    var data = {
        roleName : $("#idCar").textbox("getValue"),
        roleCode : $("#roleCodes").textbox("getValue"),
        roleDescribe : $("#roleDescribe").textbox("getValue"),
        resourceId : resourceId,
        roleInherit: $("input[name='roleInherit']:checked").val()
    };
    var text;
    if ("添加角色" === title) {
        url = "addRole";
        text = "添加角色失败";
        if (parentObj != null) {
            data.parentId = parentObj.id
        }
    } else {
        url = "updateRole";
        data.id = parentObj.id;
        text = "修改角色信息失败";
    }
    console.log(data);
    ajax(url, data, function (data) {
        $("#treeRole").tree("reload");
        $.messager.progress("close");
        $.messager.show({
            title:'提示',
            msg:data,
            timeout:5000,
            showType:'slide'
        });
        $("#roleDialog").dialog('close');
    }, text)
}
function showTree(id, url, flag) {
    $("#" + id).tree({
        url: url,
        required: flag,//是否必填
        lines: true,//是否显示虚线
        onBeforeSelect: function (node) {
            $('#dictionary-detail').datagrid({
                url: 'findRoleDetails',
                queryParams: {
                    id: node.id
                }
            });
        }
        /*onSelect : function (node) {
         console.log(node);
         }*/
    })
}
function ajax(url, data, success, error) {
    $.ajax({
        type: 'post',
        url: url,
        data: data,
        beforeSend: function () {
            $('<div class="datagrid-mask"></div>').css({display: 'block', width: '100%', height: $(window).height()}).appendTo('body');
            $('<div class="datagrid-mask-msg"></div>').html('正在处理，请稍候。。。').appendTo('body').css({display: 'block', left: ($(document.body).outerWidth - 190) / 2, top: ($(window).height() - 45) / 2});
        },
        success: function (data) {
            success(data);
        },
        error: function () {
            $.messager.alert('错误', error, 'error');
        },
        complete: function () {
            $('.datagrid-mask').remove();
            $('.datagrid-mask-msg').remove();
        }
    });
}
function clearForm() {
    $("#roleDialog").dialog('close');
}
function prepareDatagrid() {
    $('#dictionary-detail').datagrid({
        url: 'getDictionaries',
        fit: true,
        fitColumns: true,
        striped: true,
        remoteSort: false,
        rownumbers: true,
        pagination: true,
        pageSize: 25,
        pageList: [10, 15, 20, 25, 30],
        pageNumber: 1,
        columns: [[
            {field: 'id', checkbox: true},
            {field: 'resourceName', title: '资源名', width: 40},
            {field: 'resVisibleName', title: '是否显示', width: 20, sortable: true},
            {field: 'resEnableName', title: '是否启用', width: 40, sortable: true},
            {field: 'resourceDescribe', title: '资源描述', width: 60}
        ]]
    });
}
function showDialog(title) {
    $('#roleDialog').dialog({
        title: title,
        onClose: function () {
            $("#roleDescribe").textbox("clear");
            $("#idCar").textbox("clear");
            $("#roleCodes").textbox("clear");
        }
    });
    $("#roleDialog").dialog('open');
}
function showCheckBox() {
    ajax("findPermission", "", function (data) {
        $(".tdPreRoleValue").html('');
        var obj = $.parseJSON(data);
        $.each(obj, function (index, value) {
            $(".tdPreRoleValue").append('<label for=""></label>' + value.resourceName + '<input id=' + value.id + ' type="checkbox" name="qx" value=' + value.id + '>');
        });

    }, function () {
        $.messager.alert("错误", "未知问题导致错误,请联系系统管理员", "error");
    });
}