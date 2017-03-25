package com.rc_long.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rc_long.Entity.SysUser;
import com.rc_long.dao.UserDao;
import com.rc_long.utils.SessionUtils;


@Component
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private  Session session;
	
	private Transaction tran;
	@Override
	public void saveUser(SysUser user) {
		
		session=SessionUtils.getSession(sessionFactory);
		
		session.save(user);
		
	}

	@Override
	public SysUser getUserById(String userId,String password) {
		List<SysUser> list = null;
		session=SessionUtils.getSession(sessionFactory);
		String hql = "FROM SysUser WHERE user_ssid = ? AND user_key = ?";
		Query query=session.createQuery(hql);
		query.setParameter(0, userId);
		query.setParameter(1, password);
		return (SysUser) query.uniqueResult();
		
	}

	@Override
	public List<SysUser> getUserByHql() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(SysUser user) {
		session=SessionUtils.getSession(sessionFactory);
		tran  = session.beginTransaction();
		
		try {
			session.update(session.merge(user));
			tran.commit();
		} catch (Exception e) {
			tran.rollback();
			e.printStackTrace();
		}
		
	}

	@Override
	public SysUser getUserByUserId(String user_id) {
		session=SessionUtils.getSession(sessionFactory);
		
		
		return (SysUser) session.get(SysUser.class, user_id);
	}
	
	
}
