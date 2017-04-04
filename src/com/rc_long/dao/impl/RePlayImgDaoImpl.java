package com.rc_long.dao.impl;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rc_long.Entity.RePlayImg;
import com.rc_long.dao.RePlayImgDao;
import com.rc_long.dao.dataSource.HQLCostants;
import com.rc_long.dao.dataSource.QueryCondition;
import com.rc_long.utils.CommoTools;
import com.rc_long.utils.SessionUtils;

@Component
public class RePlayImgDaoImpl implements RePlayImgDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public void saveorUpdate(RePlayImg rePlayImg) {	
		
		Daoutils.saveOrupdate(sessionFactory, rePlayImg);

	}

	@Override
	public int getCount(QueryCondition condition) {
		String hql =HQLCostants.getALL(condition);
		
		Session session = SessionUtils.getSession(sessionFactory);
		
		Query query = session.createSQLQuery(hql);
		
		CommoTools.setValues(condition.getObj(), query);
		
		BigInteger co = (BigInteger) query.uniqueResult();
		
		return co.intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RePlayImg> getList(QueryCondition condition, int start, int max) {
		String hql =HQLCostants.getSQL(condition);
		
		Session session = SessionUtils.getSession(sessionFactory);
		
		Query query = session.createQuery(hql);
		
		CommoTools.setValues(condition.getObj(), query);
		
		return query.list();
	}

	@Override
	public RePlayImg get(Class<RePlayImg> class1, String id) {
		return Daoutils.getBeanById(sessionFactory, id, class1);
	}

	@Override
	public void dele(String hql) {
		Daoutils.delete(sessionFactory, hql);
	}



	@Override
	public void dele(String hql, Map<String, Object> map) {
		
		Daoutils.delete(sessionFactory, hql,map);
	}

}
