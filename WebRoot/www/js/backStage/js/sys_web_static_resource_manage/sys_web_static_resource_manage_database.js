//查询js
var listform = $("#listform");

// 设置表单属性
function setForm(pageNum) {
	listform.attr("method", "post");
	listform.attr("action", base
			+ "/sys/web/static/resource/manage/database/search?pageNum="
			+ pageNum);
};
// 提交表单
function submit() {
	listform.submit();
};
function turnPage() {
	var inputPageNum = $("input[name='inputPageNum']").val();
	setForm(inputPageNum);
	submit();
}

function del(id) {
	if (confirm("您确定要删除吗?")) {

	}
}

$("#checkall").click(function() {
	$("input[name='id[]']").each(function() {
		if (this.checked) {
			this.checked = false;
		} else {
			this.checked = true;
		}
	});
});
// ---------------------------------------------------------------------------------------------------
// 选择
function choose(resource_id) {
	$("#" + resource_id).each(function() {
		if (this.checked) {
			this.checked = false;
			$("#choose_exe_connect").val("");
		} else {
			this.checked = true;
			var resource_id =$(this).val();
			$("#choose_exe_connect").val(resource_id);
		}
	});
}

// 模糊查询
// **************************************************** 搜索框
function dealForm() {
	listform.attr("method", "post");
	listform.attr("action", base
			+ "/sys/web/static/resource/manage/database/search");
}

function changesearch() {
	var like = $("#likeSearch").val();
	var likeName = $("#likeName_serach").val();
	$("#like").val(like);
	$("#likeName").val(likeName);
	dealForm();
	$("#listform").submit();
}

// **********************************************************************************

// 批量删除

var del = function() {
	var data = "";
	$("input[name='id[]']").each(function() {
		if (this.checked) {
			var resource_id = $(this).val();
			data = data + resource_id + ",";
		}
	});

	if (data.length > 0) {
		var enter = window.confirm("确定删除吗?");
		if (enter == 1) {
			$.ajax({
				cache : true,
				type : "POST",
				url : base + "/sys/web/static/resource/manage/database/delete",
				// data:$('#exe_form_login').serialize(),// 你的formid
				data : {
					"resource_list" : data
				},
				async : false,
				error : function(request) {
					alert("Connection error");
				},
				success : function(data) {
					if (data > 0) {
						window.confirm("操作成功");
						window.location.reload();
					} else {
						window.confirm("操作失败");
					}
				}
			});
		}
	} else {
		window.confirm("请选择你要删除的内容");
	}
};

$(".border-red").click(del);