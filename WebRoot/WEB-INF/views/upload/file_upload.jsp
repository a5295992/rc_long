<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="../../jsp/global.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${base }/www/css/upload/css/default.css">
<link rel="stylesheet" href="${base }/www/css/upload/css/index.2.0.css">
<script type="text/javascript" src="${base }/www/resources/upload/swfupload/swfupload.js"></script>
<script type="text/javascript" src="${base }/www/js/file/upload/handlers.js"></script>
<script type="text/javascript" src="${base }/www/js/file/upload/swfupload.queue.js"></script>

<title>swf文件上传</title>
</head>
<body>
	<div id="content">
	<form id="form1" action="${base }/sys/file/swf/upload/start" method="post" enctype="multipart/form-data">

		<p>点击“浏览”按钮，选择您要上传的文档文件后，系统将自动上传并在完成后提示您。</p>
		<p>请勿上传包含中文文件名的文件！</p>
		<div class="fieldset flash" id="fsUploadProgress">
			<span class="legend">快速上传</span>

	  </div>
		<div id="divStatus">0 个文件已上传</div>
			<div>
				<span id="spanButtonPlaceHolder"></span>
				<input id="btnCancel" type="button" value="取消所有上传" onclick="swfu.cancelQueue();" disabled="disabled" style="margin-left: 2px; font-size: 8pt; height: 29px;" />
			
			<input type="submit" name="upload" value="查看" style="margin-left: 2px; font-size: 8pt; height: 29px;" />
			</div>

	</form>
</div>
   
</body>
<script type="text/javascript" src="${base }/www/js/file/upload/swfupload.js"></script>
</html>