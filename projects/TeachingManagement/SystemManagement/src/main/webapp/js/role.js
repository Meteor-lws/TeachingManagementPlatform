/**
 * Created by 朱高 on 2017/4/25.
 */
$(function () {
    showTree("treeRole", "findRole", true);
    $("#addRole").click(function () {
        ajax("findPermission", "", function (data) {
            $(".tdPreRoleValue").html('');
            var obj = $.parseJSON(data);
            $.each(obj, function (index, value) {
                $(".tdPreRoleValue").append('<label for=""></label>'+ value.resourceName + '<input id='+value.id+' type="checkbox" name="qx" value='+value.id+'>');
            });

        }, function () {
            $.messager.alert("错误","未知问题导致错误,请联系系统管理员","error");
        });
        $('#roleDialog').dialog({
            title: "班级添加",
            onClose : function () {
                $("#roleDescribe").textbox("clear");
                $("#idCar").textbox("clear");
                $("#roleCodes").textbox("clear");
            }
        });
        $("#roleDialog").dialog('open');
    });
    $("#editRole").click(function () {

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
        parentId: "",
        roleName : $("#idCar").textbox("getValue"),
        roleCode : $("#roleCodes").textbox("getValue"),
        roleDescribe : $("#roleDescribe").textbox("getValue"),
        resourceId : resourceId,
        roleInherit: $("input[name='roleInherit']:checked").val()
    };
    if (parentObj != null){
        data.parentId = parentObj.id
    }
    ajax("addRole", data, function (data) {
        $("#treeRole").tree("reload");
        $.messager.progress("close");
        $.messager.show({
            title:'提示',
            msg:data,
            timeout:5000,
            showType:'slide'
        });
        $("#roleDialog").dialog('close');
    }, "添加角色失败")
}
function showTree(id, url, flag) {
    $("#" + id).tree({
        url: url,
        required: flag,//是否必填
        lines: true,//是否显示虚线
        onBeforeSelect: function (node) {
            console.log(node);
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