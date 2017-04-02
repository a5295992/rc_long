package com.rc_long.dao.impl;

import java.math.BigInteger;
import java.util.List;



import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rc_long.Entity.News;
import com.rc_long.dao.ModuleNewsDao;
import com.rc_long.dao.dataSource.HQLCostants;
import com.rc_long.dao.dataSource.QueryCondition;
import com.rc_long.utils.CommoTools;
import com.rc_long.utils.SessionUtils;

@Component
public class ModuleNewsDaoImpl implements ModuleNewsDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public void add(News news) {
		Daoutils.saveBean(sessionFactory, news);
	}

	@Override
	public void update(News news) {
		Daoutils.updateMerge(sessionFactory, news);
	}

	@Override
	public void dele(News news) {
		Daoutils.delete(sessionFactory, news);
	}

	@Override
	public News get(Class<News> class1, String id) {
		
		
		return Daoutils.getBeanById(sessionFactory, id, class1);
	}

	@Override
	public int getCount(QueryCondition queryCondition) {
		String hql = HQLCostants.getALL(queryCondition);
		Session session = SessionUtils.getSession(sessionFactory);
		SQLQuery query =  session.createSQLQuery(hql);
		
		CommoTools.setValues(queryCondition.getObj(), query);
		BigInteger count = (BigInteger) query.uniqueResult();
		
		Integer in = count.intValue();
		return in;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> getList(QueryCondition queryCondition,int begin,int max) {
		String hql = HQLCostants.getSQL(queryCondition);
		Session session = SessionUtils.getSession(sessionFactory);
		
		Query query = session.createQuery(hql);
		CommoTools.setValues(queryCondition.getObj(), query);
		query.setFirstResult(begin);
		query.setMaxResults(max);
		return query.list();
	}

	@Override
	public void dele(String hql, News news) {
		
		Session session = SessionUtils.getSession(sessionFactory);
		
		Transaction tran =session.beginTransaction();
		
		session.createSQLQuery(hql).setParameter("news_id", news.getNews_id()).executeUpdate();
		
		tran.commit();
		
	}

}
