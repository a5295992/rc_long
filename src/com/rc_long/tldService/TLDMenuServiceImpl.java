package com.rc_long.tldService;

import java.util.List;

import com.rc_long.Entity.ModuleMenu;
import com.rc_long.Entity.SysMenu;
import com.rc_long.tldDao.TLDMenuDao;
import com.rc_long.tldDao.TLDMenuDaoImpl;

public class TLDMenuServiceImpl implements TLDMenuService {
	private TLDMenuDao tldMenuDao =new TLDMenuDaoImpl();

	@Override
	public List<ModuleMenu> getMenuList(Integer pid) {
		List<ModuleMenu> list;

		String sql = "SELECT name,id,parents_id_,isParent FROM module_menu WHERE parents_id_ =? AND isIndexShow =?";
		Object[] obj = { pid,1 };
		list = tldMenuDao.getMenuList(sql, obj);
		
		
		//以后在优化上使用addBatch()
		
		return list;
	}


	@Override
	public SysMenu getMenu(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public static void main(String[] args) {
		List<ModuleMenu> list = new TLDMenuServiceImpl().getMenuList(0);
		System.out.println(list.size());
		for (ModuleMenu moduleMenu : list) {
			System.out.println("c:"+moduleMenu.getChildren().size());
		}
		
	}
}



