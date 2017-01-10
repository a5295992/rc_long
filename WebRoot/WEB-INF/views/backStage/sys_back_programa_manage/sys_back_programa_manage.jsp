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
</head>
<body>
	<form id="listform">
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong class="icon-reorder"> 内容列表</strong>
		</div>
		<div class="padding border-bottom">
			<button type="button" class="button border-green" id="checkall">
							<span class="icon-check"></span> 全选
			</button>
			<button type="submit" class="button border-red">
							<span class="icon-trash-o"></span> 一键删除
			</button>
			<button type="button" class="button border-yellow"
				onclick="window.location.href='#add'">
				<span class="icon-plus-square-o"></span> 添加分类
			</button>
			<a class="button border-main icon-plus-square-o"
				href="#" id="changeLiveRec"> 查看栏目下所有视频</a>
			<button type="button" class="button border-yellow"
				onclick="window.location.href='#add'">
				<span class="icon-plus-square-o"></span> 添加视频
			</button>
			<input type="text" placeholder="请输入搜索关键字" id="likeSearch"
						class="input"
						style="width:250px; line-height:17px;display:inline-block" /> <a
						href="javascript:void(0)" class="button border-main icon-search"
						onclick="changesearch()"> 搜索</a>
		</div>
		<table class="table table-hover text-center">
			<tr>
				<th width="5%">选择</th>
				<th width="5%">ID</th>
				<th width="15%">栏目名称</th>
				<th width="15%">封面缩略图</th>
				<th width="10%">观看人数</th>
				<th width="10%">总视频数</th>
				<th width="10%">描述</th>
				<th width="15%">操作</th>
			</tr>
			
			<c:forEach items="${programaBean.list }" var="programa">
				<tr>
				<td><input type="checkbox" name="id[]" value="${programa.programa_id }"/></td>
				<td>${fn:substring(programa.programa_id,0,5) }</td>
				<td>${fn:substring(programa.programa_name,0,10) }</td>
				<td>
					<img style="width: 50px;height: 35px"
					src="${base }/www/resources/images/${programa.programa_img}" alt="缩略图" />
				</td>
				<td>${programa.programa_wathers }</td>
				<td>${programa.programa_videos }</td>
				<td>${fn:substring(programa.programa_desc,0,10) }</td>
				<td><div class="button-group">
						<a class="button border-main" href="cateedit.html"><span
							class="icon-edit"></span> 修改</a>
							<a class="button border-red"
							href="##" onclick="del('${programa.programa_id}')"><span
							class="icon-trash-o"></span> 删除</a>
					</div></td>
				</tr>
			
			</c:forEach>
			
			<tr>
					<td>
					<td>
						<!--用来提交下查询的操作的表单  --> <input type="hidden" id="pageNum"
						name="pageNum" value="" /> <input type="hidden" id="pageCount"
						name="pageCount" value="" /> <input type="hidden" id="order"
						name="order" value="${map.order }" /> <input type="hidden"
						id="orderBy" name="orderBy" value="${map.orderBy }" /> <input
						type="hidden" id="condition" name="condition" value="" /> <input
						type="hidden" id="likeName" name="likeName" value="" /> <input
						type="hidden" id="like" name="like" value="" />
					</td>
					<pager:Pager pager="${programaBean }"
						path="${base }/sys/back/programa/manage/search"></pager:Pager>
				</tr>
		</table>
	</div>
	</form>
	<div>
		<%@include file="sys_back_programa_manage_create.jsp" %>
	</div>
</body>
<script type="text/javascript">
	var base = "${base}";
</script>
<script type="text/javascript" src="${base }/www/js/backStage/js/sys_back_programa_manage/sys_back_programa_manage.js">
	</script>
</html>
