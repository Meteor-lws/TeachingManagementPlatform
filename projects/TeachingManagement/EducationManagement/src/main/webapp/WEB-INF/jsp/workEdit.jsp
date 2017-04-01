<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/workEdit.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>考勤管理</title>
</head>
<body>
<table id="dg" style="width:100%;height:300px"
       data-options="rownumbers:true,singleSelect:true,pagination:true,url:'${pageContext.request.contextPath}/datagrid_data1.json',method:'get',toolbar:'#tb',fit:true">
    <thead>
    <div id="tb" align="center" style="height:40px">
        <div style="margin-top:5px" align="left">
            <label>
                班级
            </label>
            <select id="cc" class="easyui-combotree" style="width:200px;"></select>
            姓名
            <input id="dd" type="text" class="easyui-datebox"></input>
            日期
            <input id="dd" type="text" class="easyui-datebox"></input>
            &nbsp&nbsp&nbsp
            <a href="otherpage.php" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>
        </div>

    </div>


    <%--<div id="w" class="easyui-window" title="教师修改" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:500px;height:450px;padding:10px;">
        <form id="ff" method="post" action="/asa">
    <div align="center" style="padding:5px;">
        <label for="name">班級:</label>   &nbsp &nbsp &nbsp
        <input id="name"   class="easyui-validatebox" data-options="required:true,validType:'email'" />
    </div>
        <div align="center" style="padding:10px;">
        <label for="email">姓名:</label>  &nbsp &nbsp &nbsp
         <input id="name"   class="easyui-validatebox" data-options="required:true,validType:'email'" />
    </div>
    <div align="center" style="padding:10px;">
        <label for="email">性&nbsp&nbsp別:</label> &nbsp &nbsp &nbsp
        <input class="easyui-textbox" type="text" name="name" data-options="required:true"></input>
    </div>
    <div align="center" style="padding:10px;">
        <label for="email">簡&nbsp&nbsp介:</label>  &nbsp &nbsp &nbsp
         <input id="name"   class="easyui-validatebox" data-options="required:true,validType:'email'" />
    </div>
    <div align="center" style="padding:10px;">
        <label for="email">照&nbsp&nbsp片:</label>   &nbsp &nbsp &nbsp
         <input id="name"   class="easyui-validatebox" data-options="required:true,validType:'email'" />
    </div>
    <div align="center" style="padding:10px;">
        <label for="email">專&nbsp&nbsp業:</label>   &nbsp &nbsp &nbsp
         <input id="name"   class="easyui-validatebox" data-options="required:true,validType:'email'" />
    </div>
    <div align="center" style="padding:10px;">
        <label for="email">類&nbsp型:</label>   &nbsp &nbsp &nbsp
         <input id="name"   class="easyui-validatebox" data-options="required:true,validType:'email'" />
    </div>
    <div align="center" style="padding:10px;">
        <label for="email">電&nbsp&nbsp話:</label>   &nbsp &nbsp &nbsp
         <input id="name"   class="easyui-validatebox" data-options="required:true,validType:'email'" />
    </div>
     <div style="text-align:center;padding:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">保存</a>
        &nbsp &nbsp &nbsp
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">清除</a>
    </div>
        </form>

        </div>
        --%>
    <tr>
        <th data-options="field:'itemid',width:80">学号</th>
        <th data-options="field:'productid',width:100">班级</th>
        <th data-options="field:'productid',width:100">姓名</th>
        <th data-options="field:'listprice',width:80,align:'right'">状态</th>
        <th data-options="field:'unitcost',width:80,align:'right'">日期</th>
    </tr>
    </thead>
</table>
</body>
</html>