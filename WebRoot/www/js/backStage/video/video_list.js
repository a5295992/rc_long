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

	diag.URL = base + "/sys/back/video/manage/"+video_id;
	
	diag.OKEvent = function(){
		diag.close();
		window.location.reload();
	}
/*	diag.OKEvent = function() {
		var exe_form_login = diag.innerFrame.contentWindow.$("#exe_form_video");
		
		
		$.ajax({
			cache : true,
			type : "POST",
			url : base + "/video/update",
			data : exe_form_login.serialize(),// 你的formid
			async : false,
			error : function(request) {
				alert(request);
				alert("Connection error");
			},
			success : function(data) {
				if(data!=""){
					var enter = window.confirm(data);
					if(enter==1){
						window.location.reload();
					}
				}
				
			}
		});
	};*/
	diag.Width = 1100;
	diag.Height = 700;

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
		diag.Width=1100;
		diag.Height=600;
		diag.URL=base+"/sys/web/static/resource/manage/public";
		diag.OKEvent=function(){
			var resource_name=diag.innerFrame.contentWindow.$("#show_name").val();
			$.ajax({
				cache : true,
				type : "POST",
				url : base + "/video/updatePath",
				/*data : exe_form_login.serialize(),// 你的formid
*/				data :{"video_id":video_id,"resource_name":resource_name},
				async : false,
				error : function(request) {
					alert("Connection error");
				},
				success : function(data) {
					alert(data);
					diag.close();
				}
			});
		};
		diag.show();
	}
	
}


//推荐
function recomment(video_id,isRecomment){
		if(isRecomment==1){
			//是推荐的状态
			
			isRecomment=0;
		}else if(isRecomment==0){
			isRecomment =1;
		}else{
			isRecomment =1;
		}
	
		$.ajax({
			cache : true,
			type : "GET",
			url : base + "/video/updateRecomment/"+video_id+"/"+isRecomment,
			/*data : exe_form_login.serialize(),// 你的formid
*/				/*data :{"video_id":video_id,"resource_name":resource_name},*/
			async : false,
			error : function(request) {
				alert("Connection error");
			},
			success : function(data) {
				window.location.reload();
			}
		});
	}
