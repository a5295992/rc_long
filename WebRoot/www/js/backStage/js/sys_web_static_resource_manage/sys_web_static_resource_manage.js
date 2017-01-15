
$(function(){
	var div2=$("#public_resource_div");
	var div=$("#private_resource_div");
	div.animate({right:'600px'},"slow");
	div2.animate({right:'600px'},"slow");
});
//访问静态资源

var public_resource = function(){
	 var div=$("#private_resource_div");
	  div.animate({right:'1500px'},"slow");
	  div.fadeOut();
	  
	  var diag = new Dialog();
		diag.Width=500;
		diag.Height=500;
		diag.URL=base+"/sys/web/static/resource/manage/public";
		diag.OKEvent=function(){
			window.location.reload();
			diag.close();
		};
		diag.show();
};
$("#public_resource").click(public_resource);

var private_resource = function(){
	 var div=$("#public_resource_div");
	  div.animate({bottom:'1000px'},"slow");
	  var div2=$("#private_resource_div");
	  div2.animate({bottom:'220px'},"slow");
	  
	  var diag = new Dialog();
		diag.Width=500;
		diag.Height=500;
		diag.URL=base+"/sys/web/static/resource/manage/public";
		diag.OKEvent=function(){
			window.location.reload();
			diag.close();
		};
		diag.show();
};
$("#private_resource").click(private_resource);