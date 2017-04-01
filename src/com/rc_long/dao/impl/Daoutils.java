package com.rc_long.dao.impl;

import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.rc_long.Entity.ModuleMenu;
import com.rc_long.utils.CommoTools;
import com.rc_long.utils.SessionUtils;

public class Daoutils {
	private static Session session;
	private static Transaction tran;

	public static <T> void saveBean(SessionFactory sessionFactory, T javaBean) {

		session = SessionUtils.getSession(sessionFactory);
		tran = session.beginTransaction();

		session.save(javaBean);
		tran.commit();
	}

	public static <T> void updateBean(SessionFactory sessionFactory,
			T witeSiteInfor) {
		session = SessionUtils.getSession(sessionFactory);
		tran = session.beginTransaction();
		session.update(witeSiteInfor);
		tran.commit();

	}

	@SuppressWarnings("unchecked")
	public static <T> T getBeanById(SessionFactory sessionFactory, String id,
			Class<T> clazz) {

		session = SessionUtils.getSession(sessionFactory);

		return (T) session.get(clazz, id);
	}

	public static <T> void updateMerge(SessionFactory sessionFactory, T sysVideo) {

		session = SessionUtils.getSession(sessionFactory);
		tran = session.beginTransaction();
		session.update(session.merge(sysVideo));
		tran.commit();

	}

	@SuppressWarnings("unchecked")
	public static <T> T getBean(SessionFactory sessionFactory, String video_id,
			Class<T> class1) {

		session = sessionFactory.openSession();

		return (T) session.get(class1, video_id);
	}

	public static void updateMap(SessionFactory sessionFactory, String hql,
			Map<String, Object> map) {
		session = SessionUtils.getSession(sessionFactory);

		tran = session.beginTransaction();

		Query query = session.createQuery(hql);
		CommoTools.setValues(map, query);
		query.executeUpdate();

		tran.commit();
	}

	public static void delete(SessionFactory sessionFactory, String hql) {
		session = SessionUtils.getSession(sessionFactory);

		tran = session.beginTransaction();

		session.delete(hql, new Object[] {});

		tran.commit();

	}

	@SuppressWarnings("unchecked")
	public static <T> T getBeanById(SessionFactory sessionFactory, Integer id,
			Class<ModuleMenu> class1) {

		session = SessionUtils.getSession(sessionFactory);

		return (T) session.get(class1, id);
	}

	public static <T> void saveOrupdate(SessionFactory sessionFactory,T bean) {
		
		session = SessionUtils.getSession(sessionFactory);
		
		tran = session.beginTransaction();
		
		session.saveOrUpdate(bean);
		
		tran.commit();
	}

	public static <T> void delete(SessionFactory sessionFactory,
			T bean) {
		
		session = SessionUtils.getSession(sessionFactory);
		
		tran = session.beginTransaction();
		
		session.delete(session.merge(bean));
		
		tran.commit();
		
	}

}
