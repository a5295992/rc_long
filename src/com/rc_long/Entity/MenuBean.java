package com.rc_long.Entity;

import java.util.List;

/**
 * 
 * @author 周湘龙
 *
 */
public class MenuBean extends EntitiBaseBean<MenuBean>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String menu_name;
	
	
	private Integer menu_id;
	
	
	private List<SysVideo> list;


	public String getMenu_name() {
		return menu_name;
	}


	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}


	public Integer getMenu_id() {
		return menu_id;
	}


	public void setMenu_id(Integer menu_id) {
		this.menu_id = menu_id;
	}


	public List<SysVideo> getList() {
		return list;
	}


	public void setList(List<SysVideo> list) {
		this.list = list;
	}
	
}
