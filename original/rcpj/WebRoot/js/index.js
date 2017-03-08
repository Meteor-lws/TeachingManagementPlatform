function getClass(clsname){
	var tags = document.getElementsByTagName("*");
	var arr = [];
	for(var i=0;i<tags.length;i++){
		if(tags[i].className == clsname){
			arr.push(tags[1]);
		}
	}
	return arr;
}

//var banner = document.getElementsByName("main_banner");
			//var lis = banner
var left = document.getElementsByName("main_leftbut");
var right = document.getElementsByName("main_rightbut");

var timer1,timer2;
for(var i=0;i<left.length;i++){
	left[i].index=i;
	right[i].index=i;
	left[i].onclick = function(data){
		
		//var ss=data.srcElement;
		clearInterval(timer1);
		//var lis = banner[this.index].getElementsByTagName("li");
		var lis = $(".banner").eq(this.index).find("li");
		var ban = $(".banner").get(this.index);
		timer1 = setInterval(function(){
			// if($(ss).attr("canUse")=="true"){
				if(ban.offsetLeft>=0){
					clearInterval(timer1);
					//$(ss).css("background","#ddd");
				}else{
					ban.style.left=ban.offsetLeft + (lis[0].offsetWidth+24)/12+"px";
					if(ban.offsetLeft%(lis[0].offsetWidth+24)==0){
						clearInterval(timer1);
					//$(ss).css("background","#ddd");
					}
				}
//				var rit=$(ss).next();
//				if(ban.offsetLeft<=-(lis[0].offsetWidth+24)*lis.length){
//					$(rit).attr("canUse","false");
//					$(rit).css("background","#ddd");
//		        }else{
//		        	$(rit).attr("canUse","true");
//		        	$(rit).css("background","#21D3D1");
//		        }
//			 }
		},50);
		

	};
	
	right[i].onclick = function(data){
		//var ss=data.srcElement;
		clearInterval(timer2);
		var inde = this.index;
		//var lis = banner[this.index].getElementsByTagName("li");
		var lis = $(".banner").eq(this.index).find("li");
		var ban = $(".banner").get(this.index);
		
		timer2 = setInterval(function(){
		  //if($(ss).attr("canUse")=="true"){
			if(ban.offsetLeft<=-((lis[0].offsetWidth+24)*lis.length-(lis[0].offsetWidth+24)*5)){
				clearInterval(timer2);
				//$(ss).css("background","#ddd");
			}else{
				ban.style.left=ban.offsetLeft - (lis[0].offsetWidth+24)/12+"px";
				if(ban.offsetLeft%(lis[0].offsetWidth+24)==0){
					clearInterval(timer2);
					//$(ss).css("background","#ddd");
				}
			}
//			var lef=$(ss).prev();
//			if(ban.offsetLeft>=0){
//				$(lef).attr("canUse","false");
//				$(lef).css("background","#ddd");
//	        }else{
//	        	$(lef).attr("canUse","true");
//	        	$(lef).css("background","#21D3D1");
//	        }
//		  }	
		},50);
	};
	
}