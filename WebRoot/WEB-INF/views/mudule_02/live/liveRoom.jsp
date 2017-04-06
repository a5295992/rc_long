<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/mudule_02/include/head.jsp"%>
<!-- //nav -->
<!-- banner -->
<div style="background-color: white;width: 630px;height: 380px;position: relative;left: 500px;">
	<object width='600' height='380' id='videoPlayer' name='videoPlayer'
		type='application/x-shockwave-flash'
		classid='clsid:d27cdb6e-ae6d-11cf-96b8-444553540000'>
		<param name='movie' value='${flash_player }/swfs/videoPlayer.swf' />
		<param name='quality' value='high' />
		<param name='bgcolor' value='#000000' />
		<param name='allowfullscreen' value='true' />
		<param name='flashvars'
			value='&videoWidth=600&videoHeight=380&dsControl=manual&dsSensitivity=100&serverURL=rtmp://172.24.168.84/live/liveStream&DS_Status=true&streamType=live&autoStart=true' />
		<embed src='${flash_player }/swfs/videoPlayer.swf' width='100%' height='100%'
			id='videoPlayer' quality='high' bgcolor='#000000' name='videoPlayer'
			allowfullscreen='true'
			pluginspage='http://www.adobe.com/go/getflashplayer'
			flashvars='&videoWidth=600&videoHeight=600&dsControl=manual&dsSensitivity=100&serverURL=rtmp://172.24.168.84/live/liveStream&DS_Status=true&streamType=live&autoStart=true'
			type='application/x-shockwave-flash' menu='true'ALIGN="middle">
		</embed>
	</object>
<button onclick="add()">2222</button>
</div>

<%@ include file="/WEB-INF/views/mudule_02/include/foot.jsp"%>
<script type="text/javascript">
	function add(){
		alert($("#videoPlayer").css("height"))
	};
	
</script>
