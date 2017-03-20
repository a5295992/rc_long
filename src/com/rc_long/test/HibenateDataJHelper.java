package com.rc_long.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.rc_long.Entity.User;
public class HibenateDataJHelper {
	
	
	private  SessionFactory sessionFactory;
	
	private Session session;
	
	
	
	public void save(User user) {
		session = getSession();
		Transaction tran = session.beginTransaction();
		
		
		try {
			session.save(user);
			tran.commit();
			
		} catch (Exception e) {
			tran.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	
	public <T> Object getById(Class<T> clazz,String id){
		
		session = getSession();
		
		return session.get(clazz, id);
		
	}



	private Session getSession() {
		return sessionFactory.openSession();
	}



	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}



	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
