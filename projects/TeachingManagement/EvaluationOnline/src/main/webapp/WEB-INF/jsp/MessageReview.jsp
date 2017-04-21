<%--
  Created by IntelliJ IDEA.
  User: lws
  Date: 2017/4/19
  Time: 16:58
  留言审核页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    final String path = request.getContextPath();
    final String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>留言审核</title>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="easyui/themes/default/easyui.css"/>
    <link rel="stylesheet" href="easyui/themes/icon.css"/>
    <script src="easyui/jquery.min.js"></script>
    <script src="easyui/jquery.easyui.min.js"></script>
    <script src="easyui/locale/easyui-lang-zh_CN.js"></script>
    <script src="js/MessageReview.js"></script>
</head>
<body>
<div id="message-data"></div>
<div id="message-tool">
    <table>
        <tr>
            <td>
                <label for="message-search-status" style="font-size: 8px;margin-left: 10px">留言状态：</label>
                <select id="message-search-status" style="width: 100px;height: 24px"></select>
                <label for="message-search-time" style="font-size: 8px">留言日期：</label>
                <input id="message-search-time" type="text" class="easyui-datebox">
                <label for="message-search-content" style="font-size: 8px;margin-left: 10px">留言内容：</label>
                <input id="message-search-content" class="message-search" style="width:200px">
                <label for="message-search-from" style="font-size: 8px;margin-left: 10px">留言人：</label>
                <input id="message-search-from" class="message-search" style="width:110px">
                <label for="message-search-to" style="font-size: 8px;margin-left: 10px">留言对象：</label>
                <input id="message-search-to" class="message-search" style="width:110px">
            </td>
            <td>
                <a id="message-pass" class="easyui-linkbutton"
                   data-options="width:80,plain:true,iconCls:'icon-ok'">审核通过</a>
                <a id="message-fail" class="easyui-linkbutton"
                   data-options="width:80,plain:true,iconCls:'icon-no'">审核失败</a>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
