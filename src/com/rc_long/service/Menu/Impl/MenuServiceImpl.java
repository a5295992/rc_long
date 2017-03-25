package com.rc_long.service.Menu.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rc_long.Entity.SysMenu;
import com.rc_long.dao.MenuDao;
import com.rc_long.service.MenuService;
@Component
public class MenuServiceImpl implements MenuService  {
	@Autowired
	private MenuDao menuDao;
	@Override
	public List<SysMenu> getMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SysMenu> getMenuList(String flag) {
		//根据flag 来获取对应的菜单
		String hql = "FROM SysMenu as s WHERE s.menu_flag=:menu_flag";
		List<SysMenu> list = menuDao.getMenuList(hql,flag);
		System.out.println(list);
		String hql2 ="FROM SysMenu as s WHERE s.menu_pid=:menu_pid";
		
		if(list!=null){
			for (SysMenu sysMenu : list) {
				List<SysMenu> childMenu = menuDao.getMenuListByPid(sysMenu.getMenu_pid(),hql2);
				if(childMenu!=null){
					sysMenu.setSysMenuList(childMenu);
				}
			}
		}else{
			list= new ArrayList<SysMenu>();
		}
		
		return list;
	}
	
	
	
}
