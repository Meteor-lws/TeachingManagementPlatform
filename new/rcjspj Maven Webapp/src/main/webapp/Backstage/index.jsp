<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
  <head>
  <link rel="stylesheet" type="text/css" href="../jquery-easyui-1.4/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../jquery-easyui-1.4/themes/icon.css">
	<!--引入Jquery主文件-->
	<script type="text/javascript" src="../jquery-easyui-1.4/jquery.min.js"></script>
	<!--引入JqueryEasyUI主文件-->
	<script type="text/javascript" src="../jquery-easyui-1.4/jquery.easyui.min.js"></script>
	<!--让easyUI支持中文-->
	<script type="text/javascript" src="../jquery-easyui-1.4/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript">
		$(function(){
			var id = 0;
			$("#classBtn").click(function(){
				var tab_name = $("#classBtn").children("span").children("span:first").html();
				if($('#main_tab').tabs('exists', tab_name))
					{
					$("#main_tab").tabs('select',tab_name)
					}
				else{
					
					$("#main_tab").tabs('add',{    
					    title:tab_name,    
					   	content:'<iframe width="100%" height="100%" frameborder="0"  src="classEdit.jsp" style="width:100%;height:100%;"></iframe>',
					    closable:true,    
					    tools:[{
							iconCls:'icon-edit'
						}]

					});
				}
			});
			
			$("#teacherBtn").click(function(){
				var tab_name = $("#teacherBtn").children("span").children("span:first").html();
				if($('#main_tab').tabs('exists', tab_name))
				{
				$("#main_tab").tabs('select',tab_name)
				}
			else{
				
				$("#main_tab").tabs('add',{    
				    title:tab_name,    
				   	content:'<iframe width="100%" height="100%" frameborder="0"  src="teacherEdit.jsp" style="width:100%;height:100%;"></iframe>',
				    closable:true,    
				    tools:[{
						iconCls:'icon-edit'
					}]

					});
				}
			});
			
			
			$("#studentBtn").click(function(){
				var tab_name = $("#studentBtn").children("span").children("span:first").html();
				if($('#main_tab').tabs('exists', tab_name))
				{
				$("#main_tab").tabs('select',tab_name)
				}
			else{
				
				$("#main_tab").tabs('add',{    
				    title:tab_name,    
				   	content:'<iframe width="100%" height="100%" frameborder="0"  src="studentEdit.jsp" style="width:100%;height:100%;"></iframe>',
				    closable:true,    
				    tools:[{
						iconCls:'icon-edit'
					}]

					});
				}
			});
			
			
			$("#passBtn").click(function(){
				var tab_name = $("#passBtn").children("span").children("span:first").html();
				if($('#main_tab').tabs('exists', tab_name))
				{
				$("#main_tab").tabs('select',tab_name)
				}
			else{
				
				$("#main_tab").tabs('add',{    
				    title:tab_name,    
				   	content:'<iframe width="100%" height="100%" frameborder="0"  src="classEdit.jsp" style="width:100%;height:100%;"></iframe>',
				    closable:true,    
				    tools:[{
						iconCls:'icon-edit'
					}]

					});
				}
			});
			
			$("#gradeItemBtn").click(function(){
				var tab_name = $("#gradeItemBtn").children("span").children("span:first").html();
				if($('#main_tab').tabs('exists', tab_name))
				{
				$("#main_tab").tabs('select',tab_name)
				}
			else{
				
				$("#main_tab").tabs('add',{    
				    title:tab_name,    
				   	content:'<iframe width="100%" height="100%" frameborder="0"  src="gradeItem.jsp" style="width:100%;height:100%;"></iframe>',
				    closable:true,    
				    tools:[{
						iconCls:'icon-edit'
					}]

					});
				}
			});
			
			
			$("#messageBtn").click(function(){
				var tab_name = $("#messageBtn").children("span").children("span:first").html();
				if($('#main_tab').tabs('exists', tab_name))
				{
				$("#main_tab").tabs('select',tab_name)
				}
			else{
				
				$("#main_tab").tabs('add',{    
				    title:tab_name,    
				   	content:'<iframe width="100%" height="100%" frameborder="0"  src="message.jsp" style="width:100%;height:100%;"></iframe>',
				    closable:true,    
				    tools:[{
						iconCls:'icon-edit'
					}]

					});
				}
			});
			
			
			$("#gradeBtn").click(function(){
				var tab_name = $("#gradeBtn").children("span").children("span:first").html();
				if($('#main_tab').tabs('exists', tab_name))
				{
				$("#main_tab").tabs('select',tab_name)
				}
			else{
				
				$("#main_tab").tabs('add',{    
				    title:tab_name,    
				   	content:'<iframe width="100%" height="100%" frameborder="0"  src="noGrade.jsp" style="width:100%;height:100%;"></iframe>',
				    closable:true,    
				    tools:[{
						iconCls:'icon-edit'
					}]

					});
				}
			});
			
			
			
			
			
			
		});
		
	
	</script>
  </head>
  <body>
	<div class="easyui-layout" style="width:100%;height:100%;">
		<div data-options="region:'north'" style="height:50px"></div>
		<div data-options="region:'south',split:true" style="height:50px;"></div>
		<div data-options="region:'west',split:true,collapsible:false" title="West" style="width:200px;">
			<div class="easyui-accordion" data-options="fit:true,border:false">
				<div title="班级管理" style="padding:20px;">
					<a id="classBtn" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'" >班级管理</a>  
				</div>
				<div title="教师管理" data-options="selected:true" style="padding:10px;">
					<a id="teacherBtn" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'">教师管理</a>  
				</div>
				<div title="学生管理" style="padding:20px">
					<a id="studentBtn"  href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'">学生管理</a>  
				</div>
				<div title="密码管理" style="padding:20px">
					<a id="passBtn" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'">密码管理</a>  
				</div>
				<div title="评分项管理" style="padding:20px">
					<a id="gradeItemBtn" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'">评分项管理</a>
					<a id="messageBtn" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'">留言管理</a>
					<a id="gradeBtn" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'">未评分管理</a>  
				</div>
			</div>
		</div>
		<div data-options="region:'center',title:'Main Title',iconCls:'icon-ok'">
			<div id="main_tab" class="easyui-tabs" data-options="fit:true,border:false,plain:true">
				<div title="主页" data-options="href:'1.jsp'" style="padding:20px"></div>
				
				
			</div>
		</div>
	</div>
  </body>
