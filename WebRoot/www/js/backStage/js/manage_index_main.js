var te1=true;
$("#h2_001").click(function(){
	if(te1){
		$("#div_001").fadeIn("slow");
		te1=false;
	}else{
		$("#div_001").fadeOut("slow");
		te1=true;
	}
	
});

var te2=true;
$("#h2_002").click(function(){
	if(te2){
		$("#div_002").fadeIn("slow");
		te2=false;
	}else{
		$("#div_002").fadeOut("slow");
		te2=true;
	}
	
});

var te3=true;
$("#h2_003").click(function(){
	if(te3){
		$("#div_003").fadeIn("slow");
		te3=false;
	}else{
		$("#div_003").fadeOut("slow");
		te3=true;
	}
	
});


var te4=true;
$("#h2_004").click(function(){
	if(te4){
		$("#div_004").fadeIn("slow");
		te4=false;
	}else{
		$("#div_004").fadeOut("slow");
		te4=true;
	}
	
});

var te5=true;
$("#h2_005").click(function(){
	if(te5){
		$("#div_005").fadeIn("slow");
		te5=false;
	}else{
		$("#div_005").fadeOut("slow");
		te5=true;
	}
	
});

var te7=true;
$("#h2_007").click(function(){
	if(te7){
		$("#div_007").fadeIn("slow");
		te7=false;
	}else{
		$("#div_007").fadeOut("slow");
		te7=true;
	}
	
});



var upload = function (){
	
	
	var diag = new Dialog();

	diag.Title = "获取资源路径";

	diag.URL=base+"/sys/web/static/resource/manage/public";
	diag.OKEvent = function() {
		var resource_name=diag.innerFrame.contentWindow.$("#show_name").val();
		if(resource_name.lastIndexOf("jpg")||resource_name.lastIndexOf("png")){
			$("input[name='video_img']").val(resource_name);
			diag.close();
		}else{
			window.confirm("请选择合适的图片");
		}
		
	};
	diag.Width = 1100;
	diag.Height = 700;

	diag.show();
	
}

$("#image1").click(upload);



//选择菜单
function chooseMenu(){
	
	var menu_id = $("#menu_select").val();
	alert(menu_id);
	$("input[name='menu_id']").val(menu_id);
	
}

