<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@include file="../../jsp/global.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>后台管理中心</title>
<link rel="stylesheet" href="${base }/www/css/backStage/css/admin.css">
<link rel="stylesheet" href="${base }/www/css/backStage/css/pintuer.css">
</head>
<body style="background-color:#f2f9fd;">
	<div class="header bg-main"
		style="background:url(${base}/www/resources/backStage/images/bg.jpg)">
		<div class="logo margin-big-left fadein-top">
			<h1>
				<img src="${base }/www/resources/backStage/images/y.jpg"
					class="radius-circle rotate-hover" height="50" alt="" />后台管理中心
			</h1>
		</div>
		<div class="head-l">
			<a class="button button-little bg-green" href="${base }/sys/video"
				target="_blank"><span class="icon-home"></span> 前台首页</a>
			&nbsp;&nbsp;<a href="##" class="button button-little bg-blue"><span
				class="icon-wrench"></span> 清除缓存</a> &nbsp;&nbsp;<a
				class="button button-little bg-red" href="login.html"><span
				class="icon-power-off"></span> 退出登录</a>
		</div>
	</div>
	<div class="leftnav">
		<div class="leftnav-title"
			style="background:url(${base}/www/resources/backStage/images/bg.jpg) no-repeat 0 -1000px;">
			<strong><span class="icon-list"></span>菜单列表</strong>
		</div>
		<h2>
			<span class="icon-user"></span>基本设置
		</h2>
		<ul style="display:block">
			<li><a href="${base }/sys/back/infor" target="right"><span
					class="icon-caret-right"></span>网站设置</a></li>
			<li><a href="${base }/www/html/pass.html" target="right"><span
					class="icon-caret-right"></span>修改密码</a></li>
			<li><a href="${base }/sys/back/index/manage" target="right"><span
					class="icon-caret-right"></span>单页管理</a></li>
			<li><a href="${base }/www/html/adv.html" target="right"><span
					class="icon-caret-right"></span>首页轮播</a></li>
			<li><a href="${base }/www/html/book.html" target="right"><span
					class="icon-caret-right"></span>留言管理</a></li>
			<li><a href="${base }/www/html/column.html" target="right"><span
					class="icon-caret-right"></span>栏目管理</a></li>
			<li><a href="${base }/sys/back/video" target="right"><span
					class="icon-caret-right"></span>视频管理</a></li>
			<li><a href="${base }/www/html/column.html" target="right"><span
					class="icon-caret-right"></span>直播管理</a></li>
			<li><a href="${base }/sys/back/user" target="right"><span
					class="icon-caret-right"></span>用户管理</a></li>
		</ul>
		<h2>
			<span class="icon-pencil-square-o"></span>栏目管理
		</h2>
		<ul>
			<li><a href="${base }/www/html/list.html" target="right"><span
					class="icon-caret-right"></span>内容管理</a></li>
			<li><a href="${base }/www/html/add.html" target="right"><span
					class="icon-caret-right"></span>添加内容</a></li>
			<li><a href="${base }/sys/back/menu" target="right"><span
					class="icon-caret-right"></span>分类管理</a></li>
		</ul>
	</div>
	<script type="text/javascript">
		$(function() {
			$(".leftnav h2").click(function() {
				$(this).next().slideToggle(200);
				$(this).toggleClass("on");
			})
			$(".leftnav ul li a").click(function() {
				$("#a_leader_txt").text($(this).text());
				$(".leftnav ul li a").removeClass("on");
				$(this).addClass("on");
			})
		});
	</script>
	<ul class="bread">
		<li><a href="{:U('Index/info')}" target="right" class="icon-home">
				首页</a></li>
		<li><a href="##" id="a_leader_txt">网站信息</a></li>
		<li><b>当前语言：</b><span style="color:red;">中文</php></span>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;切换语言：<a href="##">中文</a> &nbsp;&nbsp;<a
			href="##">英文</a></li>
	</ul>
	<div class="admin">
		<iframe scrolling="auto" rameborder="0" src="${base }/sys/back/infor"
			name="right" width="100%" height="100%"></iframe>
	</div>
	<div style="text-align:center;"></div>
	<script type="text/javascript">
		var base = "${base}";

		function del(user_id) {
			alert("hedassad");
			var enter = window.confirm("警告！删除该用户后,用户无法再使用该账号");
			if (enter == 1) {
				$.ajax({
					cache : true,
					type : "POST",
					url : base + "/sys/back/user/delete",
					//data:$('#exe_form_login').serialize(),// 你的formid
					data : {
						"user_id" : user_id
					},
					async : false,
					error : function(request) {
						alert("Connection error");
					},
					success : function(data) {
						if (data > 0) {
							window.confirm("操作成功");
							w.replace(base + "/sys/back");
						} else {
							window.confirm("操作失败");
						}
					}
				});
			}
		};
	</script>
</body>
</html>
