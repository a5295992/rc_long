var w=window.location;
function del(user_id){
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