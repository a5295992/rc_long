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
<title>添加轮播</title>
<link rel="stylesheet" href="${base }/www/css/backStage/css/admin.css">
<link rel="stylesheet" href="${base }/www/css/backStage/css/pintuer.css">
<script src="${base }/www/js/backStage/js/jquery.js"></script>
</head>

<body>
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong><span class="icon-pencil-square-o"></span>添加新轮播图</strong>
			
		</div>
		<div class="body-content">
			<form method="post" class="form-x" action="${base }/replayImg/add" >
				<input type="hidden" value="<%=CommoTools.getUUID() %>" name="id">
				<div class="form-group">
					<div class="label">
						<label>轮播标题：</label>
					</div>
					<div class="field">
						<input type="text" class="input" name="title" value="" />
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
					<input name="menu_id" value=""  required="required"/>
					</div>
				</div>
				
				<div class="form-group">
					<div class="label">
						<label>封面：</label>
					</div>
					<div class="field">
						<input type="text" id="url1" name="img" class="input tips"
							style="width:25%; float:left;" value=" " data-toggle="hover"
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
						<textarea name="intruduction" class="input" style="height:120px;">
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
	
	function toValue(){
		
		$("input[name='menu_id']").val($("#p_id_sele").val());
		
	}
	
	
		
</script>

</html>
