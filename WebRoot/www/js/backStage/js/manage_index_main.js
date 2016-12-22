var te=true;
$("#h2_001").click(function(){
	if(te){
		$("#div_001").fadeIn("slow");
		te=false;
	}else{
		$("#div_001").fadeOut("slow");
		te=true;
	}
	
});