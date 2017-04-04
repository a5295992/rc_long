//添加
var addNews = function(){
	
	var diag = new Dialog();
	
	
	diag.height = 900;
	
	diag.wight= 1000;
	
	diag.Title = "更改视频信息";

	diag.URL = base + "/replayImg/toadd";
	
	diag.OKEvent=function(){
		diag.close();
		window.location.reload();
	}
	
	diag.show();
}

$("#addnew").click(addNews);



function update(news_id){
	var diag = new Dialog();
	
	
	diag.height = 900;
	
	diag.wight= 1000;
	
	diag.Title = "更改视频信息";

	diag.URL = base + "/replayImg/toadd?re_id="+news_id;
	
	diag.OKEvent=function(){
		diag.close();
		window.location.reload();
	}
	
	diag.show();
}




//删除

function dele(news_id){
	
	
	var enter = window.confirm("确定删除吗");
	
	if(enter==1){
		$.ajax({
	        cache: true,
	        type: "POST",
	        url:base+"/replayImg/dele/"+news_id,
	        async: false,
	        error: function(request) {
	            alert("Connection error");
	        },
	        success: function(data) {
	           if(data=="success"){
	        	   window.location.reload();
	           }else{
	        	   window.confirm(data);
	           }
	        }
	    });
	}
	
}

function img_file(){
	var diag = new Dialog();
	diag.Title="关联资源选择";
	diag.Width=1100;
	diag.Height=600;
	diag.URL=base+"/sys/web/static/resource/manage/public";
	diag.OKEvent=function(){
	var resource_name=diag.innerFrame.contentWindow.$("#show_name").val();
		$("#url1").val(resource_name);
		diag.close();
	}
	
	diag.show();
}