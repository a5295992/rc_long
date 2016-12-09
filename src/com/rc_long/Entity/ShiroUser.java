package com.rc_long.Entity;

import java.sql.Date;

import javax.persistence.Entity;

//当前用户信息类
@Entity
public class ShiroUser {
	private String user_name;
	
	private String user_ssid;
	
	private String user_img;
	
	private String user_id;
	
	private int user_flag;
	
	private int user_staut;
	
	private int user_type;
	
	private Date user_last_time;

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_ssid() {
		return user_ssid;
	}

	public void setUser_ssid(String user_ssid) {
		this.user_ssid = user_ssid;
	}

	public String getUser_img() {
		return user_img;
	}

	public void setUser_img(String user_img) {
		this.user_img = user_img;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getUser_flag() {
		return user_flag;
	}

	public void setUser_flag(int user_flag) {
		this.user_flag = user_flag;
	}

	public int getUser_staut() {
		return user_staut;
	}

	public void setUser_staut(int user_staut) {
		this.user_staut = user_staut;
	}

	public int getUser_type() {
		return user_type;
	}

	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}

	public Date getUser_last_time() {
		return user_last_time;
	}

	public void setUser_last_time(Date date) {
		this.user_last_time = date;
	}
	
	
}
