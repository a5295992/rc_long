//用户登录注册js

function login(){
	$.ajax({
        cache: true,
        type: "POST",
        url:base+"/user/login",
        data:$("#loginForm").serialize(),// 你的formid
        async: false,
        error: function(request) {
            alert("服务器繁忙");
        },
        success: function(data) {
           if("success"===data){
        	   window.location.reload();
           }else{
        	   $("#message_font").html(data);
           }
        }
    });
}

//当获得焦点的时候 将错误信息还原


function recove(){
	
	 $("#message_font").html("");
	
}


function loginOut(){
	var enter =window.confirm("退出吗?");
	
	if(enter==1){
		$.ajax({
	        cache: true,
	        type: "GET",
	        url:base+"/fuser/loginOut",
	        async: false,
	        error: function(request) {
	            alert("服务器繁忙");
	        },
	        success: function(data) {
	        	window.confirm("您已退出登陆状态");
	        	window.location.reload();
	        }
	    });
	}
	
	
}




