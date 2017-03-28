function restart(){
		var enter = window.confirm("重启服务器，将会导致整个平台数十秒的暂停 继续吗？");
		if(enter==1){
			window.location.href=base+"/system/restart";
		}
		
}

//前端数据监测

