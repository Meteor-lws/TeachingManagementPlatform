<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../jquery-easyui-1.4/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../jquery-easyui-1.4/themes/icon.css">
	<!--引入Jquery主文件-->
	<script type="text/javascript" src="../jquery-easyui-1.4/jquery.min.js"></script>
	<!--引入JqueryEasyUI主文件-->
	<script type="text/javascript" src="../jquery-easyui-1.4/jquery.easyui.min.js"></script>
	<!--让easyUI支持中文-->
    <script type="text/javascript" src="../jquery-easyui-1.4/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
	<div style="margin:20px 0;"></div>
	
	<table id="dg" class="easyui-datagrid" title="CheckBox Selection on DataGrid" style="width:700px;height:250px"
			data-options="rownumbers:true,singleSelect:true,url:'datagrid_data1.json',method:'get'">
		<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true">是否启用</th>
				<th data-options="field:'itemid',width:80">ID</th>
				<th data-options="field:'productid',width:100">评分内容</th>
				<th data-options="field:'listprice',width:80,align:'right'">评分分值</th>
			</tr>
			<div id="w" class="easyui-window" title="学生修改" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:500px;height:300px;padding:10px;">
			<form id="ff" method="post" action="/asa">
    	<div align="center" style="padding:10px;">    
        	<label for="email">评分内容:</label>   &nbsp &nbsp &nbsp 
        	<input class="easyui-textbox" data-options="multiline:true" value="请输入评分内容" style="width:300px;height:100px">   
    	</div> 
    	<div align="center" style="padding:10px;">    
        	<label for="email">评分分值:</label>   &nbsp &nbsp &nbsp 
        	<input id="ss" class="easyui-numberspinner" style="width:80px;"   
        required="required" data-options="min:10,max:100,editable:false"> 
    	</div> 
    	 <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">保存</a>
	    	&nbsp &nbsp &nbsp 
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">清除</a>
	    </div>
			</form>  
			
			</div>
		</thead>
	</table>
</body>
<script type="text/javascript">
		$(function(){
			
			
			
			
			var rowValue;
			$('#dg').datagrid({
			    onDblClickCell: function(index,field,value){
			    	$('#w').window('open');
			    	$("#name").val(rowValue.itemid);
			    	
			    	
			    },
			    onSelect: function(rowIndex, rowData)
			    {
					rowValue = rowData;			    	
			    }
			});
		});
		function clearForm()
		{
			$("input").each(function(){
				$(this).val("");
			});
		}
		function submitForm()
		{
			$.messager.progress();	// 显示进度条
			$('#ff').form('submit', {
				url: "/asada",
				onSubmit: function(){
					var isValid = $(this).form('validate');
					if (!isValid){
						$.messager.progress('close');	// 如果表单是无效的则隐藏进度条
					}
					return isValid;	// 返回false终止表单提交
				},
				success: function(){
					$.messager.progress("close");	// 如果提交成功则隐藏进度条
					$("#w").window("close")
				}
			});

		}
		
		
	</script>
	<script type="text/javascript">
		$(function(){
			var pager = $('#dg').datagrid().datagrid('getPager');	// get the pager of datagrid
			pager.pagination({
				buttons:[{
					iconCls:'icon-remove',
					handler:function(){
						alert('search');
					}
				},{
					iconCls:'icon-add',
					handler:function(){
						$('#w').window({    
						    title:"教师添加"   
						});  
						$("#w").window('open');

					}
				},{
					iconCls:'icon-edit',
					handler:function(){
						alert('edit');
					}
				}]
			});			
		})
	</script>
</html>