package com.rc_long.tldService;

import java.util.List;

import org.apache.log4j.helpers.LogLog;

import com.rc_long.Entity.SysMenu;
import com.rc_long.tldDao.TLDMenuDao;
import com.rc_long.tldDao.TLDMenuDaoImpl;

public class TLDMenuServiceImpl implements TLDMenuService {
	private TLDMenuDao tldMenuDao;

	@Override
	public List<SysMenu> getMenuList(String flag) {
		List<SysMenu> list;
		tldMenuDao = new TLDMenuDaoImpl();

		String sql = "SELECT co_id,menu_id,menu_name,menu_pid,menu_path FROM sys_menu WHERE menu_flag =? AND menu_pid ='0'";
		Object[] obj = { flag };
		list = tldMenuDao.getMenuList(sql, obj);
		String sql2 = "SELECT co_id,menu_id,menu_name,menu_pid,menu_path FROM sys_menu WHERE menu_pid =?";
		
		//以后在优化上使用addBatch()
		for (SysMenu sysMenu : list) {
			Object[] obj2 = { sysMenu.getMenu_id() };
			LogLog.warn(sysMenu.getMenu_id());
			List<SysMenu> list2 = tldMenuDao.getMenuList(sql2, obj2);
			if (list2 != null) {
				sysMenu.setSysMenuList(list2);
			}
		}
		return list;
	}

	@Override
	public List<SysMenu> getMenuByPid(String pid) {

		String sql = "SELECT co_id,menu_id,menu_name,menu_pid,menu_path FROM sys_menu WHERE menu_pid =?";
		Object[] obj = { pid };

		return tldMenuDao.getMenuList(sql, obj);
	}

	@Override
	public SysMenu getMenu(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
