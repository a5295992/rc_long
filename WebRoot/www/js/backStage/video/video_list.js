//查询js
var  listform=$("#listform");

//设置表单属性
  function setForm(pageNum){
	listform.attr("method","post");
	listform.attr("action",base+"/sys/back/video/search?pageNum="+pageNum);
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