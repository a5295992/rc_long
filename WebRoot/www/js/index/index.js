$(function(){
	
	//登出
	
	$("#href_butt_logout").click(function(){
		var judge=window.confirm("确定要退出吗");
		if(judge){
			window.location.href=base+"/sys/user/logout";
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
