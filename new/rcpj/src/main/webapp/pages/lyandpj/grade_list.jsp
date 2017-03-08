<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/pages/common/inc.jsp"%>

<!DOCTYPE html>
<html>
	<head>

		<script type="text/javascript" charset="utf-8">
	$(function() {
		$('#list_data').datagrid({ 
	        title:'评分信息列表', 
	        url:'<%=basePath%>grade/Grade!findgrade',
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
	        columns:[[    
           /* {field:'t_id',title:'',hidden:true,width:0}, */
           {field:'t_name',title:'教师名称',width:65,editor:'text'},    
           {field:'s_name',title:'学生名称',width:50,editor:'text'},
           {field:'g_time',title:'评价时间',width:100,editor:'text'},    
           //{field:'t_photo',title:'照片',width:100,editor:'text'},    
           {field:'e_name',title:'评价项',width:300,editor:'text'},    
           {field:'g_mark',title:'评分',width:130,editor:'text'},    
           ]],
	        toolbar: '#search'
	       
	    }); 
		$('#btn-save,#btn-cancel').linkbutton();
		win = $('#provider-window').window({
			closed:true,
			modal : true
		});
		form = win.find('form');
	});
	
	
	var win;
	var form;
	function searchbox(){
	    alert(111);
		  $('#list_data').datagrid({
		 
		     columns:[[ 
			           {field:'t_name',title:'教师名称',width:65},
				        {field:'t_id',title:'教师名称',width:65},
                        {field:'avg',title:'平均分',width:50},
				        ]]
				        });
	

	}
	
	function searchbox1(){
	  var  namess=document.getElementById("names").value;
	  var  times = $("#time").datebox("getValue");
	  if(namess==''&&times!='')
	  {
	      
	    		$.ajax({
			    type:'post',
				url:'<%=basePath%>/grade/Grade!selectBYtime',
				data:{"g_time":times},
				dataType:'json', 
				success:function(data){	
				     
					 	//alert(data);
		                $('#list_data').datagrid("loadData",data);//传数据，到本地显示（loadData(本地数据),data（返回的数据））
				                      }
		           })
	  }
	  else if (times==''&&namess!='')
	  {
	     
	     $.ajax({
	            type:'post',
				url:'<%=basePath%>/grade/Grade!selectBYname',
				data:{"g_name":namess},
				dataType:'json',
				success:function(data){	
					 	//alert(data);
		                $('#list_data').datagrid("loadData",data);//传数据，到本地显示（loadData(本地数据),data（返回的数据））
				                      }
	     
	     })
	  
	  }
	  else if (times!=''&& namess!='')
	  {
	     $.ajax({
	       type:'post',
				url:'<%=basePath%>/grade/Grade!selectAll',
				data:"g_name="+namess+"&g_time="+times,
				dataType:'json',
				success:function(data){	
					 	//alert(data);
		                $('#list_data').datagrid("loadData",data);//传数据，到本地显示（loadData(本地数据),data（返回的数据））
				                      }
	     })
	  
	  }
	
	}
	
	function newProvider(){
   		if(confirm("确定开启下一轮投票吗？")){
   			window.location.href="<%=basePath%>grade/Grade!beginNext";
   		form.url = "<%=basePath%>grade/Grade!beginNext";
   		}
    	
    }
    
    
    function closeWindow(){
    	win.window('close');
    }
</script>
	</head>
	<body class="easyui-layout">

		<div id="search" style="padding-top: 3px;">
			<a href="javascript:void(0)"  class="easyui-linkbutton"
				iconCls="icon-ok" plain="true" onclick="newProvider()">开启下一轮投票</a>
			
			
			<input type="text" class="easyui-datebox" id="time"  name="name" style="width: 120px"></input>
			<input type="text" id="names" name="names" placeholder="查询學生或老師的名字"
				style="width: 100px"></input>
				
				<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-search" plain="true"   onclick="searchbox1()">查询</a>
		
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-search" plain="true"   onclick="searchbox()">查询平均分</a>
		</div>
		<div region="center" border="false">
			<table id="list_data" cellspacing="0" cellpadding="0"
				style="display: none">
	
			</table>
		</div>
	</body>
</html>