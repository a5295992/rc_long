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
<link rel="stylesheet" href="${base }/www/css/backStage/css/admin.css">
<link rel="stylesheet" href="${base }/www/css/backStage/css/pintuer.css">
</head>
<body>
	<form id="listform">
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong class="icon-reorder"> ${manage_name }</strong>
			</div>
			
			
			<div class="padding border-bottom">
				<ul class="search">
					<li>
						<button type="button" class="button border-green" id="checkall">
							<span class="icon-check"></span> 全选
						</button>
					</li>

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
					<th>投稿人</th>
					<th width="50px">名字</th>
					<th>缩略图</th>
					<th width="15%">菜单</th>
					<th width="120">创建时间</th>
					<th>操作</th>
				</tr>
				
				<!-- 视频 -->
				<c:if test="${type eq 'video' }">
					<c:forEach items="${commoPager.list }" var="video">
					<tr>
						
						<td>
						    <input type="checkbox" name="id[]"
							value="${video.video_id }" /> 
							  </td>
						<td>${video.sysUser.user_name }</td>
						<td width="150px">${fn:substring(video.video_cname,0,8) }</td>
						<td>
						<img style="width: 50px;height: 35px"
						src="${base }/${video.video_img}" alt="缩略图" />
						</td>
						<td>${video.moduleMenu.name }</td>
						<td>${video.create_time }</td>
						<td> <div class="button-group">
								 <a class="button border-red" href="javascript:void(0)"
									onclick="return del(1)"><span class="icon-trash-o"></span>
									移除</a>
							</div></td>
					</tr>
				   </c:forEach>
				
				</c:if>
	
				<tr>
					<td>
					<pager:Pager pager="${commoPager }"
						path="${base }/sys/back/video/search">
					</pager:Pager>
					</td>
				</tr>
			</table>
		</div>
	</form>
	<script type="text/javascript">
		var base="${base}";
	</script>
<body>
</html>
