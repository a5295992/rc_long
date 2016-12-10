/**
 * 注册一个新用户
 */
$(function(){
	var create =function cre(){
		$("#exe_form_regist").attr("action",base+"/sys/user/create");
		$("#exe_form_regist").attr("method","post");
		$("#exe_form_regist").submit();
	};
	$("#exe_button_re").click(create);
	
});

