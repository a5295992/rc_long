<%@page import="com.rc_long.enumeration.VideoTypeConstants"%>
<%@page import="com.rc_long.enumeration.DescribeConstants" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../../jsp/global.jsp"%>
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
<script src="${base }/WebRoot/www/js/backStage/js/pintuer.js"></script>
</head>

<body style="padding: 80px;background-color: #59CFC7">
	<div>
		<!-- <div class="panel-head">
			<strong><span class="icon-key"></span> 视频管理</strong>
		</div> -->
		<div>
			<form class="form-x" id="exe_form_login">
				<input type="hidden" value="${videoBean.video_id }" name="video_id" />
				<input type="hidden" value="${videoBean.video_auth }"
					name="video_auth" /> 
					<input type="hidden"
					value="${videoBean.video_type }" name="video_type"/> <input
					type="hidden" value="${videoBean.video_desc }" name="video_desc" />
				<div>
					<div>
						<label for="sitename">是否审核：</label>
					</div>
					<hr>
					<select name="video_auth"
						style="padding:5px 15px; border:1px solid #ddd;">

						<option value="">请选择状态</option>
						<option value="0"
							<c:if test="${videoBean.video_auth eq '0' }">selected="selected"</c:if>>未审核</option>
						<option value="1"
							<c:if test="${videoBean.video_auth eq '1' }">selected="selected"</c:if>>已审核</option>
					</select>
				</div>
				<div>
				</div>
				<div>
					<div>
						<label for="sitename">定义视频类型：</label>
					</div>
					<hr>
					<select name="video_type"
						style="padding:5px 15px; border:1px solid #ddd;">
						<option value="">请选择类型</option>
						<c:forEach items="${video_type_bean }" var="video_type">
							<c:set var="video_type" value="${video_type.video_type_id }"
								scope="request"></c:set>
							<option value="${video_type.video_type_id }"
								<c:if test="${video_type.video_type_id eq videoBean.video_type }">selected="selected"</c:if>><%=VideoTypeConstants.chooseName(Integer
						.parseInt((String) request.getAttribute("video_type")))%></option>
						</c:forEach>
					</select>
				</div>
				<div>
					<div class="label">
						<label for="sitename">管理员描述：</label>
					</div>
					<hr>
					<select name="video_desc"
						style="padding:5px 15px; border:1px solid #ddd;">
						<option value="">描述内容</option>
						<option value="<%=DescribeConstants.exe_01%>"
							<c:if test="${videoBean.video_desc eq '真心不错!' }">selected="selected"</c:if>>真心不错!</option>
						<option value="<%=DescribeConstants.exe_01%>"
							<c:if test="${videoBean.video_desc eq '可以的!' }">selected="selected"</c:if>>可以的!</option>
						<option value="<%=DescribeConstants.exe_01%>"
							<c:if test="${videoBean.video_desc eq '良心!' }">selected="selected"</c:if>>良心!</option>
						<option value="<%=DescribeConstants.exe_01%>"
							<c:if test="${videoBean.video_desc eq '太逊了!' }">selected="selected"</c:if>>太逊了!</option>
					</select>
				</div>

				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<!-- <div class="field">
						<button class="button bg-main icon-check-square-o" type="button">
							更改</button>
					</div> -->
				</div>
			</form>
		</div>
	</div>
</body>
<script type="text/javascript">
	var base = "${base}";
	var user_id = "${user.user_id}";
</script>
<script type="text/javascript"
	src="${base }/www/js/backStage/video/video_manage.js"></script>
</html>
