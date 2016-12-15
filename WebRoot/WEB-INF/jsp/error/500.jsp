<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="base" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html >

	<html lang="zh_CN"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width; initial-scale=1; user-scalable=no;">
	<title></title>
	<style>
	*{padding:0; margin:0; border:0;}
	html,body{ height:100vw; font-size:4vw;}
	body{ background-color:#eee;background:radial-gradient(#FFF,#eee);background:-webkit-radial-gradient(#FFF,#eee); background-size:contain;}
	.c404{ width:100vw; padding-top:84vw; text-align:center;   text-align:center; color:#888; background-size:100vw auto; line-height:160%}
	.c404 b{ color:#f80;}
	.c404 span{ padding-top:1rem; display:block;}
	</style>
	</head>
	<body>
	<div class="c404" style="background:url(${base}/www/resources/error/404_wapy.png) no-repeat center top; margin:10vh auto;">
	<span>500-系统内部错误！</span>
	</div>

	</body>
	</html>
