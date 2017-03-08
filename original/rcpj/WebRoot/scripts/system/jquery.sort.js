(function($) {
	
	var options ={
		normalColor:"#FFFFFF",
		selectedColor:"#FFFF00",
		overColor:"#AEEE00",
		onFirst:function(){},
		onLast:function(){},
		onNoRowSelected:function(){}
	}

	var selectRow = {
		backgroundColor : "#FFFF00"
	};

	var overRow = {
		backgroundColor : "#AEEE00"
	};

	var normalRow = {
		backgroundColor : "#FFFFFF"
	}

	$.fn.extend( {

		tableSort : function(opt) {
			if(opt){
				if(opt.normalColor)
					normalRow.backgroundColor = opt.normalColor;
				if(opt.selectedColor)
					selectRow.backgroundColor = opt.selectedColor;
				if(opt.overColor)
					overRow.backgroundColor = opt.overColor;
				if(opt.onFirst)
					options.onFirst = opt.onFirst;
				if(opt.onLast)
					options.onLast = opt.onLast;
				if(opt.onNoRowSelected)
					options.onNoRowSelected = opt.onNoRowSelected;
				
			}else{
				opt = options;
			}
		
			return $(this).each(function() {
				$(this).hover(function() {
					var color = $("td", $(this)).css("backgroundColor");
					if (color.toUpperCase() != selectRow.backgroundColor)
						$("td", $(this)).css(overRow);
				}, function() {
					var color = $("td", $(this)).css("backgroundColor");
					if (color.toUpperCase() != selectRow.backgroundColor)
						$("td", $(this)).css(normalRow);
				});

				$(this).click(function() {
					$("td", $(this).parent()).css(normalRow);
					$("td", this).css(selectRow);
				});
			})
		},

		up : function() {
			var row  = $(this).getSelected();
			
			if(row.size() > 0){
				var idx = $(this).index(row);
				if(idx>0){
					row.insertBefore(row.prev());
				}else{
					options.onFirst();
				}
			}else{
				options.onNoRowSelected();
			}
			return this;
		},

		down : function() {
			var row  = $(this).getSelected();
			if(row.size() > 0){
				var idx = $(this).index(row);
				if(idx < ($(this).size() - 1))
					row.insertAfter(row.next());
				else
					options.onLast();
			}else{
				options.onNoRowSelected();
			}
			return this;
		},

		setSelected : function(row) {
			
		},

		getSelected : function() {
			var selected = null;
			$(this).each(function(idx,row){
				var color = $("td", row).css("backgroundColor");
				if(color.toUpperCase() == selectRow.backgroundColor){
					selected = row;
					return false;
				}
			})
			return $(selected);
		},

		skipTo : function(idx) {
			var row = $(this).get(idx);
			if(row){
				$("td",$(row).parent()).css(normalRow);
				$("td",row).css(selectRow);
			}
			return this;
		}

	});

})(jQuery);