<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/pages/common/inc.jsp"%>

<!DOCTYPE html>
<html>
	<head>

	</head>
	<body >
  <div  class="easyui-layout" style="width:100%;height:100%;">   
    <div  data-options="region:'center',title:'学生列表',split:true"> 
      <table  id="student_list" class="easyui-datagrid" cellspacing="0" cellpadding="0"></table>
    </div>   
    <div data-options="region:'south',title:'评分列表',split:true" style="height:150px;">
       <table id="grade_list" class="easyui-datagrid" cellspacing="0" cellpadding="0"></table>
    </div>   
  </div>  
  <div id="search">
	<label>请选择教师查询</label>	
	<input id="teacherList" class="easyui-combobox" onchange="teacherChange(this.value)" data-options="valueField:'t_id',textField:'t_name',url:'<%=basePath%>teacher/TeacherAction_loadAllteachersForSelect'" /> 
	<label>&nbsp;|&nbsp;</label>	
	<a href="javascript:void(0)"  class="easyui-linkbutton" iconCls="icon-ok" plain="true" onclick="newProvider()">开启下一轮投票</a>	
 </div>
		
</body>
	
<script type="text/javascript" charset="utf-8">
$(function() {
	/* $('#student_list').datagrid({ 
        width: 700, 
        height: 'auto', 
        rownumbers:true,//行号 
        nowrap: false, 
        striped: true, 
        border: true, 
        fitColumns:true,
        collapsible:false,//是否可折叠的 
        singleSelect:true,
        showFooter:true,
        fit: true,//自动大小 
        frozenColumns:[[ 
            {field:'s_id',checkbox:true} 
        ]], 
        columns:[[    
       {field:'s_name',title:'学生名称',width:200,editor:'text'},    
       {field:'s_class',title:'所属班级',width:200,editor:'text'},
       {field:'sum',title:'评价总分',width:300,editor:'text'},   
       {field:'advice',title:'建议',width:300,editor:'text'}   
       ]],
        toolbar: '#search',
        onClickRow:loadgradeData
    });  */
    $('#student_list').datagrid({ 
        width: 700, 
        height: 'auto', 
        rownumbers:true,//行号 
        nowrap: false, 
        striped: true, 
        border: true, 
        fitColumns:true,
        collapsible:false,//是否可折叠的 
        singleSelect:true,
        showFooter:true,
        fit: true,//自动大小 
        frozenColumns:[[ 
            {field:'s_id',checkbox:true} 
        ]], 
        columns:[[    
       {field:'s_name',title:'学生名称',width:200,editor:'text'},    
       {field:'s_class',title:'所属班级',width:200,editor:'text'},
       {field:'sum',title:'评价总分',width:300,editor:'text'},   
       {field:'advice',title:'建议',width:300,editor:'text'}   
       ]],
        toolbar: '#search',
        onClickRow:loadgradeData
    });  
    $('#grade_list').datagrid({ 
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
        //showFooter:true,
        columns:[[    
       /* {field:'t_id',title:'',hidden:true,width:0}, */
       {field:'e_name',title:'评价项',width:200,editor:'text'},    
       {field:'g_time',title:'评价时间',width:200,editor:'text'},
       {field:'g_mark',title:'评分',width:200,editor:'text'}
      // {field:'g_advice',title:'评价意见',width:300,editor:'text'}   
       ]]
    }); 
   
   $('#teacherList').combobox({
      onChange:teacherChange
   });
   
});

function teacherChange(value){
$('#student_list').datagrid
   $('#student_list').datagrid({
	  url:"<%=basePath%>student/StudentAction_selectStudentsByTeacherid?tid="+value
   });
}	
function loadgradeData(){
	 var row=$('#student_list').datagrid("getSelected");
	 var teacherid=$('#teacherList').combobox("getValue");
	 $('#grade_list').datagrid({
         url:"<%=basePath%>grade/Grade!findgradeByStudentID?studentID="+row.s_id+"&teacherID="+teacherid
      });
}
function newProvider(){
		if(confirm("确定开启下一轮投票吗？")){
			window.location.href="<%=basePath%>grade/Grade!beginNext";
		form.url = "<%=basePath%>grade/Grade!beginNext";
		}
	
}
</script>
</html>