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
</head>

<body>
	<h2 style="cursor:pointer" id="h2_001">
		<span class="icon-pencil-square-o"></span>主页推荐模块
	</h2>
	<div style="display: none" id="div_001">
		<ul>
			<li><a href="${base }/sys/back/live/room" target="right2"><span
					class="icon-caret-right"></span>直播间推荐</a></li>
			<li><a href="${base }/sys/back/self/edit" target="right2"><span
					class="icon-caret-right"></span>自编辑</a></li>
			<li><a href="${base }/sys/back/self/movie/comment" target="right2"><span
					class="icon-caret-right"></span>自影评</a></li>
			<li><a href="${base }/sys/back/self/recomment" target="right2"><span
					class="icon-caret-right"></span>自推荐</a></li>
		</ul>
	</div>

	<h2 style="cursor:pointer" id="h2_002">
		<span class="icon-pencil-square-o"></span>电影推荐模块
	</h2>
	<div style="display: none" id="div_002">
		<ul>
			<li><a href="${base }/sys/back/movie/recomment?video_type=401" target="right2"><span
					class="icon-caret-right"></span>精选短片</a></li>
			<li><a href="${base }/sys/back/movie/recomment?video_type=402" target="right2"><span
					class="icon-caret-right"></span>最新预告</a></li>
			<li><a href="${base }/sys/back/movie/recomment?video_type=403" target="right2"><span
					class="icon-caret-right"></span>院线强档</a></li>
			<li><a href="${base }/sys/back/movie/recomment?video_type=404" target="right2"><span
				class="icon-caret-right"></span>幕后特辑</a></li>
		</ul>
	</div>

	<h2 style="cursor:pointer" id="h2_003">
		<span class="icon-pencil-square-o"></span>电视剧推荐模块
	</h2>
	<div style="display: none" id="div_003">
		<ul>
			<li><a href="${base }/sys/back/movie/recomment?video_type=501" target="right2"><span
					class="icon-caret-right"></span>网络热播</a></li>
			<li><a href="${base }/sys/back/movie/recomment?video_type=502" target="right2"><span
					class="icon-caret-right"></span>强势推荐</a></li>
			<li><a href="${base }/sys/back/movie/recomment?video_type=503" target="right2"><span
					class="icon-caret-right"></span>内地剧</a></li>
			<li><a href="${base }/sys/back/movie/recomment?video_type=504" target="right2"><span
					class="icon-caret-right"></span>美剧</a></li>
			<li><a href="${base }/sys/back/movie/recomment?video_type=505" target="right2"><span
			class="icon-caret-right"></span>日剧</a></li>
			<li><a href="${base }/sys/back/movie/recomment?video_type=506" target="right2"><span
			class="icon-caret-right"></span>资讯快递</a></li>
		</ul>
	</div>

	<h2 style="cursor:pointer" id="h2_004">
		<span class="icon-pencil-square-o"></span>综艺推荐模块
	</h2>
	<div style="display: none" id="div_004">
		<ul>
			<li><a href="${base }/sys/back/movie/recomment?video_type=601" target="right2"><span
			class="icon-caret-right"></span>精选短片</a></li>
			<li><a href="${base }/sys/back/movie/recomment?video_type=602" target="right2"><span
			class="icon-caret-right"></span>最近更新</a></li>
			<li><a href="${base }/sys/back/movie/recomment?video_type=603" target="right2"><span
			class="icon-caret-right"></span>娱乐爆点</a></li>
			<li><a href="${base }/sys/back/movie/recomment?video_type=604" target="right2"><span
			class="icon-caret-right"></span>大陆综艺</a></li>
			<li><a href="${base }/sys/back/movie/recomment?video_type=605" target="right2"><span
			class="icon-caret-right"></span>海外综艺</a></li>
		</ul>
	</div>

	<h2 style="cursor:pointer" id="h2_005">
		<span class="icon-pencil-square-o"></span>搞笑推荐模块
	</h2>
	<div style="display: none" id="div_005">
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
		<iframe scrolling="auto" rameborder="0" src=""
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
