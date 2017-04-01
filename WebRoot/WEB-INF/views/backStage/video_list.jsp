<%@page import="com.rc_long.enumeration.VideoTypeConstants"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="../../jsp/global.jsp"%>

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
				<strong class="icon-reorder"> 视频管理</strong>
			</div>
			<div class="padding border-bottom">
				<ul class="search">
					<li>
						<button type="button" class="button border-green" id="checkall">
							<span class="icon-check"></span> 全选
						</button>
						<button type="submit" class="button border-red">
							<span class="icon-trash-o"></span> 批量删除
						</button>
					<button type="button" class="button border-yellow"
				onclick="openResourceManage()">
				<span class="icon-plus-square-o"></span> 关联资源
			</button>
					</li>

					<li><select id="likeName_serach" class="input"
						style="width:200px; line-height:17px;">
							<option value="">请选择查询条件</option>
							<option value="user_name"
								<c:if test="${likeName eq 'video_name' }">selected="selected"</c:if>>视频名</option>
							<option value="user_id"
								<c:if test="${likeName eq 'user_name' }">selected="selected"</c:if>>用户名</option>
							<option value="user_type"
								<c:if test="${likeName eq 'video_type' }">selected="selected"</c:if>>视频类型</option>
							<option value="user_flag"
								<c:if test="${likeName eq 'video_auth' }">selected="selected"</c:if>>审核状态</option>
					</select></li>
					<li><input type="text" placeholder="请输入搜索关键字" id="likeSearch"
						class="input"
						style="width:250px; line-height:17px;display:inline-block" /> <a
						href="javascript:void(0)" class="button border-main icon-search"
						onclick="changesearch()"> 搜索</a></li>
				</ul>
			</div>
			<table class="table table-hover text-center">
				<tr>
					<th width="120">序号</th>
					<th>审核</th>
					<th>投稿人</th>
					<th>视频别名</th>
					<th>缩略图</th>
					<th width="10%">栏目</th>
					<th width="8%">分类</th>
					<th width="120">创建时间</th>
					<th>操作</th>
				</tr>
				<%
					int i = 1;
				%>
				<c:forEach items="${video_bean.list }" var="video">
					<tr>
						<td><input type="checkbox" name="id[]"
							value="${video.video_id }" /> <%=i++%></td>
						<td>${video.video_auth }</td>
						<td>${video.sysUser.user_name }</td>
						<td>${video.video_cname }</td>
						<td>
						<img style="width: 50px;height: 35px"
						src="${base }/${video.video_img}" alt="缩略图" />
						</td>
						<td>${video.videoGroup.group_name }</td>
						<td>${video.moduleMenu.name }</td>
						<td>${video.create_time }</td>
						<td><div class="button-group">
								<a class="button border-main"
									href="##" onclick="manage(${video.video_id})">
									<span class="icon-edit"></span> 管理
								</a> <a class="button border-red" href="javascript:void(0)"
									onclick="return del(1)"><span class="icon-trash-o"></span>
									删除</a>
							</div></td>
					</tr>
				</c:forEach>
				<tr>
					<td>
					<td>
						<!--用来提交下查询的操作的表单  --> <input type="hidden" id="pageNum"
						name="pageNum" value="${video_bean.pageNum }" /> <input type="hidden" id="pageCount"
						name="pageCount" value="${video_bean.pageCount }" /> <input type="hidden" id="order"
						name="order" value="${map.order }" /> <input type="hidden"
						id="orderBy" name="orderBy" value="${map.orderBy }" /> <input
						type="hidden" id="condition" name="condition" value="" /> <input
						type="hidden" id="likeName" name="likeName" value="" /> <input
						type="hidden" id="like" name="like" value="" />
					</td>
					<pager:Pager pager="${video_bean }"
						path="${base }/sys/back/video/search"></pager:Pager>
				</tr>
			</table>
		</div>
	</form>
	<script type="text/javascript">
		var base="${base}";
	</script>
	<script type="text/javascript" src="${base }/www/js/backStage/video/video_list.js"></script>
<body>
</html>
