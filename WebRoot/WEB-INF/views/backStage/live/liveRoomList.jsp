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
<title>直播列表</title>
<link rel="stylesheet" href="${base }/www/css/backStage/css/admin.css">
<link rel="stylesheet" href="${base }/www/css/backStage/css/pintuer.css">
</head>
<body>
	<form id="listform" action="${base }/blive/find" method="post">
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong class="icon-reorder"> 直播列表</strong>
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
						<button type="button" class="button border-yellow"  id="addnews">
						<span class="icon-plus-square-o"></span> 添加直播
						</button>
						<button type="button" class="button border-green" id="authmanage">
							<span class="icon-check"></span> 授权
						</button>
					</li>

					<li>
						<input type="text" placeholder="请输入搜索关键字" name="like"
						class="input"
						style="width:250px; line-height:17px;display:inline-block" />
						
						<a href="#" onclick="findlist()" class="button border-main icon-search">搜索</a>
					</li>
						
						<input type="hidden" id="pageNum" name="pageNum" value="${liveRooms.pageNum }" />
						
						<input type="hidden" id="pageCount" name="pageCount" value="10" />
						
						<input type="hidden" id="likeName" name="likeName" value="news_title" />
						<input type="hidden" id="page" name="page" value="${liveRooms.page }" />
				</ul>
			</div>
			<table class="table table-hover text-center">
				<tr>
					<th width="120">序号</th>
					<th>直播授权</th>
					<th>直播标题</th>
					<th>用户</th>
					<th>缩略图</th>
					<th>描述</th>
					<th>分类</th>
					<th width="120">创建时间</th>
					<th>直播状态</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${liveRooms.list }" var="live">
					<tr>
						<td><input type="checkbox" name="id[]"
							value="${live.live_id }" /> </td>
						<td id="auth${live.live_id }">${live.auth }</td>
						<td>${live.live_name }</td>
						<td>${live.sysUser.user_name }</td>
						<td>
						<img style="width: 50px;height: 35px"
						src="${base }/${live.live_img}" alt="缩略图" />
						</td>
						<td>${fn:substring(live.live_desc,0,8) }</td>
						<td>${live.moduleMenu.name }</td>
						<td>${live.creare_time }</td>
						<td>${live.live_status }</td>
						<td><div class="button-group">
								<a class="button border-main"
									href="##" onclick="update('${live.live_id}')">
									<span class="icon-edit"></span> 管理
								</a> <a class="button border-red" href="javascript:void(0)"
									onclick="dele('${live.live_id}')">
									<span class="icon-trash-o"></span>
									删除</a>
							</div></td>
					</tr>
				</c:forEach>
				<tr>
					<pager:pager pager="${liveRooms }"/>
					
				</tr>
			</table>
		</div>
	</form>
	<script type="text/javascript">
		var base="${base}";
		
	</script>
	
	
	<script type="text/javascript" src="${back_static }/js/live_list.js"></script>
<body>
</html>
