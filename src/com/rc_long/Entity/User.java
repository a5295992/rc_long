package com.rc_long.Entity;

import org.springframework.stereotype.Component;

@Component
public class User {
	
	
	private String user_name;
	
	
	private String user_id;
	
	
	private int user_age;


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public int getUser_age() {
		return user_age;
	}


	public void setUser_age(int user_age) {
		this.user_age = user_age;
	}


	public User(String user_name, String user_id, int user_age) {
		super();
		this.user_name = user_name;
		this.user_id = user_id;
		this.user_age = user_age;
	}


	public User() {
	}
	
	
}
