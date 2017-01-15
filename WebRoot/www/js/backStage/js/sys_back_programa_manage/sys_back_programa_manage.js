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
//删除栏目
function del(programa_id) {
	if (confirm("您确定要删除吗?")) {
		$.ajax({
	        cache: true,
	        type: "POST",
	        //url:base+"/sys/back/programa/manage/update",
	        url:base+"/sys/back/programa/manage/delete",
	       // data:$('#exe_form_login').serialize(),// 你的formid
	        data:{"programa_id":programa_id},
	        async: false,
	        error: function(request) {
	            alert("Connection error");
	        },
	        success: function(data) {
	            if(data>1){
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

