<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="base" value="${pageContext.request.contextPath }"></c:set>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>视频播放</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>
<link rel="stylesheet" type="text/css"
	href="${base }/www/html_player_resource/css/video.css" media="all">
<div class="video_container" hidden="true" style="margin:0 auto"></div>
<script type="text/javascript" src="${base }/www/html_player_resource/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${base }/www/html_player_resource/js/jquery.plugin.js"></script>
<script type="text/javascript" src="${base }/www/html_player_resource/js/jquery.video.js"></script>
<script type="text/javascript">
	var base="${base}";
	$(function() {
		$(".video_container").html5video({
			width : 600, //Number型，播放器宽度。
			height : 338, //Number型，播放器高度。
			src : base+"/www/resources/data_data/57b1368741321.mp4", //String型，要播放的视频的 URL。
			poster : "html5video-preview.png", //String型，在视频播放之前所显示的图片的 URL。
			loop : false, //Boolean型，则当媒介文件完成播放后再次开始播放。
			preload : true, //Boolean型，如果出现该属性，则视频在页面加载时进行加载，并预备播放。
			notsuportmsg : "您的浏览器不支持html5，无法使用该插件！" //String型，浏览器不支持video标签时的提示，可使用html标签。			
		});
	});
</script>
<script>
	var _hmt = _hmt || [];
	(function() {
		var hm = document.createElement("script");
		hm.src = "//hm.baidu.com/hm.js?8867273989ac579c211d99bc3e0d00dd";
		var s = document.getElementsByTagName("script")[0];
		s.parentNode.insertBefore(hm, s);
	})();
</script>
<div style="text-align:center;"></div>
</html>
