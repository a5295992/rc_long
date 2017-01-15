<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<%@include file="../../../jsp/global.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="${base }/www/css/backStage/css/admin.css">
<link rel="stylesheet" href="${base }/www/css/backStage/css/pintuer.css">
<style type="text/css">
.tu_a{ width:200px; height:192px; position:relative;}
.tu_a img{ width:53px; height:53px; vertical-align:top; margin-top:30px;}
.tu_a p{ width:100%; height:30px; line-height:30px; text-align:center; margin-top:10px; font-size:16px; color:#FFF;}
.tu_a em{ display:inline-block; *display:inline; zoom:1; height:25px; line-height:25px; font-size:16px; padding: 0 15px; border-bottom:1px solid #fff; color:#FFF;}
.tu_a i{ display:block; width:31px; height:14px; position:absolute; left:50%; margin-left:-15px; bottom:-14px;}
.i_m li .li_m{ background:#FFF; height:536px; overflow:hidden;}
.tu_a i{ background:url(../images/icon2.png) no-repeat;}
 .tu_a{ background:#005BAB;}
.tu_a i{ background:url(../images/icon3.png) no-repeat;}
 .tu_a{ background:#3EEADB;}
</style>
</head>
<body>
	<div>
		<ul >
		<li><button>全部添加</button></li>
		</ul>
	</div>
	<hr>
	<div>
		<ul id="ul_id">
		</ul>
	</div>
</body>
<script type="text/javascript">
	var base = "${base}";
	var path = "${path}";
</script>
<script type="text/javascript" src="${base }/www/js/backStage/js/sys_web_static_resource_manage/sys_web_static_resource_manage_public.js">
	</script>
</html>
