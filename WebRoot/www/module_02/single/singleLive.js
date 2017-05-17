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



/*function videoPlay(video_path) {

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
	
}*/



//加入直播


//进入聊天室 
	var websocket = null;
       
      //判断当前浏览器是否支持WebSocket
      if('WebSocket' in window){
    	 	
          websocket = new WebSocket("ws://"+basePathUrl+"websocketToLiveRoom");
      }
      else{
          alert('Not support websocket');
      }
      //连接发生错误的回调方法
      websocket.onerror = function(){
          setMessageInnerHTML("error");
      };
       
      //连接成功建立的回调方法
      websocket.onopen = function(event){
    	  var message2 ={"live_fid":live_id};
    	  send(JSON.stringify(message2));
      };
       
      //接收到消息的回调方法
      websocket.onmessage = function(event){
          var dat = event.data;
          var dataObj=eval("("+dat+")");//转换为json对象\
          if(typeof(dataObj.count)!="undefined"){
        	 $("#count_s_p"+dataObj.live_id).html(dataObj.count);
          }
          var index= 0;
         if(typeof(dataObj.errorMessage)=="undefined"){
       	  if($("p[name='chat_name']").length>3){
           	  $("p[name='chat_name']").each(function(){
           		  if(index==0){
           			  $(this).remove(); 
           			  index =index+1;
           		  }
           	  });
             }
       	  	if(typeof(dataObj.user_name)!="undefined"){
       	  		$("#chat"+dataObj.live_id).append("<p name='chat_name'>"+dataObj.user_name+":"+dataObj.chattig+"</p>");
       	  	}
            
         }else{
       	  	window.confirm(dataObj.errorMessage);
         }
      };
       
      //连接关闭的回调方法
      websocket.onclose = function(){
          setMessageInnerHTML("close");
      };
       
      //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
      window.onbeforeunload = function(){
          websocket.close();
      };
       
      //将消息显示在网页上
      function setMessageInnerHTML(innerHTML){
          document.getElementById('message').innerHTML += innerHTML + '<br/>';
      }
       
      //关闭连接
      function closeWebSocket(){
          websocket.close();
      }
       
      //发送消息
      function send(message){
    	  //alert("发送消息");
    	  websocket.send(message);
    	 
      }
      //发送消息
      function sendMs(user_name){
    	  if(user_name!=""){
    		  var chatting  = $("#comment_data").val();
        	  var message ={"live_id":live_id,"user_name":user_name,"chattig":chatting};
        	  send(JSON.stringify(message));
    	  }
    	  
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