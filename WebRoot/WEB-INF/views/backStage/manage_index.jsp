<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="base" value="${pageContext.request.contextPath }"></c:set>
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
<script src="${base }/www/js/backStage/js/jquery.js"></script>
</head>
<body style="background-color:#f2f9fd;">
	<div class="leftnav" style="top: 0px">
		<ul style="display:block;background-color:scrollbar; ;">
			<li><a href="${base }/sys/back/infor" target="right"><span
					class="icon-caret-right"></span>首页管理</a></li>
			<li><a href="${base }/www/html/pass.html" target="right"><span
					class="icon-caret-right"></span>电影页管理</a></li>
			<li><a href="${base }/sys/back/index/manage" target="right"><span
					class="icon-caret-right"></span>电视剧管理</a></li>
			<li><a href="${base }/www/html/adv.html" target="right"><span
					class="icon-caret-right"></span>个人主页</a></li>
			<li><a href="${base }/www/html/book.html" target="right1"><span
					class="icon-caret-right"></span>搞笑频道</a></li>
			<li><a href="${base }/www/html/column.html" target="right1"><span
					class="icon-caret-right"></span>直播页面</a></li>
			<li><a href="${base }/sys/back/video" target="right1"><span
					class="icon-caret-right"></span>视频播放</a></li>
			<li><a href="${base }/www/html/column.html" target="right1"><span
					class="icon-caret-right"></span>用户推荐</a></li>
			<li><a href="${base }/sys/back/user" target="right1"><span
					class="icon-caret-right"></span>娱乐频道</a></li>
		</ul>
		<h2>
			<span class="icon-pencil-square-o"></span>功能添加
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
	<div class="admin" style="top: 0px;padding: 0px">
		<iframe scrolling="auto" rameborder="0" src="${base }/sys/back/infor"
			name="right1" width="100%" height="100%"></iframe>
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
