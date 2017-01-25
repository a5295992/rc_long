
// Called instead of the SWFUpload _showUI method
var FeaturesDemo = {
	start : function(swf_upload_instance) {
		FeaturesDemo.SU = swf_upload_instance;
		
		var su=FeaturesDemo.SU;
		var tbar=su.grid.getTopToolbar();       
		tbar.addButton({
		
			text:"上传",
			pressed : true,
			handler:function(){
			  FeaturesDemo.startSelectedFile();
			}
			
		
		})		
		tbar.addSeparator();
		tbar.addButton({
		
			text:"删除",		
			pressed : true,
			handler:function(){
			  FeaturesDemo.cancelSelectedFile();
			}
			
		
		})			

		tbar.addSeparator();
		tbar.addButton({
		
			text:"停止",	
			pressed : true,
			handler:function(){
			  FeaturesDemo.stopUpload();
			}
			
		
		})			
		
	},
	
	startSelectedQuene:function(){		
		var su=FeaturesDemo.SU;
		var sm=su.grid.getSelectionModel();		
		var rc=sm.getSelections();	
		this.current.set("state",3);
		this.current.commit();
		for(var i=0;i<rc.length;i++)
		{
			if(rc[i].get("state")==0)
			{
			  	this.current=rc[i];
			  	su.startUpload(rc[i].get("id"));
			  	return ;
			}			
		}			
	},
	startSelectedFile : function() {
		var su=FeaturesDemo.SU;
		var sm=su.grid.getSelectionModel();		
		var rc=sm.getSelections();		
		if (rc.length == 0) {
			alert("请选择文件");
			return;
		}
		var isFirst=true;
		for(var i=0;i<rc.length;i++)
		{
			if(rc[i].get("state")==-1 || rc[i].get("state")==2)
			{
				rc[i].set("state",0);
				rc[i].commit();
				if(isFirst)
				{
				   this.current=rc[i];
				   su.startUpload(rc[i].get("id"));
				   isFirst=false;
				}
			}	
			
		}		
	},
	stopUpload : function() {
		FeaturesDemo.SU.stopUpload();
	},
	cancelSelectedFile : function(triggerEvent) {
		var su=FeaturesDemo.SU;
		var sm=su.grid.getSelectionModel();		
		var rc=sm.getSelections();		
		if (rc.length == 0) {
			alert("请选择文件");
			return;
		}
		for(var i=0;i<rc.length;i++)
		{
			if(rc[i].get("state")==3)
			{
               // 已经成功的要清理
		       // Ext.Ajax.request({   
	          //   method:'POST',   
	           //  url:'upload!delete.action',  
			   //  params:{'code':rc[i].get("code")}
	           // });	
				su.ds.remove(rc[i]);
			}else{
				FeaturesDemo.SU.cancelUpload(rc[i].get("id"), false);	
			    su.ds.remove(rc[i]);
			}	
			
		}
		
	}
};
