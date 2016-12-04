<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <body>
  	<table>
  		<tr>
  			<th>电影名</th>
  			<th>电影上传人</th>
  			<th>电影类型</th>
  		</tr>
  		<c:forEach items="${videoPager.list }" var="x">
  			<tr>
  			<td>${x.video_cname }</td>
  			<td>${x.user_id }</td>
  			<td>${x.video_type }</td>
  			</tr>
  		</c:forEach>
  	</table>
  </body>
  
 </html>