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
//给别的js 参考*************************************************************************************
//---------------------------------------------------------------------------------------------------
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

/*****************************************
 * 打开关联资源
 * openResourceManage()
 */

function openResourceManage(){
	var index = 0;
	var video_id=null;
	$("input[name='id[]']").each(function() {
		if (this.checked == true) {
			index=index+1;
			video_id=$(this).val();
		}
	});
	if(index!=1){
		window.confirm("选且仅能选择一位");
	}else{
		var diag = new Dialog();
		diag.Title="关联资源选择";
		diag.Width=1000;
		diag.Height=600;
		diag.URL=base+"/sys/web/static/resource/manage/database";
		diag.OKEvent=function(){
			var resource_id=diag.innerFrame.contentWindow.$("#choose_exe_connect").val();
			alert(resource_id);
			$.ajax({
				cache : true,
				type : "POST",
				url : base + "/sys/back/video/manage/update/resource",
				/*data : exe_form_login.serialize(),// 你的formid
*/				data :{"video_id":video_id,"resource_id":resource_id},
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
		diag.show();
	}
	
}