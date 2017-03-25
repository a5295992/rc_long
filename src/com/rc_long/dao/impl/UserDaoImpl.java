package com.rc_long.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rc_long.Entity.SysUser;
import com.rc_long.dao.UserDao;


@Component
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private  Session session;
	@Override
	public void saveUser(SysUser user) {
		
		session = sessionFactory.openSession();
		
		session.save(user);
		
	}

	@Override
	public SysUser getUserById(String userId,String password) {
		List<SysUser> list = null;
		Transaction tran = null;
		try {
			session = sessionFactory.openSession();
			 tran =  session.beginTransaction();
			String hql = "FROM SysUser WHERE user_ssid = ? AND user_key = ?";
			Query query=session.createQuery(hql);
			query.setParameter(0, userId);
			query.setParameter(1, password);
			list = query.list();
			tran.commit();
		} catch (HibernateException e) {
			tran.rollback();
			e.printStackTrace();
		}finally{
			
			session.close();
		}
		if(list!=null&&list.size()>0){
			return  list.get(0);
		}
		return null;
	}

	@Override
	public List<SysUser> getUserByHql() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(SysUser user) {
		session = sessionFactory.openSession();
		Transaction tran  = session.beginTransaction();
		try {
			session.update(user);
			tran.commit();
		} catch (Exception e) {
			tran.rollback();
			e.printStackTrace();
		}finally{
			
			session.close();
		}
		
	}
	
	
}
