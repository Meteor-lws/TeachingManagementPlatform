// JavaScript Document

var comments=document.getElementsByTagName("textarea")[0];

comments.onfocus=function (){
	if(this.value=="˵��ʲô..."){
		this.value="";
	}
	
	}
comments.onblur=function (){
	if(this.value==""){
		this.value="˵��ʲô...";
		this.style="#999";
		}else{
			this.style.color="#444";
			}
	}
/*��ʾ��*/
var prompter=document.getElementsByClassName("prompt")[0];
var prompter_ok=prompter.getElementsByTagName("input")[0];
var prompter_no=prompter.getElementsByTagName("input")[1];
var prompter_tip=prompter.getElementsByTagName("p")[0];

function submitInf(v){
	if(comments.value=="˵��ʲô..." || comments.value==""){
		alert("请填写意见，才能提交！");
		return false;
	}else{
		prompter.style.display="block";
		prompter_no.onclick=function (){prompter.style.display="none"};
		}
	}

function resetInf(v){
	if(comments.value=="˵��ʲô..." || comments.value==""){
		return false;
	}else{
		prompter.style.display="block";
		prompter_ok.type="reset";
		prompter_ok.onclick=function (){prompter.style.display="none"};
		prompter_no.onclick=function (){prompter.style.display="none"};
		}
	}
