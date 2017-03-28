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
<title>网站信息</title>
<link rel="stylesheet" href="${base }/www/css/backStage/css/admin.css">
<link rel="stylesheet" href="${base }/www/css/backStage/css/pintuer.css">
<script src="${base }/www/js/backStage/js/jquery.js"></script>
</head>

<body>
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong><span class="icon-pencil-square-o"></span> 网站信息</strong>
			<input type="button"
							class="button bg-blue margin-left" id="image1" value="重启服务器" onclick="restart()">
		</div>
		<div class="body-content">
			<form method="post" class="form-x" action="${base }/system/witeSet/update">
				<input type="hidden" value="${witeSiteInfor.id }" name="id">
				<div class="form-group">
					<div class="label">
						<label>网站标题：</label>
					</div>
					<div class="field">
						<input type="text" class="input" name="wite_name" value="${witeSiteInfor.wite_name }" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>网站LOGO：</label>
					</div>
					<div class="field">
						<input type="text" id="url1" name="wite_logo" class="input tips"
							style="width:25%; float:left;" value="${witeSiteInfor.wite_logo }" data-toggle="hover"
							data-place="right" data-image="" /> <input type="button"
							class="button bg-blue margin-left" id="image1" value="+ 浏览上传">
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>网站域名：</label>
					</div>
					<div class="field">
						<input type="text" class="input" name="wite_href" value="${witeSiteInfor.wite_href }"" />
					</div>
				</div>
				<div class="form-group" style="display:none">
					<div class="label">
						<label>副加标题：</label>
					</div>
					<div class="field">
						<input type="text" class="input" name="wite_name_" value="" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>网站关键字：</label>
					</div>
					<div class="field">
						<textarea class="input" name="wite_key" style="height:80px" > ${witeSiteInfor.wite_key }</textarea>
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>网站描述：</label>
					</div>
					<div class="field">
						<textarea class="input" name="wite_desc">${witeSiteInfor.wite_desc }</textarea>
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>联系人：</label>
					</div>
					<div class="field">
						<input type="text" class="input" name="wite_author" value="${witeSiteInfor.wite_author }"" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>手机：</label>
					</div>
					<div class="field">
						<input type="text" class="input" name="phone" value="${witeSiteInfor.phone }"" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>电话：</label>
					</div>
					<div class="field">
						<input type="text" class="input" name="s_phone" value="" />
						<div class="tips"></div>
					</div>
				</div>
				
				
				<div class="form-group">
					<div class="label">
						<label>QQ：</label>
					</div>
					<div class="field">
						<input type="text" class="input" name="qq" value=""${witeSiteInfor.qq }" />
						<div class="tips"></div>
					</div>
				</div>
				

				<div class="form-group">
					<div class="label">
						<label>Email：</label>
					</div>
					<div class="field">
						<input type="text" class="input" name="connet_email" value="${witeSiteInfor.connet_email }"" />
						<div class="tips"></div>
					</div>
				</div>
				

				<div class="form-group">
					<div class="label">
						<label>底部信息：</label>
					</div>
					<div class="field">
						<textarea name="copy_right" class="input" style="height:120px;">
						${witeSiteInfor.copy_right }
						</textarea>
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<div class="field">
						<button class="button bg-main icon-check-square-o" type="submit"  id="submit">
							提交</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
<script type="text/javascript">
	var base = "${base}";
	if("${message}"!=""){
		window.confirm("${message}")
	}
	
</script>
<script type="text/javascript" src="${back_static }/js/webinfor.js"></script>
</html>
