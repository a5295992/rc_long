package com.rc_long.tldHandle;

import java.util.List;

import org.apache.log4j.helpers.LogLog;

import com.rc_long.Entity.SysMenu;
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
	public static List<SysMenu> getCurrentMenu(String flag){
		
		List<SysMenu> list = null;
		try {
			list = (List<SysMenu>) JedisUtils.getObject("indexMenu");
		} catch (Exception e) {
			list=null;
		}
		if(list==null){
			tldService = new TLDMenuServiceImpl();
			
			list = tldService.getMenuList(flag);
			
			if(list!=null){
				LogLog.warn("数据保存到缓存中...");
				JedisUtils.saveObject("indexMenu", list);
			}
		}
		
		return list;
	}
}
