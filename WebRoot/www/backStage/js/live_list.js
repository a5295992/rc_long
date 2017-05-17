//添加
var addNews = function(){
	
	var diag = new Dialog();
	
	
	diag.Title = "更改视频信息";

	diag.URL = base + "/blive/toAddorUpdate";
	
	diag.OKEvent=function(){
		var listform=diag.innerFrame.contentWindow.$("#addlistform");
		
		$.ajax({
	        cache: true,
	        type: "POST",
	        url:base+"/blive/add",
	        data:listform.serialize(),// 你的formid
	        async: false,
	        error: function(request) {
	            alert("Connection error");
	        },
	        success: function(data) {
	           if(data=="ok"){
	        	   diag.close();
	       		   window.location.reload();
	           }
	        }
	    });
	}
	diag.Width = 1100;
	diag.Height = 700;
	diag.show();
}

$("#addnews").click(addNews);



function update(liveId){
	var diag = new Dialog();
	
	diag.Title = "更改信息";

	diag.URL = base + "/blive/toAddorUpdate?liveId="+liveId;
	
	diag.OKEvent=function(){
		var listform=diag.innerFrame.contentWindow.$("#addlistform");
		
		$.ajax({
	        cache: true,
	        type: "POST",
	        url:base+"/blive/add",
	        data:listform.serialize(),// 你的formid
	        async: false,
	        error: function(request) {
	            alert("Connection error");
	        },
	        success: function(data) {
	           if(data=="ok"){
	        	   diag.close();
	       		   window.location.reload();
	           }
	        }
	    });
		
	}
	diag.Width = 1100;
	diag.Height = 700;
	diag.show();
}




//删除

function dele(news_id){
	
	
	var enter = window.confirm("确定删除吗");
	
	if(enter==1){
		$.ajax({
	        cache: true,
	        type: "POST",
	        url:base+"/blive/dele/"+news_id,
	        async: false,
	        error: function(request) {
	            alert("Connection error");
	        },
	        success: function(data) {
	           if(data=="ok"){
	        	   window.location.reload();
	           }else{
	        	   window.confirm(data);
	           }
	        }
	    });
	}
	
}


$("#authmanage").click(function(){
	var index = 0;
	var live_id=null;
	$("input[name='id[]']").each(function() {
		if (this.checked == true) {
			index=index+1;
			live_id=$(this).val();
		}
	});
	if(index!=1){
		window.confirm("选且仅能选择一位");
	}else{
		var auth = $("#auth"+live_id).text();
		if(auth==1){
			var enter = window.confirm("该直播对象已授权 禁用该对象吗?");
			if(enter==1){
				auth=0;
			}
		}else{
			var enter = window.confirm("该直播对象未授权 授权该对象吗?");
			if(enter==1){
				auth=1;
			}
		}
		$.ajax({
	        cache: true,
	        type: "POST",
	        url:base+"/blive/update/"+live_id+"/"+auth,
	        async: true,
	        error: function(request) {
	        	 window.location.reload();
	        },
	        success: function(data) {
	           if(data=="ok"){
	        	   window.location.reload();
	           }else{
	        	   window.confirm(data);
	           }
	        }
	    });
	}
	
});