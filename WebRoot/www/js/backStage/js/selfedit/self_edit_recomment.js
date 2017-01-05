//当页面加载的时候
function onLoad(){
	$.ajax({
        cache: true,
        type: "GET",
        url:base+"/sys/back/self/edit/search",
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
});
