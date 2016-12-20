<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="../../jsp/global.jsp"%>
<%@taglib prefix="pager" uri="http://com.suse/jsp/jstl/sky"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="${base }/www/css/backStage/css/admin.css">
<link rel="stylesheet" href="${base }/www/css/backStage/css/pintuer.css">
<script src="${base }/www/js/backStage/js/jquery.js"></script>
<script type="text/javascript" src="${base }/www/js/zDialog.js"></script>
<script type="text/javascript" src="${base }/www/js/zDrag.js"></script>
</head>
<body>
	<form id="listform">
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong class="icon-reorder"> 用户列表</strong> <a href=""
					style="float:right; display:none;">添加字段</a>
			</div>
			<div class="padding border-bottom">
				<ul class="search" style="padding-left:10px;">
					<li><a class="button border-main icon-plus-square-o"
						href="add.html"> 向用户推送消息</a></li>
					<li>搜索：</li>
					<li>首页 <select name="s_ishome" class="input"
						onchange="changesearch()"
						style="width:60px; line-height:17px; display:inline-block">
							<option value="">选择</option>
							<option value="1">是</option>
							<option value="0">否</option>
					</select> &nbsp;&nbsp; 推荐 <select name="s_isvouch" class="input"
						onchange="changesearch()"
						style="width:60px; line-height:17px;display:inline-block">
							<option value="">选择</option>
							<option value="1">是</option>
							<option value="0">否</option>
					</select> &nbsp;&nbsp; 置顶 <select name="s_istop" class="input"
						onchange="changesearch()"
						style="width:60px; line-height:17px;display:inline-block">
							<option value="">选择</option>
							<option value="1">是</option>
							<option value="0">否</option>
					</select>
					</li>
					<li><select id="likeName_serach" class="input"
						style="width:200px; line-height:17px;">
							<option value="">请选择查询条件</option>
							<option value="user_name"
								<c:if test="${likeName eq 'user_name' }">selected="selected"</c:if>>用户姓名</option>
							<option value="user_id"
								<c:if test="${likeName eq 'user_id' }">selected="selected"</c:if>>用户ID</option>
							<option value="user_type"
								<c:if test="${likeName eq 'user_type' }">selected="selected"</c:if>>用户类型</option>
							<option value="user_flag"
								<c:if test="${likeName eq 'user_flag' }">selected="selected"</c:if>>用户状态</option>
					</select></li>
					<li><input type="text" placeholder="请输入搜索关键字" id="likeSearch"
						class="input"
						style="width:250px; line-height:17px;display:inline-block" /> <a
						href="javascript:void(0)" class="button border-main icon-search"
						onclick="changesearch()"> 搜索</a></li>
				</ul>
			</div>
			<table class="table table-hover text-center">
				
				<%@include file="user_list_date.jsp" %>
				
				<tr>
					<td style="text-align:left; padding:19px 0;padding-left:20px;"><input
						type="checkbox" id="checkall" /> 全选</td>
					<td colspan="7" style="text-align:left;padding-left:20px;"><a
						href="javascript:void(0)" class="button border-red icon-trash-o"
						style="padding:5px 15px;" onclick="DelSelect()"> 删除</a> <a
						href="#desc" style="padding:5px 15px; margin:0 10px;"
						class="button border-blue icon-edit" onclick="sorts()"> <c:choose>
								<c:when test="${map.oder eq 'desc' }">
									<span>排序:升序</span>
								</c:when>
								<c:otherwise>
									<span>排序:降序</span>
								</c:otherwise>
							</c:choose>


					</a> 排序方式： <select name="ishome"
						style="padding:5px 15px; border:1px solid #ddd;"
						onchange="changgeThingOder()">
							<option value="user_name">名字</option>
							<option value="user_id">ID</option>
							<option value="user_ssid">账号</option>
							<option value="user_last_time">登录时间</option>
					</select>
				</tr>
				<tr>
					<td>
						<!--用来提交下查询的操作的表单  --> <input type="hidden" id="pageNum"
						name="pageNum" value="0" /> <input type="hidden" id="pageCount"
						name="pageCount" value="10" /> <input type="hidden" id="oder"
						name="oder" value="${map.oder }" /> <input type="hidden"
						id="oderBy" name="oderBy" value="${map.oderBy }" /> <input
						type="hidden" id="condtion" name="condtion" value="" /> <input
						type="hidden" id="likeName" name="likeName" value="" /> <input
						type="hidden" id="like" name="like" value="" />
						
						<pager:Pager pager="${user_bean }" path="${base }/sys/back/user/search" />
				</tr>
			</table>
		</div>
	</form>
	
	<script type="text/javascript">
		var base = "${base}";
		var pageNum = "${user_bean.pageNum}";
	</script>
	<script type="text/javascript"
		src="${base }/www/js/backStage/js/user_list2.js"></script>
</body>
</html>
