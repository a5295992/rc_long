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
.tu_a{ width:500px; height:192px; position:relative;margin-left: 600px;margin-top: 20px}
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

<style> 
div p
{
width:50px;
height:50px;
transition:width 2s, height 2s;
-moz-transition:width 2s, height 2s, -moz-transform 2s; /* Firefox 4 */
-webkit-transition:width 2s, height 2s, -webkit-transform 2s; /* Safari and Chrome */
-o-transition:width 2s, height 2s, -o-transform 2s; /* Opera */
}

div p:hover
{
width:300px;
height:100px;
}
</style>

</head>
<body>
	<div>
		<ul>
			<li>
				<div class="tu_a" id="public_resource_div">
            	<a href="#" id="public_resource">
                    <img src="${base }/www/resources/images/icon4.png" alt=""/>
                    <p id="public_resource_center"><span id="public_resource_span">公共资源管理中心</span></p>
                    <em>PUBLIC RESOURCE MANAGE</em>
                </a>
                <i>&nbsp;</i>
                
            </div>
            <hr>
            <div class="tu_a" style="background-color: #005BAB" id="private_resource_div">
            	<a href="#" id="private_resource">
                    <img src="${base }/www/resources/images/icon4.png" alt=""/>
                    <p>私有资源管理中心</p>
                    <em>PRIVATE RESOURCE MANAGE</em>
                </a>
                <i>&nbsp;</i>
            </div>
			</li>
		</ul>
	</div>
</body>
<script type="text/javascript">
	var base = "${base}";
	var path = "${path}";
</script>
<script type="text/javascript" src="${base }/www/js/backStage/js/sys_web_static_resource_manage/sys_web_static_resource_manage.js">
	</script>
</html>
