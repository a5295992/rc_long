<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/global.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>${inform }-a_long</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="${module_02 }/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="${module_02 }/css/style.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="${module_02 }/css/contactstyle.css" type="text/css" media="all" />
<link rel="stylesheet" href="${module_02 }/css/faqstyle.css" type="text/css" media="all" />
<link href="${module_02 }/css/single.css" rel='stylesheet' type='text/css' />
<link href="${module_02 }/css/medile.css" rel='stylesheet' type='text/css' />
<!-- banner-slider -->
<link href="${module_02 }/css/jquery.slidey.min.css" rel="stylesheet">
<!-- //banner-slider -->
<!-- pop-up -->
<link href="${module_02 }/css/popuo-box.css" rel="stylesheet" type="text/css" media="all" />
<!-- //pop-up -->
<!-- font-awesome icons -->
<link rel="stylesheet" href="${module_02 }/css/font-awesome.min.css" />
<!-- //font-awesome icons -->
<!-- js -->
<!-- //js -->
<!-- banner-bottom-plugin -->
<link href="${module_02 }/css/owl.carousel.css" rel="stylesheet" type="text/css" media="all">
<script src="${module_02 }/js/owl.carousel.js"></script>
<script src="${module_02 }/js/bootstrap.min.js"></script>
<script>
	$(document).ready(function() { 
		$("#owl-demo").owlCarousel({
	 
		  autoPlay: 3000, //Set AutoPlay to 3 seconds
	 
		  items : 5,
		  itemsDesktop : [640,4],
		  itemsDesktopSmall : [414,3]
	 
		});
	 
	}); 
</script> 
<!-- //banner-bottom-plugin -->
<!---<link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700italic,700,400italic,300italic,300' rel='stylesheet' type='text/css'>--->
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="${module_02 }/js/move-top.js"></script>
<script type="text/javascript" src="${module_02 }/js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script>
	
	
  </head>
  <body>
<%--  <c:out value="${fnc:getCurrentMenu('index') }"></c:out> --%>
<%--  <c:forEach items="${fnc:getCurrentMenu('index') }" var="menu">
 		${menu.menu_name }
 		<c:forEach items="${menu.sysMenuS }" var="menu_child">
 			${menu.menu_name }
 		</c:forEach>
 
 </c:forEach> --%>
  <!-- header -->
	<div class="header">
		<div class="container">
			<div class="w3layouts_logo">
				<a href="index.html"><h1>One<span>Movies</span></h1></a>
			</div>
			<div class="w3_search">
				<form action="#" method="post">
					<input type="text" name="Search" placeholder="Search" required="">
					<input type="submit" value="Go">
				</form>
			</div>
			<div class="w3l_sign_in_register">
				<ul>
					<li><i aria-hidden="true"></i> 更多精彩！</li>
					<c:choose>
						<c:when test="${ShiroUser eq null }">
							<li><a href="#" data-toggle="modal" data-target="#myModal">登录</a></li>
						</c:when>
						<c:otherwise>
							<li><img src="${base }/www/resources/images/001.PNG" alt="" /></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
<!-- //header -->
<!-- bootstrap-pop-up -->
<!-- 登录页面 -->
	<%@ include file="../login/login.jsp" %>
	<div class="movies_nav">
		<div class="container">
			<nav class="navbar navbar-default">
				<div class="navbar-header navbar-left">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-1">
					<nav>
						<ul class="nav navbar-nav">
							<li class="active"><a href="${base }">Home</a></li>
							
					<c:forEach items="${fnc:getCurrentMenu('index') }" var="menu">
						<!-- 如果是下拉的菜单 -->
						<c:choose>
							<c:when test="${menu.co_id eq '下拉' }">
								<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">${menu.menu_name } <b class="caret"></b></a>
								<ul class="dropdown-menu multi-column columns-3">
									<div class="col-sm-4">
										<ul class="multi-column-dropdown">
											<c:forEach items="${menu.sysMenuList }" var="menu_child" >
 												<li><a href="genres.html">${menu_child.menu_name }</a></li>
 											</c:forEach>
										</ul>
									</div>
								</ul>
						
								</li>
							</c:when>
							<c:otherwise>
								<li><a href="news.html">${menu.menu_name }</a></li>						
							</c:otherwise>
						</c:choose>
 					</c:forEach>
							
						</ul>
					</nav>
				</div>
			</nav>	
		</div>
	</div>
  </body>
</html>
