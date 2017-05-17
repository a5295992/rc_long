<%@page import="com.rc_long.utils.CommoTools"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../jsp/global.jsp" %> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>添加直播间</title>
<link rel="stylesheet" href="${base }/www/css/backStage/css/admin.css">
<link rel="stylesheet" href="${base }/www/css/backStage/css/pintuer.css">
</head>

<body>
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong><span class="icon-pencil-square-o"></span>添加直播信息</strong>
			
		</div>
		<div class="body-content">
			<form method="post" class="form-x" action="${base }/blive/add"  id = "addlistform">
				<input type="hidden" value="<%=CommoTools.getUUID()%>" name="live_id">
				<div class="form-group">
					<div class="label">
						<label>直播标题：</label>
					</div>
					<div class="field">
						<input type="text" class="input" name="live_name" value="${ShiroUser.user_name }的直播间" />
						<div class="tips"></div>
					</div>
				</div>
				
				<div class="form-group">
					<div class="label">
						<label>直播路径：</label>
					</div>
					<div class="field">
						<input type="text" class="input" name="live_path" value="rtmp://localhost/live/${ShiroUser.user_id }" readonly="readonly"/>
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>分类：</label>
					</div>
					<div class="field">
					
					<select onchange="toValue()" id="p_id_sele">
					<c:forEach items="${menu_list }" var="x">
						<option  name= "menu_id"value="${x.id }" > ${x.name }
						</option>
					</c:forEach>
					</select>
					<input name="menu_id" value="0"  required="required"/>
					</div>
				</div>
				
				<div class="form-group">
					<div class="label">
						<label>是否推荐：</label>
					</div>
					<div class="field">
					
					<input name="is_recoment" value="1"/>[tips:0 or 1 默认[1:推荐]]
					</div>
				</div>
				
				
				
				<div class="form-group" ">
					<div class="label">
						<label>用户：</label>
					</div>
					<div class="field">
							<input type="text" class="input" name="user_name" value="${ShiroUser.user_name }"  readonly="readonly"/>
							<input type="hidden" class="input" name="user_id" value="${ShiroUser.user_id }" />
							<input type="hidden" class="input" name="creare_time" value="<%=CommoTools.getTime()%>" />
							<input type="hidden" class="input" name="live_status" value="0" />
							<input type="hidden" class="input" name="auth" value="0" />
						<div class="tips"></div>
					</div>
				</div>
				
				<div class="form-group" ">
					<div class="label">
						<label>搜索关键字：</label>
					</div>
					<div class="field">
							<input type="text" class="input" name="key_words" value="${news.key_words }"  />
						<div class="tips"></div>
					</div>
				</div>
				
				<div class="form-group">
					<div class="label">
						<label>新闻封面：</label>
					</div>
					<div class="field">
						<input type="text" id="url1" name="live_img" class="input tips"
							style="width:25%; float:left;" value=" " data-toggle="hover"
							data-place="right" data-image="" /> 
							<input type="button"
							class="button bg-blue margin-left" id="image1" value="+ 浏览上传" onclick="img_file()">
					</div>
				</div>
					<div class="form-group">
					<div class="label">
						<label>直播间描述：</label>
					</div>
					<div class="field">
						<textarea name="live_desc" class="input" style="height:120px;">
						</textarea>
						<div class="tips"></div>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
<script type="text/javascript">
	var base = "${base}";
	
	function toValue(){
		
		$("input[name='menu_id']").val($("#p_id_sele").val());
		
	}
	
	function img_file(){
		var diag = new Dialog();
		diag.Title="关联资源选择";
		diag.Width=1100;
		diag.Height=600;
		diag.URL=base+"/sys/web/static/resource/manage/public";
		diag.OKEvent=function(){
		var resource_name=diag.innerFrame.contentWindow.$("#show_name").val();
			$("#url1").val(resource_name);
			diag.close();
		}
		
		diag.show();
	}
	$(function(){
		
		if("${message}".trim()!=""){
			window.confirm(("${message}"));
			setTimeout(function(){
				parent.location.reload();
			}, 1000);
		}
	});
		
</script>
</html>
