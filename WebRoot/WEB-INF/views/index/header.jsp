<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="base" value="${pageContext.request.contextPath }"></c:set>
<html>
<head>
<title>头部</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="${base }/www/css/base.css" />
<link rel="stylesheet" href="${base }/www/css/index.css" />
<script src="${base }/www/resources/assets/js/jquery.2.1.1.min.js"></script>
<script type="text/javascript" src="${base }/www/js/zDialog.js"></script>
<script type="text/javascript" src="${base }/www/js/zDrag.js"></script>
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
<header> <!--头部首导航开始--> <nav class="login">
<div class="main">
	<div class="login_img">
		<a href="#"> <img src="${base }/www/resources/images/007.PNG"
			alt="图标" />
		</a>
	</div>
	<div class="login_date">
		<a href="#"><img src="${base }/www/resources/images/date.gif"
			alt="动图"></a>
	</div>

	<div class="login_second">
		<div class="login_secondF">
			<input type="text" class="in" value="上课别看" /> <input type="submit"
				class="sub" value="乐搜" />
		</div>
		<div class="login_secondS">
			<ul>
				<li><a href="#">上课别看</a></li>
				<li><a href="#">赵薇资助希拉里</a></li>
				<li><a href="#">56音乐下午茶</a></li>
				<li><a href="#">微体兔菜谱</a></li>
			</ul>
		</div>

	</div>
	<div class="login_third">
		<ul>
			<li><c:choose>
					<c:when test="${ShiroUser eq null}">
					</c:when>
					<c:otherwise>
						<a href="#" id="href_butt_logout">
							<div class="img">
								<img src="${base }/www/resources/images/exit.jpg" alt="" />
							</div>
							<div class="login_thirdDiv">退出</div>
						</a>
					</c:otherwise>
				</c:choose></li>
			<li class="first"><c:choose>
					<c:when test="${ShiroUser eq null}">
						<a href="#" id="exe_herf_login">
							<div class="img">
								<img src="${base }/www/resources/images/001.PNG" alt="" />
							</div>
							<div class="login_thirdDiv">
								<span class="span1">登陆</span>
							</div>
						</a>

					</c:when>
					<c:otherwise>
						<form id="exe_form_singepage">
							<input type="hidden" name="user_id" value="${ShiroUser.user_id }" />
						</form>
						<a href="${base }/sys/user/infor">
							<div class="img">
								<img src="${base }/www/resources/images/001.PNG" alt="" />
							</div>
							<div class=login_thirdDiv>
								<span class="span1">${ShiroUser.user_name }</span>
							</div>
						</a>
					</c:otherwise>

				</c:choose></li>
			<li><a href="#">
					<div class="img">
						<img src="${base }/www/resources/images/002.PNG" alt="" />
					</div>

					<div class="login_thirdDiv">上传</div>
			</a></li>
			<li><a href="#">
					<div class="img">
						<img src="${base }/www/resources/images/003.PNG" alt="" />
					</div>
					<div class="login_thirdDiv">消息</div>
			</a></li>
			<li><a href="#">
					<div class="img">
						<img src="${base }/www/resources/images/003.PNG" alt="" />
					</div>
					<div class="login_thirdDiv">看过</div>
			</a></li>

		</ul>

	</div>

</div>
</nav> <!-- 头部首导航结束--> <!-- 头部子导航开始--> <nav class="nav">
<div class="center">
	<ul>
		<li class="first"><a href="${base }/sys/video">首页</a></li>
		<li><a href="#">电视剧</a></li>
		<li><a href="${base }/sys/movie">电影</a></li>
		<li><a href="#">综艺</a></li>
		<li><a href="#">搞笑</a></li>
		<li><a href="#">直播</a></li>
	</ul>
</div>
</nav> <!-- 头部子导航结束--> </header>
<body>

</body>
</html>
