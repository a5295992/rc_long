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

</head>
<body style="background-color:#f2f9fd;">
		<div >
			<ul id="ztreeDeme" class="ztree"></ul>
		</div>
	<div class="leftnav" style="top: 500px" >
		
		<h2>
			<span class="icon-pencil-square-o"></span>功能管理
		</h2>
		<ul>
			<li><a href="javascript:void(0)" onclick="add()"><span
					class="icon-caret-right"></span>菜单修改</a></li>
			<li><a href="javascript:void(0)" onclick="addNew()"><span
					class="icon-caret-right" "></span>添加菜单</a></li>
			<li><a href="javascript:void(0)" onclick="dele()"><span
					class="icon-caret-right"></span>删除菜单</a></li>
		</ul>
		
		<input type="hidden" name="dd" id="menu_id_">
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
	<div style="position:absolute;top: 0px;padding: 0px;left: 200px;width: 1100"><p>详情</p> </div>
	<div class="admin" style="position:absolute;top: 30px;padding: 0px;left: 200px;color: white;width: 100%" id="content_id">
		<!-- <iframe scrolling="auto" rameborder="0" src=""
			name="right1" width="100%" height="100%">
		</iframe> -->
	</div>
	<div style="text-align:center;"></div>
	<script type="text/javascript">
		var base = "${base}";

		
	</script>
</body>
<script type="text/javascript" src="${back_static }/js/manage_index.js"></script>
</html>
