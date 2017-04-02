//添加
var addNews = function(){
	
	var diag = new Dialog();
	
	
	diag.height = 900;
	
	diag.wight= 1000;
	
	diag.Title = "更改视频信息";

	diag.URL = base + "/news/add";
	
	diag.OKEvent=function(){
		diag.close();
		window.location.reload();
	}
	
	diag.show();
}

$("#addnews").click(addNews);



function update(news_id){
	var diag = new Dialog();
	
	
	diag.height = 900;
	
	diag.wight= 1000;
	
	diag.Title = "更改视频信息";

	diag.URL = base + "/news/update/"+news_id;
	
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
	        url:base+"/news/dele/"+news_id,
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