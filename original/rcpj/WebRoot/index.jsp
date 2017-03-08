<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.ruicai.edu.entity.Student"%>
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
		<link rel="stylesheet" href="<%=basePath%>css/index.css"  />
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
							<li><a class="showNav" href="javascript:"onclick="loadTeachersByStudent()">评教老师</a></li>
							<li><a href="javascript:;" onclick="getTeacherByZY('ALL',this)">全部老师</a></li>
							<li><a href="javascript:" onclick="getTeacherByZY('UI',this)">UI</a></li>
							<li><a href="javascript:" onclick="getTeacherByZY('.Net',this)" >.Net</a></li>
							<li><a href="javascript:" onclick="getTeacherByZY('Web',this)" >Web</a></li>
							<li><a href="javascript:" onclick="getTeacherByZY('IOS',this)" >IOS</a></li>
							<li><a href="javascript:" onclick="getTeacherByZY('Java',this)">Java</a></li>
							<li><a href="javascript:" onclick="getTeacherByZY('Android',this)">Android</a></li>
							<li><a href="javascript:" onclick="getTeacherByZY('HTML5',this)">HTML5</a></li>
						</ul>
						<div class="search fr">
							<input type="text" id="search" value="搜索老师" onblur="getTeacherByZY('',null)"
							onfocus="if(this.value=='搜索老师'){this.value=''}" />
						</div>
					</div>
					<div class="content_detail">
						<h3>高级讲师</h3>
						<div class="bannerBox">
							<ul id="mainTeacher" class="banner" name="main_banner">
								<!-- 存放高级讲师的位置 -->

							</ul>
						</div>
						
						<a class="left"  canUse="false" href="javascript:" name="main_leftbut" > < </a>
						<a class="right" canUse="true" href="javascript:" name="main_rightbut"> > </a>
					</div>
					
					<div class="content_detail">
						<h3>班主任</h3>
						<div class="bannerBox">
							<ul id="classroomTeacher" class="banner" name="main_banner">
								<!-- 存放班主任的位置 -->
							</ul>
						</div>
						<a class="left" canUse="false" href="javascript:" name="main_leftbut" > < </a>
						<a class="right" canUse="true" href="javascript:" name="main_rightbut"> > </a>
					</div>
					
					<div class="content_detail">
						<h3>助教</h3>
						<div class="bannerBox">
							<ul id="assistantTeacher" class="banner" name="main_banner">
								<!-- 存放助教的位置 -->
							</ul>
						</div>
						
						<a class="left" canUse="false" href="javascript:" name="main_leftbut" > < </a>
						<a class="right" canUse="true" href="javascript:" name="main_rightbut"> > </a>
					</div>
					
				</div>
			</div>
			<div class="footer">
					武汉瑞才教育科技有限公司版权所有<span>鄂ICP备15014867号-1</span>
			</div>
		</div>

		<script type="text/javascript" src="<%=basePath %>js/index.js"></script>
		<script type="text/javascript" src="<%=basePath %>scripts/jquery-easyui-1.3/jquery-1.7.2.min.js"></script>\
		<script type="text/javascript">
		var currentZY="ALL";
		var currentLX="ALL";
		var teacherName="";
       <%
           System.out.println(session.getAttribute("student").toString());
		   Student student=(Student)session.getAttribute("student");
		%>
		var stdentID="<%=student.getS_id()%>"; 
		//初次加载时load事件
		$(function(){
			//getTeacherByLX();
			loadTeachersByStudent();
			pingjia();
		});
	function pingjia()
	{
	  $.ajax({
	    type:"post",
	    url:"<%=basePath%>relation/relationAction!findbyid",
	    data:{"r_sid":stdentID},
	    //dataType:"json", 
	  success:function(data)
	  {
	 
	    var one= data[0].r_type;
	    var two=data[1].r_type;
	    var name=data[0].r_tid;
	     var lengths= eval(data).length;
	    
	    for(var i=0; i<lengths;i++)
	    {
	       if(data[i].r_type==0)
	       {
	       		var namess= data[i].r_tid;
	          	document.getElementById(namess).href="javascript:void(0);";
	          	document.getElementById(namess).style.backgroundColor="#ccc";
	          	
	       }
	    }
	  }
	  });
	}	
		
	function loadTeachersByStudent(){
			$.ajax({
     	       type:"post",
     	        url:"<%=basePath%>teacher/TeacherAction_loadTeachersByStudentID?studentID="+stdentID,
     	        dataType:"json",
     	        success : function(data){
     	        //清空高级教师信息
     	      	 var mainTeacher=$("#mainTeacher");
     	      	 mainTeacher.find("li").remove();
     	      	 //清空助教信息
     	      	 var assistantTeacher=$("#assistantTeacher");
     	      	 assistantTeacher.find("li").remove();
     	      	 //清空班主任信息
     	      	 var classroomTeacher=$("#classroomTeacher");
     	      	 classroomTeacher.find("li").remove();
     	      	 data=eval(data);
	     	      	if(null!=data){
	     	      		var panner;
	    	            for(var i=0;i<data.length;i++){
	    	            	  if(data[i].t_leiXing=="高级讲师"){panner=mainTeacher}
	    	            	  else if(data[i].t_leiXing=="助教"){panner=assistantTeacher}
	    	            	  else{panner=classroomTeacher}		
	    	            	  
	    	                  var urlPJ="<%=basePath%>detail.jsp?teacherID="+data[i].t_id;
	    	                  var urlPF="<%=basePath%>pinjia/pin_choiceStudent?teacherID="+data[i].t_id;
	    	                  panner.append("<li><a href='"+urlPJ+"'><img  src='<%=basePath%>images/teachers/"+data[i].t_photo+"' alt='"+data[i].t_name+"' /></a>"+
	    	                   "<div class='provice'><h4>"+data[i].t_name+"</h4><p>"+data[i].t_jianJie+"</p></div><a id='"+data[i].t_id+"' class='judge judge1' href='"+urlPF+"'>评教</a></li>");
	    	            } 
	    	            
	    	        }
     	        }
     	   });
		}
		
	 function getTeacherByZY(zyType,data){
		 if(zyType!=""){
			 currentZY=zyType;
			 $(".showNav").removeClass("showNav");
			 //data.className="showNav";
			  $(data).addClass("showNav");
			 getTeacherByLX();
		 }else{
			 var name=$("#search").val();
			 if(name==""){
				 $("#search").val("搜索老师");
				 teacherName="";
			 }else{
				 teacherName=$("#search").val();
				 currentZY="ALL";
				 currentLX="ALL";
				 getTeacherByLX();
			 }
		 }
		 
	 }
		
	 function getTeacherByLX(){
		 
		//获取高级教师信息
    	 var mainTeacher=$("#mainTeacher");
    	 currentLX="高级讲师";
    	 mainTeacher.find("li").remove();
    	 loadTeachersByFilter(teacherName,currentZY,currentLX,mainTeacher);
    	 //获取助教信息
    	 var assistantTeacher=$("#assistantTeacher");
    	 currentLX="助教";
    	 assistantTeacher.find("li").remove();
    	 loadTeachersByFilter(teacherName,currentZY,currentLX,assistantTeacher);
    	 //获取班主任信息
    	 var classroomTeacher=$("#classroomTeacher");
    	 currentLX="班主任";
    	 classroomTeacher.find("li").remove();
    	 loadTeachersByFilter(teacherName,currentZY,currentLX,classroomTeacher);
		
	 }
		
		//根据条件查询老师
		//name:模糊查询老师名字
		//zy: 根据老师专业查询
		//lx：根据老师类型查询
		//panner： 显示信息的地方 
	    function loadTeachersByFilter(name,zy,lx,panner){
	    	var teacher = {
	                "teacher.t_name":name,
	                "teacher.t_zhuanYe":zy,
	                "teacher.t_leiXing":lx
	            };
	           $.ajax({
	        	       type:"post",
	        	        url:"<%=basePath%>teacher/TeacherAction_loadTeachersByFilter",
	        	        data:teacher,
	        	        dataType:"json",
	        	        success : function(data){
	        	            data=eval(data);
	        	            if(null!=data){
		        	            for(var i=0;i<data.length;i++){
		        	                  var urlPJ="<%=basePath%>detail.jsp?teacherID="+data[i].t_id;
		        	                  var urlPF="<%=basePath%>pinjia/pin_choiceStudent?teacherID="+data[i].t_id;
		        	                  panner.append("<li><a href='"+urlPJ+"'><img  src='<%=basePath%>images/teachers/"+data[i].t_photo+"' alt='"+data[i].t_name+"' /></a>"+
		        	                   "<div class='provice'><h4>"+data[i].t_name+"</h4><p>"+data[i].t_jianJie+"</p></div></li>");
		        	            } 
		        	            panner.attr("width",300*data.length);
		        	        }
	        	        }
	        	    });
	    		
	    		}
		</script>
	</body>
</html>