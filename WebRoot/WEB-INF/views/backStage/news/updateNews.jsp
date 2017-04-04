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
<title>添加新闻</title>
<link rel="stylesheet" href="${base }/www/css/backStage/css/admin.css">
<link rel="stylesheet" href="${base }/www/css/backStage/css/pintuer.css">
<script src="${base }/www/js/backStage/js/jquery.js"></script>
</head>

<body>
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong><span class="icon-pencil-square-o"></span>修改新闻信息</strong>
			
		</div>
		<div class="body-content">
			<form method="post" class="form-x" action="${base }/news/update" >
				<input type="hidden" value="${news.news_id }" name="news_id">
				<div class="form-group">
					<div class="label">
						<label>新闻标题：</label>
					</div>
					<div class="field">
						<input type="text" class="input" name="news_title" value="${news.news_title }" />
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
						<option  name= "menu_id"value="${x.id }" 
							<c:if test="${news.menu_id eq x.id }">selected='selected'</c:if>
						
						> ${x.name }
						</option>
					</c:forEach>
					</select>
					<input name="menu_id" value="${news.menu_id }"  required="required"/>
					</div>
				</div>
				
				<div class="form-group">
					<div class="label">
						<label>是否推荐：</label>
					</div>
					<div class="field">
					
					<input name="isRecomment" value="${news.isRecomment }"/>[tips:0 or 1]
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>关键字：</label>
					</div>
					<div class="field">
					
					<input name="key_words" value="${news.key_words }"/>[tips:#key1#key2]
					</div>
				</div>
				<div class="form-group" ">
					<div class="label">
						<label>用户：</label>
					</div>
					<div class="field">
							<input type="text" class="input" name="user_name" value="${news.sysUser.user_name }"  readonly="readonly"/>
							<input type="hidden" class="input" name="user_id" value="${news.user_id }" />
						<div class="tips"></div>
					</div>
				</div>
				
				<div class="form-group">
					<div class="label">
						<label>新闻封面：</label>
					</div>
					<div class="field">
						<input type="text" id="url1" name="news_img" class="input tips"
							style="width:25%; float:left;" value="${news.news_img }" data-toggle="hover"
							data-place="right" data-image="" /> 
							<input type="button"
							class="button bg-blue margin-left" id="image1" value="+ 浏览上传" onclick="img_file()">
					</div>
				</div>
					<div class="form-group">
					<div class="label">
						<label>内容：</label>
					</div>
					<div class="field">
						<textarea name="news_content" class="input" style="height:120px;">${news.news_content }</textarea>
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
	
		
</script>

<script type="text/javascript" src="${back_static }/js/news_update.js"></script>
</html>
