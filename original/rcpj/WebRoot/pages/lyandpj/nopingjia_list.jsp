<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/pages/common/inc.jsp"%>

<!DOCTYPE html>
<html>
	<head>

		<script type="text/javascript" charset="utf-8">
	$(function() {
		$('#list_data').datagrid({ 
	        title:'学员列表 ', 
	        url:'<%=basePath%>grade/Grade!selectNoPinJia', 
	        //iconCls:'icon-edit',//图标 
	        width: 700, 
	        height: 'auto', 
	        rownumbers:true,//行号 
	        nowrap: false, 
	        striped: true, 
	        border: true, 
	        fitColumns:true,
	        collapsible:true,//是否可折叠的 
	        fit: true,//自动大小 
	        pagination :true, 
	        remoteSort:false,  
	        idField:'b_id', //在删除的时候，可以翻页选择，框架能知道选了哪些
	        singleSelect:true,//是否单选 
	        //[{ 
	        //    text: '添加', 
	        //    iconCls: 'icon-add', 
	        //    handler: function() { 
	        //        newProvider(); 
	        //    } 
	        //}, '-', { 
	        //    text: '修改', 
	        //    iconCls: 'icon-edit', 
	        //    handler: function() { 
	        //        modifyProvider(); 
	        //    } 
	        //}, '-',{ 
	        //    text: '删除', 
	        //    iconCls: 'icon-remove', 
	        //    handler: function(){ 
	        //        delProvider(); 
	        //    } 
	        //}, '-',{
	        	
           		//   text: '<input type="text" id="name" name = "name" placeholder = "姓名或班级"/>' 
        		//}, { 
              //     id: 'btnSetName', 
              //     text: '确认', 
             //      iconCls: 'icon-search', 
             //      handler: function(){ 
             //      	 alert(111);
             //        searchbox(); 
           	//	 } 
                
	        //}]
	    }); 
		
	});
	
	
 	
</script>
	</head>
	<body class="easyui-layout">
		

		<div region="center" border="false">
			<table id="list_data" cellspacing="0" cellpadding="0"
				style="display: none">
				<thead>
					<tr>
						<th field="s_name"  width="100">
							学生姓名
						</th>
						<th field="s_sex" width="100">
							学生性别
						</th>
						<th field="s_class" width="100">
							学生班级
						</th>
						<th field="t_name" width="100">
						         所属老师
						</th>
					</tr>
				</thead>
			</table>
		</div>

		</div>
	</body>
</html>