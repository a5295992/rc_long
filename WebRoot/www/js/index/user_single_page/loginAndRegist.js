
var w=  parent.location;
var loginAjax=function login(){
	$.ajax({
        cache: true,
        type: "POST",
        url:base+"/sys/user/ajax",
        data:$('#exe_form_login').serialize(),// 你的formid
        async: false,
        error: function(request) {
            alert("Connection error");
        },
        success: function(data) {
            if(data==1){
            	w.replace(base+"/sys/video");
            	parentDialog.close();
            }else{
            	$("#erroMessage").text("用户名或密码错误");
            }
        }
    });
};
$("#exe_login_button").click(loginAjax);
	
