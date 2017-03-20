<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.4/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="jquery-easyui-1.4/themes/icon.css">
	<!--引入Jquery主文件-->
	<script type="text/javascript" src="jquery-easyui-1.4/jquery.min.js"></script>
	<!--引入JqueryEasyUI主文件-->
	<script type="text/javascript" src="jquery-easyui-1.4/jquery.easyui.min.js"></script>
	<!--让easyUI支持中文-->
	<script type="text/javascript" src="jquery-easyui-1.4/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
	<table id="dg" title="Custom DataGrid Pager" style="width:100%;height:100%"
			data-options="rownumbers:true,singleSelect:true,pagination:true,url:'datagrid_data1.json',method:'get',fitColumns:true,fit:true">
		<thead>
		<div> 
	教师编号
	<input type="text" class="easyui-numberbox" value="100" data-options="min:0,precision:2"></input>  

	教师姓名
	<input id="vv" class="easyui-validatebox"  />  
	入职时间  
	<input id="dd" type="text" class="easyui-datebox" ></input>--
	<input id="dd" type="text" class="easyui-datebox" ></input>
	&nbsp&nbsp&nbsp
	<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>
	</div>	
			<tr>	
			<th data-options="field:'ck',checkbox:true">是否启用</th>
			   <th data-options="field:'itemid'">ID</th>
				<th data-options="field:'itemid'">編號</th>
				<th data-options="field:'productid'">班級</th>
				<th data-options="field:'listprice',align:'right'">教師姓名</th>
				<th data-options="field:'unitcost',align:'right'">性別</th>
				<th data-options="field:'attr1'">簡介</th>
				<th data-options="field:'status',align:'center'">照片</th>
				<th data-options="field:'status',align:'center'">專業</th>
				<th data-options="field:'status',align:'center'">類型</th>
				<th data-options="field:'status',align:'center'">電話</th>
			</tr>
			<div id="w" class="easyui-window" title="教师修改" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:500px;height:450px;padding:10px;">
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
		</thead>
	</table>
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
					iconCls:'icon-search',
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
</body>