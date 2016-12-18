var w = window.location;
function del(user_id) {
	var enter = window.confirm("警告！删除该用户后,用户无法再使用该账号");
	if (enter == 1) {
		$.ajax({
			cache : true,
			type : "POST",
			url : base + "/sys/back/user/delete",
			// data:$('#exe_form_login').serialize(),// 你的formid
			data : {
				"user_id" : user_id
			},
			async : false,
			error : function(request) {
				alert("Connection error");
			},
			success : function(data) {
				if (data > 0) {
					window.confirm("操作成功");
					w.replace(base + "/sys/back");
				} else {
					window.confirm("操作失败");
				}
			}
		});
	}
};

function dealForm() {
	$("#listform").attr("method", "post");
	$("#listform").attr("action", base + "/sys/back/user/search");
}
function lastVal() {
	$("#pageNum").val(pageNum - 1);
	dealForm();

	$("#listform").submit();
}
function nextVal() {
	dealForm();
	$("#pageNum").val(pageNum + 1);
	$("#listform").submit();
}
// 转到哪一页
function turnPage() {
	dealForm();
	var pa = $("input[name='inputPageNum']").val();
	$("#pageNum").val(pa);
	$("#listform").submit();
}

// 模糊查询

function changesearch() {
	var like = $("#likeSearch").val();
	var likeName = $("#likeName_serach").val();
	$("#like").val(like);
	$("#likeName").val(likeName);
	dealForm();
	$("#listform").submit();
}
// 排序
function sorts() {
	var oder = $("#oder").val();
	if (oder == "desc") {
		$("#oder").val("asc");
	} else {
		$("#oder").val("desc");
	}
	dealForm();
	$("#listform").submit();
}
// 更改排序内容
function changgeThingOder() {
	var oderNam = $("select[name='ishome']").val();
	$("#oderBy").val(oderNam);
}

// 全选删除

function DelSelect() {
	var Checkbox = false;
	$("input[name='id[]']").each(function() {
		if (this.checked == true) {
			Checkbox = true;
		}
	});
	if (Checkbox) {
		var t = confirm("您确认要删除选中的内容吗？");
		if (t == false)
			return false;
		$("#listform").submit();
	} else {
		alert("请选择您要删除的内容!");
		return false;
	}
}
// 全选择
$("#checkall").click(function() {
	$("input[name='id[]']").each(function() {
		if (this.checked) {
			this.checked = false;
		} else {
			this.checked = true;
		}
	});
});
