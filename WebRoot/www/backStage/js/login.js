
function login(){
	
	var loginForm = $("#login_form");
	
	$.ajax({
        cache: true,
        type: "POST",
        url:base+"/admin/login/determin",
        data:loginForm.serialize(),// 你的formid
        async: false,
        error: function(request) {
            alert("Connection error");
        },
        success: function(data) {
            if(data=="success"){
            	window.location.href=base+"/admin";
            }else{
            	$("#erroMessage").html(data);
            }
        }
    });
}

//还原



function recove(){
	$("#erroMessage").html("");
	
}




