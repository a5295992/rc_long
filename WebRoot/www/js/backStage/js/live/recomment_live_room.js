	var diag = new Dialog();	
	$("#changeLiveRec").click(function(){
		
		diag.Width = 1200;

		diag.Height = 600;
		
		diag.Title = "更改直播推荐";

		diag.URL = base+"/sys/back/live/room/search";
		
		diag.show();
		diag.okButton="保存";
		diag.cancelButton="取消";
	});
