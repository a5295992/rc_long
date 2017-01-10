//查询js
var listform = $("#listform");

// 设置表单属性
function setForm(pageNum) {
	listform.attr("method", "post");
	listform.attr("action", base + "/sys/back/video/search?pageNum=" + pageNum);
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
	} else {
		alert("请选择您要删除的内容!");
		return false;
	}
}

// 管理视频
function manage(video_id) {
	var diag = new Dialog();

	diag.Title = "更改视频信息";

	diag.URL = base + "/sys/back/video/manage?video_id="+video_id;
	diag.OKEvent = function() {
		var exe_form_login = diag.innerFrame.contentWindow.$("#exe_form_login");

		$.ajax({
			cache : true,
			type : "POST",
			url : base + "/sys/back/video/manage/update",
			data : exe_form_login.serialize(),// 你的formid
			async : false,
			error : function(request) {
				alert("Connection error");
			},
			success : function(data) {
				if (data > 0) {
					var enter = window.confirm("操作成功");
					if (enter == 1) {
						diag.close();
						window.location.reload();
					}else{
						window.location.reload();
					}
				} else {
					window.confirm("操作失败");
				}
			}
		});
	};
	diag.Width = 400;
	diag.Height = 450;

	diag.show();

}
