<%@page import="com.rc_long.enumeration.VideoTypeConstants"%>
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
<title>静态资源数据库管理</title>
<link rel="stylesheet" href="${base }/www/css/backStage/css/admin.css">
<link rel="stylesheet" href="${base }/www/css/backStage/css/pintuer.css">
</head>
<body>
	<form id="listform">
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong class="icon-reorder"> 静态资源管理</strong>
			</div>
			<div class="padding border-bottom">
				<ul class="search">
					<li>
						<button type="button" class="button border-green" id="checkall">
							<span class="icon-check"></span> 全选
						</button>
						<button type="button" class="button border-red">
							<span class="icon-trash-o"></span> 批量删除
						</button>
					</li>

					<li><select id="likeName_serach" class="input"
						style="width:200px; line-height:17px;">
							<option value="resource_name">请选择查询条件</option>
							<option value="resource_name"
								<c:if test="${likeName eq 'resource_name' }">selected="selected"</c:if>>资源名称</option>
							<option value="user_name"
								<c:if test="${likeName eq 'user_name' }">selected="selected"</c:if>>用户名</option>
							<option value="resource_type"
								<c:if test="${likeName eq 'resource_type' }">selected="selected"</c:if>>资源类型</option>
							<option value="upload_date"
								<c:if test="${likeName eq 'upload_date' }">selected="selected"</c:if>>时间</option>
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
					<th>上传人</th>
					<th>上传日期</th>
					<th>上传格式</th>
					<th>上传简名</th>
					<th>文件类型</th>
					<th width="15%">预览图</th>
					<th>操作</th>
				</tr>
				<%
					int i = 1;
				%>
				<c:forEach items="${resource_bean.list }" var="resource">
					<tr>
						<td><input type="checkbox" name="id[]"
							value="${resource.resource_id }"  id="${resource.resource_id }"/> <%=i++%></td>
						<td><a href="#">${resource.user_name }</a></td>
						<td>${resource.upload_date }</td>
						<td>${resource.resource_format }</td>
						<%-- <td>
						<img style="width: 50px;height: 35px"
						src="${base }/www/resources/images/${video.video_img}" alt="缩略图" />
						</td> --%>
					<%-- 	<c:set var="video_type" value="${video.video_type }" scope="request"></c:set>
						<td><%=VideoTypeConstants.chooseName(Integer.parseInt((String)request.getAttribute("video_type")))%></td>
						<td>${video.create_time }</td> --%>
						<td>${fn:substring(resource.resource_name,0,10) }</td>
						<td>${resource.resource_type }</td>
						<td>
						<img style="width: 50px;height: 35px"
						src="${base }/RESOURCES/${resource.resource_personal }/${resource.resource_type }/${resource.user_id }/${resource.upload_date}/${resource.resource_name}.PNG" alt="缩略图" />
						</td>
						<td><div class="button-group">
								 <a class="button border-main"
									href="##" onclick="choose(${resource.resource_id})">
									<span class="icon-edit"></span> 选择
								</a> 
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
					<pager:Pager pager="${resource_bean }"
						path="${base }/sys/web/static/resource/manage/database/search"></pager:Pager>
				</tr>
			</table>
		</div>
	</form>
	<script type="text/javascript">
		var base="${base}";
	</script>
	<script type="text/javascript" src="${base }/www/js/backStage/js/sys_web_static_resource_manage/sys_web_static_resource_manage_database.js"></script>
<body>
</html>
