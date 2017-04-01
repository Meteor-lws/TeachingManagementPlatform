<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="http://libs.baidu.com/jquery/1.6.4/jquery.min.js"></script>
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
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/studentEdit.js" charset="utf-8">

    </script>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        body {
            padding: 20px;
            font: 12px "微软雅黑";
            background: #FFF;
        }

        ul li {
            list-style: none;
        }

        #schoolName {
            width: 170px;
        }

        .provinceSchool {
            display: none;
            position: absolute;
            width: 580px;
            height: 310px;
            border: 1px solid #72B9D7;
        }

        .title span {
            margin-left: 10px;
            font-weight: 600;
            color: #FFF;
            line-height: 30px;
        }

        .proSelect {
            width: 550px;
            height: 22px;
            margin: 10px 0 6px 20px;
        }

        .proSelect select {
            width: 136px;
        }

        .proSelect input {
            display: none;
        }

        .schoolList {
            width: 550px;
            height: 200px;
            margin-left: 20px;
            overflow-y: auto;
            border: 1px solid #72B9D7;
        }

        .schoolList ul {
            width: 510px;
        }

        .schoolList ul li {
            float: left;
            width: 158px;
            height: 22px;
            margin-left: 6px;
            padding-left: 6px;
            line-height: 22px;
            cursor: pointer;
        }

        .schoolList ul li.DoubleWidthLi {
            width: 328px;
        }

        .schoolList ul li:hover {
            background: #72B9D7;
        }

        .button {
            width: 100%;
            height: 40px;
            margin-top: 8px;
        }

    </style>
</head>
<body>
<table id="dg" style="width:100%;height:100%"
       data-options="rownumbers:true,singleSelect:false,pagination:true,url:'${pageContext.request.contextPath}/list.json',method:'get',fitColumns:true,fit:true,toolbar:'#tb'">
    <thead>

    <div id="tb" align="center" style="height:80px">
        <div align="left" style="margin-top:5px">
            <a id="addStu" href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-add'">添加</a> <a id="editStu"
                                                           href="javascript:void(0)" class="easyui-linkbutton"
                                                           data-options="iconCls:'icon-edit'">修改</a> <a id="removeStu"
                                                                                                        href="javascript:void(0)"
                                                                                                        class="easyui-linkbutton"
                                                                                                        data-options="iconCls:'icon-remove'">删除</a>
            <a id="search"
               href="#" class="easyui-linkbutton"
               data-options="iconCls:'icon-search'">搜索</a>
        </div>
        <div align="left" style="margin-top:5px">
            学生编号 <input name="stuNo" type="text" class="easyui-numberbox"
                        value="100" data-options="min:0,precision:2"></input> 学生姓名 <input
                id="stuName" class="easyui-validatebox" name="stuName"/> 入学时间 <input
                id="entranceTime" name="entranceTime" type="text"
                class="easyui-datebox"></input> &nbsp &nbsp班&nbsp &nbsp&nbsp级 <select
                id="classes" class="easyui-combotree" style="width:170px;"></select>
            毕业时间 <input id="graduationTime" type="text" class="easyui-datebox"></input>
        </div>
    </div>
    <span></span>


    <tr>
        <th data-options="field:'ck',checkbox:true">是否启用</th>
        <th data-options="field:'classId'">学号</th>
        <th data-options="field:'productid'">姓名</th>
        <th data-options="field:'unitcost',align:'right'">性別</th>
        <th data-options="field:'listprice',align:'right'">班级</th>
        <th data-options="field:'education',align:'right'">学历</th>
        <th data-options="field:'listprice',align:'right'">专业</th>
        <th data-options="field:'idCar',align:'right'">身份证号码</th>
        <th data-options="field:'score',align:'right'">操行分</th>
        <th data-options="field:'graduateSchool',align:'right'">毕业学校</th>
        <th data-options="field:'graduteTime',align:'right'">毕业时间</th>
        <th data-options="field:'insurance',align:'center'">保险是否缴纳</th>
        <th data-options="field:'studentContact',align:'center'">本人联系方式</th>
        <th data-options="field:'parentContact',align:'center'">家长联系方式</th>
        <th data-options="field:'status',align:'center'">状态</th>
    </tr>
    <div id="w" class="easyui-window" title="学生修改"
         data-options="modal:true,closed:true,iconCls:'icon-save'"
         style="width:700px;height:500px;padding:10px;">
        <form id="ff" method="post" action="/asa">
            <div align="center" style="padding:5px;">
						<span>&nbsp <label for="name">姓名:</label> &nbsp &nbsp &nbsp
							&nbsp &nbsp &nbsp <input id="name" class="easyui-validatebox"
                                                     data-options="required:true"/> &nbsp &nbsp
							&nbsp &nbsp &nbsp &nbsp<label for="email">毕业学校:</label> &nbsp &nbsp &nbsp <input
                                    type="text" id="schoolName" readonly class="easyui-validatebox"/>
							<div id="proSchool" class="easyui-window">
								<div class="title">
									<span>已选择:</span>
								</div>
								<div class="proSelect">
									<select></select> <span>如没找到选择项，请选择其他手动填写</span> <input
                                        type="text">
								</div>
								<div class="schoolList">
									<ul>
									</ul>
								</div>
							</div> </span>
            </div>

            <div align="center" style="padding:20px;">
						<span>  &nbsp &nbsp<label for="email">状态:</label> &nbsp&nbsp&nbsp&nbsp &nbsp &nbsp &nbsp <select
                                id="state" class="easyui-combobox" name="dept"
                                style="width:170px;" data-options="panelHeight:'80px'">
								<option value="1">已就业</option>
								<option value="0">待就业</option>
								<option value="0">待就业</option>
						</select> &nbsp &nbsp &nbsp &nbsp &nbsp&nbsp &nbsp &nbsp 
							<label for="email">班级:</label> &nbsp &nbsp  &nbsp &nbsp &nbsp &nbsp
							 <select id="personClass"
                                     class="easyui-combotree" style="width:170px;"></select>
						</span>
            </div>

            <div align="center" style="padding:20px;">
						<span> <label for="email">毕业时间:&nbsp
								&nbsp&nbsp&nbsp </label> &nbsp <input id="dd" type="text"
                                                                      class="easyui-datebox"
                                                                      required="required"></input> &nbsp&nbsp
							&nbsp &nbsp &nbsp &nbsp <label for="email">&nbsp
								操行分:&nbsp &nbsp </label> &nbsp &nbsp &nbsp <input class="easyui-textbox"
                                                                                  type="text" name="name"
                                                                                  data-options="required:true"></input> </span>
            </div>

            <div align="center" style="padding:20px;">
						<span> <label for="email">保险是否缴纳:</label> &nbsp <input
                                class="easyui-textbox" type="text" name="name"
                                data-options="required:true"></input> &nbsp &nbsp &nbsp&nbsp
							&nbsp &nbsp <label for="email">身份证号码: &nbsp</label> &nbsp <input
                                    class="easyui-textbox" type="text" name="name"
                                    data-options="required:true"></input> </span>
            </div>


            <div align="center" style="padding:20px;">
						<span> <label for="email">家长联系方式:</label> &nbsp <input
                                class="easyui-textbox" type="text" name="name"
                                data-options="required:true"><label for="email">
								&nbsp &nbsp &nbsp&nbsp &nbsp &nbsp 本人联系方式:</label> &nbsp <input
                                class="easyui-textbox" type="text" name="name"
                                data-options="required:true"></input> </span>
            </div>


            <div align="center" style="padding:20px;">

                <label for="email">性別:</label> &nbsp
                &nbsp &nbsp &nbsp <label><input name="gander" type="radio"
                                                value="1"/>男 </label> &nbsp &nbsp &nbsp <label><input
                    name="gander" type="radio" value="0"/>女 </label>

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
</body>