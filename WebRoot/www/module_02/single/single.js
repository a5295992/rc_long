//视频播放
/*
	 * ar flag = 0; function videoPlay(video_path) {
	 *  // alert(video_path); $("#video").css("height", "360");
	 * $("#video").html( "<a
	 * href='http://pseudo01.hddn.com/vod/demo.flowplayervod/flowplayer-700.flv'" +
	 * "style='display:block;width:600px;height:360px' " + " id='my52player'>
	 * </a> "); $("#play_list").css("display", "block")
	 * $("#video").append($("#play_list"));
	 * 
	 * flowplayer("my52player", $player + "/flowplayer-3.2.11.swf", { clip : {
	 * url : "http://demo.cuplayer.com/file/ad6.mp4", autoPlay : false,
	 * autoBuffering : true }, playlist : [ // playlist is an array of Clips,
	 * hence [...]
	 * 
	 * base+"/"video_path, // simple playlist entry: // video
	 * 'http://demo.cuplayer.com/file/ad3.mp4', { // small object as entry url :
	 * "http://demo.cuplayer.com/file/ad4.mp4", duration : 25 } ], plugins : { //
	 * load one or more plugins controls : { // load the controls plugin
	 *  // always: where to find the Flash object url : $player +
	 * '/flowplayer.controls-3.2.11.swf',
	 *  // now the custom options of the Flash object playlist : true,
	 * backgroundColor : '#aedaff', tooltips : { // this plugin object exposes a
	 * 'tooltips' // object buttons : true, fullscreen : '全屏' } } },
	 *  // set an event handler in the configuration onFinish : function() { var
	 * video_ids=$("input[name='video_id_id']"); video_ids.each(function(){
	 * window.location.herf=base+"/video/"+$(this).val(); return; }); } });
	 *  }
	 */



function videoPlay(video_path) {

	$("#video").css("height", "380");
	$("#video").html(
			"<object width='700' height='380' id='videoPlayer' " +
			"name='videoPlayer' type='application/x-shockwave-flash'" +
			" classid='clsid:d27cdb6e-ae6d-11cf-96b8-444553540000' >" +
			"<param name='movie' value='"+$flash_player+"/swfs/videoPlayer.swf' />" +
			" <param name='quality' value='high' /> " +
			"<param name='bgcolor' value='#000000' /> " +
			"<param name='allowfullscreen' value='true' />" +
			" <param name='flashvars' value= '&videoWidth=0&" +
			"videoHeight=0&dsControl=manual&dsSensitivity=100&DS_Status=true&streamType=vod&autoStart=true&" +
			"serverURL=rtmp:/vod/mp4:sample2_1000kbps.f4v'/>" +
			"<embed src='"+$flash_player+"/swfs/videoPlayer.swf' width='700' height='380px' id='videoPlayer' quality='high'" +
			" bgcolor='#000000' name='videoPlayer' allowfullscreen='true' " +
			"pluginspage='http://www.adobe.com/go/getflashplayer'   " +
			"flashvars='&videoWidth=0&videoHeight=0&dsControl=manual&dsSensitivity=100&DS_Status=true&" +
			"streamType=vod&autoStart=true&serverURL="+video_path+"' " +
			"type='application/x-shockwave-flash'> </embed>" +
			"</object> ");
	$("#play_list").css("display", "block")
	$("#video").append($("#play_list"));
	
	
	

}


// 添加新留言
function createNewComment(){
	var comment_id=$("input[name='comment_id']").val();
	if(comment_id.trim()!=""){
		url=base+"/comment/create/"+comment_id;
	}else{
		url=base+"/comment/create";
	}
	// 字符檢測
	
	// 评论表单
	var comment_form = $("#comment_form");
	
	if($("#comment_data").val().trim()!=""){
		
		$.ajax({
	        cache: true,
	        type: "POST",
	        url:url,
	        data:comment_form.serialize(),// 你的formid
	        async: false,
	        error: function(request) {
	            alert("Connection error");
	        },
	        success: function(data) {
	        	if(data==1){
	        		window.confirm("评论成功");
	        		window.location.reload();
	        	}else if(data==-5){
	        		window.confirm("敏感词汇");
	        	}else if(data==-2){
	        		window.confirm("您无发言权利");
	        	}
	        	
	        }
	    });
		
	}else{
		window.confirm("请输入内容");
	}
}

function recommentTOUser(comment_id,user_name){
	$("input[name='comment_id']").val(comment_id);
	//
	$("#comment_data").attr("placeholder","回复:"+user_name);
}


function recoverTonew(){
	$("input[name='comment_id']").val("");
	$("#comment_data").attr("placeholder","我也要说一句");
	
	
}