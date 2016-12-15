<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="base" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${ShiroUser.user_name }的个人主页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="${base }/www/css/singlepage.css/css/bootstrap.css" rel="stylesheet">
    <link href="${base }/www/css/singlepage.css/css/blog.css" rel="stylesheet">
	
  </head>
  <body>
    <div class="blog-masthead">
      <div class="container">
        <nav class="blog-nav">
        <a class="blog-nav-item" href="${base }/sys/video">Rc_long首页</a>
          <a class="blog-nav-item active" href="${base }/sys/user/infor">个人信息首页</a>
          <a class="blog-nav-item" href="#part1">看过</a>
          <a class="blog-nav-item" href="#part2">与我相关</a>
          <a class="blog-nav-item" href="#part3">上传的作品</a>
        </nav>
      </div>
    </div>
	<div class="intr" >
    	<span class="avtar" style="background:url(${base }/www/resources/singlepage_img/${ShiroUser.user_img });background-size:cover"></span>
        <p class="peointr">${ShiroUser.user_name}</p>
		<p class="peointr">账号:${ShiroUser.user_ssid }</p>
        <p class="peointr">热爱生活，爱编程。<a href="${base }/sys/back">后台管理</p>
    </div>
    <div class="title" id="part1">看过</div>
    <div class="content"> 
    	<div class="pic pic1">
    		<img src="${base }/www/resources/singlepage_img/h1.jpg" alt="">
    		<p>笔锋塔下</p>
    	</div>
    	<div class="pic pic2">
    		<img src="${base }/www/resources/singlepage_img/h2.jpg" alt="">
    		<p>河畔</p>
    	</div>
    	<div class="pic pic3">
    		<img src="${base }/www/resources/singlepage_img/h3.jpg" alt="">
    		<p>桥岸</p>
    	</div>
    </div>
    <div class="title" id="part2">与我相关</div>
    <div class="content">
    	<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
              <ol class="carousel-indicators">
                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
              </ol>
              <div class="carousel-inner" role="listbox">
                <div class="item active">
                  <img src="${base }/www/resources/singlepage_img/s1.jpg" alt="...">
                </div>
                <div class="item">
                  <img src="${base }/www/resources/singlepage_img//s2.jpg" alt="...">
                </div>
				<div class="item">
                  <img src="${base }/www/resources/singlepage_img//s3.jpg" alt="...">
                </div>
              </div>
              <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left"></span>
                <span class="sr-only">Previous</span>
              </a>
              <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right"></span>
                <span class="sr-only">Next</span>
              </a>
            </div>
    </div>
	<div class="title" id="part3">上传的作品</div>
    <div class="content">
        <ul class="nav nav-tabs" role="tablist">
          <li class="active"><a href="#home" role="tab" data-toggle="tab">电影</a></li>
          <li><a href="#profile" role="tab" data-toggle="tab">电视剧</a></li>
          <li><a href="#messages" role="tab" data-toggle="tab">其他</a></li>
        </ul>
        <div class="tab-content">
          <div class="tab-pane active" id="home">
          	<p class="text">1.<a href="#">魔幻先生之通灵术士</a>2016.12.1</p>
            <p class="text">2.<a href="#">僵尸先生之灵幻先生</a>2016.12.1</p>
            <p class="text">3.<a href="#">鬼打鬼之僵尸家族</a>2016.12.1</p>
          </div>
          <div class="tab-pane" id="profile">
          	<p class="text">1.<a href="#">我的兄弟叫顺溜</a>2016.12.41</p>
            <p class="text">2.<a href="#">我的团长我的团</a>2016.12.3</p>
            <p class="text">3.<a href="#">盗墓笔记剧场版</a>2016.12.1</p>
          </div>
          <div class="tab-pane" id="messages">
          	<p class="text">1.<a href="#">我的自拍</a>2016.12.1</p>
            <p class="text">2.<a href="#">亲测免流量大法</a>2016.12.11</p>
            <p class="text">3.<a href="#">装逼的乐趣</a>2016.12.2</p>
          </div>
        </div>
    </div>
    <div class="blog-footer">
      <p>by <a href="#" target="_blank">RC_long</a>.</p>
    </div>
    <a href="" class="btt">顶部</a>
    <!-- Js-->
    <script src="${base }/www/js/index/user_single_page/jquery-1.9.1.min.js"></script>
    <script src="${base }/www/js/index/user_single_page/bootstrap.min.js"></script>
    <script src="${base }/www/js/index/user_single_page/plugin.js"></script>
  </body>
</html>
