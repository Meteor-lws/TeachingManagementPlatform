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
<title>教学评分系统 </title>
<link href="<%=basePath%>css/base.css" rel="stylesheet"/>
<link rel="stylesheet" href="<%=basePath%>css/main.css"  />
<link href="<%=basePath%>css/point_table.css" rel="stylesheet"/>
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
<!--						<li><a href="<%=basePath%>ranking_list.jsp">排行榜</a></li>-->
						<li><a href="<%=basePath%>history.jsp">历史记录</a></li>
					</ul>
				</div>
			</div>

  <div class="container">
    <form action="<%=basePath%>/grade/Grade!addGrade" method="post">
      <table width="1000" border="0" cellpadding="0" cellpadding="0">
        <caption>
        	教学评分系统
        </caption>
        <tr>
          <th width="748" scope="col">评分细则</th>
          <th width="300" scope="col">分数</th>
        </tr>
        
        <c:forEach items="${evaluates}" var="now" varStatus="s">
        <tr>
          <td>${s['count']}.${now.e_name}</td>
          <td>
          	<select style="width:80px;"   name="select" id="select1">
          		<option value="10">10</option>
          		<option value="9">9</option>
          		<option value="8">8</option>
          		<option value="7">7</option>
          		<option value="6">6</option>
          		<option value="5">5</option>
          		<option value="4">4</option>
          		<option value="3">3</option>
          		<option value="2">2</option>
          		<option value="1">1</option>
          		<option value="0">0</option>            		
            </select>
           </td>
        </tr>
        </c:forEach>
      </table>
      <div class="comment">
      	<h4>评论及意见</h4>
        <div><textarea name="advice" cols="" rows="" placeholder="说点什么..." ></textarea></div>
        <em>140个字以内</em>
      </div>
      <div class="set_btn">
      	<input name="" type="button" value="提交"  onclick="submitInf('您的评教已完成，是否确认提交？')"
        /><input type="button" value="重置" onclick="resetInf('重置后，您填写的信息将恢复原始状态，是否确认重置？')">
      </div>
      <div class="prompt">
    	<p>您的评教已完成，是否确认提交？</p>
        <input type="submit" value="确定"/>
        <input type="button" value="取消"/>
    </div>
    </form>
  </div>
  <div class="footer">
					武汉瑞才教育科技有限公司版权所有<span>鄂ICP备15014867号-1</span>
	</div>
	
</div>
<script src="<%=basePath%>js/point_table.js"></script>
</body>
</html>
