// JavaScript Document
//留言于评分情况切换
var tit1 = document.getElementById("tit1");     
	var tit2 = document.getElementById("tit2");
	var scoreDeail = document.getElementsByClassName("scoreDeail")[0];
	var leaveWord = document.getElementsByClassName("leaveWord")[0];
	tit1.onclick = function(){
		//alert(scoreDeail);
		scoreDeail.style.display="block";
		leaveWord.style.display="none";
		tit1.className="show";
		tit2.className="";
	}
	tit2.onclick = function(){
		leaveWord.style.display="block";
		scoreDeail.style.display="none";
		tit1.className="";
		tit2.className="show";
		ly();
	}


//弹出框
var prompt_box=document.getElementsByClassName("prompt")[0];
var prompt_ok=prompt_box.getElementsByTagName("input")[0];
var prompt_no=prompt_box.getElementsByTagName("input")[1];

function prompter(){
	prompt_box.style.display="block";
	prompt_ok.onclick=function (){prompt_box.style.display="none";check()};
	prompt_no.onclick=function (){prompt_box.style.display="none";};
	}

document.getElementById("getScore").onclick = function(){
	this.className="noClick";
}