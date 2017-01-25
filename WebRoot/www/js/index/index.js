$(function(){
	
	//登出
	
	$("#href_butt_logout").click(function(){
		var judge=window.confirm("确定要退出吗");
		if(judge){
			$.ajax({
				cache : true,
				type : "GET",
				url :base+"/sys/user/logout",
				// data:$('#exe_form_login').serialize(),// 你的formid
				async : false,
				error : function(request) {
					alert("Connection error");
				},
				success : function(data) {
					if (data > 0) {
						window.confirm("操作成功");
						window.location.replace(base + "/sys/video");
					} else {
						window.confirm("操作失败");
					}
				}
			});
		}else{
			
		}
	});
	var loadSingel=function(){
		$("exe_form_singepage").attr("method","post");
		$("exe_form_singepage").attr("action",base+"/sys/user/infor");
		$("exe_form_singepage").commit();
	};
	//点击个人头像 加载个人中心
	$("#exe_form_singepage").click(loadSingel);
	
	
	//登录注册弹出层
	
	var loginServer=function(){
		var diag = new Dialog();
		diag.Width = 400;

		diag.Height = 520;

		diag.Title = "登录注册";

		diag.URL = base+"/user/login";
		
		diag.show();
	};
	$("#exe_herf_login").click(loginServer);
	
});

var websocket = null;

//判断当前浏览器是否支持WebSocket
if('WebSocket' in window){
websocket = new WebSocket("ws://localhost:6662/rc_long/websocketToUser");
send("{user_id:'"+user_id+"'}");
}
else{
alert('Not support websocket');
}

//连接发生错误的回调方法
websocket.onerror = function(){
};

//连接成功建立的回调方法
websocket.onopen = function(event){
	
};

//接收到消息的回调方法
websocket.onmessage = function(event){
	var flag=true;
	setInterval(function(){
		if(flag){
			$("#message_div").css("color","red");
			flag=false;
		}else{
			$("#message_div").css("color","black");
			flag=true;
		}
	}, 800);
	
};

//连接关闭的回调方法
websocket.onclose = function(){
};

//监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
window.onbeforeunload = function(){
websocket.close();
};

//将消息显示在网页上
function setMessageInnerHTML(innerHTML){
}

//关闭连接
function closeWebSocket(){
websocket.close();
}

//发送消息
function send(message){
	setTimeout(function(){
		websocket.send(message);
	}, 1000);
//alert("发送消息");
//websocket.send(JSON.stringify(a));
	
}


//上传方法
function upload(){
	
}