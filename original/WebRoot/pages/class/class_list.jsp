<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/pages/common/inc.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>">
		<script type="text/javascript" charset="utf-8">
$(function() {
	$('#list_data').datagrid( {
		title : '学生列表',
		url : '<%=basePath%>classes/classesAction!selectClass',
		//iconCls:'icon-edit',//图标 
		width : 700,
		height : 'auto',
		rownumbers : true,//行号 
		nowrap : false,
		striped : true,
		border : true,
		fitColumns : true,
		collapsible : false,//是否可折叠的 
		fit : true,//自动大小 
		pagination : true,
		remoteSort : false,
		idField : 's_id', //在删除的时候，可以翻页选择，框架能知道选了哪些
		singleSelect : false,//是否单选 
		frozenColumns : [ [ {
			field : 's_id',
			checkbox : true
		} ] ],
		columns : [ [ {
			field : 'c_name',
			title : '班级名称',
			width : 100,
			editor : 'text'
		     }, {
			field : 't_name',
			title : '班主任姓名',
			width : 100,
			editor : 'text'
		     },  {
			field : 'c_stime',
			title : '开班时间',
			width : 100,
			editor : 'text'
		     }, {
			field : 'c_etime',
			title : '毕业时间',
			width : 100,
			editor : 'text'
		     },] ],
		toolbar : '#search'
	});
	$('#name').combobox({
	 url:'<%=basePath%>classes/classesAction!findall',
	valueField:'c_id',
	textField:'c_name',
	});
	$('#tname').combobox({
	 url:'<%=basePath%>classes/classesAction!findteacher',
	valueField:'t_id',
	textField:'t_name',
	});
	$('#btn-save,#btn-cancel').linkbutton();
	win = $('#provider-window').window( {
		closed : true,
		modal : true
	});
	form = win.find('form');
	debugger;
	$("#type").val("1");
});
var form;
var win;
function searchbox() {//查找学生信息
	var name = $('#name').combobox('getValue');
	$.ajax( {
		url : "<%=basePath%>classes/classesAction!findbyid",
		data : "cid=" + name,
		method : "POST",
		dataType : 'json',
		success : function(obj) {

	  $("#list_data").datagrid("loadData", obj);
    }
	});
}
function newProvider() {//弹出窗口添加学生信息
	win.window('open');
	form.form('clear');
	$('#mname').combobox({
	 url:'<%=basePath%>teacher/TeacherAction_findM',
	valueField:'t_id',
	textField:'t_name',
	onChange: function (n,o) {
       // $("#mid").val($('#mname').combobox('getValue'));
       // $("#main").val($('#mname').combobox('getText'));
     }
	});
	$('#ccname').combobox({
	 url:'<%=basePath%>teacher/TeacherAction_findC',
	valueField:'t_id',
	textField:'t_name',
	onChange: function (n,o) {
       // $("#mid").val($('#ccname').combobox('getValue'));
       // $("#mnames").val($('#ccname').combobox('getText'));
     }
	});
	$('#aname').combobox({
	 url:'<%=basePath%>teacher/TeacherAction_findA',
	valueField:'t_id',
	textField:'t_name',
	});
    form.url = '<%=basePath%>classes/classesAction!addClass';
}

function saveProvider() {//保存学生信息
	form.form('submit', {
	       onSubmit: function () { 		   
		  //表单提交前的回调函数 
          var isValid = $(this).form('validate');//验证表单中的一些控件的值是否填写正确，比如某些文本框中的内容必须是数字 
          if (!isValid) { 
          } 
          return isValid; // 如果验证不通过，返回false终止表单提交 
          }, 
				url:form.url,
				success : function(obj) {
					var json = eval('(' + obj + ')');
					if (json.success) {
						$('#list_data').datagrid('reload');
						$.messager.show( {
							title : '警告',
  						    msg :json.msg,
						});
						win.window('close');
					} else {
						$.messager.alert("错误",json.msg,"error");
					}
		}
			});
}

function modifyProvider() {
	var row = $("#list_data").datagrid("getSelections");
	if (row) {
		if (row.length > 1) {
			$.messager.show({
			title:'警告',
			msg:'只能选择单条记录!'	
			})
			}else if (row.length == 1) {
			win.window('open');
			$("#cid").val(row[0].c_id);
			$("#cname").val(row[0].c_name);
		    $("#type").val(row[0].c_type);
		    $("#tname").combobox('setValue',row[0].c_tid);
		    $('#stime').datebox('setValue',row[0].c_stime);
		    $('#etime').datebox('setValue',row[0].c_etime);
			form.url ='<%=basePath%>classes/classesAction!updateClass';
		} else {
			$.messager.show({
					title:'警告',
					msg:'请选择数据记录!'
				})
		}
		$("#list_data").datagrid("clearSelections");
		$("#list_data").datagrid("reload");
	}
}


   //表单验证 
  $.extend($.fn.validatebox.defaults.rules, { 
    
     useracc:{
    	validator:function(value,param)
    	{
    	  var flag=true;
    	  $.ajax({
    		  type:"post",
    		  async:false,
    		  url:'<%=path%>/admin/adminAction!validateAccount',
    		  success:function(data){
    		  var uacc =data
    		  for(var i=0;i<uacc.length;i++)
    			  {
    			    if(value==uacc[i])
    			    	{
    			    	flag=false;
    			    	break;
    			    	}
    			  }
    		  }
    	  });
    	  return flag;
    	},
    message:'用户名已存在'
    },
    
   
    idcard: {  
        validator: function (value, param) {  
           return  /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/.test(value);  
        },  
       message:'请输入正确的身份证号码'  
  }  
}); 
  
/* 密码由字母和数字组成，至少6位 */  
    var safePassword = function (value) {  
    return  !(/^(([A-Z]*|[a-z]*|\d*|[-_\~!@#\$%\^&\*\. \{\}<>\?\\\/\'\"]*)|.{0,5})$|\s/.test(value));  
}  
  
    var idCard = function (value) {  
    if (value.length == 18 && 18 != value.length) return false;  
   var number = value.toLowerCase();  
   var d, sum = 0, v = '10x98765432', w = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2], a = '11,12,13,14,15,21,22,23,31,32,33,34,35,36,37,41,42,43,44,45,46,50,51,52,53,54,61,62,63,64,65,71,81,82,91';  
    var re = number.match(/^(\d{2})\d{4}(((\d{2})(\d{2})(\d{2})(\d{3}))|((\d{4})(\d{2})(\d{2})(\d{3}[x\d])))$/);  
    if (re == null || a.indexOf(re[1]) < 0) return false;  
    if (re[2].length == 9) {  
        number = number.substr(0, 6) + '19' + number.substr(6);  
        d = ['19' + re[4], re[5], re[6]].join('-');  
    } else d = [re[9], re[10], re[11]].join('-');  
    if (!isDateTime.call(d, 'yyyy-MM-dd')) return false;  
    for (var i = 0; i < 17; i++) sum += number.charAt(i) * w[i];  
    return (re[2].length == 9 || number.charAt(17) == v.charAt(sum % 11));  
}  
 
   var isDateTime = function (format, reObj) {  
   format = format || 'yyyy-MM-dd';  
    var input = this, o = {}, d = new Date();  
    var f1 = format.split(/[^a-z]+/gi), f2 = input.split(/\D+/g), f3 = format.split(/[a-z]+/gi), f4 = input.split(/\d+/g);  
   var len = f1.length, len1 = f3.length;  
    if (len != f2.length || len1 != f4.length) return false;  
    for (var i = 0; i < len1; i++) if (f3[i] != f4[i]) return false;  
    for (var i = 0; i < len; i++) o[f1[i]] = f2[i];  
    o.yyyy = s(o.yyyy, o.yy, d.getFullYear(), 9999, 4);  
    o.MM = s(o.MM, o.M, d.getMonth() + 1, 12);  
    o.dd = s(o.dd, o.d, d.getDate(), 31);  
    o.hh = s(o.hh, o.h, d.getHours(), 24);  
    o.mm = s(o.mm, o.m, d.getMinutes());  
    o.ss = s(o.ss, o.s, d.getSeconds());  
    o.ms = s(o.ms, o.ms, d.getMilliseconds(), 999, 3);  
    if (o.yyyy + o.MM + o.dd + o.hh + o.mm + o.ss + o.ms < 0) return false;  
    if (o.yyyy < 100) o.yyyy += (o.yyyy > 30 ? 1900 : 2000);  
   d = new Date(o.yyyy, o.MM - 1, o.dd, o.hh, o.mm, o.ss, o.ms);  
   var reVal = d.getFullYear() == o.yyyy && d.getMonth() + 1 == o.MM && d.getDate() == o.dd && d.getHours() == o.hh && d.getMinutes() == o.mm && d.getSeconds() == o.ss && d.getMilliseconds() == o.ms;  
   return reVal && reObj ? d : reVal;  
    function s(s1, s2, s3, s4, s5) {  
        s4 = s4 || 60, s5 = s5 || 2;  
        var reVal = s3;  
        if (s1 != undefined && s1 != '' || !isNaN(s1)) reVal = s1 * 1;  
       if (s2 != undefined && s2 != '' && !isNaN(s2)) reVal = s2 * 1;  
       return (reVal == s1 && s1.length != s5 || reVal > s4) ? -10000 : reVal;  
    }  
}; 

var flag = true;  
  
$('#uiform input').each(function () {  
    if ($(this).attr('required') || $(this).attr('validType')) {  
   if (!$(this).validatebox('isValid')) {  
        flag = false;  
        if (flag) 
    {    	
   alert('验证通过！');  
   }
else  
	{
    alert('验证失败！');  
    }
        return;  
   }  
    }  
}) 

function closeWindow() {
	win.window('close');
	//  $("#list_data").datagrid("reload");
}


</script>
	</head>
	<body class="easyui-layout">

		<div id="search" style="padding-top: 3px;">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-add" plain="true" onclick="newProvider()">增加</a>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-edit" plain="true" onclick="modifyProvider()">修改</a>
			<input id="name" name="name"
				style="width: 100px"></input>

			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-search" plain="true" onclick="searchbox()">查找班级</a>
		</div>

		<div region="center" border="false">
			<table id="list_data" cellspacing="0" cellpadding="0"
				style="display: none">
			</table>
		</div>
		<div id="provider-window" title="学生信息窗口"
			style="width: 400px; height: 300px;">
			<div id="showMassage" class="align-center"></div>
			<div>
			</div>
			<div style="padding: 20px 30px 40px 30px;">
				<form method="post">
					<table bgcolor="#C1DAD7" width="300px" align="center"
						style="align: center" border="0">
						
							<tr>
							<td class="form_content" >
								<input id="cid" name="classes.c_id"
									class="easyui-validatebox" maxlength="20"
									style="display: none;"></input>
							</td>
						</tr>

						<tr>
							<td class="form_label">
								班级名称：
							</td>
							<td  class="form_content">
								<input id="cname" name="classes.c_name"
									class="easyui-validatebox" maxlength="20"
									data-options="required:true"></input>
							</td>
						</tr>
						
						
						<tr>
						   <td colspan = "2"><font size="1" color="red">班级名称格式为：xxx-xxx 例如：JAVA-1606</font></td>
						</tr>
						
						<tr>
							<td class="form_label">
								班主任：
							</td>
							<td >
							<input id="tname" name="classes.c_tid" style="width: 100px"></input>
							</td>
						</tr>
						
						<tr>
							<td class="form_label">
								<font >开班时间：</font>
							</td>
							<td class="form_content">
								<input id="stime"  name="classes.c_stime" class="easyui-datebox"></input>
							</td>
						</tr>
						<tr>
							<td class="form_label">
								<font >毕业时间：</font>
							</td>
							<td class="form_content">
								<input id="etime"  name="classes.c_etime" class="easyui-datebox"></input>
							</td>
						</tr>
				
						
						<tr>
							<td class="form_label">
								是否启用:
							</td>
							<td class="form_content">
								<SELECT id="type" name="classes.c_type">
								 <option selected="selected" value="0">是</option>
								 <option value="1">否</option>
								</SELECT>
							</td>
						</tr>

						<tr>
							<td class="form_label" colspan="2" style="text-align: center">
								<a href="javascript:void(0)" onclick="saveProvider()"
									id="btn-save" icon="icon-save">保存</a>
								<a href="javascript:void(0)" onclick="closeWindow()"
									id="btn-cancel" icon="icon-cancel">取消</a>
							</td>
						</tr>
					</table>
				</form>
			</div>

		</div>
	</body>
</html>