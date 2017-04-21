<%--
  Created by IntelliJ IDEA.
  User: lws
  Date: 2017/3/30
  Time: 16:58
  在线考试首页
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    final String path = request.getContextPath();
    final String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="js/problemManagement.js"></script>
    <script type="text/javascript" src="js/ajaxfileupload.js"></script>
    <script charset="utf-8" src="kindeditor/kindeditor.js"></script>
    <script charset="utf-8" src="kindeditor/lang/zh_CN.js"></script>
    <script>
        var editor;
        KindEditor.ready(function (K) {
            editor = K.create('textarea[name="questionContent"]', {
                allowFileManage: true,
                uploadJson: 'kindeditor/jsp/upload_json.jsp',
                fileManagerJson: 'kindeditor/jsp/file_manager_json.jsp',
                afterBlur: function () {
                    this.sync();
                    K.ctrl(document, 13, function () {
                        K('form[name="myForm"]')[0].submit();
                    });
                    K.ctrl(this.edit.doc, 13, function () {
                        K('form[name="myForm"]')[0].submit();
                    });
                }
            });
        });
    </script>
    <title>在线考试</title>
    <base href="<%=basePath%>">
</head>
<body>
<h2>在线考试</h2>
<div id="test" style="background: red">
    <textarea class="easyui-dialog" id="content" name="questionContent" style="width: 800px; height: 400px"></textarea>
</div>
</body>
</html>
