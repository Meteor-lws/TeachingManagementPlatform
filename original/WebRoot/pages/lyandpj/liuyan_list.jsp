<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/pages/common/inc.jsp"%>

<!DOCTYPE html>
<html>
	<head>

		<script type="text/javascript" charset="utf-8">
	$(function() {
		$('#list_data').datagrid({ 
	        title:'留言管理', 
	        url:'<%=basePath%>/liuyan/liuyanAll', 
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
	        singleSelect:false,//是否单选 
	        frozenColumns:[[ 
	           {field:'b_id',checkbox:true} 
	        ]], 
	        toolbar: '#search'
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
		$('#btn-save,#btn-cancel').linkbutton();
		win = $('#provider-window').window({
			closed:true,
			modal : true
		});
		form = win.find('form');
	});
	
	var win;
	var form;
	
   <%--搜索框--%>
	function searchbox(){
		var b_ly = document.getElementById("b_ly").value;
		if(b_ly !="")
		{
<%--			form.url = '<%=path %>/liuyan/liuyanFind?b_id ="b_id"';--%>
			$.ajax({
			    type:'post',
				url:'<%=basePath%>/liuyan/liuyanFind',
				data:'b_ly='+b_ly,
				dataType:'json',
				success:function(data){	
					 	//alert(data);
		                $('#list_data').datagrid("loadData",data);//传数据，到本地显示（loadData(本地数据),data（返回的数据））
				                      }
		           })
			}
		      else
			      {
		    	    $('#list_data').datagrid("reload");
			      }
	   }
	
    function delProvider(){
        var ids = "";
        var rows = $("#list_data").datagrid("getSelections");
       //判断是否选择行
		if(!rows || rows.length == 0){
			$.pmsystem.showError('请选择要删除的数据');
			return ;
   	    }
    	 $.pmsystem.showConfirm("确定要进行删除操作吗？",function(choice){
    		 if(!choice)
 				return;
    		
        	 $.each(rows,function(i,n){
        		 ids += n.b_id +",";
             })
             $("#list_data").datagrid("clearSelections");
             $.ajax({
 				url:"<%=basePath%>/liuyan/liuyanDelete",
 				data:"ids="+ids,
 				method:"POST",
 				dataType:'json',
 				success:function(obj){
 					if(obj.code != 0){
 						$.messager.show({
 	    					title:'警告', 
    					msg:"删除成功"
 	    				});
 						$("#list_data").datagrid("reload");
 					}else{
<%-- 						$.pmsystem.showError(obj.msg,'错误','error');--%>
 					}
 					$("#list_data").datagrid("reload");
 				}
 			});
         });
    }
</script>
	</head>
	<body class="easyui-layout">
		<div id="search" style="padding-top: 3px;">
			<a href="javascript:void(0)"  class="easyui-linkbutton"
				iconCls="icon-remove" plain="true" onclick="delProvider()">删除</a>
			
			<input type="text" id="b_ly" name="b_ly" placeholder="查询的留言内容"
				style="width: 100px"></input>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-search" plain="true"   onclick="searchbox()">查询</a>
		</div>

		<div region="center" border="false">
			<table id="list_data" cellspacing="0" cellpadding="0"
				style="display: none">
				<thead>
					<tr>
<%--					   <th field="b_id"  width="100">--%>
<%--							编号--%>
<%--						</th>--%>
						<th field="b_ly"  width="100">
							留言内容
						</th>
						<th field="s_name" width="100">
							留言人
						</th>
						<th field="t_name" width="100">
							被留言的教师
						</th>
						<th field="b_time" width="100">
						         留言时间
						</th>
					</tr>
				</thead>
			</table>
		</div>

		</div>
	</body>
</html>