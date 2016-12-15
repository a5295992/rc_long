var w=window.location;
var updateUser=function (){
	var enter=window.confirm("该操作可能会导致该用户不可用?");
	if(enter==1){
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
	            	window.confirm("操作成功");
	            	w.replace(base+"/sys/back/user/qupdate?user_id="+user_id);
	            }else{
	            	window.confirm("操作失败");
	            }
	        }
	    });
	}
	
};
$(".icon-check-square-o").click(updateUser);
//删除用户
var deleUser=function del(user_id){
	alert("hedassad");
	var enter=window.confirm("警告！删除该用户后,用户无法再使用该账号");
	if(enter==1){
		$.ajax({
	        cache: true,
	        type: "POST",
	        url:base+"/sys/back/user/delete",
	        //data:$('#exe_form_login').serialize(),// 你的formid
	        data:{"user_id":user_id},
	        async: false,
	        error: function(request) {
	            alert("Connection error");
	        },
	        success: function(data) {
	            if(data>0){
	            	window.confirm("操作成功");
	            	w.replace(base+"/sys/back");
	            }else{
	            	window.confirm("操作失败");
	            }
	        }
	    });
	}
};
