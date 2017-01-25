//上传
function upload(){
	var diag = new Dialog();
	diag.Title="文件上传";
	diag.Width=620;
	diag.Height=350;
	diag.URL=base+"/sys/file/swf/upload";
	diag.OKEvent=function(){
		diag.close();
	};
	diag.show();
	
}