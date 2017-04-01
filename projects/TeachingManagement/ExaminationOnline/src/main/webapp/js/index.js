$(function () {
    $("#login").dialog({
        title: "登陆后台",
        width: 300,
        height: 180,
        model: true,
    });

    $("#manager").validatebox({
        required: true,
        missingMessage: "请输入用户账号",
    });

    $("#password").validatebox({
        required: true,
        validType: 'length[6,30]',
        missingMessage: "请输入用户密码",
    });
    if (!$("#manager").validatebox("isValid")) {
        $("#manager").focus();
    } else if (!$("#password").validatebox("isValid")) {
        $("#password").focus();
    }
    $("a").click(function () {
            if (!$("#manager").validatebox("isValid")) {
                $("#manager").focus();
            } else if (!$("#password").validatebox("isValid")) {

                alert($("#password").val().length);
                $("#password").focus();

            } else {
                $.ajax({
                    url: "tree",
                    type: "post",
                    data: {
                        manager: $("#manager").val(),
                        password: $("#password").val(),
                    },
                    /*beforeSend : $.messager.progress({
                     title : "hh",
                     }),*/
                    success: function (data, response, state) {
                        if (data == "0") {
                            location.href = "main.jsp";
                        } else {
                            /*
                             $.messager.alert()类似js中的alert('String')
                             　　方法参数：title, msg, icon, function(回调函数)
                             　　描述：title头部面板标题、msg主要消息内容、icon：消息图标，可用值有(error,question,info,warning)、function回调函数
                             */
                            $.messager.alert("登录失败", ",账号或者用户名输入错误", function () {
                                $("#password").select();
                            });
                        }
                    }
                });
            }
        }
    )
});








