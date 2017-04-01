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
</head>
<body>
<table id="dg" style="width:100%;height:100%"
       data-options="rownumbers:true,toolbar:'#tb',singleSelect:true,pagination:true,url:'${pageContext.request.contextPath}/datagrid_data1.json',method:'get',fitColumns:true,fit:true">
    <thead>
    <div id="tb" align="center" style="height:60px">
        <div align="left" style="margin-top:5px">
            <a id="addTea" href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-add'">添加</a> <a id="editTea"
                                                           href="javascript:void(0)" class="easyui-linkbutton"
                                                           data-options="iconCls:'icon-edit'">修改</a> <a id="removeTea"
                                                                                                        href="javascript:void(0)"
                                                                                                        class="easyui-linkbutton"
                                                                                                        data-options="iconCls:'icon-remove'">删除</a>
            <a id="search"
               href="#" class="easyui-linkbutton"
               data-options="iconCls:'icon-search'">搜索</a>
        </div>
        <div align="left" style="margin-top:5px">
            教师编号 <input id="noSearch" type="text" class="easyui-numberbox"
                        value="100" data-options="min:0,precision:2"></input> 教师姓名 <input
                id="vv" class="easyui-validatebox"/> 入职时间 <input id="dd"
                                                                 type="text" class="easyui-datebox"></input>-- <input
                id="dd"
                type="text" class="easyui-datebox"></input>
        </div>
    </div>
    <tr>
        <th data-options="field:'ck',checkbox:true">是否启用</th>
        <th data-options="field:'itemid'">ID</th>
        <th data-options="field:'itemid'">編號</th>
        <th data-options="field:'productid'">班級</th>
        <th data-options="field:'listprice',align:'right'">教師姓名</th>
        <th data-options="field:'unitcost',align:'right'">性別</th>
        <th data-options="field:'attr1'">簡介</th>
        <th data-options="field:'status',align:'center'">專業</th>
        <th data-options="field:'status',align:'center'">入职时间</th>
        <th data-options="field:'status',align:'center'">類型</th>
        <th data-options="field:'status',align:'center'">電話</th>
    </tr>
    <div id="w" class="easyui-window" title="教师修改"
         data-options="modal:true,closed:true,iconCls:'icon-save'"
         style="width:700px;height:500px;padding:10px;">
        <form id="ff" method="post" action="/asa">
            <div align="center" style="padding:10px">
					<span> <label for="name">班&nbsp级:</label> &nbsp &nbsp &nbsp <input
                            id="name" class="easyui-validatebox"
                            data-options="required:true,validType:'email'"/>&nbsp &nbsp
						&nbsp <label for="email">姓&nbsp名:</label> &nbsp &nbsp &nbsp <input
                                id="name" class="easyui-validatebox"
                                data-options="required:true,validType:'email'"/> </span>
            </div>
            <div align="center" style="padding:10px;">
					<span>
					<label for="email">专&nbsp业:</label> &nbsp &nbsp &nbsp <input
                            id="name" class="easyui-validatebox"
                            data-options="required:true,validType:'email'"/>
							 &nbsp &nbsp 
							<label for="email">电&nbsp话:</label> &nbsp &nbsp &nbsp <input
                            id="name" class="easyui-validatebox"
                            data-options="required:true,validType:'email'"/>
					</span>
            </div>

            <div align="center" style="padding:10px;">
                <label for="email">類&nbsp型:</label> &nbsp &nbsp &nbsp <input
                    id="name" class="easyui-validatebox"
                    data-options="required:true,validType:'email'"/>
                &nbsp &nbsp&nbsp
                <label for="email">性&nbsp&nbsp別:</label> &nbsp &nbsp <label><input
                    name="gander" type="radio" value="1"/>男 </label> &nbsp &nbsp &nbsp &nbsp&nbsp&nbsp<label><input
                    name="gander" type="radio" value="0"/>女 </label>&nbsp &nbsp
                &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp &nbsp&nbsp &nbsp &nbsp
            </div>

            <div align="center" style="padding:10px;">
					<span>
						<span><div align="center"><label for="email">照&nbsp&nbsp片:</label></div></span> &nbsp &nbsp &nbsp
						<span><div align="center"><img alt="jiaoshi"
                                                       src="${pageContext.request.contextPath}/js.jpg"></div></span>
							&nbsp &nbsp &nbsp
					</span>
            </div>

            <div align="center" style="padding:10px;">
                <label for="email">简&nbsp&nbsp介:</label> &nbsp &nbsp &nbsp <input
                    class="easyui-textbox" data-options="multiline:true" value=""
                    style="width:300px;height:100px">
            </div>
            <div style="text-align:center;padding:5px">
                <a href="javascript:void(0)" class="easyui-linkbutton"
                   data-options="iconCls:'icon-add'" onclick="submitForm()">保存</a>
                &nbsp &nbsp &nbsp <a href="javascript:void(0)"
                                     class="easyui-linkbutton" data-options="iconCls:'icon-cancel'"
                                     onclick="cancel()">取消</a>
            </div>
        </form>
    </div>
    </thead>
</table>
<script type="text/javascript">
    $(function () {

        var rowValue;
        $('#dg').datagrid({
            onDblClickCell: function (index, field, value) {
                $('#w').window('open');
                $("#name").val(rowValue.itemid);

            },
            onSelect: function (rowIndex, rowData) {
                rowValue = rowData;
            }
        });
    });
    function clearForm() {
        $("input").each(function () {
            $(this).val("");
        });
    }
    function submitForm() {
        $.messager.progress(); // 显示进度条
        $('#ff').form('submit', {
            url: "/asada",
            onSubmit: function () {
                var isValid = $(this).form('validate');
                if (!isValid) {
                    $.messager.progress('close'); // 如果表单是无效的则隐藏进度条
                }
                return isValid; // 返回false终止表单提交
            },
            success: function () {
                $.messager.progress("close"); // 如果提交成功则隐藏进度条
                $("#w").window("close")
            }
        });

    }
    function cancel() {
        $("#w").window("close");
    }
</script>
<script type="text/javascript">
    $(function () {
        var pager = $('#dg').datagrid().datagrid('getPager'); // get the pager of datagrid
        $("#addTea").click(function () {
            $('#w').window({
                title: "学生添加"
            });
            $("#w").window('open');
        });
        $("#editTea").click(function () {

            var selects = $("#dg").datagrid("getSelections");
            if (selects.length == 0) {
                $.messager.alert('警告', '请选择一个需要修改的列');
                return;
            }
            if (selects.length > 1) {
                $.messager.alert('警告', '请勿选择多个');

            }

            else {
                $('#w').window({
                    title: "学生修改"
                });
                $("#w").window('open');
                var selectRow = selects[0]

            }
        });

        $("#removeTea").click(function () {
            var selects = $("#dg").datagrid("getSelections");
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
            $('#dg').datagrid('load', {
                'no': no
            });
        });

    })
</script>
</body>