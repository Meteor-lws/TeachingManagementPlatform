<%@page import="com.ruicai.edu.entity.Student"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/pages/common/inc.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html><head>
<style type="text/css">
.align-center{
width: 250px;
height: 30px;
position: absolute;
left: 240px;
top:100px;
font-size: x-large;
text-align: center;
color: red;
}
</style>
<script type="text/javascript" charset="utf-8">
	$(function() {
	    
		$('#list_data').datagrid({ 
	        title:'教师列表', 
	        url:'<%=basePath%>teacher/TeacherAction_loadTeachersByPages', 
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
	        pagination :true, 
	        pageSize:20,
	        remoteSort:false,  
	        idField:'t_id', //在删除的时候，可以翻页选择，框架能知道选了哪些
	        singleSelect:false,//是否单选 
	        frozenColumns:[[ 
	            {field:'t_id',checkbox:true} 
	        ]], 
	       columns:[[    
           /* {field:'t_id',title:'',hidden:true,width:0}, */
           {field:'t_name',title:'教师名称',width:65,editor:'text'},    
           {field:'t_sex',title:'性别',width:50,editor:'text'},
           {field:'t_jianJie',title:'简介',width:370,editor:'text'},    
           //{field:'t_photo',title:'照片',width:100,editor:'text'},    
           {field:'t_account',title:'账号',width:80,editor:'text'},    
           {field:'t_pass',title:'密码',width:130,editor:'text'},    
           {field:'t_zhuanYe',title:'执教专业',width:100,editor:'text'},    
           {field:'t_leiXing',title:'执教类型',width:100,editor:'text'},    
           {field:'t_phone',title:'联系电话',width:100,editor:'text'},
           {field:'t_class',title:'班级',width:85,editor:'text'},]],
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
	    var p = $("#list_data").datagrid("getPager"); 
	    $(p).pagination({ 
	        pageSize: 20,//每页显示的记录条数，默认为10 
	        pageList: [10,15,20,25,30,40,50],//可以设置每页记录条数的列表 
	        beforePageText: '第',//页数文本框前显示的汉字 
	        afterPageText: '页    共 {pages} 页', 
	        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录', 
	        /*onBeforeRefresh:function(){
	            $(this).pagination('loading');
	            alert('before refresh');
	            $(this).pagination('loaded');
	        }*/ 
	    }); 
		$('#btn-save,#btn-cancel').linkbutton();
		win = $('#provider-window').window({
			closed:true,
			modal : true,
			resizable:false
		});
		form = win.find('form');
		//登录名失焦时检查用户名是否存在
		$("#teacherLoginName").blur(checkLoginName); 
		//初始化隐藏消息框
		$("#showMassage").html("").hide();
		//加载图片改变事件
		$("#teacherIMG").change(loadPhoto());
		
	});
	
	var win;
	var form;
	
	function newProvider(){
    	win.window('open');
    	 form.form('clear');
    	 $('#teacherClass').combobox({
	 	url:'<%=basePath%>classes/classesAction!findall',
		valueField:'c_id',
		textField:'c_name',
	});
    	 $("#checkMessage").text("");
    	 $("#showTeacherPhoto").attr("src","<%=basePath%>images/teachers/default.png");
    	 $("#checkMan").prop("checked",true);
    	 $("#teacherZY").val("Java");
    	 $("#teacherLX").val("高级讲师");
    	form.url = '<%=basePath%>teacher/TeacherAction_addTeacher';
    }

    function saveProvider(){
    	if(setValidation()){
    	    var saveType="修改";
    	    //如果是添加事件，则先给个默认id=0，消息框为添加，否则消息框为修改
    	    if(form.url=="<%=basePath%>teacher/TeacherAction_addTeacher"){
    	       $("#teacherID").val(0);
    	       saveType="添加";
    	    }
	    	form.form('submit', {
	    		url:form.url,
	    		dataType:'json',
	    		success:function(data){
	    		    data=eval(data);
	    			if (data == "isOK"){
	    				$('#list_data').datagrid('reload');
	    				$.messager.show({
	    					title:'警告', 
	    					msg:saveType+"成功！"
	    				});
	    				win.window('close');
	    			} else {
	    				$.pmsystem.showError(saveType+"失败",'错误','error');
	    			}
	    			$("#list_data").datagrid("reload");
	    		}
	    	});
    	
    	}
    }

    function modifyProvider(){
    
    	var row = $("#list_data").datagrid("getSelections");
		if(row){
			if(row.length>1){
				$.pmsystem.showError('请选择一条数据编辑！');
			}else if(row.length == 1){
				win.window('open');
				form.form('clear');
				$("#checkMessage").text("");
				$("#showTeacherPhoto").attr("src","<%=basePath%>images/teachers/default.png");
				$.ajax({
				   type:"post",
				   dataType:"json",
				   url:'<%=basePath%>teacher/TeacherAction_getTeacherByID?teacher.t_id='+row[0].t_id,
				   success:function(data){
				      form.form('load', data);
				      var data=eval(data);
			          $("#showTeacherPhoto").attr("src","<%=basePath%>images/teachers/"+data["teacher.t_photo"]);
				      //$('#teacherClass').combobox('setValue', data["teacher.t_class"]);
				   }
				});
				//form.form('load', 'TeacherAction_getTeacherByID?teacher.t_id='+row[0].t_id);
				//form.form("load",{"teacher.t_name":"张三"});
				form.url = '<%=basePath%>teacher/TeacherAction_updateTeacher';
				
			}else{
				$.pmsystem.showError('请选择要编辑的数据');
			}	 
			$("#list_data").datagrid("clearSelections");
			$("#list_data").datagrid("reload");    
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
        		 ids =ids+ n.t_id +",";
             })
             $("#list_data").datagrid("clearSelections");
             $.ajax({
 				url:"<%=basePath%>teacher/TeacherAction_deleteTeacher",
 				data:"ids="+ids,
 				method:"POST",
 				dataType:'json',
 				success:function(msg){
 					if(msg =="isOK"){
 						$.messager.show({
 	    					title:'警告', 
 	    					msg:"删除成功！"
 	    				});
 						$("#list_data").datagrid("reload");
 					}else{
 						$.pmsystem.showError("删除错误",'错误','error');
 					}
 					$("#list_data").datagrid("reload");
 				}
 			});
         });
    }
    
    function setValidation(){
		/* $("#name").validatebox({
			required: true,
			tipPosition:'left',
			
			validType:['length[0,20]'],
			missingMessage:"姓名不能为空",
			invalidMessage:"长度不能超过10个汉字"
		}); */
		 
		return checkNull();
	}
    function closeWindow(){
    	win.window('close');
    }
function checkNull(){
        var  checkOK=false; 
        if($("#TeacherName").val()==""){
		  $("#showMassage").html("教师名称不能为空！").show().delay(2000).hide(300);
		  $("#TeacherName").focus();
		}else if($("#TeacherPhone").val()==""){
		  $("#showMassage").html("联系电话不能为空！").show().delay(2000).hide(300);
		  //$("#TeacherPhone").focus(); 
		}else if($("#teacherLoginName").val()==""){
		  $("#showMassage").html("登录名不能为空！").show().delay(2000).hide(300); 
		  $("#teacherLoginName").focus(); 
		}else if($("#TeacherPassWord").val()==""){
		  $("#showMassage").html("登录密码不能为空！").show().delay(2000).hide(300); 
		  $("#TeacherPassWord").focus(); 
		}else if($("#TeacherSynopsis").val()==""){
		  $("#showMassage").html("教师简介不能为空！").show().delay(2000).hide(300); 
		  $("#TeacherSynopsis").focus(); 
		}else{
		   checkOK=true; 
		}
		return checkOK; 
} 
   	
function checkLoginName(data){
    var loginName=$("#teacherLoginName").val();
    if(loginName==null||loginName==""){
         //$("#showMassage").css("color","red");
	     $("#showMassage").html("登录用户名不能为空！").show().delay(2000).hide(300);
	     if(form.url=="<%=basePath%>teacher/TeacherAction_addTeacher"){
	       $("#teacherLoginName").focus();
	     }
    }else{
         $.ajax({
	       type:"post",
	        url:"<%=basePath%>teacher/TeacherAction_checkName",
	        data:"teacher.t_account="+loginName,
	        dataType:"json",
	        success : after_checkName
	    });
    }
    
}
function  after_checkName(data){
   if(data=="isOK"){
     $("#checkMessage").css("color","green");
     $("#checkMessage").text("√");
   }else{
     $("#checkMessage").css("color","red");
     $("#checkMessage").text("用户名已注册");
     if(form.url=="<%=basePath%>teacher/TeacherAction_addTeacher"){
	       $("#teacherLoginName").focus();
	  }   
   }
}
	
function loadPhoto(sourceId, targetId) {  
    
    if (typeof FileReader === 'undefined') {  
        alert('Your browser does not support FileReader...');  
        return;  
    }  
    var reader = new FileReader();  
  
    reader.onload = function(e) {  
        var img = document.getElementById(targetId);  
        img.src = this.result;  
    }  
    reader.readAsDataURL(document.getElementById(sourceId).files[0]);  

    $("#teacherPhoto").val($("#teacherIMG").val());
}

function loadTeachersByFilter (){
    var teacher = {
            "teacher.t_name":$("#teachername").val(),
            "teacher.t_zhuanYe":$("#filterZY").val(),
            "teacher.t_leiXing":$("#filterXL").val()
        };
   $.ajax({
	       type:"post",
	        url:"<%=basePath%>teacher/TeacherAction_loadTeachersByFilter",
	        data:teacher,
	        dataType:"json",
	        success : function(teacherData){
	          $("#list_data").datagrid("loadData",teacherData);
	        }
	    });
}

function  openOrClosePages(){
   $("#list_data").attr("pagination",false);
}
</script>
	</head>
	<body class="easyui-layout">
       
		<div id="search" style="padding-top: 3px;">
			<a href="javascript:void(0)"  class="easyui-linkbutton"
				iconCls="icon-add" plain="true" onclick="newProvider()">增加</a>
			<a href="javascript:void(0)"  class="easyui-linkbutton"
				iconCls="icon-edit" plain="true" onclick="modifyProvider()">修改</a>
			<a href="javascript:void(0)"  class="easyui-linkbutton"
				iconCls="icon-remove" plain="true" onclick="delProvider()">删除</a>
			
			<input type="text" id="teachername"  placeholder="输入老师的姓名"
				style="width: 100px"></input>
			<label>专业</label>	
			<select  id="filterZY"  class="easyui-combo" name="teacher.t_zhuanYe"  style="width:100px;">   
			    <option value="ALL">全部</option>
			    <option value="Java">Java</option>   
			    <option value=".Net">.Net</option>   
			    <option value="UI">UI</option>   
			    <option value="UI">Web</option>
			    <option value="IOS">IOS</option>   
			    <option value="Android">Android</option>   
			    <option value="HTML5">HTML5</option>   
			</select>  	
			<label>类型</label>
			<select id="filterXL" class="easyui-combo" value="高级讲师" name="teacher.t_leiXing"  style="width:100px;">   
			    <option value="ALL">全部</option>
			    <option value="高级讲师">高级讲师</option>   
			    <option value="助教">助教</option>   
			    <option value="班主任">班主任</option>   
			</select>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-search" plain="true"   onclick="loadTeachersByFilter()">查询</a>
				
			<!-- <a id="openPages" href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-user-pages" plain="true"   onclick="openOrClosePages()">关闭分页</a>	 -->
		</div>

		<div region="center" border="false">
			<table id="list_data" cellspacing="0" cellpadding="0"
				style="display: none">
			</table>
		</div>
		<div id="provider-window"  title="教师信息"
			style="width: 680px; height: 450px;">
			 <div id="showMassage"  class="align-center"></div>
			<div style="padding: 5px 5px 5px 5px;">
				<form method="post" enctype="multipart/form-data">
					<table bgcolor="#C1DAD7" width="600px" align="center"
						style="align: center" border="0">
						<input id="teacherID" name="teacher.t_id" type="hidden" value="1" ></input>
						<tr>
							<td class="teacherLabel">
								教师姓名：
							</td>
							<td >
								<input id="TeacherName"  name="teacher.t_name" class="easyui-validatebox" maxlength="20"
									data-options="required:true,validType:'length[1,20]'"style="width:130px"></input>
							</td>
							<td class="form_content" align="right">
								<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>电话：
							</td>
							<td class="teacherLabel">
								<input id="TeacherPhone"   name="teacher.t_phone" class="easyui-numberbox" style="width:130px"></input>
							</td>
						</tr>
						<tr >
							<td class="teacherLabel">
								登录账号：
							</td>
							<td >
								<!-- <input id="teacherLoginName" onblur="checkLoginName(this)" name="teacher.t_account" class="easyui-validatebox" maxlength="20"
									data-options="required:true,validType:'length[1,20]'"></input> -->
							<input id="teacherLoginName"    name="teacher.t_account" style="width:130px"/>
							</td>
							<td style="text-align: right;">
							 <table border="0" style="width: 100%;height: 100%">
							   <tr><td style="text-align: left;"><label id="checkMessage"></label></td><td style="text-align: right;widdth:180px">密码：</td></tr>
							 </table>
							</td>
							<td >
								<input id="TeacherPassWord"  type="password"  name="teacher.t_pass" class="easyui-validatebox" maxlength="20"
								data-options="required:true,validType:'length[1,20]'" style="width:130px"
								></input>
							</td>
						</tr>
						<tr >
							<td class="teacherLabel">
								教师性别：
							</td>
							<td >
								<input id="checkMan" type="radio" checked value="男" name="teacher.t_sex">男
								<span></span>
								<input type="radio" value="女" name="teacher.t_sex">女
							</td>
							<td style="text-align: right;">
							 <table border="0" style="width: 100%;height: 100%">
							   <tr><td style="text-align: left;"><label id="checkMessage"></label></td><td style="text-align: right;widdth:180px">所属班级：</td></tr>
							 </table>
							</td>
							<td >
								<input id="teacherClass" name="teacher.t_class" class="easyui-combobox" data-options="valueField:'c_name',textField:'c_name',url:'<%=basePath%>classes/classesAction!selectClass'"/>
							</td>
						</tr>
						<tr>
							<td class="teacherLabel">
								执教专业：
							</td>
							<td >
								<select  id="teacherZY"  class="easyui-combo" name="teacher.t_zhuanYe" style="width:100px;">   
								    <option value="Java">Java</option>   
								    <option value=".Net">.Net</option>
								    <option value="UI">Web</option>   
								    <option value="UI">UI</option>   
								    <option value="IOS">IOS</option>   
								    <option value="Android">Android</option>   
								    <option value="HTML5">HTML5</option>   
								</select>  
							</td>
							<!--<td id = "teacherCl" >班级
								<input id="teacherClass" name="teacher.t_class" />
							</td>
							--><td align="right">
								执教类型：
							</td>
							
							<td >
								<select id="teacherLX" class="easyui-combo" value="高级讲师" name="teacher.t_leiXing" >   
								    <option value="高级讲师">高级讲师</option>   
								    <option value="助教">助教</option>   
								    <option value="班主任">班主任</option>   
								</select>  
							</td>
							
						</tr>
						<tr style="height: 100px;">
							<td class="teacherLabel">
								教师简介：	
							</td>
							<td colspan="3" >
								<textarea id="TeacherSynopsis"  style="height: 100%;width: 100%"  name="teacher.t_jianJie"></textarea>
							</td>
						</tr>
						<tr style="height: 110px;">
							<td class="teacherLabel">
								教师照片：
							</td>
							<td colspan="3">
							    <div  style="height: 110px;width:300px;overflow: auto;"><img id="showTeacherPhoto"  width="100%" height="100%" alt="教师照片" src="<%=basePath%>images/teachers/default.png"></div>
								<input id="teacherIMG" name="teacherImg" onchange="loadPhoto(this.id,'showTeacherPhoto')" type="file" alt="上传图片" >
								<input id="teacherPhoto"   name="teacher.t_photo" type="hidden" ></input>
							</td>
						</tr>
						<!-- <tr>
							<td class="teacherLabel">
								联系电话：
							</td>
							<td colspan="3" class="form_content">
								<textarea style="height: 30px;"  name="t_jianJie"></textarea>
							</td>
						</tr> -->
						<tr>
							<td  colspan="4" style="text-align: center">
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