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
<title>主页自编辑模块推荐</title>
</head>
<body style="background-color: 9990;margin: 7px">
	<h3>当前推荐信息:</h3>
	<div class="sec_Ful">
		<ul>

			<!--自编辑  -->
			<c:forEach items="${self_edit_bean_list.list }" var="x">
				<li>
					<div class="liF">
						<a href="#"><img
							src="${base }/www/resources/images/${x.video_img}" alt="" /></a>
						<div class="liS">
							<span><img src="${base }/www/resources/images/009.PNG"
								alt="" /></span> <span>${x.video_wathers }</span>
						</div>
					</div> <span class="title">${x.video_name }</span>
				</li>
			</c:forEach>
		</ul>
	</div>
	<div>
		<ul class="search" style="padding-left:10px;">
			<li><a class="button border-main icon-plus-square-o" href="#"
				id="changeLiveRec"> 更改推荐</a></li>
		</ul>
	</div>
	<div id="self_edit_bean_list"></div>
</body>
<script type="text/javascript">
	var base = "${base}";
</script>

<script type="text/javascript"
	src="${base }/www/js/backStage/js/selfedit/self_edit_recomment.js"></script>
<script type="text/javascript"
	src="${base }/www/js/backStage/js/live/recoment_live_room_list.js"></script>
</html>