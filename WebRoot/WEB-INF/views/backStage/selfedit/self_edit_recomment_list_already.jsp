<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="../../../jsp/global.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>视频后台管理</title>
<link rel="stylesheet" href="${base }/www/css/backStage/css/admin.css">
<link rel="stylesheet" href="${base }/www/css/backStage/css/pintuer.css">
</head>
<body>
	<form id="listform">
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong class="icon-reorder"> 当前列表</strong>
			</div>
			<table class="table table-hover text-center">
				<tr>
					<th width="120">序号</th>
					<th>审核</th>
					<th>投稿人</th>
					<th>视频别名</th>
					<th>缩略图</th>
					<th>是否推荐</th>
					<th width="120">创建时间</th>
					<th>操作</th>
				</tr>
				<%
					int i = 1;
				%>
				<c:forEach items="${self_edit_bean_list.list }" var="video">
					<tr>
						<td><input type="checkbox" name="id[]"
							value="${video.video_id }" /> <%=i++%></td>
						<td>${video.video_auth }</td>
						<td>${video.user_name }</td>
						<td>${video.video_cname }</td>
						<td>
						
						<img style="width: 50px;height: 35px"
						src="${base }/www/resources/images/${video.video_img}" alt="" />
							
						</td>
						<td>${video.is_recommend }</td>
						<td>${video.create_time }</td>
						<td><div class="button-group">
								<a class="button border-main"
									href="${base }/sys/back/user/qupdate?user_id=${user.user_id}">
									<span class="icon-edit"></span>更改</a> 
							</div></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</form>
	<script type="text/javascript">
		var base="${base}";
		
	</script>
	<script type="text/javascript" src="${base }/www/js/backStage/js/selfedit/self_edit_recomment_list.js"></script>
<body>
</html>
