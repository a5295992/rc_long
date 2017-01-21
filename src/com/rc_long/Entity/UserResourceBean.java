package com.rc_long.Entity;

import com.rc_long.anotation.TableList;

@TableList(connectCondition = { "a1.user_id = a2.user_id" }, names = { "resource_bean a1","sys_user a2" })
public class UserResourceBean {
	
	private String resource_type;//0,图片 1视频 2. 声音 3 其他

	private String resource_personal; // public ,private 
	
	private String resource_id;
	
	private String resource_name;
	
	private String resource_format;//格式mp3.wmv,png,PNG,JPG,jpg,jpeg,mp4,flv,rmvb,avi
	
	private String user_id;//上传人
	
	private String upload_date;//上传时间
	
	private int is_personal; //0 是私人的 1 非 私人的
	
	
	private String user_name;




	public String getResource_personal() {
		return resource_personal;
	}


	public void setResource_personal(String resource_personal) {
		this.resource_personal = resource_personal;
	}


	public String getResource_id() {
		return resource_id;
	}


	public void setResource_id(String resource_id) {
		this.resource_id = resource_id;
	}


	public String getResource_name() {
		return resource_name;
	}


	public void setResource_name(String resource_name) {
		this.resource_name = resource_name;
	}


	public String getResource_format() {
		return resource_format;
	}


	public void setResource_format(String resource_format) {
		this.resource_format = resource_format;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getUpload_date() {
		return upload_date;
	}


	public void setUpload_date(String upload_date) {
		this.upload_date = upload_date;
	}


	public int getIs_personal() {
		return is_personal;
	}


	public void setIs_personal(int is_personal) {
		this.is_personal = is_personal;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getResource_type() {
		return resource_type;
	}


	public void setResource_type(String resource_type) {
		this.resource_type = resource_type;
	}
	
	
}
