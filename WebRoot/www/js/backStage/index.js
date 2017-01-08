var single_page_manage = function (){
	
	$.ajax({
        cache: true,
        type: "POST",
        url:base+"/sys/back/index/manage",
        //data:$('#exe_form_login').serialize(),// 你的formid
        async: false,
        error: function(request) {
            alert("Connection error");
        },
        success: function(html) {
        	$("#menu_list_singgle_page").html(html);
        }
    });
};
$("#single_page_manage").click(single_page_manage);
