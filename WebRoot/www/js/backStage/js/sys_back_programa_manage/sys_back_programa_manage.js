//查询js
var listform = $("#listform");

// 设置表单属性
function setForm(pageNum) {
	listform.attr("method", "post");
	listform.attr("action", base + "/sys/back/programa/manage/search?pageNum=" + pageNum);
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
//全选
$("#checkall").click(function() {
	$("input[name='id[]']").each(function() {
		if (this.checked) {
			this.checked = false;
		} else {
			this.checked = true;
		}
	});
});


function searchA(){
	listform.submit();
	
}
//删除栏目
function del(programa_id) {
	if (confirm("您确定要删除吗?")) {
		$.ajax({
	        cache: true,
	        type: "POST",
	        //url:base+"/sys/back/programa/manage/update",
	        url:base+"/group/delete",
	       // data:$('#exe_form_login').serialize(),// 你的formid
	        data:{"group_ids":programa_id},
	        async: false,
	        error: function(request) {
	            alert("Connection error");
	        },
	        success: function(data) {
	            if(data==1){
	            	confirm("操作成功");
	            	window.location.reload();
	            }else{
	            	confirm("操作失败");
	            }
	        }
	    });
	}
}

 var  create_form_sumbit = function(){
	 
 };
 
 
$("#create_form_sumbit").click(create_form_sumbit);



function add(){
	$("#span_m").html("添加新内容");
	$("input[name='group_id']").val("");
	
	$("input[name='group_name']").val("");
	
	$("textarea[name='group_desc']").val("");
	
	$("input[name='group_img']").val("");
	$("#img_input").attr("src","");
}
/**
 * 修改 或添加
 */
function update(group_id,group_name,group_pid,group_img,group_desc){
	$("#span_m").html("修改");
	$("option[name='group_id']").each(function(){
		if($(this).val()==group_pid){
			$(this).attr("selected","selected");
		}
	});
	$("input[name='group_id']").val(group_id);
	
	$("input[name='group_name']").val(group_name);
	
	$("textarea[name='group_desc']").val(group_desc);
	
	$("input[name='group_img']").val(group_img);
	
	$("#img_input").attr("src",base+"/"+group_img);
}

/**
 * 关联资源
 */
function openRecource(){
	var diag = new Dialog();
	diag.Title="关联资源选择";
	diag.Width=1100;
	diag.Height=600;
	diag.URL=base+"/sys/web/static/resource/manage/public";
	diag.OKEvent=function(){
		var resource_name=diag.innerFrame.contentWindow.$("#show_name").val();
		
		
		if(resource_name.lastIndexOf("jpg")!=-1||resource_name.lastIndexOf("png")!=-1){
			$("input[name='group_img']").val(resource_name);
			
			$("#img_input").attr("src",base+"/"+resource_name);
			diag.close();
		}else{
			window.confirm("请选择正确格式的资源");
		}
	};
	diag.show();
}







//查看 栏目下 所有视频


function findAllVideos(){
	var group_id="" ;
	var index=0;
	$("input[name='id[]']").each(function() {
		if (this.checked) {
			index =index+1;
			group_id = $(this).val();
		} 
	});
	
	if(index==1){
		var diag = new Dialog();
		diag.Title="选择视频";
		diag.Width=1300;
		diag.Height=600;
		diag.URL=base+"/group/videos/"+group_id;
		diag.OKEvent=function(){
var videos=diag.innerFrame.contentWindow.$("input[name='id[]']");
			
			
			var video_ids="";
			
			$(videos).each(function(){
				if (this.checked) {
					if(video_ids==""){
						video_ids =$(this).val(); 
					}else{
						video_ids = video_ids.concat(","+$(this).val());
					}
				} 
				
			});
			if(video_ids!=""){
				$.ajax({
			        cache: true,
			        type: "POST",
			        //url:base+"/sys/back/programa/manage/update",
			        url:base+"/group/videos/add",
			       // data:$('#exe_form_login').serialize(),// 你的formid
			        data:{"videos":video_ids,"group_id":" "},
			        async: false,
			        error: function(request) {
			            alert("Connection error");
			        },
			        success: function(data) {
			            if(data=="1"){
			            	window.confirm("操作成功");
			            	diag.close();
			            }else{
			            	window.confirm("操作失败");
			            }
			        }
			    });
			}
		};
		diag.show();
	}else{
		window.confirm("选择最多选择一个");
	}
	
}


function addVideos(){
	var index =0;
	var group_id="" ;
	$("input[name='id[]']").each(function() {
		if (this.checked) {
			index =index+1;
			group_id = $(this).val();
		} 
	});
	
	if(index==1){
		var diag = new Dialog();
		diag.Title="添加视频";
		diag.Width=1300;
		diag.Height=600;
		diag.URL=base+"/group/videos/add/"+group_id;
		diag.OKEvent=function(){
			var videos=diag.innerFrame.contentWindow.$("input[name='id[]']");
			
			
			var video_ids="";
			
			$(videos).each(function(){
				if (this.checked) {
					if(video_ids==""){
						video_ids =$(this).val(); 
					}else{
						video_ids = video_ids.concat(","+$(this).val());
					}
				} 
				
			});
			if(video_ids!=""){
				$.ajax({
			        cache: true,
			        type: "POST",
			        //url:base+"/sys/back/programa/manage/update",
			        url:base+"/group/videos/add",
			       // data:$('#exe_form_login').serialize(),// 你的formid
			        data:{"videos":video_ids,"group_id":group_id},
			        async: false,
			        error: function(request) {
			            alert("Connection error");
			        },
			        success: function(data) {
			            if(data=="1"){
			            	window.confirm("操作成功");
			            	diag.close();
			            }else{
			            	window.confirm("操作失败");
			            }
			        }
			    });
			}
		};
		diag.show();
	}else{
		window.confirm("选择最多选择一个");
	}
	
}




