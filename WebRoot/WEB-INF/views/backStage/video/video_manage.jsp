<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../../jsp/global.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>视频信息更改</title>
<link rel="stylesheet" href="${base }/www/css/backStage/css/admin.css">
<link rel="stylesheet" href="${base }/www/css/backStage/css/pintuer.css">
<script src="${base }/www/js/backStage/js/jquery.js"></script>
</head>

<body>
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong><span class="icon-pencil-square-o"></span> 视频信息</strong>
			
		</div>
		<div class="body-content">
			<form method="post" class="form-x"  id ="exe_form_video" action="${base }/video/updateBean/${videoBean.video_id}">
				<input type="hidden" value="${videoBean.video_id }" name="video_id" >
				
				<input type="hidden" value="${videoBean.videoType.video_type_id }" name="video_type_id" >
				
				
				<div class="form-group">
					<div class="label">
						<label>视频名字：</label>
					</div>
					<div class="field">
						<input type="text" class="input" name="video_name" value="${videoBean.video_name }" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>视频缩略图：</label>
					</div>
					<div class="field">
						<input type="text" id="url1" name="video_img" class="input tips"
							style="width:25%; float:left;" value="${videoBean.video_img }" data-toggle="hover"
							data-place="right" data-image="" /> <input type="button"
							class="button bg-blue margin-left" id="image1" value="+ 浏览上传">
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>视频别名：</label>
					</div>
					<div class="field">
						<input type="text" class="input" name="video_cname" value="${videoBean.video_cname }"" />
					</div>
				</div>
				<div class="form-group" >
					<div class="label">
						<label>关联资源：</label>
					</div>
					<div class="field">
						<input type="text" class="input" name="video_path" value="${videoBean.video_path }" />
						<div class="tips"></div>
					</div>
				</div>
				
				<div class="form-group">
					<div class="label">
						<label>栏目：</label>
					</div>
					<div class="field">
					<input type="text" class="input" name="" value="${videoBean.videoGroup.group_name }" readonly="readonly" />
						<div class="tips"></div>
						<div class="tips"><strong>[tips]</strong><font size="2px" color="red">修改栏目请前往栏目管理--视频添加</font></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>分类[菜单]：</label>
					</div>
					<div class="field">
					<li><select id="likeName_serach" class="input"
						style="width:200px; line-height:17px;">
						<option value="" name="menu_id_option"
						 onclick="chooseMenu()">请选择菜单</option>
						<c:forEach items="${menu_list }" var="menu">
							<option value="${menu.id }" name="menu_id_option">${menu.name }</option>
						</c:forEach>
					</select></li>
					<input type="text" class="input" name="menu_id" value="${videoBean.moduleMenu.name }"  disabled="disabled"/>
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>上传日期：</label>
					</div>
					<div class="field">
						<input class="input" name="" style="height:80px" readonly="readonly" value="${videoBean.create_time }"> </input>
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>视频描述：</label>
					</div>
					<div class="field">
						<textarea class="input" name="video_desc">${videoBean.video_desc }</textarea>
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>上传人：</label>
					</div>
					<div class="field">
						<input type="text" class="input" name="sysUser.user_name" value="${videoBean.sysUser.user_name }" readonly="readonly"/>
						<input type="hidden" class="input" name="sysUser.user_id" value="${videoBean.sysUser.user_id }"/>
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>授权：</label>
					</div>
					<div class="field">
						<input type="text" class="input" name="video_auth" value="${videoBean.video_auth }" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>观看人数：</label>
					</div>
					<div class="field">
						<input type="text" class="input" name="video_wathers" value="${videoBean.video_wathers }" readonly="readonly"/>
						<div class="tips"></div>
					</div>
				</div>
				
				
				<div class="form-group">
					<div class="label">
						<label>评分：</label>
					</div>
					<div class="field">
						<input type="text" class="input" name="video_rating" value=""${videoBean.video_rating }" />
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
</script>
<script type="text/javascript" src="${base }/www/js/backStage/js/manage_index_main.js"></script>
</html>
