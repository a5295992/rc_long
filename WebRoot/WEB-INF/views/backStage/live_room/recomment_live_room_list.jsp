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
<title>直播间管理</title>
<link rel="stylesheet" href="${base }/www/css/backStage/css/admin.css">
<link rel="stylesheet" href="${base }/www/css/backStage/css/pintuer.css">
</head>
<body>
	<form id="listform">
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
					</li>

					<li><select id="likeName_serach" class="input"
						style="width:200px; line-height:17px;">
							<option value="">请选择查询条件</option>
							<option value="live_name"
								<c:if test="${likeName eq 'video_name' }">selected="selected"</c:if>>直播名字</option>
							<option value="live_id"
								<c:if test="${likeName eq 'user_name' }">selected="selected"</c:if>>直播ID</option>
							<option value="live_title"
								<c:if test="${likeName eq 'video_type' }">selected="selected"</c:if>>直播类型</option>
							<option value="user_id"
								<c:if test="${likeName eq 'video_auth' }">selected="selected"</c:if>>用户名</option>
					</select></li>
					<li><input type="text" placeholder="请输入搜索关键字" id="likeSearch"
						class="input"
						style="width:250px; line-height:17px;display:inline-block" /> <a
						href="javascript:void(0)" class="button border-main icon-search"
						onclick="changeThingsToSearch()"> 搜索</a></li>
				</ul>
			</div>
			<table class="table table-hover text-center">
				<tr>
					<th width="120">序号</th>
					<th>是否推荐</th>
					<th>直播ID</th>
					<th>直播名</th>
					<th>缩略图</th>
					<th width="25%">描述信息</th>
					<th width="120">是否直播</th>
					<th>操作</th>
				</tr>
				<%
					int i = 1;
				%>
				<c:forEach items="${live_bean.list }" var="live">
					<tr>
						<td><input type="checkbox" name="id[]"
							value="${live.live_id }" /> <%=i++%></td>
						<td>${live.is_recoment }</td>
						<td>${live.live_id }</td>
						<td>${live.live_title }</td>
						<td>${live.live_img }</td>
						<td>${live.user_id }</td>
						<td>${live.live_path }</td>
						<td><div class="button-group">
							<c:if test="${live.is_recoment eq 0 }">
								<a class="button border-main"
									href="javascript:void(0)" onclick="recomment(${live.live_id})">
									<span class="icon-edit"></span>推荐
								</a> 
							</c:if>
							<c:if test="${live.is_recoment eq 1 }">
								<a class="button border-red" href="javascript:void(0)"
									onclick="noRecomment(${live.live_id})"><span class="icon-trash-o"></span>
									取消</a>
							</c:if>
								
							</div></td>
					</tr>
				</c:forEach>
				<tr>
					<td>
					<td>
						<!--用来提交下查询的操作的表单  --> <input type="hidden" id="pageNum"
						name="pageNum" value="${live_bean.pageNum }" /> <input type="hidden" id="pageCount"
						name="pageCount" value="${live_bean.pageCount }" /> <input type="hidden" id="order"
						name="order" value="${map.order }" /> <input type="hidden"
						id="orderBy" name="orderBy" value="${map.orderBy }" /> <input
						type="hidden" id="condition" name="condition" value="" /> <input
						type="hidden" id="likeName" name="likeName" value="" /> <input
						type="hidden" id="like" name="like" value="" />
					</td>
					<pager:Pager pager="${live_bean }"
						path="${base }/sys/back/live/room/search"></pager:Pager>
				</tr>
			</table>
		</div>
	</form>
	<script type="text/javascript">
		var base="${base}";
	</script>
	<script type="text/javascript" src="${base }/www/js/backStage/js/live/recoment_live_room_list.js"></script>
<body>
</html>
