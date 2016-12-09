function login() {
	$("#exe_form_login").attr("action", "/sys/user/login");
	$("#exe_form_login").attr("method", "post");

	$(".width-35 pull-right btn btn-sm btn-primary").click(function() {
		alert("hello");
		$("#exe_form_login").submit();
	});
}