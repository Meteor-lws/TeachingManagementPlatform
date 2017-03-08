<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/pages/common/inc.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>教师投票系统</title>

		<style type="text/css">
body {
	font: 12px/ 20px "微软雅黑", "宋体", Arial, sans-serif, Verdana, Tahoma;
	padding: 0;
	margin: 0;
}

a:link {
	text-decoration: none;
}

a:visited {
	text-decoration: none;
}

a:hover {
	text-decoration: underline;
}

a:active {
	text-decoration: none;
}

.cs-north {
	height: 60px;
	background: #B3DFDA;
}

.cs-north-bg {
	width: 100%;
	height: 100%;
	background:
		url('<%=basePath%>scripts/jquery-easyui-1.3/themes/gray/images/header_bg.png')
		repeat-x;
}

.cs-north-logo {
	height: 40px;
	padding: 15px 0px 0px 5px;
	color: #fff;
	font-size: 22px;
	font-weight: bold;
	text-decoration: none
}

.cs-west {
	width: 200px;
	padding: 0px;
	border-left: 1px solid #99BBE8;
}

.cs-south {
	height: 25px;
	background:
		url('<%=basePath%>scripts/jquery-easyui-1.3/themes/gray/images/panel_title.gif')
		repeat-x;
	padding: 0px;
	text-align: center;
}

.cs-navi-tab {
	padding: 5px;
}

.cs-tab-menu {
	width: 120px;
}

.cs-home-remark {
	padding: 10px;
}

/**
 *	层浮动
 */
.left {
	float: left;
	display: inline;
}

.right {
	float: right;
	display: inline;
}

.clear {
	clear: both;
}

.title {
	background:
		url('<%=basePath%>scripts/jquery-easyui-1.3/themes/gray/images/header_bg.png')
		repeat-x;
	height: 26px;
}

#topbar {
	padding: 0 5px;
}
</style>

		<script type="text/javascript">
	var centerTabs;
	$(function() {
		$('.demo-menu a')
				.click(
						function() {
							var _tit = $(this).html(), _contant = $(this).attr(
									"href"), _tabCls = $(this).attr("tabCls");
							$('.demo-menu a').removeClass("icon-on");
							$(this).addClass("icon-on");
							addTab(_tit, _contant, _tabCls);
							return false;
						});

		centerTabs = $('#tabs').tabs( {
			fit : true,
			border : false,
			onContextMenu : function(e, title) {
				e.preventDefault();
				tabsMenu.menu('show', {
					left : e.pageX,
					top : e.pageY
				}).data('tabTitle', title);
			}
		});
	});

	function addTab(title, href, tabCls) {
		if (centerTabs.tabs('exists', title)) {
			centerTabs.tabs('select', title);
		} else {
			if (href) {
				var content = '<iframe scrolling="no" frameborder="0"  src="' + href + '" style="width:100%;height:100%;">__tag_144$49_';
			} else {
				var content = '木有可以加载的页面';
			}
			centerTabs.tabs( {
				scrollIncrement : 100
			}).tabs('add', {
				title : title,
				content : content,
				closable : true,
				iconCls : tabCls
			});
		}
	}

	function tabClose() {
		/*双击关闭TAB选项卡*/
		$(".tabs-inner").dblclick(function() {
			var subtitle = $(this).children(".tabs-closable").text();
			$('#tabs').tabs('close', subtitle);
		})
		/*为选项卡绑定右键*/
		$(".tabs-inner").bind('contextmenu', function(e) {
			$('#mm').menu('show', {
				left : e.pageX,
				top : e.pageY
			});

			var subtitle = $(this).children(".tabs-closable").text();

			$('#mm').data("currtab", subtitle);
			$('#tabs').tabs('select', subtitle);
			return false;
		});
	}

	//打开弹出窗口
	function showWindow(options) {
		jQuery("#SysPopWindow").window(options);
	}
	//关闭弹出窗口
	function closeWindow(sel) {
		if (sel) {
			$(sel).window("close");
		} else {
			$("#SysPopWindow").window('close');
		}
	}

	function showAjaxWindow(options, url) {
		$("#popWinFrame").attr("src", url);
		JQuery("#AjaxPopWindow").window(options);
	}

	function showDialog(options) {
		jQuery("#SysDialogWindow").dialog(options);
	}

	function showMessage(title, msg, type) {
		$.messager.alert(title, msg, type);
	}

	function showConfirm(title, msg, callback) {
		$.messager.confirm(title, msg, callback);
	}
</script>

	</head>
	<body class="easyui-layout">

		<div region="north" border="true"
			style="height: 89px; overflow: hidden;">
			<div style="height: 60px;">
				<img src="pages\frame\ruicai.png"
					style="width: 210px; height: 58px;margin-left: 15px" />
			</div>
			<div id="topbar" class="title">
				<div id="topbar-logon" class="right">
					<a id="logout" icon="icon-remove" class="easyui-linkbutton"
						plain="true" href="<%=basePath%>login/login!exit" >注销</a>
					<a icon="icon-help" href="#" class="easyui-menubutton"
						menu="#topbar-menu">管理</a>
					<div id="topbar-menu" style="width: 150px;">
						<div icon="">
							修改个人信息
						</div>
						<div icon="">
							修改口令
						</div>
						<div class="menu-sep"></div>
						<div icon="icon-reload">
							刷新系统缓存
						</div>
						<div class="menu-sep"></div>
						<div icon="icon-help" onclick=
	showAbout();
>
							关于
						</div>
					</div>
				</div>
				<div id="topbar-info" class="left">
					<b style="margin-top: 15px">欢迎 admin</b>
				</div>
			</div>
		</div>
		<div region="west" border="true" split="true" title="教师投票管理系统"
			class="cs-west">
			<div class="easyui-accordion" fit="true" border="false">
				<div title="学生管理" iconCls="icon-model" class="demo-menu">
					<ul>

						<li>
							<a class="icon icon-mail"
								href="<%=basePath%>pages/student/student_list.jsp"
								tabCls="icon-rolemanager">学生信息管理</a>
						</li>
						
						
						
					</ul>
				</div>
				<div title="教师管理"  iconCls="icon-reload"
					class="demo-menu">
					<ul>
						<li>
						<a class="icon icon-calendar" href="<%=basePath%>teacher/TeacherAction_loadManager" tabCls="icon-provider">教师信息管理</a>
						</li>

					</ul>
				</div>


				<div title="评分留言管理"  iconCls="icon-reload" class="demo-menu">
					<ul>
						<li>
						<a class="icon icon-calendar" href="<%=basePath%>evaluate/EvaluateAction_loadManager" tabCls="icon-provider">评价项管理</a>
						</li>

						<li>
						<a class="icon icon-calendar" href="<%=basePath%>pages/lyandpj/liuyan_list.jsp" tabCls="icon-provider">留言管理</a>
						</li>
						
						<li>
						<a class="icon icon-calendar" href="<%=basePath%>pages/lyandpj/gradeManager.jsp" tabCls="icon-provider">评分管理</a>
						</li>

						<li>
						<a class="icon icon-calendar" href="<%=basePath%>pages/lyandpj/nopingjia_list.jsp" tabCls="icon-provider">查询未评分学生</a>
						</li>

					</ul>
				</div>
				
				<div title="班级管理" selected="true" iconCls="icon-reload" class="demo-menu">
					<ul>
						<li>
						<a class="icon icon-calendar" href="<%=basePath%>pages/class/class_list.jsp" tabCls="icon-provider">班级管理</a>
						</li>
					</ul>
				</div>
				


			</div>
		</div>
		<div id="mainPanle" region="center" border="true" border="false">
			<div id="tabs" class="easyui-tabs" fit="true" border="false">
				<div title="Home">
					<div class="cs-home-remark">
						<h1>
							欢迎来到瑞才
						</h1>
						<br>
						制作：1606
						<br>
						博客：
						<a href="" target="_blank">www.ruicai.com</a>
						<br>
					</div>
				</div>
			</div>
		</div>


		<div region="south" border="false" class="cs-south">
		武汉瑞才教育科技有限公司版权所有<span>鄂ICP备15014867号-1
		</div>

	</body>
</html>
