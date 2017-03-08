<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<script type="text/javascript" src="<%=basePath %>scripts/jquery-easyui-1.3/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=basePath %>scripts/jquery-easyui-1.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath %>scripts/jquery-easyui-1.3/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" href="<%=basePath %>scripts/jquery-easyui-1.3/themes/default/easyui.css" type="text/css"></link>
<link rel="stylesheet" href="<%=basePath %>scripts/jquery-easyui-1.3/themes/icon.css" type="text/css"></link>
<link  href="<%=basePath %>styles/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath %>scripts/common/jquery.pmsystem.messager.js"></script>

<link rel="stylesheet" href="<%=basePath %>styles/css2007.css" type="text/css"></link>



<script type="text/javascript">

function showPopupWindow(tit,url,wi,ht,load){
	if(!top || !top.window || !top.window.showWindow)
		return;
	
	if(!load)
		load = function(){};
	
	top.window.showWindow({
 			title:tit,
 			href:url,
 			width:wi,
 			height:ht,
 			onLoad:load
 		});
}

function showAlert(title,msg){
	if(!top || !top.window )
		return;
	top.window.showMessage(title,msg,null);
}

function showWarning(title,msg){
	if(!top || !top.window )
		return;
	top.window.showMessage(title,msg,"warning");
}

function showInfo(title,msg){
	if(!top || !top.window )
		return;
	top.window.showMessage(title,msg,"info");
}

function showError(title,msg){
	if(!top || !top.window )
		return;
	top.window.showMessage(title,msg,"error");
}

function showQuestion(title,msg){
	if(!top || !top.window )
		return;
	top.window.showMessage(title,msg,"question");
}

function showConfirm(title,msg,callback){
	if(!top || !top.window )
		return;

	if(!callback)
		callback = function(){};
	top.window.showConfirm(title,msg,callback);
}

</script>

