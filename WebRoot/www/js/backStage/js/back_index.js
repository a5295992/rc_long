//2016 12-14日 edit by log
//查询 所有用户
var getUserlist=function (){
	$.ajax({
        cache: true,
        type: "GET",
        url:base+"/sys/back/user",
       // data:$('#exe_form_login').serialize(),// 你的formid
        async: false,
        error: function(request) {
            alert("Connection error");
        },
        success: function(html) {
            if(html!=null||html!=''){
            	
            }
        }
    });
};