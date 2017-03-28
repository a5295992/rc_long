package com.rc_long.dao.impl;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.rc_long.utils.SessionUtils;

public class Daoutils {
	private static Session session;
	private static Transaction tran;
	public static <T> void saveBean(SessionFactory sessionFactory,
			T javaBean) {
		
		session = SessionUtils.getSession(sessionFactory);
		
		
		session.save(javaBean);
	}
	public static <T> void updateBean(SessionFactory sessionFactory,
			T witeSiteInfor) {
		session = SessionUtils.getSession(sessionFactory);
		tran = session.beginTransaction();
		session.update(witeSiteInfor);
		tran.commit();
		
	}
	@SuppressWarnings("unchecked")
	public static <T> T getBeanById(SessionFactory sessionFactory, String id,Class<T> clazz) {
		session = SessionUtils.getSession(sessionFactory);
		return (T) session.get(clazz, id);
	}

}
