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
				<strong class="icon-reorder"> 视频管理</strong>
			</div>
			<div class="padding border-bottom">
				<ul class="search">
					<li>
						<button type="button" class="button border-green" id="checkall">
							<span class="icon-check"></span> 全选
						</button>
						<a class="button border-main"
									href="javascript:void(0)" onclick="recomment(${video.video_id})">
									<span class="icon-edit"></span>批量推荐
						</a>
					</li>

					<li><select id="likeName_serach" class="input"
						style="width:200px; line-height:17px;">
							<option value="">请选择查询条件</option>
							<option value="video_name"
								<c:if test="${likeName eq 'video_name' }">selected="selected"</c:if>>视频名</option>
							<option value="user_name"
								<c:if test="${likeName eq 'user_name' }">selected="selected"</c:if>>用户名</option>
							<option value="video_type"
								<c:if test="${likeName eq 'video_type' }">selected="selected"</c:if>>视频类型</option>
							<option value="video_auth"
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
					<th>是否推荐</th>
					<th width="120">创建时间</th>
					<th>操作</th>
				</tr>
				<%
					int i = 1;
				%>
				<c:forEach items="${self_edit_bean.list }" var="video">
					<tr>
						<td><input type="checkbox" name="id[]"
							value="${video.video_id }" 
							<c:if test="${video.is_recommend eq 1 }">checked="checked"</c:if>/> <%=i++%></td>
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
								<c:if test="${video.is_recommend eq 0 }">
								<a class="button border-main"
									href="javascript:void(0)" onclick="recomment(${video.video_id})">
									<span class="icon-edit"></span>推荐
								</a> 
							</c:if>
							<c:if test="${video.is_recommend eq 1 }">
								<a class="button border-red" href="javascript:void(0)"
									onclick="noRecomment(${video.video_id})"><span class="icon-trash-o"></span>
									取消</a>
							</c:if>
							</div></td>
					</tr>
				</c:forEach>
				<tr>
					<td>
					<td>
						<!--用来提交下查询的操作的表单  --> <input type="hidden" id="pageNum"
						name="pageNum" value="${self_edit_bean.pageNum }" /> <input type="hidden" id="pageCount"
						name="pageCount" value="${self_edit_bean.pageCount }" /> <input type="hidden" id="order"
						name="order" value="${map.order }" /> <input type="hidden"
						id="orderBy" name="orderBy" value="${map.orderBy }" /> <input
						type="hidden" id="condition" name="condition" value="" /> <input
						type="hidden" id="likeName" name="likeName" value="" /> <input
						type="hidden" id="like" name="like" value="" />
					</td>
					<pager:Pager pager="${self_edit_bean }"
						path="${base }/sys/back/self/movie/comment/search"></pager:Pager>
				</tr>
			</table>
		</div>
	</form>
	<script type="text/javascript">
		var base="${base}";
	</script>
	<script type="text/javascript" src="${base }/www/js/backStage/js/selfMovie/self_movie_comment_list.js""></script>
<body>
</html>
