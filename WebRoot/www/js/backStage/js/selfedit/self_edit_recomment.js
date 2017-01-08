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
	diag.Width = 1200;

	diag.Height = 600;
	
	diag.Title = "更改自编辑推荐";
	
	diag.URL = base+"/sys/back/self/edit/search";
	diag.show();
	
};
//手动推荐

$("#self_control_rec").click(self_control_rec);