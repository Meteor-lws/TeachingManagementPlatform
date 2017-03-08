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
		<link rel="stylesheet" href="<%=basePath%>css/history.css"  />
	</head>
	<body>
		<div class="wrap">
			<div class="header">
				<div class="head">
					<div class="top">
						<span>
						<c:if test ="${!empty teacher}">${sessionScope.teacher.t_account}</c:if>
						<c:if test="${!empty student}">${sessionScope.student.s_account}</c:if>
						</span>你好，欢迎访问瑞才教师评分系统！
						<a class="fr" href="<%=basePath%>login/login!exit">[退出]</a>
					</div>
					<div class="logo fl">
						<img src="<%=basePath%>images/logo.png" alt="" />
					</div>
					<ul class="nav fr">
						<li><a href="<%=basePath%>index.jsp">全部教师</a></li>
<!--						<li><a href="<%=basePath%>ranking_list.jsp">排行榜</a></li>-->
						<li><a class="showMainNav" href="<%=basePath%>history.jsp">历史记录</a></li>
					</ul>
				</div>
			</div>
			<div class="container">
				<div class="content">
					<p><a href="<%=basePath%>teacher.jsp">评教老师</a> > 历史评价记录</p>
					<ul class="title">
						<li>
							<select id="month" class="month">
								<option>1月</option><option>2月</option><option>3月</option>
								<option>4月</option><option>5月</option><option>6月</option>
								<option>7月</option><option>8月</option><option>9月</option>
								<option>10月</option><option>11月</option><option>12月</option>
							</select>
						</li>
						<li>评价</li>
					</ul>
					<ul class="chart">
						<li>
							<img src="<%=basePath%>images/17_lmx.png" alt="" />
							<div class="introduction">
								<h3>李濛晰</h3>
								<div class="grade">
									<div class="star_box">
										<div class="bg_grey"></div>
										<div class="chosen_blue"></div>
									</div>
									<p><span class="score">10</span><span>分</span></p>
								</div>
								<p>在设计领域有丰富的教学经验，资深视觉设计师，平面设计领域专家，曾任嬷嬷蜜网首席UI设计师、 近年来潜心研究移动端APP视觉界面设计，对于视觉设计有其独特的设计理念。喜欢～～～</p>
							</div>
						</li>
						<li>
							<img src="<%=basePath%>img2/许亮.png" alt="" />
							<div class="introduction">
								<h3>许亮</h3>
								<div class="grade">
									<div class="star_box">
										<div class="bg_grey"></div>
										<div class="chosen_blue"></div>
									</div>
									<p><span class="score">10</span><span>分</span></p>
								</div>
								<p>在设计领域有丰富的教学经验，资深视觉设计师，平面设计领域专家，曾任嬷嬷蜜网首席UI设计师、 近年来潜心研究移动端APP视觉界面设计，对于视觉设计有其独特的设计理念。喜欢～～～</p>
							</div>
						</li>
						<li>
							<img src="<%=basePath%>img2/余超.png" alt="" />
							<div class="introduction">
								<h3>余超</h3>
								<div class="grade">
									<div class="star_box">
										<div class="bg_grey"></div>
										<div class="chosen_blue"></div>
									</div>
									<p><span class="score">10</span><span>分</span></p>
								</div>
								<p>在设计领域有丰富的教学经验，资深视觉设计师，平面设计领域专家，曾任嬷嬷蜜网首席UI设计师、 近年来潜心研究移动端APP视觉界面设计，对于视觉设计有其独特的设计理念。喜欢～～～</p>
							</div>
						</li>
						<li>
							<img src="<%=basePath%>img2/夏珏.png" alt="" />
							<div class="introduction">
								<h3>夏珏</h3>
								<div class="grade">
									<div class="star_box">
										<div class="bg_grey"></div>
										<div class="chosen_blue"></div>
									</div>
									<p><span class="score">10</span><span>分</span></p>
								</div>
								<p>在设计领域有丰富的教学经验，资深视觉设计师，平面设计领域专家，曾任嬷嬷蜜网首席UI设计师、 近年来潜心研究移动端APP视觉界面设计，对于视觉设计有其独特的设计理念。喜欢～～～</p>
							</div>
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