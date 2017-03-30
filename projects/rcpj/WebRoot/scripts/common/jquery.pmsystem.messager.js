(function($) {
	
	var defaults = {ok:"确定",cancel:"取消"};
	
	
	$.extend( {pmsystem:{
		
		showAlert:function(msg,title){
			$.pmsystem.alert(title?title:$.pmsystem.constants.title_error,
					msg,null);
		},
		
		showInfo:function(msg,title) {
			$.pmsystem.alert(title?title:$.pmsystem.constants.title_info,
					msg,"info");
		},
		
		showError:function(msg,title){
			$.pmsystem.alert(title?title:$.pmsystem.constants.title_error,
					msg,"error");
		},
		
		showWarning:function(msg,title){
			$.pmsystem.alert(title?title:$.pmsystem.constants.title_warning,
					msg,"warning");
		},
		
		showQuestion:function(msg,title){
			$.pmsystem.alert(title?title:$.pmsystem.constants.title_question,
					msg,"question");
		},
		
		showConfirm:function(msg,callback,title){
			if(!callback)
				callback = function(){};
				
			$.pmsystem.confirm(title?title:$.pmsystem.constants.title_confirm,
					msg,callback)
		},
		
		alert:function(title,msg,type){
			$.messager.alert(title,msg,type);
		},
		
		confirm:function(title,msg,callback){
			$.messager.confirm(title,msg,callback);
		},
		
		constants:{
			title_error:"错误1",
			title_sys_error:"系统错误",
			title_fatal:"致命错误",
			title_info:"信息",
			title_warning:"警告",
			title_question:"询问",
			title_confirm:"确认操作"
		}
		
	}});
	
	//设置按钮的默认文本
	$.messager.defaults = defaults;
	
})(jQuery);