<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../jsp/global.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="${base }/www/css/backStage/css/pintuer.css">
<link rel="stylesheet" href="${base }/www/css/backStage/css/admin.css">
<script src="${base }/www/js/backStage/js/jquery.js"></script>
<script src="${base }/WebRoot/www/js/backStage/js/pintuer.js"></script>
</head>

<body>
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong><span class="icon-key"></span> 修改会员信息</strong>
		</div>
		<div class="body-content">
			<form class="form-x"  id="exe_form_login">
				<div class="form-group">
					<div class="label">
						<label for="sitename">用户账号：</label>
					</div>
					<div class="field">
						<label style="line-height:33px;"> ${user.user_ssid } </label>
					</div>
				</div>
					<div class="form-group">
					<div class="label">
						<label for="sitename">用户昵称：</label>
					</div>
					<div class="field">
						<label style="line-height:33px;"> ${user.user_name } </label>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="sitename">用户状态：</label>
					</div>
					<select name="user_flag"
						style="padding:5px 15px; border:1px solid #ddd;"
						onchange="changecate(this)">
						
						<option value="" >请选择状态</option>
						<option value="0"  <c:if test="${user.user_type eq '0' }">selected="selected"</c:if>>可用</option>
						<option value="1" <c:if test="${user.user_type eq '1' }">selected="selected"</c:if>>封号</option>
					</select>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="sitename">用户类型：</label>
					</div>
					<select name="user_type"
						style="padding:5px 15px; border:1px solid #ddd;"
						onchange="changecate(this)">
						<option value="" >请选择类型</option>
						<option value="0" <c:if test="${user.user_type eq '0' }">selected="selected"</c:if>>0(普通用户)</option>
						<option value="1" <c:if test="${user.user_type eq '1' }">selected="selected"</c:if>>1(会员)</option>
						<option value="2" <c:if test="${user.user_type eq '2' }">selected="selected"</c:if>>2(普通管理员)</option>
						<option value="3" <c:if test="${user.user_type eq '3' }">selected="selected"</c:if>>3(超级管理员)</option>
					</select>
				</div>
				

				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<div class="field">
						<button class="button bg-main icon-check-square-o" type="button">
							更改</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
<script type="text/javascript">
	var base="${base}";
	var user_id="${user.user_id}";
</script>
<script type="text/javascript" src="${base }/www/js/backStage/js/user_edit.js"></script>
</html>
