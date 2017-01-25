var manualPB2=null;
  function setProgress(v,fileId){
					manualPB2 = new JS_BRAMUS.jsProgressBar(
								$('element6_'+fileId),
								v,
								{

									barImage	: Array(
										base+'/www/upload/images/bramus/percentImage_back4.png',
										base+'/www/upload/images/bramus/percentImage_back3.png',
										base+'/www/upload/images/bramus/percentImage_back2.png',
										base+'/www/upload/images/bramus/percentImage_back1.png'
									),

									onTick : function(pbObj) {

										switch(pbObj.getPercentage()) {
										}

										return true;
									}
								}
							);
  }
var Handlers = {
	swfUploadLoaded : function() {
		FeaturesDemo.start(this); // This refers to the SWFObject because		
	},
	fileQueued : function(file) {
		try {			
			var su=FeaturesDemo.su;
			var r=new this.RC({id:file.id,fileName:file.name,fileSize:file.size,state:-1});
			this.ds.add([r]);	
			setProgress(0,file.id);
		} catch (ex) {
			alert(ex);
		}
	},

	fileQueueError : function(file, errorCode, message) {
		try {
			var errorName = "";
			switch (errorCode) {
				case SWFUpload.QUEUE_ERROR.QUEUE_LIMIT_EXCEEDED :
					//errorName = "上文件个数超过限制";
					break;
				case SWFUpload.QUEUE_ERROR.FILE_EXCEEDS_SIZE_LIMIT :
					errorName = "文件大小超过限制";
					break;
				case SWFUpload.QUEUE_ERROR.ZERO_BYTE_FILE :
					//errorName = "不能上传零字节文件";
					break;
				case SWFUpload.QUEUE_ERROR.INVALID_FILETYPE :
					errorName = "无效文件类型";
					break;
				default :
					errorName = "为止错误";
					break;
			}

			var errorString = errorName
					+ ":File ID: "
					+ (typeof(file) === "object" && file !== null
							? file.id
							: "na") + ":" + message;

			alert(errorString);

		} catch (ex) {
			this.debug(ex);
		}
	},

	uploadProgress : function(file, bytesLoaded, totalBytes) {

		try {
			var percent = Math.ceil((bytesLoaded / file.size) * 100);		
			FeaturesDemo.current.set("rate",percent);
			FeaturesDemo.current.set("state",1);
			FeaturesDemo.current.set("speed",SWFUpload.speed.formatBPS(file.sizeUploaded/file.timeElapsed));
			FeaturesDemo.current.commit();	
			setProgress(percent,file.id);
		} catch (ex) {
			alert(ex);
		}
	},

	uploadSuccess : function(file, serverData, receivedResponse) {
		try 
	    {			
			if(data)
			{
	    	 var data=Ext.decode(serverData);		    	 
			 FeaturesDemo.current.set("code",data.code);
			 FeaturesDemo.current.commit();
			
			}			 
			FeaturesDemo.startSelectedQuene();
			 setProgress(100,file.id);
		} catch (ex) {
			alert(ex);
		}
	},

	uploadError : function(file, errorCode, message) {		
		try {
			var errorName = "";
			switch (errorCode) {
				case SWFUpload.UPLOAD_ERROR.HTTP_ERROR :
					errorName = "HTTP ERROR";
					break;
				case SWFUpload.UPLOAD_ERROR.MISSING_UPLOAD_URL :
					errorName = "MISSING UPLOAD URL";
					break;
				case SWFUpload.UPLOAD_ERROR.IO_ERROR :
					errorName = "IO ERROR";
					break;
				case SWFUpload.UPLOAD_ERROR.SECURITY_ERROR :
					errorName = "SECURITY ERROR";
					break;
				case SWFUpload.UPLOAD_ERROR.UPLOAD_LIMIT_EXCEEDED :
					errorName = "UPLOAD LIMIT EXCEEDED";
					break;
				case SWFUpload.UPLOAD_ERROR.UPLOAD_FAILED :
					errorName = "UPLOAD FAILED";
					break;
				case SWFUpload.UPLOAD_ERROR.SPECIFIED_FILE_ID_NOT_FOUND :
					errorName = "SPECIFIED FILE ID NOT FOUND";
					break;
				case SWFUpload.UPLOAD_ERROR.FILE_VALIDATION_FAILED :
					errorName = "FILE VALIDATION FAILED";
					break;
				case SWFUpload.UPLOAD_ERROR.FILE_CANCELLED :
					errorName = "FILE CANCELLED";
					break;
				case SWFUpload.UPLOAD_ERROR.UPLOAD_STOPPED :
					errorName = "FILE STOPPED";
					FeaturesDemo.current.set("state",2);
					FeaturesDemo.current.commit();
					return;					
				default :
					errorName = "UNKNOWN";
					break;
			}

			alert(errorName);

		} catch (ex) {
			this.debug(ex);
		}
	}
};
