<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../jsp/global.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>首页管理</title>
<link rel="stylesheet" href="${base }/www/css/backStage/css/admin.css">
<link rel="stylesheet" href="${base }/www/css/backStage/css/pintuer.css">
<link rel="stylesheet"
	href="${base }/www/css/backStage/css/manage_index_main.css">
<script src="${base }/www/js/backStage/js/jquery.js"></script>
</head>

<body>
	<h2 style="cursor:pointer" id="h2_001">
		<span class="icon-pencil-square-o"></span>主页推荐模块
	</h2>
	<div style="display: none" id="div_001">
		<ul>
			<li><a href="${base }/sys/back/live/room" target="right2"><span
					class="icon-caret-right"></span>直播间推荐</a></li>
			<li><a href="${base }/www/html/add.html" target="right"><span
					class="icon-caret-right"></span>自编辑</a></li>
			<li><a href="${base }/sys/back/menu" target="right"><span
					class="icon-caret-right"></span>自影评</a></li>
			<li><a href="${base }/sys/back/menu" target="right"><span
					class="icon-caret-right"></span>自推荐</a></li>
		</ul>
	</div>

	<h2 style="cursor:pointer" id="h2_001">
		<span class="icon-pencil-square-o"></span>电影推荐模块
	</h2>
	<div style="display: none" id="div_001">
		<ul>
			<li><a href="${base }/www/html/list.html" target="right"><span
					class="icon-caret-right"></span>内容管理</a></li>
			<li><a href="${base }/www/html/add.html" target="right"><span
					class="icon-caret-right"></span>添加内容</a></li>
			<li><a href="${base }/sys/back/menu" target="right"><span
					class="icon-caret-right"></span>分类管理</a></li>
		</ul>
	</div>

	<h2 style="cursor:pointer" id="h2_001">
		<span class="icon-pencil-square-o"></span>电视剧推荐模块
	</h2>
	<div style="display: none" id="div_001">
		<ul>
			<li><a href="${base }/www/html/list.html" target="right"><span
					class="icon-caret-right"></span>内容管理</a></li>
			<li><a href="${base }/www/html/add.html" target="right"><span
					class="icon-caret-right"></span>添加内容</a></li>
			<li><a href="${base }/sys/back/menu" target="right"><span
					class="icon-caret-right"></span>分类管理</a></li>
		</ul>
	</div>

	<h2 style="cursor:pointer" id="h2_001">
		<span class="icon-pencil-square-o"></span>综艺推荐模块
	</h2>
	<div style="display: none" id="div_001">
		<ul>
			<li><a href="${base }/www/html/list.html" target="right"><span
					class="icon-caret-right"></span>内容管理</a></li>
			<li><a href="${base }/www/html/add.html" target="right"><span
					class="icon-caret-right"></span>添加内容</a></li>
			<li><a href="${base }/sys/back/menu" target="right"><span
					class="icon-caret-right"></span>分类管理</a></li>
		</ul>
	</div>

	<h2 style="cursor:pointer" id="h2_001">
		<span class="icon-pencil-square-o"></span>搞笑推荐模块
	</h2>
	<div style="display: none" id="div_001">
		<ul>
			<li><a href="${base }/www/html/list.html" target="right"><span
					class="icon-caret-right"></span>内容管理</a></li>
			<li><a href="${base }/www/html/add.html" target="right"><span
					class="icon-caret-right"></span>添加内容</a></li>
			<li><a href="${base }/sys/back/menu" target="right"><span
					class="icon-caret-right"></span>分类管理</a></li>
		</ul>
	</div>
	<div class="admin" style="top:0px;padding: 0px">
		<iframe scrolling="auto" rameborder="0" src="${base }/sys/back/infor"
			name="right2" width="100%" height="100%"></iframe>
	</div>
</body>
<script type="text/javascript">
	var base = "${base}";
</script>
<script type="text/javascript"
	src="${base }/www/js/backStage/js/manage_index_main.js">
	
</script>
</html>
