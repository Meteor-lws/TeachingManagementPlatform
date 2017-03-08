(function($) {
	
	var options ={
		iconCls:'icon-save',
		autoRowHeight: false,
		striped: false,
		collapsible:false,
		url:'',
		remoteSort: false,
		fitColumns:true,
		striped:true,
		rownumbers:true,
		singleSelect:true,
		pagination:true,
		loadMsg:"正在加载数据，请稍候..."
	};
	
	var pageOptions = {
		pageSize:12,
		showPageList:false,
		beforePageText:"第",
		afterPageText:"页    共 {pages} 页",
		displayMsg:"当前显示 {from} 到 {to} 条记录   共 {total} 条记录"	
	};

	$.fn.extend( {
		
		getOptions:function(){
			return options;
		},
		
		setupDatagrid:function(){
			$(this).datagrid(options);
			
			if(options.pagination){
				var pager = $(this).datagrid("getPager");
				$(pager).pagination(pageOptions)
			}
			
			return $(this);
		},
		
		setTitle:function(title){
			options.title = title;
			return $(this);
		},
		
		setIconCls:function(cls){
			options.iconCls = cls;
			return $(this);
		},
		
		setUrl:function(url){
			options.url = url;
			return $(this);
		},
		
		setColumns :function(col){
			options.columns = col;
			return $(this);
		},
		
		setFrozenColumns : function(fcol){
			options.frozenColumns = fcol;
			return $(this);
		},
		
		addColumn : function(col){
			
			if(!options.columns){
				var arr = new Array();
				arr [0] = new Array();
				options.columns = arr;
			}
			options.columns[0].push(col);
			
			return $(this);
		},
		
		addFrozenColumn : function(fcol){
			if(!options.frozenColumns){
				var arr = new Array();
				arr [0] = new Array();
				options.frozenColumns = arr;
			}
			options.frozenColumns[0].push(fcol);
			
			return $(this);
		},
		
		setToolbar:function(tb){
			options.toolbar = tb;
			return $(this);
		},
		
		addToolbarItem:function(tool){
			if(!options.toolbar)
				options.toolbar = new Array();
			options.toolbar.push(tool);
			return $(this);
		},
		
		setLoadMsg:function(msg){
			options.loadMsg = msg;
			return $(this);
		},
		
		setMethod:function(method){
			options.method = method;
			return $(this);
		},
		
		setSingleSelect:function(single){
			options.singleSelect = single;
			return $(this);
		},
		
		setPagination:function(pagination){
			options.pagination = pagination;
			return $(this);
		},
		
		setPageSize:function(size){
			pageOptions.pageSize = size;
			return $(this);
		},
		
		deleteCurrentRow:function(){
			var row = $(this).datagrid("getSelected");
			if(row){
				var index =  $(this).datagrid("getRowIndex",row);
				$(this).datagrid("deleteRow",index);
			}
			return $(this);
		},
		
		getSelectedRowIndex:function(){
			var row = $(this).datagrid("getSelected");
			if(row){
				var index =  $(this).datagrid("getRowIndex",row);
				return index;
			}
			
			return -1;
		},
		
		getRowData:function(idx){
			var data = $(this).datagrid("getData");
			return data.rows[idx];
		},
		
		isFirst:function(){
			if($(this).getSelectedRowIndex() == 0)
				return true;
			else
				return false;
		},
		
		isLast:function(){
			
		},
		
		moveUp:function(){
			var idx = $(this).getSelectedRowIndex();
			var data = $(this).getRowData(idx);
			
			
			$(this).datagrid("deleteRow",idx);
			$(this).datagrid('insertRow',{
				index: (idx-1),	
				row:data
			});
		}
		
		
		
	});

})(jQuery);