var w=window.location;
var updateUser=function (){
	$.ajax({
        cache: true,
        type: "POST",
        url:base+"/sys/back/user/update",
        data:$('#exe_form_login').serialize(),// 你的formid
        async: false,
        error: function(request) {
            alert("Connection error");
        },
        success: function(data) {
            if(data>0){
            	w.replace(base+"/sys/video");
            }else{
            	w.replace(base+"/sys/back/user/qupdate?user_id="+user_id);
            	alert("dd");
            }
        }
    });
};
$(".icon-check-square-o").click(updateUser);
