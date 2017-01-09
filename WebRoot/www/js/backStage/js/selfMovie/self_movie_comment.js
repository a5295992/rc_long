/*//当页面加载的时候
function onLoad(){
	$.ajax({
        cache: true,
        type: "GET",
        url:base+"/sys/back/self/edit/search/already",
        //data:$('#exe_form_login').serialize(),// 你的formid
        async: false,
        error: function(request) {
            alert("Connection error");
        },
        success: function(html) {
            
        	$("#self_edit_bean_list").html(html);
        }
    });
}

$(function(){
	onLoad();
});*/

var self_control_rec= function (){
	var diag = new Dialog();

	diag.Title = "更改自编辑推荐";

	diag.URL = base+"/sys/back/self/movie/comment/search";
	
	diag.OKEvent = function(){
		var e= window.confirm("确认操作吗?");
		if(e==1){
			var doc = diag.innerFrame.contentWindow.$("input[name='id[]']");
			var data = "" ;
			var index = 0;
			doc.each(function() {
				if (this.checked == true) {
					data = data+$(this).val()+",";
					
					index=index+1;
				}
			});
			if(index!=3){
				window.confirm("请选择三个推荐视频");
				return ;
			}
			$.ajax({
		        cache: true,
		        type: "POST",
		        url:base+"/sys/back/self/movie/comment/update",
		        //data:$('#exe_form_login').serialize(),// 你的formid
		        data:{"data_id":data},
		        async: false,
		        error: function(request) {
		            alert("Connection error");
		        },
		        success: function(data) {
		            if(data>0){
		            	
		            	var enter = window.confirm("操作成功");
		            	if(enter==1){
		            		window.location.reload();
		            	}
		            }else{
		            	window.confirm("操作失败");
		            }
		        }
		    });
		}
		
	diag.close();};
	diag.Width = 1200;

	diag.Height = 600;
	diag.show();

	
};
//手动推荐

$("#self_control_rec").click(self_control_rec);