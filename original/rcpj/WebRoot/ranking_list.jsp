<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>无标题文档</title>
<link href="<%=basePath%>css/base.css" rel="stylesheet"/>
<link rel="stylesheet" href="<%=basePath%>css/main.css"  />
<link href="<%=basePath%>css/ranking_list.css" rel="stylesheet"/>
</head>

<body>
<div class="wrap">
  <div class="header">
				<div class="head">
					<div class="top">
						<span>
						<c:if test ="${!empty teacher}">${sessionScope.teacher.t_account}</c:if>
						<c:if test="${!empty student}">${sessionScope.student.s_name}</c:if>
						</span>你好，欢迎访问瑞才教师评分系统！
						<a class="fr" href="<%=basePath%>login/login!exit">[退出]</a>
					</div>
					<div class="logo fl">
						<img src="<%=basePath%>images/logo.png" alt="" />
					</div>
					<ul class="nav fr">
						<li><a href="<%=basePath%>index.jsp">全部教师</a></li>
<!--						<li><a class="showMainNav" href="<%=basePath%>ranking_list.jsp">排行榜</a></li>-->
						<li><a href="<%=basePath%>history.jsp">历史记录</a></li>
					</ul>
				</div>
			</div>

  <div class="container">
  <!--导航-->
  	<ul class="nav2">
    	<li class="curr_area"><a href="<%=basePath%>ranking_list.jsp">总排行榜</a></li>
        <li><a href="<%=basePath%>index.jsp">高端UI榜</a></li>
        <li><a href="<%=basePath%>index.jsp">Android榜</a></li>
        <li><a href="<%=basePath%>index.jsp">WEB前端榜</a></li>
        <li><a href="<%=basePath%>index.jsp">Java榜</a></li>
        <li><a href="<%=basePath%>index.jsp">HTML5榜</a></li>
    </ul>
    <!--排行榜分栏-->
    <ol>
    	<li>
        	<div class="avatar"><img src="<%=basePath%>images/avatar_lmx.png"></div>
            <dl>
            	<dt>NO.1</dt>
                <dd>李濛晰</dd>
                <dd>高级UI讲师</dd>
            </dl>
            <div class="comment">
                <h4>评语：</h4>
                <p>                老师授课的方式非常适合我们，他根据本课程知识结构的特点，重点突出，层次分明。
    理论和实际相结合，通过例题使知识更条理化。但授课速度有点快，来不及记录。
                </p>
            </div>
        </li>
        <li>
        	<div class="avatar"><img src="<%=basePath%>images/avatar_lmx.png"></div>
            <dl>
            	<dt>NO.2</dt>
                <dd>李濛晰</dd>
                <dd>高级UI讲师</dd>
            </dl>
            <div class="comment">
                <h4>评语：</h4>
                <p>                老师授课的方式非常适合我们，他根据本课程知识结构的特点，重点突出，层次分明。
    理论和实际相结合，通过例题使知识更条理化。但授课速度有点快，来不及记录。
                </p>
            </div>
        </li>
        <li>
        	<div class="avatar"><img src="<%=basePath%>images/avatar_lmx.png"></div>
            <dl>
            	<dt>NO.3</dt>
                <dd>李濛晰</dd>
                <dd>高级UI讲师</dd>
            </dl>
            <div class="comment">
                <h4>评语：</h4>
                <p>                老师授课的方式非常适合我们，他根据本课程知识结构的特点，重点突出，层次分明。
    理论和实际相结合，通过例题使知识更条理化。但授课速度有点快，来不及记录。
                </p>
            </div>
        </li>
        <li>
        	<div class="avatar"><img src="<%=basePath%>images/avatar_lmx.png"></div>
            <dl>
            	<dt>NO.4</dt>
                <dd>李濛晰</dd>
                <dd>高级UI讲师</dd>
            </dl>
            <div class="comment">
                <h4>评语：</h4>
                <p>                老师授课的方式非常适合我们，他根据本课程知识结构的特点，重点突出，层次分明。
    理论和实际相结合，通过例题使知识更条理化。但授课速度有点快，来不及记录。
                </p>
            </div>
        </li>
     </ol>  
  <!--分页-->
  <div class="page">
  	<dl>
    	<input type="image" src="<%=basePath%>images/06_left.png" value="firstpg"/>
        <input type="button" value="1" class="curr_page"/>
        <input type="button" value="2"/>
        <input type="button" value="3"/>
        <input type="image" src="<%=basePath%>images/07_right.png" value="lastpg"/>
    </dl>
    <div class="go_page">
    	<span>跳转到：</span>
        <input type="text"/>
        <input type="image" src="<%=basePath%>images/05_go.png" value="GO">
    </div>
  </div>
  </div>

  <div class="footer">
					武汉瑞才教育科技有限公司版权所有<span>鄂ICP备15014867号-1</span>
	</div>
</div>
<script src="<%=basePath%>js/ranking_list.js"></script>
</body>
</html>
