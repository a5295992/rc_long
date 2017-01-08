	
	$("#changeLiveRec").click(function(){
		var diag = new Dialog();	
		diag.Width = 1200;

		diag.Height = 600;
		
		diag.Title = "更改直播推荐";

		diag.URL = base+"/sys/back/live/room/search";
		diag.CancelEvent=function(){
			diag.close();
			window.location.reload();
		};
		diag.okButton="保存";
		diag.cancelButton="取消";
		
		diag.show();
	});
