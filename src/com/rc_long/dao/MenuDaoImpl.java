package com.rc_long.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rc_long.Entity.SysMenu;

@Component
public class MenuDaoImpl  implements MenuDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session;
	
	private Transaction tran;
	
	private Query query;
	@Override
	public List<SysMenu> getMenuList(String hql,String flag) {
		System.out.println("这离都没有输出没？");
		session= sessionFactory.openSession();
		
		
		query = session.createQuery(hql);
		
		query.setString("menu_flag", flag);
		
		List<SysMenu> list = query.list();
		
		session.close();
		return list;
	}
	@Override
	public List<SysMenu> getMenuListByPid(String menu_pid, String hql2) {
		
		

		session= sessionFactory.openSession();
		
		
		query = session.createQuery(hql2);
		
		query.setString("menu_pid", menu_pid);
		
		List<SysMenu> list = query.list();
		
		session.close();
		return list;
	}
}
