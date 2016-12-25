	$("#changeLiveRec").click(function(){
		var diag = new Dialog();
		diag.Width = 800;

		diag.Height = 600;
		
		diag.Title = "登录注册";

		diag.URL = base+"/sys/back/live/room/search";
		diag.okButton="保存";
		diag.cancelButton="取消";
		
		diag.show();
	});
