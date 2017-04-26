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
        parentId : null,
        roleName : $("#idCar").textbox("getValue"),
        roleCode : $("#roleCodes").textbox("getValue"),
        roleDescribe : $("#roleDescribe").textbox("getValue"),
        resourceId : resourceId,
        roleInherit : $("input[name='roleInherit']:checkbox").val()
    };
    if (parentObj != null){
        data.parentId = parentObj.id
    }
    ajax("addRole", data, function (data) {
        $.messager.progress("close");
        $.messager.show({
            title:'提示',
            msg:data,
            timeout:5000,
            showType:'slide'
        });

    }, "添加角色失败")
}
function showTree(id, url, flag) {
    $("#" + id).tree({
        url: url,
        required: flag,//是否必填
        lines: true,//是否显示虚线
        onlyLeafCheck: flag,//只能选取叶子结点
        //不为叶子节点不让选上
        onBeforeSelect: function (node) {
            //node.target代表的是选取的结点
            //node代表整个结点对象
            if (!$(this).tree('isLeaf', node.target)) {
                return !flag;
            }
        },
        onClick: function (node) {
            if (flag) {
                if (!$(this).tree('isLeaf', node.target)) {
                    //idObject.combo('showPanel');
                }
            }
        },
        onLoadSuccess: function (node, data) {
            var _this = this;
            if (data) {
                $(data).each(function () {
                    if (this.state === 'closed') {
                        $(_this).tree('expandAll');
                    }
                });
            }
        }
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