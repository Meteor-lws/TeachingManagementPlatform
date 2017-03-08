<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>瑞才科技投票系统</title>
		<link rel="stylesheet" href="<%=basePath%>css/base.css"  />
		<link rel="stylesheet" href="<%=basePath%>css/login.css"  />
	</head>
	<body>
		<div class="wrap">
			<div class="header">
				<div class="logo">
					<img src="<%=basePath%>images/logo.png" alt="" />
				</div>
			</div>
			<div class="content">
				<div class="myform">
					<form method="post" action="<%=basePath%>login/login.do" onsubmit="return mysubmit();">
						<h3>瑞才账号登录</h3>
						<div class="checkPerson">
						<input type="radio" id="admin" name="leixing" value="0" /><label for="admin">管理登录</label>
						<input type="radio" id="student" name="leixing" value="1" checked/><label for="student">学员登录</label>
<%--						<input type="radio" id="teacher" name="leixing" value="2"/><label for="teacher">教师登录</label>--%>
						</div>
						<input type="text" id="userId" name="adminName" placeholder = "请输入你的学号"/><br/>
						<input type="password" id="pwd" name="adminPass" placeholder = "请输入你的密码"/><br/>
						<input type="submit" id="sub" value="登录" /><br/>
						<p><input type="checkbox" name="isLogining" id="isLogining" />
						<label for="isLogining">自动登录</label></p>
						
					</form>
					
				</div>
			</div>
			<div class="footer">
				武汉瑞才教育科技有限公司版权所有<span>鄂ICP备15014867号-1</span>
			</div>
		</div>
		<script type="text/javascript">
			var persons = document.getElementsByName("leixing");
			var userId = document.getElementById("adminName");
			var pwd = document.getElementById("adminPass");
			var userIdTest;
			var pwdTest;
			if(persons[0].checked){
				userId.value="xxxx";
				pwd.value="aaaa";	
			}
			for(var i=0;i<persons.length;i++){
				
				persons[i].onclick = function(){
					userId.value="请输入您的学号";
					pwd.value="";
					if(this.value==0){
						userId.value="xxxx";
						pwd.value="aaaa";
					}
				}
			}
			userId.onblur = function myblur(){
				if(userId.value==""){
					userId.value="请输入您的学号";
				}
				
			}
			userId.onfocus = function myfocus(){
				if(userId.value=="请输入您的学号"){
					userId.value="";
				}
			}
			function mysubmit(){
				if(userId.value==""){
					return false;
				}
				if(pwd.value==""){
					return false;
				}
			}
		</script>
	</body>
</html>