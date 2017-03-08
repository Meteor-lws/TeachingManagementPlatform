<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/pages/common/inc.jsp"%>

<!DOCTYPE html>
<html>
	<head>

	</head>
	<body >
    <div data-options="region:'south',title:'评分列表'" style="height:300px;">
       <table id="grade_list" class="easyui-datagrid" cellspacing="0" cellpadding="0"></table>
    </div>   
</body>
	
		<script type="text/javascript" charset="utf-8">
	$(function() {
	    $('#grade_list').datagrid({ 
	        url: '<%=basePath%>pages/lyandpj/test.json',
	        // url:"<%=basePath%>grade/Grade!findgradeByStudentID?studentID=26",
	        //title:'评分列表', 
	        //iconCls:'icon-edit',//图标 
	        width: 700, 
	        height: 'auto', 
	        rownumbers:true,//行号 
	        nowrap: false, 
	        striped: true, 
	        border: true, 
	        fitColumns:true,
	        collapsible:false,//是否可折叠的 
	        fit: true,//自动大小 
	        showFooter:true,
	        columns:[[    
           /* {field:'t_id',title:'',hidden:true,width:0}, */
           {field:'e_name',title:'评价项',width:200,editor:'text'},    
           {field:'g_time',title:'评价时间',width:200,editor:'text'},
           {field:'g_mark',title:'评分',width:200,editor:'text'}
          // {field:'g_advice',title:'评价意见',width:300,editor:'text'}   
           ]]
	    }); 

	});
	
	function reloadDataGridFooter(){
		// 更新页脚行的值并刷新
		debugger;
		var rows = $('#grade_list').datagrid('getFooterRows');
		rows[0]['name'] = 'new name';
		rows[0]['salary'] = 60000;
		$('#grade_list').datagrid('reloadFooter');
	   // debugger;
		// 更新页脚行并载入新数据
		$('#grade_list').datagrid('reloadFooter',[
			{name: 'name1', salary: 60000},
			{name: 'name2', salary: 65000}
		]);


	}	
	
</script>
</html>