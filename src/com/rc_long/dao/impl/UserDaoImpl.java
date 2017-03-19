package com.rc_long.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.rc_long.dao_001.UserDao;
import com.rc_long.entity_001.User;

public class UserDaoImpl  implements UserDao{
	
	Session session ;
	private SessionFactory sessionFactory;
	
	@Override
	public void save(User u) {
		
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e1) {
			// TODO Auto-generated catch block
			session=sessionFactory.openSession();
		}
		Transaction tr = session.beginTransaction();
		
		try {
			session.save(u);
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	

	@Override
	public User getUser(String id) {
		try {
			session = sessionFactory.getCurrentSession();
			return (User) session.get(User.class, id);
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
			return (User) session.get(User.class, id);
		}finally{
			session.close();
		}
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	
}
