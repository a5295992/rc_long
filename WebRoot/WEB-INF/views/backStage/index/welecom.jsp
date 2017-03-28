<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="base" value="${pageContext.request.contextPath }"></c:set>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>欢迎页面</title>
<link rel="stylesheet" href="${base }/www/css/backStage/css/admin.css">
<link rel="stylesheet" href="${base }/www/css/backStage/css/pintuer.css">
<script src="${base }/www/js/backStage/js/jquery.js"></script>
</head>

<body>
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong><span></span> 当前用户</strong>
			<span >欢迎您!尊敬的管理员(${ShiroUser.user_ssid })${dateFiled }好</span>
		</div>
		<div class="body-content">
			<form method="post" class="form-x" action="">
				<div class="form-group">
					<div class="label">
						<label>当前系统可用内存：</label>
					</div>
					<div class="field">
						<input type="text" class="input" name="stitle" value="${mee }"  id="useMemery" readonly="readonly"/>
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>您上次登录时间是：</label>
					</div>
					<div class="field">
					<input type="text" class="input" name="stitle" value="${ShiroUser.user_last_time }"  id="useMemery" readonly="readonly"/>
						
						<div class="tips">
							如果不是您主动登录的，很可能密码泄露了 请尽快<a href="${base }/admin/updatekey">[修改密码]</a>
						</div>
					</div>
				</div>
				</form>
				
		</div>
	</div>
</body>

<script type="text/javascript">
	
</script>
</html>
