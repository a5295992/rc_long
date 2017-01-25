package com.rc_long.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.rc_long.Entity.ResourceBean;

public class ResouTools {

	public static String getRrsourceType(String fileName) {
		
		String[] fileNameArr = fileName.split("\\.");
		//刚好有个以.xxx结尾的情况
		if(fileNameArr.length==2){
			return fileNameArr[1];
			//文件名中有’.‘的情况
		}else if(fileNameArr.length>2){
		    return fileNameArr[fileNameArr.length-1];
		}else{
			return "other";
		}
	}

	public static String makePath(String string) {
		File file =new File(string);
		if(file.exists()){
			return string;
		}else{
			file.mkdirs();
		}
		return string;
		
	}

	public static String getFormatTime() {
		
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	public static String getRrsorcePath(ResourceBean rb) {
		
		return rb.getResource_personal()+"/"+rb.getUser_id()+"/"+rb.getResource_type()+"/"+rb.getUpload_date()+"/"+rb.getResource_id()+"/"+rb.getResource_name();
	}

}
