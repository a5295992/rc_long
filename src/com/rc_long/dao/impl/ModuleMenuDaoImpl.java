package com.rc_long.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rc_long.Entity.ModuleMenu;
import com.rc_long.dao.ModuleMenuDao;
import com.rc_long.utils.CommoTools;
import com.rc_long.utils.SessionUtils;

@Component
public class ModuleMenuDaoImpl implements ModuleMenuDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session;
	
	private Query query;
	@SuppressWarnings("unchecked")
	public List<ModuleMenu> getMenuByPId(int i) {
		String hql ="FROM ModuleMenu as c WHERE c.parents_id_=:parents_id_";
		
		session = SessionUtils.getSession(sessionFactory);
		
		query = session.createQuery(hql);
		
		query.setParameter("parents_id_", i);
		
		
		return query.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ModuleMenu> getMenu() {
		String hql ="FROM ModuleMenu as c WHERE c.parents_id_=:parents_id_";
		
		session = SessionUtils.getSession(sessionFactory);
		
		query = session.createQuery(hql);
		query.setParameter("parents_id_", 0);
		return query.list();
	}
	/**
	 * 根据 主键 id获取菜单
	 */
	public ModuleMenu getMenuById(Integer menu_id) {
		
		
		return Daoutils.getBeanById(sessionFactory, menu_id, ModuleMenu.class);
	}
	@Override
	public void saveOrUpdate(ModuleMenu moduleMenu) {
		
		Daoutils.saveOrupdate(sessionFactory,moduleMenu);
	}
	@Override
	public void dele(ModuleMenu moduleMenu) {
		
		Daoutils.delete(sessionFactory, moduleMenu);
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ModuleMenu> getAllMenuList(String hql) {
		session = SessionUtils.getSession(sessionFactory);
		
		query = session.createQuery(hql);
		
		return query.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ModuleMenu> getAllMenuList(String hql, Map<String,Object> map) {
		session = SessionUtils.getSession(sessionFactory);
		
		query = session.createQuery(hql);
		
		CommoTools.setValues(map, query);
		
		return query.list();
	}

}
