<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
		<link rel="stylesheet" href="<%=basePath%>css/main.css"  />
		<link rel="stylesheet" href="<%=basePath%>css/teacher.css"  />
	</head>
	<body>
		<div class="wrap">
			<div class="header">
				<div class="head">
					<div class="top">
						<span>
						<c:if test ="${!empty teacher}">${sessionScope.teacher.t_account}</c:if>
						<c:if test="${!empty student}">${sessionScope.student.s_name}</c:if>
						</span>你好，欢迎访问瑞才教育教师评分系统！
						<a class="fr" href="<%=basePath%>login/login!exit">[退出]</a>
					</div>
					<div class="logo fl">
						<img src="<%=basePath%>images/logo.png" alt="" />
					</div>
					<ul class="nav fr">
						<li><a class="showMainNav" href="<%=basePath%>index.jsp">全部教师</a></li>
<!--						<li><a href="<%=basePath%>ranking_list.jsp">排行榜</a></li>-->
						<li><a href="<%=basePath%>history.jsp">历史记录</a></li>
					</ul>
				</div>
			</div>
			<div class="container">
				<div class="content">
					<div class="content_top">
						<ul class="content_nav fl">
							<li><a class="showNav" href="<%=basePath%>teacher.jsp">评教老师</a></li>
							<li><a href="<%=basePath%>index.jsp">全部老师</a></li>
							<li><a href="">UI</a></li>
							<li><a href="">Web</a></li>
							<li><a href="">Java</a></li>
							<li><a href="">Android</a></li>
							<li><a href="">Html5</a></li>
						</ul>
						<div class="search fr">
							<input type="text" id="search" value="搜索" onblur="if(this.value==''){this.value='搜索'}"
							onfocus="if(this.value=='搜索'){this.value=''}" />
						</div>
					</div>
					<ul class="content_Detail">
						<h3>主讲老师</h3>
						<li>
							<img src="img3/lmx.png" alt="" />
							<div class="introduction">
								<h3>李濛晰( 高级UI课程研发部副总监,设计领域专家 )</h3>
								<p>个人简介：<br/>
								在设计领域有丰富的教学经验，资深视觉设计师，平面设计领域专家，曾任嬷嬷蜜网首席UI设计师、 近年来潜心研究移动端APP视觉界面设计，对于视觉设计有其独特的设计理念。喜欢～～～</p>
							</div>
							<a class="judge judge1" href="<%=basePath%>index.jsp">评教</a>
						</li>
						<li>
							<img src="<%=basePath%>img3/许亮.png" alt="" />
							<div class="introduction">
								<h3>许亮( 教学总监,资深嵌入式领域专家 )</h3>
								<p>个人简介：<br/>
								互联网+、物联网风云人物，参与园林飞鸟管理系统、智能家居等国内多个大中型项目开发，实战经验丰富。</p>
							</div>
							<a class="judge judge1" href="<%=basePath%>index.jsp">评教</a>
						</li>
					</ul>
					<ul class="content_Detail">
						<h3>助教老师</h3>
						<li>
							<img src="<%=basePath%>img3/余超.png" alt="" />
							<div class="introduction">
								<h3>余超</h3>
								<p>个人简介：<br/>
								在设计领域有丰富的教学经验，资深视觉设计师，平面设计领域专家，曾任嬷嬷蜜网首席UI设计师、 近年来潜心研究移动端APP视觉界面设计，对于视觉设计有其独特的设计理念。喜欢～～～</p>
							</div>
							<a class="judge judge1" href="<%=basePath%>index.jsp">评教</a>
						</li>
					</ul>
					<ul class="content_Detail">
						<h3>班主任</h3>
						<li>
							<img src="<%=basePath%>img3/夏珏.png" alt="" />
							<div class="introduction">
								<h3>夏珏</h3>
								<p>个人简介：<br/>
								在设计领域有丰富的教学经验，资深视觉设计师，平面设计领域专家，曾任嬷嬷蜜网首席UI设计师、 近年来潜心研究移动端APP视觉界面设计，对于视觉设计有其独特的设计理念。喜欢～～～</p>
							</div>
							<a class="judge judge1" href="<%=basePath%>index.jsp">评教</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="footer">
					武汉瑞才教育科技有限公司版权所有<span>鄂ICP备15014867号-1</span>
			</div>
		</div>

<script>
var chosenBlue=document.getElementsByClassName("chosen_blue")[0];

var score=5;             //分数更改
var points=Math.ceil(points/2);           //星级更改
document.getElementsByClassName("score")[0].innerHTML = score;
//alert(n);
chosenBlue.style.width=185-(10-score)*19+"px";
</script>
	</body>
</html>