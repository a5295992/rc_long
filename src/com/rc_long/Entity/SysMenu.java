package com.rc_long.Entity;

import javax.persistence.Entity;

/**
 * 菜单实体类
 * @author long
 */
@Entity
public class SysMenu extends EntitiBaseBean<SysMenu>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int co_id;
	
	private int menu_id;//菜单id
	
	private int menu_pid;//父类菜单ID
	
	private String menu_name; //菜单名字
	
	private String menu_path;//请求路径 sys/video

	public int getCo_id() {
		return co_id;
	}

	public void setCo_id(int co_id) {
		this.co_id = co_id;
	}

	public int getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}

	public int getMenu_pid() {
		return menu_pid;
	}

	public void setMenu_pid(int menu_pid) {
		this.menu_pid = menu_pid;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public String getMenu_path() {
		return menu_path;
	}

	public void setMenu_path(String menu_path) {
		this.menu_path = menu_path;
	}
	
	
}
