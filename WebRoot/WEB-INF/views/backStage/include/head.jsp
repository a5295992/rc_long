<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../../jsp/global.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>后台管理</title>
    <link rel="stylesheet" href="${base }/www/css/backStage/css/admin.css">
	<link rel="stylesheet" href="${base }/www/css/backStage/css/pintuer.css">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
 <body style="background-color:#f2f9fd;">
	<div class="header bg-main"
		style="background:url(${base}/www/resources/backStage/images/bg.jpg)">
		<div class="logo margin-big-left fadein-top">
			<h1>
				<img src="${base }/www/resources/backStage/images/y.jpg"
					class="radius-circle rotate-hover" height="50" alt="" />后台管理中心
			</h1>
		</div>
		<div class="head-l">
			<a class="button button-little bg-green" href="${base }"
				target="_blank"><span class="icon-home"></span> 前台首页</a>
			&nbsp;&nbsp;<a href="javascript:void(0)" class="button button-little bg-blue" onclick="clearCach()"><span
				class="icon-wrench"></span> 清除缓存</a> &nbsp;&nbsp;<a
				class="button button-little bg-red" href="${base }/admin/login"><span
				class="icon-power-off"></span> 退出登录</a>
		</div>
	</div>
	
</html>
