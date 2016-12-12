$(function(){
	alert("hello");
	window.close();
	var login=function(){
	$("#exe_form_login").attr("action", base+"/sys/user/login");
	$("#exe_form_login").attr("method", "post");
	$("#exe_form_login").submit();
};
$("#exe_login_button").click(login);
var judge=function(){
	
	
};

	
});
