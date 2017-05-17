package com.rc_long.Entity;

import java.util.List;

import com.rc_long.utils.Pager;

/**
 * 
 * @author 周湘龙
 * @param <T>
 *
 */
public class MenuBean extends EntitiBaseBean<MenuBean>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * 
	 */
	
	
	private String menu_name;
	
	
	private Integer menu_id;
	
	
	private List<News> list;
	
	private Pager<LiveRoom> livelist;




	public Pager<LiveRoom> getLivelist() {
		return livelist;
	}


	public void setLivelist(Pager<LiveRoom> livelist) {
		this.livelist = livelist;
	}


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


	public List<News> getList() {
		return list;
	}


	public void setList(List<News> list) {
		this.list = list;
	}


	



	
}
