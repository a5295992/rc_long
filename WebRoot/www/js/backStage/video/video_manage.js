var video_auth_change = function(){
	
	var video_auth= $("select[name='video_auth']").val();
	$("input[name='video_auth']").val(video_auth);
};
$("select[name='video_auth']").change(video_auth_change);
var video_type_change = function(){
	var video_type= $("select[name='video_type']").val();
	$("input[name='video_type']").val(video_type);
};
$("select[name='video_type']").change(video_type_change);

var video_desc_change = function(){
	var video_desc= $("select[name='video_desc']").val();
	$("input[name='video_desc']").val(video_desc);
};
$("select[name='video_desc']").change(video_desc_change);