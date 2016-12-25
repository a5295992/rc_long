<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../../jsp/global.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${base }/www/css/base.css" />
<link rel="stylesheet" href="${base }/www/css/index.css" />
<link rel="stylesheet" href="${base }/www/css/backStage/css/admin.css">
<link rel="stylesheet" href="${base }/www/css/backStage/css/pintuer.css">
<script src="${base }/www/resources/assets/js/jquery.2.1.1.min.js"></script>
<title>Insert title here</title>
</head>
<body style="background-color: 9990;margin: 7px">
	<h3>当前推荐信息:</h3>
	<span>直播封面:</span>
	<a href="#"><img src="${base }/www/resources/images/0023.jpg"
		alt="" style="width:800px" /></a>
	<div class="small">
		<span>直播标题:</span><span><img src="images/008.PNG" alt="" /></span> <span>速来围观逆天颜值！气质女神完美娃娃脸</span>
	</div>
	<div>
		<ul class="search" style="padding-left:10px;">
			<li><a class="button border-main icon-plus-square-o"
				href="#" id="changeLiveRec"> 更改直播推荐</a></li>
		</ul>
	</div>
</body>
<script type="text/javascript" >
var base="${base}";
</script>

<script type="text/javascript" src="${base }/www/js/backStage/js/live/recomment_live_room.js"></script>
</html>