package com.rc_long.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SessionUtils {

	public static Session getSession(SessionFactory sessionFactory) {
		Session session = null;
		
		try {
			session = sessionFactory.getCurrentSession();
		} catch (Exception e) {
			session = sessionFactory.openSession();
		}
		return session;
	}
}
