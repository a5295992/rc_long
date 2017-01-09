//查询js
var  listform=$("#listform");

//设置表单属性
  function setForm(pageNum){
	listform.attr("method","post");
	listform.attr("action",base+"/sys/back/self/movie/comment/search?pageNum="+pageNum);
};
//提交表单
 function submit (){
	listform.submit();
};
function turnPage(){
	var inputPageNum=$("input[name='inputPageNum']").val();
	setForm(inputPageNum);
	submit();
}

function dealForm() {
	$("#listform").attr("method", "post");
	$("#listform").attr("action", base + "/sys/back/self/movie/comment/search");
}
function changesearch() {
	var like = $("#likeSearch").val();
	var likeName = $("#likeName_serach").val();
	$("#like").val(like);
	$("#likeName").val(likeName);
	dealForm();
	$("#listform").submit();
}

//选中所有
$("#checkall").click(function() {
	$("input[name='id[]']").each(function() {
		if (this.checked) {
			this.checked = false;
		} else {
			this.checked = true;
		}
	});
});



