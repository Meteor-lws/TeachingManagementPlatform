<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>瑞才科技投票系统</title>
		<link rel="stylesheet" href="css/base.css"  />
		<link rel="stylesheet" href="css/main.css"  />
		<link rel="stylesheet" href="css/detail.css"  />
	</head>
	<script type="text/javascript" src="scripts/jquery-easyui-1.3/jquery-1.7.2.min.js"></script>
	<script type="text/javascript">
	  var teacher=$("#teacher");
	  var  liuyan=$("#liuyan");
	  var dd=${sessionScope.student.s_id}
	  $(function(){
							  $.ajax({
							   url:'liuyan/liuyanShow?t_id=<%=request.getParameter("teacherID")%>',
							   type:'post',
							   dataType:'json',
							   success:function(data)
							   {
								 json=eval(data);
								 if(data!=null){  
						             $.each(json, function (index, item) {  
						                 //循环获取数据    
						                 var b_id = json[index].b_id; 
						              
						                 $("#teacher").html("<img src='images/teachers/"+json[0].t_photo+"' alt='无图片' /><li class='person fl'><h4>"+json[0].t_name+"</h4><h4>专业:"+json[0].t_zhuanYe+"</h4>"+
												"<h4>类型:"+json[0].t_leiXing+"</h4><div class='but'><a href='javascript:void(0)' onclick='prompter()'>留言</a>"+
												"</div></li><li class='intro fr'><h3>个人简介：</h3>"+json[0].t_jianJie+"</li>");
						             });   
						         }  
							   } 
							 })
							 
						})
	  
	  function ly(){
	  $.ajax({
	   url:'liuyan/liuyanOnclick?t_id=<%=request.getParameter("teacherID")%>',
	   type:'post',
	   dataType:'json',
	   success:function(data){
	      data=eval(data);
		 if(data!=null){  
             $.each(data, function (index, item) {  
                 //循环获取数据    
                $("#liuyan").html("");	
				 for(var i=0;i<data.length;i++)
				 {		
			     $("#liuyan").html($("#liuyan").html()+"<li>"+data[i].s_name+"  <span>发表于:</span>   "+data[i].b_time+"<br/>"+data[i].b_ly+"</li>");
             }  
         });  
	   }
	   }
	 });
	 }
	  
	  
	  
	 function check()
	 {var texts=document.getElementById("text").value;
		if (texts.replace(/\s/g, '')==""||texts.replace(/\s/g, '')==null) {
                    alert("请输入内容");
                  return false;
     } 
		else
			{
			    $.ajax({
		   url:'liuyan/liuyanAdd.action?t_id=<%=request.getParameter("teacherID")%>&s_id=${sessionScope.student.s_id}',
		   type:'post',
		   dataType:'json',
		   data: $("#add").serializeArray(),
		   success:function(data){
		       $("#text").val(''); 
			   ly();
		   }
		   });
			}
	 }
	       
	</script>
	<body>
		<div class="wrap">
			<div class="header">
				<div class="head">
					<div class="top">&nbsp; 
						<span>
						<c:if test ="${!empty teacher}">${sessionScope.teacher.t_account}</c:if>
						<c:if test="${!empty student}">${sessionScope.student.s_name}</c:if>
						</span>你好，欢迎访问瑞才教育教师评分系统！
						<a class="fr" href="login.jsp">[退出]</a>
					</div>
					<div class="logo fl">
						<img src="images/logo.png" alt="" />
					</div>
					<ul class="nav fr">
						<li><a href="index.jsp">全部教师</a></li>
<!--						<li><a href="ranking_list.jsp">排行榜</a></li>-->
						<li><a href="history.jsp">历史记录</a></li>
					</ul>
				</div>
			</div>
			<div class="container">
				<ul class="content-person" id="teacher">
<!--					<img src="images/17_头像.png" alt="" />-->
<!--					<li class="person fl">-->
<!--						<h4>讲师：李濛晰</h4>-->
<!--						<h4>班级：高级UI1605班</h4>-->
<!--						<h4>标签：</h4>-->
<!--						<div class="but">-->
<!--							<a class="canClick" id="getScore" href="point_table.html">评分</a>-->
<!--							<a href="javascript:void(0)" onclick="prompter()">留言</a>-->
<!--						</div>-->
<!--						-->
<!--					</li>-->
<!--					<li class="intro fr">-->
<!--						<h3>个人简介：</h3>-->
<!--						<p>高级UI课程研发部副总监,设计领域专家</p>-->
<!--						在设计领域有丰富的教学经验，资深视觉设计师，平面设计领域专家，曾任嬷嬷蜜网首席UI设计师、 近年来潜心研究移动端APP视觉界面设计，对于视觉设计有其独特的设计理念。-->
<!--					</li>-->
				</ul>
				<div class="content-detail">
					<ul class="title">
						<li><a id="tit1" class="show" href="javascript:">评分概况</a></li>
						<li><a id="tit2" href="javascript:" >留言</a></li>
					</ul>
					<div class="scoreDeail">
						<div class="detail1">
							<div class="left1 fl">
								<div class="d1"><span class="">10</span>人</div>
								<div class="d2"><span class="">1</span>人</div>
								<div class="d3"><span class="">0</span>人</div>
								<p>9月评分分布情况</p>
							</div>
							<div class="right1 fr">
								<h3>2016年9月学生评分概况</h3>
								<p><i></i>8-10分<span class="num">10人</span></p>
								<p><i class="i2"></i>5-8分<span class="num">1人</span></p>
								<p><i class="i3"></i>1-4分<span class="num">0人</span></p>
								<div class="equally">
									平均分：<span>9.6分</span><br/>
									平均人数：<span>11人</span><br/>
									评分时间：<span>2016/09/30</span>
								</div>
							</div>
						</div>
						<div class="detail2">
							<div class="left2 fl">
								<h3>2016年7-9月平均分对比</h3>
								<p><i></i><span class="">2016/07</span></p>
								<p><i class="i2"></i><span class="">2016/08</span></p>
								<p><i class="i3"></i><span class="">2016/09</span></p>
								<span>注：数值为每月平均分</pspan>
							</div>
							<div class="right2 fr">
								<ul class="clumn">
									<li>
										<div class="clumn1"></div>
										<p>7月</p>
									</li>
									<li>
										<div class="clumn2"></div>
										<p>8月</p>
									</li>
									<li>
										<div class="clumn3"></div>
										<p>9月</p>
									</li>
								</ul>
								<p>近三个月平均分对比</p>
							</div>
						</div>
						<!-- <div class="detail3">
							10分<br/>
							9分<br/>
							8分<br/>
							7分<br/>
							6分<br/>
							5分<br/>
							4分<br/>
							3分<br/>
							2分<br/>
							1分<br/>
							0分<br/>
							<ul class="monthList">
								<li>1月</li>
								<li>2月</li>
								<li>3月</li>
								<li>4月</li>
								<li>5月</li>
								<li>6月</li>
								<li>7月</li>
								<li>8月</li>
								<li>9月</li>
								<li>10月</li>
								<li>11月</li>
								<li>12月</li>
							</ul>
						</div> -->
					</div>
					<div class="leaveWord">
						<ul id="liuyan">
<%--							<li>--%>
<%--							RS10650086-×××   <span>发表于:</span>  2016-09-30<br/>--%>
<%--							新的开始，新的征程，未来四个月，希望大家依然保持笑颜，为心中想要的，想追求的，一路向前!--%>
<%--							</li>--%>
<%--							<li>--%>
<%--							RS10650086-×××   <span>发表于:</span>  2016-09-30<br/>--%>
<%--							新的开始，新的征程，未来四个月，希望大家依然保持笑颜，为心中想要的，想追求的，一路向前!--%>
<%--							</li>--%>
<%--							<li>--%>
<%--							RS10650086-×××   <span>发表于:</span>  2016-09-30<br/>--%>
<%--							新的开始，新的征程，未来四个月，希望大家依然保持笑颜，为心中想要的，想追求的，一路向前!--%>
<%--							</li>--%>
						</ul>
						  <!--分页-->
                      <div class="page"  style="display:none;">
                        <dl>
                            <input type="image" src="images/06_left.png" value="firstpg"/>
                            <input type="button" value="1" class="curr_page"/>
                            <input type="button" value="2"/>
                            <input type="button" value="3"/>
                            <input type="image" src="images/07_right.png" value="lastpg"/>
                        </dl>
                        <div class="go_page">
                            <span>跳转到：</span>
                            <input type="text"/>
                            <input type="image" src="images/05_go.png" value="GO">
                        </div>
                      </div>

					</div>
				</div>
			</div>
			<div class="footer">
					武汉瑞才教育科技有限公司版权所有<span>鄂ICP备15014867号-1</span>
			</div>
			<div class="prompt">
				<form  id="add" onsubmit="return check()">
					<textarea id="text" name="text" cols="" rows=""></textarea>
					<input type="button"  class="ok_btn" value="确定"/>
					<input type="reset" value="取消">
				</form>
			</div>
		</div>

	<script type="text/javascript" src="js/detail.js"></script>
	</body>
</html>