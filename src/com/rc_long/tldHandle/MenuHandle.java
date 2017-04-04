package com.rc_long.tldHandle;

import java.util.List;

import com.rc_long.Entity.ModuleMenu;
import com.rc_long.tldService.TLDMenuService;
import com.rc_long.tldService.TLDMenuServiceImpl;
import com.rc_long.utils.JedisUtils;
public class MenuHandle {
	
	private static TLDMenuService tldService;
	/**
	 * 获取菜单集合
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<ModuleMenu> getCurrentMenu(){
		
		List<ModuleMenu> list = null;
		try {
			list = (List<ModuleMenu>) JedisUtils.getObject("moduleMenu");
		} catch (Exception e) {
			list=null;
		}
		if(list==null){
			tldService = new TLDMenuServiceImpl();
			
			list = tldService.getMenuList(0);
			
			if(list!=null){
				JedisUtils.saveObject("moduleMenu", list);
			}
		}
		
		return list;
	}
	
	/**
	 * 获取当前菜单
	 * @return
	 */
	public static String getCurrentMenuName(){
		
		
		return JedisUtils.load("active");
	}
}
