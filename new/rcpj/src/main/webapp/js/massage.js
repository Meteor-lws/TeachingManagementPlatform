// JavaScript Document
var prompt_box=document.getElementsByClassName("prompt")[0];
var prompt_ok=prompt_box.getElementsByTagName("input")[0];
var prompt_no=prompt_box.getElementsByTagName("input")[1];

function prompter(){
	prompt_box.style.display="block";
	prompt_ok.onclick=function (){prompt_box.style.display="none";};
	prompt_no.onclick=function (){prompt_box.style.display="none";};
	}

document.getElementById("getScore").onclick = function(){
	this.className="noClick";
}