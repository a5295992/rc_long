var w=  parent.location;
var w2= window.location;
function dealForm() {
	$("#listform").attr("method", "post");
	$("#listform").attr("action", base + "/sys/back/live/room/search");
}

//更改查询条件查询
function changeThingsToSearch(){
	var likeName = $("#likeName_serach").val();
	$("#likeName").val(likeName);
	var like = $("#likeSearch").val();
	$("#like").val(like);
	dealForm();
	$("#listform").submit();
}
//
//全选择
$("#checkall").click(function() {
	$("input[name='id[]']").each(function() {
		if (this.checked) {
			this.checked = false;
		} else {
			this.checked = true;
		}
	});
});

//推荐
function recomment(live_id){
	var enter = window.confirm("推荐该用户?");
	if (enter == 1) {
		$.ajax({
			cache : true,
			type : "POST",
			url : base + "/sys/back/live/room/recomment",
			// data:$('#exe_form_login').serialize(),// 你的formid
			data : {
				"live_id" : live_id
			},
			async : false,
			error : function(request) {
				alert("Connection error");
			},
			success : function(data) {
				if (data > 0) {
					var enter  = window.confirm("操作成功");
					if(enter  == 1){
						w2.close();
					}
					
				} else {
					window.confirm("操作失败");
				}
			}
		});
	}
}


//取消推荐

function noRecomment(live_id){
	var enter = window.confirm("取消推荐该用户?");
	if (enter == 1) {
		$.ajax({
			cache : true,
			type : "POST",
			url : base + "/sys/back/live/room/noRecomment",
			// data:$('#exe_form_login').serialize(),// 你的formid
			data : {
				"live_id" : live_id
			},
			async : false,
			error : function(request) {
				alert("Connection error");
			},
			success : function(data) {
				if (data > 0) {
					window.confirm("操作成功");
					w2.reload();
				} else {
					window.confirm("操作失败");
				}
			}
		});
	}
}



//转到哪一页
function turnPage() {
	dealForm();
	var pa = $("input[name='inputPageNum']").val();
	$("#pageNum").val(pa);
	$("#listform").submit();
}
