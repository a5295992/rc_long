package com.rc_long.utils;

import org.apache.log4j.helpers.LogLog;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SessionUtils {

	public static Session getSession(SessionFactory sessionFactory) {
		Session session = null;
		
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			LogLog.error("当前没有正在使用中的session");
		}
		if(session==null){
			session = sessionFactory.openSession();
		}
		
		
		return session;
	}
}
