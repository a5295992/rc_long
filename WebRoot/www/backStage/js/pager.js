//转到


function turnPage(){
	var input = $("input[name='inputPageNum']").val();
	$("input[name='pageNum']").val(input);
	$("#listform").submit();
	
}


function last(){
	
	var pageNum = $("input[name='pageNum']").val();
	
	$("input[name='pageNum']").val(pageNum-1);
	
	$("#listform").submit();
	
}
//下一页
function next(){
	var pageNum = $("input[name='pageNum']").val();
	
	$("input[name='pageNum']").val(pageNum+1);
	
	$("#listform").submit();
	
}

function end(){
	var page=$("input[name='page']").val();
	$("input[name='pageNum']").val(page-1);
	
	$("#listform").submit();
}

function crrent(i){
	
	$("input[name='pageNum']").val(i);
	
	$("#listform").submit();
}

function find(){
	
	$("#listform").submit();
}

